package com.shopee.app.ui.sharing;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import com.garena.android.appkit.btmsheet.a;
import com.shopee.app.h.r;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.o;
import java.util.HashMap;
import java.util.List;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f25363a = new a((g) null);

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, a> f25364c = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final HashMap<Integer, String> f25365d = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final Activity f25366b;

    public c(Activity activity) {
        j.b(activity, "activity");
        this.f25366b = activity;
    }

    public final Activity a() {
        return this.f25366b;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final HashMap<Integer, String> a() {
            return c.f25365d;
        }
    }

    static {
        f25364c.put("facebookLink", new a("facebookLink", R.drawable.com_garena_shopee_ic_share_fb, R.string.sp_label_facebook));
        f25364c.put("facebookPhoto", new a("facebookPhoto", R.drawable.com_garena_shopee_ic_share_fb, R.string.sp_label_facebook));
        f25364c.put("instagram", new a("instagram", R.drawable.com_garena_shopee_ic_share_ig, R.string.sp_label_instagram_feed));
        f25364c.put("instagramStory", new a("instagram", R.drawable.com_garena_shopee_ic_share_ig, R.string.sp_label_instagram_story));
        f25364c.put("whatsapp", new a("whatsapp", R.drawable.com_garena_shopee_ic_share_wa, R.string.sp_label_whatsapp));
        f25364c.put("lineChat", new a("lineChat", R.drawable.com_garena_shopee_ic_share_line, R.string.sp_label_line));
        f25364c.put("pinterest", new a("pinterest", R.drawable.com_garena_shopee_ic_share_pi, R.string.sp_label_pinterest));
        f25364c.put("twitter", new a("twitter", R.drawable.com_garena_shopee_ic_share_tw, R.string.sp_label_twitter));
        f25364c.put("facebookMessenger", new a("facebookMessenger", R.drawable.com_garena_shopee_ic_share_fbmessenger, R.string.sp_messenger));
        f25364c.put("viber", new a("viber", R.drawable.com_garena_shopee_ic_share_viber, R.string.sp_label_viber));
        f25364c.put("copyInfo", new a("copyInfo", R.drawable.com_garena_shopee_ic_share_copyinfo, R.string.sp_label_info));
        f25364c.put("copyLink", new a("copyLink", R.drawable.com_garena_shopee_ic_share_copylink, R.string.sp_label_copy));
        String str = "copyLink";
        f25364c.put("sms", new a("sms", R.drawable.com_garena_shopee_ic_share_sms, R.string.sp_label_sms));
        String str2 = "sms";
        f25364c.put("email", new a("email", R.drawable.com_garena_shopee_ic_share_email, R.string.sp_label_email));
        f25365d.put(Integer.valueOf("facebookLink".hashCode()), "facebookLink");
        f25365d.put(Integer.valueOf("facebookPhoto".hashCode()), "facebookPhoto");
        f25365d.put(Integer.valueOf("instagram".hashCode()), "instagram");
        f25365d.put(Integer.valueOf("instagramStory".hashCode()), "instagramStory");
        f25365d.put(Integer.valueOf("whatsapp".hashCode()), "whatsapp");
        f25365d.put(Integer.valueOf("pinterest".hashCode()), "pinterest");
        f25365d.put(Integer.valueOf("twitter".hashCode()), "twitter");
        f25365d.put(Integer.valueOf("lineChat".hashCode()), "lineChat");
        f25365d.put(Integer.valueOf("facebookMessenger".hashCode()), "facebookMessenger");
        f25365d.put(Integer.valueOf("viber".hashCode()), "viber");
        f25365d.put(Integer.valueOf("copyInfo".hashCode()), "copyInfo");
        f25365d.put(Integer.valueOf(str.hashCode()), str);
        f25365d.put(Integer.valueOf(str2.hashCode()), str2);
        f25365d.put(Integer.valueOf("email".hashCode()), "email");
    }

    public final void a(String str, String str2, Boolean bool, List<String> list, List<String> list2, d dVar) {
        int i;
        j.b(dVar, "sharingPanelListener");
        a.C0124a a2 = new a.C0124a(this.f25366b, R.style.StyleDialog).b().a((CharSequence) str).b((CharSequence) str2).a(false);
        if (list != null) {
            i = 0;
            for (String str3 : list) {
                a aVar = f25364c.get(str3);
                if (aVar != null) {
                    a2.a(aVar.a().hashCode(), com.garena.android.appkit.tools.b.f(aVar.b()), com.garena.android.appkit.tools.b.e(aVar.c()));
                    i++;
                }
            }
        } else {
            i = 0;
        }
        j.a((Object) a2, "popupBuilder");
        a(i, a2);
        if (list2 != null) {
            for (String str4 : list2) {
                a aVar2 = f25364c.get(str4);
                if (aVar2 != null) {
                    a2.a(aVar2.a().hashCode(), com.garena.android.appkit.tools.b.f(aVar2.b()), com.garena.android.appkit.tools.b.e(aVar2.c()));
                }
            }
        }
        o.a aVar3 = new o.a();
        aVar3.element = false;
        a2.a((DialogInterface.OnClickListener) new b(this, dVar, aVar3, bool));
        a2.a((DialogInterface.OnDismissListener) new C0388c(aVar3, dVar));
        a2.c().show();
    }

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f25367a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f25368b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ o.a f25369c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Boolean f25370d;

        b(c cVar, d dVar, o.a aVar, Boolean bool) {
            this.f25367a = cVar;
            this.f25368b = dVar;
            this.f25369c = aVar;
            this.f25370d = bool;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            String str = c.f25363a.a().get(Integer.valueOf(i));
            if (str == null) {
                str = "";
            }
            j.a((Object) str, "SOCIAL_MAPPING_BACK_MAP[which] ?: \"\"");
            com.shopee.app.ui.sharing.base.a<?> a2 = b.f25343a.a(this.f25367a.a(), str, new a());
            if (a2 != null ? a2.a(this.f25367a.a()) : false) {
                this.f25368b.onSelectApp(str, true);
                this.f25369c.element = true;
                dialogInterface.dismiss();
            } else if (j.a((Object) this.f25370d, (Object) true)) {
                this.f25368b.onSelectApp(str, false);
                this.f25369c.element = true;
                dialogInterface.dismiss();
            } else {
                r.a().b((int) R.string.sp_sharing_app_not_installed);
            }
        }

        public static final class a implements com.shopee.app.ui.sharing.base.b {
            public void onPreProcessingData() {
            }

            public void onResult(com.shopee.app.ui.sharing.base.data.a aVar) {
                j.b(aVar, "shareResult");
            }

            a() {
            }
        }
    }

    /* renamed from: com.shopee.app.ui.sharing.c$c  reason: collision with other inner class name */
    static final class C0388c implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o.a f25371a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f25372b;

        C0388c(o.a aVar, d dVar) {
            this.f25371a = aVar;
            this.f25372b = dVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            if (!this.f25371a.element) {
                this.f25372b.onDismiss();
            }
        }
    }

    private final void a(int i, a.C0124a aVar) {
        Bitmap createBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(com.garena.android.appkit.tools.b.a(R.color.transparent));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);
        Application application = com.garena.android.appkit.tools.a.f6696a;
        j.a((Object) application, "ApplicationInterface.application");
        BitmapDrawable bitmapDrawable = new BitmapDrawable(application.getResources(), createBitmap);
        int i2 = 4 - (i % 4);
        if (i2 == 4) {
            i2 = 0;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            aVar.a(R.id.share_dummy, false, bitmapDrawable, "");
        }
    }
}
