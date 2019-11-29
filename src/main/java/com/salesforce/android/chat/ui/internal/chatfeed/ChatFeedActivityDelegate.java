package com.salesforce.android.chat.ui.internal.chatfeed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.ChatFeedViewBinder;
import com.salesforce.android.chat.ui.internal.presenter.PresenterManager;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import tencent.tls.platform.SigType;

public class ChatFeedActivityDelegate {
    static final int REQUEST_CAMERA_PERMISSION_CODE = 21;
    static final int REQUEST_GALLERY_PERMISSION_CODE = 20;
    static final int REQUEST_LAST_PHOTO_PERMISSION_CODE = 22;
    static final int SELECT_CAMERA_REQUEST_CODE = 11;
    static final int SELECT_IMAGE_REQUEST_CODE = 10;
    private final ChatFeedActivity mChatActivity;
    private ChatFeedView mChatFeedView;
    private final ChatFeedViewBinder.Builder mChatFeedViewBinderBuilder;
    int mCurrentSdkVersion;
    private PresenterManager mPresenterManager;

    public static Intent createStartIntent(Context context, IntentFactory intentFactory) {
        Intent createIntent = intentFactory.createIntent(context, ChatFeedActivity.class);
        createIntent.addFlags(SigType.TLS);
        return createIntent;
    }

    private ChatFeedActivityDelegate(Builder builder) {
        this.mChatActivity = builder.mChatActivity;
        this.mChatFeedViewBinderBuilder = builder.mChatFeedViewBinderBuilder;
        this.mCurrentSdkVersion = builder.mCurrentSdkVersion;
    }

    public Context getContext() {
        return this.mChatActivity;
    }

    public void setPresenterManager(PresenterManager presenterManager) {
        this.mPresenterManager = presenterManager;
    }

    /* access modifiers changed from: package-private */
    public void onCreate(Bundle bundle) {
        this.mChatActivity.setContentView(R.layout.chat_feed_activity);
        LayoutInflater layoutInflater = this.mChatActivity.getLayoutInflater();
        PresenterManager presenterManager = this.mPresenterManager;
        this.mChatFeedView = this.mChatFeedViewBinderBuilder.activity(this).applicationContext(this.mChatActivity.getApplicationContext()).presenter(presenterManager != null ? (ChatFeedPresenter) presenterManager.getPresenter(1) : null).build();
        Arguments.checkNotNull(this.mChatFeedView);
        ViewGroup viewGroup = (ViewGroup) this.mChatActivity.findViewById(16908290);
        this.mChatFeedView.onCreateView(layoutInflater, viewGroup);
        Toolbar toolbar = (Toolbar) viewGroup.findViewById(R.id.toolbar);
        this.mChatActivity.setSupportActionBar(toolbar);
        Arguments.checkNotNull(this.mChatActivity.getSupportActionBar());
        this.mChatActivity.getSupportActionBar().a((CharSequence) null);
        this.mChatActivity.getSupportActionBar().a(R.string.chat_end_session_content_description);
        this.mChatFeedView.onToolbarInflated(toolbar);
        Window window = this.mChatActivity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(RNCartPanelDataEntity.NULL_VALUE);
        window.setStatusBarColor(b.c(this.mChatActivity, R.color.salesforce_brand_primary));
        ChatFeedView chatFeedView = this.mChatFeedView;
        if (chatFeedView != null && bundle != null) {
            chatFeedView.onRestoreInstanceState(bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
        ChatFeedView chatFeedView = this.mChatFeedView;
        if (chatFeedView != null) {
            chatFeedView.onDestroyView();
        }
    }

    /* access modifiers changed from: package-private */
    public void onSaveInstanceState(Bundle bundle) {
        ChatFeedView chatFeedView = this.mChatFeedView;
        if (chatFeedView != null) {
            chatFeedView.onSaveInstanceState(bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void onRequestPermissionsResult(int i, int[] iArr) {
        if (this.mChatFeedView != null) {
            if (!arePermissionsGranted(iArr)) {
                this.mChatFeedView.onPermissionsNotGranted();
            } else if (i == 20) {
                this.mChatFeedView.onGalleryPermitted();
            } else if (i == 21) {
                this.mChatFeedView.onCameraPermitted();
            } else if (i == 22) {
                this.mChatFeedView.onGetLastPhotoPermitted();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onActivityResult(int i, int i2, Intent intent) {
        ChatFeedView chatFeedView = this.mChatFeedView;
        if (chatFeedView != null) {
            if (i2 != -1) {
                chatFeedView.onImageSelectionFailed();
            } else if (i == 10) {
                chatFeedView.onImageSelected(intent.getData());
            } else if (i == 11) {
                chatFeedView.onPhotoTaken();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean onBackPressed() {
        ChatFeedView chatFeedView = this.mChatFeedView;
        return chatFeedView != null && chatFeedView.onBackPressed();
    }

    public void finish() {
        this.mChatActivity.finish();
    }

    /* access modifiers changed from: package-private */
    public boolean onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        ChatFeedView chatFeedView = this.mChatFeedView;
        return chatFeedView != null && chatFeedView.onCreateOptionsMenu(menu, menuInflater);
    }

    /* access modifiers changed from: package-private */
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        ChatFeedView chatFeedView = this.mChatFeedView;
        return chatFeedView != null && chatFeedView.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: package-private */
    public void showToast(int i, int i2) {
        Toast.makeText(this.mChatActivity, i, i2).show();
    }

    /* access modifiers changed from: package-private */
    public boolean hasSelectLastPhotoPermission() {
        return arePermissionsGranted("android.permission.READ_EXTERNAL_STORAGE");
    }

    /* access modifiers changed from: package-private */
    public void requestSelectLastPhotoPermission() {
        requestPermissions(22, "android.permission.READ_EXTERNAL_STORAGE");
    }

    /* access modifiers changed from: package-private */
    public void selectImageFromGallery() {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.putExtra("return-data", true);
        if (intent.resolveActivity(this.mChatActivity.getPackageManager()) != null) {
            this.mChatActivity.startActivityForResult(intent, 10);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasGalleryPermission() {
        return arePermissionsGranted("android.permission.READ_EXTERNAL_STORAGE");
    }

    /* access modifiers changed from: package-private */
    public void requestGalleryPermission() {
        requestPermissions(20, "android.permission.READ_EXTERNAL_STORAGE");
    }

    /* access modifiers changed from: package-private */
    public void launchCamera(Uri uri) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", uri);
        if (intent.resolveActivity(this.mChatActivity.getPackageManager()) != null) {
            this.mChatActivity.startActivityForResult(intent, 11);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasCameraPermission() {
        return arePermissionsGranted("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    /* access modifiers changed from: package-private */
    public void requestCameraPermission() {
        requestPermissions(21, "android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @SuppressLint({"NewApi"})
    private void requestPermissions(int i, String... strArr) {
        if (this.mCurrentSdkVersion >= 23) {
            this.mChatActivity.requestPermissions(strArr, i);
        }
    }

    private boolean arePermissionsGranted(int[] iArr) {
        boolean z = true;
        for (int i : iArr) {
            if (i != 0) {
                z = false;
            }
        }
        return z;
    }

    @SuppressLint({"NewApi"})
    private boolean arePermissionsGranted(String... strArr) {
        if (this.mCurrentSdkVersion < 23) {
            return true;
        }
        boolean z = true;
        for (String checkSelfPermission : strArr) {
            if (this.mChatActivity.checkSelfPermission(checkSelfPermission) != 0) {
                z = false;
            }
        }
        return z;
    }

    static class Builder {
        /* access modifiers changed from: private */
        public ChatFeedActivity mChatActivity;
        /* access modifiers changed from: private */
        public ChatFeedViewBinder.Builder mChatFeedViewBinderBuilder;
        /* access modifiers changed from: private */
        public int mCurrentSdkVersion = Build.VERSION.SDK_INT;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder chatActivity(ChatFeedActivity chatFeedActivity) {
            this.mChatActivity = chatFeedActivity;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder chatFeedViewBinderBuilder(ChatFeedViewBinder.Builder builder) {
            this.mChatFeedViewBinderBuilder = builder;
            return this;
        }

        /* access modifiers changed from: package-private */
        public ChatFeedActivityDelegate build() {
            Arguments.checkNotNull(this.mChatActivity);
            if (this.mChatFeedViewBinderBuilder == null) {
                this.mChatFeedViewBinderBuilder = new ChatFeedViewBinder.Builder();
            }
            return new ChatFeedActivityDelegate(this);
        }
    }
}
