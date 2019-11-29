package com.thoughtworks.xstream.io.json;

import java.io.Writer;

public class JsonHierarchicalStreamWriter extends JsonWriter {
    public JsonHierarchicalStreamWriter(Writer writer, char[] cArr, String str) {
        super(writer, cArr, str);
    }

    public JsonHierarchicalStreamWriter(Writer writer, char[] cArr) {
        this(writer, cArr, "\n");
    }

    public JsonHierarchicalStreamWriter(Writer writer, String str, String str2) {
        this(writer, str.toCharArray(), str2);
    }

    public JsonHierarchicalStreamWriter(Writer writer, String str) {
        this(writer, str.toCharArray());
    }

    public JsonHierarchicalStreamWriter(Writer writer) {
        this(writer, new char[]{' ', ' '});
    }
}
