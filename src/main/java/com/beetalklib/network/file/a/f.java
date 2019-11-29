package com.beetalklib.network.file.a;

import com.beetalklib.network.d.b;
import com.beetalklib.network.d.c;
import com.beetalklib.network.file.b.a;
import com.beetalklib.network.file.protocol.FSGeneralError;
import com.beetalklib.network.file.protocol.ImageUploadRequestHeaderAck;
import com.beetalklib.network.file.protocol.ImageUploadRequestPart;
import com.beetalklib.network.file.protocol.ImageUploadRequestPartAck;
import com.salesforce.android.chat.core.internal.logging.event.ChatFileTransferEvent;
import com.squareup.wire.Wire;
import java.io.IOException;

public class f implements c, a {

    /* renamed from: c  reason: collision with root package name */
    private static Wire f5553c = new Wire((Class<?>[]) new Class[0]);

    /* renamed from: a  reason: collision with root package name */
    private int f5554a = 8;

    /* renamed from: b  reason: collision with root package name */
    private h f5555b;

    /* renamed from: d  reason: collision with root package name */
    private b f5556d;

    /* renamed from: e  reason: collision with root package name */
    private int f5557e = 0;

    /* renamed from: f  reason: collision with root package name */
    private com.beetalklib.network.file.b.c f5558f;

    /* renamed from: g  reason: collision with root package name */
    private j f5559g;

    public f(h hVar, com.beetalklib.network.file.b.c cVar) {
        this.f5555b = hVar;
        this.f5558f = cVar;
        a.a().a(this);
    }

    public void a(int i, int i2) {
        com.beetalklib.network.c.a.b("unable to connect %d error %d", Integer.valueOf(i), Integer.valueOf(i2));
        c();
    }

    public void a(com.beetalklib.network.d.f fVar) {
        com.beetalklib.network.c.a.b("send packet failed %d", Integer.valueOf(fVar.a()));
        c();
    }

    public void a(int i) {
        com.beetalklib.network.c.a.b("connection dropped %d", Integer.valueOf(i));
        c();
    }

    public void b(com.beetalklib.network.d.f fVar) {
        if (this.f5559g == null) {
            com.beetalklib.network.c.a.b("response cmd %d ignored - no pending tasks", new Object[0]);
            return;
        }
        try {
            int a2 = fVar.a();
            if (a2 == 2) {
                FSGeneralError fSGeneralError = (FSGeneralError) f5553c.parseFrom(fVar.b(), FSGeneralError.class);
                a(fSGeneralError.ErrorCode.intValue(), fSGeneralError.RequestId);
            } else if (a2 == 4) {
                ImageUploadRequestPartAck imageUploadRequestPartAck = (ImageUploadRequestPartAck) f5553c.parseFrom(fVar.b(), ImageUploadRequestPartAck.class);
                if (imageUploadRequestPartAck.RequestId.equals(this.f5559g.f5564a)) {
                    c(imageUploadRequestPartAck.PartId.intValue() + 1);
                }
            } else if (a2 == 5) {
                a((ImageUploadRequestHeaderAck) f5553c.parseFrom(fVar.b(), ImageUploadRequestHeaderAck.class));
            }
        } catch (IOException e2) {
            com.beetalklib.network.c.a.a(e2);
        }
    }

    public void b(int i) {
        j jVar = this.f5559g;
        if (jVar != null) {
            if (jVar.d() == -1) {
                b();
                return;
            }
            com.beetalklib.network.c.a.b("resume the upload session %s", this.f5559g.f5564a);
            c(this.f5559g.d() + 1);
        }
    }

    public void a(j jVar) {
        if (this.f5559g == null) {
            com.beetalklib.network.c.a.b("new task join %s", jVar.f5564a);
            this.f5554a = jVar.f() > 10 ? 8 : 6;
            this.f5559g = jVar;
            this.f5557e = 0;
            this.f5556d = this.f5555b.a((c) this);
            this.f5556d.a();
        }
    }

    public void a(int i, String str) {
        com.beetalklib.network.c.a.a("general error %d %s", Integer.valueOf(i), str);
        j jVar = this.f5559g;
        if (jVar == null || !jVar.f5564a.equals(str)) {
            com.beetalklib.network.c.a.a("ignore error %d %s", Integer.valueOf(i), str);
        } else if (i == 1) {
            this.f5559g.b(1);
            a(false);
        } else if (i == 16) {
            this.f5559g.b(16);
            a(false);
        } else if (i == 129) {
            this.f5559g.b(129);
            a(false);
        } else if (i != 130) {
            com.beetalklib.network.c.a.a("unknown error %d %s %s", Integer.valueOf(i), str, this.f5559g.b());
            this.f5559g.b(272);
            a(false);
        } else {
            b();
        }
    }

    private void a(ImageUploadRequestHeaderAck imageUploadRequestHeaderAck) {
        if (imageUploadRequestHeaderAck.Exists.booleanValue()) {
            this.f5559g.a(Integer.MAX_VALUE);
            a(true);
        } else if (this.f5559g.f5564a.equals(imageUploadRequestHeaderAck.Name)) {
            this.f5556d.a(new com.beetalklib.network.d.f(4, this.f5559g.a(0).toByteArray()));
        }
    }

    private void b() {
        this.f5556d.a(new com.beetalklib.network.d.f(3, this.f5559g.a().toByteArray()));
    }

    private void c(int i) {
        ImageUploadRequestPart a2 = this.f5559g.a(i);
        if (a2 != null) {
            this.f5556d.a(new com.beetalklib.network.d.f(4, a2.toByteArray()));
            return;
        }
        a(true);
        com.beetalklib.network.c.a.b("null the current task", new Object[0]);
    }

    private void c() {
        j jVar = this.f5559g;
        if (jVar != null) {
            this.f5557e++;
            if (this.f5554a <= this.f5557e) {
                jVar.b(34);
                a(false);
                return;
            }
            com.beetalklib.network.c.a.b("resume connection %d seconds later", 2L);
            this.f5556d.a(2000);
        }
    }

    public void a() {
        j jVar = this.f5559g;
        if (jVar != null) {
            jVar.b(34);
            a(false);
        }
    }

    private void a(boolean z) {
        Object[] objArr = new Object[1];
        objArr[0] = z ? "ok" : ChatFileTransferEvent.FAILED;
        com.beetalklib.network.c.a.b("fileUpload completed %s", objArr);
        this.f5559g = null;
        a.a().b(this);
        this.f5555b.a();
        this.f5558f.a(z);
    }
}
