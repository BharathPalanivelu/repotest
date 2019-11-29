package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.io.naming.NameCoder;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;

public class Dom4JReader extends AbstractDocumentReader {
    private Element currentElement;

    public Dom4JReader(Element element) {
        this(element, (NameCoder) new XmlFriendlyNameCoder());
    }

    public Dom4JReader(Document document) {
        this(document.getRootElement());
    }

    public Dom4JReader(Element element, NameCoder nameCoder) {
        super((Object) element, nameCoder);
    }

    public Dom4JReader(Document document, NameCoder nameCoder) {
        this(document.getRootElement(), nameCoder);
    }

    public Dom4JReader(Element element, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(element, (NameCoder) xmlFriendlyReplacer);
    }

    public Dom4JReader(Document document, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(document.getRootElement(), (NameCoder) xmlFriendlyReplacer);
    }

    public String getNodeName() {
        return decodeNode(this.currentElement.getName());
    }

    public String getValue() {
        return this.currentElement.getText();
    }

    public String getAttribute(String str) {
        return this.currentElement.attributeValue(encodeAttribute(str));
    }

    public String getAttribute(int i) {
        return this.currentElement.attribute(i).getValue();
    }

    public int getAttributeCount() {
        return this.currentElement.attributeCount();
    }

    public String getAttributeName(int i) {
        return decodeAttribute(this.currentElement.attribute(i).getQualifiedName());
    }

    /* access modifiers changed from: protected */
    public Object getParent() {
        return this.currentElement.getParent();
    }

    /* access modifiers changed from: protected */
    public Object getChild(int i) {
        return this.currentElement.elements().get(i);
    }

    /* access modifiers changed from: protected */
    public int getChildCount() {
        return this.currentElement.elements().size();
    }

    /* access modifiers changed from: protected */
    public void reassignCurrentElement(Object obj) {
        this.currentElement = (Element) obj;
    }

    public String peekNextChild() {
        List elements = this.currentElement.elements();
        if (elements == null || elements.isEmpty()) {
            return null;
        }
        return decodeNode(((Element) elements.get(0)).getName());
    }

    public void appendErrors(ErrorWriter errorWriter) {
        errorWriter.add("xpath", this.currentElement.getPath());
    }
}
