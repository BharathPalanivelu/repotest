package d.h;

import com.shopee.shopeetracker.bimodel.TrackingType;
import d.d.a.b;
import d.d.b.k;
import d.e.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

final class j implements i {

    /* renamed from: a  reason: collision with root package name */
    private final g f32707a = new a(this);

    /* renamed from: b  reason: collision with root package name */
    private final Matcher f32708b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f32709c;

    public j(Matcher matcher, CharSequence charSequence) {
        d.d.b.j.b(matcher, "matcher");
        d.d.b.j.b(charSequence, TrackingType.INPUT);
        this.f32708b = matcher;
        this.f32709c = charSequence;
    }

    /* access modifiers changed from: private */
    public final MatchResult b() {
        return this.f32708b;
    }

    public static final class a extends d.a.a<f> implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f32710a;

        public boolean isEmpty() {
            return false;
        }

        /* renamed from: d.h.j$a$a  reason: collision with other inner class name */
        static final class C0499a extends k implements b<Integer, f> {
            final /* synthetic */ a this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0499a(a aVar) {
                super(1);
                this.this$0 = aVar;
            }

            public /* synthetic */ Object a(Object obj) {
                return a(((Number) obj).intValue());
            }

            public final f a(int i) {
                return this.this$0.a(i);
            }
        }

        a(j jVar) {
            this.f32710a = jVar;
        }

        public boolean a(f fVar) {
            return super.contains(fVar);
        }

        public final boolean contains(Object obj) {
            if (obj != null ? obj instanceof f : true) {
                return a((f) obj);
            }
            return false;
        }

        public int a() {
            return this.f32710a.b().groupCount() + 1;
        }

        public Iterator<f> iterator() {
            return d.g.b.a(d.a.j.e(d.a.j.a((Collection<?>) this)), new C0499a(this)).a();
        }

        public f a(int i) {
            c a2 = l.b(this.f32710a.b(), i);
            if (a2.f().intValue() < 0) {
                return null;
            }
            String group = this.f32710a.b().group(i);
            d.d.b.j.a((Object) group, "matchResult.group(index)");
            return new f(group, a2);
        }
    }

    public String a() {
        String group = b().group();
        d.d.b.j.a((Object) group, "matchResult.group()");
        return group;
    }
}
