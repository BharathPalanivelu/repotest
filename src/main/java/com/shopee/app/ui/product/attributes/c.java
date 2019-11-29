package com.shopee.app.ui.product.attributes;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.a.a.f;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.uikit.fluid.tagcloud.GTagCloud;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.data.viewmodel.VMItemAttribute;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.product.add.k;
import com.shopee.app.util.af;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class c extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    GTagCloud f24248a;

    /* renamed from: b  reason: collision with root package name */
    View f24249b;

    /* renamed from: c  reason: collision with root package name */
    View f24250c;

    /* renamed from: d  reason: collision with root package name */
    TextView f24251d;

    /* renamed from: e  reason: collision with root package name */
    ImageButton f24252e;

    /* renamed from: f  reason: collision with root package name */
    TextView f24253f;

    /* renamed from: g  reason: collision with root package name */
    EditText f24254g;
    r h;
    bc i;
    a j;
    ak k;
    b l;
    private VMItemAttribute m;
    /* access modifiers changed from: private */
    public String n = "";
    private String o;
    private u p;

    public interface a {
        void a(c cVar);
    }

    /* access modifiers changed from: package-private */
    public void d() {
    }

    public c(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.l = new b();
        this.i.a(this.j);
        this.j.a(this);
        this.f24248a.setAdapter(this.l);
        this.f24248a.setChildPadding(b.a.f7696g);
        this.f24248a.setLineMargin(b.a.f7696g);
        double b2 = (double) com.garena.android.appkit.tools.b.b();
        Double.isNaN(b2);
        double d2 = (double) b.a.n;
        Double.isNaN(d2);
        this.f24251d.setMaxWidth((int) ((b2 * 0.6d) - d2));
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j.c();
    }

    public void a(final VMItemAttribute vMItemAttribute) {
        this.m = vMItemAttribute;
        this.j.a(vMItemAttribute);
        f a2 = f.a(getContext());
        a2.a(vMItemAttribute.getDisplayName()).b();
        if (!vMItemAttribute.isMandatory()) {
            a2.a(SQLBuilder.BLANK + com.garena.android.appkit.tools.b.e(R.string.sp_label_model_optional)).a().a(b.a.f7696g).b(com.garena.android.appkit.tools.b.a(R.color.black50)).c().b();
        }
        this.f24252e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                com.shopee.app.ui.dialog.a.a(c.this.getContext(), "", vMItemAttribute.getToolTip(), (int) R.string.button_ok, 0);
            }
        });
        if (TextUtils.isEmpty(vMItemAttribute.getToolTip()) || !vMItemAttribute.isMandatory()) {
            this.f24252e.setVisibility(8);
        } else {
            this.f24252e.setVisibility(0);
        }
        a(false);
        if (vMItemAttribute.isSelfDefined()) {
            b(vMItemAttribute);
        } else if (vMItemAttribute.hasSubAttributes()) {
            d(vMItemAttribute);
        } else {
            c(vMItemAttribute);
        }
        a2.a(this.f24251d);
        if (TextUtils.isEmpty(vMItemAttribute.getPlaceHolder())) {
            String concat = com.garena.android.appkit.tools.b.e(R.string.sp_label_set).concat(SQLBuilder.BLANK).concat(vMItemAttribute.getDisplayName());
            this.f24253f.setHint(concat);
            this.f24254g.setHint(concat);
        } else {
            this.f24253f.setHint(vMItemAttribute.getPlaceHolder());
            this.f24254g.setHint(vMItemAttribute.getPlaceHolder());
        }
        this.f24249b.setVisibility(8);
        g();
    }

    private void b(VMItemAttribute vMItemAttribute) {
        this.f24249b.setVisibility(8);
        this.f24248a.setVisibility(8);
        this.f24253f.setVisibility(8);
        this.f24254g.setVisibility(0);
        int validateType = vMItemAttribute.getValidateType();
        if (validateType != 1) {
            if (validateType == 2) {
                this.f24254g.setInputType(1);
                return;
            } else if (!(validateType == 3 || validateType == 4)) {
                if (validateType == 6) {
                    this.f24254g.setFocusable(false);
                    this.f24254g.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            c cVar = c.this;
                            DatePickerDialog unused = cVar.a(cVar.f24254g);
                        }
                    });
                    return;
                }
                return;
            }
        }
        this.f24254g.setInputType(2);
    }

    /* access modifiers changed from: private */
    public DatePickerDialog a(final EditText editText) {
        DatePickerDialog datePickerDialog;
        int a2 = com.garena.android.appkit.tools.a.a.a(editText.getText().toString(), "ID");
        if (editText.getTag() == null && a2 != 0) {
            editText.setTag(Integer.valueOf(a2));
        }
        Calendar instance = Calendar.getInstance();
        if (a2 != 0) {
            instance.setTimeInMillis(((long) a2) * 1000);
        }
        int i2 = instance.get(1);
        int i3 = instance.get(2);
        int i4 = instance.get(5);
        AnonymousClass3 r5 = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                if (datePicker.isShown()) {
                    Calendar instance = Calendar.getInstance();
                    instance.set(i, i2, i3);
                    int timeInMillis = (int) (instance.getTimeInMillis() / 1000);
                    editText.setText(com.garena.android.appkit.tools.a.a.c(timeInMillis, "ID"));
                    editText.setTag(Integer.valueOf(timeInMillis));
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 21) {
            datePickerDialog = new DatePickerDialog(getContext(), R.style.SpinnerDateDialogTheme, r5, i2, i3, i4);
        } else {
            datePickerDialog = new DatePickerDialog(getContext(), r5, i2, i3, i4);
        }
        datePickerDialog.setButton(-2, com.garena.android.appkit.tools.b.e(R.string.sp_pick_time_cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        datePickerDialog.show();
        return datePickerDialog;
    }

    private void c(final VMItemAttribute vMItemAttribute) {
        this.f24249b.setVisibility(8);
        this.f24248a.setVisibility(8);
        this.f24254g.setVisibility(8);
        this.f24253f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.garena.android.appkit.tools.b.f(R.drawable.com_garena_shopee_ic_arrow_right), (Drawable) null);
        this.f24253f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                com.garena.android.appkit.b.b.a("ON_SELF_DEFINE_CLICKED", new com.garena.android.appkit.b.a(new u(vMItemAttribute.getAttrId(), c.this.n, 0)), b.a.UI_BUS);
            }
        });
    }

    private void d(final VMItemAttribute vMItemAttribute) {
        this.f24254g.setVisibility(8);
        this.f24253f.setVisibility(0);
        final List<String> subAttributes = vMItemAttribute.getSubAttributes();
        if (!af.a(subAttributes)) {
            if (subAttributes.size() <= 8) {
                this.l.a(vMItemAttribute.getAttrId(), subAttributes, vMItemAttribute.getInputType(), vMItemAttribute.getValidateType());
                this.f24253f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.garena.android.appkit.tools.b.f(R.drawable.com_garena_shopee_ic_arrow_down), (Drawable) null);
                this.f24248a.a();
            } else if (subAttributes.size() > 8) {
                this.l.a(vMItemAttribute.getAttrId(), new ArrayList(), vMItemAttribute.getInputType(), vMItemAttribute.getValidateType());
                this.f24249b.setVisibility(8);
                this.f24248a.setVisibility(8);
                this.f24253f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.garena.android.appkit.tools.b.f(R.drawable.com_garena_shopee_ic_arrow_right), (Drawable) null);
            }
            this.f24253f.setOnClickListener((View.OnClickListener) null);
            this.f24253f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (subAttributes.size() <= 8) {
                        if (c.this.f24248a.getVisibility() == 8) {
                            c.this.a(true);
                        } else {
                            c.this.a(false);
                        }
                    } else if (subAttributes.size() > 8) {
                        c.this.k.a(vMItemAttribute.getAttrId(), vMItemAttribute.getDisplayName(), vMItemAttribute.getSubAttributes().size(), vMItemAttribute.getModelId(), vMItemAttribute.getSignature(), c.this.n);
                    }
                }
            });
            return;
        }
        this.f24253f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.garena.android.appkit.tools.b.f(R.drawable.com_garena_shopee_ic_arrow_right), (Drawable) null);
        this.f24253f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                com.garena.android.appkit.b.b.a("ON_SELF_DEFINE_CLICKED", new com.garena.android.appkit.b.a(new u(vMItemAttribute.getAttrId(), c.this.n, 0)), b.a.UI_BUS);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i.b(this.j);
        this.j.d();
        this.j.b();
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        int a2 = this.l.a();
        int i2 = R.drawable.com_garena_shopee_ic_arrow_right;
        if (a2 <= 0) {
            this.f24253f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.garena.android.appkit.tools.b.f(R.drawable.com_garena_shopee_ic_arrow_right), (Drawable) null);
        } else if (z) {
            this.f24249b.setVisibility(0);
            this.f24248a.setVisibility(0);
            this.f24253f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.garena.android.appkit.tools.b.f(R.drawable.com_garena_shopee_ic_arrow_up), (Drawable) null);
        } else {
            this.f24249b.setVisibility(8);
            this.f24248a.setVisibility(8);
            if (this.l.a() <= 8) {
                i2 = R.drawable.com_garena_shopee_ic_arrow_down;
            }
            this.f24253f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.garena.android.appkit.tools.b.f(i2), (Drawable) null);
        }
    }

    public void a(u uVar) {
        u uVar2 = this.p;
        if (uVar2 != null && uVar2.e() && uVar != null && uVar.g()) {
            return;
        }
        if (!this.m.isSelfDefined() || this.f24254g.getText().length() <= 0 || uVar == null || !uVar.g()) {
            this.p = uVar;
            setAttributeSelected(uVar != null ? uVar.b() : "");
            setDisplayText(this.n);
            VMItemAttribute vMItemAttribute = this.m;
            if (vMItemAttribute != null && vMItemAttribute.hasSubAttributes()) {
                this.l.a(this.n);
                this.f24248a.a();
                a(false);
            }
            if (!k.f24081b) {
                return;
            }
            if (k.f24080a || (uVar != null && !TextUtils.isEmpty(uVar.b()))) {
                b();
            }
        }
    }

    private void setAttributeSelected(String str) {
        this.n = str;
        if (this.o == null) {
            u uVar = this.p;
            if (uVar != null && uVar.d()) {
                this.o = new String(this.n);
            }
        }
    }

    private void setDisplayText(String str) {
        if (this.m.isTimestampType()) {
            int i2 = -1;
            try {
                i2 = Integer.valueOf(str).intValue();
                this.f24254g.setTag(Integer.valueOf(i2));
            } catch (NumberFormatException e2) {
                com.garena.android.appkit.d.a.a(e2);
                this.f24254g.setTag(0);
            }
            str = i2 >= 0 ? com.garena.android.appkit.tools.a.a.c(i2, "ID") : "";
        }
        if (this.m.isSelfDefined()) {
            this.f24254g.setText(str);
        } else {
            this.f24253f.setText(str);
        }
    }

    public void a(VMItemAttribute vMItemAttribute, u uVar) {
        this.k.a(vMItemAttribute, vMItemAttribute.getSignature(), vMItemAttribute.getModelId(), uVar);
    }

    public u getSubmitAttributeData() {
        String str;
        if (!this.m.isSelfDefined()) {
            str = this.n;
        } else if (this.m.isTimestampType()) {
            str = String.valueOf(this.f24254g.getTag());
        } else {
            str = this.f24254g.getText().toString().trim();
        }
        com.garena.android.appkit.d.a.b("%d has selected: %s ", Integer.valueOf(this.m.getAttrId()), str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        u uVar = this.p;
        if (uVar != null) {
            return new u(uVar.a(), str, this.p.c());
        }
        return new u(this.m.getAttrId(), str, 0);
    }

    public u getAttributeValue() {
        String str;
        com.garena.android.appkit.d.a.b("%d has selected: %s ", Integer.valueOf(this.m.getAttrId()), this.n);
        if (!this.m.isSelfDefined()) {
            return this.p;
        }
        if (this.m.isTimestampType()) {
            str = this.f24254g.getTag() != null ? String.valueOf(this.f24254g.getTag()) : null;
        } else {
            str = this.f24254g.getText().toString().trim();
        }
        if (!TextUtils.isEmpty(str)) {
            return new u(this.m.getAttrId(), str, 0);
        }
        return null;
    }

    public void setSelectAttributeData(u uVar) {
        if (uVar == null || uVar.a() != this.m.getAttrId()) {
            a((u) null);
        } else {
            a(uVar);
        }
    }

    public int getAttributeId() {
        VMItemAttribute vMItemAttribute = this.m;
        if (vMItemAttribute != null) {
            return vMItemAttribute.getAttrId();
        }
        return 0;
    }

    public void b() {
        if (c()) {
            f();
            return;
        }
        boolean z = !TextUtils.isEmpty(this.n) || !TextUtils.isEmpty(this.f24254g.getText());
        if (!this.m.isMandatory() || z) {
            g();
        } else {
            f();
        }
    }

    public boolean c() {
        String str = this.o;
        return str != null && str.equals(this.n);
    }

    private void f() {
        this.f24250c.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
        this.f24252e.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.no_variation_highlight));
    }

    private void g() {
        this.f24250c.setBackgroundResource(R.drawable.bottom_border_white_background_highlight);
        this.f24252e.setBackgroundResource(R.drawable.white_background_corner);
    }

    public void e() {
        this.p = null;
        this.n = null;
        this.f24250c.setBackgroundResource(R.drawable.bottom_border_white_background_highlight);
    }

    private static class b implements GTagCloud.a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public List<String> f24268a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f24269b;

        /* renamed from: c  reason: collision with root package name */
        private int f24270c;

        /* renamed from: d  reason: collision with root package name */
        private int f24271d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public String f24272e;

        /* renamed from: f  reason: collision with root package name */
        private View.OnClickListener f24273f;

        /* renamed from: g  reason: collision with root package name */
        private View.OnClickListener f24274g;

        private b() {
            this.f24268a = new ArrayList();
            this.f24273f = new View.OnClickListener() {
                public void onClick(View view) {
                    com.garena.android.appkit.b.b.a("ON_ATTRIBUTE_SELECTED", new com.garena.android.appkit.b.a(new u(b.this.f24269b, (String) ((TextView) view).getTag(R.id.hash_tag_view), 1)), b.a.UI_BUS);
                }
            };
            this.f24274g = new View.OnClickListener() {
                public void onClick(View view) {
                    com.garena.android.appkit.b.b.a("ON_SELF_DEFINE_CLICKED", new com.garena.android.appkit.b.a(new u(b.this.f24269b, !b.this.f24268a.contains(b.this.f24272e) ? b.this.f24272e : "", 0)), b.a.UI_BUS);
                }
            };
        }

        public void a(int i, List<String> list, int i2, int i3) {
            this.f24269b = i;
            this.f24270c = i2;
            this.f24271d = i3;
            this.f24268a.clear();
            this.f24268a.addAll(list);
        }

        public int a() {
            return this.f24268a.size();
        }

        public View a(Context context, int i) {
            TextView textView = (TextView) View.inflate(context, R.layout.attribute_tag_layout, (ViewGroup) null);
            textView.setMinWidth(b.a.r);
            int i2 = b.a.f7694e;
            int i3 = b.a.f7694e;
            int i4 = b.a.f7695f;
            int i5 = b.a.f7695f;
            int i6 = this.f24270c;
            boolean z = true;
            if (i6 == 1) {
                a(textView, this.f24268a.get(i), this.f24271d);
                textView.setOnClickListener(this.f24273f);
            } else if (i6 == 3) {
                if (i == a() - 1) {
                    textView.setText("  " + com.garena.android.appkit.tools.b.e(R.string.sp_self_define));
                    Drawable f2 = com.garena.android.appkit.tools.b.f(R.drawable.com_garena_shopee_ic_arrow_right);
                    f2.setBounds(0, 0, textView.getLineHeight(), textView.getLineHeight());
                    textView.setCompoundDrawables((Drawable) null, (Drawable) null, f2, (Drawable) null);
                    textView.setOnClickListener(this.f24274g);
                } else {
                    a(textView, this.f24268a.get(i), this.f24271d);
                    textView.setOnClickListener(this.f24273f);
                }
            } else if (i6 == 2) {
                if (TextUtils.isEmpty(this.f24268a.get(i))) {
                    textView.setText("  " + com.garena.android.appkit.tools.b.e(R.string.sp_self_define));
                } else {
                    a(textView, this.f24268a.get(i), this.f24271d);
                }
                Drawable f3 = com.garena.android.appkit.tools.b.f(R.drawable.com_garena_shopee_ic_arrow_right);
                f3.setBounds(0, 0, textView.getLineHeight(), textView.getLineHeight());
                textView.setCompoundDrawables((Drawable) null, (Drawable) null, f3, (Drawable) null);
                textView.setOnClickListener(this.f24274g);
            }
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            textView.setPadding(i4, i2, i5, i3);
            if (TextUtils.isEmpty(this.f24272e) || !this.f24268a.get(i).equals(this.f24272e)) {
                z = false;
            }
            int i7 = z ? R.drawable.sub_cat_tag_background_selected : R.drawable.sub_cat_tag_background;
            int i8 = z ? R.color.primary : R.color.black54;
            textView.setBackgroundResource(i7);
            textView.setTextColor(com.garena.android.appkit.tools.b.a(i8));
            return textView;
        }

        private void a(TextView textView, String str, int i) {
            if (i == 6) {
                int i2 = 0;
                try {
                    i2 = Integer.valueOf(str).intValue();
                } catch (NumberFormatException e2) {
                    com.garena.android.appkit.d.a.a(e2);
                    textView.setTag(R.id.hash_tag_view, String.valueOf(0));
                }
                str = com.garena.android.appkit.tools.a.a.c(i2, "ID");
                textView.setTag(R.id.hash_tag_view, String.valueOf(i2));
            } else {
                textView.setTag(R.id.hash_tag_view, str);
            }
            textView.setText(str);
        }

        public void a(String str) {
            this.f24272e = str;
            if (!TextUtils.isEmpty(str) && !af.a(this.f24268a)) {
                this.f24268a.remove(str);
                this.f24268a.add(0, str);
            }
        }
    }
}
