package com.thoughtworks.xstream.io.xml;

import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.io.naming.NameCoder;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDocumentWriter extends AbstractXmlWriter implements DocumentWriter {
    private final FastStack nodeStack;
    private final List result;

    public void close() {
    }

    /* access modifiers changed from: protected */
    public abstract Object createNode(String str);

    public void endNodeInternally() {
    }

    public void flush() {
    }

    public AbstractDocumentWriter(Object obj, NameCoder nameCoder) {
        super(nameCoder);
        this.result = new ArrayList();
        this.nodeStack = new FastStack(16);
        if (obj != null) {
            this.nodeStack.push(obj);
            this.result.add(obj);
        }
    }

    public AbstractDocumentWriter(Object obj, XmlFriendlyReplacer xmlFriendlyReplacer) {
        this(obj, (NameCoder) xmlFriendlyReplacer);
    }

    public final void startNode(String str) {
        this.nodeStack.push(createNode(str));
    }

    public final void endNode() {
        endNodeInternally();
        Object pop = this.nodeStack.pop();
        if (this.nodeStack.size() == 0) {
            this.result.add(pop);
        }
    }

    /* access modifiers changed from: protected */
    public final Object getCurrent() {
        return this.nodeStack.peek();
    }

    public List getTopLevelNodes() {
        return this.result;
    }
}
