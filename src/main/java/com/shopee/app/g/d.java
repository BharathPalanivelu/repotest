package com.shopee.app.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.f;
import com.appsflyer.share.Constants;
import com.shopee.app.application.ar;
import com.shopee.app.ui.a.w;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.au;
import com.shopee.id.R;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final List<Long> f17476a = Arrays.asList(new Long[]{Long.valueOf(TimeUnit.DAYS.toMillis(365)), Long.valueOf(TimeUnit.DAYS.toMillis(30)), Long.valueOf(TimeUnit.DAYS.toMillis(1)), Long.valueOf(TimeUnit.HOURS.toMillis(1)), Long.valueOf(TimeUnit.MINUTES.toMillis(1)), Long.valueOf(TimeUnit.SECONDS.toMillis(1))});

    /* renamed from: b  reason: collision with root package name */
    public static final List<Integer> f17477b = Arrays.asList(new Integer[]{Integer.valueOf(R.string.sp_1_year_ago), Integer.valueOf(R.string.sp_1_month_ago), Integer.valueOf(R.string.sp_1_day_ago), Integer.valueOf(R.string.sp_1_hour_ago), Integer.valueOf(R.string.sp_1_minute_ago), Integer.valueOf(R.string.sp_1_second_ago)});

    /* renamed from: c  reason: collision with root package name */
    public static final List<Integer> f17478c = Arrays.asList(new Integer[]{Integer.valueOf(R.string.sp_n_year_ago), Integer.valueOf(R.string.sp_n_month_ago), Integer.valueOf(R.string.sp_n_day_ago), Integer.valueOf(R.string.sp_n_hour_ago), Integer.valueOf(R.string.sp_n_minute_ago), Integer.valueOf(R.string.sp_n_second_ago)});

    public interface a {
        void a();

        void b();

        void c();
    }

    public static void a(final RecyclerView recyclerView, final View view, final w wVar) {
        wVar.registerAdapterDataObserver(new RecyclerView.c() {
            public void a() {
                d.c(recyclerView, view, wVar);
            }

            public void a(int i, int i2) {
                d.c(recyclerView, view, wVar);
            }

            public void b(int i, int i2) {
                d.c(recyclerView, view, wVar);
            }

            public void c(int i, int i2) {
                d.c(recyclerView, view, wVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void c(RecyclerView recyclerView, View view, w wVar) {
        if (view != null && wVar != null) {
            int i = 0;
            view.setVisibility(wVar.a() ? 0 : 8);
            if (wVar.a()) {
                i = 8;
            }
            recyclerView.setVisibility(i);
        }
    }

    public static void a(EditText editText) {
        if (editText != null) {
            editText.setInputType(8192);
            e.a(editText);
            au.a(editText);
            e.a(editText, ar.f().e().settingConfigStore());
        }
    }

    private static boolean a(Activity activity, String[] strArr) {
        int length = strArr.length;
        int i = 0;
        boolean z = true;
        while (i < length) {
            if (b.b((Context) activity, strArr[i]) != 0) {
                return true;
            }
            i++;
            z = false;
        }
        return z;
    }

    public static void a(Activity activity, String[] strArr, int i, int i2, int i3, int i4, int i5, a aVar) {
        if (Build.VERSION.SDK_INT < 23) {
            aVar.a();
        } else if (!a(activity, strArr)) {
            aVar.a();
        } else if (!a(activity, strArr)) {
        } else {
            if ((i2 > 0 || i3 > 0) && ar.f().e().settingConfigStore().permissionPopupEnabled()) {
                final Activity activity2 = activity;
                final String[] strArr2 = strArr;
                final int i6 = i;
                final int i7 = i4;
                final int i8 = i5;
                final a aVar2 = aVar;
                com.shopee.app.ui.dialog.a.a((Context) activity, i2, i3, 0, (int) R.string.button_ok, (f.b) new f.b() {
                    public void onPositive(f fVar) {
                        d.b(activity2, strArr2, i6, com.garena.android.appkit.tools.b.e(i7), com.garena.android.appkit.tools.b.e(i8), aVar2);
                    }
                }, false);
                return;
            }
            String str = "";
            String e2 = i4 > 0 ? com.garena.android.appkit.tools.b.e(i4) : str;
            if (i5 > 0) {
                str = com.garena.android.appkit.tools.b.e(i5);
            }
            b(activity, strArr, i, e2, str, aVar);
        }
    }

    /* access modifiers changed from: private */
    public static void b(final Activity activity, String[] strArr, int i, String str, String str2, final a aVar) {
        int length = strArr.length;
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (b.b((Context) activity, strArr[i2]) != 0) {
                z = false;
                break;
            } else {
                i2++;
                z = true;
            }
        }
        if (z) {
            aVar.a();
        } else if (!androidx.core.app.a.a(activity, strArr[0]) || TextUtils.isEmpty(str2)) {
            androidx.core.app.a.a(activity, strArr, i);
        } else {
            com.shopee.app.ui.dialog.a.a((Context) activity, str, str2, com.garena.android.appkit.tools.b.e(R.string.button_cancel), com.garena.android.appkit.tools.b.e(R.string.sp_settings), (a.C0318a) new a.C0318a() {
                public void onPositive() {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.parse("package:" + activity.getPackageName()));
                    activity.startActivity(intent);
                    aVar.c();
                }

                public void onNegative() {
                    aVar.b();
                }
            }, (a.g) new a.g() {
                public void a() {
                    aVar.b();
                }
            });
        }
    }

    public static void a(final Context context, final EditText editText) {
        if (editText != null) {
            editText.setInputType(8192);
            au.a(editText, 6);
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        try {
                            if (Integer.parseInt(editText.getText().toString()) == 0) {
                                editText.setText("");
                            } else if (editText.getText().toString().length() > 0) {
                                String obj = editText.getText().toString();
                                editText.setText("");
                                editText.append(obj);
                                ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(2, 1);
                            }
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            });
        }
    }

    public static String a(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(a(list.get(i)));
            sb.append(",");
        }
        sb.append(a(list.get(list.size() - 1)));
        return sb.toString();
    }

    private static String a(String str) {
        String[] split = str.split(Constants.URL_PATH_DELIMITER);
        if (split.length == 1) {
            return str;
        }
        return split[split.length - 1];
    }

    public static String a(long j, int i) {
        if (j > 0) {
            while (i < f17476a.size()) {
                Long l = f17476a.get(i);
                long longValue = j / l.longValue();
                if (j % l.longValue() > l.longValue() / 2 && longValue > 0) {
                    longValue++;
                }
                if (longValue > 0) {
                    if (f17476a.get(i).longValue() == TimeUnit.DAYS.toMillis(1) && longValue > 30) {
                        longValue = 30;
                    }
                    if (longValue > 1) {
                        return com.garena.android.appkit.tools.b.a(f17478c.get(i).intValue(), Long.valueOf(longValue));
                    }
                    return com.garena.android.appkit.tools.b.a(f17477b.get(i).intValue(), Long.valueOf(longValue));
                }
                i++;
            }
        }
        return "";
    }
}
