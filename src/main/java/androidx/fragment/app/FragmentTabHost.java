package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a> f2150a;

    /* renamed from: b  reason: collision with root package name */
    private Context f2151b;

    /* renamed from: c  reason: collision with root package name */
    private h f2152c;

    /* renamed from: d  reason: collision with root package name */
    private int f2153d;

    /* renamed from: e  reason: collision with root package name */
    private TabHost.OnTabChangeListener f2154e;

    /* renamed from: f  reason: collision with root package name */
    private a f2155f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2156g;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String f2158a;

        /* renamed from: b  reason: collision with root package name */
        final Class<?> f2159b;

        /* renamed from: c  reason: collision with root package name */
        final Bundle f2160c;

        /* renamed from: d  reason: collision with root package name */
        Fragment f2161d;
    }

    static class SavedState extends View.BaseSavedState {
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
        String f2157a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2157a = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f2157a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f2157a + "}";
        }
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f2154e = onTabChangeListener;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f2150a.size();
        l lVar = null;
        for (int i = 0; i < size; i++) {
            a aVar = this.f2150a.get(i);
            aVar.f2161d = this.f2152c.a(aVar.f2158a);
            if (aVar.f2161d != null && !aVar.f2161d.isDetached()) {
                if (aVar.f2158a.equals(currentTabTag)) {
                    this.f2155f = aVar;
                } else {
                    if (lVar == null) {
                        lVar = this.f2152c.a();
                    }
                    lVar.b(aVar.f2161d);
                }
            }
        }
        this.f2156g = true;
        l a2 = a(currentTabTag, lVar);
        if (a2 != null) {
            a2.b();
            this.f2152c.b();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2156g = false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2157a = getCurrentTabTag();
        return savedState;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f2157a);
    }

    @Deprecated
    public void onTabChanged(String str) {
        if (this.f2156g) {
            l a2 = a(str, (l) null);
            if (a2 != null) {
                a2.b();
            }
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f2154e;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    private l a(String str, l lVar) {
        a a2 = a(str);
        if (this.f2155f != a2) {
            if (lVar == null) {
                lVar = this.f2152c.a();
            }
            a aVar = this.f2155f;
            if (!(aVar == null || aVar.f2161d == null)) {
                lVar.b(this.f2155f.f2161d);
            }
            if (a2 != null) {
                if (a2.f2161d == null) {
                    a2.f2161d = this.f2152c.e().c(this.f2151b.getClassLoader(), a2.f2159b.getName());
                    a2.f2161d.setArguments(a2.f2160c);
                    lVar.a(this.f2153d, a2.f2161d, a2.f2158a);
                } else {
                    lVar.c(a2.f2161d);
                }
            }
            this.f2155f = a2;
        }
        return lVar;
    }

    private a a(String str) {
        int size = this.f2150a.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f2150a.get(i);
            if (aVar.f2158a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
