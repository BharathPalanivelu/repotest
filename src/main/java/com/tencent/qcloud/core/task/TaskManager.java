package com.tencent.qcloud.core.task;

import com.tencent.qcloud.core.logger.QCloudLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class TaskManager {
    static final String TASK_LOG_TAG = "QCloudTask";
    private static volatile TaskManager instance;
    private Map<String, QCloudTask> taskPool = new ConcurrentHashMap(30);

    public static TaskManager getInstance() {
        if (instance == null) {
            synchronized (TaskManager.class) {
                if (instance == null) {
                    instance = new TaskManager();
                }
            }
        }
        return instance;
    }

    private TaskManager() {
    }

    /* access modifiers changed from: package-private */
    public void add(QCloudTask qCloudTask) {
        this.taskPool.put(qCloudTask.getIdentifier(), qCloudTask);
        QCloudLogger.d(TASK_LOG_TAG, "[Pool] ADD %s, %d cached", qCloudTask.getIdentifier(), Integer.valueOf(this.taskPool.size()));
    }

    /* access modifiers changed from: package-private */
    public void remove(QCloudTask qCloudTask) {
        if (this.taskPool.remove(qCloudTask.getIdentifier()) != null) {
            QCloudLogger.d(TASK_LOG_TAG, "[Pool] REMOVE %s, %d cached", qCloudTask.getIdentifier(), Integer.valueOf(this.taskPool.size()));
        }
    }

    public QCloudTask get(String str) {
        return this.taskPool.get(str);
    }

    public List<QCloudTask> snapshot() {
        return new ArrayList(this.taskPool.values());
    }

    /* access modifiers changed from: package-private */
    public void evict() {
        QCloudLogger.d(TASK_LOG_TAG, "[Pool] CLEAR %d", Integer.valueOf(this.taskPool.size()));
        this.taskPool.clear();
    }
}
