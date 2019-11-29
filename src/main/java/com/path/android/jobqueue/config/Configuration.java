package com.path.android.jobqueue.config;

import android.content.Context;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.QueueFactory;
import com.path.android.jobqueue.di.DependencyInjector;
import com.path.android.jobqueue.log.CustomLogger;
import com.path.android.jobqueue.network.NetworkUtil;
import com.path.android.jobqueue.network.NetworkUtilImpl;
import com.path.android.jobqueue.persistentQueue.sqlite.SqliteJobQueue;

public class Configuration {
    public static final String DEFAULT_ID = "default_job_manager";
    public static final int DEFAULT_LOAD_FACTOR_PER_CONSUMER = 3;
    public static final int DEFAULT_THREAD_KEEP_ALIVE_SECONDS = 15;
    public static final int MAX_CONSUMER_COUNT = 5;
    public static final int MIN_CONSUMER_COUNT = 0;
    /* access modifiers changed from: private */
    public int consumerKeepAlive;
    /* access modifiers changed from: private */
    public CustomLogger customLogger;
    /* access modifiers changed from: private */
    public DependencyInjector dependencyInjector;
    /* access modifiers changed from: private */
    public String id;
    /* access modifiers changed from: private */
    public boolean inTestMode;
    /* access modifiers changed from: private */
    public int loadFactor;
    /* access modifiers changed from: private */
    public int maxConsumerCount;
    /* access modifiers changed from: private */
    public int minConsumerCount;
    /* access modifiers changed from: private */
    public NetworkUtil networkUtil;
    /* access modifiers changed from: private */
    public QueueFactory queueFactory;

    private Configuration() {
        this.id = DEFAULT_ID;
        this.maxConsumerCount = 5;
        this.minConsumerCount = 0;
        this.consumerKeepAlive = 15;
        this.loadFactor = 3;
        this.inTestMode = false;
    }

    public String getId() {
        return this.id;
    }

    public QueueFactory getQueueFactory() {
        return this.queueFactory;
    }

    public DependencyInjector getDependencyInjector() {
        return this.dependencyInjector;
    }

    public int getConsumerKeepAlive() {
        return this.consumerKeepAlive;
    }

    public NetworkUtil getNetworkUtil() {
        return this.networkUtil;
    }

    public int getMaxConsumerCount() {
        return this.maxConsumerCount;
    }

    public int getMinConsumerCount() {
        return this.minConsumerCount;
    }

    public CustomLogger getCustomLogger() {
        return this.customLogger;
    }

    public int getLoadFactor() {
        return this.loadFactor;
    }

    public boolean isInTestMode() {
        return this.inTestMode;
    }

    public static final class Builder {
        private Context appContext;
        private Configuration configuration = new Configuration();

        public Builder(Context context) {
            this.appContext = context.getApplicationContext();
        }

        public Builder id(String str) {
            String unused = this.configuration.id = str;
            return this;
        }

        public Builder consumerKeepAlive(int i) {
            int unused = this.configuration.consumerKeepAlive = i;
            return this;
        }

        public Builder queueFactory(QueueFactory queueFactory) {
            if (this.configuration.queueFactory == null) {
                QueueFactory unused = this.configuration.queueFactory = queueFactory;
                return this;
            }
            throw new RuntimeException("already set a queue factory. This might happen if you've provided a custom job serializer");
        }

        public Builder jobSerializer(SqliteJobQueue.JobSerializer jobSerializer) {
            QueueFactory unused = this.configuration.queueFactory = new JobManager.DefaultQueueFactory(jobSerializer);
            return this;
        }

        public Builder networkUtil(NetworkUtil networkUtil) {
            NetworkUtil unused = this.configuration.networkUtil = networkUtil;
            return this;
        }

        public Builder injector(DependencyInjector dependencyInjector) {
            DependencyInjector unused = this.configuration.dependencyInjector = dependencyInjector;
            return this;
        }

        public Builder maxConsumerCount(int i) {
            int unused = this.configuration.maxConsumerCount = i;
            return this;
        }

        public Builder minConsumerCount(int i) {
            int unused = this.configuration.minConsumerCount = i;
            return this;
        }

        public Builder customLogger(CustomLogger customLogger) {
            CustomLogger unused = this.configuration.customLogger = customLogger;
            return this;
        }

        public Builder loadFactor(int i) {
            int unused = this.configuration.loadFactor = i;
            return this;
        }

        public Builder inTestMode() {
            boolean unused = this.configuration.inTestMode = true;
            return this;
        }

        public Configuration build() {
            if (this.configuration.queueFactory == null) {
                QueueFactory unused = this.configuration.queueFactory = new JobManager.DefaultQueueFactory();
            }
            if (this.configuration.networkUtil == null) {
                NetworkUtil unused2 = this.configuration.networkUtil = new NetworkUtilImpl(this.appContext);
            }
            return this.configuration;
        }
    }
}
