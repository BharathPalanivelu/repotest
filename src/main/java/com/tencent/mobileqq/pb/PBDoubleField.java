package com.tencent.mobileqq.pb;

import java.io.IOException;

public final class PBDoubleField extends PBPrimitiveField<Double> {
    public static final PBDoubleField __repeatHelper__ = new PBDoubleField(0.0d, false);
    private double value = 0.0d;

    public PBDoubleField(double d2, boolean z) {
        set(d2, z);
    }

    public double get() {
        return this.value;
    }

    public void set(double d2, boolean z) {
        this.value = d2;
        setHasFlag(z);
    }

    public void set(double d2) {
        set(d2, true);
    }

    public int computeSize(int i) {
        if (has()) {
            return CodedOutputStreamMicro.computeDoubleSize(i, this.value);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int computeSizeDirectly(int i, Double d2) {
        return CodedOutputStreamMicro.computeDoubleSize(i, d2.doubleValue());
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i) throws IOException {
        if (has()) {
            codedOutputStreamMicro.writeDouble(i, this.value);
        }
    }

    /* access modifiers changed from: protected */
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i, Double d2) throws IOException {
        codedOutputStreamMicro.writeDouble(i, d2.doubleValue());
    }

    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        this.value = codedInputStreamMicro.readDouble();
        setHasFlag(true);
    }

    /* access modifiers changed from: protected */
    public Double readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return Double.valueOf(codedInputStreamMicro.readDouble());
    }

    public void clear(Object obj) {
        if (obj instanceof Double) {
            this.value = ((Double) obj).doubleValue();
        } else {
            this.value = 0.0d;
        }
        setHasFlag(false);
    }

    /* access modifiers changed from: protected */
    public void copyFrom(PBField<Double> pBField) {
        PBDoubleField pBDoubleField = (PBDoubleField) pBField;
        set(pBDoubleField.value, pBDoubleField.has());
    }
}
