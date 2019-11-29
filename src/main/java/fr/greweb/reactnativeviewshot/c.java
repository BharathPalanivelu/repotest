package fr.greweb.reactnativeviewshot;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.zip.Deflater;
import org.json.JSONArray;

public class c implements UIBlock {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33030a = "c";

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f33031b = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
    private static final Object o = new Object();
    private static final Set<Bitmap> p = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: c  reason: collision with root package name */
    private final int f33032c;

    /* renamed from: d  reason: collision with root package name */
    private final String f33033d;
    @a

    /* renamed from: e  reason: collision with root package name */
    private final int f33034e;

    /* renamed from: f  reason: collision with root package name */
    private final double f33035f;

    /* renamed from: g  reason: collision with root package name */
    private final Integer f33036g;
    private final Integer h;
    private final File i;
    private final String j;
    private final Promise k;
    private final Boolean l;
    private final ReactApplicationContext m;
    private final Activity n;
    private ArrayList<String> q = new ArrayList<>();

    public @interface a {

        /* renamed from: a  reason: collision with root package name */
        public static final Bitmap.CompressFormat[] f7167a = {Bitmap.CompressFormat.JPEG, Bitmap.CompressFormat.PNG, Bitmap.CompressFormat.WEBP};
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [A, T] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T extends A, A> T a(A r0) {
        /*
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.greweb.reactnativeviewshot.c.a(java.lang.Object):java.lang.Object");
    }

    public c(int i2, String str, @a int i3, double d2, Integer num, Integer num2, File file, String str2, Boolean bool, ReactApplicationContext reactApplicationContext, Activity activity, Promise promise) {
        this.f33032c = i2;
        this.f33033d = str;
        this.f33034e = i3;
        this.f33035f = d2;
        this.f33036g = num;
        this.h = num2;
        this.i = file;
        this.j = str2;
        this.l = bool;
        this.m = reactApplicationContext;
        this.n = activity;
        this.k = promise;
    }

    public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
        View view;
        int i2 = this.f33032c;
        if (i2 == -1) {
            view = this.n.getWindow().getDecorView().findViewById(16908290);
        } else {
            view = nativeViewHierarchyManager.resolveView(i2);
        }
        if (view == null) {
            String str = f33030a;
            Log.e(str, "No view found with reactTag: " + this.f33032c, new AssertionError());
            Promise promise = this.k;
            promise.reject("E_UNABLE_TO_SNAPSHOT", "No view found with reactTag: " + this.f33032c);
            return;
        }
        try {
            b bVar = new b(f33031b);
            bVar.b(f(view));
            f33031b = bVar.a();
            if ("tmpfile".equals(this.j) && -1 == this.f33034e) {
                b(view);
            } else if (!"tmpfile".equals(this.j) || -1 == this.f33034e) {
                if (!"base64".equals(this.j)) {
                    if (!"zip-base64".equals(this.j)) {
                        if ("data-uri".equals(this.j)) {
                            c(view);
                            return;
                        }
                        return;
                    }
                }
                d(view);
            } else {
                a(view);
            }
        } catch (Throwable th) {
            Log.e(f33030a, "Failed to capture view snapshot", th);
            this.k.reject("E_UNABLE_TO_SNAPSHOT", "Failed to capture view snapshot");
        }
    }

    private void a(View view) throws IOException {
        a(view, (OutputStream) new FileOutputStream(this.i));
        this.k.resolve(a(Uri.fromFile(this.i).toString()));
    }

    private void b(View view) throws IOException {
        String uri = Uri.fromFile(this.i).toString();
        FileOutputStream fileOutputStream = new FileOutputStream(this.i);
        b bVar = new b(f33031b);
        Point a2 = a(view, (OutputStream) bVar);
        f33031b = bVar.a();
        int size = bVar.size();
        fileOutputStream.write(String.format(Locale.US, "%d:%d|", new Object[]{Integer.valueOf(a2.x), Integer.valueOf(a2.y)}).getBytes(Charset.forName("US-ASCII")));
        fileOutputStream.write(f33031b, 0, size);
        fileOutputStream.close();
        this.k.resolve(a(uri));
    }

    private void c(View view) throws IOException {
        b bVar = new b(f33031b);
        a(view, (OutputStream) bVar);
        f33031b = bVar.a();
        String encodeToString = Base64.encodeToString(f33031b, 0, bVar.size(), 2);
        String str = "jpg".equals(this.f33033d) ? "jpeg" : this.f33033d;
        Promise promise = this.k;
        promise.resolve(a("data:image/" + str + ";base64," + encodeToString));
    }

    private void d(View view) throws IOException {
        String str;
        boolean z = -1 == this.f33034e;
        boolean equals = "zip-base64".equals(this.j);
        b bVar = new b(f33031b);
        Point a2 = a(view, (OutputStream) bVar);
        f33031b = bVar.a();
        int size = bVar.size();
        String format = String.format(Locale.US, "%d:%d|", new Object[]{Integer.valueOf(a2.x), Integer.valueOf(a2.y)});
        if (!z) {
            format = "";
        }
        if (equals) {
            Deflater deflater = new Deflater();
            deflater.setInput(f33031b, 0, size);
            deflater.finish();
            b bVar2 = new b(new byte[32]);
            byte[] bArr = new byte[1024];
            while (!deflater.finished()) {
                bVar2.write(bArr, 0, deflater.deflate(bArr));
            }
            str = format + Base64.encodeToString(bVar2.a(), 0, bVar2.size(), 2);
        } else {
            str = format + Base64.encodeToString(f33031b, 0, size, 2);
        }
        this.k.resolve(a(str));
    }

    private List<View> e(View view) {
        if (!(view instanceof ViewGroup)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(view);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            arrayList2.addAll(e(viewGroup.getChildAt(i2)));
        }
        return arrayList2;
    }

    private Point a(View view, OutputStream outputStream) throws IOException {
        try {
            a.a(f33030a, a.a(this.n));
            return b(view, outputStream);
        } finally {
            outputStream.close();
        }
    }

    private Point b(View view, OutputStream outputStream) {
        Bitmap bitmap;
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            throw new RuntimeException("Impossible to snapshot the view: view is invalid");
        }
        if (this.l.booleanValue()) {
            ScrollView scrollView = (ScrollView) view;
            int i2 = 0;
            for (int i3 = 0; i3 < scrollView.getChildCount(); i3++) {
                i2 += scrollView.getChildAt(i3).getHeight();
            }
            height = i2;
        }
        Point point = new Point(width, height);
        Bitmap a2 = a(width, height);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        Canvas canvas = new Canvas(a2);
        view.draw(canvas);
        for (View next : e(view)) {
            if ((next instanceof TextureView) && next.getVisibility() == 0) {
                TextureView textureView = (TextureView) next;
                textureView.setOpaque(false);
                Bitmap bitmap2 = textureView.getBitmap(b(next.getWidth(), next.getHeight()));
                int save = canvas.save();
                a(canvas, view, next);
                canvas.drawBitmap(bitmap2, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint);
                canvas.restoreToCount(save);
                a(bitmap2);
            }
        }
        Integer num = this.f33036g;
        if (num == null || this.h == null || (num.intValue() == width && this.h.intValue() == height)) {
            bitmap = a2;
        } else {
            bitmap = Bitmap.createScaledBitmap(a2, this.f33036g.intValue(), this.h.intValue(), true);
            a(a2);
        }
        if (-1 != this.f33034e || !(outputStream instanceof b)) {
            bitmap.compress(a.f7167a[this.f33034e], (int) (this.f33035f * 100.0d), outputStream);
        } else {
            int i4 = width * height * 4;
            b bVar = (b) a(outputStream);
            bitmap.copyPixelsToBuffer(bVar.a(i4));
            bVar.b(i4);
        }
        a(bitmap);
        return point;
    }

    private Matrix a(Canvas canvas, View view, View view2) {
        Matrix matrix = new Matrix();
        LinkedList linkedList = new LinkedList();
        View view3 = view2;
        do {
            linkedList.add(view3);
            view3 = (View) view3.getParent();
        } while (view3 != view);
        Collections.reverse(linkedList);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            View view4 = (View) it.next();
            canvas.save();
            int i2 = 0;
            float left = ((float) (view4.getLeft() + (view4 != view2 ? view4.getPaddingLeft() : 0))) + view4.getTranslationX();
            int top = view4.getTop();
            if (view4 != view2) {
                i2 = view4.getPaddingTop();
            }
            float translationY = ((float) (top + i2)) + view4.getTranslationY();
            canvas.translate(left, translationY);
            canvas.rotate(view4.getRotation(), view4.getPivotX(), view4.getPivotY());
            canvas.scale(view4.getScaleX(), view4.getScaleY());
            matrix.postTranslate(left, translationY);
            matrix.postRotate(view4.getRotation(), view4.getPivotX(), view4.getPivotY());
            matrix.postScale(view4.getScaleX(), view4.getScaleY());
        }
        return matrix;
    }

    private static int f(View view) {
        return Math.min(view.getWidth() * view.getHeight() * 4, 32);
    }

    private static void a(Bitmap bitmap) {
        synchronized (o) {
            p.add(bitmap);
        }
    }

    private static Bitmap a(int i2, int i3) {
        synchronized (o) {
            for (Bitmap next : p) {
                if (next.getWidth() == i2 && next.getHeight() == i3) {
                    p.remove(next);
                    next.eraseColor(0);
                    return next;
                }
            }
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
    }

    private static Bitmap b(int i2, int i3) {
        synchronized (o) {
            for (Bitmap next : p) {
                if (next.getWidth() == i2 && next.getHeight() == i3) {
                    p.remove(next);
                    next.eraseColor(0);
                    return next;
                }
            }
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
    }

    public static class b extends ByteArrayOutputStream {
        public b(byte[] bArr) {
            super(0);
            this.buf = bArr;
        }

        public byte[] a() {
            return this.buf;
        }

        public ByteBuffer a(int i) {
            if (this.buf.length < i) {
                c(i);
            }
            return ByteBuffer.wrap(this.buf);
        }

        public void b(int i) {
            this.count = i;
        }

        /* access modifiers changed from: protected */
        public void c(int i) {
            int length = this.buf.length << 1;
            if (length - i < 0) {
                length = i;
            }
            if (length - 2147483639 > 0) {
                length = d(i);
            }
            this.buf = Arrays.copyOf(this.buf, length);
        }

        protected static int d(int i) {
            if (i >= 0) {
                return i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            throw new OutOfMemoryError();
        }
    }

    private String a(String str) {
        this.q.clear();
        this.q.add(str);
        return new JSONArray(this.q).toString();
    }
}
