package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.io.AttributeNameIterator;
import com.thoughtworks.xstream.io.naming.NameCoder;
import java.util.Iterator;

public abstract class AbstractDocumentReader extends AbstractXmlReader implements DocumentReader {
    private Object current;
    private FastStack pointers;

    public void appendErrors(ErrorWriter errorWriter) {
    }

    public void close() {
    }

    /* access modifiers changed from: protected */
    public abstract Object getChild(int i);

    /* access modifiers changed from: protected */
    public abstract int getChildCount();

    /* access modifiers changed from: protected */
    public abstract Object getParent();

    /* access modifiers changed from: protected */
    public abstract void reassignCurrentElement(Object obj);

    protected AbstractDocumentReader(Object obj) {
        this(obj, (NameCoder) new XmlFriendlyNameCoder());
    }

    protected AbstractDocumentReader(Object obj, NameCoder nameCoder) {
        super(nameCoder);
        this.pointers = new FastStack(16);
        this.current = obj;
        this.pointers.push(new Pointer());
        reassignCurrentElement(this.current);
    }

    protected AbstractDocumentReader(Object obj, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(obj, (NameCoder) xmlFriendlyReplacer);
    }

    private static class Pointer {
        public int v;

        private Pointer() {
        }
    }

    public boolean hasMoreChildren() {
        return ((Pointer) this.pointers.peek()).v < getChildCount();
    }

    public void moveUp() {
        this.current = getParent();
        this.pointers.popSilently();
        reassignCurrentElement(this.current);
    }

    public void moveDown() {
        Pointer pointer = (Pointer) this.pointers.peek();
        this.pointers.push(new Pointer());
        this.current = getChild(pointer.v);
        pointer.v++;
        reassignCurrentElement(this.current);
    }

    public Iterator getAttributeNames() {
        return new AttributeNameIterator(this);
    }

    public Object getCurrent() {
        return this.current;
    }
}
