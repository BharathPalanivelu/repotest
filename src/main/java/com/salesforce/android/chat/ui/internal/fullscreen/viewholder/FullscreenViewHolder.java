package com.salesforce.android.chat.ui.internal.fullscreen.viewholder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.ServerProtocol;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.ui.Mockable;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.service.common.ui.views.SalesforceBottomSheetMenu;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import d.d.b.j;
import d.d.b.r;
import d.m;
import java.util.Arrays;

@Mockable
public class FullscreenViewHolder {
    public static final Companion Companion = new Companion((g) null);
    private static final int INITIAL_QUEUE_POSITION = 1;
    private static final ServiceLogger log = ServiceLogging.getLogger(FullscreenViewHolder.class);
    private final Activity mActivity;
    private ViewGroup mCurrentStatusView;
    private ViewGroup mPreviousStatusView = this.mCurrentStatusView;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[ChatEndReason.values().length];

        static {
            $EnumSwitchMapping$0 = new int[ChatSessionState.values().length];
            $EnumSwitchMapping$0[ChatSessionState.Ready.ordinal()] = 1;
            $EnumSwitchMapping$0[ChatSessionState.Verification.ordinal()] = 2;
            $EnumSwitchMapping$0[ChatSessionState.Initializing.ordinal()] = 3;
            $EnumSwitchMapping$0[ChatSessionState.InQueue.ordinal()] = 4;
            $EnumSwitchMapping$0[ChatSessionState.Connecting.ordinal()] = 5;
            $EnumSwitchMapping$0[ChatSessionState.Disconnected.ordinal()] = 6;
            $EnumSwitchMapping$0[ChatSessionState.Connected.ordinal()] = 7;
            $EnumSwitchMapping$0[ChatSessionState.Ending.ordinal()] = 8;
            $EnumSwitchMapping$1[ChatEndReason.NetworkError.ordinal()] = 1;
            $EnumSwitchMapping$1[ChatEndReason.VerificationError.ordinal()] = 2;
            $EnumSwitchMapping$1[ChatEndReason.Unknown.ordinal()] = 3;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public FullscreenViewHolder(Activity activity) {
        j.b(activity, "mActivity");
        this.mActivity = activity;
        toggleChatFeedVisibility(8);
        updateCurrentStatusView(R.layout.chat_fullscreen_connecting);
    }

    public void attachTo(ChatSessionState chatSessionState) {
        j.b(chatSessionState, ServerProtocol.DIALOG_PARAM_STATE);
        switch (chatSessionState) {
            case Ready:
            case Verification:
            case Initializing:
            case InQueue:
            case Connecting:
                toggleChatFeedVisibility(8);
                updateCurrentStatusView(R.layout.chat_fullscreen_connecting);
                return;
            case Disconnected:
                updateCurrentStatusView(R.layout.chat_fullscreen_disconnected);
                return;
            case Connected:
                toggleChatFeedVisibility(0);
                return;
            case Ending:
                toggleChatFeedVisibility(0);
                return;
            default:
                return;
        }
    }

    public void onSessionEnded(ChatEndReason chatEndReason) {
        j.b(chatEndReason, "endReason");
        int i = WhenMappings.$EnumSwitchMapping$1[chatEndReason.ordinal()];
        if (i == 1) {
            updateCurrentStatusView(R.layout.chat_fullscreen_network_error);
            toggleChatFeedVisibility(8);
        } else if (i == 2 || i == 3) {
            updateCurrentStatusView(R.layout.chat_fullscreen_error);
            toggleChatFeedVisibility(8);
        }
    }

    public void updateQueuePositionText(int i) {
        int i2 = i + 1;
        toggleChatFeedVisibility(8);
        updateCurrentStatusView(R.layout.chat_fullscreen_queued);
        TextView textView = (TextView) this.mActivity.findViewById(R.id.chat_fullscreen_queued_text_number);
        if (textView != null) {
            r rVar = r.f32672a;
            Object[] objArr = {Integer.valueOf(i2)};
            String format = String.format("%d", Arrays.copyOf(objArr, objArr.length));
            j.a((Object) format, "java.lang.String.format(format, *args)");
            textView.setText(format);
        }
        TextView textView2 = (TextView) this.mActivity.findViewById(R.id.chat_fullscreen_queued_text_description);
        if (textView2 != null) {
            r rVar2 = r.f32672a;
            String string = this.mActivity.getResources().getString(R.string.chat_fullscreen_queued_text_description, new Object[]{Integer.valueOf(i2)});
            j.a((Object) string, "mActivity.resources.getS…xt_description, position)");
            Object[] objArr2 = new Object[0];
            String format2 = String.format(string, Arrays.copyOf(objArr2, objArr2.length));
            j.a((Object) format2, "java.lang.String.format(format, *args)");
            textView2.setText(format2);
        }
    }

    private void toggleChatFeedVisibility(int i) {
        RecyclerView recyclerView = (RecyclerView) this.mActivity.findViewById(R.id.chat_message_feed);
        if (recyclerView != null) {
            recyclerView.setVisibility(i);
        }
        FrameLayout frameLayout = (FrameLayout) this.mActivity.findViewById(R.id.chat_feed_input_footer);
        if (frameLayout != null) {
            frameLayout.setVisibility(i);
        }
        SalesforceBottomSheetMenu salesforceBottomSheetMenu = (SalesforceBottomSheetMenu) this.mActivity.findViewById(R.id.chat_bottom_sheet_menu);
        if (salesforceBottomSheetMenu != null) {
            salesforceBottomSheetMenu.setVisibility(i);
        }
        FrameLayout frameLayout2 = (FrameLayout) this.mActivity.findViewById(R.id.fullscreen_status_container);
        if (frameLayout2 != null) {
            int i2 = 8;
            if (i == 8) {
                i2 = 0;
            }
            frameLayout2.setVisibility(i2);
        }
    }

    private void updateCurrentStatusView(int i) {
        LayoutInflater from = LayoutInflater.from(this.mActivity);
        Window window = this.mActivity.getWindow();
        j.a((Object) window, "mActivity.window");
        View decorView = window.getDecorView();
        if (decorView != null) {
            View inflate = from.inflate(i, (ViewGroup) decorView, false);
            if (inflate != null) {
                this.mCurrentStatusView = (ViewGroup) inflate;
                addView();
                return;
            }
            throw new m("null cannot be cast to non-null type android.view.ViewGroup");
        }
        throw new m("null cannot be cast to non-null type android.view.ViewGroup");
    }

    private void addView() {
        if (!j.a((Object) this.mCurrentStatusView, (Object) this.mPreviousStatusView)) {
            this.mPreviousStatusView = this.mCurrentStatusView;
            FrameLayout frameLayout = (FrameLayout) this.mActivity.findViewById(R.id.fullscreen_status_container);
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            FrameLayout frameLayout2 = (FrameLayout) this.mActivity.findViewById(R.id.fullscreen_status_container);
            if (frameLayout2 != null) {
                frameLayout2.addView(this.mCurrentStatusView);
                return;
            }
            FullscreenViewHolder fullscreenViewHolder = this;
            log.warn("Couldn't find android.R.id.content in {}. Are you calling Activity.setContentView and AppCompatDelegate.setContentView?", fullscreenViewHolder.mActivity.getClass().getSimpleName());
            Window window = fullscreenViewHolder.mActivity.getWindow();
            j.a((Object) window, "mActivity.window");
            View decorView = window.getDecorView();
            if (decorView != null) {
                ((ViewGroup) decorView).addView(fullscreenViewHolder.mCurrentStatusView);
                return;
            }
            throw new m("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }
}
