package com.thoughtworks.xstream.mapper;

public class AttributeAliasingMapper extends AbstractAttributeAliasingMapper {
    public AttributeAliasingMapper(Mapper mapper) {
        super(mapper);
    }

    public String aliasForAttribute(String str) {
        String str2 = (String) this.nameToAlias.get(str);
        return str2 == null ? super.aliasForAttribute(str) : str2;
    }

    public String attributeForAlias(String str) {
        String str2 = (String) this.aliasToName.get(str);
        return str2 == null ? super.attributeForAlias(str) : str2;
    }
}
