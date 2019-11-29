package com.google.android.material.navigation;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.i;
import androidx.core.content.b;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.g;
import com.google.android.material.internal.h;
import com.google.android.material.internal.j;

public class NavigationView extends j {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f13420d = {16842912};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f13421e = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    a f13422c;

    /* renamed from: f  reason: collision with root package name */
    private final g f13423f;

    /* renamed from: g  reason: collision with root package name */
    private final h f13424g;
    private final int h;
    private MenuInflater i;

    public interface a {
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f13425a = new Bundle();
        this.f13423f.a(savedState.f13425a);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f13423f.b(savedState.f13425a);
    }

    public void setNavigationItemSelectedListener(a aVar) {
        this.f13422c = aVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.h), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public Menu getMenu() {
        return this.f13423f;
    }

    public int getHeaderCount() {
        return this.f13424g.d();
    }

    public ColorStateList getItemIconTintList() {
        return this.f13424g.e();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f13424g.a(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.f13424g.g();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f13424g.b(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.f13424g.h();
    }

    public void setItemBackgroundResource(int i2) {
        setItemBackground(b.a(getContext(), i2));
    }

    public void setItemBackground(Drawable drawable) {
        this.f13424g.a(drawable);
    }

    public int getItemHorizontalPadding() {
        return this.f13424g.i();
    }

    public void setItemHorizontalPadding(int i2) {
        this.f13424g.b(i2);
    }

    public void setItemHorizontalPaddingResource(int i2) {
        this.f13424g.b(getResources().getDimensionPixelSize(i2));
    }

    public int getItemIconPadding() {
        return this.f13424g.j();
    }

    public void setItemIconPadding(int i2) {
        this.f13424g.c(i2);
    }

    public void setItemIconPaddingResource(int i2) {
        this.f13424g.c(getResources().getDimensionPixelSize(i2));
    }

    public void setCheckedItem(int i2) {
        MenuItem findItem = this.f13423f.findItem(i2);
        if (findItem != null) {
            this.f13424g.a((i) findItem);
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f13423f.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.f13424g.a((i) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public MenuItem getCheckedItem() {
        return this.f13424g.a();
    }

    public void setItemTextAppearance(int i2) {
        this.f13424g.a(i2);
    }

    private MenuInflater getMenuInflater() {
        if (this.i == null) {
            this.i = new androidx.appcompat.view.g(getContext());
        }
        return this.i;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public Bundle f13425a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13425a = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f13425a);
        }
    }
}
