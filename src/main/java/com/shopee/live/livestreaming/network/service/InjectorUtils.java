package com.shopee.live.livestreaming.network.service;

import android.content.Context;
import com.shopee.live.livestreaming.network.executor.ThreadExecutor;
import com.shopee.live.livestreaming.network.task.BanUserCommentTask;
import com.shopee.live.livestreaming.network.task.ClaimVoucherTask;
import com.shopee.live.livestreaming.network.task.CommendBanCheckTask;
import com.shopee.live.livestreaming.network.task.EndLiveTask;
import com.shopee.live.livestreaming.network.task.ExitLiveTask;
import com.shopee.live.livestreaming.network.task.FollowingCheckTask;
import com.shopee.live.livestreaming.network.task.FollowingPostTask;
import com.shopee.live.livestreaming.network.task.GetCoinGiveOutTask;
import com.shopee.live.livestreaming.network.task.GetLiveSessionTask;
import com.shopee.live.livestreaming.network.task.GetPlayUrlTask;
import com.shopee.live.livestreaming.network.task.GetPollingMessageTask;
import com.shopee.live.livestreaming.network.task.GetReplayRecordTask;
import com.shopee.live.livestreaming.network.task.GetSessionProductTask;
import com.shopee.live.livestreaming.network.task.GetUserConfigTask;
import com.shopee.live.livestreaming.network.task.GetVoucherListTask;
import com.shopee.live.livestreaming.network.task.JoinLiveTask;
import com.shopee.live.livestreaming.network.task.LiveAdTask;
import com.shopee.live.livestreaming.network.task.NotifyLiveTask;
import com.shopee.live.livestreaming.network.task.PostCoinCanClaimTask;
import com.shopee.live.livestreaming.network.task.PostCoinClaimTask;
import com.shopee.live.livestreaming.network.task.PostCoinLockTask;
import com.shopee.live.livestreaming.network.task.PostCoinReleaseTask;
import com.shopee.live.livestreaming.network.task.PostLikeTask;
import com.shopee.live.livestreaming.network.task.PostReplayCountTask;
import com.shopee.live.livestreaming.network.task.PostReportTask;
import com.shopee.live.livestreaming.network.task.SendMessageTask;
import com.shopee.live.livestreaming.network.task.ShowVoucherTask;
import com.shopee.live.livestreaming.network.task.UpLoadShowProductTask;
import com.shopee.live.livestreaming.util.p;
import com.shopee.sdk.b;
import f.b.a.a;
import f.e;
import f.n;

public class InjectorUtils {
    private static n mRetrofit;

    public static n provideRetrofit() {
        if (mRetrofit == null) {
            mRetrofit = new n.a().a(b.a().g().a()).a(p.b()).a((e.a) a.a()).a();
        }
        return mRetrofit;
    }

    public static GetLiveSessionTask provideGetLiveSessionTask() {
        return new GetLiveSessionTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static GetPollingMessageTask provideGetPollingMessageTask(Context context) {
        return new GetPollingMessageTask(ThreadExecutor.getInstance(), context);
    }

    public static GetSessionProductTask provideGetSessionProductTask() {
        return new GetSessionProductTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static GetVoucherListTask provideGetVoucherListTask() {
        return new GetVoucherListTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static NotifyLiveTask provideNotifyLiveTask() {
        return new NotifyLiveTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static BanUserCommentTask provideBanUserCommentTask() {
        return new BanUserCommentTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static UpLoadShowProductTask provideUpLoadShowProductTask() {
        return new UpLoadShowProductTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static ShowVoucherTask provideShowVoucherTask() {
        return new ShowVoucherTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static ClaimVoucherTask provideClaimVoucherTask() {
        return new ClaimVoucherTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static EndLiveTask provideEndLiveTask() {
        return new EndLiveTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static JoinLiveTask provideJoinLiveTask() {
        return new JoinLiveTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static SendMessageTask provideSendMessageTask() {
        return new SendMessageTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static ExitLiveTask provideExitLiveTask() {
        return new ExitLiveTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static FollowingCheckTask provideFollowingCheckTask() {
        return new FollowingCheckTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static FollowingPostTask provideFollowingPostTask() {
        return new FollowingPostTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static CommendBanCheckTask provideDanmakuBanCheckTask() {
        return new CommendBanCheckTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static PostLikeTask providePostLikeTask() {
        return new PostLikeTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static PostReportTask providePostReportTask() {
        return new PostReportTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static GetReplayRecordTask provideGetReplayRecordTask() {
        return new GetReplayRecordTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static PostReplayCountTask providePostReplayCountTask() {
        return new PostReplayCountTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static LiveAdTask provideLiveAdTask() {
        return new LiveAdTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static GetCoinGiveOutTask provideGetCoinGiveOutTask() {
        return new GetCoinGiveOutTask(ThreadExecutor.getInstance(), (CheckInCoinService) provideRetrofit().a(CheckInCoinService.class));
    }

    public static GetPlayUrlTask provideGetPlayUrlTask() {
        return new GetPlayUrlTask(ThreadExecutor.getInstance(), (LiveStreamingService) provideRetrofit().a(LiveStreamingService.class));
    }

    public static GetUserConfigTask provideGetUserConfigTask() {
        return new GetUserConfigTask(ThreadExecutor.getInstance(), (CheckInCoinService) provideRetrofit().a(CheckInCoinService.class));
    }

    public static PostCoinCanClaimTask providePostCoinCanClaimTask() {
        return new PostCoinCanClaimTask(ThreadExecutor.getInstance(), (CheckInCoinService) provideRetrofit().a(CheckInCoinService.class));
    }

    public static PostCoinClaimTask providePostCoinClaimTask() {
        return new PostCoinClaimTask(ThreadExecutor.getInstance(), (CheckInCoinService) provideRetrofit().a(CheckInCoinService.class));
    }

    public static PostCoinLockTask providePostCoinLockTask() {
        return new PostCoinLockTask(ThreadExecutor.getInstance(), (CheckInCoinService) provideRetrofit().a(CheckInCoinService.class));
    }

    public static PostCoinReleaseTask providePostCoinReleaseTask() {
        return new PostCoinReleaseTask(ThreadExecutor.getInstance(), (CheckInCoinService) provideRetrofit().a(CheckInCoinService.class));
    }
}
