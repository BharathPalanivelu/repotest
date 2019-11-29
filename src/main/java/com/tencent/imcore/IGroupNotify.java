package com.tencent.imcore;

public class IGroupNotify {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public IGroupNotify() {
        this(internalGroupExtJNI.new_IGroupNotify(), true);
        internalGroupExtJNI.IGroupNotify_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected IGroupNotify(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(IGroupNotify iGroupNotify) {
        if (iGroupNotify == null) {
            return 0;
        }
        return iGroupNotify.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalGroupExtJNI.delete_IGroupNotify(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public void onGroupAdd(GroupCacheInfo groupCacheInfo) {
        if (getClass() == IGroupNotify.class) {
            internalGroupExtJNI.IGroupNotify_onGroupAdd(this.swigCPtr, this, GroupCacheInfo.getCPtr(groupCacheInfo), groupCacheInfo);
            return;
        }
        internalGroupExtJNI.IGroupNotify_onGroupAddSwigExplicitIGroupNotify(this.swigCPtr, this, GroupCacheInfo.getCPtr(groupCacheInfo), groupCacheInfo);
    }

    public void onGroupDelete(String str) {
        if (getClass() == IGroupNotify.class) {
            internalGroupExtJNI.IGroupNotify_onGroupDelete(this.swigCPtr, this, str);
        } else {
            internalGroupExtJNI.IGroupNotify_onGroupDeleteSwigExplicitIGroupNotify(this.swigCPtr, this, str);
        }
    }

    public void onGroupUpdate(GroupCacheInfo groupCacheInfo) {
        if (getClass() == IGroupNotify.class) {
            internalGroupExtJNI.IGroupNotify_onGroupUpdate(this.swigCPtr, this, GroupCacheInfo.getCPtr(groupCacheInfo), groupCacheInfo);
            return;
        }
        internalGroupExtJNI.IGroupNotify_onGroupUpdateSwigExplicitIGroupNotify(this.swigCPtr, this, GroupCacheInfo.getCPtr(groupCacheInfo), groupCacheInfo);
    }

    public void onMemberJoin(String str, MemberInfoVec memberInfoVec) {
        if (getClass() == IGroupNotify.class) {
            internalGroupExtJNI.IGroupNotify_onMemberJoin(this.swigCPtr, this, str, MemberInfoVec.getCPtr(memberInfoVec), memberInfoVec);
            return;
        }
        internalGroupExtJNI.IGroupNotify_onMemberJoinSwigExplicitIGroupNotify(this.swigCPtr, this, str, MemberInfoVec.getCPtr(memberInfoVec), memberInfoVec);
    }

    public void onMemberQuit(String str, StrVec strVec) {
        if (getClass() == IGroupNotify.class) {
            internalGroupExtJNI.IGroupNotify_onMemberQuit(this.swigCPtr, this, str, StrVec.getCPtr(strVec), strVec);
            return;
        }
        internalGroupExtJNI.IGroupNotify_onMemberQuitSwigExplicitIGroupNotify(this.swigCPtr, this, str, StrVec.getCPtr(strVec), strVec);
    }

    public void onMemberUpdate(String str, MemberInfoVec memberInfoVec) {
        if (getClass() == IGroupNotify.class) {
            internalGroupExtJNI.IGroupNotify_onMemberUpdate(this.swigCPtr, this, str, MemberInfoVec.getCPtr(memberInfoVec), memberInfoVec);
            return;
        }
        internalGroupExtJNI.IGroupNotify_onMemberUpdateSwigExplicitIGroupNotify(this.swigCPtr, this, str, MemberInfoVec.getCPtr(memberInfoVec), memberInfoVec);
    }

    /* access modifiers changed from: protected */
    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        internalGroupExtJNI.IGroupNotify_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        internalGroupExtJNI.IGroupNotify_change_ownership(this, this.swigCPtr, true);
    }
}
