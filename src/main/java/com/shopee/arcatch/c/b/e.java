package com.shopee.arcatch.c.b;

import com.shopee.arcatch.c.g.i;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public float f26742a;

    /* renamed from: b  reason: collision with root package name */
    public float f26743b;

    /* renamed from: c  reason: collision with root package name */
    public double f26744c;

    /* renamed from: d  reason: collision with root package name */
    public float f26745d;

    /* renamed from: e  reason: collision with root package name */
    public float f26746e;

    /* renamed from: f  reason: collision with root package name */
    public double f26747f;

    /* renamed from: g  reason: collision with root package name */
    public String f26748g;
    public int h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;
    public String u;
    public float v;
    public float w;
    public float x;
    public float y;

    public void a(i iVar) {
        if (iVar != null) {
            String d2 = iVar.d();
            char c2 = 65535;
            switch (d2.hashCode()) {
                case -1863857531:
                    if (d2.equals("detection")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -195599433:
                    if (d2.equals("gamefps")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 98728:
                    if (d2.equals("cpu")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 112670:
                    if (d2.equals("ram")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 93928829:
                    if (d2.equals("box2d")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                this.r = iVar.a();
                this.s = iVar.b();
                this.t = iVar.c();
            } else if (c2 == 1) {
                this.l = iVar.a();
                this.m = iVar.b();
                this.n = iVar.c();
                this.o = iVar.a();
                this.p = iVar.b();
                this.q = iVar.c();
            } else if (c2 == 2) {
                this.i = iVar.a();
                this.j = iVar.b();
                this.k = iVar.c();
            } else if (c2 == 3) {
                this.f26742a = iVar.a();
                this.f26743b = iVar.b();
                this.f26744c = (double) iVar.c();
            } else if (c2 == 4) {
                this.f26745d = iVar.a();
                this.f26747f = (double) iVar.c();
                this.f26746e = iVar.b();
            }
        }
    }

    public String toString() {
        return "ArCatchQualityBean{cpu_rate_max=" + this.f26742a + ", cpu_rate_min=" + this.f26743b + ", cpu_rate_avg=" + this.f26744c + ", ram_max=" + this.f26745d + ", ram_min=" + this.f26746e + ", ram_avg=" + this.f26747f + ", model='" + this.f26748g + '\'' + ", version=" + this.h + ", detect_time_max=" + this.i + ", detect_time_min=" + this.j + ", detect_time_avg=" + this.k + ", app_frame_rate_max=" + this.l + ", app_frame_rate_min=" + this.m + ", app_frame_rate_avg=" + this.n + ", game_frame_rate_max=" + this.o + ", game_frame_rate_min=" + this.p + ", game_frame_rate_avg=" + this.q + ", physics_compute_time_max=" + this.r + ", physics_compute_time_min=" + this.s + ", physics_compute_time_avg=" + this.t + ", resolution='" + this.u + '\'' + ", capure_frame_rate=" + this.v + ", capture_interval_max=" + this.w + ", capture_interval_min=" + this.x + ", capture_interval_avg=" + this.y + '}';
    }
}
