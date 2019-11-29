package androidx.m.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.graphics.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i extends h {

    /* renamed from: a  reason: collision with root package name */
    static final PorterDuff.Mode f2620a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private g f2621b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuffColorFilter f2622c;

    /* renamed from: e  reason: collision with root package name */
    private ColorFilter f2623e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2624f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2625g;
    private Drawable.ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    i() {
        this.f2625g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f2621b = new g();
    }

    i(g gVar) {
        this.f2625g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.f2621b = gVar;
        this.f2622c = a(this.f2622c, gVar.f2649c, gVar.f2650d);
    }

    public Drawable mutate() {
        if (this.f2619d != null) {
            this.f2619d.mutate();
            return this;
        }
        if (!this.f2624f && super.mutate() == this) {
            this.f2621b = new g(this.f2621b);
            this.f2624f = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public Object a(String str) {
        return this.f2621b.f2648b.k.get(str);
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f2619d != null && Build.VERSION.SDK_INT >= 24) {
            return new h(this.f2619d.getConstantState());
        }
        this.f2621b.f2647a = getChangingConfigurations();
        return this.f2621b;
    }

    public void draw(Canvas canvas) {
        if (this.f2619d != null) {
            this.f2619d.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() > 0 && this.k.height() > 0) {
            ColorFilter colorFilter = this.f2623e;
            if (colorFilter == null) {
                colorFilter = this.f2622c;
            }
            canvas.getMatrix(this.j);
            this.j.getValues(this.i);
            float abs = Math.abs(this.i[0]);
            float abs2 = Math.abs(this.i[4]);
            float abs3 = Math.abs(this.i[1]);
            float abs4 = Math.abs(this.i[3]);
            if (!(abs3 == BitmapDescriptorFactory.HUE_RED && abs4 == BitmapDescriptorFactory.HUE_RED)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.k.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.k.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate((float) this.k.left, (float) this.k.top);
                if (a()) {
                    canvas.translate((float) this.k.width(), BitmapDescriptorFactory.HUE_RED);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.k.offsetTo(0, 0);
                this.f2621b.b(min, min2);
                if (!this.f2625g) {
                    this.f2621b.a(min, min2);
                } else if (!this.f2621b.b()) {
                    this.f2621b.a(min, min2);
                    this.f2621b.c();
                }
                this.f2621b.a(canvas, colorFilter, this.k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        if (this.f2619d != null) {
            return androidx.core.graphics.drawable.a.c(this.f2619d);
        }
        return this.f2621b.f2648b.getRootAlpha();
    }

    public void setAlpha(int i2) {
        if (this.f2619d != null) {
            this.f2619d.setAlpha(i2);
        } else if (this.f2621b.f2648b.getRootAlpha() != i2) {
            this.f2621b.f2648b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f2619d != null) {
            this.f2619d.setColorFilter(colorFilter);
            return;
        }
        this.f2623e = colorFilter;
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        if (this.f2619d != null) {
            return androidx.core.graphics.drawable.a.e(this.f2619d);
        }
        return this.f2623e;
    }

    /* access modifiers changed from: package-private */
    public PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setTint(int i2) {
        if (this.f2619d != null) {
            androidx.core.graphics.drawable.a.a(this.f2619d, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.f2619d != null) {
            androidx.core.graphics.drawable.a.a(this.f2619d, colorStateList);
            return;
        }
        g gVar = this.f2621b;
        if (gVar.f2649c != colorStateList) {
            gVar.f2649c = colorStateList;
            this.f2622c = a(this.f2622c, colorStateList, gVar.f2650d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f2619d != null) {
            androidx.core.graphics.drawable.a.a(this.f2619d, mode);
            return;
        }
        g gVar = this.f2621b;
        if (gVar.f2650d != mode) {
            gVar.f2650d = mode;
            this.f2622c = a(this.f2622c, gVar.f2649c, mode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (this.f2619d != null) {
            return this.f2619d.isStateful();
        }
        if (!super.isStateful()) {
            g gVar = this.f2621b;
            if (gVar == null || (!gVar.d() && (this.f2621b.f2649c == null || !this.f2621b.f2649c.isStateful()))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.f2619d != null) {
            return this.f2619d.setState(iArr);
        }
        boolean z = false;
        g gVar = this.f2621b;
        if (!(gVar.f2649c == null || gVar.f2650d == null)) {
            this.f2622c = a(this.f2622c, gVar.f2649c, gVar.f2650d);
            invalidateSelf();
            z = true;
        }
        if (!gVar.d() || !gVar.a(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public int getOpacity() {
        if (this.f2619d != null) {
            return this.f2619d.getOpacity();
        }
        return -3;
    }

    public int getIntrinsicWidth() {
        if (this.f2619d != null) {
            return this.f2619d.getIntrinsicWidth();
        }
        return (int) this.f2621b.f2648b.f2643d;
    }

    public int getIntrinsicHeight() {
        if (this.f2619d != null) {
            return this.f2619d.getIntrinsicHeight();
        }
        return (int) this.f2621b.f2648b.f2644e;
    }

    public boolean canApplyTheme() {
        if (this.f2619d == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.d(this.f2619d);
        return false;
    }

    public boolean isAutoMirrored() {
        if (this.f2619d != null) {
            return androidx.core.graphics.drawable.a.b(this.f2619d);
        }
        return this.f2621b.f2651e;
    }

    public void setAutoMirrored(boolean z) {
        if (this.f2619d != null) {
            androidx.core.graphics.drawable.a.a(this.f2619d, z);
        } else {
            this.f2621b.f2651e = z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.m.a.a.i a(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0023
            androidx.m.a.a.i r0 = new androidx.m.a.a.i
            r0.<init>()
            android.graphics.drawable.Drawable r6 = androidx.core.content.a.f.a(r6, r7, r8)
            r0.f2619d = r6
            androidx.m.a.a.i$h r6 = new androidx.m.a.a.i$h
            android.graphics.drawable.Drawable r7 = r0.f2619d
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.h = r6
            return r0
        L_0x0023:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x002b:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            r4 = 2
            if (r3 == r4) goto L_0x0036
            r5 = 1
            if (r3 == r5) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            if (r3 != r4) goto L_0x003d
            androidx.m.a.a.i r6 = a(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            return r6
        L_0x003d:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            throw r6     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x0045:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x004e
        L_0x004a:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x004e:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.m.a.a.i.a(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.m.a.a.i");
    }

    public static i a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (((float) Color.alpha(i2)) * f2)) << 24);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.f2619d != null) {
            this.f2619d.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.f2619d != null) {
            androidx.core.graphics.drawable.a.a(this.f2619d, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.f2621b;
        gVar.f2648b = new f();
        TypedArray a2 = androidx.core.content.a.g.a(resources, theme, attributeSet, a.f2595a);
        a(a2, xmlPullParser, theme);
        a2.recycle();
        gVar.f2647a = getChangingConfigurations();
        gVar.k = true;
        b(resources, xmlPullParser, attributeSet, theme);
        this.f2622c = a(this.f2622c, gVar.f2649c, gVar.f2650d);
    }

    private static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        g gVar = this.f2621b;
        f fVar = gVar.f2648b;
        gVar.f2650d = a(androidx.core.content.a.g.a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList a2 = androidx.core.content.a.g.a(typedArray, xmlPullParser, theme, "tint", 1);
        if (a2 != null) {
            gVar.f2649c = a2;
        }
        gVar.f2651e = androidx.core.content.a.g.a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.f2651e);
        fVar.f2645f = androidx.core.content.a.g.a(typedArray, xmlPullParser, "viewportWidth", 7, fVar.f2645f);
        fVar.f2646g = androidx.core.content.a.g.a(typedArray, xmlPullParser, "viewportHeight", 8, fVar.f2646g);
        if (fVar.f2645f <= BitmapDescriptorFactory.HUE_RED) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (fVar.f2646g > BitmapDescriptorFactory.HUE_RED) {
            fVar.f2643d = typedArray.getDimension(3, fVar.f2643d);
            fVar.f2644e = typedArray.getDimension(2, fVar.f2644e);
            if (fVar.f2643d <= BitmapDescriptorFactory.HUE_RED) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (fVar.f2644e > BitmapDescriptorFactory.HUE_RED) {
                fVar.setAlpha(androidx.core.content.a.g.a(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    fVar.i = string;
                    fVar.k.put(string, fVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        g gVar = this.f2621b;
        f fVar = gVar.f2648b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.f2642c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2634b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.k.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    gVar.f2647a = bVar.o | gVar.f2647a;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2634b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.k.put(aVar.getPathName(), aVar);
                    }
                    gVar.f2647a = aVar.o | gVar.f2647a;
                } else if ("group".equals(name)) {
                    c cVar2 = new c();
                    cVar2.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2634b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.k.put(cVar2.getGroupName(), cVar2);
                    }
                    gVar.f2647a = cVar2.f2637e | gVar.f2647a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f2625g = z;
    }

    private boolean a() {
        if (Build.VERSION.SDK_INT < 17 || !isAutoMirrored() || androidx.core.graphics.drawable.a.i(this) != 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f2619d != null) {
            this.f2619d.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        if (this.f2619d != null) {
            return this.f2619d.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f2621b.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.f2619d != null) {
            this.f2619d.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        if (this.f2619d != null) {
            this.f2619d.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.f2619d != null) {
            return this.f2619d.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.f2619d != null) {
            this.f2619d.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    private static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f2654a;

        public h(Drawable.ConstantState constantState) {
            this.f2654a = constantState;
        }

        public Drawable newDrawable() {
            i iVar = new i();
            iVar.f2619d = (VectorDrawable) this.f2654a.newDrawable();
            return iVar;
        }

        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f2619d = (VectorDrawable) this.f2654a.newDrawable(resources);
            return iVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f2619d = (VectorDrawable) this.f2654a.newDrawable(resources, theme);
            return iVar;
        }

        public boolean canApplyTheme() {
            return this.f2654a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f2654a.getChangingConfigurations();
        }
    }

    private static class g extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f2647a;

        /* renamed from: b  reason: collision with root package name */
        f f2648b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f2649c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f2650d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2651e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f2652f;

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f2653g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public g(g gVar) {
            this.f2649c = null;
            this.f2650d = i.f2620a;
            if (gVar != null) {
                this.f2647a = gVar.f2647a;
                this.f2648b = new f(gVar.f2648b);
                if (gVar.f2648b.f2641b != null) {
                    this.f2648b.f2641b = new Paint(gVar.f2648b.f2641b);
                }
                if (gVar.f2648b.f2640a != null) {
                    this.f2648b.f2640a = new Paint(gVar.f2648b.f2640a);
                }
                this.f2649c = gVar.f2649c;
                this.f2650d = gVar.f2650d;
                this.f2651e = gVar.f2651e;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f2652f, (Rect) null, rect, a(colorFilter));
        }

        public boolean a() {
            return this.f2648b.getRootAlpha() < 255;
        }

        public Paint a(ColorFilter colorFilter) {
            if (!a() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new Paint();
                this.l.setFilterBitmap(true);
            }
            this.l.setAlpha(this.f2648b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public void a(int i2, int i3) {
            this.f2652f.eraseColor(0);
            this.f2648b.a(new Canvas(this.f2652f), i2, i3, (ColorFilter) null);
        }

        public void b(int i2, int i3) {
            if (this.f2652f == null || !c(i2, i3)) {
                this.f2652f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean c(int i2, int i3) {
            return i2 == this.f2652f.getWidth() && i3 == this.f2652f.getHeight();
        }

        public boolean b() {
            return !this.k && this.f2653g == this.f2649c && this.h == this.f2650d && this.j == this.f2651e && this.i == this.f2648b.getRootAlpha();
        }

        public void c() {
            this.f2653g = this.f2649c;
            this.h = this.f2650d;
            this.i = this.f2648b.getRootAlpha();
            this.j = this.f2651e;
            this.k = false;
        }

        public g() {
            this.f2649c = null;
            this.f2650d = i.f2620a;
            this.f2648b = new f();
        }

        public Drawable newDrawable() {
            return new i(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public int getChangingConfigurations() {
            return this.f2647a;
        }

        public boolean d() {
            return this.f2648b.a();
        }

        public boolean a(int[] iArr) {
            boolean a2 = this.f2648b.a(iArr);
            this.k |= a2;
            return a2;
        }
    }

    private static class f {
        private static final Matrix n = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        Paint f2640a;

        /* renamed from: b  reason: collision with root package name */
        Paint f2641b;

        /* renamed from: c  reason: collision with root package name */
        final c f2642c;

        /* renamed from: d  reason: collision with root package name */
        float f2643d;

        /* renamed from: e  reason: collision with root package name */
        float f2644e;

        /* renamed from: f  reason: collision with root package name */
        float f2645f;

        /* renamed from: g  reason: collision with root package name */
        float f2646g;
        int h;
        String i;
        Boolean j;
        final androidx.b.a<String, Object> k;
        private final Path l;
        private final Path m;
        private final Matrix o;
        private PathMeasure p;
        private int q;

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        public f() {
            this.o = new Matrix();
            this.f2643d = BitmapDescriptorFactory.HUE_RED;
            this.f2644e = BitmapDescriptorFactory.HUE_RED;
            this.f2645f = BitmapDescriptorFactory.HUE_RED;
            this.f2646g = BitmapDescriptorFactory.HUE_RED;
            this.h = 255;
            this.i = null;
            this.j = null;
            this.k = new androidx.b.a<>();
            this.f2642c = new c();
            this.l = new Path();
            this.m = new Path();
        }

        public void setRootAlpha(int i2) {
            this.h = i2;
        }

        public int getRootAlpha() {
            return this.h;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public f(f fVar) {
            this.o = new Matrix();
            this.f2643d = BitmapDescriptorFactory.HUE_RED;
            this.f2644e = BitmapDescriptorFactory.HUE_RED;
            this.f2645f = BitmapDescriptorFactory.HUE_RED;
            this.f2646g = BitmapDescriptorFactory.HUE_RED;
            this.h = 255;
            this.i = null;
            this.j = null;
            this.k = new androidx.b.a<>();
            this.f2642c = new c(fVar.f2642c, this.k);
            this.l = new Path(fVar.l);
            this.m = new Path(fVar.m);
            this.f2643d = fVar.f2643d;
            this.f2644e = fVar.f2644e;
            this.f2645f = fVar.f2645f;
            this.f2646g = fVar.f2646g;
            this.q = fVar.q;
            this.h = fVar.h;
            this.i = fVar.i;
            String str = fVar.i;
            if (str != null) {
                this.k.put(str, this);
            }
            this.j = fVar.j;
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            cVar.f2633a.set(matrix);
            cVar.f2633a.preConcat(cVar.f2636d);
            canvas.save();
            for (int i4 = 0; i4 < cVar.f2634b.size(); i4++) {
                d dVar = cVar.f2634b.get(i4);
                if (dVar instanceof c) {
                    a((c) dVar, cVar.f2633a, canvas, i2, i3, colorFilter);
                } else if (dVar instanceof e) {
                    a(cVar, (e) dVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        public void a(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            a(this.f2642c, n, canvas, i2, i3, colorFilter);
        }

        private void a(c cVar, e eVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = ((float) i2) / this.f2645f;
            float f3 = ((float) i3) / this.f2646g;
            float min = Math.min(f2, f3);
            Matrix matrix = cVar.f2633a;
            this.o.set(matrix);
            this.o.postScale(f2, f3);
            float a2 = a(matrix);
            if (a2 != BitmapDescriptorFactory.HUE_RED) {
                eVar.a(this.l);
                Path path = this.l;
                this.m.reset();
                if (eVar.a()) {
                    this.m.setFillType(eVar.n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.m.addPath(path, this.o);
                    canvas.clipPath(this.m);
                    return;
                }
                b bVar = (b) eVar;
                if (!(bVar.f2631f == BitmapDescriptorFactory.HUE_RED && bVar.f2632g == 1.0f)) {
                    float f4 = (bVar.f2631f + bVar.h) % 1.0f;
                    float f5 = (bVar.f2632g + bVar.h) % 1.0f;
                    if (this.p == null) {
                        this.p = new PathMeasure();
                    }
                    this.p.setPath(this.l, false);
                    float length = this.p.getLength();
                    float f6 = f4 * length;
                    float f7 = f5 * length;
                    path.reset();
                    if (f6 > f7) {
                        this.p.getSegment(f6, length, path, true);
                        this.p.getSegment(BitmapDescriptorFactory.HUE_RED, f7, path, true);
                    } else {
                        this.p.getSegment(f6, f7, path, true);
                    }
                    path.rLineTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                }
                this.m.addPath(path, this.o);
                if (bVar.f2628c.e()) {
                    androidx.core.content.a.b bVar2 = bVar.f2628c;
                    if (this.f2641b == null) {
                        this.f2641b = new Paint(1);
                        this.f2641b.setStyle(Paint.Style.FILL);
                    }
                    Paint paint = this.f2641b;
                    if (bVar2.c()) {
                        Shader a3 = bVar2.a();
                        a3.setLocalMatrix(this.o);
                        paint.setShader(a3);
                        paint.setAlpha(Math.round(bVar.f2630e * 255.0f));
                    } else {
                        paint.setShader((Shader) null);
                        paint.setAlpha(255);
                        paint.setColor(i.a(bVar2.b(), bVar.f2630e));
                    }
                    paint.setColorFilter(colorFilter);
                    this.m.setFillType(bVar.n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.m, paint);
                }
                if (bVar.f2626a.e()) {
                    androidx.core.content.a.b bVar3 = bVar.f2626a;
                    if (this.f2640a == null) {
                        this.f2640a = new Paint(1);
                        this.f2640a.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint2 = this.f2640a;
                    if (bVar.j != null) {
                        paint2.setStrokeJoin(bVar.j);
                    }
                    if (bVar.i != null) {
                        paint2.setStrokeCap(bVar.i);
                    }
                    paint2.setStrokeMiter(bVar.k);
                    if (bVar3.c()) {
                        Shader a4 = bVar3.a();
                        a4.setLocalMatrix(this.o);
                        paint2.setShader(a4);
                        paint2.setAlpha(Math.round(bVar.f2629d * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(i.a(bVar3.b(), bVar.f2629d));
                    }
                    paint2.setColorFilter(colorFilter);
                    paint2.setStrokeWidth(bVar.f2627b * min * a2);
                    canvas.drawPath(this.m, paint2);
                }
            }
        }

        private float a(Matrix matrix) {
            float[] fArr = {BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > BitmapDescriptorFactory.HUE_RED) {
                return Math.abs(a2) / max;
            }
            return BitmapDescriptorFactory.HUE_RED;
        }

        public boolean a() {
            if (this.j == null) {
                this.j = Boolean.valueOf(this.f2642c.b());
            }
            return this.j.booleanValue();
        }

        public boolean a(int[] iArr) {
            return this.f2642c.a(iArr);
        }
    }

    private static abstract class d {
        public boolean a(int[] iArr) {
            return false;
        }

        public boolean b() {
            return false;
        }

        private d() {
        }
    }

    private static class c extends d {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f2633a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<d> f2634b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        float f2635c = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: d  reason: collision with root package name */
        final Matrix f2636d = new Matrix();

        /* renamed from: e  reason: collision with root package name */
        int f2637e;

        /* renamed from: f  reason: collision with root package name */
        private float f2638f = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: g  reason: collision with root package name */
        private float f2639g = BitmapDescriptorFactory.HUE_RED;
        private float h = 1.0f;
        private float i = 1.0f;
        private float j = BitmapDescriptorFactory.HUE_RED;
        private float k = BitmapDescriptorFactory.HUE_RED;
        private int[] l;
        private String m = null;

        public c(c cVar, androidx.b.a<String, Object> aVar) {
            super();
            e eVar;
            this.f2635c = cVar.f2635c;
            this.f2638f = cVar.f2638f;
            this.f2639g = cVar.f2639g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.f2637e = cVar.f2637e;
            String str = this.m;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f2636d.set(cVar.f2636d);
            ArrayList<d> arrayList = cVar.f2634b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d dVar = arrayList.get(i2);
                if (dVar instanceof c) {
                    this.f2634b.add(new c((c) dVar, aVar));
                } else {
                    if (dVar instanceof b) {
                        eVar = new b((b) dVar);
                    } else if (dVar instanceof a) {
                        eVar = new a((a) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f2634b.add(eVar);
                    if (eVar.m != null) {
                        aVar.put(eVar.m, eVar);
                    }
                }
            }
        }

        public c() {
            super();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.f2636d;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = androidx.core.content.a.g.a(resources, theme, attributeSet, a.f2596b);
            a(a2, xmlPullParser);
            a2.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f2635c = androidx.core.content.a.g.a(typedArray, xmlPullParser, "rotation", 5, this.f2635c);
            this.f2638f = typedArray.getFloat(1, this.f2638f);
            this.f2639g = typedArray.getFloat(2, this.f2639g);
            this.h = androidx.core.content.a.g.a(typedArray, xmlPullParser, "scaleX", 3, this.h);
            this.i = androidx.core.content.a.g.a(typedArray, xmlPullParser, "scaleY", 4, this.i);
            this.j = androidx.core.content.a.g.a(typedArray, xmlPullParser, "translateX", 6, this.j);
            this.k = androidx.core.content.a.g.a(typedArray, xmlPullParser, "translateY", 7, this.k);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            a();
        }

        private void a() {
            this.f2636d.reset();
            this.f2636d.postTranslate(-this.f2638f, -this.f2639g);
            this.f2636d.postScale(this.h, this.i);
            this.f2636d.postRotate(this.f2635c, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            this.f2636d.postTranslate(this.j + this.f2638f, this.k + this.f2639g);
        }

        public float getRotation() {
            return this.f2635c;
        }

        public void setRotation(float f2) {
            if (f2 != this.f2635c) {
                this.f2635c = f2;
                a();
            }
        }

        public float getPivotX() {
            return this.f2638f;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f2638f) {
                this.f2638f = f2;
                a();
            }
        }

        public float getPivotY() {
            return this.f2639g;
        }

        public void setPivotY(float f2) {
            if (f2 != this.f2639g) {
                this.f2639g = f2;
                a();
            }
        }

        public float getScaleX() {
            return this.h;
        }

        public void setScaleX(float f2) {
            if (f2 != this.h) {
                this.h = f2;
                a();
            }
        }

        public float getScaleY() {
            return this.i;
        }

        public void setScaleY(float f2) {
            if (f2 != this.i) {
                this.i = f2;
                a();
            }
        }

        public float getTranslateX() {
            return this.j;
        }

        public void setTranslateX(float f2) {
            if (f2 != this.j) {
                this.j = f2;
                a();
            }
        }

        public float getTranslateY() {
            return this.k;
        }

        public void setTranslateY(float f2) {
            if (f2 != this.k) {
                this.k = f2;
                a();
            }
        }

        public boolean b() {
            for (int i2 = 0; i2 < this.f2634b.size(); i2++) {
                if (this.f2634b.get(i2).b()) {
                    return true;
                }
            }
            return false;
        }

        public boolean a(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f2634b.size(); i2++) {
                z |= this.f2634b.get(i2).a(iArr);
            }
            return z;
        }
    }

    private static abstract class e extends d {
        protected c.b[] l = null;
        String m;
        int n = 0;
        int o;

        public boolean a() {
            return false;
        }

        public e() {
            super();
        }

        public e(e eVar) {
            super();
            this.m = eVar.m;
            this.o = eVar.o;
            this.l = androidx.core.graphics.c.a(eVar.l);
        }

        public void a(Path path) {
            path.reset();
            c.b[] bVarArr = this.l;
            if (bVarArr != null) {
                c.b.a(bVarArr, path);
            }
        }

        public String getPathName() {
            return this.m;
        }

        public c.b[] getPathData() {
            return this.l;
        }

        public void setPathData(c.b[] bVarArr) {
            if (!androidx.core.graphics.c.a(this.l, bVarArr)) {
                this.l = androidx.core.graphics.c.a(bVarArr);
            } else {
                androidx.core.graphics.c.b(this.l, bVarArr);
            }
        }
    }

    private static class a extends e {
        public boolean a() {
            return true;
        }

        a() {
        }

        a(a aVar) {
            super(aVar);
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (androidx.core.content.a.g.a(xmlPullParser, "pathData")) {
                TypedArray a2 = androidx.core.content.a.g.a(resources, theme, attributeSet, a.f2598d);
                a(a2, xmlPullParser);
                a2.recycle();
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.l = androidx.core.graphics.c.b(string2);
            }
            this.n = androidx.core.content.a.g.a(typedArray, xmlPullParser, "fillType", 2, 0);
        }
    }

    private static class b extends e {

        /* renamed from: a  reason: collision with root package name */
        androidx.core.content.a.b f2626a;

        /* renamed from: b  reason: collision with root package name */
        float f2627b = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: c  reason: collision with root package name */
        androidx.core.content.a.b f2628c;

        /* renamed from: d  reason: collision with root package name */
        float f2629d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        float f2630e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        float f2631f = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: g  reason: collision with root package name */
        float f2632g = 1.0f;
        float h = BitmapDescriptorFactory.HUE_RED;
        Paint.Cap i = Paint.Cap.BUTT;
        Paint.Join j = Paint.Join.MITER;
        float k = 4.0f;
        private int[] p;

        b() {
        }

        b(b bVar) {
            super(bVar);
            this.p = bVar.p;
            this.f2626a = bVar.f2626a;
            this.f2627b = bVar.f2627b;
            this.f2629d = bVar.f2629d;
            this.f2628c = bVar.f2628c;
            this.n = bVar.n;
            this.f2630e = bVar.f2630e;
            this.f2631f = bVar.f2631f;
            this.f2632g = bVar.f2632g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
        }

        private Paint.Cap a(int i2, Paint.Cap cap) {
            if (i2 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i2 != 1) {
                return i2 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        private Paint.Join a(int i2, Paint.Join join) {
            if (i2 == 0) {
                return Paint.Join.MITER;
            }
            if (i2 != 1) {
                return i2 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = androidx.core.content.a.g.a(resources, theme, attributeSet, a.f2597c);
            a(a2, xmlPullParser, theme);
            a2.recycle();
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.p = null;
            if (androidx.core.content.a.g.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.m = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.l = androidx.core.graphics.c.b(string2);
                }
                Resources.Theme theme2 = theme;
                this.f2628c = androidx.core.content.a.g.a(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f2630e = androidx.core.content.a.g.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f2630e);
                this.i = a(androidx.core.content.a.g.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.i);
                this.j = a(androidx.core.content.a.g.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.j);
                this.k = androidx.core.content.a.g.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.k);
                this.f2626a = androidx.core.content.a.g.a(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f2629d = androidx.core.content.a.g.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f2629d);
                this.f2627b = androidx.core.content.a.g.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f2627b);
                this.f2632g = androidx.core.content.a.g.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f2632g);
                this.h = androidx.core.content.a.g.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.h);
                this.f2631f = androidx.core.content.a.g.a(typedArray, xmlPullParser, "trimPathStart", 5, this.f2631f);
                this.n = androidx.core.content.a.g.a(typedArray, xmlPullParser, "fillType", 13, this.n);
            }
        }

        public boolean b() {
            return this.f2628c.d() || this.f2626a.d();
        }

        public boolean a(int[] iArr) {
            return this.f2626a.a(iArr) | this.f2628c.a(iArr);
        }

        /* access modifiers changed from: package-private */
        public int getStrokeColor() {
            return this.f2626a.b();
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i2) {
            this.f2626a.b(i2);
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f2627b;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f2) {
            this.f2627b = f2;
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.f2629d;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f2) {
            this.f2629d = f2;
        }

        /* access modifiers changed from: package-private */
        public int getFillColor() {
            return this.f2628c.b();
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i2) {
            this.f2628c.b(i2);
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.f2630e;
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f2) {
            this.f2630e = f2;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.f2631f;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f2) {
            this.f2631f = f2;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.f2632g;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f2) {
            this.f2632g = f2;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.h;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f2) {
            this.h = f2;
        }
    }
}
