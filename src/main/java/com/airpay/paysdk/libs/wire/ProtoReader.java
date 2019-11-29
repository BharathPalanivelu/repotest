package com.airpay.paysdk.libs.wire;

import com.facebook.common.time.Clock;
import e.e;
import e.f;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;

public final class ProtoReader {
    private static final int FIELD_ENCODING_MASK = 7;
    private static final int RECURSION_LIMIT = 65;
    private static final int STATE_END_GROUP = 4;
    private static final int STATE_FIXED32 = 5;
    private static final int STATE_FIXED64 = 1;
    private static final int STATE_LENGTH_DELIMITED = 2;
    private static final int STATE_PACKED_TAG = 7;
    private static final int STATE_START_GROUP = 3;
    private static final int STATE_TAG = 6;
    private static final int STATE_VARINT = 0;
    static final int TAG_FIELD_ENCODING_BITS = 3;
    private long limit = Clock.MAX_TIME;
    private FieldEncoding nextFieldEncoding;
    private long pos = 0;
    private long pushedLimit = -1;
    private int recursionDepth;
    private final e source;
    private int state = 2;
    private int tag = -1;

    public ProtoReader(e eVar) {
        this.source = eVar;
    }

    public long beginMessage() throws IOException {
        if (this.state == 2) {
            int i = this.recursionDepth + 1;
            this.recursionDepth = i;
            if (i <= 65) {
                long j = this.pushedLimit;
                this.pushedLimit = -1;
                this.state = 6;
                return j;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public void endMessage(long j) throws IOException {
        if (this.state == 6) {
            int i = this.recursionDepth - 1;
            this.recursionDepth = i;
            if (i < 0 || this.pushedLimit != -1) {
                throw new IllegalStateException("No corresponding call to beginMessage()");
            } else if (this.pos == this.limit || this.recursionDepth == 0) {
                this.limit = j;
            } else {
                throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
            }
        } else {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
    }

    public int nextTag() throws IOException {
        int i = this.state;
        if (i == 7) {
            this.state = 2;
            return this.tag;
        } else if (i == 6) {
            while (this.pos < this.limit && !this.source.f()) {
                int internalReadVarint32 = internalReadVarint32();
                if (internalReadVarint32 != 0) {
                    this.tag = internalReadVarint32 >> 3;
                    int i2 = internalReadVarint32 & 7;
                    if (i2 == 0) {
                        this.nextFieldEncoding = FieldEncoding.VARINT;
                        this.state = 0;
                        return this.tag;
                    } else if (i2 == 1) {
                        this.nextFieldEncoding = FieldEncoding.FIXED64;
                        this.state = 1;
                        return this.tag;
                    } else if (i2 == 2) {
                        this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
                        this.state = 2;
                        int internalReadVarint322 = internalReadVarint32();
                        if (internalReadVarint322 < 0) {
                            throw new ProtocolException("Negative length: " + internalReadVarint322);
                        } else if (this.pushedLimit == -1) {
                            this.pushedLimit = this.limit;
                            this.limit = this.pos + ((long) internalReadVarint322);
                            if (this.limit <= this.pushedLimit) {
                                return this.tag;
                            }
                            throw new EOFException();
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (i2 == 3) {
                        skipGroup(this.tag);
                    } else if (i2 == 4) {
                        throw new ProtocolException("Unexpected end group");
                    } else if (i2 == 5) {
                        this.nextFieldEncoding = FieldEncoding.FIXED32;
                        this.state = 5;
                        return this.tag;
                    } else {
                        throw new ProtocolException("Unexpected field encoding: " + i2);
                    }
                } else {
                    throw new ProtocolException("Unexpected tag 0");
                }
            }
            return -1;
        } else {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
    }

    public FieldEncoding peekFieldEncoding() {
        return this.nextFieldEncoding;
    }

    public void skip() throws IOException {
        int i = this.state;
        if (i == 0) {
            readVarint64();
        } else if (i == 1) {
            readFixed64();
        } else if (i == 2) {
            this.source.i(beforeLengthDelimitedScalar());
        } else if (i == 5) {
            readFixed32();
        } else {
            throw new IllegalStateException("Unexpected call to skip()");
        }
    }

    private void skipGroup(int i) throws IOException {
        while (this.pos < this.limit && !this.source.f()) {
            int internalReadVarint32 = internalReadVarint32();
            if (internalReadVarint32 != 0) {
                int i2 = internalReadVarint32 >> 3;
                int i3 = internalReadVarint32 & 7;
                if (i3 == 0) {
                    this.state = 0;
                    readVarint64();
                } else if (i3 == 1) {
                    this.state = 1;
                    readFixed64();
                } else if (i3 == 2) {
                    long internalReadVarint322 = (long) internalReadVarint32();
                    this.pos += internalReadVarint322;
                    this.source.i(internalReadVarint322);
                } else if (i3 == 3) {
                    skipGroup(i2);
                } else if (i3 != 4) {
                    if (i3 == 5) {
                        this.state = 5;
                        readFixed32();
                    } else {
                        throw new ProtocolException("Unexpected field encoding: " + i3);
                    }
                } else if (i2 != i) {
                    throw new ProtocolException("Unexpected end group");
                } else {
                    return;
                }
            } else {
                throw new ProtocolException("Unexpected tag 0");
            }
        }
        throw new EOFException();
    }

    public f readBytes() throws IOException {
        return this.source.d(beforeLengthDelimitedScalar());
    }

    public String readString() throws IOException {
        return this.source.e(beforeLengthDelimitedScalar());
    }

    public int readVarint32() throws IOException {
        int i = this.state;
        if (i == 0 || i == 2) {
            int internalReadVarint32 = internalReadVarint32();
            afterPackableScalar(0);
            return internalReadVarint32;
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    private int internalReadVarint32() throws IOException {
        int i;
        this.pos++;
        byte i2 = this.source.i();
        if (i2 >= 0) {
            return i2;
        }
        byte b2 = i2 & Byte.MAX_VALUE;
        this.pos++;
        byte i3 = this.source.i();
        if (i3 >= 0) {
            i = i3 << 7;
        } else {
            b2 |= (i3 & Byte.MAX_VALUE) << 7;
            this.pos++;
            byte i4 = this.source.i();
            if (i4 >= 0) {
                i = i4 << 14;
            } else {
                b2 |= (i4 & Byte.MAX_VALUE) << 14;
                this.pos++;
                byte i5 = this.source.i();
                if (i5 >= 0) {
                    i = i5 << 21;
                } else {
                    byte b3 = b2 | ((i5 & Byte.MAX_VALUE) << 21);
                    this.pos++;
                    byte i6 = this.source.i();
                    byte b4 = b3 | (i6 << 28);
                    if (i6 >= 0) {
                        return b4;
                    }
                    for (int i7 = 0; i7 < 5; i7++) {
                        this.pos++;
                        if (this.source.i() >= 0) {
                            return b4;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
            }
        }
        return b2 | i;
    }

    public long readVarint64() throws IOException {
        int i = this.state;
        if (i == 0 || i == 2) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                this.pos++;
                byte i3 = this.source.i();
                j |= ((long) (i3 & Byte.MAX_VALUE)) << i2;
                if ((i3 & 128) == 0) {
                    afterPackableScalar(0);
                    return j;
                }
            }
            throw new ProtocolException("WireInput encountered a malformed varint");
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public int readFixed32() throws IOException {
        int i = this.state;
        if (i == 5 || i == 2) {
            this.source.a(4);
            this.pos += 4;
            int n = this.source.n();
            afterPackableScalar(5);
            return n;
        }
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
    }

    public long readFixed64() throws IOException {
        int i = this.state;
        if (i == 1 || i == 2) {
            this.source.a(8);
            this.pos += 8;
            long o = this.source.o();
            afterPackableScalar(1);
            return o;
        }
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
    }

    private void afterPackableScalar(int i) throws IOException {
        if (this.state == i) {
            this.state = 6;
            return;
        }
        long j = this.pos;
        long j2 = this.limit;
        if (j > j2) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        } else if (j == j2) {
            this.limit = this.pushedLimit;
            this.pushedLimit = -1;
            this.state = 6;
        } else {
            this.state = 7;
        }
    }

    private long beforeLengthDelimitedScalar() throws IOException {
        if (this.state == 2) {
            long j = this.limit - this.pos;
            this.source.a(j);
            this.state = 6;
            this.pos = this.limit;
            this.limit = this.pushedLimit;
            this.pushedLimit = -1;
            return j;
        }
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
    }
}
