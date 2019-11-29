package com.shopee.app.ui.product.attributes;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.garena.android.appkit.f.f;
import com.garena.android.appkit.tools.b;
import com.shopee.app.h.q;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import java.util.Calendar;

public class n extends LinearLayout implements com.shopee.app.ui.a.n<v> {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static DatePickerDialog f24316g;

    /* renamed from: a  reason: collision with root package name */
    EditText f24317a;

    /* renamed from: b  reason: collision with root package name */
    Button f24318b;

    /* renamed from: c  reason: collision with root package name */
    r f24319c;

    /* renamed from: d  reason: collision with root package name */
    bc f24320d;

    /* renamed from: e  reason: collision with root package name */
    m f24321e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public v f24322f;
    private Runnable h = new Runnable() {
        public void run() {
            if (n.this.f24322f != null) {
                if (n.this.f24322f.d()) {
                    if (n.f24316g == null) {
                        n nVar = n.this;
                        DatePickerDialog unused = n.f24316g = nVar.a(nVar.f24317a);
                    } else if (!n.f24316g.isShowing()) {
                        n.f24316g.hide();
                        n nVar2 = n.this;
                        DatePickerDialog unused2 = n.f24316g = nVar2.a(nVar2.f24317a);
                    }
                } else if (n.this.f24322f.c() && n.this.f24317a != null) {
                    com.shopee.app.c.a.b(n.this.f24317a);
                }
            }
        }
    };

    public interface a {
        void a(n nVar);
    }

    public n(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24320d.a(this.f24321e);
        this.f24321e.a(this);
    }

    /* access modifiers changed from: package-private */
    public void setOnTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.f24317a.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void a(v vVar) {
        v vVar2 = this.f24322f;
        if (vVar2 == null || vVar2.f24347a != vVar.f24347a || !this.f24322f.equals(vVar)) {
            this.f24322f = vVar;
            int i = vVar.f24350d;
            if (i != 1) {
                if (i == 2) {
                    this.f24317a.setInputType(1);
                } else if (!(i == 3 || i == 4)) {
                    if (i == 6) {
                        this.f24317a.setFocusable(false);
                        this.f24317a.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                n nVar = n.this;
                                DatePickerDialog unused = nVar.a(nVar.f24317a);
                            }
                        });
                    }
                }
                this.f24318b.setEnabled(false);
                this.f24317a.addTextChangedListener(new TextWatcher() {
                    public void afterTextChanged(Editable editable) {
                    }

                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        if (charSequence.length() > 0) {
                            n.this.f24318b.setEnabled(true);
                        } else {
                            n.this.f24318b.setEnabled(false);
                        }
                    }
                });
                b();
            }
            this.f24317a.setInputType(2);
            this.f24318b.setEnabled(false);
            this.f24317a.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (charSequence.length() > 0) {
                        n.this.f24318b.setEnabled(true);
                    } else {
                        n.this.f24318b.setEnabled(false);
                    }
                }
            });
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!TextUtils.isEmpty(this.f24322f.f24352f)) {
            e();
            EditText editText = this.f24317a;
            int i = 50;
            if (this.f24322f.f24352f.length() <= 50) {
                i = this.f24322f.f24352f.length();
            }
            editText.setSelection(i);
        }
        if (this.f24322f.b()) {
            this.f24317a.setHint(R.string.sp_self_define);
            f.a().a(this.h, IjkMediaCodecInfo.RANK_LAST_CHANCE);
            return;
        }
        this.f24317a.setHint(R.string.sp_no_attribute_found);
    }

    private void e() {
        int i;
        if (this.f24322f.d()) {
            try {
                i = Integer.valueOf(this.f24322f.f24352f).intValue();
            } catch (NumberFormatException unused) {
                i = 0;
            }
            this.f24317a.setTag(Integer.valueOf(i));
            this.f24317a.setText(com.garena.android.appkit.tools.a.a.c(i, "ID"));
            return;
        }
        this.f24317a.setText(this.f24322f.f24352f);
    }

    /* access modifiers changed from: private */
    public DatePickerDialog a(final EditText editText) {
        int i;
        int i2;
        DatePickerDialog datePickerDialog;
        int a2 = com.garena.android.appkit.tools.a.a.a(editText.getText().toString(), "ID");
        if (editText.getTag() == null && a2 != 0) {
            editText.setTag(Integer.valueOf(a2));
        }
        int i3 = 1;
        if (editText.getTag() != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(((long) ((Integer) editText.getTag()).intValue()) * 1000);
            int i4 = instance.get(1);
            i = instance.get(2);
            int i5 = i4;
            i3 = instance.get(5);
            i2 = i5;
        } else {
            i2 = 1985;
            i = 0;
        }
        AnonymousClass4 r6 = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                if (datePicker.isShown()) {
                    Calendar instance = Calendar.getInstance();
                    instance.set(i, i2, i3);
                    if (instance.getTimeInMillis() < com.garena.android.appkit.tools.a.a.b()) {
                        int timeInMillis = (int) (instance.getTimeInMillis() / 1000);
                        editText.setText(com.garena.android.appkit.tools.a.a.c(timeInMillis, "ID"));
                        editText.setTag(Integer.valueOf(timeInMillis));
                        return;
                    }
                    n.this.a(b.e(R.string.sp_birthday_invalid));
                }
            }
        };
        if (Build.VERSION.SDK_INT >= 21) {
            datePickerDialog = new DatePickerDialog(getContext(), R.style.SpinnerDateDialogTheme, r6, i2, i, i3);
        } else {
            datePickerDialog = new DatePickerDialog(getContext(), r6, i2, i, i3);
        }
        datePickerDialog.setButton(-2, b.e(R.string.sp_pick_time_cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        datePickerDialog.show();
        return datePickerDialog;
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    private String getAttributeValue() {
        if (this.f24322f.d()) {
            return String.valueOf(this.f24317a.getTag());
        }
        return this.f24317a.getText().toString();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        String attributeValue = getAttributeValue();
        if (attributeValue.length() > 0) {
            this.f24321e.a(this.f24322f, attributeValue);
        }
    }
}
