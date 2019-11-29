package d.a;

import d.d.b.j;
import java.util.List;
import java.util.RandomAccess;

class g extends f {
    public static final <T> List<T> a(T[] tArr) {
        j.b(tArr, "$this$asList");
        List<T> a2 = i.a(tArr);
        j.a((Object) a2, "ArraysUtilJVM.asList(this)");
        return a2;
    }

    public static final class a extends b<Boolean> implements RandomAccess {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean[] f32648b;

        a(boolean[] zArr) {
            this.f32648b = zArr;
        }

        public final boolean contains(Object obj) {
            if (obj instanceof Boolean) {
                return a(((Boolean) obj).booleanValue());
            }
            return false;
        }

        public final int indexOf(Object obj) {
            if (obj instanceof Boolean) {
                return b(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        public final int lastIndexOf(Object obj) {
            if (obj instanceof Boolean) {
                return c(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        public int a() {
            return this.f32648b.length;
        }

        public boolean isEmpty() {
            return this.f32648b.length == 0;
        }

        public boolean a(boolean z) {
            return d.a(this.f32648b, z);
        }

        /* renamed from: a */
        public Boolean get(int i) {
            return Boolean.valueOf(this.f32648b[i]);
        }

        public int b(boolean z) {
            return d.b(this.f32648b, z);
        }

        public int c(boolean z) {
            return d.c(this.f32648b, z);
        }
    }

    public static final List<Boolean> a(boolean[] zArr) {
        j.b(zArr, "$this$asList");
        return new a(zArr);
    }
}
