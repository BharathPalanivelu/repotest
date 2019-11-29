package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.xml.xppdom.XppDom;

public class XppDomReader extends AbstractDocumentReader {
    private XppDom currentElement;

    public XppDomReader(XppDom xppDom) {
        super(xppDom);
    }

    public XppDomReader(XppDom xppDom, NameCoder nameCoder) {
        super((Object) xppDom, nameCoder);
    }

    public XppDomReader(XppDom xppDom, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(xppDom, (NameCoder) xmlFriendlyReplacer);
    }

    public String getNodeName() {
        return decodeNode(this.currentElement.getName());
    }

    public String getValue() {
        String str;
        try {
            str = this.currentElement.getValue();
        } catch (Exception unused) {
            str = null;
        }
        return str == null ? "" : str;
    }

    public String getAttribute(String str) {
        return this.currentElement.getAttribute(encodeAttribute(str));
    }

    public String getAttribute(int i) {
        XppDom xppDom = this.currentElement;
        return xppDom.getAttribute(xppDom.getAttributeNames()[i]);
    }

    public int getAttributeCount() {
        return this.currentElement.getAttributeNames().length;
    }

    public String getAttributeName(int i) {
        return decodeAttribute(this.currentElement.getAttributeNames()[i]);
    }

    /* access modifiers changed from: protected */
    public Object getParent() {
        return this.currentElement.getParent();
    }

    /* access modifiers changed from: protected */
    public Object getChild(int i) {
        return this.currentElement.getChild(i);
    }

    /* access modifiers changed from: protected */
    public int getChildCount() {
        return this.currentElement.getChildCount();
    }

    /* access modifiers changed from: protected */
    public void reassignCurrentElement(Object obj) {
        this.currentElement = (XppDom) obj;
    }

    public String peekNextChild() {
        if (this.currentElement.getChildCount() == 0) {
            return null;
        }
        return decodeNode(this.currentElement.getChild(0).getName());
    }
}
