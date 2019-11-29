package com.shopee.livequiz.ui.view.share;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.a.o;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.livequiz.c;
import com.shopee.livequiz.c.d;
import com.shopee.livequiz.d.c.a;
import com.shopee.livequiz.d.c.e;
import com.shopee.livequiz.data.b;
import com.shopee.livequiz.data.bean.share.PanelResponse;
import com.shopee.livequiz.g.h;
import com.shopee.livequiz.g.j;
import com.shopee.sdk.modules.ui.d.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShareContainer extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f30085a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f30086b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f30087c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f30088d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f30089e;

    /* renamed from: f  reason: collision with root package name */
    private View f30090f;

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<Activity> f30091g;
    /* access modifiers changed from: private */
    public String h;
    private boolean i;
    private int j;
    private int k;
    private a l;

    public ShareContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public ShareContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        View inflate = View.inflate(context, c.f.livesdk_shopee_layout_dialog_share_container, this);
        this.f30085a = (ImageView) inflate.findViewById(c.d.img_item_1);
        this.f30086b = (ImageView) inflate.findViewById(c.d.img_item_2);
        this.f30087c = (ImageView) inflate.findViewById(c.d.img_item_3);
        this.f30088d = (ImageView) inflate.findViewById(c.d.img_copy_link);
        this.f30089e = (ImageView) inflate.findViewById(c.d.img_more);
        a();
        this.f30088d.setOnClickListener(this);
        this.f30089e.setOnClickListener(this);
        this.l = com.shopee.livequiz.d.b.a.i();
    }

    public ShareContainer a(View view) {
        this.f30090f = view;
        return this;
    }

    public ShareContainer a(Activity activity) {
        this.f30091g = new WeakReference<>(activity);
        return this;
    }

    public ShareContainer a(String str) {
        this.h = str;
        return this;
    }

    public ShareContainer a(boolean z, int i2, int i3) {
        this.i = z;
        this.j = i2;
        this.k = i3;
        return this;
    }

    public void onClick(View view) {
        if (view.getId() == c.d.img_item_1 || view.getId() == c.d.img_item_2 || view.getId() == c.d.img_item_3) {
            b((String) view.getTag());
        } else if (view.getId() == c.d.img_copy_link) {
            String str = b.a().b().shareToken;
            if (j.a(str)) {
                com.shopee.livequiz.d.b.a.j().b(new e.a(b.a().b().eventId), new d<String>() {
                    public void a(String str) {
                        ShareContainer shareContainer = ShareContainer.this;
                        shareContainer.c(ShareContainer.this.h + "&share_token=" + Uri.encode(str));
                    }

                    public void a(int i, String str) {
                        ShareContainer shareContainer = ShareContainer.this;
                        shareContainer.c(shareContainer.h);
                    }
                });
            } else {
                c(this.h + "&share_token=" + Uri.encode(str));
            }
            c();
        } else if (view.getId() == c.d.img_more) {
            b();
            d();
        }
    }

    public void a() {
        String[] a2 = com.shopee.livequiz.data.a.c.a();
        a(this.f30085a, a2[0]);
        a(this.f30086b, a2[1]);
        a(this.f30087c, a2[2]);
    }

    public void a(ImageView imageView, String str) {
        if ("whatsapp".equals(str)) {
            imageView.setImageResource(c.g.livequiz_ic_whatsapp);
        } else if ("instagram".equals(str)) {
            imageView.setImageResource(c.g.livequiz_ic_instagram);
        } else if ("lineChat".equals(str)) {
            imageView.setImageResource(c.g.livequiz_ic_line);
        } else if ("facebookLink".equals(str)) {
            imageView.setImageResource(c.g.livequiz_ic_facebook);
        } else if ("twitter".equals(str)) {
            imageView.setImageResource(c.g.livequiz_ic_twitter);
        } else if ("facebookMessenger".equals(str)) {
            imageView.setImageResource(c.g.livequiz_ic_messenger);
        }
        imageView.setTag(str);
        imageView.setOnClickListener(this);
    }

    private void b() {
        WeakReference<Activity> weakReference = this.f30091g;
        if (weakReference != null) {
            Activity activity = (Activity) weakReference.get();
            if (activity != null) {
                ArrayList arrayList = new ArrayList(Arrays.asList(com.shopee.livequiz.data.a.c.b()));
                String a2 = com.shopee.livequiz.g.e.a().a("t_sp_title");
                com.shopee.sdk.b.a().h().a(activity, new c.a().a(a2).b(com.shopee.livequiz.g.e.a().a("t_sp_sub_title")).a((List<String>) arrayList).a(), (com.shopee.sdk.f.b<o>) new com.shopee.sdk.f.b<o>() {
                    public void a(o oVar) {
                        PanelResponse panelResponse = (PanelResponse) com.shopee.sdk.b.a.fromJson(oVar, PanelResponse.class);
                        if (panelResponse == null) {
                            return;
                        }
                        if (panelResponse.status == 0) {
                            com.garena.android.appkit.d.a.a("share response status 0", new Object[0]);
                        } else if (panelResponse.isAppAvailable) {
                            ShareContainer.this.b(panelResponse.sharingAppID);
                        } else {
                            com.garena.android.appkit.d.a.a("app is not available", new Object[0]);
                            Toast.makeText(ShareContainer.this.getContext(), com.shopee.livequiz.g.e.a().a("t_sp_fail_install"), 0).show();
                        }
                    }

                    public void a(int i, String str) {
                        com.garena.android.appkit.d.a.a("share failed: " + i + "," + str, new Object[0]);
                        Toast.makeText(ShareContainer.this.getContext(), com.shopee.livequiz.g.e.a().a("t_sp_fail_general"), 0).show();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(final String str) {
        String str2 = b.a().b().shareToken;
        if (j.a(str2)) {
            com.shopee.livequiz.d.b.a.j().b(new e.a(b.a().b().eventId), new d<String>() {
                public void a(String str) {
                    ShareContainer shareContainer = ShareContainer.this;
                    String str2 = str;
                    shareContainer.a(str2, ShareContainer.this.h + "&share_token=" + Uri.encode(str));
                }

                public void a(int i, String str) {
                    Toast.makeText(ShareContainer.this.getContext(), com.shopee.livequiz.g.e.a().a("t_sp_fail_general"), 0).show();
                }
            });
            return;
        }
        a(str, this.h + "&share_token=" + Uri.encode(str2));
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        if (str != null) {
            WeakReference<Activity> weakReference = this.f30091g;
            if (weakReference != null && this.f30090f != null) {
                Activity activity = (Activity) weakReference.get();
                String str3 = "";
                if ("whatsapp".equals(str)) {
                    String a2 = com.shopee.livequiz.g.e.a().a("share_general_msg");
                    StringBuilder sb = new StringBuilder();
                    if (a2 != null) {
                        str3 = a2 + SQLBuilder.BLANK;
                    }
                    sb.append(str3);
                    sb.append(str2);
                    h.b(str, sb.toString(), com.shopee.livequiz.g.e.a().c("share_general_fb"), activity);
                } else if ("lineChat".equals(str)) {
                    String a3 = com.shopee.livequiz.g.e.a().a("share_general_msg");
                    StringBuilder sb2 = new StringBuilder();
                    if (a3 != null) {
                        str3 = a3 + SQLBuilder.BLANK;
                    }
                    sb2.append(str3);
                    sb2.append(str2);
                    h.b(str, sb2.toString(), (String) null, activity);
                } else if ("facebookLink".equals(str)) {
                    h.b(str, com.shopee.livequiz.g.e.a().a("share_general_msg"), str2, activity);
                } else if ("instagram".equals(str)) {
                    String a4 = com.shopee.livequiz.g.e.a().a("share_general_msg");
                    StringBuilder sb3 = new StringBuilder();
                    if (a4 != null) {
                        str3 = a4 + SQLBuilder.BLANK;
                    }
                    sb3.append(str3);
                    sb3.append(str2);
                    c(sb3.toString());
                    h.a(str, (String) null, this.f30090f, activity);
                } else {
                    String a5 = com.shopee.livequiz.g.e.a().a("share_general_msg");
                    StringBuilder sb4 = new StringBuilder();
                    if (a5 != null) {
                        str3 = a5 + SQLBuilder.BLANK;
                    }
                    sb4.append(str3);
                    sb4.append(str2);
                    h.a(str, sb4.toString(), this.f30090f, activity);
                }
                d(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        h.a(str, (Activity) this.f30091g.get());
    }

    private void d(String str) {
        String str2;
        if ("whatsapp".equals(str)) {
            str2 = "whatsapp_share";
        } else if ("lineChat".equals(str)) {
            str2 = "line_share";
        } else if ("twitter".equals(str)) {
            str2 = "twitter_share";
        } else if ("facebookMessenger".equals(str)) {
            str2 = "messenger_share";
        } else if ("facebookLink".equals(str)) {
            str2 = "fb_share";
        } else {
            return;
        }
        e(str2);
    }

    private void c() {
        e("copylink_share");
    }

    private void d() {
        e("more_share");
    }

    private void e(String str) {
        this.l.b(new a.C0456a(str, this.j, this.k), null);
        if (this.i) {
            this.l.b(new a.C0456a("share_winner_popup", this.j, this.k), null);
        } else {
            this.l.b(new a.C0456a("share_loser_popup", this.j, this.k), null);
        }
    }
}
