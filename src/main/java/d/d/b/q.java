package d.d.b;

import d.f.b;
import d.f.f;

public class q {
    public f a(m mVar) {
        return mVar;
    }

    public b a(Class cls) {
        return new e(cls);
    }

    public String a(k kVar) {
        return a((i) kVar);
    }

    public String a(i iVar) {
        String obj = iVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
