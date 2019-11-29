package com.thoughtworks.xstream.io.naming;

public class NoNameCoder implements NameCoder {
    public String decodeAttribute(String str) {
        return str;
    }

    public String decodeNode(String str) {
        return str;
    }

    public String encodeAttribute(String str) {
        return str;
    }

    public String encodeNode(String str) {
        return str;
    }
}
