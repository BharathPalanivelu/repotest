package com.tencent.qalsdk.config;

import android.content.Context;
import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.g.a.a.e;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.core.n;
import com.tencent.qalsdk.sdk.MsfCommand;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.util.QLog;
import qalsdk.aa;
import qalsdk.af;
import tencent.tls.platform.SigType;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f32158a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f32159b = 0;

    /* renamed from: c  reason: collision with root package name */
    public byte f32160c = 0;

    /* renamed from: d  reason: collision with root package name */
    public byte f32161d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f32162e = 8;

    /* renamed from: f  reason: collision with root package name */
    public byte f32163f = 0;

    /* renamed from: g  reason: collision with root package name */
    public byte f32164g = 0;

    public static aa a(ToServiceMsg toServiceMsg) {
        e eVar = new e((byte[]) toServiceMsg.getAttribute("to_push_cmdCallbackerInfo"));
        aa aaVar = new aa();
        aaVar.readFrom(eVar);
        return aaVar;
    }

    public static af b(ToServiceMsg toServiceMsg) {
        e eVar = new e((byte[]) toServiceMsg.getAttribute("to_push_pushRegisterInfo"));
        af afVar = new af();
        afVar.readFrom(eVar);
        return afVar;
    }

    public static ToServiceMsg a(String str) {
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, AppEventsConstants.EVENT_PARAM_VALUE_NO, "cmd_openConn");
        toServiceMsg.setMsfCommand(MsfCommand.openConn);
        toServiceMsg.setNeedCallback(false);
        toServiceMsg.setTimeout(10000);
        return toServiceMsg;
    }

    public static void a(Context context, String str, String str2, String str3, int i, String str4, byte[] bArr) {
        Intent intent = new Intent(str3);
        intent.putExtra("offlineMsgID", str2);
        intent.putExtra("istatus", i);
        intent.putExtra("gatewayip", n.b());
        intent.putExtra("offlineMsgCmd", str4);
        intent.putExtra("offlineMsgContent", bArr);
        try {
            if (str3.toLowerCase().indexOf("activity", 0) != -1) {
                intent.setFlags(SigType.TLS);
                context.startActivity(intent);
            }
            intent.setFlags(32);
            context.sendBroadcast(intent);
        } catch (Exception e2) {
            QLog.d("MSF.S.Util", 1, "sendBootAction " + e2);
        }
        QLog.d("MSF.S.Util", 1, "send bootAction " + str3 + " for " + str + " uin:" + str2 + " istatus:" + i);
    }

    public static FromServiceMsg c(ToServiceMsg toServiceMsg) {
        FromServiceMsg fromServiceMsg = new FromServiceMsg(toServiceMsg.getUin(), toServiceMsg.getServiceCmd());
        fromServiceMsg.setAppId(toServiceMsg.getAppId());
        fromServiceMsg.setAppSeq(toServiceMsg.getAppSeq());
        fromServiceMsg.setRequestSsoSeq(toServiceMsg.getRequestSsoSeq());
        fromServiceMsg.setMsfCommand(toServiceMsg.getMsfCommand());
        MsfSdkUtils.addFromMsgProcessName(d(toServiceMsg), fromServiceMsg);
        return fromServiceMsg;
    }

    public static String d(ToServiceMsg toServiceMsg) {
        return (toServiceMsg == null || toServiceMsg.getAttributes().get("to_SenderProcessName") == null) ? "" : (String) toServiceMsg.getAttributes().get("to_SenderProcessName");
    }
}
