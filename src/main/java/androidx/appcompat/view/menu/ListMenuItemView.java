package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ar;
import androidx.core.g.w;

public class ListMenuItemView extends LinearLayout implements AbsListView.SelectionBoundsAdjuster, n.a {

    /* renamed from: a  reason: collision with root package name */
    private i f794a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f795b;

    /* renamed from: c  reason: collision with root package name */
    private RadioButton f796c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f797d;

    /* renamed from: e  reason: collision with root package name */
    private CheckBox f798e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f799f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f800g;
    private ImageView h;
    private LinearLayout i;
    private Drawable j;
    private int k;
    private Context l;
    private boolean m;
    private Drawable n;
    private boolean o;
    private int p;
    private LayoutInflater q;
    private boolean r;

    public boolean a() {
        return false;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0012a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        ar a2 = ar.a(getContext(), attributeSet, a.j.MenuView, i2, 0);
        this.j = a2.a(a.j.MenuView_android_itemBackground);
        this.k = a2.g(a.j.MenuView_android_itemTextAppearance, -1);
        this.m = a2.a(a.j.MenuView_preserveIconSpacing, false);
        this.l = context;
        this.n = a2.a(a.j.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, a.C0012a.dropDownListViewStyle, 0);
        this.o = obtainStyledAttributes.hasValue(0);
        a2.a();
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        w.a((View) this, this.j);
        this.f797d = (TextView) findViewById(a.f.title);
        int i2 = this.k;
        if (i2 != -1) {
            this.f797d.setTextAppearance(this.l, i2);
        }
        this.f799f = (TextView) findViewById(a.f.shortcut);
        this.f800g = (ImageView) findViewById(a.f.submenuarrow);
        ImageView imageView = this.f800g;
        if (imageView != null) {
            imageView.setImageDrawable(this.n);
        }
        this.h = (ImageView) findViewById(a.f.group_divider);
        this.i = (LinearLayout) findViewById(a.f.content);
    }

    public void a(i iVar, int i2) {
        this.f794a = iVar;
        this.p = i2;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.a((n.a) this));
        setCheckable(iVar.isCheckable());
        a(iVar.f(), iVar.d());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    private void a(View view) {
        a(view, -1);
    }

    private void a(View view, int i2) {
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    public void setForceShowIcon(boolean z) {
        this.r = z;
        this.m = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f797d.setText(charSequence);
            if (this.f797d.getVisibility() != 0) {
                this.f797d.setVisibility(0);
            }
        } else if (this.f797d.getVisibility() != 8) {
            this.f797d.setVisibility(8);
        }
    }

    public i getItemData() {
        return this.f794a;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f796c != null || this.f798e != null) {
            if (this.f794a.g()) {
                if (this.f796c == null) {
                    c();
                }
                compoundButton2 = this.f796c;
                compoundButton = this.f798e;
            } else {
                if (this.f798e == null) {
                    d();
                }
                compoundButton2 = this.f798e;
                compoundButton = this.f796c;
            }
            if (z) {
                compoundButton2.setChecked(this.f794a.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f798e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f796c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f794a.g()) {
            if (this.f796c == null) {
                c();
            }
            compoundButton = this.f796c;
        } else {
            if (this.f798e == null) {
                d();
            }
            compoundButton = this.f798e;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f800g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void a(boolean z, char c2) {
        int i2 = (!z || !this.f794a.f()) ? 8 : 0;
        if (i2 == 0) {
            this.f799f.setText(this.f794a.e());
        }
        if (this.f799f.getVisibility() != i2) {
            this.f799f.setVisibility(i2);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f794a.i() || this.r;
        if (!z && !this.m) {
            return;
        }
        if (this.f795b != null || drawable != null || this.m) {
            if (this.f795b == null) {
                b();
            }
            if (drawable != null || this.m) {
                ImageView imageView = this.f795b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f795b.getVisibility() != 0) {
                    this.f795b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f795b.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f795b != null && this.m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f795b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i2, i3);
    }

    private void b() {
        this.f795b = (ImageView) getInflater().inflate(a.g.abc_list_menu_item_icon, this, false);
        a((View) this.f795b, 0);
    }

    private void c() {
        this.f796c = (RadioButton) getInflater().inflate(a.g.abc_list_menu_item_radio, this, false);
        a(this.f796c);
    }

    private void d() {
        this.f798e = (CheckBox) getInflater().inflate(a.g.abc_list_menu_item_checkbox, this, false);
        a(this.f798e);
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility((this.o || !z) ? 8 : 0);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
            rect.top += this.h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }
}
