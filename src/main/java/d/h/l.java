package d.h;

import d.e.c;
import d.e.d;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

public final class l {
    /* access modifiers changed from: private */
    public static final i b(Matcher matcher, int i, CharSequence charSequence) {
        if (!matcher.find(i)) {
            return null;
        }
        return new j(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    public static final i b(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new j(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    public static final c b(MatchResult matchResult, int i) {
        return d.b(matchResult.start(i), matchResult.end(i));
    }
}
