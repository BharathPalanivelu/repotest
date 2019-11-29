package com.modiface.mfemakeupkit.utils;

import android.graphics.Color;
import com.google.a.f;
import com.google.a.g;
import com.google.a.w;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;

public class o {

    public static final class a extends w<Integer> {
        /* renamed from: a */
        public void write(com.google.a.d.c cVar, Integer num) throws IOException {
            if (num == null) {
                num = 0;
            }
            double intValue = (double) num.intValue();
            Double.isNaN(intValue);
            cVar.a(intValue / 100.0d);
        }

        public Integer read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != com.google.a.d.b.NULL) {
                return Integer.valueOf((int) Math.round(aVar.k() * 100.0d));
            }
            aVar.j();
            return null;
        }
    }

    public static abstract class b extends w<Integer> {

        /* renamed from: a  reason: collision with root package name */
        private final String f15385a;

        protected b(String str) {
            this.f15385a = str;
        }

        /* renamed from: a */
        public void write(com.google.a.d.c cVar, Integer num) throws IOException {
            if (num == null) {
                num = 0;
            }
            cVar.a((Number) num);
            int red = Color.red(num.intValue());
            int green = Color.green(num.intValue());
            int blue = Color.blue(num.intValue());
            int alpha = Color.alpha(num.intValue());
            cVar.a(this.f15385a + "R");
            cVar.a((long) red);
            cVar.a(this.f15385a + "G");
            cVar.a((long) green);
            cVar.a(this.f15385a + "B");
            cVar.a((long) blue);
            cVar.a(this.f15385a + "A");
            cVar.a((long) alpha);
        }

        public Integer read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != com.google.a.d.b.NULL) {
                return Integer.valueOf(aVar.m());
            }
            aVar.j();
            return null;
        }
    }

    public static abstract class c<T extends Enum<T>> extends w<T> {

        /* renamed from: a  reason: collision with root package name */
        private final String f15386a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f15387b;

        protected c(String str, Class<T> cls) {
            this.f15386a = str;
            this.f15387b = cls;
        }

        /* renamed from: a */
        public void write(com.google.a.d.c cVar, T t) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f15386a);
            sb.append(t != null ? t.name() : "Custom");
            cVar.b(sb.toString());
        }

        public T read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            String h = aVar.h();
            if (h.startsWith(this.f15386a)) {
                h = h.replaceFirst(this.f15386a, "");
            }
            Iterator it = EnumSet.allOf(this.f15387b).iterator();
            while (it.hasNext()) {
                T t = (Enum) it.next();
                if (t.name().equals(h)) {
                    return t;
                }
            }
            return null;
        }
    }

    public static f a() {
        return new g().a().d();
    }
}
