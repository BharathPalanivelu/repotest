package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

class xx0x000xxx0o0xox0ooxx implements LocationListener {
    boolean o00xxox0x0xoox;

    public void onProviderEnabled(String str) {
    }

    private xx0x000xxx0o0xox0ooxx() {
        this.o00xxox0x0xoox = false;
    }

    /* synthetic */ xx0x000xxx0o0xox0ooxx(xxx00xo0xoxxooxo xxx00xo0xoxxooxo) {
        this();
    }

    public void onLocationChanged(Location location) {
        if (location.getLatitude() != 0.0d || location.getLongitude() != 0.0d) {
            boolean z = this.o00xxox0x0xoox;
            this.o00xxox0x0xoox = true;
        }
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (i == 0 || i == 1) {
            this.o00xxox0x0xoox = false;
        }
    }

    public void onProviderDisabled(String str) {
        this.o00xxox0x0xoox = false;
    }
}
