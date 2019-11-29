package androidx.core.g.a;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.a;
import androidx.core.g.a.g;
import com.facebook.common.util.ByteConstants;
import com.facebook.internal.NativeProtocol;
import com.tencent.imsdk.TIMGroupManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tencent.tls.platform.SigType;

public class d {

    /* renamed from: d  reason: collision with root package name */
    private static int f1739d;

    /* renamed from: a  reason: collision with root package name */
    public int f1740a = -1;

    /* renamed from: b  reason: collision with root package name */
    private final AccessibilityNodeInfo f1741b;

    /* renamed from: c  reason: collision with root package name */
    private int f1742c = -1;

    private static String b(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE /*16384*/:
                return "ACTION_COPY";
            case TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG /*32768*/:
                return "ACTION_PASTE";
            case NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST /*65536*/:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public static class a {
        public static final a A = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a B = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a C = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a D = new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, (CharSequence) null, (g) null, g.f.class);
        public static final a E = new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, (CharSequence) null, (g) null, g.d.class);
        public static final a F = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a G;

        /* renamed from: a  reason: collision with root package name */
        public static final a f1743a = new a(1, (CharSequence) null);

        /* renamed from: b  reason: collision with root package name */
        public static final a f1744b = new a(2, (CharSequence) null);

        /* renamed from: c  reason: collision with root package name */
        public static final a f1745c = new a(4, (CharSequence) null);

        /* renamed from: d  reason: collision with root package name */
        public static final a f1746d = new a(8, (CharSequence) null);

        /* renamed from: e  reason: collision with root package name */
        public static final a f1747e = new a(16, (CharSequence) null);

        /* renamed from: f  reason: collision with root package name */
        public static final a f1748f = new a(32, (CharSequence) null);

        /* renamed from: g  reason: collision with root package name */
        public static final a f1749g = new a(64, (CharSequence) null);
        public static final a h = new a(128, (CharSequence) null);
        public static final a i = new a(256, (CharSequence) null, g.b.class);
        public static final a j = new a(512, (CharSequence) null, g.b.class);
        public static final a k = new a(1024, (CharSequence) null, g.c.class);
        public static final a l = new a(2048, (CharSequence) null, g.c.class);
        public static final a m = new a(4096, (CharSequence) null);
        public static final a n = new a(8192, (CharSequence) null);
        public static final a o = new a(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE, (CharSequence) null);
        public static final a p = new a(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG, (CharSequence) null);
        public static final a q = new a(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, (CharSequence) null);
        public static final a r = new a(131072, (CharSequence) null, g.C0035g.class);
        public static final a s = new a(SigType.D2, (CharSequence) null);
        public static final a t = new a(524288, (CharSequence) null);
        public static final a u = new a(ByteConstants.MB, (CharSequence) null);
        public static final a v = new a(2097152, (CharSequence) null, g.h.class);
        public static final a w = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a x = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, (CharSequence) null, (g) null, g.e.class);
        public static final a y = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a z = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        final Object H;
        protected final g I;
        private final int J;
        private final CharSequence K;
        private final Class<? extends g.a> L;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            if (Build.VERSION.SDK_INT >= 28) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            }
            G = new a(accessibilityAction, 16908357, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        }

        public a(int i2, CharSequence charSequence) {
            this((Object) null, i2, charSequence, (g) null, (Class<? extends g.a>) null);
        }

        private a(int i2, CharSequence charSequence, Class<? extends g.a> cls) {
            this((Object) null, i2, charSequence, (g) null, cls);
        }

        a(Object obj, int i2, CharSequence charSequence, g gVar, Class<? extends g.a> cls) {
            this.J = i2;
            this.K = charSequence;
            this.I = gVar;
            if (Build.VERSION.SDK_INT < 21 || obj != null) {
                this.H = obj;
            } else {
                this.H = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            }
            this.L = cls;
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.H).getId();
            }
            return 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                androidx.core.g.a.g r0 = r4.I
                r1 = 0
                if (r0 == 0) goto L_0x0049
                r0 = 0
                java.lang.Class<? extends androidx.core.g.a.g$a> r2 = r4.L
                if (r2 == 0) goto L_0x0042
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x0020 }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r1 = r2.newInstance(r1)     // Catch:{ Exception -> 0x0020 }
                androidx.core.g.a.g$a r1 = (androidx.core.g.a.g.a) r1     // Catch:{ Exception -> 0x0020 }
                r1.a(r6)     // Catch:{ Exception -> 0x001d }
                r0 = r1
                goto L_0x0042
            L_0x001d:
                r6 = move-exception
                r0 = r1
                goto L_0x0021
            L_0x0020:
                r6 = move-exception
            L_0x0021:
                java.lang.Class<? extends androidx.core.g.a.g$a> r1 = r4.L
                if (r1 != 0) goto L_0x0028
                java.lang.String r1 = "null"
                goto L_0x002c
            L_0x0028:
                java.lang.String r1 = r1.getName()
            L_0x002c:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Failed to execute command with argument class ViewCommandArgument: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.String r2 = "A11yActionCompat"
                android.util.Log.e(r2, r1, r6)
            L_0x0042:
                androidx.core.g.a.g r6 = r4.I
                boolean r5 = r6.a(r5, r0)
                return r5
            L_0x0049:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.g.a.d.a.a(android.view.View, android.os.Bundle):boolean");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f1750a;

        public static b a(int i, int i2, boolean z, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new b((Object) null);
        }

        b(Object obj) {
            this.f1750a = obj;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final Object f1751a;

        public static c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new c((Object) null);
        }

        public static c a(int i, int i2, int i3, int i4, boolean z) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new c((Object) null);
        }

        c(Object obj) {
            this.f1751a = obj;
        }
    }

    private d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1741b = accessibilityNodeInfo;
    }

    public static d a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }

    public AccessibilityNodeInfo a() {
        return this.f1741b;
    }

    public static d a(d dVar) {
        return a(AccessibilityNodeInfo.obtain(dVar.f1741b));
    }

    public void a(View view) {
        this.f1742c = -1;
        this.f1741b.setSource(view);
    }

    public void b(View view) {
        this.f1741b.addChild(view);
    }

    public int b() {
        return this.f1741b.getActions();
    }

    public void a(int i) {
        this.f1741b.addAction(i);
    }

    private List<Integer> a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f1741b.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f1741b.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1741b.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.H);
        }
    }

    public boolean b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f1741b.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.H);
        }
        return false;
    }

    public boolean a(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f1741b.performAction(i, bundle);
        }
        return false;
    }

    public void c(View view) {
        this.f1740a = -1;
        this.f1741b.setParent(view);
    }

    public void a(Rect rect) {
        this.f1741b.getBoundsInParent(rect);
    }

    public void b(Rect rect) {
        this.f1741b.setBoundsInParent(rect);
    }

    public void c(Rect rect) {
        this.f1741b.getBoundsInScreen(rect);
    }

    public void d(Rect rect) {
        this.f1741b.setBoundsInScreen(rect);
    }

    public boolean c() {
        return this.f1741b.isCheckable();
    }

    public void a(boolean z) {
        this.f1741b.setCheckable(z);
    }

    public boolean d() {
        return this.f1741b.isChecked();
    }

    public void b(boolean z) {
        this.f1741b.setChecked(z);
    }

    public boolean e() {
        return this.f1741b.isFocusable();
    }

    public void c(boolean z) {
        this.f1741b.setFocusable(z);
    }

    public boolean f() {
        return this.f1741b.isFocused();
    }

    public void d(boolean z) {
        this.f1741b.setFocused(z);
    }

    public boolean g() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f1741b.isVisibleToUser();
        }
        return false;
    }

    public void e(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1741b.setVisibleToUser(z);
        }
    }

    public boolean h() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f1741b.isAccessibilityFocused();
        }
        return false;
    }

    public void f(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1741b.setAccessibilityFocused(z);
        }
    }

    public boolean i() {
        return this.f1741b.isSelected();
    }

    public void g(boolean z) {
        this.f1741b.setSelected(z);
    }

    public boolean j() {
        return this.f1741b.isClickable();
    }

    public void h(boolean z) {
        this.f1741b.setClickable(z);
    }

    public boolean k() {
        return this.f1741b.isLongClickable();
    }

    public void i(boolean z) {
        this.f1741b.setLongClickable(z);
    }

    public boolean l() {
        return this.f1741b.isEnabled();
    }

    public void j(boolean z) {
        this.f1741b.setEnabled(z);
    }

    public boolean m() {
        return this.f1741b.isPassword();
    }

    public boolean n() {
        return this.f1741b.isScrollable();
    }

    public void k(boolean z) {
        this.f1741b.setScrollable(z);
    }

    public CharSequence o() {
        return this.f1741b.getPackageName();
    }

    public void a(CharSequence charSequence) {
        this.f1741b.setPackageName(charSequence);
    }

    public CharSequence p() {
        return this.f1741b.getClassName();
    }

    public void b(CharSequence charSequence) {
        this.f1741b.setClassName(charSequence);
    }

    public CharSequence q() {
        if (!v()) {
            return this.f1741b.getText();
        }
        List<Integer> a2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> a3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> a4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> a5 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f1741b.getText(), 0, this.f1741b.getText().length()));
        for (int i = 0; i < a2.size(); i++) {
            spannableString.setSpan(new a(a5.get(i).intValue(), this, u().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), a2.get(i).intValue(), a3.get(i).intValue(), a4.get(i).intValue());
        }
        return spannableString;
    }

    public void c(CharSequence charSequence) {
        this.f1741b.setText(charSequence);
    }

    public void a(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 26) {
            w();
            f(view);
            ClickableSpan[] d2 = d(charSequence);
            if (d2 != null && d2.length > 0) {
                u().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", a.c.accessibility_action_clickable_span);
                SparseArray<WeakReference<ClickableSpan>> d3 = d(view);
                int i = 0;
                while (d2 != null && i < d2.length) {
                    int a2 = a(d2[i], d3);
                    d3.put(a2, new WeakReference(d2[i]));
                    a(d2[i], (Spanned) charSequence, a2);
                    i++;
                }
            }
        }
    }

    private SparseArray<WeakReference<ClickableSpan>> d(View view) {
        SparseArray<WeakReference<ClickableSpan>> e2 = e(view);
        if (e2 != null) {
            return e2;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(a.c.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> e(View view) {
        return (SparseArray) view.getTag(a.c.tag_accessibility_clickable_spans);
    }

    public static ClickableSpan[] d(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private int a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = f1739d;
        f1739d = i2 + 1;
        return i2;
    }

    private boolean v() {
        return !a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private void w() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1741b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f1741b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f1741b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f1741b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private void a(ClickableSpan clickableSpan, Spanned spanned, int i) {
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    private void f(View view) {
        SparseArray<WeakReference<ClickableSpan>> e2 = e(view);
        if (e2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < e2.size(); i++) {
                if (e2.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e2.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    public CharSequence r() {
        return this.f1741b.getContentDescription();
    }

    public void e(CharSequence charSequence) {
        this.f1741b.setContentDescription(charSequence);
    }

    public void s() {
        this.f1741b.recycle();
    }

    public String t() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f1741b.getViewIdResourceName();
        }
        return null;
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1741b.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f1750a);
        }
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1741b.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f1751a);
        }
    }

    public void l(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1741b.setContentInvalid(z);
        }
    }

    public void f(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1741b.setHintText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f1741b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void g(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1741b.setError(charSequence);
        }
    }

    public void m(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1741b.setCanOpenPopup(z);
        }
    }

    public Bundle u() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f1741b.getExtras();
        }
        return new Bundle();
    }

    public void n(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1741b.setDismissable(z);
        }
    }

    public void h(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1741b.setPaneTitle(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f1741b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void o(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1741b.setScreenReaderFocusable(z);
        } else {
            a(1, z);
        }
    }

    public void p(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1741b.setShowingHintText(z);
        } else {
            a(4, z);
        }
    }

    public void q(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1741b.setHeading(z);
        } else {
            a(2, z);
        }
    }

    public void i(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1741b.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1741b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1741b;
        if (accessibilityNodeInfo == null) {
            if (dVar.f1741b != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(dVar.f1741b)) {
            return false;
        }
        return this.f1742c == dVar.f1742c && this.f1740a == dVar.f1740a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        c(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(o());
        sb.append("; className: ");
        sb.append(p());
        sb.append("; text: ");
        sb.append(q());
        sb.append("; contentDescription: ");
        sb.append(r());
        sb.append("; viewId: ");
        sb.append(t());
        sb.append("; checkable: ");
        sb.append(c());
        sb.append("; checked: ");
        sb.append(d());
        sb.append("; focusable: ");
        sb.append(e());
        sb.append("; focused: ");
        sb.append(f());
        sb.append("; selected: ");
        sb.append(i());
        sb.append("; clickable: ");
        sb.append(j());
        sb.append("; longClickable: ");
        sb.append(k());
        sb.append("; enabled: ");
        sb.append(l());
        sb.append("; password: ");
        sb.append(m());
        sb.append("; scrollable: " + n());
        sb.append("; [");
        int b2 = b();
        while (b2 != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b2);
            b2 &= numberOfTrailingZeros ^ -1;
            sb.append(b(numberOfTrailingZeros));
            if (b2 != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void a(int i, boolean z) {
        Bundle u = u();
        if (u != null) {
            int i2 = u.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i ^ -1);
            if (!z) {
                i = 0;
            }
            u.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }
}
