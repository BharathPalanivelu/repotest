package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.naming.NameCoder;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

public class StandardStaxDriver extends StaxDriver {
    public StandardStaxDriver() {
    }

    public StandardStaxDriver(QNameMap qNameMap, XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super(qNameMap, (NameCoder) xmlFriendlyNameCoder);
    }

    public StandardStaxDriver(QNameMap qNameMap, NameCoder nameCoder) {
        super(qNameMap, nameCoder);
    }

    public StandardStaxDriver(QNameMap qNameMap) {
        super(qNameMap);
    }

    public StandardStaxDriver(XmlFriendlyNameCoder xmlFriendlyNameCoder) {
        super((NameCoder) xmlFriendlyNameCoder);
    }

    public StandardStaxDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    /* access modifiers changed from: protected */
    public XMLInputFactory createInputFactory() {
        try {
            Class staxInputFactory = JVM.getStaxInputFactory();
            if (staxInputFactory != null) {
                return (XMLInputFactory) staxInputFactory.newInstance();
            }
            throw new StreamException("Java runtime has no standard XMLInputFactory implementation.", (Throwable) null);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new StreamException("Cannot create standard XMLInputFactory instance of Java runtime.", e2);
        }
    }

    /* access modifiers changed from: protected */
    public XMLOutputFactory createOutputFactory() {
        try {
            Class staxOutputFactory = JVM.getStaxOutputFactory();
            if (staxOutputFactory != null) {
                return (XMLOutputFactory) staxOutputFactory.newInstance();
            }
            throw new StreamException("Java runtime has no standard XMLOutputFactory implementation.", (Throwable) null);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new StreamException("Cannot create standard XMLOutputFactory instance of Java runtime.", e2);
        }
    }
}
