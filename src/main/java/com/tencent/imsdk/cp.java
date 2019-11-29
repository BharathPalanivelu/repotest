package com.tencent.imsdk;

import com.tencent.imsdk.IMMsgSender;
import com.tencent.imsdk.log.QLog;
import com.tencent.qalsdk.QALSDKManager;
import java.util.TimerTask;

final class cp extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ long f30839a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMMsgSender f30840b;

    cp(IMMsgSender iMMsgSender, long j) {
        this.f30840b = iMMsgSender;
        this.f30839a = j;
    }

    public final void run() {
        if (this.f30840b.resendMsgMap.containsKey(Long.valueOf(this.f30839a))) {
            IMMsgSender.ab abVar = (IMMsgSender.ab) this.f30840b.resendMsgMap.get(Long.valueOf(this.f30839a));
            long sendMsgAndGetSeq = (long) QALSDKManager.getInstance().sendMsgAndGetSeq(abVar.f30660a, abVar.f30661b, abVar.f30662c, abVar.f30663d, abVar.f30665f, true);
            this.f30840b.seqMap.put(Long.valueOf(sendMsgAndGetSeq), Long.valueOf(this.f30839a));
            String access$100 = IMMsgSender.TAG;
            QLog.i(access$100, 1, "resend msg request, qalSeq:" + sendMsgAndGetSeq + "|" + abVar.toString());
        }
    }
}
