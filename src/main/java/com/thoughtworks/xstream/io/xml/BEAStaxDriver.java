package com.thoughtworks.xstream.io.xml;

import com.bea.xml.stream.MXParserFactory;
import com.bea.xml.stream.XMLOutputFactoryBase;
import com.thoughtworks.xstream.io.naming.NameCoder;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

public class BEAStaxDriver extends StaxDriver {
    public BEAStaxDriver() {
    }

    public BEAStaxDriver(QNameMap qNameMap, XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super(qNameMap, (NameCoder) xmlFriendlyNameCoder);
    }

    public BEAStaxDriver(QNameMap qNameMap, NameCoder nameCoder) {
        super(qNameMap, nameCoder);
    }

    public BEAStaxDriver(QNameMap qNameMap) {
        super(qNameMap);
    }

    public BEAStaxDriver(XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super((NameCoder) xmlFriendlyNameCoder);
    }

    public BEAStaxDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    /* access modifiers changed from: protected */
    public XMLInputFactory createInputFactory() {
        return new MXParserFactory();
    }

    /* access modifiers changed from: protected */
    public XMLOutputFactory createOutputFactory() {
        return new XMLOutputFactoryBase();
    }
}
