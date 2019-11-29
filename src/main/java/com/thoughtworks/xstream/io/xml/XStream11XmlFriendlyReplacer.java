package com.thoughtworks.xstream.io.xml;

public class XStream11XmlFriendlyReplacer extends XmlFriendlyReplacer {
    public String decodeAttribute(String str) {
        return str;
    }

    public String decodeNode(String str) {
        return str;
    }

    public String unescapeName(String str) {
        return str;
    }
}
