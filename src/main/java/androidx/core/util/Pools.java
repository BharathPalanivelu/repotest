package androidx.core.util;

public final class Pools {

    public interface a<T> {
        T acquire();

        boolean release(T t);
    }

    public static class SimplePool<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f1877a;

        /* renamed from: b  reason: collision with root package name */
        private int f1878b;

        public SimplePool(int i) {
            if (i > 0) {
                this.f1877a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        public T acquire() {
            int i = this.f1878b;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            T[] tArr = this.f1877a;
            T t = tArr[i2];
            tArr[i2] = null;
            this.f1878b = i - 1;
            return t;
        }

        public boolean release(T t) {
            if (!a(t)) {
                int i = this.f1878b;
                Object[] objArr = this.f1877a;
                if (i >= objArr.length) {
                    return false;
                }
                objArr[i] = t;
                this.f1878b = i + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }

        private boolean a(T t) {
            for (int i = 0; i < this.f1878b; i++) {
                if (this.f1877a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class b<T> extends SimplePool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f1879a = new Object();

        public b(int i) {
            super(i);
        }

        public T acquire() {
            T acquire;
            synchronized (this.f1879a) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public boolean release(T t) {
            boolean release;
            synchronized (this.f1879a) {
                release = super.release(t);
            }
            return release;
        }
    }
}
