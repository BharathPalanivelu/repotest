package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.util.regex.Pattern;

public class RegexPatternConverter implements Converter {
    public RegexPatternConverter() {
    }

    public RegexPatternConverter(Converter converter) {
    }

    public boolean canConvert(Class cls) {
        return cls.equals(Pattern.class);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Pattern pattern = (Pattern) obj;
        hierarchicalStreamWriter.startNode("pattern");
        hierarchicalStreamWriter.setValue(pattern.pattern());
        hierarchicalStreamWriter.endNode();
        hierarchicalStreamWriter.startNode("flags");
        hierarchicalStreamWriter.setValue(String.valueOf(pattern.flags()));
        hierarchicalStreamWriter.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        hierarchicalStreamReader.moveDown();
        String value = hierarchicalStreamReader.getValue();
        hierarchicalStreamReader.moveUp();
        hierarchicalStreamReader.moveDown();
        int parseInt = Integer.parseInt(hierarchicalStreamReader.getValue());
        hierarchicalStreamReader.moveUp();
        return Pattern.compile(value, parseInt);
    }
}
