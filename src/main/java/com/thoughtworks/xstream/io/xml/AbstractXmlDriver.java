package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.AbstractDriver;
import com.thoughtworks.xstream.io.naming.NameCoder;

public abstract class AbstractXmlDriver extends AbstractDriver {
    public AbstractXmlDriver() {
        this((NameCoder) new XmlFriendlyNameCoder());
    }

    public AbstractXmlDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    public AbstractXmlDriver(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((NameCoder) xmlFriendlyReplacer);
    }

    /* access modifiers changed from: protected */
    public XmlFriendlyReplacer xmlFriendlyReplacer() {
        NameCoder nameCoder = getNameCoder();
        if (nameCoder instanceof XmlFriendlyReplacer) {
            return (XmlFriendlyReplacer) nameCoder;
        }
        return null;
    }
}
