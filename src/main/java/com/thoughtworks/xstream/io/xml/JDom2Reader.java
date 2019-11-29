package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.naming.NameCoder;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

public class JDom2Reader extends AbstractDocumentReader {
    private Element currentElement;

    public JDom2Reader(Element element) {
        super(element);
    }

    public JDom2Reader(Document document) {
        super(document.getRootElement());
    }

    public JDom2Reader(Element element, NameCoder nameCoder) {
        super((Object) element, nameCoder);
    }

    public JDom2Reader(Document document, NameCoder nameCoder) {
        super((Object) document.getRootElement(), nameCoder);
    }

    /* access modifiers changed from: protected */
    public void reassignCurrentElement(Object obj) {
        this.currentElement = (Element) obj;
    }

    /* access modifiers changed from: protected */
    public Object getParent() {
        return this.currentElement.getParentElement();
    }

    /* access modifiers changed from: protected */
    public Object getChild(int i) {
        return this.currentElement.getChildren().get(i);
    }

    /* access modifiers changed from: protected */
    public int getChildCount() {
        return this.currentElement.getChildren().size();
    }

    public String getNodeName() {
        return decodeNode(this.currentElement.getName());
    }

    public String getValue() {
        return this.currentElement.getText();
    }

    public String getAttribute(String str) {
        return this.currentElement.getAttributeValue(encodeAttribute(str));
    }

    public String getAttribute(int i) {
        return ((Attribute) this.currentElement.getAttributes().get(i)).getValue();
    }

    public int getAttributeCount() {
        return this.currentElement.getAttributes().size();
    }

    public String getAttributeName(int i) {
        return decodeAttribute(((Attribute) this.currentElement.getAttributes().get(i)).getQualifiedName());
    }

    public String peekNextChild() {
        List children = this.currentElement.getChildren();
        if (children == null || children.isEmpty()) {
            return null;
        }
        return decodeNode(((Element) children.get(0)).getName());
    }
}
