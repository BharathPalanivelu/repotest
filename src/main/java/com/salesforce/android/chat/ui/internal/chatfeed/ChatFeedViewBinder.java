package com.salesforce.android.chat.ui.internal.chatfeed;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.core.model.AgentInformation;
import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.ChatBotFooterMenuAdapter;
import com.salesforce.android.chat.ui.internal.dialog.ChatEndSessionAlertDialog;
import com.salesforce.android.chat.ui.internal.dialog.ChatImageSourceAdapter;
import com.salesforce.android.chat.ui.internal.dialog.ChatImageSourceAlertDialog;
import com.salesforce.android.chat.ui.internal.dialog.ChatImageSourceViewHolder;
import com.salesforce.android.service.common.ui.internal.messaging.MessageFeedAdapter;
import com.salesforce.android.service.common.ui.internal.messaging.MessageItemAnimator;
import com.salesforce.android.service.common.ui.internal.text.SalesforceTextWatcher;
import com.salesforce.android.service.common.ui.views.SalesforceBottomSheetMenu;
import com.salesforce.android.service.common.ui.views.SalesforceConnectionBanner;
import com.salesforce.android.service.common.ui.views.SalesforceEditText;
import com.salesforce.android.service.common.ui.views.SalesforceTextView;
import com.salesforce.android.service.common.utilities.internal.device.OrientationTracker;
import com.salesforce.android.service.common.utilities.spatial.Orientation;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import d.d.a.a;
import d.p;

public class ChatFeedViewBinder implements ChatFeedView, SalesforceTextWatcher.OnAfterTextChangedListener, OrientationTracker.Listener {
    static final String EXTRA_AGENT_NAME = "com.salesforce.android.chat.ui.internal.chatfeed.AgentName";
    static final String EXTRA_MESSAGE_TEXT = "com.salesforce.android.chat.ui.internal.chatfeed.PendingMessageText";
    private AgentInformation mAgentInformation;
    private SalesforceTextView mAgentName;
    /* access modifiers changed from: private */
    public SalesforceBottomSheetMenu mBottomSheetMenu;
    private SalesforceConnectionBanner mChatConnectionBanner;
    private final ChatEndSessionAlertDialog mChatEndSessionAlertDialog;
    /* access modifiers changed from: private */
    public final ChatFeedActivityDelegate mChatFeedActivity;
    /* access modifiers changed from: private */
    public final ChatFeedPresenter mChatFeedPresenter;
    RecyclerView mChatFeedRecyclerView;
    /* access modifiers changed from: private */
    public final ChatImageSourceAlertDialog mChatImageSourceAlertDialog;
    private boolean mConnected;
    private ChatBotFooterMenuAdapter mFooterMenuAdapter;
    private String mFooterMenuContentDescription;
    private Drawable mFooterMenuIcon;
    private View mInputFooter;
    /* access modifiers changed from: private */
    public final InputMethodManager mInputMethodManager;
    private final LinearLayoutManager mLinearLayoutManager;
    private MessageFeedAdapter mMessageFeedAdapter;
    SalesforceEditText mMessageInput;
    private ImageButton mMessageInputActionButton;
    private final SalesforceTextWatcher mMessageInputTextWatcher;
    private OrientationTracker mOrientationTracker;
    private String mPendingMessageText;
    private String mSelectPhotoContentDescription;
    private Drawable mSelectPhotoIcon;
    ImageButton mSendButton;

    private ChatFeedViewBinder(Builder builder) {
        this.mConnected = true;
        this.mChatFeedActivity = builder.mChatFeedActivity;
        this.mChatFeedPresenter = builder.mChatFeedPresenter;
        this.mLinearLayoutManager = builder.mLinearLayoutManager;
        this.mMessageInputTextWatcher = builder.mMessageInputTextWatcher;
        this.mInputMethodManager = builder.mInputMethodManager;
        this.mChatEndSessionAlertDialog = builder.mChatEndSessionAlertDialog;
        this.mChatImageSourceAlertDialog = builder.mChatImageSourceAlertDialog;
        this.mChatImageSourceAlertDialog.setOnTakePhoto(new a<p>() {
            public p invoke() {
                if (ChatFeedViewBinder.this.mChatFeedActivity.hasCameraPermission()) {
                    ChatFeedViewBinder.this.onCameraPermitted();
                    return null;
                }
                ChatFeedViewBinder.this.mChatFeedActivity.requestCameraPermission();
                return null;
            }
        });
        this.mChatImageSourceAlertDialog.setOnUseLastPhoto(new a<p>() {
            public p invoke() {
                if (ChatFeedViewBinder.this.mChatFeedActivity.hasSelectLastPhotoPermission()) {
                    ChatFeedViewBinder.this.onGetLastPhotoPermitted();
                    return null;
                }
                ChatFeedViewBinder.this.mChatFeedActivity.requestSelectLastPhotoPermission();
                return null;
            }
        });
        this.mChatImageSourceAlertDialog.setOnOpenGallery(new a<p>() {
            public p invoke() {
                if (ChatFeedViewBinder.this.mChatFeedActivity.hasGalleryPermission()) {
                    ChatFeedViewBinder.this.onGalleryPermitted();
                    return null;
                }
                ChatFeedViewBinder.this.mChatFeedActivity.requestGalleryPermission();
                return null;
            }
        });
        this.mMessageInputTextWatcher.setOnAfterTextChangedListener(this);
    }

    public void onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        bind(viewGroup);
        ChatFeedPresenter chatFeedPresenter = this.mChatFeedPresenter;
        if (chatFeedPresenter != null) {
            chatFeedPresenter.onViewCreated(this);
        }
        if (this.mOrientationTracker == null) {
            this.mOrientationTracker = new OrientationTracker.Builder().with(viewGroup.getContext()).listener(this).build();
        }
        if (this.mChatFeedPresenter != null) {
            if (this.mOrientationTracker.getOrientation() == Orientation.LANDSCAPE) {
                this.mChatFeedPresenter.hideChatBanner();
            } else {
                this.mChatFeedPresenter.showChatBanner();
            }
        }
        enableMessageControls(true);
        SalesforceConnectionBanner salesforceConnectionBanner = this.mChatConnectionBanner;
        if (salesforceConnectionBanner != null) {
            boolean z = this.mConnected;
            if (!z) {
                salesforceConnectionBanner.toggleDisplay(z);
            }
        }
    }

    public void onDestroyView() {
        RecyclerView recyclerView = this.mChatFeedRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager((RecyclerView.i) null);
            this.mChatFeedRecyclerView.setItemAnimator((RecyclerView.f) null);
            this.mChatFeedRecyclerView.setAdapter((RecyclerView.a) null);
        }
        ChatFeedPresenter chatFeedPresenter = this.mChatFeedPresenter;
        if (chatFeedPresenter != null) {
            chatFeedPresenter.onViewDestroyed(this);
        }
        ChatBotFooterMenuAdapter chatBotFooterMenuAdapter = this.mFooterMenuAdapter;
        if (chatBotFooterMenuAdapter != null) {
            chatBotFooterMenuAdapter.setOnMenuItemSelectedListener((ChatBotFooterMenuAdapter.OnMenuItemSelectedListener) null);
        }
        OrientationTracker orientationTracker = this.mOrientationTracker;
        if (orientationTracker != null) {
            orientationTracker.teardown();
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.mPendingMessageText = bundle.getString(EXTRA_MESSAGE_TEXT);
        this.mAgentName.setText(bundle.getString(EXTRA_AGENT_NAME));
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(EXTRA_MESSAGE_TEXT, this.mMessageInput.getText().toString());
        bundle.putString(EXTRA_AGENT_NAME, this.mAgentName.getText().toString());
    }

    public boolean onBackPressed() {
        ChatFeedPresenter chatFeedPresenter = this.mChatFeedPresenter;
        if (chatFeedPresenter == null) {
            return false;
        }
        chatFeedPresenter.onMinimizePressed();
        return false;
    }

    public Context getContext() {
        return this.mChatFeedActivity.getContext();
    }

    public void onToolbarInflated(Toolbar toolbar) {
        this.mAgentName = (SalesforceTextView) toolbar.findViewById(R.id.chat_feed_agent_name);
    }

    public boolean onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.chat_feed_toolbar_menu, menu);
        MenuItem findItem = menu.findItem(R.id.chat_toolbar_minimize);
        if (this.mChatFeedPresenter == null) {
            findItem.setVisible(false);
        } else {
            findItem.setVisible(true);
        }
        AgentInformation agentInformation = this.mAgentInformation;
        if (agentInformation != null) {
            this.mAgentName.setText(agentInformation.getAgentName());
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            ChatFeedPresenter chatFeedPresenter = this.mChatFeedPresenter;
            if (chatFeedPresenter == null) {
                this.mChatFeedActivity.finish();
                return true;
            } else if (chatFeedPresenter.getCurrentSessionState() != ChatSessionState.Disconnected) {
                this.mChatEndSessionAlertDialog.accept(new a<p>() {
                    public p invoke() {
                        ChatFeedViewBinder.this.mChatFeedPresenter.endSession();
                        return null;
                    }
                });
                this.mChatEndSessionAlertDialog.show(this.mChatFeedActivity.getContext());
                return true;
            } else {
                this.mChatFeedPresenter.endSession();
                return true;
            }
        } else if (itemId != R.id.chat_toolbar_minimize) {
            return true;
        } else {
            ChatFeedPresenter chatFeedPresenter2 = this.mChatFeedPresenter;
            if (chatFeedPresenter2 == null) {
                return true;
            }
            chatFeedPresenter2.onMinimizePressed();
            return true;
        }
    }

    public void onCameraPermitted() {
        ChatFeedPresenter chatFeedPresenter = this.mChatFeedPresenter;
        if (chatFeedPresenter != null) {
            this.mChatFeedActivity.launchCamera(chatFeedPresenter.createNewImageContent());
        }
    }

    public void onGetLastPhotoPermitted() {
        try {
            if (this.mChatFeedPresenter != null) {
                this.mChatFeedPresenter.transferImage(this.mChatFeedPresenter.getLastPhotoTaken());
            }
        } catch (Exception unused) {
            this.mChatFeedActivity.showToast(R.string.chat_image_selection_failed, 0);
        }
    }

    public void onGalleryPermitted() {
        this.mChatFeedActivity.selectImageFromGallery();
    }

    public void toggleConnectionBanner(boolean z) {
        this.mConnected = z;
        SalesforceConnectionBanner salesforceConnectionBanner = this.mChatConnectionBanner;
        if (salesforceConnectionBanner != null) {
            salesforceConnectionBanner.toggleDisplay(z);
        }
    }

    public void setAgentInformation(AgentInformation agentInformation) {
        this.mAgentInformation = agentInformation;
        SalesforceTextView salesforceTextView = this.mAgentName;
        if (salesforceTextView != null) {
            salesforceTextView.setText(agentInformation.getAgentName());
        }
    }

    public void setMessageFeedAdapter(MessageFeedAdapter messageFeedAdapter) {
        RecyclerView recyclerView = this.mChatFeedRecyclerView;
        if (recyclerView != null) {
            this.mMessageFeedAdapter = messageFeedAdapter;
            this.mMessageFeedAdapter.bind(recyclerView);
            scrollToBottom();
        }
    }

    public void setFooterMenuAdapter(ChatBotFooterMenuAdapter chatBotFooterMenuAdapter) {
        if (this.mBottomSheetMenu != null && this.mMessageInputActionButton != null) {
            this.mFooterMenuAdapter = chatBotFooterMenuAdapter;
            this.mFooterMenuAdapter.setOnMenuItemSelectedListener(new ChatBotFooterMenuAdapter.OnMenuItemSelectedListener() {
                public void onMenuItemSelected(ChatFooterMenu.MenuItem menuItem) {
                    if (ChatFeedViewBinder.this.mChatFeedPresenter != null) {
                        ChatFeedViewBinder.this.mChatFeedPresenter.sendFooterMenuSelection(menuItem);
                    }
                }
            });
            this.mBottomSheetMenu.setAdapter(chatBotFooterMenuAdapter);
            this.mBottomSheetMenu.setOnVisibilityChangedListener(new SalesforceBottomSheetMenu.OnVisibilityChangedListener() {
                public void onVisibilityChanged(boolean z) {
                    if (z && ChatFeedViewBinder.this.mInputMethodManager.isAcceptingText() && ChatFeedViewBinder.this.mInputMethodManager.isActive(ChatFeedViewBinder.this.mMessageInput)) {
                        ChatFeedViewBinder.this.mInputMethodManager.hideSoftInputFromWindow(ChatFeedViewBinder.this.mMessageInput.getWindowToken(), 0);
                        if (ChatFeedViewBinder.this.mMessageInput.hasFocus()) {
                            ChatFeedViewBinder.this.mMessageInput.clearFocus();
                        }
                    }
                }
            });
        }
    }

    public void enableFooterMenu() {
        this.mMessageInputActionButton.setImageDrawable(this.mFooterMenuIcon);
        this.mMessageInputActionButton.setContentDescription(this.mFooterMenuContentDescription);
        this.mMessageInputActionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ChatFeedViewBinder.this.mBottomSheetMenu.toggleVisibility();
            }
        });
        this.mMessageInputActionButton.setVisibility(0);
        this.mMessageInputActionButton.setEnabled(true);
        this.mBottomSheetMenu.setOnVisibilityChangedListener(new SalesforceBottomSheetMenu.OnVisibilityChangedListener() {
            public void onVisibilityChanged(boolean z) {
                ChatFeedViewBinder.this.enableMessageControls(!z);
            }
        });
    }

    public void disableFooterMenu() {
        this.mBottomSheetMenu.collapse();
        this.mMessageInputActionButton.setVisibility(8);
        this.mMessageInputActionButton.setEnabled(false);
    }

    public void scrollToBottom() {
        MessageFeedAdapter messageFeedAdapter = this.mMessageFeedAdapter;
        if (messageFeedAdapter != null && messageFeedAdapter.getItemCount() > 0) {
            this.mMessageFeedAdapter.scrollToBottom();
        }
    }

    public void setPhotoSelectionEnabled(boolean z) {
        if (z) {
            this.mMessageInputActionButton.setImageDrawable(this.mSelectPhotoIcon);
            this.mMessageInputActionButton.setContentDescription(this.mSelectPhotoContentDescription);
            this.mMessageInputActionButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ChatFeedViewBinder.this.mChatImageSourceAlertDialog.show(view.getContext());
                }
            });
        }
        this.mMessageInputActionButton.setVisibility(z ? 0 : 8);
        this.mMessageInputActionButton.setEnabled(z);
    }

    public void onImageSelected(Uri uri) {
        ChatFeedPresenter chatFeedPresenter = this.mChatFeedPresenter;
        if (chatFeedPresenter != null) {
            try {
                chatFeedPresenter.transferImage(uri);
            } catch (Exception unused) {
                this.mChatFeedActivity.showToast(R.string.chat_image_selection_failed, 0);
            }
        }
    }

    public void onPhotoTaken() {
        ChatFeedPresenter chatFeedPresenter = this.mChatFeedPresenter;
        if (chatFeedPresenter != null) {
            chatFeedPresenter.transferNewImageContent();
        }
    }

    public void onPermissionsNotGranted() {
        this.mChatFeedActivity.showToast(R.string.chat_permission_not_granted, 0);
    }

    public void onImageSelectionFailed() {
        this.mChatFeedActivity.showToast(R.string.chat_image_selection_failed, 0);
    }

    public void disableInputs() {
        if (this.mMessageInput.hasFocus() && this.mChatFeedPresenter != null) {
            this.mMessageInput.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.mChatFeedPresenter.getApplicationContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.mMessageInput.getWindowToken(), 2);
            }
        }
        this.mMessageInput.setEnabled(false);
        this.mMessageInput.setFocusable(false);
        this.mMessageInput.setFocusableInTouchMode(false);
        this.mMessageInput.setCursorVisible(false);
        this.mSendButton.setClickable(false);
        setPhotoSelectionEnabled(false);
        View view = this.mInputFooter;
        view.setTranslationY((float) view.getHeight());
        this.mInputFooter.setVisibility(8);
    }

    public void onTransferringToAgent() {
        AgentInformation agentInformation = this.mAgentInformation;
        if (agentInformation == null || !agentInformation.isChatBot()) {
            this.mAgentName.setText(R.string.chat_feed_title);
        } else {
            this.mAgentName.setText(R.string.chatbot_transferring_toolbar_title);
        }
    }

    public void onOrientationChange(Orientation orientation) {
        if (this.mChatFeedPresenter == null) {
            return;
        }
        if (orientation == Orientation.PORTRAIT) {
            this.mChatFeedPresenter.showChatBanner();
        } else {
            this.mChatFeedPresenter.hideChatBanner();
        }
    }

    public void onAfterTextChanged(Editable editable) {
        if (this.mChatFeedPresenter != null) {
            boolean z = editable.length() > 0;
            this.mChatFeedPresenter.setIsUserTyping(z);
            this.mChatFeedPresenter.sendSneakPeekMessage(editable.toString());
            this.mChatFeedPresenter.setCachedMessageInput(editable.toString());
            this.mSendButton.setEnabled(z);
        }
    }

    private void bind(View view) {
        this.mChatFeedRecyclerView = (RecyclerView) view.findViewById(R.id.chat_message_feed);
        this.mInputFooter = view.findViewById(R.id.chat_feed_input_footer);
        this.mMessageInput = (SalesforceEditText) view.findViewById(R.id.salesforce_message_input);
        this.mSendButton = (ImageButton) view.findViewById(R.id.salesforce_send_message_button);
        this.mMessageInputActionButton = (ImageButton) view.findViewById(R.id.salesforce_message_input_action_button);
        this.mBottomSheetMenu = (SalesforceBottomSheetMenu) view.findViewById(R.id.chat_bottom_sheet_menu);
        View findViewById = view.findViewById(R.id.chat_resume_error);
        this.mChatConnectionBanner = (SalesforceConnectionBanner) view.findViewById(R.id.chat_connection_banner);
        this.mSendButton.setEnabled(false);
        this.mSendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ChatFeedViewBinder.this.sendMessage();
            }
        });
        this.mSelectPhotoContentDescription = view.getContext().getString(R.string.salesforce_select_photo_content_description);
        this.mSelectPhotoIcon = androidx.appcompat.a.a.a.b(view.getContext(), R.drawable.salesforce_ic_camera);
        this.mFooterMenuContentDescription = view.getContext().getString(R.string.chat_footer_menu_button_content_description);
        this.mFooterMenuIcon = androidx.appcompat.a.a.a.b(view.getContext(), R.drawable.chat_ic_footer_menu);
        setupMessageInput();
        if (this.mPendingMessageText == null) {
            ChatFeedPresenter chatFeedPresenter = this.mChatFeedPresenter;
            if (chatFeedPresenter != null) {
                this.mPendingMessageText = chatFeedPresenter.getCachedMessageInput();
                this.mChatFeedPresenter.setCachedMessageInput("");
            }
        }
        String str = this.mPendingMessageText;
        if (str != null) {
            this.mMessageInput.setText(str);
            this.mMessageInput.setSelection(this.mPendingMessageText.length());
            this.mPendingMessageText = null;
        }
        this.mChatFeedRecyclerView.setItemAnimator(new MessageItemAnimator());
        this.mChatFeedRecyclerView.setLayoutManager(this.mLinearLayoutManager);
        this.mChatFeedRecyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, final int i4, int i5, int i6, int i7, int i8) {
                if (i4 < i8) {
                    ChatFeedViewBinder.this.mChatFeedRecyclerView.postDelayed(new Runnable() {
                        public void run() {
                            ChatFeedViewBinder.this.mChatFeedRecyclerView.d(i4);
                        }
                    }, 100);
                }
            }
        });
        if (this.mChatFeedPresenter == null) {
            findViewById.setVisibility(0);
            disableInputs();
            this.mChatFeedRecyclerView.setVisibility(8);
            return;
        }
        findViewById.setVisibility(8);
        this.mInputFooter.setVisibility(0);
        this.mChatFeedRecyclerView.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void enableMessageControls(boolean z) {
        this.mMessageInput.setEnabled(z);
        int i = 1;
        this.mMessageInput.setImportantForAccessibility(z ? 1 : 2);
        ImageButton imageButton = this.mSendButton;
        if (!z) {
            i = 2;
        }
        imageButton.setImportantForAccessibility(i);
    }

    private void setupMessageInput() {
        if (this.mChatFeedPresenter != null) {
            this.mMessageInput.getBackground().setColorFilter(b.c(this.mChatFeedPresenter.getApplicationContext(), R.color.salesforce_contrast_secondary), PorterDuff.Mode.SRC_IN);
            this.mMessageInput.setHorizontallyScrolling(false);
            this.mMessageInput.setMaxLines(Integer.MAX_VALUE);
            this.mMessageInput.setBackgroundColor(b.c(this.mChatFeedPresenter.getApplicationContext(), 17170445));
            this.mMessageInput.addTextChangedListener(this.mMessageInputTextWatcher);
            this.mMessageInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 6 && i != 4) {
                        return false;
                    }
                    ChatFeedViewBinder.this.sendMessage();
                    return true;
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void sendMessage() {
        if (this.mChatFeedPresenter != null) {
            String obj = this.mMessageInput.getText().toString();
            if (!obj.isEmpty()) {
                this.mChatFeedPresenter.sendMessage(obj);
                this.mChatFeedPresenter.setIsUserTyping(false);
                this.mMessageInput.setText("");
            }
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public ChatEndSessionAlertDialog mChatEndSessionAlertDialog;
        /* access modifiers changed from: private */
        public ChatFeedActivityDelegate mChatFeedActivity;
        /* access modifiers changed from: private */
        public ChatFeedPresenter mChatFeedPresenter;
        /* access modifiers changed from: private */
        public ChatImageSourceAlertDialog mChatImageSourceAlertDialog;
        private Context mContext;
        /* access modifiers changed from: private */
        public InputMethodManager mInputMethodManager;
        /* access modifiers changed from: private */
        public LinearLayoutManager mLinearLayoutManager;
        /* access modifiers changed from: private */
        public SalesforceTextWatcher mMessageInputTextWatcher;

        public Builder activity(ChatFeedActivityDelegate chatFeedActivityDelegate) {
            this.mChatFeedActivity = chatFeedActivityDelegate;
            return this;
        }

        public Builder presenter(ChatFeedPresenter chatFeedPresenter) {
            this.mChatFeedPresenter = chatFeedPresenter;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder applicationContext(Context context) {
            this.mContext = context;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder linearLayoutManager(LinearLayoutManager linearLayoutManager) {
            this.mLinearLayoutManager = linearLayoutManager;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder textWatcher(SalesforceTextWatcher salesforceTextWatcher) {
            this.mMessageInputTextWatcher = salesforceTextWatcher;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder inputMethodManager(InputMethodManager inputMethodManager) {
            this.mInputMethodManager = inputMethodManager;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder chatEndSessionDialog(ChatEndSessionAlertDialog chatEndSessionAlertDialog) {
            this.mChatEndSessionAlertDialog = chatEndSessionAlertDialog;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder chatImageSourceDialog(ChatImageSourceAlertDialog chatImageSourceAlertDialog) {
            this.mChatImageSourceAlertDialog = chatImageSourceAlertDialog;
            return this;
        }

        public ChatFeedView build() {
            Arguments.checkNotNull(this.mChatFeedActivity);
            if (this.mContext == null) {
                ChatFeedPresenter chatFeedPresenter = this.mChatFeedPresenter;
                if (chatFeedPresenter != null) {
                    this.mContext = chatFeedPresenter.getApplicationContext();
                }
            }
            Arguments.checkNotNull(this.mContext, "Presenter is not sharing the Application Context");
            if (this.mLinearLayoutManager == null) {
                this.mLinearLayoutManager = new LinearLayoutManager(this.mContext);
            }
            if (this.mMessageInputTextWatcher == null) {
                this.mMessageInputTextWatcher = new SalesforceTextWatcher();
            }
            if (this.mInputMethodManager == null) {
                this.mInputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
            }
            if (this.mChatEndSessionAlertDialog == null) {
                this.mChatEndSessionAlertDialog = new ChatEndSessionAlertDialog();
            }
            if (this.mChatImageSourceAlertDialog == null) {
                Context context = this.mContext;
                this.mChatImageSourceAlertDialog = new ChatImageSourceAlertDialog(context, new ChatImageSourceAdapter(context, LayoutInflater.from(context), new ChatImageSourceViewHolder.Factory()));
            }
            return new ChatFeedViewBinder(this);
        }
    }
}
