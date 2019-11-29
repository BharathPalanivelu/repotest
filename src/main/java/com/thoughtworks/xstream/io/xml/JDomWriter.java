package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.naming.NameCoder;
import org.jdom.DefaultJDOMFactory;
import org.jdom.Element;
import org.jdom.JDOMFactory;

public class JDomWriter extends AbstractDocumentWriter {
    private final JDOMFactory documentFactory;

    public JDomWriter(Element element, JDOMFactory jDOMFactory, NameCoder nameCoder) {
        super((Object) element, nameCoder);
        this.documentFactory = jDOMFactory;
    }

    public JDomWriter(Element element, JDOMFactory jDOMFactory, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(element, jDOMFactory, (NameCoder) xmlFriendlyReplacer);
    }

    public JDomWriter(Element element, JDOMFactory jDOMFactory) {
        this(element, jDOMFactory, (NameCoder) new XmlFriendlyNameCoder());
    }

    public JDomWriter(JDOMFactory jDOMFactory, NameCoder nameCoder) {
        this((Element) null, jDOMFactory, nameCoder);
    }

    public JDomWriter(JDOMFactory jDOMFactory, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((Element) null, jDOMFactory, (NameCoder) xmlFriendlyReplacer);
    }

    public JDomWriter(JDOMFactory jDOMFactory) {
        this((Element) null, jDOMFactory);
    }

    public JDomWriter(Element element, NameCoder nameCoder) {
        this(element, (JDOMFactory) new DefaultJDOMFactory(), nameCoder);
    }

    public JDomWriter(Element element, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(element, (JDOMFactory) new DefaultJDOMFactory(), (NameCoder) xmlFriendlyReplacer);
    }

    public JDomWriter(Element element) {
        this(element, (JDOMFactory) new DefaultJDOMFactory());
    }

    public JDomWriter() {
        this((JDOMFactory) new DefaultJDOMFactory());
    }

    /* access modifiers changed from: protected */
    public Object createNode(String str) {
        Element element = this.documentFactory.element(encodeNode(str));
        Element pVar = top();
        if (pVar != null) {
            pVar.addContent(element);
        }
        return element;
    }

    public void setValue(String str) {
        top().addContent(this.documentFactory.text(str));
    }

    public void addAttribute(String str, String str2) {
        top().setAttribute(this.documentFactory.attribute(encodeAttribute(str), str2));
    }

    private Element top() {
        return (Element) getCurrent();
    }
}
