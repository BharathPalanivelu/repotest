package com.firebase.jobdispatcher;

import android.text.TextUtils;
import java.util.List;

public class aa implements v {

    /* renamed from: a  reason: collision with root package name */
    private final v f7185a;

    public aa(v vVar) {
        this.f7185a = vVar;
    }

    public List<String> a(r rVar) {
        return this.f7185a.a(rVar);
    }

    public final void b(r rVar) {
        a(a(rVar));
    }

    private static void a(List<String> list) {
        if (list != null) {
            throw new a("JobParameters is invalid", list);
        }
    }

    public static final class a extends RuntimeException {
        private final List<String> errors;

        public a(String str, List<String> list) {
            super(str + ": " + TextUtils.join("\n  - ", list));
            this.errors = list;
        }
    }
}
