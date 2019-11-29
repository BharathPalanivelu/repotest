package com.garena.android.appkit.btmsheet;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.garena.android.appkit.btmsheet.ClosableSlidingLayout;
import com.garena.android.appkit.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a extends Dialog implements DialogInterface {

    /* renamed from: a  reason: collision with root package name */
    private String f7640a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Drawable f7641b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f7642c;

    /* renamed from: d  reason: collision with root package name */
    private int f7643d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public GridView f7644e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public List<b> f7645f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public BaseAdapter f7646g;
    /* access modifiers changed from: private */
    public C0124a h;
    private boolean i;
    private boolean j = true;
    private String k;
    private boolean l;
    private float m;
    /* access modifiers changed from: private */
    public ImageView n;
    /* access modifiers changed from: private */
    public ArrayList<b> o;
    /* access modifiers changed from: private */
    public List<b> p = this.f7645f;

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r1v24, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.content.Context r8, int r9) {
        /*
            r7 = this;
            r7.<init>(r8, r9)
            r9 = 1
            r7.j = r9
            java.util.List<com.garena.android.appkit.btmsheet.a$b> r0 = r7.f7645f
            r7.p = r0
            android.content.Context r0 = r7.getContext()
            int[] r1 = com.garena.android.appkit.c.j.BottomSheet
            int r2 = com.garena.android.appkit.c.a.bottomSheetStyle2
            r3 = 0
            r4 = 0
            android.content.res.TypedArray r0 = r0.obtainStyledAttributes(r3, r1, r2, r4)
            int r1 = com.garena.android.appkit.c.j.BottomSheet_bs_moreDrawable     // Catch:{ all -> 0x00e7 }
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r1)     // Catch:{ all -> 0x00e7 }
            r7.f7642c = r1     // Catch:{ all -> 0x00e7 }
            int r1 = com.garena.android.appkit.c.j.BottomSheet_bs_closeDrawable     // Catch:{ all -> 0x00e7 }
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r1)     // Catch:{ all -> 0x00e7 }
            r7.f7641b = r1     // Catch:{ all -> 0x00e7 }
            int r1 = com.garena.android.appkit.c.j.BottomSheet_bs_moreText     // Catch:{ all -> 0x00e7 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x00e7 }
            r7.f7640a = r1     // Catch:{ all -> 0x00e7 }
            r0.recycle()
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 19
            if (r0 < r1) goto L_0x00e6
            java.lang.String r0 = "window"
            java.lang.Object r0 = r8.getSystemService(r0)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.content.res.Resources r1 = r8.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.orientation
            if (r1 != r9) goto L_0x004f
            r1 = 1
            goto L_0x0050
        L_0x004f:
            r1 = 0
        L_0x0050:
            r7.i = r1
            java.lang.String r1 = "android.os.SystemProperties"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Throwable -> 0x0076 }
            java.lang.String r2 = "get"
            java.lang.Class[] r5 = new java.lang.Class[r9]     // Catch:{ Throwable -> 0x0076 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r4] = r6     // Catch:{ Throwable -> 0x0076 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r5)     // Catch:{ Throwable -> 0x0076 }
            r1.setAccessible(r9)     // Catch:{ Throwable -> 0x0076 }
            java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch:{ Throwable -> 0x0076 }
            java.lang.String r5 = "qemu.hw.mainkeys"
            r2[r4] = r5     // Catch:{ Throwable -> 0x0076 }
            java.lang.Object r1 = r1.invoke(r3, r2)     // Catch:{ Throwable -> 0x0076 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Throwable -> 0x0076 }
            r7.k = r1     // Catch:{ Throwable -> 0x0076 }
            goto L_0x0078
        L_0x0076:
            r7.k = r3
        L_0x0078:
            r1 = 2
            int[] r1 = new int[r1]
            r1 = {16843759, 16843760} // fill-array
            android.content.res.TypedArray r1 = r8.obtainStyledAttributes(r1)
            boolean r2 = r1.getBoolean(r4, r4)     // Catch:{ all -> 0x00e1 }
            r7.j = r2     // Catch:{ all -> 0x00e1 }
            boolean r2 = r1.getBoolean(r9, r4)     // Catch:{ all -> 0x00e1 }
            r7.l = r2     // Catch:{ all -> 0x00e1 }
            r1.recycle()
            boolean r1 = r8 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0099
            r3 = r8
            android.app.Activity r3 = (android.app.Activity) r3
            goto L_0x00ab
        L_0x0099:
            boolean r1 = r8 instanceof android.content.ContextWrapper
            if (r1 == 0) goto L_0x00ab
            r1 = r8
            android.content.ContextWrapper r1 = (android.content.ContextWrapper) r1
            android.content.Context r1 = r1.getBaseContext()
            boolean r2 = r1 instanceof android.app.Activity
            if (r2 == 0) goto L_0x00ab
            r3 = r1
            android.app.Activity r3 = (android.app.Activity) r3
        L_0x00ab:
            if (r3 == 0) goto L_0x00e6
            android.view.Window r1 = r3.getWindow()
            android.view.WindowManager$LayoutParams r1 = r1.getAttributes()
            r2 = 134217728(0x8000000, float:3.85186E-34)
            int r3 = r1.flags
            r2 = r2 & r3
            if (r2 == 0) goto L_0x00be
            r7.l = r9
        L_0x00be:
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            int r1 = r1.flags
            r1 = r1 & r2
            if (r1 == 0) goto L_0x00c7
            r7.j = r9
        L_0x00c7:
            float r0 = r7.a((android.view.WindowManager) r0)
            r7.m = r0
            boolean r0 = r7.l
            if (r0 == 0) goto L_0x00d4
            r7.a((boolean) r9)
        L_0x00d4:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r9 = "status_bar_height"
            int r8 = r7.a((android.content.res.Resources) r8, (java.lang.String) r9)
            r7.f7643d = r8
            goto L_0x00e6
        L_0x00e1:
            r8 = move-exception
            r1.recycle()
            throw r8
        L_0x00e6:
            return
        L_0x00e7:
            r8 = move-exception
            r0.recycle()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.garena.android.appkit.btmsheet.a.<init>(android.content.Context, int):void");
    }

    @SuppressLint({"NewApi"})
    private float a(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 16) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    @TargetApi(14)
    private int a(Context context) {
        String str;
        Resources resources = context.getResources();
        if (Build.VERSION.SDK_INT < 14 || !b(context)) {
            return 0;
        }
        if (this.i) {
            str = "navigation_bar_height";
        } else if (!a()) {
            return 0;
        } else {
            str = "navigation_bar_height_landscape";
        }
        return a(resources, str);
    }

    @TargetApi(14)
    private boolean b(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z = resources.getBoolean(identifier);
        if ("1".equals(this.k)) {
            return false;
        }
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.k)) {
            return true;
        }
        return z;
    }

    private int a(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private boolean a() {
        return this.m >= 600.0f || this.i;
    }

    private int b() {
        try {
            Field declaredField = GridView.class.getDeclaredField("mRequestedNumColumns");
            declaredField.setAccessible(true);
            return declaredField.getInt(this.f7644e);
        } catch (Exception unused) {
            return 1;
        }
    }

    private void c(Context context) {
        setCanceledOnTouchOutside(true);
        ClosableSlidingLayout closableSlidingLayout = (ClosableSlidingLayout) View.inflate(context, c.h.bottom_sheet_dialog, (ViewGroup) null);
        setContentView(closableSlidingLayout);
        closableSlidingLayout.setSlideListener(new ClosableSlidingLayout.a() {
            public void a() {
                a.this.dismiss();
            }
        });
        setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                a aVar = a.this;
                List unused = aVar.p = aVar.f7645f;
                a.this.f7644e.setAdapter(a.this.f7646g);
                a.this.f7644e.startLayoutAnimation();
                if (a.this.h.j == null) {
                    a.this.n.setVisibility(8);
                    return;
                }
                a.this.n.setVisibility(0);
                a.this.n.setImageDrawable(a.this.h.j);
            }
        });
        if (Build.VERSION.SDK_INT >= 19) {
            closableSlidingLayout.setPadding(0, this.j ? this.f7643d : 0, 0, 0);
            closableSlidingLayout.getChildAt(0).setPadding(0, 0, 0, this.l ? a(getContext()) + closableSlidingLayout.getPaddingBottom() : 0);
        }
        TextView textView = (TextView) closableSlidingLayout.findViewById(c.f.bottom_sheet_title);
        TextView textView2 = (TextView) closableSlidingLayout.findViewById(c.f.bottom_sheet_subtitle);
        View findViewById = closableSlidingLayout.findViewById(c.f.titlePanel);
        if (this.h.f7660e != null) {
            textView.setVisibility(0);
            findViewById.setVisibility(0);
            textView.setText(this.h.f7660e);
        }
        if (this.h.f7661f != null) {
            textView2.setVisibility(0);
            findViewById.setVisibility(0);
            textView2.setText(this.h.f7661f);
        }
        this.n = (ImageView) closableSlidingLayout.findViewById(c.f.bottom_sheet_title_image);
        this.f7644e = (GridView) closableSlidingLayout.findViewById(c.f.bottom_sheet_gridview);
        if (this.h.f7656a) {
            this.f7644e.setVisibility(8);
            closableSlidingLayout.f7631a = this.h.m;
            ((ViewGroup) closableSlidingLayout.getChildAt(0)).addView(this.h.l);
        } else {
            closableSlidingLayout.f7631a = this.f7644e;
            findViewById.setBackgroundColor(-1);
            this.f7644e.setBackgroundColor(-1);
        }
        if (!this.h.f7662g) {
            this.f7644e.setNumColumns(1);
        }
        this.f7645f = this.h.f7659d;
        if (this.h.f7662g) {
            Iterator<b> it = this.f7645f.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next.f7663a) {
                    it.remove();
                } else if (next.f7668f == null) {
                    throw new IllegalArgumentException("You should set icon for each items in grid style");
                }
            }
        }
        C0124a aVar = this.h;
        int unused = aVar.k = aVar.k * b();
        if (this.f7645f.size() > this.h.k) {
            this.o = new ArrayList<>(this.f7645f);
            this.f7645f = this.f7645f.subList(0, this.h.k - 1);
            this.f7645f.add(new b(c.f.bs_more, this.f7640a, this.f7642c));
        }
        this.p = this.f7645f;
        this.f7646g = new BaseAdapter() {
            public boolean areAllItemsEnabled() {
                return false;
            }

            public long getItemId(int i) {
                return (long) i;
            }

            public int getViewTypeCount() {
                return 2;
            }

            public int getCount() {
                return a.this.p.size();
            }

            /* renamed from: a */
            public b getItem(int i) {
                return (b) a.this.p.get(i);
            }

            public boolean isEnabled(int i) {
                return getItemViewType(i) == 0 && getItem(i).f7665c;
            }

            public int getItemViewType(int i) {
                return getItem(i).f7663a ? 1 : 0;
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                C0123a aVar;
                if (getItemViewType(i) == 0) {
                    if (view == null) {
                        LayoutInflater from = LayoutInflater.from(a.this.getContext());
                        if (a.this.h.f7662g) {
                            view = from.inflate(c.h.bs_grid_entry, viewGroup, false);
                        } else {
                            view = from.inflate(c.h.bs_list_entry, viewGroup, false);
                        }
                        aVar = new C0123a();
                        TextView unused = aVar.f7651b = (TextView) view.findViewById(c.f.bs_list_title);
                        ImageView unused2 = aVar.f7652c = (ImageView) view.findViewById(c.f.bs_list_image);
                        view.setTag(aVar);
                    } else {
                        aVar = (C0123a) view.getTag();
                    }
                    b a2 = getItem(i);
                    aVar.f7651b.setText(a2.f7667e);
                    if (a2.f7664b) {
                        aVar.f7651b.setTextColor(-7829368);
                    }
                    if (a2.f7668f == null) {
                        aVar.f7652c.setVisibility(8);
                    } else {
                        aVar.f7652c.setVisibility(0);
                        aVar.f7652c.setImageDrawable(a2.f7668f);
                    }
                    return view;
                } else if (view != null) {
                    return view;
                } else {
                    View inflate = LayoutInflater.from(a.this.getContext()).inflate(c.h.bs_list_divider, viewGroup, false);
                    inflate.setVisibility(0);
                    return inflate;
                }
            }

            /* renamed from: com.garena.android.appkit.btmsheet.a$3$a  reason: collision with other inner class name */
            class C0123a {
                /* access modifiers changed from: private */

                /* renamed from: b  reason: collision with root package name */
                public TextView f7651b;
                /* access modifiers changed from: private */

                /* renamed from: c  reason: collision with root package name */
                public ImageView f7652c;

                C0123a() {
                }
            }
        };
        this.f7644e.setAdapter(this.f7646g);
        this.f7644e.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (((b) a.this.f7646g.getItem(i)).f7666d == c.f.bs_more) {
                    a aVar = a.this;
                    List unused = aVar.p = aVar.o;
                    if (Build.VERSION.SDK_INT >= 19) {
                        ChangeBounds changeBounds = new ChangeBounds();
                        changeBounds.setDuration(300);
                        TransitionManager.beginDelayedTransition(a.this.f7644e, changeBounds);
                    }
                    a.this.f7646g.notifyDataSetChanged();
                    ViewGroup.LayoutParams layoutParams = a.this.f7644e.getLayoutParams();
                    layoutParams.height = -2;
                    a.this.f7644e.setLayoutParams(layoutParams);
                    a.this.n.setVisibility(0);
                    a.this.n.setImageDrawable(a.this.f7641b);
                    a.this.n.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            List unused = a.this.p = a.this.f7645f;
                            a.this.f7646g.notifyDataSetChanged();
                            a.this.c();
                            if (a.this.h.j == null) {
                                a.this.n.setVisibility(8);
                                return;
                            }
                            a.this.n.setVisibility(0);
                            a.this.n.setImageDrawable(a.this.h.j);
                        }
                    });
                    return;
                }
                if (a.this.h.h != null) {
                    DialogInterface.OnClickListener j2 = a.this.h.h;
                    a aVar2 = a.this;
                    j2.onClick(aVar2, ((b) aVar2.f7646g.getItem(i)).f7666d);
                }
                if (a.this.h.n) {
                    a.this.dismiss();
                }
            }
        });
        if (this.h.i != null) {
            setOnDismissListener(this.h.i);
        }
        c();
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f7644e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    a.this.f7644e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    a.this.f7644e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                View childAt = a.this.f7644e.getChildAt(a.this.f7644e.getChildCount() - 1);
                if (childAt != null) {
                    a.this.f7644e.setLayoutParams(new LinearLayout.LayoutParams(-1, childAt.getBottom() + childAt.getPaddingBottom()));
                }
            }
        });
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c(getContext());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = -2;
        attributes.gravity = 80;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16842996});
        try {
            attributes.width = obtainStyledAttributes.getLayoutDimension(0, -1);
            obtainStyledAttributes.recycle();
            getWindow().setAttributes(attributes);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @TargetApi(19)
    private void a(boolean z) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
        window.setFlags(134217728, 134217728);
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f7663a;

        /* renamed from: b  reason: collision with root package name */
        boolean f7664b;

        /* renamed from: c  reason: collision with root package name */
        boolean f7665c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f7666d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f7667e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public Drawable f7668f;

        private b() {
            this.f7664b = false;
            this.f7665c = true;
        }

        private b(int i, CharSequence charSequence, Drawable drawable) {
            this.f7664b = false;
            this.f7665c = true;
            this.f7666d = i;
            this.f7667e = charSequence;
            this.f7668f = drawable;
        }

        public String toString() {
            return "MenuItem{id=" + this.f7666d + ", text=" + this.f7667e + ", icon=" + this.f7668f + ", divider=" + this.f7663a + '}';
        }
    }

    /* renamed from: com.garena.android.appkit.btmsheet.a$a  reason: collision with other inner class name */
    public static class C0124a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f7656a = false;

        /* renamed from: b  reason: collision with root package name */
        private final Context f7657b;

        /* renamed from: c  reason: collision with root package name */
        private int f7658c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final ArrayList<b> f7659d = new ArrayList<>();
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f7660e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f7661f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public boolean f7662g;
        /* access modifiers changed from: private */
        public DialogInterface.OnClickListener h;
        /* access modifiers changed from: private */
        public DialogInterface.OnDismissListener i;
        /* access modifiers changed from: private */
        public Drawable j;
        /* access modifiers changed from: private */
        public int k = 21474836;
        /* access modifiers changed from: private */
        public View l;
        /* access modifiers changed from: private */
        public View m;
        /* access modifiers changed from: private */
        public boolean n = true;

        public C0124a(Context context, int i2) {
            this.f7657b = context;
            this.f7658c = i2;
        }

        public C0124a a(View view) {
            this.f7656a = true;
            this.l = view;
            return this;
        }

        private C0124a a(b bVar) {
            this.f7659d.add(bVar);
            return this;
        }

        public C0124a a(int i2, boolean z, Drawable drawable, CharSequence charSequence) {
            b bVar = new b(i2, charSequence, drawable);
            bVar.f7665c = z;
            a(bVar);
            return this;
        }

        public C0124a a(int i2, Drawable drawable, CharSequence charSequence) {
            a(new b(i2, charSequence, drawable));
            return this;
        }

        public C0124a a(DialogInterface.OnClickListener onClickListener) {
            this.h = onClickListener;
            return this;
        }

        public a a() {
            a c2 = c();
            c2.show();
            return c2;
        }

        public C0124a b() {
            this.f7662g = true;
            return this;
        }

        @SuppressLint({"Override"})
        public a c() {
            a aVar = new a(this.f7657b, this.f7658c);
            C0124a unused = aVar.h = this;
            return aVar;
        }

        public C0124a a(CharSequence charSequence) {
            this.f7660e = charSequence;
            return this;
        }

        public C0124a b(CharSequence charSequence) {
            this.f7661f = charSequence;
            return this;
        }

        public C0124a a(DialogInterface.OnDismissListener onDismissListener) {
            this.i = onDismissListener;
            return this;
        }

        public C0124a b(View view) {
            this.m = view;
            return this;
        }

        public C0124a a(boolean z) {
            this.n = z;
            return this;
        }
    }
}
