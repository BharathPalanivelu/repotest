package io.a.a.a.a.c;

public enum e {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    static <Y> int a(i iVar, Y y) {
        e eVar;
        if (y instanceof i) {
            eVar = ((i) y).b();
        } else {
            eVar = NORMAL;
        }
        return eVar.ordinal() - iVar.b().ordinal();
    }
}
