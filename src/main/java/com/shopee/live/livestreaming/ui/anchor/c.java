package com.shopee.live.livestreaming.ui.anchor;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.a.l;
import com.google.a.o;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.share.CopyInfoBean;
import com.shopee.live.livestreaming.data.entity.share.PanelResponse;
import com.shopee.live.livestreaming.util.b.a;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.p;
import com.shopee.live.livestreaming.util.z;
import com.shopee.sdk.b;
import com.shopee.sdk.modules.ui.a.a;
import com.shopee.sdk.modules.ui.d.a;
import com.shopee.sdk.modules.ui.d.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f28833a;

    /* renamed from: b  reason: collision with root package name */
    private View f28834b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f28835c;

    /* renamed from: d  reason: collision with root package name */
    private int f28836d;

    /* renamed from: e  reason: collision with root package name */
    private String f28837e;

    /* renamed from: f  reason: collision with root package name */
    private String f28838f;

    /* renamed from: g  reason: collision with root package name */
    private long f28839g;
    private boolean h = false;
    private long i;

    public c(Context context) {
        this.f28833a = context;
    }

    public void a(View view) {
        this.f28834b = view;
    }

    public void a(String str) {
        this.f28835c = str;
    }

    public void a(int i2) {
        this.f28836d = i2;
    }

    public void b(String str) {
        this.f28837e = str;
    }

    public void c(String str) {
        this.f28838f = str;
    }

    public void a(long j) {
        this.f28839g = j;
    }

    public void d(String str) {
        a(str, false);
    }

    public void a(String str, boolean z) {
        c.a aVar;
        Activity activity = (Activity) this.f28833a;
        if (activity != null) {
            if (System.currentTimeMillis() - this.i >= 1000 || !this.h) {
                a();
                ArrayList arrayList = new ArrayList(Arrays.asList(a.a()));
                ArrayList arrayList2 = new ArrayList(Arrays.asList(a.f29425a));
                if (z) {
                    arrayList.addAll(arrayList2);
                }
                if (z) {
                    aVar = new c.a().a(str).a((List<String>) arrayList);
                } else {
                    aVar = new c.a().a(str).a((List<String>) arrayList).b((List<String>) arrayList2);
                }
                this.h = true;
                this.i = System.currentTimeMillis();
                b.a().h().a(activity, aVar.a(), (com.shopee.sdk.f.b<o>) new com.shopee.sdk.f.b<o>() {
                    public void a(o oVar) {
                        c.this.a();
                        PanelResponse panelResponse = (PanelResponse) com.shopee.sdk.b.a.fromJson(oVar, PanelResponse.class);
                        if (panelResponse == null) {
                            return;
                        }
                        if (panelResponse.status == 0) {
                            com.shopee.e.a.a.b("share response status 0", new Object[0]);
                        } else if (panelResponse.isAppAvailable) {
                            c.this.e(panelResponse.sharingAppID);
                        } else {
                            com.shopee.e.a.a.b("app is not available", new Object[0]);
                            z.a(c.this.f28833a, com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_fail_install));
                        }
                    }

                    public void a(int i, String str) {
                        c.this.a();
                        z.a(c.this.f28833a, com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_fail_general));
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        this.h = false;
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (str != null) {
            Context context = this.f28833a;
            if (!(context == null || this.f28834b == null)) {
                Activity activity = (Activity) context;
                int i2 = this.f28836d;
                if (i2 == 21) {
                    str2 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_replay_viewer_socialmedia_content), new Object[]{this.f28837e, this.f28838f, g(str)});
                } else if (i2 == 20) {
                    str2 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_viewer_socialmedia_content), new Object[]{this.f28837e, this.f28838f, g(str)});
                } else {
                    str2 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_host_socialmedia_content), new Object[]{this.f28837e, this.f28838f, g(str)});
                }
                if ("copyInfo".equals(str)) {
                    com.shopee.live.livestreaming.util.b.b.a(str, this.f28837e + ":" + g(str), (String) null, activity);
                } else if ("copyLink".equals(str)) {
                    com.shopee.live.livestreaming.util.b.b.a(str, g(str), (String) null, activity);
                } else if ("sms".equals(str)) {
                    int i3 = this.f28836d;
                    if (i3 == 21) {
                        str6 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_replay_sms_content), new Object[]{this.f28837e, g(str)});
                    } else if (i3 == 20) {
                        str6 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_viewer_sms_content), new Object[]{this.f28837e, g(str)});
                    } else {
                        str6 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_host_sms_content), new Object[]{this.f28837e, g(str)});
                    }
                    com.shopee.live.livestreaming.util.b.b.a(str, str6, p.a(this.f28835c), activity);
                } else if ("email".equals(str)) {
                    int i4 = this.f28836d;
                    if (i4 == 21) {
                        str5 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_replay_email_title), new Object[]{this.f28837e});
                        str4 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_replay_email_content), new Object[]{g(str)});
                    } else if (i4 == 20) {
                        str5 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_viewer_email_title), new Object[]{this.f28837e});
                        str4 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_viewer_email_content), new Object[]{g(str)});
                    } else {
                        str5 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_host_email_title), new Object[]{this.f28837e});
                        str4 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_host_email_content), new Object[]{g(str)});
                    }
                    com.shopee.live.livestreaming.util.b.b.a(str, str5, str4, p.a(this.f28835c), activity);
                } else if ("lineChat".equals(str)) {
                    com.shopee.live.livestreaming.util.b.b.a(str, str2, (String) null, activity);
                } else if ("facebookLink".equals(str)) {
                    int i5 = this.f28836d;
                    if (i5 == 21) {
                        str3 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_replay_fb_quote), new Object[]{this.f28837e, this.f28838f});
                    } else if (i5 == 20) {
                        str3 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_viewer_fb_quote), new Object[]{this.f28837e, this.f28838f});
                    } else {
                        str3 = String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_host_fb_quote), new Object[]{this.f28837e, this.f28838f});
                    }
                    com.shopee.live.livestreaming.util.b.b.a(str, g(str), str3, activity);
                } else if ("instagram".equals(str)) {
                    a(str2, activity);
                } else if ("facebookMessenger".equals(str)) {
                    com.shopee.live.livestreaming.util.b.b.a(str, str2, (String) null, activity);
                } else {
                    com.shopee.live.livestreaming.util.b.b.a(str, str2, p.a(this.f28835c), activity);
                }
                f(str);
            }
        }
        if (this.f28836d == 21) {
            com.shopee.live.livestreaming.ui.audience.c.b(str);
        } else {
            com.shopee.live.livestreaming.ui.audience.c.a(str);
        }
    }

    private void f(String str) {
        if (!"whatsapp".equals(str) && !"lineChat".equals(str) && !"twitter".equals(str) && !"facebookMessenger".equals(str) && "facebookLink".equals(str)) {
        }
    }

    private String g(String str) {
        String str2;
        String j = f.a().j();
        if (j == null) {
            j = "";
        }
        if (j.contains("?")) {
            str2 = j + "&viewer=" + this.f28839g;
        } else {
            str2 = j + "?viewer=" + this.f28839g;
        }
        return str2 + a.a(str);
    }

    private void a(final String str, final Activity activity) {
        b.a().h().a(activity, new a.C0474a().a("copyInfo").a((l) new CopyInfoBean(str).toJsonObject()).a(), (com.shopee.sdk.f.b<Integer>) new com.shopee.sdk.f.b<Integer>() {
            public void a(int i, String str) {
            }

            public void a(Integer num) {
                b.a().c().a(activity, new a.C0472a().a(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_ins_direction_title)).b(com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_ins_direction_content)).c(com.garena.android.appkit.tools.b.e(c.g.live_streaming_common_btn_ok)).a(), new com.shopee.sdk.f.b<Integer>() {
                    public void a(int i, String str) {
                    }

                    public void a(Integer num) {
                        int intValue = num.intValue();
                        if (intValue == 0) {
                            return;
                        }
                        if (intValue == 1) {
                            com.shopee.live.livestreaming.util.b.b.a("instagram", str, p.a(c.this.f28835c), activity);
                        }
                    }
                });
            }
        });
    }
}
