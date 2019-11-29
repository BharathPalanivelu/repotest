package com.shopee.app.ui.dialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TimePicker;
import com.afollestad.materialdialogs.f;
import com.afollestad.materialdialogs.internal.MDButton;
import com.devspark.robototextview.widget.RobotoButton;
import com.garena.android.appkit.tools.a.b;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.application.ar;
import com.shopee.app.ui.auth.AuthTabActivity_;
import com.shopee.app.ui.dialog.k;
import com.shopee.app.ui.home.HomeActivity_;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.upload.data.UploadGroup;
import com.shopee.app.util.ak;
import com.shopee.id.R;
import java.util.Calendar;
import java.util.regex.Pattern;

public class a {

    /* renamed from: com.shopee.app.ui.dialog.a$a  reason: collision with other inner class name */
    public interface C0318a {
        void onNegative();

        void onPositive();
    }

    public interface b {
        void a();

        void a(String str);
    }

    public interface c {
        void a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence);
    }

    public interface d {
        void a();

        void a(long j, int i);
    }

    public interface e {
        void a();

        void a(String str, String str2);
    }

    public interface f {
        void a();

        void a(String str);
    }

    public interface g {
        void a();
    }

    public static void a(Context context, int i, int i2, int i3, int i4, int i5, final C0318a aVar, final g gVar) {
        new f.a(context).j(com.garena.android.appkit.tools.b.a(R.color.white)).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary)).a(i).c(i2).b(i3).d(i5).h(i4).a(false).b(false).a((DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                gVar.a();
            }
        }).a((f.b) new f.b() {
            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                aVar.onPositive();
                fVar.dismiss();
            }

            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                aVar.onNegative();
                fVar.dismiss();
            }
        }).b().show();
    }

    public static void a(Context context, String str, CharSequence[] charSequenceArr, final c cVar) {
        new f.a(context).a((CharSequence) str).a(charSequenceArr).a((f.d) new f.d() {
            public void a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence) {
                cVar.a(fVar, view, i, charSequence);
            }
        }).c();
    }

    public static Dialog a(Context context, String str, CharSequence[] charSequenceArr, final c cVar, final g gVar) {
        return new f.a(context).a((CharSequence) str).a(charSequenceArr).a((f.d) new f.d() {
            public void a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence) {
                cVar.a(fVar, view, i, charSequence);
            }
        }).a((DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                gVar.a();
            }
        }).c();
    }

    public static void a(Context context, CharSequence[] charSequenceArr, final c cVar) {
        new f.a(context).a(charSequenceArr).a((f.d) new f.d() {
            public void a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence) {
                cVar.a(fVar, view, i, charSequence);
            }
        }).c();
    }

    public static Dialog a(Context context, CharSequence[] charSequenceArr, final c cVar, final g gVar) {
        return new f.a(context).a(charSequenceArr).a((f.d) new f.d() {
            public void a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence) {
                cVar.a(fVar, view, i, charSequence);
            }
        }).a((DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                gVar.a();
            }
        }).c();
    }

    public static void a(Context context, String str, String str2, String str3, final C0318a aVar, final g gVar) {
        f.a e2 = new f.a(context).b((CharSequence) str).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary));
        if (!TextUtils.isEmpty(str3)) {
            e2.c((CharSequence) str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            e2.e((CharSequence) str2);
        }
        if (aVar != null) {
            e2.a((f.b) new f.b() {
                public void onNegative(com.afollestad.materialdialogs.f fVar) {
                    aVar.onNegative();
                }

                public void onPositive(com.afollestad.materialdialogs.f fVar) {
                    aVar.onPositive();
                }
            });
        }
        if (gVar != null) {
            e2.a((DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    gVar.a();
                }
            });
        }
        e2.c();
    }

    public static void a(Context context, String str, String str2, String str3, final C0318a aVar) {
        f.a e2 = new f.a(context).b((CharSequence) str).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary));
        if (!TextUtils.isEmpty(str3)) {
            e2.c((CharSequence) str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            e2.e((CharSequence) str2);
        }
        if (aVar != null) {
            e2.a((f.b) new f.b() {
                public void onNegative(com.afollestad.materialdialogs.f fVar) {
                    aVar.onNegative();
                }

                public void onPositive(com.afollestad.materialdialogs.f fVar) {
                    aVar.onPositive();
                }
            });
        }
        e2.c();
    }

    public static void a(Context context, int i, int i2, int i3, C0318a aVar) {
        a(context, com.garena.android.appkit.tools.b.e(i), com.garena.android.appkit.tools.b.e(i2), com.garena.android.appkit.tools.b.e(i3), aVar);
    }

    public static void a(Context context, int i, int i2, int i3, C0318a aVar, g gVar) {
        a(context, com.garena.android.appkit.tools.b.e(i), com.garena.android.appkit.tools.b.e(i2), com.garena.android.appkit.tools.b.e(i3), aVar, gVar);
    }

    public static Dialog a(Context context, int i, int i2, int i3, int i4, final C0318a aVar) {
        return new f.a(context).a(i).c(i2).d(i4).h(i3).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary)).a((f.b) new f.b() {
            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                C0318a aVar = aVar;
                if (aVar != null) {
                    aVar.onNegative();
                }
            }

            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                C0318a aVar = aVar;
                if (aVar != null) {
                    aVar.onPositive();
                }
            }
        }).c();
    }

    public static Dialog a(Context context, String str, String str2, String str3, String str4, final C0318a aVar, final g gVar) {
        f.a a2 = new f.a(context).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary)).a((DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                gVar.a();
            }
        }).a((f.b) new f.b() {
            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                C0318a aVar = aVar;
                if (aVar != null) {
                    aVar.onNegative();
                }
            }

            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                C0318a aVar = aVar;
                if (aVar != null) {
                    aVar.onPositive();
                }
            }
        });
        if (!TextUtils.isEmpty(str)) {
            a2.a((CharSequence) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            a2.b((CharSequence) str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            a2.e((CharSequence) str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            a2.c((CharSequence) str4);
        }
        return a2.c();
    }

    public static Dialog a(Context context, String str, String str2, String str3, String str4, final C0318a aVar) {
        f.a a2 = new f.a(context).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary)).a((f.b) new f.b() {
            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                C0318a aVar = aVar;
                if (aVar != null) {
                    aVar.onNegative();
                }
            }

            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                C0318a aVar = aVar;
                if (aVar != null) {
                    aVar.onPositive();
                }
            }
        });
        if (!TextUtils.isEmpty(str)) {
            a2.a((CharSequence) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            a2.b((CharSequence) str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            a2.e((CharSequence) str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            a2.c((CharSequence) str4);
        }
        return a2.c();
    }

    public static void a(Context context, int i, int i2, int i3, final e eVar, String str, String str2, String str3, int i4) {
        final k a2 = l.a(context);
        a2.a("", com.garena.android.appkit.tools.b.e(R.string.sp_shipping_info), str, str2, str3, i4);
        Context context2 = context;
        int i5 = i3;
        int i6 = i;
        int i7 = i2;
        e eVar2 = eVar;
        com.afollestad.materialdialogs.f b2 = new f.a(context).a((View) a2, false).d(i3).h(i).f(i2).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary)).i(com.garena.android.appkit.tools.b.a(R.color.primary)).a((f.b) new f.b() {
            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                if (eVar == null) {
                    fVar.dismiss();
                } else if (a2.b() && a2.c()) {
                    String logistic = a2.getLogistic();
                    String trackingCode = a2.getTrackingCode();
                    if (TextUtils.isEmpty(logistic)) {
                        logistic = "-";
                    }
                    eVar.a(logistic, trackingCode);
                    fVar.dismiss();
                }
            }

            public void onNeutral(com.afollestad.materialdialogs.f fVar) {
                e eVar = eVar;
                if (eVar != null) {
                    eVar.a();
                }
                fVar.dismiss();
            }

            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                if (eVar == null) {
                    fVar.dismiss();
                } else if (a2.b() && a2.c()) {
                    String logistic = a2.getLogistic();
                    String trackingCode = a2.getTrackingCode();
                    if (TextUtils.isEmpty(logistic)) {
                        logistic = "-";
                    }
                    eVar.a(logistic, trackingCode);
                    fVar.dismiss();
                }
            }
        }).b(false).b();
        final MDButton a3 = b2.a(com.afollestad.materialdialogs.b.POSITIVE);
        a2.setInfoValidCallBack(new k.a() {
            public void a(boolean z) {
                a3.setEnabled(z);
            }
        });
        b2.show();
    }

    public static void a(Context context, int i, int i2, final d dVar, long j, int i3) {
        final b a2 = PriceManageView_.a(context);
        a2.b("", com.garena.android.appkit.tools.b.e(R.string.sp_label_payment_received), j, i3);
        new f.a(context).a((View) a2, false).d(i2).h(i).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary)).k(i3).a((f.b) new f.b() {
            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                d dVar = dVar;
                if (dVar != null) {
                    dVar.a();
                }
            }

            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                d dVar = dVar;
                if (dVar != null) {
                    dVar.a(a2.getPrice(), 0);
                }
            }
        }).c();
    }

    public static Dialog a(Context context, int i, int i2, int i3, final b bVar) {
        FrameLayout frameLayout = new FrameLayout(context);
        final MaterialEditText materialEditText = new MaterialEditText(context);
        materialEditText.setFloatingLabelText(com.garena.android.appkit.tools.b.e(R.string.sp_description));
        materialEditText.setMaxCharacters(250);
        materialEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(250)});
        materialEditText.setHint(com.garena.android.appkit.tools.b.e(R.string.sp_leave_a_comment));
        materialEditText.b((com.rengwuxian.materialedittext.a.b) new com.rengwuxian.materialedittext.a.b(com.garena.android.appkit.tools.b.e(R.string.sp_err_report_length)) {
            public boolean a(CharSequence charSequence, boolean z) {
                return charSequence.length() <= 250;
            }
        });
        frameLayout.setPadding(b.a.k, b.a.f7695f, b.a.k, b.a.f7695f);
        frameLayout.addView(materialEditText);
        return new f.a(context).a((View) frameLayout, false).a(i).d(i3).h(i2).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary)).b(false).a((f.b) new f.b() {
            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                b bVar = bVar;
                if (bVar != null) {
                    bVar.a();
                }
                fVar.dismiss();
            }

            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                if (materialEditText.b()) {
                    fVar.dismiss();
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.a(materialEditText.getText().toString().trim());
                    }
                }
            }
        }).c();
    }

    public static Dialog a(Context context, int i, int i2, int i3, final f fVar) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        final MaterialEditText materialEditText = new MaterialEditText(context);
        materialEditText.setFloatingLabelText(com.garena.android.appkit.tools.b.e(R.string.sp_description));
        materialEditText.setHint(com.garena.android.appkit.tools.b.e(R.string.sp_youtube_video_url));
        materialEditText.b((com.rengwuxian.materialedittext.a.b) new com.rengwuxian.materialedittext.a.c(com.garena.android.appkit.tools.b.e(R.string.sp_youtube_video_url_invalid), "(?:https?://)?(?:www.)?(?:youtu.be|(?:m.)?youtube.com)/(?:embed/|v/|u/\\\\w/|embed/|watch\\?v=)?([a-zA-Z0-9_-]{11}).*"));
        materialEditText.setMaxCharacters(2000);
        materialEditText.b((com.rengwuxian.materialedittext.a.b) new com.rengwuxian.materialedittext.a.b(com.garena.android.appkit.tools.b.e(R.string.sp_youtube_video_url_too_long)) {
            public boolean a(CharSequence charSequence, boolean z) {
                return charSequence.length() <= 2000;
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        relativeLayout.setPadding(b.a.k, b.a.f7695f, b.a.k, b.a.f7695f);
        relativeLayout.addView(materialEditText, layoutParams);
        final RobotoButton robotoButton = new RobotoButton(context);
        robotoButton.setBackgroundResource(R.drawable.action_bar_button_background);
        robotoButton.setText(R.string.sp_label_paste);
        robotoButton.setMinWidth(b.a.n);
        robotoButton.setTextColor(com.garena.android.appkit.tools.b.a(R.color.link_text_material_light));
        final ClipboardManager clipboardManager = (ClipboardManager) ar.a().getSystemService("clipboard");
        if (clipboardManager.hasText()) {
            if (Pattern.compile("(?:https?://)?(?:www.)?(?:youtu.be|(?:m.)?youtube.com)/(?:embed/|v/|u/\\\\w/|embed/|watch\\?v=)?([a-zA-Z0-9_-]{11}).*", 2).matcher(clipboardManager.getText().toString()).matches()) {
                robotoButton.setVisibility(0);
            } else {
                robotoButton.setVisibility(8);
            }
        } else {
            robotoButton.setVisibility(8);
        }
        robotoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                materialEditText.setText(clipboardManager.getText());
                robotoButton.setVisibility(8);
            }
        });
        materialEditText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                robotoButton.setVisibility(8);
            }
        });
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams2.addRule(21);
        }
        layoutParams2.addRule(11);
        layoutParams2.addRule(6, R.id.password);
        relativeLayout.addView(robotoButton, layoutParams2);
        return new f.a(context).a((View) relativeLayout, false).a(i).d(i3).h(i2).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary)).b(false).a((f.b) new f.b() {
            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                f fVar2 = fVar;
                if (fVar2 != null) {
                    fVar2.a();
                }
                fVar.dismiss();
            }

            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                if (materialEditText.b()) {
                    fVar.dismiss();
                    f fVar2 = fVar;
                    if (fVar2 != null) {
                        fVar2.a(materialEditText.getText().toString().trim());
                    }
                }
            }
        }).c();
    }

    public static void a(Context context, int i, int i2, int i3, int i4) {
        f.a aVar = new f.a(context);
        if (i != 0) {
            aVar.a(i);
        }
        if (i2 != 0) {
            aVar.c(i2);
        }
        if (i3 != 0) {
            aVar.h(i3);
        }
        if (i4 != 0) {
            aVar.d(i4);
        }
        aVar.c();
    }

    public static Dialog a(Context context, int i, int i2, int i3, int i4, f.b bVar) {
        f.a aVar = new f.a(context);
        if (i != 0) {
            aVar.a(i);
        }
        if (i2 != 0) {
            aVar.c(i2);
        }
        if (i3 != 0) {
            aVar.h(i3);
        }
        if (i4 != 0) {
            aVar.d(i4);
        }
        if (bVar != null) {
            aVar.a(bVar);
        }
        return aVar.c();
    }

    public static Dialog a(Context context, int i, int i2, int i3, int i4, f.b bVar, boolean z) {
        f.a aVar = new f.a(context);
        aVar.a(z);
        if (i != 0) {
            aVar.a(i);
        }
        if (i2 != 0) {
            aVar.c(i2);
        }
        if (i3 != 0) {
            aVar.h(i3);
        }
        if (i4 != 0) {
            aVar.d(i4);
        }
        if (bVar != null) {
            aVar.a(bVar);
        }
        return aVar.c();
    }

    public static Dialog a(Context context, String str, String str2, int i, int i2) {
        f.a aVar = new f.a(context);
        if (!TextUtils.isEmpty(str)) {
            aVar.a((CharSequence) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            aVar.b((CharSequence) str2);
        }
        if (i != 0) {
            aVar.h(i);
        }
        if (i2 != 0) {
            aVar.d(i2);
        }
        return aVar.c();
    }

    public static Dialog a(Context context, String str, String str2, int i, int i2, f.b bVar) {
        f.a aVar = new f.a(context);
        if (!TextUtils.isEmpty(str)) {
            aVar.a((CharSequence) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            aVar.b((CharSequence) str2);
        }
        if (i != 0) {
            aVar.h(i);
        }
        if (i2 != 0) {
            aVar.d(i2);
        }
        if (bVar != null) {
            aVar.a(bVar);
        }
        return aVar.c();
    }

    public static Dialog b(Context context, String str, String str2, String str3, String str4, final C0318a aVar) {
        f.a aVar2 = new f.a(context);
        if (!TextUtils.isEmpty(str)) {
            aVar2.a((CharSequence) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            aVar2.b((CharSequence) str2);
        }
        if (TextUtils.isEmpty(str4)) {
            aVar2.c((CharSequence) str3);
        } else {
            aVar2.c((CharSequence) str3);
            aVar2.e((CharSequence) str4);
        }
        aVar2.a((f.b) new f.b() {
            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                C0318a aVar = aVar;
                if (aVar != null) {
                    aVar.onNegative();
                }
                fVar.dismiss();
            }

            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                fVar.dismiss();
                C0318a aVar = aVar;
                if (aVar != null) {
                    aVar.onPositive();
                }
            }
        });
        return aVar2.c();
    }

    public static Dialog a(final Context context, int i, int i2) {
        return new f.a(context).c(i).a((int) R.string.sp_sign_in_continue).d((int) R.string.sp_label_ok).h(R.string.sp_label_cancel).a((f.b) new f.b() {
            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                fVar.dismiss();
            }

            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                AuthTabActivity_.a(context).b(0).a();
            }
        }).c();
    }

    public static void a(final Context context, UploadManager uploadManager, UploadGroup uploadGroup, int i) {
        new f.a(context).b((CharSequence) com.garena.android.appkit.tools.b.e(R.string.sp_add_edit_product_block_msg)).a((int) R.string.sp_label_please_wait).h(R.string.sp_label_see_progress).d((int) R.string.sp_label_got_it).a((f.b) new f.b() {
            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                Context context = context;
                if (context instanceof HomeActivity_) {
                    ((HomeActivity_.a) HomeActivity_.a(context).k(536870912)).b(4).a();
                } else {
                    ((HomeActivity_.a) HomeActivity_.a(context).k(67108864)).a("me").a();
                }
                fVar.dismiss();
            }

            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                fVar.dismiss();
            }
        }).c();
    }

    public static com.afollestad.materialdialogs.f a(Context context, f.b bVar) {
        return new f.a(context).a((View) i.a(context), false).a((int) R.string.sp_payment_complete_date).d((int) R.string.sp_reset).g(com.garena.android.appkit.tools.b.a(R.color.primary)).e(com.garena.android.appkit.tools.b.a(R.color.primary)).i(com.garena.android.appkit.tools.b.a(R.color.primary)).a(bVar).b(false).c();
    }

    public static com.afollestad.materialdialogs.f a(Context context, long j, DatePicker.OnDateChangedListener onDateChangedListener, f.b bVar) {
        return a(context, j, -1, -1, false, onDateChangedListener, bVar);
    }

    public static com.afollestad.materialdialogs.f a(Context context, long j, long j2, long j3, DatePicker.OnDateChangedListener onDateChangedListener, f.b bVar) {
        return a(context, j, j2, j3, false, onDateChangedListener, bVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.afollestad.materialdialogs.f a(android.content.Context r18, long r19, long r21, long r23, boolean r25, android.widget.DatePicker.OnDateChangedListener r26, com.afollestad.materialdialogs.f.b r27) {
        /*
            r0 = r18
            r1 = r21
            r3 = r23
            r5 = r27
            java.util.Calendar r6 = java.util.Calendar.getInstance()
            r7 = r19
            r6.setTimeInMillis(r7)
            r7 = 1
            int r8 = r6.get(r7)
            r9 = 2
            int r9 = r6.get(r9)
            r10 = 5
            int r10 = r6.get(r10)
            android.widget.DatePicker r11 = new android.widget.DatePicker
            r12 = 0
            r13 = 2131952112(0x7f1301f0, float:1.9540658E38)
            r11.<init>(r0, r12, r13)
            r12 = 0
            r11.setCalendarViewShown(r12)
            r11.setSpinnersShown(r7)
            java.util.TimeZone r6 = r6.getTimeZone()
            int r6 = r6.getRawOffset()
            r13 = 0
            r15 = 2145887999000(0x1f3a0e45418, double:1.060209540129E-311)
            int r17 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r17 <= 0) goto L_0x0050
            r20 = r8
            long r7 = (long) r6
            long r7 = r7 + r15
            int r17 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r17 > 0) goto L_0x0052
            r11.setMinDate(r1)
            r7 = r13
            goto L_0x005e
        L_0x0050:
            r20 = r8
        L_0x0052:
            r7 = -1893484800000(0xfffffe472382d800, double:NaN)
            long r12 = (long) r6
            long r12 = r12 + r7
            r11.setMinDate(r12)
            r7 = 0
        L_0x005e:
            int r12 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r12 <= 0) goto L_0x006c
            long r7 = (long) r6
            long r7 = r7 + r15
            int r12 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r12 > 0) goto L_0x006c
            r11.setMaxDate(r3)
            goto L_0x0071
        L_0x006c:
            long r1 = (long) r6
            long r1 = r1 + r15
            r11.setMaxDate(r1)
        L_0x0071:
            if (r25 == 0) goto L_0x008c
            android.content.res.Resources r1 = android.content.res.Resources.getSystem()
            java.lang.String r2 = "day"
            java.lang.String r3 = "id"
            java.lang.String r4 = "android"
            int r1 = r1.getIdentifier(r2, r3, r4)
            android.view.View r1 = r11.findViewById(r1)
            if (r1 == 0) goto L_0x008c
            r2 = 8
            r1.setVisibility(r2)
        L_0x008c:
            com.shopee.app.util.bj.a((android.widget.DatePicker) r11)
            com.afollestad.materialdialogs.f$a r1 = new com.afollestad.materialdialogs.f$a
            r1.<init>(r0)
            r0 = 0
            com.afollestad.materialdialogs.f$a r1 = r1.a((android.view.View) r11, (boolean) r0)
            r0 = 2131888437(0x7f120935, float:1.941151E38)
            com.afollestad.materialdialogs.f$a r0 = r1.a((int) r0)
            com.shopee.app.ui.dialog.a$22 r1 = new com.shopee.app.ui.dialog.a$22
            r2 = r26
            r1.<init>(r11, r2, r5)
            com.afollestad.materialdialogs.f$a r0 = r0.a((com.afollestad.materialdialogs.f.b) r1)
            r1 = 2131888143(0x7f12080f, float:1.9410913E38)
            com.afollestad.materialdialogs.f$a r0 = r0.h(r1)
            r1 = 2131889148(0x7f120bfc, float:1.9412951E38)
            com.afollestad.materialdialogs.f$a r0 = r0.d((int) r1)
            r1 = 1
            com.afollestad.materialdialogs.f$a r0 = r0.b((boolean) r1)
            com.afollestad.materialdialogs.f r0 = r0.c()
            com.afollestad.materialdialogs.b r1 = com.afollestad.materialdialogs.b.POSITIVE
            com.afollestad.materialdialogs.internal.MDButton r1 = r0.a(r1)
            r2 = 0
            r1.setEnabled(r2)
            com.shopee.app.ui.dialog.a$23 r2 = new com.shopee.app.ui.dialog.a$23
            r2.<init>(r1)
            r1 = r20
            r11.init(r1, r9, r10, r2)
            com.shopee.app.ui.dialog.a$24 r1 = new com.shopee.app.ui.dialog.a$24
            r1.<init>(r11, r5, r0)
            r0.setOnDismissListener(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.dialog.a.a(android.content.Context, long, long, long, boolean, android.widget.DatePicker$OnDateChangedListener, com.afollestad.materialdialogs.f$b):com.afollestad.materialdialogs.f");
    }

    public static com.afollestad.materialdialogs.f a(Context context, long j, boolean z, int i, final TimePickerDialog.OnTimeSetListener onTimeSetListener, final DialogInterface.OnDismissListener onDismissListener) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i2 = instance.get(11);
        int i3 = instance.get(12);
        final n nVar = new n(context);
        nVar.setIs24HourView(z);
        nVar.setCurrentHour(i2);
        nVar.setCurrentMinute(i3);
        nVar.setInterval(i);
        com.afollestad.materialdialogs.f c2 = new f.a(context).a((View) nVar, false).a((CharSequence) "Select Time").a((f.b) new f.b() {
            public void onPositive(com.afollestad.materialdialogs.f fVar) {
                nVar.setTag(1);
                onTimeSetListener.onTimeSet(nVar.getTimePicker(), nVar.getCurrentHour(), nVar.getCurrentMinute());
            }

            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                nVar.setTag(1);
                onDismissListener.onDismiss(fVar);
            }
        }).h(R.string.sp_label_cancel).d((int) R.string.sp_submit).b(true).c();
        MDButton a2 = c2.a(com.afollestad.materialdialogs.b.POSITIVE);
        a2.setEnabled(false);
        nVar.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
                MDButton.this.setEnabled(true);
            }
        });
        c2.setOnDismissListener(new DialogInterface.OnDismissListener(onDismissListener) {
            private final /* synthetic */ DialogInterface.OnDismissListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                a.a(n.this, this.f$1, dialogInterface);
            }
        });
        return c2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(n nVar, DialogInterface.OnDismissListener onDismissListener, DialogInterface dialogInterface) {
        if (nVar.getTag() == null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public static com.afollestad.materialdialogs.f a(Context context, String str) {
        com.shopee.app.ui.product.a.a a2 = com.shopee.app.ui.product.a.b.a(context, str);
        com.afollestad.materialdialogs.f c2 = new f.a(context).a((View) a2, false).c();
        a2.setDialog(c2);
        return c2;
    }

    public static void a(Context context, final ak akVar) {
        a(context, 0, (int) R.string.sp_error_account_banned, (int) R.string.sp_label_learn_more, (int) R.string.sp_label_ok, (f.b) new f.b() {
            public void onPositive(com.afollestad.materialdialogs.f fVar) {
            }

            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                akVar.l("3841");
            }
        }, false);
    }

    public static void b(Context context, final ak akVar) {
        a(context, 0, (int) R.string.sp_login_device_limit, (int) R.string.sp_label_learn_more, (int) R.string.sp_label_ok, (f.b) new f.b() {
            public void onPositive(com.afollestad.materialdialogs.f fVar) {
            }

            public void onNegative(com.afollestad.materialdialogs.f fVar) {
                akVar.l("3841");
            }
        }, false);
    }

    public static Dialog a(Context context, com.shopee.app.data.a aVar, View.OnClickListener onClickListener) {
        o a2 = p.a(context);
        if (!a2.a(aVar, onClickListener)) {
            return null;
        }
        return new f.a(context).a((View) a2, false).c();
    }

    public static Dialog a(Context context, String str, DialogInterface.OnDismissListener onDismissListener) {
        Context context2 = context;
        Dialog a2 = a(context2, "", com.garena.android.appkit.tools.b.a(R.string.sp_label_converted_login_number_message, str), 0, (int) R.string.sp_label_ok, (f.b) new f.b() {
            public void onAny(com.afollestad.materialdialogs.f fVar) {
                super.onAny(fVar);
                fVar.dismiss();
            }
        });
        if (onDismissListener != null) {
            a2.setOnDismissListener(onDismissListener);
        }
        return a2;
    }
}
