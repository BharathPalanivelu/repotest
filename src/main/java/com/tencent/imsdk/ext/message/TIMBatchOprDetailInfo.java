package com.tencent.imsdk.ext.message;

import com.tencent.imcore.ErrInfoVec;
import com.tencent.imcore.IBatchOprCallback;
import java.util.ArrayList;
import java.util.List;

public class TIMBatchOprDetailInfo {
    private List<ErrInfo> errors = new ArrayList();
    private long failNum;
    private long succNum;

    public class ErrInfo {
        private int errCode;
        private String errMsg = "";
        private String id = "";

        public ErrInfo(IBatchOprCallback.BatchOprDetailInfo.ErrInfo errInfo) {
            if (errInfo != null) {
                this.id = errInfo.getId();
                this.errCode = errInfo.getErr_code();
                this.errMsg = errInfo.getErr_msg();
            }
        }

        public int getErrCode() {
            return this.errCode;
        }

        public String getErrMsg() {
            return this.errMsg;
        }

        public String getId() {
            return this.id;
        }
    }

    public TIMBatchOprDetailInfo() {
    }

    public TIMBatchOprDetailInfo(IBatchOprCallback.BatchOprDetailInfo batchOprDetailInfo) {
        if (batchOprDetailInfo != null) {
            this.succNum = batchOprDetailInfo.getSucc_num();
            this.failNum = batchOprDetailInfo.getFail_num();
            ErrInfoVec errs = batchOprDetailInfo.getErrs();
            long size = errs.size();
            for (int i = 0; ((long) i) < size; i++) {
                this.errors.add(new ErrInfo(errs.get(i)));
            }
        }
    }

    public List<ErrInfo> getErrors() {
        return this.errors;
    }

    public long getFailNum() {
        return this.failNum;
    }

    public long getSuccNum() {
        return this.succNum;
    }
}
