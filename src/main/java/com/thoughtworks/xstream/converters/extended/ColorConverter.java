package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.awt.Color;
import java.util.HashMap;

public class ColorConverter implements Converter {
    public boolean canConvert(Class cls) {
        return cls.getName().equals("java.awt.Color");
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Color color = (Color) obj;
        write("red", color.getRed(), hierarchicalStreamWriter);
        write("green", color.getGreen(), hierarchicalStreamWriter);
        write("blue", color.getBlue(), hierarchicalStreamWriter);
        write("alpha", color.getAlpha(), hierarchicalStreamWriter);
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        HashMap hashMap = new HashMap();
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            hashMap.put(hierarchicalStreamReader.getNodeName(), Integer.valueOf(hierarchicalStreamReader.getValue()));
            hierarchicalStreamReader.moveUp();
        }
        return new Color(((Integer) hashMap.get("red")).intValue(), ((Integer) hashMap.get("green")).intValue(), ((Integer) hashMap.get("blue")).intValue(), ((Integer) hashMap.get("alpha")).intValue());
    }

    private void write(String str, int i, HierarchicalStreamWriter hierarchicalStreamWriter) {
        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, str, Integer.TYPE);
        hierarchicalStreamWriter.setValue(String.valueOf(i));
        hierarchicalStreamWriter.endNode();
    }
}
