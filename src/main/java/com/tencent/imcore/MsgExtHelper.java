package com.tencent.imcore;

public class MsgExtHelper {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MsgExtHelper() {
        this(internalMsgExtJNI.new_MsgExtHelper(), true);
    }

    protected MsgExtHelper(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static boolean deleteConversation(String str, SessionType sessionType, String str2) {
        return internalMsgExtJNI.MsgExtHelper_deleteConversation(str, sessionType.swigValue(), str2);
    }

    public static boolean deleteConversationAndMessages(String str, SessionType sessionType, String str2) {
        return internalMsgExtJNI.MsgExtHelper_deleteConversationAndMessages(str, sessionType.swigValue(), str2);
    }

    protected static long getCPtr(MsgExtHelper msgExtHelper) {
        if (msgExtHelper == null) {
            return 0;
        }
        return msgExtHelper.swigCPtr;
    }

    public static int getConversationCount(String str) {
        return internalMsgExtJNI.MsgExtHelper_getConversationCount(str);
    }

    public static SWIGTYPE_p_void getMsgManagerExt(String str) {
        long MsgExtHelper_getMsgManagerExt = internalMsgExtJNI.MsgExtHelper_getMsgManagerExt(str);
        if (MsgExtHelper_getMsgManagerExt == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(MsgExtHelper_getMsgManagerExt, false);
    }

    public static PairVectorSession getSessionList(String str) {
        return new PairVectorSession(internalMsgExtJNI.MsgExtHelper_getSessionList(str), true);
    }

    public static int initStorage(String str) {
        return internalMsgExtJNI.MsgExtHelper_initStorage(str);
    }

    public static void sendMsgToMultiUsers(String str, StrVec strVec, Msg msg, IBatchOprCallback iBatchOprCallback) {
        internalMsgExtJNI.MsgExtHelper_sendMsgToMultiUsers(str, StrVec.getCPtr(strVec), strVec, Msg.getCPtr(msg), msg, IBatchOprCallback.getCPtr(iBatchOprCallback), iBatchOprCallback);
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalMsgExtJNI.delete_MsgExtHelper(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }
}
