package com.thoughtworks.xstream.io.xml;

public class XmlFriendlyReplacer extends XmlFriendlyNameCoder {
    public XmlFriendlyReplacer() {
        this("_-", "__");
    }

    public XmlFriendlyReplacer(String str, String str2) {
        super(str, str2);
    }

    public String escapeName(String str) {
        return super.encodeNode(str);
    }

    public String unescapeName(String str) {
        return super.decodeNode(str);
    }
}
