package com.shopee.app.web.processor;

import com.google.a.l;
import org.a.a.a;

public abstract class WebProcessor {
    public abstract void onProcess(l lVar);

    public void process(final l lVar) {
        a.a(new Runnable() {
            public void run() {
                WebProcessor.this.onProcess(lVar);
            }
        }, "", "WebProcessor");
    }
}
