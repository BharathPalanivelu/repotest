package com.shopee.liveimsdk.a;

import android.content.Context;
import com.shopee.liveimsdk.b;
import com.shopee.liveimsdk.c;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMCustomElem;
import com.tencent.imsdk.TIMElem;
import com.tencent.imsdk.TIMElemType;
import com.tencent.imsdk.TIMFriendshipManager;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.imsdk.TIMLogLevel;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMMessageListener;
import com.tencent.imsdk.TIMSdkConfig;
import com.tencent.imsdk.TIMTextElem;
import com.tencent.imsdk.TIMUserConfig;
import com.tencent.imsdk.TIMUserStatusListener;
import com.tencent.imsdk.TIMValueCallBack;
import java.util.List;

public class a extends com.shopee.liveimsdk.a {

    /* renamed from: a  reason: collision with root package name */
    private TIMMessageListener f29516a;

    /* renamed from: b  reason: collision with root package name */
    private String f29517b;

    /* renamed from: c  reason: collision with root package name */
    private String f29518c;

    /* renamed from: d  reason: collision with root package name */
    private String f29519d;

    /* renamed from: e  reason: collision with root package name */
    private String f29520e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f29521f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f29522g;
    /* access modifiers changed from: private */
    public boolean h;
    /* access modifiers changed from: private */
    public boolean i;
    /* access modifiers changed from: private */
    public int j = 10;
    /* access modifiers changed from: private */
    public int k = 10;
    /* access modifiers changed from: private */
    public int l = 10;
    /* access modifiers changed from: private */
    public int m = 10;
    private boolean n = true;
    /* access modifiers changed from: private */
    public boolean o = true;
    /* access modifiers changed from: private */
    public b p;

    /* renamed from: com.shopee.liveimsdk.a.a$a  reason: collision with other inner class name */
    public interface C0449a {
        void a();

        void a(int i, String str);
    }

    static /* synthetic */ int b(a aVar) {
        int i2 = aVar.j;
        aVar.j = i2 - 1;
        return i2;
    }

    static /* synthetic */ int f(a aVar) {
        int i2 = aVar.l;
        aVar.l = i2 - 1;
        return i2;
    }

    static /* synthetic */ int i(a aVar) {
        int i2 = aVar.m;
        aVar.m = i2 - 1;
        return i2;
    }

    static /* synthetic */ int o(a aVar) {
        int i2 = aVar.k;
        aVar.k = i2 - 1;
        return i2;
    }

    public a(b bVar) {
        this.p = bVar;
    }

    public void a(Context context, int i2) {
        c.a("init sdk : appId" + i2);
        TIMManager.getInstance().init(context, new TIMSdkConfig(i2).enableCrashReport(false).enableLogPrint(false).setLogLevel(TIMLogLevel.OFF));
        TIMManager.getInstance().setUserConfig(new TIMUserConfig().setUserStatusListener(new TIMUserStatusListener() {
            public void onForceOffline() {
                if (a.this.p != null) {
                    a.this.p.c();
                }
            }

            public void onUserSigExpired() {
                if (a.this.p != null) {
                    a.this.p.d();
                }
            }
        }));
    }

    public void a(b bVar) {
        this.f29517b = bVar.f29543d;
        this.f29519d = bVar.f29546g;
        this.f29520e = bVar.h;
        this.f29518c = bVar.i;
        this.f29521f = bVar.j;
        this.f29522g = bVar.k;
    }

    public void a() {
        String str = this.f29517b;
        if (str != null) {
            String str2 = this.f29519d;
            if (str2 != null) {
                a(str, str2, new C0449a() {
                    public void a(int i, String str) {
                        a.b(a.this);
                        if (a.this.j >= 0) {
                            a.this.a();
                            return;
                        }
                        c.b("login failed: " + i + ", " + str);
                        if (a.this.p != null) {
                            a.this.p.b();
                        }
                    }

                    public void a() {
                        c.a("chat room login success");
                        if (a.this.p != null) {
                            a.this.p.a();
                        }
                        a.this.g();
                        if (a.this.o) {
                            AnonymousClass1 r0 = new C0449a() {
                                public void a(int i, String str) {
                                    c.b("join chat group error: " + i + ", " + str);
                                    a.f(a.this);
                                    if (a.this.l >= 0) {
                                        a.this.b(a.this.f29521f, "join chat group", this);
                                    }
                                    if (a.this.p != null) {
                                        if (a.this.l < 0) {
                                            a.this.p.b(a.this.f29521f);
                                        }
                                        a.this.p.c(a.this.f29521f);
                                    }
                                }

                                public void a() {
                                    c.a("join chat group success.");
                                    boolean unused = a.this.h = true;
                                    if (a.this.p != null) {
                                        a.this.p.a(a.this.f29521f);
                                    }
                                }
                            };
                            a aVar = a.this;
                            aVar.b(aVar.f29521f, "join chat group", r0);
                        }
                        AnonymousClass2 r02 = new C0449a() {
                            public void a(int i, String str) {
                                c.b("join issue group error: " + i + ", " + str);
                                a.i(a.this);
                                if (a.this.m >= 0) {
                                    a.this.b(a.this.f29522g, "join issue group", this);
                                }
                                if (a.this.p != null) {
                                    if (a.this.m < 0) {
                                        a.this.p.b(a.this.f29522g);
                                    }
                                    a.this.p.c(a.this.f29522g);
                                }
                            }

                            public void a() {
                                c.a("join issue group success.");
                                boolean unused = a.this.i = true;
                                if (a.this.p != null) {
                                    a.this.p.a(a.this.f29522g);
                                }
                            }
                        };
                        a aVar2 = a.this;
                        aVar2.b(aVar2.f29522g, "join issue group", r02);
                    }
                });
                return;
            }
        }
        c.b("should set userName and userSig first");
    }

    private void a(String str, String str2, final C0449a aVar) {
        TIMManager.getInstance().login(str, str2, new TIMCallBack() {
            public void onError(int i, String str) {
                c.b("login error: " + i + ", " + str);
                aVar.a(i, str);
            }

            public void onSuccess() {
                c.a("login success.");
                C0449a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(String str, String str2, final C0449a aVar) {
        TIMGroupManager.getInstance().applyJoinGroup(str, str2, new TIMCallBack() {
            public void onError(int i, String str) {
                C0449a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }

            public void onSuccess() {
                C0449a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
    }

    private void a(String str, final C0449a aVar) {
        TIMGroupManager.getInstance().quitGroup(str, new TIMCallBack() {
            public void onError(int i, String str) {
                C0449a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i, str);
                }
            }

            public void onSuccess() {
                C0449a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
    }

    public void b() {
        if (this.o) {
            a(this.f29521f, (C0449a) new C0449a() {
                public void a(int i, String str) {
                    c.b("quit chat group error: " + i + ", " + str);
                }

                public void a() {
                    c.a("quit chat group success");
                    boolean unused = a.this.h = false;
                    if (!a.this.i) {
                        a.this.f();
                    }
                }
            });
        } else {
            this.h = false;
        }
        a(this.f29522g, (C0449a) new C0449a() {
            public void a(int i, String str) {
                c.b("quit issue group error: " + i + ", " + str);
            }

            public void a() {
                c.a("quit issue group success");
                boolean unused = a.this.i = false;
                if (!a.this.h) {
                    a.this.f();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void f() {
        TIMManager.getInstance().logout(new TIMCallBack() {
            public void onError(int i, String str) {
                c.b("logout error: " + i + ", " + str);
            }

            public void onSuccess() {
                c.b("logout success.");
            }
        });
    }

    public void c() {
        if (this.f29516a == null) {
            this.f29516a = new TIMMessageListener() {
                public boolean onNewMessages(List<TIMMessage> list) {
                    if (list == null) {
                        return false;
                    }
                    for (TIMMessage a2 : list) {
                        a.this.a(a2);
                    }
                    return false;
                }
            };
        }
        TIMManager.getInstance().addMessageListener(this.f29516a);
    }

    public void d() {
        if (this.f29516a != null) {
            TIMManager.getInstance().removeMessageListener(this.f29516a);
        }
    }

    public void e() {
        d();
        this.f29516a = null;
        this.p = null;
        b();
    }

    public void a(final String str) {
        TIMConversation conversation = TIMManager.getInstance().getConversation(TIMConversationType.Group, this.f29521f);
        TIMMessage tIMMessage = new TIMMessage();
        TIMTextElem tIMTextElem = new TIMTextElem();
        tIMTextElem.setText(str);
        if (tIMMessage.addElement(tIMTextElem) == 0) {
            conversation.sendMessage(tIMMessage, new TIMValueCallBack<TIMMessage>() {
                public void onError(int i, String str) {
                    c.b("send message failed. code: " + i + ", desc: " + str);
                    if (a.this.p != null) {
                        a.this.p.b(a.this.f29521f, str);
                    }
                }

                /* renamed from: a */
                public void onSuccess(TIMMessage tIMMessage) {
                    if (a.this.p != null) {
                        a.this.p.a(a.this.f29521f, str);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(TIMMessage tIMMessage) {
        String peer = tIMMessage.getConversation().getPeer();
        int i2 = 0;
        if (peer.equals(this.f29521f)) {
            if (this.o) {
                while (((long) i2) < tIMMessage.getElementCount()) {
                    TIMElem element = tIMMessage.getElement(i2);
                    if (element.getType() == TIMElemType.Text) {
                        String text = ((TIMTextElem) element).getText();
                        b bVar = this.p;
                        if (bVar != null) {
                            bVar.a(tIMMessage.getSenderProfile().getNickName(), tIMMessage.getSenderProfile().getFaceUrl(), text);
                        }
                    }
                    i2++;
                }
            }
        } else if (peer.equals(this.f29522g) && this.n) {
            while (((long) i2) < tIMMessage.getElementCount()) {
                TIMElem element2 = tIMMessage.getElement(i2);
                if (element2.getType() == TIMElemType.Custom) {
                    String a2 = a(((TIMCustomElem) element2).getData());
                    b bVar2 = this.p;
                    if (bVar2 != null) {
                        bVar2.d(a2);
                    }
                }
                i2++;
            }
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        TIMFriendshipManager.getInstance().modifyProfile(new TIMFriendshipManager.ModifyUserProfileParam().setNickname(this.f29520e).setFaceUrl(this.f29518c), new TIMCallBack() {
            public void onSuccess() {
            }

            public void onError(int i, String str) {
                c.b("setNickName failed. code: " + i + ", desc: " + str);
                a.o(a.this);
                if (a.this.k >= 0) {
                    a.this.g();
                }
            }
        });
    }

    public void a(boolean z) {
        this.n = z;
    }

    public void b(boolean z) {
        this.o = z;
    }

    private String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr);
    }
}
