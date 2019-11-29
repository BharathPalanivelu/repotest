package com.path.android.jobqueue.di;

import com.path.android.jobqueue.Job;

public interface DependencyInjector {
    void inject(Job job);
}
