package com.shopee.livequiz.ui.b;

import android.content.Context;
import android.util.SparseBooleanArray;
import com.shopee.livequiz.b.e;
import com.shopee.livequiz.c.f;
import com.shopee.livequiz.d.a;
import com.shopee.livequiz.d.c;
import com.shopee.livequiz.data.bean.GameData;
import com.shopee.livequiz.data.bean.GameModel;
import com.shopee.livequiz.data.bean.LiveParams;
import com.shopee.livequiz.f.a;
import com.shopee.livequiz.f.b;
import com.shopee.livequiz.g.g;
import com.shopee.livequiz.ui.view.panel.d;
import com.squareup.a.w;

public class b extends com.shopee.livequiz.a.b<com.shopee.livequiz.ui.activity.b> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public GameModel f29925b = new GameModel();

    /* renamed from: c  reason: collision with root package name */
    private a f29926c;

    /* renamed from: d  reason: collision with root package name */
    private com.shopee.livequiz.f.b f29927d;

    /* renamed from: e  reason: collision with root package name */
    private com.shopee.livequiz.f.a f29928e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f29929f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f29930g;
    private boolean h;
    private boolean i;
    private GameData j;
    private GameData k;
    /* access modifiers changed from: private */
    public int l = 0;
    private SparseBooleanArray m;
    private long n;
    private com.shopee.livequiz.b.a o;

    public b() {
        this.f29925b.isLogin = g.c();
        this.f29925b.eventId = com.shopee.livequiz.data.b.a().b().eventId;
        this.f29925b.sessionId = com.shopee.livequiz.data.b.a().b().sessionId;
        this.f29925b.userName = g.e();
        this.f29925b.state = g.d() ? 3 : 1;
        this.f29925b.extraLifeBalance = com.shopee.livequiz.data.b.a().b().extraLifeBalance;
        this.f29925b.extraLifeLimit = com.shopee.livequiz.data.b.a().b().extraLifeLimit;
        this.f29927d = new com.shopee.livequiz.f.b(com.shopee.livequiz.c.g.a());
        this.f29928e = new com.shopee.livequiz.f.a(com.shopee.livequiz.c.g.a());
        this.m = new SparseBooleanArray();
        this.o = new com.shopee.livequiz.b.a();
    }

    public void a(com.shopee.livequiz.ui.activity.b bVar) {
        super.a(bVar);
        m();
    }

    public void a() {
        super.a();
        a aVar = this.f29926c;
        if (aVar != null) {
            aVar.c();
            this.f29926c = null;
        }
    }

    /* renamed from: c */
    public com.shopee.livequiz.ui.activity.b b() {
        return com.shopee.livequiz.g.a.a((com.shopee.livequiz.ui.activity.b) super.b());
    }

    public GameModel d() {
        return this.f29925b;
    }

    public void a(final int i2, int i3, final int i4) {
        final boolean f2 = com.shopee.livequiz.data.a.f(this.f29925b, i2);
        if (f2 || i4 != -1) {
            this.l = i4;
            if (i4 != -1) {
                e.a(i3, i2, i4, f2);
            }
            new c(i3, i2, i4, f2).a((c.a) new c.a() {
                public void a() {
                    com.shopee.livequiz.data.a.a(b.this.f29925b, i2, i4);
                    int unused = b.this.l = 0;
                    b.this.f();
                }

                public void b() {
                    b.this.a(i2, f2 && i4 == -1);
                    int unused = b.this.l = 0;
                    b.this.f();
                }
            });
        }
    }

    public void a(int i2, boolean z) {
        if (!this.m.get(i2, false)) {
            this.m.put(i2, true);
            com.shopee.livequiz.data.a.b(this.f29925b, i2 - 1);
            b().i();
            b().a(com.shopee.livequiz.g.e.a().a(z ? "t_neg_fail_to_use_life_msg" : "t_neg_fail_to_send_msg"));
            e.a(z ? "post_extra_life_failed" : "post_answer_failed");
        }
    }

    public void e() {
        if (com.shopee.livequiz.data.b.a().b().ifPollingIM) {
            int i2 = com.shopee.livequiz.data.b.a().b().pollingTimeInterval;
            long j2 = com.shopee.livequiz.data.b.a().b().intervalOfPollingIM;
            if (j2 <= 0) {
                j2 = (long) (i2 > 0 ? i2 * 1000 : 5000);
            }
            long j3 = j2;
            if (this.f29926c == null) {
                this.f29926c = new a(com.shopee.livequiz.data.b.a().c(), com.shopee.livequiz.data.b.a().d(), j3, com.shopee.livequiz.data.b.a().b().timeoutOfPollingIM);
                this.f29926c.a((a.C0455a) new a.C0455a() {
                    public void a(GameData gameData) {
                        if (gameData != null) {
                            b.this.a(gameData, true);
                            b.this.a(gameData);
                        }
                    }

                    public void a() {
                        com.garena.android.appkit.d.a.a("Get issue failed", new Object[0]);
                    }
                });
            }
            this.f29926c.a();
        }
    }

    private void m() {
        this.f29928e.b(null, new a.C0457a() {
            public void a(GameModel gameModel) {
                if (gameModel != null && gameModel.userName != null && gameModel.isLogin == b.this.f29925b.isLogin && gameModel.userName.equals(g.e()) && gameModel.eventId == com.shopee.livequiz.data.b.a().b().eventId && gameModel.sessionId == com.shopee.livequiz.data.b.a().b().sessionId) {
                    GameModel unused = b.this.f29925b = gameModel;
                    b.this.f29925b.state = gameModel.state == 0 ? 1 : gameModel.state;
                    com.garena.android.appkit.d.a.b("GamePresenter %s", "Restore game state: " + b.this.f29925b.state);
                }
                b.this.b().E_();
            }
        });
    }

    public void f() {
        this.f29927d.b(new b.C0458b(this.f29925b), null);
    }

    public void g() {
        if (this.f29925b.state == 1 || this.f29925b.state == 2) {
            this.f29925b.state = 3;
        }
        this.f29927d.b(new b.C0458b(this.f29925b), new b.a() {
            public void a() {
                b.this.b().e();
            }
        });
    }

    public void h() {
        this.f29927d.b(new b.C0458b(this.f29925b), new b.a() {
            public void a() {
                b.this.p();
                b.this.b().f();
            }
        });
    }

    public void a(long j2) {
        this.n = j2;
    }

    public void a(GameData gameData, boolean z) {
        if (z) {
            try {
                this.o.b(gameData);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            this.o.a(gameData);
        }
    }

    public void a(final GameData gameData) {
        if (gameData.msg_body == null) {
            gameData.msg_body = new GameData.MSgBody();
        }
        int f2 = f(gameData);
        if (f2 > this.f29925b.issueIndex) {
            this.f29925b.issueIndex = f2;
            long j2 = 0;
            if (c(gameData) && LiveParams.SYNC_TYPE_APP.equals(com.shopee.livequiz.data.b.a().b().syncType) && this.i) {
                j2 = Math.max(0, Math.min((gameData.msg_body.timestamp * 1000) - this.n, 5000));
            }
            f.b(new com.shopee.livequiz.c.e() {
                public void a() {
                    b.this.b(gameData);
                }
            }, j2);
        }
        e.a(gameData.msg_type, gameData.msg_body != null ? gameData.msg_body.sn : 0);
    }

    public void i() {
        GameData gameData = this.k;
        if (gameData != null) {
            b(gameData);
            this.k = null;
        }
    }

    public void j() {
        GameData gameData = this.j;
        if (gameData != null) {
            b(gameData);
            this.j = null;
        }
    }

    public void b(GameData gameData) {
        boolean z = true;
        if (GameData.TYPE_QUEATION.equals(gameData.msg_type)) {
            if (b().h() && gameData.msg_body != null && gameData.msg_body.sn - this.f29925b.sn == 1) {
                this.k = gameData;
                return;
            } else if (d(gameData)) {
                n();
            }
        } else if (GameData.TYPE_ANSWER.equals(gameData.msg_type)) {
            if (b().g()) {
                this.j = gameData;
                return;
            }
            if (this.l != 0) {
                com.shopee.livequiz.data.a.b(this.f29925b, gameData.msg_body.sn - 1);
            }
            if (e(gameData)) {
                if (this.l != 0) {
                    int i2 = gameData.msg_body.sn;
                    if (this.l != -1 || !com.shopee.livequiz.data.a.f(this.f29925b, gameData.msg_body.sn)) {
                        z = false;
                    }
                    a(i2, z);
                    f.b(new com.shopee.livequiz.c.e() {
                        public void a() {
                            b.this.o();
                        }
                    }, 2000);
                } else {
                    o();
                }
            }
        } else if (GameData.TYPE_SESSION_RESULT.equals(gameData.msg_type)) {
            b().a(gameData.msg_body.winners, gameData.msg_body.each_coins);
        } else if (GameData.TYPE_HIDE_RESULT.equals(gameData.msg_type)) {
            b().F_();
        } else if (GameData.TYPE_END_LIVE.equals(gameData.msg_type)) {
            b().d();
        }
        b().i();
        f();
    }

    private boolean c(GameData gameData) {
        return GameData.TYPE_QUEATION.equals(gameData.msg_type) || GameData.TYPE_ANSWER.equals(gameData.msg_type);
    }

    private boolean d(GameData gameData) {
        boolean z = false;
        if (gameData.msg_body == null) {
            return false;
        }
        int i2 = this.f29925b.sn;
        GameData c2 = com.shopee.livequiz.data.a.c(this.f29925b, i2);
        GameData d2 = com.shopee.livequiz.data.a.d(this.f29925b, i2);
        this.f29925b.sn = gameData.msg_body.sn;
        com.shopee.livequiz.data.a.a(this.f29925b, gameData);
        if (gameData.msg_body.sn - i2 > 1 || (c2 != null && d2 == null)) {
            z = true;
        }
        if (z && this.f29925b.state == 1) {
            this.f29925b.state = 2;
        }
        if (this.f29925b.state != 1) {
            this.h = true;
        }
        return true;
    }

    private boolean e(GameData gameData) {
        if (gameData.msg_body == null) {
            return false;
        }
        int i2 = this.f29925b.sn;
        this.f29925b.sn = gameData.msg_body.sn;
        com.shopee.livequiz.data.a.a(this.f29925b, gameData);
        if (this.f29925b.state != 1) {
            this.h = true;
            this.f29929f = false;
            this.f29930g = false;
            return true;
        } else if (com.shopee.livequiz.data.a.c(this.f29925b, i2) == null) {
            GameModel gameModel = this.f29925b;
            gameModel.state = 2;
            if (gameModel.sn == 1) {
                this.h = true;
                this.f29930g = false;
                this.f29929f = false;
            } else {
                this.h = true;
                this.f29930g = false;
                this.f29929f = false;
            }
            return true;
        } else if (this.f29925b.sn != i2) {
            this.f29925b.state = 2;
            this.h = true;
            this.f29929f = false;
            this.f29930g = false;
            return true;
        } else {
            if (com.shopee.livequiz.data.a.e(this.f29925b, gameData.msg_body.sn) != gameData.msg_body.correct_answer_id) {
                if (gameData.msg_body.sn >= com.shopee.livequiz.data.b.a().b().questionNum || com.shopee.livequiz.data.a.d(this.f29925b) <= 0 || com.shopee.livequiz.data.a.e(this.f29925b)) {
                    this.f29925b.state = 2;
                } else {
                    this.f29925b.state = 4;
                }
                this.h = false;
                this.f29930g = true;
                this.f29929f = false;
            } else {
                this.h = false;
                this.f29930g = false;
                this.f29929f = true;
                this.f29925b.correctNum++;
            }
            return true;
        }
    }

    private void n() {
        b().a(new com.shopee.livequiz.ui.view.panel.c(this.f29925b.clone(), this.h, false, false));
    }

    /* access modifiers changed from: private */
    public void o() {
        b().b(new d(this.f29925b.clone(), this.h, this.f29929f, this.f29930g));
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void k() {
        this.f29925b.state = 1;
        b().i();
        f();
    }

    public void l() {
        this.f29925b.state = 2;
        b().i();
        f();
    }

    /* access modifiers changed from: private */
    public void p() {
        Context c2 = com.shopee.livequiz.b.a().c();
        com.shopee.livequiz.g.e a2 = com.shopee.livequiz.g.e.a();
        w.a(c2).b(a2.c("ls_turnoff_bg"));
        w.a(c2).b(a2.c("ls_winner_result_bg"));
        w.a(c2).b(a2.c("ls_close_btn_bg"));
        w.a(c2).b(a2.c("ls_loser_result_bg"));
        w.a(c2).b(a2.c("ls_login_popup_bg"));
        w.a(c2).b(a2.c("ls_login_popup_btn_bg"));
        w.a(c2).b(a2.c("ls_session_result_bg"));
    }

    private int f(GameData gameData) {
        if (gameData == null) {
            return -1;
        }
        if (GameData.TYPE_QUEATION.equals(gameData.msg_type)) {
            if (gameData.msg_body == null || gameData.msg_body.sn <= 0) {
                return -1;
            }
            return gameData.msg_body.sn * 10;
        } else if (GameData.TYPE_ANSWER.equals(gameData.msg_type)) {
            if (gameData.msg_body == null || gameData.msg_body.sn <= 0) {
                return -1;
            }
            return (gameData.msg_body.sn * 10) + 5;
        } else if (GameData.TYPE_SESSION_RESULT.equals(gameData.msg_type)) {
            return 9999997;
        } else {
            if (GameData.TYPE_HIDE_RESULT.equals(gameData.msg_type)) {
                return 9999998;
            }
            return GameData.TYPE_END_LIVE.equals(gameData.msg_type) ? 9999999 : 0;
        }
    }
}
