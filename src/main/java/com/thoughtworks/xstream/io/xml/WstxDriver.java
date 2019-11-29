package com.thoughtworks.xstream.io.xml;

import com.ctc.wstx.stax.WstxInputFactory;
import com.ctc.wstx.stax.WstxOutputFactory;
import com.thoughtworks.xstream.io.naming.NameCoder;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

public class WstxDriver extends StaxDriver {
    public WstxDriver() {
    }

    public WstxDriver(QNameMap qNameMap, XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super(qNameMap, (NameCoder) xmlFriendlyNameCoder);
    }

    public WstxDriver(QNameMap qNameMap, NameCoder nameCoder) {
        super(qNameMap, nameCoder);
    }

    public WstxDriver(QNameMap qNameMap) {
        super(qNameMap);
    }

    public WstxDriver(XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super((NameCoder) xmlFriendlyNameCoder);
    }

    public WstxDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    /* access modifiers changed from: protected */
    public XMLInputFactory createInputFactory() {
        return new WstxInputFactory();
    }

    /* access modifiers changed from: protected */
    public XMLOutputFactory createOutputFactory() {
        return new WstxOutputFactory();
    }
}
