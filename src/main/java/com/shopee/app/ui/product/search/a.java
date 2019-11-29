package com.shopee.app.ui.product.search;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.app.data.viewmodel.CuratedHint;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.ui.a.n;
import com.shopee.id.R;
import com.squareup.a.ah;
import com.squareup.a.w;
import d.d.b.j;
import d.h.m;

public class a extends RelativeLayout implements n<SearchProductItem> {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f24780a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24781b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24782c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24783d;

    /* renamed from: e  reason: collision with root package name */
    private C0381a f24784e;

    /* renamed from: com.shopee.app.ui.product.search.a$a  reason: collision with other inner class name */
    public interface C0381a {
        void a(String str, String str2, int i, int i2, SearchProductItem searchProductItem);
    }

    public a(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
    }

    public ImageView getImageView() {
        ImageView imageView = this.f24780a;
        if (imageView == null) {
            j.b("imageView");
        }
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        j.b(imageView, "<set-?>");
        this.f24780a = imageView;
    }

    public TextView getHintText() {
        TextView textView = this.f24781b;
        if (textView == null) {
            j.b("hintText");
        }
        return textView;
    }

    public void setHintText(TextView textView) {
        j.b(textView, "<set-?>");
        this.f24781b = textView;
    }

    public TextView getTag1Text() {
        TextView textView = this.f24782c;
        if (textView == null) {
            j.b("tag1Text");
        }
        return textView;
    }

    public void setTag1Text(TextView textView) {
        j.b(textView, "<set-?>");
        this.f24782c = textView;
    }

    public TextView getTag2Text() {
        TextView textView = this.f24783d;
        if (textView == null) {
            j.b("tag2Text");
        }
        return textView;
    }

    public void setTag2Text(TextView textView) {
        j.b(textView, "<set-?>");
        this.f24783d = textView;
    }

    public C0381a getOnClickListener() {
        return this.f24784e;
    }

    public void setOnClickListener(C0381a aVar) {
        this.f24784e = aVar;
    }

    public void a() {
        int d2 = com.garena.android.appkit.tools.b.d(R.dimen.spacing_normal);
        int d3 = com.garena.android.appkit.tools.b.d(R.dimen.spacing_small);
        setPadding(d2, d3, d2, d3);
        setMinimumHeight(com.garena.android.appkit.tools.b.d(R.dimen.dp48));
        setBackgroundResource(R.drawable.white_background_hightlight);
    }

    public void a(SearchProductItem searchProductItem) {
        Object tag = getTag(R.id.view_position);
        Object obj = null;
        if (!(tag instanceof Integer)) {
            tag = null;
        }
        Integer num = (Integer) tag;
        int intValue = num != null ? num.intValue() : 0;
        if (searchProductItem != null) {
            obj = searchProductItem.getExtra();
        }
        if (obj instanceof CuratedHint) {
            CuratedHint curatedHint = (CuratedHint) obj;
            a(curatedHint.getImage());
            getHintText().setText(curatedHint.getName());
            getImageView().setOnClickListener(new b(this, obj, intValue, searchProductItem));
            CharSequence tag_name_1 = curatedHint.getTag_name_1();
            boolean z = true;
            if (tag_name_1 == null || m.a(tag_name_1)) {
                getTag1Text().setText("");
                getTag1Text().setVisibility(8);
            } else {
                getTag1Text().setVisibility(0);
                getTag1Text().setText(curatedHint.getTag_name_1());
                getTag1Text().setOnClickListener(new c(this, obj, intValue, searchProductItem));
            }
            CharSequence tag_name_2 = curatedHint.getTag_name_2();
            if (tag_name_2 != null && !m.a(tag_name_2)) {
                z = false;
            }
            if (z) {
                getTag2Text().setText("");
                getTag2Text().setVisibility(8);
                return;
            }
            getTag2Text().setVisibility(0);
            getTag2Text().setText(curatedHint.getTag_name_2());
            getTag2Text().setOnClickListener(new d(this, obj, intValue, searchProductItem));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f24786a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f24787b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f24788c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SearchProductItem f24789d;

        b(a aVar, Object obj, int i, SearchProductItem searchProductItem) {
            this.f24786a = aVar;
            this.f24787b = obj;
            this.f24788c = i;
            this.f24789d = searchProductItem;
        }

        public final void onClick(View view) {
            this.f24786a.a(((CuratedHint) this.f24787b).getUrl(), ((CuratedHint) this.f24787b).getName(), 0, this.f24788c, this.f24789d);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f24790a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f24791b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f24792c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SearchProductItem f24793d;

        c(a aVar, Object obj, int i, SearchProductItem searchProductItem) {
            this.f24790a = aVar;
            this.f24791b = obj;
            this.f24792c = i;
            this.f24793d = searchProductItem;
        }

        public final void onClick(View view) {
            this.f24790a.a(((CuratedHint) this.f24791b).getTag_url_1(), ((CuratedHint) this.f24791b).getName(), 1, this.f24792c, this.f24793d);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f24794a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f24795b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f24796c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SearchProductItem f24797d;

        d(a aVar, Object obj, int i, SearchProductItem searchProductItem) {
            this.f24794a = aVar;
            this.f24795b = obj;
            this.f24796c = i;
            this.f24797d = searchProductItem;
        }

        public final void onClick(View view) {
            this.f24794a.a(((CuratedHint) this.f24795b).getTag_url_2(), ((CuratedHint) this.f24795b).getName(), 2, this.f24796c, this.f24797d);
        }
    }

    private void a(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || m.a(charSequence)) {
            getImageView().setImageBitmap((Bitmap) null);
            getImageView().setVisibility(8);
            return;
        }
        getImageView().setVisibility(0);
        w a2 = w.a(getContext());
        a2.a("http://cf.shopee.co.id/file/" + str).a().a((int) R.drawable.com_garena_shopee_ic_product_default_circle).a((ah) new com.shopee.app.util.j(false)).a(getImageView());
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, int i, int i2, SearchProductItem searchProductItem) {
        if (str != null && str2 != null && searchProductItem != null) {
            C0381a onClickListener = getOnClickListener();
            if (onClickListener != null) {
                onClickListener.a(str, str2, i, i2, searchProductItem);
            }
        }
    }
}
