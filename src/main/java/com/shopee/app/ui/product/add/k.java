package com.shopee.app.ui.product.add;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.facebook.common.time.Clock;
import com.garena.android.appkit.btmsheet.a;
import com.garena.android.appkit.tools.a.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.AddProductInfo;
import com.shopee.app.data.viewmodel.EditCategoryData;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.VMItemAttribute;
import com.shopee.app.data.viewmodel.Variation;
import com.shopee.app.data.viewmodel.VariationData;
import com.shopee.app.h.m;
import com.shopee.app.h.q;
import com.shopee.app.instagram.h;
import com.shopee.app.network.d.ab;
import com.shopee.app.tracking.f;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.auth.IsAuthProxyActivity_;
import com.shopee.app.ui.common.TagEditText2;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.dialog.d;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.ui.product.add.a.a;
import com.shopee.app.ui.product.add.a.b;
import com.shopee.app.ui.product.add.a.c;
import com.shopee.app.ui.product.add.j;
import com.shopee.app.ui.product.add.wholesale.WholesaleTierModel;
import com.shopee.app.ui.product.attributes.t;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.ui.product.b.c;
import com.shopee.app.ui.product.b.d;
import com.shopee.app.ui.product.common.ProductImageControl;
import com.shopee.app.util.af;
import com.shopee.app.util.ak;
import com.shopee.app.util.au;
import com.shopee.app.util.bb;
import com.shopee.app.util.bc;
import com.shopee.app.util.i;
import com.shopee.app.util.k.g;
import com.shopee.app.util.l;
import com.shopee.app.util.q.e;
import com.shopee.app.util.s;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.notification.UpdateItemShippingMessage;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class k extends FrameLayout implements r {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f24080a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f24081b = true;
    RelativeLayout A;
    View B;
    TextView C;
    TextView D;
    View E;
    ScrollView F;
    LinearLayout G;
    View H;
    View I;
    TextView J;
    TextView K;
    View L;
    TextView M;
    View N;
    View O;
    View P;
    LinearLayout Q;
    CompoundButton R;
    TextView S;
    TextView T;
    View U;
    TextView V;
    SwitchCompat W;
    a aA;
    b aB;
    Map<e.C0408e, com.shopee.app.ui.product.add.a.e> aC = new HashMap();
    private AddProductInfo aD;
    private String aE = "";
    private final long aF;
    private boolean aG = true;
    private boolean aH = false;
    /* access modifiers changed from: private */
    public long aI = 0;
    private long aJ = 0;
    private boolean aK = false;
    private h aL;
    private t aM;
    private boolean aN = false;
    private int aO;
    private g aP;
    /* access modifiers changed from: private */
    public ItemDetail aQ;
    private io.b.b.b aR;
    private boolean aS = false;
    private Dialog aT;
    View aa;
    bc ab;
    ak ac;
    Activity ad;
    com.shopee.app.ui.common.r ae;
    e af;
    com.shopee.app.ui.product.twitter.e ag;
    be ah;
    com.shopee.app.application.a.b ai;
    f aj;
    bh ak;
    m al;
    SettingConfigStore am;
    ShareConfigStore an;
    RegionConfig ao;
    SearchKeywordsStore ap;
    com.shopee.app.tracking.a aq;
    s ar;
    UserInfo as;
    d at;
    int au;
    protected AddProductInfo av;
    List<VMItemAttribute> aw;
    protected n ax;
    com.shopee.app.ui.product.add.a.d ay;
    c az;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f24082c;

    /* renamed from: d  reason: collision with root package name */
    TagEditText2 f24083d;

    /* renamed from: e  reason: collision with root package name */
    View f24084e;

    /* renamed from: f  reason: collision with root package name */
    com.shopee.app.ui.common.m f24085f;

    /* renamed from: g  reason: collision with root package name */
    View f24086g;
    com.shopee.app.ui.product.common.a h;
    com.shopee.app.ui.product.common.a i;
    com.shopee.app.ui.product.common.a j;
    com.shopee.app.ui.product.common.a k;
    com.shopee.app.ui.product.common.a l;
    com.shopee.app.ui.product.common.a m;
    t n;
    com.shopee.app.ui.product.common.b o;
    TextView p;
    TextView q;
    com.shopee.app.ui.product.common.a r;
    com.shopee.app.ui.product.common.a s;
    com.shopee.app.ui.product.common.a t;
    LinearLayout u;
    EditText v;
    TextView w;
    RelativeLayout x;
    CompoundButton y;
    ProductImageControl z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(View view) {
    }

    public void X() {
    }

    public void d() {
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return false;
    }

    public k(Context context, long j2) {
        super(context);
        setId(R.id.add_product_root_view);
        this.aF = j2;
        this.av = new AddProductInfo();
        this.aQ = new ItemDetail();
        this.aG = ((Boolean) com.shopee.app.data.store.ak.a().q().b(true)).booleanValue();
        ((d) ((x) context).b()).a(this);
    }

    public void a() {
        this.y.toggle();
        this.x.performClick();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.U.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (!f24081b) {
            ak akVar = this.ac;
            akVar.n(i.f7041d + "m/banreason");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(CompoundButton compoundButton, boolean z2) {
        this.av.setPreOrder(z2);
        if (z2) {
            this.r.setVisibility(0);
            a(this.av.getShippingDays());
        } else {
            this.r.setVisibility(8);
        }
        this.aB.c();
    }

    private ag aa() {
        ag a2 = ah.a(getContext());
        a2.a((TextWatcher) new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                k.this.af.b(k.this.getModelDetails(), k.this.aQ.getWholesaleTiers());
            }
        });
        return a2;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (ai()) {
            this.ac.b(a(this.av.getTierVariations(), getModelDetails(), ac()));
            return;
        }
        ModelDetail modelDetail = new ModelDetail();
        if (this.G.getChildCount() == 0) {
            modelDetail.setDisplayPrice(this.o.getText());
            modelDetail.setDisplayStock(this.s.getText());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.I.getLayoutParams();
            layoutParams.bottomMargin = this.au;
            this.I.setLayoutParams(layoutParams);
        } else if (this.G.getChildCount() >= this.am.getMaxVariations()) {
            a(com.garena.android.appkit.tools.b.a(R.string.sp_error_max_model_reaches2, Integer.valueOf(this.am.getMaxVariations())));
            return;
        } else {
            LinearLayout linearLayout = this.G;
            ag agVar = (ag) linearLayout.getChildAt(linearLayout.getChildCount() - 1);
            modelDetail.setDisplayPrice(agVar.getModelPrice());
            modelDetail.setDisplayStock(agVar.getModelStock());
        }
        ag aa2 = aa();
        aa2.a(modelDetail, ac());
        aa2.setTag(modelDetail);
        this.G.addView(aa2, new FrameLayout.LayoutParams(-1, -2));
        aa2.setAlpha(BitmapDescriptorFactory.HUE_RED);
        aa2.animate().alpha(1.0f).setDuration(500).setListener((Animator.AnimatorListener) null);
        if (this.G.getChildCount() > 0) {
            this.o.animate().scaleY(1.5f).alpha(BitmapDescriptorFactory.HUE_RED).setDuration(500).setListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    k.this.o.setVisibility(8);
                    k.this.o.setScaleY(1.0f);
                }
            });
            this.f24086g.animate().alpha(BitmapDescriptorFactory.HUE_RED).setDuration(500).setListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    k.this.f24086g.setVisibility(8);
                }
            });
            this.s.animate().alpha(BitmapDescriptorFactory.HUE_RED).scaleY(1.5f).setDuration(500).setListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    k.this.H.setTranslationY((float) ((-b.a.m) * 2));
                    k.this.I.setTranslationY((float) ((-b.a.m) * 2));
                    k.this.H.animate().translationYBy((float) (b.a.m * 2)).setDuration(500).setListener(new Animator.AnimatorListener() {
                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                            k.this.H.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                        }
                    });
                    k.this.I.animate().translationYBy((float) (b.a.m * 2)).setDuration(500).setListener(new Animator.AnimatorListener() {
                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                            k.this.I.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                        }
                    });
                }

                public void onAnimationEnd(Animator animator) {
                    k.this.s.setVisibility(8);
                    k.this.s.setScaleY(1.0f);
                }
            });
        }
        this.af.b(getModelDetails(), this.aQ.getWholesaleTiers());
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.ac.a(this.aQ.hasPromotion(), getOriginalPrice(), this.aQ.getWholesaleTiers());
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.ac.c(this.aI, this.aJ);
    }

    public Long getOriginalPrice() {
        List<ModelDetail> modelDetails = getModelDetails();
        if (!af.a(modelDetails)) {
            if (!this.af.b(modelDetails)) {
                return null;
            }
            ModelDetail modelDetail = modelDetails.get(0);
            if (modelDetail.getPriceBeforeDiscount() > 0) {
                return Long.valueOf(modelDetail.getPriceBeforeDiscount());
            }
            return com.shopee.app.g.e.a(modelDetail.getDisplayPrice(), "IDR");
        } else if (this.aQ.hasPromotion()) {
            return Long.valueOf(this.aQ.getPriceBeforeDiscount());
        } else {
            return com.shopee.app.g.e.a(this.o.getText(), "IDR");
        }
    }

    public void a(List<ModelDetail> list) {
        for (ModelDetail next : list) {
            next.setDisplayStock(Integer.toString(next.getStock()));
            next.setDisplayPrice(com.shopee.app.g.e.a(next.getPrice(), "IDR", true));
        }
        this.aE = e(list);
        if (ai()) {
            f(list);
            return;
        }
        for (ModelDetail next2 : list) {
            ag aa2 = aa();
            aa2.setTag(next2);
            aa2.a(next2, ac());
            this.G.addView(aa2, new FrameLayout.LayoutParams(-1, -2));
            if (this.G.getChildCount() > 0) {
                this.o.setVisibility(8);
                this.s.setVisibility(8);
                this.f24086g.setVisibility(8);
            }
        }
    }

    private String e(List<ModelDetail> list) {
        StringBuilder sb = new StringBuilder();
        for (ModelDetail next : list) {
            sb.append(next.getDisplayPrice());
            sb.append(next.getDisplayStock());
            sb.append(next.getName());
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.ax = new n(this.am, this.as);
        this.ab.a(this.af);
        this.af.a(this);
        q();
        ab();
        a(this.ax.a());
        this.z.setEditable(true);
        this.z.setRemoveListener(new ProductImageControl.c() {
            public void a(MediaData mediaData) {
                if (mediaData.isDummy() && mediaData.isVideo()) {
                    k.this.af.j();
                }
            }
        });
        this.af.a(this.al.g().intValue(), this.al.b());
        ae();
        if (this.am.getFbSilentPost()) {
            this.an.getShareOptions().contains("facebook");
        }
        if (this.an.getShareOptions().contains("twitter")) {
            this.x.setVisibility(0);
        }
        int i2 = 8;
        if (!this.an.getShareOptions().contains("facebook") && !this.an.getShareOptions().contains("twitter")) {
            findViewById(R.id.sharing_panel).setVisibility(8);
        }
        if (!this.am.getAllowLogistics() || !this.ao.isFullBuild()) {
            this.m.setVisibility(8);
            this.o.d();
        } else {
            setShippingFee("");
        }
        if (this.am.showProductWeight()) {
            this.m.setHint(com.garena.android.appkit.tools.b.e(R.string.sp_set_shipping_settings));
        } else {
            this.m.setHint(com.garena.android.appkit.tools.b.e(R.string.sp_set_shipping_fee));
        }
        if (this.ao.isFullBuild()) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(8);
            this.s.setText("1000");
        }
        if (this.am.showProductWeight()) {
            this.k.setVisibility(0);
            if (this.am.isProductWeightOptional()) {
                this.k.setSmallText(com.garena.android.appkit.tools.b.e(R.string.sp_label_model_optional));
            }
        } else {
            this.k.setVisibility(8);
        }
        if (this.am.getShowShareFbPage()) {
            this.t.setVisibility(0);
            if (this.ah.p() != null) {
                this.aM = this.ah.p();
                this.t.setText(this.aM.a());
            }
        } else {
            this.t.setVisibility(8);
        }
        if (this.am.isProductDimension()) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
        this.J.setText(getVariationHelpCenterSpannable());
        this.J.setMovementMethod(LinkMovementMethod.getInstance());
        this.v.requestFocus();
        this.v.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    k.this.af.b(k.this.v.getText().toString());
                }
            }
        });
        this.w.setText(com.garena.android.appkit.tools.b.a(R.string.sp_x_out_of_y, 0, Integer.valueOf(this.am.productTitleMaxlen())));
        this.af.e();
        this.ae.a(true);
        if (!this.ar.a("tier_variations")) {
            this.f24085f.setImageResource(R.drawable.ic_add_product_model);
            this.f24085f.setColor(com.garena.android.appkit.tools.b.a(R.color.complement));
        } else {
            this.f24085f.setColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        }
        this.aP = h.a(getContext());
        View view = this.aa;
        if (this.ar.a("delist_product")) {
            i2 = 0;
        }
        view.setVisibility(i2);
    }

    private void ab() {
        this.az = new c(this.z, this.f24082c, this.at);
        this.ay = new com.shopee.app.ui.product.add.a.d(this.v, this.w, this.u, this.f24082c, this.at);
        this.aA = new a(this.f24084e, this.f24083d, this.f24082c, this.at);
        this.aB = new com.shopee.app.ui.product.add.a.b(this.f24082c, this.at, this.Q, this.R, this.r);
        this.aC.put(this.az.d(), this.az);
        this.aC.put(this.ay.d(), this.ay);
        this.aC.put(this.aA.a(), this.aA);
        this.aC.put(this.aB.d(), this.aB);
    }

    public void k() {
        for (e.C0408e eVar : this.aC.keySet()) {
            this.aC.get(eVar).e();
        }
    }

    /* access modifiers changed from: protected */
    public void a(c.a aVar) {
        Map<e.C0408e, com.shopee.app.util.q.d> c2 = aVar.c();
        for (e.C0408e next : c2.keySet()) {
            com.shopee.app.util.q.d dVar = c2.get(next);
            com.shopee.app.ui.product.add.a.e eVar = this.aC.get(next);
            if (eVar != null) {
                eVar.a(dVar);
            }
        }
        if (!aVar.a()) {
            a(aVar.b());
        }
    }

    public void a(long j2) {
        this.aI = j2;
        if (ac()) {
            this.A.setVisibility(0);
        }
    }

    private boolean ac() {
        return this.aI != 0;
    }

    /* access modifiers changed from: package-private */
    public void l() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_delete_product, (int) R.string.sp_label_cancel_capital, (int) R.string.sp_delete_capital, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                k.this.af.c(k.this.aI);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void m() {
        this.ac.b(this.aI, this.aJ);
    }

    /* access modifiers changed from: package-private */
    public void n() {
        if (!this.am.showProductWeight()) {
            this.ac.a(this.aI, this.aJ, false);
        } else if (this.am.isProductWeightOptional()) {
            this.ac.a(this.aI, this.aJ, true);
        } else if (!TextUtils.isEmpty(this.av.getDisplayWeight())) {
            this.k.setBackgroundResource(R.drawable.bottom_border_white_background);
            this.ac.a(this.aI, this.aJ, true);
        } else {
            this.k.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
            d((int) R.string.sp_no_product_weight_err);
        }
    }

    public void o() {
        com.shopee.app.h.r.a().b((int) R.string.sp_delete_success);
        this.ad.finish();
    }

    public void p() {
        if (!this.aN) {
            ad();
        }
    }

    private void ad() {
        t tVar = this.aM;
        this.ac.q(tVar != null ? tVar.c() : "");
    }

    private void ae() {
        this.y.setChecked(((Boolean) com.shopee.app.data.store.f.a().c().b(false)).booleanValue());
        if (this.y.isChecked()) {
            com.shopee.app.data.store.bc.a().d().a(true).v();
            this.y.setChecked(true);
            if (!this.ag.a()) {
                af();
                return;
            }
            return;
        }
        this.y.setChecked(false);
    }

    private void af() {
        this.ag.a(getContext());
    }

    public void q() {
        this.af.a(this.aF);
    }

    /* access modifiers changed from: package-private */
    public void s() {
        f24080a = false;
        b(this.av.isInvalidCategory() ? -1 : this.av.getCategoryId());
    }

    /* access modifiers changed from: package-private */
    public void t() {
        if (com.shopee.app.f.a.a().c()) {
            ad();
            return;
        }
        this.ai.b();
        com.shopee.app.f.a.a().b(this.ad);
        this.aN = false;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        this.af.f();
    }

    /* access modifiers changed from: package-private */
    public void v() {
        com.shopee.app.ui.dialog.d a2 = com.shopee.app.ui.dialog.e.a(getContext());
        a2.setOnClickListener($$Lambda$k$w9V9cU0ACrDYQLzG1DnFqs3pExk.INSTANCE);
        com.garena.android.appkit.btmsheet.a a3 = new a.C0124a(getContext(), R.style.StyleDialog).a((View) a2).a();
        a2.a(0, 100);
        a2.a(com.garena.android.appkit.tools.b.e(R.string.sp_label_shipping_in_days), com.garena.android.appkit.tools.b.a(R.string.sp_shipping_day_not_smaller_7, 0), com.garena.android.appkit.tools.b.e(R.string.sp_shipping_day_max_reached2), new d.a(a3) {
            private final /* synthetic */ Dialog f$1;

            {
                this.f$1 = r2;
            }

            public final void onCheckout(int i) {
                k.this.a(this.f$1, i);
            }
        });
        a2.setCurrentQuantity(this.av.getShippingDays());
        a2.setBottomButton(com.garena.android.appkit.tools.b.e(R.string.sp_label_set));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Dialog dialog, int i2) {
        dialog.dismiss();
        a(i2);
    }

    public void a(int i2) {
        if (i2 == 1) {
            this.r.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_shipping_day));
        } else {
            this.r.setText(com.garena.android.appkit.tools.b.a(R.string.sp_label_shipping_days, Integer.valueOf(i2)));
        }
        this.av.setShippingDays(i2);
        this.r.setTag(Integer.valueOf(i2));
        this.aB.f();
    }

    public void b(int i2) {
        this.ac.a(this.v.getText().toString(), this.ap.getSubCategorySelectHistory(), i2);
        if (!af.a(getRecommendationIds())) {
            this.aS = true;
        }
        this.af.b(this.v.getText().toString());
        this.s.clearFocus();
        this.o.clearFocus();
    }

    public ArrayList<Integer> getRecommendationIds() {
        ArrayList<Integer> catRecommendationIds = this.av.getCatRecommendationIds();
        return (af.a(catRecommendationIds) || !catRecommendationIds.contains(Integer.valueOf(this.av.getCategoryId()))) ? catRecommendationIds : new ArrayList<>();
    }

    public void a(CharSequence[] charSequenceArr) {
        com.shopee.app.ui.dialog.a.a(getContext(), com.garena.android.appkit.tools.b.e(R.string.sp_label_condition), charSequenceArr, (a.c) new a.c() {
            public void a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence) {
                k.this.a(charSequence.toString(), i);
            }
        });
        this.s.clearFocus();
        this.o.clearFocus();
    }

    public void a(String str, int i2) {
        this.i.setText(str);
        this.i.setTag(Integer.valueOf(this.af.c(i2)));
    }

    public void b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String a2 : list) {
            arrayList.add(Integer.valueOf(this.z.a(a2)));
        }
        this.af.a((List<Integer>) arrayList, list);
        this.aK = true;
    }

    public void a(List<String> list, String str) {
        if (!af.a(list)) {
            this.af.a(list.get(0), str);
            this.aK = true;
        }
    }

    public void a(String str, String str2, int i2, int i3, int i4, boolean z2) {
        this.z.a(str, str2, i2, i3, i4, z2);
    }

    public void a(int i2, String str) {
        this.z.a(i2, str);
    }

    @Deprecated
    public void a(j.a aVar, boolean z2) {
        if (aVar.a()) {
            aj();
        } else {
            ak();
        }
        this.n.a();
        if (aVar.b()) {
            this.o.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
        } else {
            this.o.setBackgroundResource(R.drawable.bottom_border_white_background);
        }
        if (aVar.c()) {
            this.s.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
        } else {
            this.s.setBackgroundResource(R.drawable.bottom_border_white_background);
        }
        if (aVar.g()) {
            this.j.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
        } else {
            this.j.setBackgroundResource(R.drawable.bottom_border_white_background);
        }
        if (aVar.h()) {
            this.r.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
        } else {
            this.r.setBackgroundResource(R.drawable.bottom_border_white_background);
        }
        if (aVar.i()) {
            setShippingFee("");
            this.m.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
        } else {
            this.m.setBackgroundResource(R.drawable.bottom_border_white_background);
        }
        if (aVar.j()) {
            this.k.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
        } else {
            this.k.setBackgroundResource(R.drawable.bottom_border_white_background);
        }
        if (aVar.l() && !al()) {
            ag agVar = (ag) this.G.getChildAt(aVar.f24074a - 1);
            if (aVar.d()) {
                agVar.setNameColor(true);
            } else {
                agVar.setNameColor(false);
            }
            if (aVar.e()) {
                agVar.setPriceColor(true);
            } else {
                agVar.setPriceColor(false);
            }
            if (aVar.f()) {
                agVar.setStockColor(true);
            } else {
                agVar.setStockColor(false);
            }
        }
        if (aVar.m()) {
            int childCount = this.G.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ((ag) this.G.getChildAt(i2)).setPriceColor(true);
            }
        }
        if (aVar.n()) {
            this.r.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
        } else {
            this.r.setBackgroundResource(R.drawable.bottom_border_white_background);
        }
        if (z2) {
            a(aVar.o());
        }
    }

    public void a(String str) {
        q.b(this, str);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putBoolean("isSeller", this.aG);
        bundle.putBoolean("isShareToSelfFb", this.aN);
        bundle.putString("originProduct", WebRegister.GSON.b(this.aD, AddProductInfo.class));
        bundle.putBoolean("fbSessionReady", this.aH);
        bundle.putLong("itemId", this.aI);
        bundle.putLong("editId", this.aJ);
        bundle.putBoolean("blockSubmit", this.aK);
        J();
        bundle.putString("previousModels", this.aE);
        bundle.putString("pageInfo", WebRegister.GSON.b(this.aM, t.class));
        bundle.putString("viewState", WebRegister.GSON.b(this.av, AddProductInfo.class));
        bundle.putString("instagramInfoString", WebRegister.GSON.b(this.aL, h.class));
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        if (this.y.isChecked()) {
            this.y.setChecked(false);
        } else if (!this.ag.a()) {
            af();
        } else {
            com.shopee.app.data.store.bc.a().d().a(true).v();
            this.y.setChecked(true);
        }
    }

    public void x() {
        com.shopee.app.data.store.bc.a().d().a(true).v();
        this.y.setChecked(true);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.av = (AddProductInfo) WebRegister.GSON.a(bundle.getString("viewState"), AddProductInfo.class);
            this.aD = (AddProductInfo) WebRegister.GSON.a(bundle.getString("originProduct"), AddProductInfo.class);
            this.aG = bundle.getBoolean("isSeller", true);
            this.aH = bundle.getBoolean("fbSessionReady", true);
            this.aI = bundle.getLong("itemId");
            a(this.aI);
            this.af.b(this.aI);
            this.aJ = bundle.getLong("editId");
            this.aK = bundle.getBoolean("blockSubmit");
            this.aE = bundle.getString("previousModels");
            this.aN = bundle.getBoolean("isShareToSelfFb");
            this.aL = (h) WebRegister.GSON.a(bundle.getString("instagramInfo"), h.class);
            this.aM = (t) WebRegister.GSON.a(bundle.getString("pageInfo"), t.class);
            K();
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void y() {
        if (!getViewState().equals(this.aD) || !this.aE.equals(e(getModelDetails())) || !this.aD.getImages().equals(com.shopee.app.g.d.a((List<String>) this.z.getImagePaths())) || !ag()) {
            this.af.i();
            return;
        }
        this.ad.finish();
        this.af.j();
    }

    private boolean ag() {
        if (af.a(this.z.getVideoPaths())) {
            if (this.aD.getVideo() == null) {
                return true;
            }
            return false;
        } else if (this.aD.getVideo() != null) {
            return this.z.getVideoPaths().get(0).equals(this.aD.getVideo().getPath());
        } else {
            return false;
        }
    }

    public void z() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_product_discard_confirmation, (int) R.string.sp_label_no_capital, (int) R.string.sp_label_discard, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                k.this.ad.finish();
                k.this.af.j();
            }
        });
    }

    public void A() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_edit_product_discard, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, (a.C0318a) new a.C0318a() {
            public void onNegative() {
            }

            public void onPositive() {
                k.this.ad.finish();
            }
        });
    }

    public void setProduct(AddProductInfo addProductInfo) {
        this.av = addProductInfo;
        this.z.setImages(addProductInfo.getImages());
        if (this.z.getImagesCount() > this.z.getMaxImageCount()) {
            U();
        }
        MediaData video = addProductInfo.getVideo();
        if (video != null) {
            this.z.a(video.getThumb(), video.getPath(), video.getStartTime(), video.getDuration(), video.getStatus(), video.isDummy());
        }
        K();
        this.aD = (AddProductInfo) WebRegister.GSON.a(WebRegister.GSON.b(getViewState(), AddProductInfo.class), AddProductInfo.class);
    }

    public AddProductInfo getViewState() {
        J();
        return this.av;
    }

    public AddProductInfo getSubmitState() {
        J();
        this.av.setModelId(this.n.getModelId());
        this.av.setAttributeValues(this.n.getSubmitAttributeValueList());
        return this.av;
    }

    public List<MediaData> getImages() {
        return this.z.getImages();
    }

    public void B() {
        this.ae.a();
    }

    /* access modifiers changed from: package-private */
    public void C() {
        this.h.b();
    }

    /* access modifiers changed from: package-private */
    public void D() {
        this.h.c();
    }

    public void E() {
        this.aP.show();
    }

    public void F() {
        this.ae.b();
        c(100);
    }

    public void c(final int i2) {
        this.ae.a(i2);
        if (i2 <= 95) {
            int i3 = 350;
            if (i2 >= 50 && i2 <= 80) {
                i3 = 700;
            } else if (i2 > 80) {
                i3 = 1000;
            }
            com.garena.android.appkit.f.f.a().a(new Runnable() {
                public void run() {
                    k.this.c(i2 + 1);
                }
            }, i3);
        }
    }

    public void d(int i2) {
        com.shopee.app.h.r.a().b(i2);
    }

    public void G() {
        new ab().a(this.av.getDescription());
        this.ah.a(this.af.a(this.aI, this.av, this.z.getImagePaths().get(0)));
        this.ah.a(this.aM);
        if (!(this.aI == 0)) {
            I();
            return;
        }
        int a2 = this.af.a(!this.ah.i());
        if (a2 == 0) {
            this.ah.c(0);
            I();
        } else if (a2 == 1) {
            this.ah.c(1);
            I();
        } else if (a2 == 2) {
            ah();
        } else if (a2 == 3) {
            ah();
        }
    }

    private void ah() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_msg_post_product_verify_phone, (int) R.string.sp_label_later, (int) R.string.sp_label_ok, (a.C0318a) new a.C0318a() {
            public void onPositive() {
                k.this.ah.c(2);
                IsAuthProxyActivity_.a(k.this.getContext()).b(0).a(true).a(561);
            }

            public void onNegative() {
                k.this.ah.c(2);
                k.this.I();
            }
        });
    }

    public void H() {
        int a2 = this.af.a(!this.ah.i());
        if (a2 == 2) {
            this.ah.c(0);
        } else if (a2 == 3) {
            this.ah.c(1);
        }
        I();
    }

    public void I() {
        this.ae.b();
        this.ac.i("sellingPage");
        this.ad.finish();
    }

    public void J() {
        this.av.setName(this.v.getText().toString().trim());
        this.av.setDescription(this.f24083d.getText().toString());
        this.av.setCategory(this.h.getText());
        this.av.setCategoryId(a(this.h.getTag(R.id.category_id)));
        this.av.setPrice(this.o.getText());
        this.av.setStock(this.s.getText());
        this.av.setBrand(this.j.getText());
        this.av.setCondition(this.i.getText());
        boolean z2 = false;
        this.av.setConditionId(a(this.i.getTag(), 0));
        this.av.setShippingDays(a(this.r.getTag()));
        this.av.setDisplayWeight(this.k.getText());
        this.av.setWeight(com.shopee.app.d.b.b.a((Long) this.k.getTag(), 0));
        if (this.l.getTag() != null) {
            this.av.setDimension((AddProductInfo.Dimension) this.l.getTag());
        }
        this.av.setDisplayLogisticInfo(this.m.getText());
        if (this.W.getVisibility() == 0 && !this.W.isChecked()) {
            z2 = true;
        }
        this.av.setDeListProduct(z2);
        if (this.n.getModelId() != 0) {
            this.av.setModelId(a((Object) Integer.valueOf(this.n.getModelId())));
            ArrayList arrayList = new ArrayList(this.n.getAttributeValueList());
            if (!af.a(arrayList)) {
                this.av.setAttributeValues(arrayList);
            }
        }
    }

    public void K() {
        this.v.setText(this.av.getName());
        EditText editText = this.v;
        editText.setSelection(editText.length());
        this.f24083d.setText(this.av.getDescription());
        this.h.setText(this.av.getCategory());
        this.h.setTag(R.id.category_id, Integer.valueOf(this.av.getCategoryId()));
        this.o.setText(this.av.getPrice());
        this.s.setText(this.av.getStock());
        this.j.setText(this.av.getBrand());
        this.i.setText(this.av.getCondition());
        this.i.setTag(Integer.valueOf(this.av.getConditionId()));
        setShippingFee(this.av.getDisplayLogisticInfo());
        this.k.setText(this.av.getDisplayWeight());
        this.k.setTag(Long.valueOf(this.av.getWeight()));
        if (this.av.getDimension() != null) {
            this.l.setText(this.av.getDimension().displayDimension);
            this.l.setTag(this.av.getDimension());
        }
        if (this.av.getShippingDays() != 0) {
            a(this.av.getShippingDays());
        }
        this.af.e(this.aQ.getWholesaleTiers());
        this.R.setChecked(this.av.isPreOrder());
        f(getModelDetails());
        this.W.setChecked(!this.av.isDeListProduct());
        this.aB.a(this.av.getCategoryIdPath());
    }

    public void L() {
        if (this.av.getModelId() <= 0 || af.a(this.av.getAttributeValues())) {
            this.n.b();
        } else {
            this.n.setSelectAttributeData(this.av.getAttributeValues());
        }
    }

    public void e(int i2) {
        this.n.a(i2, new ArrayList());
    }

    public void f(int i2) {
        this.av.setModelId(i2);
        this.av.setAttributeValues((List<u>) null);
        b(i2, (List<VMItemAttribute>) new ArrayList());
    }

    public int a(Object obj) {
        if (obj == null) {
            return -1;
        }
        return ((Integer) obj).intValue();
    }

    public int a(Object obj, int i2) {
        if (obj != null) {
            Integer num = (Integer) obj;
            if (num.intValue() >= 0) {
                return num.intValue();
            }
        }
        return i2;
    }

    public void b(String str) {
        q.a((View) this, str);
    }

    public void a(UpdateItemShippingMessage updateItemShippingMessage) {
        this.aJ = updateItemShippingMessage.getEditID();
        String displayWeight = updateItemShippingMessage.getDisplayWeight();
        if (!TextUtils.isEmpty(displayWeight)) {
            this.k.setText(displayWeight);
            this.k.setTag(Long.valueOf(updateItemShippingMessage.getWeight()));
            this.av.setDisplayWeight(displayWeight);
            this.av.setWeight(updateItemShippingMessage.getWeight());
        }
        if (updateItemShippingMessage.getHeight() != -1) {
            String displayDimension = updateItemShippingMessage.getDisplayDimension();
            AddProductInfo.Dimension a2 = new com.shopee.app.d.a.b().a(updateItemShippingMessage);
            this.l.setText(displayDimension);
            this.l.setTag(a2);
            this.av.setDimension(a2);
        }
        String logisticsInfo = updateItemShippingMessage.getLogisticsInfo();
        if (!TextUtils.isEmpty(logisticsInfo)) {
            this.av.setLogisticInfo(logisticsInfo);
        }
        String displayedShippingInfo = updateItemShippingMessage.getDisplayedShippingInfo();
        if (!TextUtils.isEmpty(displayedShippingInfo)) {
            setShippingFee(displayedShippingInfo);
            this.av.setDisplayLogisticInfo(displayedShippingInfo);
        }
    }

    private void setShippingFee(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.m.setText(str);
        } else if (this.am.showProductWeight()) {
            this.m.setText("");
        } else {
            this.m.setText(com.garena.android.appkit.tools.b.e(R.string.sp_label_shipping_fee_included));
        }
    }

    public void M() {
        this.aK = false;
    }

    public boolean N() {
        return this.aK;
    }

    public void a(ShopDetail shopDetail) {
        if (TextUtils.isEmpty(this.av.getLogisticInfo()) && this.am.getAllowLogistics() && !TextUtils.isEmpty(shopDetail.getDefaultItemLogisticInfo())) {
            if (this.aI != 0) {
                setShippingFee("");
            } else if (!this.am.showProductWeight()) {
                this.av.setDisplayLogisticInfo(shopDetail.getDisplayShippingFee());
                setShippingFee(shopDetail.getDisplayShippingFee());
                this.av.setLogisticInfo(shopDetail.getDefaultItemLogisticInfo());
            } else {
                setShippingFee("");
            }
        }
    }

    public void setInstagramInfo(String str) {
        this.aL = (h) WebRegister.GSON.a(str, h.class);
        if (!TextUtils.isEmpty(this.aL.e()) && TextUtils.isEmpty(this.f24083d.getText().toString())) {
            this.f24083d.setText(this.aL.e());
        }
    }

    public String getInstagramId() {
        h hVar = this.aL;
        if (hVar != null) {
            return hVar.d();
        }
        return null;
    }

    public void setCategoryRN(List<EditCategoryData.EditCategory> list) {
        int i2 = list.get(list.size() - 1).catId;
        this.h.setTag(R.id.category_id, Integer.valueOf(i2));
        this.av.setCategoryId(i2);
        List<Integer> a2 = g.a(list);
        this.av.setCategoryIdPath(a2);
        this.aB.a(a2);
        this.ap.addSubCategorySelectHistory(Integer.valueOf(i2));
        this.af.a(list);
    }

    public void O() {
        postDelayed(new Runnable() {
            public void run() {
                com.shopee.app.c.a.a(k.this.getContext());
            }
        }, 400);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i5 - i3 >= l.p) {
            postDelayed(new Runnable() {
                @SuppressLint({"ClickableViewAccessibility"})
                public void run() {
                    k.this.f24083d.setMaxLines(5);
                    k.this.f24083d.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (view.getId() == R.id.hash_tag_view) {
                                view.getParent().requestDisallowInterceptTouchEvent(true);
                                if ((motionEvent.getAction() & 255) == 1) {
                                    view.getParent().requestDisallowInterceptTouchEvent(false);
                                }
                            }
                            return false;
                        }
                    });
                }
            }, 400);
        }
    }

    public boolean P() {
        return this.aS;
    }

    public void a(final ag agVar) {
        if (this.G.getChildCount() <= 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.I.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.I.setLayoutParams(layoutParams);
            agVar.animate().alpha(BitmapDescriptorFactory.HUE_RED).scaleY(0.667f).setDuration(500).setListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                    k.this.H.animate().translationYBy((float) (b.a.f7690a - (b.a.m * 2))).setDuration(500).setListener(new Animator.AnimatorListener() {
                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                            k.this.H.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                        }
                    });
                    k.this.I.animate().translationYBy((float) (b.a.f7690a - (b.a.m * 2))).setDuration(500).setListener(new Animator.AnimatorListener() {
                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                            k.this.I.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                        }
                    });
                }

                public void onAnimationEnd(Animator animator) {
                    k.this.G.removeView(agVar);
                    k.this.af.b(k.this.getModelDetails(), k.this.aQ.getWholesaleTiers());
                }
            });
            this.f24086g.setVisibility(0);
            this.o.setVisibility(0);
            if (this.ao.isFullBuild()) {
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
            this.o.animate().alpha(1.0f).setDuration(500).setListener((Animator.AnimatorListener) null);
            this.f24086g.animate().alpha(1.0f).setDuration(500).setListener((Animator.AnimatorListener) null);
            this.s.animate().alpha(1.0f).setDuration(500).setListener((Animator.AnimatorListener) null);
            this.o.setText(agVar.getModelPrice());
            this.s.setText(agVar.getModelStock());
            return;
        }
        agVar.animate().alpha(BitmapDescriptorFactory.HUE_RED).scaleY(0.667f).setDuration(500).setListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                k.this.G.removeView(agVar);
                k.this.af.b(k.this.getModelDetails(), k.this.aQ.getWholesaleTiers());
            }
        });
    }

    private boolean ai() {
        return this.ar.a("tier_variations");
    }

    public List<ModelDetail> getModelDetails() {
        if (ai()) {
            return this.aQ.getModelDetails();
        }
        ArrayList arrayList = new ArrayList();
        if (this.G.getChildCount() > 0) {
            for (int i2 = 0; i2 < this.G.getChildCount(); i2++) {
                ag agVar = (ag) this.G.getChildAt(i2);
                ModelDetail modelDetail = (ModelDetail) agVar.getTag();
                modelDetail.setDisplayPrice(agVar.getModelPrice());
                modelDetail.setDisplayStock(agVar.getModelStock());
                modelDetail.setName(agVar.getModelName());
                arrayList.add(modelDetail);
            }
        }
        return arrayList;
    }

    public void Q() {
        if (this.G.getChildCount() > 0) {
            for (int i2 = 0; i2 < this.G.getChildCount(); i2++) {
                ag agVar = (ag) this.G.getChildAt(i2);
                agVar.setPriceColor(false);
                agVar.setStockColor(false);
                agVar.setNameColor(false);
            }
        }
    }

    public void a(double d2) {
        this.z.a(d2);
    }

    public void setPageInfo(t tVar) {
        this.aM = tVar;
        this.t.setText(tVar.a());
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, List<VMItemAttribute> list) {
        this.aO = i2;
        this.aw = list;
        this.n.a(i2, list);
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, List<VMItemAttribute> list) {
        this.aO = i2;
        this.aw = list;
        this.n.c(i2, list);
    }

    public void a(u uVar, int i2) {
        a(this.aO, uVar);
        if (uVar.f()) {
            this.n.a(uVar);
            this.af.d(this.av.getAttributeValues());
        }
    }

    public void a(int i2, u uVar) {
        if (i2 == this.aO) {
            J();
            this.av.setModelId(i2);
            ArrayList arrayList = new ArrayList();
            List<u> attributeValues = this.av.getAttributeValues();
            if (attributeValues == null) {
                arrayList.add(uVar);
            } else {
                SparseArray sparseArray = new SparseArray(attributeValues.size());
                for (u next : attributeValues) {
                    sparseArray.put(next.a(), next);
                }
                List<VMItemAttribute> list = this.aw;
                if (list != null) {
                    com.garena.android.appkit.d.a.b(list.toString(), new Object[0]);
                    for (VMItemAttribute attrId : this.aw) {
                        int attrId2 = attrId.getAttrId();
                        if (sparseArray.get(attrId2) != null) {
                            u uVar2 = (u) sparseArray.get(attrId2);
                            if (uVar2.a() == uVar.a()) {
                                com.garena.android.appkit.d.a.b("%s found, user new value %s", uVar2.toString(), uVar.toString());
                                if (!TextUtils.isEmpty(uVar.b())) {
                                    arrayList.add(uVar);
                                }
                            } else {
                                com.garena.android.appkit.d.a.b("%s found, use old value %s", uVar2.toString(), uVar2.toString());
                                arrayList.add(uVar2);
                            }
                        } else if (attrId2 == uVar.a()) {
                            com.garena.android.appkit.d.a.b("%s not found, add as new ", uVar.toString());
                            arrayList.add(uVar);
                            sparseArray.put(attrId2, uVar);
                        }
                    }
                }
            }
            this.av.setAttributeValues(arrayList);
            L();
        }
    }

    public void b(int i2, u uVar) {
        a(i2, uVar);
    }

    public void b() {
        com.shopee.app.c.a.a(getContext());
    }

    public void c() {
        io.b.b.b bVar = this.aR;
        if (bVar != null && !bVar.isDisposed()) {
            this.aR.dispose();
        }
    }

    public void c(List<WholesaleTierModel> list) {
        this.af.e(list);
    }

    public void c(String str) {
        this.K.setText(str);
    }

    public void d(List<WholesaleTierModel> list) {
        this.aQ.setWholesaleTiers(list);
    }

    public void R() {
        this.L.setEnabled(false);
        this.K.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black26));
        this.M.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black26));
    }

    public void S() {
        this.L.setEnabled(true);
        this.K.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
        this.M.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black87));
    }

    public void setItemDetail(ItemDetail itemDetail) {
        this.aQ = itemDetail;
    }

    public List<WholesaleTierModel> getWholesaleTiers() {
        return this.aQ.getWholesaleTiers();
    }

    public void T() {
        this.L.setVisibility(8);
        this.P.setVisibility(8);
        this.N.setVisibility(8);
        this.O.setVisibility(8);
    }

    public void a(j.b bVar, a.C0318a aVar) {
        if (bVar.a()) {
            com.shopee.app.ui.dialog.a.a(getContext(), bVar.b(), com.garena.android.appkit.tools.b.e(R.string.sp_label_cancel), com.garena.android.appkit.tools.b.e(R.string.sp_label_ok), aVar);
        }
    }

    public void U() {
        Dialog dialog = this.aT;
        if (dialog == null || !dialog.isShowing()) {
            this.aT = com.shopee.app.ui.dialog.a.a(getContext(), "", com.garena.android.appkit.tools.b.e(R.string.sp_exceed_images_cap_message), 0, (int) R.string.sp_label_ok);
        }
    }

    public void a(Spannable spannable) {
        this.U.setVisibility(0);
        this.T.setText(spannable);
    }

    private void aj() {
        this.h.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
    }

    private void ak() {
        this.h.setBackgroundResource(R.drawable.white_background_hightlight);
    }

    public void V() {
        this.h.f24612d.setTextColor(com.garena.android.appkit.tools.b.a(R.color.primary));
        if (this.aR == null) {
            this.aR = io.b.j.a(1, TimeUnit.SECONDS).a(new io.b.d.f<Long>() {
                /* renamed from: a */
                public void accept(Long l) throws Exception {
                    k.this.aq.b((long) k.this.aQ.getShopId(), k.this.aQ.getId());
                }
            }, (io.b.d.f<? super Throwable>) bb.a());
        }
    }

    public void W() {
        this.h.f24612d.setTextColor(com.garena.android.appkit.tools.b.a(R.color.black));
    }

    private boolean al() {
        return !af.a(this.av.getTierVariations()) || !af.a(getModelDetails());
    }

    public void Y() {
        if (ai() && al()) {
            this.ac.a(a(this.av.getTierVariations(), getModelDetails(), ac()));
        }
    }

    public void Z() {
        if (ai() && al()) {
            this.ac.a(a(this.av.getTierVariations(), getModelDetails(), ac()));
        }
    }

    public List<Variation> getTierVariations() {
        if (af.a(this.av.getTierVariations())) {
            return Collections.emptyList();
        }
        return this.av.getTierVariations();
    }

    private VariationData a(List<Variation> list, List<ModelDetail> list2, boolean z2) {
        try {
            com.shopee.app.ui.product.b.a.g gVar = (com.shopee.app.ui.product.b.a.g) this.at.b().a(e.C0408e.STOCK);
            com.shopee.app.ui.product.b.a.f fVar = (com.shopee.app.ui.product.b.a.f) this.at.b().a(e.C0408e.PRICE);
            return new VariationData(list, list2, fVar.b(), fVar.a(), gVar.b(), gVar.a(), z2);
        } catch (Exception unused) {
            return new VariationData(list, list2, 0, 0, 0, 0, z2);
        }
    }

    private void f(List<ModelDetail> list) {
        if (af.a(list)) {
            this.o.setType(3);
            this.s.setType(2);
            this.V.setText("");
            return;
        }
        this.o.setType(1);
        this.s.setType(1);
        this.V.setText(list.get(0).getName());
        long j2 = Clock.MAX_TIME;
        long j3 = 0;
        int i2 = 0;
        for (ModelDetail next : list) {
            j2 = Math.min(j2, next.getPrice());
            j3 = Math.max(j3, next.getPrice());
            i2 += next.getStock();
        }
        if (j2 == j3) {
            this.o.setText(au.b(j2));
        } else {
            this.o.setText(au.b(j2) + "-" + com.shopee.app.g.e.a(j3, "IDR", false));
        }
        this.s.setText(String.valueOf(i2));
    }

    public void a(List<Variation> list, List<ModelDetail> list2) {
        a(list2);
        this.aQ.setModelDetails(list2);
        this.av.setTierVariations(list);
        this.af.b(getModelDetails(), this.aQ.getWholesaleTiers());
        f(list2);
    }

    public void g(int i2) {
        if (i2 > 0) {
            this.z.setMaxImageCount(i2);
            if (this.z.getImagesCount() > i2) {
                U();
            }
        }
    }

    private SpannedString getVariationHelpCenterSpannable() {
        String str = com.garena.android.appkit.tools.b.e(R.string.label_how_to_create_product_variations) + SQLBuilder.BLANK;
        String e2 = com.garena.android.appkit.tools.b.e(R.string.label_view_help_center);
        AnonymousClass10 r2 = new ClickableSpan() {
            public void updateDrawState(TextPaint textPaint) {
            }

            public void onClick(View view) {
                k.this.ac.t("LISTING_GUIDE");
            }
        };
        SpannableString spannableString = new SpannableString(e2);
        spannableString.setSpan(r2, 0, e2.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(com.garena.android.appkit.tools.b.a(R.color.url)), 0, e2.length(), 33);
        return new SpannedString(new SpannableStringBuilder().append(str).append(spannableString));
    }
}
