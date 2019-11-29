package com.airpay.paysdk.common.net.tcp.a;

import com.airpay.paysdk.common.net.a.a.g;
import com.airpay.paysdk.common.net.tcp.b.b;
import com.airpay.paysdk.common.net.tcp.b.c;
import com.airpay.paysdk.common.net.tcp.b.e;
import com.airpay.paysdk.common.net.tcp.proto.BasicPacketProto;
import com.airpay.paysdk.common.net.tcp.proto.HeartbeatReplyProto;
import com.airpay.paysdk.common.net.tcp.proto.PacketHeaderProto;
import com.airpay.paysdk.libs.wire.Message;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Timer f4008a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f4009b;

    /* renamed from: com.airpay.paysdk.common.net.tcp.a.a$a  reason: collision with other inner class name */
    private static final class C0080a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f4016a = new a();
    }

    public static a a() {
        return C0080a.f4016a;
    }

    private a() {
        this.f4009b = new AtomicInteger(0);
    }

    public void a(final int i, final int i2) {
        this.f4008a = new Timer();
        this.f4008a.schedule(new TimerTask() {
            public void run() {
                a.this.b(i, i2);
            }
        }, 500, 60000);
    }

    /* access modifiers changed from: private */
    public void b(final int i, final int i2) {
        com.airpay.paysdk.common.b.a.a("koneng... start heart beat+++++++++++++++++", new Object[0]);
        b a2 = new b.a().a();
        PacketHeaderProto.Builder builder = new PacketHeaderProto.Builder();
        builder.id = Integer.valueOf(a2.b());
        builder.source(Integer.valueOf(i2));
        com.airpay.paysdk.common.net.a.a().a((g) new e(a2, i, (Message) new BasicPacketProto.Builder().header(builder.build()).build()), HeartbeatReplyProto.class, new com.airpay.paysdk.common.net.a.a.a<HeartbeatReplyProto>() {
            public void a(HeartbeatReplyProto heartbeatReplyProto) {
                com.airpay.paysdk.common.b.a.a("koneng----------heart beat ---------success!", new Object[0]);
                a.this.f4009b.set(0);
            }

            public void a(int i, String str) {
                com.airpay.paysdk.common.b.a.a("koneng----------heart beat ---------error code ==" + i + "---- error message == " + str, new Object[0]);
                int incrementAndGet = a.this.f4009b.incrementAndGet();
                if (i == 10012 || i == 4 || incrementAndGet > 3) {
                    a.this.f4009b.set(0);
                } else {
                    a.this.b(i, i2);
                }
            }
        });
    }

    public void b() {
        com.airpay.paysdk.common.b.a.a("koneng stopHeartBeat--------------", new Object[0]);
        com.airpay.paysdk.common.net.a.a b2 = com.airpay.paysdk.common.net.a.a().b();
        Timer timer = this.f4008a;
        if (timer != null) {
            timer.cancel();
            this.f4008a.purge();
        }
        if (b2 != null) {
            c cVar = (c) b2.b();
            if (cVar.c()) {
                cVar.b();
            }
        }
    }
}
