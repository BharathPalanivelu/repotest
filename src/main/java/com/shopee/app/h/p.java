package com.shopee.app.h;

import com.facebook.common.util.UriUtil;
import com.shopee.app.data.store.ServerConfigStore;
import com.shopee.app.data.viewmodel.ServerData;
import com.shopee.app.util.af;
import com.shopee.app.util.bh;
import com.shopee.app.util.i;
import java.util.ArrayList;
import java.util.List;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private final ServerConfigStore f17691a;

    /* renamed from: b  reason: collision with root package name */
    private final bh f17692b;

    /* renamed from: c  reason: collision with root package name */
    private int f17693c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f17694d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f17695e = 0;

    public p(ServerConfigStore serverConfigStore, bh bhVar) {
        this.f17691a = serverConfigStore;
        this.f17692b = bhVar;
    }

    public void a() {
        if (this.f17692b.a() - this.f17691a.getLastUsedTime() > 10800) {
            this.f17691a.setConnectionURL(i.f7039b);
            this.f17691a.setFileServerURL("f.shopee.co.id:18080");
            this.f17691a.setImageSearchUploadServerURL("cf.imagesearch.shopee.co.id:18080");
            this.f17691a.setLastUsedTime(this.f17692b.a());
        }
    }

    public synchronized String b() {
        return this.f17691a.getConnectionURL();
    }

    public synchronized String c() {
        return this.f17691a.getFileServerURL();
    }

    public synchronized String d() {
        return this.f17691a.getImageSearchUploadServerURL();
    }

    public synchronized void e() {
        for (ServerData next : this.f17691a.getServerData()) {
            List<ServerData.ServerInfo> a2 = a(next.getServers());
            if ("connection".equals(next.getKey()) && a2 != null && !a2.isEmpty()) {
                this.f17693c %= a2.size();
                this.f17691a.setConnectionURL(a2.get(this.f17693c).getURL());
                this.f17691a.setLastUsedTime(this.f17692b.a());
                this.f17693c++;
            }
        }
    }

    public synchronized void f() {
        for (ServerData next : this.f17691a.getServerData()) {
            List<ServerData.ServerInfo> a2 = a(next.getServers());
            if (UriUtil.LOCAL_FILE_SCHEME.equals(next.getKey()) && a2 != null && !a2.isEmpty()) {
                this.f17694d %= a2.size();
                this.f17691a.setFileServerURL(a2.get(this.f17694d).getURL());
                this.f17691a.setLastUsedTime(this.f17692b.a());
                this.f17694d++;
            }
        }
    }

    public synchronized void g() {
        for (ServerData next : this.f17691a.getServerData()) {
            List<ServerData.ServerInfo> a2 = a(next.getServers());
            if ("imageSearchUpload".equals(next.getKey()) && a2 != null && !a2.isEmpty()) {
                this.f17695e %= a2.size();
                this.f17691a.setImageSearchUploadServerURL(a2.get(this.f17695e).getURL());
                this.f17691a.setLastUsedTime(this.f17692b.a());
                this.f17695e++;
            }
        }
    }

    private synchronized List<ServerData.ServerInfo> a(List<ServerData.ServerInfo> list) {
        if (af.a(list)) {
            return new ArrayList();
        }
        return af.a(list, new af.a<ServerData.ServerInfo>() {
            /* renamed from: a */
            public boolean shouldInclude(ServerData.ServerInfo serverInfo) {
                return serverInfo.getCountry() != null && serverInfo.getCountry().equals("ID");
            }
        });
    }
}
