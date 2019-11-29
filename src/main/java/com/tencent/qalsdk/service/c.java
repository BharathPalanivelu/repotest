package com.tencent.qalsdk.service;

import android.content.Context;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.salesforce.android.chat.core.internal.logging.event.ChatFileTransferEvent;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.IMsfServiceCallbacker;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.config.NativeConfigStore;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.core.l;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.sdk.r;
import com.tencent.qalsdk.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    static ConcurrentHashMap<String, b> f32310a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    static j f32311b;

    /* renamed from: c  reason: collision with root package name */
    private static a f32312c = new a();

    public static void a(Context context, j jVar) {
        f32311b = jVar;
        f32312c.setName("MsfServiceAppMsgHandler");
        f32312c.start();
        try {
            String[] configList = l.a().getConfigList("app_process_info_");
            QLog.d("MSF.S.AppProcessManager", "start loadAppProcessInfos:" + configList.length);
            for (String str : configList) {
                QLog.d("MSF.S.AppProcessManager", "loadAppProcessInfo proInfo:" + str);
                String[] split = str.split(",");
                String str2 = split[0];
                String str3 = "";
                if (split.length > 1) {
                    str3 = split[1];
                }
                a(str2, str3, (IMsfServiceCallbacker) null);
            }
        } catch (UnsatisfiedLinkError e2) {
            QLog.e("MSF.S.AppProcessManager", "so init error:" + e2.getMessage());
        }
    }

    public static void a(String str, String str2, IMsfServiceCallbacker iMsfServiceCallbacker) {
        if (str.equals(QalService.getProccessName())) {
            QLog.e("MSF.S.AppProcessManager", "WARNING, bind self:" + str);
        }
        if (!f32310a.containsKey(str)) {
            f32310a.putIfAbsent(str, new b());
            if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, "add bootName " + str);
            }
        }
        f32310a.get(str).a(str, str2, iMsfServiceCallbacker);
        try {
            b bVar = f32310a.get(str);
            l.a().setConfig("app_process_info_" + str, bVar.f32304b + "," + bVar.f32305c + "," + bVar.f32303a);
        } catch (UnsatisfiedLinkError e2) {
            QLog.e("MSF.S.AppProcessManager", "onRegisterApp exception: setConfig not find" + e2.getMessage());
        }
        QLog.i("MSF.S.AppProcessManager", "onRegisterApp: " + str);
        f32312c.a();
    }

    public static void a(String str, Boolean bool) {
        b bVar = f32310a.get(str);
        if (bVar != null) {
            bVar.b();
        }
        boolean booleanValue = bool.booleanValue();
        String str2 = ChatFileTransferEvent.FAILED;
        if (booleanValue) {
            b remove = f32310a.remove(str);
            NativeConfigStore a2 = l.a();
            a2.removeConfig("app_process_info_" + str);
            if (QLog.isColorLevel()) {
                StringBuilder sb = new StringBuilder("remove process :");
                sb.append(str);
                sb.append(SQLBuilder.BLANK);
                if (remove != null) {
                    str2 = "succ";
                }
                sb.append(str2);
                QLog.d("MSF.S.AppProcessManager", 2, sb.toString());
            }
        } else if (QLog.isColorLevel()) {
            StringBuilder sb2 = new StringBuilder("unregister process :");
            sb2.append(str);
            sb2.append(SQLBuilder.BLANK);
            if (bVar != null) {
                str2 = "succ";
            }
            sb2.append(str2);
            QLog.d("MSF.S.AppProcessManager", 2, sb2.toString());
        }
    }

    public static void a(String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (str != null && str.length() != 0) {
            if (str.equals("*")) {
                for (Map.Entry next : f32310a.entrySet()) {
                    MsfSdkUtils.addFromMsgProcessName((String) next.getKey(), fromServiceMsg);
                    ((b) next.getValue()).f32306d.add(new r(toServiceMsg, fromServiceMsg));
                }
            } else {
                b bVar = f32310a.get(str);
                if (bVar == null) {
                    QLog.e("MSF.S.AppProcessManager", 1, "can not find " + str + " to receive msg to:" + toServiceMsg + " from:" + fromServiceMsg);
                } else if (MsfSdkUtils.isPrivilegeCMD(fromServiceMsg.getServiceCmd())) {
                    bVar.f32306d.addFirst(new r(toServiceMsg, fromServiceMsg));
                    QLog.d("MSF.S.AppProcessManager", "service add queue first:" + System.currentTimeMillis() + "|" + fromServiceMsg.getServiceCmd() + "|" + fromServiceMsg.getRequestSsoSeq());
                } else {
                    bVar.f32306d.addLast(new r(toServiceMsg, fromServiceMsg));
                    QLog.d("MSF.S.AppProcessManager", "service add queue last:" + System.currentTimeMillis() + "|" + fromServiceMsg.getServiceCmd() + "|" + fromServiceMsg.getRequestSsoSeq());
                }
            }
            f32312c.a();
        } else if (QLog.isColorLevel()) {
            QLog.e("MSF.S.AppProcessManager", 2, "find null processName msg to app " + toServiceMsg + SQLBuilder.BLANK + fromServiceMsg);
        }
    }
}
