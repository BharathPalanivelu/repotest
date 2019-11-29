package com.shopee.app.ui.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.afollestad.materialdialogs.f;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.shopee.app.data.store.al;
import com.shopee.id.R;
import com.shopee.web.sdk.bridge.a.f.b;
import d.a.d;
import d.a.z;
import d.d.b.j;
import d.l;
import d.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tencent.tls.platform.SigType;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0303a f19988a = new C0303a((g) null);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, String> f19989g = z.c(l.a("contact", "android.permission.READ_CONTACTS"), l.a("calendar", "android.permission.WRITE_CALENDAR"), l.a("camera", "android.permission.CAMERA"), l.a(PlaceFields.LOCATION, "android.permission.ACCESS_FINE_LOCATION"), l.a("record_audio", "android.permission.RECORD_AUDIO"), l.a("storage", "android.permission.WRITE_EXTERNAL_STORAGE"), l.a("gallery", "android.permission.WRITE_EXTERNAL_STORAGE"));

    /* renamed from: b  reason: collision with root package name */
    private String f19990b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f19991c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public b.C0475b f19992d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f19993e;

    /* renamed from: f  reason: collision with root package name */
    private final al f19994f;

    public a(al alVar) {
        j.b(alVar, "mLoginStore");
        this.f19994f = alVar;
    }

    /* renamed from: com.shopee.app.ui.c.a$a  reason: collision with other inner class name */
    public static final class C0303a {
        private C0303a() {
        }

        public /* synthetic */ C0303a(g gVar) {
            this();
        }

        public final HashMap<String, String> a() {
            return a.f19989g;
        }
    }

    public final void a(String str) {
        j.b(str, "popupText");
        this.f19990b = str;
    }

    public final void a(Context context, List<String> list, b.C0475b bVar) {
        j.b(context, "context");
        this.f19992d = bVar;
        this.f19993e = list;
        if (list != null) {
            boolean[] b2 = b(context, list, this.f19992d);
            b.C0475b bVar2 = this.f19992d;
            if (bVar2 != null) {
                bVar2.onResult(d.a(b2));
                return;
            }
            return;
        }
        b.C0475b bVar3 = this.f19992d;
        if (bVar3 != null) {
            bVar3.onResult((List<Boolean>) null);
        }
    }

    private final boolean[] b(Context context, List<String> list, b.C0475b bVar) {
        this.f19992d = bVar;
        this.f19993e = list;
        boolean[] zArr = new boolean[list.size()];
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                d.a.j.b();
            }
            String str = (String) next;
            String str2 = f19989g.get(str);
            zArr[i] = false;
            if (str2 == null) {
                com.garena.b.a.a.b("PermissionBridge", str + " is not supported or has been removed. Please fix it in your code.");
            } else if (!j.a((Object) str, (Object) "contact") || Build.VERSION.SDK_INT >= 23) {
                zArr[i] = androidx.core.content.b.b(context, str2) == 0;
            } else {
                zArr[i] = this.f19994f.r();
            }
            i = i2;
        }
        return zArr;
    }

    public final void a(Activity activity, List<String> list, String str, b.C0475b bVar) {
        j.b(activity, "activity");
        j.b(str, "popupText");
        j.b(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        a(str);
        a(activity, list, bVar);
    }

    public final void a(Activity activity, List<String> list, b.C0475b bVar) {
        j.b(activity, "activity");
        j.b(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f19992d = bVar;
        this.f19993e = list;
        if (list != null && (!list.isEmpty())) {
            if (Build.VERSION.SDK_INT < 23) {
                a(activity, 1231, a(b(activity, list, this.f19992d)));
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : list) {
                String str2 = f19989g.get(str);
                if (str2 != null) {
                    hashSet.add(str2);
                } else {
                    com.garena.b.a.a.b("PermissionBridge", str + " is not supported or has been removed. Please fix it in your code.");
                }
            }
            Collection collection = hashSet;
            if (!collection.isEmpty()) {
                Object[] array = collection.toArray(new String[0]);
                if (array != null) {
                    androidx.core.app.a.a(activity, (String[]) array, 1231);
                    return;
                }
                throw new m("null cannot be cast to non-null type kotlin.Array<T>");
            }
            bVar.onResult((List<Boolean>) null);
        }
    }

    public final void a(Activity activity, int i, int[] iArr) {
        j.b(activity, "activity");
        j.b(iArr, "grantResults");
        if (this.f19992d != null && i == 1231) {
            boolean z = false;
            if (!(iArr.length == 0)) {
                int length = iArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (iArr[i2] != 0) {
                        z = true;
                        break;
                    }
                    i2++;
                }
            }
            if (z) {
                a(activity);
            } else {
                a((Context) activity, this.f19993e, this.f19992d);
            }
        }
    }

    private final void a(Activity activity) {
        String str = this.f19990b;
        if (str == null) {
            str = activity.getResources().getString(R.string.label_permissions_default_explanation);
        }
        com.shopee.app.ui.dialog.a.a((Context) activity, "", str, (int) R.string.cancel, Build.VERSION.SDK_INT < 23 ? R.string.button_ok : R.string.menu_settings, (f.b) new c(this, activity)).setOnDismissListener(new b(this));
    }

    public static final class c extends f.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f19996a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f19997b;

        c(a aVar, Activity activity) {
            this.f19996a = aVar;
            this.f19997b = activity;
        }

        public void onPositive(f fVar) {
            super.onPositive(fVar);
            this.f19996a.f19991c = true;
            if (fVar != null) {
                fVar.dismiss();
            }
            if (Build.VERSION.SDK_INT < 23) {
                this.f19996a.b(this.f19997b);
                return;
            }
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", this.f19997b.getPackageName(), (String) null));
            intent.addFlags(SigType.TLS);
            this.f19997b.startActivity(intent);
        }
    }

    static final class b implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f19995a;

        b(a aVar) {
            this.f19995a = aVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            if (!this.f19995a.f19991c) {
                b.C0475b b2 = this.f19995a.f19992d;
                if (b2 != null) {
                    b2.onResult((List<Boolean>) null);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b(Activity activity) {
        this.f19994f.d(true);
        a((Context) activity);
    }

    private final int[] a(boolean[] zArr) {
        int[] iArr = new int[zArr.length];
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            iArr[i2] = zArr[i2] ? 0 : -1;
            i++;
            i2 = i4;
        }
        return iArr;
    }

    public final void a(Context context) {
        j.b(context, "context");
        if (this.f19991c) {
            this.f19991c = false;
            a(context, this.f19993e, this.f19992d);
        }
    }
}
