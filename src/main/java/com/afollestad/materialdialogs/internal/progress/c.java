package com.afollestad.materialdialogs.internal.progress;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;

@TargetApi(14)
abstract class c extends h implements Animatable {

    /* renamed from: a  reason: collision with root package name */
    protected Animator[] f3209a;

    public c(Context context) {
        super(context);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (a()) {
            invalidateSelf();
        }
    }

    public void start() {
        if (!a()) {
            for (Animator start : this.f3209a) {
                start.start();
            }
            invalidateSelf();
        }
    }

    private boolean a() {
        for (Animator isStarted : this.f3209a) {
            if (isStarted.isStarted()) {
                return true;
            }
        }
        return false;
    }

    public void stop() {
        for (Animator end : this.f3209a) {
            end.end();
        }
    }

    public boolean isRunning() {
        for (Animator isRunning : this.f3209a) {
            if (isRunning.isRunning()) {
                return true;
            }
        }
        return false;
    }
}
