package com.shopee.live.livestreaming.network.task;

import android.content.Context;
import com.google.a.f;
import com.shopee.live.livestreaming.data.entity.DanmaKuContentEntity;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity;
import com.shopee.live.livestreaming.data.entity.require.BanRequireEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.h;
import com.shopee.live.livestreaming.util.x;
import com.shopee.liveimsdk.custom.a;
import com.shopee.liveimsdk.custom.a.a;
import com.shopee.liveimsdk.custom.b;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class GetPollingMessageTask extends AbstractInteractor<Data, Callback> {
    private static final long DANMAKU_RECEIVE_TIMESTAMP = 200;
    public static final int MESSAGE_BAN_COMMENT = 0;
    public static final int MESSAGE_REJECT_RULE = 1;
    /* access modifiers changed from: private */
    public long currentMillTime;
    private Context mContext;
    private a mCustomChatGroupManager;

    public interface Callback {
        void onError(int i, String str);

        void receiveBanCommentMessage(a.b bVar);

        void receiveBarrageMessage(DanmaKuEntity danmaKuEntity);

        void receiveOtherSystemMessage(a.b bVar);

        void receiveRejectRuleMessage(a.b bVar);

        void updateScreenMessage(PollingRoomInfoEntity pollingRoomInfoEntity);
    }

    public GetPollingMessageTask(Executor executor, Context context) {
        super(executor);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        if (this.mCustomChatGroupManager == null) {
            this.mCustomChatGroupManager = new com.shopee.liveimsdk.custom.a(new b() {
                public void onJoinGroupFailed(String str) {
                }

                public void onJoinGroupSucceed(String str) {
                }

                public void onLoginFailed() {
                }

                public void onLoginSucceed() {
                }

                public void onSendError(String str, String str2) {
                }

                public void onSendSucess(String str, String str2) {
                }

                public void onDanmaKuReceive(a.d dVar) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - GetPollingMessageTask.this.currentMillTime >= GetPollingMessageTask.DANMAKU_RECEIVE_TIMESTAMP) {
                        long unused = GetPollingMessageTask.this.currentMillTime = currentTimeMillis;
                        GetPollingMessageTask.this.handleDanmakuMessage(dVar, callback);
                    }
                }

                public void onReceivePublicScreenMessage(com.shopee.liveimsdk.custom.a.a aVar) {
                    GetPollingMessageTask.this.handleSystemMessage(aVar, callback);
                }
            });
        }
        this.mCustomChatGroupManager.a(this.mContext, 0);
        com.shopee.sdk.modules.app.e.a e2 = x.e();
        if (e2 != null) {
            this.mCustomChatGroupManager.a(new com.shopee.liveimsdk.b().a(true).a(x.b()).b(x.a()).a(e2.a()).d(e2.c()).f(h.a()).g(e2.d()).c(x.c()).h("SPIM-5C12301177"));
            this.mCustomChatGroupManager.a();
        }
    }

    /* access modifiers changed from: private */
    public void handleSystemMessage(com.shopee.liveimsdk.custom.a.a aVar, final Callback callback) {
        if (aVar != null) {
            if (aVar.f29587e != null) {
                notify(new Runnable() {
                    public void run() {
                    }
                });
            }
            if (aVar.f29586d != null && aVar.f29586d.size() > 0) {
                for (int i = 0; i < aVar.f29586d.size(); i++) {
                    a.C0451a aVar2 = aVar.f29586d.get(i);
                    for (int i2 = 0; i2 < aVar2.f29590a.size(); i2++) {
                        final a.b bVar = aVar2.f29590a.get(i2);
                        if (!d.a(bVar.f29591a)) {
                            if (i == 0) {
                                notify(new Runnable() {
                                    public void run() {
                                        callback.receiveBanCommentMessage(bVar);
                                    }
                                });
                            } else if (i != 1) {
                                notify(new Runnable() {
                                    public void run() {
                                        callback.receiveOtherSystemMessage(bVar);
                                    }
                                });
                            } else {
                                notify(new Runnable() {
                                    public void run() {
                                        callback.receiveRejectRuleMessage(bVar);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleDanmakuMessage(a.d dVar, final Callback callback) {
        if (!d.a(dVar.f29597e)) {
            DanmaKuContentEntity a2 = h.a(dVar.f29597e);
            if (a2 != null && !d.a(a2.getContent())) {
                final DanmaKuEntity danmaKuEntity = new DanmaKuEntity();
                danmaKuEntity.setMessageType(a2.getType());
                danmaKuEntity.setContent(a2.getContent());
                danmaKuEntity.setId(dVar.f29593a);
                danmaKuEntity.setAvatar(dVar.f29596d);
                danmaKuEntity.setNickname(h.a(dVar));
                danmaKuEntity.setUid(dVar.f29594b);
                notify(new Runnable() {
                    public void run() {
                        callback.receiveBarrageMessage(danmaKuEntity);
                    }
                });
            }
        }
    }

    public static class Data {
        private RequestBody requestBody;
        private int session_id;

        public Data(int i, int i2) {
            this.session_id = i;
            BanRequireEntity banRequireEntity = new BanRequireEntity();
            banRequireEntity.setBan_uid((long) i2);
            this.requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new f().b((Object) banRequireEntity));
            this.requestBody = h.a((Object) banRequireEntity);
        }
    }
}
