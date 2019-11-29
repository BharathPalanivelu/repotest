package com.shopee.live.livestreaming.ui.anchor.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity;
import com.shopee.live.livestreaming.ui.view.ChronometerView;
import com.shopee.live.livestreaming.util.ab;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.p;
import com.shopee.live.livestreaming.util.q;
import com.shopee.live.livestreaming.util.y;
import com.squareup.a.w;

public class LivePageAnchorInfoView extends ConstraintLayout implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    ImageView f28864g;
    RobotoTextView h;
    TextView i;
    TextView j;
    ChronometerView k;
    View l;
    LinearLayout m;
    LinearLayout n;
    TextView o;
    RobotoTextView p;
    private View q;
    private int r;
    private int s;
    /* access modifiers changed from: private */
    public boolean t;
    /* access modifiers changed from: private */
    public a u;
    private long v;
    private long w;
    private long x;

    public interface a {
        void a(int i);

        void a(boolean z);
    }

    public LivePageAnchorInfoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LivePageAnchorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LivePageAnchorInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k();
        this.s = 0;
    }

    private void k() {
        this.q = LayoutInflater.from(getContext()).inflate(c.f.live_streaming_layout_anchor_info, this, true);
        this.f28864g = (ImageView) findViewById(c.e.iv_anchor_portrait);
        this.h = (RobotoTextView) findViewById(c.e.tv_anchor_name);
        this.i = (TextView) findViewById(c.e.tv_viewer_num);
        this.j = (TextView) findViewById(c.e.tv_likes_num);
        this.k = (ChronometerView) findViewById(c.e.cv_anchor_charger_time);
        this.l = findViewById(c.e.anchor_charger_time_divider);
        this.m = (LinearLayout) findViewById(c.e.ll_anchor_info);
        this.n = (LinearLayout) findViewById(c.e.ll_audience_info);
        this.o = (TextView) findViewById(c.e.tv_audience_viewer_num);
        this.p = (RobotoTextView) findViewById(c.e.btn_follow);
        this.p.setOnClickListener(this);
        this.f28864g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.j.setText(String.format(b.e(c.g.live_streaming_txt_like), new Object[]{String.valueOf(0)}));
        this.i.setText(String.format(b.e(c.g.live_streaming_txt_viewer), new Object[]{String.valueOf(0)}));
    }

    public void setData(LiveStreamingSessionEntity.Session session) {
        String username = session.getUsername();
        if (!d.a(session.getNickname())) {
            username = session.getNickname();
        }
        a(session.getShop_id(), session.getAvatar(), username, session.getLike_cnt(), session.getMember_cnt());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
    }

    private void a(int i2, String str, String str2, int i3, int i4) {
        if (!d.a(str)) {
            w.a(getContext()).a(p.a(str)).a(c.d.live_streaming_ic_default_portrait).b(c.d.live_streaming_ic_default_portrait).a(this.f28864g);
        }
        if (!d.a(str2)) {
            this.h.setText(str2);
        }
        if (q.b(this.r)) {
            this.j.setText(String.format(b.e(c.g.live_streaming_txt_like), new Object[]{String.valueOf(0)}));
            this.i.setText(String.format(b.e(c.g.live_streaming_txt_viewer), new Object[]{String.valueOf(0)}));
        } else if (q.d(this.r)) {
            long j2 = (long) i4;
            this.v = j2;
            if (this.w + j2 > 1) {
                this.o.setText(String.format(b.e(c.g.live_streaming_txt_viewers), new Object[]{ab.a(String.valueOf(j2 + this.w), 1)}));
            } else {
                this.o.setText(String.format(b.e(c.g.live_streaming_txt_viewer), new Object[]{String.valueOf(j2 + this.w)}));
            }
        } else {
            this.o.setVisibility(4);
        }
        this.s = i2;
    }

    public void a(PollingRoomInfoEntity pollingRoomInfoEntity) {
        this.v = (long) pollingRoomInfoEntity.session_member_cnt;
        if (q.b(this.r)) {
            if (this.v + this.w > 1) {
                this.i.setText(String.format(b.e(c.g.live_streaming_txt_viewers), new Object[]{ab.a(String.valueOf(this.v + this.w), 1)}));
            } else {
                this.i.setText(String.format(b.e(c.g.live_streaming_txt_viewer), new Object[]{String.valueOf(this.v + this.w)}));
            }
            long session_like_cnt = (long) pollingRoomInfoEntity.getSession_like_cnt();
            if (session_like_cnt > this.x) {
                this.x = session_like_cnt;
                if (session_like_cnt > 1) {
                    this.j.setText(String.format(b.e(c.g.live_streaming_txt_likes), new Object[]{ab.a(String.valueOf(pollingRoomInfoEntity.session_like_cnt), 1)}));
                    return;
                }
                this.j.setText(String.format(b.e(c.g.live_streaming_txt_like), new Object[]{String.valueOf(pollingRoomInfoEntity.session_like_cnt)}));
            }
        } else if (q.c(this.r) || q.d(this.r)) {
            this.o.setVisibility(0);
            if (this.v + this.w > 1) {
                this.o.setText(String.format(b.e(c.g.live_streaming_txt_viewers), new Object[]{ab.a(String.valueOf(this.v + this.w), 1)}));
                return;
            }
            this.o.setText(String.format(b.e(c.g.live_streaming_txt_viewer), new Object[]{String.valueOf(this.v + this.w)}));
        }
    }

    public void setViewerCount(long j2) {
        this.w = j2;
        if (this.v + this.w > 1) {
            this.o.setText(String.format(b.e(c.g.live_streaming_txt_viewers), new Object[]{ab.a(String.valueOf(this.v + this.w), 1)}));
            return;
        }
        this.o.setText(String.format(b.e(c.g.live_streaming_txt_viewer), new Object[]{String.valueOf(this.v + this.w)}));
    }

    public long getMemberCount() {
        return this.v;
    }

    public void b() {
        this.r = 17;
        f();
    }

    public void c() {
        this.r = 18;
        f();
    }

    public void d() {
        this.r = 20;
        f();
    }

    public void e() {
        this.r = 21;
        f();
    }

    public void f() {
        int i2 = this.r;
        boolean z = i2 == 20 || i2 == 21;
        this.m.setVisibility(z ? 8 : 0);
        this.n.setVisibility(z ? 0 : 8);
        int i3 = this.r;
        if (i3 == 18) {
            setChargerTimeVisibility(0);
        } else if (i3 == 17) {
            setChargerTimeVisibility(8);
        }
        l();
    }

    public void onClick(View view) {
        if (view.getId() == c.e.btn_follow) {
            y.a((Activity) getContext(), new y.a() {
                public void b() {
                }

                public void a() {
                    if (!LivePageAnchorInfoView.this.t && LivePageAnchorInfoView.this.u != null) {
                        LivePageAnchorInfoView.this.setFollowingStatus(true);
                        LivePageAnchorInfoView.this.u.a(LivePageAnchorInfoView.this.t);
                    }
                }
            });
        } else if ((view.getId() == c.e.iv_anchor_portrait || view.getId() == c.e.tv_anchor_name) && this.u != null) {
            int i2 = this.r;
            if (i2 == 20 || i2 == 21) {
                this.u.a(this.s);
            }
        }
    }

    private void l() {
        if (this.t) {
            this.p.setText(b.e(c.g.live_streaming_viewer_btn_following));
            this.p.setBackgroundResource(c.d.live_streaming_bg_follow_disabled);
            return;
        }
        RobotoTextView robotoTextView = this.p;
        robotoTextView.setText("+ " + b.e(c.g.live_streaming_viewer_btn_follow));
        this.p.setBackgroundResource(c.d.live_streaming_bg_follow);
    }

    public void g() {
        this.p.setVisibility(0);
    }

    public void setFollowingStatus(boolean z) {
        this.t = z;
        l();
    }

    public void setFollowButtonClickable(boolean z) {
        this.p.setClickable(z);
    }

    public void setClickListener(a aVar) {
        this.u = aVar;
    }

    public void setChargerTimeVisibility(int i2) {
        this.k.setVisibility(i2);
        this.l.setVisibility(i2);
    }

    public void a(long j2) {
        if (this.r == 18) {
            this.k.a(j2);
        }
    }

    public void h() {
        if (this.r == 18) {
            this.k.a();
        }
    }

    public void i() {
        this.k.b();
    }

    public void j() {
        this.k.b();
    }

    public ImageView getAnchorPortrait() {
        return this.f28864g;
    }
}
