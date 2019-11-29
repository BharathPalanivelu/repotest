package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.w;
import com.salesforce.android.chat.ui.internal.state.AvatarCache;

public interface AvatarViewHolderBuilder<VH extends RecyclerView.w> extends ViewHolderBuilder<VH> {
    AvatarViewHolderBuilder avatarCache(AvatarCache avatarCache);
}
