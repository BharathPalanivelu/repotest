package com.shopee.app.g;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.facebook.appevents.AppEventsConstants;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.ui.common.d;
import com.shopee.id.R;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, a> f17493a = new HashMap<String, a>() {
        {
            put("THB", new a("฿", false, '.', ','));
            put("MYR", new a("RM", true, '.', ','));
            put("PHP", new a("₱", false, '.', ','));
            put("IDR", new a("Rp", false, ',', '.'));
            put("SGD", new a("$", true, '.', ','));
            put("VND", new a("₫", false, ',', '.'));
            put("TWD", new a("$", false, '.', ','));
            put("IRR", new a("تومان", false, '.', ','));
            put("HKD", new a("$", false, '.', ','));
            put("MMK", new a("Ks", false, '.', ','));
        }
    };

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f17499a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f17500b;

        /* renamed from: c  reason: collision with root package name */
        public char f17501c;

        /* renamed from: d  reason: collision with root package name */
        public char f17502d;

        /* renamed from: e  reason: collision with root package name */
        private DecimalFormat f17503e;

        /* renamed from: f  reason: collision with root package name */
        private DecimalFormat f17504f;

        public a(String str, boolean z, char c2, char c3) {
            this.f17499a = str;
            this.f17500b = z;
            this.f17501c = c2;
            this.f17502d = c3;
        }

        public synchronized DecimalFormat a(boolean z) {
            if (z) {
                if (this.f17503e != null) {
                    return this.f17503e;
                }
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator(this.f17501c);
                decimalFormatSymbols.setGroupingSeparator(this.f17502d);
                decimalFormatSymbols.setMonetaryDecimalSeparator(this.f17501c);
                DecimalFormat decimalFormat = new DecimalFormat();
                if (this.f17500b) {
                    decimalFormat.setMaximumFractionDigits(2);
                    decimalFormat.setMinimumFractionDigits(2);
                } else {
                    decimalFormat.setMaximumFractionDigits(0);
                }
                decimalFormat.setGroupingUsed(true);
                decimalFormat.setGroupingSize(3);
                decimalFormat.setRoundingMode(RoundingMode.DOWN);
                decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
                this.f17503e = decimalFormat;
                return this.f17503e;
            } else if (this.f17504f != null) {
                return this.f17504f;
            } else {
                DecimalFormatSymbols decimalFormatSymbols2 = new DecimalFormatSymbols();
                decimalFormatSymbols2.setDecimalSeparator(this.f17501c);
                decimalFormatSymbols2.setGroupingSeparator(this.f17502d);
                decimalFormatSymbols2.setMonetaryDecimalSeparator(this.f17501c);
                DecimalFormat decimalFormat2 = new DecimalFormat();
                if (this.f17500b) {
                    decimalFormat2.setMaximumFractionDigits(2);
                } else {
                    decimalFormat2.setMaximumFractionDigits(0);
                }
                decimalFormat2.setGroupingUsed(true);
                decimalFormat2.setGroupingSize(3);
                decimalFormat2.setRoundingMode(RoundingMode.DOWN);
                decimalFormat2.setDecimalFormatSymbols(decimalFormatSymbols2);
                this.f17504f = decimalFormat2;
                return this.f17504f;
            }
        }
    }

    public static String a(String str) {
        return d(str).f17499a;
    }

    public static int b(String str) {
        a d2 = d("IDR");
        if (d2.f17500b && str.contains(String.valueOf(d2.f17501c))) {
            if (str.endsWith("00")) {
                return 2;
            }
            if (str.endsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                return 1;
            }
        }
        return 0;
    }

    public static Long a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Long.valueOf(new BigDecimal(b(str, str2)).multiply(new BigDecimal(d.f7007a)).longValue());
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String b(String str, String str2) {
        return str.replace(a(str2), "").replace(String.valueOf(d(str2).f17502d), "");
    }

    public static String c(String str) {
        return b(str, "IDR");
    }

    public static a d(String str) {
        if (str == null || str.isEmpty()) {
            str = "IDR";
        }
        a aVar = f17493a.get(str.toUpperCase());
        return aVar == null ? f17493a.get("IDR".toUpperCase()) : aVar;
    }

    public static String a(long j, String str, boolean z) {
        return a(j, str, z, true);
    }

    public static String a(long j, String str, boolean z, boolean z2) {
        return a(j, str, z, z2, d(str));
    }

    public static String a(long j, String str, boolean z, boolean z2, a aVar) {
        NumberFormat numberFormat;
        double doubleValue = new BigDecimal(j).divide(new BigDecimal(d.f7007a)).doubleValue();
        if (aVar == null) {
            return str + String.valueOf(doubleValue);
        }
        if (TextUtils.isEmpty(str) || !str.equals("IRR")) {
            numberFormat = aVar.a(z2);
        } else {
            numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
        }
        if (z) {
            return c(aVar.f17499a, numberFormat.format(doubleValue));
        }
        return numberFormat.format(doubleValue);
    }

    private static String c(String str, String str2) {
        if (str.equalsIgnoreCase(f17493a.get("IRR").f17499a)) {
            return str2 + str;
        }
        return str + str2;
    }

    public static void a(final EditText editText) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    try {
                        Long a2 = e.a(editText.getText().toString(), "IDR");
                        if (!(a2 == null || a2.longValue() == 0 || editText.getText().toString().length() <= 0 || editText.getSelectionEnd() == 0)) {
                            String obj = editText.getText().toString();
                            editText.setText("");
                            editText.append(obj);
                        }
                    } catch (NumberFormatException unused) {
                    }
                    com.shopee.app.c.a.b(editText);
                }
            }
        });
    }

    public static void a(final EditText editText, final SettingConfigStore settingConfigStore) {
        editText.addTextChangedListener(new TextWatcher() {

            /* renamed from: c  reason: collision with root package name */
            private boolean f17497c = false;

            /* renamed from: d  reason: collision with root package name */
            private String f17498d = "";

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f17497c = TextUtils.isEmpty(charSequence);
            }

            public void afterTextChanged(Editable editable) {
                String str;
                int length = editText.getText().length();
                if (length != 0) {
                    String str2 = this.f17498d;
                    if (str2 == null || !str2.equals(editable.toString())) {
                        editText.removeTextChangedListener(this);
                        boolean z = this.f17497c && editable.length() == 1 && settingConfigStore.getPrefillPrice();
                        int selectionStart = editText.getSelectionStart();
                        int b2 = e.b(editable.toString());
                        Long a2 = e.a(editable.toString(), "IDR");
                        if (z) {
                            a2 = Long.valueOf(a2.longValue() * 1000);
                        }
                        if (a2 != null) {
                            String a3 = e.a(a2.longValue(), "IDR", true, false);
                            a d2 = e.d("IDR");
                            String valueOf = String.valueOf(d2.a(true).getDecimalFormatSymbols().getDecimalSeparator());
                            if (editable.toString().endsWith(valueOf) && d2.f17500b) {
                                a3 = a3 + valueOf;
                            }
                            if (b2 == 1) {
                                if (!a3.contains(valueOf)) {
                                    a3 = a3 + valueOf + AppEventsConstants.EVENT_PARAM_VALUE_NO;
                                } else if ((a3.length() - a3.indexOf(valueOf)) - 1 < 2) {
                                    a3 = a3 + AppEventsConstants.EVENT_PARAM_VALUE_NO;
                                }
                            } else if (b2 == 2) {
                                if (a3.contains(valueOf)) {
                                    int length2 = (a3.length() - a3.indexOf(valueOf)) - 1;
                                    if (length2 < 1) {
                                        str = a3 + "00";
                                    } else if (length2 < 2) {
                                        str = a3 + AppEventsConstants.EVENT_PARAM_VALUE_NO;
                                    }
                                    a3 = str;
                                } else {
                                    a3 = a3 + valueOf + "00";
                                }
                            }
                            editText.setText(a3);
                        } else {
                            editText.setText(editable.toString());
                        }
                        int length3 = editText.getText().length();
                        if (!z || editText.getText().length() < 4) {
                            int i = selectionStart + (length3 - length);
                            if (i <= 0 || i > editText.getText().length()) {
                                editText.setSelection(0);
                            } else {
                                editText.setSelection(i);
                            }
                        } else if (b.b(R.bool.isRightToLeft)) {
                            editText.setSelection(1);
                        } else {
                            EditText editText = editText;
                            editText.setSelection(editText.getText().length() - 4);
                        }
                        this.f17498d = editText.getText().toString();
                        editText.addTextChangedListener(this);
                    }
                }
            }
        });
    }
}
