package com.shopee.arcatch.b.c;

import java.util.LinkedList;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<Long> f26688a = new LinkedList<>();

    public int a(long j) {
        this.f26688a.addLast(Long.valueOf(j));
        while (!this.f26688a.isEmpty() && j - this.f26688a.getFirst().longValue() >= 1000) {
            this.f26688a.removeFirst();
        }
        return this.f26688a.size();
    }
}
