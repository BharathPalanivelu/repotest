package androidx.constraintlayout.a;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;

public class h {
    private static int j = 1;
    private static int k = 1;
    private static int l = 1;
    private static int m = 1;
    private static int n = 1;

    /* renamed from: a  reason: collision with root package name */
    public int f1445a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f1446b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f1447c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float f1448d;

    /* renamed from: e  reason: collision with root package name */
    float[] f1449e = new float[7];

    /* renamed from: f  reason: collision with root package name */
    a f1450f;

    /* renamed from: g  reason: collision with root package name */
    b[] f1451g = new b[8];
    int h = 0;
    public int i = 0;
    private String o;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    static void a() {
        k++;
    }

    public h(a aVar, String str) {
        this.f1450f = aVar;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.h;
            if (i2 >= i3) {
                b[] bVarArr = this.f1451g;
                if (i3 >= bVarArr.length) {
                    this.f1451g = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f1451g;
                int i4 = this.h;
                bVarArr2[i4] = bVar;
                this.h = i4 + 1;
                return;
            } else if (this.f1451g[i2] != bVar) {
                i2++;
            } else {
                return;
            }
        }
    }

    public final void b(b bVar) {
        int i2 = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.f1451g[i3] == bVar) {
                for (int i4 = 0; i4 < (i2 - i3) - 1; i4++) {
                    b[] bVarArr = this.f1451g;
                    int i5 = i3 + i4;
                    bVarArr[i5] = bVarArr[i5 + 1];
                }
                this.h--;
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i2 = this.h;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f1451g[i3].f1424d.a(this.f1451g[i3], bVar, false);
        }
        this.h = 0;
    }

    public void b() {
        this.o = null;
        this.f1450f = a.UNKNOWN;
        this.f1447c = 0;
        this.f1445a = -1;
        this.f1446b = -1;
        this.f1448d = BitmapDescriptorFactory.HUE_RED;
        this.h = 0;
        this.i = 0;
    }

    public void a(a aVar, String str) {
        this.f1450f = aVar;
    }

    public String toString() {
        return "" + this.o;
    }
}
