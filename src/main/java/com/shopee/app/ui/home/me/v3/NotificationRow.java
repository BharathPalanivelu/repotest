package com.shopee.app.ui.home.me.v3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.f;
import com.devspark.robototextview.widget.RobotoTextView;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.a;
import com.shopee.app.application.ar;
import com.shopee.app.data.viewmodel.MeTabNoticeItem;
import com.shopee.id.R;
import d.d.b.j;
import d.h.m;
import java.util.HashMap;

public final class NotificationRow extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private MeTabNoticeItem f22457a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f22458b;

    public NotificationRow(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public NotificationRow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    public View a(int i) {
        if (this.f22458b == null) {
            this.f22458b = new HashMap();
        }
        View view = (View) this.f22458b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f22458b.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public NotificationRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        RelativeLayout.inflate(context, R.layout.view_notification_row, this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotificationRow(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ void a(NotificationRow notificationRow, boolean z, MeTabNoticeItem meTabNoticeItem, int i, Object obj) {
        if ((i & 2) != 0) {
            meTabNoticeItem = notificationRow.f22457a;
        }
        notificationRow.a(z, meTabNoticeItem);
    }

    public final void a(boolean z, MeTabNoticeItem meTabNoticeItem) {
        if (meTabNoticeItem != null) {
            this.f22457a = meTabNoticeItem;
            if (z || meTabNoticeItem.getActionId() == 99) {
                com.shopee.app.e.b.a(this);
                return;
            }
            com.shopee.app.e.b.b(this);
            int iconRes = meTabNoticeItem.getIconRes();
            String text = meTabNoticeItem.getText();
            j.a((Object) text, "notice.text");
            a(iconRes, text, meTabNoticeItem.getButtonText());
        }
    }

    public final void a(int i, String str, int i2) {
        j.b(str, "notiText");
        if ((!m.a(str)) && i2 != 0) {
            f.a(getContext()).a(str).b().b().a(SQLBuilder.BLANK).b().b().a(i2).a((View.OnClickListener) new a(this)).a().b(com.garena.android.appkit.tools.b.a(R.color.complement)).c().b().b().a((TextView) (RobotoTextView) a(a.C0250a.text));
        }
        if (i != 0) {
            ((ImageView) a(a.C0250a.icon)).setImageResource(i);
            ImageView imageView = (ImageView) a(a.C0250a.icon);
            j.a((Object) imageView, "icon");
            com.shopee.app.e.b.b(imageView);
        } else {
            ImageView imageView2 = (ImageView) a(a.C0250a.icon);
            j.a((Object) imageView2, "icon");
            com.shopee.app.e.b.a(imageView2);
        }
        ((ImageView) a(a.C0250a.cross)).setOnClickListener(new b(this));
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationRow f22459a;

        a(NotificationRow notificationRow) {
            this.f22459a = notificationRow;
        }

        public final void onClick(View view) {
            this.f22459a.a();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationRow f22460a;

        b(NotificationRow notificationRow) {
            this.f22460a = notificationRow;
        }

        public final void onClick(View view) {
            this.f22460a.b();
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        f2.e().uiEventBus().a().B.a(this.f22457a).a();
    }

    /* access modifiers changed from: private */
    public final void b() {
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        f2.e().uiEventBus().a().J.a(this.f22457a).a();
    }
}
