package com.tencent.mobileqq.pb;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;

public final class PBFloatField extends PBPrimitiveField<Float> {
    public static final PBFloatField __repeatHelper__ = new PBFloatField(BitmapDescriptorFactory.HUE_RED, false);
    private float value = BitmapDescriptorFactory.HUE_RED;

    public PBFloatField(float f2, boolean z) {
        set(f2, z);
    }

    public float get() {
        return this.value;
    }

    public void set(float f2, boolean z) {
        this.value = f2;
        setHasFlag(z);
    }

    public void set(float f2) {
        set(f2, true);
    }

    public int computeSize(int i) {
        if (has()) {
            return CodedOutputStreamMicro.computeFloatSize(i, this.value);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int computeSizeDirectly(int i, Float f2) {
        return CodedOutputStreamMicro.computeFloatSize(i, f2.floatValue());
    }

    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro, int i) throws IOException {
        if (has()) {
            codedOutputStreamMicro.writeFloat(i, this.value);
        }
    }

    /* access modifiers changed from: protected */
    public void writeToDirectly(CodedOutputStreamMicro codedOutputStreamMicro, int i, Float f2) throws IOException {
        codedOutputStreamMicro.writeFloat(i, f2.floatValue());
    }

    public void readFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        this.value = codedInputStreamMicro.readFloat();
        setHasFlag(true);
    }

    /* access modifiers changed from: protected */
    public Float readFromDirectly(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return Float.valueOf(codedInputStreamMicro.readFloat());
    }

    public void clear(Object obj) {
        if (obj instanceof Float) {
            this.value = ((Float) obj).floatValue();
        } else {
            this.value = BitmapDescriptorFactory.HUE_RED;
        }
        setHasFlag(false);
    }

    /* access modifiers changed from: protected */
    public void copyFrom(PBField<Float> pBField) {
        PBFloatField pBFloatField = (PBFloatField) pBField;
        set(pBFloatField.value, pBFloatField.has());
    }
}
