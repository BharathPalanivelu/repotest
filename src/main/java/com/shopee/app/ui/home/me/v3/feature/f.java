package com.shopee.app.ui.home.me.v3.feature;

import android.view.View;
import d.d.a.b;
import d.d.b.j;
import d.d.b.k;
import d.p;

public final class f {

    static final class a extends k implements b<View, p> {
        final /* synthetic */ d.d.a.a $block;
        final /* synthetic */ i $data;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(i iVar, d.d.a.a aVar) {
            super(1);
            this.$data = iVar;
            this.$block = aVar;
        }

        public /* bridge */ /* synthetic */ Object a(Object obj) {
            a((View) obj);
            return p.f32714a;
        }

        public final void a(View view) {
            if (this.$data.j().isLoggedIn()) {
                this.$block.invoke();
            } else {
                this.$data.k().f();
            }
        }
    }

    public static final void a(View view, i iVar, d.d.a.a<p> aVar) {
        j.b(view, "$this$setUserLoggedClickAction");
        j.b(iVar, "data");
        j.b(aVar, "block");
        com.shopee.app.e.b.a(view, (b<? super View, p>) new a(iVar, aVar));
    }
}
