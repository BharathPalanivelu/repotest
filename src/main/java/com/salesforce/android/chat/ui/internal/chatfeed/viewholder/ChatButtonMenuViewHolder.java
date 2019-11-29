package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ChatButtonMenuMessage;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.concurrent.atomic.AtomicBoolean;

public class ChatButtonMenuViewHolder extends RecyclerView.w implements DataBinder {
    private ViewGroup mButtonContainer;
    /* access modifiers changed from: private */
    public ChatButtonMenuMessage mChatWindowButtonMenuMessage;
    private Context mContext;

    ChatButtonMenuViewHolder(View view) {
        super(view);
        this.mButtonContainer = (ViewGroup) view.findViewById(R.id.chat_menu_button_container);
        this.mContext = view.getContext();
    }

    public void setData(Object obj) {
        if (obj instanceof ChatButtonMenuMessage) {
            this.mChatWindowButtonMenuMessage = (ChatButtonMenuMessage) obj;
            this.mButtonContainer.removeAllViews();
            for (ChatWindowButtonMenu.Button buildButton : this.mChatWindowButtonMenuMessage.getButtons()) {
                this.mButtonContainer.addView(buildButton(buildButton));
            }
        }
    }

    private View buildButton(ChatWindowButtonMenu.Button button) {
        int i = R.style.ServiceChatButton;
        LinearLayout linearLayout = new LinearLayout(this.mContext, (AttributeSet) null, 0, R.style.ServiceChatButtonHolder);
        Button button2 = new Button(this.mContext, (AttributeSet) null, 0, i);
        setButtonListener(button2, button);
        button2.setText(button.getLabel());
        button2.setClickable(true);
        linearLayout.addView(button2);
        return linearLayout;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setButtonListener(final Button button, final ChatWindowButtonMenu.Button button2) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        button.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    ChatButtonMenuViewHolder.this.applyChatButtonPressedStyle(button, true);
                } else if (action == 3) {
                    ChatButtonMenuViewHolder.this.applyChatButtonPressedStyle(button, false);
                }
                return false;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!atomicBoolean.getAndSet(true)) {
                    ChatButtonMenuViewHolder.this.mChatWindowButtonMenuMessage.setSelectedButton(button2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void applyChatButtonPressedStyle(Button button, boolean z) {
        if (z) {
            button.setTextColor(this.mContext.getResources().getColor(R.color.salesforce_brand_secondary_inverted));
            button.setBackground(a.b(this.mContext, R.drawable.chat_button_pressed));
            return;
        }
        button.setTextColor(this.mContext.getResources().getColor(R.color.salesforce_brand_secondary));
        button.setBackground(a.b(this.mContext, R.drawable.chat_button));
    }

    public static class Builder implements ViewHolderBuilder<ChatButtonMenuViewHolder> {
        private View mButtonView;

        public int getKey() {
            return 7;
        }

        public int getLayoutResource() {
            return R.layout.chat_button_menu;
        }

        public ViewHolderBuilder<ChatButtonMenuViewHolder> itemView(View view) {
            this.mButtonView = view;
            return this;
        }

        public ChatButtonMenuViewHolder build() {
            Arguments.checkNotNull(this.mButtonView);
            return new ChatButtonMenuViewHolder(this.mButtonView);
        }
    }
}
