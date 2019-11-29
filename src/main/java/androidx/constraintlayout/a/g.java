package androidx.constraintlayout.a;

final class g {

    interface a<T> {
        T a();

        void a(T[] tArr, int i);

        boolean a(T t);
    }

    static class b<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f1443a;

        /* renamed from: b  reason: collision with root package name */
        private int f1444b;

        b(int i) {
            if (i > 0) {
                this.f1443a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        public T a() {
            int i = this.f1444b;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            T[] tArr = this.f1443a;
            T t = tArr[i2];
            tArr[i2] = null;
            this.f1444b = i - 1;
            return t;
        }

        public boolean a(T t) {
            int i = this.f1444b;
            Object[] objArr = this.f1443a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.f1444b = i + 1;
            return true;
        }

        public void a(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                int i3 = this.f1444b;
                Object[] objArr = this.f1443a;
                if (i3 < objArr.length) {
                    objArr[i3] = t;
                    this.f1444b = i3 + 1;
                }
            }
        }
    }
}
