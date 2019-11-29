package jp.co.cyberagent.android.gpuimage;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.facebook.react.uimanager.ViewProps;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList<Runnable> f33675a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33676b;

    /* renamed from: c  reason: collision with root package name */
    private final String f33677c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f33678d;
    protected int j;
    protected int k;
    protected int l;
    protected int m;
    protected int n;
    protected int o;

    public void a() {
    }

    public void c() {
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    public e() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public e(String str, String str2) {
        this.f33675a = new LinkedList<>();
        this.f33676b = str;
        this.f33677c = str2;
    }

    public final void e() {
        b();
        this.f33678d = true;
        a();
    }

    public void b() {
        this.j = n.a(this.f33676b, this.f33677c);
        this.k = GLES20.glGetAttribLocation(this.j, ViewProps.POSITION);
        this.l = GLES20.glGetUniformLocation(this.j, "inputImageTexture");
        this.m = GLES20.glGetAttribLocation(this.j, "inputTextureCoordinate");
        this.f33678d = true;
    }

    public final void f() {
        this.f33678d = false;
        GLES20.glDeleteProgram(this.j);
        c();
    }

    public void a(int i, int i2) {
        this.n = i;
        this.o = i2;
    }

    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.j);
        h();
        if (this.f33678d) {
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.k, 2, 5126, false, 0, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.k);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.m, 2, 5126, false, 0, floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.m);
            if (i != -1) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, i);
                GLES20.glUniform1i(this.l, 0);
            }
            g();
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.k);
            GLES20.glDisableVertexAttribArray(this.m);
            GLES20.glBindTexture(3553, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
        while (!this.f33675a.isEmpty()) {
            this.f33675a.removeFirst().run();
        }
    }

    public boolean i() {
        return this.f33678d;
    }

    public int j() {
        return this.j;
    }

    /* access modifiers changed from: protected */
    public void a(final int i, final float f2) {
        a(new Runnable() {
            public void run() {
                GLES20.glUniform1f(i, f2);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(final int i, final PointF pointF) {
        a(new Runnable() {
            public void run() {
                GLES20.glUniform2fv(i, 1, new float[]{pointF.x, pointF.y}, 0);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable) {
        synchronized (this.f33675a) {
            this.f33675a.addLast(runnable);
        }
    }
}
