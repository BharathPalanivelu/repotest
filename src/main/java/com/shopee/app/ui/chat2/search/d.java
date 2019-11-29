package com.shopee.app.ui.chat2.search;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.s;
import com.afollestad.materialdialogs.f;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.chat2.ChatItem2;
import com.shopee.app.h.m;
import com.shopee.app.ui.common.NPALinearLayoutManager;
import com.shopee.app.ui.common.ae;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.order.r;
import com.shopee.app.util.af;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.List;

public class d extends FrameLayout implements r.b<ChatItem2> {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f20895a;

    /* renamed from: b  reason: collision with root package name */
    View f20896b;

    /* renamed from: c  reason: collision with root package name */
    ProgressWheel f20897c;

    /* renamed from: d  reason: collision with root package name */
    b f20898d;

    /* renamed from: e  reason: collision with root package name */
    com.shopee.app.ui.common.b f20899e;

    /* renamed from: f  reason: collision with root package name */
    bc f20900f;

    /* renamed from: g  reason: collision with root package name */
    m f20901g;
    Activity h;
    ak i;
    be j;
    com.shopee.app.ui.common.r k;
    private final CharSequence[] l = {com.garena.android.appkit.tools.b.e(R.string.sp_label_mark_unread), com.garena.android.appkit.tools.b.e(R.string.sp_label_delete)};
    private final CharSequence[] m = {com.garena.android.appkit.tools.b.e(R.string.sp_label_mark_read), com.garena.android.appkit.tools.b.e(R.string.sp_label_delete)};
    private final boolean n = true;
    private ae o;
    private a p;
    private String q = "";

    public interface b {
        void a(d dVar);
    }

    public d(Context context, String str) {
        super(context);
        this.q = str;
        a(context);
    }

    private void a(Context context) {
        ((b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20900f.a(this.f20898d);
        this.f20898d.a(this);
        this.f20895a.setLayoutManager(new NPALinearLayoutManager(getContext()));
        ((s) this.f20895a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.p = new a();
        this.p.a(this);
        this.p.setHasStableIds(true);
        this.f20899e.a(R.string.sp_login_to_see_your_chats, R.drawable.ic_no_chat);
        this.o = new ae(this.f20895a, this.p);
        this.o.a((ae.a) this.f20898d);
        this.f20895a.setAdapter(this.p);
        this.f20898d.a(this.q);
    }

    public void b() {
        this.f20897c.setVisibility(0);
    }

    public void c() {
        this.f20897c.setVisibility(8);
    }

    public void d() {
        this.o.c();
    }

    public void e() {
        this.o.b();
    }

    public void f() {
        this.k.a();
    }

    public void g() {
        this.k.b();
    }

    public void a(View view, ChatItem2 chatItem2, int i2) {
        this.i.d(chatItem2.getUserId());
        this.f20898d.f(chatItem2.getUserId());
    }

    public void a(View view, final ChatItem2 chatItem2) {
        if (chatItem2.getUnreadCount() > 0) {
            com.shopee.app.ui.dialog.a.a(getContext(), this.m, (a.c) new a.c() {
                public void a(f fVar, View view, int i, CharSequence charSequence) {
                    if (i != 0) {
                        d.this.a(chatItem2);
                    } else {
                        d.this.f20898d.f(chatItem2.getUserId());
                    }
                }
            });
        } else {
            com.shopee.app.ui.dialog.a.a(getContext(), this.l, (a.c) new a.c() {
                public void a(f fVar, View view, int i, CharSequence charSequence) {
                    if (i != 0) {
                        d.this.a(chatItem2);
                    } else {
                        d.this.f20898d.g(chatItem2.getUserId());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(final ChatItem2 chatItem2) {
        if (this.j.b()) {
            com.shopee.app.ui.dialog.a.a(getContext(), com.garena.android.appkit.tools.b.e(R.string.sp_warn_undone_action), com.garena.android.appkit.tools.b.e(R.string.sp_label_cancel_capital), com.garena.android.appkit.tools.b.e(R.string.sp_label_yes_capital), (a.C0318a) new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    d.this.f20898d.e(chatItem2.getUserId());
                }
            });
            this.j.c();
            return;
        }
        this.f20898d.e(chatItem2.getUserId());
    }

    public void a(List<ChatItem2> list) {
        this.p.a(list);
        this.p.notifyItemRangeChanged(0, list.size());
        if (af.a(list)) {
            this.f20896b.setVisibility(0);
            this.f20895a.setVisibility(8);
            return;
        }
        this.f20895a.setVisibility(0);
        this.f20896b.setVisibility(8);
    }

    public void h() {
        this.o.d();
    }

    private class a extends r<ChatItem2> {
        private a() {
        }

        /* access modifiers changed from: protected */
        public View a(ViewGroup viewGroup) {
            return com.shopee.app.ui.chat2.d.a(viewGroup.getContext(), true);
        }

        public long a(int i) {
            return ((ChatItem2) b(i)).getPChatId();
        }
    }
}
