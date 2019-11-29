package com.tencent.qalsdk.core;

import java.io.File;
import java.util.Comparator;

final class h implements Comparator<File> {
    h(g gVar) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((File) obj).lastModified() > ((File) obj2).lastModified() ? 1 : 0;
    }
}
