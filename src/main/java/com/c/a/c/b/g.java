package com.c.a.c.b;

import android.util.Log;
import androidx.core.util.Pools;
import com.c.a.c.a.c;
import com.c.a.c.d.f.d;
import com.c.a.c.j;
import com.c.a.c.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class g<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f5802a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends k<DataType, ResourceType>> f5803b;

    /* renamed from: c  reason: collision with root package name */
    private final d<ResourceType, Transcode> f5804c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools.a<List<Throwable>> f5805d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5806e;

    interface a<ResourceType> {
        s<ResourceType> a(s<ResourceType> sVar);
    }

    public g(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends k<DataType, ResourceType>> list, d<ResourceType, Transcode> dVar, Pools.a<List<Throwable>> aVar) {
        this.f5802a = cls;
        this.f5803b = list;
        this.f5804c = dVar;
        this.f5805d = aVar;
        this.f5806e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public s<Transcode> a(c<DataType> cVar, int i, int i2, j jVar, a<ResourceType> aVar) throws o {
        return this.f5804c.a(aVar.a(a(cVar, i, i2, jVar)), jVar);
    }

    private s<ResourceType> a(c<DataType> cVar, int i, int i2, j jVar) throws o {
        List acquire = this.f5805d.acquire();
        try {
            return a(cVar, i, i2, jVar, (List<Throwable>) acquire);
        } finally {
            this.f5805d.release(acquire);
        }
    }

    private s<ResourceType> a(c<DataType> cVar, int i, int i2, j jVar, List<Throwable> list) throws o {
        int size = this.f5803b.size();
        s<ResourceType> sVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            k kVar = (k) this.f5803b.get(i3);
            try {
                if (kVar.a(cVar.a(), jVar)) {
                    sVar = kVar.a(cVar.a(), i, i2, jVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + kVar, e2);
                }
                list.add(e2);
            }
            if (sVar != null) {
                break;
            }
        }
        if (sVar != null) {
            return sVar;
        }
        throw new o(this.f5806e, (List<Throwable>) new ArrayList(list));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f5802a + ", decoders=" + this.f5803b + ", transcoder=" + this.f5804c + '}';
    }
}
