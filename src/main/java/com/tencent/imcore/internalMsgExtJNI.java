package com.tencent.imcore;

import com.tencent.imcore.IBatchOprCallback;

public class internalMsgExtJNI {
    static {
        swig_module_init();
    }

    public static final native long Draft_elems_get(long j, Draft draft);

    public static final native void Draft_elems_set(long j, Draft draft, long j2, ElemVec elemVec);

    public static final native long Draft_uint64_edit_time_get(long j, Draft draft);

    public static final native void Draft_uint64_edit_time_set(long j, Draft draft, long j2);

    public static final native byte[] Draft_user_define_get(long j, Draft draft);

    public static final native void Draft_user_define_set(long j, Draft draft, byte[] bArr);

    public static final native void ErrInfoVec_add(long j, ErrInfoVec errInfoVec, long j2, IBatchOprCallback.BatchOprDetailInfo.ErrInfo errInfo);

    public static final native long ErrInfoVec_capacity(long j, ErrInfoVec errInfoVec);

    public static final native void ErrInfoVec_clear(long j, ErrInfoVec errInfoVec);

    public static final native long ErrInfoVec_get(long j, ErrInfoVec errInfoVec, int i);

    public static final native boolean ErrInfoVec_isEmpty(long j, ErrInfoVec errInfoVec);

    public static final native void ErrInfoVec_reserve(long j, ErrInfoVec errInfoVec, long j2);

    public static final native void ErrInfoVec_set(long j, ErrInfoVec errInfoVec, int i, long j2, IBatchOprCallback.BatchOprDetailInfo.ErrInfo errInfo);

    public static final native long ErrInfoVec_size(long j, ErrInfoVec errInfoVec);

    public static final native int IBatchOprCallback_BatchOprDetailInfo_ErrInfo_err_code_get(long j, IBatchOprCallback.BatchOprDetailInfo.ErrInfo errInfo);

    public static final native void IBatchOprCallback_BatchOprDetailInfo_ErrInfo_err_code_set(long j, IBatchOprCallback.BatchOprDetailInfo.ErrInfo errInfo, int i);

    public static final native String IBatchOprCallback_BatchOprDetailInfo_ErrInfo_err_msg_get(long j, IBatchOprCallback.BatchOprDetailInfo.ErrInfo errInfo);

    public static final native void IBatchOprCallback_BatchOprDetailInfo_ErrInfo_err_msg_set(long j, IBatchOprCallback.BatchOprDetailInfo.ErrInfo errInfo, String str);

    public static final native String IBatchOprCallback_BatchOprDetailInfo_ErrInfo_id_get(long j, IBatchOprCallback.BatchOprDetailInfo.ErrInfo errInfo);

    public static final native void IBatchOprCallback_BatchOprDetailInfo_ErrInfo_id_set(long j, IBatchOprCallback.BatchOprDetailInfo.ErrInfo errInfo, String str);

    public static final native long IBatchOprCallback_BatchOprDetailInfo_errs_get(long j, IBatchOprCallback.BatchOprDetailInfo batchOprDetailInfo);

    public static final native void IBatchOprCallback_BatchOprDetailInfo_errs_set(long j, IBatchOprCallback.BatchOprDetailInfo batchOprDetailInfo, long j2, ErrInfoVec errInfoVec);

    public static final native long IBatchOprCallback_BatchOprDetailInfo_fail_num_get(long j, IBatchOprCallback.BatchOprDetailInfo batchOprDetailInfo);

    public static final native void IBatchOprCallback_BatchOprDetailInfo_fail_num_set(long j, IBatchOprCallback.BatchOprDetailInfo batchOprDetailInfo, long j2);

    public static final native long IBatchOprCallback_BatchOprDetailInfo_succ_num_get(long j, IBatchOprCallback.BatchOprDetailInfo batchOprDetailInfo);

    public static final native void IBatchOprCallback_BatchOprDetailInfo_succ_num_set(long j, IBatchOprCallback.BatchOprDetailInfo batchOprDetailInfo, long j2);

    public static final native void IBatchOprCallback_change_ownership(IBatchOprCallback iBatchOprCallback, long j, boolean z);

    public static final native void IBatchOprCallback_director_connect(IBatchOprCallback iBatchOprCallback, long j, boolean z, boolean z2);

    public static final native void IBatchOprCallback_done(long j, IBatchOprCallback iBatchOprCallback);

    public static final native void IBatchOprCallback_doneSwigExplicitIBatchOprCallback(long j, IBatchOprCallback iBatchOprCallback);

    public static final native void IBatchOprCallback_fail(long j, IBatchOprCallback iBatchOprCallback, int i, String str, long j2, IBatchOprCallback.BatchOprDetailInfo batchOprDetailInfo);

    public static final native void IBatchOprCallback_failSwigExplicitIBatchOprCallback(long j, IBatchOprCallback iBatchOprCallback, int i, String str, long j2, IBatchOprCallback.BatchOprDetailInfo batchOprDetailInfo);

    public static final native void IBatchOprCallback_setLogin(long j, IBatchOprCallback iBatchOprCallback, String str, boolean z);

    public static final native void IBatchOprCallback_setLoginSwigExplicitIBatchOprCallback(long j, IBatchOprCallback iBatchOprCallback, String str, boolean z);

    public static final native void ICallbackWithMsgVec_change_ownership(ICallbackWithMsgVec iCallbackWithMsgVec, long j, boolean z);

    public static final native void ICallbackWithMsgVec_director_connect(ICallbackWithMsgVec iCallbackWithMsgVec, long j, boolean z, boolean z2);

    public static final native void ICallbackWithMsgVec_done(long j, ICallbackWithMsgVec iCallbackWithMsgVec, long j2, MsgVec msgVec);

    public static final native void ICallbackWithMsgVec_doneSwigExplicitICallbackWithMsgVec(long j, ICallbackWithMsgVec iCallbackWithMsgVec, long j2, MsgVec msgVec);

    public static final native void ICallbackWithMsgVec_fail(long j, ICallbackWithMsgVec iCallbackWithMsgVec, int i, String str);

    public static final native void ICallbackWithMsgVec_failSwigExplicitICallbackWithMsgVec(long j, ICallbackWithMsgVec iCallbackWithMsgVec, int i, String str);

    public static final native boolean MsgExtHelper_deleteConversation(String str, int i, String str2);

    public static final native boolean MsgExtHelper_deleteConversationAndMessages(String str, int i, String str2);

    public static final native int MsgExtHelper_getConversationCount(String str);

    public static final native long MsgExtHelper_getMsgManagerExt(String str);

    public static final native long MsgExtHelper_getSessionList(String str);

    public static final native int MsgExtHelper_initStorage(String str);

    public static final native void MsgExtHelper_sendMsgToMultiUsers(String str, long j, StrVec strVec, long j2, Msg msg, long j3, IBatchOprCallback iBatchOprCallback);

    public static final native boolean MsgExt_convertToImportmsg(long j, MsgExt msgExt);

    public static final native int MsgExt_customInt(long j, MsgExt msgExt);

    public static final native String MsgExt_customStr(long j, MsgExt msgExt);

    public static final native boolean MsgExt_hasGap(long j, MsgExt msgExt);

    public static final native boolean MsgExt_isPeerRead(long j, MsgExt msgExt);

    public static final native boolean MsgExt_isRead(long j, MsgExt msgExt);

    public static final native boolean MsgExt_remove(long j, MsgExt msgExt);

    public static final native boolean MsgExt_setCustomInt(long j, MsgExt msgExt, int i);

    public static final native boolean MsgExt_setCustomStr(long j, MsgExt msgExt, String str);

    public static final native boolean MsgExt_setSender(long j, MsgExt msgExt, String str);

    public static final native boolean MsgExt_setTime(long j, MsgExt msgExt, long j2);

    public static final native void MsgLocatorVec_add(long j, MsgLocatorVec msgLocatorVec, long j2, MessageLocator messageLocator);

    public static final native long MsgLocatorVec_capacity(long j, MsgLocatorVec msgLocatorVec);

    public static final native void MsgLocatorVec_clear(long j, MsgLocatorVec msgLocatorVec);

    public static final native long MsgLocatorVec_get(long j, MsgLocatorVec msgLocatorVec, int i);

    public static final native boolean MsgLocatorVec_isEmpty(long j, MsgLocatorVec msgLocatorVec);

    public static final native void MsgLocatorVec_reserve(long j, MsgLocatorVec msgLocatorVec, long j2);

    public static final native void MsgLocatorVec_set(long j, MsgLocatorVec msgLocatorVec, int i, long j2, MessageLocator messageLocator);

    public static final native long MsgLocatorVec_size(long j, MsgLocatorVec msgLocatorVec);

    public static final native int SessionExt_deleteLocalMsg(long j, SessionExt sessionExt, long j2, Msg msg, long j3, INotifyCallback iNotifyCallback);

    public static final native void SessionExt_findMsg(long j, SessionExt sessionExt, long j2, MsgLocatorVec msgLocatorVec, long j3, ICallbackWithMsgVec iCallbackWithMsgVec);

    public static final native long SessionExt_getDraft(long j, SessionExt sessionExt);

    public static final native void SessionExt_getLocalMsgs(long j, SessionExt sessionExt, long j2, long j3, Msg msg, long j4, ICallbackWithMsgVec iCallbackWithMsgVec);

    public static final native void SessionExt_getMsgs(long j, SessionExt sessionExt, long j2, long j3, Msg msg, long j4, ICallbackWithMsgVec iCallbackWithMsgVec);

    public static final native void SessionExt_getMsgsForward(long j, SessionExt sessionExt, long j2, long j3, Msg msg, long j4, ICallbackWithMsgVec iCallbackWithMsgVec);

    public static final native long SessionExt_getMsgsFromCache__SWIG_0(long j, SessionExt sessionExt, long j2, long j3, Msg msg);

    public static final native long SessionExt_getMsgsFromCache__SWIG_1(long j, SessionExt sessionExt, long j2);

    public static final native long SessionExt_getUndeletedMsgsFromCache__SWIG_0(long j, SessionExt sessionExt, long j2, long j3, Msg msg);

    public static final native long SessionExt_getUndeletedMsgsFromCache__SWIG_1(long j, SessionExt sessionExt, long j2);

    public static final native boolean SessionExt_hasDraft(long j, SessionExt sessionExt);

    public static final native void SessionExt_ignoreStorage(long j, SessionExt sessionExt);

    public static final native int SessionExt_importMsg(long j, SessionExt sessionExt, long j2, MsgVec msgVec);

    public static final native long SessionExt_msgUnread(long j, SessionExt sessionExt);

    public static final native void SessionExt_reportReaded(long j, SessionExt sessionExt, long j2, Msg msg, long j3, INotifyCallback iNotifyCallback);

    public static final native void SessionExt_revokeMsg(long j, SessionExt sessionExt, long j2, Msg msg, long j3, INotifyCallback iNotifyCallback);

    public static final native int SessionExt_saveMsg(long j, SessionExt sessionExt, long j2, Msg msg, String str, boolean z);

    public static final native void SessionExt_setDraft(long j, SessionExt sessionExt, long j2, Draft draft);

    public static final native void SessionExt_syncRevokeNotify(long j, SessionExt sessionExt, long j2, INotifyCallback iNotifyCallback);

    public static void SwigDirector_IBatchOprCallback_done(IBatchOprCallback iBatchOprCallback) {
        iBatchOprCallback.done();
    }

    public static void SwigDirector_IBatchOprCallback_fail(IBatchOprCallback iBatchOprCallback, int i, String str, long j) {
        iBatchOprCallback.fail(i, str, j == 0 ? null : new IBatchOprCallback.BatchOprDetailInfo(j, false));
    }

    public static void SwigDirector_IBatchOprCallback_setLogin(IBatchOprCallback iBatchOprCallback, String str, boolean z) {
        iBatchOprCallback.setLogin(str, z);
    }

    public static void SwigDirector_ICallbackWithMsgVec_done(ICallbackWithMsgVec iCallbackWithMsgVec, long j) {
        iCallbackWithMsgVec.done(new MsgVec(j, false));
    }

    public static void SwigDirector_ICallbackWithMsgVec_fail(ICallbackWithMsgVec iCallbackWithMsgVec, int i, String str) {
        iCallbackWithMsgVec.fail(i, str);
    }

    public static final native void delete_Draft(long j);

    public static final native void delete_ErrInfoVec(long j);

    public static final native void delete_IBatchOprCallback(long j);

    public static final native void delete_IBatchOprCallback_BatchOprDetailInfo(long j);

    public static final native void delete_IBatchOprCallback_BatchOprDetailInfo_ErrInfo(long j);

    public static final native void delete_ICallbackWithMsgVec(long j);

    public static final native void delete_MsgExt(long j);

    public static final native void delete_MsgExtHelper(long j);

    public static final native void delete_MsgLocatorVec(long j);

    public static final native void delete_SessionExt(long j);

    public static final native long new_Draft();

    public static final native long new_ErrInfoVec__SWIG_0();

    public static final native long new_ErrInfoVec__SWIG_1(long j);

    public static final native long new_IBatchOprCallback();

    public static final native long new_IBatchOprCallback_BatchOprDetailInfo();

    public static final native long new_IBatchOprCallback_BatchOprDetailInfo_ErrInfo();

    public static final native long new_ICallbackWithMsgVec();

    public static final native long new_MsgExt(long j, Msg msg);

    public static final native long new_MsgExtHelper();

    public static final native long new_MsgLocatorVec__SWIG_0();

    public static final native long new_MsgLocatorVec__SWIG_1(long j);

    public static final native long new_SessionExt(long j, Session session);

    private static final native void swig_module_init();
}
