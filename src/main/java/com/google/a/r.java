package com.google.a;

import com.google.a.b.a;
import com.google.a.b.g;
import java.math.BigInteger;

public final class r extends l {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?>[] f8935a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: b  reason: collision with root package name */
    private Object f8936b;

    public r(Boolean bool) {
        a((Object) bool);
    }

    public r(Number number) {
        a((Object) number);
    }

    public r(String str) {
        a((Object) str);
    }

    r(Object obj) {
        a(obj);
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        if (obj instanceof Character) {
            this.f8936b = String.valueOf(((Character) obj).charValue());
            return;
        }
        a.a((obj instanceof Number) || b(obj));
        this.f8936b = obj;
    }

    public boolean a() {
        return this.f8936b instanceof Boolean;
    }

    /* access modifiers changed from: package-private */
    public Boolean p() {
        return (Boolean) this.f8936b;
    }

    public boolean h() {
        if (a()) {
            return p().booleanValue();
        }
        return Boolean.parseBoolean(c());
    }

    public boolean q() {
        return this.f8936b instanceof Number;
    }

    public Number b() {
        Object obj = this.f8936b;
        return obj instanceof String ? new g((String) obj) : (Number) obj;
    }

    public boolean r() {
        return this.f8936b instanceof String;
    }

    public String c() {
        if (q()) {
            return b().toString();
        }
        if (a()) {
            return p().toString();
        }
        return (String) this.f8936b;
    }

    public double d() {
        return q() ? b().doubleValue() : Double.parseDouble(c());
    }

    public float e() {
        return q() ? b().floatValue() : Float.parseFloat(c());
    }

    public long f() {
        return q() ? b().longValue() : Long.parseLong(c());
    }

    public int g() {
        return q() ? b().intValue() : Integer.parseInt(c());
    }

    private static boolean b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> isAssignableFrom : f8935a) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f8936b == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = b().longValue();
        } else {
            Object obj = this.f8936b;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(b().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f8936b == null) {
            if (rVar.f8936b == null) {
                return true;
            }
            return false;
        } else if (!a(this) || !a(rVar)) {
            if (!(this.f8936b instanceof Number) || !(rVar.f8936b instanceof Number)) {
                return this.f8936b.equals(rVar.f8936b);
            }
            double doubleValue = b().doubleValue();
            double doubleValue2 = rVar.b().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            if (!Double.isNaN(doubleValue) || !Double.isNaN(doubleValue2)) {
                return false;
            }
            return true;
        } else if (b().longValue() == rVar.b().longValue()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean a(r rVar) {
        Object obj = rVar.f8936b;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }
}
