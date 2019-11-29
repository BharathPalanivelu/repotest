package com.facebook.react.devsupport;

import com.tencent.qcloud.core.http.HttpConstants;
import e.c;
import e.e;
import e.f;
import e.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MultipartStreamReader {
    private static final String CRLF = "\r\n";
    private final String mBoundary;
    private long mLastProgressEvent;
    private final e mSource;

    public interface ChunkListener {
        void onChunkComplete(Map<String, String> map, c cVar, boolean z) throws IOException;

        void onChunkProgress(Map<String, String> map, long j, long j2) throws IOException;
    }

    public MultipartStreamReader(e eVar, String str) {
        this.mSource = eVar;
        this.mBoundary = str;
    }

    private Map<String, String> parseHeaders(c cVar) {
        HashMap hashMap = new HashMap();
        for (String str : cVar.s().split("\r\n")) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                hashMap.put(str.substring(0, indexOf).trim(), str.substring(indexOf + 1).trim());
            }
        }
        return hashMap;
    }

    private void emitChunk(c cVar, boolean z, ChunkListener chunkListener) throws IOException {
        f a2 = f.a("\r\n\r\n");
        long b2 = cVar.b(a2);
        if (b2 == -1) {
            chunkListener.onChunkComplete((Map<String, String>) null, cVar, z);
            return;
        }
        c cVar2 = new c();
        c cVar3 = new c();
        cVar.read(cVar2, b2);
        cVar.i((long) a2.h());
        cVar.a((u) cVar3);
        chunkListener.onChunkComplete(parseHeaders(cVar2), cVar3, z);
    }

    private void emitProgress(Map<String, String> map, long j, boolean z, ChunkListener chunkListener) throws IOException {
        if (map != null && chunkListener != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastProgressEvent > 16 || z) {
                this.mLastProgressEvent = currentTimeMillis;
                chunkListener.onChunkProgress(map, j, map.get(HttpConstants.Header.CONTENT_LENGTH) != null ? Long.parseLong(map.get(HttpConstants.Header.CONTENT_LENGTH)) : 0);
            }
        }
    }

    public boolean readAllParts(ChunkListener chunkListener) throws IOException {
        boolean z;
        f a2 = f.a("\r\n--" + this.mBoundary + "\r\n");
        f a3 = f.a("\r\n--" + this.mBoundary + "--" + "\r\n");
        f a4 = f.a("\r\n\r\n");
        c cVar = new c();
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        Map<String, String> map = null;
        while (true) {
            long max = Math.max(j - ((long) a3.h()), j2);
            long a5 = cVar.a(a2, max);
            if (a5 == -1) {
                a5 = cVar.a(a3, max);
                z = true;
            } else {
                z = false;
            }
            if (a5 == -1) {
                long a6 = cVar.a();
                if (map == null) {
                    long a7 = cVar.a(a4, max);
                    if (a7 >= 0) {
                        this.mSource.read(cVar, a7);
                        c cVar2 = new c();
                        cVar.a(cVar2, max, a7 - max);
                        j3 = cVar2.a() + ((long) a4.h());
                        map = parseHeaders(cVar2);
                    }
                } else {
                    emitProgress(map, cVar.a() - j3, false, chunkListener);
                }
                if (this.mSource.read(cVar, (long) 4096) <= 0) {
                    return false;
                }
                j = a6;
            } else {
                long j4 = a5 - j2;
                if (j2 > 0) {
                    c cVar3 = new c();
                    cVar.i(j2);
                    cVar.read(cVar3, j4);
                    emitProgress(map, cVar3.a() - j3, true, chunkListener);
                    emitChunk(cVar3, z, chunkListener);
                    j3 = 0;
                    map = null;
                } else {
                    ChunkListener chunkListener2 = chunkListener;
                    cVar.i(a5);
                }
                if (z) {
                    return true;
                }
                j2 = (long) a2.h();
                j = j2;
            }
        }
    }
}
