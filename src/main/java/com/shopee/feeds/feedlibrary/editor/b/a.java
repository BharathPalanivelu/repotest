package com.shopee.feeds.feedlibrary.editor.b;

import android.view.View;
import com.shopee.feeds.feedlibrary.editor.b.b;
import com.shopee.feeds.feedlibrary.editor.sticker.CommentStickerItemView;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.t;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a<T extends b> {

    /* renamed from: a  reason: collision with root package name */
    protected int f27912a = 5;
    /* access modifiers changed from: protected */

    /* renamed from: b  reason: collision with root package name */
    public d f27913b;

    /* renamed from: c  reason: collision with root package name */
    protected C0429a<T> f27914c;
    /* access modifiers changed from: protected */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<T> f27915d = new ArrayList<>();

    /* renamed from: com.shopee.feeds.feedlibrary.editor.b.a$a  reason: collision with other inner class name */
    public interface C0429a<T> {
        void a(T t);

        void b(T t);
    }

    /* access modifiers changed from: protected */
    public abstract void f(T t);

    public a(d dVar) {
        this.f27913b = dVar;
        this.f27914c = new C0429a<T>() {
            /* renamed from: a */
            public void b(T t) {
            }

            /* renamed from: b */
            public void a(T t) {
            }
        };
    }

    public ArrayList<T> a() {
        return this.f27915d;
    }

    public void a(T t) {
        if (this.f27915d.size() < this.f27912a) {
            this.f27915d.add(t);
            f(t);
            this.f27914c.b(t);
        }
    }

    public void a(ArrayList<T> arrayList) {
        if (arrayList != null && arrayList.size() <= this.f27912a && arrayList.size() > 0) {
            c();
            this.f27915d.addAll(arrayList);
            for (int i = 0; i < this.f27915d.size(); i++) {
                f((b) this.f27915d.get(i));
                this.f27914c.b(this.f27915d.get(i));
            }
        }
    }

    public void b(T t) {
        int childCount = this.f27913b.getItemContainer().getChildCount();
        if (childCount > 0) {
            int i = 0;
            while (i < childCount) {
                View childAt = this.f27913b.getItemContainer().getChildAt(i);
                if (!(childAt instanceof c) || !((c) childAt).getViewTag().equals(t.g())) {
                    i++;
                } else {
                    this.f27913b.getItemContainer().removeView(childAt);
                    this.f27915d.remove(a(t.g()));
                    this.f27914c.a(t);
                    return;
                }
            }
        }
    }

    public void c(T t) {
        int childCount = this.f27913b.getItemContainer().getChildCount();
        if (childCount > 0) {
            int i = 0;
            while (i < childCount) {
                View childAt = this.f27913b.getItemContainer().getChildAt(i);
                if (!(childAt instanceof c) || !((c) childAt).getViewTag().equals(t.g())) {
                    i++;
                } else {
                    childAt.setVisibility(8);
                    return;
                }
            }
        }
    }

    public void d(T t) {
        int childCount = this.f27913b.getItemContainer().getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f27913b.getItemContainer().getChildAt(i);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    if (cVar.getViewTag().equals(t.g())) {
                        childAt.setVisibility(0);
                        cVar.setInfo(t);
                        e(t);
                        if (cVar instanceof CommentStickerItemView) {
                            h.b("", "showInfoItem " + cVar.getScaleY() + "," + cVar.getX() + "," + cVar.getY() + "," + cVar.getRotation() + cVar.getMeasuredWidth() + "," + t.g());
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public void e(T t) {
        int childCount = this.f27913b.getItemContainer().getChildCount();
        if (childCount > 0) {
            int i = 0;
            while (i < childCount) {
                View childAt = this.f27913b.getItemContainer().getChildAt(i);
                if (!(childAt instanceof c) || !((c) childAt).getViewTag().equals(t.g())) {
                    i++;
                } else {
                    childAt.setVisibility(0);
                    g(t);
                    return;
                }
            }
        }
    }

    private void g(T t) {
        if (this.f27915d != null) {
            for (int i = 0; i < this.f27915d.size(); i++) {
                if (((b) this.f27915d.get(i)).g().equals(t.g())) {
                    this.f27915d.set(i, t);
                }
            }
        }
    }

    public void b() {
        int childCount = this.f27913b.getItemContainer().getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f27913b.getItemContainer().getChildAt(i);
                if ((childAt instanceof c) && childAt.getVisibility() != 0) {
                    childAt.setVisibility(0);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        int childCount = this.f27913b.getItemContainer().getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f27913b.getItemContainer().getChildAt(i);
                if (childAt instanceof c) {
                    c cVar = (c) childAt;
                    b a2 = t.a((CharSequence) cVar.getViewTag()) ? null : a(cVar.getViewTag());
                    if (a2 != null && this.f27915d.contains(a2)) {
                        this.f27913b.getItemContainer().removeView(cVar);
                    }
                }
            }
        }
        this.f27915d.clear();
    }

    /* access modifiers changed from: protected */
    public T a(String str) {
        if (str == null) {
            return null;
        }
        Iterator<T> it = this.f27915d.iterator();
        while (it.hasNext()) {
            T t = (b) it.next();
            if (str.equals(t.g())) {
                return t;
            }
        }
        return null;
    }

    public void a(int i) {
        this.f27912a = i;
    }

    public int d() {
        return this.f27912a;
    }

    public void a(C0429a<T> aVar) {
        this.f27914c = aVar;
    }
}
