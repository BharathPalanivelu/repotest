package com.shopee.feeds.feedlibrary.adapter;

import android.content.Context;
import android.graphics.Bitmap;
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
import com.shopee.feeds.feedlibrary.util.u;
import com.squareup.a.w;
import java.util.ArrayList;

public class ChooseTagProductAdapter extends a<ProductEntity.ProductItem> {

    /* renamed from: e  reason: collision with root package name */
    a f27461e;

    /* renamed from: f  reason: collision with root package name */
    private int f27462f = 1;

    /* renamed from: g  reason: collision with root package name */
    private int f27463g;
    private ArrayList<ProductEntity.ProductItem> h = new ArrayList<>();

    public interface a {
        void a(ProductEntity.ProductItem productItem, int i, ProductEntity.ProductItem productItem2, int i2);

        void a(ArrayList<ProductEntity.ProductItem> arrayList);
    }

    public class ProductViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private ProductViewHolder f27467b;

        public ProductViewHolder_ViewBinding(ProductViewHolder productViewHolder, View view) {
            this.f27467b = productViewHolder;
            productViewHolder.mLlinearLayout = (LinearLayout) b.a(view, c.e.ll_product_item, "field 'mLlinearLayout'", LinearLayout.class);
            productViewHolder.ivProduct = (ImageView) b.a(view, c.e.iv_product, "field 'ivProduct'", ImageView.class);
            productViewHolder.tvCheck = (TextView) b.a(view, c.e.tv_check, "field 'tvCheck'", TextView.class);
            productViewHolder.llCheck = (LinearLayout) b.a(view, c.e.ll_check, "field 'llCheck'", LinearLayout.class);
            productViewHolder.rlProduct = (RelativeLayout) b.a(view, c.e.rl_product, "field 'rlProduct'", RelativeLayout.class);
            productViewHolder.tvProductName = (TextView) b.a(view, c.e.tv_product_name, "field 'tvProductName'", TextView.class);
            productViewHolder.priceTextView = (PriceTextView) b.a(view, c.e.price_textview, "field 'priceTextView'", PriceTextView.class);
        }
    }

    public ChooseTagProductAdapter(Context context, ArrayList<ProductEntity.ProductItem> arrayList) {
        super(context);
        if (arrayList != null && arrayList.size() > 0) {
            this.h.clear();
            this.h.addAll(arrayList);
        }
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ProductViewHolder(this.f27559c.inflate(c.f.feeds_layout_product_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.w wVar, final int i) {
        ProductViewHolder productViewHolder = (ProductViewHolder) wVar;
        final ProductEntity.ProductItem productItem = (ProductEntity.ProductItem) this.f27558b.get(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) productViewHolder.ivProduct.getLayoutParams();
        layoutParams.height = s.a(this.f27557a) / 2;
        productViewHolder.ivProduct.setLayoutParams(layoutParams);
        ImageView imageView = productViewHolder.ivProduct;
        int a2 = (this.f27557a.getResources().getDisplayMetrics().widthPixels / 2) - l.a(10, this.f27557a);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = a2;
            layoutParams2.width = a2;
            imageView.setLayoutParams(layoutParams2);
        }
        w.a(this.f27557a).a(com.shopee.feeds.feedlibrary.data.c.b.b(productItem.getImage())).d().b(350, 350).a(c.d.feeds_ic_product_default).a(Bitmap.Config.RGB_565).b(c.d.feeds_ic_product_default).a((Object) "product").f().a(productViewHolder.ivProduct);
        int i2 = this.f27463g;
        if (i2 == 5 || i2 == 6) {
            int i3 = this.f27462f;
            if (i3 == 1) {
                productViewHolder.llCheck.setVisibility(8);
            } else if (i3 == 2) {
                productViewHolder.llCheck.setVisibility(0);
                if (c(productItem)) {
                    productViewHolder.tvCheck.setSelected(true);
                    if (d(productItem) != -1) {
                        TextView textView = productViewHolder.tvCheck;
                        textView.setText(d(productItem) + "");
                    }
                } else {
                    productViewHolder.tvCheck.setSelected(false);
                    productViewHolder.tvCheck.setText("");
                }
            }
        }
        productViewHolder.mLlinearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ChooseTagProductAdapter.this.a(i, productItem);
                ChooseTagProductAdapter.this.a(productItem);
            }
        });
        productViewHolder.tvProductName.setText(productItem.getName());
        productViewHolder.priceTextView.setPriceWithOutIntervalPrice(productItem);
    }

    /* access modifiers changed from: private */
    public void a(int i, ProductEntity.ProductItem productItem) {
        int i2 = this.f27462f;
        if (i2 == 1) {
            this.f27461e.a(productItem, i, (ProductEntity.ProductItem) this.f27558b.get(i), i);
        } else if (i2 == 2 && b(i, productItem)) {
            a(productItem, i);
        }
        this.f27461e.a(this.h);
    }

    private void a(ProductEntity.ProductItem productItem, int i) {
        if (c(productItem)) {
            b(productItem);
        } else {
            this.h.add(productItem);
        }
        notifyDataSetChanged();
    }

    private void b(ProductEntity.ProductItem productItem) {
        ArrayList<ProductEntity.ProductItem> arrayList = this.h;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < this.h.size(); i++) {
                ProductEntity.ProductItem productItem2 = this.h.get(i);
                if (productItem.getItem_id().equals(productItem2.getItem_id()) && productItem.getShop_id() == productItem2.getShop_id()) {
                    this.h.remove(i);
                }
            }
        }
    }

    private boolean c(ProductEntity.ProductItem productItem) {
        if (productItem != null && this.h.size() > 0) {
            for (int i = 0; i < this.h.size(); i++) {
                ProductEntity.ProductItem productItem2 = this.h.get(i);
                if (productItem.getItem_id().equals(productItem2.getItem_id()) && productItem.getShop_id() == productItem2.getShop_id()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean b(int i, ProductEntity.ProductItem productItem) {
        if (this.f27462f != 2 || this.h.size() < 5 || c(productItem)) {
            return true;
        }
        u.a(this.f27557a, com.garena.android.appkit.tools.b.a(c.g.feeds_product_limit_tips, 5));
        return false;
    }

    public void a(int i) {
        this.f27462f = i;
    }

    public void b(int i) {
        this.f27463g = i;
    }

    public void c() {
        ArrayList<ProductEntity.ProductItem> arrayList = this.h;
        if (arrayList != null) {
            arrayList.clear();
            notifyDataSetChanged();
            this.f27461e.a(this.h);
        }
    }

    public void a(ArrayList<ProductEntity.ProductItem> arrayList) {
        if (this.h == null) {
            this.h = new ArrayList<>();
        }
        this.h.clear();
        this.h.addAll(arrayList);
        notifyDataSetChanged();
    }

    private int d(ProductEntity.ProductItem productItem) {
        if (productItem == null || this.h.size() <= 0) {
            return -1;
        }
        for (int i = 0; i < this.h.size(); i++) {
            ProductEntity.ProductItem productItem2 = this.h.get(i);
            if (productItem.getItem_id().equals(productItem2.getItem_id()) && productItem.getShop_id() == productItem2.getShop_id()) {
                return i + 1;
            }
        }
        return -1;
    }

    public void a(ProductEntity.ProductItem productItem) {
        int i = this.f27463g;
        if (i == 3) {
            e.h(productItem.getShop_id(), productItem.getItem_id());
        } else if (i == 4) {
            e.f(productItem.getShop_id(), productItem.getItem_id());
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
        this.f27461e = aVar;
    }
}
