package com.thoughtworks.xstream.io;

import com.thoughtworks.xstream.core.util.FastStack;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StatefulWriter extends WriterWrapper {
    public static int STATE_CLOSED = 4;
    public static int STATE_NODE_END = 3;
    public static int STATE_NODE_START = 1;
    public static int STATE_OPEN = 0;
    public static int STATE_VALUE = 2;
    private transient FastStack attributes = new FastStack(16);
    private transient int balance;
    private transient int state = STATE_OPEN;

    public StatefulWriter(HierarchicalStreamWriter hierarchicalStreamWriter) {
        super(hierarchicalStreamWriter);
    }

    public void startNode(String str) {
        startNodeCommon();
        super.startNode(str);
    }

    public void startNode(String str, Class cls) {
        startNodeCommon();
        super.startNode(str, cls);
    }

    private void startNodeCommon() {
        checkClosed();
        if (this.state != STATE_VALUE) {
            this.state = STATE_NODE_START;
            this.balance++;
            this.attributes.push(new HashSet());
            return;
        }
        throw new StreamException((Throwable) new IllegalStateException("Opening node after writing text"));
    }

    public void addAttribute(String str, String str2) {
        checkClosed();
        if (this.state == STATE_NODE_START) {
            Set set = (Set) this.attributes.peek();
            if (!set.contains(str)) {
                set.add(str);
                super.addAttribute(str, str2);
                return;
            }
            throw new StreamException((Throwable) new IllegalStateException("Writing attribute '" + str + "' twice"));
        }
        throw new StreamException((Throwable) new IllegalStateException("Writing attribute '" + str + "' without an opened node"));
    }

    public void setValue(String str) {
        checkClosed();
        if (this.state == STATE_NODE_START) {
            this.state = STATE_VALUE;
            super.setValue(str);
            return;
        }
        throw new StreamException((Throwable) new IllegalStateException("Writing text without an opened node"));
    }

    public void endNode() {
        checkClosed();
        int i = this.balance;
        this.balance = i - 1;
        if (i != 0) {
            this.attributes.popSilently();
            this.state = STATE_NODE_END;
            super.endNode();
            return;
        }
        throw new StreamException((Throwable) new IllegalStateException("Unbalanced node"));
    }

    public void flush() {
        checkClosed();
        super.flush();
    }

    public void close() {
        if (this.state != STATE_NODE_END) {
            int i = STATE_OPEN;
        }
        this.state = STATE_CLOSED;
        super.close();
    }

    private void checkClosed() {
        if (this.state == STATE_CLOSED) {
            throw new StreamException((Throwable) new IOException("Writing on a closed stream"));
        }
    }

    public int state() {
        return this.state;
    }

    private Object readResolve() {
        this.attributes = new FastStack(16);
        return this;
    }
}
