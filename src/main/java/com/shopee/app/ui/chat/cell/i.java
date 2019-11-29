package com.shopee.app.ui.chat.cell;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.shopee.app.data.viewmodel.chat.ChatImageMessage;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.h.f;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.image.ImageBrowserActivity_;
import com.shopee.app.ui.image.MediaData;
import com.shopee.id.R;
import com.squareup.a.aa;
import com.squareup.a.w;
import java.io.File;
import java.util.ArrayList;

public class i extends FrameLayout implements View.OnClickListener, View.OnLongClickListener, n<ChatMessage>, am {

    /* renamed from: a  reason: collision with root package name */
    ImageView f20103a;

    /* renamed from: b  reason: collision with root package name */
    int f20104b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20105c;

    /* renamed from: d  reason: collision with root package name */
    private ChatImageMessage f20106d;

    /* renamed from: e  reason: collision with root package name */
    private final an f20107e;

    public i(Context context, an anVar, boolean z) {
        super(context);
        this.f20107e = anVar;
        this.f20105c = z;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    public void a(ChatMessage chatMessage) {
        this.f20106d = (ChatImageMessage) chatMessage;
        File file = new File(f.a().b(this.f20106d.getThumbUrl()));
        if (file.exists()) {
            aa a2 = w.a(getContext()).a(file);
            int i = this.f20104b;
            a2.b(i, i).d().a(this.f20103a);
        } else {
            w a3 = w.a(getContext());
            aa a4 = a3.a("http://cf.shopee.co.id/file/" + this.f20106d.getThumbUrl());
            int i2 = this.f20104b;
            a4.b(i2, i2).d().a(this.f20103a);
        }
        an anVar = this.f20107e;
        if (anVar != null) {
            anVar.setContentBackground(R.color.white);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            ImageView imageView = this.f20103a;
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
                imageView.invalidate();
            }
        } else if (action == 1 || action == 3) {
            ImageView imageView2 = this.f20103a;
            Drawable drawable2 = imageView2.getDrawable();
            if (drawable2 != null) {
                drawable2.clearColorFilter();
            }
            imageView2.invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        MediaData newImageData = MediaData.newImageData("http://cf.shopee.co.id/file/" + this.f20106d.getImageUrl());
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(newImageData);
        ImageBrowserActivity_.a(getContext()).a((ArrayList<MediaData>) arrayList).a(true).a();
    }

    public void b() {
        if (this.f20106d.getSendStatus() == 2) {
            a.a((View) this.f20103a, (ChatMessage) this.f20106d);
        }
    }

    public boolean onLongClick(View view) {
        if (this.f20106d.getSendStatus() != 2) {
            return false;
        }
        a.a((View) this.f20103a, (ChatMessage) this.f20106d);
        return true;
    }
}
