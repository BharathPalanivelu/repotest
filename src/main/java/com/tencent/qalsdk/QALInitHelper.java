package com.tencent.qalsdk;

import com.tencent.qalsdk.base.remote.IBaseActionListener;
import com.tencent.qalsdk.sdk.c;
import com.tencent.qalsdk.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QALInitHelper {
    private static int MAX_LEN = 5000;
    private static QALInitHelper inst = new QALInitHelper();
    private static String tag = "QALInitHelper";
    private ConcurrentLinkedQueue<QALSendData> waitQueue = new ConcurrentLinkedQueue<>();

    public static QALInitHelper instance() {
        return inst;
    }

    public void addToQueue(String str, byte[] bArr, IBaseActionListener iBaseActionListener) {
        String str2 = tag;
        QLog.d(str2, "init not ok,add to queue:" + str);
        QALSendData qALSendData = new QALSendData();
        qALSendData.cmd = str;
        qALSendData.body = bArr;
        qALSendData.listener = iBaseActionListener;
        if (this.waitQueue.size() > MAX_LEN) {
            QLog.e("QALInitHelper", 1, " queue full:" + MAX_LEN);
        } else if (!this.waitQueue.add(qALSendData)) {
            QLog.e("QALInitHelper", 1, "add queue error");
        }
    }

    public void sendMsg() {
        synchronized (this.waitQueue) {
            while (!this.waitQueue.isEmpty()) {
                QALSendData poll = this.waitQueue.poll();
                if (poll != null) {
                    String str = tag;
                    QLog.i(str, 4, "init ok,send saved msg :" + poll.cmd + ":" + poll.body.length);
                    c a2 = c.a();
                    String d2 = c.a().d();
                    String str2 = poll.cmd;
                    byte[] bArr = poll.body;
                    IBaseActionListener iBaseActionListener = poll.listener;
                    c.a();
                    a2.a(d2, str2, bArr, iBaseActionListener, c.c(poll.body.length), true, false);
                }
            }
        }
    }
}
