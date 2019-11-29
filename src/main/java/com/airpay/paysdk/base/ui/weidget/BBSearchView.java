package com.airpay.paysdk.base.ui.weidget;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airpay.paysdk.c;
import java.util.ArrayList;
import java.util.Iterator;

public class BBSearchView extends LinearLayout implements View.OnKeyListener, TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    private EditText f3854a;

    /* renamed from: b  reason: collision with root package name */
    private TextWatcher f3855b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<b> f3856c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f3857d;

    /* renamed from: e  reason: collision with root package name */
    private int f3858e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f3859f;

    public interface a {
        void a();

        void a(String str);
    }

    public interface b {
        void a(int i);
    }

    public void a() {
        if (this.f3858e != 1) {
            a(1);
            setVisibility(0);
            TextWatcher textWatcher = this.f3855b;
            if (textWatcher != null) {
                this.f3854a.addTextChangedListener(textWatcher);
            }
            this.f3854a.requestFocus();
            this.f3854a.setOnKeyListener(this);
            d.b(this.f3854a);
            setBackgroundResource(c.b.com_garena_beepay_common_white_bg);
        }
    }

    public void b() {
        if (this.f3858e != 0) {
            a(0);
            setVisibility(8);
            TextWatcher textWatcher = this.f3855b;
            if (textWatcher != null) {
                this.f3854a.removeTextChangedListener(textWatcher);
            }
            this.f3854a.setText("");
            this.f3854a.setOnKeyListener((View.OnKeyListener) null);
            d.a((View) this.f3854a);
            d();
            setBackgroundResource(c.b.transparent);
        }
    }

    private void d() {
        a aVar = this.f3857d;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void a(int i) {
        this.f3858e = i;
        ArrayList<b> arrayList = this.f3856c;
        if (arrayList != null) {
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(i);
            }
        }
    }

    public void setQueryChangedListener(a aVar) {
        EditText editText = this.f3854a;
        if (editText != null) {
            TextWatcher textWatcher = this.f3855b;
            if (textWatcher != null) {
                editText.removeTextChangedListener(textWatcher);
            }
            this.f3857d = aVar;
            this.f3855b = new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    if (editable != null && BBSearchView.this.f3859f) {
                        BBSearchView.this.f3857d.a(editable.toString().trim());
                    }
                }
            };
            this.f3854a.addTextChangedListener(this.f3855b);
        }
    }

    public void c() {
        if (this.f3858e != 0) {
            d();
            a(0);
        }
        this.f3854a.setOnEditorActionListener((TextView.OnEditorActionListener) null);
        this.f3856c = null;
        this.f3857d = null;
    }

    public void setSearchOnTextChange(boolean z) {
        this.f3859f = z;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        if (this.f3858e == 1) {
            b();
        }
        return true;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        d.a((View) this.f3854a);
        if (this.f3859f) {
            return true;
        }
        this.f3857d.a(textView.getText().toString().trim());
        return true;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i = savedState.f3861a;
        if (i == 0) {
            b();
        } else if (i == 1) {
            a();
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f3858e);
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
        public final int f3861a;

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f3861a = i;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f3861a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3861a);
        }
    }
}
