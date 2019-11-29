package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.naming.NameCoder;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxReader extends AbstractPullReader {
    private final XMLStreamReader in;
    private final QNameMap qnameMap;

    public StaxReader(QNameMap qNameMap, XMLStreamReader xMLStreamReader) {
        this(qNameMap, xMLStreamReader, (NameCoder) new XmlFriendlyNameCoder());
    }

    public StaxReader(QNameMap qNameMap, XMLStreamReader xMLStreamReader, NameCoder nameCoder) {
        super(nameCoder);
        this.qnameMap = qNameMap;
        this.in = xMLStreamReader;
        moveDown();
    }

    public StaxReader(QNameMap qNameMap, XMLStreamReader xMLStreamReader, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(qNameMap, xMLStreamReader, (NameCoder) xmlFriendlyReplacer);
    }

    /* access modifiers changed from: protected */
    public int pullNextEvent() {
        try {
            int next = this.in.next();
            if (next != 1) {
                if (next != 2) {
                    if (next == 4) {
                        return 3;
                    }
                    if (next == 5) {
                        return 4;
                    }
                    if (next != 7) {
                        if (next != 8) {
                            return 0;
                        }
                    }
                }
                return 2;
            }
            return 1;
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    /* access modifiers changed from: protected */
    public String pullElementName() {
        return this.qnameMap.getJavaClassName(this.in.getName());
    }

    /* access modifiers changed from: protected */
    public String pullText() {
        return this.in.getText();
    }

    public String getAttribute(String str) {
        return this.in.getAttributeValue((String) null, encodeAttribute(str));
    }

    public String getAttribute(int i) {
        return this.in.getAttributeValue(i);
    }

    public int getAttributeCount() {
        return this.in.getAttributeCount();
    }

    public String getAttributeName(int i) {
        return decodeAttribute(this.in.getAttributeLocalName(i));
    }

    public void appendErrors(ErrorWriter errorWriter) {
        errorWriter.add("line number", String.valueOf(this.in.getLocation().getLineNumber()));
    }

    public void close() {
        try {
            this.in.close();
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }
}
