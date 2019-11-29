package com.tencent.qalsdk.core;

final class o extends Thread {
    o(n nVar) {
    }

    public final void run() {
        try {
            Thread.sleep(180000);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        l.a().removeConfig("LOGLEVEL_");
        l.a().removeConfig("LOGLEVELTIME");
    }
}
