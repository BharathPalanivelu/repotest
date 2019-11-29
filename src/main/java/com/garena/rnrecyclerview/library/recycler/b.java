package com.garena.rnrecyclerview.library.recycler;

import android.os.AsyncTask;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import java.util.List;

class b extends AsyncTask<Void, Void, f.b> {

    /* renamed from: a  reason: collision with root package name */
    private final a f8594a;

    /* renamed from: b  reason: collision with root package name */
    private final ReactRecyclerView f8595b;

    /* renamed from: c  reason: collision with root package name */
    private List<c> f8596c;

    /* renamed from: d  reason: collision with root package name */
    private List<c> f8597d;

    b(ReactRecyclerView reactRecyclerView, a aVar, List<c> list, List<c> list2) {
        this.f8595b = reactRecyclerView;
        this.f8594a = aVar;
        this.f8596c = list;
        this.f8597d = list2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public f.b doInBackground(Void... voidArr) {
        return f.a(new a(this.f8596c, this.f8597d));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(f.b bVar) {
        if (!this.f8595b.B()) {
            Parcelable e2 = this.f8595b.getLayoutManager().e();
            this.f8594a.a(this.f8597d);
            bVar.a((RecyclerView.a) this.f8594a);
            this.f8595b.getLayoutManager().a(e2);
        }
    }

    private static class a extends f.a {

        /* renamed from: a  reason: collision with root package name */
        private List<c> f8598a;

        /* renamed from: b  reason: collision with root package name */
        private List<c> f8599b;

        a(List<c> list, List<c> list2) {
            this.f8598a = list;
            this.f8599b = list2;
        }

        public int a() {
            return this.f8598a.size();
        }

        public int b() {
            return this.f8599b.size();
        }

        public boolean a(int i, int i2) {
            return this.f8598a.get(i).f8602c.equals(this.f8599b.get(i2).f8602c);
        }

        public boolean b(int i, int i2) {
            return this.f8598a.get(i).f8604e.equals(this.f8599b.get(i2).f8604e) && !TextUtils.isEmpty(this.f8598a.get(i).f8604e);
        }

        public Object c(int i, int i2) {
            return this.f8599b.get(i2).f8604e;
        }
    }
}
