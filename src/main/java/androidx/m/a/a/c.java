package androidx.m.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.a.g;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c extends h implements b {

    /* renamed from: a  reason: collision with root package name */
    b f2602a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<Object> f2603b;

    /* renamed from: c  reason: collision with root package name */
    final Drawable.Callback f2604c;

    /* renamed from: e  reason: collision with root package name */
    private a f2605e;

    /* renamed from: f  reason: collision with root package name */
    private Context f2606f;

    /* renamed from: g  reason: collision with root package name */
    private ArgbEvaluator f2607g;
    private Animator.AnimatorListener h;

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

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    c() {
        this((Context) null, (a) null, (Resources) null);
    }

    private c(Context context) {
        this(context, (a) null, (Resources) null);
    }

    private c(Context context, a aVar, Resources resources) {
        this.f2607g = null;
        this.h = null;
        this.f2603b = null;
        this.f2604c = new Drawable.Callback() {
            public void invalidateDrawable(Drawable drawable) {
                c.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                c.this.scheduleSelf(runnable, j);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                c.this.unscheduleSelf(runnable);
            }
        };
        this.f2606f = context;
        if (aVar != null) {
            this.f2605e = aVar;
        } else {
            this.f2605e = new a(context, aVar, this.f2604c, resources);
        }
    }

    public Drawable mutate() {
        if (this.f2619d != null) {
            this.f2619d.mutate();
        }
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004b A[Catch:{ XmlPullParserException -> 0x0065, IOException -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058 A[Catch:{ XmlPullParserException -> 0x0065, IOException -> 0x0060 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.m.a.a.c a(android.content.Context r6, int r7) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "AnimatedVDCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0032
            androidx.m.a.a.c r0 = new androidx.m.a.a.c
            r0.<init>(r6)
            android.content.res.Resources r1 = r6.getResources()
            android.content.res.Resources$Theme r6 = r6.getTheme()
            android.graphics.drawable.Drawable r6 = androidx.core.content.a.f.a(r1, r7, r6)
            r0.f2619d = r6
            android.graphics.drawable.Drawable r6 = r0.f2619d
            android.graphics.drawable.Drawable$Callback r7 = r0.f2604c
            r6.setCallback(r7)
            androidx.m.a.a.c$b r6 = new androidx.m.a.a.c$b
            android.graphics.drawable.Drawable r7 = r0.f2619d
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.f2602a = r6
            return r0
        L_0x0032:
            android.content.res.Resources r2 = r6.getResources()
            android.content.res.XmlResourceParser r7 = r2.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0065, IOException -> 0x0060 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0065, IOException -> 0x0060 }
        L_0x003e:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0065, IOException -> 0x0060 }
            r4 = 2
            if (r3 == r4) goto L_0x0049
            r5 = 1
            if (r3 == r5) goto L_0x0049
            goto L_0x003e
        L_0x0049:
            if (r3 != r4) goto L_0x0058
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ XmlPullParserException -> 0x0065, IOException -> 0x0060 }
            android.content.res.Resources$Theme r4 = r6.getTheme()     // Catch:{ XmlPullParserException -> 0x0065, IOException -> 0x0060 }
            androidx.m.a.a.c r6 = a(r6, r3, r7, r2, r4)     // Catch:{ XmlPullParserException -> 0x0065, IOException -> 0x0060 }
            return r6
        L_0x0058:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0065, IOException -> 0x0060 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0065, IOException -> 0x0060 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0065, IOException -> 0x0060 }
        L_0x0060:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x0069
        L_0x0065:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x0069:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.m.a.a.c.a(android.content.Context, int):androidx.m.a.a.c");
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f2619d == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(this.f2619d.getConstantState());
    }

    public int getChangingConfigurations() {
        if (this.f2619d != null) {
            return this.f2619d.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f2605e.f2609a;
    }

    public void draw(Canvas canvas) {
        if (this.f2619d != null) {
            this.f2619d.draw(canvas);
            return;
        }
        this.f2605e.f2610b.draw(canvas);
        if (this.f2605e.f2611c.isStarted()) {
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f2619d != null) {
            this.f2619d.setBounds(rect);
        } else {
            this.f2605e.f2610b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.f2619d != null) {
            return this.f2619d.setState(iArr);
        }
        return this.f2605e.f2610b.setState(iArr);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        if (this.f2619d != null) {
            return this.f2619d.setLevel(i);
        }
        return this.f2605e.f2610b.setLevel(i);
    }

    public int getAlpha() {
        if (this.f2619d != null) {
            return androidx.core.graphics.drawable.a.c(this.f2619d);
        }
        return this.f2605e.f2610b.getAlpha();
    }

    public void setAlpha(int i) {
        if (this.f2619d != null) {
            this.f2619d.setAlpha(i);
        } else {
            this.f2605e.f2610b.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f2619d != null) {
            this.f2619d.setColorFilter(colorFilter);
        } else {
            this.f2605e.f2610b.setColorFilter(colorFilter);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.f2619d != null) {
            return androidx.core.graphics.drawable.a.e(this.f2619d);
        }
        return this.f2605e.f2610b.getColorFilter();
    }

    public void setTint(int i) {
        if (this.f2619d != null) {
            androidx.core.graphics.drawable.a.a(this.f2619d, i);
        } else {
            this.f2605e.f2610b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.f2619d != null) {
            androidx.core.graphics.drawable.a.a(this.f2619d, colorStateList);
        } else {
            this.f2605e.f2610b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f2619d != null) {
            androidx.core.graphics.drawable.a.a(this.f2619d, mode);
        } else {
            this.f2605e.f2610b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.f2619d != null) {
            return this.f2619d.setVisible(z, z2);
        }
        this.f2605e.f2610b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public boolean isStateful() {
        if (this.f2619d != null) {
            return this.f2619d.isStateful();
        }
        return this.f2605e.f2610b.isStateful();
    }

    public int getOpacity() {
        if (this.f2619d != null) {
            return this.f2619d.getOpacity();
        }
        return this.f2605e.f2610b.getOpacity();
    }

    public int getIntrinsicWidth() {
        if (this.f2619d != null) {
            return this.f2619d.getIntrinsicWidth();
        }
        return this.f2605e.f2610b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.f2619d != null) {
            return this.f2619d.getIntrinsicHeight();
        }
        return this.f2605e.f2610b.getIntrinsicHeight();
    }

    public boolean isAutoMirrored() {
        if (this.f2619d != null) {
            return androidx.core.graphics.drawable.a.b(this.f2619d);
        }
        return this.f2605e.f2610b.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        if (this.f2619d != null) {
            androidx.core.graphics.drawable.a.a(this.f2619d, z);
        } else {
            this.f2605e.f2610b.setAutoMirrored(z);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.f2619d != null) {
            androidx.core.graphics.drawable.a.a(this.f2619d, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray a2 = g.a(resources, theme, attributeSet, a.f2599e);
                    int resourceId = a2.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i a3 = i.a(resources, resourceId, theme);
                        a3.a(false);
                        a3.setCallback(this.f2604c);
                        if (this.f2605e.f2610b != null) {
                            this.f2605e.f2610b.setCallback((Drawable.Callback) null);
                        }
                        this.f2605e.f2610b = a3;
                    }
                    a2.recycle();
                } else if (TouchesHelper.TARGET_KEY.equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f2600f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f2606f;
                        if (context != null) {
                            a(string, e.a(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f2605e.a();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.f2619d != null) {
            androidx.core.graphics.drawable.a.a(this.f2619d, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.f2619d != null) {
            return androidx.core.graphics.drawable.a.d(this.f2619d);
        }
        return false;
    }

    private static class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f2614a;

        public b(Drawable.ConstantState constantState) {
            this.f2614a = constantState;
        }

        public Drawable newDrawable() {
            c cVar = new c();
            cVar.f2619d = this.f2614a.newDrawable();
            cVar.f2619d.setCallback(cVar.f2604c);
            return cVar;
        }

        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            cVar.f2619d = this.f2614a.newDrawable(resources);
            cVar.f2619d.setCallback(cVar.f2604c);
            return cVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            cVar.f2619d = this.f2614a.newDrawable(resources, theme);
            cVar.f2619d.setCallback(cVar.f2604c);
            return cVar;
        }

        public boolean canApplyTheme() {
            return this.f2614a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f2614a.getChangingConfigurations();
        }
    }

    private static class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f2609a;

        /* renamed from: b  reason: collision with root package name */
        i f2610b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f2611c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f2612d;

        /* renamed from: e  reason: collision with root package name */
        androidx.b.a<Animator, String> f2613e;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f2609a = aVar.f2609a;
                i iVar = aVar.f2610b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    if (resources != null) {
                        this.f2610b = (i) constantState.newDrawable(resources);
                    } else {
                        this.f2610b = (i) constantState.newDrawable();
                    }
                    this.f2610b = (i) this.f2610b.mutate();
                    this.f2610b.setCallback(callback);
                    this.f2610b.setBounds(aVar.f2610b.getBounds());
                    this.f2610b.a(false);
                }
                ArrayList<Animator> arrayList = aVar.f2612d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f2612d = new ArrayList<>(size);
                    this.f2613e = new androidx.b.a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.f2612d.get(i);
                        Animator clone = animator.clone();
                        String str = aVar.f2613e.get(animator);
                        clone.setTarget(this.f2610b.a(str));
                        this.f2612d.add(clone);
                        this.f2613e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public int getChangingConfigurations() {
            return this.f2609a;
        }

        public void a() {
            if (this.f2611c == null) {
                this.f2611c = new AnimatorSet();
            }
            this.f2611c.playTogether(this.f2612d);
        }
    }

    private void a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    a(childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f2607g == null) {
                    this.f2607g = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f2607g);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.f2605e.f2610b.a(str));
        if (Build.VERSION.SDK_INT < 21) {
            a(animator);
        }
        if (this.f2605e.f2612d == null) {
            this.f2605e.f2612d = new ArrayList<>();
            this.f2605e.f2613e = new androidx.b.a<>();
        }
        this.f2605e.f2612d.add(animator);
        this.f2605e.f2613e.put(animator, str);
    }

    public boolean isRunning() {
        if (this.f2619d != null) {
            return ((AnimatedVectorDrawable) this.f2619d).isRunning();
        }
        return this.f2605e.f2611c.isRunning();
    }

    public void start() {
        if (this.f2619d != null) {
            ((AnimatedVectorDrawable) this.f2619d).start();
        } else if (!this.f2605e.f2611c.isStarted()) {
            this.f2605e.f2611c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.f2619d != null) {
            ((AnimatedVectorDrawable) this.f2619d).stop();
        } else {
            this.f2605e.f2611c.end();
        }
    }
}
