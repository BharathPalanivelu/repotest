package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.io.AttributeNameIterator;
import com.thoughtworks.xstream.io.naming.NameCoder;
import java.util.Iterator;

public abstract class AbstractPullReader extends AbstractXmlReader {
    protected static final int COMMENT = 4;
    protected static final int END_NODE = 2;
    protected static final int OTHER = 0;
    protected static final int START_NODE = 1;
    protected static final int TEXT = 3;
    private final FastStack elementStack;
    private final FastStack lookahead;
    private final FastStack lookback;
    private boolean marked;
    private final FastStack pool;

    /* access modifiers changed from: protected */
    public abstract String pullElementName();

    /* access modifiers changed from: protected */
    public abstract int pullNextEvent();

    /* access modifiers changed from: protected */
    public abstract String pullText();

    private static class Event {
        int type;
        String value;

        private Event() {
        }
    }

    protected AbstractPullReader(NameCoder nameCoder) {
        super(nameCoder);
        this.elementStack = new FastStack(16);
        this.pool = new FastStack(16);
        this.lookahead = new FastStack(4);
        this.lookback = new FastStack(4);
    }

    protected AbstractPullReader(XmlFriendlyReplacer xmlFriendlyReplacer) {
        this((NameCoder) xmlFriendlyReplacer);
    }

    public boolean hasMoreChildren() {
        int i;
        mark();
        do {
            i = readEvent().type;
            if (i == 1) {
                reset();
                return true;
            }
        } while (i != 2);
        reset();
        return false;
    }

    public void moveDown() {
        int size = this.elementStack.size();
        while (this.elementStack.size() <= size) {
            move();
            if (this.elementStack.size() < size) {
                throw new RuntimeException();
            }
        }
    }

    public void moveUp() {
        int size = this.elementStack.size();
        while (this.elementStack.size() >= size) {
            move();
        }
    }

    private void move() {
        Event readEvent = readEvent();
        this.pool.push(readEvent);
        int i = readEvent.type;
        if (i == 1) {
            this.elementStack.push(pullElementName());
        } else if (i == 2) {
            this.elementStack.pop();
        }
    }

    private Event readEvent() {
        if (this.marked) {
            if (this.lookback.hasStuff()) {
                return (Event) this.lookahead.push(this.lookback.pop());
            }
            return (Event) this.lookahead.push(readRealEvent());
        } else if (this.lookback.hasStuff()) {
            return (Event) this.lookback.pop();
        } else {
            return readRealEvent();
        }
    }

    private Event readRealEvent() {
        Event event = this.pool.hasStuff() ? (Event) this.pool.pop() : new Event();
        event.type = pullNextEvent();
        if (event.type == 3) {
            event.value = pullText();
        } else if (event.type == 1) {
            event.value = pullElementName();
        } else {
            event.value = null;
        }
        return event;
    }

    public void mark() {
        this.marked = true;
    }

    public void reset() {
        while (this.lookahead.hasStuff()) {
            this.lookback.push(this.lookahead.pop());
        }
        this.marked = false;
    }

    public String getValue() {
        mark();
        Event readEvent = readEvent();
        StringBuffer stringBuffer = null;
        String str = null;
        while (true) {
            if (readEvent.type == 3) {
                String str2 = readEvent.value;
                if (str2 != null && str2.length() > 0) {
                    if (str == null) {
                        str = str2;
                    } else {
                        if (stringBuffer == null) {
                            stringBuffer = new StringBuffer(str);
                        }
                        stringBuffer.append(str2);
                    }
                }
            } else if (readEvent.type != 4) {
                break;
            }
            readEvent = readEvent();
        }
        reset();
        if (stringBuffer != null) {
            return stringBuffer.toString();
        }
        return str == null ? "" : str;
    }

    public Iterator getAttributeNames() {
        return new AttributeNameIterator(this);
    }

    public String getNodeName() {
        return unescapeXmlName((String) this.elementStack.peek());
    }

    public String peekNextChild() {
        int i;
        mark();
        do {
            Event readEvent = readEvent();
            i = readEvent.type;
            if (i == 1) {
                reset();
                return readEvent.value;
            }
        } while (i != 2);
        reset();
        return null;
    }
}
