package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.naming.NameCoder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomWriter extends AbstractDocumentWriter {
    private final Document document;
    private boolean hasRootElement;

    public DomWriter(Document document2) {
        this(document2, (NameCoder) new XmlFriendlyNameCoder());
    }

    public DomWriter(Element element) {
        this(element, (NameCoder) new XmlFriendlyNameCoder());
    }

    public DomWriter(Document document2, NameCoder nameCoder) {
        this(document2.getDocumentElement(), document2, nameCoder);
    }

    public DomWriter(Element element, Document document2, NameCoder nameCoder) {
        super((Object) element, nameCoder);
        this.document = document2;
        this.hasRootElement = document2.getDocumentElement() != null;
    }

    public DomWriter(Element element, NameCoder nameCoder) {
        this(element, element.getOwnerDocument(), nameCoder);
    }

    public DomWriter(Document document2, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(document2.getDocumentElement(), document2, (NameCoder) xmlFriendlyReplacer);
    }

    public DomWriter(Element element, Document document2, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(element, document2, (NameCoder) xmlFriendlyReplacer);
    }

    public DomWriter(Element element, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(element, element.getOwnerDocument(), (NameCoder) xmlFriendlyReplacer);
    }

    /* access modifiers changed from: protected */
    public Object createNode(String str) {
        Element createElement = this.document.createElement(encodeNode(str));
        if (top() != null) {
            top().appendChild(createElement);
        } else if (!this.hasRootElement) {
            this.document.appendChild(createElement);
            this.hasRootElement = true;
        }
        return createElement;
    }

    public void addAttribute(String str, String str2) {
        top().setAttribute(encodeAttribute(str), str2);
    }

    public void setValue(String str) {
        top().appendChild(this.document.createTextNode(str));
    }

    private Element top() {
        return (Element) getCurrent();
    }
}
