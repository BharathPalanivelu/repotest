package com.google.android.libraries.places.internal;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class hj {

    /* renamed from: a  reason: collision with root package name */
    public final String f6718a;

    public static boolean a(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int a(@NullableDecl Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static hj b(String str) {
        return new hj(str);
    }

    public hj(String str) {
        this.f6718a = (String) go.a(str);
    }

    public hj(hj hjVar) {
        this.f6718a = hjVar.f6718a;
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A a(A a2, Iterator<?> it) throws IOException {
        go.a(a2);
        if (it.hasNext()) {
            a2.append(a((Object) it.next()));
            while (it.hasNext()) {
                a2.append(this.f6718a);
                a2.append(a((Object) it.next()));
            }
        }
        return a2;
    }

    @CanIgnoreReturnValue
    public StringBuilder a(StringBuilder sb, Iterator<?> it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public String a(Iterable<?> iterable) {
        return a(iterable.iterator());
    }

    public String a(Iterator<?> it) {
        return a(new StringBuilder(), it).toString();
    }

    public hj a() {
        return new gn(this, this);
    }

    public jt a(String str) {
        return new jt(this, str, (byte) 0);
    }

    public CharSequence a(Object obj) {
        go.a(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public /* synthetic */ hj(hj hjVar, byte b2) {
        this(hjVar);
    }
}
