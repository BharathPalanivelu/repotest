package com.shopee.app.react.d;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayBlockingQueue<T> f18642a = new ArrayBlockingQueue<>(1);

    public void a(T t) {
        this.f18642a.add(t);
    }

    public void b(T t) {
        this.f18642a.add(t);
    }

    public T a() {
        try {
            return this.f18642a.poll(20, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
