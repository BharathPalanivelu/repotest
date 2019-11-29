package com.shopee.liveimsdk.custom;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.shopee.liveimsdk.RemoteimConfig;
import com.shopee.liveimsdk.custom.CustomIMSingleService;
import com.shopee.liveimsdk.custom.a.a;
import com.shopee.liveimsdk.custom.c.a;
import com.shopee.liveimsdk.custom.c.b;
import com.shopee.liveimsdk.custom.c.c;
import com.shopee.liveimsdk.d;

public class a extends com.shopee.liveimsdk.a {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static b f29548b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f29549a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0450a f29550c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f29551d = "";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f29552e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f29553f = "";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f29554g = "";
    /* access modifiers changed from: private */
    public String h = "";
    /* access modifiers changed from: private */
    public int i;
    /* access modifiers changed from: private */
    public boolean j;
    /* access modifiers changed from: private */
    public boolean k;
    /* access modifiers changed from: private */
    public long l;
    /* access modifiers changed from: private */
    public a.b m;
    /* access modifiers changed from: private */
    public CustomIMSingleService.a n;
    /* access modifiers changed from: private */
    public ServiceConnection o = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.b unused = a.this.m = (a.b) iBinder;
            CustomIMSingleService.a unused2 = a.this.n = new CustomIMSingleService.a() {
                public void a(String str) {
                    a.this.c(str);
                }

                public void a(String str, int i) {
                    a.this.a(str, i);
                }

                public void b(String str) {
                    a.this.d(str);
                }

                public void b(String str, int i) {
                    a.this.b(str, i);
                }

                public void a(String str, String str2) {
                    a.this.a(str, str2);
                }

                public void a(String str, String str2, int i) {
                    a.this.a(str, str2, i);
                }

                public void a(a.d dVar) {
                    a.this.a(dVar);
                }

                public void a(com.shopee.liveimsdk.custom.a.a aVar) {
                    a.this.a(aVar);
                }
            };
            a.this.m.a(a.this.n);
            if (a.this.j) {
                boolean unused3 = a.this.j = false;
                a.this.a();
            }
            if (a.this.k) {
                a.this.m.a(a.this.l);
                boolean unused4 = a.this.k = false;
                a.this.b();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            a.this.m.a((CustomIMSingleService.a) null);
            CustomIMSingleService.a unused = a.this.n = null;
            a.b unused2 = a.this.m = null;
        }
    };

    static /* synthetic */ int n(a aVar) {
        int i2 = aVar.i;
        aVar.i = i2 - 1;
        return i2;
    }

    public a(b bVar) {
        f29548b = bVar;
    }

    public void a(final Context context, int i2) {
        c.a(new b() {
            public void a() {
                Context unused = a.this.f29549a = context;
                boolean unused2 = a.this.j = false;
                boolean unused3 = a.this.k = false;
                C0450a unused4 = a.this.f29550c = new C0450a();
                a.this.f29549a.bindService(new Intent(a.this.f29549a, CustomIMSingleService.class), a.this.o, 1);
            }
        });
    }

    public void a(final com.shopee.liveimsdk.b bVar) {
        c.a(new b() {
            public void a() {
                d.f29665a = bVar.f29540a;
                d.f29666b = bVar.f29541b;
                d.f29667c = bVar.f29542c;
                String unused = a.this.f29551d = bVar.f29543d;
                int unused2 = a.this.f29552e = bVar.f29544e;
                String unused3 = a.this.f29553f = bVar.i;
                String unused4 = a.this.h = bVar.j;
            }
        });
    }

    public void a() {
        c.a(new b() {
            public void a() {
                if (a.this.m != null) {
                    a.this.m.a(new RemoteimConfig(d.f29665a, d.f29666b, d.f29667c, a.this.f29551d, a.this.f29552e, a.this.f29553f, a.this.f29554g));
                    int unused = a.this.i = 10;
                    a aVar = a.this;
                    aVar.b(aVar.h);
                    return;
                }
                boolean unused2 = a.this.j = true;
            }
        });
    }

    public void b() {
        c.a(new b() {
            public void a() {
                if (a.this.m != null) {
                    a.this.m.a(new RemoteimConfig(d.f29665a, d.f29666b, d.f29667c, a.this.f29551d, a.this.f29552e, a.this.f29553f, a.this.f29554g));
                    a.this.m.c(a.this.h);
                    return;
                }
                boolean unused = a.this.k = true;
            }
        });
    }

    public void a(final long j2) {
        c.a(new b() {
            public void a() {
                if (a.this.m != null) {
                    a.this.m.a(j2);
                } else {
                    long unused = a.this.l = j2;
                }
                a.this.b();
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        a.b bVar = this.m;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public void c() {
        c.a(new b() {
            public void a() {
                if (a.this.m != null) {
                    a.this.m.b(a.this.h);
                }
            }
        });
    }

    public void d() {
        c();
    }

    public void e() {
        c.a(new b() {
            public void a() {
                a.this.d();
                if (a.this.m != null) {
                    a.this.f29549a.unbindService(a.this.o);
                }
                Context unused = a.this.f29549a = null;
                a.this.f29550c.removeCallbacksAndMessages((Object) null);
                C0450a unused2 = a.this.f29550c = null;
                b unused3 = a.f29548b = null;
            }
        });
    }

    public void a(String str) {
        a.b bVar = this.m;
        if (bVar != null) {
            bVar.a(this.h, str);
        }
    }

    /* access modifiers changed from: private */
    public void c(final String str) {
        c.a(new b() {
            public void a() {
                com.shopee.liveimsdk.c.a("onJoinRoomSucceedroom_id: " + str);
                if (a.this.f29550c != null) {
                    Message obtainMessage = a.this.f29550c.obtainMessage();
                    obtainMessage.what = 3;
                    obtainMessage.obj = str;
                    if (a.this.f29550c != null) {
                        a.this.f29550c.sendMessage(obtainMessage);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final String str, final int i2) {
        c.a(new b() {
            public void a() {
                com.shopee.liveimsdk.c.a("onJoinRoomFailed: room_id: " + str + ", error code: " + i2);
                if (i2 == 120) {
                    int unused = a.this.i = 0;
                } else {
                    a.n(a.this);
                }
                if (a.this.i > 0) {
                    a.this.b(str);
                } else if (a.this.f29550c != null) {
                    Message obtainMessage = a.this.f29550c.obtainMessage();
                    obtainMessage.what = 4;
                    obtainMessage.obj = str;
                    if (a.this.f29550c != null) {
                        a.this.f29550c.sendMessage(obtainMessage);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        com.shopee.liveimsdk.c.a("onExitRoomSucceed: room_id: " + str);
    }

    /* access modifiers changed from: private */
    public void b(String str, int i2) {
        com.shopee.liveimsdk.c.a("onExitRoomFailed: room_id: " + str + ", error code: " + i2);
    }

    /* access modifiers changed from: private */
    public void a(final String str, final String str2) {
        c.a(new b() {
            public void a() {
                com.shopee.liveimsdk.c.a("onSendMessageSucceed: room_id: " + str + ", msg: " + str2);
                if (a.this.f29550c != null) {
                    Message obtainMessage = a.this.f29550c.obtainMessage();
                    obtainMessage.what = 5;
                    Bundle bundle = new Bundle();
                    bundle.putString("send_group_id", str);
                    bundle.putString("send_message", str2);
                    obtainMessage.setData(bundle);
                    if (a.this.f29550c != null) {
                        a.this.f29550c.sendMessage(obtainMessage);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final String str, final String str2, final int i2) {
        c.a(new b() {
            public void a() {
                com.shopee.liveimsdk.c.a("onSendMessageFailed: room_id: " + str + ", msg: " + str2 + ", error code: " + i2);
                if (i2 == 150) {
                    a.this.b(str);
                }
                if (a.this.f29550c != null) {
                    Message obtainMessage = a.this.f29550c.obtainMessage();
                    obtainMessage.what = 6;
                    Bundle bundle = new Bundle();
                    bundle.putString("send_group_id", str);
                    bundle.putString("send_message", str2);
                    obtainMessage.setData(bundle);
                    if (a.this.f29550c != null) {
                        a.this.f29550c.sendMessage(obtainMessage);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final a.d dVar) {
        c.a(new b() {
            public void a() {
                com.shopee.liveimsdk.c.a("onNewMessage: " + dVar.f29595c + ", " + dVar.f29596d + ", " + dVar.f29597e);
                if (a.this.f29550c != null) {
                    Message obtainMessage = a.this.f29550c.obtainMessage();
                    obtainMessage.what = 7;
                    obtainMessage.obj = dVar;
                    if (a.this.f29550c != null) {
                        a.this.f29550c.sendMessage(obtainMessage);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final com.shopee.liveimsdk.custom.a.a aVar) {
        c.a(new b() {
            public void a() {
                com.shopee.liveimsdk.c.a("on Get Public ScreenMessage.");
                if (a.this.f29550c != null) {
                    Message obtainMessage = a.this.f29550c.obtainMessage();
                    obtainMessage.what = 8;
                    obtainMessage.obj = aVar;
                    if (a.this.f29550c != null) {
                        a.this.f29550c.sendMessage(obtainMessage);
                    }
                }
            }
        });
    }

    /* renamed from: com.shopee.liveimsdk.custom.a$a  reason: collision with other inner class name */
    private static class C0450a extends Handler {
        private C0450a() {
        }

        public void handleMessage(final Message message) {
            if (a.f29548b != null) {
                c.a(new b() {
                    public void a() {
                        switch (message.what) {
                            case 1:
                                a.f29548b.onLoginSucceed();
                                return;
                            case 2:
                                a.f29548b.onLoginFailed();
                                return;
                            case 3:
                                a.f29548b.onJoinGroupSucceed((String) message.obj);
                                return;
                            case 4:
                                a.f29548b.onJoinGroupFailed((String) message.obj);
                                return;
                            case 5:
                                Bundle data = message.getData();
                                a.f29548b.onSendSucess(data.getString("send_group_id"), data.getString("send_message"));
                                return;
                            case 6:
                                Bundle data2 = message.getData();
                                a.f29548b.onSendError(data2.getString("send_group_id"), data2.getString("send_message"));
                                return;
                            case 7:
                                a.f29548b.onDanmaKuReceive((a.d) message.obj);
                                return;
                            case 8:
                                a.f29548b.onReceivePublicScreenMessage((com.shopee.liveimsdk.custom.a.a) message.obj);
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
        }
    }
}
