package com.shopee.app.ui.follow.search;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.devspark.robototextview.widget.RobotoButton;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {
    private boolean i = false;
    private final c j = new c();

    public b(Context context) {
        super(context);
        b();
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.search_user_item_layout, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.j);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onViewChanged(a aVar) {
        this.f21772a = (TextView) aVar.internalFindViewById(R.id.username);
        this.f21773b = (TextView) aVar.internalFindViewById(R.id.nickname);
        this.f21774c = (ImageView) aVar.internalFindViewById(R.id.avatar);
        this.f21775d = (ImageView) aVar.internalFindViewById(R.id.shopee_verified);
        this.f21776e = (RobotoButton) aVar.internalFindViewById(R.id.follow_button);
        if (this.f21776e != null) {
            this.f21776e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.a();
                }
            });
        }
    }
}
