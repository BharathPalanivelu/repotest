package com.thoughtworks.xstream.io.xml;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.ReaderWrapper;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.naming.NameCoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public class StaxDriver extends AbstractXmlDriver {
    private XMLInputFactory inputFactory;
    private XMLOutputFactory outputFactory;
    private QNameMap qnameMap;

    public StaxDriver() {
        this(new QNameMap());
    }

    public StaxDriver(QNameMap qNameMap) {
        this(qNameMap, (NameCoder) new XmlFriendlyNameCoder());
    }

    public StaxDriver(QNameMap qNameMap, NameCoder nameCoder) {
        super(nameCoder);
        this.qnameMap = qNameMap;
    }

    public StaxDriver(NameCoder nameCoder) {
        this(new QNameMap(), nameCoder);
    }

    public StaxDriver(QNameMap qNameMap, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(qNameMap, (NameCoder) xmlFriendlyReplacer);
    }

    public StaxDriver(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(new QNameMap(), (NameCoder) xmlFriendlyReplacer);
    }

    public HierarchicalStreamReader createReader(Reader reader) {
        try {
            return createStaxReader(createParser(reader));
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public HierarchicalStreamReader createReader(InputStream inputStream) {
        try {
            return createStaxReader(createParser(inputStream));
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public HierarchicalStreamReader createReader(URL url) {
        try {
            final InputStream openStream = FirebasePerfUrlConnection.openStream(url);
            return new ReaderWrapper(createStaxReader(createParser((Source) new StreamSource(openStream, url.toExternalForm())))) {
                public void close() {
                    super.close();
                    try {
                        openStream.close();
                    } catch (IOException unused) {
                    }
                }
            };
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        } catch (IOException e3) {
            throw new StreamException((Throwable) e3);
        }
    }

    public HierarchicalStreamReader createReader(File file) {
        try {
            final FileInputStream fileInputStream = new FileInputStream(file);
            return new ReaderWrapper(createStaxReader(createParser((Source) new StreamSource(fileInputStream, file.toURI().toASCIIString())))) {
                public void close() {
                    super.close();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                }
            };
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        } catch (FileNotFoundException e3) {
            throw new StreamException((Throwable) e3);
        }
    }

    public HierarchicalStreamWriter createWriter(Writer writer) {
        try {
            return createStaxWriter(getOutputFactory().createXMLStreamWriter(writer));
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        try {
            return createStaxWriter(getOutputFactory().createXMLStreamWriter(outputStream));
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public AbstractPullReader createStaxReader(XMLStreamReader xMLStreamReader) {
        return new StaxReader(this.qnameMap, xMLStreamReader, getNameCoder());
    }

    public StaxWriter createStaxWriter(XMLStreamWriter xMLStreamWriter, boolean z) throws XMLStreamException {
        return new StaxWriter(this.qnameMap, xMLStreamWriter, z, isRepairingNamespace(), getNameCoder());
    }

    public StaxWriter createStaxWriter(XMLStreamWriter xMLStreamWriter) throws XMLStreamException {
        return createStaxWriter(xMLStreamWriter, true);
    }

    public QNameMap getQnameMap() {
        return this.qnameMap;
    }

    public void setQnameMap(QNameMap qNameMap) {
        this.qnameMap = qNameMap;
    }

    public XMLInputFactory getInputFactory() {
        if (this.inputFactory == null) {
            this.inputFactory = createInputFactory();
        }
        return this.inputFactory;
    }

    public XMLOutputFactory getOutputFactory() {
        if (this.outputFactory == null) {
            this.outputFactory = createOutputFactory();
        }
        return this.outputFactory;
    }

    public boolean isRepairingNamespace() {
        return Boolean.TRUE.equals(getOutputFactory().getProperty("javax.xml.stream.isRepairingNamespaces"));
    }

    public void setRepairingNamespace(boolean z) {
        getOutputFactory().setProperty("javax.xml.stream.isRepairingNamespaces", z ? Boolean.TRUE : Boolean.FALSE);
    }

    /* access modifiers changed from: protected */
    public XMLStreamReader createParser(Reader reader) throws XMLStreamException {
        return getInputFactory().createXMLStreamReader(reader);
    }

    /* access modifiers changed from: protected */
    public XMLStreamReader createParser(InputStream inputStream) throws XMLStreamException {
        return getInputFactory().createXMLStreamReader(inputStream);
    }

    /* access modifiers changed from: protected */
    public XMLStreamReader createParser(Source source) throws XMLStreamException {
        return getInputFactory().createXMLStreamReader(source);
    }

    /* access modifiers changed from: protected */
    public XMLInputFactory createInputFactory() {
        return XMLInputFactory.newInstance();
    }

    /* access modifiers changed from: protected */
    public XMLOutputFactory createOutputFactory() {
        return XMLOutputFactory.newInstance();
    }
}
