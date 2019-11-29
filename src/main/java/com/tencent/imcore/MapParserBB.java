package com.tencent.imcore;

public class MapParserBB {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MapParserBB() {
        this(internalJNI.new_MapParserBB(), true);
    }

    protected MapParserBB(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MapParserBB mapParserBB) {
        if (mapParserBB == null) {
            return 0;
        }
        return mapParserBB.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_MapParserBB(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void fetchMapKeys(BytesMap bytesMap) {
        internalJNI.MapParserBB_fetchMapKeys(this.swigCPtr, this, BytesMap.getCPtr(bytesMap), bytesMap);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public byte[] getKey(int i) {
        return internalJNI.MapParserBB_getKey(this.swigCPtr, this, i);
    }

    public BytesVec getKeys() {
        long MapParserBB_keys_get = internalJNI.MapParserBB_keys_get(this.swigCPtr, this);
        if (MapParserBB_keys_get == 0) {
            return null;
        }
        return new BytesVec(MapParserBB_keys_get, false);
    }

    public byte[] getValue(BytesMap bytesMap, int i) {
        return internalJNI.MapParserBB_getValue(this.swigCPtr, this, BytesMap.getCPtr(bytesMap), bytesMap, i);
    }

    public void setKeys(BytesVec bytesVec) {
        internalJNI.MapParserBB_keys_set(this.swigCPtr, this, BytesVec.getCPtr(bytesVec), bytesVec);
    }
}
