package com.shopee.app.react.modules.ui.product;

import android.app.Dialog;
import android.content.Context;
import com.shopee.app.ui.common.a.c;
import com.shopee.app.web.protocol.AddCartMessage;

public interface e {
    void a(Dialog dialog);

    void a(c.b bVar);

    void a(String str);

    void b(String str);

    void c(String str);

    boolean c();

    void d();

    void d(AddCartMessage addCartMessage);

    void e();

    void f();

    Context getContext();
}
