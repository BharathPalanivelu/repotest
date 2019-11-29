package com.shopee.app.g;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.GraphResponse;
import com.garena.android.appkit.btmsheet.a;
import com.garena.g.a;
import com.garena.g.a.j;
import com.garena.g.a.m;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.h.r;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.app.web.protocol.notification.ShareDataField;
import com.shopee.id.R;
import java.util.HashMap;
import java.util.List;

public class h {
    private static HashMap<String, e> j = new HashMap<>();
    /* access modifiers changed from: private */
    public static SparseArray<Pair<Integer, String>> k = new SparseArray<>();

    /* renamed from: a  reason: collision with root package name */
    i f17507a;

    /* renamed from: b  reason: collision with root package name */
    bc f17508b;

    /* renamed from: c  reason: collision with root package name */
    SettingConfigStore f17509c;

    /* renamed from: d  reason: collision with root package name */
    com.shopee.app.tracking.f f17510d;

    /* renamed from: e  reason: collision with root package name */
    UserInfo f17511e;

    /* renamed from: f  reason: collision with root package name */
    private com.garena.android.appkit.btmsheet.a f17512f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Context f17513g;
    /* access modifiers changed from: private */
    public c h = c.UNKNOWN;
    /* access modifiers changed from: private */
    public HashMap<String, d> i = new HashMap<>();

    public interface a {
        void a(h hVar);
    }

    public interface b {
        void a(o oVar);
    }

    public enum c {
        UNKNOWN,
        APP_NOT_INSTALLED,
        PROCESSING_IMAGE,
        FAILED,
        SUCCESS
    }

    public interface f {
        void a(c cVar);
    }

    public h(Context context) {
        ((a) ((x) context).b()).a(this);
        this.f17513g = context;
        this.f17508b.a(this.f17507a);
        this.f17507a.a(this);
    }

    private static class e {

        /* renamed from: a  reason: collision with root package name */
        int f17537a;

        /* renamed from: b  reason: collision with root package name */
        int f17538b;

        /* renamed from: c  reason: collision with root package name */
        int f17539c;

        /* renamed from: d  reason: collision with root package name */
        int f17540d;

        /* renamed from: e  reason: collision with root package name */
        boolean f17541e = false;

        e(int i, int i2, int i3, int i4) {
            this.f17538b = i;
            this.f17537a = i2;
            this.f17539c = i3;
            this.f17540d = i4;
        }

        e(int i, int i2, int i3, int i4, boolean z) {
            this.f17538b = i;
            this.f17537a = i2;
            this.f17539c = i3;
            this.f17540d = i4;
            this.f17541e = z;
        }
    }

    static {
        j.put("beetalk", new e(1, R.id.share_beetalk, R.drawable.com_garena_shopee_ic_share_bt, R.string.sp_label_beetalk));
        j.put("buzz", new e(2, R.id.share_buzz, R.drawable.com_garena_shopee_ic_share_buzz, R.string.sp_label_buzz));
        j.put("facebook", new e(3, R.id.share_facebook, R.drawable.com_garena_shopee_ic_share_fb, R.string.sp_label_facebook));
        j.put("twitter", new e(4, R.id.share_twitter, R.drawable.com_garena_shopee_ic_share_tw, R.string.sp_label_twitter));
        j.put("line", new e(5, R.id.share_line, R.drawable.com_garena_shopee_ic_share_line, R.string.sp_label_line));
        j.put("whatsapp", new e(6, R.id.share_whatsapp, R.drawable.com_garena_shopee_ic_share_wa, R.string.sp_label_whatsapp));
        j.put("pinterest", new e(7, R.id.share_pinterest, R.drawable.com_garena_shopee_ic_share_pi, R.string.sp_label_pinterest));
        j.put("instagram", new e(0, R.id.share_instagram, R.drawable.com_garena_shopee_ic_share_ig, R.string.sp_label_instagram));
        j.put("viber", new e(11, R.id.share_viber, R.drawable.com_garena_shopee_ic_share_viber, R.string.sp_label_viber));
        j.put("system_android", new e(12, R.id.share_system_android, R.drawable.com_garena_shopee_ic_share_more, R.string.sp_share_more));
        j.put("messenger", new e(13, R.id.share_messenger, R.drawable.com_garena_shopee_ic_share_fbmessenger, R.string.sp_messenger));
        j.put("copy_info", new e(8, R.id.share_copy_info, R.drawable.com_garena_shopee_ic_share_copyinfo, R.string.sp_label_info, true));
        j.put("copy_link", new e(8, R.id.share_copy_link, R.drawable.com_garena_shopee_ic_share_copylink, R.string.sp_label_copy, true));
        j.put("email", new e(9, R.id.share_email, R.drawable.com_garena_shopee_ic_share_email, R.string.sp_label_email, true));
        j.put("sms", new e(10, R.id.share_sms, R.drawable.com_garena_shopee_ic_share_sms, R.string.sp_label_sms, true));
        com.garena.g.b.a(com.garena.android.appkit.tools.b.e(R.string.pinterest_app_id));
        k.put(R.id.share_beetalk, new Pair(1, "beetalk"));
        k.put(R.id.share_buzz, new Pair(2, "buzz"));
        k.put(R.id.share_facebook, new Pair(3, "facebook"));
        k.put(R.id.share_twitter, new Pair(4, "twitter"));
        k.put(R.id.share_line, new Pair(5, "line"));
        k.put(R.id.share_whatsapp, new Pair(6, "whatsapp"));
        k.put(R.id.share_pinterest, new Pair(7, "pinterest"));
        k.put(R.id.share_instagram, new Pair(0, "instagram"));
        k.put(R.id.share_copy_info, new Pair(8, "copy_info"));
        k.put(R.id.share_copy_link, new Pair(8, "copy_link"));
        k.put(R.id.share_email, new Pair(9, "email"));
        k.put(R.id.share_sms, new Pair(10, "sms"));
        k.put(R.id.share_system_android, new Pair(12, "system_android"));
        k.put(R.id.share_viber, new Pair(11, "viber"));
        k.put(R.id.share_messenger, new Pair(13, "messenger"));
    }

    public void a(ShareMessage shareMessage, List<String> list, ShareConfigStore shareConfigStore, boolean z, String str, String str2) {
        shareMessage.setTitle(str);
        shareMessage.setSubTitle(str2);
        a(shareMessage, list, shareConfigStore, z, (b) null);
    }

    public void a(ShareMessage shareMessage, List<String> list, ShareConfigStore shareConfigStore, boolean z, b bVar) {
        String title = shareMessage.getTitle();
        String subTitle = shareMessage.getSubTitle();
        if (TextUtils.isEmpty(title)) {
            if (shareMessage.isShareShop()) {
                if (z) {
                    title = com.garena.android.appkit.tools.b.e(R.string.sp_share_my_shop_title);
                    subTitle = com.garena.android.appkit.tools.b.e(R.string.sp_share_my_shop_subtitle);
                } else {
                    title = com.garena.android.appkit.tools.b.e(R.string.sp_share_others_shop_title);
                    subTitle = com.garena.android.appkit.tools.b.e(R.string.sp_share_others_shop_subtitle);
                }
            } else if (z) {
                title = com.garena.android.appkit.tools.b.e(R.string.sp_share_my_product_title);
                subTitle = com.garena.android.appkit.tools.b.e(R.string.sp_share_my_product_subtitle);
            } else {
                title = com.garena.android.appkit.tools.b.e(R.string.sp_share_others_product_title);
                subTitle = com.garena.android.appkit.tools.b.e(R.string.sp_share_others_product_subtitle);
            }
        }
        a.C0124a b2 = new a.C0124a(this.f17513g, R.style.StyleDialog).b();
        b2.a((CharSequence) title);
        b2.b((CharSequence) subTitle);
        if (shareMessage.isReferral() || shareMessage.isGeneric()) {
            a(b2, shareMessage, list, bVar);
        } else {
            a(b2, shareMessage, list, shareConfigStore, z, bVar);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f17534a = "";

        /* renamed from: b  reason: collision with root package name */
        public boolean f17535b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f17536c = 0;

        public d(String str, boolean z) {
            this.f17534a = str;
            this.f17535b = z;
        }
    }

    private void a(a.C0124a aVar, final ShareMessage shareMessage, List<String> list, final b bVar) {
        try {
            if (this.f17512f == null || !this.f17512f.isShowing()) {
                List<String> disabledAppIds = shareMessage.getDisabledAppIds();
                boolean z = false;
                int i2 = 0;
                for (String next : list) {
                    if (disabledAppIds == null || !disabledAppIds.contains(next)) {
                        e eVar = j.get(next);
                        if (eVar != null) {
                            Drawable f2 = com.garena.android.appkit.tools.b.f(eVar.f17539c);
                            if (eVar.f17541e && !z) {
                                a(i2, aVar);
                                z = true;
                            }
                            aVar.a(eVar.f17537a, f2, com.garena.android.appkit.tools.b.e(eVar.f17540d));
                            i2++;
                        }
                    }
                }
                aVar.a((DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final Pair pair = (Pair) h.k.get(i);
                        if (pair == null) {
                            dialogInterface.dismiss();
                            return;
                        }
                        String url = shareMessage.getUrl();
                        ShareDataField sharingUrls = shareMessage.getSharingUrls();
                        String str = (String) pair.second;
                        char c2 = 65535;
                        switch (str.hashCode()) {
                            case -1436108013:
                                if (str.equals("messenger")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case -95244193:
                                if (str.equals("system_android")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case 3321844:
                                if (str.equals("line")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 28903346:
                                if (str.equals("instagram")) {
                                    c2 = 5;
                                    break;
                                }
                                break;
                            case 96619420:
                                if (str.equals("email")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 497130182:
                                if (str.equals("facebook")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 1934780818:
                                if (str.equals("whatsapp")) {
                                    c2 = 6;
                                    break;
                                }
                                break;
                        }
                        if (c2 == 0) {
                            com.garena.g.a.a a2 = com.garena.g.b.a(((Integer) pair.first).intValue());
                            String value = ShareDataField.Companion.getValue(shareMessage.getGenericText(), shareMessage.getSharingText(), "email");
                            String value2 = ShareDataField.Companion.getValue("", shareMessage.getSharingText(), "email_subject");
                            String value3 = ShareDataField.Companion.getValue(shareMessage.getGenericImageUrl(), shareMessage.getSharingImages(), (String) pair.second);
                            String str2 = c.a(value3) + "_sharing.jpg";
                            String str3 = "file:///" + com.shopee.app.h.f.a().d(str2);
                            h.this.f17507a.a(str2, shareMessage, h.this.f17509c.getSharingImageConfig(), value3);
                            try {
                                c unused = h.this.h = h.this.f17507a.a(a2, h.this.f17513g, a.C0132a.a().c(value2).a(1).a(value), str3, false, new f() {
                                    public void a(c cVar) {
                                        h.this.a((String) pair.second, cVar);
                                    }
                                });
                            } catch (com.garena.g.c unused2) {
                                c unused3 = h.this.h = c.APP_NOT_INSTALLED;
                            }
                        } else if (c2 == 1) {
                            h.this.f17507a.a(shareMessage);
                            c unused4 = h.this.h = c.SUCCESS;
                        } else if (c2 == 2) {
                            try {
                                com.garena.g.b.a(((Integer) pair.first).intValue()).a(h.this.f17513g, a.C0132a.a().a(0).c(shareMessage.getTitle()).a(ShareDataField.Companion.getValue(url, shareMessage.getSharingUrls(), "line")).b());
                            } catch (com.garena.g.c unused5) {
                                c unused6 = h.this.h = c.APP_NOT_INSTALLED;
                            }
                        } else if (c2 != 3) {
                            com.garena.g.a.a a3 = com.garena.g.b.a(((Integer) pair.first).intValue());
                            String value4 = ShareDataField.Companion.getValue(shareMessage.getGenericText(), shareMessage.getSharingText(), (String) pair.second);
                            if (!"pinterest".equals(pair.second)) {
                                url = value4;
                            }
                            if ((a3 instanceof com.garena.g.a.e) || (a3 instanceof j) || (a3 instanceof m)) {
                                new com.garena.g.a.d().a(h.this.f17513g, a.C0132a.a().a(0).c(shareMessage.getTitle()).a(value4).b());
                                r.a().b((int) R.string.sp_copy_text_done);
                            } else if (a3 instanceof com.garena.g.a.d) {
                                a3.a(h.this.f17513g, a.C0132a.a().a(0).c(shareMessage.getTitle()).a(value4).b());
                                r.a().b((int) R.string.sp_info_copied);
                            }
                            a.C0132a a4 = a.C0132a.a().a(1).b(url).a(value4);
                            String value5 = ShareDataField.Companion.getValue(shareMessage.getGenericImageUrl(), shareMessage.getSharingImages(), (String) pair.second);
                            String str4 = c.a(value5) + "_sharing.jpg";
                            String str5 = "file:///" + com.shopee.app.h.f.a().d(str4);
                            h.this.f17507a.a(str4, shareMessage, h.this.f17509c.getSharingImageConfig(), value5);
                            try {
                                c unused7 = h.this.h = h.this.f17507a.a(a3, h.this.f17513g, a4, str5, false, new f() {
                                    public void a(c cVar) {
                                        h.this.a((String) pair.second, cVar);
                                    }
                                });
                            } catch (com.garena.g.c unused8) {
                                c unused9 = h.this.h = c.APP_NOT_INSTALLED;
                            }
                        } else {
                            try {
                                com.garena.g.a.a a5 = com.garena.g.b.a(((Integer) pair.first).intValue());
                                String value6 = ShareDataField.Companion.getValue(url, sharingUrls, "messenger");
                                a5.a(h.this.f17513g, a.C0132a.a().a(value6).c(shareMessage.getTitle()).b(value6).a(0).b());
                            } catch (com.garena.g.c unused10) {
                                c unused11 = h.this.h = c.APP_NOT_INSTALLED;
                            }
                        }
                        h.this.a(shareMessage, String.valueOf(pair.second));
                        h.this.a((String) pair.second, h.this.h);
                    }
                });
                aVar.a(false);
                aVar.a((DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (bVar != null) {
                            o oVar = new o();
                            oVar.a("status", (Number) Integer.valueOf(h.this.h == c.SUCCESS ? 1 : 0));
                            if (!h.this.i.isEmpty()) {
                                i iVar = new i(h.this.i.size());
                                for (d dVar : h.this.i.values()) {
                                    o oVar2 = new o();
                                    oVar2.a("appId", dVar.f17534a);
                                    oVar2.a(GraphResponse.SUCCESS_KEY, Boolean.valueOf(dVar.f17535b));
                                    oVar2.a("numberOfClicks", (Number) Integer.valueOf(dVar.f17536c));
                                    iVar.a((l) oVar2);
                                }
                                oVar.a("clickData", (l) iVar);
                            }
                            bVar.a(oVar);
                            c unused = h.this.h = c.UNKNOWN;
                            h.this.i.clear();
                        }
                    }
                });
                this.f17512f = aVar.c();
                this.f17512f.show();
            }
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            ar.f().e().fabricClient().a((Throwable) e2, "");
        }
    }

    private void a(a.C0124a aVar, ShareMessage shareMessage, List<String> list, ShareConfigStore shareConfigStore, boolean z, b bVar) {
        String str;
        a.C0124a aVar2 = aVar;
        ShareMessage shareMessage2 = shareMessage;
        try {
            if (this.f17512f == null || !this.f17512f.isShowing()) {
                if (shareMessage.isShareShop()) {
                    str = shareMessage.getShopID() + "_sharing.jpg";
                } else if (shareMessage.getShareType() == 2) {
                    str = shareMessage.getItemID() + shareMessage.getItemImage() + "_sharing.jpg";
                } else if (shareMessage.isGeneric()) {
                    str = c.a(shareMessage.getGenericImageUrl());
                } else {
                    str = shareMessage.getItemID() + shareMessage.getItemImage() + "_sharing.jpg";
                }
                final String str2 = "file:///" + com.shopee.app.h.f.a().d(str);
                final String str3 = "file:///" + com.shopee.app.h.f.a().c(str);
                if (shareMessage.isShareShop()) {
                    this.f17507a.a(str, shareMessage2, this.f17509c.getProductImageConfig(), "");
                } else {
                    this.f17507a.a(str, shareMessage2, this.f17509c.getCoverImageConfig(), "");
                }
                final String url = shareMessage.getUrl();
                List<String> disabledAppIds = shareMessage.getDisabledAppIds();
                boolean z2 = false;
                int i2 = 0;
                for (String next : list) {
                    if (disabledAppIds == null || !disabledAppIds.contains(next)) {
                        e eVar = j.get(next);
                        if (eVar != null) {
                            Drawable f2 = com.garena.android.appkit.tools.b.f(eVar.f17539c);
                            if (eVar.f17541e && !z2) {
                                a(i2, aVar2);
                                z2 = true;
                            }
                            aVar2.a(eVar.f17537a, f2, com.garena.android.appkit.tools.b.e(eVar.f17540d));
                            i2++;
                        }
                    }
                }
                final ShareMessage shareMessage3 = shareMessage;
                final boolean z3 = z;
                final ShareConfigStore shareConfigStore2 = shareConfigStore;
                aVar2.a((DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* JADX WARNING: Can't fix incorrect switch cases order */
                    /* JADX WARNING: Can't wrap try/catch for region: R(2:61|62) */
                    /* JADX WARNING: Can't wrap try/catch for region: R(5:82|83|84|85|86) */
                    /* JADX WARNING: Can't wrap try/catch for region: R(7:103|104|105|106|107|111|112) */
                    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
                        com.shopee.app.g.h.a(r1.f17528g, com.shopee.app.g.h.c.APP_NOT_INSTALLED);
                     */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:106:0x044a */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x01a7 */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x02f3 */
                    /* JADX WARNING: Unknown top exception splitter block from list: {B:85:0x02f3=Splitter:B:85:0x02f3, B:106:0x044a=Splitter:B:106:0x044a, B:56:0x013f=Splitter:B:56:0x013f} */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void onClick(android.content.DialogInterface r22, int r23) {
                        /*
                            r21 = this;
                            r1 = r21
                            java.lang.String r2 = ""
                            android.util.SparseArray r0 = com.shopee.app.g.h.k
                            r3 = r23
                            java.lang.Object r0 = r0.get(r3)
                            r3 = r0
                            android.util.Pair r3 = (android.util.Pair) r3
                            if (r3 != 0) goto L_0x0017
                            r22.dismiss()
                            return
                        L_0x0017:
                            java.lang.String r0 = r3
                            com.shopee.app.g.h r4 = com.shopee.app.g.h.this
                            com.shopee.app.g.h$c r5 = com.shopee.app.g.h.c.UNKNOWN
                            com.shopee.app.g.h.c unused = r4.h = r5
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.notification.ShareDataField r4 = r4.getSharingText()     // Catch:{ Exception -> 0x045a }
                            java.lang.Object r5 = r3.second     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x045a }
                            r6 = -1
                            int r7 = r5.hashCode()     // Catch:{ Exception -> 0x045a }
                            r8 = 3
                            r9 = 2
                            java.lang.String r10 = "system_android"
                            java.lang.String r11 = "email"
                            r12 = 1
                            r13 = 0
                            switch(r7) {
                                case -95244193: goto L_0x0057;
                                case 28903346: goto L_0x004d;
                                case 96619420: goto L_0x0045;
                                case 497130182: goto L_0x003b;
                                default: goto L_0x003a;
                            }
                        L_0x003a:
                            goto L_0x005e
                        L_0x003b:
                            java.lang.String r7 = "facebook"
                            boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x045a }
                            if (r5 == 0) goto L_0x005e
                            r6 = 1
                            goto L_0x005e
                        L_0x0045:
                            boolean r5 = r5.equals(r11)     // Catch:{ Exception -> 0x045a }
                            if (r5 == 0) goto L_0x005e
                            r6 = 0
                            goto L_0x005e
                        L_0x004d:
                            java.lang.String r7 = "instagram"
                            boolean r5 = r5.equals(r7)     // Catch:{ Exception -> 0x045a }
                            if (r5 == 0) goto L_0x005e
                            r6 = 3
                            goto L_0x005e
                        L_0x0057:
                            boolean r5 = r5.equals(r10)     // Catch:{ Exception -> 0x045a }
                            if (r5 == 0) goto L_0x005e
                            r6 = 2
                        L_0x005e:
                            if (r6 == 0) goto L_0x0324
                            if (r6 == r12) goto L_0x0305
                            if (r6 == r9) goto L_0x01cc
                            if (r6 == r8) goto L_0x006b
                            r18 = r0
                            r19 = 0
                            goto L_0x0085
                        L_0x006b:
                            java.lang.String r0 = r8     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r5 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r5 = r5.isShareShop()     // Catch:{ Exception -> 0x045a }
                            if (r5 != 0) goto L_0x0080
                            com.shopee.app.web.protocol.ShareMessage r5 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r5 = r5.isShareItem()     // Catch:{ Exception -> 0x045a }
                            if (r5 == 0) goto L_0x007e
                            goto L_0x0080
                        L_0x007e:
                            r5 = 0
                            goto L_0x0081
                        L_0x0080:
                            r5 = 1
                        L_0x0081:
                            r18 = r0
                            r19 = r5
                        L_0x0085:
                            java.lang.String r0 = "copy_link"
                            if (r4 == 0) goto L_0x00a2
                            com.shopee.app.web.protocol.notification.ShareDataField$Companion r5 = com.shopee.app.web.protocol.notification.ShareDataField.Companion     // Catch:{ Exception -> 0x045a }
                            java.lang.Object r6 = r3.second     // Catch:{ Exception -> 0x045a }
                            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x045a }
                            java.lang.String r4 = r5.getValue(r2, r4, r6)     // Catch:{ Exception -> 0x045a }
                            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x045a }
                            if (r5 == 0) goto L_0x0125
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h$c r4 = com.shopee.app.g.h.c.FAILED     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h.c unused = r0.h = r4     // Catch:{ Exception -> 0x045a }
                            goto L_0x0474
                        L_0x00a2:
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r4 = r4.isGeneric()     // Catch:{ Exception -> 0x045a }
                            if (r4 == 0) goto L_0x00bc
                            java.lang.Object r4 = r3.second     // Catch:{ Exception -> 0x045a }
                            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x045a }
                            if (r4 == 0) goto L_0x00b5
                            java.lang.String r4 = r7     // Catch:{ Exception -> 0x045a }
                            goto L_0x0125
                        L_0x00b5:
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r4 = r4.getGenericText()     // Catch:{ Exception -> 0x045a }
                            goto L_0x0125
                        L_0x00bc:
                            boolean r4 = r5     // Catch:{ Exception -> 0x045a }
                            if (r4 == 0) goto L_0x00f3
                            com.shopee.app.data.store.ShareConfigStore r4 = r6     // Catch:{ Exception -> 0x045a }
                            java.lang.Object r5 = r3.second     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r6 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r6 = r6.isShareShop()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.SharingConfigInfo$AppDetailInfo r4 = r4.getShareText(r5, r6, r12)     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = r4.getShareText()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r6 = r4.getItemName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r7 = r4.getShopName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r8 = r4.getUsername()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r9 = r7     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r10 = r4.getItemPrice()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r4 = com.shopee.app.g.m.a(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x045a }
                            goto L_0x0125
                        L_0x00f3:
                            com.shopee.app.data.store.ShareConfigStore r4 = r6     // Catch:{ Exception -> 0x045a }
                            java.lang.Object r5 = r3.second     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r6 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r6 = r6.isShareShop()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.SharingConfigInfo$AppDetailInfo r4 = r4.getShareText(r5, r6, r13)     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = r4.getShareText()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r6 = r4.getItemName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r7 = r4.getShopName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r8 = r4.getUsername()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r9 = r7     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r10 = r4.getItemPrice()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r4 = com.shopee.app.g.m.a(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x045a }
                        L_0x0125:
                            java.lang.String r5 = "pinterest"
                            java.lang.Object r6 = r3.second     // Catch:{ Exception -> 0x045a }
                            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x045a }
                            if (r5 == 0) goto L_0x0132
                            java.lang.String r5 = r7     // Catch:{ Exception -> 0x045a }
                            goto L_0x0133
                        L_0x0132:
                            r5 = r4
                        L_0x0133:
                            java.lang.Object r6 = r3.first     // Catch:{ Exception -> 0x045a }
                            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x045a }
                            int r6 = r6.intValue()     // Catch:{ Exception -> 0x045a }
                            com.garena.g.a.a r15 = com.garena.g.b.a((int) r6)     // Catch:{ Exception -> 0x045a }
                            boolean r6 = r15.a()     // Catch:{ c -> 0x01a7 }
                            if (r6 != 0) goto L_0x0173
                            com.shopee.app.g.h r6 = com.shopee.app.g.h.this     // Catch:{ c -> 0x01a7 }
                            android.content.Context r6 = r6.f17513g     // Catch:{ c -> 0x01a7 }
                            com.garena.g.a$a r7 = com.garena.g.a.C0132a.a()     // Catch:{ c -> 0x01a7 }
                            com.garena.g.a$a r5 = r7.b(r5)     // Catch:{ c -> 0x01a7 }
                            com.garena.g.a$a r4 = r5.a((java.lang.String) r4)     // Catch:{ c -> 0x01a7 }
                            com.garena.g.a r4 = r4.b()     // Catch:{ c -> 0x01a7 }
                            r15.a((android.content.Context) r6, (com.garena.g.a) r4)     // Catch:{ c -> 0x01a7 }
                            com.shopee.app.g.h r4 = com.shopee.app.g.h.this     // Catch:{ c -> 0x01a7 }
                            com.shopee.app.g.h$c r5 = com.shopee.app.g.h.c.SUCCESS     // Catch:{ c -> 0x01a7 }
                            com.shopee.app.g.h.c unused = r4.h = r5     // Catch:{ c -> 0x01a7 }
                            com.shopee.app.g.h r4 = com.shopee.app.g.h.this     // Catch:{ c -> 0x01a7 }
                            com.shopee.app.web.protocol.ShareMessage r5 = r4     // Catch:{ c -> 0x01a7 }
                            java.lang.Object r6 = r3.second     // Catch:{ c -> 0x01a7 }
                            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ c -> 0x01a7 }
                            r4.a((com.shopee.app.web.protocol.ShareMessage) r5, (java.lang.String) r6)     // Catch:{ c -> 0x01a7 }
                            goto L_0x01ae
                        L_0x0173:
                            com.shopee.app.g.h r6 = com.shopee.app.g.h.this     // Catch:{ c -> 0x01a7 }
                            com.shopee.app.g.h r7 = com.shopee.app.g.h.this     // Catch:{ c -> 0x01a7 }
                            com.shopee.app.g.i r14 = r7.f17507a     // Catch:{ c -> 0x01a7 }
                            com.shopee.app.g.h r7 = com.shopee.app.g.h.this     // Catch:{ c -> 0x01a7 }
                            android.content.Context r16 = r7.f17513g     // Catch:{ c -> 0x01a7 }
                            com.garena.g.a$a r7 = com.garena.g.a.C0132a.a()     // Catch:{ c -> 0x01a7 }
                            com.garena.g.a$a r5 = r7.b(r5)     // Catch:{ c -> 0x01a7 }
                            com.garena.g.a$a r17 = r5.a((java.lang.String) r4)     // Catch:{ c -> 0x01a7 }
                            com.shopee.app.g.h$3$1 r4 = new com.shopee.app.g.h$3$1     // Catch:{ c -> 0x01a7 }
                            r4.<init>(r3)     // Catch:{ c -> 0x01a7 }
                            r20 = r4
                            com.shopee.app.g.h$c r4 = r14.a(r15, r16, r17, r18, r19, r20)     // Catch:{ c -> 0x01a7 }
                            com.shopee.app.g.h.c unused = r6.h = r4     // Catch:{ c -> 0x01a7 }
                            com.shopee.app.g.h r4 = com.shopee.app.g.h.this     // Catch:{ c -> 0x01a7 }
                            com.shopee.app.web.protocol.ShareMessage r5 = r4     // Catch:{ c -> 0x01a7 }
                            java.lang.Object r6 = r3.second     // Catch:{ c -> 0x01a7 }
                            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ c -> 0x01a7 }
                            r4.a((com.shopee.app.web.protocol.ShareMessage) r5, (java.lang.String) r6)     // Catch:{ c -> 0x01a7 }
                            goto L_0x01ae
                        L_0x01a7:
                            com.shopee.app.g.h r4 = com.shopee.app.g.h.this     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h$c r5 = com.shopee.app.g.h.c.APP_NOT_INSTALLED     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h.c unused = r4.h = r5     // Catch:{ Exception -> 0x045a }
                        L_0x01ae:
                            java.lang.String r4 = "copy_info"
                            java.lang.Object r5 = r3.second     // Catch:{ Exception -> 0x045a }
                            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x045a }
                            if (r4 != 0) goto L_0x01c0
                            java.lang.Object r4 = r3.second     // Catch:{ Exception -> 0x045a }
                            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x045a }
                            if (r0 == 0) goto L_0x0474
                        L_0x01c0:
                            com.shopee.app.h.r r0 = com.shopee.app.h.r.a()     // Catch:{ Exception -> 0x045a }
                            r4 = 2131888057(0x7f1207b9, float:1.9410739E38)
                            r0.b((int) r4)     // Catch:{ Exception -> 0x045a }
                            goto L_0x0474
                        L_0x01cc:
                            if (r4 == 0) goto L_0x01de
                            com.shopee.app.web.protocol.notification.ShareDataField$Companion r0 = com.shopee.app.web.protocol.notification.ShareDataField.Companion     // Catch:{ Exception -> 0x045a }
                            java.lang.String r0 = r0.getValue(r2, r4, r10)     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.notification.ShareDataField$Companion r5 = com.shopee.app.web.protocol.notification.ShareDataField.Companion     // Catch:{ Exception -> 0x045a }
                            java.lang.String r6 = "system_android_subject"
                            java.lang.String r4 = r5.getValue(r2, r4, r6)     // Catch:{ Exception -> 0x045a }
                            goto L_0x02ab
                        L_0x01de:
                            boolean r0 = r5     // Catch:{ Exception -> 0x045a }
                            if (r0 == 0) goto L_0x023f
                            com.shopee.app.data.store.ShareConfigStore r0 = r6     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r4 = r4.isShareShop()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.SharingConfigInfo$AppDetailInfo r0 = r0.getShareText(r10, r4, r12)     // Catch:{ Exception -> 0x045a }
                            java.lang.String r4 = r0.getBody()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = r0.getItemName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r6 = r0.getShopName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r7 = r0.getUsername()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r8 = r7     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r9 = r0.getItemPrice()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r0 = com.shopee.app.g.m.a(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.ShareConfigStore r4 = r6     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r5 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r5 = r5.isShareShop()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.SharingConfigInfo$AppDetailInfo r4 = r4.getShareText(r10, r5, r12)     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = r4.getSubject()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r6 = r4.getItemName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r7 = r4.getShopName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r8 = r4.getUsername()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r9 = r7     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r10 = r4.getItemPrice()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r4 = com.shopee.app.g.m.a(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x045a }
                            goto L_0x02ab
                        L_0x023f:
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r0 = r0.isGeneric()     // Catch:{ Exception -> 0x045a }
                            if (r0 == 0) goto L_0x024f
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r0 = r0.getGenericText()     // Catch:{ Exception -> 0x045a }
                            r4 = r2
                            goto L_0x02ab
                        L_0x024f:
                            com.shopee.app.data.store.ShareConfigStore r0 = r6     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r4 = r4.isShareShop()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.SharingConfigInfo$AppDetailInfo r0 = r0.getShareText(r11, r4, r13)     // Catch:{ Exception -> 0x045a }
                            java.lang.String r4 = r0.getBody()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = r0.getItemName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r6 = r0.getShopName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r7 = r0.getUsername()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r8 = r7     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r9 = r0.getItemPrice()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r0 = com.shopee.app.g.m.a(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.ShareConfigStore r4 = r6     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r5 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r5 = r5.isShareShop()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.SharingConfigInfo$AppDetailInfo r4 = r4.getShareText(r11, r5, r13)     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = r4.getSubject()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r6 = r4.getItemName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r7 = r4.getShopName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r8 = r4.getUsername()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r9 = r7     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r10 = r4.getItemPrice()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r4 = com.shopee.app.g.m.a(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x045a }
                        L_0x02ab:
                            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x045a }
                            if (r5 != 0) goto L_0x02fc
                            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x045a }
                            if (r5 == 0) goto L_0x02b8
                            goto L_0x02fc
                        L_0x02b8:
                            java.lang.Object r5 = r3.first     // Catch:{ Exception -> 0x045a }
                            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x045a }
                            int r5 = r5.intValue()     // Catch:{ Exception -> 0x045a }
                            com.garena.g.a.a r5 = com.garena.g.b.a((int) r5)     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h r6 = com.shopee.app.g.h.this     // Catch:{ c -> 0x02f3 }
                            android.content.Context r6 = r6.f17513g     // Catch:{ c -> 0x02f3 }
                            com.garena.g.a$a r7 = com.garena.g.a.C0132a.a()     // Catch:{ c -> 0x02f3 }
                            com.garena.g.a$a r4 = r7.c(r4)     // Catch:{ c -> 0x02f3 }
                            com.garena.g.a$a r0 = r4.a((java.lang.String) r0)     // Catch:{ c -> 0x02f3 }
                            com.garena.g.a r0 = r0.b()     // Catch:{ c -> 0x02f3 }
                            r5.a((android.content.Context) r6, (com.garena.g.a) r0)     // Catch:{ c -> 0x02f3 }
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this     // Catch:{ c -> 0x02f3 }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ c -> 0x02f3 }
                            java.lang.Object r5 = r3.second     // Catch:{ c -> 0x02f3 }
                            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ c -> 0x02f3 }
                            r0.a((com.shopee.app.web.protocol.ShareMessage) r4, (java.lang.String) r5)     // Catch:{ c -> 0x02f3 }
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this     // Catch:{ c -> 0x02f3 }
                            com.shopee.app.g.h$c r4 = com.shopee.app.g.h.c.SUCCESS     // Catch:{ c -> 0x02f3 }
                            com.shopee.app.g.h.c unused = r0.h = r4     // Catch:{ c -> 0x02f3 }
                            goto L_0x0474
                        L_0x02f3:
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h$c r4 = com.shopee.app.g.h.c.APP_NOT_INSTALLED     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h.c unused = r0.h = r4     // Catch:{ Exception -> 0x045a }
                            goto L_0x0474
                        L_0x02fc:
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h$c r4 = com.shopee.app.g.h.c.FAILED     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h.c unused = r0.h = r4     // Catch:{ Exception -> 0x045a }
                            goto L_0x0474
                        L_0x0305:
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.i r0 = r0.f17507a     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            r0.a((com.shopee.app.web.protocol.ShareMessage) r4)     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.Object r5 = r3.second     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x045a }
                            r0.a((com.shopee.app.web.protocol.ShareMessage) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h$c r4 = com.shopee.app.g.h.c.SUCCESS     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h.c unused = r0.h = r4     // Catch:{ Exception -> 0x045a }
                            goto L_0x0474
                        L_0x0324:
                            if (r4 == 0) goto L_0x0336
                            com.shopee.app.web.protocol.notification.ShareDataField$Companion r0 = com.shopee.app.web.protocol.notification.ShareDataField.Companion     // Catch:{ Exception -> 0x045a }
                            java.lang.String r0 = r0.getValue(r2, r4, r11)     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.notification.ShareDataField$Companion r5 = com.shopee.app.web.protocol.notification.ShareDataField.Companion     // Catch:{ Exception -> 0x045a }
                            java.lang.String r6 = "email_subject"
                            java.lang.String r4 = r5.getValue(r2, r4, r6)     // Catch:{ Exception -> 0x045a }
                            goto L_0x0403
                        L_0x0336:
                            boolean r0 = r5     // Catch:{ Exception -> 0x045a }
                            if (r0 == 0) goto L_0x0397
                            com.shopee.app.data.store.ShareConfigStore r0 = r6     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r4 = r4.isShareShop()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.SharingConfigInfo$AppDetailInfo r0 = r0.getShareText(r11, r4, r12)     // Catch:{ Exception -> 0x045a }
                            java.lang.String r4 = r0.getBody()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = r0.getItemName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r6 = r0.getShopName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r7 = r0.getUsername()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r8 = r7     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r9 = r0.getItemPrice()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r0 = com.shopee.app.g.m.a(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.ShareConfigStore r4 = r6     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r5 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r5 = r5.isShareShop()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.SharingConfigInfo$AppDetailInfo r4 = r4.getShareText(r11, r5, r12)     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = r4.getSubject()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r6 = r4.getItemName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r7 = r4.getShopName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r8 = r4.getUsername()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r9 = r7     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r10 = r4.getItemPrice()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r4 = com.shopee.app.g.m.a(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x045a }
                            goto L_0x0403
                        L_0x0397:
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r0 = r0.isGeneric()     // Catch:{ Exception -> 0x045a }
                            if (r0 == 0) goto L_0x03a7
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r0 = r0.getGenericText()     // Catch:{ Exception -> 0x045a }
                            r4 = r2
                            goto L_0x0403
                        L_0x03a7:
                            com.shopee.app.data.store.ShareConfigStore r0 = r6     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r4 = r4.isShareShop()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.SharingConfigInfo$AppDetailInfo r0 = r0.getShareText(r11, r4, r13)     // Catch:{ Exception -> 0x045a }
                            java.lang.String r4 = r0.getBody()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = r0.getItemName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r6 = r0.getShopName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r7 = r0.getUsername()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r8 = r7     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r0 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r9 = r0.getItemPrice()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r0 = com.shopee.app.g.m.a(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.ShareConfigStore r4 = r6     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r5 = r4     // Catch:{ Exception -> 0x045a }
                            boolean r5 = r5.isShareShop()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.data.store.SharingConfigInfo$AppDetailInfo r4 = r4.getShareText(r11, r5, r13)     // Catch:{ Exception -> 0x045a }
                            java.lang.String r5 = r4.getSubject()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r6 = r4.getItemName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r7 = r4.getShopName()     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r8 = r4.getUsername()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r9 = r7     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ Exception -> 0x045a }
                            java.lang.String r10 = r4.getItemPrice()     // Catch:{ Exception -> 0x045a }
                            java.lang.String r4 = com.shopee.app.g.m.a(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x045a }
                        L_0x0403:
                            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x045a }
                            if (r5 != 0) goto L_0x0452
                            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x045a }
                            if (r5 == 0) goto L_0x0410
                            goto L_0x0452
                        L_0x0410:
                            java.lang.Object r5 = r3.first     // Catch:{ Exception -> 0x045a }
                            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x045a }
                            int r5 = r5.intValue()     // Catch:{ Exception -> 0x045a }
                            com.garena.g.a.a r5 = com.garena.g.b.a((int) r5)     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h r6 = com.shopee.app.g.h.this     // Catch:{ c -> 0x044a }
                            android.content.Context r6 = r6.f17513g     // Catch:{ c -> 0x044a }
                            com.garena.g.a$a r7 = com.garena.g.a.C0132a.a()     // Catch:{ c -> 0x044a }
                            com.garena.g.a$a r4 = r7.c(r4)     // Catch:{ c -> 0x044a }
                            com.garena.g.a$a r0 = r4.a((java.lang.String) r0)     // Catch:{ c -> 0x044a }
                            com.garena.g.a r0 = r0.b()     // Catch:{ c -> 0x044a }
                            r5.a((android.content.Context) r6, (com.garena.g.a) r0)     // Catch:{ c -> 0x044a }
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this     // Catch:{ c -> 0x044a }
                            com.shopee.app.web.protocol.ShareMessage r4 = r4     // Catch:{ c -> 0x044a }
                            java.lang.Object r5 = r3.second     // Catch:{ c -> 0x044a }
                            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ c -> 0x044a }
                            r0.a((com.shopee.app.web.protocol.ShareMessage) r4, (java.lang.String) r5)     // Catch:{ c -> 0x044a }
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this     // Catch:{ c -> 0x044a }
                            com.shopee.app.g.h$c r4 = com.shopee.app.g.h.c.SUCCESS     // Catch:{ c -> 0x044a }
                            com.shopee.app.g.h.c unused = r0.h = r4     // Catch:{ c -> 0x044a }
                            goto L_0x0474
                        L_0x044a:
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h$c r4 = com.shopee.app.g.h.c.APP_NOT_INSTALLED     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h.c unused = r0.h = r4     // Catch:{ Exception -> 0x045a }
                            goto L_0x0474
                        L_0x0452:
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h$c r4 = com.shopee.app.g.h.c.FAILED     // Catch:{ Exception -> 0x045a }
                            com.shopee.app.g.h.c unused = r0.h = r4     // Catch:{ Exception -> 0x045a }
                            goto L_0x0474
                        L_0x045a:
                            r0 = move-exception
                            com.garena.android.appkit.d.a.a(r0)
                            com.shopee.app.application.ar r4 = com.shopee.app.application.ar.f()
                            com.shopee.app.appuser.UserComponent r4 = r4.e()
                            com.shopee.app.util.q r4 = r4.fabricClient()
                            r4.a((java.lang.Throwable) r0, (java.lang.String) r2)
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this
                            com.shopee.app.g.h$c r2 = com.shopee.app.g.h.c.FAILED
                            com.shopee.app.g.h.c unused = r0.h = r2
                        L_0x0474:
                            com.shopee.app.g.h r0 = com.shopee.app.g.h.this
                            java.lang.Object r2 = r3.second
                            java.lang.String r2 = (java.lang.String) r2
                            com.shopee.app.g.h r3 = com.shopee.app.g.h.this
                            com.shopee.app.g.h$c r3 = r3.h
                            r0.a((java.lang.String) r2, (com.shopee.app.g.h.c) r3)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.g.h.AnonymousClass3.onClick(android.content.DialogInterface, int):void");
                    }
                });
                aVar2.a(false);
                final b bVar2 = bVar;
                aVar2.a((DialogInterface.OnDismissListener) new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (bVar2 != null) {
                            o oVar = new o();
                            oVar.a("status", (Number) Integer.valueOf(h.this.h == c.SUCCESS ? 1 : 0));
                            if (!h.this.i.isEmpty()) {
                                i iVar = new i(h.this.i.size());
                                for (d dVar : h.this.i.values()) {
                                    o oVar2 = new o();
                                    oVar2.a("appId", dVar.f17534a);
                                    oVar2.a(GraphResponse.SUCCESS_KEY, Boolean.valueOf(dVar.f17535b));
                                    oVar2.a("numberOfClicks", (Number) Integer.valueOf(dVar.f17536c));
                                    iVar.a((l) oVar2);
                                }
                                oVar.a("clickData", (l) iVar);
                            }
                            bVar2.a(oVar);
                            c unused = h.this.h = c.UNKNOWN;
                            h.this.i.clear();
                        }
                    }
                });
                this.f17512f = aVar.c();
                this.f17512f.show();
            }
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            ar.f().e().fabricClient().a((Throwable) e2, "");
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, c cVar) {
        d dVar = this.i.get(str);
        if (dVar == null) {
            dVar = new d(str, true);
            this.i.put(str, dVar);
        }
        dVar.f17536c++;
        int i2 = AnonymousClass5.f17533a[cVar.ordinal()];
        if (i2 == 1) {
            dVar.f17535b = true;
            this.f17512f.dismiss();
        } else if (i2 == 2) {
        } else {
            if (i2 == 3) {
                dVar.f17535b = false;
                r.a().b((int) R.string.sp_sharing_app_not_installed);
            } else if (i2 == 4) {
                dVar.f17535b = false;
                this.f17512f.dismiss();
            }
        }
    }

    /* renamed from: com.shopee.app.g.h$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17533a = new int[c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.shopee.app.g.h$c[] r0 = com.shopee.app.g.h.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17533a = r0
                int[] r0 = f17533a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.shopee.app.g.h$c r1 = com.shopee.app.g.h.c.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f17533a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.shopee.app.g.h$c r1 = com.shopee.app.g.h.c.PROCESSING_IMAGE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f17533a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.shopee.app.g.h$c r1 = com.shopee.app.g.h.c.APP_NOT_INSTALLED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f17533a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.shopee.app.g.h$c r1 = com.shopee.app.g.h.c.FAILED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.g.h.AnonymousClass5.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void a(ShareMessage shareMessage, String str) {
        this.f17510d.a(shareMessage.getShareTrackerLabel(), shareMessage.getShareTrackerId(), str, this.f17511e.getUserId());
    }

    private void a(int i2, a.C0124a aVar) {
        Bitmap createBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(com.garena.android.appkit.tools.b.a(R.color.transparent));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(com.garena.android.appkit.tools.a.f6696a.getResources(), createBitmap);
        int i3 = 4 - (i2 % 4);
        if (i3 == 4) {
            i3 = 0;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            aVar.a(R.id.share_dummy, false, bitmapDrawable, "");
        }
    }
}
