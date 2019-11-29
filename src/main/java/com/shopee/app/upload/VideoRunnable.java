package com.shopee.app.upload;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.garena.videolib.a.c;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.setting.VideoConfig;
import com.shopee.app.h.f;
import com.shopee.app.upload.UploadRunnable;
import com.shopee.app.upload.data.UploadVideo;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import org.b.a.a;
import org.b.a.b;
import org.b.a.d;

public class VideoRunnable implements Runnable {
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_SUCCESS = 0;
    /* access modifiers changed from: private */
    public BlockingQueue<Integer> mBlockingQueue = new ArrayBlockingQueue(1);
    private SettingConfigStore mConfigStore = ar.f().e().settingConfigStore();
    private final n mEventBus;
    private OkHttpClient mHTTPClient = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();
    /* access modifiers changed from: private */
    public ProgressListener mListener;
    /* access modifiers changed from: private */
    public UploadRunnable.PauseHelper mPauseHelper;
    /* access modifiers changed from: private */
    public Result mResult;
    private final UserInfo mUser;
    /* access modifiers changed from: private */
    public final UploadVideo mVideo;
    private BlockingQueue<Integer> mWaitQueue = new ArrayBlockingQueue(1);

    public interface ProgressListener {
        void onProgress(int i);
    }

    public static class Result {
        public int status;
        public String videoId;
    }

    public VideoRunnable(n nVar, UserInfo userInfo, UploadVideo uploadVideo) {
        this.mEventBus = nVar;
        this.mVideo = uploadVideo;
        this.mUser = userInfo;
    }

    public void setProgressListener(ProgressListener progressListener) {
        this.mListener = progressListener;
    }

    public void setPauseHelper(UploadRunnable.PauseHelper pauseHelper) {
        this.mPauseHelper = pauseHelper;
    }

    public void run() {
        int i;
        if (this.mPauseHelper == null) {
            this.mPauseHelper = new UploadRunnable.PauseHelper(Thread.currentThread());
        }
        this.mResult = new Result();
        if (this.mVideo.getStatus() == 3) {
            Result result = this.mResult;
            result.status = 0;
            result.videoId = this.mVideo.getVideoId();
            this.mWaitQueue.add(1);
            return;
        }
        if (this.mVideo.getStatus() == 0) {
            if (TextUtils.isEmpty(this.mVideo.getPath())) {
                this.mResult.status = 1;
                this.mWaitQueue.add(1);
                return;
            } else if (!new File(this.mVideo.getPath()).exists()) {
                this.mResult.status = 1;
                this.mWaitQueue.add(1);
                return;
            } else {
                VideoConfig videoConfig = this.mConfigStore.getVideoConfig();
                int maxSize = videoConfig.getMaxSize();
                try {
                    Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(this.mVideo.getPath(), 2);
                    int width = createVideoThumbnail.getWidth();
                    int height = createVideoThumbnail.getHeight();
                    createVideoThumbnail.recycle();
                    if (width < height) {
                        if (height > maxSize) {
                            width = (int) ((((float) width) / (((float) height) * 1.0f)) * ((float) maxSize));
                        } else {
                            maxSize = height;
                        }
                        height = width;
                    } else if (width > maxSize) {
                        height = (int) ((((float) height) / (((float) width) * 1.0f)) * ((float) maxSize));
                    } else {
                        maxSize = width;
                    }
                    if (maxSize % 2 != 0) {
                        maxSize--;
                    }
                    if (height % 2 != 0) {
                        height--;
                    }
                    final a aVar = new a(this.mVideo.getPath());
                    aVar.h = String.valueOf(this.mVideo.getStartTime());
                    aVar.i = (double) this.mVideo.getDuration();
                    aVar.f33854a = maxSize;
                    aVar.f33855b = height;
                    aVar.l = videoConfig.getCrf();
                    aVar.m = videoConfig.getRate();
                    aVar.n = videoConfig.getPreset();
                    String str = f.a().d() + "out.mp4";
                    final b bVar = new b(ar.f(), new File(f.a().d()));
                    bVar.a(aVar, true, str, (d.a) new d.a() {
                        public void shellOut(String str) {
                            Log.d("TEST1", "SHELL: " + str);
                            if (str.startsWith("frame=")) {
                                int indexOf = str.indexOf("time=");
                                if (indexOf != -1) {
                                    int i = indexOf + 5;
                                    String[] split = str.substring(i, i + 11).split(":");
                                    float parseInt = ((float) ((Integer.parseInt(split[0]) * 3600) + (Integer.parseInt(split[1]) * 60))) + Float.parseFloat(split[2]);
                                    StringBuilder sb = new StringBuilder();
                                    double d2 = (double) parseInt;
                                    double d3 = aVar.i;
                                    Double.isNaN(d2);
                                    sb.append(String.valueOf((int) ((d2 / d3) * 100.0d)));
                                    sb.append("%");
                                    Log.d("TRIM", sb.toString());
                                    double d4 = aVar.i;
                                    Double.isNaN(d2);
                                    int i2 = (int) ((d2 / d4) * 100.0d * 0.75d);
                                    if (VideoRunnable.this.mListener != null) {
                                        VideoRunnable.this.mListener.onProgress(i2);
                                    }
                                    VideoRunnable.this.notifyUpdate(100, (long) i2);
                                }
                            }
                            if (VideoRunnable.this.mPauseHelper != null && VideoRunnable.this.mPauseHelper.isDiscarded()) {
                                Process b2 = bVar.b();
                                if (b2 != null) {
                                    b2.destroy();
                                }
                            }
                        }

                        public void processComplete(int i) {
                            VideoRunnable.this.mBlockingQueue.add(1);
                        }
                    });
                    try {
                        i = this.mBlockingQueue.take().intValue();
                    } catch (InterruptedException unused) {
                        i = -1;
                    }
                    if (i == -1) {
                        this.mResult.status = 1;
                        this.mWaitQueue.add(1);
                        return;
                    }
                    this.mVideo.setOutPath(str);
                    this.mVideo.setStatus(1);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        UploadRunnable.PauseHelper pauseHelper = this.mPauseHelper;
        if (pauseHelper == null || pauseHelper.canContinue() != -99) {
            if (this.mVideo.getStatus() == 1 || this.mVideo.getStatus() == 2) {
                if (TextUtils.isEmpty(this.mVideo.getOutPath())) {
                    this.mResult.status = 1;
                    this.mWaitQueue.add(1);
                    return;
                } else if (!new File(this.mVideo.getOutPath()).exists()) {
                    this.mResult.status = 1;
                    this.mWaitQueue.add(1);
                    return;
                } else {
                    notifyTrimSuccess();
                    com.garena.videolib.a.a aVar2 = new com.garena.videolib.a.a();
                    aVar2.a(this.mUser.getToken());
                    aVar2.b(String.valueOf(this.mUser.getUserId()));
                    com.garena.videolib.uploader.f fVar = new com.garena.videolib.uploader.f(this.mHTTPClient, WebRegister.GSON, new c(this.mVideo.getOutPath()), aVar2);
                    if (TextUtils.isEmpty(this.mVideo.getUploadId())) {
                        fVar.a(new com.garena.videolib.uploader.d() {
                            public void onSessionSuccess(String str) {
                                Log.d("TEST1", "SESSION: " + str);
                                VideoRunnable.this.mVideo.setUploadId(str);
                                VideoRunnable.this.mVideo.setStatus(2);
                            }

                            public void onSessionError(Exception exc) {
                                Log.d("TEST1", "SESSION: " + exc.getMessage());
                            }

                            public void onProgress(int i) {
                                Log.d("TEST1", "PROGRESS: " + i);
                                double d2 = (double) i;
                                Double.isNaN(d2);
                                int i2 = ((int) (d2 * 0.25d)) + 75;
                                if (VideoRunnable.this.mListener != null) {
                                    VideoRunnable.this.mListener.onProgress(i2);
                                }
                                VideoRunnable.this.notifyUpdate(100, (long) i2);
                            }

                            public void onFinish(String str) {
                                Log.d("TEST1", "FINISH: " + str);
                                String lastPathSegment = Uri.parse(str).getLastPathSegment();
                                VideoRunnable.this.mResult.videoId = lastPathSegment;
                                VideoRunnable.this.mVideo.setVideoId(lastPathSegment);
                                VideoRunnable.this.mVideo.setStatus(3);
                            }

                            public void onError(Exception exc) {
                                Log.d("TEST1", "ERROR: " + exc.getMessage());
                                VideoRunnable.this.mResult.status = 1;
                            }
                        });
                    } else {
                        fVar.a(this.mVideo.getUploadId(), new com.garena.videolib.uploader.b() {
                            public void onProgress(int i) {
                                Log.d("TEST1", "RESUME_PROGRESS: " + i);
                            }

                            public void onFinish(String str) {
                                String lastPathSegment = Uri.parse(str).getLastPathSegment();
                                VideoRunnable.this.mResult.videoId = lastPathSegment;
                                VideoRunnable.this.mVideo.setVideoId(lastPathSegment);
                                VideoRunnable.this.mVideo.setStatus(3);
                            }

                            public void onError(Exception exc) {
                                Log.d("TEST1", "RESUME_ERROR: " + exc.getMessage());
                                VideoRunnable.this.mResult.status = 1;
                            }
                        });
                    }
                }
            }
            if (this.mResult.status != 1) {
                this.mResult.status = 0;
                notifySuccess();
            }
            this.mWaitQueue.add(1);
            return;
        }
        com.garena.android.appkit.d.a.b("PRODUCT_UPLOAD: " + this.mVideo.getPath() + " DISCARDED: ", new Object[0]);
        this.mResult.status = 1;
        this.mWaitQueue.add(1);
    }

    public Result getResult() {
        return this.mResult;
    }

    public void discard() {
        UploadRunnable.PauseHelper pauseHelper = this.mPauseHelper;
        if (pauseHelper != null) {
            pauseHelper.discard();
        }
    }

    public void untilFinished() {
        try {
            this.mWaitQueue.take();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void notifyUpdate(long j, long j2) {
        if (!this.mPauseHelper.isDiscarded()) {
            VideoState data = data();
            data.progress = (double) (((float) j2) / (((float) j) * 1.0f));
            this.mEventBus.a().az.a(data).a();
        }
    }

    private void notifyTrimSuccess() {
        if (!this.mPauseHelper.isDiscarded()) {
            this.mEventBus.a().cG.a(data()).a();
        }
    }

    private void notifySuccess() {
        if (!this.mPauseHelper.isDiscarded()) {
            this.mEventBus.a().aB.a(data()).a();
        }
    }

    private VideoState data() {
        VideoState videoState = new VideoState();
        videoState.video = this.mVideo;
        videoState.runnable = this;
        return videoState;
    }
}
