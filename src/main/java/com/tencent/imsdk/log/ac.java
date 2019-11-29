package com.tencent.imsdk.log;

import java.io.File;
import java.util.Comparator;

final class ac implements Comparator<File> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ab f31095a;

    ac(ab abVar) {
        this.f31095a = abVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((File) obj).lastModified() > ((File) obj2).lastModified() ? 1 : 0;
    }
}
