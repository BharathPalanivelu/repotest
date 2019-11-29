package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.io.naming.NameCoder;
import java.io.Writer;

public class CompactWriter extends PrettyPrintWriter {
    /* access modifiers changed from: protected */
    public void endOfLine() {
    }

    public CompactWriter(Writer writer) {
        super(writer);
    }

    public CompactWriter(Writer writer, int i) {
        super(writer, i);
    }

    public CompactWriter(Writer writer, NameCoder nameCoder) {
        super(writer, nameCoder);
    }

    public CompactWriter(Writer writer, int i, NameCoder nameCoder) {
        super(writer, i, nameCoder);
    }

    public CompactWriter(Writer writer, XmlFriendlyReplacer xmlFriendlyReplacer) {
        super(writer, xmlFriendlyReplacer);
    }

    public CompactWriter(Writer writer, int i, XmlFriendlyReplacer xmlFriendlyReplacer) {
        super(writer, i, xmlFriendlyReplacer);
    }
}
