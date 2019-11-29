package com.squareup.wire;

import e.c;
import e.e;
import e.f;
import e.n;
import e.v;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

final class WireInput {
    private static final String ENCOUNTERED_A_MALFORMED_VARINT = "WireInput encountered a malformed varint.";
    private static final String ENCOUNTERED_A_NEGATIVE_SIZE = "Encountered a negative size";
    private static final String INPUT_ENDED_UNEXPECTEDLY = "The input ended unexpectedly in the middle of a field";
    private static final String PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO = "Protocol message contained an invalid tag (zero).";
    private static final String PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG = "Protocol message end-group tag did not match expected tag.";
    public static final int RECURSION_LIMIT = 64;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private int currentLimit = Integer.MAX_VALUE;
    private int lastTag;
    private int pos = 0;
    public int recursionDepth;
    private final e source;

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static WireInput newInstance(byte[] bArr) {
        return new WireInput(new c().c(bArr));
    }

    public static WireInput newInstance(byte[] bArr, int i, int i2) {
        return new WireInput(new c().c(bArr, i, i2));
    }

    public static WireInput newInstance(InputStream inputStream) {
        return new WireInput(n.a(n.a(inputStream)));
    }

    public static WireInput newInstance(v vVar) {
        return new WireInput(n.a(vVar));
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        this.lastTag = readVarint32();
        int i = this.lastTag;
        if (i != 0) {
            return i;
        }
        throw new IOException(PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO);
    }

    public void checkLastTagWas(int i) throws IOException {
        if (this.lastTag != i) {
            throw new IOException(PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG);
        }
    }

    public String readString() throws IOException {
        int readVarint32 = readVarint32();
        this.pos += readVarint32;
        return this.source.a((long) readVarint32, UTF_8);
    }

    public f readBytes() throws IOException {
        return readBytes(readVarint32());
    }

    public f readBytes(int i) throws IOException {
        this.pos += i;
        long j = (long) i;
        this.source.a(j);
        return this.source.d(j);
    }

    public int readVarint32() throws IOException {
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
                    throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
                }
            }
        }
        return b2 | i;
    }

    public long readVarint64() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            this.pos++;
            byte i2 = this.source.i();
            j |= ((long) (i2 & Byte.MAX_VALUE)) << i;
            if ((i2 & 128) == 0) {
                return j;
            }
        }
        throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
    }

    public int readFixed32() throws IOException {
        this.pos += 4;
        return this.source.n();
    }

    public long readFixed64() throws IOException {
        this.pos += 8;
        return this.source.o();
    }

    private WireInput(e eVar) {
        this.source = eVar;
    }

    public int pushLimit(int i) throws IOException {
        if (i >= 0) {
            int i2 = i + this.pos;
            int i3 = this.currentLimit;
            if (i2 <= i3) {
                this.currentLimit = i2;
                return i3;
            }
            throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
        }
        throw new IOException(ENCOUNTERED_A_NEGATIVE_SIZE);
    }

    public void popLimit(int i) {
        this.currentLimit = i;
    }

    private boolean isAtEnd() throws IOException {
        if (getPosition() == ((long) this.currentLimit)) {
            return true;
        }
        return this.source.f();
    }

    public long getPosition() {
        return (long) this.pos;
    }

    public void skipGroup() throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (!skipField(readTag));
    }

    private boolean skipField(int i) throws IOException {
        switch (WireType.valueOf(i)) {
            case VARINT:
                readVarint64();
                return false;
            case FIXED32:
                readFixed32();
                return false;
            case FIXED64:
                readFixed64();
                return false;
            case LENGTH_DELIMITED:
                skip((long) readVarint32());
                return false;
            case START_GROUP:
                skipGroup();
                checkLastTagWas((i & -8) | WireType.END_GROUP.value());
                return false;
            case END_GROUP:
                return true;
            default:
                throw new AssertionError();
        }
    }

    private void skip(long j) throws IOException {
        this.pos = (int) (((long) this.pos) + j);
        this.source.i(j);
    }
}
