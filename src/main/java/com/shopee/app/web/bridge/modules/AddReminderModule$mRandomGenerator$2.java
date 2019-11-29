package com.shopee.app.web.bridge.modules;

import d.d.a.a;
import d.d.b.k;
import java.util.Random;

final class AddReminderModule$mRandomGenerator$2 extends k implements a<Random> {
    public static final AddReminderModule$mRandomGenerator$2 INSTANCE = new AddReminderModule$mRandomGenerator$2();

    AddReminderModule$mRandomGenerator$2() {
        super(0);
    }

    public final Random invoke() {
        return new Random(System.currentTimeMillis());
    }
}
