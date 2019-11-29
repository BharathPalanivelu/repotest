package com.garena.pay.android;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.appsflyer.AppsFlyerProperties;
import com.beetalk.sdk.data.c;
import com.beetalk.sdk.l;
import com.garena.d.a;
import com.garena.pay.android.b.a;
import com.garena.pay.android.c.d;
import com.garena.pay.android.c.f;
import com.garena.pay.android.f.b;
import com.garena.pay.android.f.i;
import com.squareup.a.w;
import java.util.HashMap;

public class e extends d {

    /* renamed from: b  reason: collision with root package name */
    static transient b f8227b;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f8228c = (!e.class.desiredAssertionStatus());
    private final Integer MP = -1;

    /* renamed from: a  reason: collision with root package name */
    transient i f8229a;

    public void h() {
    }

    protected e(b bVar) {
        super(bVar);
    }

    public boolean a(final c cVar) {
        LinearLayout linearLayout = new LinearLayout(this.client.b());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        AnonymousClass1 r0 = new i.b() {
            public void a(Bundle bundle, a aVar) {
                e.this.a(cVar, bundle, aVar);
            }
        };
        String a2 = a(l.i(), cVar);
        if (this.f8229a == null) {
            this.f8229a = new i(this.client.b(), a2, 16973840);
        }
        this.f8229a.a((i.b) r0);
        this.f8229a.show();
        return this.f8229a.isShowing();
    }

    private String a(String str, c cVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", cVar.b().e());
        hashMap.put("platform", cVar.b().h().toString());
        hashMap.put("open_id", cVar.b().f());
        hashMap.put("client_type", l.c.f5472b.toString());
        hashMap.put("app_server_id", cVar.b().b().toString());
        hashMap.put("app_role_id", cVar.b().c().toString());
        if (cVar.i() != null) {
            if (cVar.a()) {
                hashMap.put("app_point_amount", cVar.i().c().toString());
            } else {
                hashMap.put("item_id", cVar.i().b());
            }
        }
        hashMap.put("access_token", cVar.b().d());
        hashMap.put(AppsFlyerProperties.CHANNEL, a());
        if (cVar.b().g() != null) {
            hashMap.put("locale", cVar.b().g().toString());
        }
        if (com.beetalk.sdk.e.b.d(cVar.c())) {
            hashMap.put("imsi", ((TelephonyManager) cVar.c().getSystemService("phone")).getSubscriberId());
        }
        if (cVar.b().a().longValue() > 0) {
            hashMap.put("rebate_card_id", String.valueOf(cVar.b().a()));
        }
        d dVar = new d(hashMap);
        com.beetalk.sdk.e.a.b("Request Params Data %s", hashMap);
        return str + "?" + dVar.toString();
    }

    /* access modifiers changed from: private */
    public void a(final c cVar, final Bundle bundle, a aVar) {
        i iVar = this.f8229a;
        if (iVar != null) {
            iVar.dismiss();
        }
        View inflate = this.client.b().getLayoutInflater().inflate(a.e.confirmation_popup, new LinearLayout(this.client.b()));
        f8227b = new b(inflate, false, false);
        inflate.findViewById(a.d.btn_ok).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e.f8227b.a();
                e.f8227b = null;
            }
        });
        if (bundle == null || !bundle.containsKey("error")) {
            a(inflate, 0);
            TextView textView = (TextView) inflate.findViewById(a.d.txt_app_point_amount);
            if (f8228c || bundle != null) {
                textView.setText("x " + bundle.getString("app_point_amount"));
                ImageView imageView = (ImageView) inflate.findViewById(a.d.icon_app_point_amount);
                w.a(imageView.getContext()).a(bundle.getString("item_icon")).a(imageView);
                f8227b.a((b.a) new b.a() {
                    public void a() {
                        Intent intent = new Intent();
                        Bundle bundle = bundle;
                        if (bundle != null) {
                            intent.putExtra("item_name", bundle.getString("item_name"));
                            intent.putExtra("app_point_amount", bundle.getString("app_point_amount"));
                            intent.putExtra("item_icon", bundle.getString("item_icon"));
                            intent.putExtra("txn_id", bundle.getString("txn_id"));
                            intent.putExtra("rebate_card_id", bundle.getString("rebate_card_id"));
                            intent.putExtra("remaining_days", bundle.getString("remaining_days"));
                        }
                        e.this.client.a(cVar.e().intValue(), -1, intent);
                    }
                });
            } else {
                throw new AssertionError();
            }
        } else {
            a(inflate, 4);
            ((TextView) inflate.findViewById(a.d.error_text)).setText(String.format("Server replied with:\n%s", new Object[]{bundle.getString("error")}));
            f8227b.a((b.a) new b.a() {
                public void a() {
                    Intent intent = new Intent();
                    intent.putExtra("error", bundle.getString("error"));
                    intent.putExtra("extra_error_code", bundle.getInt("extra_error_code"));
                    e.this.client.a(cVar.e().intValue(), 0, intent);
                }
            });
        }
        f8227b.a(this.client.b().findViewById(a.d.main_layout));
    }

    private void a(View view, int i) {
        if (i == 4) {
            view.findViewById(a.d.success_panel).setVisibility(4);
            view.findViewById(a.d.error_panel).setVisibility(0);
            return;
        }
        view.findViewById(a.d.success_panel).setVisibility(0);
        view.findViewById(a.d.error_panel).setVisibility(4);
    }

    /* access modifiers changed from: protected */
    public boolean a(int i, int i2, Intent intent, c cVar) {
        if (i2 == 0) {
            if (intent.getExtras().containsKey("error")) {
                this.client.a(c.a(cVar, a.getErrorFromCode(intent.getIntExtra("extra_error_code", a.UNKNOWN_ERROR.getCode().intValue())), intent.getStringExtra("error")));
                return true;
            }
            this.client.a(c.a(cVar, a.UNKNOWN_ERROR, a.UNKNOWN_ERROR.getStringValue()));
            return true;
        } else if (i2 != -1) {
            return true;
        } else {
            this.client.a(c.a(cVar, f.a(intent.getExtras())));
            return true;
        }
    }
}
