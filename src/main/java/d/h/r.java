package d.h;

import d.d.a.b;
import d.d.b.j;

class r extends q {
    public static final <T> void a(Appendable appendable, T t, b<? super T, ? extends CharSequence> bVar) {
        j.b(appendable, "$this$appendElement");
        if (bVar != null) {
            appendable.append((CharSequence) bVar.a(t));
            return;
        }
        if (t != null ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
