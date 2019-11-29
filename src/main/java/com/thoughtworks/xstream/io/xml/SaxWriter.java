package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.naming.NameCoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

public final class SaxWriter extends AbstractXmlWriter implements XMLReader {
    public static final String CONFIGURED_XSTREAM_PROPERTY = "http://com.thoughtworks.xstream/sax/property/configured-xstream";
    public static final String SOURCE_OBJECT_LIST_PROPERTY = "http://com.thoughtworks.xstream/sax/property/source-object-list";
    private final AttributesImpl attributeList;
    private char[] buffer;
    private ContentHandler contentHandler;
    private int depth;
    private DTDHandler dtdHandler;
    private List elementStack;
    private EntityResolver entityResolver;
    private ErrorHandler errorHandler;
    private Map features;
    private final boolean includeEnclosingDocument;
    private final Map properties;
    private boolean startTagInProgress;

    public void close() {
    }

    public void flush() {
    }

    public SaxWriter(NameCoder nameCoder) {
        this(true, nameCoder);
    }

    public SaxWriter(boolean z, NameCoder nameCoder) {
        super(nameCoder);
        this.entityResolver = null;
        this.dtdHandler = null;
        this.contentHandler = null;
        this.errorHandler = null;
        this.features = new HashMap();
        this.properties = new HashMap();
        this.depth = 0;
        this.elementStack = new LinkedList();
        this.buffer = new char[128];
        this.startTagInProgress = false;
        this.attributeList = new AttributesImpl();
        this.includeEnclosingDocument = z;
    }

    public SaxWriter(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(true, xmlFriendlyReplacer);
    }

    public SaxWriter(boolean z, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(z, (NameCoder) xmlFriendlyReplacer);
    }

    public SaxWriter(boolean z) {
        this(z, (NameCoder) new XmlFriendlyNameCoder());
    }

    public SaxWriter() {
        this(true);
    }

    public void setFeature(String str, boolean z) throws SAXNotRecognizedException {
        if (str.equals("http://xml.org/sax/features/namespaces") || str.equals("http://xml.org/sax/features/namespace-prefixes")) {
            this.features.put(str, z ? Boolean.TRUE : Boolean.FALSE);
            return;
        }
        throw new SAXNotRecognizedException(str);
    }

    public boolean getFeature(String str) throws SAXNotRecognizedException {
        if (str.equals("http://xml.org/sax/features/namespaces") || str.equals("http://xml.org/sax/features/namespace-prefixes")) {
            Boolean bool = (Boolean) this.features.get(str);
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            return bool.booleanValue();
        }
        throw new SAXNotRecognizedException(str);
    }

    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals(CONFIGURED_XSTREAM_PROPERTY)) {
            if (!(obj instanceof XStream)) {
                throw new SAXNotSupportedException("Value for property \"http://com.thoughtworks.xstream/sax/property/configured-xstream\" must be a non-null XStream object");
            }
        } else if (!str.equals(SOURCE_OBJECT_LIST_PROPERTY)) {
            throw new SAXNotRecognizedException(str);
        } else if (obj instanceof List) {
            List list = (List) obj;
            if (!list.isEmpty()) {
                obj = Collections.unmodifiableList(new ArrayList(list));
            } else {
                throw new SAXNotSupportedException("Value for property \"http://com.thoughtworks.xstream/sax/property/source-object-list\" shall not be an empty list");
            }
        } else {
            throw new SAXNotSupportedException("Value for property \"http://com.thoughtworks.xstream/sax/property/source-object-list\" must be a non-null List object");
        }
        this.properties.put(str, obj);
    }

    public Object getProperty(String str) throws SAXNotRecognizedException {
        if (str.equals(CONFIGURED_XSTREAM_PROPERTY) || str.equals(SOURCE_OBJECT_LIST_PROPERTY)) {
            return this.properties.get(str);
        }
        throw new SAXNotRecognizedException(str);
    }

    public void setEntityResolver(EntityResolver entityResolver2) {
        if (entityResolver2 != null) {
            this.entityResolver = entityResolver2;
            return;
        }
        throw new NullPointerException("resolver");
    }

    public EntityResolver getEntityResolver() {
        return this.entityResolver;
    }

    public void setDTDHandler(DTDHandler dTDHandler) {
        if (dTDHandler != null) {
            this.dtdHandler = dTDHandler;
            return;
        }
        throw new NullPointerException("handler");
    }

    public DTDHandler getDTDHandler() {
        return this.dtdHandler;
    }

    public void setContentHandler(ContentHandler contentHandler2) {
        if (contentHandler2 != null) {
            this.contentHandler = contentHandler2;
            return;
        }
        throw new NullPointerException("handler");
    }

    public ContentHandler getContentHandler() {
        return this.contentHandler;
    }

    public void setErrorHandler(ErrorHandler errorHandler2) {
        if (errorHandler2 != null) {
            this.errorHandler = errorHandler2;
            return;
        }
        throw new NullPointerException("handler");
    }

    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    public void parse(String str) throws SAXException {
        parse();
    }

    public void parse(InputSource inputSource) throws SAXException {
        parse();
    }

    private void parse() throws SAXException {
        XStream xStream = (XStream) this.properties.get(CONFIGURED_XSTREAM_PROPERTY);
        if (xStream == null) {
            xStream = new XStream();
        }
        List<Object> list = (List) this.properties.get(SOURCE_OBJECT_LIST_PROPERTY);
        if (list == null || list.isEmpty()) {
            throw new SAXException("Missing or empty source object list. Setting property \"http://com.thoughtworks.xstream/sax/property/source-object-list\" is mandatory");
        }
        try {
            startDocument(true);
            for (Object marshal : list) {
                xStream.marshal(marshal, this);
            }
            endDocument(true);
        } catch (StreamException e2) {
            if (e2.getCause() instanceof SAXException) {
                throw ((SAXException) e2.getCause());
            }
            throw new SAXException(e2);
        }
    }

    public void startNode(String str) {
        try {
            if (this.depth != 0) {
                flushStartTag();
            } else if (this.includeEnclosingDocument) {
                startDocument(false);
            }
            this.elementStack.add(0, escapeXmlName(str));
            this.startTagInProgress = true;
            this.depth++;
        } catch (SAXException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public void addAttribute(String str, String str2) {
        if (this.startTagInProgress) {
            String escapeXmlName = escapeXmlName(str);
            this.attributeList.addAttribute("", escapeXmlName, escapeXmlName, "CDATA", str2);
            return;
        }
        throw new StreamException((Throwable) new IllegalStateException("No startElement being processed"));
    }

    public void setValue(String str) {
        try {
            flushStartTag();
            int length = str.length();
            if (length > this.buffer.length) {
                this.buffer = new char[length];
            }
            str.getChars(0, length, this.buffer, 0);
            this.contentHandler.characters(this.buffer, 0, length);
        } catch (SAXException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public void endNode() {
        try {
            flushStartTag();
            String str = (String) this.elementStack.remove(0);
            this.contentHandler.endElement("", str, str);
            this.depth--;
            if (this.depth == 0 && this.includeEnclosingDocument) {
                endDocument(false);
            }
        } catch (SAXException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    private void startDocument(boolean z) throws SAXException {
        if (this.depth == 0) {
            this.contentHandler.startDocument();
            if (z) {
                this.depth++;
            }
        }
    }

    private void endDocument(boolean z) throws SAXException {
        int i = this.depth;
        if (i == 0 || (i == 1 && z)) {
            this.contentHandler.endDocument();
            this.depth = 0;
        }
    }

    private void flushStartTag() throws SAXException {
        if (this.startTagInProgress) {
            String str = (String) this.elementStack.get(0);
            this.contentHandler.startElement("", str, str, this.attributeList);
            this.attributeList.clear();
            this.startTagInProgress = false;
        }
    }
}
