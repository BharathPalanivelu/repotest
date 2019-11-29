package com.beetalklib.network.file.a;

import com.beetalklib.network.d.b;
import com.beetalklib.network.d.c;
import com.beetalklib.network.d.f;
import com.beetalklib.network.file.b.a;
import com.beetalklib.network.file.protocol.FSGeneralError;
import com.beetalklib.network.file.protocol.ImageDownloadResult;
import com.salesforce.android.chat.core.internal.logging.event.ChatFileTransferEvent;
import com.squareup.wire.Wire;
import java.io.IOException;

public class e implements c, a {

    /* renamed from: a  reason: collision with root package name */
    private Wire f5547a = new Wire((Class<?>[]) new Class[0]);

    /* renamed from: b  reason: collision with root package name */
    private b f5548b;

    /* renamed from: c  reason: collision with root package name */
    private int f5549c = 0;

    /* renamed from: d  reason: collision with root package name */
    private com.beetalklib.network.file.b.c f5550d;

    /* renamed from: e  reason: collision with root package name */
    private d f5551e;

    /* renamed from: f  reason: collision with root package name */
    private h f5552f;

    public e(h hVar, com.beetalklib.network.file.b.c cVar) {
        this.f5552f = hVar;
        this.f5550d = cVar;
        a.a().a(this);
    }

    public void a(int i, int i2) {
        com.beetalklib.network.c.a.b("unable to connect %d error %d", Integer.valueOf(i), Integer.valueOf(i2));
        b();
    }

    public void a(f fVar) {
        com.beetalklib.network.c.a.b("send packet failed %d", Integer.valueOf(fVar.a()));
        b();
    }

    public void b(f fVar) {
        if (this.f5551e == null) {
            com.beetalklib.network.c.a.b("response cmd %d ignored - no pending tasks", new Object[0]);
            return;
        }
        try {
            int a2 = fVar.a();
            if (a2 == 2) {
                FSGeneralError fSGeneralError = (FSGeneralError) this.f5547a.parseFrom(fVar.b(), FSGeneralError.class);
                a(fSGeneralError.ErrorCode.intValue(), fSGeneralError.RequestId);
            } else if (a2 == 3) {
                ImageDownloadResult imageDownloadResult = (ImageDownloadResult) this.f5547a.parseFrom(fVar.b(), ImageDownloadResult.class);
                a(imageDownloadResult.Content.i(), imageDownloadResult.RequestId);
            }
        } catch (IOException e2) {
            com.beetalklib.network.c.a.a(e2);
        }
    }

    public void a(int i, String str) {
        com.beetalklib.network.c.a.a("general error %d %s", Integer.valueOf(i), str);
        d dVar = this.f5551e;
        if (dVar == null || !dVar.f5541a.equals(str)) {
            com.beetalklib.network.c.a.a("ignore error %d %s", Integer.valueOf(i), str);
        } else if (i == 1) {
            this.f5551e.a(1);
            a(false);
        } else if (i != 16) {
            com.beetalklib.network.c.a.a("unknown error %d %s %s", Integer.valueOf(i), str, this.f5551e.c());
            this.f5551e.a(272);
            a(false);
        } else {
            this.f5551e.a(16);
            a(false);
        }
    }

    public void a(int i) {
        com.beetalklib.network.c.a.b("connection dropped %d", Integer.valueOf(i));
        b();
    }

    public void b(int i) {
        d dVar = this.f5551e;
        if (dVar != null && !dVar.a()) {
            a();
        }
    }

    public void a(d dVar) {
        if (this.f5551e == null) {
            com.beetalklib.network.c.a.b("new task join download queue %s", dVar.f5541a);
            this.f5551e = dVar;
            this.f5549c = 0;
            this.f5548b = this.f5552f.a((c) this);
            this.f5548b.a();
        }
    }

    private void a() {
        this.f5548b.a(new f(2, this.f5551e.b().toByteArray()));
    }

    private void b() {
        d dVar = this.f5551e;
        if (dVar != null) {
            this.f5549c++;
            if (3 <= this.f5549c) {
                dVar.a(34);
                a(false);
                return;
            }
            com.beetalklib.network.c.a.b("resume connection %d seconds later", 2L);
            this.f5548b.a(2000);
        }
    }

    private void a(byte[] bArr, String str) {
        d dVar = this.f5551e;
        if (dVar != null && dVar.f5541a.equals(str)) {
            this.f5551e.a(bArr);
        }
        d dVar2 = this.f5551e;
        if (dVar2 == null || dVar2.f5541a.equals(str)) {
            a(true);
        }
    }

    private void a(boolean z) {
        Object[] objArr = new Object[1];
        objArr[0] = z ? "ok" : ChatFileTransferEvent.FAILED;
        com.beetalklib.network.c.a.b("fileUpload completed %s", objArr);
        this.f5551e = null;
        a.a().b(this);
        this.f5552f.a();
        this.f5550d.a(z);
    }
}
