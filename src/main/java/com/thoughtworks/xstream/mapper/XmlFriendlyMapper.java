package com.thoughtworks.xstream.mapper;

public class XmlFriendlyMapper extends AbstractXmlFriendlyMapper {
    public XmlFriendlyMapper(Mapper mapper) {
        super(mapper);
    }

    public String serializedClass(Class cls) {
        return escapeClassName(super.serializedClass(cls));
    }

    public Class realClass(String str) {
        return super.realClass(unescapeClassName(str));
    }

    public String serializedMember(Class cls, String str) {
        return escapeFieldName(super.serializedMember(cls, str));
    }

    public String realMember(Class cls, String str) {
        return unescapeFieldName(super.realMember(cls, str));
    }

    public String mapNameToXML(String str) {
        return escapeFieldName(str);
    }

    public String mapNameFromXML(String str) {
        return unescapeFieldName(str);
    }
}
