package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.awt.Font;
import java.util.Map;

public class FontConverter implements Converter {
    private final Mapper mapper;
    private final SingleValueConverter textAttributeConverter;

    public FontConverter() {
        this((Mapper) null);
    }

    public FontConverter(Mapper mapper2) {
        this.mapper = mapper2;
        if (mapper2 == null) {
            this.textAttributeConverter = null;
        } else {
            this.textAttributeConverter = new TextAttributeConverter();
        }
    }

    public boolean canConvert(Class cls) {
        return cls.getName().equals("java.awt.Font") || cls.getName().equals("javax.swing.plaf.FontUIResource");
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Map attributes = ((Font) obj).getAttributes();
        Mapper mapper2 = this.mapper;
        if (mapper2 != null) {
            String aliasForSystemAttribute = mapper2.aliasForSystemAttribute("class");
            for (Map.Entry entry : attributes.entrySet()) {
                String singleValueConverter = this.textAttributeConverter.toString(entry.getKey());
                Object value = entry.getValue();
                Class cls = value != null ? value.getClass() : Mapper.Null.class;
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, singleValueConverter, cls);
                hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, this.mapper.serializedClass(cls));
                if (value != null) {
                    marshallingContext.convertAnother(value);
                }
                hierarchicalStreamWriter.endNode();
            }
            return;
        }
        hierarchicalStreamWriter.startNode("attributes");
        marshallingContext.convertAnother(attributes);
        hierarchicalStreamWriter.endNode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader r7, com.thoughtworks.xstream.converters.UnmarshallingContext r8) {
        /*
            r6 = this;
            boolean r0 = r7.hasMoreChildren()
            if (r0 == 0) goto L_0x0066
            r7.moveDown()
            java.lang.String r0 = r7.getNodeName()
            java.lang.String r1 = "attributes"
            boolean r0 = r0.equals(r1)
            r1 = 0
            if (r0 != 0) goto L_0x0059
            com.thoughtworks.xstream.mapper.Mapper r0 = r6.mapper
            java.lang.String r2 = "class"
            java.lang.String r0 = r0.aliasForSystemAttribute(r2)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
        L_0x0023:
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x002c
            r7.moveDown()
        L_0x002c:
            com.thoughtworks.xstream.mapper.Mapper r3 = r6.mapper
            java.lang.String r4 = r7.getAttribute((java.lang.String) r0)
            java.lang.Class r3 = r3.realClass(r4)
            com.thoughtworks.xstream.converters.SingleValueConverter r4 = r6.textAttributeConverter
            java.lang.String r5 = r7.getNodeName()
            java.lang.Object r4 = r4.fromString(r5)
            java.awt.font.TextAttribute r4 = (java.awt.font.TextAttribute) r4
            java.lang.Class<com.thoughtworks.xstream.mapper.Mapper$Null> r5 = com.thoughtworks.xstream.mapper.Mapper.Null.class
            if (r3 != r5) goto L_0x0048
            r3 = r1
            goto L_0x004c
        L_0x0048:
            java.lang.Object r3 = r8.convertAnother(r1, r3)
        L_0x004c:
            r2.put(r4, r3)
            r7.moveUp()
            boolean r3 = r7.hasMoreChildren()
            if (r3 != 0) goto L_0x0023
            goto L_0x0068
        L_0x0059:
            java.lang.Class<java.util.Map> r0 = java.util.Map.class
            java.lang.Object r0 = r8.convertAnother(r1, r0)
            r2 = r0
            java.util.Map r2 = (java.util.Map) r2
            r7.moveUp()
            goto L_0x0068
        L_0x0066:
            java.util.Map r2 = java.util.Collections.EMPTY_MAP
        L_0x0068:
            boolean r7 = com.thoughtworks.xstream.core.JVM.is16()
            if (r7 != 0) goto L_0x0086
            java.util.Collection r7 = r2.values()
            java.util.Iterator r7 = r7.iterator()
        L_0x0076:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0086
            java.lang.Object r0 = r7.next()
            if (r0 != 0) goto L_0x0076
            r7.remove()
            goto L_0x0076
        L_0x0086:
            java.awt.Font r7 = java.awt.Font.getFont(r2)
            java.lang.Class r8 = r8.getRequiredType()
            java.lang.Class<javax.swing.plaf.FontUIResource> r0 = javax.swing.plaf.FontUIResource.class
            if (r8 != r0) goto L_0x0098
            javax.swing.plaf.FontUIResource r8 = new javax.swing.plaf.FontUIResource
            r8.<init>(r7)
            return r8
        L_0x0098:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.converters.extended.FontConverter.unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext):java.lang.Object");
    }
}
