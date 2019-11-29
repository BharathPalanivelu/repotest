package com.shopee.live.livestreaming.ui.view.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.h;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.live.livestreaming.a.d;
import com.shopee.live.livestreaming.a.f;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.BanUserCommentTask;
import com.shopee.live.livestreaming.ui.view.MyTextView;
import com.shopee.live.livestreaming.ui.view.c.a;
import com.shopee.live.livestreaming.util.x;
import com.shopee.sdk.modules.ui.a.a;

public class b extends d<DanmaKuEntity> {

    /* renamed from: e  reason: collision with root package name */
    private BanUserCommentTask f29198e = InjectorUtils.provideBanUserCommentTask();

    /* renamed from: f  reason: collision with root package name */
    private int f29199f;

    /* renamed from: g  reason: collision with root package name */
    private String f29200g = "";
    private int h;

    public b(Context context) {
        super(context);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 100 || i == 101) {
            return new a(this.f28753c.inflate(c.f.live_streaming_layout_danmaku_item, viewGroup, false));
        }
        if (i != 201) {
            return null;
        }
        return new C0443b(this.f28753c.inflate(c.f.live_streaming_layout_danmaku_public_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i) {
        DanmaKuEntity danmaKuEntity = (DanmaKuEntity) this.f28752b.get(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType == 100 || itemViewType == 101) {
            a(wVar, danmaKuEntity);
        } else if (itemViewType == 201) {
            b(wVar, danmaKuEntity);
        }
    }

    private void a(RecyclerView.w wVar, final DanmaKuEntity danmaKuEntity) {
        final a aVar = (a) wVar;
        if (x.d()) {
            aVar.f29209b.setLineSpacing(BitmapDescriptorFactory.HUE_RED, 1.2f);
        }
        String str = SQLBuilder.BLANK + com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_msg_role_tag) + SQLBuilder.BLANK;
        if (danmaKuEntity.isAuchorMessage()) {
            com.shopee.live.livestreaming.ui.view.d.b.a(this.f28751a, aVar.f29209b, str, SQLBuilder.BLANK + this.f29200g, danmaKuEntity.getContent(), 11.0f, 12.0f, 14, 6);
        } else if (danmaKuEntity.isAudienceMessage()) {
            com.shopee.live.livestreaming.ui.view.d.b.a(this.f28751a, aVar.f29209b, danmaKuEntity.getNickname(), danmaKuEntity.getContent(), 12.0f, 14);
        }
        if (danmaKuEntity.isAudienceMessage() && this.h != 20) {
            aVar.f29209b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    final com.shopee.live.livestreaming.ui.view.c.a aVar = new com.shopee.live.livestreaming.ui.view.c.a(b.this.f28751a);
                    aVar.a(new a.C0447a() {
                        public void a() {
                            b.this.a(danmaKuEntity);
                            aVar.dismiss();
                        }
                    });
                    aVar.getContentView().measure(b.e(aVar.getWidth()), b.e(aVar.getHeight()));
                    h.a(aVar, aVar.f29209b, 0, -(aVar.getContentView().getMeasuredHeight() + aVar.f29209b.getHeight()), 8388611);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(final DanmaKuEntity danmaKuEntity) {
        com.shopee.sdk.b.a().c().a((Activity) this.f28751a, new a.C0472a().c(com.garena.android.appkit.tools.b.e(c.g.live_streaming_btn_confirm)).d(com.garena.android.appkit.tools.b.e(c.g.live_streaming_btn_cancel)).b(String.format(com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_msg_ban_confirm_text), new Object[]{danmaKuEntity.getNickname()})).a(), new com.shopee.sdk.f.b<Integer>() {
            public void a(int i, String str) {
            }

            public void a(Integer num) {
                if (num.intValue() == 1) {
                    b.this.a(danmaKuEntity.getUid());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(long j) {
        this.f29198e.execute(new BanUserCommentTask.Data(this.f29199f, j), new BanUserCommentTask.Callback() {
            public void onError(int i, String str) {
            }
        });
    }

    /* access modifiers changed from: private */
    public static int e(int i) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), i == -2 ? 0 : 1073741824);
    }

    private void b(RecyclerView.w wVar, DanmaKuEntity danmaKuEntity) {
        C0443b bVar = (C0443b) wVar;
        if (!com.shopee.live.livestreaming.util.d.a(danmaKuEntity.getContent())) {
            MyTextView myTextView = bVar.f29210b;
            myTextView.setText("       " + danmaKuEntity.getContent());
        }
    }

    public int getItemViewType(int i) {
        DanmaKuEntity danmaKuEntity = (DanmaKuEntity) this.f28752b.get(i);
        if (danmaKuEntity.isAudienceMessage()) {
            return 100;
        }
        if (danmaKuEntity.isAuchorMessage()) {
            return 101;
        }
        if (danmaKuEntity.isPublicMessge()) {
            return DanmaKuEntity.MESSAGE_PUBLIC;
        }
        return 0;
    }

    static class a extends f {

        /* renamed from: b  reason: collision with root package name */
        TextView f29209b = ((TextView) a(c.e.tv_message));

        public a(View view) {
            super(view);
        }
    }

    /* renamed from: com.shopee.live.livestreaming.ui.view.a.b$b  reason: collision with other inner class name */
    static class C0443b extends f {

        /* renamed from: b  reason: collision with root package name */
        MyTextView f29210b = ((MyTextView) a(c.e.danmaku_msg));

        public C0443b(View view) {
            super(view);
        }
    }

    public void b(int i) {
        this.f29199f = i;
    }

    public void a(LiveStreamingSessionEntity.Session session) {
        if (!com.shopee.live.livestreaming.util.d.a(session.getNickname())) {
            this.f29200g = session.getNickname();
        } else if (!com.shopee.live.livestreaming.util.d.a(session.getUsername())) {
            this.f29200g = session.getUsername();
        }
    }

    public void c(int i) {
        this.h = i;
    }
}
