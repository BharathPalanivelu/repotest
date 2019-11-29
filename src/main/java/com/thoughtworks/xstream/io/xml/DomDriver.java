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
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DomDriver extends AbstractXmlDriver {
    private final DocumentBuilderFactory documentBuilderFactory;
    private final String encoding;

    public DomDriver() {
        this((String) null);
    }

    public DomDriver(String str) {
        this(str, (NameCoder) new XmlFriendlyNameCoder());
    }

    public DomDriver(String str, NameCoder nameCoder) {
        super(nameCoder);
        this.documentBuilderFactory = DocumentBuilderFactory.newInstance();
        this.encoding = str;
    }

    public DomDriver(String str, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(str, (NameCoder) xmlFriendlyReplacer);
    }

    public HierarchicalStreamReader createReader(Reader reader) {
        return createReader(new InputSource(reader));
    }

    public HierarchicalStreamReader createReader(InputStream inputStream) {
        return createReader(new InputSource(inputStream));
    }

    public HierarchicalStreamReader createReader(URL url) {
        return createReader(new InputSource(url.toExternalForm()));
    }

    public HierarchicalStreamReader createReader(File file) {
        return createReader(new InputSource(file.toURI().toASCIIString()));
    }

    private HierarchicalStreamReader createReader(InputSource inputSource) {
        try {
            DocumentBuilder newDocumentBuilder = this.documentBuilderFactory.newDocumentBuilder();
            if (this.encoding != null) {
                inputSource.setEncoding(this.encoding);
            }
            return new DomReader(newDocumentBuilder.parse(inputSource), getNameCoder());
        } catch (FactoryConfigurationError e2) {
            throw new StreamException((Throwable) e2);
        } catch (ParserConfigurationException e3) {
            throw new StreamException((Throwable) e3);
        } catch (SAXException e4) {
            throw new StreamException((Throwable) e4);
        } catch (IOException e5) {
            throw new StreamException((Throwable) e5);
        }
    }

    public HierarchicalStreamWriter createWriter(Writer writer) {
        return new PrettyPrintWriter(writer, getNameCoder());
    }

    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        try {
            return createWriter((Writer) this.encoding != null ? new OutputStreamWriter(outputStream, this.encoding) : new OutputStreamWriter(outputStream));
        } catch (UnsupportedEncodingException e2) {
            throw new StreamException((Throwable) e2);
        }
    }
}
