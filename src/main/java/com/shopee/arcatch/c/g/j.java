package com.shopee.arcatch.c.g;

import java.util.Random;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private int f26904a = 2;

    /* renamed from: b  reason: collision with root package name */
    private int f26905b = 1000;

    /* renamed from: c  reason: collision with root package name */
    private Random f26906c = new Random();

    /* renamed from: d  reason: collision with root package name */
    private long f26907d;

    /* renamed from: e  reason: collision with root package name */
    private int f26908e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f26909f;

    public j(int i, int i2) {
        int i3 = 0;
        this.f26908e = 0;
        int i4 = this.f26904a;
        this.f26909f = new int[(i4 + 1)];
        int i5 = this.f26905b / i4;
        while (true) {
            int[] iArr = this.f26909f;
            if (i3 < iArr.length) {
                iArr[i3] = i5 * i3;
                i3++;
            } else {
                return;
            }
        }
    }

    public void a() {
        this.f26907d = System.currentTimeMillis();
    }

    public long b() {
        int i = this.f26908e;
        int i2 = this.f26904a;
        int i3 = i / i2;
        int i4 = i % i2;
        long j = ((long) (i3 * this.f26905b)) + this.f26907d;
        int[] iArr = this.f26909f;
        int i5 = iArr[i4];
        int i6 = iArr[i4 + 1];
        this.f26908e++;
        long nextInt = (j + ((long) (this.f26906c.nextInt((i6 - i5) + 1) + i5))) - System.currentTimeMillis();
        if (nextInt <= 0) {
            return 1;
        }
        return nextInt;
    }
}
