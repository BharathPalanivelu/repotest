package com.airpay.paysdk.common.b;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.litesuits.orm.db.assit.SQLBuilder;
import g.a.a;
import java.util.ArrayList;

public class b extends a.C0509a {

    /* renamed from: b  reason: collision with root package name */
    private boolean f3963b = false;

    public void a(boolean z) {
        this.f3963b = z;
    }

    /* access modifiers changed from: protected */
    public String a(StackTraceElement stackTraceElement) {
        return super.a(stackTraceElement);
    }

    /* access modifiers changed from: protected */
    public boolean a(String str, int i) {
        return this.f3963b;
    }

    /* access modifiers changed from: protected */
    public void a(int i, String str, String str2, Throwable th) {
        ArrayList<String> a2 = a();
        super.a(i, a2.get(0), str2 + a2.get(1), th);
    }

    public ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 7) {
            arrayList.add(String.format("%1$s%2$s%3$s%4$s%5$s%6$s", new Object[]{a(stackTrace[7]), SimpleComparison.LESS_THAN_OPERATION, Thread.currentThread().getName(), SQLBuilder.BLANK, Long.valueOf(Thread.currentThread().getId()), SimpleComparison.GREATER_THAN_OPERATION}));
            arrayList.add(":" + SQLBuilder.PARENTHESES_LEFT + stackTrace[7].getFileName() + ":" + stackTrace[7].getLineNumber() + SQLBuilder.PARENTHESES_RIGHT);
            return arrayList;
        }
        throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
    }
}
