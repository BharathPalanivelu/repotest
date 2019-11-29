package com.salesforce.android.chat.ui.internal.presenter;

import android.content.Context;
import com.salesforce.android.chat.ui.internal.view.ViewBinder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Presenter<VB extends ViewBinder> {
    public static final int CHAT_FEED_PRESENTER = 1;
    public static final int INVALID_PRESENTER = -1;
    public static final int MINIMIZE_CONNECTING_PRESENTER = 2;
    public static final int MINIMIZE_IN_SESSION_PRESENTER = 4;
    public static final int MINIMIZE_POST_SESSION_PRESENTER = 5;
    public static final int MINIMIZE_QUEUED_PRESENTER = 3;
    public static final int PRECHAT_PRESENTER = 6;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    Context getApplicationContext();

    void onCreate();

    void onDestroy();

    void onViewCreated(VB vb);

    void onViewDestroyed(VB vb);
}
