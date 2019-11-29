package com.shopee.app.ui.home.me.editprofile;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.app.a;
import com.shopee.app.e.b;
import com.shopee.id.R;
import d.d.b.j;
import d.h.m;
import d.p;
import java.util.HashMap;

public final class EditProfileItemView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private String f22297a;

    /* renamed from: b  reason: collision with root package name */
    private String f22298b;

    /* renamed from: c  reason: collision with root package name */
    private String f22299c;

    /* renamed from: d  reason: collision with root package name */
    private int f22300d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f22301e;

    public EditProfileItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public EditProfileItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    public View a(int i) {
        if (this.f22301e == null) {
            this.f22301e = new HashMap();
        }
        View view = (View) this.f22301e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f22301e.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditProfileItemView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        View.inflate(context, R.layout.edit_profile_item_layout, this);
        a();
        int[] iArr = a.b.EditProfileItemView;
        j.a((Object) iArr, "R.styleable.EditProfileItemView");
        b.a(this, iArr, attributeSet, new d.d.a.b<TypedArray, p>(this) {
            final /* synthetic */ EditProfileItemView this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object a(Object obj) {
                a((TypedArray) obj);
                return p.f32714a;
            }

            public final void a(TypedArray typedArray) {
                j.b(typedArray, "$receiver");
                this.this$0.setTitle(typedArray.getString(2));
                this.this$0.setValue(typedArray.getString(3));
                this.this$0.setAction(typedArray.getString(0));
                this.this$0.setActionColor(typedArray.getColor(1, androidx.core.content.b.c(context, R.color.primary)));
            }
        });
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditProfileItemView(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final String getTitle() {
        return this.f22297a;
    }

    public final void setTitle(String str) {
        this.f22297a = str;
        RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.tv_title);
        j.a((Object) robotoTextView, "tv_title");
        robotoTextView.setText(str);
    }

    /* access modifiers changed from: private */
    public final void setValue(String str) {
        this.f22298b = str;
        RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.tv_value);
        j.a((Object) robotoTextView, "tv_value");
        robotoTextView.setText(str);
    }

    public final String getAction() {
        return this.f22299c;
    }

    public final void setAction(String str) {
        this.f22299c = str;
        RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.tv_action);
        j.a((Object) robotoTextView, "tv_action");
        robotoTextView.setText(str);
    }

    /* access modifiers changed from: private */
    public final void setActionColor(int i) {
        this.f22300d = i;
        ((RobotoTextView) a(a.C0250a.tv_action)).setTextColor(this.f22300d);
    }

    private final void a() {
        setBackgroundResource(R.drawable.bottom_border_white_background_highlight);
        Context context = getContext();
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                setMinimumHeight(resources.getDimensionPixelOffset(R.dimen.dp48));
                int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.dp12);
                int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.dp16);
                setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
            }
        }
    }

    private final void setActionBtnVisibility(int i) {
        RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.tv_action);
        j.a((Object) robotoTextView, "tv_action");
        robotoTextView.setVisibility(i);
    }

    public final void setValueAndActionBtnVisibility(String str) {
        CharSequence charSequence = str;
        int i = 0;
        if (!(charSequence == null || m.a(charSequence))) {
            i = 8;
        }
        a(str, i);
    }

    public final void a(String str, int i) {
        CharSequence charSequence = str;
        if (charSequence == null || m.a(charSequence)) {
            str = "";
        }
        setValue(str);
        setActionBtnVisibility(i);
    }
}
