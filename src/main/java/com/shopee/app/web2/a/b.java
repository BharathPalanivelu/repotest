package com.shopee.app.web2.a;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.DatePicker;
import android.widget.TimePicker;
import com.facebook.appevents.AppEventsConstants;
import com.shopee.app.web2.d;
import com.shopee.id.R;
import java.lang.reflect.Field;
import java.util.Calendar;

public class b extends h {
    public a a() {
        return new a();
    }

    class a {

        /* renamed from: b  reason: collision with root package name */
        private final String[] f26587b = {"date", "month", "time"};

        a() {
        }

        private int a(String str, int i) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return i;
            }
        }

        /* access modifiers changed from: private */
        public String a(int i) {
            if (i >= 10) {
                return String.valueOf(i);
            }
            return AppEventsConstants.EVENT_PARAM_VALUE_NO + i;
        }

        private DatePickerDialog a(DatePickerDialog.OnDateSetListener onDateSetListener, int i, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(b.this.e(), R.style.SpinnerDateDialogTheme, onDateSetListener, i, i2, i3);
                try {
                    int identifier = Resources.getSystem().getIdentifier("day", "id", "android");
                    if (identifier != 0) {
                        View findViewById = datePickerDialog.getDatePicker().findViewById(identifier);
                        if (findViewById != null) {
                            findViewById.setVisibility(8);
                        }
                    }
                } catch (Exception unused) {
                }
                return datePickerDialog;
            }
            DatePickerDialog datePickerDialog2 = new DatePickerDialog(b.this.e(), onDateSetListener, i, i2, i3);
            try {
                for (Field field : datePickerDialog2.getClass().getDeclaredFields()) {
                    if (field.getName().equals("mDatePicker")) {
                        field.setAccessible(true);
                        DatePicker datePicker = (DatePicker) field.get(datePickerDialog2);
                        for (Field field2 : field.getType().getDeclaredFields()) {
                            if ("mDaySpinner".equals(field2.getName())) {
                                field2.setAccessible(true);
                                ((View) field2.get(datePicker)).setVisibility(8);
                            }
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            return datePickerDialog2;
        }

        public void a(String str, String str2, int i) {
            final String str3 = str;
            String str4 = str2;
            int i2 = i;
            final d c2 = b.this.c();
            if (c2 != null && c2.f26666c == null) {
                Calendar instance = Calendar.getInstance();
                int i3 = instance.get(1);
                int i4 = instance.get(2);
                int i5 = instance.get(5);
                int i6 = instance.get(11);
                int i7 = instance.get(12);
                String[] split = str4.split("-");
                if (split.length >= 1) {
                    i3 = a(split[0], i3);
                }
                if (split.length >= 2) {
                    i4 = Math.max(0, a(split[1], i4) - 1);
                }
                if (split.length >= 3) {
                    i5 = a(split[2], i5);
                }
                String[] split2 = str4.split(":");
                if (split2.length >= 1) {
                    i6 = a(split2[0], i6);
                }
                int i8 = i6;
                if (split2.length >= 2) {
                    i7 = a(split2[1], i7);
                }
                int i9 = i7;
                if (i2 == 2) {
                    TimePickerDialog timePickerDialog = new TimePickerDialog(b.this.e(), new TimePickerDialog.OnTimeSetListener() {
                        public void onTimeSet(TimePicker timePicker, int i, int i2) {
                            c2.f26666c = null;
                            c2.a(str3, a.this.a(i) + ":" + a.this.a(i2));
                        }
                    }, i8, i9, true);
                    timePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public void onDismiss(DialogInterface dialogInterface) {
                            c2.f26666c = null;
                        }
                    });
                    if (!c2.a()) {
                        c2.f26666c = timePickerDialog;
                        c2.f26665b.add(timePickerDialog);
                        timePickerDialog.show();
                    }
                } else if (i2 == 1) {
                    DatePickerDialog a2 = a(new DatePickerDialog.OnDateSetListener() {
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            c2.f26666c = null;
                            c2.a(str3, i + "-" + a.this.a(i2 + 1));
                        }
                    }, i3, i4, i5);
                    a2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public void onDismiss(DialogInterface dialogInterface) {
                            c2.f26666c = null;
                        }
                    });
                    if (!c2.a()) {
                        c2.f26666c = a2;
                        a2.show();
                        c2.f26665b.add(a2);
                    }
                } else {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(b.this.e(), new DatePickerDialog.OnDateSetListener() {
                        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            c2.f26666c = null;
                            c2.a(str3, i + "-" + a.this.a(i2 + 1) + "-" + a.this.a(i3));
                        }
                    }, i3, i4, i5);
                    datePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public void onDismiss(DialogInterface dialogInterface) {
                            c2.f26666c = null;
                        }
                    });
                    if (!c2.a()) {
                        c2.f26666c = datePickerDialog;
                        datePickerDialog.show();
                        c2.f26665b.add(datePickerDialog);
                    }
                }
            }
        }

        private void b(final String str, final String str2, final int i) {
            d c2 = b.this.c();
            if (c2 != null) {
                c2.a((Runnable) new Runnable() {
                    public void run() {
                        a.this.a(str, str2, i);
                    }
                });
            }
        }

        @JavascriptInterface
        public void pickDate(String str, String str2) {
            b(str, str2, 0);
        }

        @JavascriptInterface
        public void pickMonth(String str, String str2) {
            b(str, str2, 1);
        }

        @JavascriptInterface
        public void pickTime(String str, String str2) {
            b(str, str2, 2);
        }
    }
}
