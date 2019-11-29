package com.tencent.qalsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.imsdk.BaseConstants;
import com.tencent.qalsdk.base.CloseConnReason;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.im_open.stat_forceoffline;
import com.tencent.qalsdk.sdk.MsfCommand;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.util.QLog;
import qalsdk.a;
import qalsdk.ad;
import qalsdk.c;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private j f32219a;

    /* renamed from: b  reason: collision with root package name */
    private long f32220b = -1;

    /* renamed from: c  reason: collision with root package name */
    private Handler f32221c = new q(this);

    public p(j jVar) {
        this.f32219a = jVar;
    }

    private boolean a(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        boolean z = businessFailCode == -12003 || businessFailCode == 210 || businessFailCode == -10001 || businessFailCode == -10003 || businessFailCode == -10004 || businessFailCode == -10006 || businessFailCode == -10106;
        if (!z && businessFailCode == -10005) {
            if (this.f32220b == -1) {
                this.f32220b = System.currentTimeMillis();
            }
            if (this.f32219a.f32187c.m.get()) {
                if (toServiceMsg == null || this.f32219a.f32187c.l == -1 || toServiceMsg.getRequestSsoSeq() < this.f32219a.f32187c.l) {
                    if (this.f32220b != -1 && System.currentTimeMillis() - this.f32220b > 60000) {
                        if (QLog.isColorLevel()) {
                            QLog.i("MSF.C.SSORespHandler", 2, "set userTokenExpired after so long wait. ");
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.i("MSF.C.SSORespHandler", 2, "set userTokenExpired. afterReloadD2SendSeq is " + this.f32219a.f32187c.l);
                }
                z = true;
            }
        }
        if (z) {
            MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
            this.f32219a.a(toServiceMsg, fromServiceMsg);
            return true;
        } else if (businessFailCode == -10101) {
            fromServiceMsg.setBusinessFail(2011, fromServiceMsg.getBusinessFailMsg());
            MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
            this.f32219a.a(toServiceMsg, fromServiceMsg);
            return true;
        } else if (businessFailCode == -10102) {
            this.f32219a.p.set(true);
            fromServiceMsg.setBusinessFail(2009, fromServiceMsg.getBusinessFailMsg());
            MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
            this.f32219a.a(toServiceMsg, fromServiceMsg);
            return true;
        } else if (businessFailCode == -10009) {
            fromServiceMsg.setBusinessFail(2015, fromServiceMsg.getBusinessFailMsg());
            MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
            this.f32219a.a(toServiceMsg, fromServiceMsg);
            this.f32219a.f32187c.k.a(CloseConnReason.ssoInvalidCookie);
            return true;
        } else if (businessFailCode == -10104) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.SSORespHandler", 2, "get CODE_SSO_FORCEQUIT kill " + this.f32219a.k.getPackageName() + ":qq now");
            }
            MsfSdkUtils.killProcess(this.f32219a.k, this.f32219a.k.getPackageName());
            return true;
        } else if (businessFailCode == -10105) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.SSORespHandler", 2, "get CODE_SSO_FORCEQUITSDK kill " + this.f32219a.k.getPackageName() + ":msf now");
            }
            Context context = this.f32219a.k;
            MsfSdkUtils.killProcess(context, this.f32219a.k.getPackageName() + ":MSF");
            return true;
        } else if (fromServiceMsg.getServiceCmd().equals("MessageSvc.PushForceOffline")) {
            try {
                this.f32219a.f32188d.a(fromServiceMsg.getUin());
                fromServiceMsg.addAttribute("_attr_sameDevice", false);
                fromServiceMsg.setBusinessFail(2013, fromServiceMsg.getBusinessFailMsg());
                MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                this.f32219a.a(toServiceMsg, fromServiceMsg);
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("MSF.C.SSORespHandler", 2, "handle forceLogout error " + e2);
                }
            }
            return true;
        } else if (!fromServiceMsg.getServiceCmd().equals("openqq.stat_forceoffline")) {
            return false;
        } else {
            try {
                this.f32219a.f32188d.a(fromServiceMsg.getUin());
                stat_forceoffline.ReqBody reqBody = new stat_forceoffline.ReqBody();
                byte[] bArr = new byte[(fromServiceMsg.getWupBuffer().length - 4)];
                System.arraycopy(fromServiceMsg.getWupBuffer(), 4, bArr, 0, bArr.length);
                reqBody.mergeFrom(bArr);
                if (reqBody.uint32_clear_sig.get() == 0) {
                    this.f32219a.f32188d.a(fromServiceMsg.getUin());
                    fromServiceMsg.addAttribute("_attr_sameDevice", Integer.valueOf(reqBody.uint32_same_device.get()));
                    fromServiceMsg.addAttribute("_attr_kickInfo", reqBody.str_info.get());
                    fromServiceMsg.addAttribute("_attr_kickTitle", reqBody.str_title.get());
                    fromServiceMsg.setBusinessFail(2013, reqBody.str_info.get());
                    MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                    this.f32219a.a(toServiceMsg, fromServiceMsg);
                }
                ToServiceMsg toServiceMsg2 = new ToServiceMsg("", fromServiceMsg.getUin(), "openqq.stat_forceoffline");
                toServiceMsg2.addAttribute("_attr_sameDevice", Integer.valueOf(reqBody.uint32_same_device.get()));
                toServiceMsg2.addAttribute("_attr_kickInfo", reqBody.str_info.get());
                toServiceMsg2.addAttribute("_attr_kickTitle", reqBody.str_title.get());
                stat_forceoffline.RspBody rspBody = new stat_forceoffline.RspBody();
                rspBody.uint32_seqno.set(reqBody.uint32_seqno.get());
                rspBody.uint32_result.set(0);
                byte[] byteArray = rspBody.toByteArray();
                if (reqBody.uint32_clear_sig.get() != 0) {
                    toServiceMsg2.setMsfCommand(MsfCommand._msf_kickedAndCleanTokenResp);
                } else {
                    toServiceMsg2.setMsfCommand(MsfCommand._msf_kickedResp);
                }
                toServiceMsg2.setNeedCallback(false);
                toServiceMsg2.putWupBuffer(n.a(byteArray));
                toServiceMsg2.setRequestSsoSeq(j.b());
                toServiceMsg2.setAppId(this.f32219a.h());
                toServiceMsg2.setTimeout(10000);
                toServiceMsg2.addAttribute(toServiceMsg2.getServiceCmd(), fromServiceMsg);
                this.f32219a.f32187c.a(toServiceMsg2);
            } catch (Exception e3) {
                if (QLog.isColorLevel()) {
                    QLog.e("MSF.C.SSORespHandler", 2, "send offlineResp error " + e3);
                }
            }
            return true;
        }
    }

    public final void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg != null) {
            toServiceMsg.getAttributes().remove("to_timeoutCallbacker");
        }
        if (fromServiceMsg.getServiceCmd().startsWith("SharpSvr.")) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (n.f32214f <= 0 || elapsedRealtime - n.f32214f <= 0 || elapsedRealtime - n.f32214f > BaseConstants.DEFAULT_MSG_TIMEOUT) {
                fromServiceMsg.addAttribute("__timestamp_msf2net_boot_sharp_c2s", -1);
            } else {
                fromServiceMsg.addAttribute("__timestamp_msf2net_boot_sharp_c2s", Long.valueOf(n.f32214f));
            }
        }
        if (a(fromServiceMsg, toServiceMsg)) {
            fromServiceMsg.getServiceCmd().startsWith("wtlogin.");
            return;
        }
        if (!(!a.f34048a || toServiceMsg == null || toServiceMsg.getMsfCommand() == MsfCommand._msf_RegPush || toServiceMsg.getMsfCommand() == MsfCommand._msf_queryPush || this.f32219a.f32188d == null)) {
            long currentTimeMillis = System.currentTimeMillis();
            ad adVar = this.f32219a.f32188d;
            this.f32219a.f32188d.a(toServiceMsg.getUin(), currentTimeMillis);
        }
        if (fromServiceMsg.getServiceCmd().equals("OnlinePush.SidTicketExpired")) {
            ToServiceMsg toServiceMsg2 = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
            toServiceMsg2.setRequestSsoSeq(fromServiceMsg.getRequestSsoSeq());
            toServiceMsg2.setAppId(this.f32219a.h());
            toServiceMsg2.setNeedCallback(false);
            toServiceMsg2.setTimeout(10000);
            this.f32219a.f32187c.a(toServiceMsg2);
            toServiceMsg2.getRequestSsoSeq();
            Message obtainMessage = this.f32221c.obtainMessage();
            obtainMessage.what = 1000;
            obtainMessage.obj = fromServiceMsg.getUin();
            if (this.f32221c.hasMessages(1000)) {
                this.f32221c.removeMessages(1000);
            }
            this.f32221c.sendMessageDelayed(obtainMessage, 3000);
        }
        if (toServiceMsg != null) {
            int i = r.f32222a[toServiceMsg.getMsfCommand().ordinal()];
            if (i == 1) {
                this.f32219a.f32188d.a(toServiceMsg, fromServiceMsg);
                FromServiceMsg fromServiceMsg2 = new FromServiceMsg(this.f32219a.h(), j.b(), AppEventsConstants.EVENT_PARAM_VALUE_NO, "cmd_connInfo");
                fromServiceMsg2.setMsgSuccess();
                fromServiceMsg2.setMsfCommand(MsfCommand.onConnInfo);
                fromServiceMsg2.addAttribute("to_conn_apn", c.a());
                fromServiceMsg2.addAttribute("to_conn_radioType", Integer.valueOf(c.b()));
                fromServiceMsg2.addAttribute("to_conn_serverIP", this.f32219a.f32187c.k.h().a());
                fromServiceMsg2.addAttribute("to_conn_gateIP", j.f32186b);
                fromServiceMsg2.getAttributes().put("to_SenderProcessName", "*");
                QLog.d("MSF.C.SSORespHandler", "send conn info:" + c.a() + ":" + c.b() + ":" + this.f32219a.f32187c.k.h().a() + ":" + j.f32186b);
                this.f32219a.a((ToServiceMsg) null, fromServiceMsg2);
            } else if (i == 2) {
                this.f32219a.f32188d.a(toServiceMsg, fromServiceMsg);
            } else if (i == 3) {
                this.f32219a.f32188d.b(toServiceMsg, fromServiceMsg);
            } else if (i == 4) {
                long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                try {
                    if (fromServiceMsg.isSuccess()) {
                        currentTimeMillis2 = (long) MsfSdkUtils.convertBytes2Int(fromServiceMsg.getWupBuffer(), 4);
                    }
                } catch (Exception e2) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.SSORespHandler", 4, "handle serverTime error " + e2);
                    }
                }
                NetConnInfoCenter.handleGetServerTimeResp(currentTimeMillis2);
            } else if (i != 5) {
                fromServiceMsg.setAppId(toServiceMsg.getAppId());
                fromServiceMsg.setAppSeq(toServiceMsg.getAppSeq());
                fromServiceMsg.setMsfCommand(toServiceMsg.getMsfCommand());
                this.f32219a.a(toServiceMsg, fromServiceMsg);
            } else {
                this.f32219a.i.a(fromServiceMsg);
            }
        } else if (fromServiceMsg.getServiceCmd().equals("ConfigPushSvc.PushReq")) {
            a.a(j.a(fromServiceMsg));
        } else {
            this.f32219a.f32188d.a(fromServiceMsg);
        }
    }
}
