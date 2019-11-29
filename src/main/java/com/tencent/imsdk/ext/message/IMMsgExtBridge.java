package com.tencent.imsdk.ext.message;

import android.os.Handler;
import com.tencent.imcore.MessageLocator;
import com.tencent.imcore.MsgExtHelper;
import com.tencent.imcore.MsgReceiptVec;
import com.tencent.imcore.SWIGTYPE_p_void;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.TIMUserConfig;
import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;

public class IMMsgExtBridge {
    /* access modifiers changed from: private */
    public static final String TAG = "IMMsgExtBridge";

    public static SWIGTYPE_p_void getMsgManagerExt(String str) {
        return MsgExtHelper.getMsgManagerExt(str);
    }

    public static void onMessageRevoked(MessageLocator messageLocator, TIMUserConfig tIMUserConfig) {
        TIMMessageRevokedListener messageRevokedListener = new TIMUserConfigMsgExt(tIMUserConfig).getMessageRevokedListener();
        if (messageRevokedListener == null) {
            QLog.i(TAG, 1, "msg revoked listener not exist");
            return;
        }
        TIMMessageLocator tIMMessageLocator = new TIMMessageLocator(messageLocator);
        Handler handler = IMMsfCoreProxy.mainHandler;
        if (handler != null) {
            handler.post(new aa(messageRevokedListener, tIMMessageLocator));
        }
    }

    public static void onRecvMsgReceipt(MsgReceiptVec msgReceiptVec, TIMUserConfig tIMUserConfig) {
        TIMMessageReceiptListener messageReceiptListener = new TIMUserConfigMsgExt(tIMUserConfig).getMessageReceiptListener();
        ArrayList arrayList = new ArrayList();
        if (msgReceiptVec.size() > 0) {
            for (int i = 0; ((long) i) < msgReceiptVec.size(); i++) {
                TIMMessageReceipt convertFrom = TIMMessageReceipt.convertFrom(msgReceiptVec.get(i));
                if (convertFrom != null) {
                    arrayList.add(convertFrom);
                }
            }
        }
        Handler handler = IMMsfCoreProxy.mainHandler;
        if (handler != null) {
            handler.post(new ab(messageReceiptListener, arrayList));
        }
    }
}
