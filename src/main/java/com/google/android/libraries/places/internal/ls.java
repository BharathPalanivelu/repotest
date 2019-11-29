package com.google.android.libraries.places.internal;

final class ls implements lz {

    /* renamed from: a  reason: collision with root package name */
    private lz[] f12945a;

    ls(lz... lzVarArr) {
        this.f12945a = lzVarArr;
    }

    public final boolean a(Class<?> cls) {
        for (lz a2 : this.f12945a) {
            if (a2.a(cls)) {
                return true;
            }
        }
        return false;
    }

    public final ly b(Class<?> cls) {
        for (lz lzVar : this.f12945a) {
            if (lzVar.a(cls)) {
                return lzVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
