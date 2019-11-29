package com.shopee.app.util.q;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;
import java.util.List;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private final C0408e f26488a;

    private e(C0408e eVar) {
        this.f26488a = eVar;
    }

    public /* synthetic */ e(C0408e eVar, g gVar) {
        this(eVar);
    }

    public final C0408e a() {
        return this.f26488a;
    }

    public static final class d extends e {

        /* renamed from: a  reason: collision with root package name */
        private final String f26494a;

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof d) && j.a((Object) this.f26494a, (Object) ((d) obj).f26494a);
            }
            return true;
        }

        public int hashCode() {
            String str = this.f26494a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Title(title=" + this.f26494a + SQLBuilder.PARENTHESES_RIGHT;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(C0408e.TITLE, (g) null);
            j.b(str, "title");
            this.f26494a = str;
        }

        public final String b() {
            return this.f26494a;
        }
    }

    public static final class a extends e {

        /* renamed from: a  reason: collision with root package name */
        private final String f26489a;

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof a) && j.a((Object) this.f26489a, (Object) ((a) obj).f26489a);
            }
            return true;
        }

        public int hashCode() {
            String str = this.f26489a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Description(description=" + this.f26489a + SQLBuilder.PARENTHESES_RIGHT;
        }

        public final String b() {
            return this.f26489a;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(C0408e.DESCRIPTION, (g) null);
            j.b(str, "description");
            this.f26489a = str;
        }
    }

    public static final class c extends e {

        /* renamed from: a  reason: collision with root package name */
        private final int f26493a;

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof c) {
                    if (this.f26493a == ((c) obj).f26493a) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Integer.valueOf(this.f26493a).hashCode();
        }

        public String toString() {
            return "ImageCount(count=" + this.f26493a + SQLBuilder.PARENTHESES_RIGHT;
        }

        public final int b() {
            return this.f26493a;
        }

        public c(int i) {
            super(C0408e.IMAGE_COUNT, (g) null);
            this.f26493a = i;
        }
    }

    public static final class b extends e {

        /* renamed from: a  reason: collision with root package name */
        private final List<Integer> f26490a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f26491b;

        /* renamed from: c  reason: collision with root package name */
        private final int f26492c;

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (j.a((Object) this.f26490a, (Object) bVar.f26490a)) {
                        if (this.f26491b == bVar.f26491b) {
                            if (this.f26492c == bVar.f26492c) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            List<Integer> list = this.f26490a;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            boolean z = this.f26491b;
            if (z) {
                z = true;
            }
            return ((hashCode + (z ? 1 : 0)) * 31) + Integer.valueOf(this.f26492c).hashCode();
        }

        public String toString() {
            return "Dts(catIdPath=" + this.f26490a + ", preOrder=" + this.f26491b + ", days=" + this.f26492c + SQLBuilder.PARENTHESES_RIGHT;
        }

        public b(List<Integer> list, boolean z, int i) {
            super(C0408e.DTS, (g) null);
            this.f26490a = list;
            this.f26491b = z;
            this.f26492c = i;
        }

        public final List<Integer> b() {
            return this.f26490a;
        }

        public final boolean c() {
            return this.f26491b;
        }

        public final int d() {
            return this.f26492c;
        }
    }

    /* renamed from: com.shopee.app.util.q.e$e  reason: collision with other inner class name */
    public enum C0408e {
        TITLE("title"),
        DESCRIPTION("description"),
        IMAGES("image"),
        IMAGE_COUNT("image_count"),
        CATEGORY("category"),
        BRAND("brand"),
        DTS("date_to_ship"),
        PRICE("price"),
        STOCK("stock");

        private C0408e(String str) {
        }
    }
}
