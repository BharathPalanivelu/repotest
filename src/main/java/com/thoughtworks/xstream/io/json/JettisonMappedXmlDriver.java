package com.thoughtworks.xstream.io.json;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.thoughtworks.xstream.io.AbstractDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxReader;
import com.thoughtworks.xstream.io.xml.StaxWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import javax.xml.stream.XMLStreamException;
import org.codehaus.jettison.mapped.Configuration;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLInputFactory;
import org.codehaus.jettison.mapped.MappedXMLOutputFactory;

public class JettisonMappedXmlDriver extends AbstractDriver {
    protected final MappedNamespaceConvention convention;
    protected final MappedXMLInputFactory mif;
    protected final MappedXMLOutputFactory mof;
    protected final boolean useSerializeAsArray;

    public JettisonMappedXmlDriver() {
        this(new Configuration());
    }

    public JettisonMappedXmlDriver(Configuration configuration) {
        this(configuration, true);
    }

    public JettisonMappedXmlDriver(Configuration configuration, boolean z) {
        this.mof = new MappedXMLOutputFactory(configuration);
        this.mif = new MappedXMLInputFactory(configuration);
        this.convention = new MappedNamespaceConvention(configuration);
        this.useSerializeAsArray = z;
    }

    public HierarchicalStreamReader createReader(Reader reader) {
        try {
            return new StaxReader(new QNameMap(), this.mif.createXMLStreamReader(reader), getNameCoder());
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public HierarchicalStreamReader createReader(InputStream inputStream) {
        try {
            return new StaxReader(new QNameMap(), this.mif.createXMLStreamReader(inputStream), getNameCoder());
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public HierarchicalStreamReader createReader(URL url) {
        InputStream inputStream = null;
        try {
            inputStream = FirebasePerfUrlConnection.openStream(url);
            StaxReader staxReader = new StaxReader(new QNameMap(), this.mif.createXMLStreamReader(url.toExternalForm(), inputStream), getNameCoder());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return staxReader;
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        } catch (IOException e3) {
            throw new StreamException((Throwable) e3);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0041 A[SYNTHETIC, Splitter:B:24:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.thoughtworks.xstream.io.HierarchicalStreamReader createReader(java.io.File r5) {
        /*
            r4 = this;
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ XMLStreamException -> 0x0038, IOException -> 0x0031 }
            r1.<init>(r5)     // Catch:{ XMLStreamException -> 0x0038, IOException -> 0x0031 }
            com.thoughtworks.xstream.io.xml.StaxReader r0 = new com.thoughtworks.xstream.io.xml.StaxReader     // Catch:{ XMLStreamException -> 0x002b, IOException -> 0x0028, all -> 0x0026 }
            com.thoughtworks.xstream.io.xml.QNameMap r2 = new com.thoughtworks.xstream.io.xml.QNameMap     // Catch:{ XMLStreamException -> 0x002b, IOException -> 0x0028, all -> 0x0026 }
            r2.<init>()     // Catch:{ XMLStreamException -> 0x002b, IOException -> 0x0028, all -> 0x0026 }
            org.codehaus.jettison.mapped.MappedXMLInputFactory r3 = r4.mif     // Catch:{ XMLStreamException -> 0x002b, IOException -> 0x0028, all -> 0x0026 }
            java.net.URI r5 = r5.toURI()     // Catch:{ XMLStreamException -> 0x002b, IOException -> 0x0028, all -> 0x0026 }
            java.lang.String r5 = r5.toASCIIString()     // Catch:{ XMLStreamException -> 0x002b, IOException -> 0x0028, all -> 0x0026 }
            javax.xml.stream.XMLStreamReader r5 = r3.createXMLStreamReader(r5, r1)     // Catch:{ XMLStreamException -> 0x002b, IOException -> 0x0028, all -> 0x0026 }
            com.thoughtworks.xstream.io.naming.NameCoder r3 = r4.getNameCoder()     // Catch:{ XMLStreamException -> 0x002b, IOException -> 0x0028, all -> 0x0026 }
            r0.<init>((com.thoughtworks.xstream.io.xml.QNameMap) r2, (javax.xml.stream.XMLStreamReader) r5, (com.thoughtworks.xstream.io.naming.NameCoder) r3)     // Catch:{ XMLStreamException -> 0x002b, IOException -> 0x0028, all -> 0x0026 }
            r1.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            return r0
        L_0x0026:
            r5 = move-exception
            goto L_0x003f
        L_0x0028:
            r5 = move-exception
            r0 = r1
            goto L_0x0032
        L_0x002b:
            r5 = move-exception
            r0 = r1
            goto L_0x0039
        L_0x002e:
            r5 = move-exception
            r1 = r0
            goto L_0x003f
        L_0x0031:
            r5 = move-exception
        L_0x0032:
            com.thoughtworks.xstream.io.StreamException r1 = new com.thoughtworks.xstream.io.StreamException     // Catch:{ all -> 0x002e }
            r1.<init>((java.lang.Throwable) r5)     // Catch:{ all -> 0x002e }
            throw r1     // Catch:{ all -> 0x002e }
        L_0x0038:
            r5 = move-exception
        L_0x0039:
            com.thoughtworks.xstream.io.StreamException r1 = new com.thoughtworks.xstream.io.StreamException     // Catch:{ all -> 0x002e }
            r1.<init>((java.lang.Throwable) r5)     // Catch:{ all -> 0x002e }
            throw r1     // Catch:{ all -> 0x002e }
        L_0x003f:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver.createReader(java.io.File):com.thoughtworks.xstream.io.HierarchicalStreamReader");
    }

    public HierarchicalStreamWriter createWriter(Writer writer) {
        try {
            if (this.useSerializeAsArray) {
                return new JettisonStaxWriter(new QNameMap(), this.mof.createXMLStreamWriter(writer), getNameCoder(), this.convention);
            }
            return new StaxWriter(new QNameMap(), this.mof.createXMLStreamWriter(writer), getNameCoder());
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        try {
            if (this.useSerializeAsArray) {
                return new JettisonStaxWriter(new QNameMap(), this.mof.createXMLStreamWriter(outputStream), getNameCoder(), this.convention);
            }
            return new StaxWriter(new QNameMap(), this.mof.createXMLStreamWriter(outputStream), getNameCoder());
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }
}
