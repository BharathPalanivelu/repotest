package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.e;
import androidx.viewpager.widget.a;
import java.util.ArrayList;

public abstract class k extends a {

    /* renamed from: a  reason: collision with root package name */
    private final h f2221a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2222b;

    /* renamed from: c  reason: collision with root package name */
    private l f2223c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Fragment.SavedState> f2224d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Fragment> f2225e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f2226f;

    public abstract Fragment a(int i);

    @Deprecated
    public k(h hVar) {
        this(hVar, 0);
    }

    public k(h hVar, int i) {
        this.f2223c = null;
        this.f2224d = new ArrayList<>();
        this.f2225e = new ArrayList<>();
        this.f2226f = null;
        this.f2221a = hVar;
        this.f2222b = i;
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.f2225e.size() > i) {
            Fragment fragment = this.f2225e.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f2223c == null) {
            this.f2223c = this.f2221a.a();
        }
        Fragment a2 = a(i);
        if (this.f2224d.size() > i) {
            Fragment.SavedState savedState = this.f2224d.get(i);
            if (savedState != null) {
                a2.setInitialSavedState(savedState);
            }
        }
        while (this.f2225e.size() <= i) {
            this.f2225e.add((Object) null);
        }
        a2.setMenuVisibility(false);
        if (this.f2222b == 0) {
            a2.setUserVisibleHint(false);
        }
        this.f2225e.set(i, a2);
        this.f2223c.a(viewGroup.getId(), a2);
        if (this.f2222b == 1) {
            this.f2223c.a(a2, e.b.STARTED);
        }
        return a2;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f2223c == null) {
            this.f2223c = this.f2221a.a();
        }
        while (this.f2224d.size() <= i) {
            this.f2224d.add((Object) null);
        }
        this.f2224d.set(i, fragment.isAdded() ? this.f2221a.a(fragment) : null);
        this.f2225e.set(i, (Object) null);
        this.f2223c.a(fragment);
        if (fragment == this.f2226f) {
            this.f2226f = null;
        }
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f2226f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f2222b == 1) {
                    if (this.f2223c == null) {
                        this.f2223c = this.f2221a.a();
                    }
                    this.f2223c.a(this.f2226f, e.b.STARTED);
                } else {
                    this.f2226f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f2222b == 1) {
                if (this.f2223c == null) {
                    this.f2223c = this.f2221a.a();
                }
                this.f2223c.a(fragment, e.b.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f2226f = fragment;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        l lVar = this.f2223c;
        if (lVar != null) {
            lVar.e();
            this.f2223c = null;
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public Parcelable saveState() {
        Bundle bundle;
        if (this.f2224d.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f2224d.size()];
            this.f2224d.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.f2225e.size(); i++) {
            Fragment fragment = this.f2225e.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f2221a.a(bundle, "f" + i, fragment);
            }
        }
        return bundle;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f2224d.clear();
            this.f2225e.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f2224d.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a2 = this.f2221a.a(bundle, str);
                    if (a2 != null) {
                        while (this.f2225e.size() <= parseInt) {
                            this.f2225e.add((Object) null);
                        }
                        a2.setMenuVisibility(false);
                        this.f2225e.set(parseInt, a2);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
