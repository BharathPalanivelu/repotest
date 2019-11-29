package com.thoughtworks.xstream.mapper;

public class SystemAttributeAliasingMapper extends AbstractAttributeAliasingMapper {
    public SystemAttributeAliasingMapper(Mapper mapper) {
        super(mapper);
    }

    public String aliasForSystemAttribute(String str) {
        String str2 = (String) this.nameToAlias.get(str);
        if (str2 != null || this.nameToAlias.containsKey(str)) {
            return str2;
        }
        String aliasForSystemAttribute = super.aliasForSystemAttribute(str);
        return aliasForSystemAttribute == str ? super.aliasForAttribute(str) : aliasForSystemAttribute;
    }
}
