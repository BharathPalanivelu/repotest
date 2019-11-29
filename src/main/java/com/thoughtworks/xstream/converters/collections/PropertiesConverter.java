package com.thoughtworks.xstream.converters.collections;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.util.Fields;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class PropertiesConverter implements Converter {
    private static final Field defaultsField = Fields.locate(Properties.class, Properties.class, false);
    private final boolean sort;

    public PropertiesConverter() {
        this(false);
    }

    public PropertiesConverter(boolean z) {
        this.sort = z;
    }

    public boolean canConvert(Class cls) {
        return Properties.class == cls;
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Properties properties = (Properties) obj;
        for (Map.Entry entry : (this.sort ? new TreeMap(properties) : properties).entrySet()) {
            hierarchicalStreamWriter.startNode("property");
            hierarchicalStreamWriter.addAttribute("name", entry.getKey().toString());
            hierarchicalStreamWriter.addAttribute(AppMeasurementSdk.ConditionalUserProperty.VALUE, entry.getValue().toString());
            hierarchicalStreamWriter.endNode();
        }
        Field field = defaultsField;
        if (field != null) {
            Properties properties2 = (Properties) Fields.read(field, properties);
            if (properties2 != null) {
                hierarchicalStreamWriter.startNode("defaults");
                marshal(properties2, hierarchicalStreamWriter, marshallingContext);
                hierarchicalStreamWriter.endNode();
            }
        }
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Properties properties = new Properties();
        Properties properties2 = null;
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            if (hierarchicalStreamReader.getNodeName().equals("defaults")) {
                properties2 = (Properties) unmarshal(hierarchicalStreamReader, unmarshallingContext);
            } else {
                properties.setProperty(hierarchicalStreamReader.getAttribute("name"), hierarchicalStreamReader.getAttribute(AppMeasurementSdk.ConditionalUserProperty.VALUE));
            }
            hierarchicalStreamReader.moveUp();
        }
        if (properties2 == null) {
            return properties;
        }
        Properties properties3 = new Properties(properties2);
        properties3.putAll(properties);
        return properties3;
    }
}
