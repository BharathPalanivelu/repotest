package com.thoughtworks.xstream.io.json;

import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.AbstractJsonWriter;
import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import java.io.Writer;

public class JsonWriter extends AbstractJsonWriter {
    private int depth;
    protected final Format format;
    private boolean newLineProposed;
    protected final QuickWriter writer;

    public HierarchicalStreamWriter underlyingWriter() {
        return this;
    }

    public JsonWriter(Writer writer2, char[] cArr, String str) {
        this(writer2, 0, new Format(cArr, str.toCharArray(), Format.SPACE_AFTER_LABEL | Format.COMPACT_EMPTY_ELEMENT));
    }

    public JsonWriter(Writer writer2, char[] cArr) {
        this(writer2, 0, new Format(cArr, new char[]{10}, Format.SPACE_AFTER_LABEL | Format.COMPACT_EMPTY_ELEMENT));
    }

    public JsonWriter(Writer writer2, String str, String str2) {
        this(writer2, 0, new Format(str.toCharArray(), str2.toCharArray(), Format.SPACE_AFTER_LABEL | Format.COMPACT_EMPTY_ELEMENT));
    }

    public JsonWriter(Writer writer2, String str) {
        this(writer2, 0, new Format(str.toCharArray(), new char[]{10}, Format.SPACE_AFTER_LABEL | Format.COMPACT_EMPTY_ELEMENT));
    }

    public JsonWriter(Writer writer2) {
        this(writer2, 0, new Format(new char[]{' ', ' '}, new char[]{10}, Format.SPACE_AFTER_LABEL | Format.COMPACT_EMPTY_ELEMENT));
    }

    public JsonWriter(Writer writer2, char[] cArr, String str, int i) {
        this(writer2, i, new Format(cArr, str.toCharArray(), Format.SPACE_AFTER_LABEL | Format.COMPACT_EMPTY_ELEMENT));
    }

    public JsonWriter(Writer writer2, int i) {
        this(writer2, i, new Format());
    }

    public JsonWriter(Writer writer2, Format format2) {
        this(writer2, 0, format2);
    }

    public JsonWriter(Writer writer2, int i, Format format2) {
        this(writer2, i, format2, 1024);
    }

    public JsonWriter(Writer writer2, int i, Format format2, int i2) {
        super(i, format2.getNameCoder());
        this.writer = new QuickWriter(writer2, i2);
        this.format = format2;
        this.depth = (i & 1) == 0 ? -1 : 0;
    }

    public void flush() {
        this.writer.flush();
    }

    public void close() {
        this.writer.close();
    }

    /* access modifiers changed from: protected */
    public void startObject() {
        if (this.newLineProposed) {
            writeNewLine();
        }
        this.writer.write('{');
        startNewLine();
    }

    /* access modifiers changed from: protected */
    public void addLabel(String str) {
        if (this.newLineProposed) {
            writeNewLine();
        }
        this.writer.write('\"');
        writeText(str);
        this.writer.write("\":");
        if ((this.format.mode() & Format.SPACE_AFTER_LABEL) != 0) {
            this.writer.write(' ');
        }
    }

    /* access modifiers changed from: protected */
    public void addValue(String str, AbstractJsonWriter.Type type) {
        if (this.newLineProposed) {
            writeNewLine();
        }
        if (type == AbstractJsonWriter.Type.STRING) {
            this.writer.write('\"');
        }
        writeText(str);
        if (type == AbstractJsonWriter.Type.STRING) {
            this.writer.write('\"');
        }
    }

    /* access modifiers changed from: protected */
    public void startArray() {
        if (this.newLineProposed) {
            writeNewLine();
        }
        this.writer.write("[");
        startNewLine();
    }

    /* access modifiers changed from: protected */
    public void nextElement() {
        this.writer.write(",");
        writeNewLine();
    }

    /* access modifiers changed from: protected */
    public void endArray() {
        endNewLine();
        this.writer.write("]");
    }

    /* access modifiers changed from: protected */
    public void endObject() {
        endNewLine();
        this.writer.write("}");
    }

    private void startNewLine() {
        int i = this.depth + 1;
        this.depth = i;
        if (i > 0) {
            this.newLineProposed = true;
        }
    }

    private void endNewLine() {
        int i = this.depth;
        this.depth = i - 1;
        if (i <= 0) {
            return;
        }
        if ((this.format.mode() & Format.COMPACT_EMPTY_ELEMENT) == 0 || !this.newLineProposed) {
            writeNewLine();
        } else {
            this.newLineProposed = false;
        }
    }

    private void writeNewLine() {
        int i = this.depth;
        this.writer.write(this.format.getNewLine());
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                this.writer.write(this.format.getLineIndenter());
                i = i2;
            } else {
                this.newLineProposed = false;
                return;
            }
        }
    }

    private void writeText(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                this.writer.write("\\f");
            } else if (charAt == 13) {
                this.writer.write("\\r");
            } else if (charAt == '\"') {
                this.writer.write("\\\"");
            } else if (charAt != '\\') {
                switch (charAt) {
                    case 8:
                        this.writer.write("\\b");
                        break;
                    case 9:
                        this.writer.write("\\t");
                        break;
                    case 10:
                        this.writer.write("\\n");
                        break;
                    default:
                        if (charAt <= 31) {
                            this.writer.write("\\u");
                            String str2 = "000" + Integer.toHexString(charAt);
                            this.writer.write(str2.substring(str2.length() - 4));
                            break;
                        } else {
                            this.writer.write(charAt);
                            break;
                        }
                }
            } else {
                this.writer.write("\\\\");
            }
        }
    }

    public static class Format {
        public static int COMPACT_EMPTY_ELEMENT = 2;
        public static int SPACE_AFTER_LABEL = 1;
        private char[] lineIndenter;
        private final int mode;
        private final NameCoder nameCoder;
        private char[] newLine;

        public Format() {
            this(new char[]{' ', ' '}, new char[]{10}, SPACE_AFTER_LABEL | COMPACT_EMPTY_ELEMENT);
        }

        public Format(char[] cArr, char[] cArr2, int i) {
            this(cArr, cArr2, i, new NoNameCoder());
        }

        public Format(char[] cArr, char[] cArr2, int i, NameCoder nameCoder2) {
            this.lineIndenter = cArr;
            this.newLine = cArr2;
            this.mode = i;
            this.nameCoder = nameCoder2;
        }

        public char[] getLineIndenter() {
            return this.lineIndenter;
        }

        public char[] getNewLine() {
            return this.newLine;
        }

        public int mode() {
            return this.mode;
        }

        public NameCoder getNameCoder() {
            return this.nameCoder;
        }
    }
}
