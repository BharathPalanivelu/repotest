package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;
import com.tencent.qalsdk.QALLogListener;

final class br implements QALLogListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30783a;

    br(IMMsfCoreProxy iMMsfCoreProxy) {
        this.f30783a = iMMsfCoreProxy;
    }

    public final void log(int i, String str, String str2) {
        if (i == 1) {
            QLog.efile(str, 1, str2);
        } else if (i == 2) {
            QLog.wfile(str, 1, str2);
        } else if (i != 3) {
            QLog.dfile(str, 1, str2);
        } else {
            QLog.ifile(str, 1, str2);
        }
    }
}
