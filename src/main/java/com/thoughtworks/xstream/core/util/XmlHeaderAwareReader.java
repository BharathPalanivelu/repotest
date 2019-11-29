package com.thoughtworks.xstream.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public final class XmlHeaderAwareReader extends Reader {
    private static final String KEY_ENCODING = "encoding";
    private static final String KEY_VERSION = "version";
    private static final int STATE_ATTR_NAME = 3;
    private static final int STATE_ATTR_VALUE = 4;
    private static final int STATE_AWAIT_XML_HEADER = 2;
    private static final int STATE_BOM = 0;
    private static final int STATE_START = 1;
    private static final String XML_TOKEN = "?xml";
    private final InputStreamReader reader;
    private final double version;

    public XmlHeaderAwareReader(InputStream inputStream) throws UnsupportedEncodingException, IOException {
        PushbackInputStream[] pushbackInputStreamArr = new PushbackInputStream[1];
        pushbackInputStreamArr[0] = inputStream instanceof PushbackInputStream ? (PushbackInputStream) inputStream : new PushbackInputStream(inputStream, 64);
        Map header = getHeader(pushbackInputStreamArr);
        this.version = Double.parseDouble((String) header.get("version"));
        this.reader = new InputStreamReader(pushbackInputStreamArr[0], (String) header.get(KEY_ENCODING));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f5, code lost:
        if (r1.size() > 1) goto L_0x0106;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map getHeader(java.io.PushbackInputStream[] r17) throws java.io.IOException {
        /*
            r16 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "encoding"
            java.lang.String r2 = "utf-8"
            r0.put(r1, r2)
            java.lang.String r1 = "version"
            java.lang.String r2 = "1.0"
            r0.put(r1, r2)
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r2 = 64
            r1.<init>(r2)
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0028:
            r8 = 0
        L_0x0029:
            r9 = -1
            if (r5 == r9) goto L_0x010c
            r5 = r17[r4]
            int r5 = r5.read()
            if (r5 == r9) goto L_0x010c
            r1.write(r5)
            char r10 = (char) r5
            r11 = 4
            r12 = 2
            r13 = 3
            r14 = 1
            if (r6 == 0) goto L_0x00cb
            if (r6 == r14) goto L_0x00c9
            if (r6 == r12) goto L_0x009f
            if (r6 == r13) goto L_0x007d
            if (r6 == r11) goto L_0x0047
            goto L_0x0029
        L_0x0047:
            if (r7 != 0) goto L_0x0053
            r11 = 34
            if (r10 == r11) goto L_0x0051
            r11 = 39
            if (r10 != r11) goto L_0x0106
        L_0x0051:
            r7 = r10
            goto L_0x0029
        L_0x0053:
            r11 = 92
            if (r10 != r11) goto L_0x005b
            if (r8 != 0) goto L_0x005b
            r8 = 1
            goto L_0x0029
        L_0x005b:
            if (r10 != r7) goto L_0x0073
            if (r8 != 0) goto L_0x0073
            java.lang.String r6 = r2.toString()
            java.lang.String r7 = r3.toString()
            r0.put(r6, r7)
            r2.setLength(r4)
            r3.setLength(r4)
            r6 = 3
            r7 = 0
            goto L_0x0029
        L_0x0073:
            r8 = 10
            if (r10 == r8) goto L_0x007b
            r3.append(r10)
            goto L_0x0028
        L_0x007b:
            r5 = -1
            goto L_0x0028
        L_0x007d:
            boolean r12 = java.lang.Character.isWhitespace(r10)
            if (r12 != 0) goto L_0x0097
            r12 = 61
            if (r10 != r12) goto L_0x0089
            r6 = 4
            goto L_0x0029
        L_0x0089:
            char r10 = java.lang.Character.toLowerCase(r10)
            boolean r11 = java.lang.Character.isLetter(r10)
            if (r11 == 0) goto L_0x0106
            r2.append(r10)
            goto L_0x0029
        L_0x0097:
            int r10 = r2.length()
            if (r10 <= 0) goto L_0x0029
            goto L_0x0106
        L_0x009f:
            boolean r11 = java.lang.Character.isWhitespace(r10)
            java.lang.String r12 = "?xml"
            if (r11 != 0) goto L_0x00b9
            char r10 = java.lang.Character.toLowerCase(r10)
            r2.append(r10)
            java.lang.String r10 = r2.substring(r4)
            boolean r10 = r12.startsWith(r10)
            if (r10 != 0) goto L_0x0029
            goto L_0x0106
        L_0x00b9:
            java.lang.String r10 = r2.toString()
            boolean r10 = r10.equals(r12)
            if (r10 == 0) goto L_0x0106
            r2.setLength(r4)
            r6 = 3
            goto L_0x0029
        L_0x00c9:
            r14 = r6
            goto L_0x00f8
        L_0x00cb:
            r11 = 239(0xef, float:3.35E-43)
            r15 = 191(0xbf, float:2.68E-43)
            if (r10 != r11) goto L_0x00d7
            int r11 = r1.size()
            if (r11 == r14) goto L_0x00e9
        L_0x00d7:
            r11 = 187(0xbb, float:2.62E-43)
            if (r10 != r11) goto L_0x00e1
            int r11 = r1.size()
            if (r11 == r12) goto L_0x00e9
        L_0x00e1:
            if (r10 != r15) goto L_0x00f1
            int r11 = r1.size()
            if (r11 != r13) goto L_0x00f1
        L_0x00e9:
            if (r10 != r15) goto L_0x0029
            r1.reset()
            r6 = 1
            goto L_0x0029
        L_0x00f1:
            int r11 = r1.size()
            if (r11 <= r14) goto L_0x00f8
            goto L_0x0106
        L_0x00f8:
            boolean r6 = java.lang.Character.isWhitespace(r10)
            if (r6 != 0) goto L_0x0109
            r6 = 60
            if (r10 != r6) goto L_0x0105
            r6 = 2
            goto L_0x0029
        L_0x0105:
            r6 = r14
        L_0x0106:
            r5 = -1
            goto L_0x0029
        L_0x0109:
            r6 = r14
            goto L_0x0029
        L_0x010c:
            byte[] r1 = r1.toByteArray()
            int r2 = r1.length
        L_0x0111:
            int r3 = r2 + -1
            if (r2 <= 0) goto L_0x012a
            byte r2 = r1[r3]
            r5 = r17[r4]     // Catch:{ IOException -> 0x011d }
            r5.unread(r2)     // Catch:{ IOException -> 0x011d }
            goto L_0x0128
        L_0x011d:
            java.io.PushbackInputStream r2 = new java.io.PushbackInputStream
            r5 = r17[r4]
            int r3 = r3 + 1
            r2.<init>(r5, r3)
            r17[r4] = r2
        L_0x0128:
            r2 = r3
            goto L_0x0111
        L_0x012a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.core.util.XmlHeaderAwareReader.getHeader(java.io.PushbackInputStream[]):java.util.Map");
    }

    public String getEncoding() {
        return this.reader.getEncoding();
    }

    public double getVersion() {
        return this.version;
    }

    public void mark(int i) throws IOException {
        this.reader.mark(i);
    }

    public boolean markSupported() {
        return this.reader.markSupported();
    }

    public int read() throws IOException {
        return this.reader.read();
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        return this.reader.read(cArr, i, i2);
    }

    public int read(char[] cArr) throws IOException {
        return this.reader.read(cArr);
    }

    public boolean ready() throws IOException {
        return this.reader.ready();
    }

    public void reset() throws IOException {
        this.reader.reset();
    }

    public long skip(long j) throws IOException {
        return this.reader.skip(j);
    }

    public void close() throws IOException {
        this.reader.close();
    }

    public boolean equals(Object obj) {
        return this.reader.equals(obj);
    }

    public int hashCode() {
        return this.reader.hashCode();
    }

    public String toString() {
        return this.reader.toString();
    }
}
