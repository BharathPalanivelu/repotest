package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.naming.NameCoder;
import java.io.IOException;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XppReader extends AbstractPullReader {
    private final XmlPullParser parser;
    private final Reader reader;

    public XppReader(Reader reader2, XmlPullParser xmlPullParser) {
        this(reader2, xmlPullParser, new XmlFriendlyNameCoder());
    }

    public XppReader(Reader reader2, XmlPullParser xmlPullParser, NameCoder nameCoder) {
        super(nameCoder);
        this.parser = xmlPullParser;
        this.reader = reader2;
        try {
            xmlPullParser.setInput(this.reader);
            moveDown();
        } catch (XmlPullParserException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public XppReader(Reader reader2) {
        this(reader2, new XmlFriendlyReplacer());
    }

    public XppReader(Reader reader2, XmlFriendlyReplacer xmlFriendlyReplacer) {
        super(xmlFriendlyReplacer);
        try {
            this.parser = createParser();
            this.reader = reader2;
            this.parser.setInput(this.reader);
            moveDown();
        } catch (XmlPullParserException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    /* access modifiers changed from: protected */
    public XmlPullParser createParser() {
        try {
            return (XmlPullParser) Class.forName("org.xmlpull.mxp1.MXParser", true, XmlPullParser.class.getClassLoader()).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new StreamException("Cannot create Xpp3 parser instance.", e2);
        }
    }

    /* access modifiers changed from: protected */
    public int pullNextEvent() {
        try {
            int next = this.parser.next();
            if (next != 0) {
                if (next != 1) {
                    if (next != 2) {
                        if (next != 3) {
                            if (next != 4) {
                                return next != 9 ? 0 : 4;
                            }
                            return 3;
                        }
                    }
                }
                return 2;
            }
            return 1;
        } catch (XmlPullParserException e2) {
            throw new StreamException((Throwable) e2);
        } catch (IOException e3) {
            throw new StreamException((Throwable) e3);
        }
    }

    /* access modifiers changed from: protected */
    public String pullElementName() {
        return this.parser.getName();
    }

    /* access modifiers changed from: protected */
    public String pullText() {
        return this.parser.getText();
    }

    public String getAttribute(String str) {
        return this.parser.getAttributeValue((String) null, encodeAttribute(str));
    }

    public String getAttribute(int i) {
        return this.parser.getAttributeValue(i);
    }

    public int getAttributeCount() {
        return this.parser.getAttributeCount();
    }

    public String getAttributeName(int i) {
        return decodeAttribute(this.parser.getAttributeName(i));
    }

    public void appendErrors(ErrorWriter errorWriter) {
        errorWriter.add("line number", String.valueOf(this.parser.getLineNumber()));
    }

    public void close() {
        try {
            this.reader.close();
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        }
    }
}
