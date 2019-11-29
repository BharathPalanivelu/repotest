package com.tencent.imsdk;

import com.tencent.imsdk.IMMsgSender;
import com.tencent.imsdk.log.QLog;
import com.tencent.qalsdk.QALValueCallBack;
import com.tencent.qalsdk.QALValueWithSeqCallBack;

final class co implements QALValueWithSeqCallBack {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ QALValueCallBack f30837a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMMsgSender f30838b;

    co(IMMsgSender iMMsgSender, QALValueCallBack qALValueCallBack) {
        this.f30838b = iMMsgSender;
        this.f30837a = qALValueCallBack;
    }

    public final void onError(int i, String str, int i2) {
        long j = (long) i2;
        long longValue = this.f30838b.seqMap.containsKey(Long.valueOf(j)) ? ((Long) this.f30838b.seqMap.get(Long.valueOf(j))).longValue() : 0;
        IMErrInfo iMErrInfo = new IMErrInfo(i, str);
        BaseConstants.covertErrorCode(iMErrInfo);
        QLog.i(IMMsgSender.TAG, 1, "resend msg reply onError, qalSeq:" + j + "|randKey:" + longValue + "|code: " + iMErrInfo.getCode() + "|descr: " + iMErrInfo.getMsg());
        if (this.f30838b.seqMap.containsKey(Long.valueOf(j))) {
            if (this.f30838b.resendMsgMap.containsKey(Long.valueOf(longValue))) {
                IMMsgSender.ab abVar = (IMMsgSender.ab) this.f30838b.resendMsgMap.get(Long.valueOf(longValue));
                abVar.f30666g--;
                if (!(iMErrInfo.getCode() == 6012 || iMErrInfo.getCode() == 6300) || abVar.f30666g < 0) {
                    this.f30838b.resendMsgMap.remove(Long.valueOf(longValue));
                    this.f30837a.onError(iMErrInfo.getCode(), iMErrInfo.getMsg());
                }
            }
            this.f30838b.seqMap.remove(Long.valueOf(j));
        }
    }

    public final void onSuccess(byte[] bArr, int i) {
        long j = (long) i;
        String access$100 = IMMsgSender.TAG;
        QLog.i(access$100, 1, "resend msg reply onSucc, qalSeq:" + j);
        if (this.f30838b.seqMap.containsKey(Long.valueOf(j))) {
            long longValue = ((Long) this.f30838b.seqMap.get(Long.valueOf(j))).longValue();
            if (this.f30838b.resendMsgMap.containsKey(Long.valueOf(longValue))) {
                String access$1002 = IMMsgSender.TAG;
                QLog.i(access$1002, 1, "resend msg reply callback, qalSeq:" + j + "|randKey:" + longValue);
                this.f30837a.onSuccess(bArr);
                this.f30838b.resendMsgMap.remove(Long.valueOf(longValue));
            }
            this.f30838b.seqMap.remove(Long.valueOf(j));
        }
    }
}
