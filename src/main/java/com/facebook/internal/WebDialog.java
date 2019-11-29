package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.appsflyer.share.Constants;
import com.facebook.AccessToken;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.common.R;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.widget.ShareDialog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebDialog extends Dialog {
    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int BACKGROUND_GRAY = -872415232;
    private static final int DEFAULT_THEME = R.style.com_facebook_activity_theme;
    static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
    private static final String DISPLAY_TOUCH = "touch";
    private static final String LOG_TAG = "FacebookSDK.WebDialog";
    private static final int MAX_PADDING_SCREEN_HEIGHT = 1280;
    private static final int MAX_PADDING_SCREEN_WIDTH = 800;
    private static final double MIN_SCALE_FACTOR = 0.5d;
    private static final int NO_PADDING_SCREEN_HEIGHT = 800;
    private static final int NO_PADDING_SCREEN_WIDTH = 480;
    private static volatile int webDialogTheme;
    /* access modifiers changed from: private */
    public FrameLayout contentFrameLayout;
    /* access modifiers changed from: private */
    public ImageView crossImageView;
    /* access modifiers changed from: private */
    public String expectedRedirectUrl;
    /* access modifiers changed from: private */
    public boolean isDetached;
    /* access modifiers changed from: private */
    public boolean isPageFinished;
    private boolean listenerCalled;
    private OnCompleteListener onCompleteListener;
    /* access modifiers changed from: private */
    public ProgressDialog spinner;
    private UploadStagingResourcesTask uploadTask;
    /* access modifiers changed from: private */
    public String url;
    /* access modifiers changed from: private */
    public WebView webView;
    private WindowManager.LayoutParams windowParams;

    public interface OnCompleteListener {
        void onComplete(Bundle bundle, FacebookException facebookException);
    }

    protected static void initDefaultTheme(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null && webDialogTheme == 0) {
                    setWebDialogTheme(applicationInfo.metaData.getInt(FacebookSdk.WEB_DIALOG_THEME));
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    public static WebDialog newInstance(Context context, String str, Bundle bundle, int i, OnCompleteListener onCompleteListener2) {
        initDefaultTheme(context);
        return new WebDialog(context, str, bundle, i, onCompleteListener2);
    }

    public static int getWebDialogTheme() {
        Validate.sdkInitialized();
        return webDialogTheme;
    }

    public static void setWebDialogTheme(int i) {
        if (i == 0) {
            i = DEFAULT_THEME;
        }
        webDialogTheme = i;
    }

    protected WebDialog(Context context, String str) {
        this(context, str, getWebDialogTheme());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private WebDialog(Context context, String str, int i) {
        super(context, i == 0 ? getWebDialogTheme() : i);
        this.expectedRedirectUrl = ServerProtocol.DIALOG_REDIRECT_URI;
        this.listenerCalled = false;
        this.isDetached = false;
        this.isPageFinished = false;
        this.url = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private WebDialog(Context context, String str, Bundle bundle, int i, OnCompleteListener onCompleteListener2) {
        super(context, i == 0 ? getWebDialogTheme() : i);
        String str2 = ServerProtocol.DIALOG_REDIRECT_URI;
        this.expectedRedirectUrl = str2;
        this.listenerCalled = false;
        this.isDetached = false;
        this.isPageFinished = false;
        bundle = bundle == null ? new Bundle() : bundle;
        this.expectedRedirectUrl = Utility.isChromeOS(context) ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : str2;
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.expectedRedirectUrl);
        bundle.putString("display", "touch");
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        bundle.putString(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.format(Locale.ROOT, "android-%s", new Object[]{FacebookSdk.getSdkVersion()}));
        this.onCompleteListener = onCompleteListener2;
        if (!str.equals(ShareDialog.WEB_SHARE_DIALOG) || !bundle.containsKey("media")) {
            String dialogAuthority = ServerProtocol.getDialogAuthority();
            this.url = Utility.buildUri(dialogAuthority, FacebookSdk.getGraphApiVersion() + Constants.URL_PATH_DELIMITER + ServerProtocol.DIALOG_PATH + str, bundle).toString();
            return;
        }
        this.uploadTask = new UploadStagingResourcesTask(str, bundle);
    }

    public void setOnCompleteListener(OnCompleteListener onCompleteListener2) {
        this.onCompleteListener = onCompleteListener2;
    }

    public OnCompleteListener getOnCompleteListener() {
        return this.onCompleteListener;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cancel();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void dismiss() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.stopLoading();
        }
        if (!this.isDetached) {
            ProgressDialog progressDialog = this.spinner;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.spinner.dismiss();
            }
        }
        super.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask == null || uploadStagingResourcesTask.getStatus() != AsyncTask.Status.PENDING) {
            resize();
            return;
        }
        this.uploadTask.execute(new Void[0]);
        this.spinner.show();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        UploadStagingResourcesTask uploadStagingResourcesTask = this.uploadTask;
        if (uploadStagingResourcesTask != null) {
            uploadStagingResourcesTask.cancel(true);
            this.spinner.dismiss();
        }
        super.onStop();
    }

    public void onDetachedFromWindow() {
        this.isDetached = true;
        super.onDetachedFromWindow();
    }

    public void onAttachedToWindow() {
        this.isDetached = false;
        if (Utility.mustFixWindowParamsForAutofill(getContext())) {
            WindowManager.LayoutParams layoutParams = this.windowParams;
            if (layoutParams != null && layoutParams.token == null) {
                this.windowParams.token = getOwnerActivity().getWindow().getAttributes().token;
                Utility.logd(LOG_TAG, "Set token on onAttachedToWindow(): " + this.windowParams.token);
            }
        }
        super.onAttachedToWindow();
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        if (layoutParams.token == null) {
            this.windowParams = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.spinner = new ProgressDialog(getContext());
        this.spinner.requestWindowFeature(1);
        this.spinner.setMessage(getContext().getString(R.string.com_facebook_loading));
        this.spinner.setCanceledOnTouchOutside(false);
        this.spinner.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                WebDialog.this.cancel();
            }
        });
        requestWindowFeature(1);
        this.contentFrameLayout = new FrameLayout(getContext());
        resize();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        createCrossImage();
        if (this.url != null) {
            setUpWebView((this.crossImageView.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        this.contentFrameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.contentFrameLayout);
    }

    /* access modifiers changed from: protected */
    public void setExpectedRedirectUrl(String str) {
        this.expectedRedirectUrl = str;
    }

    /* access modifiers changed from: protected */
    public Bundle parseResponseUri(String str) {
        Uri parse = Uri.parse(str);
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
        parseUrlQueryString.putAll(Utility.parseUrlQueryString(parse.getFragment()));
        return parseUrlQueryString;
    }

    /* access modifiers changed from: protected */
    public boolean isListenerCalled() {
        return this.listenerCalled;
    }

    /* access modifiers changed from: protected */
    public boolean isPageFinished() {
        return this.isPageFinished;
    }

    /* access modifiers changed from: protected */
    public WebView getWebView() {
        return this.webView;
    }

    public void resize() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        getWindow().setLayout(Math.min(getScaledSize(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels, displayMetrics.density, NO_PADDING_SCREEN_WIDTH, 800), displayMetrics.widthPixels), Math.min(getScaledSize(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels, displayMetrics.density, 800, MAX_PADDING_SCREEN_HEIGHT), displayMetrics.heightPixels));
    }

    private int getScaledSize(int i, float f2, int i2, int i3) {
        int i4 = (int) (((float) i) / f2);
        double d2 = MIN_SCALE_FACTOR;
        if (i4 <= i2) {
            d2 = 1.0d;
        } else if (i4 < i3) {
            double d3 = (double) (i3 - i4);
            double d4 = (double) (i3 - i2);
            Double.isNaN(d3);
            Double.isNaN(d4);
            d2 = MIN_SCALE_FACTOR + ((d3 / d4) * MIN_SCALE_FACTOR);
        }
        double d5 = (double) i;
        Double.isNaN(d5);
        return (int) (d5 * d2);
    }

    /* access modifiers changed from: protected */
    public void sendSuccessToListener(Bundle bundle) {
        OnCompleteListener onCompleteListener2 = this.onCompleteListener;
        if (onCompleteListener2 != null && !this.listenerCalled) {
            this.listenerCalled = true;
            onCompleteListener2.onComplete(bundle, (FacebookException) null);
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void sendErrorToListener(Throwable th) {
        FacebookException facebookException;
        if (this.onCompleteListener != null && !this.listenerCalled) {
            this.listenerCalled = true;
            if (th instanceof FacebookException) {
                facebookException = (FacebookException) th;
            } else {
                facebookException = new FacebookException(th);
            }
            this.onCompleteListener.onComplete((Bundle) null, facebookException);
            dismiss();
        }
    }

    public void cancel() {
        if (this.onCompleteListener != null && !this.listenerCalled) {
            sendErrorToListener(new FacebookOperationCanceledException());
        }
    }

    private void createCrossImage() {
        this.crossImageView = new ImageView(getContext());
        this.crossImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WebDialog.this.cancel();
            }
        });
        this.crossImageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.com_facebook_close));
        this.crossImageView.setVisibility(4);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void setUpWebView(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.webView = new WebView(getContext()) {
            public void onWindowFocusChanged(boolean z) {
                try {
                    super.onWindowFocusChanged(z);
                } catch (NullPointerException unused) {
                }
            }
        };
        this.webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.setWebViewClient(new DialogWebViewClient());
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.loadUrl(this.url);
        this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.webView.setVisibility(4);
        this.webView.getSettings().setSavePassword(false);
        this.webView.getSettings().setSaveFormData(false);
        this.webView.setFocusable(true);
        this.webView.setFocusableInTouchMode(true);
        this.webView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.webView);
        linearLayout.setBackgroundColor(BACKGROUND_GRAY);
        this.contentFrameLayout.addView(linearLayout);
    }

    private class DialogWebViewClient extends WebViewClient {
        private DialogWebViewClient() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0096  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean shouldOverrideUrlLoading(android.webkit.WebView r6, java.lang.String r7) {
            /*
                r5 = this;
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = "Redirect URL: "
                r6.append(r0)
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                java.lang.String r0 = "FacebookSDK.WebDialog"
                com.facebook.internal.Utility.logd((java.lang.String) r0, (java.lang.String) r6)
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                java.lang.String r6 = r6.expectedRedirectUrl
                boolean r6 = r7.startsWith(r6)
                r0 = 1
                if (r6 == 0) goto L_0x00a6
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                android.os.Bundle r6 = r6.parseResponseUri(r7)
                java.lang.String r7 = "error"
                java.lang.String r7 = r6.getString(r7)
                if (r7 != 0) goto L_0x0037
                java.lang.String r7 = "error_type"
                java.lang.String r7 = r6.getString(r7)
            L_0x0037:
                java.lang.String r1 = "error_msg"
                java.lang.String r1 = r6.getString(r1)
                if (r1 != 0) goto L_0x0045
                java.lang.String r1 = "error_message"
                java.lang.String r1 = r6.getString(r1)
            L_0x0045:
                if (r1 != 0) goto L_0x004d
                java.lang.String r1 = "error_description"
                java.lang.String r1 = r6.getString(r1)
            L_0x004d:
                java.lang.String r2 = "error_code"
                java.lang.String r2 = r6.getString(r2)
                boolean r3 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r2)
                r4 = -1
                if (r3 != 0) goto L_0x005f
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x005f }
                goto L_0x0060
            L_0x005f:
                r2 = -1
            L_0x0060:
                boolean r3 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r7)
                if (r3 == 0) goto L_0x0074
                boolean r3 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r1)
                if (r3 == 0) goto L_0x0074
                if (r2 != r4) goto L_0x0074
                com.facebook.internal.WebDialog r7 = com.facebook.internal.WebDialog.this
                r7.sendSuccessToListener(r6)
                goto L_0x00a5
            L_0x0074:
                if (r7 == 0) goto L_0x008c
                java.lang.String r6 = "access_denied"
                boolean r6 = r7.equals(r6)
                if (r6 != 0) goto L_0x0086
                java.lang.String r6 = "OAuthAccessDeniedException"
                boolean r6 = r7.equals(r6)
                if (r6 == 0) goto L_0x008c
            L_0x0086:
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                r6.cancel()
                goto L_0x00a5
            L_0x008c:
                r6 = 4201(0x1069, float:5.887E-42)
                if (r2 != r6) goto L_0x0096
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                r6.cancel()
                goto L_0x00a5
            L_0x0096:
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>(r2, r7, r1)
                com.facebook.internal.WebDialog r7 = com.facebook.internal.WebDialog.this
                com.facebook.FacebookServiceException r2 = new com.facebook.FacebookServiceException
                r2.<init>(r6, r1)
                r7.sendErrorToListener(r2)
            L_0x00a5:
                return r0
            L_0x00a6:
                java.lang.String r6 = "fbconnect://cancel"
                boolean r6 = r7.startsWith(r6)
                if (r6 == 0) goto L_0x00b4
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this
                r6.cancel()
                return r0
            L_0x00b4:
                java.lang.String r6 = "touch"
                boolean r6 = r7.contains(r6)
                r1 = 0
                if (r6 == 0) goto L_0x00be
                return r1
            L_0x00be:
                com.facebook.internal.WebDialog r6 = com.facebook.internal.WebDialog.this     // Catch:{ ActivityNotFoundException -> 0x00d3 }
                android.content.Context r6 = r6.getContext()     // Catch:{ ActivityNotFoundException -> 0x00d3 }
                android.content.Intent r2 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x00d3 }
                java.lang.String r3 = "android.intent.action.VIEW"
                android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ ActivityNotFoundException -> 0x00d3 }
                r2.<init>(r3, r7)     // Catch:{ ActivityNotFoundException -> 0x00d3 }
                r6.startActivity(r2)     // Catch:{ ActivityNotFoundException -> 0x00d3 }
                return r0
            L_0x00d3:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WebDialog.DialogWebViewClient.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            WebDialog.this.sendErrorToListener(new FacebookDialogException(str, i, str2));
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            sslErrorHandler.cancel();
            WebDialog.this.sendErrorToListener(new FacebookDialogException((String) null, -11, (String) null));
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Utility.logd(WebDialog.LOG_TAG, "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
            if (!WebDialog.this.isDetached) {
                WebDialog.this.spinner.show();
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!WebDialog.this.isDetached) {
                WebDialog.this.spinner.dismiss();
            }
            WebDialog.this.contentFrameLayout.setBackgroundColor(0);
            WebDialog.this.webView.setVisibility(0);
            WebDialog.this.crossImageView.setVisibility(0);
            boolean unused = WebDialog.this.isPageFinished = true;
        }
    }

    public static class Builder {
        private AccessToken accessToken;
        private String action;
        private String applicationId;
        private Context context;
        private OnCompleteListener listener;
        private Bundle parameters;
        private int theme;

        public Builder(Context context2, String str, Bundle bundle) {
            this.accessToken = AccessToken.getCurrentAccessToken();
            if (!AccessToken.isCurrentAccessTokenActive()) {
                String metadataApplicationId = Utility.getMetadataApplicationId(context2);
                if (metadataApplicationId != null) {
                    this.applicationId = metadataApplicationId;
                } else {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
            }
            finishInit(context2, str, bundle);
        }

        public Builder(Context context2, String str, String str2, Bundle bundle) {
            str = str == null ? Utility.getMetadataApplicationId(context2) : str;
            Validate.notNullOrEmpty(str, "applicationId");
            this.applicationId = str;
            finishInit(context2, str2, bundle);
        }

        public Builder setTheme(int i) {
            this.theme = i;
            return this;
        }

        public Builder setOnCompleteListener(OnCompleteListener onCompleteListener) {
            this.listener = onCompleteListener;
            return this;
        }

        public WebDialog build() {
            AccessToken accessToken2 = this.accessToken;
            if (accessToken2 != null) {
                this.parameters.putString("app_id", accessToken2.getApplicationId());
                this.parameters.putString("access_token", this.accessToken.getToken());
            } else {
                this.parameters.putString("app_id", this.applicationId);
            }
            return WebDialog.newInstance(this.context, this.action, this.parameters, this.theme, this.listener);
        }

        public String getApplicationId() {
            return this.applicationId;
        }

        public Context getContext() {
            return this.context;
        }

        public int getTheme() {
            return this.theme;
        }

        public Bundle getParameters() {
            return this.parameters;
        }

        public OnCompleteListener getListener() {
            return this.listener;
        }

        private void finishInit(Context context2, String str, Bundle bundle) {
            this.context = context2;
            this.action = str;
            if (bundle != null) {
                this.parameters = bundle;
            } else {
                this.parameters = new Bundle();
            }
        }
    }

    private class UploadStagingResourcesTask extends AsyncTask<Void, Void, String[]> {
        private String action;
        /* access modifiers changed from: private */
        public Exception[] exceptions;
        private Bundle parameters;

        UploadStagingResourcesTask(String str, Bundle bundle) {
            this.action = str;
            this.parameters = bundle;
        }

        /* access modifiers changed from: protected */
        public String[] doInBackground(Void... voidArr) {
            String[] stringArray = this.parameters.getStringArray("media");
            final String[] strArr = new String[stringArray.length];
            this.exceptions = new Exception[stringArray.length];
            final CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            final int i = 0;
            while (i < stringArray.length) {
                try {
                    if (isCancelled()) {
                        Iterator it = concurrentLinkedQueue.iterator();
                        while (it.hasNext()) {
                            ((AsyncTask) it.next()).cancel(true);
                        }
                        return null;
                    }
                    Uri parse = Uri.parse(stringArray[i]);
                    if (Utility.isWebUri(parse)) {
                        strArr[i] = parse.toString();
                        countDownLatch.countDown();
                    } else {
                        concurrentLinkedQueue.add(ShareInternalUtility.newUploadStagingResourceWithImageRequest(currentAccessToken, parse, (GraphRequest.Callback) new GraphRequest.Callback() {
                            public void onCompleted(GraphResponse graphResponse) {
                                try {
                                    FacebookRequestError error = graphResponse.getError();
                                    if (error != null) {
                                        String errorMessage = error.getErrorMessage();
                                        if (errorMessage == null) {
                                            errorMessage = "Error staging photo.";
                                        }
                                        throw new FacebookGraphResponseException(graphResponse, errorMessage);
                                    }
                                    JSONObject jSONObject = graphResponse.getJSONObject();
                                    if (jSONObject != null) {
                                        String optString = jSONObject.optString(ShareConstants.MEDIA_URI);
                                        if (optString != null) {
                                            strArr[i] = optString;
                                            countDownLatch.countDown();
                                            return;
                                        }
                                        throw new FacebookException("Error staging photo.");
                                    }
                                    throw new FacebookException("Error staging photo.");
                                } catch (Exception e2) {
                                    UploadStagingResourcesTask.this.exceptions[i] = e2;
                                }
                            }
                        }).executeAsync());
                    }
                    i++;
                } catch (Exception unused) {
                    Iterator it2 = concurrentLinkedQueue.iterator();
                    while (it2.hasNext()) {
                        ((AsyncTask) it2.next()).cancel(true);
                    }
                    return null;
                }
            }
            countDownLatch.await();
            return strArr;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String[] strArr) {
            WebDialog.this.spinner.dismiss();
            for (Exception exc : this.exceptions) {
                if (exc != null) {
                    WebDialog.this.sendErrorToListener(exc);
                    return;
                }
            }
            if (strArr == null) {
                WebDialog.this.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                return;
            }
            List asList = Arrays.asList(strArr);
            if (asList.contains((Object) null)) {
                WebDialog.this.sendErrorToListener(new FacebookException("Failed to stage photos for web dialog"));
                return;
            }
            Utility.putJSONValueInBundle(this.parameters, "media", new JSONArray(asList));
            String unused = WebDialog.this.url = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + Constants.URL_PATH_DELIMITER + ServerProtocol.DIALOG_PATH + this.action, this.parameters).toString();
            WebDialog.this.setUpWebView((WebDialog.this.crossImageView.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
    }
}
