package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

public class BitSetConverter implements Converter {
    public boolean canConvert(Class cls) {
        return cls.equals(BitSet.class);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        BitSet bitSet = (BitSet) obj;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        for (int i = 0; i < bitSet.length(); i++) {
            if (bitSet.get(i)) {
                if (z) {
                    stringBuffer.append(',');
                } else {
                    z = true;
                }
                stringBuffer.append(i);
            }
        }
        hierarchicalStreamWriter.setValue(stringBuffer.toString());
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        BitSet bitSet = new BitSet();
        StringTokenizer stringTokenizer = new StringTokenizer(hierarchicalStreamReader.getValue(), ",", false);
        while (stringTokenizer.hasMoreTokens()) {
            bitSet.set(Integer.parseInt(stringTokenizer.nextToken()));
        }
        return bitSet;
    }
}
