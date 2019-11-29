package f;

import com.litesuits.orm.db.assit.SQLBuilder;

public class h extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final transient m<?> f32918a;
    private final int code;
    private final String message;

    private static String a(m<?> mVar) {
        p.a(mVar, "response == null");
        return "HTTP " + mVar.a() + SQLBuilder.BLANK + mVar.b();
    }

    public h(m<?> mVar) {
        super(a(mVar));
        this.code = mVar.a();
        this.message = mVar.b();
        this.f32918a = mVar;
    }
}
