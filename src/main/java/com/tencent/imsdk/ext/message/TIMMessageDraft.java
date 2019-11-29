package com.tencent.imsdk.ext.message;

import com.tencent.imcore.Draft;
import com.tencent.imcore.Elem;
import com.tencent.imcore.ElemVec;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.TIMElem;
import com.tencent.imsdk.TIMElemType;
import java.util.ArrayList;
import java.util.List;

public class TIMMessageDraft {
    private List<TIMElem> elems = new ArrayList();
    private long timestamp;
    private byte[] userDefinedData;

    protected static TIMMessageDraft convertFrom(Draft draft) {
        if (draft == null) {
            return null;
        }
        TIMMessageDraft tIMMessageDraft = new TIMMessageDraft();
        tIMMessageDraft.setTimestamp(draft.getUint64_edit_time());
        tIMMessageDraft.setUserDefinedData(draft.getUser_define());
        ElemVec elems2 = draft.getElems();
        if (elems2 != null) {
            for (int i = 0; ((long) i) < elems2.size(); i++) {
                TIMElem elemFromInternal = IMLiteBridge.elemFromInternal(elems2.get(i));
                if (elemFromInternal.getType() != TIMElemType.Invalid) {
                    tIMMessageDraft.addElem(elemFromInternal);
                }
            }
        }
        return tIMMessageDraft;
    }

    public void addElem(TIMElem tIMElem) {
        this.elems.add(tIMElem);
    }

    /* access modifiers changed from: protected */
    public Draft convertTo() {
        Draft draft = new Draft();
        if (!this.elems.isEmpty()) {
            ElemVec elemVec = new ElemVec();
            for (TIMElem elem2Internal : this.elems) {
                Elem elem2Internal2 = IMLiteBridge.elem2Internal(elem2Internal);
                if (elem2Internal2 != null) {
                    elemVec.add(elem2Internal2);
                }
            }
            draft.setElems(elemVec);
        }
        byte[] bArr = this.userDefinedData;
        if (bArr != null) {
            draft.setUser_define(bArr);
        }
        return draft;
    }

    public List<TIMElem> getElems() {
        return this.elems;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public byte[] getUserDefinedData() {
        return this.userDefinedData;
    }

    /* access modifiers changed from: protected */
    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setUserDefinedData(byte[] bArr) {
        this.userDefinedData = bArr;
    }
}
