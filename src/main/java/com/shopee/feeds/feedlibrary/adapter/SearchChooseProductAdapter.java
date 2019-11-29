package com.shopee.feeds.feedlibrary.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
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
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import com.shopee.feeds.feedlibrary.editor.text.PriceTextView;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.l;
import com.shopee.feeds.feedlibrary.util.m;
import com.shopee.feeds.feedlibrary.util.t;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.view.CircleImageView;
import com.squareup.a.w;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchChooseProductAdapter extends a<ProductEntity.ProductItem> {

    /* renamed from: e  reason: collision with root package name */
    public boolean f27499e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f27500f = null;

    /* renamed from: g  reason: collision with root package name */
    c f27501g;
    private int h = 0;
    private int i = -1;
    private int j = 1;
    private int k;
    private View l;
    private View m;
    private LinkedHashMap<Integer, ProductEntity.ProductItem> n = new LinkedHashMap<>();

    public interface c {
        void a(ProductEntity.ProductItem productItem, int i, ProductEntity.ProductItem productItem2, int i2, int i3, int i4);

        void a(LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap);
    }

    public class ProductViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private ProductViewHolder f27508b;

        public ProductViewHolder_ViewBinding(ProductViewHolder productViewHolder, View view) {
            this.f27508b = productViewHolder;
            productViewHolder.mLlinearLayout = (RelativeLayout) butterknife.a.b.a(view, c.e.ll_product_item, "field 'mLlinearLayout'", RelativeLayout.class);
            productViewHolder.ivProduct = (ImageView) butterknife.a.b.a(view, c.e.iv_product, "field 'ivProduct'", ImageView.class);
            productViewHolder.tvCheck = (TextView) butterknife.a.b.a(view, c.e.tv_check, "field 'tvCheck'", TextView.class);
            productViewHolder.llCheck = (LinearLayout) butterknife.a.b.a(view, c.e.ll_check, "field 'llCheck'", LinearLayout.class);
            productViewHolder.rlProduct = (RelativeLayout) butterknife.a.b.a(view, c.e.rl_product, "field 'rlProduct'", RelativeLayout.class);
            productViewHolder.tvProductName = (TextView) butterknife.a.b.a(view, c.e.tv_product_name, "field 'tvProductName'", TextView.class);
            productViewHolder.priceTextView = (PriceTextView) butterknife.a.b.a(view, c.e.price_textview, "field 'priceTextView'", PriceTextView.class);
            productViewHolder.shopAvatar = (CircleImageView) butterknife.a.b.a(view, c.e.tag_img, "field 'shopAvatar'", CircleImageView.class);
            productViewHolder.shopName = (RobotoTextView) butterknife.a.b.a(view, c.e.tag_tv, "field 'shopName'", RobotoTextView.class);
            productViewHolder.preferIcon = (ImageView) butterknife.a.b.a(view, c.e.prefer_icon, "field 'preferIcon'", ImageView.class);
            productViewHolder.mTopLayout = (LinearLayout) butterknife.a.b.a(view, c.e.top_layout, "field 'mTopLayout'", LinearLayout.class);
        }
    }

    public void a(View view) {
        this.l = view;
        notifyItemInserted(0);
    }

    public void b(View view) {
        this.m = view;
        this.f27499e = true;
        notifyItemInserted(getItemCount() - 1);
        h.b("%s", "dbsetFootview " + getItemCount());
    }

    public void c() {
        if (this.f27499e) {
            this.f27499e = false;
            notifyItemRangeRemoved(getItemCount() - 1, 1);
            this.m = null;
        }
    }

    public boolean a(int i2) {
        return this.l != null && i2 == 0;
    }

    public boolean b(int i2) {
        return this.m != null && i2 >= this.f27558b.size() + 1;
    }

    public int getItemViewType(int i2) {
        if (this.l == null && this.m == null) {
            return 2;
        }
        if (i2 == 0 && this.l != null) {
            return 0;
        }
        if (i2 != getItemCount() - 1 || this.m == null) {
            return 2;
        }
        return 1;
    }

    public int getItemCount() {
        if (this.l == null && this.m == null) {
            return this.f27558b.size();
        }
        if (this.l == null && this.m != null) {
            return this.f27558b.size() + 1;
        }
        if (this.l == null || this.m != null) {
            return this.f27558b.size() + 2;
        }
        return this.f27558b.size() + 1;
    }

    public SearchChooseProductAdapter(Context context) {
        super(context);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View view = this.l;
        if (view != null && i2 == 0) {
            return new b(view);
        }
        View view2 = this.m;
        if (view2 == null || i2 != 1) {
            return new ProductViewHolder(this.f27559c.inflate(c.f.feeds_layout_search_product_item, viewGroup, false));
        }
        return new a(view2);
    }

    public void onBindViewHolder(RecyclerView.w wVar, final int i2) {
        if (getItemViewType(i2) != 0 && getItemViewType(i2) != 1) {
            ProductViewHolder productViewHolder = (ProductViewHolder) wVar;
            View view = productViewHolder.itemView;
            int i3 = i2 % 2;
            if (i3 == 1) {
                view.setPadding(l.a(6, this.f27557a), view.getPaddingTop(), l.a(6, this.f27557a), view.getPaddingBottom());
            } else if (i3 == 0) {
                view.setPadding(l.a(0, this.f27557a), view.getPaddingTop(), l.a(8, this.f27557a), view.getPaddingBottom());
            }
            final ProductEntity.ProductItem productItem = (ProductEntity.ProductItem) this.f27558b.get(i2 - 1);
            if (productItem.isEmptyItem()) {
                view.setBackgroundColor(com.garena.android.appkit.tools.b.a(c.b.grey_200));
                productViewHolder.mTopLayout.setVisibility(4);
                productViewHolder.preferIcon.setVisibility(4);
                return;
            }
            productViewHolder.mTopLayout.setVisibility(0);
            productViewHolder.preferIcon.setVisibility(0);
            int a2 = (this.f27557a.getResources().getDisplayMetrics().widthPixels / 2) - l.a(10, this.f27557a);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) productViewHolder.ivProduct.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = a2;
                layoutParams.width = a2;
                productViewHolder.ivProduct.setLayoutParams(layoutParams);
            }
            w.a(this.f27557a).a(com.shopee.feeds.feedlibrary.data.c.b.b(productItem.getImage())).d().b(350, 350).a(c.d.feeds_ic_product_default).a(Bitmap.Config.RGB_565).b(c.d.feeds_ic_product_default).a((Object) "product").f().a(productViewHolder.ivProduct);
            a(productViewHolder.shopAvatar, productItem.getShop_avatar());
            productViewHolder.shopName.setText(productItem.getShop_name() == null ? "" : productItem.getShop_name());
            if (productItem.isIs_24h()) {
                productViewHolder.preferIcon.setBackground(com.garena.android.appkit.tools.b.f(c.d.feeds_search_time_icon));
            } else if (productItem.isIs_official_mall()) {
                productViewHolder.preferIcon.setBackground(com.garena.android.appkit.tools.b.f(c.d.feeds_search_mall_icon));
            } else if (productItem.isIs_preferred()) {
                productViewHolder.preferIcon.setBackground(com.garena.android.appkit.tools.b.f(c.d.feeds_search_prefer_icon));
            } else {
                productViewHolder.preferIcon.setVisibility(8);
            }
            int i4 = this.k;
            if (i4 == 1 || i4 == 2) {
                if (i2 == this.h) {
                    productViewHolder.ivProduct.setColorFilter(androidx.core.content.b.c(this.f27557a, c.b.filter_color_fa), PorterDuff.Mode.SRC_ATOP);
                } else {
                    productViewHolder.ivProduct.clearColorFilter();
                }
            }
            int i5 = this.k;
            if (i5 == 1 || i5 == 2) {
                int i6 = this.j;
                if (i6 == 1) {
                    productViewHolder.llCheck.setVisibility(8);
                } else if (i6 == 2) {
                    productViewHolder.llCheck.setVisibility(0);
                    if (this.n.containsKey(Integer.valueOf(i2))) {
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
                    SearchChooseProductAdapter.this.a(i2, productItem);
                    SearchChooseProductAdapter.this.a(productItem);
                }
            });
            productViewHolder.tvProductName.setText(productItem.getName());
            SpannableString spannableString = new SpannableString(productViewHolder.tvProductName.getText().toString());
            if (!TextUtils.isEmpty(this.f27500f)) {
                try {
                    Matcher matcher = Pattern.compile(this.f27500f.toLowerCase()).matcher(productViewHolder.tvProductName.getText().toString().toLowerCase());
                    while (matcher.find()) {
                        spannableString.setSpan(new ForegroundColorSpan(com.garena.android.appkit.tools.b.a(c.b.main_color)), matcher.start(), matcher.end(), 33);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                productViewHolder.tvProductName.setText(spannableString);
            }
            productViewHolder.priceTextView.setPriceWithOutIntervalPrice(productItem);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, ProductEntity.ProductItem productItem) {
        int i3 = this.k;
        if ((i3 == 1 || i3 == 2) && d(i2)) {
            a(productItem, i2);
        }
        this.f27501g.a(this.n);
    }

    private void a(ProductEntity.ProductItem productItem, int i2) {
        this.f27501g.a(productItem, this.h, (ProductEntity.ProductItem) null, this.i, this.j, i2 - 1);
    }

    private boolean d(int i2) {
        if (this.j != 2 || this.n.containsKey(Integer.valueOf(i2)) || this.n.size() < 5) {
            return true;
        }
        u.a(this.f27557a, com.garena.android.appkit.tools.b.a(c.g.feeds_product_limit_tips, 5));
        return false;
    }

    public void a(int i2, boolean z) {
        this.j = i2;
        if (z && this.f27558b != null && this.f27558b.size() > 0) {
            d();
            this.n.put(Integer.valueOf(this.h), this.f27558b.get(this.h));
            notifyDataSetChanged();
        }
    }

    public void d() {
        LinkedHashMap<Integer, ProductEntity.ProductItem> linkedHashMap = this.n;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
    }

    public void c(int i2) {
        this.k = i2;
    }

    private int b(ProductEntity.ProductItem productItem) {
        if (productItem == null || this.n.size() <= 0) {
            return -1;
        }
        int i2 = 0;
        for (Map.Entry<Integer, ProductEntity.ProductItem> value : this.n.entrySet()) {
            i2++;
            if (t.a(productItem).equals(t.a((ProductEntity.ProductItem) value.getValue()))) {
                return i2;
            }
        }
        return -1;
    }

    public void a(ProductEntity.ProductItem productItem) {
        int i2 = this.k;
        if (i2 == 1) {
            e.a(productItem.getShop_id(), productItem.getItem_id());
        } else if (i2 == 2) {
            e.c(productItem.getShop_id(), productItem.getItem_id());
        }
    }

    static class b extends RecyclerView.w {
        public b(View view) {
            super(view);
        }
    }

    static class a extends RecyclerView.w {
        public a(View view) {
            super(view);
        }
    }

    static class ProductViewHolder extends RecyclerView.w {
        @BindView
        ImageView ivProduct;
        @BindView
        LinearLayout llCheck;
        @BindView
        RelativeLayout mLlinearLayout;
        @BindView
        LinearLayout mTopLayout;
        @BindView
        ImageView preferIcon;
        @BindView
        PriceTextView priceTextView;
        @BindView
        RelativeLayout rlProduct;
        @BindView
        CircleImageView shopAvatar;
        @BindView
        RobotoTextView shopName;
        @BindView
        TextView tvCheck;
        @BindView
        TextView tvProductName;

        public ProductViewHolder(View view) {
            super(view);
            ButterKnife.a(this, view);
        }
    }

    public void a(final CircleImageView circleImageView, final String str) {
        if (!d.a(str)) {
            w.a(this.f27557a).a(m.a(str, true)).a(c.d.feeds_icn_default_avatar).b(c.d.feeds_icn_default_avatar).a((ImageView) circleImageView, (com.squareup.a.e) new com.squareup.a.e() {
                public void c() {
                    h.b("%s", "tagdbmod hashtag sus " + m.a(str, true));
                }

                public void d() {
                    h.b("%s", "tagdbmod hashtag err " + m.a(str, false));
                    w.a(SearchChooseProductAdapter.this.f27557a).a(m.a(str, false)).a(c.d.feeds_icn_default_avatar).b(c.d.feeds_icn_default_avatar).a((ImageView) circleImageView);
                }
            });
        } else {
            circleImageView.setImageResource(c.d.feeds_icn_default_avatar);
        }
    }

    public void a(c cVar) {
        this.f27501g = cVar;
    }
}
