package com.shopee.a;

import android.text.TextUtils;
import com.google.a.l;
import com.google.a.o;
import com.shopee.a.b.b;
import com.shopee.a.c.c;
import com.shopee.shopeetracker.ShopeeTracker;
import com.shopee.shopeetracker.model.TrackingEventV3;
import com.shopee.shopeetracker.model.UserActionV3;
import com.shopee.shopeetracker.utils.Logger;
import java.util.UUID;

public class a {
    public static void a(Object obj) {
        final com.shopee.a.b.a r = obj instanceof b ? ((b) obj).r() : null;
        if (a(obj, r)) {
            final String d2 = d(obj);
            if (!TextUtils.isEmpty(d2)) {
                final long currentTimeMillis = System.currentTimeMillis();
                final String simpleName = obj.getClass().getSimpleName();
                ShopeeTracker.getInstance().addRunnable(new Runnable() {
                    public void run() {
                        String str;
                        try {
                            String str2 = simpleName;
                            if (r != null) {
                                String a2 = r.a();
                                if (!TextUtils.isEmpty(a2)) {
                                    str2 = str2 + "|" + a2;
                                }
                            }
                            c b2 = b.a().b(d2);
                            if (b2 == null) {
                                str = b.a().d();
                            } else {
                                str = b2.f15749a;
                            }
                            b.a().e(str2);
                            c cVar = new c();
                            cVar.f15749a = str;
                            cVar.f15750b = str2;
                            String str3 = UUID.randomUUID().toString() + currentTimeMillis;
                            b.a().c(str3);
                            cVar.f15753e = currentTimeMillis;
                            cVar.f15755g = str3;
                            b.a().a(d2, cVar);
                        } catch (Exception e2) {
                            Logger.debug((Throwable) e2);
                        }
                    }
                });
            }
        }
    }

    public static void b(Object obj) {
        final com.shopee.a.b.a r = obj instanceof b ? ((b) obj).r() : null;
        if (a(obj, r)) {
            final String d2 = d(obj);
            if (!TextUtils.isEmpty(d2)) {
                final long currentTimeMillis = System.currentTimeMillis();
                final String simpleName = obj.getClass().getSimpleName();
                ShopeeTracker.getInstance().addRunnable(new Runnable() {
                    public void run() {
                        String str;
                        try {
                            c b2 = b.a().b(d2);
                            if (b2 != null) {
                                if (r != null) {
                                    if (TextUtils.isEmpty(b2.f15750b)) {
                                        String str2 = simpleName;
                                        String a2 = r.a();
                                        if (!TextUtils.isEmpty(a2)) {
                                            str2 = str2 + "|" + a2;
                                        }
                                        b2.f15750b = str2;
                                    }
                                    str = r.b();
                                } else {
                                    str = "";
                                }
                                if (str == null) {
                                    str = "";
                                }
                                b2.f15751c = str;
                                b2.f15752d = b.a().c();
                                long j = currentTimeMillis - b2.f15753e;
                                if (j <= 0) {
                                    j = 0;
                                }
                                b2.f15754f = j;
                                a.a(b2);
                            }
                        } catch (Exception e2) {
                            Logger.debug((Throwable) e2);
                        }
                    }
                });
            }
        }
    }

    public static void c(Object obj) {
        if (a(obj, obj instanceof b ? ((b) obj).r() : null)) {
            final String d2 = d(obj);
            if (!TextUtils.isEmpty(d2)) {
                ShopeeTracker.getInstance().addRunnable(new Runnable() {
                    public void run() {
                        try {
                            b.a().a(d2);
                        } catch (Exception e2) {
                            Logger.debug((Throwable) e2);
                        }
                    }
                });
            }
        }
    }

    public static boolean a(Object obj, com.shopee.a.b.a aVar) {
        if (!ShopeeTracker.isInitialized() || obj == null) {
            return false;
        }
        if (aVar == null || !aVar.c()) {
            return true;
        }
        return false;
    }

    public static void a(c cVar) {
        if (cVar != null) {
            o oVar = new o();
            oVar.a("param_string", cVar.f15751c);
            oVar.a("auto_mapped_view", cVar.f15752d);
            oVar.a("start_time", (Number) Long.valueOf(cVar.f15753e));
            oVar.a("stay_time", (Number) Long.valueOf(cVar.f15754f));
            oVar.a("auto_refer", cVar.f15749a);
            o oVar2 = new o();
            oVar2.a("auto_pv_common", (l) oVar);
            com.shopee.a.c.b bVar = new com.shopee.a.c.b(new com.shopee.a.c.a(cVar.f15750b, oVar2));
            bVar.f15748a = cVar.f15755g;
            ShopeeTracker.getInstance().logAction(UserActionV3.create((TrackingEventV3) bVar));
        }
    }

    public static String d(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return obj.toString() + obj.hashCode();
        }
        return obj.getClass().getName() + obj.hashCode();
    }
}
