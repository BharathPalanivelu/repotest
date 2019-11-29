package eu.davidea.flexibleadapter.a;

import android.animation.Animator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import eu.davidea.flexibleadapter.b;
import eu.davidea.flexibleadapter.b.f;
import eu.davidea.flexibleadapter.b.g;
import eu.davidea.flexibleadapter.c.a;

public class b extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32818a = eu.davidea.flexibleadapter.b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private eu.davidea.flexibleadapter.b f32819b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f32820c;

    /* renamed from: d  reason: collision with root package name */
    private ViewGroup f32821d;

    /* renamed from: e  reason: collision with root package name */
    private eu.davidea.a.b f32822e;

    /* renamed from: f  reason: collision with root package name */
    private b.k f32823f;

    /* renamed from: g  reason: collision with root package name */
    private int f32824g = -1;

    public b(eu.davidea.flexibleadapter.b bVar, b.k kVar) {
        this.f32819b = bVar;
        this.f32823f = kVar;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        a(false);
    }

    public boolean a() {
        return this.f32820c != null;
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f32820c;
        if (recyclerView2 != null) {
            recyclerView2.b((RecyclerView.n) this);
            b();
        }
        this.f32820c = recyclerView;
        RecyclerView recyclerView3 = this.f32820c;
        if (recyclerView3 != null) {
            recyclerView3.a((RecyclerView.n) this);
            this.f32820c.post(new Runnable() {
                public void run() {
                    b.this.c();
                }
            });
        }
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f32820c;
        if (recyclerView2 == recyclerView) {
            recyclerView2.b((RecyclerView.n) this);
            this.f32820c = null;
            this.f32821d.animate().setListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    b.this.b();
                }
            });
            this.f32821d.animate().alpha(BitmapDescriptorFactory.HUE_RED).start();
            if (eu.davidea.flexibleadapter.b.k) {
                Log.i(f32818a, "StickyHolderLayout detached");
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f32821d = this.f32819b.e();
        ViewGroup viewGroup = this.f32821d;
        if (viewGroup == null) {
            Log.w(f32818a, "WARNING! ViewGroup for Sticky Headers unspecified! You must include @layout/sticky_header_layout or implement FlexibleAdapter.getStickySectionHeadersHolder() method");
        } else if (viewGroup.getLayoutParams() != null) {
            this.f32821d.setClipToPadding(false);
            this.f32821d.setAlpha(BitmapDescriptorFactory.HUE_RED);
            a(false);
            this.f32821d.animate().alpha(1.0f).start();
            if (eu.davidea.flexibleadapter.b.k) {
                Log.i(f32818a, "StickyHolderLayout initialized");
            }
        } else {
            throw new IllegalStateException("The ViewGroup provided, doesn't have LayoutParams correctly set, please initialize the ViewGroup accordingly");
        }
    }

    public boolean a(int i) {
        RecyclerView.w e2 = this.f32820c.e(i);
        return e2 != null && (e2.itemView.getX() < BitmapDescriptorFactory.HUE_RED || e2.itemView.getY() < BitmapDescriptorFactory.HUE_RED);
    }

    private void b(int i) {
        b.k kVar = this.f32823f;
        if (kVar != null) {
            kVar.a(i);
        }
    }

    public void a(boolean z) {
        if (this.f32821d != null && !this.f32819b.h()) {
            RecyclerView recyclerView = this.f32820c;
            if (!(recyclerView == null || recyclerView.getChildCount() == 0)) {
                int c2 = c(-1);
                if (c2 < 0 || c2 >= this.f32819b.getItemCount()) {
                    b();
                    return;
                } else {
                    a(c2, z);
                    return;
                }
            }
        }
        b();
    }

    private void a(int i, boolean z) {
        int i2 = this.f32824g;
        if (i2 != i) {
            this.f32824g = i;
            eu.davidea.a.b d2 = d(i);
            if (eu.davidea.flexibleadapter.b.k) {
                String str = f32818a;
                Log.d(str, "swapHeader newHeaderPosition=" + this.f32824g);
            }
            a(d2);
        } else if (z) {
            eu.davidea.a.b bVar = this.f32822e;
            if (bVar != null) {
                this.f32819b.onBindViewHolder(bVar, i2);
                e();
            }
        }
        d();
    }

    private void d() {
        if (this.f32822e != null) {
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f32820c.getChildCount(); i3++) {
                View childAt = this.f32820c.getChildAt(i3);
                if (!(childAt == null || this.f32824g == c(this.f32820c.f(childAt)))) {
                    if (a.a(this.f32820c.getLayoutManager()) == 0) {
                        if (childAt.getLeft() > 0) {
                            i = Math.min(childAt.getLeft() - this.f32821d.getMeasuredWidth(), 0);
                            if (i < 0) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else if (childAt.getTop() > 0) {
                        i2 = Math.min(childAt.getTop() - this.f32821d.getMeasuredHeight(), 0);
                        if (i2 < 0) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.f32821d.setTranslationX((float) i);
            this.f32821d.setTranslationY((float) i2);
        }
    }

    private void a(eu.davidea.a.b bVar) {
        eu.davidea.a.b bVar2 = this.f32822e;
        if (bVar2 != null) {
            b(bVar2);
        }
        this.f32822e = bVar;
        eu.davidea.a.b bVar3 = this.f32822e;
        if (bVar3 != null) {
            bVar3.setIsRecyclable(false);
            e();
        }
        b(this.f32824g);
    }

    private void e() {
        View g2 = this.f32822e.g();
        this.f32822e.itemView.getLayoutParams().width = g2.getMeasuredWidth();
        this.f32822e.itemView.getLayoutParams().height = g2.getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = this.f32821d.getLayoutParams();
        layoutParams.width = g2.getLayoutParams().width;
        layoutParams.height = g2.getLayoutParams().height;
        a(g2);
        this.f32821d.setClipToPadding(false);
        this.f32821d.addView(g2);
    }

    public void b() {
        if (this.f32822e != null) {
            if (eu.davidea.flexibleadapter.b.k) {
                Log.d(f32818a, "clearHeader");
            }
            b(this.f32822e);
            this.f32821d.setAlpha(1.0f);
            this.f32822e = null;
            this.f32824g = -1;
            b(this.f32824g);
        }
    }

    private void b(eu.davidea.a.b bVar) {
        View g2 = bVar.g();
        a(g2);
        g2.setTranslationX(BitmapDescriptorFactory.HUE_RED);
        g2.setTranslationY(BitmapDescriptorFactory.HUE_RED);
        this.f32822e.itemView.setVisibility(0);
        if (!bVar.itemView.equals(g2)) {
            ((ViewGroup) bVar.itemView).addView(g2);
        }
        bVar.setIsRecyclable(true);
    }

    private static void a(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    private int c(int i) {
        if (i == -1) {
            if (this.f32820c.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                i = ((StaggeredGridLayoutManager) this.f32820c.getLayoutManager()).a((int[]) null)[0];
            } else {
                i = ((LinearLayoutManager) this.f32820c.getLayoutManager()).n();
            }
            if (i == 0 && !a(0)) {
                return -1;
            }
        }
        g e2 = this.f32819b.e(i);
        if (e2 == null || (this.f32819b.f(e2) && !this.f32819b.e(e2))) {
            return -1;
        }
        return this.f32819b.a((f) e2);
    }

    private eu.davidea.a.b d(int i) {
        int i2;
        int i3;
        eu.davidea.a.b bVar = (eu.davidea.a.b) this.f32820c.e(i);
        if (bVar == null) {
            eu.davidea.flexibleadapter.b bVar2 = this.f32819b;
            bVar = (eu.davidea.a.b) bVar2.createViewHolder(this.f32820c, bVar2.getItemViewType(i));
            this.f32819b.bindViewHolder(bVar, i);
            bVar.b(i);
            if (a.a(this.f32820c.getLayoutManager()) == 1) {
                i2 = View.MeasureSpec.makeMeasureSpec(this.f32820c.getWidth(), 1073741824);
                i3 = View.MeasureSpec.makeMeasureSpec(this.f32820c.getHeight(), 0);
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec(this.f32820c.getWidth(), 0);
                i3 = View.MeasureSpec.makeMeasureSpec(this.f32820c.getHeight(), 1073741824);
            }
            View g2 = bVar.g();
            g2.measure(ViewGroup.getChildMeasureSpec(i2, this.f32820c.getPaddingLeft() + this.f32820c.getPaddingRight(), g2.getLayoutParams().width), ViewGroup.getChildMeasureSpec(i3, this.f32820c.getPaddingTop() + this.f32820c.getPaddingBottom(), g2.getLayoutParams().height));
            g2.layout(0, 0, g2.getMeasuredWidth(), g2.getMeasuredHeight());
        }
        return bVar;
    }
}
