package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.naming.NameCoder;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

public class SjsxpDriver extends StaxDriver {
    public SjsxpDriver() {
    }

    public SjsxpDriver(QNameMap qNameMap, XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super(qNameMap, (NameCoder) xmlFriendlyNameCoder);
    }

    public SjsxpDriver(QNameMap qNameMap) {
        super(qNameMap);
    }

    public SjsxpDriver(XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super((NameCoder) xmlFriendlyNameCoder);
    }

    /* access modifiers changed from: protected */
    public XMLInputFactory createInputFactory() {
        try {
            return Class.forName("com.sun.xml.internal.stream.XMLInputFactoryImpl").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new StreamException("Cannot create SJSXP (Sun JDK 6 StAX) XMLInputFaqctory instance.", e2);
        }
    }

    /* access modifiers changed from: protected */
    public XMLOutputFactory createOutputFactory() {
        try {
            return Class.forName("com.sun.xml.internal.stream.XMLOutputFactoryImpl").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new StreamException("Cannot create SJSXP (Sun JDK 6 StAX) XMLOutputFaqctory instance.", e2);
        }
    }
}
