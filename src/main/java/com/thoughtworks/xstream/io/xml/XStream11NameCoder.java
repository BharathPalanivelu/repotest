package com.thoughtworks.xstream.io.xml;

public class XStream11NameCoder extends XmlFriendlyNameCoder {
    public String decodeAttribute(String str) {
        return str;
    }

    public String decodeNode(String str) {
        return str;
    }
}
