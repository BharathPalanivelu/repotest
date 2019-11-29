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
import nu.xom.Builder;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

public class XomDriver extends AbstractXmlDriver {
    private final Builder builder;

    public XomDriver() {
        this(new Builder());
    }

    public XomDriver(Builder builder2) {
        this(builder2, (NameCoder) new XmlFriendlyNameCoder());
    }

    public XomDriver(NameCoder nameCoder) {
        this(new Builder(), nameCoder);
    }

    public XomDriver(Builder builder2, NameCoder nameCoder) {
        super(nameCoder);
        this.builder = builder2;
    }

    public XomDriver(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(new Builder(), xmlFriendlyReplacer);
    }

    public XomDriver(Builder builder2, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((NameCoder) xmlFriendlyReplacer);
    }

    /* access modifiers changed from: protected */
    public Builder getBuilder() {
        return this.builder;
    }

    public HierarchicalStreamReader createReader(Reader reader) {
        try {
            return new XomReader(this.builder.build(reader), getNameCoder());
        } catch (ValidityException e2) {
            throw new StreamException((Throwable) e2);
        } catch (ParsingException e3) {
            throw new StreamException((Throwable) e3);
        } catch (IOException e4) {
            throw new StreamException((Throwable) e4);
        }
    }

    public HierarchicalStreamReader createReader(InputStream inputStream) {
        try {
            return new XomReader(this.builder.build(inputStream), getNameCoder());
        } catch (ValidityException e2) {
            throw new StreamException((Throwable) e2);
        } catch (ParsingException e3) {
            throw new StreamException((Throwable) e3);
        } catch (IOException e4) {
            throw new StreamException((Throwable) e4);
        }
    }

    public HierarchicalStreamReader createReader(URL url) {
        try {
            return new XomReader(this.builder.build(url.toExternalForm()), getNameCoder());
        } catch (ValidityException e2) {
            throw new StreamException((Throwable) e2);
        } catch (ParsingException e3) {
            throw new StreamException((Throwable) e3);
        } catch (IOException e4) {
            throw new StreamException((Throwable) e4);
        }
    }

    public HierarchicalStreamReader createReader(File file) {
        try {
            return new XomReader(this.builder.build(file), getNameCoder());
        } catch (ValidityException e2) {
            throw new StreamException((Throwable) e2);
        } catch (ParsingException e3) {
            throw new StreamException((Throwable) e3);
        } catch (IOException e4) {
            throw new StreamException((Throwable) e4);
        }
    }

    public HierarchicalStreamWriter createWriter(Writer writer) {
        return new PrettyPrintWriter(writer, getNameCoder());
    }

    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        return new PrettyPrintWriter((Writer) new OutputStreamWriter(outputStream), getNameCoder());
    }
}
