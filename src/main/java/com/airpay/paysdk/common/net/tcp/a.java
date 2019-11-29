package com.airpay.paysdk.common.net.tcp;

import com.airpay.paysdk.common.net.a.a.a;
import com.airpay.paysdk.common.net.a.a.f;
import com.airpay.paysdk.common.net.a.a.g;
import com.airpay.paysdk.common.net.tcp.b.c;
import com.airpay.paysdk.common.net.tcp.b.e;
import com.airpay.paysdk.common.net.tcp.c.b;
import com.airpay.paysdk.libs.wire.ProtoAdapter;
import com.tencent.ijk.media.player.IjkMediaPlayer;

public class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private volatile c f3991a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile e f3992b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile com.airpay.paysdk.common.net.a.a.e f3993c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f3994d;

    /* renamed from: e  reason: collision with root package name */
    private int f3995e;

    /* renamed from: f  reason: collision with root package name */
    private int f3996f;

    /* renamed from: g  reason: collision with root package name */
    private b f3997g;

    private a(C0079a aVar) {
        g a2 = aVar.f4002b;
        this.f3995e = aVar.f4004d;
        this.f3996f = aVar.f4006f;
        int d2 = aVar.f4005e;
        this.f3993c = aVar.f4003c;
        if (aVar.f4001a != null) {
            this.f3991a = aVar.f4001a;
            if (d2 == 0) {
                if (a2 instanceof e) {
                    this.f3992b = (e) a2;
                } else {
                    throw new RuntimeException("IRequest need instanceof TcpRequest!");
                }
            }
            this.f3997g = aVar.f4007g;
            return;
        }
        throw new RuntimeException("client is null error !");
    }

    public <T> void a(final Class<T> cls, final com.airpay.paysdk.common.net.a.a.a<T> aVar) {
        b bVar = this.f3997g;
        if (bVar != null) {
            aVar.a(bVar.a());
            return;
        }
        this.f3992b.a(aVar);
        this.f3992b.a(cls);
        this.f3991a.a(this.f3996f, this.f3992b, (com.airpay.paysdk.common.net.tcp.c.a) new com.airpay.paysdk.common.net.tcp.c.a() {
            public void a(com.airpay.paysdk.common.net.tcp.b.f fVar) {
                a aVar = a.this;
                aVar.a(false, aVar.f3992b.e(), a.this.f3992b, fVar, cls, aVar);
            }

            public void a(int i, String str) {
                boolean z = false;
                com.airpay.paysdk.common.b.a.a("koneng---execute--error code ==" + i + "---- error message == " + str, new Object[0]);
                if (a.this.f3993c != null) {
                    if (!a.this.f3994d) {
                        com.airpay.paysdk.common.net.tcp.b.f fVar = new com.airpay.paysdk.common.net.tcp.b.f(a.this.f3992b.a().b(), a.this.f3992b.e(), (com.airpay.paysdk.common.net.tcp.d.a) null);
                        fVar.a(i);
                        fVar.a(str);
                        z = a.this.f3993c.a(a.this.f3992b, fVar);
                    } else {
                        return;
                    }
                }
                if (!a.this.f3994d && !z) {
                    a.this.a((Runnable) new Runnable(i, str) {
                        private final /* synthetic */ int f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            a.this.a(this.f$1, this.f$2);
                        }
                    });
                }
            }
        });
    }

    public <T> void a(int i, Class<T> cls, com.airpay.paysdk.common.net.a.a.a<T> aVar) {
        b bVar = this.f3997g;
        if (bVar != null) {
            aVar.a(bVar.a());
        } else {
            this.f3991a.a(i, (com.airpay.paysdk.common.net.tcp.c.c) new com.airpay.paysdk.common.net.tcp.c.c(i, cls, aVar) {
                private final /* synthetic */ int f$1;
                private final /* synthetic */ Class f$2;
                private final /* synthetic */ a f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onReceive(com.airpay.paysdk.common.net.tcp.b.f fVar) {
                    a.this.a(this.f$1, this.f$2, this.f$3, fVar);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i, Class cls, com.airpay.paysdk.common.net.a.a.a aVar, com.airpay.paysdk.common.net.tcp.b.f fVar) {
        a(true, i, (e) null, fVar, cls, aVar);
    }

    /* access modifiers changed from: private */
    public <T> void a(boolean z, int i, e eVar, com.airpay.paysdk.common.net.tcp.b.f fVar, Class<T> cls, com.airpay.paysdk.common.net.a.a.a<T> aVar) {
        if (!this.f3994d) {
            if (i != fVar.c()) {
                a((Runnable) new Runnable() {
                    public final void run() {
                        a.this.a(10006, "response command is different with request command error !");
                    }
                });
            } else if (!this.f3994d) {
                boolean z2 = false;
                com.airpay.paysdk.common.b.a.b("koneng: responseParse " + fVar.d() + ", error: " + fVar.e(), new Object[0]);
                if (fVar.d() == 0) {
                    M m = null;
                    try {
                        m = ProtoAdapter.get(cls).decode(fVar.b());
                        com.airpay.paysdk.common.b.a.b("Airpay cmd-0x" + Integer.toHexString(i) + "--response data-- " + m.toString(), new Object[0]);
                    } catch (Exception e2) {
                        com.airpay.paysdk.common.b.a.a((Throwable) e2);
                        a((Runnable) new Runnable() {
                            public final void run() {
                                a.this.a(IjkMediaPlayer.FFP_PROP_FLOAT_DROP_FRAME_RATE, "receiver proto parse error !");
                            }
                        });
                    }
                    if (!this.f3994d && m != null) {
                        a((Runnable) new Runnable(m) {
                            private final /* synthetic */ Object f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                a.this.a(this.f$1);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (this.f3993c != null) {
                    if (!this.f3994d) {
                        if (!z) {
                            z2 = this.f3993c.a(eVar, fVar);
                        }
                    } else {
                        return;
                    }
                }
                if (!this.f3994d && !z2) {
                    a((Runnable) new Runnable(fVar) {
                        private final /* synthetic */ com.airpay.paysdk.common.net.tcp.b.f f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            a.this.a(this.f$1.d(), this.f$1.e());
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Runnable runnable) {
        if (this.f3995e == 0) {
            com.airpay.paysdk.common.c.a.a();
            if (com.airpay.paysdk.common.c.a.c()) {
                runnable.run();
            } else {
                com.airpay.paysdk.common.c.a.a().a(runnable);
            }
        } else {
            runnable.run();
        }
    }

    public void a() {
        this.f3994d = true;
    }

    /* renamed from: com.airpay.paysdk.common.net.tcp.a$a  reason: collision with other inner class name */
    public static class C0079a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public c f4001a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public g f4002b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public com.airpay.paysdk.common.net.a.a.e f4003c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f4004d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f4005e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f4006f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public b f4007g;

        public C0079a a(c cVar) {
            this.f4001a = cVar;
            return this;
        }

        public C0079a a(int i) {
            this.f4004d = i;
            return this;
        }

        public C0079a b(int i) {
            this.f4005e = i;
            return this;
        }

        public C0079a a(g gVar) {
            this.f4002b = gVar;
            return this;
        }

        public C0079a a(com.airpay.paysdk.common.net.a.a.e eVar) {
            this.f4003c = eVar;
            return this;
        }

        public C0079a c(int i) {
            this.f4006f = i;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
