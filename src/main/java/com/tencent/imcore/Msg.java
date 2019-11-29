package com.tencent.imcore;

public class Msg {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Msg() {
        this(internalJNI.new_Msg__SWIG_0(), true);
    }

    protected Msg(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public Msg(SWIGTYPE_p_std__shared_ptrT_imcore__MsgNode_t sWIGTYPE_p_std__shared_ptrT_imcore__MsgNode_t) {
        this(internalJNI.new_Msg__SWIG_1(SWIGTYPE_p_std__shared_ptrT_imcore__MsgNode_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_imcore__MsgNode_t)), true);
    }

    protected static long getCPtr(Msg msg) {
        if (msg == null) {
            return 0;
        }
        return msg.swigCPtr;
    }

    public static Msg newMsg() {
        return new Msg(internalJNI.Msg_newMsg__SWIG_0(), true);
    }

    public static Msg newMsg(Msg msg) {
        return new Msg(internalJNI.Msg_newMsg__SWIG_1(getCPtr(msg), msg), true);
    }

    public void addElem(Elem elem) {
        internalJNI.Msg_addElem(this.swigCPtr, this, Elem.getCPtr(elem), elem);
    }

    public SWIGTYPE_p_std__shared_ptrT_imcore__MsgNode_t cloneShared() {
        return new SWIGTYPE_p_std__shared_ptrT_imcore__MsgNode_t(internalJNI.Msg_cloneShared(this.swigCPtr, this), true);
    }

    public boolean copyFrom(Msg msg) {
        return internalJNI.Msg_copyFrom(this.swigCPtr, this, getCPtr(msg), msg);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_Msg(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public long elemSize() {
        return internalJNI.Msg_elemSize(this.swigCPtr, this);
    }

    public MsgElemType elemType(long j) {
        return MsgElemType.swigToEnum(internalJNI.Msg_elemType(this.swigCPtr, this, j));
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public long flag() {
        return internalJNI.Msg_flag(this.swigCPtr, this);
    }

    public Elem getElem(long j) {
        return new Elem(internalJNI.Msg_getElem(this.swigCPtr, this, j), true);
    }

    public byte[] getGroupName() {
        return internalJNI.Msg_getGroupName(this.swigCPtr, this);
    }

    public OfflinePushInfo getOfflinePushInfo() {
        return new OfflinePushInfo(internalJNI.Msg_getOfflinePushInfo(this.swigCPtr, this), true);
    }

    public int getRecvFlag() {
        return internalJNI.Msg_getRecvFlag(this.swigCPtr, this);
    }

    public String getSender() {
        return internalJNI.Msg_getSender(this.swigCPtr, this);
    }

    public GroupTipsMemberInfo getSenderGroupMemberProfile() {
        return new GroupTipsMemberInfo(internalJNI.Msg_getSenderGroupMemberProfile(this.swigCPtr, this), true);
    }

    public FriendProfile getSenderProfile() {
        return new FriendProfile(internalJNI.Msg_getSenderProfile(this.swigCPtr, this), true);
    }

    public boolean isSelf() {
        return internalJNI.Msg_isSelf(this.swigCPtr, this);
    }

    public boolean isValid() {
        return internalJNI.Msg_isValid(this.swigCPtr, this);
    }

    public long lifetime() {
        return internalJNI.Msg_lifetime(this.swigCPtr, this);
    }

    public byte[] msgid() {
        return internalJNI.Msg_msgid(this.swigCPtr, this);
    }

    public boolean parse(byte[] bArr) {
        return internalJNI.Msg_parse(this.swigCPtr, this, bArr);
    }

    public MsgPriority priority() {
        return MsgPriority.swigToEnum(internalJNI.Msg_priority(this.swigCPtr, this));
    }

    public long rand() {
        return internalJNI.Msg_rand(this.swigCPtr, this);
    }

    public long seq() {
        return internalJNI.Msg_seq(this.swigCPtr, this);
    }

    public byte[] serialize() {
        return internalJNI.Msg_serialize(this.swigCPtr, this);
    }

    public Session session() {
        return new Session(internalJNI.Msg_session(this.swigCPtr, this), true);
    }

    public boolean setBuzCmd(StrVec strVec) {
        return internalJNI.Msg_setBuzCmd(this.swigCPtr, this, StrVec.getCPtr(strVec), strVec);
    }

    public boolean setOfflinePushInfo(OfflinePushInfo offlinePushInfo) {
        return internalJNI.Msg_setOfflinePushInfo(this.swigCPtr, this, OfflinePushInfo.getCPtr(offlinePushInfo), offlinePushInfo);
    }

    public boolean setPriority(MsgPriority msgPriority) {
        return internalJNI.Msg_setPriority(this.swigCPtr, this, msgPriority.swigValue());
    }

    public int status() {
        return internalJNI.Msg_status(this.swigCPtr, this);
    }

    public boolean storeMsg() {
        return internalJNI.Msg_storeMsg(this.swigCPtr, this);
    }

    public long time() {
        return internalJNI.Msg_time(this.swigCPtr, this);
    }

    public long uniqueid() {
        return internalJNI.Msg_uniqueid(this.swigCPtr, this);
    }
}
