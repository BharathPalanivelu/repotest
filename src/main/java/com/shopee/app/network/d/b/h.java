package com.shopee.app.network.d.b;

import android.util.Base64;
import com.shopee.app.h.o;
import com.shopee.app.network.a.b;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.ContactMeta;
import com.shopee.protocol.action.UpdateContacts;
import com.squareup.wire.Message;
import e.f;
import java.util.List;

public class h extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private List<ContactMeta> f18155a;

    /* renamed from: b  reason: collision with root package name */
    private List<ContactMeta> f18156b;

    /* renamed from: c  reason: collision with root package name */
    private List<ContactMeta> f18157c;

    /* renamed from: d  reason: collision with root package name */
    private List<ContactMeta> f18158d;

    /* renamed from: e  reason: collision with root package name */
    private List<ContactMeta> f18159e;

    /* renamed from: f  reason: collision with root package name */
    private List<ContactMeta> f18160f;

    /* renamed from: g  reason: collision with root package name */
    private String f18161g;
    private byte[] h;

    public int b() {
        return 110;
    }

    public void a(List<ContactMeta> list) {
        this.f18155a = list;
    }

    public void b(List<ContactMeta> list) {
        this.f18156b = list;
    }

    public void c(List<ContactMeta> list) {
        this.f18157c = list;
    }

    public void a(String str) {
        this.f18161g = str;
    }

    public void a(byte[] bArr) {
        this.h = bArr;
    }

    public int c() {
        List<ContactMeta> list = this.f18155a;
        int i = 0;
        if (list != null) {
            i = 0 + list.size();
        }
        List<ContactMeta> list2 = this.f18156b;
        if (list2 != null) {
            i += list2.size();
        }
        List<ContactMeta> list3 = this.f18157c;
        return list3 != null ? i + list3.size() : i;
    }

    /* access modifiers changed from: protected */
    public void f() {
        super.f();
        o.a().a((az) this);
    }

    public Message q_() {
        UpdateContacts.Builder builder = new UpdateContacts.Builder();
        builder.requestid(i().a()).add_phone(this.f18155a).add_email(this.f18157c).add_facebookid(this.f18156b).remove_email(this.f18160f).remove_facebookid(this.f18159e).remove_phone(this.f18158d).device_fingerprint(f.a(this.h)).deviceid(f.a(Base64.decode(this.f18161g, 0)));
        return builder.build();
    }
}
