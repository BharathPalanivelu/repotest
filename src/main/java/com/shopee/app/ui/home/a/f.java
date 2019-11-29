package com.shopee.app.ui.home.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class f extends e implements a, b {
    private boolean l = false;
    private final c m = new c();

    public f(Context context) {
        super(context);
        b();
    }

    public static e a(Context context) {
        f fVar = new f(context);
        fVar.onFinishInflate();
        return fVar;
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.activity_item_layout, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.m);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.i = resources.getDimensionPixelOffset(R.dimen.font_size_12);
        this.f22039g = androidx.core.content.b.c(getContext(), R.color.black26);
        this.h = androidx.core.content.b.c(getContext(), R.color.black87);
        a();
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22033a = (AvatarView) aVar.internalFindViewById(R.id.avatar);
        this.f22034b = (TextView) aVar.internalFindViewById(R.id.text_content);
        this.f22035c = (TextView) aVar.internalFindViewById(R.id.time);
        this.f22036d = (ImageView) aVar.internalFindViewById(R.id.product_image);
        this.f22037e = (Button) aVar.internalFindViewById(R.id.follow_button);
        this.f22038f = aVar.internalFindViewById(R.id.divider);
    }
}
