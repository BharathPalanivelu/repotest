package com.rengwuxian.materialedittext;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.k;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.rengwuxian.materialedittext.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Marker;

public class MaterialEditText extends k {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private float I;
    private float J;
    private String K;
    private int L = -1;
    private String M;
    private float N;
    /* access modifiers changed from: private */
    public boolean O;
    private float P;
    private Typeface Q;
    private Typeface R;
    private CharSequence S;
    private boolean T;
    private int U;
    /* access modifiers changed from: private */
    public boolean V;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    Paint f15711a = new Paint(1);
    private boolean aa;
    private boolean ab;
    private Bitmap[] ac;
    private Bitmap[] ad;
    private Bitmap[] ae;
    /* access modifiers changed from: private */
    public boolean af;
    private boolean ag;
    private boolean ah;
    private int ai;
    private int aj;
    private int ak;
    private int al;
    private boolean am;
    private boolean an;
    private ColorStateList ao;
    private ColorStateList ap;
    private ArgbEvaluator aq = new ArgbEvaluator();
    private ArrayList<a> ar;
    private List<b> as;
    private com.rengwuxian.materialedittext.a.a at;
    /* access modifiers changed from: private */
    public Runnable au;

    /* renamed from: b  reason: collision with root package name */
    TextPaint f15712b = new TextPaint(1);

    /* renamed from: c  reason: collision with root package name */
    StaticLayout f15713c;

    /* renamed from: d  reason: collision with root package name */
    ObjectAnimator f15714d;

    /* renamed from: e  reason: collision with root package name */
    ObjectAnimator f15715e;

    /* renamed from: f  reason: collision with root package name */
    ObjectAnimator f15716f;

    /* renamed from: g  reason: collision with root package name */
    View.OnFocusChangeListener f15717g;
    View.OnFocusChangeListener h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    /* access modifiers changed from: private */
    public boolean r;
    /* access modifiers changed from: private */
    public boolean s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public interface a {
        void a(boolean z);
    }

    public MaterialEditText(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public MaterialEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    @TargetApi(21)
    public MaterialEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:10|11|(1:13)(2:14|15)) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r3 = getResources().getIdentifier("colorPrimary", "attr", getContext().getPackageName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x008a, code lost:
        if (r3 != 0) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x008c, code lost:
        r8.getTheme().resolveAttribute(r3, r0, true);
        r0 = r0.data;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x009d, code lost:
        throw new java.lang.RuntimeException("colorPrimary not found");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009e, code lost:
        r0 = r7.t;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0076 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r8, android.util.AttributeSet r9) {
        /*
            r7 = this;
            boolean r0 = r7.isInEditMode()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 32
            int r1 = r7.b((int) r0)
            r7.ai = r1
            r1 = 48
            int r1 = r7.b((int) r1)
            r7.aj = r1
            int r0 = r7.b((int) r0)
            r7.ak = r0
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.rengwuxian.materialedittext.c.a.inner_components_spacing
            int r0 = r0.getDimensionPixelSize(r1)
            r7.q = r0
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.rengwuxian.materialedittext.c.a.bottom_ellipsis_height
            int r0 = r0.getDimensionPixelSize(r1)
            r7.F = r0
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            int[] r1 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText
            android.content.res.TypedArray r1 = r8.obtainStyledAttributes(r9, r1)
            int r2 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_textColor
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r7.ao = r2
            int r2 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_textColorHint
            android.content.res.ColorStateList r2 = r1.getColorStateList(r2)
            r7.ap = r2
            int r2 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_baseColor
            int r0 = r1.getColor(r2, r0)
            r7.t = r0
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r2 = 1
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0076 }
            r4 = 21
            if (r3 < r4) goto L_0x006e
            android.content.res.Resources$Theme r3 = r8.getTheme()     // Catch:{ Exception -> 0x0076 }
            r4 = 16843827(0x1010433, float:2.369657E-38)
            r3.resolveAttribute(r4, r0, r2)     // Catch:{ Exception -> 0x0076 }
            int r0 = r0.data     // Catch:{ Exception -> 0x0076 }
            goto L_0x00a0
        L_0x006e:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0076 }
            java.lang.String r4 = "SDK_INT less than LOLLIPOP"
            r3.<init>(r4)     // Catch:{ Exception -> 0x0076 }
            throw r3     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            android.content.res.Resources r3 = r7.getResources()     // Catch:{ Exception -> 0x009e }
            java.lang.String r4 = "colorPrimary"
            java.lang.String r5 = "attr"
            android.content.Context r6 = r7.getContext()     // Catch:{ Exception -> 0x009e }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x009e }
            int r3 = r3.getIdentifier(r4, r5, r6)     // Catch:{ Exception -> 0x009e }
            if (r3 == 0) goto L_0x0096
            android.content.res.Resources$Theme r4 = r8.getTheme()     // Catch:{ Exception -> 0x009e }
            r4.resolveAttribute(r3, r0, r2)     // Catch:{ Exception -> 0x009e }
            int r0 = r0.data     // Catch:{ Exception -> 0x009e }
            goto L_0x00a0
        L_0x0096:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x009e }
            java.lang.String r3 = "colorPrimary not found"
            r0.<init>(r3)     // Catch:{ Exception -> 0x009e }
            throw r0     // Catch:{ Exception -> 0x009e }
        L_0x009e:
            int r0 = r7.t
        L_0x00a0:
            int r3 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_primaryColor
            int r0 = r1.getColor(r3, r0)
            r7.y = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_floatingLabel
            r3 = 0
            int r0 = r1.getInt(r0, r3)
            r7.setFloatingLabelInternal(r0)
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_errorColor
            java.lang.String r4 = "#e7492E"
            int r4 = android.graphics.Color.parseColor(r4)
            int r0 = r1.getColor(r0, r4)
            r7.z = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_minCharacters
            int r0 = r1.getInt(r0, r3)
            r7.A = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_maxCharacters
            int r0 = r1.getInt(r0, r3)
            r7.B = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_singleLineEllipsis
            boolean r0 = r1.getBoolean(r0, r3)
            r7.C = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_helperText
            java.lang.String r0 = r1.getString(r0)
            r7.K = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_helperTextColor
            r4 = -1
            int r0 = r1.getColor(r0, r4)
            r7.L = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_minBottomTextLines
            int r0 = r1.getInt(r0, r3)
            r7.H = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_accentTypeface
            java.lang.String r0 = r1.getString(r0)
            if (r0 == 0) goto L_0x010c
            boolean r5 = r7.isInEditMode()
            if (r5 != 0) goto L_0x010c
            android.graphics.Typeface r0 = r7.a((java.lang.String) r0)
            r7.Q = r0
            android.text.TextPaint r0 = r7.f15712b
            android.graphics.Typeface r5 = r7.Q
            r0.setTypeface(r5)
        L_0x010c:
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_typeface
            java.lang.String r0 = r1.getString(r0)
            if (r0 == 0) goto L_0x0125
            boolean r5 = r7.isInEditMode()
            if (r5 != 0) goto L_0x0125
            android.graphics.Typeface r0 = r7.a((java.lang.String) r0)
            r7.R = r0
            android.graphics.Typeface r0 = r7.R
            r7.setTypeface(r0)
        L_0x0125:
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_floatingLabelText
            java.lang.String r0 = r1.getString(r0)
            r7.S = r0
            java.lang.CharSequence r0 = r7.S
            if (r0 != 0) goto L_0x0137
            java.lang.CharSequence r0 = r7.getHint()
            r7.S = r0
        L_0x0137:
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_floatingLabelPadding
            int r5 = r7.q
            int r0 = r1.getDimensionPixelSize(r0, r5)
            r7.p = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_floatingLabelTextSize
            android.content.res.Resources r5 = r7.getResources()
            int r6 = com.rengwuxian.materialedittext.c.a.floating_label_text_size
            int r5 = r5.getDimensionPixelSize(r6)
            int r0 = r1.getDimensionPixelSize(r0, r5)
            r7.m = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_floatingLabelTextColor
            int r0 = r1.getColor(r0, r4)
            r7.n = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_floatingLabelAnimating
            boolean r0 = r1.getBoolean(r0, r2)
            r7.aa = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_bottomTextSize
            android.content.res.Resources r5 = r7.getResources()
            int r6 = com.rengwuxian.materialedittext.c.a.bottom_text_size
            int r5 = r5.getDimensionPixelSize(r6)
            int r0 = r1.getDimensionPixelSize(r0, r5)
            r7.o = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_hideUnderline
            boolean r0 = r1.getBoolean(r0, r3)
            r7.T = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_underlineColor
            int r0 = r1.getColor(r0, r4)
            r7.U = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_autoValidate
            boolean r0 = r1.getBoolean(r0, r3)
            r7.V = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_iconLeft
            int r0 = r1.getResourceId(r0, r4)
            android.graphics.Bitmap[] r0 = r7.a((int) r0)
            r7.ac = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_iconRight
            int r0 = r1.getResourceId(r0, r4)
            android.graphics.Bitmap[] r0 = r7.a((int) r0)
            r7.ad = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_clearButton
            boolean r0 = r1.getBoolean(r0, r3)
            r7.ag = r0
            int r0 = com.rengwuxian.materialedittext.c.b.met_ic_clear
            android.graphics.Bitmap[] r0 = r7.a((int) r0)
            r7.ae = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_iconPadding
            r4 = 16
            int r5 = r7.b((int) r4)
            int r0 = r1.getDimensionPixelSize(r0, r5)
            r7.al = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_floatingLabelAlwaysShown
            boolean r0 = r1.getBoolean(r0, r3)
            r7.D = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_helperTextAlwaysShown
            boolean r0 = r1.getBoolean(r0, r3)
            r7.E = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_validateOnFocusLost
            boolean r0 = r1.getBoolean(r0, r3)
            r7.af = r0
            int r0 = com.rengwuxian.materialedittext.c.C0249c.MaterialEditText_met_checkCharactersCountAtBeginning
            boolean r0 = r1.getBoolean(r0, r2)
            r7.ab = r0
            r1.recycle()
            r0 = 5
            int[] r0 = new int[r0]
            r0 = {16842965, 16842966, 16842967, 16842968, 16842969} // fill-array
            android.content.res.TypedArray r8 = r8.obtainStyledAttributes(r9, r0)
            int r9 = r8.getDimensionPixelSize(r3, r3)
            int r0 = r8.getDimensionPixelSize(r2, r9)
            r7.w = r0
            r0 = 2
            int r0 = r8.getDimensionPixelSize(r0, r9)
            r7.u = r0
            r0 = 3
            int r0 = r8.getDimensionPixelSize(r0, r9)
            r7.x = r0
            r0 = 4
            int r9 = r8.getDimensionPixelSize(r0, r9)
            r7.v = r9
            r8.recycle()
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 0
            if (r8 < r4) goto L_0x021b
            r7.setBackground(r9)
            goto L_0x021e
        L_0x021b:
            r7.setBackgroundDrawable(r9)
        L_0x021e:
            boolean r8 = r7.C
            if (r8 == 0) goto L_0x022c
            android.text.method.TransformationMethod r8 = r7.getTransformationMethod()
            r7.setSingleLine()
            r7.setTransformationMethod(r8)
        L_0x022c:
            r7.g()
            r7.f()
            r7.d()
            r7.j()
            r7.e()
            r7.o()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rengwuxian.materialedittext.MaterialEditText.a(android.content.Context, android.util.AttributeSet):void");
    }

    private void d() {
        if (!TextUtils.isEmpty(getText())) {
            Editable text = getText();
            setText((CharSequence) null);
            l();
            setText(text);
            setSelection(text.length());
            this.N = 1.0f;
            this.O = true;
        } else {
            l();
        }
        k();
    }

    private void e() {
        addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                MaterialEditText.this.o();
                if (MaterialEditText.this.V) {
                    MaterialEditText materialEditText = MaterialEditText.this;
                    materialEditText.postDelayed(materialEditText.getValidateRunnable(), 1000);
                } else {
                    MaterialEditText.this.setError((CharSequence) null);
                }
                MaterialEditText.this.postInvalidate();
            }
        });
    }

    /* access modifiers changed from: private */
    public Runnable getValidateRunnable() {
        Runnable runnable = this.au;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.au = new Runnable() {
            public void run() {
                MaterialEditText.this.b();
                Runnable unused = MaterialEditText.this.au = null;
            }
        };
        return this.au;
    }

    private Typeface a(String str) {
        return Typeface.createFromAsset(getContext().getAssets(), str);
    }

    public void setIconLeft(int i2) {
        this.ac = a(i2);
        f();
    }

    public void setIconLeft(Drawable drawable) {
        this.ac = a(drawable);
        f();
    }

    public void setIconLeft(Bitmap bitmap) {
        this.ac = a(bitmap);
        f();
    }

    public void setIconRight(int i2) {
        this.ad = a(i2);
        f();
    }

    public void setIconRight(Drawable drawable) {
        this.ad = a(drawable);
        f();
    }

    public void setIconRight(Bitmap bitmap) {
        this.ad = a(bitmap);
        f();
    }

    public boolean a() {
        return this.ag;
    }

    public void setShowClearButton(boolean z2) {
        this.ag = z2;
        h();
    }

    private Bitmap[] a(int i2) {
        if (i2 == -1) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i3 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), i2, options);
        int max = Math.max(options.outWidth, options.outHeight);
        int i4 = this.ai;
        if (max > i4) {
            i3 = max / i4;
        }
        options.inSampleSize = i3;
        options.inJustDecodeBounds = false;
        return a(BitmapFactory.decodeResource(getResources(), i2, options));
    }

    private Bitmap[] a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        int i2 = this.ai;
        return a(Bitmap.createScaledBitmap(createBitmap, i2, i2, false));
    }

    private Bitmap[] a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap[] bitmapArr = new Bitmap[4];
        Bitmap b2 = b(bitmap);
        bitmapArr[0] = b2.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmapArr[0]);
        int i2 = this.t;
        canvas.drawColor((a.a(i2) ? -16777216 : -1979711488) | (i2 & 16777215), PorterDuff.Mode.SRC_IN);
        bitmapArr[1] = b2.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(bitmapArr[1]).drawColor(this.y, PorterDuff.Mode.SRC_IN);
        bitmapArr[2] = b2.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas2 = new Canvas(bitmapArr[2]);
        int i3 = this.t;
        canvas2.drawColor((a.a(i3) ? 1275068416 : 1107296256) | (16777215 & i3), PorterDuff.Mode.SRC_IN);
        bitmapArr[3] = b2.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(bitmapArr[3]).drawColor(this.z, PorterDuff.Mode.SRC_IN);
        return bitmapArr;
    }

    private Bitmap b(Bitmap bitmap) {
        int i2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int max = Math.max(width, height);
        int i3 = this.ai;
        if (max == i3 || max <= i3) {
            return bitmap;
        }
        if (width > i3) {
            int i4 = i3;
            i3 = (int) (((float) i3) * (((float) height) / ((float) width)));
            i2 = i4;
        } else {
            i2 = (int) (((float) i3) * (((float) width) / ((float) height)));
        }
        return Bitmap.createScaledBitmap(bitmap, i2, i3, false);
    }

    public float getFloatingLabelFraction() {
        return this.N;
    }

    public void setFloatingLabelFraction(float f2) {
        this.N = f2;
        invalidate();
    }

    public float getFocusFraction() {
        return this.P;
    }

    public void setFocusFraction(float f2) {
        this.P = f2;
        invalidate();
    }

    public float getCurrentBottomLines() {
        return this.I;
    }

    public void setCurrentBottomLines(float f2) {
        this.I = f2;
        f();
    }

    public void setFloatingLabelAlwaysShown(boolean z2) {
        this.D = z2;
        invalidate();
    }

    public void setHelperTextAlwaysShown(boolean z2) {
        this.E = z2;
        invalidate();
    }

    public Typeface getAccentTypeface() {
        return this.Q;
    }

    public void setAccentTypeface(Typeface typeface) {
        this.Q = typeface;
        this.f15712b.setTypeface(typeface);
        postInvalidate();
    }

    public void setHideUnderline(boolean z2) {
        this.T = z2;
        f();
        postInvalidate();
    }

    public int getUnderlineColor() {
        return this.U;
    }

    public void setUnderlineColor(int i2) {
        this.U = i2;
        postInvalidate();
    }

    public CharSequence getFloatingLabelText() {
        return this.S;
    }

    public void setFloatingLabelText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = getHint();
        }
        this.S = charSequence;
        postInvalidate();
    }

    public int getFloatingLabelTextSize() {
        return this.m;
    }

    public void setFloatingLabelTextSize(int i2) {
        this.m = i2;
        f();
    }

    public int getFloatingLabelTextColor() {
        return this.n;
    }

    public void setFloatingLabelTextColor(int i2) {
        this.n = i2;
        postInvalidate();
    }

    public int getBottomTextSize() {
        return this.o;
    }

    public void setBottomTextSize(int i2) {
        this.o = i2;
        f();
    }

    private int b(int i2) {
        return b.a(getContext(), (float) i2);
    }

    private void f() {
        this.i = this.r ? this.m + this.p : this.p;
        this.f15712b.setTextSize((float) this.o);
        Paint.FontMetrics fontMetrics = this.f15712b.getFontMetrics();
        this.j = ((int) ((fontMetrics.descent - fontMetrics.ascent) * this.I)) + (this.T ? this.q : this.q * 2);
        int i2 = 0;
        this.k = this.ac == null ? 0 : this.aj + this.al;
        if (this.ad != null) {
            i2 = this.al + this.aj;
        }
        this.l = i2;
        h();
    }

    private void g() {
        int i2 = 0;
        boolean z2 = this.A > 0 || this.B > 0 || this.C || this.M != null || this.K != null;
        int i3 = this.H;
        if (i3 > 0) {
            i2 = i3;
        } else if (z2) {
            i2 = 1;
        }
        this.G = i2;
        this.I = (float) i2;
    }

    @Deprecated
    public final void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
    }

    private void h() {
        int buttonsCount = this.aj * getButtonsCount();
        int i2 = 0;
        if (!n()) {
            i2 = buttonsCount;
            buttonsCount = 0;
        }
        super.setPadding(this.w + this.k + buttonsCount, this.u + this.i, this.x + this.l + i2, this.v + this.j);
    }

    private int getButtonsCount() {
        return a() ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.ah) {
            this.ah = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (this.au != null) {
                removeCallbacks(this.au);
                this.au = null;
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            i();
        }
    }

    private boolean i() {
        int i2;
        Layout.Alignment alignment;
        if (getWidth() == 0) {
            return false;
        }
        this.f15712b.setTextSize((float) this.o);
        if (this.M == null && this.K == null) {
            i2 = this.G;
        } else {
            if ((getGravity() & 5) == 5 || n()) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else {
                alignment = (getGravity() & 3) == 3 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
            }
            Layout.Alignment alignment2 = alignment;
            String str = this.M;
            if (str == null) {
                str = this.K;
            }
            this.f15713c = new StaticLayout(str, this.f15712b, (((getWidth() - getBottomTextLeftOffset()) - getBottomTextRightOffset()) - getPaddingLeft()) - getPaddingRight(), alignment2, 1.0f, BitmapDescriptorFactory.HUE_RED, true);
            i2 = Math.max(this.f15713c.getLineCount(), this.H);
        }
        float f2 = (float) i2;
        if (this.J != f2) {
            a(f2).start();
        }
        this.J = f2;
        return true;
    }

    public int getInnerPaddingTop() {
        return this.u;
    }

    public int getInnerPaddingBottom() {
        return this.v;
    }

    public int getInnerPaddingLeft() {
        return this.w;
    }

    public int getInnerPaddingRight() {
        return this.x;
    }

    private void j() {
        addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (!MaterialEditText.this.r) {
                    return;
                }
                if (editable.length() == 0) {
                    if (MaterialEditText.this.O) {
                        boolean unused = MaterialEditText.this.O = false;
                        MaterialEditText.this.getLabelAnimator().reverse();
                    }
                } else if (!MaterialEditText.this.O) {
                    boolean unused2 = MaterialEditText.this.O = true;
                    MaterialEditText.this.getLabelAnimator().start();
                }
            }
        });
        this.f15717g = new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (MaterialEditText.this.r && MaterialEditText.this.s) {
                    if (z) {
                        MaterialEditText.this.getLabelFocusAnimator().start();
                    } else {
                        MaterialEditText.this.getLabelFocusAnimator().reverse();
                    }
                }
                if (MaterialEditText.this.af && !z) {
                    MaterialEditText.this.b();
                }
                if (MaterialEditText.this.h != null) {
                    MaterialEditText.this.h.onFocusChange(view, z);
                }
            }
        };
        super.setOnFocusChangeListener(this.f15717g);
    }

    public void setValidateOnFocusLost(boolean z2) {
        this.af = z2;
    }

    public void a(a aVar) {
        if (this.ar == null) {
            this.ar = new ArrayList<>();
        }
        this.ar.add(aVar);
    }

    public void setBaseColor(int i2) {
        if (this.t != i2) {
            this.t = i2;
        }
        d();
        postInvalidate();
    }

    public void setPrimaryColor(int i2) {
        this.y = i2;
        postInvalidate();
    }

    public void setMetTextColor(int i2) {
        this.ao = ColorStateList.valueOf(i2);
        k();
    }

    public void setMetTextColor(ColorStateList colorStateList) {
        this.ao = colorStateList;
        k();
    }

    private void k() {
        ColorStateList colorStateList = this.ao;
        if (colorStateList == null) {
            int[][] iArr = {new int[]{16842910}, EMPTY_STATE_SET};
            int i2 = this.t;
            this.ao = new ColorStateList(iArr, new int[]{(i2 & 16777215) | -553648128, (i2 & 16777215) | 1140850688});
            setTextColor(this.ao);
            return;
        }
        setTextColor(colorStateList);
    }

    public void setMetHintTextColor(int i2) {
        this.ap = ColorStateList.valueOf(i2);
        l();
    }

    public void setMetHintTextColor(ColorStateList colorStateList) {
        this.ap = colorStateList;
        l();
    }

    private void l() {
        ColorStateList colorStateList = this.ap;
        if (colorStateList == null) {
            setHintTextColor((this.t & 16777215) | 1140850688);
        } else {
            setHintTextColor(colorStateList);
        }
    }

    private void setFloatingLabelInternal(int i2) {
        if (i2 == 1) {
            this.r = true;
            this.s = false;
        } else if (i2 != 2) {
            this.r = false;
            this.s = false;
        } else {
            this.r = true;
            this.s = true;
        }
    }

    public void setFloatingLabel(int i2) {
        setFloatingLabelInternal(i2);
        f();
    }

    public int getFloatingLabelPadding() {
        return this.p;
    }

    public void setFloatingLabelPadding(int i2) {
        this.p = i2;
        postInvalidate();
    }

    public void setFloatingLabelAnimating(boolean z2) {
        this.aa = z2;
    }

    public void setSingleLineEllipsis(boolean z2) {
        this.C = z2;
        g();
        f();
        postInvalidate();
    }

    public int getMaxCharacters() {
        return this.B;
    }

    public void setMaxCharacters(int i2) {
        this.B = i2;
        g();
        f();
        postInvalidate();
    }

    public int getMinCharacters() {
        return this.A;
    }

    public void setMinCharacters(int i2) {
        this.A = i2;
        g();
        f();
        postInvalidate();
    }

    public int getMinBottomTextLines() {
        return this.H;
    }

    public void setMinBottomTextLines(int i2) {
        this.H = i2;
        g();
        f();
        postInvalidate();
    }

    public void setAutoValidate(boolean z2) {
        this.V = z2;
        if (z2) {
            postDelayed(getValidateRunnable(), 1000);
        }
    }

    public int getErrorColor() {
        return this.z;
    }

    public void setErrorColor(int i2) {
        this.z = i2;
        postInvalidate();
    }

    public void setHelperText(CharSequence charSequence) {
        this.K = charSequence == null ? null : charSequence.toString();
        if (i()) {
            postInvalidate();
        }
    }

    public String getHelperText() {
        return this.K;
    }

    public int getHelperTextColor() {
        return this.L;
    }

    public void setHelperTextColor(int i2) {
        this.L = i2;
        postInvalidate();
    }

    public void setError(CharSequence charSequence) {
        this.M = charSequence == null ? null : charSequence.toString();
        if (i()) {
            postInvalidate();
        }
    }

    public CharSequence getError() {
        return this.M;
    }

    private boolean m() {
        return this.M == null && c();
    }

    public boolean a(b bVar) {
        Editable text = getText();
        boolean a2 = bVar.a(text, text.length() == 0);
        if (!a2) {
            setError(bVar.a());
        }
        postInvalidate();
        return a2;
    }

    public boolean b() {
        List<b> list = this.as;
        if (list == null || list.isEmpty()) {
            return true;
        }
        Editable text = getText();
        boolean z2 = text.length() == 0;
        Iterator<b> it = this.as.iterator();
        boolean z3 = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            b next = it.next();
            if (!z3 || !next.a(text, z2)) {
                z3 = false;
                continue;
            } else {
                z3 = true;
                continue;
            }
            if (!z3) {
                setError(next.a());
                break;
            }
        }
        if (z3) {
            setError((CharSequence) null);
        }
        ArrayList<a> arrayList = this.ar;
        if (arrayList != null) {
            Iterator<a> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().a(z3);
            }
        }
        postInvalidate();
        return z3;
    }

    public MaterialEditText b(b bVar) {
        if (this.as == null) {
            this.as = new ArrayList();
        }
        this.as.add(bVar);
        return this;
    }

    public List<b> getValidators() {
        return this.as;
    }

    public void setLengthChecker(com.rengwuxian.materialedittext.a.a aVar) {
        this.at = aVar;
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        if (this.f15717g == null) {
            super.setOnFocusChangeListener(onFocusChangeListener);
        } else {
            this.h = onFocusChangeListener;
        }
    }

    /* access modifiers changed from: private */
    public ObjectAnimator getLabelAnimator() {
        if (this.f15714d == null) {
            this.f15714d = ObjectAnimator.ofFloat(this, "floatingLabelFraction", new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
        }
        this.f15714d.setDuration(this.aa ? 300 : 0);
        return this.f15714d;
    }

    /* access modifiers changed from: private */
    public ObjectAnimator getLabelFocusAnimator() {
        if (this.f15715e == null) {
            this.f15715e = ObjectAnimator.ofFloat(this, "focusFraction", new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
        }
        return this.f15715e;
    }

    private ObjectAnimator a(float f2) {
        ObjectAnimator objectAnimator = this.f15716f;
        if (objectAnimator == null) {
            this.f15716f = ObjectAnimator.ofFloat(this, "currentBottomLines", new float[]{f2});
        } else {
            objectAnimator.cancel();
            this.f15716f.setFloatValues(new float[]{f2});
        }
        return this.f15716f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        Canvas canvas2 = canvas;
        int scrollX = getScrollX() + (this.ac == null ? 0 : this.aj + this.al) + getPaddingLeft();
        int scrollX2 = (getScrollX() + (this.ad == null ? getWidth() : (getWidth() - this.aj) - this.al)) - getPaddingRight();
        int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
        this.f15711a.setAlpha(255);
        Bitmap[] bitmapArr = this.ac;
        if (bitmapArr != null) {
            Bitmap bitmap = bitmapArr[!m() ? 3 : !isEnabled() ? 2 : hasFocus() ? (char) 1 : 0];
            int i6 = this.aj;
            int width = ((scrollX - this.al) - i6) + ((i6 - bitmap.getWidth()) / 2);
            int i7 = this.ak;
            canvas2.drawBitmap(bitmap, (float) width, (float) (((this.q + scrollY) - i7) + ((i7 - bitmap.getHeight()) / 2)), this.f15711a);
        }
        Bitmap[] bitmapArr2 = this.ad;
        if (bitmapArr2 != null) {
            Bitmap bitmap2 = bitmapArr2[!m() ? 3 : !isEnabled() ? 2 : hasFocus() ? (char) 1 : 0];
            int width2 = this.al + scrollX2 + ((this.aj - bitmap2.getWidth()) / 2);
            int i8 = this.ak;
            canvas2.drawBitmap(bitmap2, (float) width2, (float) (((this.q + scrollY) - i8) + ((i8 - bitmap2.getHeight()) / 2)), this.f15711a);
        }
        if (hasFocus() && this.ag && !TextUtils.isEmpty(getText()) && isEnabled()) {
            this.f15711a.setAlpha(255);
            if (n()) {
                i5 = scrollX;
            } else {
                i5 = scrollX2 - this.aj;
            }
            Bitmap bitmap3 = this.ae[0];
            int width3 = i5 + ((this.aj - bitmap3.getWidth()) / 2);
            int i9 = this.ak;
            canvas2.drawBitmap(bitmap3, (float) width3, (float) (((this.q + scrollY) - i9) + ((i9 - bitmap3.getHeight()) / 2)), this.f15711a);
        }
        int i10 = -1;
        if (!this.T) {
            int i11 = scrollY + this.q;
            if (!m()) {
                this.f15711a.setColor(this.z);
                i4 = i11;
                canvas.drawRect((float) scrollX, (float) i11, (float) scrollX2, (float) (b(2) + i11), this.f15711a);
            } else {
                i4 = i11;
                if (!isEnabled()) {
                    Paint paint = this.f15711a;
                    int i12 = this.U;
                    if (i12 == -1) {
                        i12 = (this.t & 16777215) | 1140850688;
                    }
                    paint.setColor(i12);
                    float b2 = (float) b(1);
                    float f2 = BitmapDescriptorFactory.HUE_RED;
                    while (f2 < ((float) getWidth())) {
                        float f3 = ((float) scrollX) + f2;
                        float f4 = b2;
                        canvas.drawRect(f3, (float) i4, f3 + b2, (float) (b(1) + i4), this.f15711a);
                        f2 += f4 * 3.0f;
                        b2 = f4;
                    }
                } else if (hasFocus()) {
                    this.f15711a.setColor(this.y);
                    canvas.drawRect((float) scrollX, (float) i4, (float) scrollX2, (float) (i4 + b(2)), this.f15711a);
                } else {
                    Paint paint2 = this.f15711a;
                    int i13 = this.U;
                    if (i13 == -1) {
                        i13 = (this.t & 16777215) | 503316480;
                    }
                    paint2.setColor(i13);
                    canvas.drawRect((float) scrollX, (float) i4, (float) scrollX2, (float) (i4 + b(1)), this.f15711a);
                }
            }
            scrollY = i4;
        }
        this.f15712b.setTextSize((float) this.o);
        Paint.FontMetrics fontMetrics = this.f15712b.getFontMetrics();
        float f5 = (-fontMetrics.ascent) - fontMetrics.descent;
        float f6 = ((float) this.o) + fontMetrics.ascent + fontMetrics.descent;
        if ((hasFocus() && p()) || !c()) {
            this.f15712b.setColor(c() ? (this.t & 16777215) | 1140850688 : this.z);
            String charactersCounterText = getCharactersCounterText();
            canvas2.drawText(charactersCounterText, n() ? (float) scrollX : ((float) scrollX2) - this.f15712b.measureText(charactersCounterText), ((float) (this.q + scrollY)) + f5, this.f15712b);
        }
        if (this.f15713c != null && (this.M != null || ((this.E || hasFocus()) && !TextUtils.isEmpty(this.K)))) {
            TextPaint textPaint = this.f15712b;
            if (this.M != null) {
                i3 = this.z;
            } else {
                i3 = this.L;
                if (i3 == -1) {
                    i3 = (this.t & 16777215) | 1140850688;
                }
            }
            textPaint.setColor(i3);
            canvas.save();
            if (n()) {
                canvas2.translate((float) (scrollX2 - this.f15713c.getWidth()), ((float) (this.q + scrollY)) - f6);
            } else {
                canvas2.translate((float) (getBottomTextLeftOffset() + scrollX), ((float) (this.q + scrollY)) - f6);
            }
            this.f15713c.draw(canvas2);
            canvas.restore();
        }
        if (this.r && !TextUtils.isEmpty(this.S)) {
            this.f15712b.setTextSize((float) this.m);
            TextPaint textPaint2 = this.f15712b;
            ArgbEvaluator argbEvaluator = this.aq;
            float f7 = this.P * (isEnabled() ? 1.0f : 0.0f);
            int i14 = this.n;
            if (i14 == -1) {
                i14 = (this.t & 16777215) | 1140850688;
            }
            textPaint2.setColor(((Integer) argbEvaluator.evaluate(f7, Integer.valueOf(i14), Integer.valueOf(this.y))).intValue());
            float measureText = this.f15712b.measureText(this.S.toString());
            if ((getGravity() & 5) == 5 || n()) {
                i2 = (int) (((float) scrollX2) - measureText);
            } else {
                i2 = (getGravity() & 3) == 3 ? scrollX : ((int) (((float) getInnerPaddingLeft()) + ((((float) ((getWidth() - getInnerPaddingLeft()) - getInnerPaddingRight())) - measureText) / 2.0f))) + scrollX;
            }
            int i15 = this.p;
            float f8 = 1.0f;
            int scrollY2 = (int) ((((float) ((this.u + this.m) + i15)) - (((float) i15) * (this.D ? 1.0f : this.N))) + ((float) getScrollY()));
            float f9 = (this.D ? 1.0f : this.N) * 255.0f * ((this.P * 0.74f * (isEnabled() ? 1.0f : 0.0f)) + 0.26f);
            int i16 = this.n;
            if (i16 == -1) {
                f8 = ((float) Color.alpha(i16)) / 256.0f;
            }
            this.f15712b.setAlpha((int) (f9 * f8));
            canvas2.drawText(this.S.toString(), (float) i2, (float) scrollY2, this.f15712b);
        }
        if (hasFocus() && this.C && getScrollX() != 0) {
            this.f15711a.setColor(m() ? this.y : this.z);
            float f10 = (float) (scrollY + this.q);
            if (n()) {
                scrollX = scrollX2;
            }
            if (!n()) {
                i10 = 1;
            }
            int i17 = this.F;
            canvas2.drawCircle((float) (((i10 * i17) / 2) + scrollX), ((float) (i17 / 2)) + f10, (float) (i17 / 2), this.f15711a);
            int i18 = this.F;
            canvas2.drawCircle((float) ((((i10 * i18) * 5) / 2) + scrollX), ((float) (i18 / 2)) + f10, (float) (i18 / 2), this.f15711a);
            int i19 = this.F;
            canvas2.drawCircle((float) (scrollX + (((i10 * i19) * 9) / 2)), f10 + ((float) (i19 / 2)), (float) (i19 / 2), this.f15711a);
        }
        super.onDraw(canvas);
    }

    @TargetApi(17)
    private boolean n() {
        if (Build.VERSION.SDK_INT >= 17 && getResources().getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private int getBottomTextLeftOffset() {
        return n() ? getCharactersCounterWidth() : getBottomEllipsisWidth();
    }

    private int getBottomTextRightOffset() {
        return n() ? getBottomEllipsisWidth() : getCharactersCounterWidth();
    }

    private int getCharactersCounterWidth() {
        if (p()) {
            return (int) this.f15712b.measureText(getCharactersCounterText());
        }
        return 0;
    }

    private int getBottomEllipsisWidth() {
        if (this.C) {
            return (this.F * 5) + b(4);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        if (r0 > r3) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o() {
        /*
            r4 = this;
            boolean r0 = r4.ah
            r1 = 1
            if (r0 != 0) goto L_0x0009
            boolean r0 = r4.ab
            if (r0 == 0) goto L_0x000f
        L_0x0009:
            boolean r0 = r4.p()
            if (r0 != 0) goto L_0x0012
        L_0x000f:
            r4.W = r1
            goto L_0x002d
        L_0x0012:
            android.text.Editable r0 = r4.getText()
            r2 = 0
            if (r0 != 0) goto L_0x001b
            r0 = 0
            goto L_0x001f
        L_0x001b:
            int r0 = r4.a((java.lang.CharSequence) r0)
        L_0x001f:
            int r3 = r4.A
            if (r0 < r3) goto L_0x002a
            int r3 = r4.B
            if (r3 <= 0) goto L_0x002b
            if (r0 > r3) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r1 = 0
        L_0x002b:
            r4.W = r1
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rengwuxian.materialedittext.MaterialEditText.o():void");
    }

    public boolean c() {
        return this.W;
    }

    private boolean p() {
        return this.A > 0 || this.B > 0;
    }

    private String getCharactersCounterText() {
        int i2;
        StringBuilder sb;
        StringBuilder sb2;
        int i3;
        StringBuilder sb3;
        if (this.A <= 0) {
            if (n()) {
                sb3 = new StringBuilder();
                sb3.append(this.B);
                sb3.append(" / ");
                i3 = a((CharSequence) getText());
            } else {
                sb3 = new StringBuilder();
                sb3.append(a((CharSequence) getText()));
                sb3.append(" / ");
                i3 = this.B;
            }
            sb3.append(i3);
            return sb3.toString();
        } else if (this.B <= 0) {
            if (n()) {
                sb2 = new StringBuilder();
                sb2.append(Marker.ANY_NON_NULL_MARKER);
                sb2.append(this.A);
                sb2.append(" / ");
                sb2.append(a((CharSequence) getText()));
            } else {
                sb2 = new StringBuilder();
                sb2.append(a((CharSequence) getText()));
                sb2.append(" / ");
                sb2.append(this.A);
                sb2.append(Marker.ANY_NON_NULL_MARKER);
            }
            return sb2.toString();
        } else {
            if (n()) {
                sb = new StringBuilder();
                sb.append(this.B);
                sb.append("-");
                sb.append(this.A);
                sb.append(" / ");
                i2 = a((CharSequence) getText());
            } else {
                sb = new StringBuilder();
                sb.append(a((CharSequence) getText()));
                sb.append(" / ");
                sb.append(this.A);
                sb.append("-");
                i2 = this.B;
            }
            sb.append(i2);
            return sb.toString();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.C || getScrollX() <= 0 || motionEvent.getAction() != 0 || motionEvent.getX() >= ((float) b(20)) || motionEvent.getY() <= ((float) ((getHeight() - this.j) - this.v)) || motionEvent.getY() >= ((float) (getHeight() - this.v))) {
            if (hasFocus() && this.ag && isEnabled()) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        if (this.an) {
                            if (!TextUtils.isEmpty(getText())) {
                                setText((CharSequence) null);
                            }
                            this.an = false;
                        }
                        if (this.am) {
                            this.am = false;
                            return true;
                        }
                        this.am = false;
                    } else if (action != 2) {
                        if (action == 3) {
                            this.am = false;
                            this.an = false;
                        }
                    }
                } else if (a(motionEvent)) {
                    this.am = true;
                    this.an = true;
                    return true;
                }
                if (this.an && !a(motionEvent)) {
                    this.an = false;
                }
                if (this.am) {
                    return true;
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        setSelection(0);
        return false;
    }

    private boolean a(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        int scrollX = getScrollX() + (this.ac == null ? 0 : this.aj + this.al);
        int scrollX2 = getScrollX() + (this.ad == null ? getWidth() : (getWidth() - this.aj) - this.al);
        if (!n()) {
            scrollX = scrollX2 - this.aj;
        }
        int scrollY = ((getScrollY() + getHeight()) - getPaddingBottom()) + this.q;
        int i2 = this.ak;
        int i3 = scrollY - i2;
        if (x2 < ((float) scrollX) || x2 >= ((float) (scrollX + this.aj)) || y2 < ((float) i3) || y2 >= ((float) (i3 + i2))) {
            return false;
        }
        return true;
    }

    private int a(CharSequence charSequence) {
        com.rengwuxian.materialedittext.a.a aVar = this.at;
        if (aVar == null) {
            return charSequence.length();
        }
        return aVar.a(charSequence);
    }
}
