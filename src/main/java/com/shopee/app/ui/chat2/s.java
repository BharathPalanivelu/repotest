package com.shopee.app.ui.chat2;

import android.text.TextUtils;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.am;
import com.shopee.app.network.d.bh;
import com.shopee.app.network.d.v;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;

public class s extends com.shopee.app.d.c.a.a<b> {

    /* renamed from: d  reason: collision with root package name */
    private final am f20852d;

    /* renamed from: e  reason: collision with root package name */
    private final SettingConfigStore f20853e;

    protected s(n nVar, SettingConfigStore settingConfigStore, am amVar) {
        super(nVar);
        this.f20852d = amVar;
        this.f20853e = settingConfigStore;
    }

    public void a() {
        b(new b(0, (Boolean) null, 0, (String) null));
    }

    public void c() {
        b(new b(1, (Boolean) null, 0, (String) null));
    }

    public void a(int i) {
        b(new b(3, (Boolean) null, i, (String) null));
    }

    public void a(int i, String str) {
        b(new b(2, (Boolean) null, i, str));
    }

    public void a(boolean z) {
        b(new b(4, Boolean.valueOf(z), 0, (String) null));
    }

    public void a(String str) {
        b(new b(5, (Boolean) null, 0, str));
    }

    /* access modifiers changed from: protected */
    public void a(b bVar) {
        List<String> a2 = this.f20852d.a();
        int a3 = bVar.f20856a;
        if (a3 == 0) {
            new v().g();
            d();
        } else if (a3 == 1) {
            d();
        } else if (a3 == 2) {
            this.f20852d.a(bVar.f20858c, bVar.f20859d);
            new bh().a(this.f20852d.b(), this.f20852d.a());
            this.f20852d.a(a2);
        } else if (a3 == 3) {
            this.f20852d.b(bVar.f20858c);
            new bh().a(this.f20852d.b(), this.f20852d.a());
            this.f20852d.a(a2);
        } else if (a3 == 4) {
            new bh().a(bVar.f20857b.booleanValue(), a2);
        } else if (a3 == 5) {
            this.f20852d.a(bVar.f20859d);
            new bh().a(this.f20852d.b(), this.f20852d.a());
            this.f20852d.a(a2);
        }
    }

    private void d() {
        a aVar = new a();
        aVar.f20854a = this.f20852d.b();
        ArrayList arrayList = new ArrayList(this.f20852d.a(this.f20853e.chatShortcutCount()));
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < Math.min(this.f20853e.chatShortcutCount(), arrayList.size()); i++) {
            arrayList2.add(new aj(i, (String) arrayList.get(i)));
        }
        aVar.f20855b = arrayList2;
        this.f16405a.a("GET_MESSAGE_SHORTCUTS", new com.garena.android.appkit.b.a(aVar));
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20854a;

        /* renamed from: b  reason: collision with root package name */
        public List<aj> f20855b;

        public List<String> a() {
            ArrayList arrayList = new ArrayList();
            List<aj> list = this.f20855b;
            if (list != null) {
                for (aj next : list) {
                    if (!TextUtils.isEmpty(next.f20279b)) {
                        arrayList.add(next.f20279b);
                    }
                }
            }
            return arrayList;
        }
    }

    public static class b extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f20856a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final Boolean f20857b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f20858c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final String f20859d;

        public b(int i, Boolean bool, int i2, String str) {
            super("MessageShortcutInteractor" + i, "use_case", 0, false);
            this.f20856a = i;
            this.f20857b = bool;
            this.f20858c = i2;
            this.f20859d = str;
        }
    }
}
