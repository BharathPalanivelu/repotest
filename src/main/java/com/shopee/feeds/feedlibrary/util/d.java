package com.shopee.feeds.feedlibrary.util;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.g.i;
import com.google.a.g;
import com.shopee.feeds.feedlibrary.activity.BaseProductSearchActivity;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import java.util.UUID;
import java.util.regex.Pattern;

public class d {
    public static boolean a(String str) {
        return str == null || "".equals(str) || "null".equals(str);
    }

    public static String a(Activity activity, String str) {
        return (!activity.getIntent().hasExtra(str) || activity.getIntent().getStringExtra(str) == null) ? "" : activity.getIntent().getStringExtra(str);
    }

    public static int b(Activity activity, String str) {
        return activity.getIntent().getIntExtra(str, -1);
    }

    public static boolean b(String str) {
        if (str == null || "".equals(str) || !Pattern.compile("[0-9]*").matcher(str).matches()) {
            return false;
        }
        return true;
    }

    public static void a(final Activity activity, View view, final EditText editText) {
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (i.a(motionEvent) != 2) {
                    return false;
                }
                EditText editText = editText;
                if (editText == null) {
                    d.a(activity);
                    return false;
                }
                d.a(activity, editText);
                return false;
            }
        });
    }

    public static void a(final Activity activity, View view, final EditText editText, final BaseProductSearchActivity.a aVar) {
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (i.a(motionEvent) != 2) {
                    return false;
                }
                EditText editText = editText;
                if (editText == null) {
                    d.a(activity);
                } else {
                    d.a(activity, editText);
                }
                aVar.a();
                return false;
            }
        });
    }

    public static void a(Activity activity) {
        if (activity != null && activity.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
            }
        }
    }

    public static void a(Activity activity, EditText editText) {
        if (activity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        }
    }

    public static void b(Activity activity, EditText editText) {
        if (activity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 0);
            }
        }
    }

    public static void c(Activity activity, EditText editText) {
        if (activity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 2);
            }
        }
    }

    public static String a(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (!a(str) && strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                if (i == 0) {
                    sb.append(str + "?" + strArr[i]);
                } else {
                    sb.append("&" + strArr[i]);
                }
            }
        }
        return sb.toString();
    }

    public static String a() {
        try {
            return UUID.randomUUID().toString().replace("-", "").toLowerCase();
        } catch (Exception unused) {
            return String.valueOf(System.currentTimeMillis());
        }
    }

    public static boolean a(ProductEntity.ProductItem productItem, ProductEntity.ProductItem productItem2) {
        return productItem != null && productItem2 != null && productItem.getShop_id() == productItem2.getShop_id() && productItem.getItem_id().equals(productItem2.getItem_id());
    }

    public static void a(Object obj) {
        try {
            g gVar = new g();
            gVar.c();
            h.a("crash_test", gVar.d().b(obj).toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
