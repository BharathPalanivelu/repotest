package com.shopee.app.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.afollestad.materialdialogs.f;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.tools.a.b;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.ui.dialog.a;
import com.shopee.id.R;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class bj {

    /* renamed from: a  reason: collision with root package name */
    private static CharSequence[] f26249a = new CharSequence[1];

    /* renamed from: b  reason: collision with root package name */
    private static final NavigableMap<Long, Integer> f26250b = new TreeMap();

    public static void a(final View view, final View.OnClickListener onClickListener) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                onClickListener.onClick(view);
                view.setEnabled(false);
                view.postDelayed(new Runnable() {
                    public void run() {
                        view.setEnabled(true);
                    }
                }, 1000);
            }
        });
    }

    public static void a(final ImageView imageView, final Context context, final CharSequence[] charSequenceArr) {
        final AnonymousClass2 r0 = new a.c() {
            public void a(f fVar, View view, int i, CharSequence charSequence) {
                if (i == 0) {
                    b.a("ON_IMAGE_ACTION_ONE", new com.garena.android.appkit.b.a(imageView), b.a.NETWORK_BUS);
                }
                fVar.dismiss();
            }
        };
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                a.a(context, charSequenceArr, r0);
                return false;
            }
        });
    }

    static {
        f26249a[0] = com.garena.android.appkit.tools.b.e(R.string.sp_label_copy_text);
        f26250b.put(1000L, Integer.valueOf(R.string.sp_big_number_format_suffix_thousand));
        f26250b.put(Long.valueOf(JobManager.NS_PER_MS), Integer.valueOf(R.string.sp_big_number_format_suffix_million));
        f26250b.put(1000000000L, Integer.valueOf(R.string.sp_big_number_format_suffix_billion));
    }

    public static void a(DatePicker datePicker) {
        boolean z = false;
        for (int i = 0; i < datePicker.getChildCount(); i++) {
            if (datePicker.getChildAt(i) instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) datePicker.getChildAt(i);
                boolean z2 = z;
                for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                    if (linearLayout.getChildAt(i2) instanceof LinearLayout) {
                        LinearLayout linearLayout2 = (LinearLayout) linearLayout.getChildAt(i2);
                        int i3 = 0;
                        for (int i4 = 0; i4 < linearLayout2.getChildCount(); i4++) {
                            View childAt = linearLayout2.getChildAt(i4);
                            if ((childAt instanceof NumberPicker) && childAt.getLayoutParams() != null) {
                                i3++;
                            }
                        }
                        if (i3 == 3) {
                            z2 = true;
                        }
                        if (z2) {
                            for (int i5 = 0; i5 < linearLayout2.getChildCount(); i5++) {
                                View childAt2 = linearLayout2.getChildAt(i5);
                                if (childAt2 instanceof NumberPicker) {
                                    ((LinearLayout.LayoutParams) childAt2.getLayoutParams()).rightMargin = b.a.f7696g;
                                }
                            }
                        }
                    }
                }
                z = z2;
            }
        }
    }

    public static void a(final View view, EditText... editTextArr) {
        if (view != null && editTextArr != null && editTextArr.length != 0) {
            final SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(editTextArr.length);
            for (final EditText editText : editTextArr) {
                sparseBooleanArray.put(editText.getId(), false);
                editText.addTextChangedListener(new TextWatcher() {
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public void afterTextChanged(Editable editable) {
                        sparseBooleanArray.put(editText.getId(), editable.toString().trim().length() > 0);
                        for (int i = 0; i < sparseBooleanArray.size(); i++) {
                            if (!sparseBooleanArray.valueAt(i)) {
                                view.setEnabled(false);
                                return;
                            }
                        }
                        view.setEnabled(true);
                    }
                });
            }
        }
    }

    public static Activity a(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static String a(long j) {
        if (j < 0) {
            return "-" + a(-j);
        } else if (j < 1000) {
            return Long.toString(j);
        } else {
            Map.Entry<Long, Integer> floorEntry = f26250b.floorEntry(Long.valueOf(j));
            String e2 = com.garena.android.appkit.tools.b.e(floorEntry.getValue().intValue());
            double d2 = (double) j;
            double longValue = (double) floorEntry.getKey().longValue();
            Double.isNaN(longValue);
            Double.isNaN(d2);
            long round = Math.round(d2 / (longValue / 10.0d));
            double d3 = (double) round;
            Double.isNaN(d3);
            double d4 = d3 / 10.0d;
            long j2 = round / 10;
            if (d4 != ((double) j2)) {
                return d4 + e2;
            }
            return j2 + e2;
        }
    }
}
