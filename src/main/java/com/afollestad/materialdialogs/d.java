package com.afollestad.materialdialogs;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.afollestad.materialdialogs.a.a;
import com.afollestad.materialdialogs.f;
import com.afollestad.materialdialogs.g;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import com.afollestad.materialdialogs.internal.b;
import com.afollestad.materialdialogs.internal.progress.IndeterminateHorizontalProgressDrawable;
import com.afollestad.materialdialogs.internal.progress.IndeterminateProgressDrawable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Arrays;

class d {
    public static int a(f.a aVar) {
        boolean a2 = a.a(aVar.f3160a, g.a.md_dark_theme, aVar.A == h.DARK);
        aVar.A = a2 ? h.DARK : h.LIGHT;
        return a2 ? g.h.MD_Dark : g.h.MD_Light;
    }

    public static int b(f.a aVar) {
        if (aVar.o != null) {
            return g.C0066g.md_dialog_custom;
        }
        if ((aVar.k != null && aVar.k.length > 0) || aVar.L != null) {
            return g.C0066g.md_dialog_list;
        }
        if (aVar.X > -2) {
            return g.C0066g.md_dialog_progress;
        }
        if (aVar.V) {
            if (aVar.ak) {
                return g.C0066g.md_dialog_progress_indeterminate_horizontal;
            }
            return g.C0066g.md_dialog_progress_indeterminate;
        } else if (aVar.ab != null) {
            return g.C0066g.md_dialog_input;
        } else {
            return g.C0066g.md_dialog_basic;
        }
    }

    public static void a(f fVar) {
        boolean z;
        f.a aVar = fVar.f3148b;
        fVar.setCancelable(aVar.B);
        fVar.setCanceledOnTouchOutside(aVar.B);
        if (aVar.T == 0) {
            aVar.T = a.b(aVar.f3160a, g.a.md_background_color);
        }
        if (aVar.T != 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(aVar.f3160a.getResources().getDimension(g.d.md_bg_corner_radius));
            gradientDrawable.setColor(aVar.T);
            a.a((View) fVar.f3144a, (Drawable) gradientDrawable);
        }
        if (!aVar.ao) {
            aVar.q = a.a(aVar.f3160a, g.a.md_positive_color, aVar.q);
        }
        if (!aVar.ap) {
            aVar.s = a.a(aVar.f3160a, g.a.md_neutral_color, aVar.s);
        }
        if (!aVar.aq) {
            aVar.r = a.a(aVar.f3160a, g.a.md_negative_color, aVar.r);
        }
        if (!aVar.ar) {
            aVar.p = a.a(aVar.f3160a, g.a.md_widget_color, aVar.p);
        }
        if (!aVar.al) {
            aVar.h = a.a(aVar.f3160a, g.a.md_title_color, a.b(fVar.getContext(), 16842806));
        }
        if (!aVar.am) {
            aVar.i = a.a(aVar.f3160a, g.a.md_content_color, a.b(fVar.getContext(), 16842808));
        }
        if (!aVar.an) {
            aVar.U = a.a(aVar.f3160a, g.a.md_item_color, aVar.i);
        }
        fVar.f3151e = (TextView) fVar.f3144a.findViewById(g.f.title);
        fVar.f3150d = (ImageView) fVar.f3144a.findViewById(g.f.icon);
        fVar.f3152f = fVar.f3144a.findViewById(g.f.titleFrame);
        fVar.k = (TextView) fVar.f3144a.findViewById(g.f.content);
        fVar.f3149c = (ListView) fVar.f3144a.findViewById(g.f.contentListView);
        fVar.n = (MDButton) fVar.f3144a.findViewById(g.f.buttonDefaultPositive);
        fVar.o = (MDButton) fVar.f3144a.findViewById(g.f.buttonDefaultNeutral);
        fVar.p = (MDButton) fVar.f3144a.findViewById(g.f.buttonDefaultNegative);
        if (aVar.ab != null && aVar.l == null) {
            aVar.l = aVar.f3160a.getText(17039370);
        }
        fVar.n.setVisibility(aVar.l != null ? 0 : 8);
        fVar.o.setVisibility(aVar.m != null ? 0 : 8);
        fVar.p.setVisibility(aVar.n != null ? 0 : 8);
        if (aVar.I != null) {
            fVar.f3150d.setVisibility(0);
            fVar.f3150d.setImageDrawable(aVar.I);
        } else {
            Drawable d2 = a.d(aVar.f3160a, g.a.md_icon);
            if (d2 != null) {
                fVar.f3150d.setVisibility(0);
                fVar.f3150d.setImageDrawable(d2);
            } else {
                fVar.f3150d.setVisibility(8);
            }
        }
        int i = aVar.K;
        if (i == -1) {
            i = a.e(aVar.f3160a, g.a.md_icon_max_size);
        }
        if (aVar.J || a.f(aVar.f3160a, g.a.md_icon_limit_icon_to_default_size)) {
            i = aVar.f3160a.getResources().getDimensionPixelSize(g.d.md_icon_max_size);
        }
        if (i > -1) {
            fVar.f3150d.setAdjustViewBounds(true);
            fVar.f3150d.setMaxHeight(i);
            fVar.f3150d.setMaxWidth(i);
            fVar.f3150d.requestLayout();
        }
        if (!aVar.as) {
            aVar.S = a.a(aVar.f3160a, g.a.md_divider_color, a.b(fVar.getContext(), g.a.md_divider));
        }
        fVar.f3144a.setDividerColor(aVar.S);
        if (fVar.f3151e != null) {
            fVar.a(fVar.f3151e, aVar.H);
            fVar.f3151e.setTextColor(aVar.h);
            fVar.f3151e.setGravity(aVar.f3162c.getGravityInt());
            if (Build.VERSION.SDK_INT >= 17) {
                fVar.f3151e.setTextAlignment(aVar.f3162c.getTextAlignment());
            }
            if (aVar.f3161b == null) {
                fVar.f3152f.setVisibility(8);
            } else {
                fVar.f3151e.setText(aVar.f3161b);
                fVar.f3152f.setVisibility(0);
            }
        }
        if (fVar.k != null) {
            fVar.k.setMovementMethod(new LinkMovementMethod());
            fVar.a(fVar.k, aVar.G);
            fVar.k.setLineSpacing(BitmapDescriptorFactory.HUE_RED, aVar.C);
            if (aVar.q == null) {
                fVar.k.setLinkTextColor(a.b(fVar.getContext(), 16842806));
            } else {
                fVar.k.setLinkTextColor(aVar.q);
            }
            fVar.k.setTextColor(aVar.i);
            fVar.k.setGravity(aVar.f3163d.getGravityInt());
            if (Build.VERSION.SDK_INT >= 17) {
                fVar.k.setTextAlignment(aVar.f3163d.getTextAlignment());
            }
            if (aVar.j != null) {
                fVar.k.setText(aVar.j);
                fVar.k.setVisibility(0);
            } else {
                fVar.k.setVisibility(8);
            }
        }
        fVar.f3144a.setButtonGravity(aVar.f3166g);
        fVar.f3144a.setButtonStackedGravity(aVar.f3164e);
        fVar.f3144a.setForceStack(aVar.Q);
        if (Build.VERSION.SDK_INT >= 14) {
            z = a.a(aVar.f3160a, 16843660, true);
            if (z) {
                z = a.a(aVar.f3160a, g.a.textAllCaps, true);
            }
        } else {
            z = a.a(aVar.f3160a, g.a.textAllCaps, true);
        }
        MDButton mDButton = fVar.n;
        fVar.a((TextView) mDButton, aVar.H);
        mDButton.setAllCapsCompat(z);
        mDButton.setText(aVar.l);
        mDButton.setTextColor(aVar.q);
        fVar.n.setStackedSelector(fVar.a(b.POSITIVE, true));
        fVar.n.setDefaultSelector(fVar.a(b.POSITIVE, false));
        fVar.n.setTag(b.POSITIVE);
        fVar.n.setOnClickListener(fVar);
        fVar.n.setVisibility(0);
        MDButton mDButton2 = fVar.p;
        fVar.a((TextView) mDButton2, aVar.H);
        mDButton2.setAllCapsCompat(z);
        mDButton2.setText(aVar.n);
        mDButton2.setTextColor(aVar.r);
        fVar.p.setStackedSelector(fVar.a(b.NEGATIVE, true));
        fVar.p.setDefaultSelector(fVar.a(b.NEGATIVE, false));
        fVar.p.setTag(b.NEGATIVE);
        fVar.p.setOnClickListener(fVar);
        fVar.p.setVisibility(0);
        MDButton mDButton3 = fVar.o;
        fVar.a((TextView) mDButton3, aVar.H);
        mDButton3.setAllCapsCompat(z);
        mDButton3.setText(aVar.m);
        mDButton3.setTextColor(aVar.s);
        fVar.o.setStackedSelector(fVar.a(b.NEUTRAL, true));
        fVar.o.setDefaultSelector(fVar.a(b.NEUTRAL, false));
        fVar.o.setTag(b.NEUTRAL);
        fVar.o.setOnClickListener(fVar);
        fVar.o.setVisibility(0);
        if (aVar.w != null) {
            fVar.r = new ArrayList();
        }
        if (fVar.f3149c != null && ((aVar.k != null && aVar.k.length > 0) || aVar.L != null)) {
            fVar.f3149c.setSelector(fVar.e());
            if (aVar.L == null) {
                if (aVar.v != null) {
                    fVar.q = f.g.SINGLE;
                } else if (aVar.w != null) {
                    fVar.q = f.g.MULTI;
                    if (aVar.E != null) {
                        fVar.r = new ArrayList(Arrays.asList(aVar.E));
                        aVar.E = null;
                    }
                } else {
                    fVar.q = f.g.REGULAR;
                }
                aVar.L = new a(fVar, f.g.getLayoutForType(fVar.q));
            } else if (aVar.L instanceof com.afollestad.materialdialogs.internal.a) {
                ((com.afollestad.materialdialogs.internal.a) aVar.L).a(fVar);
            }
        }
        b(fVar);
        c(fVar);
        if (aVar.o != null) {
            ((MDRootLayout) fVar.f3144a.findViewById(g.f.root)).a();
            FrameLayout frameLayout = (FrameLayout) fVar.f3144a.findViewById(g.f.customViewFrame);
            fVar.f3153g = frameLayout;
            View view = aVar.o;
            if (aVar.R) {
                Resources resources = fVar.getContext().getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(g.d.md_dialog_frame_margin);
                ScrollView scrollView = new ScrollView(fVar.getContext());
                int dimensionPixelSize2 = resources.getDimensionPixelSize(g.d.md_content_padding_top);
                int dimensionPixelSize3 = resources.getDimensionPixelSize(g.d.md_content_padding_bottom);
                scrollView.setClipToPadding(false);
                if (view instanceof EditText) {
                    scrollView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize3);
                } else {
                    scrollView.setPadding(0, dimensionPixelSize2, 0, dimensionPixelSize3);
                    view.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
                }
                scrollView.addView(view, new FrameLayout.LayoutParams(-1, -2));
                view = scrollView;
            }
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -2));
        }
        if (aVar.P != null) {
            fVar.setOnShowListener(aVar.P);
        }
        if (aVar.N != null) {
            fVar.setOnCancelListener(aVar.N);
        }
        if (aVar.M != null) {
            fVar.setOnDismissListener(aVar.M);
        }
        if (aVar.O != null) {
            fVar.setOnKeyListener(aVar.O);
        }
        fVar.a();
        fVar.d();
        fVar.a(fVar.f3144a);
        fVar.c();
    }

    private static void b(f fVar) {
        f.a aVar = fVar.f3148b;
        if (aVar.V || aVar.X > -2) {
            fVar.h = (ProgressBar) fVar.f3144a.findViewById(16908301);
            if (fVar.h != null) {
                if (Build.VERSION.SDK_INT < 14) {
                    b.a(fVar.h, aVar.p);
                } else if (!aVar.V) {
                    com.afollestad.materialdialogs.internal.progress.b bVar = new com.afollestad.materialdialogs.internal.progress.b(aVar.a());
                    bVar.setTint(aVar.p);
                    fVar.h.setProgressDrawable(bVar);
                    fVar.h.setIndeterminateDrawable(bVar);
                } else if (aVar.ak) {
                    IndeterminateHorizontalProgressDrawable indeterminateHorizontalProgressDrawable = new IndeterminateHorizontalProgressDrawable(aVar.a());
                    indeterminateHorizontalProgressDrawable.setTint(aVar.p);
                    fVar.h.setProgressDrawable(indeterminateHorizontalProgressDrawable);
                    fVar.h.setIndeterminateDrawable(indeterminateHorizontalProgressDrawable);
                } else {
                    IndeterminateProgressDrawable indeterminateProgressDrawable = new IndeterminateProgressDrawable(aVar.a());
                    indeterminateProgressDrawable.setTint(aVar.p);
                    fVar.h.setProgressDrawable(indeterminateProgressDrawable);
                    fVar.h.setIndeterminateDrawable(indeterminateProgressDrawable);
                }
                if (!aVar.V || aVar.ak) {
                    fVar.h.setIndeterminate(aVar.ak);
                    fVar.h.setProgress(0);
                    fVar.h.setMax(aVar.Y);
                    fVar.i = (TextView) fVar.f3144a.findViewById(g.f.label);
                    if (fVar.i != null) {
                        fVar.i.setTextColor(aVar.i);
                        fVar.a(fVar.i, aVar.H);
                        fVar.i.setText(aVar.aj.format(0));
                    }
                    fVar.j = (TextView) fVar.f3144a.findViewById(g.f.minMax);
                    if (fVar.j != null) {
                        fVar.j.setTextColor(aVar.i);
                        fVar.a(fVar.j, aVar.G);
                        if (aVar.W) {
                            fVar.j.setVisibility(0);
                            fVar.j.setText(String.format(aVar.ai, new Object[]{0, Integer.valueOf(aVar.Y)}));
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) fVar.h.getLayoutParams();
                            marginLayoutParams.leftMargin = 0;
                            marginLayoutParams.rightMargin = 0;
                            return;
                        }
                        fVar.j.setVisibility(8);
                        return;
                    }
                    aVar.W = false;
                }
            }
        }
    }

    private static void c(f fVar) {
        f.a aVar = fVar.f3148b;
        fVar.l = (EditText) fVar.f3144a.findViewById(16908297);
        if (fVar.l != null) {
            fVar.a((TextView) fVar.l, aVar.G);
            if (aVar.Z != null) {
                fVar.l.setText(aVar.Z);
            }
            fVar.g();
            fVar.l.setHint(aVar.aa);
            fVar.l.setSingleLine();
            fVar.l.setTextColor(aVar.i);
            fVar.l.setHintTextColor(a.a(aVar.i, 0.3f));
            b.a(fVar.l, fVar.f3148b.p);
            if (aVar.ad != -1) {
                fVar.l.setInputType(aVar.ad);
                if ((aVar.ad & 128) == 128) {
                    fVar.l.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
            fVar.m = (TextView) fVar.f3144a.findViewById(g.f.minMax);
            if (aVar.af > 0 || aVar.ag > -1) {
                fVar.a(fVar.l.getText().toString().length(), !aVar.ac);
                return;
            }
            fVar.m.setVisibility(8);
            fVar.m = null;
        }
    }
}
