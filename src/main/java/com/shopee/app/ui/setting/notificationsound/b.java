package com.shopee.app.ui.setting.notificationsound;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.shopee.app.data.store.v;
import com.shopee.app.pushnotification.a.a.c;
import com.shopee.app.pushnotification.e;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.setting.m;
import com.shopee.app.util.x;
import com.shopee.id.R;
import d.d.b.j;
import java.util.ArrayList;
import java.util.List;

public final class b extends LinearLayout implements View.OnClickListener, r {

    /* renamed from: a  reason: collision with root package name */
    public v f25305a;

    /* renamed from: b  reason: collision with root package name */
    private MediaPlayer f25306b;

    /* renamed from: c  reason: collision with root package name */
    private final List<com.shopee.app.ui.setting.cell.b> f25307c;

    public void b() {
    }

    public void c() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        this.f25307c = new ArrayList();
        Object b2 = ((x) context).b();
        if (b2 != null) {
            ((m) b2).a(this);
            setOrientation(1);
            a();
            e();
            return;
        }
        throw new d.m("null cannot be cast to non-null type com.shopee.app.ui.setting.SettingComponent");
    }

    public final v getStatusStore() {
        v vVar = this.f25305a;
        if (vVar == null) {
            j.b("statusStore");
        }
        return vVar;
    }

    public final void setStatusStore(v vVar) {
        j.b(vVar, "<set-?>");
        this.f25305a = vVar;
    }

    public void onClick(View view) {
        v vVar = this.f25305a;
        if (vVar == null) {
            j.b("statusStore");
        }
        String g2 = vVar.g();
        Object tag = view != null ? view.getTag() : null;
        if (!(tag instanceof String)) {
            tag = null;
        }
        String str = (String) tag;
        if (str != null) {
            j.a((Object) g2, "oldSoundId");
            String a2 = com.shopee.app.pushnotification.a.a(g2);
            String a3 = com.shopee.app.pushnotification.a.a(str);
            v vVar2 = this.f25305a;
            if (vVar2 == null) {
                j.b("statusStore");
            }
            vVar2.d(str);
            com.shopee.app.pushnotification.a.a(getContext(), a2, a3);
            e();
            a(str);
        }
    }

    private final void a(String str) {
        com.shopee.app.e.a.a(this.f25306b);
        MediaPlayer a2 = c.a(getContext(), str);
        if (a2 != null) {
            a2.setOnCompletionListener(a.f25308a);
        } else {
            a2 = null;
        }
        this.f25306b = a2;
    }

    static final class a implements MediaPlayer.OnCompletionListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f25308a = new a();

        a() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            com.shopee.app.e.a.a(mediaPlayer);
        }
    }

    public void d() {
        com.shopee.app.e.a.a(this.f25306b);
    }

    private final void a() {
        List<e> list = c.f18510a;
        j.a((Object) list, "soundShopeeList");
        for (e eVar : list) {
            j.a((Object) eVar, "sound");
            com.shopee.app.ui.setting.cell.b a2 = a(eVar);
            this.f25307c.add(a2);
            addView(a2, new LinearLayout.LayoutParams(-1, com.garena.android.appkit.tools.b.d(R.dimen.dp48)));
        }
    }

    private final void e() {
        v vVar = this.f25305a;
        if (vVar == null) {
            j.b("statusStore");
        }
        String g2 = vVar.g();
        for (com.shopee.app.ui.setting.cell.b bVar : this.f25307c) {
            bVar.setChecked(j.a(bVar.getTag(), (Object) g2));
        }
    }

    private final com.shopee.app.ui.setting.cell.b a(e eVar) {
        com.shopee.app.ui.setting.cell.b a2 = com.shopee.app.ui.setting.cell.c.a(getContext());
        a2.a(true);
        a2.setText(com.garena.android.appkit.tools.b.e(eVar.b()));
        a2.setOnClickListener(this);
        a2.setTag(eVar.a());
        j.a((Object) a2, "SettingsItemView_.build(… tag = sound.id\n        }");
        return a2;
    }
}
