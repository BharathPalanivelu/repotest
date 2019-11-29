package com.salesforce.android.chat.ui.internal.prechat;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.d;
import com.salesforce.android.chat.ui.internal.prechat.PreChatActivityDelegate;

public class PreChatActivity extends d {
    private final PreChatActivityDelegate mChatActivityDelegate = new PreChatActivityDelegate.Builder().preChatActivity(this).build();

    public PreChatActivityDelegate getActivityDelegate() {
        return this.mChatActivityDelegate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mChatActivityDelegate.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mChatActivityDelegate.onDestroy();
    }

    public void onBackPressed() {
        this.mChatActivityDelegate.onBackPressed();
        super.onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mChatActivityDelegate.onOptionsItemSelected(menuItem);
    }
}
