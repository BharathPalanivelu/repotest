package com.shopee.livequiz.ui.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.a.o;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.livequiz.a.a;
import com.shopee.livequiz.c;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.data.bean.DanmaKuMessage;
import com.shopee.livequiz.data.bean.GameData;
import com.shopee.livequiz.data.bean.GameModel;
import com.shopee.livequiz.data.bean.LiveParams;
import com.shopee.livequiz.g.d;
import com.shopee.livequiz.g.f;
import com.shopee.livequiz.g.g;
import com.shopee.livequiz.g.i;
import com.shopee.livequiz.g.j;
import com.shopee.livequiz.g.k;
import com.shopee.livequiz.ui.a.a;
import com.shopee.livequiz.ui.b.b;
import com.shopee.livequiz.ui.b.c;
import com.shopee.livequiz.ui.view.AnchorAbsentScreenCoverView;
import com.shopee.livequiz.ui.view.ImageCheckButton;
import com.shopee.livequiz.ui.view.b.c;
import com.shopee.livequiz.ui.view.b.d;
import com.shopee.livequiz.ui.view.b.f;
import com.shopee.livequiz.ui.view.danmaku.DanmaKuView;
import com.shopee.livequiz.ui.view.keyboard.InputMotionLayout;
import com.shopee.livequiz.ui.view.panel.GameQuestionPanel;
import com.shopee.livequiz.ui.view.panel.GameResultPanel;
import com.shopee.sdk.modules.ui.navigator.NavigationPath;
import com.shopee.sdk.modules.ui.navigator.options.PushOption;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class LivePlayerActivity extends a implements a, b, c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b f29881a;
    @BindView
    AnchorAbsentScreenCoverView anchorAbsentScreenCoverView;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public com.shopee.livequiz.ui.b.a f29882b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public c f29883c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public com.shopee.livequiz.ui.a.a f29884d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public f f29885e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f29886f;
    @BindView
    FrameLayout flVideoContainer;

    /* renamed from: g  reason: collision with root package name */
    private boolean f29887g;
    /* access modifiers changed from: private */
    public boolean h;
    private boolean i;
    @BindView
    InputMotionLayout inputMotionLayout;
    /* access modifiers changed from: private */
    public d j;
    private k k = new k(new k.a() {
        public void a() {
            com.shopee.livequiz.c.f.c(new e() {
                public void a() throws Exception {
                    if (LivePlayerActivity.this.f29883c != null && LivePlayerActivity.this.f29881a != null) {
                        LivePlayerActivity.this.f29883c.d();
                        LivePlayerActivity.this.f29883c.e();
                        LivePlayerActivity.this.f29881a.a(true);
                    }
                }
            });
        }
    }, 5000);
    @BindView
    View mBack;
    @BindView
    ImageView mBgImageView;
    @BindView
    DanmaKuView mDanmaKuView;
    @BindView
    ImageView mIvExtraLifeHeart;
    @BindView
    ProgressBar mLoadingProgressBar;
    @BindView
    TextView mMemberNum;
    @BindView
    RelativeLayout mParentView;
    @BindView
    ImageCheckButton mPlayerCheckBtn;
    @BindView
    GameQuestionPanel mQuestionPanel;
    @BindView
    GameResultPanel mResultPanel;
    @BindView
    LinearLayout mStreamTurnOffNotifyLayout;
    @BindView
    RelativeLayout mTextMsgContainer;
    @BindView
    TextView mTurnOffStreamReminder;
    @BindView
    TextView mTurnOnStreamBtn;
    @BindView
    TextView mTvExtraLifeNumber;
    @BindView
    TXCloudVideoView mVideoView;

    public String a() {
        return "ShopeeLiveQuiz";
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        LiveParams liveParams;
        super.onCreate(bundle);
        try {
            liveParams = (LiveParams) a(LiveParams.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            liveParams = null;
        }
        if (liveParams == null) {
            e();
            return;
        }
        com.shopee.livequiz.data.b.a().a(liveParams);
        if (com.shopee.livequiz.data.b.a().e()) {
            setRequestedOrientation(0);
        } else {
            o();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getRequestedOrientation() == 0 && !this.f29887g) {
            o();
            this.mQuestionPanel.a(false);
            this.mResultPanel.a(false);
            if (this.mPlayerCheckBtn.a()) {
                this.f29883c.e();
                this.f29881a.a(true);
            }
            this.f29886f = true;
            if (!g.c()) {
                com.shopee.livequiz.c.f.b(new e() {
                    public void a() {
                        LivePlayerActivity.this.f29885e.a(2);
                    }
                }, 500);
            }
        }
    }

    private void o() {
        setContentView(c.f.livesdk_shopee_activity_player);
        ButterKnife.a((Activity) this);
        k();
        this.f29881a = new b();
        this.f29882b = new com.shopee.livequiz.ui.b.a();
        this.f29883c = new com.shopee.livequiz.ui.b.c(new com.shopee.c.a() {
            public void a(long j) {
                LivePlayerActivity.this.f29881a.a(j);
            }

            public void a() {
                String f2 = LivePlayerActivity.this.f29883c.f();
                if (TextUtils.isEmpty(f2) || "null".equals(f2)) {
                    f2 = j.g(com.shopee.livequiz.data.b.a().b().playUrl);
                }
                com.shopee.livequiz.g.f.a(f2, (f.a) new f.a() {
                    public void a() {
                        if (LivePlayerActivity.this.mPlayerCheckBtn.a()) {
                            LivePlayerActivity.this.j().setVisibility(8);
                            LivePlayerActivity.this.mLoadingProgressBar.setVisibility(8);
                            LivePlayerActivity.this.u();
                        }
                    }

                    public void b() {
                        if (LivePlayerActivity.this.mPlayerCheckBtn.a()) {
                            LivePlayerActivity.this.j().setVisibility(8);
                            LivePlayerActivity.this.mLoadingProgressBar.setVisibility(8);
                            LivePlayerActivity.this.f29881a.a(false);
                            LivePlayerActivity.this.mPlayerCheckBtn.setChecked(false);
                            LivePlayerActivity.this.a(true);
                        }
                    }
                });
            }

            public void b() {
                LivePlayerActivity.this.mLoadingProgressBar.setVisibility(8);
                LivePlayerActivity.this.f29881a.a(false);
                LivePlayerActivity.this.mPlayerCheckBtn.setChecked(false);
                LivePlayerActivity.this.a(true);
            }

            public void c() {
                LivePlayerActivity.this.mLoadingProgressBar.setVisibility(8);
                LivePlayerActivity.this.f29881a.a(true);
                LivePlayerActivity.this.a(true);
            }

            public void d() {
                LivePlayerActivity.this.a(com.shopee.livequiz.g.e.a().a("t_neg_wifi_msg"));
                com.shopee.livequiz.b.e.a("switch_to_wifi_hint");
            }
        });
        this.f29883c.a((c) this);
        this.f29882b.a((a) this);
        this.f29881a.a((b) this);
        com.shopee.livequiz.b.e.a();
        if (g.c()) {
            com.shopee.livequiz.b.e.g();
        }
        this.f29887g = true;
    }

    public void k() {
        q();
        r();
        s();
        p();
        com.shopee.livequiz.g.e.a().a(com.shopee.livequiz.data.b.a().b());
        i.a().b();
        t();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!isFinishing()) {
            com.shopee.livequiz.b.e.i();
        }
        if (this.f29887g) {
            if (!this.f29886f) {
                this.f29886f = true;
            } else if (com.shopee.livequiz.data.b.a().b().sessionEndTime <= 0 || System.currentTimeMillis() <= com.shopee.livequiz.data.b.a().b().sessionEndTime * 1000) {
                this.mQuestionPanel.a(false);
                this.mResultPanel.a(false);
                if (this.mPlayerCheckBtn.a()) {
                    this.f29883c.e();
                    this.f29881a.a(true);
                }
                if (!g.c()) {
                    com.shopee.livequiz.c.f.b(new e() {
                        public void a() {
                            LivePlayerActivity.this.f29885e.a(2);
                        }
                    }, 500);
                }
            } else {
                this.f29881a.h();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.f29887g) {
            this.mQuestionPanel.a(true);
            this.mResultPanel.a(true);
            if (!this.mPlayerCheckBtn.a()) {
                this.f29883c.d();
            }
            this.mLoadingProgressBar.setVisibility(8);
            this.f29881a.a(false);
            com.shopee.livequiz.b.e.h();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (this.f29887g && isFinishing()) {
            this.f29883c.a();
            this.f29882b.a();
            this.f29881a.a();
            l();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.f29887g) {
            this.inputMotionLayout.a();
            this.k.d();
        }
    }

    public void l() {
        if (this.f29887g) {
            this.mQuestionPanel.e();
            this.mResultPanel.e();
            i.a().c();
            com.shopee.livequiz.g.b.a();
            com.shopee.livequiz.g.e.b();
        }
    }

    private void p() {
        this.mQuestionPanel.setCallback(new GameQuestionPanel.a() {
            public void a(int i, int i2, int i3) {
                GameModel d2 = LivePlayerActivity.this.f29881a.d();
                boolean z = true;
                if (d2.state == 1) {
                    GameData b2 = com.shopee.livequiz.data.a.b(LivePlayerActivity.this.f29881a.d());
                    GameData a2 = com.shopee.livequiz.data.a.a(LivePlayerActivity.this.f29881a.d());
                    if (!(a2 == null || b2 == null || a2.msg_body.sn != b2.msg_body.sn)) {
                        b b3 = LivePlayerActivity.this.f29881a;
                        if (i3 != -1 || !com.shopee.livequiz.data.a.f(d2, b2.msg_body.sn)) {
                            z = false;
                        }
                        b3.a(i, z);
                    }
                    LivePlayerActivity.this.f29881a.a(i, i2, i3);
                }
            }

            public void a() {
                LivePlayerActivity.this.f29881a.j();
            }
        });
        this.mResultPanel.setCallback(new GameResultPanel.a() {
            public void a(final int i) {
                LivePlayerActivity.this.f29885e.e().a(LivePlayerActivity.this.f29881a.d(), (c.a) new c.a() {
                    public void a(boolean z) {
                        if (!z) {
                            LivePlayerActivity.this.f29881a.i();
                        }
                    }

                    public void a() {
                        com.shopee.livequiz.data.a.a(LivePlayerActivity.this.f29881a.d(), i);
                        LivePlayerActivity.this.f29881a.k();
                        LivePlayerActivity.this.j.a(LivePlayerActivity.this.mParentView, LivePlayerActivity.this.mIvExtraLifeHeart, new d.a() {
                            public void a() {
                                LivePlayerActivity.this.n();
                                LivePlayerActivity.this.f29881a.i();
                            }
                        });
                        LivePlayerActivity.this.i();
                    }

                    public void b() {
                        LivePlayerActivity.this.f29881a.l();
                        boolean unused = LivePlayerActivity.this.h = true;
                        LivePlayerActivity.this.f29885e.b().a(LivePlayerActivity.this.f29881a.d());
                        LivePlayerActivity.this.i();
                    }
                });
            }

            public void a() {
                boolean unused = LivePlayerActivity.this.h = true;
                LivePlayerActivity.this.f29885e.c().a();
            }

            public void b() {
                boolean unused = LivePlayerActivity.this.h = true;
                LivePlayerActivity.this.f29885e.b().a(LivePlayerActivity.this.f29881a.d());
                LivePlayerActivity.this.i();
            }
        });
    }

    private void q() {
        this.f29885e = new com.shopee.livequiz.ui.view.b.f(this);
        this.mTurnOnStreamBtn.getPaint().setFlags(8);
        this.f29885e.a().a(new d.a() {
            public void a() {
                LivePlayerActivity.this.f29881a.g();
                com.shopee.livequiz.b.e.d();
            }

            public void b() {
                LivePlayerActivity.this.f29885e.b(1);
                com.shopee.livequiz.b.e.e();
            }
        });
        this.j = new com.shopee.livequiz.g.d(this);
        this.mPlayerCheckBtn.setCheckListener(new ImageCheckButton.a() {
            public void a(boolean z) {
                if (z) {
                    LivePlayerActivity.this.f29883c.e();
                    LivePlayerActivity.this.mLoadingProgressBar.setVisibility(0);
                    LivePlayerActivity.this.f29881a.a(true);
                    LivePlayerActivity.this.mStreamTurnOffNotifyLayout.setVisibility(8);
                    LivePlayerActivity.this.a(false);
                    return;
                }
                LivePlayerActivity.this.f29883c.d();
                LivePlayerActivity.this.mLoadingProgressBar.setVisibility(8);
                LivePlayerActivity.this.f29881a.a(false);
                LivePlayerActivity.this.mVideoView.setVisibility(8);
                LivePlayerActivity.this.mStreamTurnOffNotifyLayout.setVisibility(0);
                LivePlayerActivity.this.a(false);
            }
        });
    }

    private void r() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (getRequestedOrientation() == 1) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mStreamTurnOffNotifyLayout.getLayoutParams();
            layoutParams.setMargins(0, (int) (((float) Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)) * 0.67f), 0, 0);
            this.mStreamTurnOffNotifyLayout.setLayoutParams(layoutParams);
        }
    }

    private void s() {
        this.f29884d = new com.shopee.livequiz.ui.a.a(this);
        int i2 = 0;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        linearLayoutManager.a(true);
        this.mDanmaKuView.setLayoutManager(linearLayoutManager);
        this.mDanmaKuView.setAdapter(this.f29884d);
        this.mDanmaKuView.setItemAnimator((RecyclerView.f) null);
        this.mDanmaKuView.y();
        DanmaKuView danmaKuView = this.mDanmaKuView;
        if (com.shopee.livequiz.data.b.a().b().disableChat) {
            i2 = 8;
        }
        danmaKuView.setVisibility(i2);
        this.inputMotionLayout.setListener(new InputMotionLayout.a() {
            public void a(String str) {
                LivePlayerActivity.this.f29882b.a(str);
            }

            public void a() {
                LivePlayerActivity.this.f29885e.a(2);
            }
        });
        this.inputMotionLayout.a((Activity) this);
    }

    private void t() {
        InputMotionLayout inputMotionLayout2 = this.inputMotionLayout;
        inputMotionLayout2.setText(SQLBuilder.BLANK + com.shopee.livequiz.g.e.a().a("t_ls_chat"));
        com.shopee.livequiz.g.e.a(this.mBgImageView, "ls_turnoff_bg", c.g.livequiz_bg_activity);
        com.shopee.livequiz.g.e.a(this.mTurnOffStreamReminder, "t_ls_turnoff");
        com.shopee.livequiz.g.e.a(this.mTurnOnStreamBtn, "t_ls_turnon");
        this.mTurnOffStreamReminder.setTextColor(com.shopee.livequiz.g.e.a().d("color_text_D"));
        this.mTurnOnStreamBtn.setTextColor(com.shopee.livequiz.g.e.a().d("color_text_A"));
        com.shopee.livequiz.g.e.a(this.anchorAbsentScreenCoverView.getNotifyTextView(), "t_ls_host_disconn_desc");
        this.mPlayerCheckBtn.a("ls_turnon_icon", "ls_turnoff_icon");
    }

    public void onBackPressed() {
        clickBack((View) null);
    }

    /* access modifiers changed from: protected */
    @OnClick
    public void onClick(View view) {
        if (this.f29887g) {
            int id = view.getId();
            if (id == c.d.check_play_btn) {
                com.shopee.livequiz.b.e.b(this.mPlayerCheckBtn.a() ? "close" : "open");
                ImageCheckButton imageCheckButton = this.mPlayerCheckBtn;
                imageCheckButton.setChecked(!imageCheckButton.a());
            } else if (id == c.d.stream_turn_off_notify) {
                this.mPlayerCheckBtn.setChecked(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    @OnClick
    public void clickBack(View view) {
        if (this.f29887g) {
            GameModel d2 = this.f29881a.d();
            if (!g.c() || d2.state != 1 || !this.i || this.h) {
                e();
            } else {
                this.f29885e.a(1);
            }
        }
    }

    public void a(String str) {
        this.f29885e.a((String) null, str, com.shopee.livequiz.g.e.a().a("t_neg_ok"), this);
    }

    public TXCloudVideoView j() {
        return this.mVideoView;
    }

    public void b(String str) {
        this.mMemberNum.setText(str);
    }

    public void a(String str, String str2, String str3) {
        this.f29884d.a(new DanmaKuMessage(str, str2, str3), (a.C0459a) new a.C0459a() {
            public void a() {
                LivePlayerActivity.this.mDanmaKuView.b(LivePlayerActivity.this.f29884d.getItemCount() - 1);
            }
        });
    }

    public void a(GameData gameData) {
        this.f29881a.a(gameData, false);
        this.f29881a.a(gameData);
    }

    public void E_() {
        i();
        this.f29881a.e();
        this.f29882b.d();
    }

    public void a(com.shopee.livequiz.ui.view.panel.a aVar) {
        n();
        m();
        this.i = true;
        this.mQuestionPanel.a(aVar);
    }

    public void b(com.shopee.livequiz.ui.view.panel.a aVar) {
        m();
        n();
        this.i = true;
        this.mResultPanel.a(aVar);
    }

    public void m() {
        if (this.mQuestionPanel.c()) {
            this.mQuestionPanel.b();
        }
    }

    public void n() {
        if (this.mResultPanel.c()) {
            this.mResultPanel.b();
        }
    }

    public void a(int i2, float f2) {
        this.h = true;
        this.f29885e.d().a(i2, f2);
    }

    public void F_() {
        this.f29885e.d().c();
    }

    public void d() {
        this.f29881a.h();
        com.shopee.livequiz.b.e.f();
    }

    public void e() {
        c().a(this);
    }

    public void f() {
        c().a((Activity) this, NavigationPath.a(com.shopee.livequiz.data.b.a().b().landingPageUrl), (o) null, PushOption.a(1));
        com.shopee.livequiz.c.f.b();
    }

    public boolean g() {
        return this.mQuestionPanel.c();
    }

    public boolean h() {
        return this.f29885e.e().b() || this.j.a();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if (a(currentFocus, motionEvent)) {
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        } else if (getWindow().superDispatchTouchEvent(motionEvent)) {
            return true;
        } else {
            return onTouchEvent(motionEvent);
        }
    }

    private boolean a(View view, MotionEvent motionEvent) {
        if (view == null || (view.getId() != c.d.et_danmaku && view.getId() != c.d.btn_send_danmaku)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int height = view.getHeight() + i3;
        int width = view.getWidth() + i2;
        if (motionEvent.getX() <= ((float) i2) || motionEvent.getX() >= ((float) width) || motionEvent.getY() <= ((float) i3) || motionEvent.getY() >= ((float) height)) {
            return true;
        }
        return false;
    }

    public void i() {
        int c2 = this.f29881a.d().extraLifeBalance - com.shopee.livequiz.data.a.c(this.f29881a.d());
        this.mTvExtraLifeNumber.setText(String.valueOf(c2));
        GameModel d2 = this.f29881a.d();
        if (c2 == 0 || !g.c() || d2.sn == com.shopee.livequiz.data.b.a().b().questionNum || com.shopee.livequiz.data.a.d(d2) == 0 || d2.state == 2 || d2.state == 3 || com.shopee.livequiz.data.a.e(d2)) {
            this.mTvExtraLifeNumber.setTextColor(com.garena.android.appkit.tools.b.a(c.a.livequiz_color_extra_life_limit));
            this.mIvExtraLifeHeart.setImageDrawable(com.garena.android.appkit.tools.b.f(c.C0454c.livequiz_ic_heart_unavailable));
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        this.anchorAbsentScreenCoverView.a();
        this.k.c();
        this.k.b();
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        this.anchorAbsentScreenCoverView.a(z);
        this.k.c();
    }
}
