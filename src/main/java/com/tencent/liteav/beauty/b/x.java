package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.beauty.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.List;

public class x extends g {
    private static final float[] A = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f};
    protected static final short[] v = {1, 2, 0, 2, 0, 3};
    private static final float[] z = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
    private String B;
    protected a[] r;
    protected List<c.e> s;
    protected boolean t;
    protected int u;
    protected ShortBuffer w;
    private a x;
    private int y;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public FloatBuffer f31514a = null;

        /* renamed from: b  reason: collision with root package name */
        public FloatBuffer f31515b = null;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f31516c;

        /* renamed from: d  reason: collision with root package name */
        public int[] f31517d = null;

        public a() {
        }
    }

    public x(String str, String str2) {
        super(str, str2);
        this.r = null;
        this.x = null;
        this.s = null;
        this.t = false;
        this.u = 1;
        this.y = 1;
        this.w = null;
        this.B = "GPUWatermark";
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(v.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.w = allocateDirect.asShortBuffer();
        this.w.put(v);
        this.w.position(0);
        this.o = true;
    }

    public x() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public void d() {
        super.d();
        this.t = false;
        q();
    }

    public void c(boolean z2) {
        this.t = z2;
    }

    public void a(Bitmap bitmap, float f2, float f3, float f4, int i) {
        if (bitmap == null) {
            a[] aVarArr = this.r;
            if (aVarArr != null && aVarArr[i] != null) {
                String str = this.B;
                Log.i(str, "release " + i + " water mark!");
                if (this.r[i].f31517d != null) {
                    GLES20.glDeleteTextures(1, this.r[i].f31517d, 0);
                }
                a[] aVarArr2 = this.r;
                aVarArr2[i].f31517d = null;
                aVarArr2[i].f31516c = null;
                aVarArr2[i] = null;
                return;
            }
            return;
        }
        a[] aVarArr3 = this.r;
        if (aVarArr3[i] == null || i >= aVarArr3.length) {
            Log.e(this.B, "index is too large for mSzWaterMark!");
            return;
        }
        a(bitmap.getWidth(), bitmap.getHeight(), f2, f3, f4, i);
        if (this.r[i].f31517d == null) {
            a[] aVarArr4 = this.r;
            aVarArr4[i].f31517d = new int[1];
            GLES20.glGenTextures(1, aVarArr4[i].f31517d, 0);
            GLES20.glBindTexture(3553, this.r[i].f31517d[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
        }
        if (this.r[i].f31516c == null || !this.r[i].f31516c.equals(bitmap)) {
            GLES20.glBindTexture(3553, this.r[i].f31517d[0]);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        }
        this.r[i].f31516c = bitmap;
    }

    /* access modifiers changed from: protected */
    public void a(int i, int i2, float f2, float f3, float f4, int i3) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(z.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.r[i3].f31514a = allocateDirect.asFloatBuffer();
        float[] fArr = new float[z.length];
        fArr[0] = (f2 * 2.0f) - 1.0f;
        fArr[1] = 1.0f - (f3 * 2.0f);
        fArr[2] = fArr[0];
        fArr[3] = fArr[1] - (((((((float) i2) / ((float) i)) * f4) * ((float) this.f31317e)) / ((float) this.f31318f)) * 2.0f);
        fArr[4] = fArr[0] + (f4 * 2.0f);
        fArr[5] = fArr[3];
        fArr[6] = fArr[4];
        fArr[7] = fArr[1];
        for (int i4 = 1; i4 <= 7; i4 += 2) {
            fArr[i4] = fArr[i4] * -1.0f;
        }
        this.r[i3].f31514a.put(fArr);
        this.r[i3].f31514a.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(A.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.r[i3].f31515b = allocateDirect2.asFloatBuffer();
        this.r[i3].f31515b.put(A);
        this.r[i3].f31515b.position(0);
    }

    public void a(Bitmap bitmap, float f2, float f3, float f4) {
        if (this.r == null) {
            this.r = new a[1];
        }
        a[] aVarArr = this.r;
        if (aVarArr[0] == null) {
            aVarArr[0] = new a();
        }
        a(bitmap, f2, f3, f4, 0);
        this.x = this.r[0];
    }

    private void q() {
        if (this.r != null) {
            int i = 0;
            while (true) {
                a[] aVarArr = this.r;
                if (i >= aVarArr.length) {
                    break;
                }
                if (aVarArr[i] != null) {
                    if (aVarArr[i].f31517d != null) {
                        GLES20.glDeleteTextures(1, this.r[i].f31517d, 0);
                    }
                    a[] aVarArr2 = this.r;
                    aVarArr2[i].f31517d = null;
                    aVarArr2[i].f31516c = null;
                    aVarArr2[i] = null;
                }
                i++;
            }
        }
        this.r = null;
    }

    /* access modifiers changed from: protected */
    public void j() {
        super.j();
        if (this.t) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(this.u, 771);
            GLES20.glActiveTexture(33984);
            int i = 0;
            while (true) {
                a[] aVarArr = this.r;
                if (i < aVarArr.length) {
                    if (aVarArr[i] != null) {
                        GLES20.glBindTexture(3553, aVarArr[i].f31517d[0]);
                        GLES20.glUniform1i(this.f31315c, 0);
                        GLES20.glVertexAttribPointer(this.f31314b, 2, 5126, false, 8, this.r[i].f31514a);
                        GLES20.glEnableVertexAttribArray(this.f31314b);
                        GLES20.glVertexAttribPointer(this.f31316d, 4, 5126, false, 16, this.r[i].f31515b);
                        GLES20.glEnableVertexAttribArray(this.f31316d);
                        GLES20.glDrawElements(4, v.length, 5123, this.w);
                        GLES20.glDisableVertexAttribArray(this.f31314b);
                        GLES20.glDisableVertexAttribArray(this.f31316d);
                    }
                    i++;
                } else {
                    GLES20.glDisable(3042);
                    return;
                }
            }
        }
    }
}
