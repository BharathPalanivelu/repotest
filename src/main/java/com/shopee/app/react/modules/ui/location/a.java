package com.shopee.app.react.modules.ui.location;

import com.shopee.id.R;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f18867a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18868b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18869c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18870d;

    public a(int i) {
        this.f18870d = i;
        switch (this.f18870d) {
            case 4096:
                this.f18867a = R.string.sp_location_internal_error;
                this.f18868b = 2;
                this.f18869c = false;
                return;
            case 4097:
            case 4099:
            case 4100:
            case 4102:
                this.f18867a = R.string.sp_location_other_error;
                this.f18868b = 2;
                this.f18869c = true;
                return;
            case 4098:
                this.f18867a = R.string.sp_location_other_error;
                this.f18868b = 2;
                this.f18869c = false;
                return;
            default:
                this.f18868b = 0;
                this.f18867a = R.string.sp_location_internal_error;
                this.f18869c = false;
                return;
        }
    }

    public final int a() {
        return this.f18867a;
    }

    public final int b() {
        return this.f18868b;
    }

    public final boolean c() {
        return this.f18869c;
    }
}
