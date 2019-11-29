package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.airpay.paysdk.c;

public class BSSectionPureTextItemView extends i {

    /* renamed from: c  reason: collision with root package name */
    protected EditText f3883c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f3884d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f3885e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f3886f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f3887g = null;
    private int h = 0;
    private int i = -1;
    private int j = -1;
    private int k = -1;
    private TextView l;

    public void a() {
    }

    public BSSectionPureTextItemView(Context context, String str) {
        super(context);
        this.f3884d = str;
        a(context);
    }

    public BSSectionPureTextItemView(Context context, String str, String str2) {
        super(context);
        this.f3884d = str;
        this.f3885e = str2;
        a(context);
    }

    public BSSectionPureTextItemView(Context context, String str, String str2, int i2) {
        super(context);
        this.f3884d = str;
        this.f3885e = str2;
        this.h = i2;
        a(context);
    }

    public BSSectionPureTextItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.k.BSSectionPureTextItemView);
        this.f3884d = obtainStyledAttributes.getString(c.k.BSSectionPureTextItemView_spt_text_title);
        this.f3885e = obtainStyledAttributes.getString(c.k.BSSectionPureTextItemView_spt_description);
        this.h = obtainStyledAttributes.getDimensionPixelSize(c.k.BSSectionPureTextItemView_spt_description_minheight, this.h);
        this.i = obtainStyledAttributes.getColor(c.k.BSSectionPureTextItemView_spt_description_color, this.i);
        this.j = obtainStyledAttributes.getInt(c.k.BSSectionPureTextItemView_spt_description_gravity, this.j);
        this.f3886f = obtainStyledAttributes.getString(c.k.BSSectionPureTextItemView_spt_description_hint);
        this.f3887g = obtainStyledAttributes.getString(c.k.BSSectionPureTextItemView_spt_footer_text);
        this.k = obtainStyledAttributes.getColor(c.k.BSSectionPureTextItemView_spt_title_color, this.k);
        obtainStyledAttributes.recycle();
        a(context);
    }

    public int getLayoutID() {
        return c.h.com_garena_beepay_section_pure_text_item;
    }

    public void b() {
        this.l = (TextView) findViewWithTag("field_title");
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(this.f3884d);
            int i2 = this.k;
            if (i2 != -1) {
                this.l.setTextColor(i2);
            }
        }
        this.f3883c = (EditText) findViewWithTag("field_edit");
        EditText editText = this.f3883c;
        if (editText != null) {
            editText.setText(this.f3885e);
            this.f3883c.setHint(this.f3886f);
            if (!this.f3945a) {
                this.f3883c.setEnabled(false);
                this.f3883c.setCursorVisible(false);
                this.f3883c.setKeyListener((KeyListener) null);
                this.f3883c.setBackgroundColor(0);
            }
            this.f3883c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f3946b)});
            int i3 = this.h;
            if (i3 != 0) {
                this.f3883c.setMinHeight(i3);
            }
            int i4 = this.i;
            if (i4 != -1) {
                this.f3883c.setTextColor(i4);
            }
            int i5 = this.j;
            if (i5 != -1) {
                if (i5 == 0) {
                    this.f3883c.setGravity(17);
                } else if (i5 == 1) {
                    this.f3883c.setGravity(19);
                } else if (i5 == 2) {
                    this.f3883c.setGravity(21);
                }
            }
        }
        View footer = getFooter();
        if (footer != null && (footer instanceof TextView)) {
            ((TextView) footer).setText(this.f3887g);
        }
    }

    public View getFooter() {
        return findViewWithTag("field_footer");
    }

    public void setFooterText(String str) {
        View footer = getFooter();
        if (footer != null && (footer instanceof TextView)) {
            ((TextView) footer).setText(str);
        }
    }

    public void setTitleColor(int i2) {
        this.l.setTextColor(i2);
    }

    public void setTitleColor(ColorStateList colorStateList) {
        this.l.setTextColor(colorStateList);
    }

    public void setTitle(String str) {
        this.l.setText(str);
    }

    public void setTitle(int i2) {
        this.l.setText(i2);
    }

    public void setDescription(String str) {
        this.f3883c.setText(str);
    }

    public String getDescription() {
        Editable text = this.f3883c.getText();
        if (text == null) {
            return null;
        }
        return text.toString();
    }

    public void setDescription(int i2) {
        this.f3883c.setText(i2);
    }

    public EditText getEditField() {
        return this.f3883c;
    }

    public void setKeyBoardType(int i2) {
        this.f3883c.setInputType(i2);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        super.dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        EditText editText = this.f3883c;
        return editText != null ? new SavedState(onSaveInstanceState, editText.getText().toString()) : onSaveInstanceState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        EditText editText = this.f3883c;
        if (editText != null) {
            editText.setText(savedState.a());
        }
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final String f3888a;

        private SavedState(Parcelable parcelable, String str) {
            super(parcelable);
            this.f3888a = str;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f3888a = parcel.readString();
        }

        public String a() {
            return this.f3888a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f3888a);
        }
    }
}
