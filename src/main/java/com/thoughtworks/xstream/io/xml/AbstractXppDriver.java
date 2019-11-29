package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.core.util.XmlHeaderAwareReader;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.naming.NameCoder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public abstract class AbstractXppDriver extends AbstractXmlDriver {
    /* access modifiers changed from: protected */
    public abstract XmlPullParser createParser() throws XmlPullParserException;

    public AbstractXppDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    public HierarchicalStreamReader createReader(Reader reader) {
        try {
            return new XppReader(reader, createParser(), getNameCoder());
        } catch (XmlPullParserException unused) {
            throw new StreamException("Cannot create XmlPullParser");
        }
    }

    public HierarchicalStreamReader createReader(InputStream inputStream) {
        try {
            return createReader((Reader) new XmlHeaderAwareReader(inputStream));
        } catch (UnsupportedEncodingException e2) {
            throw new StreamException((Throwable) e2);
        } catch (IOException e3) {
            throw new StreamException((Throwable) e3);
        }
    }

    public HierarchicalStreamWriter createWriter(Writer writer) {
        return new PrettyPrintWriter(writer, getNameCoder());
    }

    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        return createWriter((Writer) new OutputStreamWriter(outputStream));
    }
}
