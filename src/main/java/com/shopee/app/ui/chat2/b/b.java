package com.shopee.app.ui.chat2.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.garena.android.uikit.grid.GGridView;
import com.shopee.app.data.viewmodel.StickerPack;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class b extends androidx.viewpager.widget.a implements GGridView.b {

    /* renamed from: a  reason: collision with root package name */
    private List<StickerPack> f20284a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f20285b;

    public interface a {
        void a(com.garena.sticker.e.b bVar);

        void a(String str);
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void a(List<StickerPack> list) {
        this.f20284a = list;
    }

    public int getCount() {
        List<StickerPack> list = this.f20284a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        final StickerPack stickerPack = this.f20284a.get(i);
        if (stickerPack.isDownloaded() || stickerPack.autoDownload()) {
            View inflate = View.inflate(viewGroup.getContext(), R.layout.sticker_list_layout, (ViewGroup) null);
            GGridView gGridView = (GGridView) inflate.findViewById(R.id.gridView);
            gGridView.setAdapter(new C0305b(stickerPack.getPack().c()));
            gGridView.setColumnCount(4);
            gGridView.a();
            gGridView.setOnItemClickListener(this);
            viewGroup.addView(inflate);
            return inflate;
        }
        a aVar = new a(viewGroup.getContext());
        aVar.setPack(stickerPack);
        aVar.setDownloadBtnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (b.this.f20285b != null) {
                    b.this.f20285b.a(stickerPack.getPack().d());
                }
            }
        });
        viewGroup.addView(aVar);
        return aVar;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public void a(View view, int i, int i2, int i3) {
        if (view.getTag(R.id.chat_sticker) instanceof com.garena.sticker.e.b) {
            a aVar = this.f20285b;
            if (aVar != null) {
                aVar.a((com.garena.sticker.e.b) view.getTag(R.id.chat_sticker));
            }
        }
    }

    public void a(a aVar) {
        this.f20285b = aVar;
    }

    /* renamed from: com.shopee.app.ui.chat2.b.b$b  reason: collision with other inner class name */
    private class C0305b implements GGridView.a {

        /* renamed from: b  reason: collision with root package name */
        private List<com.garena.sticker.e.b> f20289b;

        private C0305b(List<com.garena.sticker.e.b> list) {
            this.f20289b = list;
        }

        public int a() {
            return this.f20289b.size();
        }

        public View a(Context context, int i, int i2, int i3) {
            c cVar = new c(context);
            cVar.setSticker(this.f20289b.get(i3));
            cVar.setTag(R.id.chat_sticker, this.f20289b.get(i3));
            cVar.a(this.f20289b.get(i3).a());
            return cVar;
        }
    }
}
