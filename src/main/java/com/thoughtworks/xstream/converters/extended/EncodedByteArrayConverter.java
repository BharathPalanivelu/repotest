package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.basic.ByteConverter;
import com.thoughtworks.xstream.core.util.Base64Encoder;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.util.ArrayList;

public class EncodedByteArrayConverter implements Converter, SingleValueConverter {
    private static final Base64Encoder base64 = new Base64Encoder();
    private static final ByteConverter byteConverter = new ByteConverter();

    public boolean canConvert(Class cls) {
        return cls.isArray() && cls.getComponentType().equals(Byte.TYPE);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        hierarchicalStreamWriter.setValue(toString(obj));
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        String value = hierarchicalStreamReader.getValue();
        if (!hierarchicalStreamReader.hasMoreChildren()) {
            return fromString(value);
        }
        return unmarshalIndividualByteElements(hierarchicalStreamReader, unmarshallingContext);
    }

    private Object unmarshalIndividualByteElements(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        ArrayList<Byte> arrayList = new ArrayList<>();
        int i = 0;
        boolean z = true;
        while (true) {
            if (!z && !hierarchicalStreamReader.hasMoreChildren()) {
                break;
            }
            hierarchicalStreamReader.moveDown();
            arrayList.add(byteConverter.fromString(hierarchicalStreamReader.getValue()));
            hierarchicalStreamReader.moveUp();
            z = false;
        }
        byte[] bArr = new byte[arrayList.size()];
        for (Byte byteValue : arrayList) {
            bArr[i] = byteValue.byteValue();
            i++;
        }
        return bArr;
    }

    public String toString(Object obj) {
        return base64.encode((byte[]) obj);
    }

    public Object fromString(String str) {
        return base64.decode(str);
    }
}
