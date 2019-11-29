package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.naming.NameCoder;
import org.dom4j.Branch;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;

public class Dom4JWriter extends AbstractDocumentWriter {
    private final DocumentFactory documentFactory;

    public Dom4JWriter(Branch branch, DocumentFactory documentFactory2, NameCoder nameCoder) {
        super((Object) branch, nameCoder);
        this.documentFactory = documentFactory2;
    }

    public Dom4JWriter(DocumentFactory documentFactory2, NameCoder nameCoder) {
        this((Branch) null, documentFactory2, nameCoder);
    }

    public Dom4JWriter(Branch branch, NameCoder nameCoder) {
        this(branch, new DocumentFactory(), nameCoder);
    }

    public Dom4JWriter(Branch branch, DocumentFactory documentFactory2, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(branch, documentFactory2, (NameCoder) xmlFriendlyReplacer);
    }

    public Dom4JWriter(DocumentFactory documentFactory2, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((Branch) null, documentFactory2, (NameCoder) xmlFriendlyReplacer);
    }

    public Dom4JWriter(DocumentFactory documentFactory2) {
        this(documentFactory2, (NameCoder) new XmlFriendlyNameCoder());
    }

    public Dom4JWriter(Branch branch, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(branch, new DocumentFactory(), (NameCoder) xmlFriendlyReplacer);
    }

    public Dom4JWriter(Branch branch) {
        this(branch, new DocumentFactory(), (NameCoder) new XmlFriendlyNameCoder());
    }

    public Dom4JWriter() {
        this(new DocumentFactory(), (NameCoder) new XmlFriendlyNameCoder());
    }

    /* access modifiers changed from: protected */
    public Object createNode(String str) {
        Element createElement = this.documentFactory.createElement(encodeNode(str));
        if (top() != null) {
            top().add(createElement);
        }
        return createElement;
    }

    public void setValue(String str) {
        top().setText(str);
    }

    public void addAttribute(String str, String str2) {
        top().addAttribute(encodeAttribute(str), str2);
    }

    private Branch top() {
        return (Branch) getCurrent();
    }
}
