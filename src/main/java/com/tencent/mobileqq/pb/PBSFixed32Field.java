package com.tencent.mobileqq.pb;

import java.io.IOException;

public final class PBSFixed32Field extends PBPrimitiveField<Integer> {
    public static final PBSFixed32Field __repeatHelper__ = new PBSFixed32Field(0, false);
    private int value = 0;

    public PBSFixed32Field(int i, boolean z) {
        set(i, z);
    }

    public int get() {
        return this.value;
    }

    public void set(int i, boolean z) {
        this.value = i;
        setHasFlag(z);
    }

    public void set(int i) {
        set(i, true);
    }

    public int computeSize(int i) {
        if (has()) {
            return CodedOutputStreamMicro.computeSFixed32Size(i, this.value);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int computeSizeDirectly(int i, Integer num) {
        return CodedOutputStreamMicro.computeSFixed32Size(i, num.intValue());
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i) throws IOException {
        if (has()) {
            codedOutputStreamMicro.writeSFixed32(i, this.value);
        }
    }

    /* access modifiers changed from: protected */
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i, Integer num) throws IOException {
        codedOutputStreamMicro.writeSFixed32(i, num.intValue());
    }

    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        this.value = codedInputStreamMicro.readSFixed32();
        setHasFlag(true);
    }

    /* access modifiers changed from: protected */
    public Integer readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return Integer.valueOf(codedInputStreamMicro.readSFixed32());
    }

    public void clear(Object obj) {
        if (obj instanceof Integer) {
            this.value = ((Integer) obj).intValue();
        } else {
            this.value = 0;
        }
        setHasFlag(false);
    }

    /* access modifiers changed from: protected */
    public void copyFrom(PBField<Integer> pBField) {
        PBSFixed32Field pBSFixed32Field = (PBSFixed32Field) pBField;
        set(pBSFixed32Field.value, pBSFixed32Field.has());
    }
}
