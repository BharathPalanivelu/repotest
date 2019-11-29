package com.tencent.imcore;

public class GroupPendencyMeta {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GroupPendencyMeta() {
        this(internalGroupExtJNI.new_GroupPendencyMeta(), true);
    }

    protected GroupPendencyMeta(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GroupPendencyMeta groupPendencyMeta) {
        if (groupPendencyMeta == null) {
            return 0;
        }
        return groupPendencyMeta.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_GroupPendencyMeta(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long getNext_start_time() {
        return internalGroupExtJNI.GroupPendencyMeta_next_start_time_get(this.swigCPtr, this);
    }

    public long getRead_time_seq() {
        return internalGroupExtJNI.GroupPendencyMeta_read_time_seq_get(this.swigCPtr, this);
    }

    public long getUnread_num() {
        return internalGroupExtJNI.GroupPendencyMeta_unread_num_get(this.swigCPtr, this);
    }

    public void setNext_start_time(long j) {
        internalGroupExtJNI.GroupPendencyMeta_next_start_time_set(this.swigCPtr, this, j);
    }

    public void setRead_time_seq(long j) {
        internalGroupExtJNI.GroupPendencyMeta_read_time_seq_set(this.swigCPtr, this, j);
    }

    public void setUnread_num(long j) {
        internalGroupExtJNI.GroupPendencyMeta_unread_num_set(this.swigCPtr, this, j);
    }
}
