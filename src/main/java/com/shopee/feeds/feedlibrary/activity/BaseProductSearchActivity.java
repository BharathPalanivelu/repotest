package com.shopee.feeds.feedlibrary.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.d.a.f;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.android.appkit.tools.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.feeds.feedlibrary.adapter.SearchChooseProductAdapter;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.FinishPdListEntity;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.util.b.d;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.l;
import com.shopee.feeds.feedlibrary.view.SearchLoadMoreRecycyleView;
import com.shopee.feeds.feedlibrary.view.SearchLoadingView;
import com.shopee.feeds.feedlibrary.view.a.e;
import com.shopee.feeds.feedlibrary.view.edittext.CustomSearchEditText;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public abstract class BaseProductSearchActivity<T> extends a implements e {
    static int p;
    private LinearLayout A;
    private RobotoTextView B;
    private ImageView C;
    private RobotoTextView D;
    private ImageView E;
    private RobotoTextView F;
    private ImageView G;
    private LinearLayout H;
    private View I;
    private RobotoTextView J;
    private ImageView K;
    private RobotoTextView L;
    private ImageView M;
    private RelativeLayout N;
    private RelativeLayout O;
    private LinearLayout P;
    private RobotoTextView Q;
    private RobotoTextView R;
    private RobotoTextView S;
    private RobotoTextView T;
    private View U;
    private RobotoTextView V;
    private ImageView W;
    private RobotoTextView X;
    private ImageView Y;
    private RobotoTextView Z;
    private ImageView aa;
    private RobotoTextView ab;
    private RelativeLayout ac;
    private LinearLayout ad;
    /* access modifiers changed from: private */
    public boolean ae = false;
    private ArrayList<T> af = new ArrayList<>();
    private int ag = -1;
    private boolean ah = false;
    private boolean ai = false;
    /* access modifiers changed from: private */
    public GridLayoutManager aj;

    /* renamed from: c  reason: collision with root package name */
    protected LinearLayout f7058c;

    /* renamed from: d  reason: collision with root package name */
    protected LinearLayout f7059d;

    /* renamed from: e  reason: collision with root package name */
    com.shopee.feeds.feedlibrary.b.e f7060e;
    @BindView
    CustomSearchEditText etSearch;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<ProductEntity.ProductItem> f7061f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    protected com.shopee.feeds.feedlibrary.data.e.a f7062g = new com.shopee.feeds.feedlibrary.data.e.a();
    protected LinearLayout h;
    protected boolean i = false;
    @BindView
    ImageView ivSearchCancel;
    protected SearchChooseProductAdapter j;
    protected f k;
    protected String l = "";
    protected d m;
    @BindView
    SearchLoadingView mSearchLoadingView;
    protected int n = -1;
    protected boolean o = false;
    private RobotoTextView q;
    private ImageView r;
    @BindView
    SearchLoadMoreRecycyleView recyclerView;
    private RobotoTextView s;
    @BindView
    View searchEtBg;
    private RobotoTextView t;
    @BindView
    TextView tvCancel;
    @BindView
    TextView tvNoResult;
    private RobotoTextView u;
    private ImageView v;
    private View w;
    private View x;
    private View y;
    private View z;

    public interface a {
        void a();
    }

    public abstract void a(Object obj);

    public abstract void a(boolean z2, String str);

    public void f() {
    }

    public abstract SearchChooseProductAdapter i();

    private void j() {
        this.ac = (RelativeLayout) findViewById(c.e.search_container);
        this.q = (RobotoTextView) findViewById(c.e.relevance_tx);
        this.r = (ImageView) findViewById(c.e.rel_img);
        this.ad = (LinearLayout) findViewById(c.e.recyle_layout);
        this.s = (RobotoTextView) findViewById(c.e.latest_tv);
        this.t = (RobotoTextView) findViewById(c.e.sales_tv);
        this.u = (RobotoTextView) findViewById(c.e.price_tv);
        this.v = (ImageView) findViewById(c.e.price_img);
        this.w = findViewById(c.e.relevance_line);
        this.x = findViewById(c.e.latest_line);
        this.y = findViewById(c.e.sales_line);
        this.z = findViewById(c.e.price_line);
        this.H = (LinearLayout) findViewById(c.e.sub_select_layout);
        this.I = findViewById(c.e.shadow_view);
        this.J = (RobotoTextView) findViewById(c.e.sub_first_text);
        this.K = (ImageView) findViewById(c.e.sub_first_img);
        this.L = (RobotoTextView) findViewById(c.e.sub_second_text);
        this.M = (ImageView) findViewById(c.e.sub_second_img);
        this.N = (RelativeLayout) findViewById(c.e.sub_first_layout);
        this.O = (RelativeLayout) findViewById(c.e.sub_second_layout);
        this.f7059d = (LinearLayout) findViewById(c.e.no_result_container);
        this.P = (LinearLayout) findViewById(c.e.no_network_layout);
        this.ab = (RobotoTextView) findViewById(c.e.try_again);
        this.U = findViewById(c.e.tab_layout);
        this.h = (LinearLayout) findViewById(c.e.fake_fileter_layout);
        this.h.setBackgroundColor(b.a(c.b.feeds_search_filter_bg_color));
        this.V = (RobotoTextView) this.h.findViewById(c.e.mall_tx);
        this.W = (ImageView) this.h.findViewById(c.e.mall_img);
        this.X = (RobotoTextView) this.h.findViewById(c.e.prefer_tx);
        this.Y = (ImageView) this.h.findViewById(c.e.prefer_img);
        this.Z = (RobotoTextView) this.h.findViewById(c.e.time_tx);
        this.aa = (ImageView) this.h.findViewById(c.e.time_img);
        this.V.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseProductSearchActivity.this.c("mall");
                if (BaseProductSearchActivity.this.f7062g.f27741d.contains("mall")) {
                    com.shopee.feeds.feedlibrary.util.b.e.a("mall", true, BaseProductSearchActivity.this.f7062g);
                } else {
                    com.shopee.feeds.feedlibrary.util.b.e.a("mall", false, BaseProductSearchActivity.this.f7062g);
                }
                BaseProductSearchActivity.this.i = true;
            }
        });
        this.X.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseProductSearchActivity.this.c("preferred");
                if (BaseProductSearchActivity.this.f7062g.f27741d.contains("preferred")) {
                    com.shopee.feeds.feedlibrary.util.b.e.a("preferred", true, BaseProductSearchActivity.this.f7062g);
                } else {
                    com.shopee.feeds.feedlibrary.util.b.e.a("preferred", false, BaseProductSearchActivity.this.f7062g);
                }
                BaseProductSearchActivity.this.i = true;
            }
        });
        this.Z.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseProductSearchActivity.this.c("24H");
                if (BaseProductSearchActivity.this.f7062g.f27741d.contains("24H")) {
                    com.shopee.feeds.feedlibrary.util.b.e.a("24h", true, BaseProductSearchActivity.this.f7062g);
                } else {
                    com.shopee.feeds.feedlibrary.util.b.e.a("24h", false, BaseProductSearchActivity.this.f7062g);
                }
                BaseProductSearchActivity.this.i = true;
            }
        });
        this.Q = (RobotoTextView) findViewById(c.e.no_net_main_tx);
        this.R = (RobotoTextView) findViewById(c.e.no_net_sub_tx);
        this.S = (RobotoTextView) findViewById(c.e.empty_main_tx);
        this.T = (RobotoTextView) findViewById(c.e.empty_sub_tx);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        c();
        super.onCreate(bundle);
        setContentView(c.f.feeds_activity_product_search);
        j();
        ButterKnife.a((Activity) this);
        org.greenrobot.eventbus.c.a().c(this);
        this.f7060e = new com.shopee.feeds.feedlibrary.b.e(this.f7086a);
        this.f7060e.a(this);
        k();
        this.m = new d(this.f7086a, this.recyclerView, 1, false);
        this.m.a((d.a) new d.a() {
            public void a(int i) {
                int i2 = i - 1;
                if (i2 > BaseProductSearchActivity.this.n) {
                    BaseProductSearchActivity.this.n = i2;
                }
                BaseProductSearchActivity.this.a(i2);
            }
        });
        this.m.a();
        this.ah = true;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        ArrayList arrayList = (ArrayList) this.j.b();
        if (arrayList != null && arrayList.size() > 0 && i2 < arrayList.size() && i2 >= 0) {
            ProductEntity.ProductItem productItem = (ProductEntity.ProductItem) arrayList.get(i2);
            com.shopee.feeds.feedlibrary.util.b.e.a(productItem.getItem_id(), productItem.getShop_id(), i2, this.etSearch.getCurKeywords(), this.f7062g);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        com.shopee.feeds.feedlibrary.util.b.e.j(this.ah);
        this.ah = false;
    }

    public void a(boolean z2) {
        LinearLayout.LayoutParams layoutParams;
        if (z2) {
            layoutParams = new LinearLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        this.ad.setLayoutParams(layoutParams);
    }

    private void k() {
        com.shopee.feeds.feedlibrary.data.e.a aVar = this.f7062g;
        aVar.f27742e = true;
        aVar.f27738a = 0;
        aVar.f27741d.clear();
        com.shopee.feeds.feedlibrary.data.e.a aVar2 = this.f7062g;
        aVar2.f27740c = -1;
        aVar2.f27739b = 0;
        this.q.setTextColor(b.a(c.b.main_color));
        this.w.setBackgroundColor(b.a(c.b.main_color));
        this.J.setTextColor(b.a(c.b.main_color));
        this.K.setVisibility(0);
    }

    private void l() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f7086a).inflate(c.f.feeds_activity_product_filter, (ViewGroup) null, false);
        this.B = (RobotoTextView) linearLayout.findViewById(c.e.mall_tx);
        this.C = (ImageView) linearLayout.findViewById(c.e.mall_img);
        this.D = (RobotoTextView) linearLayout.findViewById(c.e.prefer_tx);
        this.E = (ImageView) linearLayout.findViewById(c.e.prefer_img);
        this.F = (RobotoTextView) linearLayout.findViewById(c.e.time_tx);
        this.G = (ImageView) linearLayout.findViewById(c.e.time_img);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.a(36, this.f7086a));
        layoutParams.topMargin = l.a(6, this.f7086a);
        layoutParams.bottomMargin = l.a(6, this.f7086a);
        this.A = new LinearLayout(this.f7086a);
        this.A.addView(linearLayout, layoutParams);
        this.j.a((View) this.A);
        this.B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseProductSearchActivity.this.c("mall");
                if (BaseProductSearchActivity.this.f7062g.f27741d.contains("mall")) {
                    com.shopee.feeds.feedlibrary.util.b.e.a("mall", true, BaseProductSearchActivity.this.f7062g);
                } else {
                    com.shopee.feeds.feedlibrary.util.b.e.a("mall", false, BaseProductSearchActivity.this.f7062g);
                }
                BaseProductSearchActivity.this.i = true;
            }
        });
        this.D.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseProductSearchActivity.this.c("preferred");
                if (BaseProductSearchActivity.this.f7062g.f27741d.contains("preferred")) {
                    com.shopee.feeds.feedlibrary.util.b.e.a("preferred", true, BaseProductSearchActivity.this.f7062g);
                } else {
                    com.shopee.feeds.feedlibrary.util.b.e.a("preferred", false, BaseProductSearchActivity.this.f7062g);
                }
                BaseProductSearchActivity.this.i = true;
            }
        });
        this.F.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseProductSearchActivity.this.c("24H");
                if (BaseProductSearchActivity.this.f7062g.f27741d.contains("24H")) {
                    com.shopee.feeds.feedlibrary.util.b.e.a("24h", true, BaseProductSearchActivity.this.f7062g);
                } else {
                    com.shopee.feeds.feedlibrary.util.b.e.a("24h", false, BaseProductSearchActivity.this.f7062g);
                }
                BaseProductSearchActivity.this.i = true;
            }
        });
        this.A.setBackgroundColor(b.a(c.b.feeds_search_filter_bg_color));
    }

    private void m() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f7086a).inflate(c.f.feeds_activity_product_no_more, (ViewGroup) null, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        ((RobotoTextView) linearLayout.findViewById(c.e.no_more_tx)).setText(b.e(c.g.feeds_search_no_more_products_found));
        this.f7058c = new LinearLayout(this.f7086a);
        this.f7058c.addView(linearLayout, layoutParams);
        this.j.b((View) this.f7058c);
    }

    private void n() {
        GridLayoutManager gridLayoutManager = this.aj;
        if (gridLayoutManager != null) {
            gridLayoutManager.b(0, 0);
        }
    }

    public void h() {
        this.aj = new GridLayoutManager(this.f7086a, 2);
        this.recyclerView.setLayoutManager(this.aj);
        this.j = i();
        this.recyclerView.setAdapter(this.j);
        l();
        this.j.notifyDataSetChanged();
        a("", true);
        this.aj.a((GridLayoutManager.c) new GridLayoutManager.c() {
            public int a(int i) {
                if (BaseProductSearchActivity.this.j.a(i) || BaseProductSearchActivity.this.j.b(i)) {
                    return BaseProductSearchActivity.this.aj.b();
                }
                return 1;
            }
        });
        this.etSearch.setSearchType(17);
        CustomSearchEditText customSearchEditText = this.etSearch;
        customSearchEditText.setHint(SQLBuilder.BLANK + b.e(c.g.feeds_search_placeholder));
        this.etSearch.a((List<?>) this.af, (com.shopee.feeds.feedlibrary.adapter.a) this.j);
        this.etSearch.setOnSearchListener(new CustomSearchEditText.a() {
            public void a(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void b(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void a(Editable editable) {
                if (BaseProductSearchActivity.this.etSearch.getCurKeywords().length() > 0) {
                    BaseProductSearchActivity.this.ivSearchCancel.setVisibility(0);
                    return;
                }
                BaseProductSearchActivity.this.ivSearchCancel.setVisibility(8);
                BaseProductSearchActivity.this.mSearchLoadingView.setVisibility(8);
                BaseProductSearchActivity.this.tvNoResult.setVisibility(8);
            }

            public void a(String str, int i) {
                BaseProductSearchActivity.this.a(str, false);
                com.shopee.feeds.feedlibrary.util.b.e.a(str, BaseProductSearchActivity.this.f7062g);
                BaseProductSearchActivity.this.o();
                boolean unused = BaseProductSearchActivity.this.ae = true;
            }
        });
        this.etSearch.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    com.shopee.feeds.feedlibrary.util.d.a(BaseProductSearchActivity.this.etSearch.getCurKeywords());
                }
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                BaseProductSearchActivity.this.etSearch.setCursorVisible(true);
                return false;
            }
        });
        this.etSearch.setImeOptions(3);
        this.etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i != 3 && i != 0) || com.shopee.feeds.feedlibrary.util.d.a(BaseProductSearchActivity.this.etSearch.getCurKeywords())) {
                    return true;
                }
                BaseProductSearchActivity.this.etSearch.setSelection(BaseProductSearchActivity.this.etSearch.getCurKeywords().length());
                BaseProductSearchActivity.this.etSearch.setCursorVisible(false);
                com.shopee.feeds.feedlibrary.util.d.a((Activity) BaseProductSearchActivity.this);
                com.shopee.feeds.feedlibrary.util.b.e.a(BaseProductSearchActivity.this.etSearch.getCurKeywords(), BaseProductSearchActivity.this.f7062g);
                BaseProductSearchActivity baseProductSearchActivity = BaseProductSearchActivity.this;
                baseProductSearchActivity.a(baseProductSearchActivity.etSearch.getCurKeywords(), false);
                return true;
            }
        });
        com.shopee.feeds.feedlibrary.util.d.a(this, this.recyclerView, this.etSearch, new a() {
            public void a() {
                BaseProductSearchActivity.this.etSearch.setCursorVisible(false);
            }
        });
        p();
    }

    /* access modifiers changed from: private */
    public void o() {
        com.shopee.feeds.feedlibrary.util.b.e.a(this.f7062g);
    }

    private void p() {
        this.q.setText(b.e(c.g.feeds_search_relevance_key));
        this.s.setText(b.e(c.g.feeds_search_latest_key));
        this.t.setText(b.e(c.g.feeds_search_sales_key));
        this.u.setText(b.e(c.g.feeds_search_price_key));
        this.J.setText(b.e(c.g.feeds_search_relevance_first));
        this.L.setText(b.e(c.g.feeds_search_relevance_second));
        this.tvCancel.setText(b.e(c.g.feeds_button_cancel));
        this.B.setText(b.e(c.g.feeds_search_mall_key));
        this.V.setText(b.e(c.g.feeds_search_mall_key));
        this.D.setText(b.e(c.g.feeds_search_preferred_key));
        this.X.setText(b.e(c.g.feeds_search_preferred_key));
        this.F.setText(b.e(c.g.feeds_search_time_key));
        this.Z.setText(b.e(c.g.feeds_search_time_key));
        this.Q.setText(b.e(c.g.feeds_search_no_connection));
        this.R.setText(b.e(c.g.feeds_search_try_again_later));
        this.ab.setText(b.e(c.g.feeds_search_try_again));
        this.S.setText(b.e(c.g.feeds_search_no_results_key));
        this.T.setText(b.e(c.g.feeds_search_try_other_key));
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z2) {
        this.n = 0;
        this.o = z2;
        h.b("%s", "dbshuru 000 " + z2);
        if (this.k == null) {
            this.k = com.d.a.d.a(this.recyclerView).a((RecyclerView.a) this.j).a(true).d(0).b(false).b(1400).c(c.b.feeds_search_skeleton_color).a(1).e(c.f.feeds_activity_search_skeleton_layout).a();
        }
        this.recyclerView.setVisibility(0);
        this.U.setVisibility(0);
        this.k.a();
        this.h.setVisibility(0);
        this.j.f27500f = this.etSearch.getCurKeywords();
        com.shopee.feeds.feedlibrary.data.e.a aVar = this.f7062g;
        aVar.f27743f = 0;
        aVar.f27744g = true;
        this.tvNoResult.setVisibility(8);
        this.f7059d.setVisibility(8);
        a(z2, str);
    }

    @OnClick
    public void onClick(View view) {
        int id = view.getId();
        if (id == c.e.iv_search_cancel) {
            this.etSearch.setText("");
            this.etSearch.setCursorVisible(true);
            ArrayList<ProductEntity.ProductItem> arrayList = this.f7061f;
            if (arrayList != null && arrayList.size() > 0) {
                this.f7061f.clear();
                this.j.a(this.f7061f);
            }
            a("", true);
        } else if (id == c.e.tv_cancel) {
            com.shopee.feeds.feedlibrary.util.b.e.a(this.etSearch.getCurKeywords(), this.n);
            finish();
        } else if (id == c.e.rel_click) {
            b(0);
        } else if (id == c.e.latest_tv) {
            b(1);
            com.shopee.feeds.feedlibrary.util.b.e.a("latest", true, this.f7062g);
            this.i = true;
        } else if (id == c.e.sales_tv) {
            b(2);
            com.shopee.feeds.feedlibrary.util.b.e.a("top_sales", true, this.f7062g);
            this.i = true;
        } else if (id == c.e.price_click) {
            b(3);
            com.shopee.feeds.feedlibrary.util.b.e.a("price", true, this.f7062g);
            this.i = true;
        } else if (id != c.e.mall_tx && id != c.e.prefer_tx && id != c.e.time_tx) {
            if (id == c.e.sub_first_layout) {
                e(0);
                com.shopee.feeds.feedlibrary.util.b.e.a("relevance", true, this.f7062g);
                this.i = true;
            } else if (id == c.e.sub_second_layout) {
                e(1);
                com.shopee.feeds.feedlibrary.util.b.e.a("nearby", true, this.f7062g);
                this.i = true;
            } else if (id == c.e.shadow_view) {
                b(0);
            } else if (id == c.e.try_again) {
                r();
            }
        }
    }

    private void b(int i2) {
        h.b("%s", "BaseProductSearchActivitydbonCateClick " + this.f7062g.toString());
        int i3 = this.f7062g.f27738a;
        com.shopee.feeds.feedlibrary.data.e.a aVar = this.f7062g;
        aVar.f27738a = i2;
        boolean z2 = true;
        if (i3 == i2) {
            if (i2 != 1 && i2 != 2) {
                if (i2 == 0) {
                    if (this.H.getVisibility() == 0) {
                        this.H.setVisibility(8);
                        this.I.setVisibility(8);
                        this.r.setBackground(b.f(c.d.search_selected_tri_icon));
                        return;
                    }
                    this.H.setVisibility(0);
                    this.I.setVisibility(0);
                    if (this.f7062g.f27739b == 0 || this.f7062g.f27739b == 1) {
                        this.r.setBackground(b.f(c.d.feeds_search_rel_select_up));
                    } else {
                        this.r.setBackground(b.f(c.d.feeds_search_rel_unselect_up));
                    }
                } else if (i2 == 3) {
                    int i4 = aVar.f27740c;
                    if (i4 == 0) {
                        this.f7062g.f27740c = 1;
                        this.v.setBackground(b.f(c.d.feeds_search_price_high_low));
                    } else if (i4 == 1) {
                        this.f7062g.f27740c = 0;
                        this.v.setBackground(b.f(c.d.feeds_search_price_low_high));
                    }
                    r();
                }
            }
        } else if (i2 == 0) {
            this.ag = i3;
            if (this.H.getVisibility() != 0) {
                z2 = false;
            }
            if (z2) {
                this.r.setBackground(b.f(c.d.feeds_search_rel_no_select));
                this.H.setVisibility(8);
                this.I.setVisibility(8);
            } else {
                this.r.setBackground(b.f(c.d.feeds_search_rel_unselect_up));
                this.H.setVisibility(0);
                this.I.setVisibility(0);
            }
            this.f7062g.f27738a = i3;
        } else {
            d(0);
            d(i3);
            c(i2);
            if (i3 == 0 && i2 != 0) {
                this.q.setText(b.e(c.g.feeds_search_relevance_key));
            }
            r();
        }
    }

    private void q() {
        int i2 = this.ag;
        if (i2 == 1) {
            this.s.setTextColor(b.a(c.b.feeds_search_cate_color));
            this.x.setBackgroundColor(b.a(c.b.feeds_search_line_color));
        } else if (i2 == 2) {
            this.t.setTextColor(b.a(c.b.feeds_search_cate_color));
            this.y.setBackgroundColor(b.a(c.b.feeds_search_line_color));
        } else if (i2 == 3) {
            this.u.setTextColor(b.a(c.b.feeds_search_cate_color));
            this.v.setBackground(b.f(c.d.search_noselected_tri_icon));
            this.z.setBackgroundColor(b.a(c.b.feeds_search_line_color));
            this.f7062g.f27740c = -1;
        }
    }

    private void c(int i2) {
        if (i2 == 1) {
            this.s.setTextColor(b.a(c.b.main_color));
            this.x.setBackgroundColor(b.a(c.b.main_color));
        } else if (i2 == 2) {
            this.t.setTextColor(b.a(c.b.main_color));
            this.y.setBackgroundColor(b.a(c.b.main_color));
        } else if (i2 == 3) {
            this.u.setTextColor(b.a(c.b.main_color));
            this.v.setBackground(b.f(c.d.feeds_search_price_low_high));
            this.z.setBackgroundColor(b.a(c.b.main_color));
            this.f7062g.f27740c = 0;
        }
    }

    private void d(int i2) {
        if (i2 == 0) {
            this.K.setVisibility(8);
            this.M.setVisibility(8);
            this.J.setTextColor(b.a(c.b.feeds_search_cate_color));
            this.L.setTextColor(b.a(c.b.feeds_search_cate_color));
            this.f7062g.f27739b = -1;
            this.q.setTextColor(b.a(c.b.feeds_search_cate_color));
            this.r.setBackground(b.f(c.d.feeds_search_rel_no_select));
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.w.setBackgroundColor(b.a(c.b.feeds_search_line_color));
        } else if (i2 == 1) {
            this.s.setTextColor(b.a(c.b.feeds_search_cate_color));
            this.x.setBackgroundColor(b.a(c.b.feeds_search_line_color));
        } else if (i2 == 2) {
            this.t.setTextColor(b.a(c.b.feeds_search_cate_color));
            this.y.setBackgroundColor(b.a(c.b.feeds_search_line_color));
        } else if (i2 == 3) {
            this.u.setTextColor(b.a(c.b.feeds_search_cate_color));
            this.v.setBackground(b.f(c.d.search_noselected_tri_icon));
            this.z.setBackgroundColor(b.a(c.b.feeds_search_line_color));
            this.f7062g.f27740c = -1;
        }
    }

    private void r() {
        h.b("%s", "BaseProductSearchActivitydb onProductSearchByUiModel " + this.f7062g.toString());
        this.f7062g.f27743f = 0;
        n();
        com.shopee.feeds.feedlibrary.util.d.a((Activity) this);
        this.etSearch.setCursorVisible(false);
        a(this.etSearch.getCurKeywords(), false);
    }

    private void a(RobotoTextView robotoTextView, ImageView imageView, boolean z2) {
        if (z2) {
            robotoTextView.setTextColor(Color.parseColor("#ee4d2d"));
            robotoTextView.setBackground(b.f(c.d.feeds_search_select_bg_selector_select));
            imageView.setVisibility(0);
            return;
        }
        robotoTextView.setTextColor(Color.parseColor("#a6000000"));
        robotoTextView.setBackground(b.f(c.d.feeds_search_select_bg_selector_unselect));
        imageView.setVisibility(8);
    }

    private void e(int i2) {
        int i3 = this.f7062g.f27739b;
        if (i3 == 0) {
            if (i2 == 0) {
                a(i2, true);
                this.H.setVisibility(8);
                this.I.setVisibility(8);
            } else {
                a(0, false);
                a(1, true);
                this.H.setVisibility(8);
                this.I.setVisibility(8);
                r();
            }
        } else if (i3 != 1) {
            q();
            this.f7062g.f27738a = 0;
            a(i2, true);
            r();
        } else if (i2 == 0) {
            a(1, false);
            a(0, true);
            r();
        } else {
            a(i2, true);
            this.H.setVisibility(8);
            this.I.setVisibility(8);
        }
        this.H.setVisibility(8);
        this.I.setVisibility(8);
    }

    private void a(int i2, boolean z2) {
        this.f7062g.f27739b = i2;
        RobotoTextView robotoTextView = this.J;
        ImageView imageView = this.K;
        if (i2 == 1) {
            robotoTextView = this.L;
            imageView = this.M;
            if (z2) {
                this.q.setText(b.e(c.g.feeds_search_relevance_second));
                this.q.setTextColor(b.a(c.b.main_color));
                this.w.setBackgroundColor(b.a(c.b.main_color));
                this.r.setBackground(b.f(c.d.search_selected_tri_icon));
            }
        } else if (i2 == 0 && z2) {
            this.q.setText(b.e(c.g.feeds_search_relevance_first));
            this.q.setTextColor(b.a(c.b.main_color));
            this.w.setBackgroundColor(b.a(c.b.main_color));
            this.r.setBackground(b.f(c.d.search_selected_tri_icon));
        }
        if (z2) {
            robotoTextView.setTextColor(b.a(c.b.main_color));
            imageView.setVisibility(0);
            return;
        }
        robotoTextView.setTextColor(b.a(c.b.feeds_search_cate_color));
        imageView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        boolean z2;
        if (this.f7062g.f27741d.contains(str)) {
            this.f7062g.f27741d.remove(str);
            z2 = false;
        } else {
            this.f7062g.f27741d.add(str);
            z2 = true;
        }
        if ("mall".equals(str)) {
            a(this.B, this.C, z2);
            a(this.V, this.W, z2);
        } else if ("preferred".equals(str)) {
            a(this.D, this.E, z2);
            a(this.X, this.Y, z2);
        } else if ("24H".equals(str)) {
            a(this.F, this.G, z2);
            a(this.Z, this.aa, z2);
        }
        this.j.a();
        this.j.notifyDataSetChanged();
        r();
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(FinishPdListEntity finishPdListEntity) {
        boolean z2 = finishPdListEntity instanceof FinishPdListEntity;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        com.shopee.feeds.feedlibrary.util.b.e.a(this.f7062g);
        this.m.c();
        org.greenrobot.eventbus.c.a().b(this);
    }

    public void a(Object obj, String str) {
        if (!this.l.equals(str)) {
            h.b("%s", "showSearchResultdb1 " + str);
            return;
        }
        this.recyclerView.setLoading(false);
        this.mSearchLoadingView.a();
        this.mSearchLoadingView.setVisibility(8);
        ProductEntity productEntity = (ProductEntity) obj;
        this.f7062g.f27744g = productEntity.isHas_more();
        if (this.f7062g.f27743f == 0) {
            this.k.b();
        }
        if (this.o) {
            this.ac.setFocusable(false);
            this.ac.setFocusableInTouchMode(false);
            this.etSearch.requestFocus();
            com.shopee.feeds.feedlibrary.util.d.b((Activity) this, (EditText) this.etSearch);
            h.b("%s", "dbshuru 1111");
        }
        this.U.setVisibility(8);
        this.h.setVisibility(8);
        a(obj);
        this.P.setVisibility(8);
        this.f7062g.f27743f = productEntity.getNext_offset();
        h.b("%s", "BaseProductSearchActivitydbshowSearchResult " + this.f7062g.f27744g + "," + this.f7062g.f27743f);
        this.i = false;
    }

    public void b(String str) {
        if (!this.l.equals(str)) {
            h.b("%s", "showSearchResultdb2 " + str);
            return;
        }
        this.mSearchLoadingView.a();
        this.mSearchLoadingView.setVisibility(8);
        this.f7059d.setVisibility(8);
        this.P.setVisibility(0);
        b(false);
        this.h.setVisibility(8);
        this.U.setVisibility(8);
        if (this.f7062g.f27743f == 0) {
            this.k.b();
        }
        a(false);
        this.j.a();
        this.j.notifyDataSetChanged();
        com.shopee.feeds.feedlibrary.data.e.a aVar = this.f7062g;
        aVar.f27743f = 0;
        aVar.f27744g = true;
        com.shopee.feeds.feedlibrary.util.d.a((Activity) this);
        this.etSearch.setCursorVisible(false);
        this.i = false;
    }

    /* access modifiers changed from: protected */
    public void b(boolean z2) {
        if (this.j.f27499e) {
            if (!z2) {
                this.j.c();
            }
        } else if (z2) {
            m();
        }
    }
}
