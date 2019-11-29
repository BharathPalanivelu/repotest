package com.tencent.imcore;

public class MapParserStringMemberInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MapParserStringMemberInfo() {
        this(internalJNI.new_MapParserStringMemberInfo(), true);
    }

    protected MapParserStringMemberInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(MapParserStringMemberInfo mapParserStringMemberInfo) {
        if (mapParserStringMemberInfo == null) {
            return 0;
        }
        return mapParserStringMemberInfo.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_MapParserStringMemberInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void fetchMapKeys(StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap) {
        internalJNI.MapParserStringMemberInfo_fetchMapKeys(this.swigCPtr, this, StringGroupTipsMemberInfoMap.getCPtr(stringGroupTipsMemberInfoMap), stringGroupTipsMemberInfoMap);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public SWIGTYPE_p_std__string getKey(int i) {
        long MapParserStringMemberInfo_getKey = internalJNI.MapParserStringMemberInfo_getKey(this.swigCPtr, this, i);
        if (MapParserStringMemberInfo_getKey == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__string(MapParserStringMemberInfo_getKey, false);
    }

    public StrVec getKeys() {
        long MapParserStringMemberInfo_keys_get = internalJNI.MapParserStringMemberInfo_keys_get(this.swigCPtr, this);
        if (MapParserStringMemberInfo_keys_get == 0) {
            return null;
        }
        return new StrVec(MapParserStringMemberInfo_keys_get, false);
    }

    public GroupTipsMemberInfo getValue(StringGroupTipsMemberInfoMap stringGroupTipsMemberInfoMap, int i) {
        long MapParserStringMemberInfo_getValue = internalJNI.MapParserStringMemberInfo_getValue(this.swigCPtr, this, StringGroupTipsMemberInfoMap.getCPtr(stringGroupTipsMemberInfoMap), stringGroupTipsMemberInfoMap, i);
        if (MapParserStringMemberInfo_getValue == 0) {
            return null;
        }
        return new GroupTipsMemberInfo(MapParserStringMemberInfo_getValue, false);
    }

    public void setKeys(StrVec strVec) {
        internalJNI.MapParserStringMemberInfo_keys_set(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec);
    }
}
