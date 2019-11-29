package jp.co.cyberagent.android.gpuimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.a.a;

public class k extends e {

    /* renamed from: a  reason: collision with root package name */
    public int f33713a;

    /* renamed from: b  reason: collision with root package name */
    public int f33714b;

    /* renamed from: c  reason: collision with root package name */
    public int f33715c;

    /* renamed from: d  reason: collision with root package name */
    private ByteBuffer f33716d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f33717e;

    public k(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", str);
    }

    public k(String str, String str2) {
        super(str, str2);
        this.f33715c = -1;
        a(p.NORMAL, false, false);
    }

    public void b() {
        super.b();
        this.f33713a = GLES20.glGetAttribLocation(j(), "inputTextureCoordinate2");
        this.f33714b = GLES20.glGetUniformLocation(j(), "inputImageTexture2");
        GLES20.glEnableVertexAttribArray(this.f33713a);
        Bitmap bitmap = this.f33717e;
        if (bitmap != null && !bitmap.isRecycled()) {
            a(this.f33717e);
        }
    }

    public void a(final Bitmap bitmap) {
        if (bitmap == null || !bitmap.isRecycled()) {
            this.f33717e = bitmap;
            if (this.f33717e != null) {
                a(new Runnable() {
                    public void run() {
                        if (k.this.f33715c == -1) {
                            Bitmap bitmap = bitmap;
                            if (bitmap != null && !bitmap.isRecycled()) {
                                GLES20.glActiveTexture(33987);
                                k.this.f33715c = n.a(bitmap, -1, false);
                            }
                        }
                    }
                });
            }
        }
    }

    public void c() {
        super.c();
        GLES20.glDeleteTextures(1, new int[]{this.f33715c}, 0);
        this.f33715c = -1;
    }

    /* access modifiers changed from: protected */
    public void g() {
        GLES20.glEnableVertexAttribArray(this.f33713a);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.f33715c);
        GLES20.glUniform1i(this.f33714b, 3);
        this.f33716d.position(0);
        GLES20.glVertexAttribPointer(this.f33713a, 2, 5126, false, 0, this.f33716d);
    }

    public void a(p pVar, boolean z, boolean z2) {
        float[] a2 = a.a(pVar, z, z2);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(a2);
        asFloatBuffer.flip();
        this.f33716d = order;
    }
}
