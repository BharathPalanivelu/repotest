package com.thoughtworks.xstream.io;

public class ExtendedHierarchicalStreamWriterHelper {
    public static void startNode(HierarchicalStreamWriter hierarchicalStreamWriter, String str, Class cls) {
        if (hierarchicalStreamWriter instanceof ExtendedHierarchicalStreamWriter) {
            ((ExtendedHierarchicalStreamWriter) hierarchicalStreamWriter).startNode(str, cls);
        } else {
            hierarchicalStreamWriter.startNode(str);
        }
    }
}
