package com.shopee.app.network.d;

import com.shopee.app.network.a.b;
import com.shopee.protocol.action.GetCoin;
import com.squareup.wire.Message;

public class w extends az implements b {
    public int b() {
        return 230;
    }

    public Message q_() {
        return new GetCoin.Builder().requestid(i().a()).build();
    }
}
