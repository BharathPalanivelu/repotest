package com.shopee.feeds.feedlibrary.view.folderwindow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.a.b;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.adapter.a;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.picture.LocalMediaFolder;
import com.shopee.feeds.feedlibrary.util.d;

public class FolderAdapter extends a<LocalMediaFolder> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f28596e;

    public class FolderViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private FolderViewHolder f28601b;

        public FolderViewHolder_ViewBinding(FolderViewHolder folderViewHolder, View view) {
            this.f28601b = folderViewHolder;
            folderViewHolder.tvFolderName = (RobotoTextView) b.a(view, c.e.tv_folder_name, "field 'tvFolderName'", RobotoTextView.class);
        }
    }

    public void a(int i) {
        this.f28596e = i;
    }

    public FolderAdapter(Context context) {
        super(context);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new FolderViewHolder(this.f27559c.inflate(c.f.feeds_layout_folder_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.w wVar, final int i) {
        final FolderViewHolder folderViewHolder = (FolderViewHolder) wVar;
        final LocalMediaFolder localMediaFolder = (LocalMediaFolder) this.f27558b.get(i);
        if (!d.a(localMediaFolder.a())) {
            folderViewHolder.tvFolderName.setText(localMediaFolder.a());
        }
        folderViewHolder.tvFolderName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int unused = FolderAdapter.this.f28596e = i;
                if (FolderAdapter.this.f27560d != null) {
                    FolderAdapter.this.f27560d.a(i, localMediaFolder, folderViewHolder.tvFolderName);
                }
            }
        });
        if (i == this.f28596e) {
            folderViewHolder.tvFolderName.setTextColor(this.f27557a.getResources().getColor(c.b.black_26));
        } else {
            folderViewHolder.tvFolderName.setTextColor(this.f27557a.getResources().getColor(c.b.black_87));
        }
    }

    static class FolderViewHolder extends RecyclerView.w {
        @BindView
        RobotoTextView tvFolderName;

        public FolderViewHolder(View view) {
            super(view);
            ButterKnife.a(this, view);
        }
    }
}
