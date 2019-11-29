package com.shopee.feeds.feedlibrary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.editor.tag.b;
import com.shopee.feeds.feedlibrary.editor.text.PriceTextView;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.m;
import com.shopee.feeds.feedlibrary.view.CircleImageView;
import com.squareup.a.e;
import com.squareup.a.r;
import com.squareup.a.w;

public class EditPageProductAdapter extends a<com.shopee.feeds.feedlibrary.editor.tag.a> {

    /* renamed from: e  reason: collision with root package name */
    a f27476e;

    public interface a {
        void a(int i, b bVar);
    }

    public class ProductViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private ProductViewHolder f27483b;

        public ProductViewHolder_ViewBinding(ProductViewHolder productViewHolder, View view) {
            this.f27483b = productViewHolder;
            productViewHolder.ivProduct = (ImageView) butterknife.a.b.a(view, c.e.iv_product, "field 'ivProduct'", ImageView.class);
            productViewHolder.tvProductName = (RobotoTextView) butterknife.a.b.a(view, c.e.tv_product_name, "field 'tvProductName'", RobotoTextView.class);
            productViewHolder.tvProductPrice = (PriceTextView) butterknife.a.b.a(view, c.e.tv_product_price, "field 'tvProductPrice'", PriceTextView.class);
            productViewHolder.civPortrait = (CircleImageView) butterknife.a.b.a(view, c.e.civ_portrait, "field 'civPortrait'", CircleImageView.class);
            productViewHolder.tvShopName = (RobotoTextView) butterknife.a.b.a(view, c.e.tv_shop_name, "field 'tvShopName'", RobotoTextView.class);
            productViewHolder.ivDelete = (ImageView) butterknife.a.b.a(view, c.e.iv_delete, "field 'ivDelete'", ImageView.class);
        }
    }

    public EditPageProductAdapter(Context context) {
        super(context);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ProductViewHolder(this.f27559c.inflate(c.f.feeds_layout_edit_page_product, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.w wVar, final int i) {
        final b bVar = (b) this.f27558b.get(i);
        final ProductEntity.ProductItem n = bVar.n();
        final ProductViewHolder productViewHolder = (ProductViewHolder) wVar;
        w.a(this.f27557a).a(com.shopee.feeds.feedlibrary.data.c.b.b(n.getImage())).a(r.NO_CACHE, new r[0]).a(c.d.feeds_ic_product_default).b(c.d.feeds_ic_product_default).a(productViewHolder.ivProduct);
        productViewHolder.tvProductName.setText(n.getName());
        if (!d.a(n.getShop_avatar())) {
            w.a(this.f27557a).a(m.a(n.getShop_avatar(), true)).a(c.d.feeds_icn_default_avatar).b(c.d.feeds_icn_default_avatar).a((ImageView) productViewHolder.civPortrait, (e) new e() {
                public void c() {
                    h.b("%s", "tagdbmod hashtag sus " + m.a(n.getShop_avatar(), true));
                }

                public void d() {
                    h.b("%s", "tagdbmod hashtag err " + m.a(n.getShop_avatar(), false));
                    w.a(EditPageProductAdapter.this.f27557a).a(m.a(n.getShop_avatar(), false)).b(com.shopee.feeds.feedlibrary.util.w.a(EditPageProductAdapter.this.f27557a, 16), com.shopee.feeds.feedlibrary.util.w.a(EditPageProductAdapter.this.f27557a, 16)).a(c.d.feeds_icn_default_avatar).b(c.d.feeds_icn_default_avatar).a((ImageView) productViewHolder.civPortrait);
                }
            });
        } else {
            productViewHolder.civPortrait.setImageResource(c.d.feeds_icn_default_avatar);
        }
        productViewHolder.tvShopName.setText(n.getShop_name());
        productViewHolder.ivDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (EditPageProductAdapter.this.f27476e != null) {
                    EditPageProductAdapter.this.f27476e.a(i, bVar);
                    EditPageProductAdapter.this.a(i, bVar);
                }
            }
        });
        productViewHolder.tvProductPrice.setPriceWithIntervalPrice(n);
    }

    static class ProductViewHolder extends RecyclerView.w {
        @BindView
        CircleImageView civPortrait;
        @BindView
        ImageView ivDelete;
        @BindView
        ImageView ivProduct;
        @BindView
        RobotoTextView tvProductName;
        @BindView
        PriceTextView tvProductPrice;
        @BindView
        RobotoTextView tvShopName;

        public ProductViewHolder(View view) {
            super(view);
            ButterKnife.a(this, view);
        }
    }

    public void a(a aVar) {
        this.f27476e = aVar;
    }

    /* access modifiers changed from: private */
    public void a(int i, b bVar) {
        if (bVar != null) {
            ProductEntity.ProductItem n = bVar.n();
            if (n != null) {
                com.shopee.feeds.feedlibrary.util.b.e.b(n.getItem_id(), n.getShop_id(), i);
            }
        }
    }
}
