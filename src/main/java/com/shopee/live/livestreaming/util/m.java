package com.shopee.live.livestreaming.util;

import android.content.Context;
import com.google.a.f;
import com.shopee.live.livestreaming.data.entity.DanmaKuContentEntity;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.shopee.live.livestreaming.data.entity.EtoeMessageItem;
import com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity;
import com.shopee.live.livestreaming.data.entity.SendMessage;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.SendMessageTask;
import com.shopee.liveimsdk.custom.a.a;
import com.shopee.liveimsdk.custom.b;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private com.shopee.liveimsdk.custom.a f29458a;

    /* renamed from: b  reason: collision with root package name */
    private long f29459b;

    /* renamed from: c  reason: collision with root package name */
    private Context f29460c;

    /* renamed from: d  reason: collision with root package name */
    private String f29461d;

    /* renamed from: e  reason: collision with root package name */
    private int f29462e;

    /* renamed from: f  reason: collision with root package name */
    private String f29463f;

    /* renamed from: g  reason: collision with root package name */
    private long f29464g;
    private SendMessageTask h = InjectorUtils.provideSendMessageTask();

    public interface a {
        void a(long j, DanmaKuContentEntity danmaKuContentEntity);

        void a(DanmaKuEntity danmaKuEntity);

        void a(EtoeMessageItem etoeMessageItem);

        void a(PollingRoomInfoEntity pollingRoomInfoEntity);

        void a(PollingRoomInfoEntity pollingRoomInfoEntity, SessionProductEntity.ProductItem productItem);

        void a(VoucherEntity voucherEntity, long j, int i);

        void b(EtoeMessageItem etoeMessageItem);

        void c(EtoeMessageItem etoeMessageItem);

        void d(EtoeMessageItem etoeMessageItem);

        void e(EtoeMessageItem etoeMessageItem);
    }

    public m(Context context) {
        this.f29460c = context;
    }

    public void a(int i) {
        this.f29462e = i;
    }

    public void a(long j) {
        this.f29464g = j;
    }

    public void a(String str) {
        this.f29461d = str;
    }

    public void b(String str) {
        this.f29463f = str;
    }

    public void c(String str) {
        if (this.f29458a != null) {
            com.shopee.e.a.a.c("GetPollingMessageManage %s", "sendAnchorMessage: ");
            SendMessage sendMessage = new SendMessage();
            sendMessage.setType(101);
            sendMessage.setContent(str);
            this.h.execute(new SendMessageTask.Data(this.f29463f, this.f29462e, x.c(), new f().b((Object) sendMessage)), new SendMessageTask.Callback() {
                public void onSucceess() {
                    com.shopee.e.a.a.c("GetPollingMessageManage %s", "send anchor message successfully.");
                }

                public void onFailed(int i) {
                    com.shopee.e.a.a.c("GetPollingMessageManage %s", "send anchor message failed, code = " + i);
                }
            });
        }
    }

    public void d(String str) {
        if (this.f29458a != null) {
            com.shopee.e.a.a.c("GetPollingMessageManage %s", "sendAudienceMessage: ");
            SendMessage sendMessage = new SendMessage();
            sendMessage.setType(100);
            sendMessage.setContent(str);
            this.h.execute(new SendMessageTask.Data(this.f29463f, this.f29462e, x.c(), new f().b((Object) sendMessage)), new SendMessageTask.Callback() {
                public void onSucceess() {
                    com.shopee.e.a.a.c("GetPollingMessageManage %s", "send audience message successfully.");
                }

                public void onFailed(int i) {
                    com.shopee.e.a.a.c("GetPollingMessageManage %s", "send audience message failed, code = " + i);
                }
            });
        }
    }

    public void a(final a aVar) {
        if (this.f29458a == null) {
            this.f29458a = new com.shopee.liveimsdk.custom.a(new b() {
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
                    m.this.a(dVar, aVar);
                }

                public void onReceivePublicScreenMessage(com.shopee.liveimsdk.custom.a.a aVar) {
                    m.this.a(aVar, aVar);
                }
            });
        }
        this.f29458a.a(this.f29460c, 0);
        com.shopee.sdk.modules.app.e.a a2 = com.shopee.sdk.b.a().d().a();
        this.f29458a.a(new com.shopee.liveimsdk.b().a(false).a(x.b()).b(x.a()).a(a2.a()).d(a2.c()).f(h.a()).g(a2.d()).c(x.c()).h(this.f29461d));
        this.f29458a.a(this.f29464g);
    }

    public void a() {
        com.shopee.liveimsdk.custom.a aVar = this.f29458a;
        if (aVar != null) {
            aVar.e();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        if (r0.getReward_type() == 2) goto L_0x0097;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.shopee.liveimsdk.custom.a.a r11, com.shopee.live.livestreaming.util.m.a r12) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0111
            com.shopee.liveimsdk.custom.a.a$e r0 = r11.f29587e
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L_0x00a6
            com.shopee.liveimsdk.custom.a.a$e r0 = r11.f29587e
            java.lang.String r0 = r0.f29598a
            boolean r0 = com.shopee.live.livestreaming.util.d.a((java.lang.String) r0)
            if (r0 != 0) goto L_0x00a6
            com.google.a.f r0 = new com.google.a.f
            r0.<init>()
            com.shopee.liveimsdk.custom.a.a$e r3 = r11.f29587e
            java.lang.String r3 = r3.f29598a
            java.lang.Class<com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity> r4 = com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity.class
            java.lang.Object r3 = r0.a((java.lang.String) r3, r4)
            com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity r3 = (com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity) r3
            if (r3 == 0) goto L_0x00a6
            int r4 = r3.getSession_id()
            if (r4 <= 0) goto L_0x0038
            int r5 = r10.f29462e
            if (r5 <= 0) goto L_0x0038
            if (r4 <= r5) goto L_0x0035
            r12.a((com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity) r3)
            goto L_0x0038
        L_0x0035:
            if (r4 >= r5) goto L_0x0038
            return
        L_0x0038:
            java.lang.String r4 = r3.getSession_show_product()
            boolean r4 = com.shopee.live.livestreaming.util.d.a((java.lang.String) r4)
            r5 = 0
            if (r4 != 0) goto L_0x0053
            java.lang.String r4 = r3.getSession_show_product()
            java.lang.Class<com.shopee.live.livestreaming.data.entity.SessionProductEntity$ProductItem> r6 = com.shopee.live.livestreaming.data.entity.SessionProductEntity.ProductItem.class
            java.lang.Object r4 = r0.a((java.lang.String) r4, r6)
            com.shopee.live.livestreaming.data.entity.SessionProductEntity$ProductItem r4 = (com.shopee.live.livestreaming.data.entity.SessionProductEntity.ProductItem) r4
            r12.a((com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity) r3, (com.shopee.live.livestreaming.data.entity.SessionProductEntity.ProductItem) r4)
            goto L_0x0056
        L_0x0053:
            r12.a((com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity) r3, (com.shopee.live.livestreaming.data.entity.SessionProductEntity.ProductItem) r5)
        L_0x0056:
            boolean r4 = r3.is_end()
            if (r4 == 0) goto L_0x005f
            r12.a((com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity) r3)
        L_0x005f:
            java.lang.String r4 = r3.getSession_show_voucher()
            boolean r4 = com.shopee.live.livestreaming.util.d.a((java.lang.String) r4)
            r6 = 0
            if (r4 != 0) goto L_0x00a3
            java.lang.String r4 = r3.getSession_show_voucher()
            java.lang.Class<com.shopee.live.livestreaming.data.entity.VoucherEntity> r5 = com.shopee.live.livestreaming.data.entity.VoucherEntity.class
            java.lang.Object r4 = r0.a((java.lang.String) r4, r5)
            com.shopee.live.livestreaming.data.entity.VoucherEntity r4 = (com.shopee.live.livestreaming.data.entity.VoucherEntity) r4
            if (r4 == 0) goto L_0x0096
            long r8 = r4.getPromotion_id()
            int r5 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r5 != 0) goto L_0x0096
            java.lang.String r5 = r4.getExtra_voucher()
            java.lang.Class<com.shopee.live.livestreaming.data.entity.VoucherEntity> r6 = com.shopee.live.livestreaming.data.entity.VoucherEntity.class
            java.lang.Object r0 = r0.a((java.lang.String) r5, r6)
            com.shopee.live.livestreaming.data.entity.VoucherEntity r0 = (com.shopee.live.livestreaming.data.entity.VoucherEntity) r0
            if (r0 == 0) goto L_0x0096
            int r5 = r0.getReward_type()
            if (r5 != r1) goto L_0x0096
            goto L_0x0097
        L_0x0096:
            r0 = r4
        L_0x0097:
            long r4 = r3.getShow_voucher_timestamp()
            int r3 = r3.getShow_voucher_duration()
            r12.a(r0, r4, r3)
            goto L_0x00a6
        L_0x00a3:
            r12.a(r5, r6, r2)
        L_0x00a6:
            java.util.List<com.shopee.liveimsdk.custom.a.a$a> r0 = r11.f29586d
            if (r0 == 0) goto L_0x0111
            java.util.List<com.shopee.liveimsdk.custom.a.a$a> r0 = r11.f29586d
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0111
            r0 = 0
        L_0x00b3:
            java.util.List<com.shopee.liveimsdk.custom.a.a$a> r3 = r11.f29586d
            int r3 = r3.size()
            if (r0 >= r3) goto L_0x0111
            java.util.List<com.shopee.liveimsdk.custom.a.a$a> r3 = r11.f29586d
            java.lang.Object r3 = r3.get(r0)
            com.shopee.liveimsdk.custom.a.a$a r3 = (com.shopee.liveimsdk.custom.a.a.C0451a) r3
            r4 = 0
        L_0x00c4:
            java.util.List<com.shopee.liveimsdk.custom.a.a$b> r5 = r3.f29590a
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x010e
            java.util.List<com.shopee.liveimsdk.custom.a.a$b> r5 = r3.f29590a
            java.lang.Object r5 = r5.get(r4)
            com.shopee.liveimsdk.custom.a.a$b r5 = (com.shopee.liveimsdk.custom.a.a.b) r5
            java.lang.String r6 = r5.f29591a
            boolean r6 = com.shopee.live.livestreaming.util.d.a((java.lang.String) r6)
            if (r6 != 0) goto L_0x010b
            com.google.a.f r6 = new com.google.a.f
            r6.<init>()
            java.lang.String r5 = r5.f29591a
            java.lang.Class<com.shopee.live.livestreaming.data.entity.EtoeMessageItem> r7 = com.shopee.live.livestreaming.data.entity.EtoeMessageItem.class
            java.lang.Object r5 = r6.a((java.lang.String) r5, r7)
            com.shopee.live.livestreaming.data.entity.EtoeMessageItem r5 = (com.shopee.live.livestreaming.data.entity.EtoeMessageItem) r5
            int r6 = r5.getType()
            if (r6 == 0) goto L_0x0108
            r7 = 1
            if (r6 == r7) goto L_0x0104
            if (r6 == r1) goto L_0x00fd
            r7 = 3
            if (r6 == r7) goto L_0x0100
            r12.d(r5)
            goto L_0x010b
        L_0x00fd:
            r12.b(r5)
        L_0x0100:
            r12.e(r5)
            goto L_0x010b
        L_0x0104:
            r12.a((com.shopee.live.livestreaming.data.entity.EtoeMessageItem) r5)
            goto L_0x010b
        L_0x0108:
            r12.c(r5)
        L_0x010b:
            int r4 = r4 + 1
            goto L_0x00c4
        L_0x010e:
            int r0 = r0 + 1
            goto L_0x00b3
        L_0x0111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.live.livestreaming.util.m.a(com.shopee.liveimsdk.custom.a.a, com.shopee.live.livestreaming.util.m$a):void");
    }

    /* access modifiers changed from: private */
    public void a(a.d dVar, a aVar) {
        String str = dVar.f29597e;
        if (!d.a(str)) {
            DanmaKuContentEntity a2 = h.a(str);
            if (a2 == null) {
                return;
            }
            if (a2.getType() == 200) {
                a2.setContent(h.a(dVar, a2));
                a(dVar, a2, aVar);
                return;
            }
            b(dVar, a2, aVar);
        }
    }

    private void a(a.d dVar, DanmaKuContentEntity danmaKuContentEntity, a aVar) {
        if (!d.a(danmaKuContentEntity.getContent())) {
            aVar.a(dVar.f29594b, danmaKuContentEntity);
        }
    }

    private void b(a.d dVar, DanmaKuContentEntity danmaKuContentEntity, a aVar) {
        if (!d.a(danmaKuContentEntity.getContent())) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f29459b >= 200) {
                aVar.a(a(dVar, danmaKuContentEntity));
                this.f29459b = currentTimeMillis;
            }
        }
    }

    private DanmaKuEntity a(a.d dVar, DanmaKuContentEntity danmaKuContentEntity) {
        DanmaKuEntity danmaKuEntity = new DanmaKuEntity();
        danmaKuEntity.setMessageType(danmaKuContentEntity.getType());
        danmaKuEntity.setContent(danmaKuContentEntity.getContent());
        danmaKuEntity.setId(dVar.f29593a);
        danmaKuEntity.setAvatar(dVar.f29596d);
        danmaKuEntity.setNickname(h.a(dVar));
        danmaKuEntity.setUid(dVar.f29594b);
        return danmaKuEntity;
    }
}
