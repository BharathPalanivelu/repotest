package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.naming.NameCoder;
import java.io.File;
import java.io.FilterWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4JDriver extends AbstractXmlDriver {
    private DocumentFactory documentFactory;
    private OutputFormat outputFormat;

    public Dom4JDriver() {
        this(new XmlFriendlyNameCoder());
    }

    public Dom4JDriver(NameCoder nameCoder) {
        this(new DocumentFactory(), OutputFormat.createPrettyPrint(), nameCoder);
        this.outputFormat.setTrimText(false);
    }

    public Dom4JDriver(DocumentFactory documentFactory2, OutputFormat outputFormat2) {
        this(documentFactory2, outputFormat2, (NameCoder) new XmlFriendlyNameCoder());
    }

    public Dom4JDriver(DocumentFactory documentFactory2, OutputFormat outputFormat2, NameCoder nameCoder) {
        super(nameCoder);
        this.documentFactory = documentFactory2;
        this.outputFormat = outputFormat2;
    }

    public Dom4JDriver(DocumentFactory documentFactory2, OutputFormat outputFormat2, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(documentFactory2, outputFormat2, (NameCoder) xmlFriendlyReplacer);
    }

    public DocumentFactory getDocumentFactory() {
        return this.documentFactory;
    }

    public void setDocumentFactory(DocumentFactory documentFactory2) {
        this.documentFactory = documentFactory2;
    }

    public OutputFormat getOutputFormat() {
        return this.outputFormat;
    }

    public void setOutputFormat(OutputFormat outputFormat2) {
        this.outputFormat = outputFormat2;
    }

    public HierarchicalStreamReader createReader(Reader reader) {
        try {
            return new Dom4JReader(new SAXReader().read(reader), getNameCoder());
        } catch (DocumentException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public HierarchicalStreamReader createReader(InputStream inputStream) {
        try {
            return new Dom4JReader(new SAXReader().read(inputStream), getNameCoder());
        } catch (DocumentException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public HierarchicalStreamReader createReader(URL url) {
        try {
            return new Dom4JReader(new SAXReader().read(url), getNameCoder());
        } catch (DocumentException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public HierarchicalStreamReader createReader(File file) {
        try {
            return new Dom4JReader(new SAXReader().read(file), getNameCoder());
        } catch (DocumentException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public HierarchicalStreamWriter createWriter(Writer writer) {
        final HierarchicalStreamWriter[] hierarchicalStreamWriterArr = {new Dom4JXmlWriter(new XMLWriter(new FilterWriter(writer) {
            public void close() {
                hierarchicalStreamWriterArr[0].close();
            }
        }, this.outputFormat), getNameCoder())};
        return hierarchicalStreamWriterArr[0];
    }

    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        return createWriter((Writer) new OutputStreamWriter(outputStream));
    }
}
