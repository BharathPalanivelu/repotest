package com.shopee.feeds.feedlibrary.view.folderwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.feeds.feedlibrary.adapter.a;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.picture.LocalMediaFolder;
import java.util.ArrayList;

public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f28602a;

    /* renamed from: b  reason: collision with root package name */
    C0437a f28603b;

    /* renamed from: c  reason: collision with root package name */
    private FolderAdapter f28604c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<LocalMediaFolder> f28605d = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f28606e;

    /* renamed from: com.shopee.feeds.feedlibrary.view.folderwindow.a$a  reason: collision with other inner class name */
    public interface C0437a {
        void a(int i, LocalMediaFolder localMediaFolder);
    }

    public a(Context context) {
        super(context);
        setHeight(-2);
        setWidth(-2);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        View inflate = LayoutInflater.from(context).inflate(c.f.feeds_layout_folder_popup, (ViewGroup) null, false);
        this.f28602a = (RecyclerView) inflate.findViewById(c.e.rv_folder);
        this.f28602a.setLayoutManager(new LinearLayoutManager(context));
        this.f28604c = new FolderAdapter(context);
        this.f28602a.setAdapter(this.f28604c);
        this.f28604c.a((a.C0422a) new a.C0422a() {
            public void a(int i, Object obj, View view) {
                if (i != a.this.f28606e) {
                    int unused = a.this.f28606e = i;
                    LocalMediaFolder localMediaFolder = (LocalMediaFolder) obj;
                    if (a.this.f28603b != null) {
                        a.this.f28603b.a(i, localMediaFolder);
                    }
                    if (a.this.isShowing()) {
                        a.this.dismiss();
                    }
                }
            }
        });
        setContentView(inflate);
    }

    public void a(ArrayList<LocalMediaFolder> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f28605d.clear();
            this.f28605d.addAll(arrayList);
            this.f28604c.a(this.f28605d);
        }
    }

    public void a() {
        FolderAdapter folderAdapter = this.f28604c;
        if (folderAdapter != null) {
            folderAdapter.a(this.f28606e);
            this.f28604c.notifyDataSetChanged();
        }
    }

    public void a(C0437a aVar) {
        this.f28603b = aVar;
    }
}
