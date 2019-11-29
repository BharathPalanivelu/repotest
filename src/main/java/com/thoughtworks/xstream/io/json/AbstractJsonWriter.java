package com.thoughtworks.xstream.io.json;

import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.io.AbstractWriter;
import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.mapper.Mapper;
import java.io.Externalizable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;

public abstract class AbstractJsonWriter extends AbstractWriter {
    public static final int DROP_ROOT_MODE = 1;
    public static final int EXPLICIT_MODE = 4;
    public static final int IEEE_754_MODE = 8;
    private static final Set NUMBER_TYPES = new HashSet(Arrays.asList(new Class[]{Byte.TYPE, Byte.class, Short.TYPE, Short.class, Integer.TYPE, Integer.class, Long.TYPE, Long.class, Float.TYPE, Float.class, Double.TYPE, Double.class, BigInteger.class, BigDecimal.class}));
    private static final int STATE_END_ATTRIBUTES = 32;
    private static final int STATE_END_ELEMENTS = 256;
    private static final int STATE_END_OBJECT = 2;
    private static final int STATE_NEXT_ATTRIBUTE = 16;
    private static final int STATE_NEXT_ELEMENT = 128;
    private static final int STATE_ROOT = 1;
    private static final int STATE_SET_VALUE = 512;
    private static final int STATE_START_ATTRIBUTES = 8;
    private static final int STATE_START_ELEMENTS = 64;
    private static final int STATE_START_OBJECT = 4;
    public static final int STRICT_MODE = 2;
    private int expectedStates;
    private int mode;
    private FastStack stack;

    public static class Type {
        public static Type BOOLEAN = new Type();
        public static Type NULL = new Type();
        public static Type NUMBER = new Type();
        public static Type STRING = new Type();
    }

    /* access modifiers changed from: protected */
    public abstract void addLabel(String str);

    /* access modifiers changed from: protected */
    public abstract void addValue(String str, Type type);

    /* access modifiers changed from: protected */
    public abstract void endArray();

    /* access modifiers changed from: protected */
    public abstract void endObject();

    /* access modifiers changed from: protected */
    public abstract void nextElement();

    /* access modifiers changed from: protected */
    public abstract void startArray();

    /* access modifiers changed from: protected */
    public abstract void startObject();

    private static class StackElement {
        int status;
        final Class type;

        public StackElement(Class cls, int i) {
            this.type = cls;
            this.status = i;
        }
    }

    private static class IllegalWriterStateException extends IllegalStateException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public IllegalWriterStateException(int r3, int r4, java.lang.String r5) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Cannot turn from state "
                r0.append(r1)
                java.lang.String r3 = getState(r3)
                r0.append(r3)
                java.lang.String r3 = " into state "
                r0.append(r3)
                java.lang.String r3 = getState(r4)
                r0.append(r3)
                if (r5 != 0) goto L_0x0022
                java.lang.String r3 = ""
                goto L_0x0033
            L_0x0022:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = " for property "
                r3.append(r4)
                r3.append(r5)
                java.lang.String r3 = r3.toString()
            L_0x0033:
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.io.json.AbstractJsonWriter.IllegalWriterStateException.<init>(int, int, java.lang.String):void");
        }

        private static String getState(int i) {
            if (i == 1) {
                return Logger.ROOT_LOGGER_NAME;
            }
            if (i == 2) {
                return "END_OBJECT";
            }
            if (i == 4) {
                return "START_OBJECT";
            }
            if (i == 8) {
                return "START_ATTRIBUTES";
            }
            if (i == 16) {
                return "NEXT_ATTRIBUTE";
            }
            if (i == 32) {
                return "END_ATTRIBUTES";
            }
            if (i == 64) {
                return "START_ELEMENTS";
            }
            if (i == 128) {
                return "NEXT_ELEMENT";
            }
            if (i == 256) {
                return "END_ELEMENTS";
            }
            if (i == 512) {
                return "SET_VALUE";
            }
            throw new IllegalArgumentException("Unknown state provided: " + i + ", cannot create message for IllegalWriterStateException");
        }
    }

    public AbstractJsonWriter() {
        this((NameCoder) new NoNameCoder());
    }

    public AbstractJsonWriter(int i) {
        this(i, new NoNameCoder());
    }

    public AbstractJsonWriter(NameCoder nameCoder) {
        this(0, nameCoder);
    }

    public AbstractJsonWriter(int i, NameCoder nameCoder) {
        super(nameCoder);
        this.stack = new FastStack(16);
        this.mode = (i & 4) > 0 ? 4 : i;
        this.stack.push(new StackElement((Class) null, 1));
        this.expectedStates = 4;
    }

    public void startNode(String str, Class cls) {
        if (str != null) {
            FastStack fastStack = this.stack;
            fastStack.push(new StackElement(cls, ((StackElement) fastStack.peek()).status));
            handleCheckedStateTransition(4, str, (String) null);
            this.expectedStates = 661;
            return;
        }
        throw new NullPointerException("name");
    }

    public void startNode(String str) {
        startNode(str, (Class) null);
    }

    public void addAttribute(String str, String str2) {
        handleCheckedStateTransition(16, str, str2);
        this.expectedStates = 661;
    }

    public void setValue(String str) {
        Class<Character> cls = ((StackElement) this.stack.peek()).type;
        if ((cls == Character.class || cls == Character.TYPE) && "".equals(str)) {
            str = "\u0000";
        }
        handleCheckedStateTransition(512, (String) null, str);
        this.expectedStates = 129;
    }

    public void endNode() {
        int size = this.stack.size();
        int i = size > 2 ? 128 : 1;
        handleCheckedStateTransition(i, (String) null, (String) null);
        this.stack.pop();
        ((StackElement) this.stack.peek()).status = i;
        this.expectedStates = 4;
        if (size > 2) {
            this.expectedStates |= 129;
        }
    }

    private void handleCheckedStateTransition(int i, String str, String str2) {
        StackElement stackElement = (StackElement) this.stack.peek();
        if ((this.expectedStates & i) != 0) {
            stackElement.status = handleStateTransition(stackElement.status, i, str, str2);
            return;
        }
        throw new IllegalWriterStateException(stackElement.status, i, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0226, code lost:
        if ((r1.mode & 4) != 0) goto L_0x022a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleStateTransition(int r18, int r19, java.lang.String r20, java.lang.String r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            com.thoughtworks.xstream.core.util.FastStack r5 = r1.stack
            int r5 = r5.size()
            com.thoughtworks.xstream.core.util.FastStack r6 = r1.stack
            java.lang.Object r6 = r6.peek()
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$StackElement r6 = (com.thoughtworks.xstream.io.json.AbstractJsonWriter.StackElement) r6
            java.lang.Class r6 = r6.type
            r7 = 0
            r8 = 1
            if (r5 <= r8) goto L_0x0026
            boolean r9 = r1.isArray(r6)
            if (r9 == 0) goto L_0x0026
            r9 = 1
            goto L_0x0027
        L_0x0026:
            r9 = 0
        L_0x0027:
            if (r5 <= r8) goto L_0x003c
            com.thoughtworks.xstream.core.util.FastStack r10 = r1.stack
            int r11 = r5 + -2
            java.lang.Object r10 = r10.get(r11)
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$StackElement r10 = (com.thoughtworks.xstream.io.json.AbstractJsonWriter.StackElement) r10
            java.lang.Class r10 = r10.type
            boolean r10 = r1.isArray(r10)
            if (r10 == 0) goto L_0x003c
            r7 = 1
        L_0x003c:
            r10 = 64
            r11 = 4
            if (r0 == r8) goto L_0x0353
            r13 = 128(0x80, float:1.794E-43)
            r14 = 2
            if (r0 == r14) goto L_0x0326
            r15 = 8
            r14 = 32
            r12 = 16
            r8 = 512(0x200, float:7.175E-43)
            if (r0 == r11) goto L_0x02c9
            java.lang.String r16 = "@"
            java.lang.String r11 = ""
            if (r0 == r15) goto L_0x01e9
            if (r0 == r12) goto L_0x01eb
            r12 = 256(0x100, float:3.59E-43)
            if (r0 == r14) goto L_0x01ca
            if (r0 == r10) goto L_0x0111
            if (r0 == r13) goto L_0x00b5
            if (r0 == r12) goto L_0x009c
            if (r0 != r8) goto L_0x0096
            r4 = 1
            if (r2 == r4) goto L_0x0087
            if (r2 == r13) goto L_0x007d
            if (r2 != r12) goto L_0x0077
            int r0 = r1.mode
            r3 = 4
            r0 = r0 & r3
            if (r0 != 0) goto L_0x0076
            if (r9 == 0) goto L_0x0076
            r17.endArray()
        L_0x0076:
            return r2
        L_0x0077:
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException r4 = new com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException
            r4.<init>(r0, r2, r3)
            throw r4
        L_0x007d:
            r3 = 0
            int r0 = r1.handleStateTransition(r0, r12, r3, r3)
            r4 = 2
            r1.handleStateTransition(r0, r4, r3, r3)
            return r2
        L_0x0087:
            r3 = 0
            r4 = 2
            int r0 = r1.handleStateTransition(r0, r12, r3, r3)
            int r0 = r1.handleStateTransition(r0, r4, r3, r3)
            r4 = 1
            r1.handleStateTransition(r0, r4, r3, r3)
            return r2
        L_0x0096:
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException r4 = new com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException
            r4.<init>(r0, r2, r3)
            throw r4
        L_0x009c:
            r4 = 2
            if (r2 != r4) goto L_0x00af
            int r0 = r1.mode
            r3 = 4
            r0 = r0 & r3
            if (r0 == 0) goto L_0x00ae
            r17.endArray()
            r17.endArray()
            r17.endObject()
        L_0x00ae:
            return r2
        L_0x00af:
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException r4 = new com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException
            r4.<init>(r0, r2, r3)
            throw r4
        L_0x00b5:
            r10 = 1
            if (r2 == r10) goto L_0x0106
            r10 = 2
            if (r2 == r10) goto L_0x00d3
            r10 = 4
            if (r2 == r10) goto L_0x00d5
            if (r2 == r13) goto L_0x00d3
            if (r2 != r12) goto L_0x00cd
            int r0 = r1.mode
            r0 = r0 & r10
            if (r0 != 0) goto L_0x00cc
            if (r9 == 0) goto L_0x00cc
            r17.endArray()
        L_0x00cc:
            return r2
        L_0x00cd:
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException r4 = new com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException
            r4.<init>(r0, r2, r3)
            throw r4
        L_0x00d3:
            r3 = 0
            goto L_0x00f2
        L_0x00d5:
            r17.nextElement()
            if (r7 != 0) goto L_0x0111
            int r10 = r1.mode
            r14 = 4
            r10 = r10 & r14
            if (r10 != 0) goto L_0x0111
            java.lang.String r0 = r1.encodeNode(r3)
            r1.addLabel(r0)
            int r0 = r1.mode
            r0 = r0 & r14
            if (r0 != 0) goto L_0x00f1
            if (r9 == 0) goto L_0x00f1
            r17.startArray()
        L_0x00f1:
            return r2
        L_0x00f2:
            int r0 = r1.handleStateTransition(r0, r12, r3, r3)
            r10 = 2
            r1.handleStateTransition(r0, r10, r3, r3)
            int r0 = r1.mode
            r3 = 4
            r0 = r0 & r3
            if (r0 != 0) goto L_0x0105
            if (r9 != 0) goto L_0x0105
            r17.endObject()
        L_0x0105:
            return r2
        L_0x0106:
            r3 = 0
            r10 = 2
            int r0 = r1.handleStateTransition(r0, r10, r3, r3)
            r4 = 1
            r1.handleStateTransition(r0, r4, r3, r3)
            return r2
        L_0x0111:
            r10 = 2
            r14 = 4
            if (r2 == r14) goto L_0x0192
            if (r2 == r13) goto L_0x0182
            if (r2 == r12) goto L_0x0182
            if (r2 != r8) goto L_0x017c
            int r0 = r1.mode
            r0 = r0 & r10
            if (r0 == 0) goto L_0x012b
            if (r5 == r10) goto L_0x0123
            goto L_0x012b
        L_0x0123:
            com.thoughtworks.xstream.converters.ConversionException r0 = new com.thoughtworks.xstream.converters.ConversionException
            java.lang.String r2 = "Single value cannot be root element"
            r0.<init>((java.lang.String) r2)
            throw r0
        L_0x012b:
            if (r4 != 0) goto L_0x0148
            java.lang.Class<com.thoughtworks.xstream.mapper.Mapper$Null> r0 = com.thoughtworks.xstream.mapper.Mapper.Null.class
            if (r6 != r0) goto L_0x0139
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$Type r0 = com.thoughtworks.xstream.io.json.AbstractJsonWriter.Type.NULL
            java.lang.String r3 = "null"
            r1.addValue(r3, r0)
            goto L_0x017b
        L_0x0139:
            int r0 = r1.mode
            r3 = 4
            r0 = r0 & r3
            if (r0 != 0) goto L_0x017b
            if (r9 != 0) goto L_0x017b
            r17.startObject()
            r17.endObject()
            goto L_0x017b
        L_0x0148:
            int r0 = r1.mode
            r0 = r0 & r15
            if (r0 == 0) goto L_0x0174
            java.lang.Class r0 = java.lang.Long.TYPE
            if (r6 == r0) goto L_0x0155
            java.lang.Class<java.lang.Long> r0 = java.lang.Long.class
            if (r6 != r0) goto L_0x0174
        L_0x0155:
            long r7 = java.lang.Long.parseLong(r21)
            r9 = 9007199254740992(0x20000000000000, double:4.450147717014403E-308)
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 > 0) goto L_0x016e
            r9 = -9007199254740992(0xffe0000000000000, double:-8.98846567431158E307)
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 >= 0) goto L_0x0166
            goto L_0x016e
        L_0x0166:
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$Type r0 = r1.getType(r6)
            r1.addValue(r4, r0)
            goto L_0x017b
        L_0x016e:
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$Type r0 = com.thoughtworks.xstream.io.json.AbstractJsonWriter.Type.STRING
            r1.addValue(r4, r0)
            goto L_0x017b
        L_0x0174:
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$Type r0 = r1.getType(r6)
            r1.addValue(r4, r0)
        L_0x017b:
            return r2
        L_0x017c:
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException r4 = new com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException
            r4.<init>(r0, r2, r3)
            throw r4
        L_0x0182:
            int r0 = r1.mode
            r3 = 4
            r0 = r0 & r3
            if (r0 != 0) goto L_0x0191
            if (r9 == 0) goto L_0x018e
            r17.endArray()
            goto L_0x0191
        L_0x018e:
            r17.endObject()
        L_0x0191:
            return r2
        L_0x0192:
            int r0 = r1.mode
            r6 = 1
            r0 = r0 & r6
            if (r0 == 0) goto L_0x019e
            r0 = 2
            if (r5 <= r0) goto L_0x019c
            goto L_0x019e
        L_0x019c:
            r3 = 4
            goto L_0x01bf
        L_0x019e:
            if (r7 == 0) goto L_0x01a6
            int r0 = r1.mode
            r5 = 4
            r0 = r0 & r5
            if (r0 == 0) goto L_0x01b6
        L_0x01a6:
            boolean r0 = r11.equals(r4)
            if (r0 != 0) goto L_0x01af
            r17.startObject()
        L_0x01af:
            java.lang.String r0 = r1.encodeNode(r3)
            r1.addLabel(r0)
        L_0x01b6:
            int r0 = r1.mode
            r3 = 4
            r0 = r0 & r3
            if (r0 == 0) goto L_0x01bf
            r17.startArray()
        L_0x01bf:
            int r0 = r1.mode
            r0 = r0 & r3
            if (r0 != 0) goto L_0x01c9
            if (r9 == 0) goto L_0x01c9
            r17.startArray()
        L_0x01c9:
            return r2
        L_0x01ca:
            r4 = 2
            if (r2 == r4) goto L_0x01df
            if (r2 != r10) goto L_0x01d9
            int r0 = r1.mode
            r3 = 4
            r0 = r0 & r3
            if (r0 != 0) goto L_0x01e8
            r17.nextElement()
            goto L_0x01e8
        L_0x01d9:
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException r4 = new com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException
            r4.<init>(r0, r2, r3)
            throw r4
        L_0x01df:
            r0 = 0
            int r3 = r1.handleStateTransition(r10, r12, r0, r0)
            r4 = 2
            r1.handleStateTransition(r3, r4, r0, r0)
        L_0x01e8:
            return r2
        L_0x01e9:
            if (r2 == r12) goto L_0x02a0
        L_0x01eb:
            r5 = 1
            if (r2 == r5) goto L_0x0291
            r5 = 4
            if (r2 == r5) goto L_0x01f9
            if (r2 == r12) goto L_0x0220
            if (r2 == r14) goto L_0x020b
            if (r2 == r13) goto L_0x0201
            if (r2 != r8) goto L_0x01fb
        L_0x01f9:
            r5 = 0
            goto L_0x0250
        L_0x01fb:
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException r4 = new com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException
            r4.<init>(r0, r2, r3)
            throw r4
        L_0x0201:
            r3 = 0
            int r0 = r1.handleStateTransition(r0, r14, r3, r3)
            r4 = 2
            r1.handleStateTransition(r0, r4, r3, r3)
            return r2
        L_0x020b:
            int r3 = r1.mode
            r4 = 4
            r3 = r3 & r4
            if (r3 == 0) goto L_0x021f
            if (r0 != r12) goto L_0x0216
            r17.endObject()
        L_0x0216:
            r17.endArray()
            r17.nextElement()
            r17.startArray()
        L_0x021f:
            return r2
        L_0x0220:
            if (r9 == 0) goto L_0x0229
            int r0 = r1.mode
            r5 = 4
            r0 = r0 & r5
            if (r0 == 0) goto L_0x024f
            goto L_0x022a
        L_0x0229:
            r5 = 4
        L_0x022a:
            r17.nextElement()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r6 = r1.mode
            r5 = r5 & r6
            if (r5 != 0) goto L_0x0239
            r11 = r16
        L_0x0239:
            r0.append(r11)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r1.encodeAttribute(r0)
            r1.addLabel(r0)
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$Type r0 = com.thoughtworks.xstream.io.json.AbstractJsonWriter.Type.STRING
            r1.addValue(r4, r0)
        L_0x024f:
            return r2
        L_0x0250:
            int r0 = r1.handleStateTransition(r0, r14, r5, r5)
            int r0 = r1.handleStateTransition(r0, r10, r5, r5)
            r5 = 2
            if (r2 == r5) goto L_0x0287
            r5 = 4
            if (r2 == r5) goto L_0x027c
            if (r2 == r8) goto L_0x0261
            goto L_0x0290
        L_0x0261:
            int r3 = r1.mode
            r3 = r3 & r5
            if (r3 != 0) goto L_0x026f
            java.lang.String r3 = "$"
            java.lang.String r3 = r1.encodeNode(r3)
            r1.addLabel(r3)
        L_0x026f:
            r3 = 0
            r1.handleStateTransition(r0, r8, r3, r4)
            int r0 = r1.mode
            r0 = r0 & r5
            if (r0 != 0) goto L_0x0290
            r17.endObject()
            goto L_0x0290
        L_0x027c:
            int r4 = r1.mode
            r4 = r4 & r5
            if (r4 != 0) goto L_0x0282
            goto L_0x0283
        L_0x0282:
            r11 = 0
        L_0x0283:
            r1.handleStateTransition(r0, r5, r3, r11)
            goto L_0x0290
        L_0x0287:
            r3 = 0
            int r0 = r1.handleStateTransition(r0, r8, r3, r3)
            r4 = 2
            r1.handleStateTransition(r0, r4, r3, r3)
        L_0x0290:
            return r2
        L_0x0291:
            r3 = 0
            r4 = 2
            int r0 = r1.handleStateTransition(r0, r14, r3, r3)
            int r0 = r1.handleStateTransition(r0, r4, r3, r3)
            r4 = 1
            r1.handleStateTransition(r0, r4, r3, r3)
            return r2
        L_0x02a0:
            if (r3 == 0) goto L_0x02c8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r5 = r1.mode
            r6 = 4
            r5 = r5 & r6
            if (r5 != 0) goto L_0x02af
            r11 = r16
        L_0x02af:
            r0.append(r11)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r17.startObject()
            java.lang.String r0 = r1.encodeAttribute(r0)
            r1.addLabel(r0)
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$Type r0 = com.thoughtworks.xstream.io.json.AbstractJsonWriter.Type.STRING
            r1.addValue(r4, r0)
        L_0x02c8:
            return r2
        L_0x02c9:
            r5 = 1
            if (r2 == r5) goto L_0x02f9
            r6 = 4
            if (r2 == r6) goto L_0x02fa
            if (r2 == r15) goto L_0x02f0
            if (r2 == r12) goto L_0x02de
            if (r2 == r13) goto L_0x02fa
            if (r2 != r8) goto L_0x02d8
            goto L_0x02fa
        L_0x02d8:
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException r4 = new com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException
            r4.<init>(r0, r2, r3)
            throw r4
        L_0x02de:
            int r5 = r1.mode
            r5 = r5 & r6
            if (r5 != 0) goto L_0x02e7
            if (r9 != 0) goto L_0x02e6
            goto L_0x02e7
        L_0x02e6:
            return r6
        L_0x02e7:
            r5 = 0
            int r0 = r1.handleStateTransition(r0, r15, r5, r5)
            r1.handleStateTransition(r0, r12, r3, r4)
            return r2
        L_0x02f0:
            int r0 = r1.mode
            r0 = r0 & r6
            if (r0 == 0) goto L_0x02f8
            r17.startArray()
        L_0x02f8:
            return r2
        L_0x02f9:
            r6 = 4
        L_0x02fa:
            if (r7 == 0) goto L_0x0304
            int r5 = r1.mode
            r5 = r5 & r6
            if (r5 == 0) goto L_0x0302
            goto L_0x0304
        L_0x0302:
            r5 = 0
            goto L_0x030c
        L_0x0304:
            r5 = 0
            int r0 = r1.handleStateTransition(r0, r15, r5, r5)
            r1.handleStateTransition(r0, r14, r5, r5)
        L_0x030c:
            r0 = 1
            if (r2 == r0) goto L_0x031e
            if (r2 == r6) goto L_0x031a
            if (r2 == r13) goto L_0x031e
            if (r2 == r8) goto L_0x0316
            goto L_0x0325
        L_0x0316:
            r1.handleStateTransition(r10, r8, r5, r4)
            goto L_0x0325
        L_0x031a:
            r1.handleStateTransition(r10, r6, r3, r5)
            goto L_0x0325
        L_0x031e:
            int r0 = r1.handleStateTransition(r10, r8, r5, r5)
            r1.handleStateTransition(r0, r2, r5, r5)
        L_0x0325:
            return r2
        L_0x0326:
            r6 = 4
            r4 = 1
            if (r2 == r4) goto L_0x0341
            if (r2 == r6) goto L_0x0338
            if (r2 != r13) goto L_0x0332
            r17.nextElement()
            return r2
        L_0x0332:
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException r4 = new com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException
            r4.<init>(r0, r2, r3)
            throw r4
        L_0x0338:
            r4 = 0
            int r0 = r1.handleStateTransition(r0, r13, r4, r4)
            r1.handleStateTransition(r0, r6, r3, r4)
            return r2
        L_0x0341:
            int r0 = r1.mode
            r3 = 1
            r0 = r0 & r3
            if (r0 == 0) goto L_0x034a
            r0 = 2
            if (r5 <= r0) goto L_0x0352
        L_0x034a:
            int r0 = r1.mode
            r0 = r0 & r6
            if (r0 != 0) goto L_0x0352
            r17.endObject()
        L_0x0352:
            return r2
        L_0x0353:
            r6 = 4
            if (r2 != r6) goto L_0x035b
            r0 = 0
            r1.handleStateTransition(r10, r6, r3, r0)     // Catch:{ Throwable -> 0x0361 }
            return r2
        L_0x035b:
            com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException r4 = new com.thoughtworks.xstream.io.json.AbstractJsonWriter$IllegalWriterStateException
            r4.<init>(r0, r2, r3)
            throw r4
        L_0x0361:
            r0 = move-exception
            r2 = r0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.io.json.AbstractJsonWriter.handleStateTransition(int, int, java.lang.String, java.lang.String):int");
    }

    /* access modifiers changed from: protected */
    public Type getType(Class cls) {
        if (cls == Mapper.Null.class) {
            return Type.NULL;
        }
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            return Type.BOOLEAN;
        }
        return NUMBER_TYPES.contains(cls) ? Type.NUMBER : Type.STRING;
    }

    /* access modifiers changed from: protected */
    public boolean isArray(Class cls) {
        return cls != null && (cls.isArray() || Collection.class.isAssignableFrom(cls) || Externalizable.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls) || Map.Entry.class.isAssignableFrom(cls));
    }
}
