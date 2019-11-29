package d.g;

import d.d.a.b;
import d.d.b.j;
import d.h.m;
import java.util.Iterator;

class g extends f {

    public static final class a implements Iterable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f32683a;

        public a(a aVar) {
            this.f32683a = aVar;
        }

        public Iterator<T> iterator() {
            return this.f32683a.a();
        }
    }

    public static final <T, R> a<R> a(a<? extends T> aVar, b<? super T, ? extends R> bVar) {
        j.b(aVar, "$this$map");
        j.b(bVar, "transform");
        return new h<>(aVar, bVar);
    }

    public static final <T, A extends Appendable> A a(a<? extends T> aVar, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, b<? super T, ? extends CharSequence> bVar) {
        j.b(aVar, "$this$joinTo");
        j.b(a2, "buffer");
        j.b(charSequence, "separator");
        j.b(charSequence2, "prefix");
        j.b(charSequence3, "postfix");
        j.b(charSequence4, "truncated");
        a2.append(charSequence2);
        Iterator<? extends T> a3 = aVar.a();
        int i2 = 0;
        while (a3.hasNext()) {
            Object next = a3.next();
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            m.a(a2, next, bVar);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(a aVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, b bVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
            charSequence2 = "";
        }
        CharSequence charSequence5 = charSequence2;
        if ((i2 & 4) != 0) {
            charSequence3 = "";
        }
        CharSequence charSequence6 = charSequence3;
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            bVar = null;
        }
        return b.a(aVar, charSequence, charSequence5, charSequence6, i3, charSequence7, bVar);
    }

    public static final <T> String a(a<? extends T> aVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, b<? super T, ? extends CharSequence> bVar) {
        j.b(aVar, "$this$joinToString");
        j.b(charSequence, "separator");
        j.b(charSequence2, "prefix");
        j.b(charSequence3, "postfix");
        j.b(charSequence4, "truncated");
        String sb = ((StringBuilder) b.a(aVar, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, bVar)).toString();
        j.a((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final <T> Iterable<T> a(a<? extends T> aVar) {
        j.b(aVar, "$this$asIterable");
        return new a(aVar);
    }
}
