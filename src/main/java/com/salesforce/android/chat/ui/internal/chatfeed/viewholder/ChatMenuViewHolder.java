package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.a;
import androidx.legacy.widget.Space;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.core.model.ChatWindowMenu;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatMenuMessage;
import com.salesforce.android.chat.ui.internal.state.AvatarCache;
import com.salesforce.android.service.common.ui.internal.messaging.GroupableView;
import com.salesforce.android.service.common.ui.views.SalesforceButton;
import com.salesforce.android.service.common.utilities.validation.Arguments;

class ChatMenuViewHolder extends RecyclerView.w implements DataBinder, GroupableView {
    private ImageView mAgentAvatar;
    private final AvatarCache mAvatarCache;
    private View mAvatarContainer;
    private Context mContext;
    private Space mFooterSpace;
    private TextView mMenuHeaderText;
    private ViewGroup mMenuItemContainer;

    private ChatMenuViewHolder(View view, AvatarCache avatarCache) {
        super(view);
        this.mAvatarCache = avatarCache;
        this.mMenuHeaderText = (TextView) view.findViewById(R.id.chat_menu_header_text);
        this.mMenuItemContainer = (ViewGroup) view.findViewById(R.id.chat_menu_item_container);
        this.mAvatarContainer = view.findViewById(R.id.salesforce_agent_avatar_container);
        this.mAgentAvatar = (ImageView) view.findViewById(R.id.salesforce_agent_avatar);
        this.mFooterSpace = (Space) view.findViewById(R.id.chat_menu_footer_space);
        this.mContext = view.getContext();
        this.mFooterSpace.setVisibility(0);
    }

    public void setData(Object obj) {
        if (obj instanceof ChatMenuMessage) {
            ChatMenuMessage chatMenuMessage = (ChatMenuMessage) obj;
            AvatarCache avatarCache = this.mAvatarCache;
            if (avatarCache != null) {
                this.mAgentAvatar.setImageDrawable(avatarCache.getAvatar(chatMenuMessage.getId()));
            }
            if (chatMenuMessage.getHeaderText() != null) {
                this.mMenuHeaderText.setText(chatMenuMessage.getHeaderText());
                this.mMenuHeaderText.setVisibility(0);
            } else {
                this.mMenuHeaderText.setVisibility(8);
            }
            this.mMenuItemContainer.removeAllViews();
            for (ChatWindowMenu.MenuItem buildMenuItem : chatMenuMessage.getMenuItems()) {
                this.mMenuItemContainer.addView(buildMenuItem(chatMenuMessage, buildMenuItem));
            }
        }
    }

    public void onGroupView() {
        this.mAvatarContainer.setVisibility(4);
        this.mFooterSpace.setVisibility(8);
    }

    public void onUngroupView() {
        this.mAvatarContainer.setVisibility(0);
        this.mFooterSpace.setVisibility(0);
    }

    private SalesforceButton buildMenuItem(final ChatMenuMessage chatMenuMessage, final ChatWindowMenu.MenuItem menuItem) {
        int i = R.style.ServiceChatMenuItem;
        int length = chatMenuMessage.getMenuItems().length;
        if (chatMenuMessage.getHeaderText() == null && length == 1) {
            i = R.style.ServiceChatMenuItem_Solo;
        } else if (chatMenuMessage.getHeaderText() == null && menuItem.getIndex() == 0 && length > 1) {
            i = R.style.ServiceChatMenuItem_Top;
        } else if (menuItem.getIndex() == length - 1) {
            i = R.style.ServiceChatMenuItem_Bottom;
        }
        final SalesforceButton salesforceButton = new SalesforceButton(new ContextThemeWrapper(this.itemView.getContext(), i), (AttributeSet) null, i);
        salesforceButton.setText(menuItem.getLabel());
        salesforceButton.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0 || action == 2) {
                    salesforceButton.getBackground().setAlpha(77);
                    return false;
                } else if (action != 3) {
                    return false;
                } else {
                    salesforceButton.getBackground().setAlpha(255);
                    return false;
                }
            }
        });
        salesforceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                chatMenuMessage.setSelectedMenuItem(menuItem);
            }
        });
        salesforceButton.setOnHoverListener(new View.OnHoverListener() {
            /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
                if (r5 != 10) goto L_0x0029;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
                /*
                    r3 = this;
                    int r5 = r5.getAction()
                    r0 = 3
                    r1 = 0
                    if (r5 == r0) goto L_0x001e
                    r0 = 9
                    if (r5 == r0) goto L_0x0011
                    r0 = 10
                    if (r5 == r0) goto L_0x001e
                    goto L_0x0029
                L_0x0011:
                    com.salesforce.android.chat.ui.internal.chatfeed.viewholder.ChatMenuViewHolder r5 = com.salesforce.android.chat.ui.internal.chatfeed.viewholder.ChatMenuViewHolder.this
                    r0 = 1
                    com.salesforce.android.chat.ui.internal.chatfeed.model.ChatMenuMessage r2 = r5
                    boolean r2 = r2.isEnabled()
                    r5.applyChatButtonPressedStyle(r4, r0, r2)
                    goto L_0x0029
                L_0x001e:
                    com.salesforce.android.chat.ui.internal.chatfeed.viewholder.ChatMenuViewHolder r5 = com.salesforce.android.chat.ui.internal.chatfeed.viewholder.ChatMenuViewHolder.this
                    com.salesforce.android.chat.ui.internal.chatfeed.model.ChatMenuMessage r0 = r5
                    boolean r0 = r0.isEnabled()
                    r5.applyChatButtonPressedStyle(r4, r1, r0)
                L_0x0029:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.ui.internal.chatfeed.viewholder.ChatMenuViewHolder.AnonymousClass3.onHover(android.view.View, android.view.MotionEvent):boolean");
            }
        });
        applyChatButtonPressedStyle(salesforceButton, false, chatMenuMessage.isEnabled());
        return salesforceButton;
    }

    /* access modifiers changed from: private */
    public void applyChatButtonPressedStyle(View view, boolean z, boolean z2) {
        int color = view.getContext().getResources().getColor(R.color.salesforce_brand_secondary);
        if (z2) {
            view.setClickable(true);
            view.setEnabled(true);
            if (z) {
                color = this.mContext.getResources().getColor(R.color.salesforce_contrast_inverted);
            }
        } else {
            view.setClickable(false);
            view.setEnabled(false);
            color = a.c(color, 179);
        }
        if (view instanceof SalesforceButton) {
            ((SalesforceButton) view).setTextColor(color);
        }
    }

    public static class Builder implements AvatarViewHolderBuilder<ChatMenuViewHolder> {
        private AvatarCache mAvatarCache;
        private View mItemView;

        public int getKey() {
            return 6;
        }

        public int getLayoutResource() {
            return R.layout.chat_menu_message;
        }

        public Builder itemView(View view) {
            this.mItemView = view;
            return this;
        }

        public Builder avatarCache(AvatarCache avatarCache) {
            this.mAvatarCache = avatarCache;
            return this;
        }

        public ChatMenuViewHolder build() {
            Arguments.checkNotNull(this.mItemView);
            View view = this.mItemView;
            AvatarCache avatarCache = this.mAvatarCache;
            this.mItemView = null;
            this.mAvatarCache = null;
            return new ChatMenuViewHolder(view, avatarCache);
        }
    }
}
