package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.xml.xppdom.XppDom;

public class XppDomWriter extends AbstractDocumentWriter {
    public XppDomWriter() {
        this((XppDom) null, (NameCoder) new XmlFriendlyNameCoder());
    }

    public XppDomWriter(XppDom xppDom) {
        this(xppDom, (NameCoder) new XmlFriendlyNameCoder());
    }

    public XppDomWriter(NameCoder nameCoder) {
        this((XppDom) null, nameCoder);
    }

    public XppDomWriter(XppDom xppDom, NameCoder nameCoder) {
        super((Object) xppDom, nameCoder);
    }

    public XppDomWriter(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((XppDom) null, xmlFriendlyReplacer);
    }

    public XppDomWriter(XppDom xppDom, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(xppDom, (NameCoder) xmlFriendlyReplacer);
    }

    public XppDom getConfiguration() {
        return (XppDom) getTopLevelNodes().get(0);
    }

    /* access modifiers changed from: protected */
    public Object createNode(String str) {
        XppDom xppDom = new XppDom(encodeNode(str));
        if (top() != null) {
            top().addChild(xppDom);
        }
        return xppDom;
    }

    public void setValue(String str) {
        top().setValue(str);
    }

    public void addAttribute(String str, String str2) {
        top().setAttribute(encodeAttribute(str), str2);
    }

    private XppDom top() {
        return (XppDom) getCurrent();
    }
}
