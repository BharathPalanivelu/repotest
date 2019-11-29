package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.r;

public class BottomNavigationPresenter implements m {

    /* renamed from: a  reason: collision with root package name */
    private g f13218a;

    /* renamed from: b  reason: collision with root package name */
    private b f13219b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13220c;

    /* renamed from: d  reason: collision with root package name */
    private int f13221d;

    public void a(g gVar, boolean z) {
    }

    public void a(m.a aVar) {
    }

    public boolean a(g gVar, i iVar) {
        return false;
    }

    public boolean a(r rVar) {
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean b(g gVar, i iVar) {
        return false;
    }

    public void a(Context context, g gVar) {
        this.f13218a = gVar;
        this.f13219b.a(this.f13218a);
    }

    public void a(boolean z) {
        if (!this.f13220c) {
            if (z) {
                this.f13219b.b();
            } else {
                this.f13219b.c();
            }
        }
    }

    public int c() {
        return this.f13221d;
    }

    public Parcelable f() {
        SavedState savedState = new SavedState();
        savedState.f13222a = this.f13219b.getSelectedItemId();
        return savedState;
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f13219b.a(((SavedState) parcelable).f13222a);
        }
    }

    public void b(boolean z) {
        this.f13220c = z;
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f13222a;

        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f13222a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f13222a);
        }
    }
}
