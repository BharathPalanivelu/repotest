package com.shopee.app.ui.setting.cell;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.app.a;
import com.shopee.app.e.b;
import com.shopee.id.R;
import d.d.b.j;
import d.p;
import java.util.HashMap;

public final class SettingWithSelectionItemView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f25190a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f25191b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f25192c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f25193d;

    public SettingWithSelectionItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public SettingWithSelectionItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    public View a(int i) {
        if (this.f25193d == null) {
            this.f25193d = new HashMap();
        }
        View view = (View) this.f25193d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f25193d.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SettingWithSelectionItemView(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettingWithSelectionItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        this.f25190a = "";
        this.f25191b = "";
        this.f25192c = true;
        View.inflate(context, R.layout.setting_with_selection_item_layout, this);
        int[] iArr = a.b.SettingWithSelectionItemView;
        j.a((Object) iArr, "R.styleable.SettingWithSelectionItemView");
        b.a(this, iArr, attributeSet, new d.d.a.b<TypedArray, p>(this) {
            final /* synthetic */ SettingWithSelectionItemView this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object a(Object obj) {
                a((TypedArray) obj);
                return p.f32714a;
            }

            public final void a(TypedArray typedArray) {
                j.b(typedArray, "$receiver");
                SettingWithSelectionItemView settingWithSelectionItemView = this.this$0;
                String string = typedArray.getString(0);
                String str = "";
                if (string == null) {
                    string = str;
                }
                settingWithSelectionItemView.f25190a = string;
                SettingWithSelectionItemView settingWithSelectionItemView2 = this.this$0;
                String string2 = typedArray.getString(1);
                if (string2 != null) {
                    str = string2;
                }
                settingWithSelectionItemView2.f25191b = str;
                this.this$0.f25192c = typedArray.getBoolean(2, true);
            }
        });
        setPrimaryText(this.f25190a);
        setSelectionText(this.f25191b);
        setRightArrowVisibility(this.f25192c);
        setBackgroundResource(R.drawable.read_bg_with_highlight_new);
    }

    public final void setSelectionText(String str) {
        j.b(str, "selectionText");
        this.f25191b = str;
        RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.selection_text);
        j.a((Object) robotoTextView, "selection_text");
        robotoTextView.setText(str);
    }

    private final void setPrimaryText(String str) {
        this.f25190a = str;
        RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.primary_text);
        j.a((Object) robotoTextView, "primary_text");
        robotoTextView.setText(str);
    }

    private final void setRightArrowVisibility(boolean z) {
        this.f25192c = z;
        ImageView imageView = (ImageView) a(a.C0250a.imv_right_arrow);
        j.a((Object) imageView, "imv_right_arrow");
        imageView.setVisibility(z ? 0 : 8);
    }
}
