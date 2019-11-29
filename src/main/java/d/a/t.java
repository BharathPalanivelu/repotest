package d.a;

import com.facebook.share.internal.ShareConstants;
import d.d.a.b;
import d.d.b.j;
import d.h.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

class t extends s {

    public static final class a implements d.g.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterable f32649a;

        public a(Iterable iterable) {
            this.f32649a = iterable;
        }

        public Iterator<T> a() {
            return this.f32649a.iterator();
        }
    }

    public static final <T> T c(List<? extends T> list) {
        j.b(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> T a(List<? extends T> list, int i) {
        j.b(list, "$this$getOrNull");
        if (i < 0 || i > j.a(list)) {
            return null;
        }
        return list.get(i);
    }

    public static final <T> T a(Iterable<? extends T> iterable) {
        j.b(iterable, "$this$last");
        if (iterable instanceof List) {
            return j.d((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T d(List<? extends T> list) {
        j.b(list, "$this$last");
        if (!list.isEmpty()) {
            return list.get(j.a(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T b(Iterable<? extends T> iterable) {
        j.b(iterable, "$this$single");
        if (iterable instanceof List) {
            return j.e((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T e(List<? extends T> list) {
        j.b(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static final <T> List<T> b(Iterable<? extends T> iterable, int i) {
        ArrayList arrayList;
        j.b(iterable, "$this$drop");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        } else if (i == 0) {
            return j.c(iterable);
        } else {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                int size = collection.size() - i;
                if (size <= 0) {
                    return j.a();
                }
                if (size == 1) {
                    return j.a(j.a(iterable));
                }
                arrayList = new ArrayList(size);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        int size2 = collection.size();
                        while (i < size2) {
                            arrayList.add(((List) iterable).get(i));
                            i++;
                        }
                    } else {
                        Iterator listIterator = ((List) iterable).listIterator(i);
                        while (listIterator.hasNext()) {
                            arrayList.add(listIterator.next());
                        }
                    }
                    return arrayList;
                }
            } else {
                arrayList = new ArrayList();
            }
            for (Object next : iterable) {
                if (i2 >= i) {
                    arrayList.add(next);
                } else {
                    i2++;
                }
            }
            return j.b(arrayList);
        }
    }

    public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> iterable, C c2) {
        j.b(iterable, "$this$toCollection");
        j.b(c2, ShareConstants.DESTINATION);
        for (Object add : iterable) {
            c2.add(add);
        }
        return c2;
    }

    public static final <T> List<T> c(Iterable<? extends T> iterable) {
        j.b(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return j.b(j.d(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return j.a();
        }
        if (size != 1) {
            return j.b(collection);
        }
        return j.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> d(Iterable<? extends T> iterable) {
        j.b(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return j.b((Collection) iterable);
        }
        return (List) j.a(iterable, new ArrayList());
    }

    public static final <T> List<T> b(Collection<? extends T> collection) {
        j.b(collection, "$this$toMutableList");
        return new ArrayList<>(collection);
    }

    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, b<? super T, ? extends CharSequence> bVar) {
        j.b(iterable, "$this$joinTo");
        j.b(a2, "buffer");
        j.b(charSequence, "separator");
        j.b(charSequence2, "prefix");
        j.b(charSequence3, "postfix");
        j.b(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (Object next : iterable) {
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

    public static /* synthetic */ String a(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, b bVar, int i2, Object obj) {
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
        return j.a(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, bVar);
    }

    public static final <T> String a(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, b<? super T, ? extends CharSequence> bVar) {
        j.b(iterable, "$this$joinToString");
        j.b(charSequence, "separator");
        j.b(charSequence2, "prefix");
        j.b(charSequence3, "postfix");
        j.b(charSequence4, "truncated");
        String sb = ((StringBuilder) j.a(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, bVar)).toString();
        j.a((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final <T> d.g.a<T> e(Iterable<? extends T> iterable) {
        j.b(iterable, "$this$asSequence");
        return new a(iterable);
    }
}
