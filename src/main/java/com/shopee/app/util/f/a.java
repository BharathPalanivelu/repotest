package com.shopee.app.util.f;

import com.beetalklib.network.file.a.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.h.a.g;
import com.shopee.app.h.f;
import com.shopee.app.h.p;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class a implements i {

    /* renamed from: a  reason: collision with root package name */
    private C0402a f26350a;

    /* renamed from: b  reason: collision with root package name */
    protected BlockingQueue<Integer> f26351b = new ArrayBlockingQueue(1);

    /* renamed from: c  reason: collision with root package name */
    protected final p f26352c;

    /* renamed from: d  reason: collision with root package name */
    protected final UserInfo f26353d;

    /* renamed from: com.shopee.app.util.f.a$a  reason: collision with other inner class name */
    public interface C0402a {
        void onProgress(int i, int i2);
    }

    public a(p pVar, UserInfo userInfo) {
        this.f26352c = pVar;
        this.f26353d = userInfo;
    }

    public int a(String str, C0402a aVar) {
        this.f26350a = aVar;
        return a(str);
    }

    public int a(String str) {
        g.f17615a.a(this.f26352c.c(), str, f.a().b(str), String.valueOf(this.f26353d.getUserId()), (i) this);
        try {
            return this.f26351b.take().intValue();
        } catch (InterruptedException unused) {
            return 2;
        }
    }

    public void a() {
        this.f26351b.add(1);
    }

    public void a(int i) {
        com.garena.android.appkit.d.a.b("ERROR CODE %d", Integer.valueOf(i));
        this.f26351b.add(Integer.valueOf(i));
    }

    public void a(int i, int i2) {
        C0402a aVar = this.f26350a;
        if (aVar != null) {
            aVar.onProgress(i, i2);
        }
    }
}
