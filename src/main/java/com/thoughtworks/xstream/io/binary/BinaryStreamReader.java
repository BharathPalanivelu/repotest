package com.thoughtworks.xstream.io.binary;

import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.binary.Token;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BinaryStreamReader implements ExtendedHierarchicalStreamReader {
    private final ReaderDepthState depthState = new ReaderDepthState();
    private final IdRegistry idRegistry = new IdRegistry();
    private final DataInputStream in;
    private Token pushback;
    private final Token.Formatter tokenFormatter = new Token.Formatter();

    public void appendErrors(ErrorWriter errorWriter) {
    }

    public HierarchicalStreamReader underlyingReader() {
        return this;
    }

    public BinaryStreamReader(InputStream inputStream) {
        this.in = new DataInputStream(inputStream);
        moveDown();
    }

    public boolean hasMoreChildren() {
        return this.depthState.hasMoreChildren();
    }

    public String getNodeName() {
        return this.depthState.getName();
    }

    public String getValue() {
        return this.depthState.getValue();
    }

    public String getAttribute(String str) {
        return this.depthState.getAttribute(str);
    }

    public String getAttribute(int i) {
        return this.depthState.getAttribute(i);
    }

    public int getAttributeCount() {
        return this.depthState.getAttributeCount();
    }

    public String getAttributeName(int i) {
        return this.depthState.getAttributeName(i);
    }

    public Iterator getAttributeNames() {
        return this.depthState.getAttributeNames();
    }

    public void moveDown() {
        this.depthState.push();
        Token readToken = readToken();
        if (readToken.getType() == 3) {
            this.depthState.setName(this.idRegistry.get(readToken.getId()));
            while (true) {
                Token readToken2 = readToken();
                byte type = readToken2.getType();
                if (type == 3) {
                    this.depthState.setHasMoreChildren(true);
                    pushBack(readToken2);
                    return;
                } else if (type == 4) {
                    this.depthState.setHasMoreChildren(false);
                    pushBack(readToken2);
                    return;
                } else if (type == 5) {
                    this.depthState.addAttribute(this.idRegistry.get(readToken2.getId()), readToken2.getValue());
                } else if (type == 6) {
                    this.depthState.setValue(readToken2.getValue());
                } else {
                    throw new StreamException("Unexpected token " + readToken2);
                }
            }
        } else {
            throw new StreamException("Expected StartNode");
        }
    }

    public void moveUp() {
        this.depthState.pop();
        int i = 0;
        while (true) {
            byte type = readToken().getType();
            if (type == 3) {
                i++;
            } else if (type != 4) {
                continue;
            } else if (i == 0) {
                break;
            } else {
                i--;
            }
        }
        Token readToken = readToken();
        byte type2 = readToken.getType();
        if (type2 == 3) {
            this.depthState.setHasMoreChildren(true);
        } else if (type2 == 4) {
            this.depthState.setHasMoreChildren(false);
        } else {
            throw new StreamException("Unexpected token " + readToken);
        }
        pushBack(readToken);
    }

    private Token readToken() {
        Token token = this.pushback;
        if (token == null) {
            try {
                Token read = this.tokenFormatter.read(this.in);
                if (read.getType() != 2) {
                    return read;
                }
                this.idRegistry.put(read.getId(), read.getValue());
                return readToken();
            } catch (IOException e2) {
                throw new StreamException((Throwable) e2);
            }
        } else {
            this.pushback = null;
            return token;
        }
    }

    public void pushBack(Token token) {
        if (this.pushback == null) {
            this.pushback = token;
            return;
        }
        throw new Error("Cannot push more than one token back");
    }

    public void close() {
        try {
            this.in.close();
        } catch (IOException e2) {
            throw new StreamException((Throwable) e2);
        }
    }

    public String peekNextChild() {
        if (this.depthState.hasMoreChildren()) {
            return this.idRegistry.get(this.pushback.getId());
        }
        return null;
    }

    private static class IdRegistry {
        private Map map;

        private IdRegistry() {
            this.map = new HashMap();
        }

        public void put(long j, String str) {
            this.map.put(new Long(j), str);
        }

        public String get(long j) {
            String str = (String) this.map.get(new Long(j));
            if (str != null) {
                return str;
            }
            throw new StreamException("Unknown ID : " + j);
        }
    }
}
