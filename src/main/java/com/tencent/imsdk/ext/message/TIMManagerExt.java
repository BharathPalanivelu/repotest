package com.tencent.imsdk.ext.message;

import android.text.TextUtils;
import com.tencent.imcore.IMCore;
import com.tencent.imcore.MsgExtHelper;
import com.tencent.imcore.PairSession;
import com.tencent.imcore.PairVectorSession;
import com.tencent.imcore.StrVec;
import com.tencent.imcore.UserConfig;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.IMCoreWrapper;
import com.tencent.imsdk.IMErrInfo;
import com.tencent.imsdk.IMFunc;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMUser;
import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.utils.QualityReportHelper;
import java.util.ArrayList;
import java.util.List;

public class TIMManagerExt {
    /* access modifiers changed from: private */
    public static final String TAG = ("imsdk." + TIMManagerExt.class.getSimpleName());
    /* access modifiers changed from: private */
    public TIMManager manager;

    private TIMManagerExt(TIMManager tIMManager) {
        this.manager = tIMManager == null ? TIMManager.getInstance() : tIMManager;
    }

    public static TIMManagerExt getInstance() {
        return new TIMManagerExt(TIMManager.getInstance());
    }

    public static TIMManagerExt getInstanceById(String str) {
        return new TIMManagerExt(TIMManager.getInstanceById(str));
    }

    public boolean deleteConversation(TIMConversationType tIMConversationType, String str) {
        if (!IMCoreWrapper.get().isIMCoreUserInited()) {
            return false;
        }
        if (str == null) {
            QLog.e(TAG, 1, "delete conversation with null peer");
            return false;
        }
        String str2 = TAG;
        QLog.i(str2, 1, "before deleteConversation, count " + getConversationCount());
        boolean deleteConversation = MsgExtHelper.deleteConversation(IMLiteBridge.getIdentifier(this.manager), IMLiteBridge.conversationType2Internal(tIMConversationType), str);
        String str3 = TAG;
        QLog.i(str3, 1, "after deleteConversation, count " + getConversationCount());
        return deleteConversation;
    }

    public boolean deleteConversationAndLocalMsgs(TIMConversationType tIMConversationType, String str) {
        if (!IMCoreWrapper.get().isIMCoreUserInited()) {
            return false;
        }
        if (str == null) {
            QLog.e(TAG, 1, "delete conversation with null peer");
            return false;
        }
        String str2 = TAG;
        QLog.i(str2, 1, "before deleteConversation, count " + getConversationCount());
        boolean deleteConversationAndMessages = MsgExtHelper.deleteConversationAndMessages(IMLiteBridge.getIdentifier(this.manager), IMLiteBridge.conversationType2Internal(tIMConversationType), str);
        String str3 = TAG;
        QLog.i(str3, 1, "after deleteConversation, count " + getConversationCount());
        return deleteConversationAndMessages;
    }

    public long getConversationCount() {
        if (!IMCoreWrapper.get().isIMCoreUserInited()) {
            return 0;
        }
        long conversationCount = (long) MsgExtHelper.getConversationCount(IMLiteBridge.getIdentifier(this.manager));
        String str = TAG;
        QLog.i(str, 1, "getConversationCount: " + conversationCount);
        return conversationCount;
    }

    public List<TIMConversation> getConversationList() {
        ArrayList arrayList = new ArrayList();
        if (!IMCoreWrapper.get().isIMCoreUserInited()) {
            return arrayList;
        }
        String identifier = IMLiteBridge.getIdentifier(this.manager);
        PairVectorSession sessionList = MsgExtHelper.getSessionList(identifier);
        for (int i = 0; ((long) i) < sessionList.size(); i++) {
            PairSession pairSession = sessionList.get(i);
            TIMConversation buildConversation = IMLiteBridge.buildConversation(identifier);
            IMLiteBridge.setConversationPeer(buildConversation, new String(pairSession.getFirst()));
            IMLiteBridge.setConversationType(buildConversation, IMLiteBridge.conversationTypeFromInternal(pairSession.getSecond()));
            arrayList.add(buildConversation);
        }
        return arrayList;
    }

    public int initStorage(String str, TIMCallBack tIMCallBack) {
        if (tIMCallBack == null) {
            return -1;
        }
        if (!IMMsfCoreProxy.get().inited || IMMsfCoreProxy.get().getMode() != 1) {
            return BaseConstants.ERR_SDK_NOT_INITIALIZED;
        }
        if (this.manager.getLoginUser().equals(str)) {
            tIMCallBack.onSuccess();
            return 0;
        }
        IMErrInfo iMErrInfo = null;
        try {
            TIMUser tIMUser = new TIMUser();
            tIMUser.setIdentifier(str);
            IMLiteBridge.setUser2UserConfig(TIMManager.getInstance().getUserConfig(), tIMUser);
            UserConfig UserConfig2Internal = IMLiteBridge.UserConfig2Internal(TIMManager.getInstance().getUserConfig());
            IMLiteBridge.setIdentifier2TIMManager(this.manager, str);
            IMCore.get().initUser(UserConfig2Internal, new an(this, tIMCallBack, str));
        } catch (Throwable th) {
            iMErrInfo = new IMErrInfo(BaseConstants.ERR_INIT_CORE_FAIL, QLog.getStackTraceString(th));
        }
        if (iMErrInfo == null) {
            return 0;
        }
        String str2 = TAG;
        QLog.e(str2, 1, "initStorage failed|code: " + iMErrInfo.getCode() + " desc: " + iMErrInfo.getMsg());
        return iMErrInfo.getCode();
    }

    public void sendMessageToMultiUsers(List<String> list, TIMMessage tIMMessage, TIMSendMsgToMultiUserCallback tIMSendMsgToMultiUserCallback) {
        if (tIMSendMsgToMultiUserCallback != null) {
            if (IMFunc.preCheck(list == null || list.isEmpty() || tIMMessage == null, tIMSendMsgToMultiUserCallback, (QualityReportHelper) null) == 0) {
                StrVec strVec = new StrVec();
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        strVec.add(next);
                    }
                }
                MsgExtHelper.sendMsgToMultiUsers(IMLiteBridge.getIdentifier(this.manager), strVec, tIMMessage.getMsg(), new ao(this, tIMSendMsgToMultiUserCallback));
            }
        }
    }
}
