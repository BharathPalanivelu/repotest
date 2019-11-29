package f;

import com.salesforce.android.chat.core.internal.liveagent.response.message.FileTransferMessage;
import f.c;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import okhttp3.Request;

final class g extends c.a {

    /* renamed from: a  reason: collision with root package name */
    final Executor f32907a;

    g(Executor executor) {
        this.f32907a = executor;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        if (a(type) != b.class) {
            return null;
        }
        final Type e2 = p.e(type);
        return new c<Object, b<?>>() {
            public Type a() {
                return e2;
            }

            /* renamed from: b */
            public b<Object> a(b<Object> bVar) {
                return new a(g.this.f32907a, bVar);
            }
        };
    }

    static final class a<T> implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        final Executor f32910a;

        /* renamed from: b  reason: collision with root package name */
        final b<T> f32911b;

        a(Executor executor, b<T> bVar) {
            this.f32910a = executor;
            this.f32911b = bVar;
        }

        public void a(final d<T> dVar) {
            p.a(dVar, "callback == null");
            this.f32911b.a(new d<T>() {
                public void onResponse(b<T> bVar, final m<T> mVar) {
                    a.this.f32910a.execute(new Runnable() {
                        public void run() {
                            if (a.this.f32911b.c()) {
                                dVar.onFailure(a.this, new IOException(FileTransferMessage.EVENT_TYPE_CANCELLED));
                            } else {
                                dVar.onResponse(a.this, mVar);
                            }
                        }
                    });
                }

                public void onFailure(b<T> bVar, final Throwable th) {
                    a.this.f32910a.execute(new Runnable() {
                        public void run() {
                            dVar.onFailure(a.this, th);
                        }
                    });
                }
            });
        }

        public m<T> a() throws IOException {
            return this.f32911b.a();
        }

        public void b() {
            this.f32911b.b();
        }

        public boolean c() {
            return this.f32911b.c();
        }

        /* renamed from: d */
        public b<T> clone() {
            return new a(this.f32910a, this.f32911b.d());
        }

        public Request e() {
            return this.f32911b.e();
        }
    }
}
