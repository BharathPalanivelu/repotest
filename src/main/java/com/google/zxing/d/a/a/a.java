package com.google.zxing.d.a.a;

import java.util.List;

final class a {
    static com.google.zxing.c.a a(List<b> list) {
        int size = (list.size() * 2) - 1;
        if (list.get(list.size() - 1).b() == null) {
            size--;
        }
        com.google.zxing.c.a aVar = new com.google.zxing.c.a(size * 12);
        int a2 = list.get(0).b().a();
        int i = 0;
        for (int i2 = 11; i2 >= 0; i2--) {
            if (((1 << i2) & a2) != 0) {
                aVar.b(i);
            }
            i++;
        }
        for (int i3 = 1; i3 < list.size(); i3++) {
            b bVar = list.get(i3);
            int a3 = bVar.a().a();
            int i4 = i;
            for (int i5 = 11; i5 >= 0; i5--) {
                if (((1 << i5) & a3) != 0) {
                    aVar.b(i4);
                }
                i4++;
            }
            if (bVar.b() != null) {
                int a4 = bVar.b().a();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & a4) != 0) {
                        aVar.b(i4);
                    }
                    i4++;
                }
            }
            i = i4;
        }
        return aVar;
    }
}
