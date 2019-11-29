package com.google.android.exoplayer2.p.e;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.s.a;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f11147a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11148b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f11149c;

    /* renamed from: d  reason: collision with root package name */
    public final long f11150d;

    /* renamed from: e  reason: collision with root package name */
    public final long f11151e;

    /* renamed from: f  reason: collision with root package name */
    public final e f11152f;

    /* renamed from: g  reason: collision with root package name */
    public final String f11153g;
    private final String[] h;
    private final HashMap<String, Integer> i;
    private final HashMap<String, Integer> j;
    private List<b> k;

    public static b a(String str) {
        return new b((String) null, d.a(str), -9223372036854775807L, -9223372036854775807L, (e) null, (String[]) null, "");
    }

    public static b a(String str, long j2, long j3, e eVar, String[] strArr, String str2) {
        return new b(str, (String) null, j2, j3, eVar, strArr, str2);
    }

    private b(String str, String str2, long j2, long j3, e eVar, String[] strArr, String str3) {
        this.f11147a = str;
        this.f11148b = str2;
        this.f11152f = eVar;
        this.h = strArr;
        this.f11149c = str2 != null;
        this.f11150d = j2;
        this.f11151e = j3;
        this.f11153g = (String) a.a(str3);
        this.i = new HashMap<>();
        this.j = new HashMap<>();
    }

    public boolean a(long j2) {
        return (this.f11150d == -9223372036854775807L && this.f11151e == -9223372036854775807L) || (this.f11150d <= j2 && this.f11151e == -9223372036854775807L) || ((this.f11150d == -9223372036854775807L && j2 < this.f11151e) || (this.f11150d <= j2 && j2 < this.f11151e));
    }

    public void a(b bVar) {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(bVar);
    }

    public b a(int i2) {
        List<b> list = this.k;
        if (list != null) {
            return list.get(i2);
        }
        throw new IndexOutOfBoundsException();
    }

    public int a() {
        List<b> list = this.k;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public long[] b() {
        TreeSet treeSet = new TreeSet();
        int i2 = 0;
        a((TreeSet<Long>) treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i2] = ((Long) it.next()).longValue();
            i2++;
        }
        return jArr;
    }

    private void a(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.f11147a);
        if (z || equals) {
            long j2 = this.f11150d;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
            long j3 = this.f11151e;
            if (j3 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j3));
            }
        }
        if (this.k != null) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                this.k.get(i2).a(treeSet, z || equals);
            }
        }
    }

    public List<com.google.android.exoplayer2.p.b> a(long j2, Map<String, e> map, Map<String, c> map2) {
        TreeMap treeMap = new TreeMap();
        a(j2, false, this.f11153g, (Map<String, SpannableStringBuilder>) treeMap);
        a(map, (Map<String, SpannableStringBuilder>) treeMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : treeMap.entrySet()) {
            c cVar = map2.get(entry.getKey());
            arrayList.add(new com.google.android.exoplayer2.p.b(a((SpannableStringBuilder) entry.getValue()), (Layout.Alignment) null, cVar.f11156c, cVar.f11157d, cVar.f11158e, cVar.f11155b, RNCartPanelDataEntity.NULL_VALUE, cVar.f11159f));
        }
        return arrayList;
    }

    private void a(long j2, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.i.clear();
        this.j.clear();
        String str2 = this.f11153g;
        if (!"".equals(str2)) {
            str = str2;
        }
        if (this.f11149c && z) {
            a(str, map).append(this.f11148b);
        } else if ("br".equals(this.f11147a) && z) {
            a(str, map).append(10);
        } else if (!"metadata".equals(this.f11147a) && a(j2)) {
            boolean equals = "p".equals(this.f11147a);
            for (Map.Entry next : map.entrySet()) {
                this.i.put(next.getKey(), Integer.valueOf(((SpannableStringBuilder) next.getValue()).length()));
            }
            for (int i2 = 0; i2 < a(); i2++) {
                a(i2).a(j2, z || equals, str, map);
            }
            if (equals) {
                d.a(a(str, map));
            }
            for (Map.Entry next2 : map.entrySet()) {
                this.j.put(next2.getKey(), Integer.valueOf(((SpannableStringBuilder) next2.getValue()).length()));
            }
        }
    }

    private static SpannableStringBuilder a(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return map.get(str);
    }

    private void a(Map<String, e> map, Map<String, SpannableStringBuilder> map2) {
        for (Map.Entry next : this.j.entrySet()) {
            String str = (String) next.getKey();
            a(map, map2.get(str), this.i.containsKey(str) ? this.i.get(str).intValue() : 0, ((Integer) next.getValue()).intValue());
            for (int i2 = 0; i2 < a(); i2++) {
                a(i2).a(map, map2);
            }
        }
    }

    private void a(Map<String, e> map, SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        if (i2 != i3) {
            e a2 = d.a(this.f11152f, this.h, map);
            if (a2 != null) {
                d.a(spannableStringBuilder, i2, i3, a2);
            }
        }
    }

    private SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder) {
        int i2;
        int i3;
        int i4 = 0;
        int length = spannableStringBuilder.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (spannableStringBuilder.charAt(i5) == ' ') {
                int i6 = i5 + 1;
                int i7 = i6;
                while (i7 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i7) == ' ') {
                    i7++;
                }
                int i8 = i7 - i6;
                if (i8 > 0) {
                    spannableStringBuilder.delete(i5, i5 + i8);
                    length -= i8;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        int i9 = 0;
        while (true) {
            i2 = length - 1;
            if (i9 >= i2) {
                break;
            }
            if (spannableStringBuilder.charAt(i9) == 10) {
                int i10 = i9 + 1;
                if (spannableStringBuilder.charAt(i10) == ' ') {
                    spannableStringBuilder.delete(i10, i9 + 2);
                    length--;
                }
            }
            i9++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i2) == ' ') {
            spannableStringBuilder.delete(i2, length);
            length--;
        }
        while (true) {
            i3 = length - 1;
            if (i4 >= i3) {
                break;
            }
            if (spannableStringBuilder.charAt(i4) == ' ') {
                int i11 = i4 + 1;
                if (spannableStringBuilder.charAt(i11) == 10) {
                    spannableStringBuilder.delete(i4, i11);
                    length--;
                }
            }
            i4++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i3) == 10) {
            spannableStringBuilder.delete(i3, length);
        }
        return spannableStringBuilder;
    }
}
