package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.Map;

public class NamedMapConverter extends MapConverter {
    private final String entryName;
    private final Mapper enumMapper;
    private final boolean keyAsAttribute;
    private final String keyName;
    private final Class keyType;
    private final ConverterLookup lookup;
    private final boolean valueAsAttribute;
    private final String valueName;
    private final Class valueType;

    public NamedMapConverter(Mapper mapper, String str, String str2, Class cls, String str3, Class cls2) {
        this(mapper, str, str2, cls, str3, cls2, false, false, (ConverterLookup) null);
    }

    public NamedMapConverter(Class cls, Mapper mapper, String str, String str2, Class cls2, String str3, Class cls3) {
        this(cls, mapper, str, str2, cls2, str3, cls3, false, false, (ConverterLookup) null);
    }

    public NamedMapConverter(Mapper mapper, String str, String str2, Class cls, String str3, Class cls2, boolean z, boolean z2, ConverterLookup converterLookup) {
        this((Class) null, mapper, str, str2, cls, str3, cls2, z, z2, converterLookup);
    }

    public NamedMapConverter(Class cls, Mapper mapper, String str, String str2, Class cls2, String str3, Class cls3, boolean z, boolean z2, ConverterLookup converterLookup) {
        super(mapper, cls);
        Mapper mapper2 = null;
        this.entryName = (str == null || str.length() != 0) ? str : null;
        this.keyName = (str2 == null || str2.length() != 0) ? str2 : null;
        this.keyType = cls2;
        this.valueName = (str3 == null || str3.length() != 0) ? str3 : null;
        this.valueType = cls3;
        this.keyAsAttribute = z;
        this.valueAsAttribute = z2;
        this.lookup = converterLookup;
        this.enumMapper = JVM.is15() ? UseAttributeForEnumMapper.createEnumMapper(mapper) : mapper2;
        if (cls2 == null || cls3 == null) {
            throw new IllegalArgumentException("Class types of key and value are mandatory");
        }
        if (str == null) {
            if (z || z2) {
                throw new IllegalArgumentException("Cannot write attributes to map entry, if map entry must be omitted");
            } else if (str3 == null) {
                throw new IllegalArgumentException("Cannot write value as text of entry, if entry must be omitted");
            }
        }
        if (str2 != null) {
            if (str3 == null) {
                if (z2) {
                    throw new IllegalArgumentException("Cannot write value as attribute without name");
                } else if (!z) {
                    throw new IllegalArgumentException("Cannot write value as text of entry, if key is also child element");
                }
            }
            if (z && z2 && str2.equals(str3)) {
                throw new IllegalArgumentException("Cannot write key and value with same attribute name");
            }
            return;
        }
        throw new IllegalArgumentException("Cannot write key without name");
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Map map = (Map) obj;
        SingleValueConverter singleValueConverter = null;
        SingleValueConverter singleValueConverter2 = this.keyAsAttribute ? getSingleValueConverter(this.keyType) : null;
        if (this.valueAsAttribute || this.valueName == null) {
            singleValueConverter = getSingleValueConverter(this.valueType);
        }
        SingleValueConverter singleValueConverter3 = singleValueConverter;
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            String str = this.entryName;
            if (str != null) {
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, str, entry.getClass());
                if (!(singleValueConverter2 == null || key == null)) {
                    hierarchicalStreamWriter.addAttribute(this.keyName, singleValueConverter2.toString(key));
                }
                String str2 = this.valueName;
                if (!(str2 == null || singleValueConverter3 == null || value == null)) {
                    hierarchicalStreamWriter.addAttribute(str2, singleValueConverter3.toString(value));
                }
            }
            if (singleValueConverter2 == null) {
                writeItem(this.keyName, this.keyType, key, marshallingContext, hierarchicalStreamWriter);
            }
            if (singleValueConverter3 == null) {
                writeItem(this.valueName, this.valueType, value, marshallingContext, hierarchicalStreamWriter);
            } else if (this.valueName == null) {
                hierarchicalStreamWriter.setValue(singleValueConverter3.toString(value));
            }
            if (this.entryName != null) {
                hierarchicalStreamWriter.endNode();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void populateMap(com.thoughtworks.xstream.io.HierarchicalStreamReader r8, com.thoughtworks.xstream.converters.UnmarshallingContext r9, java.util.Map r10, java.util.Map r11) {
        /*
            r7 = this;
            boolean r0 = r7.keyAsAttribute
            r1 = 0
            if (r0 == 0) goto L_0x000c
            java.lang.Class r0 = r7.keyType
            com.thoughtworks.xstream.converters.SingleValueConverter r0 = r7.getSingleValueConverter(r0)
            goto L_0x000d
        L_0x000c:
            r0 = r1
        L_0x000d:
            boolean r2 = r7.valueAsAttribute
            if (r2 != 0) goto L_0x0018
            java.lang.String r2 = r7.valueName
            if (r2 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r2 = r1
            goto L_0x001e
        L_0x0018:
            java.lang.Class r2 = r7.valueType
            com.thoughtworks.xstream.converters.SingleValueConverter r2 = r7.getSingleValueConverter(r2)
        L_0x001e:
            boolean r3 = r8.hasMoreChildren()
            if (r3 == 0) goto L_0x00af
            java.lang.String r3 = r7.entryName
            if (r3 == 0) goto L_0x0050
            r8.moveDown()
            if (r0 == 0) goto L_0x003a
            java.lang.String r3 = r7.keyName
            java.lang.String r3 = r8.getAttribute((java.lang.String) r3)
            if (r3 == 0) goto L_0x003a
            java.lang.Object r3 = r0.fromString(r3)
            goto L_0x003b
        L_0x003a:
            r3 = r1
        L_0x003b:
            boolean r4 = r7.valueAsAttribute
            if (r4 == 0) goto L_0x004e
            if (r2 == 0) goto L_0x004e
            java.lang.String r4 = r7.valueName
            java.lang.String r4 = r8.getAttribute((java.lang.String) r4)
            if (r4 == 0) goto L_0x004e
            java.lang.Object r4 = r2.fromString(r4)
            goto L_0x0052
        L_0x004e:
            r4 = r1
            goto L_0x0052
        L_0x0050:
            r3 = r1
            r4 = r3
        L_0x0052:
            if (r0 != 0) goto L_0x007f
            r8.moveDown()
            if (r2 != 0) goto L_0x0076
            java.lang.String r5 = r7.keyName
            java.lang.String r6 = r7.valueName
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0076
            java.lang.String r5 = r8.getNodeName()
            java.lang.String r6 = r7.valueName
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0076
            java.lang.Class r4 = r7.valueType
            java.lang.Object r4 = r7.readItem(r4, r8, r9, r10)
            goto L_0x007c
        L_0x0076:
            java.lang.Class r3 = r7.keyType
            java.lang.Object r3 = r7.readItem(r3, r8, r9, r10)
        L_0x007c:
            r8.moveUp()
        L_0x007f:
            if (r2 != 0) goto L_0x009b
            r8.moveDown()
            if (r0 != 0) goto L_0x0091
            if (r3 != 0) goto L_0x0091
            if (r4 == 0) goto L_0x0091
            java.lang.Class r3 = r7.keyType
            java.lang.Object r3 = r7.readItem(r3, r8, r9, r10)
            goto L_0x0097
        L_0x0091:
            java.lang.Class r4 = r7.valueType
            java.lang.Object r4 = r7.readItem(r4, r8, r9, r10)
        L_0x0097:
            r8.moveUp()
            goto L_0x00a3
        L_0x009b:
            boolean r5 = r7.valueAsAttribute
            if (r5 != 0) goto L_0x00a3
            java.lang.String r4 = r8.getValue()
        L_0x00a3:
            r11.put(r3, r4)
            java.lang.String r3 = r7.entryName
            if (r3 == 0) goto L_0x001e
            r8.moveUp()
            goto L_0x001e
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.converters.extended.NamedMapConverter.populateMap(com.thoughtworks.xstream.io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext, java.util.Map, java.util.Map):void");
    }

    private SingleValueConverter getSingleValueConverter(Class cls) {
        Mapper mapper;
        if (UseAttributeForEnumMapper.isEnum(cls)) {
            mapper = this.enumMapper;
        } else {
            mapper = mapper();
        }
        SingleValueConverter converterFromItemType = mapper.getConverterFromItemType((String) null, cls, (Class) null);
        if (converterFromItemType != null) {
            return converterFromItemType;
        }
        Converter lookupConverterForType = this.lookup.lookupConverterForType(cls);
        if (lookupConverterForType instanceof SingleValueConverter) {
            return (SingleValueConverter) lookupConverterForType;
        }
        throw new ConversionException("No SingleValueConverter for key available");
    }

    /* access modifiers changed from: protected */
    public void writeItem(String str, Class cls, Object obj, MarshallingContext marshallingContext, HierarchicalStreamWriter hierarchicalStreamWriter) {
        Class cls2 = obj == null ? Mapper.Null.class : obj.getClass();
        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, str, cls2);
        if (!cls2.equals(cls)) {
            String aliasForSystemAttribute = mapper().aliasForSystemAttribute("class");
            if (aliasForSystemAttribute != null) {
                hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, mapper().serializedClass(cls2));
            }
        }
        if (obj != null) {
            marshallingContext.convertAnother(obj);
        }
        hierarchicalStreamWriter.endNode();
    }

    /* access modifiers changed from: protected */
    public Object readItem(Class cls, HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Object obj) {
        String readClassAttribute = HierarchicalStreams.readClassAttribute(hierarchicalStreamReader, mapper());
        if (readClassAttribute != null) {
            cls = mapper().realClass(readClassAttribute);
        }
        if (Mapper.Null.class.equals(cls)) {
            return null;
        }
        return unmarshallingContext.convertAnother(obj, cls);
    }
}
