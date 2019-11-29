package jp.co.cyberagent.android.gpuimage;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import jp.co.cyberagent.android.gpuimage.a.a;

public class f extends e {

    /* renamed from: a  reason: collision with root package name */
    protected List<e> f33685a;

    /* renamed from: b  reason: collision with root package name */
    protected List<e> f33686b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f33687c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f33688d;

    /* renamed from: e  reason: collision with root package name */
    private final FloatBuffer f33689e;

    /* renamed from: f  reason: collision with root package name */
    private final FloatBuffer f33690f;

    /* renamed from: g  reason: collision with root package name */
    private final FloatBuffer f33691g;

    public f() {
        this((List<e>) null);
    }

    public f(List<e> list) {
        this.f33685a = list;
        if (this.f33685a == null) {
            this.f33685a = new ArrayList();
        } else {
            k();
        }
        this.f33689e = ByteBuffer.allocateDirect(i.f33694a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f33689e.put(i.f33694a).position(0);
        this.f33690f = ByteBuffer.allocateDirect(a.f33629a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f33690f.put(a.f33629a).position(0);
        float[] a2 = a.a(p.NORMAL, false, true);
        this.f33691g = ByteBuffer.allocateDirect(a2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f33691g.put(a2).position(0);
    }

    public void a(e eVar) {
        if (eVar != null) {
            this.f33685a.add(eVar);
            k();
        }
    }

    public void b() {
        super.b();
        for (e e2 : this.f33685a) {
            e2.e();
        }
    }

    public void c() {
        l();
        for (e f2 : this.f33685a) {
            f2.f();
        }
        super.c();
    }

    private void l() {
        int[] iArr = this.f33688d;
        if (iArr != null) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            this.f33688d = null;
        }
        int[] iArr2 = this.f33687c;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
            this.f33687c = null;
        }
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (this.f33687c != null) {
            l();
        }
        int size = this.f33685a.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f33685a.get(i3).a(i, i2);
        }
        int i4 = i;
        int i5 = i2;
        List<e> list = this.f33686b;
        if (list != null && list.size() > 0) {
            int i6 = 1;
            int size2 = this.f33686b.size() - 1;
            this.f33687c = new int[size2];
            this.f33688d = new int[size2];
            int i7 = 0;
            while (i7 < size2) {
                GLES20.glGenFramebuffers(i6, this.f33687c, i7);
                GLES20.glGenTextures(i6, this.f33688d, i7);
                GLES20.glBindTexture(3553, this.f33688d[i7]);
                GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, (Buffer) null);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.f33687c[i7]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f33688d[i7], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
                i7++;
                i6 = 1;
            }
        }
    }

    @SuppressLint({"WrongCall"})
    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        h();
        if (i() && this.f33687c != null && this.f33688d != null) {
            List<e> list = this.f33686b;
            if (list != null) {
                int size = list.size();
                int i2 = i;
                int i3 = 0;
                while (i3 < size) {
                    e eVar = this.f33686b.get(i3);
                    int i4 = size - 1;
                    boolean z = i3 < i4;
                    if (z) {
                        GLES20.glBindFramebuffer(36160, this.f33687c[i3]);
                        GLES20.glClearColor(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                    }
                    if (i3 == 0) {
                        eVar.a(i2, floatBuffer, floatBuffer2);
                    } else if (i3 == i4) {
                        eVar.a(i2, this.f33689e, size % 2 == 0 ? this.f33691g : this.f33690f);
                    } else {
                        eVar.a(i2, this.f33689e, this.f33690f);
                    }
                    if (z) {
                        GLES20.glBindFramebuffer(36160, 0);
                        i2 = this.f33688d[i3];
                    }
                    i3++;
                }
            }
        }
    }

    public List<e> d() {
        return this.f33686b;
    }

    public void k() {
        if (this.f33685a != null) {
            List<e> list = this.f33686b;
            if (list == null) {
                this.f33686b = new ArrayList();
            } else {
                list.clear();
            }
            for (e next : this.f33685a) {
                if (next instanceof f) {
                    f fVar = (f) next;
                    fVar.k();
                    List<e> d2 = fVar.d();
                    if (d2 != null && !d2.isEmpty()) {
                        this.f33686b.addAll(d2);
                    }
                } else {
                    this.f33686b.add(next);
                }
            }
        }
    }
}
