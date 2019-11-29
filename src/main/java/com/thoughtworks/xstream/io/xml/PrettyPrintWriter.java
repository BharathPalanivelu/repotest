package com.thoughtworks.xstream.io.xml;

import com.tencent.qcloud.core.util.IOUtils;
import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.naming.NameCoder;
import java.io.Writer;

public class PrettyPrintWriter extends AbstractXmlWriter {
    private static final char[] AMP = "&amp;".toCharArray();
    private static final char[] APOS = "&apos;".toCharArray();
    private static final char[] CLOSE = "</".toCharArray();
    private static final char[] CR = "&#xd;".toCharArray();
    private static final char[] GT = "&gt;".toCharArray();
    private static final char[] LT = "&lt;".toCharArray();
    private static final char[] NULL = "&#x0;".toCharArray();
    private static final char[] QUOT = "&quot;".toCharArray();
    public static int XML_1_0 = 0;
    public static int XML_1_1 = 1;
    public static int XML_QUIRKS = -1;
    protected int depth;
    private final FastStack elementStack;
    private final char[] lineIndenter;
    private final int mode;
    private String newLine;
    private boolean readyForNewLine;
    private boolean tagInProgress;
    private boolean tagIsEmpty;
    private final QuickWriter writer;

    private PrettyPrintWriter(Writer writer2, int i, char[] cArr, NameCoder nameCoder, String str) {
        super(nameCoder);
        this.elementStack = new FastStack(16);
        this.writer = new QuickWriter(writer2);
        this.lineIndenter = cArr;
        this.newLine = str;
        this.mode = i;
        if (i < XML_QUIRKS || i > XML_1_1) {
            throw new IllegalArgumentException("Not a valid XML mode");
        }
    }

    public PrettyPrintWriter(Writer writer2, char[] cArr, String str, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(writer2, XML_QUIRKS, cArr, xmlFriendlyReplacer, str);
    }

    public PrettyPrintWriter(Writer writer2, int i, char[] cArr, NameCoder nameCoder) {
        this(writer2, i, cArr, nameCoder, "\n");
    }

    public PrettyPrintWriter(Writer writer2, int i, char[] cArr, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(writer2, i, cArr, xmlFriendlyReplacer, "\n");
    }

    public PrettyPrintWriter(Writer writer2, char[] cArr, String str) {
        this(writer2, cArr, str, new XmlFriendlyReplacer());
    }

    public PrettyPrintWriter(Writer writer2, int i, char[] cArr) {
        this(writer2, i, cArr, (NameCoder) new XmlFriendlyNameCoder());
    }

    public PrettyPrintWriter(Writer writer2, char[] cArr) {
        this(writer2, XML_QUIRKS, cArr);
    }

    public PrettyPrintWriter(Writer writer2, String str, String str2) {
        this(writer2, str.toCharArray(), str2);
    }

    public PrettyPrintWriter(Writer writer2, int i, String str) {
        this(writer2, i, str.toCharArray());
    }

    public PrettyPrintWriter(Writer writer2, String str) {
        this(writer2, str.toCharArray());
    }

    public PrettyPrintWriter(Writer writer2, int i, NameCoder nameCoder) {
        this(writer2, i, new char[]{' ', ' '}, nameCoder);
    }

    public PrettyPrintWriter(Writer writer2, int i, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(writer2, i, new char[]{' ', ' '}, xmlFriendlyReplacer);
    }

    public PrettyPrintWriter(Writer writer2, NameCoder nameCoder) {
        this(writer2, XML_QUIRKS, new char[]{' ', ' '}, nameCoder, "\n");
    }

    public PrettyPrintWriter(Writer writer2, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(writer2, new char[]{' ', ' '}, "\n", xmlFriendlyReplacer);
    }

    public PrettyPrintWriter(Writer writer2, int i) {
        this(writer2, i, new char[]{' ', ' '});
    }

    public PrettyPrintWriter(Writer writer2) {
        this(writer2, new char[]{' ', ' '});
    }

    public void startNode(String str) {
        String encodeNode = encodeNode(str);
        this.tagIsEmpty = false;
        finishTag();
        this.writer.write('<');
        this.writer.write(encodeNode);
        this.elementStack.push(encodeNode);
        this.tagInProgress = true;
        this.depth++;
        this.readyForNewLine = true;
        this.tagIsEmpty = true;
    }

    public void startNode(String str, Class cls) {
        startNode(str);
    }

    public void setValue(String str) {
        this.readyForNewLine = false;
        this.tagIsEmpty = false;
        finishTag();
        writeText(this.writer, str);
    }

    public void addAttribute(String str, String str2) {
        this.writer.write(' ');
        this.writer.write(encodeAttribute(str));
        this.writer.write('=');
        this.writer.write('\"');
        writeAttributeValue(this.writer, str2);
        this.writer.write('\"');
    }

    /* access modifiers changed from: protected */
    public void writeAttributeValue(QuickWriter quickWriter, String str) {
        writeText(str, true);
    }

    /* access modifiers changed from: protected */
    public void writeText(QuickWriter quickWriter, String str) {
        writeText(str, false);
    }

    private void writeText(String str, boolean z) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != 0) {
                if (charAt == 13) {
                    this.writer.write(CR);
                } else if (charAt == '\"') {
                    this.writer.write(QUOT);
                } else if (charAt == '<') {
                    this.writer.write(LT);
                } else if (charAt != '>') {
                    if (charAt == 9 || charAt == 10) {
                        if (!z) {
                            this.writer.write(charAt);
                        }
                    } else if (charAt == '&') {
                        this.writer.write(AMP);
                    } else if (charAt == '\'') {
                        this.writer.write(APOS);
                    }
                    if (!Character.isDefined(charAt) || Character.isISOControl(charAt)) {
                        if (this.mode == XML_1_0 && (charAt < 9 || charAt == 11 || charAt == 12 || charAt == 14 || (charAt >= 15 && charAt <= 31))) {
                            throw new StreamException("Invalid character 0x" + Integer.toHexString(charAt) + " in XML 1.0 stream");
                        } else if (this.mode == XML_QUIRKS || !(charAt == 65534 || charAt == 65535)) {
                            this.writer.write("&#x");
                            this.writer.write(Integer.toHexString(charAt));
                            this.writer.write(';');
                        } else {
                            throw new StreamException("Invalid character 0x" + Integer.toHexString(charAt) + " in XML stream");
                        }
                    } else if (this.mode == XML_QUIRKS || charAt <= 55295 || charAt >= 57344) {
                        this.writer.write(charAt);
                    } else {
                        throw new StreamException("Invalid character 0x" + Integer.toHexString(charAt) + " in XML stream");
                    }
                } else {
                    this.writer.write(GT);
                }
            } else if (this.mode == XML_QUIRKS) {
                this.writer.write(NULL);
            } else {
                throw new StreamException("Invalid character 0x0 in XML stream");
            }
        }
    }

    public void endNode() {
        this.depth--;
        if (this.tagIsEmpty) {
            this.writer.write((char) IOUtils.DIR_SEPARATOR_UNIX);
            this.readyForNewLine = false;
            finishTag();
            this.elementStack.popSilently();
        } else {
            finishTag();
            this.writer.write(CLOSE);
            this.writer.write((String) this.elementStack.pop());
            this.writer.write('>');
        }
        this.readyForNewLine = true;
        if (this.depth == 0) {
            this.writer.flush();
        }
    }

    private void finishTag() {
        if (this.tagInProgress) {
            this.writer.write('>');
        }
        this.tagInProgress = false;
        if (this.readyForNewLine) {
            endOfLine();
        }
        this.readyForNewLine = false;
        this.tagIsEmpty = false;
    }

    /* access modifiers changed from: protected */
    public void endOfLine() {
        this.writer.write(getNewLine());
        for (int i = 0; i < this.depth; i++) {
            this.writer.write(this.lineIndenter);
        }
    }

    public void flush() {
        this.writer.flush();
    }

    public void close() {
        this.writer.close();
    }

    /* access modifiers changed from: protected */
    public String getNewLine() {
        return this.newLine;
    }
}
