package d.h;

import com.shopee.shopeetracker.bimodel.TrackingType;
import d.d.b.j;
import java.io.Serializable;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32711a = new a((g) null);
    private Set<? extends Object> _options;
    private final Pattern nativePattern;

    public k(Pattern pattern) {
        j.b(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public k(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            d.d.b.j.b(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            d.d.b.j.a((java.lang.Object) r2, (java.lang.String) r0)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.h.k.<init>(java.lang.String):void");
    }

    public final boolean a(CharSequence charSequence) {
        j.b(charSequence, TrackingType.INPUT);
        return this.nativePattern.matcher(charSequence).matches();
    }

    public static /* synthetic */ i a(k kVar, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return kVar.a(charSequence, i);
    }

    public final i a(CharSequence charSequence, int i) {
        j.b(charSequence, TrackingType.INPUT);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        j.a((Object) matcher, "nativePattern.matcher(input)");
        return l.b(matcher, i, charSequence);
    }

    public final i b(CharSequence charSequence) {
        j.b(charSequence, TrackingType.INPUT);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        j.a((Object) matcher, "nativePattern.matcher(input)");
        return l.b(matcher, charSequence);
    }

    public final String a(CharSequence charSequence, String str) {
        j.b(charSequence, TrackingType.INPUT);
        j.b(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        j.a((Object) replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        j.a((Object) pattern, "nativePattern.toString()");
        return pattern;
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        j.a((Object) pattern, "nativePattern.pattern()");
        return new b(pattern, this.nativePattern.flags());
    }

    private static final class b implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32712a = new a((g) null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(g gVar) {
                this();
            }
        }

        public b(String str, int i) {
            j.b(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            j.a((Object) compile, "Pattern.compile(pattern, flags)");
            return new k(compile);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
}
