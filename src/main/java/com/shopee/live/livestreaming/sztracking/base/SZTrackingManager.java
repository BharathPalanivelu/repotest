package com.shopee.live.livestreaming.sztracking.base;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.shopee.e.a.a;
import com.shopee.live.livestreaming.network.executor.ThreadExecutor;
import com.shopee.live.livestreaming.sztracking.base.db.SZTrackingDBHelper;
import com.shopee.live.livestreaming.sztracking.base.db.SZTrackingDBModel;
import com.shopee.live.livestreaming.sztracking.base.net.SZTrackingReportTask;
import com.squareup.wire.Message;
import e.f;
import java.util.ArrayList;
import java.util.List;

public class SZTrackingManager {
    private static final int DB_MAX_SIZE = 1000;
    private static final String REPORT_THREAD = "sz_tracking_query_db_thread";
    private static final String TAG = "SZTrackingManager: %s";
    private static final int TRACKING_POST_INTERVAL = 10000;
    private static final int TRACKING_POST_MAX_SIZE = 50;
    private static final int TRACKING_POST_TIMEOUT = 30;
    /* access modifiers changed from: private */
    public SZTrackingDBHelper mDBHelper;
    /* access modifiers changed from: private */
    public SZTrackingMessageFactory mEventFactory;
    /* access modifiers changed from: private */
    public SZTrackingReportTask mReportTask;
    /* access modifiers changed from: private */
    public HandlerThreadWrapper mSingleThread = new HandlerThreadWrapper(REPORT_THREAD);
    private int maxEvents = 1000;
    private int netTimeout = 30;
    private int remainEvents = 500;
    /* access modifiers changed from: private */
    public int sendInterval = 10000;
    /* access modifiers changed from: private */
    public int sendLimitSize = 50;

    public SZTrackingManager(Context context) {
        this.mDBHelper = SZTrackingDBHelper.singleInstance(context);
        this.mDBHelper.openOrCreateDatabase();
        this.mReportTask = new SZTrackingReportTask(ThreadExecutor.getInstance());
        this.mEventFactory = new SZTrackingMessageFactoryImpl();
    }

    public void start() {
        this.mSingleThread.start();
        this.mSingleThread.startPost();
    }

    public void close() {
        this.mSingleThread.stop();
        this.mDBHelper.close();
    }

    public boolean started() {
        return this.mSingleThread.isAvailable();
    }

    public void eventReport(Message message) {
        this.mSingleThread.saveDB(message);
    }

    public void eventReport(List<Message> list) {
        this.mSingleThread.saveDB(list);
    }

    public void updateSettings(int i, int i2, int i3, int i4, int i5) {
        this.maxEvents = i;
        this.remainEvents = i2;
        this.netTimeout = i3;
        this.sendInterval = i4 * 1000;
        this.sendLimitSize = i5;
    }

    private class HandlerThreadWrapper {
        private boolean available;
        private TrackingHandler handler;
        private String name;
        private HandlerThread thread;

        HandlerThreadWrapper(String str) {
            this.name = str;
        }

        public void start() {
            this.thread = new HandlerThread(this.name, 10);
            this.thread.start();
            this.available = true;
            this.handler = new TrackingHandler(this.thread.getLooper());
        }

        /* access modifiers changed from: package-private */
        public boolean isAvailable() {
            return this.available;
        }

        /* access modifiers changed from: package-private */
        public void stop() {
            if (isAvailable()) {
                this.available = false;
                this.handler.removeCallbacksAndMessages((Object) null);
                this.handler = null;
                if (Build.VERSION.SDK_INT >= 18) {
                    this.thread.quitSafely();
                } else {
                    this.thread.quit();
                }
                this.thread = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void saveDB(Message message) {
            if (message != null && isAvailable()) {
                android.os.Message obtainMessage = this.handler.obtainMessage();
                obtainMessage.obj = message;
                obtainMessage.what = 1;
                this.handler.sendMessage(obtainMessage);
            }
        }

        /* access modifiers changed from: package-private */
        public void saveDB(List<Message> list) {
            if (list != null && isAvailable()) {
                android.os.Message obtainMessage = this.handler.obtainMessage();
                obtainMessage.obj = list;
                obtainMessage.what = 2;
                this.handler.sendMessage(obtainMessage);
            }
        }

        /* access modifiers changed from: package-private */
        public void startPost() {
            if (isAvailable()) {
                this.handler.sendEmptyMessage(3);
            }
        }
    }

    private class TrackingHandler extends Handler {
        static final int MSG_DELETE = 4;
        static final int MSG_POST = 3;
        static final int MSG_SAVE = 1;
        static final int MSG_SAVE_LIST = 2;
        boolean isPosting;
        boolean isReportLooping;
        List<SZTrackingDBModel> postingModels;

        TrackingHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            SZTrackingManager.this.mDBHelper.deleteList(this.postingModels);
                            this.isPosting = false;
                        }
                    } else if (!this.isPosting) {
                        this.isPosting = true;
                        try {
                            ArrayList query = SZTrackingManager.this.mDBHelper.query(new QueryBuilder(SZTrackingDBModel.class).limit(0, SZTrackingManager.this.sendLimitSize));
                            Object[] objArr = new Object[1];
                            StringBuilder sb = new StringBuilder();
                            sb.append("prepare to report: models.size-");
                            sb.append(query == null ? "null" : Integer.valueOf(query.size()));
                            objArr[0] = sb.toString();
                            a.a(SZTrackingManager.TAG, objArr);
                            if (query == null || query.size() <= 0) {
                                this.isPosting = false;
                                this.isReportLooping = false;
                                return;
                            }
                            Message outToPost = SZTrackingManager.this.mEventFactory.outToPost(query);
                            this.postingModels = query;
                            SZTrackingManager.this.mReportTask.execute(new SZTrackingReportTask.Data(f.a(outToPost.toByteArray())), new SZTrackingReportTask.Callback() {
                                public void onResolve() {
                                    TrackingHandler.this.sendEmptyMessage(4);
                                }

                                public void onReject() {
                                    TrackingHandler.this.isPosting = false;
                                }
                            });
                            if (SZTrackingManager.this.mSingleThread != null) {
                                sendEmptyMessageDelayed(3, (long) SZTrackingManager.this.sendInterval);
                            }
                        } catch (Exception e2) {
                            a.a(e2, "sztrakcing post failure", new Object[0]);
                            this.isPosting = false;
                        }
                    }
                } else if (!SZTrackingDBHelper.isClosed()) {
                    ArrayList arrayList = new ArrayList();
                    for (Message inToSave : (List) message.obj) {
                        arrayList.add(SZTrackingManager.this.mEventFactory.inToSave(inToSave));
                    }
                    SZTrackingManager.this.checkSaveData();
                    SZTrackingManager.this.mDBHelper.insert(arrayList);
                }
            } else if (!SZTrackingDBHelper.isClosed()) {
                SZTrackingDBModel inToSave2 = SZTrackingManager.this.mEventFactory.inToSave((Message) message.obj);
                if (inToSave2 != null) {
                    SZTrackingManager.this.checkSaveData();
                    SZTrackingManager.this.mDBHelper.insert(inToSave2);
                    a.a(SZTrackingManager.TAG, "insert: " + inToSave2.timestamp);
                    if (!this.isReportLooping) {
                        this.isReportLooping = true;
                        sendEmptyMessage(3);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void checkSaveData() {
        long queryCount = this.mDBHelper.queryCount(SZTrackingDBModel.class);
        if (queryCount >= ((long) this.maxEvents)) {
            ArrayList query = this.mDBHelper.query(new QueryBuilder(SZTrackingDBModel.class).limit(0, (int) Math.min((long) (((int) (queryCount - ((long) this.remainEvents))) + 1), queryCount)));
            int deleteList = this.mDBHelper.deleteList(query);
            a.a(TAG, "delete: " + query.size() + ", result = " + deleteList);
        }
    }
}
