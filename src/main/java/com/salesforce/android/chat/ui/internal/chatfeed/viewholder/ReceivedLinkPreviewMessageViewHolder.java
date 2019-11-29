package com.salesforce.android.chat.ui.internal.chatfeed.viewholder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.salesforce.android.chat.ui.ChatKnowledgeArticlePreviewClickListener;
import com.salesforce.android.chat.ui.R;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedLinkPreviewMessage;
import com.salesforce.android.service.common.ui.internal.android.AsyncViewHolder;
import com.salesforce.android.service.common.ui.internal.messaging.GroupableView;
import com.salesforce.android.service.common.ui.views.SalesforceLoadingDots;
import com.salesforce.android.service.common.ui.views.SalesforceRoundedImageView;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ReceivedLinkPreviewMessageViewHolder extends AsyncViewHolder implements DataBinder, GroupableView {
    /* access modifiers changed from: private */
    public String mArticleIdOrTitle;
    private View mAvatarContainer;
    /* access modifiers changed from: private */
    public ChatKnowledgeArticlePreviewClickListener mClickListener;
    private SalesforceRoundedImageView mFavicon;
    private View mFooter;
    private Space mFooterSpace;
    private SalesforceLoadingDots mLoading;
    /* access modifiers changed from: private */
    public ReceivedLinkPreviewMessage.PreviewMessageType mMessageType;
    private TextView mOGDescription;
    private SalesforceRoundedImageView mOGImage;
    private TextView mOGTitle;
    /* access modifiers changed from: private */
    public String mOriginalUrl;
    private ImageView mRightArrow;
    private final int mShortAnimationDuration;
    private TextView mURL;

    private ReceivedLinkPreviewMessageViewHolder(final View view) {
        super(view);
        this.mOGTitle = (TextView) view.findViewById(R.id.salesforce_link_preview_title);
        this.mOGDescription = (TextView) view.findViewById(R.id.salesforce_link_preview_description);
        this.mURL = (TextView) view.findViewById(R.id.salesforce_link_preview_url);
        this.mOGImage = (SalesforceRoundedImageView) view.findViewById(R.id.salesforce_link_preview_image);
        this.mRightArrow = (ImageView) view.findViewById(R.id.salesforce_link_preview_right_arrow);
        this.mFooter = view.findViewById(R.id.salesforce_rich_link_preview_footer);
        this.mFooterSpace = (Space) view.findViewById(R.id.salesforce_rich_link_preview_footer_space);
        this.mAvatarContainer = view.findViewById(R.id.salesforce_rich_link_agent_avatar_container);
        this.mLoading = (SalesforceLoadingDots) view.findViewById(R.id.salesforce_link_preview_loadingdots);
        this.mFavicon = (SalesforceRoundedImageView) view.findViewById(R.id.salesforce_link_preview_favicon);
        this.mShortAnimationDuration = view.getResources().getInteger(17694722);
        this.mArticleIdOrTitle = null;
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    if (!(ReceivedLinkPreviewMessageViewHolder.this.mMessageType.equals(ReceivedLinkPreviewMessage.PreviewMessageType.KB) ? ReceivedLinkPreviewMessageViewHolder.this.mClickListener.onClick(view.getContext(), ReceivedLinkPreviewMessageViewHolder.this.mArticleIdOrTitle) : false)) {
                        view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(ReceivedLinkPreviewMessageViewHolder.this.mOriginalUrl)));
                    }
                } catch (ActivityNotFoundException e2) {
                    Context context = view.getContext();
                    Toast.makeText(context, "Unable to process click: " + e2.getMessage(), 0).show();
                }
            }
        });
        this.mFooter.setVisibility(8);
        this.mFooterSpace.setVisibility(0);
    }

    private void setAnimationFadeIn(View view) {
        view.setAlpha(BitmapDescriptorFactory.HUE_RED);
        view.setVisibility(0);
        view.animate().alpha(1.0f).setDuration((long) this.mShortAnimationDuration).setListener((Animator.AnimatorListener) null);
    }

    private void setAnimationFadeOut(final View view) {
        view.animate().alpha(BitmapDescriptorFactory.HUE_RED).setDuration((long) this.mShortAnimationDuration).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(8);
            }
        });
    }

    public void setData(Object obj) {
        if (obj instanceof ReceivedLinkPreviewMessage) {
            ReceivedLinkPreviewMessage receivedLinkPreviewMessage = (ReceivedLinkPreviewMessage) obj;
            this.mOriginalUrl = receivedLinkPreviewMessage.getOriginalUrl();
            this.mMessageType = receivedLinkPreviewMessage.getType();
            this.mArticleIdOrTitle = receivedLinkPreviewMessage.getArticleIdOrTitle();
            bindAsyncComplete(receivedLinkPreviewMessage);
            bindOGTitle(receivedLinkPreviewMessage);
            bindOGDescription(receivedLinkPreviewMessage);
            bindOGImage(receivedLinkPreviewMessage);
            bindOGUrl(receivedLinkPreviewMessage);
            bindFaviconImage(receivedLinkPreviewMessage);
        }
        this.itemView.invalidate();
        this.itemView.requestLayout();
    }

    private void disableLoadingView() {
        setAnimationFadeOut(this.mLoading);
    }

    private void enableLoadingView() {
        setAnimationFadeIn(this.mLoading);
    }

    private void bindOGTitle(ReceivedLinkPreviewMessage receivedLinkPreviewMessage) {
        if (receivedLinkPreviewMessage.getOGTitle() == null) {
            this.mOGTitle.setVisibility(8);
            return;
        }
        this.mOGTitle.setText(Html.fromHtml(receivedLinkPreviewMessage.getOGTitle()));
        setAnimationFadeIn(this.mOGTitle);
    }

    private void bindOGDescription(ReceivedLinkPreviewMessage receivedLinkPreviewMessage) {
        if (receivedLinkPreviewMessage.getOGDescription() == null) {
            this.mOGDescription.setVisibility(8);
            return;
        }
        this.mOGDescription.setText(Html.fromHtml(receivedLinkPreviewMessage.getOGDescription()));
        setAnimationFadeIn(this.mOGDescription);
    }

    private void bindOGImage(ReceivedLinkPreviewMessage receivedLinkPreviewMessage) {
        if (receivedLinkPreviewMessage.getType() == ReceivedLinkPreviewMessage.PreviewMessageType.KB) {
            setAnimationFadeIn(this.mOGImage);
            this.mOGImage.setBackgroundColor(this.itemView.getContext().getResources().getColor(R.color.salesforce_brand_primary));
            this.mOGImage.setImageDrawable(this.itemView.getContext().getResources().getDrawable(R.drawable.kb_icon_hero));
            this.mOGImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else if (receivedLinkPreviewMessage.getOGImage() == null) {
            this.mOGImage.setVisibility(8);
        } else {
            setAnimationFadeIn(this.mOGImage);
            this.mOGImage.setImageBitmap(receivedLinkPreviewMessage.getOGImage());
        }
    }

    private void bindFaviconImage(ReceivedLinkPreviewMessage receivedLinkPreviewMessage) {
        if (receivedLinkPreviewMessage.getType() == ReceivedLinkPreviewMessage.PreviewMessageType.KB) {
            this.mFavicon.setImageBitmap(BitmapFactory.decodeResource(this.itemView.getContext().getResources(), R.drawable.kb_icon_favicon));
            this.mFavicon.setVisibility(0);
        } else if (receivedLinkPreviewMessage.getFaviconImage() != null) {
            this.mFavicon.setImageBitmap(receivedLinkPreviewMessage.getFaviconImage());
            this.mFavicon.setVisibility(0);
        } else {
            this.mFavicon.setVisibility(8);
        }
    }

    private void bindOGUrl(ReceivedLinkPreviewMessage receivedLinkPreviewMessage) {
        if (receivedLinkPreviewMessage.getType() == ReceivedLinkPreviewMessage.PreviewMessageType.KB) {
            this.mURL.setText(this.itemView.getContext().getResources().getString(R.string.hyperlink_preview_knowledge_article_url_title));
            setAnimationFadeIn(this.mURL);
        } else if (receivedLinkPreviewMessage.getHost() != null) {
            this.mURL.setText(receivedLinkPreviewMessage.getHost());
            setAnimationFadeIn(this.mURL);
        } else {
            this.mURL.setVisibility(8);
        }
    }

    private void bindAsyncComplete(ReceivedLinkPreviewMessage receivedLinkPreviewMessage) {
        setAsyncComplete(receivedLinkPreviewMessage.isAsyncComplete());
    }

    /* access modifiers changed from: protected */
    public void handleAsyncComplete() {
        if (isAsyncComplete()) {
            disableLoadingView();
        } else {
            enableLoadingView();
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

    public void setClickListener(ChatKnowledgeArticlePreviewClickListener chatKnowledgeArticlePreviewClickListener) {
        this.mClickListener = chatKnowledgeArticlePreviewClickListener;
    }

    public static class Builder implements ViewHolderBuilder<ReceivedLinkPreviewMessageViewHolder> {
        private ChatKnowledgeArticlePreviewClickListener mClickListener;
        private View mItemView;

        public int getKey() {
            return 13;
        }

        public int getLayoutResource() {
            return R.layout.salesforce_rich_link_preview;
        }

        public Builder itemView(View view) {
            this.mItemView = view;
            return this;
        }

        public Builder clickListener(ChatKnowledgeArticlePreviewClickListener chatKnowledgeArticlePreviewClickListener) {
            this.mClickListener = chatKnowledgeArticlePreviewClickListener;
            return this;
        }

        public ReceivedLinkPreviewMessageViewHolder build() {
            Arguments.checkNotNull(this.mItemView);
            ReceivedLinkPreviewMessageViewHolder receivedLinkPreviewMessageViewHolder = new ReceivedLinkPreviewMessageViewHolder(this.mItemView);
            receivedLinkPreviewMessageViewHolder.setClickListener(this.mClickListener);
            this.mItemView = null;
            return receivedLinkPreviewMessageViewHolder;
        }
    }
}
