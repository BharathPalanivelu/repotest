package com.thoughtworks.xstream.converters.reflection;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.CGLIBMapper;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Factory;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.NoOp;

public class CGLIBEnhancedConverter extends SerializableConverter {
    private static String CALLBACK_MARKER = "CGLIB$CALLBACK_";
    private static String DEFAULT_NAMING_MARKER = "$$EnhancerByCGLIB$$";
    private transient Map fieldCache;

    public CGLIBEnhancedConverter(Mapper mapper, ReflectionProvider reflectionProvider, ClassLoaderReference classLoaderReference) {
        super(mapper, (ReflectionProvider) new CGLIBFilteringReflectionProvider(reflectionProvider), classLoaderReference);
        this.fieldCache = new HashMap();
    }

    public CGLIBEnhancedConverter(Mapper mapper, ReflectionProvider reflectionProvider, ClassLoader classLoader) {
        super(mapper, (ReflectionProvider) new CGLIBFilteringReflectionProvider(reflectionProvider), classLoader);
        this.fieldCache = new HashMap();
    }

    public CGLIBEnhancedConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
        this(mapper, (ReflectionProvider) new CGLIBFilteringReflectionProvider(reflectionProvider), CGLIBEnhancedConverter.class.getClassLoader());
    }

    public boolean canConvert(Class cls) {
        return (Enhancer.isEnhanced(cls) && cls.getName().indexOf(DEFAULT_NAMING_MARKER) > 0) || cls == CGLIBMapper.Marker.class;
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Callback[] callbackArr;
        Class<?> cls = obj.getClass();
        boolean isAssignableFrom = Factory.class.isAssignableFrom(cls);
        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, "type", cls);
        marshallingContext.convertAnother(cls.getSuperclass());
        hierarchicalStreamWriter.endNode();
        hierarchicalStreamWriter.startNode("interfaces");
        Class<Factory>[] interfaces = cls.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            if (interfaces[i] != Factory.class) {
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, this.mapper.serializedClass(interfaces[i].getClass()), interfaces[i].getClass());
                marshallingContext.convertAnother(interfaces[i]);
                hierarchicalStreamWriter.endNode();
            }
        }
        hierarchicalStreamWriter.endNode();
        hierarchicalStreamWriter.startNode("hasFactory");
        hierarchicalStreamWriter.setValue(String.valueOf(isAssignableFrom));
        hierarchicalStreamWriter.endNode();
        if (isAssignableFrom) {
            callbackArr = ((Factory) obj).getCallbacks();
        } else {
            callbackArr = getCallbacks(obj);
        }
        if (callbackArr.length > 1) {
            if (isAssignableFrom) {
                Map createCallbackIndexMap = createCallbackIndexMap((Factory) obj);
                hierarchicalStreamWriter.startNode("callbacks");
                hierarchicalStreamWriter.startNode("mapping");
                marshallingContext.convertAnother(createCallbackIndexMap);
                hierarchicalStreamWriter.endNode();
            } else {
                ConversionException conversionException = new ConversionException("Cannot handle CGLIB enhanced proxies without factory that have multiple callbacks");
                conversionException.add("proxy superclass", cls.getSuperclass().getName());
                conversionException.add("number of callbacks", String.valueOf(callbackArr.length));
                throw conversionException;
            }
        }
        boolean z = false;
        for (Callback callback : callbackArr) {
            if (callback == null) {
                hierarchicalStreamWriter.startNode(this.mapper.serializedClass((Class) null));
                hierarchicalStreamWriter.endNode();
            } else {
                z = z || MethodInterceptor.class.isAssignableFrom(callback.getClass());
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, this.mapper.serializedClass(callback.getClass()), callback.getClass());
                marshallingContext.convertAnother(callback);
                hierarchicalStreamWriter.endNode();
            }
        }
        if (callbackArr.length > 1) {
            hierarchicalStreamWriter.endNode();
        }
        try {
            Field declaredField = cls.getDeclaredField("serialVersionUID");
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            long j = declaredField.getLong((Object) null);
            ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, "serialVersionUID", String.class);
            hierarchicalStreamWriter.setValue(String.valueOf(j));
            hierarchicalStreamWriter.endNode();
        } catch (NoSuchFieldException unused) {
        } catch (IllegalAccessException e2) {
            throw new ObjectAccessException("Access to serialVersionUID of " + cls.getName() + " not allowed", e2);
        }
        if (z) {
            hierarchicalStreamWriter.startNode("instance");
            super.doMarshalConditionally(obj, hierarchicalStreamWriter, marshallingContext);
            hierarchicalStreamWriter.endNode();
        }
    }

    private Callback[] getCallbacks(Object obj) {
        Class<?> cls = obj.getClass();
        List list = (List) this.fieldCache.get(cls.getName());
        int i = 0;
        if (list == null) {
            list = new ArrayList();
            this.fieldCache.put(cls.getName(), list);
            int i2 = 0;
            while (true) {
                try {
                    Field declaredField = cls.getDeclaredField(CALLBACK_MARKER + i2);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    list.add(declaredField);
                    i2++;
                } catch (NoSuchFieldException unused) {
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        while (i < list.size()) {
            try {
                arrayList.add(((Field) list.get(i)).get(obj));
                i++;
            } catch (IllegalAccessException e2) {
                throw new ObjectAccessException("Access to " + cls.getName() + "." + CALLBACK_MARKER + i + " not allowed", e2);
            }
        }
        return (Callback[]) arrayList.toArray(new Callback[arrayList.size()]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r1 = new com.thoughtworks.xstream.converters.ConversionException("CGLIB enhanced proxies wit abstract nethod that has not been implemented");
        r1.add("proxy superclass", r5.getSuperclass().getName());
        r1.add("method", r7.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0107, code lost:
        throw r1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x00ea */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ea A[SYNTHETIC, Splitter:B:44:0x00ea] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[ExcHandler: InvocationTargetException (unused java.lang.reflect.InvocationTargetException), SYNTHETIC, Splitter:B:31:0x00bc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map createCallbackIndexMap(net.sf.cglib.proxy.Factory r13) {
        /*
            r12 = this;
            net.sf.cglib.proxy.Callback[] r0 = r13.getCallbacks()
            int r1 = r0.length
            net.sf.cglib.proxy.Callback[] r1 = new net.sf.cglib.proxy.Callback[r1]
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = -1
            r4 = 0
        L_0x000e:
            int r5 = r0.length
            r6 = 0
            if (r4 >= r5) goto L_0x0034
            r5 = r0[r4]
            if (r5 != 0) goto L_0x0019
            r1[r4] = r6
            goto L_0x0031
        L_0x0019:
            java.lang.Class<net.sf.cglib.proxy.NoOp> r6 = net.sf.cglib.proxy.NoOp.class
            java.lang.Class r7 = r5.getClass()
            boolean r6 = r6.isAssignableFrom(r7)
            if (r6 == 0) goto L_0x002b
            net.sf.cglib.proxy.NoOp r3 = net.sf.cglib.proxy.NoOp.INSTANCE
            r1[r4] = r3
            r3 = r4
            goto L_0x0031
        L_0x002b:
            net.sf.cglib.proxy.Callback r5 = r12.createReverseEngineeredCallbackOfProperType(r5, r4, r2)
            r1[r4] = r5
        L_0x0031:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x0034:
            r13.setCallbacks(r1)     // Catch:{ all -> 0x0155 }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0155 }
            r1.<init>()     // Catch:{ all -> 0x0155 }
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ all -> 0x0155 }
            r4.<init>()     // Catch:{ all -> 0x0155 }
            java.lang.Class r5 = r13.getClass()     // Catch:{ all -> 0x0155 }
        L_0x0045:
            java.lang.reflect.Method[] r7 = r5.getDeclaredMethods()     // Catch:{ all -> 0x0155 }
            java.util.List r7 = java.util.Arrays.asList(r7)     // Catch:{ all -> 0x0155 }
            r4.addAll(r7)     // Catch:{ all -> 0x0155 }
            java.lang.reflect.Method[] r7 = r5.getMethods()     // Catch:{ all -> 0x0155 }
            java.util.List r7 = java.util.Arrays.asList(r7)     // Catch:{ all -> 0x0155 }
            r4.addAll(r7)     // Catch:{ all -> 0x0155 }
            java.lang.Class[] r7 = r5.getInterfaces()     // Catch:{ all -> 0x0155 }
            java.util.List r7 = java.util.Arrays.asList(r7)     // Catch:{ all -> 0x0155 }
            r1.addAll(r7)     // Catch:{ all -> 0x0155 }
            java.lang.Class r5 = r5.getSuperclass()     // Catch:{ all -> 0x0155 }
            if (r5 != 0) goto L_0x0045
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0155 }
        L_0x0070:
            boolean r7 = r1.hasNext()     // Catch:{ all -> 0x0155 }
            if (r7 == 0) goto L_0x0088
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x0155 }
            java.lang.Class r5 = (java.lang.Class) r5     // Catch:{ all -> 0x0155 }
            java.lang.reflect.Method[] r7 = r5.getDeclaredMethods()     // Catch:{ all -> 0x0155 }
            java.util.List r7 = java.util.Arrays.asList(r7)     // Catch:{ all -> 0x0155 }
            r4.addAll(r7)     // Catch:{ all -> 0x0155 }
            goto L_0x0070
        L_0x0088:
            java.util.Iterator r1 = r4.iterator()     // Catch:{ all -> 0x0155 }
        L_0x008c:
            boolean r7 = r1.hasNext()     // Catch:{ all -> 0x0155 }
            if (r7 == 0) goto L_0x0135
            java.lang.Object r7 = r1.next()     // Catch:{ all -> 0x0155 }
            java.lang.reflect.Method r7 = (java.lang.reflect.Method) r7     // Catch:{ all -> 0x0155 }
            boolean r8 = r7.isAccessible()     // Catch:{ all -> 0x0155 }
            if (r8 != 0) goto L_0x00a2
            r8 = 1
            r7.setAccessible(r8)     // Catch:{ all -> 0x0155 }
        L_0x00a2:
            java.lang.Class<net.sf.cglib.proxy.Factory> r8 = net.sf.cglib.proxy.Factory.class
            java.lang.Class r9 = r7.getDeclaringClass()     // Catch:{ all -> 0x0155 }
            boolean r8 = r8.isAssignableFrom(r9)     // Catch:{ all -> 0x0155 }
            if (r8 != 0) goto L_0x0130
            int r8 = r7.getModifiers()     // Catch:{ all -> 0x0155 }
            r8 = r8 & 24
            if (r8 <= 0) goto L_0x00b8
            goto L_0x0130
        L_0x00b8:
            java.lang.Class[] r8 = r7.getParameterTypes()     // Catch:{ all -> 0x0155 }
            int r9 = r7.getModifiers()     // Catch:{ IllegalAccessException -> 0x0113, InvocationTargetException -> 0x0108, NoSuchMethodException -> 0x00ea }
            r9 = r9 & 1024(0x400, float:1.435E-42)
            if (r9 <= 0) goto L_0x00d5
            java.lang.Class r9 = r13.getClass()     // Catch:{ IllegalAccessException -> 0x0113, InvocationTargetException -> 0x0108, NoSuchMethodException -> 0x00ea }
            java.lang.String r10 = r7.getName()     // Catch:{ IllegalAccessException -> 0x0113, InvocationTargetException -> 0x0108, NoSuchMethodException -> 0x00ea }
            java.lang.Class[] r11 = r7.getParameterTypes()     // Catch:{ IllegalAccessException -> 0x0113, InvocationTargetException -> 0x0108, NoSuchMethodException -> 0x00ea }
            java.lang.reflect.Method r9 = r9.getMethod(r10, r11)     // Catch:{ IllegalAccessException -> 0x0113, InvocationTargetException -> 0x0108, NoSuchMethodException -> 0x00ea }
            goto L_0x00d6
        L_0x00d5:
            r9 = r7
        L_0x00d6:
            r2.put(r6, r7)     // Catch:{ IllegalAccessException -> 0x00e7, InvocationTargetException -> 0x0108, NoSuchMethodException -> 0x00ea }
            if (r8 != 0) goto L_0x00df
            r8 = r6
            java.lang.Object[] r8 = (java.lang.Object[]) r8     // Catch:{ IllegalAccessException -> 0x00e7, InvocationTargetException -> 0x0108, NoSuchMethodException -> 0x00ea }
            goto L_0x00e3
        L_0x00df:
            java.lang.Object[] r8 = r12.createNullArguments(r8)     // Catch:{ IllegalAccessException -> 0x00e7, InvocationTargetException -> 0x0108, NoSuchMethodException -> 0x00ea }
        L_0x00e3:
            r9.invoke(r13, r8)     // Catch:{ IllegalAccessException -> 0x00e7, InvocationTargetException -> 0x0108, NoSuchMethodException -> 0x00ea }
            goto L_0x0108
        L_0x00e7:
            r1 = move-exception
            r7 = r9
            goto L_0x0114
        L_0x00ea:
            com.thoughtworks.xstream.converters.ConversionException r1 = new com.thoughtworks.xstream.converters.ConversionException     // Catch:{ all -> 0x0155 }
            java.lang.String r2 = "CGLIB enhanced proxies wit abstract nethod that has not been implemented"
            r1.<init>((java.lang.String) r2)     // Catch:{ all -> 0x0155 }
            java.lang.String r2 = "proxy superclass"
            java.lang.Class r3 = r5.getSuperclass()     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0155 }
            r1.add(r2, r3)     // Catch:{ all -> 0x0155 }
            java.lang.String r2 = "method"
            java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x0155 }
            r1.add(r2, r3)     // Catch:{ all -> 0x0155 }
            throw r1     // Catch:{ all -> 0x0155 }
        L_0x0108:
            boolean r7 = r2.containsKey(r7)     // Catch:{ all -> 0x0155 }
            if (r7 == 0) goto L_0x008c
            r1.remove()     // Catch:{ all -> 0x0155 }
            goto L_0x008c
        L_0x0113:
            r1 = move-exception
        L_0x0114:
            com.thoughtworks.xstream.converters.reflection.ObjectAccessException r2 = new com.thoughtworks.xstream.converters.reflection.ObjectAccessException     // Catch:{ all -> 0x0155 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0155 }
            r3.<init>()     // Catch:{ all -> 0x0155 }
            java.lang.String r4 = "Access to "
            r3.append(r4)     // Catch:{ all -> 0x0155 }
            r3.append(r7)     // Catch:{ all -> 0x0155 }
            java.lang.String r4 = " not allowed"
            r3.append(r4)     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0155 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0155 }
            throw r2     // Catch:{ all -> 0x0155 }
        L_0x0130:
            r1.remove()     // Catch:{ all -> 0x0155 }
            goto L_0x008c
        L_0x0135:
            if (r3 < 0) goto L_0x014e
            java.lang.Integer r1 = new java.lang.Integer     // Catch:{ all -> 0x0155 }
            r1.<init>(r3)     // Catch:{ all -> 0x0155 }
            java.util.Iterator r3 = r4.iterator()     // Catch:{ all -> 0x0155 }
        L_0x0140:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0155 }
            if (r4 == 0) goto L_0x014e
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0155 }
            r2.put(r4, r1)     // Catch:{ all -> 0x0155 }
            goto L_0x0140
        L_0x014e:
            r13.setCallbacks(r0)
            r2.remove(r6)
            return r2
        L_0x0155:
            r1 = move-exception
            r13.setCallbacks(r0)
            goto L_0x015b
        L_0x015a:
            throw r1
        L_0x015b:
            goto L_0x015a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.converters.reflection.CGLIBEnhancedConverter.createCallbackIndexMap(net.sf.cglib.proxy.Factory):java.util.Map");
    }

    private Object[] createNullArguments(Class[] clsArr) {
        Object[] objArr = new Object[clsArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Class cls = clsArr[i];
            if (cls.isPrimitive()) {
                if (cls == Byte.TYPE) {
                    objArr[i] = new Byte((byte) 0);
                } else if (cls == Short.TYPE) {
                    objArr[i] = new Short(0);
                } else if (cls == Integer.TYPE) {
                    objArr[i] = new Integer(0);
                } else if (cls == Long.TYPE) {
                    objArr[i] = new Long(0);
                } else if (cls == Float.TYPE) {
                    objArr[i] = new Float(BitmapDescriptorFactory.HUE_RED);
                } else if (cls == Double.TYPE) {
                    objArr[i] = new Double(0.0d);
                } else if (cls == Character.TYPE) {
                    objArr[i] = new Character(0);
                } else {
                    objArr[i] = Boolean.FALSE;
                }
            }
        }
        return objArr;
    }

    private Callback createReverseEngineeredCallbackOfProperType(Callback callback, int i, Map map) {
        Class<Callback> cls = null;
        Class<Callback>[] interfaces = callback.getClass().getInterfaces();
        int i2 = 0;
        while (i2 < interfaces.length) {
            if (Callback.class.isAssignableFrom(interfaces[i2])) {
                cls = interfaces[i2];
                if (cls != Callback.class) {
                    Class<Callback>[] interfaces2 = cls.getInterfaces();
                    if (Arrays.asList(interfaces2).contains(Callback.class)) {
                        break;
                    }
                    interfaces = interfaces2;
                    i2 = -1;
                } else {
                    ConversionException conversionException = new ConversionException("Cannot handle CGLIB callback");
                    conversionException.add("CGLIB callback type", callback.getClass().getName());
                    throw conversionException;
                }
            }
            i2++;
        }
        return (Callback) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new ReverseEngineeringInvocationHandler(i, map));
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Map map;
        Enhancer enhancer = new Enhancer();
        hierarchicalStreamReader.moveDown();
        Object obj = null;
        enhancer.setSuperclass((Class) unmarshallingContext.convertAnother((Object) null, Class.class));
        hierarchicalStreamReader.moveUp();
        hierarchicalStreamReader.moveDown();
        ArrayList arrayList = new ArrayList();
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            arrayList.add(unmarshallingContext.convertAnother((Object) null, this.mapper.realClass(hierarchicalStreamReader.getNodeName())));
            hierarchicalStreamReader.moveUp();
        }
        enhancer.setInterfaces((Class[]) arrayList.toArray(new Class[arrayList.size()]));
        hierarchicalStreamReader.moveUp();
        hierarchicalStreamReader.moveDown();
        boolean booleanValue = Boolean.valueOf(hierarchicalStreamReader.getValue()).booleanValue();
        enhancer.setUseFactory(booleanValue);
        hierarchicalStreamReader.moveUp();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        hierarchicalStreamReader.moveDown();
        if ("callbacks".equals(hierarchicalStreamReader.getNodeName())) {
            hierarchicalStreamReader.moveDown();
            map = (Map) unmarshallingContext.convertAnother((Object) null, HashMap.class);
            hierarchicalStreamReader.moveUp();
            while (hierarchicalStreamReader.hasMoreChildren()) {
                hierarchicalStreamReader.moveDown();
                readCallback(hierarchicalStreamReader, unmarshallingContext, arrayList2, arrayList3);
                hierarchicalStreamReader.moveUp();
            }
        } else {
            readCallback(hierarchicalStreamReader, unmarshallingContext, arrayList2, arrayList3);
            map = null;
        }
        enhancer.setCallbacks((Callback[]) arrayList2.toArray(new Callback[arrayList2.size()]));
        if (map != null) {
            enhancer.setCallbackFilter(new ReverseEngineeredCallbackFilter(map));
        }
        hierarchicalStreamReader.moveUp();
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            if (hierarchicalStreamReader.getNodeName().equals("serialVersionUID")) {
                enhancer.setSerialVersionUID(Long.valueOf(hierarchicalStreamReader.getValue()));
            } else if (hierarchicalStreamReader.getNodeName().equals("instance")) {
                obj = create(enhancer, arrayList3, booleanValue);
                super.doUnmarshalConditionally(obj, hierarchicalStreamReader, unmarshallingContext);
            }
            hierarchicalStreamReader.moveUp();
        }
        if (obj == null) {
            obj = create(enhancer, arrayList3, booleanValue);
        }
        return this.serializationMembers.callReadResolve(obj);
    }

    private void readCallback(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, List list, List list2) {
        Callback callback = (Callback) unmarshallingContext.convertAnother((Object) null, this.mapper.realClass(hierarchicalStreamReader.getNodeName()));
        list2.add(callback);
        if (callback == null) {
            list.add(NoOp.INSTANCE);
        } else {
            list.add(callback);
        }
    }

    private Object create(Enhancer enhancer, List list, boolean z) {
        Object create = enhancer.create();
        if (z) {
            ((Factory) create).setCallbacks((Callback[]) list.toArray(new Callback[list.size()]));
        }
        return create;
    }

    /* access modifiers changed from: protected */
    public List hierarchyFor(Class cls) {
        List hierarchyFor = super.hierarchyFor(cls);
        hierarchyFor.remove(hierarchyFor.size() - 1);
        return hierarchyFor;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        super.readResolve();
        this.fieldCache = new HashMap();
        return this;
    }

    private static class CGLIBFilteringReflectionProvider extends ReflectionProviderWrapper {
        public CGLIBFilteringReflectionProvider(ReflectionProvider reflectionProvider) {
            super(reflectionProvider);
        }

        public void visitSerializableFields(Object obj, final ReflectionProvider.Visitor visitor) {
            this.wrapped.visitSerializableFields(obj, new ReflectionProvider.Visitor() {
                public void visit(String str, Class cls, Class cls2, Object obj) {
                    if (!str.startsWith("CGLIB$")) {
                        visitor.visit(str, cls, cls2, obj);
                    }
                }
            });
        }
    }

    private static final class ReverseEngineeringInvocationHandler implements InvocationHandler {
        private final Integer index;
        private final Map indexMap;

        public ReverseEngineeringInvocationHandler(int i, Map map) {
            this.indexMap = map;
            this.index = new Integer(i);
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Map map = this.indexMap;
            map.put(map.get((Object) null), this.index);
            return null;
        }
    }

    private static class ReverseEngineeredCallbackFilter implements CallbackFilter {
        private final Map callbackIndexMap;

        public ReverseEngineeredCallbackFilter(Map map) {
            this.callbackIndexMap = map;
        }

        public int accept(Method method) {
            if (this.callbackIndexMap.containsKey(method)) {
                return ((Integer) this.callbackIndexMap.get(method)).intValue();
            }
            ConversionException conversionException = new ConversionException("CGLIB callback not detected in reverse engineering");
            conversionException.add("CGLIB callback", method.toString());
            throw conversionException;
        }
    }
}
