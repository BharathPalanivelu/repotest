package com.tencent.imsdk;

import android.util.Log;
import com.tencent.imsdk.log.QLog;
import com.tencent.qalsdk.QALSDKManager;
import com.tencent.qalsdk.QALValueCallBack;
import com.tencent.qalsdk.QALValueWithSeqCallBack;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class IMMsgSender {
    private static final String CMD_STR = "im_open_msg.msg_send,group_open_svc.group_msg_send,group_open_svc.create_group,group_open_svc.apply_join_group,group_open_svc.quit_group,openim.pbvideoapp,openim.pbvideoinfo";
    private static final int DEFAULT_DELAY_SECONDS = 3;
    private static final int DEFAULT_RETRY_TIMES = 2;
    private static final String SSO_CMD_SEND_C2C_MSG = "im_open_msg.msg_send";
    private static final String SSO_CMD_SEND_CREATE_GROUP = "group_open_svc.create_group";
    private static final String SSO_CMD_SEND_GRP_MSG = "group_open_svc.group_msg_send";
    private static final String SSO_CMD_SEND_JOIN_GROUP = "group_open_svc.apply_join_group";
    private static final String SSO_CMD_SEND_QUIT_GROUP = "group_open_svc.quit_group";
    private static final String SSO_CMD_SEND_VIDEO_APP = "openim.pbvideoapp";
    private static final String SSO_CMD_SEND_VIDEO_INFO = "openim.pbvideoinfo";
    /* access modifiers changed from: private */
    public static final String TAG = "IMMsgSender";
    private static Random random = new Random(System.currentTimeMillis());
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Long, ab> resendMsgMap = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Long, Long> seqMap = new ConcurrentHashMap<>();

    private static class aa {

        /* renamed from: a  reason: collision with root package name */
        static IMMsgSender f30659a = new IMMsgSender();
    }

    static class ab {

        /* renamed from: a  reason: collision with root package name */
        public String f30660a;

        /* renamed from: b  reason: collision with root package name */
        public String f30661b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f30662c;

        /* renamed from: d  reason: collision with root package name */
        public long f30663d;

        /* renamed from: e  reason: collision with root package name */
        public long f30664e;

        /* renamed from: f  reason: collision with root package name */
        public QALValueWithSeqCallBack f30665f;

        /* renamed from: g  reason: collision with root package name */
        public int f30666g = 2;

        public ab(String str, String str2, byte[] bArr, long j, QALValueWithSeqCallBack qALValueWithSeqCallBack) {
            this.f30660a = str;
            this.f30661b = str2;
            this.f30662c = bArr;
            this.f30663d = j;
            this.f30665f = qALValueWithSeqCallBack;
        }

        public final String toString() {
            return "ResendMsg{sender:" + this.f30660a + ", serviceCmd:" + this.f30661b + ", randKey:" + this.f30664e + ", remainRetries:" + this.f30666g + "}";
        }
    }

    public static IMMsgSender getInstance() {
        return aa.f30659a;
    }

    static boolean isNeedResend(String str) {
        return CMD_STR.contains(str);
    }

    static long randGen() {
        return ((System.currentTimeMillis() << 16) | (random.nextLong() & 65535)) & 2147483647L;
    }

    public void sendMsg(String str, String str2, byte[] bArr, long j, QALValueCallBack qALValueCallBack) {
        QALValueCallBack qALValueCallBack2 = qALValueCallBack;
        if (isNeedResend(str2)) {
            Log.i(TAG, "need resend");
            co coVar = null;
            if (qALValueCallBack2 != null) {
                coVar = new co(this, qALValueCallBack2);
            }
            String str3 = str;
            String str4 = str2;
            byte[] bArr2 = bArr;
            long j2 = j;
            co coVar2 = coVar;
            long sendMsgAndGetSeq = (long) QALSDKManager.getInstance().sendMsgAndGetSeq(str3, str4, bArr2, j2, coVar2, false);
            ab abVar = new ab(str3, str4, bArr2, j2, coVar2);
            long randGen = randGen();
            abVar.f30664e = randGen;
            this.seqMap.put(Long.valueOf(sendMsgAndGetSeq), Long.valueOf(randGen));
            this.resendMsgMap.put(Long.valueOf(randGen), abVar);
            String str5 = TAG;
            QLog.i(str5, 1, "resend msg original request, qalSeq:" + sendMsgAndGetSeq + "|" + abVar.toString());
            Timer timer = new Timer(true);
            for (int i = 1; i <= abVar.f30666g; i++) {
                timer.schedule(new cp(this, randGen), TimeUnit.SECONDS.toMillis((long) (i * 3)));
            }
            return;
        }
        String str6 = TAG;
        QLog.e(str6, 1, "sendmsg cb: " + qALValueCallBack2);
        QALSDKManager.getInstance().sendMsg(str, str2, bArr, j, qALValueCallBack);
    }
}
