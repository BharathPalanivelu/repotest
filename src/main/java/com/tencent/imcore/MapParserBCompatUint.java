package com.tencent.imcore;

public class MapParserBCompatUint {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MapParserBCompatUint() {
        this(internalJNI.new_MapParserBCompatUint(), true);
    }

    protected MapParserBCompatUint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MapParserBCompatUint mapParserBCompatUint) {
        if (mapParserBCompatUint == null) {
            return 0;
        }
        return mapParserBCompatUint.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_MapParserBCompatUint(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void fetchMapKeys(BytesCompatUintMap bytesCompatUintMap) {
        internalJNI.MapParserBCompatUint_fetchMapKeys(this.swigCPtr, this, BytesCompatUintMap.getCPtr(bytesCompatUintMap), bytesCompatUintMap);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public byte[] getKey(int i) {
        return internalJNI.MapParserBCompatUint_getKey(this.swigCPtr, this, i);
    }

    public BytesVec getKeys() {
        long MapParserBCompatUint_keys_get = internalJNI.MapParserBCompatUint_keys_get(this.swigCPtr, this);
        if (MapParserBCompatUint_keys_get == 0) {
            return null;
        }
        return new BytesVec(MapParserBCompatUint_keys_get, false);
    }

    public CompatUint64 getValue(BytesCompatUintMap bytesCompatUintMap, int i) {
        long MapParserBCompatUint_getValue = internalJNI.MapParserBCompatUint_getValue(this.swigCPtr, this, BytesCompatUintMap.getCPtr(bytesCompatUintMap), bytesCompatUintMap, i);
        if (MapParserBCompatUint_getValue == 0) {
            return null;
        }
        return new CompatUint64(MapParserBCompatUint_getValue, false);
    }

    public void setKeys(BytesVec bytesVec) {
        internalJNI.MapParserBCompatUint_keys_set(this.swigCPtr, this, BytesVec.getCPtr(bytesVec), bytesVec);
    }
}
