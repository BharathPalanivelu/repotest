package com.shopee.livequiz.ui.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.shopee.livequiz.c;
import com.shopee.livequiz.ui.view.AnchorAbsentScreenCoverView;
import com.shopee.livequiz.ui.view.ImageCheckButton;
import com.shopee.livequiz.ui.view.danmaku.DanmaKuView;
import com.shopee.livequiz.ui.view.keyboard.InputMotionLayout;
import com.shopee.livequiz.ui.view.panel.GameQuestionPanel;
import com.shopee.livequiz.ui.view.panel.GameResultPanel;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class LivePlayerActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private LivePlayerActivity f29903b;

    /* renamed from: c  reason: collision with root package name */
    private View f29904c;

    /* renamed from: d  reason: collision with root package name */
    private View f29905d;

    /* renamed from: e  reason: collision with root package name */
    private View f29906e;

    public LivePlayerActivity_ViewBinding(final LivePlayerActivity livePlayerActivity, View view) {
        this.f29903b = livePlayerActivity;
        livePlayerActivity.mParentView = (RelativeLayout) b.a(view, c.d.rl_parent_view, "field 'mParentView'", RelativeLayout.class);
        livePlayerActivity.flVideoContainer = (FrameLayout) b.a(view, c.d.video_container, "field 'flVideoContainer'", FrameLayout.class);
        View a2 = b.a(view, c.d.image_back, "field 'mBack' and method 'clickBack'");
        livePlayerActivity.mBack = a2;
        this.f29904c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                livePlayerActivity.clickBack(view);
            }
        });
        livePlayerActivity.mBgImageView = (ImageView) b.a(view, c.d.live_image_bg, "field 'mBgImageView'", ImageView.class);
        livePlayerActivity.mMemberNum = (TextView) b.a(view, c.d.text_online_guest_num, "field 'mMemberNum'", TextView.class);
        livePlayerActivity.mIvExtraLifeHeart = (ImageView) b.a(view, c.d.iv_extra_life_heart, "field 'mIvExtraLifeHeart'", ImageView.class);
        livePlayerActivity.mTvExtraLifeNumber = (TextView) b.a(view, c.d.tv_extra_life_number, "field 'mTvExtraLifeNumber'", TextView.class);
        View a3 = b.a(view, c.d.check_play_btn, "field 'mPlayerCheckBtn' and method 'onClick'");
        livePlayerActivity.mPlayerCheckBtn = (ImageCheckButton) b.b(a3, c.d.check_play_btn, "field 'mPlayerCheckBtn'", ImageCheckButton.class);
        this.f29905d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                livePlayerActivity.onClick(view);
            }
        });
        livePlayerActivity.mVideoView = (TXCloudVideoView) b.a(view, c.d.live_video_view, "field 'mVideoView'", TXCloudVideoView.class);
        livePlayerActivity.mTextMsgContainer = (RelativeLayout) b.a(view, c.d.text_msg_container, "field 'mTextMsgContainer'", RelativeLayout.class);
        View a4 = b.a(view, c.d.stream_turn_off_notify, "field 'mStreamTurnOffNotifyLayout' and method 'onClick'");
        livePlayerActivity.mStreamTurnOffNotifyLayout = (LinearLayout) b.b(a4, c.d.stream_turn_off_notify, "field 'mStreamTurnOffNotifyLayout'", LinearLayout.class);
        this.f29906e = a4;
        a4.setOnClickListener(new a() {
            public void a(View view) {
                livePlayerActivity.onClick(view);
            }
        });
        livePlayerActivity.mTurnOffStreamReminder = (TextView) b.a(view, c.d.t_ls_turnoff, "field 'mTurnOffStreamReminder'", TextView.class);
        livePlayerActivity.mTurnOnStreamBtn = (TextView) b.a(view, c.d.t_ls_turnon, "field 'mTurnOnStreamBtn'", TextView.class);
        livePlayerActivity.mDanmaKuView = (DanmaKuView) b.a(view, c.d.danmaku_list, "field 'mDanmaKuView'", DanmaKuView.class);
        livePlayerActivity.mLoadingProgressBar = (ProgressBar) b.a(view, c.d.loading_progress, "field 'mLoadingProgressBar'", ProgressBar.class);
        livePlayerActivity.mQuestionPanel = (GameQuestionPanel) b.a(view, c.d.question_panel, "field 'mQuestionPanel'", GameQuestionPanel.class);
        livePlayerActivity.mResultPanel = (GameResultPanel) b.a(view, c.d.result_panel, "field 'mResultPanel'", GameResultPanel.class);
        livePlayerActivity.inputMotionLayout = (InputMotionLayout) b.a(view, c.d.input_motion_layout, "field 'inputMotionLayout'", InputMotionLayout.class);
        livePlayerActivity.anchorAbsentScreenCoverView = (AnchorAbsentScreenCoverView) b.a(view, c.d.view_anchor_absent, "field 'anchorAbsentScreenCoverView'", AnchorAbsentScreenCoverView.class);
    }
}
