package com.thoughtworks.xstream.io.binary;

import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import com.thoughtworks.xstream.io.StreamException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class Token {
    private static final byte ID_EIGHT_BYTES = 32;
    private static final byte ID_FOUR_BYTES = 24;
    private static final byte ID_MASK = 56;
    private static final byte ID_ONE_BYTE = 8;
    private static final String ID_SPLITTED = "\u0000‡\u0000";
    private static final byte ID_TWO_BYTES = 16;
    private static final int MAX_UTF8_LENGTH = 65535;
    public static final byte TYPE_ATTRIBUTE = 5;
    public static final byte TYPE_END_NODE = 4;
    public static final byte TYPE_MAP_ID_TO_VALUE = 2;
    private static final byte TYPE_MASK = 7;
    public static final byte TYPE_START_NODE = 3;
    public static final byte TYPE_VALUE = 6;
    public static final byte TYPE_VERSION = 1;
    protected long id = -1;
    private final byte type;
    protected String value;

    public abstract void readFrom(DataInput dataInput, byte b2) throws IOException;

    public abstract void writeTo(DataOutput dataOutput, byte b2) throws IOException;

    public Token(byte b2) {
        this.type = b2;
    }

    public byte getType() {
        return this.type;
    }

    public long getId() {
        return this.id;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return getClass().getName() + " [id=" + this.id + ", value='" + this.value + "']";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Token token = (Token) obj;
        if (this.id != token.id || this.type != token.type) {
            return false;
        }
        String str = this.value;
        if (str != null) {
            if (!str.equals(token.value)) {
                return false;
            }
            return true;
        } else if (token.value == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((this.type * 29) + ((int) (j ^ (j >>> 32)))) * 29;
        String str = this.value;
        return i + (str != null ? str.hashCode() : 0);
    }

    /* access modifiers changed from: protected */
    public void writeId(DataOutput dataOutput, long j, byte b2) throws IOException {
        if (j < 0) {
            throw new IOException("id must not be negative " + j);
        } else if (b2 == 8) {
            dataOutput.writeByte(((byte) ((int) j)) - 128);
        } else if (b2 == 16) {
            dataOutput.writeShort(((short) ((int) j)) - 32768);
        } else if (b2 == 24) {
            dataOutput.writeInt(((int) j) + RNCartPanelDataEntity.NULL_VALUE);
        } else if (b2 == 32) {
            dataOutput.writeLong(j - Long.MIN_VALUE);
        } else {
            throw new Error("Unknown idType " + b2);
        }
    }

    /* access modifiers changed from: protected */
    public void writeString(DataOutput dataOutput, String str) throws IOException {
        byte[] bytes = str.length() > 16383 ? str.getBytes("utf-8") : new byte[0];
        if (bytes.length <= 65535) {
            dataOutput.writeUTF(str);
            return;
        }
        dataOutput.writeUTF(ID_SPLITTED);
        dataOutput.writeInt(bytes.length);
        dataOutput.write(bytes);
    }

    /* access modifiers changed from: protected */
    public long readId(DataInput dataInput, byte b2) throws IOException {
        if (b2 == 8) {
            return (long) (dataInput.readByte() + 128);
        }
        if (b2 == 16) {
            return (long) (dataInput.readShort() - Short.MIN_VALUE);
        }
        if (b2 == 24) {
            return (long) (dataInput.readInt() - RNCartPanelDataEntity.NULL_VALUE);
        }
        if (b2 == 32) {
            return dataInput.readLong() - Long.MIN_VALUE;
        }
        throw new Error("Unknown idType " + b2);
    }

    /* access modifiers changed from: protected */
    public String readString(DataInput dataInput) throws IOException {
        String readUTF = dataInput.readUTF();
        if (!ID_SPLITTED.equals(readUTF)) {
            return readUTF;
        }
        byte[] bArr = new byte[dataInput.readInt()];
        dataInput.readFully(bArr);
        return new String(bArr, "utf-8");
    }

    public static class Formatter {
        public void write(DataOutput dataOutput, Token token) throws IOException {
            long id = token.getId();
            byte b2 = id <= 255 ? 8 : id <= 65535 ? Token.ID_TWO_BYTES : id <= 4294967295L ? Token.ID_FOUR_BYTES : Token.ID_EIGHT_BYTES;
            dataOutput.write(token.getType() + b2);
            token.writeTo(dataOutput, b2);
        }

        public Token read(DataInput dataInput) throws IOException {
            byte readByte = dataInput.readByte();
            Token contructToken = contructToken((byte) (readByte & 7));
            contructToken.readFrom(dataInput, (byte) (readByte & Token.ID_MASK));
            return contructToken;
        }

        private Token contructToken(byte b2) {
            if (b2 == 2) {
                return new MapIdToValue();
            }
            if (b2 == 3) {
                return new StartNode();
            }
            if (b2 == 4) {
                return new EndNode();
            }
            if (b2 == 5) {
                return new Attribute();
            }
            if (b2 == 6) {
                return new Value();
            }
            throw new StreamException("Unknown token type");
        }
    }

    public static class MapIdToValue extends Token {
        public MapIdToValue(long j, String str) {
            super((byte) 2);
            this.id = j;
            this.value = str;
        }

        public MapIdToValue() {
            super((byte) 2);
        }

        public void writeTo(DataOutput dataOutput, byte b2) throws IOException {
            writeId(dataOutput, this.id, b2);
            writeString(dataOutput, this.value);
        }

        public void readFrom(DataInput dataInput, byte b2) throws IOException {
            this.id = readId(dataInput, b2);
            this.value = readString(dataInput);
        }
    }

    public static class StartNode extends Token {
        public StartNode(long j) {
            super((byte) 3);
            this.id = j;
        }

        public StartNode() {
            super((byte) 3);
        }

        public void writeTo(DataOutput dataOutput, byte b2) throws IOException {
            writeId(dataOutput, this.id, b2);
        }

        public void readFrom(DataInput dataInput, byte b2) throws IOException {
            this.id = readId(dataInput, b2);
        }
    }

    public static class EndNode extends Token {
        public void readFrom(DataInput dataInput, byte b2) {
        }

        public void writeTo(DataOutput dataOutput, byte b2) {
        }

        public EndNode() {
            super((byte) 4);
        }
    }

    public static class Attribute extends Token {
        public Attribute(long j, String str) {
            super((byte) 5);
            this.id = j;
            this.value = str;
        }

        public Attribute() {
            super((byte) 5);
        }

        public void writeTo(DataOutput dataOutput, byte b2) throws IOException {
            writeId(dataOutput, this.id, b2);
            writeString(dataOutput, this.value);
        }

        public void readFrom(DataInput dataInput, byte b2) throws IOException {
            this.id = readId(dataInput, b2);
            this.value = readString(dataInput);
        }
    }

    public static class Value extends Token {
        public Value(String str) {
            super((byte) 6);
            this.value = str;
        }

        public Value() {
            super((byte) 6);
        }

        public void writeTo(DataOutput dataOutput, byte b2) throws IOException {
            writeString(dataOutput, this.value);
        }

        public void readFrom(DataInput dataInput, byte b2) throws IOException {
            this.value = readString(dataInput);
        }
    }
}
