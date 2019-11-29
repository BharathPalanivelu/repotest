package com.shopee.feeds.feedlibrary.editor.b;

import java.io.Serializable;

public class b implements Serializable {
    private int angle;
    private float fix_scale;
    private float parentHeight;
    private float parentWidth;
    private float pivotXpos;
    private float pivotYpos;
    private float scale;
    private String tag = String.valueOf(System.currentTimeMillis());
    private float x;
    private float xScale;
    private float y;
    private float yScale;

    public String toString() {
        return String.format("scale=%f,pivXpos=%f,pivYpox=%f,angle=%d", new Object[]{Float.valueOf(this.scale), Float.valueOf(this.pivotXpos), Float.valueOf(this.pivotYpos), Integer.valueOf(this.angle)});
    }

    public float a() {
        return this.x;
    }

    public void a(float f2) {
        this.x = f2;
    }

    public float b() {
        return this.y;
    }

    public void b(float f2) {
        this.y = f2;
    }

    public float c() {
        return this.xScale;
    }

    public void c(float f2) {
        this.xScale = f2;
    }

    public float d() {
        return this.yScale;
    }

    public void d(float f2) {
        this.yScale = f2;
    }

    public float e() {
        return this.parentWidth;
    }

    public void e(float f2) {
        this.parentWidth = f2;
    }

    public float f() {
        return this.parentHeight;
    }

    public void f(float f2) {
        this.parentHeight = f2;
    }

    public String g() {
        return this.tag;
    }

    public void a(String str) {
        this.tag = str;
    }

    public float h() {
        return this.pivotXpos;
    }

    public void g(float f2) {
        this.pivotXpos = f2;
    }

    public float i() {
        return this.pivotYpos;
    }

    public void h(float f2) {
        this.pivotYpos = f2;
    }

    public float j() {
        return this.scale;
    }

    public void i(float f2) {
        this.scale = f2;
    }

    public float k() {
        return this.fix_scale;
    }

    public void j(float f2) {
        this.fix_scale = f2;
    }

    public int l() {
        return this.angle;
    }

    public void a(int i) {
        this.angle = i;
    }
}
