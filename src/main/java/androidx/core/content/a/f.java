package androidx.core.content.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;

public final class f {
    public static Drawable a(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, theme);
        }
        return resources.getDrawable(i);
    }

    public static Typeface a(Context context, int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, new TypedValue(), 0, (a) null, (Handler) null, false);
    }

    public static abstract class a {
        public abstract void a(int i);

        public abstract void a(Typeface typeface);

        public final void a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    a.this.a(typeface);
                }
            });
        }

        public final void a(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    a.this.a(i);
                }
            });
        }
    }

    public static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i, typedValue, i2, aVar, (Handler) null, true);
    }

    private static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a2 = a(context, resources, typedValue, i, i2, aVar, handler, z);
        if (a2 != null || aVar != null) {
            return a2;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface a(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, androidx.core.content.a.f.a r20, android.os.Handler r21, boolean r22) {
        /*
            r0 = r16
            r1 = r17
            r4 = r18
            r5 = r19
            r9 = r20
            r10 = r21
            java.lang.String r11 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L_0x00a9
            java.lang.CharSequence r1 = r1.string
            java.lang.String r12 = r1.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = 0
            r14 = -3
            if (r1 != 0) goto L_0x0028
            if (r9 == 0) goto L_0x0027
            r9.a((int) r14, (android.os.Handler) r10)
        L_0x0027:
            return r13
        L_0x0028:
            android.graphics.Typeface r1 = androidx.core.graphics.d.a((android.content.res.Resources) r0, (int) r4, (int) r5)
            if (r1 == 0) goto L_0x0034
            if (r9 == 0) goto L_0x0033
            r9.a((android.graphics.Typeface) r1, (android.os.Handler) r10)
        L_0x0033:
            return r1
        L_0x0034:
            java.lang.String r1 = r12.toLowerCase()     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0078 }
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0078 }
            if (r1 == 0) goto L_0x0067
            android.content.res.XmlResourceParser r1 = r0.getXml(r4)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0078 }
            androidx.core.content.a.c$a r2 = androidx.core.content.a.c.a((org.xmlpull.v1.XmlPullParser) r1, (android.content.res.Resources) r0)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0078 }
            if (r2 != 0) goto L_0x0055
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r11, r0)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0078 }
            if (r9 == 0) goto L_0x0054
            r9.a((int) r14, (android.os.Handler) r10)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0078 }
        L_0x0054:
            return r13
        L_0x0055:
            r1 = r15
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r0 = androidx.core.graphics.d.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0078 }
            return r0
        L_0x0067:
            r1 = r15
            android.graphics.Typeface r0 = androidx.core.graphics.d.a(r15, r0, r4, r12, r5)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0078 }
            if (r9 == 0) goto L_0x0077
            if (r0 == 0) goto L_0x0074
            r9.a((android.graphics.Typeface) r0, (android.os.Handler) r10)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0078 }
            goto L_0x0077
        L_0x0074:
            r9.a((int) r14, (android.os.Handler) r10)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0078 }
        L_0x0077:
            return r0
        L_0x0078:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
            goto L_0x00a3
        L_0x008e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
        L_0x00a3:
            if (r9 == 0) goto L_0x00a8
            r9.a((int) r14, (android.os.Handler) r10)
        L_0x00a8:
            return r13
        L_0x00a9:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r18)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.a.f.a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.a.f$a, android.os.Handler, boolean):android.graphics.Typeface");
    }
}
