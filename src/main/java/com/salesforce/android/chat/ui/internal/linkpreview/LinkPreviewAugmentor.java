package com.salesforce.android.chat.ui.internal.linkpreview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import com.salesforce.android.chat.ui.ChatKnowledgeArticlePreviewDataHelper;
import com.salesforce.android.chat.ui.ChatKnowledgeArticlePreviewDataProvider;
import com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedLinkPreviewMessage;
import com.salesforce.android.chat.ui.internal.linkpreview.OGMetadataParseJob;
import com.salesforce.android.service.common.http.HttpClient;
import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpRequest;
import com.salesforce.android.service.common.http.HttpResponse;
import com.salesforce.android.service.common.http.HttpSendJob;
import com.salesforce.android.service.common.ui.internal.messaging.MessageFeedModel;
import com.salesforce.android.service.common.ui.internal.messaging.MultiActorMessage;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import com.salesforce.android.service.common.utilities.hashing.SalesforceIdConverter;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.Job;
import com.salesforce.android.service.common.utilities.threading.JobQueue;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

class LinkPreviewAugmentor implements MessageAugmentor {
    private static final String PROTOCOL_REL_DEFAULT = "https:";
    /* access modifiers changed from: private */
    public static final ServiceLogger log = ServiceLogging.getLogger(LinkPreviewAugmentor.class);
    private HttpClient mHttpClient;
    private HttpFactoryWrapper mHttpFactoryWrapper;
    private JobQueue mJobQueue;
    private ChatKnowledgeArticlePreviewDataProvider mKnowledgeArticlePreviewDataProvider;
    private String mKnowledgeCommunityUrl;
    private LinkifyWrapper mLinkifyWrapper;
    private LinkPreviewParseJobFactory mPreviewParseFactory;
    private SpannableStringFactory mSpannableStringFactory;

    LinkPreviewAugmentor(Builder builder) {
        this.mJobQueue = builder.mJobQueue;
        this.mHttpClient = builder.mHttpClient;
        this.mHttpFactoryWrapper = builder.mHttpFactoryWrapper;
        this.mPreviewParseFactory = builder.mPreviewParseJobFactory;
        this.mLinkifyWrapper = builder.mLinkifyWrapper;
        this.mSpannableStringFactory = builder.mSpannableStringFactory;
        this.mKnowledgeCommunityUrl = builder.mKnowledgeCommunityUrl;
        this.mKnowledgeArticlePreviewDataProvider = builder.mKnowledgeArticlePreviewDataProvider;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedMessage} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedMessage} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedLinkPreviewMessage} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedMessage} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMessageAdded(com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedMessage r9, com.salesforce.android.service.common.ui.internal.messaging.MessageFeedModel r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.getMessageText()
            java.lang.String[] r0 = r8.extractUrls(r0)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            int r1 = r0.length
            r2 = 0
            r3 = r9
        L_0x000e:
            if (r2 >= r1) goto L_0x0030
            r4 = r0[r2]
            com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedLinkPreviewMessage r5 = new com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedLinkPreviewMessage
            java.lang.String r6 = r9.getId()
            java.util.Date r7 = r9.getTimestamp()
            r5.<init>(r6, r7, r4)
            java.lang.String r4 = com.salesforce.android.chat.ui.internal.linkpreview.URLHelper.parseHost(r4)
            r5.setHost(r4)
            r8.insertMessage(r3, r5, r10)
            r8.processHyperlink(r5, r10)
            int r2 = r2 + 1
            r3 = r5
            goto L_0x000e
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.ui.internal.linkpreview.LinkPreviewAugmentor.onMessageAdded(com.salesforce.android.chat.ui.internal.chatfeed.model.ReceivedMessage, com.salesforce.android.service.common.ui.internal.messaging.MessageFeedModel):void");
    }

    private String[] extractUrls(String str) {
        SpannableString createSpannableString = this.mSpannableStringFactory.createSpannableString(str);
        if (this.mLinkifyWrapper.addLinks(createSpannableString, 1)) {
            URLSpan[] uRLSpanArr = (URLSpan[]) createSpannableString.getSpans(0, createSpannableString.length(), URLSpan.class);
            if (uRLSpanArr.length > 0) {
                String[] strArr = new String[uRLSpanArr.length];
                for (int i = 0; i < uRLSpanArr.length; i++) {
                    strArr[i] = uRLSpanArr[i].getURL();
                }
                return strArr;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void insertMessage(MultiActorMessage multiActorMessage, ReceivedLinkPreviewMessage receivedLinkPreviewMessage, MessageFeedModel messageFeedModel) {
        int indexOfItem = messageFeedModel.indexOfItem(multiActorMessage);
        if (indexOfItem < 0) {
            log.error("MessageFeedModel.indexOfItem unable to find MultiActorMessage received from agent. Message Timestamp: {}", multiActorMessage.getTimestamp());
            return;
        }
        messageFeedModel.add(receivedLinkPreviewMessage, indexOfItem + 1);
    }

    /* access modifiers changed from: package-private */
    public Async<HttpResponse> addHtmlHttpRequestJob(String str) {
        return this.mJobQueue.add(prepareHttpSendJob(str));
    }

    /* access modifiers changed from: package-private */
    public Async<String> addExtractHtmlJob(final HttpResponse httpResponse) {
        return this.mJobQueue.add(new Job<String>() {
            public void execute(ResultReceiver<String> resultReceiver) {
                try {
                    resultReceiver.setResult(httpResponse.body().string());
                } catch (IOException e2) {
                    resultReceiver.setError(e2);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Async<OGMetadata> addLinkPreviewHtmlParseJob(String str) {
        return this.mJobQueue.add(this.mPreviewParseFactory.createLinkPreviewParseJob(str));
    }

    /* access modifiers changed from: package-private */
    public HttpSendJob prepareHttpSendJob(String str) {
        return this.mHttpFactoryWrapper.createHttpSendJob(str, this.mHttpClient);
    }

    /* access modifiers changed from: package-private */
    public Async<Bitmap> addImageParseJob(final HttpResponse httpResponse) {
        return this.mJobQueue.add(new Job<Bitmap>() {
            public void execute(ResultReceiver<Bitmap> resultReceiver) {
                Bitmap access$800 = LinkPreviewAugmentor.this.decodeBitmapFromHttpResponse(httpResponse);
                if (access$800 == null) {
                    resultReceiver.setError(new Exception(String.format("Error parsing bitmap from http response. URL: %s", new Object[]{httpResponse.request().url().toString()})));
                    return;
                }
                resultReceiver.setResult(access$800);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Async<String> addFaviconParseJob(String str) {
        return this.mJobQueue.add(this.mPreviewParseFactory.createFaviconParseJob(str));
    }

    /* access modifiers changed from: private */
    public Bitmap decodeBitmapFromHttpResponse(HttpResponse httpResponse) {
        InputStream byteStream = httpResponse.body().byteStream();
        Bitmap decodeStream = BitmapFactory.decodeStream(byteStream);
        try {
            byteStream.close();
            httpResponse.close();
            return decodeStream;
        } catch (IOException e2) {
            log.error("Error closing http response after fetching og:image preview. {}", e2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Async.ResultHandler<String> faviconParseResultHandler(final ReceivedLinkPreviewMessage receivedLinkPreviewMessage, final MessageFeedModel messageFeedModel) {
        return new Async.ResultHandler<String>() {
            public void handleResult(Async<?> async, String str) {
                if (str != null && receivedLinkPreviewMessage.getOriginalUrl() != null) {
                    String createAbsoluteUrl = URLHelper.createAbsoluteUrl(receivedLinkPreviewMessage.getOriginalUrl(), str, LinkPreviewAugmentor.PROTOCOL_REL_DEFAULT);
                    if (createAbsoluteUrl != null) {
                        Async<HttpResponse> addHtmlHttpRequestJob = LinkPreviewAugmentor.this.addHtmlHttpRequestJob(createAbsoluteUrl);
                        LinkPreviewAugmentor linkPreviewAugmentor = LinkPreviewAugmentor.this;
                        ReceivedLinkPreviewMessage receivedLinkPreviewMessage = receivedLinkPreviewMessage;
                        MessageFeedModel messageFeedModel = messageFeedModel;
                        addHtmlHttpRequestJob.onResult(linkPreviewAugmentor.imageHttpResponseHandler(receivedLinkPreviewMessage, messageFeedModel, linkPreviewAugmentor.faviconBitmapParseJobResultHandler(receivedLinkPreviewMessage, messageFeedModel))).onError(LinkPreviewAugmentor.this.errorCallback(receivedLinkPreviewMessage, messageFeedModel));
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Async.ResultHandler<HttpResponse> imageHttpResponseHandler(final ReceivedLinkPreviewMessage receivedLinkPreviewMessage, final MessageFeedModel messageFeedModel, final Async.ResultHandler<Bitmap> resultHandler) {
        return new Async.ResultHandler<HttpResponse>() {
            public void handleResult(Async<?> async, HttpResponse httpResponse) {
                LinkPreviewAugmentor.this.addImageParseJob(httpResponse).onResult(resultHandler).onError(LinkPreviewAugmentor.this.errorCallback(receivedLinkPreviewMessage, messageFeedModel));
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Async.ResultHandler<Bitmap> faviconBitmapParseJobResultHandler(final ReceivedLinkPreviewMessage receivedLinkPreviewMessage, final MessageFeedModel messageFeedModel) {
        return new Async.ResultHandler<Bitmap>() {
            public void handleResult(Async<?> async, Bitmap bitmap) {
                if (bitmap != null) {
                    receivedLinkPreviewMessage.setFaviconImage(bitmap);
                    LinkPreviewAugmentor.this.setComplete(receivedLinkPreviewMessage, messageFeedModel);
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Async.ResultHandler<Bitmap> previewImageParseJobResultHandler(final ReceivedLinkPreviewMessage receivedLinkPreviewMessage, final MessageFeedModel messageFeedModel) {
        return new Async.ResultHandler<Bitmap>() {
            public void handleResult(Async<?> async, Bitmap bitmap) {
                if (bitmap != null) {
                    receivedLinkPreviewMessage.setOGImage(bitmap);
                }
                LinkPreviewAugmentor.this.setComplete(receivedLinkPreviewMessage, messageFeedModel);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Async.ResultHandler<String> htmlRequestJobResultHandler(final ReceivedLinkPreviewMessage receivedLinkPreviewMessage, final MessageFeedModel messageFeedModel) {
        return new Async.ResultHandler<String>() {
            public void handleResult(Async<?> async, String str) {
                if (str == null || str.isEmpty()) {
                    LinkPreviewAugmentor.this.setComplete(receivedLinkPreviewMessage, messageFeedModel);
                    return;
                }
                LinkPreviewAugmentor.this.addLinkPreviewHtmlParseJob(str).onError(LinkPreviewAugmentor.this.errorCallback(receivedLinkPreviewMessage, messageFeedModel)).onResult(LinkPreviewAugmentor.this.parseJobResultHandler(receivedLinkPreviewMessage, messageFeedModel));
                LinkPreviewAugmentor.this.addFaviconParseJob(str).onResult(LinkPreviewAugmentor.this.faviconParseResultHandler(receivedLinkPreviewMessage, messageFeedModel)).onError(LinkPreviewAugmentor.this.errorCallback(receivedLinkPreviewMessage, messageFeedModel));
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Async.ResultHandler<HttpResponse> httpSendJobResultHandler(final ReceivedLinkPreviewMessage receivedLinkPreviewMessage, final MessageFeedModel messageFeedModel) {
        return new Async.ResultHandler<HttpResponse>() {
            public void handleResult(Async<?> async, HttpResponse httpResponse) {
                LinkPreviewAugmentor.this.addExtractHtmlJob(httpResponse).onError(LinkPreviewAugmentor.this.errorCallback(receivedLinkPreviewMessage, messageFeedModel)).onResult(LinkPreviewAugmentor.this.htmlRequestJobResultHandler(receivedLinkPreviewMessage, messageFeedModel));
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Async.ResultHandler<OGMetadata> parseJobResultHandler(final ReceivedLinkPreviewMessage receivedLinkPreviewMessage, final MessageFeedModel messageFeedModel) {
        return new Async.ResultHandler<OGMetadata>() {
            public void handleResult(Async<?> async, OGMetadata oGMetadata) {
                receivedLinkPreviewMessage.setOGTitle(oGMetadata.getOGTitle());
                receivedLinkPreviewMessage.setOGDescription(oGMetadata.getOGDescription());
                if (receivedLinkPreviewMessage.getOriginalUrl() == null || oGMetadata.getOGImageUrl() == null) {
                    LinkPreviewAugmentor.this.setComplete(receivedLinkPreviewMessage, messageFeedModel);
                    return;
                }
                String createAbsoluteUrl = URLHelper.createAbsoluteUrl(receivedLinkPreviewMessage.getOriginalUrl(), oGMetadata.getOGImageUrl(), LinkPreviewAugmentor.PROTOCOL_REL_DEFAULT);
                if (createAbsoluteUrl != null) {
                    receivedLinkPreviewMessage.setOGImageUrl(createAbsoluteUrl);
                    Async<HttpResponse> addHtmlHttpRequestJob = LinkPreviewAugmentor.this.addHtmlHttpRequestJob(createAbsoluteUrl);
                    LinkPreviewAugmentor linkPreviewAugmentor = LinkPreviewAugmentor.this;
                    ReceivedLinkPreviewMessage receivedLinkPreviewMessage = receivedLinkPreviewMessage;
                    MessageFeedModel messageFeedModel = messageFeedModel;
                    addHtmlHttpRequestJob.onResult(linkPreviewAugmentor.imageHttpResponseHandler(receivedLinkPreviewMessage, messageFeedModel, linkPreviewAugmentor.previewImageParseJobResultHandler(receivedLinkPreviewMessage, messageFeedModel))).onError(LinkPreviewAugmentor.this.errorCallback(receivedLinkPreviewMessage, messageFeedModel));
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Async.ErrorHandler errorCallback(final ReceivedLinkPreviewMessage receivedLinkPreviewMessage, final MessageFeedModel messageFeedModel) {
        return new Async.ErrorHandler() {
            public void handleError(Async<?> async, Throwable th) {
                LinkPreviewAugmentor.log.error("Error processing link preview metadata. Exception: " + th.getClass() + " Message: " + th.getMessage() + "Backtrace: " + th.getMessage());
                LinkPreviewAugmentor.this.setComplete(receivedLinkPreviewMessage, messageFeedModel);
            }
        };
    }

    /* access modifiers changed from: private */
    public void setComplete(ReceivedLinkPreviewMessage receivedLinkPreviewMessage, MessageFeedModel messageFeedModel) {
        receivedLinkPreviewMessage.setAsyncComplete();
        messageFeedModel.notifyItemChanged(receivedLinkPreviewMessage);
        if (messageFeedModel.isAtBottomPosition()) {
            messageFeedModel.scrollToBottom();
        }
    }

    private void processHyperlink(ReceivedLinkPreviewMessage receivedLinkPreviewMessage, MessageFeedModel messageFeedModel) {
        if ((this.mKnowledgeCommunityUrl != null ? invokeDataProvider(receivedLinkPreviewMessage, messageFeedModel) : false) || receivedLinkPreviewMessage.getOriginalUrl() == null) {
            setComplete(receivedLinkPreviewMessage, messageFeedModel);
            log.error("Error processing link preview: URL submitted by agent is null within the preview message.");
            return;
        }
        processLinkPreviewData(receivedLinkPreviewMessage, messageFeedModel);
    }

    private boolean invokeDataProvider(ReceivedLinkPreviewMessage receivedLinkPreviewMessage, MessageFeedModel messageFeedModel) {
        try {
            URI uri = new URI(this.mKnowledgeCommunityUrl);
            if (!(uri.getHost() == null || receivedLinkPreviewMessage.getHost() == null || !uri.getHost().equals(receivedLinkPreviewMessage.getHost()))) {
                try {
                    URI uri2 = new URI(receivedLinkPreviewMessage.getOriginalUrl());
                    KnowledgePreviewListener knowledgePreviewListener = new KnowledgePreviewListener(receivedLinkPreviewMessage, messageFeedModel);
                    boolean z = uri2.getPath().lastIndexOf("article") != -1;
                    String substring = uri2.getPath().substring(uri2.getPath().lastIndexOf(47) + 1);
                    if (!z && substring.length() == 15) {
                        substring = SalesforceIdConverter.convert15to18(substring);
                    }
                    receivedLinkPreviewMessage.setArticleIdOrTitle(substring);
                    return this.mKnowledgeArticlePreviewDataProvider.onPreviewDataRequested(substring, knowledgePreviewListener);
                } catch (URISyntaxException unused) {
                    log.error("Error parsing provided knowledge article URL: link preview message may be unavailable.");
                }
            }
            return false;
        } catch (URISyntaxException unused2) {
            log.error("Error parsing knowledge community URL: link preview message may be unavailable.");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void processLinkPreviewData(ReceivedLinkPreviewMessage receivedLinkPreviewMessage, MessageFeedModel messageFeedModel) {
        addHtmlHttpRequestJob(receivedLinkPreviewMessage.getOriginalUrl()).onError(errorCallback(receivedLinkPreviewMessage, messageFeedModel)).onResult(httpSendJobResultHandler(receivedLinkPreviewMessage, messageFeedModel));
    }

    class KnowledgePreviewListener implements ChatKnowledgeArticlePreviewDataHelper {
        private MessageFeedModel mMessageFeedModel;
        private ReceivedLinkPreviewMessage mPreviewMessage;

        KnowledgePreviewListener(ReceivedLinkPreviewMessage receivedLinkPreviewMessage, MessageFeedModel messageFeedModel) {
            this.mPreviewMessage = receivedLinkPreviewMessage;
            this.mMessageFeedModel = messageFeedModel;
        }

        public void onPreviewDataReceived(String str, String str2) {
            this.mPreviewMessage.setOGTitle(str);
            this.mPreviewMessage.setOGDescription(str2);
            if (this.mPreviewMessage.getOGTitle() == null && this.mPreviewMessage.getOGDescription() == null) {
                LinkPreviewAugmentor.this.processLinkPreviewData(this.mPreviewMessage, this.mMessageFeedModel);
                return;
            }
            this.mPreviewMessage.setType(ReceivedLinkPreviewMessage.PreviewMessageType.KB);
            LinkPreviewAugmentor.this.setComplete(this.mPreviewMessage, this.mMessageFeedModel);
        }
    }

    static class HttpFactoryWrapper {
        HttpFactoryWrapper() {
        }

        /* access modifiers changed from: package-private */
        public HttpRequest createHttpRequest(String str) {
            return HttpFactory.request().url(str).addHeader("Accept-Language", String.format("%s,*;q=0.5", new Object[]{Locale.getDefault().getLanguage()})).build();
        }

        /* access modifiers changed from: package-private */
        public HttpSendJob createHttpSendJob(String str, HttpClient httpClient) {
            return HttpSendJob.create(httpClient, createHttpRequest(str));
        }
    }

    static class LinkPreviewParseJobFactory {
        LinkPreviewParseJobFactory() {
        }

        /* access modifiers changed from: package-private */
        public OGMetadataParseJob createLinkPreviewParseJob(String str) {
            return new OGMetadataParseJob.Builder().setHtml(str).build();
        }

        /* access modifiers changed from: package-private */
        public FaviconParseJob createFaviconParseJob(String str) {
            return new FaviconParseJob(str);
        }
    }

    static class LinkifyWrapper {
        LinkifyWrapper() {
        }

        /* access modifiers changed from: package-private */
        public boolean addLinks(SpannableString spannableString, int i) {
            return Linkify.addLinks(spannableString, i);
        }
    }

    static class SpannableStringFactory {
        SpannableStringFactory() {
        }

        /* access modifiers changed from: package-private */
        public SpannableString createSpannableString(String str) {
            return new SpannableString(str.subSequence(0, str.length()));
        }
    }

    static class Builder {
        /* access modifiers changed from: private */
        public HttpClient mHttpClient;
        /* access modifiers changed from: private */
        public HttpFactoryWrapper mHttpFactoryWrapper;
        /* access modifiers changed from: private */
        public JobQueue mJobQueue;
        /* access modifiers changed from: private */
        public ChatKnowledgeArticlePreviewDataProvider mKnowledgeArticlePreviewDataProvider;
        /* access modifiers changed from: private */
        public String mKnowledgeCommunityUrl;
        /* access modifiers changed from: private */
        public LinkifyWrapper mLinkifyWrapper;
        /* access modifiers changed from: private */
        public LinkPreviewParseJobFactory mPreviewParseJobFactory;
        /* access modifiers changed from: private */
        public SpannableStringFactory mSpannableStringFactory;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder jobQueue(JobQueue jobQueue) {
            this.mJobQueue = jobQueue;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder httpClient(HttpClient httpClient) {
            this.mHttpClient = httpClient;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder httpFactoryWrapper(HttpFactoryWrapper httpFactoryWrapper) {
            this.mHttpFactoryWrapper = httpFactoryWrapper;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder linkPreviewParseJobFactory(LinkPreviewParseJobFactory linkPreviewParseJobFactory) {
            this.mPreviewParseJobFactory = linkPreviewParseJobFactory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder linkifyWrapper(LinkifyWrapper linkifyWrapper) {
            this.mLinkifyWrapper = linkifyWrapper;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder spannableStringFactory(SpannableStringFactory spannableStringFactory) {
            this.mSpannableStringFactory = spannableStringFactory;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder knowledgeCommunityUrl(String str) {
            this.mKnowledgeCommunityUrl = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder knowledgeArticlePreviewDataProvider(ChatKnowledgeArticlePreviewDataProvider chatKnowledgeArticlePreviewDataProvider) {
            this.mKnowledgeArticlePreviewDataProvider = chatKnowledgeArticlePreviewDataProvider;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LinkPreviewAugmentor build() {
            if (this.mHttpFactoryWrapper == null) {
                this.mHttpFactoryWrapper = new HttpFactoryWrapper();
            }
            if (this.mPreviewParseJobFactory == null) {
                this.mPreviewParseJobFactory = new LinkPreviewParseJobFactory();
            }
            if (this.mLinkifyWrapper == null) {
                this.mLinkifyWrapper = new LinkifyWrapper();
            }
            if (this.mSpannableStringFactory == null) {
                this.mSpannableStringFactory = new SpannableStringFactory();
            }
            if (this.mKnowledgeArticlePreviewDataProvider == null) {
                this.mKnowledgeArticlePreviewDataProvider = KnowledgeArticleDataProviderWrapper.create((ChatKnowledgeArticlePreviewDataProvider) null);
            }
            return new LinkPreviewAugmentor(this);
        }
    }
}
