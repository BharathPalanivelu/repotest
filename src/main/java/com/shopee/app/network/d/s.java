package com.shopee.app.network.d;

import com.shopee.app.network.a.b;
import com.shopee.protocol.action.GetAttributeModel;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;

public class s extends az implements b {

    /* renamed from: a  reason: collision with root package name */
    private List<Integer> f18448a = new ArrayList();

    public int b() {
        return 237;
    }

    public void a(List<Integer> list) {
        this.f18448a.clear();
        this.f18448a.addAll(list);
        g();
    }

    public Message q_() {
        GetAttributeModel.Builder builder = new GetAttributeModel.Builder();
        builder.requestid(i().a()).catid(this.f18448a).country("ID").build();
        return builder.build();
    }
}
