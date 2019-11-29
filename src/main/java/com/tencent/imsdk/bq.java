package com.tencent.imsdk;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class bq implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30782a;

    bq(IMMsfCoreProxy iMMsfCoreProxy) {
        this.f30782a = iMMsfCoreProxy;
    }

    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
