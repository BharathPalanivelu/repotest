package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.sax.SAXSource;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;

public class TraxSource extends SAXSource {
    public static final String XSTREAM_FEATURE = "http://com.thoughtworks.xstream/XStreamSource/feature";
    private List source = null;
    private XMLReader xmlReader = null;
    private XStream xstream = null;

    public TraxSource() {
        super(new InputSource());
    }

    public TraxSource(Object obj) {
        super(new InputSource());
        setSource(obj);
    }

    public TraxSource(Object obj, XStream xStream) {
        super(new InputSource());
        setSource(obj);
        setXStream(xStream);
    }

    public TraxSource(List list) {
        super(new InputSource());
        setSourceAsList(list);
    }

    public TraxSource(List list, XStream xStream) {
        super(new InputSource());
        setSourceAsList(list);
        setXStream(xStream);
    }

    public void setInputSource(InputSource inputSource) {
        throw new UnsupportedOperationException();
    }

    public void setXMLReader(XMLReader xMLReader) {
        createXMLReader(xMLReader);
    }

    public XMLReader getXMLReader() {
        if (this.xmlReader == null) {
            createXMLReader((XMLReader) null);
        }
        return this.xmlReader;
    }

    public void setXStream(XStream xStream) {
        if (xStream != null) {
            this.xstream = xStream;
            configureXMLReader();
            return;
        }
        throw new IllegalArgumentException("xstream");
    }

    public void setSource(Object obj) {
        if (obj != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(obj);
            setSourceAsList(arrayList);
            return;
        }
        throw new IllegalArgumentException("obj");
    }

    public void setSourceAsList(List list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("list");
        }
        this.source = list;
        configureXMLReader();
    }

    private void createXMLReader(XMLReader xMLReader) {
        XMLFilter xMLFilter;
        if (xMLReader == null) {
            this.xmlReader = new SaxWriter();
        } else if (xMLReader instanceof XMLFilter) {
            XMLReader xMLReader2 = xMLReader;
            while (true) {
                xMLFilter = (XMLFilter) xMLReader2;
                if (!(xMLFilter.getParent() instanceof XMLFilter)) {
                    break;
                }
                xMLReader2 = (XMLFilter) xMLFilter.getParent();
            }
            if (!(xMLFilter.getParent() instanceof SaxWriter)) {
                xMLFilter.setParent(new SaxWriter());
            }
            this.xmlReader = xMLReader;
        } else {
            throw new UnsupportedOperationException();
        }
        configureXMLReader();
    }

    private void configureXMLReader() {
        XMLReader xMLReader = this.xmlReader;
        if (xMLReader != null) {
            try {
                if (this.xstream != null) {
                    xMLReader.setProperty(SaxWriter.CONFIGURED_XSTREAM_PROPERTY, this.xstream);
                }
                if (this.source != null) {
                    this.xmlReader.setProperty(SaxWriter.SOURCE_OBJECT_LIST_PROPERTY, this.source);
                }
            } catch (SAXException e2) {
                throw new IllegalArgumentException(e2.getMessage());
            }
        }
    }
}
