package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.naming.NameCoder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class JDomDriver extends AbstractXmlDriver {
    public JDomDriver() {
        super((NameCoder) new XmlFriendlyNameCoder());
    }

    public JDomDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    public JDomDriver(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((NameCoder) xmlFriendlyReplacer);
    }

    public HierarchicalStreamReader createReader(Reader reader) {
        try {
            return new JDomReader(new SAXBuilder().build(reader), getNameCoder());
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        } catch (JDOMException e3) {
            throw new StreamException((Throwable) e3);
        }
    }

    public HierarchicalStreamReader createReader(InputStream inputStream) {
        try {
            return new JDomReader(new SAXBuilder().build(inputStream), getNameCoder());
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        } catch (JDOMException e3) {
            throw new StreamException((Throwable) e3);
        }
    }

    public HierarchicalStreamReader createReader(URL url) {
        try {
            return new JDomReader(new SAXBuilder().build(url), getNameCoder());
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        } catch (JDOMException e3) {
            throw new StreamException((Throwable) e3);
        }
    }

    public HierarchicalStreamReader createReader(File file) {
        try {
            return new JDomReader(new SAXBuilder().build(file), getNameCoder());
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        } catch (JDOMException e3) {
            throw new StreamException((Throwable) e3);
        }
    }

    public HierarchicalStreamWriter createWriter(Writer writer) {
        return new PrettyPrintWriter(writer, getNameCoder());
    }

    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        return new PrettyPrintWriter(new OutputStreamWriter(outputStream));
    }
}
