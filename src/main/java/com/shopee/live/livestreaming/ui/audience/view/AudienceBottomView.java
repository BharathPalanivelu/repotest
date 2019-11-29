package com.shopee.live.livestreaming.ui.audience.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.core.widget.h;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.network.executor.RetryTask;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.GetSessionProductTask;
import com.shopee.live.livestreaming.ui.view.c.d;
import com.shopee.live.livestreaming.ui.view.d;
import com.shopee.live.livestreaming.ui.view.f;
import com.shopee.live.livestreaming.util.ab;
import com.shopee.live.livestreaming.util.x;
import com.shopee.live.livestreaming.util.y;
import java.util.ArrayList;

public class AudienceBottomView extends com.shopee.live.livestreaming.a.b implements View.OnClickListener {
    /* access modifiers changed from: private */
    public int A;
    /* access modifiers changed from: private */
    public int B;
    /* access modifiers changed from: private */
    public int C;
    /* access modifiers changed from: private */
    public ArrayList<SessionProductEntity.ProductItem> D;
    private boolean E;
    /* access modifiers changed from: private */
    public Handler F;
    /* access modifiers changed from: private */
    public Handler G;
    private GetSessionProductTask H;
    private int I;
    private c J;
    private c K;
    private ConstraintLayout L;
    private boolean M;
    private d N;
    ViewGroup h;
    ImageView i;
    TextView j;
    TextView k;
    ImageView l;
    ImageView m;
    ImageView n;
    TextView o;
    ImageView p;
    /* access modifiers changed from: private */
    public com.shopee.live.livestreaming.ui.audience.d q;
    /* access modifiers changed from: private */
    public FlowLikeLayout r;
    /* access modifiers changed from: private */
    public int s;
    /* access modifiers changed from: private */
    public long t;
    /* access modifiers changed from: private */
    public Animation u;
    private f v;
    /* access modifiers changed from: private */
    public boolean w;
    private com.shopee.live.livestreaming.ui.anchor.c x;
    /* access modifiers changed from: private */
    public b y;
    /* access modifiers changed from: private */
    public String z;

    public interface b {
        void a();

        void a(int i);

        void a(String str);

        void b();
    }

    static /* synthetic */ int g(AudienceBottomView audienceBottomView) {
        int i2 = audienceBottomView.s;
        audienceBottomView.s = i2 + 1;
        return i2;
    }

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private long f29036b;

        /* renamed from: c  reason: collision with root package name */
        private long f29037c;

        public a(long j, long j2) {
            this.f29036b = j;
            this.f29037c = j2;
        }

        public void run() {
            AudienceBottomView.this.r.a();
            if (this.f29036b > 0 && AudienceBottomView.this.G != null) {
                AudienceBottomView.this.G.postDelayed(new a(this.f29036b - 1, this.f29037c), this.f29037c);
            }
        }
    }

    public AudienceBottomView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AudienceBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AudienceBottomView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.z = "";
        this.D = new ArrayList<>();
        this.J = new c();
        this.K = new c();
        g();
        this.H = InjectorUtils.provideGetSessionProductTask();
    }

    /* access modifiers changed from: protected */
    public int b() {
        return c.f.live_streaming_layout_audience_bottom_view;
    }

    private void g() {
        this.h = (ViewGroup) a(c.e.rl_bottom_product, this);
        this.i = (ImageView) b(c.e.iv_bottom_product);
        this.j = (TextView) b(c.e.tv_product_num);
        this.k = (TextView) a(c.e.tv_send_message, this);
        this.l = (ImageView) a(c.e.iv_more, this);
        this.m = (ImageView) a(c.e.iv_share, this);
        this.n = (ImageView) a(c.e.iv_like, this);
        this.o = (TextView) b(c.e.tv_likes);
        this.p = (ImageView) b(c.e.iv_more_btn_corner_mark);
        this.u = AnimationUtils.loadAnimation(getContext(), c.a.live_streaming_anim_click_like);
        this.u.setInterpolator(new OvershootInterpolator(2.0f));
        this.x = new com.shopee.live.livestreaming.ui.anchor.c(getContext());
        this.F = new Handler();
        this.G = new Handler();
        this.k.setText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_msg_input_placeholder));
        this.j.getPaint().setFakeBoldText(true);
        k();
        this.L = (ConstraintLayout) findViewById(c.e.audience_bottom);
        this.K.a(getContext().getApplicationContext(), c.f.live_streaming_layout_audience_bottom_view_landscape);
        this.J.a(this.L);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == c.e.tv_send_message) {
            y.a((Activity) getContext(), new y.a() {
                public void b() {
                }

                public void a() {
                    if (!AudienceBottomView.this.w) {
                        AudienceBottomView.this.h();
                    }
                    com.shopee.live.livestreaming.ui.audience.c.a(AudienceBottomView.this.w);
                }
            });
        } else if (id == c.e.iv_share) {
            this.x.a((View) this);
            com.shopee.live.livestreaming.ui.anchor.c cVar = this.x;
            com.shopee.live.livestreaming.ui.audience.d dVar = this.q;
            cVar.a(dVar == null ? "" : dVar.g());
            if (this.I == 21) {
                com.shopee.live.livestreaming.ui.audience.c.n();
                this.x.a(com.garena.android.appkit.tools.b.e(c.g.live_streaming_replay_share_panel_title), this.M);
                return;
            }
            com.shopee.live.livestreaming.ui.audience.c.i();
            this.x.a(com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_share_panel_title), this.M);
        } else if (id == c.e.iv_more) {
            com.shopee.live.livestreaming.b.b().a().setUserGuideCleanButton(Integer.valueOf(x.f()));
            j();
            k();
        } else if (id == c.e.iv_like) {
            y.a((Activity) getContext(), new y.a() {
                public void b() {
                }

                public void a() {
                    AudienceBottomView audienceBottomView = AudienceBottomView.this;
                    audienceBottomView.setLikeNumber(audienceBottomView.t + 1);
                    AudienceBottomView.this.n.startAnimation(AudienceBottomView.this.u);
                    AudienceBottomView.this.o.startAnimation(AudienceBottomView.this.u);
                    AudienceBottomView.g(AudienceBottomView.this);
                    if (AudienceBottomView.this.r != null) {
                        AudienceBottomView.this.r.a();
                    }
                    AudienceBottomView.this.F.removeCallbacksAndMessages((Object) null);
                    AudienceBottomView.this.F.postDelayed(new Runnable() {
                        public void run() {
                            if (AudienceBottomView.this.y != null) {
                                AudienceBottomView.this.y.a(AudienceBottomView.this.s + AudienceBottomView.this.C);
                                int unused = AudienceBottomView.this.s = 0;
                            }
                        }
                    }, 1000);
                    com.shopee.live.livestreaming.ui.audience.c.j();
                }
            });
        } else if (id == c.e.rl_bottom_product) {
            if (this.I == 20) {
                com.shopee.live.livestreaming.ui.audience.c.f();
            } else {
                com.shopee.live.livestreaming.ui.audience.c.m();
            }
            f();
        }
    }

    public void setAudienceView(com.shopee.live.livestreaming.ui.audience.interfaceD dVar) {
        this.q = dVar;
    }

    public void setFlowLikeLayout(FlowLikeLayout flowLikeLayout) {
        this.r = flowLikeLayout;
    }

    public void a(boolean z2) {
        String str;
        this.w = z2;
        TextView textView = this.k;
        if (z2) {
            str = com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_msg_input_placeholder_banned);
        } else {
            str = com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_msg_input_placeholder);
        }
        textView.setText(str);
        f fVar = this.v;
        if (fVar != null) {
            fVar.dismiss();
            com.shopee.live.livestreaming.util.d.a((Activity) getContext());
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        if (this.v == null) {
            this.v = new f(getContext(), c.h.InputDialog);
            this.v.a(150);
            this.v.a((f.a) new f.a() {
                public void a(String str, boolean z) {
                    if (AudienceBottomView.this.y != null) {
                        AudienceBottomView.this.y.a(str);
                    }
                }
            });
            i();
        }
        this.v.show();
    }

    private void i() {
        if (this.v != null) {
            Display defaultDisplay = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
            if (this.v.getWindow() != null) {
                WindowManager.LayoutParams attributes = this.v.getWindow().getAttributes();
                attributes.width = defaultDisplay.getWidth();
                this.v.getWindow().setAttributes(attributes);
            }
            this.v.setCancelable(true);
            this.v.getWindow().setSoftInputMode(4);
        }
    }

    public void c() {
        f fVar = this.v;
        if (fVar != null) {
            fVar.dismiss();
        }
    }

    public void setProductItemCount(int i2) {
        if (i2 > 0) {
            this.j.setText(String.valueOf(i2));
            this.h.setVisibility(0);
            return;
        }
        this.h.setVisibility(8);
    }

    public void setLikeNumber(long j2) {
        if (this.t <= j2) {
            this.t = j2;
            if (j2 > 0) {
                this.o.setVisibility(0);
            } else {
                this.o.setVisibility(8);
            }
            this.o.setText(ab.a(String.valueOf(j2), 1));
        }
    }

    public long getLikeNumber() {
        return this.t;
    }

    public void a(long j2) {
        if (this.t == 0) {
            setLikeNumber(j2);
            return;
        }
        long min = Math.min(Math.max(j2 - this.t, 0), 50);
        if (!this.E) {
            this.G.removeCallbacksAndMessages((Object) null);
            if (min > 0) {
                this.G.post(new a(min - 1, Math.min(Math.max(1000 / min, 100), 1000)));
            }
        }
        setLikeNumber(j2);
    }

    public void b(long j2) {
        this.x.a(j2);
    }

    public void setLikeClickForbidden(boolean z2) {
        this.n.setClickable(!z2);
        this.E = z2;
    }

    public void d() {
        this.k.setVisibility(8);
    }

    public void setBottomViewCallback(b bVar) {
        this.y = bVar;
    }

    public void c(int i2) {
        final RetryTask retryTask = new RetryTask();
        retryTask.execute(new RetryTask.Data(this.H, new GetSessionProductTask.Data(i2, 0, 10), new GetSessionProductTask.Callback() {
            public void onError(int i, String str) {
            }

            public void returnProduct(int i, SessionProductEntity sessionProductEntity) {
                if (retryTask.handleResult(true) && sessionProductEntity != null) {
                    AudienceBottomView.this.setProductItemCount(sessionProductEntity.getTotal_count());
                    ArrayList unused = AudienceBottomView.this.D = sessionProductEntity.getItems();
                }
            }
        }), new RetryTask.Callback() {
            public void onFailed() {
            }

            public void onSuccess() {
            }
        });
    }

    public void d(int i2) {
        this.C += i2;
    }

    public void e() {
        this.C = 0;
    }

    public void f() {
        if (this.N == null || !(getContext() instanceof Activity)) {
            this.N = d.a(this.q.B_(), "", this.z, this.D, this.A, this.B, 0).a(this.I);
            this.N.a((d.a) new d.a() {
                public void a() {
                }

                public void a(SessionProductEntity.ProductItem productItem, String str) {
                    String unused = AudienceBottomView.this.z = str;
                    AudienceBottomView.this.a(productItem);
                }

                public void b(SessionProductEntity.ProductItem productItem, String str) {
                    String unused = AudienceBottomView.this.z = str;
                    AudienceBottomView.this.b(productItem);
                }

                public void a(int i) {
                    AudienceBottomView.this.setProductItemCount(i);
                }

                public void a(ArrayList<SessionProductEntity.ProductItem> arrayList, int i, int i2) {
                    if (arrayList != null && arrayList.size() > 0) {
                        AudienceBottomView.this.D.clear();
                        AudienceBottomView.this.D.addAll(arrayList);
                        int unused = AudienceBottomView.this.A = i;
                        int unused2 = AudienceBottomView.this.B = i2;
                    }
                }
            });
            if (getContext() instanceof Activity) {
                this.N.show(((Activity) getContext()).getFragmentManager(), "ff");
                return;
            }
            return;
        }
        this.N.show(((Activity) getContext()).getFragmentManager(), "ff");
    }

    public void setPlayMode(int i2) {
        this.I = i2;
        this.x.a(i2);
        k();
    }

    public void setTitleName(String str) {
        this.x.b(str);
    }

    public void setAnchorName(String str) {
        this.x.c(str);
    }

    private void j() {
        final com.shopee.live.livestreaming.ui.view.c.d dVar = new com.shopee.live.livestreaming.ui.view.c.d(getContext());
        if (this.I != 21) {
            dVar.a(0, com.garena.android.appkit.tools.b.e(c.g.live_streaming_clean_mode));
        }
        dVar.a(1, com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_btn_report));
        dVar.a(new d.a() {
            public void a(int i) {
                dVar.dismiss();
                if (i == 1) {
                    y.a((Activity) AudienceBottomView.this.getContext(), new y.a() {
                        public void b() {
                        }

                        public void a() {
                            if (AudienceBottomView.this.y != null) {
                                AudienceBottomView.this.y.a();
                            }
                        }
                    });
                } else if (i == 0 && AudienceBottomView.this.y != null) {
                    com.shopee.live.livestreaming.ui.audience.c.d();
                    AudienceBottomView.this.y.b();
                }
            }
        });
        dVar.getContentView().measure(e(dVar.getWidth()), e(dVar.getHeight()));
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(c.C0439c.live_streaming_oval_bottom_size);
        int measuredWidth = dVar.getContentView().getMeasuredWidth();
        int d2 = (-(dVar.getContentView().getMeasuredHeight() + dimensionPixelSize)) - com.garena.android.appkit.tools.b.d(c.C0439c.live_streaming_menu_popup_margin_bottom);
        h.a(dVar, this.l, (dimensionPixelSize - measuredWidth) / 2, d2, 8388611);
    }

    private static int e(int i2) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), i2 == -2 ? 0 : 1073741824);
    }

    private void k() {
        if (this.I == 21) {
            this.p.setVisibility(8);
        } else if (!com.shopee.live.livestreaming.b.b().a().ifSetUserGuideCleanButton(Integer.valueOf(x.f()))) {
            this.p.setVisibility(0);
        } else {
            this.p.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.J != null && this.K != null && this.L != null) {
            this.M = configuration.orientation == 2;
            i();
            int visibility = this.h.getVisibility();
            int visibility2 = this.i.getVisibility();
            int visibility3 = this.j.getVisibility();
            int visibility4 = this.k.getVisibility();
            int visibility5 = this.l.getVisibility();
            int visibility6 = this.m.getVisibility();
            int visibility7 = this.n.getVisibility();
            int visibility8 = this.o.getVisibility();
            int visibility9 = this.p.getVisibility();
            if (configuration.orientation == 1) {
                this.J.b(this.L);
            } else {
                this.K.b(this.L);
            }
            this.h.setVisibility(visibility);
            this.i.setVisibility(visibility2);
            this.j.setVisibility(visibility3);
            this.k.setVisibility(visibility4);
            this.l.setVisibility(visibility5);
            this.m.setVisibility(visibility6);
            this.n.setVisibility(visibility7);
            this.o.setVisibility(visibility8);
            this.p.setVisibility(visibility9);
        }
    }

    /* access modifiers changed from: private */
    public void a(SessionProductEntity.ProductItem productItem) {
        if (this.q != null && productItem != null && productItem.getShop_id() != 0 && productItem.getItem_id() != 0) {
            this.q.a(productItem.getShop_id(), productItem.getItem_id());
        }
    }

    /* access modifiers changed from: private */
    public void b(final SessionProductEntity.ProductItem productItem) {
        if (this.q != null && productItem != null && productItem.getShop_id() != 0 && productItem.getItem_id() != 0) {
            y.a((Activity) getContext(), new y.a() {
                public void b() {
                }

                public void a() {
                    AudienceBottomView.this.q.b(productItem.getShop_id(), productItem.getItem_id());
                }
            });
        }
    }
}
