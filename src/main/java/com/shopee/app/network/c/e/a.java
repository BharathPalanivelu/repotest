package com.shopee.app.network.c.e;

import android.util.Pair;
import android.util.SparseArray;
import com.shopee.app.network.c.c;
import com.shopee.protocol.action.ResponseCommon;
import com.squareup.wire.Message;
import java.io.IOException;
import java.util.Arrays;

public class a extends c implements com.shopee.app.network.a.a<Message> {

    /* renamed from: a  reason: collision with root package name */
    private C0266a f17899a = new C0266a();

    public int a() {
        return 255;
    }

    public a() {
        c();
    }

    private void c() {
        this.f17899a.a(new com.shopee.app.network.c.e.b.a());
        this.f17899a.a(new com.shopee.app.network.c.e.a.a());
    }

    public void c(byte[] bArr, int i) throws IOException {
        byte b2 = bArr[0] & 255;
        byte b3 = bArr[1] & 255;
        com.garena.android.appkit.d.a.b("CMD_Extended [ServiceId: " + b2 + " | command: " + b3, new Object[0]);
        a(b2, b3, a(bArr));
    }

    private void a(int i, int i2, Pair<String, ? extends Message> pair) {
        b<? extends Message> a2 = this.f17899a.a(i, i2);
        if (a2 != null) {
            a2.a((String) pair.first, (Message) pair.second);
        }
    }

    public Pair<String, Message> a(byte[] bArr) throws IOException {
        b<? extends Message> a2 = this.f17899a.a(bArr[0] & 255, bArr[1] & 255);
        if (a2 != null) {
            return a2.a(Arrays.copyOfRange(bArr, 2, bArr.length));
        }
        return new Pair<>("UNKNOWN", new ResponseCommon.Builder().build());
    }

    /* renamed from: com.shopee.app.network.c.e.a$a  reason: collision with other inner class name */
    private static class C0266a {

        /* renamed from: a  reason: collision with root package name */
        private SparseArray<SparseArray<b<? extends Message>>> f17900a = new SparseArray<>();

        public void a(b<? extends Message> bVar) {
            SparseArray sparseArray = this.f17900a.get(bVar.b());
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.f17900a.put(bVar.b(), sparseArray);
            }
            sparseArray.put(bVar.a(), bVar);
        }

        public b<? extends Message> a(int i, int i2) {
            SparseArray sparseArray = this.f17900a.get(i);
            if (sparseArray != null) {
                return (b) sparseArray.get(i2);
            }
            return null;
        }
    }
}
