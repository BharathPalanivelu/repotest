package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.s.a;

public abstract class Id3Frame implements Metadata.Entry {

    /* renamed from: f  reason: collision with root package name */
    public final String f10873f;

    public int describeContents() {
        return 0;
    }

    public Id3Frame(String str) {
        this.f10873f = (String) a.a(str);
    }
}
