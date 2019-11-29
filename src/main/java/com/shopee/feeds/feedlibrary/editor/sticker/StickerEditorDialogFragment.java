package com.shopee.feeds.feedlibrary.editor.sticker;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.shopee.feeds.feedlibrary.adapter.SelectStickerRecyclerAdapter;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.ImageStickerItemEntity;
import com.shopee.feeds.feedlibrary.view.a.c;
import java.util.ArrayList;
import java.util.List;
import tencent.tls.platform.SigType;

public class StickerEditorDialogFragment extends DialogFragment implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f27996a = "StickerEditorDialogFragment";

    /* renamed from: b  reason: collision with root package name */
    List<SelectStickerRecyclerAdapter.a> f27997b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    SelectStickerRecyclerAdapter f27998c;

    /* renamed from: d  reason: collision with root package name */
    private com.shopee.feeds.feedlibrary.b.c f27999d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f28000e;
    @BindView
    View outBoundView;
    @BindView
    RecyclerView stickerListView;

    public interface a {
        void a(int i, String str, String str2, int i2, int i3);

        void a(List<SelectStickerRecyclerAdapter.a> list);
    }

    public void a(ArrayList<ImageStickerItemEntity> arrayList) {
        this.f27997b.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            SelectStickerRecyclerAdapter.a aVar = new SelectStickerRecyclerAdapter.a(a(arrayList.get(i).getType()), arrayList.get(i).getUrl());
            aVar.a(arrayList.get(i).getId());
            this.f27997b.add(aVar);
        }
        this.f27998c.a(this.f27997b);
        a aVar2 = this.f28000e;
        if (aVar2 != null) {
            aVar2.a(this.f27997b);
        }
    }

    public static StickerEditorDialogFragment a(Activity activity, a aVar, List<SelectStickerRecyclerAdapter.a> list) {
        StickerEditorDialogFragment stickerEditorDialogFragment = new StickerEditorDialogFragment();
        stickerEditorDialogFragment.a(aVar);
        stickerEditorDialogFragment.a(list);
        stickerEditorDialogFragment.show(activity.getFragmentManager(), f27996a);
        return stickerEditorDialogFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT < 23) {
            setStyle(0, 16973937);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(c.f.feeds_layout_photo_editor_add_sticker_dialog, viewGroup, false);
        ButterKnife.a(this, inflate);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f27999d = new com.shopee.feeds.feedlibrary.b.c((Context) getActivity(), (com.shopee.feeds.feedlibrary.view.a.c) this);
        this.stickerListView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        this.stickerListView.setDescendantFocusability(SigType.D2);
        this.f27998c = new SelectStickerRecyclerAdapter(getActivity());
        this.f27998c.a((SelectStickerRecyclerAdapter.b) new SelectStickerRecyclerAdapter.b() {
            public void a(int i, Object obj, int i2, int i3) {
                if (StickerEditorDialogFragment.this.f28000e != null) {
                    StickerEditorDialogFragment.this.dismiss();
                    SelectStickerRecyclerAdapter.a aVar = (SelectStickerRecyclerAdapter.a) obj;
                    StickerEditorDialogFragment.this.f28000e.a(aVar.a(), aVar.b(), aVar.c(), i2, i3);
                }
            }
        });
        this.stickerListView.setAdapter(this.f27998c);
        List<SelectStickerRecyclerAdapter.a> list = this.f27997b;
        if (list != null && list.size() > 0) {
            this.f27998c.a(this.f27997b);
        }
        this.f27999d.a();
        this.outBoundView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StickerEditorDialogFragment.this.dismiss();
            }
        });
    }

    public void onStart() {
        super.onStart();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setLayout(displayMetrics.widthPixels, -1);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    public void onStop() {
        super.onStop();
    }

    private void a(List<SelectStickerRecyclerAdapter.a> list) {
        if (list != null && list.size() > 0) {
            this.f27997b.clear();
            this.f27997b.addAll(list);
        }
    }

    private void a(a aVar) {
        this.f28000e = aVar;
    }

    private int a(String str) {
        if ("1".equals(str)) {
            return 2;
        }
        if ("2".equals(str)) {
            return 3;
        }
        return "3".equals(str) ? 4 : 1;
    }
}
