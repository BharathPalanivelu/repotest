package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.AbstractWriter;
import com.thoughtworks.xstream.io.naming.NameCoder;

public abstract class AbstractXmlWriter extends AbstractWriter implements XmlFriendlyWriter {
    protected AbstractXmlWriter() {
        this((NameCoder) new XmlFriendlyNameCoder());
    }

    protected AbstractXmlWriter(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((NameCoder) xmlFriendlyReplacer);
    }

    protected AbstractXmlWriter(NameCoder nameCoder) {
        super(nameCoder);
    }

    public String escapeXmlName(String str) {
        return super.encodeNode(str);
    }
}
