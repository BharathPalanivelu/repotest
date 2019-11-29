package com.salesforce.android.chat.ui.internal.chatfeed;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.d;
import com.salesforce.android.chat.ui.internal.chatfeed.ChatFeedActivityDelegate;

public class ChatFeedActivity extends d {
    private final ChatFeedActivityDelegate mChatActivityDelegate = new ChatFeedActivityDelegate.Builder().chatActivity(this).build();

    public ChatFeedActivityDelegate getActivityDelegate() {
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

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mChatActivityDelegate.onSaveInstanceState(bundle);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.mChatActivityDelegate.onRequestPermissionsResult(i, iArr);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mChatActivityDelegate.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.mChatActivityDelegate.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return this.mChatActivityDelegate.onCreateOptionsMenu(menu, getMenuInflater());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mChatActivityDelegate.onOptionsItemSelected(menuItem);
    }
}
