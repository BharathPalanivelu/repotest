package com.tencent.qalsdk.sdk;

import java.io.PrintStream;

final class n extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ m f32267a;

    n(m mVar) {
        this.f32267a = mVar;
    }

    public final void run() {
        while (true) {
            try {
                String take = this.f32267a.f32262b.take();
                if (take != null) {
                    m.a(this.f32267a, take);
                }
            } catch (InterruptedException e2) {
                PrintStream printStream = System.out;
                printStream.println("write log file error." + e2);
            }
        }
    }
}
