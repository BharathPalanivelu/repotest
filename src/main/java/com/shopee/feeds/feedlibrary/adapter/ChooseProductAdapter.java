package com.shopee.feeds.feedlibrary.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.editor.text.PriceTextView;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.l;
import com.shopee.feeds.feedlibrary.util.s;
import com.shopee.feeds.feedlibrary.util.t;
import com.shopee.feeds.feedlibrary.util.u;
import com.squareup.a.w;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChooseProductAdapter extends a<ProductEntity.ProductItem> {

    /* renamed from: e  reason: collision with root package name */
    a f27454e;

    /* renamed from: f  reason: collision with root package name */
    private int f27455f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f27456g = 0;
    private int h = 1;
    private int i;
    private Context j;
    private LinkedHashMap<Integer, ProductEntity.ProductItem> k = new LinkedHashMap<>();

    public interface a {
        void a(ProductEntity.ProductItem productItem, int i);

        void a(ProductEntity.ProductItem productItem, int i, ProductEntity.ProductItem productItem2, int i2, int i3);

        void a(LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap);
    }

    public class ProductViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private ProductViewHolder f27460b;

        public ProductViewHolder_ViewBinding(ProductViewHolder productViewHolder, View view) {
            this.f27460b = productViewHolder;
            productViewHolder.mLlinearLayout = (LinearLayout) b.a(view, c.e.ll_product_item, "field 'mLlinearLayout'", LinearLayout.class);
            productViewHolder.ivProduct = (ImageView) b.a(view, c.e.iv_product, "field 'ivProduct'", ImageView.class);
            productViewHolder.tvCheck = (TextView) b.a(view, c.e.tv_check, "field 'tvCheck'", TextView.class);
            productViewHolder.llCheck = (LinearLayout) b.a(view, c.e.ll_check, "field 'llCheck'", LinearLayout.class);
            productViewHolder.rlProduct = (RelativeLayout) b.a(view, c.e.rl_product, "field 'rlProduct'", RelativeLayout.class);
            productViewHolder.tvProductName = (TextView) b.a(view, c.e.tv_product_name, "field 'tvProductName'", TextView.class);
            productViewHolder.priceTextView = (PriceTextView) b.a(view, c.e.price_textview, "field 'priceTextView'", PriceTextView.class);
        }
    }

    public ChooseProductAdapter(Context context) {
        super(context);
        this.j = context;
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ProductViewHolder(this.f27559c.inflate(c.f.feeds_layout_product_item, viewGroup, false));
    }

    public void onBindViewHolder(final RecyclerView.w wVar, int i2) {
        ProductViewHolder productViewHolder = (ProductViewHolder) wVar;
        final ProductEntity.ProductItem productItem = (ProductEntity.ProductItem) this.f27558b.get(i2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) productViewHolder.ivProduct.getLayoutParams();
        layoutParams.height = s.a(this.j) / 2;
        productViewHolder.ivProduct.setLayoutParams(layoutParams);
        ImageView imageView = productViewHolder.ivProduct;
        int a2 = (this.j.getResources().getDisplayMetrics().widthPixels / 2) - l.a(10, this.j);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = a2;
            layoutParams2.width = a2;
            imageView.setLayoutParams(layoutParams2);
        }
        w.a(this.j).a(com.shopee.feeds.feedlibrary.data.c.b.b(productItem.getImage())).d().b(350, 350).a(c.d.feeds_ic_product_default).a(Bitmap.Config.RGB_565).b(c.d.feeds_ic_product_default).a((Object) "product").f().a(productViewHolder.ivProduct);
        int i3 = this.i;
        if (i3 == 1 || i3 == 2) {
            if (i2 == this.f27455f) {
                productViewHolder.ivProduct.setColorFilter(androidx.core.content.b.c(this.j, c.b.filter_color_fa), PorterDuff.Mode.SRC_ATOP);
            } else {
                productViewHolder.ivProduct.clearColorFilter();
            }
        }
        int i4 = this.i;
        if (i4 == 1 || i4 == 2) {
            int i5 = this.h;
            if (i5 == 1) {
                productViewHolder.llCheck.setVisibility(8);
            } else if (i5 == 2) {
                productViewHolder.llCheck.setVisibility(0);
                if (this.k.containsKey(Integer.valueOf(i2))) {
                    productViewHolder.tvCheck.setSelected(true);
                    if (b(productItem) != -1) {
                        TextView textView = productViewHolder.tvCheck;
                        textView.setText(b(productItem) + "");
                    }
                } else {
                    productViewHolder.tvCheck.setSelected(false);
                    productViewHolder.tvCheck.setText("");
                }
            }
        }
        productViewHolder.mLlinearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ChooseProductAdapter.this.b(wVar.getAdapterPosition(), productItem);
                ChooseProductAdapter.this.a(productItem);
            }
        });
        productViewHolder.tvProductName.setText(productItem.getName());
        productViewHolder.priceTextView.setPriceWithOutIntervalPrice(productItem);
    }

    /* access modifiers changed from: private */
    public void b(int i2, ProductEntity.ProductItem productItem) {
        int i3 = this.i;
        if ((i3 == 1 || i3 == 2) && b(i2)) {
            a(productItem, i2);
        }
        this.f27454e.a(this.k);
    }

    private void a(ProductEntity.ProductItem productItem, int i2) {
        if (this.h == 1 && i2 != this.f27455f) {
            c(i2);
            this.k.clear();
            this.k.put(Integer.valueOf(i2), productItem);
            this.f27454e.a(productItem, this.f27455f, (ProductEntity.ProductItem) this.f27558b.get(this.f27456g), this.f27456g, this.h);
        } else if (this.h != 2) {
        } else {
            if (i2 != this.f27455f) {
                c(i2);
                a(i2, productItem);
                this.f27454e.a(productItem, this.f27455f, (ProductEntity.ProductItem) this.f27558b.get(this.f27456g), this.f27456g, this.h);
            } else if (this.k.size() > 0) {
                this.k.remove(Integer.valueOf(i2));
                f();
                if (this.k.size() > 0) {
                    e();
                } else {
                    notifyItemChanged(i2);
                }
                this.f27454e.a(productItem, i2);
            } else {
                a(i2, productItem);
                this.f27456g = this.f27455f;
                this.f27455f = i2;
                notifyItemChanged(this.f27455f);
                this.f27454e.a(productItem, this.f27455f, (ProductEntity.ProductItem) this.f27558b.get(this.f27456g), this.f27456g, this.h);
            }
        }
    }

    public void a(int i2, ProductEntity.ProductItem productItem) {
        LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap = this.k;
        if (linkedHashMap != null && !linkedHashMap.containsKey(Integer.valueOf(i2))) {
            this.k.put(Integer.valueOf(i2), productItem);
        }
    }

    public void c() {
        this.f27455f = 0;
    }

    private void e() {
        if (this.k.size() > 0) {
            Iterator<Map.Entry<Integer, ProductEntity.ProductItem>> it = this.k.entrySet().iterator();
            Map.Entry entry = null;
            while (it.hasNext()) {
                entry = it.next();
            }
            if (entry != null) {
                this.f27456g = this.f27455f;
                this.f27455f = ((Integer) entry.getKey()).intValue();
                notifyItemChanged(this.f27456g);
                notifyItemChanged(this.f27455f);
                this.f27454e.a((ProductEntity.ProductItem) this.f27558b.get(this.f27455f), this.f27455f, (ProductEntity.ProductItem) this.f27558b.get(this.f27456g), this.f27456g, this.h);
            }
        }
    }

    private boolean b(int i2) {
        if (this.h != 2 || this.k.containsKey(Integer.valueOf(i2)) || this.k.size() < 5) {
            return true;
        }
        u.a(this.j, com.garena.android.appkit.tools.b.a(c.g.feeds_product_limit_tips, 5));
        return false;
    }

    private void c(int i2) {
        int i3 = this.f27455f;
        if (i2 != i3) {
            this.f27456g = i3;
            this.f27455f = i2;
            notifyItemChanged(this.f27456g);
            notifyItemChanged(this.f27455f);
        }
    }

    public void a(int i2, boolean z) {
        this.h = i2;
        if (z && this.f27558b != null && this.f27558b.size() > 0) {
            d();
            this.k.put(Integer.valueOf(this.f27455f), this.f27558b.get(this.f27455f));
            notifyDataSetChanged();
        }
    }

    public void a(LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap) {
        if (linkedHashMap != null) {
            this.k.clear();
            this.k.putAll(linkedHashMap);
            a aVar = this.f27454e;
            if (aVar != null) {
                aVar.a(this.k);
            }
        }
    }

    public void d() {
        LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap = this.k;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
    }

    private void f() {
        if (this.k.size() > 0) {
            for (Map.Entry<Integer, ProductEntity.ProductItem> key : this.k.entrySet()) {
                notifyItemChanged(((Integer) key.getKey()).intValue());
            }
        }
    }

    public void a(int i2) {
        this.i = i2;
    }

    private int b(ProductEntity.ProductItem productItem) {
        if (productItem == null || this.k.size() <= 0) {
            return -1;
        }
        int i2 = 0;
        for (Map.Entry<Integer, ProductEntity.ProductItem> value : this.k.entrySet()) {
            i2++;
            if (t.a(productItem).equals(t.a((ProductEntity.ProductItem) value.getValue()))) {
                return i2;
            }
        }
        return -1;
    }

    public void a(ProductEntity.ProductItem productItem) {
        int i2 = this.i;
        if (i2 == 1) {
            e.a(productItem.getShop_id(), productItem.getItem_id());
        } else if (i2 == 2) {
            e.c(productItem.getShop_id(), productItem.getItem_id());
        }
    }

    static class ProductViewHolder extends RecyclerView.w {
        @BindView
        ImageView ivProduct;
        @BindView
        LinearLayout llCheck;
        @BindView
        LinearLayout mLlinearLayout;
        @BindView
        PriceTextView priceTextView;
        @BindView
        RelativeLayout rlProduct;
        @BindView
        TextView tvCheck;
        @BindView
        TextView tvProductName;

        public ProductViewHolder(View view) {
            super(view);
            ButterKnife.a(this, view);
        }
    }

    public void a(a aVar) {
        this.f27454e = aVar;
    }
}
