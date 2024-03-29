package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.naming.NameCoder;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class DomReader extends AbstractDocumentReader {
    private List childElements;
    private Element currentElement;
    private StringBuffer textBuffer;

    public DomReader(Element element) {
        this(element, (NameCoder) new XmlFriendlyNameCoder());
    }

    public DomReader(Document document) {
        this(document.getDocumentElement());
    }

    public DomReader(Element element, NameCoder nameCoder) {
        super((Object) element, nameCoder);
        this.textBuffer = new StringBuffer();
    }

    public DomReader(Document document, NameCoder nameCoder) {
        this(document.getDocumentElement(), nameCoder);
    }

    public DomReader(Element element, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(element, (NameCoder) xmlFriendlyReplacer);
    }

    public DomReader(Document document, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(document.getDocumentElement(), (NameCoder) xmlFriendlyReplacer);
    }

    public String getNodeName() {
        return decodeNode(this.currentElement.getTagName());
    }

    public String getValue() {
        NodeList childNodes = this.currentElement.getChildNodes();
        this.textBuffer.setLength(0);
        int length = childNodes.getLength();
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item instanceof Text) {
                this.textBuffer.append(((Text) item).getData());
            }
        }
        return this.textBuffer.toString();
    }

    public String getAttribute(String str) {
        Attr attributeNode = this.currentElement.getAttributeNode(encodeAttribute(str));
        if (attributeNode == null) {
            return null;
        }
        return attributeNode.getValue();
    }

    public String getAttribute(int i) {
        return ((Attr) this.currentElement.getAttributes().item(i)).getValue();
    }

    public int getAttributeCount() {
        return this.currentElement.getAttributes().getLength();
    }

    public String getAttributeName(int i) {
        return decodeAttribute(((Attr) this.currentElement.getAttributes().item(i)).getName());
    }

    /* access modifiers changed from: protected */
    public Object getParent() {
        return this.currentElement.getParentNode();
    }

    /* access modifiers changed from: protected */
    public Object getChild(int i) {
        return this.childElements.get(i);
    }

    /* access modifiers changed from: protected */
    public int getChildCount() {
        return this.childElements.size();
    }

    /* access modifiers changed from: protected */
    public void reassignCurrentElement(Object obj) {
        this.currentElement = (Element) obj;
        NodeList childNodes = this.currentElement.getChildNodes();
        this.childElements = new ArrayList();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item instanceof Element) {
                this.childElements.add(item);
            }
        }
    }

    public String peekNextChild() {
        NodeList childNodes = this.currentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item instanceof Element) {
                return decodeNode(((Element) item).getTagName());
            }
        }
        return null;
    }
}
