package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.a;
import androidx.appcompat.widget.ah;

public final class j {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final PorterDuff.Mode f1214a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private static j f1215b;

    /* renamed from: c  reason: collision with root package name */
    private ah f1216c;

    public static synchronized void a() {
        synchronized (j.class) {
            if (f1215b == null) {
                f1215b = new j();
                f1215b.f1216c = ah.a();
                f1215b.f1216c.a((ah.e) new ah.e() {

                    /* renamed from: a  reason: collision with root package name */
                    private final int[] f1217a = {a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha};

                    /* renamed from: b  reason: collision with root package name */
                    private final int[] f1218b = {a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_seekbar_tick_mark_material, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha};

                    /* renamed from: c  reason: collision with root package name */
                    private final int[] f1219c = {a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material, a.e.abc_text_select_handle_left_mtrl_dark, a.e.abc_text_select_handle_middle_mtrl_dark, a.e.abc_text_select_handle_right_mtrl_dark, a.e.abc_text_select_handle_left_mtrl_light, a.e.abc_text_select_handle_middle_mtrl_light, a.e.abc_text_select_handle_right_mtrl_light};

                    /* renamed from: d  reason: collision with root package name */
                    private final int[] f1220d = {a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult};

                    /* renamed from: e  reason: collision with root package name */
                    private final int[] f1221e = {a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material};

                    /* renamed from: f  reason: collision with root package name */
                    private final int[] f1222f = {a.e.abc_btn_check_material, a.e.abc_btn_radio_material, a.e.abc_btn_check_material_anim, a.e.abc_btn_radio_material_anim};

                    private ColorStateList a(Context context) {
                        return b(context, am.a(context, a.C0012a.colorButtonNormal));
                    }

                    private ColorStateList b(Context context) {
                        return b(context, 0);
                    }

                    private ColorStateList c(Context context) {
                        return b(context, am.a(context, a.C0012a.colorAccent));
                    }

                    private ColorStateList b(Context context, int i) {
                        int a2 = am.a(context, a.C0012a.colorControlHighlight);
                        int c2 = am.c(context, a.C0012a.colorButtonNormal);
                        return new ColorStateList(new int[][]{am.f1133a, am.f1136d, am.f1134b, am.h}, new int[]{c2, androidx.core.graphics.a.a(a2, i), androidx.core.graphics.a.a(a2, i), i});
                    }

                    private ColorStateList d(Context context) {
                        int[][] iArr = new int[3][];
                        int[] iArr2 = new int[3];
                        ColorStateList b2 = am.b(context, a.C0012a.colorSwitchThumbNormal);
                        if (b2 == null || !b2.isStateful()) {
                            iArr[0] = am.f1133a;
                            iArr2[0] = am.c(context, a.C0012a.colorSwitchThumbNormal);
                            iArr[1] = am.f1137e;
                            iArr2[1] = am.a(context, a.C0012a.colorControlActivated);
                            iArr[2] = am.h;
                            iArr2[2] = am.a(context, a.C0012a.colorSwitchThumbNormal);
                        } else {
                            iArr[0] = am.f1133a;
                            iArr2[0] = b2.getColorForState(iArr[0], 0);
                            iArr[1] = am.f1137e;
                            iArr2[1] = am.a(context, a.C0012a.colorControlActivated);
                            iArr[2] = am.h;
                            iArr2[2] = b2.getDefaultColor();
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    public Drawable a(ah ahVar, Context context, int i) {
                        if (i != a.e.abc_cab_background_top_material) {
                            return null;
                        }
                        return new LayerDrawable(new Drawable[]{ahVar.a(context, a.e.abc_cab_background_internal_bg), ahVar.a(context, a.e.abc_cab_background_top_mtrl_alpha)});
                    }

                    private void a(Drawable drawable, int i, PorterDuff.Mode mode) {
                        if (z.c(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = j.f1214a;
                        }
                        drawable.setColorFilter(j.a(i, mode));
                    }

                    public boolean a(Context context, int i, Drawable drawable) {
                        if (i == a.e.abc_seekbar_track_material) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            a(layerDrawable.findDrawableByLayerId(16908288), am.a(context, a.C0012a.colorControlNormal), j.f1214a);
                            a(layerDrawable.findDrawableByLayerId(16908303), am.a(context, a.C0012a.colorControlNormal), j.f1214a);
                            a(layerDrawable.findDrawableByLayerId(16908301), am.a(context, a.C0012a.colorControlActivated), j.f1214a);
                            return true;
                        } else if (i != a.e.abc_ratingbar_material && i != a.e.abc_ratingbar_indicator_material && i != a.e.abc_ratingbar_small_material) {
                            return false;
                        } else {
                            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                            a(layerDrawable2.findDrawableByLayerId(16908288), am.c(context, a.C0012a.colorControlNormal), j.f1214a);
                            a(layerDrawable2.findDrawableByLayerId(16908303), am.a(context, a.C0012a.colorControlActivated), j.f1214a);
                            a(layerDrawable2.findDrawableByLayerId(16908301), am.a(context, a.C0012a.colorControlActivated), j.f1214a);
                            return true;
                        }
                    }

                    private boolean a(int[] iArr, int i) {
                        for (int i2 : iArr) {
                            if (i2 == i) {
                                return true;
                            }
                        }
                        return false;
                    }

                    public ColorStateList a(Context context, int i) {
                        if (i == a.e.abc_edit_text_material) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_edittext);
                        }
                        if (i == a.e.abc_switch_track_mtrl_alpha) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_switch_track);
                        }
                        if (i == a.e.abc_switch_thumb_material) {
                            return d(context);
                        }
                        if (i == a.e.abc_btn_default_mtrl_shape) {
                            return a(context);
                        }
                        if (i == a.e.abc_btn_borderless_material) {
                            return b(context);
                        }
                        if (i == a.e.abc_btn_colored_material) {
                            return c(context);
                        }
                        if (i == a.e.abc_spinner_mtrl_am_alpha || i == a.e.abc_spinner_textfield_background_material) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_spinner);
                        }
                        if (a(this.f1218b, i)) {
                            return am.b(context, a.C0012a.colorControlNormal);
                        }
                        if (a(this.f1221e, i)) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_default);
                        }
                        if (a(this.f1222f, i)) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_btn_checkable);
                        }
                        if (i == a.e.abc_seekbar_thumb_material) {
                            return androidx.appcompat.a.a.a.a(context, a.c.abc_tint_seek_thumb);
                        }
                        return null;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
                    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066 A[RETURN] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
                        /*
                            r6 = this;
                            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.j.f1214a
                            int[] r1 = r6.f1217a
                            boolean r1 = r6.a((int[]) r1, (int) r8)
                            r2 = 16842801(0x1010031, float:2.3693695E-38)
                            r3 = -1
                            r4 = 0
                            r5 = 1
                            if (r1 == 0) goto L_0x0018
                            int r2 = androidx.appcompat.a.C0012a.colorControlNormal
                        L_0x0014:
                            r1 = r0
                            r8 = 1
                            r0 = -1
                            goto L_0x0049
                        L_0x0018:
                            int[] r1 = r6.f1219c
                            boolean r1 = r6.a((int[]) r1, (int) r8)
                            if (r1 == 0) goto L_0x0023
                            int r2 = androidx.appcompat.a.C0012a.colorControlActivated
                            goto L_0x0014
                        L_0x0023:
                            int[] r1 = r6.f1220d
                            boolean r1 = r6.a((int[]) r1, (int) r8)
                            if (r1 == 0) goto L_0x002e
                            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                            goto L_0x0014
                        L_0x002e:
                            int r1 = androidx.appcompat.a.e.abc_list_divider_mtrl_alpha
                            if (r8 != r1) goto L_0x0040
                            r2 = 16842800(0x1010030, float:2.3693693E-38)
                            r8 = 1109603123(0x42233333, float:40.8)
                            int r8 = java.lang.Math.round(r8)
                            r1 = r0
                            r0 = r8
                            r8 = 1
                            goto L_0x0049
                        L_0x0040:
                            int r1 = androidx.appcompat.a.e.abc_dialog_material_background
                            if (r8 != r1) goto L_0x0045
                            goto L_0x0014
                        L_0x0045:
                            r1 = r0
                            r8 = 0
                            r0 = -1
                            r2 = 0
                        L_0x0049:
                            if (r8 == 0) goto L_0x0066
                            boolean r8 = androidx.appcompat.widget.z.c(r9)
                            if (r8 == 0) goto L_0x0055
                            android.graphics.drawable.Drawable r9 = r9.mutate()
                        L_0x0055:
                            int r7 = androidx.appcompat.widget.am.a(r7, r2)
                            android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.j.a((int) r7, (android.graphics.PorterDuff.Mode) r1)
                            r9.setColorFilter(r7)
                            if (r0 == r3) goto L_0x0065
                            r9.setAlpha(r0)
                        L_0x0065:
                            return r5
                        L_0x0066:
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j.AnonymousClass1.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                    }

                    public PorterDuff.Mode a(int i) {
                        if (i == a.e.abc_switch_thumb_material) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }
                });
            }
        }
    }

    public static synchronized j b() {
        j jVar;
        synchronized (j.class) {
            if (f1215b == null) {
                a();
            }
            jVar = f1215b;
        }
        return jVar;
    }

    public synchronized Drawable a(Context context, int i) {
        return this.f1216c.a(context, i);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, int i, boolean z) {
        return this.f1216c.a(context, i, z);
    }

    public synchronized void a(Context context) {
        this.f1216c.a(context);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList b(Context context, int i) {
        return this.f1216c.b(context, i);
    }

    static void a(Drawable drawable, ap apVar, int[] iArr) {
        ah.a(drawable, apVar, iArr);
    }

    public static synchronized PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (j.class) {
            a2 = ah.a(i, mode);
        }
        return a2;
    }
}
