package com.tencent.imsdk.ext.message;

import com.tencent.imsdk.log.QLog;
import java.util.List;

final class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMMessageReceiptListener f30980a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ List f30981b;

    ab(TIMMessageReceiptListener tIMMessageReceiptListener, List list) {
        this.f30980a = tIMMessageReceiptListener;
        this.f30981b = list;
    }

    public final void run() {
        TIMMessageReceiptListener tIMMessageReceiptListener = this.f30980a;
        if (tIMMessageReceiptListener == null) {
            QLog.i(IMMsgExtBridge.TAG, 1, "msg receipt listener not exist");
        } else {
            tIMMessageReceiptListener.onRecvReceipt(this.f30981b);
        }
    }
}
