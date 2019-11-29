package com.thoughtworks.xstream.mapper;

public class XStream11XmlFriendlyMapper extends AbstractXmlFriendlyMapper {
    public XStream11XmlFriendlyMapper(Mapper mapper) {
        super(mapper);
    }

    public Class realClass(String str) {
        return super.realClass(unescapeClassName(str));
    }

    public String realMember(Class cls, String str) {
        return unescapeFieldName(super.realMember(cls, str));
    }

    public String mapNameFromXML(String str) {
        return unescapeFieldName(str);
    }
}
