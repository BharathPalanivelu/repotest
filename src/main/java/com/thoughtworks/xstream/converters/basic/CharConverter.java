package com.thoughtworks.xstream.converters.basic;

import com.facebook.internal.ServerProtocol;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CharConverter implements Converter, SingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(Character.TYPE) || cls.equals(Character.class);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        hierarchicalStreamWriter.setValue(toString(obj));
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        String attribute = hierarchicalStreamReader.getAttribute("null");
        if (attribute == null || !attribute.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return fromString(hierarchicalStreamReader.getValue());
        }
        return new Character(0);
    }

    public Object fromString(String str) {
        if (str.length() == 0) {
            return new Character(0);
        }
        return new Character(str.charAt(0));
    }

    public String toString(Object obj) {
        if (((Character) obj).charValue() == 0) {
            return "";
        }
        return obj.toString();
    }
}
