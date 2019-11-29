package f;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import e.c;
import e.e;
import e.n;
import e.v;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

final class i<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final o<T, ?> f32919a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f32920b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f32921c;

    /* renamed from: d  reason: collision with root package name */
    private Call f32922d;

    /* renamed from: e  reason: collision with root package name */
    private Throwable f32923e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f32924f;

    i(o<T, ?> oVar, Object[] objArr) {
        this.f32919a = oVar;
        this.f32920b = objArr;
    }

    /* renamed from: f */
    public i<T> d() {
        return new i<>(this.f32919a, this.f32920b);
    }

    public synchronized Request e() {
        Call call = this.f32922d;
        if (call != null) {
            return call.request();
        } else if (this.f32923e == null) {
            try {
                Call g2 = g();
                this.f32922d = g2;
                return g2.request();
            } catch (RuntimeException e2) {
                e = e2;
                p.a(e);
                this.f32923e = e;
                throw e;
            } catch (Error e3) {
                e = e3;
                p.a(e);
                this.f32923e = e;
                throw e;
            } catch (IOException e4) {
                this.f32923e = e4;
                throw new RuntimeException("Unable to create request.", e4);
            }
        } else if (this.f32923e instanceof IOException) {
            throw new RuntimeException("Unable to create request.", this.f32923e);
        } else if (this.f32923e instanceof RuntimeException) {
            throw ((RuntimeException) this.f32923e);
        } else {
            throw ((Error) this.f32923e);
        }
    }

    public void a(final d<T> dVar) {
        Call call;
        Throwable th;
        p.a(dVar, "callback == null");
        synchronized (this) {
            if (!this.f32924f) {
                this.f32924f = true;
                call = this.f32922d;
                th = this.f32923e;
                if (call == null && th == null) {
                    try {
                        Call g2 = g();
                        this.f32922d = g2;
                        call = g2;
                    } catch (Throwable th2) {
                        th = th2;
                        p.a(th);
                        this.f32923e = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            dVar.onFailure(this, th);
            return;
        }
        if (this.f32921c) {
            call.cancel();
        }
        FirebasePerfOkHttpClient.enqueue(call, new Callback() {
            public void onResponse(Call call, Response response) {
                try {
                    try {
                        dVar.onResponse(i.this, i.this.a(response));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    a(th2);
                }
            }

            public void onFailure(Call call, IOException iOException) {
                a(iOException);
            }

            private void a(Throwable th) {
                try {
                    dVar.onFailure(i.this, th);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    public m<T> a() throws IOException {
        Call call;
        synchronized (this) {
            if (!this.f32924f) {
                this.f32924f = true;
                if (this.f32923e == null) {
                    call = this.f32922d;
                    if (call == null) {
                        try {
                            call = g();
                            this.f32922d = call;
                        } catch (IOException | Error | RuntimeException e2) {
                            p.a(e2);
                            this.f32923e = e2;
                            throw e2;
                        }
                    }
                } else if (this.f32923e instanceof IOException) {
                    throw ((IOException) this.f32923e);
                } else if (this.f32923e instanceof RuntimeException) {
                    throw ((RuntimeException) this.f32923e);
                } else {
                    throw ((Error) this.f32923e);
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.f32921c) {
            call.cancel();
        }
        return a(FirebasePerfOkHttpClient.execute(call));
    }

    private Call g() throws IOException {
        Call a2 = this.f32919a.a(this.f32920b);
        if (a2 != null) {
            return a2;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    /* access modifiers changed from: package-private */
    public m<T> a(Response response) throws IOException {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new b(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return m.a(p.a(body), build);
            } finally {
                body.close();
            }
        } else if (code == 204 || code == 205) {
            body.close();
            return m.a(null, build);
        } else {
            a aVar = new a(body);
            try {
                return m.a(this.f32919a.a((ResponseBody) aVar), build);
            } catch (RuntimeException e2) {
                aVar.a();
                throw e2;
            }
        }
    }

    public void b() {
        Call call;
        this.f32921c = true;
        synchronized (this) {
            call = this.f32922d;
        }
        if (call != null) {
            call.cancel();
        }
    }

    public boolean c() {
        boolean z = true;
        if (this.f32921c) {
            return true;
        }
        synchronized (this) {
            if (this.f32922d == null || !this.f32922d.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    static final class b extends ResponseBody {

        /* renamed from: a  reason: collision with root package name */
        private final MediaType f32930a;

        /* renamed from: b  reason: collision with root package name */
        private final long f32931b;

        b(MediaType mediaType, long j) {
            this.f32930a = mediaType;
            this.f32931b = j;
        }

        public MediaType contentType() {
            return this.f32930a;
        }

        public long contentLength() {
            return this.f32931b;
        }

        public e source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    static final class a extends ResponseBody {

        /* renamed from: a  reason: collision with root package name */
        IOException f32927a;

        /* renamed from: b  reason: collision with root package name */
        private final ResponseBody f32928b;

        a(ResponseBody responseBody) {
            this.f32928b = responseBody;
        }

        public MediaType contentType() {
            return this.f32928b.contentType();
        }

        public long contentLength() {
            return this.f32928b.contentLength();
        }

        public e source() {
            return n.a((v) new e.i(this.f32928b.source()) {
                public long read(c cVar, long j) throws IOException {
                    try {
                        return super.read(cVar, j);
                    } catch (IOException e2) {
                        a.this.f32927a = e2;
                        throw e2;
                    }
                }
            });
        }

        public void close() {
            this.f32928b.close();
        }

        /* access modifiers changed from: package-private */
        public void a() throws IOException {
            IOException iOException = this.f32927a;
            if (iOException != null) {
                throw iOException;
            }
        }
    }
}
