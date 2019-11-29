package com.salesforce.android.chat.ui.internal.chatfeed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.service.common.ui.views.SalesforceBottomSheetMenu;
import com.salesforce.android.service.common.ui.views.SalesforceButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ChatBotFooterMenuAdapter implements SalesforceBottomSheetMenu.Adapter {
    private List<ChatFooterMenu.MenuItem> mMenuItems = new ArrayList();
    /* access modifiers changed from: private */
    public OnMenuItemSelectedListener mOnMenuItemSelectedListener;

    interface OnMenuItemSelectedListener {
        void onMenuItemSelected(ChatFooterMenu.MenuItem menuItem);
    }

    /* access modifiers changed from: package-private */
    public void setMenuItems(ChatFooterMenu chatFooterMenu) {
        this.mMenuItems = Arrays.asList(chatFooterMenu.getMenuItems());
    }

    /* access modifiers changed from: package-private */
    public void setOnMenuItemSelectedListener(OnMenuItemSelectedListener onMenuItemSelectedListener) {
        this.mOnMenuItemSelectedListener = onMenuItemSelectedListener;
    }

    public int getItemCount() {
        return this.mMenuItems.size() + 1;
    }

    public View onCreateMenuItem(SalesforceBottomSheetMenu salesforceBottomSheetMenu, int i) {
        if (i == 0) {
            return buildMenuHeader(salesforceBottomSheetMenu.getContext(), salesforceBottomSheetMenu);
        }
        return buildMenuItem(salesforceBottomSheetMenu.getContext(), this.mMenuItems.get(i - 1));
    }

    private View buildMenuHeader(Context context, final SalesforceBottomSheetMenu salesforceBottomSheetMenu) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chat_bot_footer_menu_header_item, salesforceBottomSheetMenu, false);
        inflate.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        return false;
                    }
                    salesforceBottomSheetMenu.collapse();
                }
                return true;
            }
        });
        return inflate;
    }

    private SalesforceButton buildMenuItem(Context context, final ChatFooterMenu.MenuItem menuItem) {
        int i = R.style.ServiceChatFooterMenuItem;
        final SalesforceButton salesforceButton = new SalesforceButton(new ContextThemeWrapper(context, i), (AttributeSet) null, i);
        salesforceButton.setText(menuItem.getText());
        salesforceButton.getBackground().setAlpha(77);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        salesforceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ChatBotFooterMenuAdapter.this.mOnMenuItemSelectedListener != null && atomicBoolean.get()) {
                    atomicBoolean.set(false);
                    salesforceButton.postDelayed(new Runnable() {
                        public void run() {
                            atomicBoolean.set(true);
                        }
                    }, 400);
                    ChatBotFooterMenuAdapter.this.mOnMenuItemSelectedListener.onMenuItemSelected(menuItem);
                }
            }
        });
        return salesforceButton;
    }
}
