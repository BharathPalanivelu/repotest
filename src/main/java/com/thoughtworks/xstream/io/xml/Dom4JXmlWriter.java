package com.thoughtworks.xstream.io.xml;

import com.salesforce.android.chat.core.model.PreChatField;
import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.naming.NameCoder;
import java.io.IOException;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultElement;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class Dom4JXmlWriter extends AbstractXmlWriter {
    private AttributesImpl attributes;
    private boolean children;
    private final FastStack elementStack;
    private boolean started;
    private final XMLWriter writer;

    public Dom4JXmlWriter(XMLWriter xMLWriter) {
        this(xMLWriter, (NameCoder) new XmlFriendlyNameCoder());
    }

    public Dom4JXmlWriter(XMLWriter xMLWriter, NameCoder nameCoder) {
        super(nameCoder);
        this.writer = xMLWriter;
        this.elementStack = new FastStack(16);
        this.attributes = new AttributesImpl();
        try {
            xMLWriter.startDocument();
        } catch (SAXException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public Dom4JXmlWriter(XMLWriter xMLWriter, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(xMLWriter, (NameCoder) xmlFriendlyReplacer);
    }

    public void startNode(String str) {
        if (this.elementStack.size() > 0) {
            try {
                startElement();
                this.started = false;
            } catch (SAXException e2) {
                throw new StreamException((Throwable) e2);
            }
        }
        this.elementStack.push(encodeNode(str));
        this.children = false;
    }

    public void setValue(String str) {
        char[] charArray = str.toCharArray();
        if (charArray.length > 0) {
            try {
                startElement();
                this.writer.characters(charArray, 0, charArray.length);
                this.children = true;
            } catch (SAXException e2) {
                throw new StreamException((Throwable) e2);
            }
        }
    }

    public void addAttribute(String str, String str2) {
        this.attributes.addAttribute("", "", encodeAttribute(str), PreChatField.STRING, str2);
    }

    public void endNode() {
        try {
            if (!this.children) {
                DefaultElement defaultElement = new DefaultElement((String) this.elementStack.pop());
                for (int i = 0; i < this.attributes.getLength(); i++) {
                    defaultElement.addAttribute(this.attributes.getQName(i), this.attributes.getValue(i));
                }
                this.writer.write(defaultElement);
                this.attributes.clear();
                this.children = true;
                this.started = true;
                return;
            }
            startElement();
            this.writer.endElement("", "", (String) this.elementStack.pop());
        } catch (SAXException e2) {
            throw new StreamException((Throwable) e2);
        } catch (IOException e3) {
            throw new StreamException((Throwable) e3);
        }
    }

    public void flush() {
        try {
            this.writer.flush();
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public void close() {
        try {
            this.writer.endDocument();
        } catch (SAXException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    private void startElement() throws SAXException {
        if (!this.started) {
            this.writer.startElement("", "", (String) this.elementStack.peek(), this.attributes);
            this.attributes.clear();
            this.started = true;
        }
    }
}
