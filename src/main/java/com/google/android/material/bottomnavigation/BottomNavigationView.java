package com.google.android.material.bottomnavigation;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.customview.view.AbsSavedState;

public class BottomNavigationView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final g f13223a;

    /* renamed from: b  reason: collision with root package name */
    private final b f13224b;

    /* renamed from: c  reason: collision with root package name */
    private final BottomNavigationPresenter f13225c;

    /* renamed from: d  reason: collision with root package name */
    private MenuInflater f13226d;

    /* renamed from: e  reason: collision with root package name */
    private b f13227e;

    /* renamed from: f  reason: collision with root package name */
    private a f13228f;

    public interface a {
    }

    public interface b {
    }

    public int getMaxItemCount() {
        return 5;
    }

    public void setOnNavigationItemSelectedListener(b bVar) {
        this.f13227e = bVar;
    }

    public void setOnNavigationItemReselectedListener(a aVar) {
        this.f13228f = aVar;
    }

    public Menu getMenu() {
        return this.f13223a;
    }

    public ColorStateList getItemIconTintList() {
        return this.f13224b.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f13224b.setIconTintList(colorStateList);
    }

    public void setItemIconSize(int i) {
        this.f13224b.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public int getItemIconSize() {
        return this.f13224b.getItemIconSize();
    }

    public ColorStateList getItemTextColor() {
        return this.f13224b.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f13224b.setItemTextColor(colorStateList);
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f13224b.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i) {
        this.f13224b.setItemBackgroundRes(i);
    }

    public Drawable getItemBackground() {
        return this.f13224b.getItemBackground();
    }

    public void setItemBackground(Drawable drawable) {
        this.f13224b.setItemBackground(drawable);
    }

    public int getSelectedItemId() {
        return this.f13224b.getSelectedItemId();
    }

    public void setSelectedItemId(int i) {
        MenuItem findItem = this.f13223a.findItem(i);
        if (findItem != null && !this.f13223a.a(findItem, (m) this.f13225c, 0)) {
            findItem.setChecked(true);
        }
    }

    public void setLabelVisibilityMode(int i) {
        if (this.f13224b.getLabelVisibilityMode() != i) {
            this.f13224b.setLabelVisibilityMode(i);
            this.f13225c.a(false);
        }
    }

    public int getLabelVisibilityMode() {
        return this.f13224b.getLabelVisibilityMode();
    }

    public void setItemTextAppearanceInactive(int i) {
        this.f13224b.setItemTextAppearanceInactive(i);
    }

    public int getItemTextAppearanceInactive() {
        return this.f13224b.getItemTextAppearanceInactive();
    }

    public void setItemTextAppearanceActive(int i) {
        this.f13224b.setItemTextAppearanceActive(i);
    }

    public int getItemTextAppearanceActive() {
        return this.f13224b.getItemTextAppearanceActive();
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.f13224b.a() != z) {
            this.f13224b.setItemHorizontalTranslationEnabled(z);
            this.f13225c.a(false);
        }
    }

    private MenuInflater getMenuInflater() {
        if (this.f13226d == null) {
            this.f13226d = new androidx.appcompat.view.g(getContext());
        }
        return this.f13226d;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f13229a = new Bundle();
        this.f13223a.a(savedState.f13229a);
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
        this.f13223a.b(savedState.f13229a);
    }

    static class SavedState extends AbsSavedState {
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
        Bundle f13229a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f13229a);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f13229a = parcel.readBundle(classLoader);
        }
    }
}
