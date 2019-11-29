package io.b.e.h;

import io.b.o;
import java.io.Serializable;

public enum g {
    COMPLETE;

    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public String toString() {
        return "NotificationLite.Complete";
    }

    static final class b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e  reason: collision with root package name */
        final Throwable f33559e;

        b(Throwable th) {
            this.f33559e = th;
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f33559e + "]";
        }

        public int hashCode() {
            return this.f33559e.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return io.b.e.b.b.a((Object) this.f33559e, (Object) ((b) obj).f33559e);
            }
            return false;
        }
    }

    static final class c implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final org.e.b s;

        c(org.e.b bVar) {
            this.s = bVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.s + "]";
        }
    }

    static final class a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;

        /* renamed from: d  reason: collision with root package name */
        final io.b.b.b f33558d;

        a(io.b.b.b bVar) {
            this.f33558d = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f33558d + "]";
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object error(Throwable th) {
        return new b(th);
    }

    public static Object subscription(org.e.b bVar) {
        return new c(bVar);
    }

    public static Object disposable(io.b.b.b bVar) {
        return new a(bVar);
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isError(Object obj) {
        return obj instanceof b;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof c;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof a;
    }

    public static Throwable getError(Object obj) {
        return ((b) obj).f33559e;
    }

    public static org.e.b getSubscription(Object obj) {
        return ((c) obj).s;
    }

    public static io.b.b.b getDisposable(Object obj) {
        return ((a) obj).f33558d;
    }

    public static <T> boolean accept(Object obj, org.e.a<? super T> aVar) {
        if (obj == COMPLETE) {
            aVar.a();
            return true;
        } else if (obj instanceof b) {
            aVar.a(((b) obj).f33559e);
            return true;
        } else {
            aVar.a(obj);
            return false;
        }
    }

    public static <T> boolean accept(Object obj, o<? super T> oVar) {
        if (obj == COMPLETE) {
            oVar.a();
            return true;
        } else if (obj instanceof b) {
            oVar.a(((b) obj).f33559e);
            return true;
        } else {
            oVar.a(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, org.e.a<? super T> aVar) {
        if (obj == COMPLETE) {
            aVar.a();
            return true;
        } else if (obj instanceof b) {
            aVar.a(((b) obj).f33559e);
            return true;
        } else if (obj instanceof c) {
            aVar.a(((c) obj).s);
            return false;
        } else {
            aVar.a(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, o<? super T> oVar) {
        if (obj == COMPLETE) {
            oVar.a();
            return true;
        } else if (obj instanceof b) {
            oVar.a(((b) obj).f33559e);
            return true;
        } else if (obj instanceof a) {
            oVar.a(((a) obj).f33558d);
            return false;
        } else {
            oVar.a(obj);
            return false;
        }
    }
}
