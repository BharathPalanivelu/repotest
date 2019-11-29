package com.shopee.feeds.feedlibrary.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.adapter.ChooseProductAdapter;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.data.entity.ProductPosEntity;
import com.shopee.feeds.feedlibrary.util.b.d;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.view.LoadMoreRecycyleView;
import com.shopee.feeds.feedlibrary.view.a.f;
import com.squareup.a.w;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public abstract class BaseProductFragment extends b implements f {

    /* renamed from: a  reason: collision with root package name */
    com.shopee.feeds.feedlibrary.b.f f7102a;

    /* renamed from: b  reason: collision with root package name */
    ChooseProductAdapter f7103b;

    /* renamed from: c  reason: collision with root package name */
    public a f7104c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f7105d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f7106e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7107f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7108g = false;
    private View h;
    private ArrayList<ProductEntity.ProductItem> i = new ArrayList<>();
    private int j;
    private int k;
    private d l;
    /* access modifiers changed from: private */
    public LinkedHashMap<Integer, ProductEntity.ProductItem> m = new LinkedHashMap<>();
    @BindView
    TextView mTvNoData;
    @BindView
    LoadMoreRecycyleView recyclerView;

    public interface a {
        void a(int i, ProductEntity.ProductItem productItem);

        void a(LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap);

        void b(int i, ProductEntity.ProductItem productItem);

        void c(int i, ProductEntity.ProductItem productItem);
    }

    public void a(int i2) {
    }

    public abstract String c();

    public abstract void d();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.j = arguments.getInt("page_type");
        this.k = arguments.getInt("select_type");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = LayoutInflater.from(getContext()).inflate(c.f.feeds_fragment_base_product, viewGroup, false);
        ButterKnife.a(this, this.h);
        org.greenrobot.eventbus.c.a().a((Object) this);
        this.f7102a = new com.shopee.feeds.feedlibrary.b.f(getContext());
        this.f7102a.a(this);
        return this.h;
    }

    public void a() {
        this.f7105d = 0;
        this.f7102a.a(c(), this.f7105d, 10);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void h() {
        this.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.recyclerView.setOnLoadListener(new LoadMoreRecycyleView.a() {
            public void a() {
                if (BaseProductFragment.this.f7106e) {
                    BaseProductFragment.this.f7102a.a(BaseProductFragment.this.c(), BaseProductFragment.this.f7105d, 10);
                } else {
                    u.a(BaseProductFragment.this.getContext(), b.e(c.g.feeds_no_more_data));
                }
            }
        });
        this.recyclerView.a((RecyclerView.n) new RecyclerView.n() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                w a2 = w.a(BaseProductFragment.this.getContext());
                if (i == 0) {
                    a2.b((Object) "product");
                } else {
                    a2.a((Object) "product");
                }
            }
        });
        this.f7103b = new ChooseProductAdapter(getContext());
        this.f7103b.a(this.j);
        this.f7103b.a(this.k, false);
        this.f7103b.a((ChooseProductAdapter.a) new ChooseProductAdapter.a() {
            public void a(LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap) {
                if (BaseProductFragment.this.f7104c != null) {
                    BaseProductFragment.this.f7104c.a(linkedHashMap);
                }
                if (BaseProductFragment.this.m != null) {
                    BaseProductFragment.this.m.clear();
                    BaseProductFragment.this.m.putAll(linkedHashMap);
                }
            }

            public void a(ProductEntity.ProductItem productItem, int i, ProductEntity.ProductItem productItem2, int i2, int i3) {
                BaseProductFragment.this.a(productItem, i, i3);
            }

            public void a(ProductEntity.ProductItem productItem, int i) {
                if (BaseProductFragment.this.f7104c != null) {
                    BaseProductFragment.this.f7104c.c(i, productItem);
                }
            }
        });
        this.recyclerView.setAdapter(this.f7103b);
        this.l = new d(getContext(), this.recyclerView, 1, false);
        this.l.a((d.a) new d.a() {
            public void a(int i) {
                BaseProductFragment.this.c(i);
            }
        });
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.f7108g = z;
    }

    public void a(ProductEntity productEntity, int i2) {
        this.recyclerView.setLoading(false);
        if (productEntity.getItems().size() > 0) {
            this.recyclerView.setVisibility(0);
            this.mTvNoData.setVisibility(8);
            if (i2 == 0) {
                this.i.clear();
                a(productEntity.getItems());
            }
            this.i.addAll(productEntity.getItems());
            f();
            this.f7103b.a(this.i);
            this.f7105d = productEntity.getNext_offset();
            this.f7106e = productEntity.isHas_more();
        } else if (i2 == 0) {
            this.recyclerView.setVisibility(8);
            this.mTvNoData.setVisibility(0);
            d();
        } else {
            u.a(getContext(), b.e(c.g.feeds_no_more_data));
        }
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

    public LinkedHashMap<Integer, ProductEntity.ProductItem> b() {
        return this.m;
    }

    public void a(int i2, boolean z) {
        ChooseProductAdapter chooseProductAdapter = this.f7103b;
        if (chooseProductAdapter != null) {
            chooseProductAdapter.a(i2, z);
        }
    }

    public void a(a aVar) {
        this.f7104c = aVar;
    }

    /* access modifiers changed from: private */
    public void a(ProductEntity.ProductItem productItem, int i2, int i3) {
        int i4 = this.j;
        if (i4 == 1 || i4 == 2) {
            a aVar = this.f7104c;
            if (aVar != null) {
                aVar.b(i2, productItem);
            }
            if (i3 != 1) {
                this.recyclerView.k(i2);
            }
        }
    }

    private void a(ArrayList<ProductEntity.ProductItem> arrayList) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(0, arrayList.get(0));
        a((LinkedHashMap<Integer, ProductEntity.ProductItem>) linkedHashMap);
        a aVar = this.f7104c;
        if (aVar != null) {
            aVar.a(0, arrayList.get(0));
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put(0, arrayList.get(0));
            this.f7104c.a(linkedHashMap2);
        }
        LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap3 = this.m;
        if (linkedHashMap3 != null) {
            linkedHashMap3.clear();
            this.m.put(0, arrayList.get(0));
        }
    }

    public ProductEntity.ProductItem b(int i2) {
        ArrayList<ProductEntity.ProductItem> arrayList = this.i;
        if (arrayList == null || i2 >= arrayList.size()) {
            return null;
        }
        return this.i.get(i2);
    }

    public void e() {
        ChooseProductAdapter chooseProductAdapter = this.f7103b;
        if (chooseProductAdapter != null) {
            chooseProductAdapter.c();
        }
    }

    public void a(LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap) {
        ChooseProductAdapter chooseProductAdapter = this.f7103b;
        if (chooseProductAdapter != null) {
            chooseProductAdapter.a(linkedHashMap);
        }
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        ArrayList<ProductEntity.ProductItem> arrayList = this.i;
        if (arrayList != null && arrayList.size() > 0) {
            ProductEntity.ProductItem productItem = this.i.get(i2);
            if (productItem != null) {
                int i3 = this.j;
                if (i3 == 1) {
                    e.b(productItem.getShop_id(), productItem.getItem_id());
                } else if (i3 == 2) {
                    e.d(productItem.getShop_id(), productItem.getItem_id());
                }
            }
        }
    }

    public void f() {
        if (this.f7108g && !this.f7107f && this.i.size() > 0) {
            if (getParentFragment() == null || getParentFragment().getUserVisibleHint()) {
                this.f7107f = true;
                this.l.a();
            }
        }
    }
}
