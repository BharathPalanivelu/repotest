package com.shopee.feeds.feedlibrary.activity;

import android.view.View;
import com.shopee.feeds.feedlibrary.adapter.SearchChooseProductAdapter;
import com.shopee.feeds.feedlibrary.adapter.a;
import com.shopee.feeds.feedlibrary.data.entity.FinishPdListEntity;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.data.entity.ProductPosEntity;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.v;
import com.shopee.feeds.feedlibrary.view.SearchLoadMoreRecycyleView;
import java.util.LinkedHashMap;
import java.util.UUID;
import org.greenrobot.eventbus.c;

public class ProductSearchActivity extends BaseProductSearchActivity<ProductEntity.ProductItem> {
    SearchChooseProductAdapter q;

    public boolean e() {
        return false;
    }

    public void a(Object obj) {
        ProductEntity productEntity = (ProductEntity) obj;
        this.f7061f.clear();
        if (productEntity.getItems().size() > 0) {
            a(true);
            this.recyclerView.setVisibility(0);
            this.tvNoResult.setVisibility(8);
            this.f7061f.addAll(productEntity.getItems());
            if (this.f7061f.size() % 2 == 1) {
                ProductEntity.ProductItem productItem = new ProductEntity.ProductItem();
                productItem.setEmptyItem(true);
                this.f7061f.add(productItem);
            }
        } else {
            a(false);
            this.recyclerView.setVisibility(8);
            this.tvNoResult.setVisibility(0);
            this.f7059d.setVisibility(0);
            this.h.setVisibility(0);
            if (this.i) {
                e.b(this.etSearch.getCurKeywords(), this.f7062g);
            }
        }
        if (this.f7062g.f27743f == 0) {
            this.m.b();
            this.m.a();
            this.q.a(this.f7061f);
        } else {
            this.q.b(this.f7061f);
        }
        if (this.f7062g.f27744g) {
            b(false);
        } else {
            b(true);
        }
    }

    public SearchChooseProductAdapter i() {
        this.q = new SearchChooseProductAdapter(this.f7086a);
        this.q.c(1);
        this.q.a(1, false);
        this.q.a((a.C0422a) new a.C0422a() {
            public void a(int i, Object obj, View view) {
                if (obj != null) {
                    ProductEntity.ProductItem productItem = (ProductEntity.ProductItem) obj;
                    ProductPosEntity productPosEntity = new ProductPosEntity();
                    productPosEntity.setProductName(productItem.getName());
                    if (!d.a(productItem.getPrice())) {
                        productPosEntity.setPrice(v.a() + v.b(productItem.getPrice()));
                    }
                    productPosEntity.setItem_id(productItem.getItem_id());
                    productPosEntity.setShop_id(productItem.getShop_id());
                    productPosEntity.setProductPosItem(productItem);
                    c.a().c(productPosEntity);
                    c.a().c(new FinishPdListEntity());
                    ProductSearchActivity.this.finish();
                }
            }
        });
        this.recyclerView.setVisibility(0);
        this.recyclerView.setOnLoadListener(new SearchLoadMoreRecycyleView.a() {
            public void a() {
                if (ProductSearchActivity.this.f7062g.f27744g) {
                    ProductSearchActivity.this.l = UUID.randomUUID().toString();
                    ProductSearchActivity productSearchActivity = ProductSearchActivity.this;
                    productSearchActivity.o = false;
                    productSearchActivity.n = productSearchActivity.f7062g.f27743f - 1;
                    ProductSearchActivity.this.f7060e.a(ProductSearchActivity.this.etSearch.getCurKeywords(), ProductSearchActivity.this.f7060e.a(ProductSearchActivity.this.f7062g), ProductSearchActivity.this.f7062g.f27743f, 12, 1, ProductSearchActivity.this.l);
                    return;
                }
                ProductSearchActivity.this.b(true);
                h.b("%s", "handle it");
            }
        });
        this.q.a((SearchChooseProductAdapter.c) new SearchChooseProductAdapter.c() {
            public void a(LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap) {
            }

            public void a(ProductEntity.ProductItem productItem, int i, ProductEntity.ProductItem productItem2, int i2, int i3, int i4) {
                if (productItem != null) {
                    ProductPosEntity productPosEntity = new ProductPosEntity();
                    productPosEntity.setProductName(productItem.getName());
                    if (!d.a(productItem.getPrice())) {
                        productPosEntity.setPrice(v.a() + v.b(productItem.getPrice()));
                    }
                    productPosEntity.setItem_id(productItem.getItem_id());
                    productPosEntity.setShop_id(productItem.getShop_id());
                    productPosEntity.setProductPosItem(productItem);
                    e.b(productItem.getItem_id(), productItem.getShop_id(), i4, ProductSearchActivity.this.etSearch.getCurKeywords(), ProductSearchActivity.this.f7062g);
                    c.a().c(productPosEntity);
                    c.a().c(new FinishPdListEntity());
                    ProductSearchActivity.this.finish();
                }
            }
        });
        return this.q;
    }

    public void a(boolean z, String str) {
        this.l = UUID.randomUUID().toString();
        this.f7060e.a(str, this.f7060e.a(this.f7062g), this.f7062g.f27743f, 12, 1, this.l);
    }
}
