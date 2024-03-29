package androidx.appcompat.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.b.a.b;
import androidx.appcompat.c.a;
import androidx.appcompat.widget.ah;
import androidx.core.content.a.g;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
class e extends b {

    /* renamed from: a  reason: collision with root package name */
    private a f734a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f735b;

    public boolean isStateful() {
        return true;
    }

    e() {
        this((a) null, (Resources) null);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int b2 = this.f734a.b(iArr);
        if (b2 < 0) {
            b2 = this.f734a.b(StateSet.WILD_CARD);
        }
        return a(b2) || onStateChange;
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a2 = g.a(resources, theme, attributeSet, a.b.StateListDrawable);
        setVisible(a2.getBoolean(a.b.StateListDrawable_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    private void a(TypedArray typedArray) {
        a aVar = this.f734a;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.f724f |= typedArray.getChangingConfigurations();
        }
        aVar.k = typedArray.getBoolean(a.b.StateListDrawable_android_variablePadding, aVar.k);
        aVar.n = typedArray.getBoolean(a.b.StateListDrawable_android_constantSize, aVar.n);
        aVar.C = typedArray.getInt(a.b.StateListDrawable_android_enterFadeDuration, aVar.C);
        aVar.D = typedArray.getInt(a.b.StateListDrawable_android_exitFadeDuration, aVar.D);
        aVar.z = typedArray.getBoolean(a.b.StateListDrawable_android_dither, aVar.z);
    }

    private void a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        a aVar = this.f734a;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next2 == 3) {
                    return;
                }
                if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                    TypedArray a2 = g.a(resources, theme, attributeSet, a.b.StateListDrawableItem);
                    Drawable drawable = null;
                    int resourceId = a2.getResourceId(a.b.StateListDrawableItem_android_drawable, -1);
                    if (resourceId > 0) {
                        drawable = ah.a().a(context, resourceId);
                    }
                    a2.recycle();
                    int[] a3 = a(attributeSet);
                    if (drawable == null) {
                        do {
                            next = xmlPullParser.next();
                        } while (next == 4);
                        if (next != 2) {
                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        } else if (Build.VERSION.SDK_INT >= 21) {
                            drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                        } else {
                            drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                        }
                    }
                    aVar.a(a3, drawable);
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int[] a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    public Drawable mutate() {
        if (!this.f735b && super.mutate() == this) {
            this.f734a.a();
            this.f735b = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public a c() {
        return new a(this.f734a, this, (Resources) null);
    }

    static class a extends b.C0017b {
        int[][] L;

        a(a aVar, e eVar, Resources resources) {
            super(aVar, eVar, resources);
            if (aVar != null) {
                this.L = aVar.L;
            } else {
                this.L = new int[c()][];
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[][] iArr = this.L;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.L;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.L = iArr2;
        }

        /* access modifiers changed from: package-private */
        public int a(int[] iArr, Drawable drawable) {
            int a2 = a(drawable);
            this.L[a2] = iArr;
            return a2;
        }

        /* access modifiers changed from: package-private */
        public int b(int[] iArr) {
            int[][] iArr2 = this.L;
            int d2 = d();
            for (int i = 0; i < d2; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        public Drawable newDrawable() {
            return new e(this, (Resources) null);
        }

        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }

        public void e(int i, int i2) {
            super.e(i, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.L, 0, iArr, 0, i);
            this.L = iArr;
        }
    }

    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* access modifiers changed from: package-private */
    public void a(b.C0017b bVar) {
        super.a(bVar);
        if (bVar instanceof a) {
            this.f734a = (a) bVar;
        }
    }

    e(a aVar, Resources resources) {
        a((b.C0017b) new a(aVar, this, resources));
        onStateChange(getState());
    }

    e(a aVar) {
        if (aVar != null) {
            a((b.C0017b) aVar);
        }
    }
}
