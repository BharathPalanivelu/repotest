package com.shopee.app.pushnotification;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.garena.android.appkit.d.a;
import com.shopee.app.application.ar;
import com.shopee.app.data.viewmodel.RedirectParameters;
import com.shopee.app.pushnotification.GPNIntentService;
import com.shopee.app.tracking.e.b;
import com.shopee.app.ui.home.HomeActivity_;
import com.shopee.app.util.bm;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final b f18537a = new b(ar.f());

    private static void b(GPNIntentService.a aVar) {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.shopee.app.pushnotification.GPNIntentService.a r18) {
        /*
            r1 = r18
            b((com.shopee.app.pushnotification.GPNIntentService.a) r18)
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r0 = 2131887629(0x7f12060d, float:1.940987E38)
            java.lang.String r4 = com.garena.android.appkit.tools.b.e(r0)
            r0 = 2131888675(0x7f120a23, float:1.9411992E38)
            java.lang.String r5 = com.garena.android.appkit.tools.b.e(r0)
            r6 = 0
            r7 = 0
            java.lang.String r5 = r1.f18492a     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r8 = r1.f18494c     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r0 = r1.f18495d     // Catch:{ Exception -> 0x00f7 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00f7 }
            if (r0 != 0) goto L_0x002a
            java.lang.String r4 = r1.f18495d     // Catch:{ Exception -> 0x00f7 }
        L_0x002a:
            java.lang.String r0 = r1.f18493b     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r9 = ","
            java.lang.String[] r0 = r0.split(r9)     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r9 = r1.f18493b     // Catch:{ Exception -> 0x00f7 }
            com.shopee.app.data.viewmodel.RedirectParameters r10 = new com.shopee.app.data.viewmodel.RedirectParameters     // Catch:{ Exception -> 0x00f7 }
            r10.<init>(r0)     // Catch:{ Exception -> 0x00f7 }
            boolean r11 = r10.needsRNUpdate()     // Catch:{ Exception -> 0x00f7 }
            if (r11 == 0) goto L_0x0046
            com.shopee.app.react.g r11 = com.shopee.app.react.g.a()     // Catch:{ Exception -> 0x00f7 }
            r11.h()     // Catch:{ Exception -> 0x00f7 }
        L_0x0046:
            java.lang.String r11 = r1.f18496e     // Catch:{ Exception -> 0x00f7 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x00f7 }
            r12 = 8
            r13 = 99
            if (r11 != 0) goto L_0x005b
            java.lang.String r0 = r1.f18496e     // Catch:{ Exception -> 0x00f7 }
            android.content.Intent r0 = a((java.lang.String) r0)     // Catch:{ Exception -> 0x00f7 }
        L_0x0058:
            r6 = r0
            goto L_0x00fe
        L_0x005b:
            long r14 = r10.getActionId()     // Catch:{ Exception -> 0x00f7 }
            r16 = 0
            int r11 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r11 == 0) goto L_0x0072
            int r0 = r10.getActionBoxCategory()     // Catch:{ Exception -> 0x00f7 }
            android.content.Intent r0 = a((int) r0, (com.shopee.app.data.viewmodel.RedirectParameters) r10)     // Catch:{ Exception -> 0x00f7 }
        L_0x006d:
            r6 = r0
            r0 = 99
            goto L_0x00ff
        L_0x0072:
            java.lang.String r11 = r10.getSns()     // Catch:{ Exception -> 0x00f7 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x00f7 }
            if (r11 != 0) goto L_0x00b2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f7 }
            r0.<init>()     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r9 = "sns?"
            r0.append(r9)     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r9 = r10.getSns()     // Catch:{ Exception -> 0x00f7 }
            r0.append(r9)     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00f7 }
            com.shopee.app.application.ar r9 = com.shopee.app.application.ar.f()     // Catch:{ Exception -> 0x00f7 }
            com.shopee.app.ui.home.HomeActivity_$a r9 = com.shopee.app.ui.home.HomeActivity_.a(r9)     // Catch:{ Exception -> 0x00f7 }
            int r10 = r10.getTaskId()     // Catch:{ Exception -> 0x00f7 }
            com.shopee.app.ui.home.HomeActivity_$a r9 = r9.c(r10)     // Catch:{ Exception -> 0x00f7 }
            com.shopee.app.ui.home.HomeActivity_$a r0 = r9.a((java.lang.String) r0)     // Catch:{ Exception -> 0x00f7 }
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            org.a.a.a.c r0 = r0.k(r9)     // Catch:{ Exception -> 0x00f7 }
            com.shopee.app.ui.home.HomeActivity_$a r0 = (com.shopee.app.ui.home.HomeActivity_.a) r0     // Catch:{ Exception -> 0x00f7 }
            android.content.Intent r0 = r0.b()     // Catch:{ Exception -> 0x00f7 }
            goto L_0x0058
        L_0x00b2:
            int r11 = r0.length     // Catch:{ Exception -> 0x00f7 }
            if (r11 <= 0) goto L_0x00bc
            r0 = r0[r7]     // Catch:{ Exception -> 0x00f7 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x00f7 }
            goto L_0x00bd
        L_0x00bc:
            r0 = 0
        L_0x00bd:
            android.content.Intent r6 = a((com.shopee.app.data.viewmodel.RedirectParameters) r10)     // Catch:{ Exception -> 0x00f7 }
            if (r6 != 0) goto L_0x00ff
            if (r0 == r12) goto L_0x00ef
            if (r0 == r13) goto L_0x00e8
            switch(r0) {
                case 11: goto L_0x00e2;
                case 12: goto L_0x00d0;
                case 13: goto L_0x00e2;
                default: goto L_0x00ca;
            }     // Catch:{ Exception -> 0x00f7 }
        L_0x00ca:
            r9 = 5
            android.content.Intent r6 = b(r9, r10)     // Catch:{ Exception -> 0x00f7 }
            goto L_0x00ff
        L_0x00d0:
            int r11 = r10.getOfferStatus()     // Catch:{ Exception -> 0x00f7 }
            r13 = 2
            if (r11 == r13) goto L_0x00dc
            android.content.Intent r0 = a((java.lang.String) r9, (com.shopee.app.data.viewmodel.RedirectParameters) r10)     // Catch:{ Exception -> 0x00f7 }
            goto L_0x00f3
        L_0x00dc:
            r9 = 6
            android.content.Intent r6 = b(r9, r10)     // Catch:{ Exception -> 0x00f7 }
            goto L_0x00ff
        L_0x00e2:
            r9 = 4
            android.content.Intent r6 = b(r9, r10)     // Catch:{ Exception -> 0x00f7 }
            goto L_0x00ff
        L_0x00e8:
            r0 = 3
            android.content.Intent r0 = b(r0, r10)     // Catch:{ Exception -> 0x00f7 }
            goto L_0x006d
        L_0x00ef:
            android.content.Intent r0 = a((java.lang.String) r9, (com.shopee.app.data.viewmodel.RedirectParameters) r10)     // Catch:{ Exception -> 0x00f7 }
        L_0x00f3:
            r6 = r0
            r0 = 8
            goto L_0x00ff
        L_0x00f7:
            r0 = move-exception
            goto L_0x00fb
        L_0x00f9:
            r0 = move-exception
            r8 = r6
        L_0x00fb:
            com.garena.android.appkit.d.a.a(r0)
        L_0x00fe:
            r0 = 0
        L_0x00ff:
            r9 = 1
            if (r6 == 0) goto L_0x011a
            java.lang.String r10 = "KEY_FROM_NOTI"
            r6.putExtra(r10, r9)
            java.lang.String r10 = "KEY_PUSH_NOTI_CODE"
            r6.putExtra(r10, r0)
            java.lang.String r10 = "KEY_RECEIVED_TIME"
            r6.putExtra(r10, r2)
            if (r1 == 0) goto L_0x011a
            java.lang.String r10 = r1.f18493b
            java.lang.String r11 = "KEY_PUSH_NOTI_PARAMS"
            r6.putExtra(r11, r10)
        L_0x011a:
            com.shopee.app.application.ar r10 = com.shopee.app.application.ar.f()
            com.shopee.app.appuser.UserComponent r10 = r10.e()
            com.shopee.app.data.store.v r10 = r10.crossUserStatusStore()
            com.shopee.app.application.ar r11 = com.shopee.app.application.ar.f()
            com.shopee.app.appuser.UserComponent r11 = r11.e()
            com.shopee.app.util.s r11 = r11.featureToggleManager()
            java.lang.String r12 = "shopee_custom_noti_sound"
            boolean r11 = r11.a((java.lang.String) r12)
            if (r11 == 0) goto L_0x0143
            boolean r12 = r10.f()
            if (r12 == 0) goto L_0x0141
            goto L_0x0143
        L_0x0141:
            r12 = 0
            goto L_0x0144
        L_0x0143:
            r12 = 1
        L_0x0144:
            if (r11 == 0) goto L_0x014d
            boolean r10 = r10.f()
            if (r10 == 0) goto L_0x014d
            r7 = 1
        L_0x014d:
            com.shopee.app.pushnotification.NotificationDataBuilder r10 = com.shopee.app.pushnotification.NotificationDataBuilder.notificationData()
            com.shopee.app.pushnotification.NotificationDataBuilder r10 = r10.withId(r0)
            com.shopee.app.pushnotification.NotificationDataBuilder r10 = r10.ofType(r0)
            com.shopee.app.pushnotification.NotificationDataBuilder r10 = r10.withLaunchIntent(r6)
            com.shopee.app.pushnotification.NotificationDataBuilder r5 = r10.withMessage(r5)
            com.shopee.app.pushnotification.NotificationDataBuilder r4 = r5.withTitle(r4)
            com.shopee.app.pushnotification.NotificationDataBuilder r4 = r4.withImageUrl(r8)
            r5 = r12 ^ 1
            com.shopee.app.pushnotification.NotificationDataBuilder r4 = r4.shouldKeepSilent(r5)
            com.shopee.app.pushnotification.NotificationDataBuilder r4 = r4.shouldStack(r9)
            java.lang.String r5 = r1.f18493b
            com.shopee.app.pushnotification.NotificationDataBuilder r4 = r4.withMetadata(r5)
            com.shopee.app.pushnotification.NotificationDataBuilder r4 = r4.useCustomSound(r7)
            com.shopee.app.pushnotification.NotificationData r4 = r4.build()
            a((com.shopee.app.pushnotification.NotificationData) r4)
            a(r6, r1, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.pushnotification.c.a(com.shopee.app.pushnotification.GPNIntentService$a):void");
    }

    private static void a(Intent intent, GPNIntentService.a aVar, int i, long j) {
        try {
            b.a(intent.getStringExtra("redirect"), i, aVar.f18493b, j);
        } catch (Throwable th) {
            a.a(th);
        }
    }

    public static synchronized void a(NotificationData notificationData) {
        synchronized (c.class) {
            f18537a.a(notificationData);
        }
    }

    private static Intent a(RedirectParameters redirectParameters) {
        String str;
        int freeRedirect = redirectParameters.getFreeRedirect();
        if (freeRedirect == 3) {
            str = "shop?shopID=" + redirectParameters.getShopId();
        } else if (freeRedirect == 27) {
            str = "reactPath?path=" + redirectParameters.getPath();
        } else if (freeRedirect == 6) {
            str = "follow";
        } else if (freeRedirect == 7) {
            str = "addFriends";
        } else if (freeRedirect == 8) {
            str = "sell";
        } else if (freeRedirect == 11) {
            str = "activity";
        } else if (freeRedirect != 12) {
            switch (freeRedirect) {
                case 14:
                    str = "sellerAssistant";
                    break;
                case 15:
                    str = "products";
                    break;
                case 16:
                    str = "income";
                    break;
                case 17:
                    str = "cart";
                    break;
                case 18:
                    str = "myLikes";
                    break;
                case 19:
                    str = "purchases";
                    break;
                case 20:
                    str = "orders";
                    break;
                case 21:
                    str = "actionbox?tab=actionRequired&cat=" + redirectParameters.getActionBoxCategory();
                    break;
                default:
                    str = null;
                    break;
            }
        } else {
            str = "me";
        }
        if (!TextUtils.isEmpty(str)) {
            return ((HomeActivity_.a) HomeActivity_.a(ar.f()).c(redirectParameters.getTaskId()).a(str).k(536870912)).b();
        }
        return null;
    }

    public static Intent a(String str) {
        HomeActivity_.a b2 = HomeActivity_.a(ar.f()).b(4);
        Intent b3 = b2.a("home?apprl=" + bm.a(str)).b();
        b3.addFlags(536870912);
        return b3;
    }

    public static Intent b(String str) {
        return a(str, (RedirectParameters) null);
    }

    private static Intent a(String str, RedirectParameters redirectParameters) {
        HomeActivity_.a c2 = HomeActivity_.a(ar.f()).c(redirectParameters == null ? 0 : redirectParameters.getTaskId());
        Intent b2 = c2.a("chat?" + str).b();
        b2.addFlags(536870912);
        return b2;
    }

    public static Intent a() {
        Intent b2 = HomeActivity_.a(ar.f()).b(4).a("me?afterUpload=1").b();
        b2.addFlags(536870912);
        return b2;
    }

    private static Intent a(int i, RedirectParameters redirectParameters) {
        int i2 = 0;
        int taskId = redirectParameters == null ? 0 : redirectParameters.getTaskId();
        if (redirectParameters != null) {
            i2 = redirectParameters.getUserId();
        }
        HomeActivity_.a c2 = HomeActivity_.a(ar.f()).c(taskId);
        return c2.a("action?catid=" + i + "&userid=" + i2).b();
    }

    public static Intent a(int i) {
        return b(i, (RedirectParameters) null);
    }

    private static Intent b(int i, RedirectParameters redirectParameters) {
        Intent intent;
        int taskId = redirectParameters == null ? 0 : redirectParameters.getTaskId();
        if (i == 3) {
            intent = HomeActivity_.a(ar.f()).c(taskId).a("action").b();
        } else if (i == 4) {
            intent = HomeActivity_.a(ar.f()).c(taskId).a("action?catid=3&userid=0").b();
        } else if (i == 5) {
            intent = HomeActivity_.a(ar.f()).c(taskId).b(4).b();
        } else if (i != 6) {
            intent = HomeActivity_.a(ar.f()).c(taskId).b(4).b();
        } else {
            intent = HomeActivity_.a(ar.f()).c(taskId).a("cart").b(4).b();
        }
        intent.addFlags(536870912);
        return intent;
    }

    public static void a(Context context) {
        f18537a.a();
        b(context);
    }

    public static void b(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            HashMap hashMap = new HashMap();
            LinkedList linkedList = new LinkedList();
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                LinkedList linkedList2 = (LinkedList) hashMap.get(statusBarNotification.getGroupKey());
                if (linkedList2 == null) {
                    linkedList2 = new LinkedList();
                }
                linkedList2.add(Integer.valueOf(statusBarNotification.getId()));
                hashMap.put(statusBarNotification.getGroupKey(), linkedList2);
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                if (((LinkedList) entry.getValue()).size() == 1) {
                    linkedList.addAll((Collection) entry.getValue());
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                notificationManager.cancel(((Integer) it.next()).intValue());
            }
        }
    }
}
