package com.c.a.c.b;

import androidx.core.util.Pools;
import com.c.a.c.a.c;
import com.c.a.c.b.g;
import com.c.a.c.j;
import com.c.a.i.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<Data> f5859a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools.a<List<Throwable>> f5860b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends g<Data, ResourceType, Transcode>> f5861c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5862d;

    public q(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<g<Data, ResourceType, Transcode>> list, Pools.a<List<Throwable>> aVar) {
        this.f5859a = cls;
        this.f5860b = aVar;
        this.f5861c = (List) h.a(list);
        this.f5862d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public s<Transcode> a(c<Data> cVar, j jVar, int i, int i2, g.a<ResourceType> aVar) throws o {
        List acquire = this.f5860b.acquire();
        try {
            return a(cVar, jVar, i, i2, aVar, acquire);
        } finally {
            this.f5860b.release(acquire);
        }
    }

    private s<Transcode> a(c<Data> cVar, j jVar, int i, int i2, g.a<ResourceType> aVar, List<Throwable> list) throws o {
        List<Throwable> list2 = list;
        int size = this.f5861c.size();
        s<Transcode> sVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                sVar = ((g) this.f5861c.get(i3)).a(cVar, i, i2, jVar, aVar);
            } catch (o e2) {
                list2.add(e2);
            }
            if (sVar != null) {
                break;
            }
        }
        if (sVar != null) {
            return sVar;
        }
        throw new o(this.f5862d, (List<Throwable>) new ArrayList(list2));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadPath{decodePaths=");
        List<? extends g<Data, ResourceType, Transcode>> list = this.f5861c;
        sb.append(Arrays.toString(list.toArray(new g[list.size()])));
        sb.append('}');
        return sb.toString();
    }
}
