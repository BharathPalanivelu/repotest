package com.airbnb.lottie.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f3645a;

    /* renamed from: b  reason: collision with root package name */
    private f f3646b;

    public e(String... strArr) {
        this.f3645a = Arrays.asList(strArr);
    }

    private e(e eVar) {
        this.f3645a = new ArrayList(eVar.f3645a);
        this.f3646b = eVar.f3646b;
    }

    public e a(String str) {
        e eVar = new e(this);
        eVar.f3645a.add(str);
        return eVar;
    }

    public e a(f fVar) {
        e eVar = new e(this);
        eVar.f3646b = fVar;
        return eVar;
    }

    public f a() {
        return this.f3646b;
    }

    public boolean a(String str, int i) {
        if (b(str)) {
            return true;
        }
        if (i >= this.f3645a.size()) {
            return false;
        }
        if (this.f3645a.get(i).equals(str) || this.f3645a.get(i).equals("**") || this.f3645a.get(i).equals("*")) {
            return true;
        }
        return false;
    }

    public int b(String str, int i) {
        if (b(str)) {
            return 0;
        }
        if (!this.f3645a.get(i).equals("**")) {
            return 1;
        }
        if (i != this.f3645a.size() - 1 && this.f3645a.get(i + 1).equals(str)) {
            return 2;
        }
        return 0;
    }

    public boolean c(String str, int i) {
        if (i >= this.f3645a.size()) {
            return false;
        }
        boolean z = i == this.f3645a.size() - 1;
        String str2 = this.f3645a.get(i);
        if (!str2.equals("**")) {
            boolean z2 = str2.equals(str) || str2.equals("*");
            if ((z || (i == this.f3645a.size() - 2 && b())) && z2) {
                return true;
            }
            return false;
        }
        if (!z && this.f3645a.get(i + 1).equals(str)) {
            if (i == this.f3645a.size() - 2 || (i == this.f3645a.size() - 3 && b())) {
                return true;
            }
            return false;
        } else if (z) {
            return true;
        } else {
            int i2 = i + 1;
            if (i2 < this.f3645a.size() - 1) {
                return false;
            }
            return this.f3645a.get(i2).equals(str);
        }
    }

    public boolean d(String str, int i) {
        if (!str.equals("__container") && i >= this.f3645a.size() - 1 && !this.f3645a.get(i).equals("**")) {
            return false;
        }
        return true;
    }

    private boolean b(String str) {
        return str.equals("__container");
    }

    private boolean b() {
        List<String> list = this.f3645a;
        return list.get(list.size() - 1).equals("**");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f3645a);
        sb.append(",resolved=");
        sb.append(this.f3646b != null);
        sb.append('}');
        return sb.toString();
    }
}
