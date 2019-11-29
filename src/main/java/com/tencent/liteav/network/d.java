package com.tencent.liteav.network;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class d implements h {

    /* renamed from: a  reason: collision with root package name */
    private h f31758a = null;

    /* renamed from: b  reason: collision with root package name */
    private b f31759b = null;

    /* renamed from: c  reason: collision with root package name */
    private long f31760c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f31761d = 0;

    /* renamed from: e  reason: collision with root package name */
    private b f31762e = null;

    /* renamed from: f  reason: collision with root package name */
    private a f31763f;

    /* renamed from: g  reason: collision with root package name */
    private long f31764g = 0;
    private long h = 0;

    public interface a {
        void onSwitchFinish(TXIStreamDownloader tXIStreamDownloader, boolean z);
    }

    public void a(h hVar) {
        this.f31758a = hVar;
    }

    public d(a aVar) {
        this.f31763f = aVar;
    }

    public void a() {
        b bVar = this.f31759b;
        if (bVar != null) {
            bVar.b(0);
        }
        b bVar2 = this.f31762e;
        if (bVar2 != null) {
            bVar2.b(0);
        }
    }

    public void a(TXIStreamDownloader tXIStreamDownloader, TXIStreamDownloader tXIStreamDownloader2, long j, long j2, String str) {
        this.f31760c = tXIStreamDownloader.getCurrentTS();
        this.f31761d = tXIStreamDownloader.getLastIFrameTS();
        this.f31759b = new b(tXIStreamDownloader, this);
        this.f31759b.a((h) this);
        ((TXCFLVDownloader) tXIStreamDownloader).recvData(true);
        Vector vector = new Vector();
        vector.add(new e(str, false));
        tXIStreamDownloader2.setOriginUrl(str);
        ((TXCFLVDownloader) tXIStreamDownloader2).recvData(true);
        tXIStreamDownloader2.startDownload(vector, false, false, tXIStreamDownloader.mEnableMessage);
        this.f31762e = new b(tXIStreamDownloader2, this);
        this.f31762e.a(this.f31760c);
    }

    public void b() {
        this.f31759b.a((h) null);
        this.f31762e.a((h) this);
        this.f31759b = this.f31762e;
        this.f31762e = null;
        StringBuilder sb = new StringBuilder();
        sb.append(" stream_switch end at ");
        sb.append(this.f31760c);
        sb.append(" stop ts ");
        sb.append(this.h);
        sb.append(" start ts ");
        sb.append(this.f31764g);
        sb.append(" diff ts ");
        long j = this.h;
        long j2 = this.f31764g;
        sb.append(j > j2 ? j - j2 : j2 - j);
        TXCLog.w("TXCMultiStreamDownloader", sb.toString());
    }

    /* access modifiers changed from: package-private */
    public void a(TXIStreamDownloader tXIStreamDownloader, boolean z) {
        a aVar = this.f31763f;
        if (aVar != null) {
            aVar.onSwitchFinish(tXIStreamDownloader, z);
        }
    }

    /* access modifiers changed from: package-private */
    public long a(long j) {
        b bVar = this.f31759b;
        if (bVar != null) {
            bVar.b(this.f31760c);
        }
        TXCLog.w("TXCMultiStreamDownloader", " stream_switch delay stop begin from " + this.f31760c);
        return this.f31760c;
    }

    /* access modifiers changed from: package-private */
    public void b(long j) {
        this.f31764g = j;
    }

    /* access modifiers changed from: package-private */
    public void c(long j) {
        this.h = j;
    }

    public void onPullAudio(com.tencent.liteav.basic.structs.a aVar) {
        h hVar = this.f31758a;
        if (hVar != null) {
            hVar.onPullAudio(aVar);
        }
    }

    public void onPullNAL(TXSNALPacket tXSNALPacket) {
        this.f31760c = tXSNALPacket.pts;
        if (tXSNALPacket.nalType == 0) {
            this.f31761d = tXSNALPacket.pts;
        }
        h hVar = this.f31758a;
        if (hVar != null) {
            hVar.onPullNAL(tXSNALPacket);
        }
    }

    private static class b implements com.tencent.liteav.basic.c.a, h {

        /* renamed from: a  reason: collision with root package name */
        private final int f31765a = 2;

        /* renamed from: b  reason: collision with root package name */
        private long f31766b = 0;

        /* renamed from: c  reason: collision with root package name */
        private long f31767c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f31768d = 0;

        /* renamed from: e  reason: collision with root package name */
        private boolean f31769e = false;

        /* renamed from: f  reason: collision with root package name */
        private long f31770f = 0;

        /* renamed from: g  reason: collision with root package name */
        private long f31771g = 0;
        private long h = 0;
        private ArrayList<TXSNALPacket> i = new ArrayList<>();
        private ArrayList<com.tencent.liteav.basic.structs.a> j = new ArrayList<>();
        private TXIStreamDownloader k = null;
        private WeakReference<d> l;
        private h m;

        public b(TXIStreamDownloader tXIStreamDownloader, d dVar) {
            this.l = new WeakReference<>(dVar);
            this.k = tXIStreamDownloader;
            this.k.setListener(this);
        }

        public void a(long j2) {
            this.f31768d = 0;
            this.f31766b = j2;
            this.k.setListener(this);
            this.k.setNotifyListener(this);
        }

        public void b(long j2) {
            this.f31766b = 0;
            this.f31770f = j2;
            this.h = 0;
            this.f31771g = 0;
            TXIStreamDownloader tXIStreamDownloader = this.k;
            if (tXIStreamDownloader != null && this.f31770f == 0) {
                tXIStreamDownloader.stopDownload();
                this.k = null;
            }
        }

        public void a(h hVar) {
            this.m = hVar;
        }

        public void onPullAudio(com.tencent.liteav.basic.structs.a aVar) {
            if (this.f31766b > 0) {
                a(aVar);
            } else if (this.f31770f > 0) {
                b(aVar);
            } else {
                h hVar = this.m;
                if (hVar != null) {
                    hVar.onPullAudio(aVar);
                }
            }
        }

        public void onPullNAL(TXSNALPacket tXSNALPacket) {
            if (tXSNALPacket != null) {
                if (this.f31766b > 0) {
                    a(tXSNALPacket);
                } else if (this.f31770f > 0) {
                    b(tXSNALPacket);
                } else {
                    h hVar = this.m;
                    if (hVar != null) {
                        hVar.onPullNAL(tXSNALPacket);
                    }
                }
            }
        }

        private void a(com.tencent.liteav.basic.structs.a aVar) {
            if (aVar == null || aVar.f31401e < this.f31767c || aVar.f31401e < this.f31766b) {
                return;
            }
            if (this.m == null || this.f31767c <= 0 || aVar.f31401e < this.f31767c) {
                this.j.add(aVar);
            } else {
                this.m.onPullAudio(aVar);
            }
        }

        private void b(com.tencent.liteav.basic.structs.a aVar) {
            if (this.h <= 0) {
                if (this.f31771g <= 0 || aVar == null || aVar.f31401e < this.f31771g) {
                    h hVar = this.m;
                    if (hVar != null) {
                        hVar.onPullAudio(aVar);
                        return;
                    }
                    return;
                }
                this.h = aVar.f31401e;
            }
        }

        private void a(TXSNALPacket tXSNALPacket) {
            d dVar = (d) this.l.get();
            if (tXSNALPacket.nalType == 0 && !this.f31769e) {
                this.f31768d++;
                if (dVar != null && (dVar.f31761d <= tXSNALPacket.pts || this.f31768d == 2)) {
                    this.f31766b = dVar.a(tXSNALPacket.pts);
                    this.f31769e = true;
                }
                if (dVar != null) {
                    TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start begin gop " + this.f31768d + " last iframe ts " + dVar.f31761d + " pts " + tXSNALPacket.pts + " from " + this.f31766b + " type " + tXSNALPacket.nalType);
                }
            }
            if (this.f31769e) {
                if (dVar != null) {
                    dVar.b(tXSNALPacket.pts);
                }
                if (tXSNALPacket.pts >= this.f31766b) {
                    if (tXSNALPacket.nalType == 0 && this.f31767c == 0) {
                        this.f31767c = tXSNALPacket.pts;
                        TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start end " + tXSNALPacket.pts + " from " + this.f31766b + " type " + tXSNALPacket.nalType);
                    }
                    if (this.f31767c <= 0) {
                        return;
                    }
                    if (this.m != null) {
                        if (dVar != null) {
                            dVar.a(this.k, true);
                        }
                        if (!this.j.isEmpty()) {
                            Iterator<com.tencent.liteav.basic.structs.a> it = this.j.iterator();
                            while (it.hasNext()) {
                                com.tencent.liteav.basic.structs.a next = it.next();
                                if (next.f31401e >= this.f31767c) {
                                    TXCLog.i("TXCMultiStreamDownloader", " stream_switch pre start cache audio pts " + next.f31401e + " from " + this.f31767c);
                                    this.m.onPullAudio(next);
                                }
                            }
                            TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start end audio cache  " + this.j.size());
                            this.j.clear();
                        }
                        if (!this.i.isEmpty()) {
                            TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start end video cache  " + this.i.size());
                            Iterator<TXSNALPacket> it2 = this.i.iterator();
                            while (it2.hasNext()) {
                                this.m.onPullNAL(it2.next());
                            }
                            this.i.clear();
                        }
                        TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start first pull nal " + tXSNALPacket.pts + " from " + this.f31767c + " type " + tXSNALPacket.nalType);
                        this.m.onPullNAL(tXSNALPacket);
                        this.m = null;
                        this.k.setNotifyListener((com.tencent.liteav.basic.c.a) null);
                        return;
                    }
                    TXCLog.i("TXCMultiStreamDownloader", " stream_switch pre start cache video pts " + tXSNALPacket.pts + " from " + this.f31767c + " type " + tXSNALPacket.nalType);
                    this.i.add(tXSNALPacket);
                }
            }
        }

        private void b(TXSNALPacket tXSNALPacket) {
            d dVar = (d) this.l.get();
            if (dVar != null) {
                dVar.c(tXSNALPacket.pts);
            }
            if (tXSNALPacket.pts >= this.f31770f) {
                if (tXSNALPacket.nalType == 0) {
                    this.f31771g = tXSNALPacket.pts;
                }
                if (this.f31771g <= 0) {
                    h hVar = this.m;
                    if (hVar != null) {
                        hVar.onPullNAL(tXSNALPacket);
                    }
                } else if (this.h > 0) {
                    TXCLog.w("TXCMultiStreamDownloader", " stream_switch delay stop end video pts " + this.f31771g + " audio ts " + this.h + " from " + this.f31770f);
                    if (dVar != null) {
                        dVar.b();
                    }
                    this.m = null;
                    this.k.setListener((h) null);
                    this.k.stopDownload();
                } else {
                    TXCLog.w("TXCMultiStreamDownloader", " stream_switch delay stop video end wait audio end video pts " + tXSNALPacket.pts + " from " + this.f31770f + " type " + tXSNALPacket.nalType);
                }
            } else {
                h hVar2 = this.m;
                if (hVar2 != null) {
                    hVar2.onPullNAL(tXSNALPacket);
                }
            }
        }

        public void onNotifyEvent(int i2, Bundle bundle) {
            if (i2 == -2301 || i2 == 3010) {
                d dVar = (d) this.l.get();
                if (dVar != null) {
                    dVar.a(this.k, false);
                }
                this.k.setNotifyListener((com.tencent.liteav.basic.c.a) null);
            }
        }
    }
}
