package com.shopee.feeds.feedlibrary.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.adapter.ChooseTagProductAdapter;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.data.entity.ProductPosEntity;
import com.shopee.feeds.feedlibrary.util.b.d;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.util.v;
import com.shopee.feeds.feedlibrary.view.LoadMoreRecycyleView;
import com.shopee.feeds.feedlibrary.view.a.f;
import com.squareup.a.w;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public abstract class BaseTagProductFragment extends b implements f {

    /* renamed from: a  reason: collision with root package name */
    com.shopee.feeds.feedlibrary.b.f f7109a;

    /* renamed from: b  reason: collision with root package name */
    ChooseTagProductAdapter f7110b;

    /* renamed from: c  reason: collision with root package name */
    public a f7111c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f7112d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f7113e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7114f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7115g = false;
    private View h;
    private ArrayList<ProductEntity.ProductItem> i = new ArrayList<>();
    private int j;
    private int k;
    private d l;
    @BindView
    LinearLayout llWrongNet;
    private ArrayList<ProductEntity.ProductItem> m = new ArrayList<>();
    private com.shopee.sdk.ui.a n;
    @BindView
    LoadMoreRecycyleView recyclerView;
    @BindView
    TextView tvNoData;
    @BindView
    RobotoTextView tvRetry;
    @BindView
    RobotoTextView tvWrongNetData;

    public interface a {
        void a(ArrayList<ProductEntity.ProductItem> arrayList);
    }

    public abstract String b();

    public abstract void c();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.j = arguments.getInt("page_type");
        this.k = arguments.getInt("select_type");
        this.m = (ArrayList) arguments.getSerializable("list");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = LayoutInflater.from(getContext()).inflate(c.f.feeds_fragment_base_product, viewGroup, false);
        ButterKnife.a(this, this.h);
        org.greenrobot.eventbus.c.a().a((Object) this);
        this.f7109a = new com.shopee.feeds.feedlibrary.b.f(getContext());
        this.f7109a.a(this);
        this.n = new com.shopee.sdk.ui.a(getActivity());
        this.tvWrongNetData.setText(b.e(c.g.feeds_product_failed_to_load));
        this.tvRetry.setText(b.e(c.g.feeds_product_retry));
        return this.h;
    }

    public void a() {
        j();
        this.f7112d = 0;
        this.f7109a.a(b(), this.f7112d, 10);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void h() {
        this.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.recyclerView.setOnLoadListener(new LoadMoreRecycyleView.a() {
            public void a() {
                if (BaseTagProductFragment.this.f7113e) {
                    BaseTagProductFragment.this.f7109a.a(BaseTagProductFragment.this.b(), BaseTagProductFragment.this.f7112d, 10);
                } else {
                    u.a(BaseTagProductFragment.this.getContext(), b.e(c.g.feeds_no_more_data));
                }
            }
        });
        this.recyclerView.a((RecyclerView.n) new RecyclerView.n() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                w a2 = w.a(BaseTagProductFragment.this.getContext());
                if (i == 0) {
                    a2.b((Object) "product");
                } else {
                    a2.a((Object) "product");
                }
            }
        });
        this.f7110b = new ChooseTagProductAdapter(getContext(), this.m);
        this.f7110b.b(this.j);
        this.f7110b.a(this.k);
        this.f7110b.a((ChooseTagProductAdapter.a) new ChooseTagProductAdapter.a() {
            public void a(ArrayList<ProductEntity.ProductItem> arrayList) {
                if (BaseTagProductFragment.this.f7111c != null) {
                    BaseTagProductFragment.this.f7111c.a(arrayList);
                }
            }

            public void a(ProductEntity.ProductItem productItem, int i, ProductEntity.ProductItem productItem2, int i2) {
                BaseTagProductFragment.this.a(productItem, i);
            }
        });
        this.recyclerView.setAdapter(this.f7110b);
        this.l = new d(getContext(), this.recyclerView, 1, false);
        this.l.a((d.a) new d.a() {
            public void a(int i) {
                BaseTagProductFragment.this.b(i);
            }
        });
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.f7115g = z;
    }

    public void a(int i2) {
        if (i2 == 0) {
            k();
            g();
        }
    }

    public void a(ProductEntity productEntity, int i2) {
        this.recyclerView.setLoading(false);
        k();
        if (productEntity.getItems().size() > 0) {
            f();
            if (i2 == 0) {
                this.i.clear();
            }
            this.i.addAll(productEntity.getItems());
            e();
            this.f7110b.a(this.i);
            this.f7112d = productEntity.getNext_offset();
            this.f7113e = productEntity.isHas_more();
        } else if (i2 == 0) {
            i();
            c();
        } else {
            u.a(com.shopee.feeds.feedlibrary.b.b().f27287b, b.e(c.g.feeds_no_more_data));
        }
    }

    @OnClick
    public void retryLoad() {
        a();
    }

    public void onDestroy() {
        super.onDestroy();
        this.l.c();
        org.greenrobot.eventbus.c.a().b(this);
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(ProductPosEntity productPosEntity) {
        boolean z = productPosEntity instanceof ProductPosEntity;
    }

    public void a(a aVar) {
        this.f7111c = aVar;
    }

    /* access modifiers changed from: private */
    public void a(ProductEntity.ProductItem productItem, int i2) {
        if (this.k == 1) {
            ProductPosEntity productPosEntity = new ProductPosEntity();
            productPosEntity.setProductName(productItem.getName());
            if (!com.shopee.feeds.feedlibrary.util.d.a(productItem.getPrice())) {
                productPosEntity.setPrice(v.a() + v.b(productItem.getPrice()));
            }
            productPosEntity.setItem_id(productItem.getItem_id());
            productPosEntity.setShop_id(productItem.getShop_id());
            productPosEntity.setProductPosItem(productItem);
            org.greenrobot.eventbus.c.a().c(productPosEntity);
            getActivity().finish();
        }
    }

    public void d() {
        ChooseTagProductAdapter chooseTagProductAdapter = this.f7110b;
        if (chooseTagProductAdapter != null) {
            chooseTagProductAdapter.c();
        }
    }

    public void a(ArrayList<ProductEntity.ProductItem> arrayList) {
        ChooseTagProductAdapter chooseTagProductAdapter = this.f7110b;
        if (chooseTagProductAdapter != null) {
            chooseTagProductAdapter.a(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        ArrayList<ProductEntity.ProductItem> arrayList = this.i;
        if (arrayList != null && arrayList.size() > 0) {
            ProductEntity.ProductItem productItem = this.i.get(i2);
            if (productItem != null) {
                int i3 = this.j;
                if (i3 == 3) {
                    e.e(productItem.getShop_id(), productItem.getItem_id());
                } else if (i3 == 4) {
                    e.g(productItem.getShop_id(), productItem.getItem_id());
                }
            }
        }
    }

    private void f() {
        this.recyclerView.setVisibility(0);
        this.tvNoData.setVisibility(8);
        this.llWrongNet.setVisibility(8);
    }

    private void g() {
        this.recyclerView.setVisibility(8);
        this.tvNoData.setVisibility(8);
        this.llWrongNet.setVisibility(0);
    }

    private void i() {
        this.recyclerView.setVisibility(8);
        this.tvNoData.setVisibility(0);
        this.llWrongNet.setVisibility(8);
    }

    private void j() {
        if (this.n != null) {
            this.tvNoData.setVisibility(0);
            this.llWrongNet.setVisibility(8);
            this.n.a();
        }
    }

    private void k() {
        com.shopee.sdk.ui.a aVar = this.n;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void e() {
        if (this.f7115g && !this.f7114f && this.i.size() > 0) {
            if (getParentFragment() == null || getParentFragment().getUserVisibleHint()) {
                this.f7114f = true;
                this.l.a();
            }
        }
    }
}
