package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.AbstractReader;
import com.thoughtworks.xstream.io.naming.NameCoder;

public abstract class AbstractXmlReader extends AbstractReader {
    protected AbstractXmlReader() {
        this((NameCoder) new XmlFriendlyNameCoder());
    }

    protected AbstractXmlReader(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((NameCoder) xmlFriendlyReplacer);
    }

    protected AbstractXmlReader(NameCoder nameCoder) {
        super(nameCoder);
    }

    public String unescapeXmlName(String str) {
        return decodeNode(str);
    }

    /* access modifiers changed from: protected */
    public String escapeXmlName(String str) {
        return encodeNode(str);
    }
}
