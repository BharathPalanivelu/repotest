package com.tencent.imcore;

public class IBatchOprCallback {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public static class BatchOprDetailInfo {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        public static class ErrInfo {
            protected transient boolean swigCMemOwn;
            private transient long swigCPtr;

            public ErrInfo() {
                this(internalMsgExtJNI.new_IBatchOprCallback_BatchOprDetailInfo_ErrInfo(), true);
            }

            protected ErrInfo(long j, boolean z) {
                this.swigCMemOwn = z;
                this.swigCPtr = j;
            }

            protected static long getCPtr(ErrInfo errInfo) {
                if (errInfo == null) {
                    return 0;
                }
                return errInfo.swigCPtr;
            }

            public synchronized void delete() {
                if (this.swigCPtr != 0) {
                    if (this.swigCMemOwn) {
                        this.swigCMemOwn = false;
                        internalMsgExtJNI.delete_IBatchOprCallback_BatchOprDetailInfo_ErrInfo(this.swigCPtr);
                    }
                    this.swigCPtr = 0;
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                delete();
            }

            public int getErr_code() {
                return internalMsgExtJNI.IBatchOprCallback_BatchOprDetailInfo_ErrInfo_err_code_get(this.swigCPtr, this);
            }

            public String getErr_msg() {
                return internalMsgExtJNI.IBatchOprCallback_BatchOprDetailInfo_ErrInfo_err_msg_get(this.swigCPtr, this);
            }

            public String getId() {
                return internalMsgExtJNI.IBatchOprCallback_BatchOprDetailInfo_ErrInfo_id_get(this.swigCPtr, this);
            }

            public void setErr_code(int i) {
                internalMsgExtJNI.IBatchOprCallback_BatchOprDetailInfo_ErrInfo_err_code_set(this.swigCPtr, this, i);
            }

            public void setErr_msg(String str) {
                internalMsgExtJNI.IBatchOprCallback_BatchOprDetailInfo_ErrInfo_err_msg_set(this.swigCPtr, this, str);
            }

            public void setId(String str) {
                internalMsgExtJNI.IBatchOprCallback_BatchOprDetailInfo_ErrInfo_id_set(this.swigCPtr, this, str);
            }
        }

        public BatchOprDetailInfo() {
            this(internalMsgExtJNI.new_IBatchOprCallback_BatchOprDetailInfo(), true);
        }

        protected BatchOprDetailInfo(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        protected static long getCPtr(BatchOprDetailInfo batchOprDetailInfo) {
            if (batchOprDetailInfo == null) {
                return 0;
            }
            return batchOprDetailInfo.swigCPtr;
        }

        public synchronized void delete() {
            if (this.swigCPtr != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    internalMsgExtJNI.delete_IBatchOprCallback_BatchOprDetailInfo(this.swigCPtr);
                }
                this.swigCPtr = 0;
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            delete();
        }

        public ErrInfoVec getErrs() {
            long IBatchOprCallback_BatchOprDetailInfo_errs_get = internalMsgExtJNI.IBatchOprCallback_BatchOprDetailInfo_errs_get(this.swigCPtr, this);
            if (IBatchOprCallback_BatchOprDetailInfo_errs_get == 0) {
                return null;
            }
            return new ErrInfoVec(IBatchOprCallback_BatchOprDetailInfo_errs_get, false);
        }

        public long getFail_num() {
            return internalMsgExtJNI.IBatchOprCallback_BatchOprDetailInfo_fail_num_get(this.swigCPtr, this);
        }

        public long getSucc_num() {
            return internalMsgExtJNI.IBatchOprCallback_BatchOprDetailInfo_succ_num_get(this.swigCPtr, this);
        }

        public void setErrs(ErrInfoVec errInfoVec) {
            internalMsgExtJNI.IBatchOprCallback_BatchOprDetailInfo_errs_set(this.swigCPtr, this, ErrInfoVec.getCPtr(errInfoVec), errInfoVec);
        }

        public void setFail_num(long j) {
            internalMsgExtJNI.IBatchOprCallback_BatchOprDetailInfo_fail_num_set(this.swigCPtr, this, j);
        }

        public void setSucc_num(long j) {
            internalMsgExtJNI.IBatchOprCallback_BatchOprDetailInfo_succ_num_set(this.swigCPtr, this, j);
        }
    }

    public IBatchOprCallback() {
        this(internalMsgExtJNI.new_IBatchOprCallback(), true);
        internalMsgExtJNI.IBatchOprCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected IBatchOprCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(IBatchOprCallback iBatchOprCallback) {
        if (iBatchOprCallback == null) {
            return 0;
        }
        return iBatchOprCallback.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalMsgExtJNI.delete_IBatchOprCallback(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void done() {
        if (getClass() == IBatchOprCallback.class) {
            internalMsgExtJNI.IBatchOprCallback_done(this.swigCPtr, this);
        } else {
            internalMsgExtJNI.IBatchOprCallback_doneSwigExplicitIBatchOprCallback(this.swigCPtr, this);
        }
    }

    public void fail(int i, String str, BatchOprDetailInfo batchOprDetailInfo) {
        if (getClass() == IBatchOprCallback.class) {
            internalMsgExtJNI.IBatchOprCallback_fail(this.swigCPtr, this, i, str, BatchOprDetailInfo.getCPtr(batchOprDetailInfo), batchOprDetailInfo);
            return;
        }
        internalMsgExtJNI.IBatchOprCallback_failSwigExplicitIBatchOprCallback(this.swigCPtr, this, i, str, BatchOprDetailInfo.getCPtr(batchOprDetailInfo), batchOprDetailInfo);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public void setLogin(String str, boolean z) {
        if (getClass() == IBatchOprCallback.class) {
            internalMsgExtJNI.IBatchOprCallback_setLogin(this.swigCPtr, this, str, z);
        } else {
            internalMsgExtJNI.IBatchOprCallback_setLoginSwigExplicitIBatchOprCallback(this.swigCPtr, this, str, z);
        }
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        internalMsgExtJNI.IBatchOprCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalMsgExtJNI.IBatchOprCallback_change_ownership(this, this.swigCPtr, true);
    }
}
