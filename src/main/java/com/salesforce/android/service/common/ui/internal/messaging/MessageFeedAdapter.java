package com.salesforce.android.service.common.ui.internal.messaging;

import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.salesforce.android.service.common.ui.internal.android.LayoutInflaterFactory;
import com.salesforce.android.service.common.ui.internal.android.RecyclerViewAdapter;
import com.salesforce.android.service.common.ui.internal.android.RecyclerViewAdapterDelegate;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.List;

public class MessageFeedAdapter implements RecyclerViewAdapter<RecyclerView.w>, MessageFeedModel {
    private static final long DEFAULT_MESSAGE_GROUP_TIMESPAN_MS = 60000;
    private final RecyclerViewAdapterDelegate<RecyclerView.w> mAdapterDelegate;
    private List<Object> mItems = new ArrayList();
    private final LayoutInflaterFactory mLayoutInflaterFactory;
    private LinearLayoutManager mLinearLayoutManager;
    private final long mMessageGroupTimespanMs;
    protected RecyclerView mParentRecyclerView;
    private final ViewHolderFactory mViewHolderFactory;

    MessageFeedAdapter(Builder builder) {
        this.mViewHolderFactory = builder.mViewHolderFactory;
        this.mLayoutInflaterFactory = builder.mLayoutInflaterFactory;
        this.mAdapterDelegate = builder.mAdapterDelegate;
        this.mAdapterDelegate.wrap(this);
        this.mMessageGroupTimespanMs = builder.mMessageGroupTimespanMs.longValue();
    }

    public void bind(RecyclerView recyclerView) {
        recyclerView.setAdapter(this.mAdapterDelegate);
    }

    public void add(Object obj) {
        if (isGroupable(getHeadItem(), obj)) {
            groupView(getHeadViewHolder());
        }
        this.mItems.add(obj);
        this.mAdapterDelegate.notifyItemInserted(this.mItems.indexOf(obj));
    }

    public void addToTop(Object obj) {
        this.mItems.remove(obj);
        this.mItems.add(0, obj);
    }

    public void setItems(List<Object> list) {
        this.mItems = list;
        this.mAdapterDelegate.notifyDataSetChanged();
    }

    public void remove(Object obj) {
        if (this.mItems.contains(obj)) {
            int indexOf = this.mItems.indexOf(obj);
            this.mItems.remove(indexOf);
            ungroupView(getHeadViewHolder());
            this.mAdapterDelegate.notifyItemRemoved(indexOf);
        }
    }

    public void moveItemToHead(Object obj) {
        remove(obj);
        add(obj);
    }

    public void clear() {
        this.mItems.clear();
        this.mAdapterDelegate.notifyDataSetChanged();
    }

    public void notifyItemChanged(Object obj) {
        if (this.mItems.contains(obj)) {
            this.mAdapterDelegate.notifyItemChanged(this.mItems.indexOf(obj));
        }
    }

    public int indexOfItem(Object obj) {
        return this.mItems.indexOf(obj);
    }

    public void add(Object obj, int i) {
        int size = this.mItems.size();
        if ((i == size || i == size + 1) && isGroupable(getHeadItem(), obj)) {
            groupView(getHeadViewHolder());
        }
        this.mItems.add(i, obj);
        this.mAdapterDelegate.notifyItemInserted(this.mItems.indexOf(obj));
    }

    public int getItemCount() {
        return this.mItems.size();
    }

    public long getItemId(int i) {
        return this.mAdapterDelegate.getItemId(i);
    }

    public int getItemViewType(int i) {
        return this.mViewHolderFactory.getItemViewType(this.mItems.get(i));
    }

    public Object getHeadItem() {
        return getItem(this.mItems.size() - 1);
    }

    public Object getItem(int i) {
        if (this.mItems.isEmpty() || i >= this.mItems.size() || i < 0) {
            return null;
        }
        return this.mItems.get(i);
    }

    public boolean contains(Object obj) {
        return this.mItems.contains(obj);
    }

    public boolean isAtBottomPosition() {
        LinearLayoutManager linearLayoutManager = this.mLinearLayoutManager;
        if (linearLayoutManager == null || linearLayoutManager.q() + 1 < getItemCount() - 1) {
            return false;
        }
        return true;
    }

    public void scrollToBottom() {
        scrollToPosition(getItemCount() - 1);
    }

    public void scrollToPosition(final int i) {
        RecyclerView recyclerView = this.mParentRecyclerView;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() {
                public void run() {
                    MessageFeedAdapter.this.mParentRecyclerView.d(i);
                }
            });
        }
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.mViewHolderFactory.onCreateViewHolder(viewGroup, i, this.mLayoutInflaterFactory.createFrom(viewGroup.getContext()));
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i) {
        Object obj = this.mItems.get(i);
        if (isGroupable(obj, getItem(i + 1))) {
            groupView(wVar);
        } else {
            ungroupView(wVar);
        }
        this.mViewHolderFactory.onBindViewHolder(wVar, wVar.getItemViewType(), obj);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.w getHeadViewHolder() {
        if (this.mParentRecyclerView == null || this.mItems.isEmpty()) {
            return null;
        }
        return this.mParentRecyclerView.e(this.mItems.size() - 1);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.mParentRecyclerView = recyclerView;
        this.mLinearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        if (this.mParentRecyclerView == recyclerView) {
            this.mParentRecyclerView = null;
            this.mLinearLayoutManager = null;
        }
    }

    private boolean isGroupable(Object obj, Object obj2) {
        if (!(obj == null || obj2 == null)) {
            if (isInstanceOf(obj, obj2, MultiActorMessage.class)) {
                return isContiguousMultiActor((MultiActorMessage) obj, (MultiActorMessage) obj2);
            }
            if (isInstanceOf(obj, obj2, Message.class) && !isEitherInstanceOf(obj, obj2, MultiActorMessage.class)) {
                return isContiguous((Message) obj, (Message) obj2);
            }
        }
        return false;
    }

    private boolean isInstanceOf(Object obj, Object obj2, Class cls) {
        return cls.isInstance(obj) && cls.isInstance(obj2);
    }

    private boolean isEitherInstanceOf(Object obj, Object obj2, Class cls) {
        return cls.isInstance(obj) || cls.isInstance(obj2);
    }

    private boolean isContiguous(Message message, Message message2) {
        return message2.getTimestamp().getTime() - message.getTimestamp().getTime() <= this.mMessageGroupTimespanMs;
    }

    private boolean isContiguousMultiActor(MultiActorMessage multiActorMessage, MultiActorMessage multiActorMessage2) {
        return isContiguous(multiActorMessage, multiActorMessage2) && multiActorMessage.getId().equals(multiActorMessage2.getId());
    }

    private void groupView(RecyclerView.w wVar) {
        if (wVar != null && (wVar instanceof GroupableView)) {
            ((GroupableView) wVar).onGroupView();
        }
    }

    private void ungroupView(RecyclerView.w wVar) {
        if (wVar != null && (wVar instanceof GroupableView)) {
            ((GroupableView) wVar).onUngroupView();
        }
    }

    public static class Builder {
        RecyclerViewAdapterDelegate<RecyclerView.w> mAdapterDelegate;
        LayoutInflaterFactory mLayoutInflaterFactory;
        Long mMessageGroupTimespanMs;
        ViewHolderFactory mViewHolderFactory;

        public Builder viewHolderFactory(ViewHolderFactory viewHolderFactory) {
            this.mViewHolderFactory = viewHolderFactory;
            return this;
        }

        public Builder layoutInflaterFactory(LayoutInflaterFactory layoutInflaterFactory) {
            this.mLayoutInflaterFactory = layoutInflaterFactory;
            return this;
        }

        public Builder adapterDelegate(RecyclerViewAdapterDelegate<RecyclerView.w> recyclerViewAdapterDelegate) {
            this.mAdapterDelegate = recyclerViewAdapterDelegate;
            return this;
        }

        public Builder messageGroupTimespan(long j) {
            this.mMessageGroupTimespanMs = Long.valueOf(j);
            return this;
        }

        public MessageFeedAdapter build() {
            Arguments.checkNotNull(this.mViewHolderFactory, "Please provide a ViewHolderFactory instance to the MessageFeedAdapter.");
            if (this.mLayoutInflaterFactory == null) {
                this.mLayoutInflaterFactory = new LayoutInflaterFactory();
            }
            if (this.mAdapterDelegate == null) {
                this.mAdapterDelegate = new RecyclerViewAdapterDelegate<>();
            }
            if (this.mMessageGroupTimespanMs == null) {
                this.mMessageGroupTimespanMs = Long.valueOf(MessageFeedAdapter.DEFAULT_MESSAGE_GROUP_TIMESPAN_MS);
            }
            return new MessageFeedAdapter(this);
        }
    }
}
