package com.bca.xco.widget.e;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bca.xco.widget.h;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.salesforce.android.service.common.liveagentlogging.internal.PodConnectionManager;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.security.MessageDigest;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.a.a.a;

public class b {
    public String a(String str, String str2, String str3, TreeMap treeMap, String str4, String str5, String str6) {
        String str7;
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "HmacSHA256");
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(secretKeySpec);
        if (treeMap != null) {
            String str8 = "";
            for (Map.Entry entry : treeMap.entrySet()) {
                str8 = str8 + entry.getKey().toString() + SimpleComparison.EQUAL_TO_OPERATION + entry.getValue().toString() + "&";
            }
            if (str8.length() > 0) {
                str7 = "?" + str8.substring(0, str8.length() - 1);
            } else {
                str7 = str8;
            }
        } else {
            str7 = "";
        }
        if (str5 == null) {
            str5 = "";
        }
        String replaceAll = str5.replaceAll("\\s+", "");
        MessageDigest instance2 = MessageDigest.getInstance(Hash.ALGORITHM_SHA256);
        instance2.update(replaceAll.getBytes("UTF-8"));
        return new String(a.a(instance.doFinal((str2 + ":" + str3 + str7 + ":" + str4 + ":" + new String(a.a(instance2.digest())).toLowerCase() + ":" + str6).getBytes("UTF-8"))));
    }

    public String a() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+7");
        AnonymousClass1 r1 = new SimpleDateFormat(PodConnectionManager.ISO_8601_DATE_FORMAT) {
            public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
                StringBuffer format = super.format(date, stringBuffer, fieldPosition);
                return format.insert(format.length() - 2, ":");
            }

            public Date parse(String str, ParsePosition parsePosition) {
                if (str.length() > 3) {
                    str = str.substring(0, str.length() - 3) + str.substring(str.length() - 2);
                }
                return super.parse(str, parsePosition);
            }
        };
        r1.setTimeZone(timeZone);
        return r1.format(new Date());
    }

    public boolean a(EditText editText) {
        try {
            if (a(editText.getText().toString())) {
                return true;
            }
            editText.requestFocus();
            return false;
        } catch (Exception unused) {
            editText.requestFocus();
            return false;
        }
    }

    public boolean a(String str) {
        if (str == null) {
            return true;
        }
        try {
            return str.equals("");
        } catch (Exception unused) {
        }
    }

    public boolean b(String str) {
        try {
            Double.parseDouble(str);
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public Bitmap a(Context context, float f2, boolean z) {
        int dimension = (int) context.getResources().getDimension(h.b.xco_left_rp);
        int dimension2 = (int) context.getResources().getDimension(h.b.xco_margin_rp);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        textView.setText("Rp");
        textView.setTextSize(0, f2);
        textView.setTextColor(-16777216);
        if (z) {
            textView.setTypeface((Typeface) null, 1);
        }
        textView.setBackgroundColor(0);
        Bitmap createBitmap = Bitmap.createBitmap(dimension, dimension2 / 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        textView.layout(0, 0, dimension, dimension2);
        textView.draw(canvas);
        return createBitmap;
    }

    private Typeface d(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf");
    }

    private Typeface e(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Bold.ttf");
    }

    public void a(TextView textView) {
        textView.setTypeface(d(textView.getContext()));
    }

    public void b(EditText editText) {
        editText.setTypeface(d(editText.getContext()));
    }

    public void a(Button button) {
        button.setTypeface(d(button.getContext()));
    }

    public void b(Button button) {
        button.setTypeface(e(button.getContext()));
    }

    public void c(EditText editText) {
        editText.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        editText.setLongClickable(false);
    }

    public void a(TextView textView, float f2) {
        textView.setTextSize(0, f2);
    }

    public void a(Context context) {
        View currentFocus = ((Activity) context).getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public void a(Context context, String str) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        if (str.equals("in")) {
            configuration.locale = new Locale("in", "ID");
        } else if (str.equals("en")) {
            configuration.locale = new Locale("en", "US");
        } else {
            configuration.locale = new Locale("in", "ID");
        }
        resources.updateConfiguration(configuration, displayMetrics);
    }

    public String b(Context context) {
        return c(context).getLanguage();
    }

    public Locale c(Context context) {
        return context.getResources().getConfiguration().locale;
    }

    public String a(Context context, String str, String str2) {
        return (!b(context).equals("in") && b(context).equals("en")) ? str2 : str;
    }
}
