package com.shopee.live.livestreaming.ui.anchor.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.a.e;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.data.entity.VoucherListItem;
import com.shopee.live.livestreaming.ui.anchor.c;
import com.shopee.live.livestreaming.ui.view.a;
import com.shopee.live.livestreaming.ui.view.d;
import com.shopee.live.livestreaming.ui.view.f;
import com.shopee.live.livestreaming.ui.view.g;
import com.shopee.live.livestreaming.util.h;
import com.shopee.live.livestreaming.util.o;
import com.shopee.live.livestreaming.util.q;
import com.shopee.live.livestreaming.util.x;
import java.util.ArrayList;

public class LivePageBottomView extends e implements View.OnClickListener {
    ArrayList<SessionProductEntity.ProductItem> A;
    ArrayList<VoucherListItem> B;
    a C;
    private f D;
    /* access modifiers changed from: private */
    public int E;
    private int F;
    /* access modifiers changed from: private */
    public String G;
    /* access modifiers changed from: private */
    public String H;
    /* access modifiers changed from: private */
    public int I;
    /* access modifiers changed from: private */
    public int J;
    /* access modifiers changed from: private */
    public int K;
    /* access modifiers changed from: private */
    public LiveStreamingSessionEntity L;
    private int M;
    private LivePageNavigationView N;
    private PublicScreenView O;

    /* renamed from: b  reason: collision with root package name */
    ViewGroup f28866b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f28867c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f28868d;

    /* renamed from: e  reason: collision with root package name */
    ImageView f28869e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f28870f;

    /* renamed from: g  reason: collision with root package name */
    ImageView f28871g;
    ImageView h;
    TextView i;
    RelativeLayout j;
    RelativeLayout k;
    RelativeLayout l;
    RelativeLayout m;
    CheckBox n;
    RelativeLayout o;
    RelativeLayout p;
    RelativeLayout q;
    RelativeLayout r;
    View s;
    View t;
    View u;
    View v;
    View w;
    View x;
    View y;
    c z;

    public interface a {
        void a();

        void a(int i);

        void a(long j, String str, String str2, String str3);

        void a(SessionProductEntity.ProductItem productItem);

        void a(VoucherEntity voucherEntity);

        void b();
    }

    public LivePageBottomView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LivePageBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LivePageBottomView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.G = "";
        this.H = "";
        this.A = new ArrayList<>();
        this.B = new ArrayList<>();
        f();
    }

    /* access modifiers changed from: protected */
    public int a() {
        return c.f.live_streaming_layout_live_bottom;
    }

    private void f() {
        this.f28866b = (ViewGroup) a(c.e.rl_bottom_product_anchor, this);
        this.f28867c = (ImageView) a(c.e.iv_bottom_product_anchor, this);
        this.f28868d = (ImageView) a(c.e.iv_bottom_voucher, this);
        this.f28869e = (ImageView) a(c.e.iv_bottom_comment, this);
        this.f28870f = (ImageView) a(c.e.iv_bottom_beauty, this);
        this.f28871g = (ImageView) a(c.e.iv_bottom_share, this);
        this.h = (ImageView) a(c.e.iv_bottom_camera_switch, this);
        this.i = (TextView) a(c.e.tv_product_num);
        this.j = (RelativeLayout) a(c.e.rl_bottom_comment);
        this.k = (RelativeLayout) a(c.e.rl_bottom_share);
        this.l = (RelativeLayout) a(c.e.rl_bottom_beauty);
        this.m = (RelativeLayout) a(c.e.rl_bottom_camera_switch);
        this.n = (CheckBox) a(c.e.cb_notify_follower);
        this.o = (RelativeLayout) a(c.e.rl_live_bottom);
        this.p = (RelativeLayout) a(c.e.rl_bottom_voucher);
        this.q = (RelativeLayout) a(c.e.rl_bottom_empty1);
        this.r = (RelativeLayout) a(c.e.rl_bottom_empty2);
        this.s = a(c.e.bottom_placeholder1);
        this.t = a(c.e.bottom_placeholder2);
        this.u = a(c.e.bottom_placeholder3);
        this.v = a(c.e.bottom_placeholder4);
        this.w = a(c.e.bottom_placeholder5);
        this.x = a(c.e.bottom_empty1_placeholder);
        this.y = a(c.e.bottom_empty2_placeholder);
        this.z = new com.shopee.live.livestreaming.ui.anchor.c(getContext());
        this.E = 50;
        this.n.setText(b.e(c.g.live_streaming_host_preview_btn_notify_followers));
        this.i.getPaint().setFakeBoldText(true);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == c.e.iv_bottom_product_anchor) {
            g();
        } else if (id == c.e.iv_bottom_voucher) {
            com.shopee.live.livestreaming.ui.anchor.b.p();
            h();
        } else if (id == c.e.iv_bottom_comment) {
            i();
        } else if (id == c.e.iv_bottom_beauty) {
            com.shopee.live.livestreaming.ui.view.a a2 = com.shopee.live.livestreaming.ui.view.a.a(this.E);
            a2.a((a.C0441a) new a.C0441a() {
                public void a(View view, int i) {
                    if (LivePageBottomView.this.C != null) {
                        int unused = LivePageBottomView.this.E = i;
                        LivePageBottomView.this.C.a(i);
                    }
                }

                public void a() {
                    LivePageBottomView.this.o.setVisibility(0);
                    LivePageBottomView.this.setBottomVisible(0);
                }
            });
            a2.show(((Activity) getContext()).getFragmentManager(), "tag");
            this.o.setVisibility(4);
            setBottomVisible(4);
        } else if (id == c.e.iv_bottom_share) {
            this.z.a((View) this.o);
            this.z.d(b.e(c.g.live_streaming_host_share_panel_title));
        } else if (id == c.e.iv_bottom_camera_switch) {
            a aVar = this.C;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private void g() {
        d a2 = d.a(com.shopee.live.livestreaming.util.f.a().f(), com.shopee.live.livestreaming.util.f.a().i(), this.G, this.A, this.I, this.J, this.M).a(this.F);
        a2.a((d.a) new d.a() {
            public void a() {
            }

            public void b(SessionProductEntity.ProductItem productItem, String str) {
            }

            public void a(SessionProductEntity.ProductItem productItem, String str) {
                if (LivePageBottomView.this.C != null) {
                    String unused = LivePageBottomView.this.G = str;
                    LivePageBottomView.this.C.a(productItem);
                }
            }

            public void a(int i) {
                if (i > 0) {
                    LivePageBottomView.this.i.setVisibility(0);
                    LivePageBottomView.this.i.setText(String.valueOf(i));
                    return;
                }
                LivePageBottomView.this.i.setVisibility(8);
            }

            public void a(ArrayList<SessionProductEntity.ProductItem> arrayList, int i, int i2) {
                if (arrayList != null && arrayList.size() > 0) {
                    LivePageBottomView.this.A.clear();
                    LivePageBottomView.this.A.addAll(arrayList);
                    int unused = LivePageBottomView.this.I = i;
                    int unused2 = LivePageBottomView.this.J = i2;
                }
            }
        });
        if (getContext() instanceof Activity) {
            a2.show(((Activity) getContext()).getFragmentManager(), "ff");
        }
    }

    private void h() {
        g a2 = g.a(this.H, this.B, this.K);
        a2.a((g.a) new g.a() {
            public void a() {
            }

            public void a(VoucherEntity voucherEntity, String str) {
                int i = 0;
                int i2 = 1;
                if (LivePageBottomView.this.C != null) {
                    String unused = LivePageBottomView.this.H = str;
                    LivePageBottomView.this.C.a(voucherEntity);
                    if (voucherEntity != null) {
                        if (voucherEntity.getShop_id() != 0) {
                            i = 1;
                        }
                        com.shopee.live.livestreaming.ui.anchor.b.b(voucherEntity.getPromotion_id(), voucherEntity.getVoucher_code(), i, true);
                    }
                } else if (voucherEntity != null) {
                    if (voucherEntity.getShop_id() == 0) {
                        i2 = 0;
                    }
                    com.shopee.live.livestreaming.ui.anchor.b.b(voucherEntity.getPromotion_id(), voucherEntity.getVoucher_code(), i2, false);
                }
            }

            public void b(VoucherEntity voucherEntity, String str) {
                String unused = LivePageBottomView.this.H = str;
                if (LivePageBottomView.this.C != null) {
                    LivePageBottomView.this.C.b();
                }
            }

            public void a(ArrayList<VoucherListItem> arrayList, int i, int i2) {
                if (arrayList != null && arrayList.size() > 0) {
                    LivePageBottomView.this.B.clear();
                    LivePageBottomView.this.B.addAll(arrayList);
                    int unused = LivePageBottomView.this.K = i;
                }
            }
        });
        a2.show(((Activity) getContext()).getFragmentManager(), "ff");
    }

    private void i() {
        if (this.D == null) {
            this.D = new f(getContext(), c.h.InputDialog);
            this.D.a((f.a) new f.a() {
                public void a(String str, boolean z) {
                    if ("live--v".equals(str)) {
                        o.b((Activity) LivePageBottomView.this.getContext());
                    } else if (LivePageBottomView.this.C != null && LivePageBottomView.this.L != null) {
                        LiveStreamingSessionEntity.Session session = LivePageBottomView.this.L.getSession();
                        LivePageBottomView.this.C.a((long) session.getUid(), session.getAvatar(), h.a(session), str);
                    }
                }
            });
            Display defaultDisplay = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
            WindowManager.LayoutParams attributes = this.D.getWindow().getAttributes();
            attributes.width = defaultDisplay.getWidth();
            this.D.getWindow().setAttributes(attributes);
            this.D.setCancelable(true);
            this.D.getWindow().setSoftInputMode(4);
        }
        this.D.show();
    }

    public void b() {
        f fVar = this.D;
        if (fVar != null) {
            fVar.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public void setBottomVisible(int i2) {
        if (this.F == 17) {
            this.N.setVisibility(i2);
        }
        if (this.F == 18) {
            this.O.setVisibility(i2);
        }
    }

    public void setSessionData(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        this.L = liveStreamingSessionEntity;
        this.z.b(liveStreamingSessionEntity.getSession().getTitle());
        String nickname = liveStreamingSessionEntity.getSession().getNickname();
        if (com.shopee.live.livestreaming.util.d.a(nickname)) {
            nickname = liveStreamingSessionEntity.getSession().getUsername();
        }
        this.z.c(nickname);
        this.M = liveStreamingSessionEntity.getSession().getItems_cnt();
        if (this.M > 0) {
            this.f28866b.setVisibility(0);
            this.s.setVisibility(0);
            this.i.setVisibility(0);
            this.i.setText(String.valueOf(this.M));
        } else if (q.a(this.F)) {
            this.f28866b.setVisibility(0);
            this.s.setVisibility(0);
            this.i.setVisibility(8);
        } else if (q.b(this.F)) {
            this.f28866b.setVisibility(8);
            this.s.setVisibility(8);
            this.i.setVisibility(8);
        }
    }

    public void setmLivePageNavigationView(LivePageNavigationView livePageNavigationView) {
        this.N = livePageNavigationView;
    }

    public void setPublicScreenView(PublicScreenView publicScreenView) {
        this.O = publicScreenView;
    }

    public void c() {
        this.F = 17;
        this.f28866b.setVisibility(0);
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.k.setVisibility(8);
        this.j.setVisibility(8);
        this.p.setVisibility(8);
        this.s.setVisibility(0);
        this.t.setVisibility(8);
        this.u.setVisibility(8);
        this.v.setVisibility(8);
        this.q.setVisibility(0);
        this.r.setVisibility(0);
        this.x.setVisibility(0);
        this.y.setVisibility(0);
        this.n.setVisibility(0);
        if (x.d()) {
            this.n.setVisibility(0);
        } else {
            this.n.setChecked(true);
            this.n.setVisibility(8);
        }
        j();
        this.z.a(this.F);
    }

    public void d() {
        this.F = 18;
        this.f28866b.setVisibility(0);
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.k.setVisibility(0);
        this.j.setVisibility(0);
        this.p.setVisibility(0);
        this.n.setVisibility(8);
        this.s.setVisibility(0);
        this.t.setVisibility(0);
        this.u.setVisibility(0);
        this.v.setVisibility(0);
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        if (this.M <= 0) {
            this.f28866b.setVisibility(8);
            this.s.setVisibility(8);
            this.i.setVisibility(8);
        }
        j();
        this.z.a(this.F);
    }

    private void j() {
        if (q.a(this.F) || q.b(this.F)) {
            this.f28867c.setImageResource(c.d.live_streaming_ic_anchor_bottom_product);
        } else {
            this.f28867c.setImageResource(c.d.live_streaming_ic_product_pos);
        }
    }

    public void setmShowVoucherId(String str) {
        this.H = str;
    }

    public void setmShowId(String str) {
        this.G = str;
    }

    public boolean e() {
        return this.n.isChecked();
    }

    public void setOnLiveBottomViewCallback(a aVar) {
        this.C = aVar;
    }

    public void a(long j2) {
        this.z.a(j2);
    }

    public void a(String str) {
        this.z.a(str);
    }
}
