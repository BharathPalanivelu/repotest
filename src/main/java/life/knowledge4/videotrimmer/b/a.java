package life.knowledge4.videotrimmer.b;

import android.media.MediaMetadataRetriever;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import life.knowledge4.videotrimmer.K4LVideoTrimmer;
import life.knowledge4.videotrimmer.c.a;

public class a extends a.C0531a {

    /* renamed from: a  reason: collision with root package name */
    private final String f33748a;

    /* renamed from: b  reason: collision with root package name */
    private final int f33749b;

    /* renamed from: c  reason: collision with root package name */
    private final int f33750c;

    /* renamed from: d  reason: collision with root package name */
    private final long f33751d;

    /* renamed from: e  reason: collision with root package name */
    private final WeakReference<C0530a> f33752e;

    /* renamed from: life.knowledge4.videotrimmer.b.a$a  reason: collision with other inner class name */
    public interface C0530a {
        void a(List<K4LVideoTrimmer.b> list);
    }

    public a(String str, int i, int i2, long j, C0530a aVar) {
        super("", 0, "");
        this.f33748a = str;
        this.f33749b = i;
        this.f33750c = i2;
        this.f33751d = j;
        this.f33752e = new WeakReference<>(aVar);
    }

    public void a() {
        ArrayList arrayList = new ArrayList();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(this.f33748a);
        mediaMetadataRetriever.release();
        int i = this.f33750c;
        int i2 = this.f33749b / 8;
        long j = (this.f33751d * 1000) / ((long) 8);
        int parseLong = (int) ((Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) * 1000) / j);
        for (int i3 = 0; i3 < parseLong; i3++) {
            K4LVideoTrimmer.b bVar = new K4LVideoTrimmer.b();
            bVar.f33742a = ((long) i3) * j;
            bVar.f33743b = i2;
            bVar.f33744c = i;
            arrayList.add(bVar);
        }
        C0530a aVar = (C0530a) this.f33752e.get();
        if (aVar != null) {
            aVar.a(arrayList);
        }
    }
}
