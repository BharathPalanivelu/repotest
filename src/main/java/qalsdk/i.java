package qalsdk;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.core.m;
import com.tencent.qalsdk.sdk.MsfCommand;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.util.QLog;
import java.util.concurrent.LinkedBlockingDeque;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static LinkedBlockingDeque<a> f34144a = new LinkedBlockingDeque<>(100);

    /* renamed from: b  reason: collision with root package name */
    private static long f34145b = (System.currentTimeMillis() - 180000);

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f34146a;
    }

    public static void a(int i) {
        if (m.b()) {
            if (f34144a.size() >= 100) {
                QLog.d("MSF.C.NetExceptionStat", 2, "addNetException NetExceptionEvent count = " + f34144a.size() + "too much drop");
                return;
            }
            a aVar = new a();
            long currentTimeMillis = System.currentTimeMillis();
            aVar.f34146a = currentTimeMillis;
            try {
                f34144a.addLast(aVar);
                QLog.d("MSF.C.NetExceptionStat", 2, "addNetException NetExceptionEvent count = " + f34144a.size());
                while (true) {
                    try {
                        a peek = f34144a.peek();
                        if (peek == null || currentTimeMillis - peek.f34146a < ((long) a.k())) {
                            QLog.d("MSF.C.NetExceptionStat", 2, "addNetException after remove expire event NetExceptionEvent count = " + f34144a.size());
                        } else {
                            f34144a.removeFirst();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                QLog.d("MSF.C.NetExceptionStat", 2, "addNetException after remove expire event NetExceptionEvent count = " + f34144a.size());
                if (currentTimeMillis - f34145b > ((long) a.k()) && f34144a.size() >= a.l()) {
                    QLog.d("MSF.C.NetExceptionStat", 2, "NetExceptionEvent count = " + f34144a.size() + " report to ui now");
                    FromServiceMsg fromServiceMsg = new FromServiceMsg(m.f32200a.h(), j.b(), AppEventsConstants.EVENT_PARAM_VALUE_NO, "cmd_connWeakNet");
                    fromServiceMsg.setMsgSuccess();
                    fromServiceMsg.setMsfCommand(MsfCommand.onConnWeakNet);
                    MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                    m.f32200a.a((ToServiceMsg) null, fromServiceMsg);
                    f34145b = currentTimeMillis;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public enum b {
        ;
        

        /* renamed from: a  reason: collision with root package name */
        public static final int f34147a = 1;

        static {
            new int[1][0] = 1;
        }
    }
}
