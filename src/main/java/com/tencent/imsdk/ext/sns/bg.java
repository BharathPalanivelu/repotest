package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;
import java.util.List;

final class bg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ List f31056a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt.ab f31057b;

    bg(TIMFriendshipManagerExt.ab abVar, List list) {
        this.f31057b = abVar;
        this.f31056a = list;
    }

    public final void run() {
        this.f31057b.a(this.f31056a);
    }
}
