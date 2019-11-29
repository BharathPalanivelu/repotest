package com.airpay.paysdk.common.net.tcp.b;

import com.airpay.paysdk.common.net.tcp.c.e;
import com.airpay.paysdk.common.net.tcp.d.b;
import com.airpay.paysdk.common.net.tcp.proto.BasicPacketProto;
import com.tencent.ijk.media.player.IMediaPlayer;
import java.io.IOException;
import java.io.InputStream;

public class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final e f4025a;

    /* renamed from: b  reason: collision with root package name */
    private final b f4026b;

    /* renamed from: c  reason: collision with root package name */
    private final d f4027c;

    public a(d dVar, b bVar, e eVar) {
        this.f4027c = dVar;
        this.f4026b = bVar;
        this.f4025a = eVar;
    }

    public void run() {
        a();
    }

    private void a() {
        while (!isInterrupted() && this.f4027c.b()) {
            try {
                a(this.f4026b.b());
            } catch (com.airpay.paysdk.common.a.a e2) {
                this.f4027c.c();
                com.airpay.paysdk.common.b.a.a((Throwable) e2);
            }
        }
        com.airpay.paysdk.common.b.a.a("koneng--------interupt-----" + isInterrupted(), new Object[0]);
        InputStream a2 = this.f4026b.a();
        if (a2 != null) {
            try {
                a2.close();
            } catch (IOException e3) {
                com.airpay.paysdk.common.b.a.a((Throwable) e3);
            }
        }
        this.f4027c.c();
    }

    private void a(com.airpay.paysdk.common.net.tcp.d.a aVar) throws com.airpay.paysdk.common.a.a {
        try {
            int a2 = aVar.a();
            int i = (65280 & a2) >> 12;
            int i2 = a2 & 255;
            if (i == 3) {
                byte[] b2 = aVar.b();
                if (b2 != null) {
                    BasicPacketProto decode = BasicPacketProto.ADAPTER.decode(b2);
                    if (decode.header.result.intValue() != 0) {
                        com.airpay.paysdk.common.b.a.b("Airpay cmd-0x" + Integer.toHexString(a2) + "--error response-- " + decode.toString(), new Object[0]);
                    }
                    f fVar = new f(decode.header.id.intValue(), i2, aVar);
                    fVar.a(decode.header.result.intValue());
                    fVar.a(decode.header.message);
                    this.f4025a.a(fVar);
                }
            } else if (i == 4) {
                this.f4025a.b(new f(a2, aVar));
            }
        } catch (IOException unused) {
            throw new com.airpay.paysdk.common.a.a((int) IMediaPlayer.MEDIA_INFO_FIRST_VIDEO_PACKET, "tcp packet parse to proto error!");
        }
    }
}
