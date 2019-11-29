package com.shopee.app.ui.follow.following.recommend;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.devspark.robototextview.widget.RobotoButton;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {
    private boolean h = false;
    private final c i = new c();

    public b(Context context) {
        super(context);
        b();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.facebook_recommend_item_layout, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.i);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f21670a = (ImageView) aVar.internalFindViewById(R.id.avatar);
        this.f21671b = (TextView) aVar.internalFindViewById(R.id.username);
        this.f21672c = (TextView) aVar.internalFindViewById(R.id.contact_username);
        this.f21673d = (RobotoButton) aVar.internalFindViewById(R.id.follow_button);
        if (this.f21673d != null) {
            this.f21673d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.a();
                }
            });
        }
    }
}
