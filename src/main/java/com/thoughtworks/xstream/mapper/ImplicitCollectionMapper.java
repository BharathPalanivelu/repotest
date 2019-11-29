package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.InitializationException;
import com.thoughtworks.xstream.core.util.Primitives;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ImplicitCollectionMapper extends MapperWrapper {
    private final Map classNameToMapper = new HashMap();

    public ImplicitCollectionMapper(Mapper mapper) {
        super(mapper);
    }

    /* access modifiers changed from: private */
    public ImplicitCollectionMapperForClass getMapper(Class cls) {
        while (cls != null) {
            ImplicitCollectionMapperForClass implicitCollectionMapperForClass = (ImplicitCollectionMapperForClass) this.classNameToMapper.get(cls);
            if (implicitCollectionMapperForClass != null) {
                return implicitCollectionMapperForClass;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private ImplicitCollectionMapperForClass getOrCreateMapper(Class cls) {
        ImplicitCollectionMapperForClass implicitCollectionMapperForClass = (ImplicitCollectionMapperForClass) this.classNameToMapper.get(cls);
        if (implicitCollectionMapperForClass != null) {
            return implicitCollectionMapperForClass;
        }
        ImplicitCollectionMapperForClass implicitCollectionMapperForClass2 = new ImplicitCollectionMapperForClass(cls);
        this.classNameToMapper.put(cls, implicitCollectionMapperForClass2);
        return implicitCollectionMapperForClass2;
    }

    public String getFieldNameForItemTypeAndName(Class cls, Class cls2, String str) {
        ImplicitCollectionMapperForClass mapper = getMapper(cls);
        if (mapper != null) {
            return mapper.getFieldNameForItemTypeAndName(cls2, str);
        }
        return null;
    }

    public Class getItemTypeForItemFieldName(Class cls, String str) {
        ImplicitCollectionMapperForClass mapper = getMapper(cls);
        if (mapper != null) {
            return mapper.getItemTypeForItemFieldName(str);
        }
        return null;
    }

    public Mapper.ImplicitCollectionMapping getImplicitCollectionDefForFieldName(Class cls, String str) {
        ImplicitCollectionMapperForClass mapper = getMapper(cls);
        if (mapper != null) {
            return mapper.getImplicitCollectionDefForFieldName(str);
        }
        return null;
    }

    public void add(Class cls, String str, Class cls2) {
        add(cls, str, (String) null, cls2);
    }

    public void add(Class cls, String str, String str2, Class cls2) {
        add(cls, str, str2, cls2, (String) null);
    }

    public void add(Class cls, String str, String str2, Class cls2, String str3) {
        Field field;
        Class cls3 = cls;
        while (true) {
            if (cls3 == Object.class || cls == null) {
                field = null;
            } else {
                try {
                    field = cls3.getDeclaredField(str);
                    break;
                } catch (SecurityException e2) {
                    throw new InitializationException("Access denied for field with implicit collection", e2);
                } catch (NoSuchFieldException unused) {
                    cls3 = cls3.getSuperclass();
                }
            }
        }
        if (field != null) {
            if (Map.class.isAssignableFrom(field.getType())) {
                if (str2 == null && str3 == null) {
                    cls2 = Map.Entry.class;
                }
            } else if (!Collection.class.isAssignableFrom(field.getType())) {
                Class<?> type = field.getType();
                if (type.isArray()) {
                    Class<?> componentType = type.getComponentType();
                    if (componentType.isPrimitive()) {
                        componentType = Primitives.box(componentType);
                    }
                    if (cls2 == null) {
                        cls2 = componentType;
                    } else {
                        if (cls2.isPrimitive()) {
                            cls2 = Primitives.box(cls2);
                        }
                        if (!componentType.isAssignableFrom(cls2)) {
                            throw new InitializationException("Field \"" + str + "\" declares an array, but the array type is not compatible with " + cls2.getName());
                        }
                    }
                } else {
                    throw new InitializationException("Field \"" + str + "\" declares no collection or array");
                }
            }
            getOrCreateMapper(cls).add(new ImplicitCollectionMappingImpl(str, cls2, str2, str3));
            return;
        }
        throw new InitializationException("No field \"" + str + "\" for implicit collection");
    }

    private class ImplicitCollectionMapperForClass {
        private Class definedIn;
        private Map fieldNameToDef = new HashMap();
        private Map itemFieldNameToDef = new HashMap();
        private Map namedItemTypeToDef = new HashMap();

        ImplicitCollectionMapperForClass(Class cls) {
            this.definedIn = cls;
        }

        public String getFieldNameForItemTypeAndName(Class cls, String str) {
            Iterator it = this.namedItemTypeToDef.keySet().iterator();
            ImplicitCollectionMappingImpl implicitCollectionMappingImpl = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                NamedItemType namedItemType = (NamedItemType) it.next();
                ImplicitCollectionMappingImpl implicitCollectionMappingImpl2 = (ImplicitCollectionMappingImpl) this.namedItemTypeToDef.get(namedItemType);
                if (cls == Mapper.Null.class) {
                    implicitCollectionMappingImpl = implicitCollectionMappingImpl2;
                    break;
                } else if (namedItemType.itemType.isAssignableFrom(cls)) {
                    if (implicitCollectionMappingImpl2.getItemFieldName() != null) {
                        if (implicitCollectionMappingImpl2.getItemFieldName().equals(str)) {
                            return implicitCollectionMappingImpl2.getFieldName();
                        }
                    } else if (implicitCollectionMappingImpl == null || implicitCollectionMappingImpl.getItemType() == null || (implicitCollectionMappingImpl2.getItemType() != null && implicitCollectionMappingImpl.getItemType().isAssignableFrom(implicitCollectionMappingImpl2.getItemType()))) {
                        implicitCollectionMappingImpl = implicitCollectionMappingImpl2;
                    }
                }
            }
            if (implicitCollectionMappingImpl != null) {
                return implicitCollectionMappingImpl.getFieldName();
            }
            ImplicitCollectionMapperForClass access$000 = ImplicitCollectionMapper.this.getMapper(this.definedIn.getSuperclass());
            if (access$000 != null) {
                return access$000.getFieldNameForItemTypeAndName(cls, str);
            }
            return null;
        }

        public Class getItemTypeForItemFieldName(String str) {
            ImplicitCollectionMappingImpl implicitCollectionDefByItemFieldName = getImplicitCollectionDefByItemFieldName(str);
            if (implicitCollectionDefByItemFieldName != null) {
                return implicitCollectionDefByItemFieldName.getItemType();
            }
            ImplicitCollectionMapperForClass access$000 = ImplicitCollectionMapper.this.getMapper(this.definedIn.getSuperclass());
            if (access$000 != null) {
                return access$000.getItemTypeForItemFieldName(str);
            }
            return null;
        }

        private ImplicitCollectionMappingImpl getImplicitCollectionDefByItemFieldName(String str) {
            if (str == null) {
                return null;
            }
            ImplicitCollectionMappingImpl implicitCollectionMappingImpl = (ImplicitCollectionMappingImpl) this.itemFieldNameToDef.get(str);
            if (implicitCollectionMappingImpl != null) {
                return implicitCollectionMappingImpl;
            }
            ImplicitCollectionMapperForClass access$000 = ImplicitCollectionMapper.this.getMapper(this.definedIn.getSuperclass());
            if (access$000 != null) {
                return access$000.getImplicitCollectionDefByItemFieldName(str);
            }
            return null;
        }

        public Mapper.ImplicitCollectionMapping getImplicitCollectionDefForFieldName(String str) {
            Mapper.ImplicitCollectionMapping implicitCollectionMapping = (Mapper.ImplicitCollectionMapping) this.fieldNameToDef.get(str);
            if (implicitCollectionMapping != null) {
                return implicitCollectionMapping;
            }
            ImplicitCollectionMapperForClass access$000 = ImplicitCollectionMapper.this.getMapper(this.definedIn.getSuperclass());
            if (access$000 != null) {
                return access$000.getImplicitCollectionDefForFieldName(str);
            }
            return null;
        }

        public void add(ImplicitCollectionMappingImpl implicitCollectionMappingImpl) {
            this.fieldNameToDef.put(implicitCollectionMappingImpl.getFieldName(), implicitCollectionMappingImpl);
            this.namedItemTypeToDef.put(implicitCollectionMappingImpl.createNamedItemType(), implicitCollectionMappingImpl);
            if (implicitCollectionMappingImpl.getItemFieldName() != null) {
                this.itemFieldNameToDef.put(implicitCollectionMappingImpl.getItemFieldName(), implicitCollectionMappingImpl);
            }
        }
    }

    private static class ImplicitCollectionMappingImpl implements Mapper.ImplicitCollectionMapping {
        private final String fieldName;
        private final String itemFieldName;
        private final Class itemType;
        private final String keyFieldName;

        ImplicitCollectionMappingImpl(String str, Class cls, String str2, String str3) {
            this.fieldName = str;
            this.itemFieldName = str2;
            this.itemType = cls;
            this.keyFieldName = str3;
        }

        public NamedItemType createNamedItemType() {
            return new NamedItemType(this.itemType, this.itemFieldName);
        }

        public String getFieldName() {
            return this.fieldName;
        }

        public String getItemFieldName() {
            return this.itemFieldName;
        }

        public Class getItemType() {
            return this.itemType;
        }

        public String getKeyFieldName() {
            return this.keyFieldName;
        }
    }

    private static class NamedItemType {
        String itemFieldName;
        Class itemType;

        NamedItemType(Class cls, String str) {
            this.itemType = cls == null ? Object.class : cls;
            this.itemFieldName = str;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NamedItemType)) {
                return false;
            }
            NamedItemType namedItemType = (NamedItemType) obj;
            if (!this.itemType.equals(namedItemType.itemType) || !isEquals(this.itemFieldName, namedItemType.itemFieldName)) {
                return false;
            }
            return true;
        }

        private static boolean isEquals(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        public int hashCode() {
            int hashCode = this.itemType.hashCode() << 7;
            String str = this.itemFieldName;
            return str != null ? hashCode + str.hashCode() : hashCode;
        }
    }
}
