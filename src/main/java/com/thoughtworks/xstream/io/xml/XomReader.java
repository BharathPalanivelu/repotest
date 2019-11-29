package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.naming.NameCoder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.Text;

public class XomReader extends AbstractDocumentReader {
    private Element currentElement;

    public XomReader(Element element) {
        super(element);
    }

    public XomReader(Document document) {
        super(document.getRootElement());
    }

    public XomReader(Element element, NameCoder nameCoder) {
        super((Object) element, nameCoder);
    }

    public XomReader(Document document, NameCoder nameCoder) {
        super((Object) document.getRootElement(), nameCoder);
    }

    public XomReader(Element element, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(element, (NameCoder) xmlFriendlyReplacer);
    }

    public XomReader(Document document, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(document.getRootElement(), (NameCoder) xmlFriendlyReplacer);
    }

    public String getNodeName() {
        return decodeNode(this.currentElement.getLocalName());
    }

    public String getValue() {
        StringBuffer stringBuffer = new StringBuffer();
        int childCount = this.currentElement.getChildCount();
        for (int i = 0; i < childCount; i++) {
            Text child = this.currentElement.getChild(i);
            if (child instanceof Text) {
                stringBuffer.append(child.getValue());
            }
        }
        return stringBuffer.toString();
    }

    public String getAttribute(String str) {
        return this.currentElement.getAttributeValue(encodeAttribute(str));
    }

    public String getAttribute(int i) {
        return this.currentElement.getAttribute(i).getValue();
    }

    public int getAttributeCount() {
        return this.currentElement.getAttributeCount();
    }

    public String getAttributeName(int i) {
        return decodeAttribute(this.currentElement.getAttribute(i).getQualifiedName());
    }

    /* access modifiers changed from: protected */
    public int getChildCount() {
        return this.currentElement.getChildElements().size();
    }

    /* access modifiers changed from: protected */
    public Object getParent() {
        return this.currentElement.getParent();
    }

    /* access modifiers changed from: protected */
    public Object getChild(int i) {
        return this.currentElement.getChildElements().get(i);
    }

    /* access modifiers changed from: protected */
    public void reassignCurrentElement(Object obj) {
        this.currentElement = (Element) obj;
    }

    public String peekNextChild() {
        Elements childElements = this.currentElement.getChildElements();
        if (childElements == null || childElements.size() == 0) {
            return null;
        }
        return decodeNode(childElements.get(0).getLocalName());
    }
}
