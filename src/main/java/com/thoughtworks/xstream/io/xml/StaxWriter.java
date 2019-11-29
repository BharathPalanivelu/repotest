package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.naming.NameCoder;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class StaxWriter extends AbstractXmlWriter {
    private boolean namespaceRepairingMode;
    private final XMLStreamWriter out;
    private final QNameMap qnameMap;
    private int tagDepth;
    private final boolean writeEnclosingDocument;

    public StaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter) throws XMLStreamException {
        this(qNameMap, xMLStreamWriter, true, true);
    }

    public StaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter, NameCoder nameCoder) throws XMLStreamException {
        this(qNameMap, xMLStreamWriter, true, true, nameCoder);
    }

    public StaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter, boolean z, boolean z2, NameCoder nameCoder) throws XMLStreamException {
        super(nameCoder);
        this.qnameMap = qNameMap;
        this.out = xMLStreamWriter;
        this.writeEnclosingDocument = z;
        this.namespaceRepairingMode = z2;
        if (z) {
            xMLStreamWriter.writeStartDocument();
        }
    }

    public StaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter, boolean z, boolean z2) throws XMLStreamException {
        this(qNameMap, xMLStreamWriter, z, z2, (NameCoder) new XmlFriendlyNameCoder());
    }

    public StaxWriter(QNameMap qNameMap, XMLStreamWriter xMLStreamWriter, boolean z, boolean z2, XmlFriendlyReplacer xmlFriendlyReplacer) throws XMLStreamException {
        this(qNameMap, xMLStreamWriter, z, z2, (NameCoder) xmlFriendlyReplacer);
    }

    public void flush() {
        try {
            this.out.flush();
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public void close() {
        try {
            this.out.close();
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public void addAttribute(String str, String str2) {
        try {
            this.out.writeAttribute(encodeAttribute(str), str2);
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public void endNode() {
        try {
            this.tagDepth--;
            this.out.writeEndElement();
            if (this.tagDepth == 0 && this.writeEnclosingDocument) {
                this.out.writeEndDocument();
            }
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public void setValue(String str) {
        try {
            this.out.writeCharacters(str);
        } catch (XMLStreamException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r6.equals(r1) != false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startNode(java.lang.String r9) {
        /*
            r8 = this;
            com.thoughtworks.xstream.io.xml.QNameMap r0 = r8.qnameMap     // Catch:{ XMLStreamException -> 0x008d }
            java.lang.String r9 = r8.encodeNode(r9)     // Catch:{ XMLStreamException -> 0x008d }
            javax.xml.namespace.QName r9 = r0.getQName(r9)     // Catch:{ XMLStreamException -> 0x008d }
            java.lang.String r0 = r9.getPrefix()     // Catch:{ XMLStreamException -> 0x008d }
            java.lang.String r1 = r9.getNamespaceURI()     // Catch:{ XMLStreamException -> 0x008d }
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x001e
            int r4 = r0.length()     // Catch:{ XMLStreamException -> 0x008d }
            if (r4 <= 0) goto L_0x001e
            r4 = 1
            goto L_0x001f
        L_0x001e:
            r4 = 0
        L_0x001f:
            if (r1 == 0) goto L_0x0029
            int r5 = r1.length()     // Catch:{ XMLStreamException -> 0x008d }
            if (r5 <= 0) goto L_0x0029
            r5 = 1
            goto L_0x002a
        L_0x0029:
            r5 = 0
        L_0x002a:
            if (r5 == 0) goto L_0x0056
            if (r4 == 0) goto L_0x0041
            javax.xml.stream.XMLStreamWriter r6 = r8.out     // Catch:{ XMLStreamException -> 0x008d }
            javax.xml.namespace.NamespaceContext r6 = r6.getNamespaceContext()     // Catch:{ XMLStreamException -> 0x008d }
            java.lang.String r6 = r6.getNamespaceURI(r0)     // Catch:{ XMLStreamException -> 0x008d }
            if (r6 == 0) goto L_0x0055
            boolean r6 = r6.equals(r1)     // Catch:{ XMLStreamException -> 0x008d }
            if (r6 != 0) goto L_0x0056
            goto L_0x0055
        L_0x0041:
            javax.xml.stream.XMLStreamWriter r6 = r8.out     // Catch:{ XMLStreamException -> 0x008d }
            javax.xml.namespace.NamespaceContext r6 = r6.getNamespaceContext()     // Catch:{ XMLStreamException -> 0x008d }
            java.lang.String r7 = ""
            java.lang.String r6 = r6.getNamespaceURI(r7)     // Catch:{ XMLStreamException -> 0x008d }
            if (r6 == 0) goto L_0x0055
            boolean r6 = r6.equals(r1)     // Catch:{ XMLStreamException -> 0x008d }
            if (r6 != 0) goto L_0x0056
        L_0x0055:
            r2 = 1
        L_0x0056:
            javax.xml.stream.XMLStreamWriter r6 = r8.out     // Catch:{ XMLStreamException -> 0x008d }
            java.lang.String r9 = r9.getLocalPart()     // Catch:{ XMLStreamException -> 0x008d }
            r6.writeStartElement(r0, r9, r1)     // Catch:{ XMLStreamException -> 0x008d }
            if (r4 == 0) goto L_0x0067
            javax.xml.stream.XMLStreamWriter r9 = r8.out     // Catch:{ XMLStreamException -> 0x008d }
            r9.setPrefix(r0, r1)     // Catch:{ XMLStreamException -> 0x008d }
            goto L_0x0070
        L_0x0067:
            if (r5 == 0) goto L_0x0070
            if (r2 == 0) goto L_0x0070
            javax.xml.stream.XMLStreamWriter r9 = r8.out     // Catch:{ XMLStreamException -> 0x008d }
            r9.setDefaultNamespace(r1)     // Catch:{ XMLStreamException -> 0x008d }
        L_0x0070:
            if (r5 == 0) goto L_0x0087
            if (r2 == 0) goto L_0x0087
            boolean r9 = r8.isNamespaceRepairingMode()     // Catch:{ XMLStreamException -> 0x008d }
            if (r9 != 0) goto L_0x0087
            if (r4 == 0) goto L_0x0082
            javax.xml.stream.XMLStreamWriter r9 = r8.out     // Catch:{ XMLStreamException -> 0x008d }
            r9.writeNamespace(r0, r1)     // Catch:{ XMLStreamException -> 0x008d }
            goto L_0x0087
        L_0x0082:
            javax.xml.stream.XMLStreamWriter r9 = r8.out     // Catch:{ XMLStreamException -> 0x008d }
            r9.writeDefaultNamespace(r1)     // Catch:{ XMLStreamException -> 0x008d }
        L_0x0087:
            int r9 = r8.tagDepth     // Catch:{ XMLStreamException -> 0x008d }
            int r9 = r9 + r3
            r8.tagDepth = r9     // Catch:{ XMLStreamException -> 0x008d }
            return
        L_0x008d:
            r9 = move-exception
            com.thoughtworks.xstream.io.StreamException r0 = new com.thoughtworks.xstream.io.StreamException
            r0.<init>((java.lang.Throwable) r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.io.xml.StaxWriter.startNode(java.lang.String):void");
    }

    public boolean isNamespaceRepairingMode() {
        return this.namespaceRepairingMode;
    }

    /* access modifiers changed from: protected */
    public QNameMap getQNameMap() {
        return this.qnameMap;
    }

    /* access modifiers changed from: protected */
    public XMLStreamWriter getXMLStreamWriter() {
        return this.out;
    }
}
