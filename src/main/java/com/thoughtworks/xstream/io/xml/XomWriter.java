package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.naming.NameCoder;
import nu.xom.Attribute;
import nu.xom.Element;

public class XomWriter extends AbstractDocumentWriter {
    public XomWriter() {
        this((Element) null);
    }

    public XomWriter(Element element) {
        this(element, (NameCoder) new XmlFriendlyNameCoder());
    }

    public XomWriter(Element element, NameCoder nameCoder) {
        super((Object) element, nameCoder);
    }

    public XomWriter(Element element, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(element, (NameCoder) xmlFriendlyReplacer);
    }

    /* access modifiers changed from: protected */
    public Object createNode(String str) {
        Element element = new Element(encodeNode(str));
        if (top() != null) {
            top().appendChild(element);
        }
        return element;
    }

    public void addAttribute(String str, String str2) {
        top().addAttribute(new Attribute(encodeAttribute(str), str2));
    }

    public void setValue(String str) {
        top().appendChild(str);
    }

    private Element top() {
        return (Element) getCurrent();
    }
}
