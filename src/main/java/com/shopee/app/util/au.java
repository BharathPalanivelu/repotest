package com.shopee.app.util;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.method.DigitsKeyListener;
import android.widget.EditText;
import com.shopee.app.g.e;
import java.util.Locale;

public class au {
    public static String a(long j) {
        Locale locale = Locale.ENGLISH;
        double d2 = (double) j;
        Double.isNaN(d2);
        return String.format(locale, "%.2f", new Object[]{Double.valueOf(d2 / 100000.0d)});
    }

    public static String b(long j) {
        if (j < 0) {
            return a(0, (String) null);
        }
        return a(j, (String) null);
    }

    public static String c(long j) {
        return a(j, (String) null);
    }

    public static String a(long j, String str) {
        return e.a(j, str, true);
    }

    public static void a(EditText editText) {
        if (!e.d("IDR").f17500b) {
            a(editText, 9);
        } else {
            b(editText);
        }
    }

    public static void a(EditText editText, final int i) {
        InputFilter[] filters = editText.getFilters();
        editText.setKeyListener(DigitsKeyListener.getInstance(false, false));
        AnonymousClass1 r2 = new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int length = charSequence.length();
                String replace = charSequence.toString().replace(",", "").replace(".", "");
                String a2 = e.a("IDR");
                String replace2 = replace.toString().replace(a2, "");
                int length2 = (i2 - length) + replace2.length();
                for (int i5 = i; i5 < length2; i5++) {
                    if (!Character.isDigit(replace2.charAt(i5))) {
                        return "";
                    }
                }
                if ((length2 - i) + spanned.toString().replace(",", "").replace(".", "").replace(a2, "").length() > i) {
                    return "";
                }
                return null;
            }
        };
        InputFilter[] inputFilterArr = new InputFilter[(filters.length + 1)];
        for (int i2 = 0; i2 < filters.length; i2++) {
            inputFilterArr[i2] = filters[i2];
        }
        inputFilterArr[filters.length] = r2;
        editText.setFilters(inputFilterArr);
    }

    private static void b(EditText editText) {
        InputFilter[] filters = editText.getFilters();
        editText.setKeyListener(DigitsKeyListener.getInstance(false, true));
        AnonymousClass2 r3 = new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int length = charSequence.length();
                String replace = charSequence.toString().replace(",", "");
                String a2 = e.a("IDR");
                String replace2 = replace.toString().replace(a2, "");
                int length2 = (i2 - length) + replace2.length();
                if (spanned.length() > 0 && replace2.length() > 1) {
                    return "";
                }
                int i5 = 0;
                if (spanned.length() != 0 || replace2.length() <= 1) {
                    String obj = spanned.toString();
                    boolean contains = obj.contains(".");
                    int indexOf = obj.indexOf(".");
                    for (int i6 = i; i6 < length2; i6++) {
                        if ((!Character.isDigit(replace2.charAt(i6)) && i3 == 0 && i6 == 0) || (!Character.isDigit(replace2.charAt(i6)) && (replace2.charAt(i6) != '.' || contains))) {
                            return "";
                        }
                    }
                    if (replace2.equals(".") && spanned.toString().equals(a2)) {
                        return "";
                    }
                    int i7 = length2 - i;
                    int length3 = spanned.toString().length() - spanned.toString().replace(",", "").replace(a2, "").length();
                    if (contains) {
                        if (i4 <= indexOf) {
                            if ((i7 + indexOf) - length3 > 9) {
                                return "";
                            }
                        } else if (i7 + ((spanned.length() - indexOf) - 1) > 3) {
                            return "";
                        }
                    } else if (replace2.toString().equals(".")) {
                        if ((i7 + spanned.length()) - length3 > 10) {
                            return "";
                        }
                    } else if ((i7 + spanned.length()) - length3 > 9) {
                        return "";
                    }
                    return null;
                }
                for (int i8 = i; i8 < length2; i8++) {
                    if ((!Character.isDigit(replace2.charAt(i8)) && i3 == 0 && i8 == 0) || (!Character.isDigit(replace2.charAt(i8)) && replace2.charAt(i8) != '.')) {
                        return "";
                    }
                    if (replace2.charAt(i8) == '.') {
                        i5++;
                    }
                    if (i5 > 1) {
                        return "";
                    }
                }
                return null;
            }
        };
        InputFilter[] inputFilterArr = new InputFilter[(filters.length + 1)];
        for (int i = 0; i < filters.length; i++) {
            inputFilterArr[i] = filters[i];
        }
        inputFilterArr[filters.length] = r3;
        editText.setFilters(inputFilterArr);
    }
}
