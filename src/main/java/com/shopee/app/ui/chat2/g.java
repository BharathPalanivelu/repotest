package com.shopee.app.ui.chat2;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.s;
import com.afollestad.materialdialogs.f;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.chat2.ChatItem2;
import com.shopee.app.h.m;
import com.shopee.app.ui.a.w;
import com.shopee.app.ui.common.NPALinearLayoutManager;
import com.shopee.app.ui.common.NoticeView_;
import com.shopee.app.ui.common.ae;
import com.shopee.app.ui.common.t;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.order.r;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class g extends FrameLayout implements r.b<ChatItem2> {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f20431a;

    /* renamed from: b  reason: collision with root package name */
    View f20432b;

    /* renamed from: c  reason: collision with root package name */
    e f20433c;

    /* renamed from: d  reason: collision with root package name */
    com.shopee.app.ui.common.b f20434d;

    /* renamed from: e  reason: collision with root package name */
    TextView f20435e;

    /* renamed from: f  reason: collision with root package name */
    bc f20436f;

    /* renamed from: g  reason: collision with root package name */
    m f20437g;
    Activity h;
    ak i;
    be j;
    com.shopee.app.ui.common.r k;
    SettingConfigStore l;
    private final int m;
    private final CharSequence[] n = {com.garena.android.appkit.tools.b.e(R.string.sp_label_mark_unread), com.garena.android.appkit.tools.b.e(R.string.sp_label_delete)};
    private final CharSequence[] o = {com.garena.android.appkit.tools.b.e(R.string.sp_label_mark_read), com.garena.android.appkit.tools.b.e(R.string.sp_label_delete)};
    private ae p;
    /* access modifiers changed from: private */
    public b q;
    private List<Object> r;
    private boolean s;

    public interface c {
        void a(g gVar);
    }

    public g(Context context, int i2) {
        super(context);
        a(context);
        this.m = i2;
        this.r = new ArrayList();
    }

    private void a(Context context) {
        ((c) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20436f.a(this.f20433c);
        this.f20433c.a(this);
        this.f20431a.setLayoutManager(new NPALinearLayoutManager(getContext()));
        this.q = new b();
        if (this.j.k() && this.l.policeScamUpdateEnabled()) {
            this.q.a(new w.a() {
                public View a() {
                    t a2 = NoticeView_.a(g.this.getContext());
                    a2.setNotice(com.garena.android.appkit.tools.b.e(R.string.tw_scam_alert_text));
                    a2.setOnDismissListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            g.this.j.l();
                            g.this.q.a((w.a) null);
                            g.this.q.notifyItemRangeChanged(0, g.this.q.getItemCount());
                        }
                    });
                    a2.setLeftIcon((int) R.drawable.ic_pop_warning);
                    return a2;
                }
            });
        }
        this.q.a(this);
        this.f20434d.a(R.string.sp_login_to_see_your_chats, R.drawable.ic_no_chat);
        ((s) this.f20431a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.q.registerAdapterDataObserver(new RecyclerView.c() {
            public void a() {
                g gVar = g.this;
                gVar.a(gVar.f20431a, g.this.f20432b, g.this.f20434d, g.this.q);
            }

            public void b(int i, int i2) {
                g gVar = g.this;
                gVar.a(gVar.f20431a, g.this.f20432b, g.this.f20434d, g.this.q);
            }

            public void c(int i, int i2) {
                g gVar = g.this;
                gVar.a(gVar.f20431a, g.this.f20432b, g.this.f20434d, g.this.q);
            }

            public void a(int i, int i2) {
                g gVar = g.this;
                gVar.a(gVar.f20431a, g.this.f20432b, g.this.f20434d, g.this.q);
            }
        });
        this.p = new ae(this.f20431a, this.q);
        this.p.a((ae.a) this.f20433c);
        this.f20431a.setAdapter(this.q);
        this.f20433c.a(this.m);
    }

    public void b() {
        this.k.a();
    }

    public void c() {
        this.k.b();
    }

    public void d() {
        this.p.c();
    }

    public void e() {
        this.p.b();
    }

    /* access modifiers changed from: private */
    public void a(RecyclerView recyclerView, View view, View view2, w wVar) {
        int i2 = this.m;
        if (i2 == 0) {
            this.f20435e.setText(com.garena.android.appkit.tools.b.e(R.string.sp_no_chat_history));
        } else if (i2 == 1) {
            this.f20435e.setText(com.garena.android.appkit.tools.b.e(R.string.sp_no_unread_chat));
        }
        if (view != null && wVar != null) {
            int i3 = 0;
            if (this.f20437g.a()) {
                view.setVisibility(wVar.a() ? 0 : 8);
                view2.setVisibility(8);
            } else {
                view.setVisibility(8);
                view2.setVisibility(wVar.a() ? 0 : 8);
            }
            if (!this.j.k() && wVar.a()) {
                i3 = 8;
            }
            recyclerView.setVisibility(i3);
        }
    }

    public void a(View view, ChatItem2 chatItem2, int i2) {
        this.i.d(chatItem2.getUserId());
        this.f20433c.g(chatItem2.getUserId());
    }

    public void a(View view, final ChatItem2 chatItem2) {
        if (chatItem2.getUnreadCount() > 0) {
            com.shopee.app.ui.dialog.a.a(getContext(), this.o, (a.c) new a.c() {
                public void a(f fVar, View view, int i, CharSequence charSequence) {
                    if (i != 0) {
                        g.this.a(chatItem2);
                    } else {
                        g.this.f20433c.g(chatItem2.getUserId());
                    }
                }
            });
        } else {
            com.shopee.app.ui.dialog.a.a(getContext(), this.n, (a.c) new a.c() {
                public void a(f fVar, View view, int i, CharSequence charSequence) {
                    if (i != 0) {
                        g.this.a(chatItem2);
                    } else {
                        g.this.f20433c.h(chatItem2.getUserId());
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
                    g.this.f20433c.f(chatItem2.getUserId());
                }
            });
            this.j.c();
            return;
        }
        this.f20433c.f(chatItem2.getUserId());
    }

    public void a(List<ChatItem2> list) {
        if (!this.r.isEmpty() || list.isEmpty()) {
            this.q.a(list);
            androidx.recyclerview.widget.f.a(new a(this.r, this.q.d()), true).a((RecyclerView.a) this.q);
        } else {
            this.q.a(list);
            this.q.notifyDataSetChanged();
        }
        this.r = this.q.d();
        if (this.s) {
            this.s = false;
            ((LinearLayoutManager) this.f20431a.getLayoutManager()).b(0, 0);
        }
    }

    public void f() {
        int n2 = ((LinearLayoutManager) this.f20431a.getLayoutManager()).n();
        if (n2 > 0 && n2 < 4) {
            this.s = true;
        }
    }

    private class b extends r<ChatItem2> {
        public long getItemId(int i) {
            return -1;
        }

        private b() {
        }

        /* access modifiers changed from: protected */
        public View a(ViewGroup viewGroup) {
            return d.a(viewGroup.getContext(), false);
        }

        public long a(int i) {
            return ((ChatItem2) b(i)).getPChatId();
        }
    }

    private class a extends f.a {

        /* renamed from: b  reason: collision with root package name */
        private final List<Object> f20448b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Object> f20449c;

        public boolean b(int i, int i2) {
            return false;
        }

        public a(List<Object> list, List<Object> list2) {
            this.f20448b = list;
            this.f20449c = list2;
        }

        public int a() {
            return this.f20448b.size();
        }

        public int b() {
            return this.f20449c.size();
        }

        public boolean a(int i, int i2) {
            Object obj = this.f20448b.get(i);
            Object obj2 = this.f20449c.get(i2);
            if (!(obj instanceof ChatItem2) || !(obj2 instanceof ChatItem2)) {
                if (!(obj instanceof r.a) || !(obj2 instanceof r.a) || ((r.a) obj).a() != ((r.a) obj2).a()) {
                    return false;
                }
                return true;
            } else if (((ChatItem2) obj).getPChatId() == ((ChatItem2) obj2).getPChatId()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
