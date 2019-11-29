package com.thoughtworks.xstream.io.binary;

import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.binary.Token;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class BinaryStreamWriter implements ExtendedHierarchicalStreamWriter {
    private final IdRegistry idRegistry = new IdRegistry();
    private final DataOutputStream out;
    private final Token.Formatter tokenFormatter = new Token.Formatter();

    public HierarchicalStreamWriter underlyingWriter() {
        return this;
    }

    public BinaryStreamWriter(OutputStream outputStream) {
        this.out = new DataOutputStream(outputStream);
    }

    public void startNode(String str) {
        write(new Token.StartNode(this.idRegistry.getId(str)));
    }

    public void startNode(String str, Class cls) {
        startNode(str);
    }

    public void addAttribute(String str, String str2) {
        write(new Token.Attribute(this.idRegistry.getId(str), str2));
    }

    public void setValue(String str) {
        write(new Token.Value(str));
    }

    public void endNode() {
        write(new Token.EndNode());
    }

    public void flush() {
        try {
            this.out.flush();
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public void close() {
        try {
            this.out.close();
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    /* access modifiers changed from: private */
    public void write(Token token) {
        try {
            this.tokenFormatter.write(this.out, token);
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    private class IdRegistry {
        private Map ids;
        private long nextId;

        private IdRegistry() {
            this.nextId = 0;
            this.ids = new HashMap();
        }

        public long getId(String str) {
            Long l = (Long) this.ids.get(str);
            if (l == null) {
                long j = this.nextId + 1;
                this.nextId = j;
                l = new Long(j);
                this.ids.put(str, l);
                BinaryStreamWriter.this.write(new Token.MapIdToValue(l.longValue(), str));
            }
            return l.longValue();
        }
    }
}
