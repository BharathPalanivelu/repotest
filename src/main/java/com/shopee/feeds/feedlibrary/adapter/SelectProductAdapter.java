package com.shopee.feeds.feedlibrary.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.m;
import com.shopee.feeds.feedlibrary.util.v;
import com.squareup.a.e;
import com.squareup.a.w;

public class SelectProductAdapter extends a<ProductEntity.ProductItem> {

    public class ProductViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private ProductViewHolder f27516b;

        public ProductViewHolder_ViewBinding(ProductViewHolder productViewHolder, View view) {
            this.f27516b = productViewHolder;
            productViewHolder.rlProduct = (RelativeLayout) b.a(view, c.e.rl_product, "field 'rlProduct'", RelativeLayout.class);
            productViewHolder.ivProduct = (ImageView) b.a(view, c.e.iv_product, "field 'ivProduct'", ImageView.class);
            productViewHolder.tvProductName = (TextView) b.a(view, c.e.tv_product_name, "field 'tvProductName'", TextView.class);
            productViewHolder.tvMoney = (TextView) b.a(view, c.e.tv_money, "field 'tvMoney'", TextView.class);
        }
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ProductViewHolder(this.f27559c.inflate(c.f.feeds_layout_product, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.w wVar, final int i) {
        final ProductViewHolder productViewHolder = (ProductViewHolder) wVar;
        final ProductEntity.ProductItem productItem = (ProductEntity.ProductItem) this.f27558b.get(i);
        if (!d.a(productItem.getImage())) {
            w.a(this.f27557a).a(m.a(productItem.getImage(), true)).a(c.d.feeds_ic_shopee_gray).b(c.d.feeds_ic_shopee_gray).a(productViewHolder.ivProduct, (e) new e() {
                public void c() {
                    h.b("%s", "tagdbmod hashtag sus" + m.a(productItem.getImage(), true));
                }

                public void d() {
                    h.b("%s", "tagdbmod hashtag sus" + m.a(productItem.getImage(), false));
                    w.a(SelectProductAdapter.this.f27557a).a(m.a(productItem.getImage(), false)).a(c.d.feeds_ic_shopee_gray).b(c.d.feeds_ic_shopee_gray).a(productViewHolder.ivProduct);
                }
            });
        }
        if (!d.a(productItem.getName())) {
            productViewHolder.tvProductName.setText(productItem.getName());
        }
        if (!d.a(productItem.getPrice())) {
            TextView textView = productViewHolder.tvMoney;
            textView.setText(v.a() + v.b(productItem.getPrice()));
        }
        productViewHolder.rlProduct.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SelectProductAdapter.this.f27560d != null) {
                    SelectProductAdapter.this.f27560d.a(i, productItem, productViewHolder.rlProduct);
                }
            }
        });
    }

    static class ProductViewHolder extends RecyclerView.w {
        @BindView
        ImageView ivProduct;
        @BindView
        RelativeLayout rlProduct;
        @BindView
        TextView tvMoney;
        @BindView
        TextView tvProductName;

        public ProductViewHolder(View view) {
            super(view);
            ButterKnife.a(this, view);
        }
    }
}
