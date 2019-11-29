package com.beetalk.sdk;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.beetalk.sdk.f;
import com.facebook.GraphResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class b implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    transient Activity f5380a;

    /* renamed from: b  reason: collision with root package name */
    transient a f5381b;

    /* renamed from: c  reason: collision with root package name */
    transient C0095b f5382c;
    c currentHandler;
    List<c> handlersToTry;
    a pendingRequest;

    /* renamed from: com.beetalk.sdk.b$b  reason: collision with other inner class name */
    interface C0095b {
        void a(c cVar);
    }

    public void a(final Activity activity) {
        this.f5380a = activity;
        this.f5381b = new a() {
            public void a(Intent intent, int i) {
                activity.startActivityForResult(intent, i);
            }

            public Activity a() {
                return activity;
            }
        };
    }

    public a a() {
        a aVar = this.f5381b;
        if (aVar != null) {
            return aVar;
        }
        if (this.pendingRequest != null) {
            return new a() {
                public void a(Intent intent, int i) {
                    b.this.pendingRequest.a().a(intent, i);
                }

                public Activity a() {
                    return b.this.pendingRequest.a().a();
                }
            };
        }
        return null;
    }

    public void a(a aVar) {
        if (this.pendingRequest == null || this.currentHandler == null) {
            b(aVar);
        } else {
            c();
        }
    }

    private void c() {
        com.beetalk.sdk.e.a.b("continueAuth()", new Object[0]);
        if (this.pendingRequest != null) {
            b();
        }
    }

    private void b(a aVar) {
        com.beetalk.sdk.e.a.b("commenceAuth()", new Object[0]);
        this.handlersToTry = c(aVar);
        this.pendingRequest = aVar;
        b();
    }

    /* access modifiers changed from: protected */
    public void b() {
        do {
            List<c> list = this.handlersToTry;
            if (list != null && !list.isEmpty()) {
                this.currentHandler = this.handlersToTry.remove(0);
                com.beetalk.sdk.e.a.b("try one handler", new Object[0]);
            } else if (this.pendingRequest != null) {
                com.beetalk.sdk.e.a.b("all handlers fail, auth fail", new Object[0]);
                d();
                return;
            } else {
                return;
            }
        } while (!e());
        com.beetalk.sdk.e.a.b("handler started, return", new Object[0]);
    }

    private void d() {
        a(c.a(this.pendingRequest, com.garena.pay.android.a.APP_NOT_INSTALLED.getCode().intValue()));
    }

    public void a(c cVar) {
        C0095b bVar = this.f5382c;
        if (bVar != null) {
            bVar.a(cVar);
        }
    }

    private boolean e() {
        return this.currentHandler.a(this.pendingRequest);
    }

    private List<c> c(a aVar) {
        f.b g2 = aVar.g();
        ArrayList arrayList = new ArrayList();
        if (g2 == f.b.FACEBOOK) {
            com.beetalk.sdk.e.a.b("add facebook auth handler", new Object[0]);
            arrayList.add(new e(this));
        } else if (g2 == f.b.BEETALK) {
            com.beetalk.sdk.e.a.b("add beetalk auth handler", new Object[0]);
            arrayList.add(new d(this));
            boolean d2 = aVar.d();
        } else if (g2 == f.b.GARENA) {
            com.beetalk.sdk.e.a.b("add garena auth handler", new Object[0]);
            arrayList.add(new i(this));
        } else if (g2 == f.b.GUEST) {
            com.beetalk.sdk.e.a.b("add guest auth handler", new Object[0]);
            arrayList.add(new j(this));
        } else if (g2 == f.b.REFRESH_TOKEN) {
            com.beetalk.sdk.e.a.b("add refresh token handler", new Object[0]);
            arrayList.add(new k(this));
        }
        return arrayList;
    }

    public void a(C0095b bVar) {
        this.f5382c = bVar;
    }

    public boolean a(int i, int i2, Intent intent) {
        if (i == this.pendingRequest.c()) {
            return this.currentHandler.a(i, i2, intent, this.pendingRequest);
        }
        return false;
    }

    public static class c implements Serializable {
        private static final long serialVersionUID = 1;
        final int errorCode;
        final String errorMessage;
        final String openId;
        final a request;
        final a resultCode;
        final com.beetalk.sdk.data.a token;

        public c(a aVar, a aVar2, com.beetalk.sdk.data.a aVar3, String str, int i, String str2) {
            this.resultCode = aVar2;
            this.token = aVar3;
            this.errorMessage = str;
            this.errorCode = i;
            this.request = aVar;
            this.openId = str2;
        }

        static c a(a aVar, com.beetalk.sdk.data.a aVar2, String str) {
            return new c(aVar, a.SUCCESS, aVar2, (String) null, 0, str);
        }

        static c a(a aVar, int i) {
            return a(aVar, "", "", i);
        }

        static c a(a aVar, String str, String str2, int i) {
            return new c(aVar, a.ERROR, (com.beetalk.sdk.data.a) null, TextUtils.join(": ", new String[]{str, str2}), i, (String) null);
        }

        public static boolean a(a aVar) {
            return aVar != a.SUCCESS;
        }

        enum a {
            SUCCESS(GraphResponse.SUCCESS_KEY),
            CANCEL("cancel"),
            ERROR("error");
            
            private final String value;

            private a(String str) {
                this.value = str;
            }
        }
    }

    public static class a implements Serializable {
        private static final long serialVersionUID = 1;

        /* renamed from: a  reason: collision with root package name */
        private final transient a f5386a;
        private String applicationId;
        private String applicationKey;
        private String authId;
        private boolean isLegacy;
        private com.beetalk.sdk.data.a mAuthToken;
        private f.b mSessionProvider;
        private ArrayList<String> permissions;
        private String redirectURI;
        private int requestCode;

        public a a() {
            return this.f5386a;
        }

        public String b() {
            return this.authId;
        }

        public int c() {
            return this.requestCode;
        }

        public boolean d() {
            return this.isLegacy;
        }

        public String e() {
            return this.applicationId;
        }

        public String f() {
            return this.applicationKey;
        }

        public f.b g() {
            return this.mSessionProvider;
        }

        public com.beetalk.sdk.data.a h() {
            return this.mAuthToken;
        }
    }
}
