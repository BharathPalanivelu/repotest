package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.bridge.DefaultNativeModuleCallExceptionHandler;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.NativeDeltaClient;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.ShakeDetector;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.react.devsupport.BundleDownloader;
import com.facebook.react.devsupport.DevInternalSettings;
import com.facebook.react.devsupport.DevServerHelper;
import com.facebook.react.devsupport.InspectorPackagerConnection;
import com.facebook.react.devsupport.JSCHeapCapture;
import com.facebook.react.devsupport.JSCSamplingProfiler;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.WebsocketJavaScriptExecutor;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorCustomizer;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.Responder;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import tencent.tls.platform.SigType;

public class DevSupportManagerImpl implements DevInternalSettings.Listener, DevServerHelper.PackagerCommandListener, DevSupportManager {
    public static final String EMOJI_FACE_WITH_NO_GOOD_GESTURE = " 🙅";
    public static final String EMOJI_HUNDRED_POINTS_SYMBOL = " 💯";
    private static final String EXOPACKAGE_LOCATION_FORMAT = "/data/local/tmp/exopackage/%s//secondary-dex";
    private static final int JAVA_ERROR_COOKIE = -1;
    private static final int JSEXCEPTION_ERROR_COOKIE = -1;
    private static final String JS_BUNDLE_FILE_NAME = "ReactNativeDevBundle.js";
    private static final String RELOAD_APP_ACTION_SUFFIX = ".RELOAD_APP_ACTION";
    /* access modifiers changed from: private */
    public final Context mApplicationContext;
    /* access modifiers changed from: private */
    public DevBundleDownloadListener mBundleDownloadListener;
    /* access modifiers changed from: private */
    public InspectorPackagerConnection.BundleStatus mBundleStatus;
    private ReactContext mCurrentContext;
    private final LinkedHashMap<String, DevOptionHandler> mCustomDevOptions;
    private Map<String, RequestHandler> mCustomPackagerCommandHandlers;
    private DebugOverlayController mDebugOverlayController;
    private final DefaultNativeModuleCallExceptionHandler mDefaultNativeModuleCallExceptionHandler;
    /* access modifiers changed from: private */
    public final DevLoadingViewController mDevLoadingViewController;
    /* access modifiers changed from: private */
    public boolean mDevLoadingViewVisible;
    /* access modifiers changed from: private */
    public AlertDialog mDevOptionsDialog;
    /* access modifiers changed from: private */
    public final DevServerHelper mDevServerHelper;
    /* access modifiers changed from: private */
    public DevInternalSettings mDevSettings;
    private List<ErrorCustomizer> mErrorCustomizers;
    private final List<ExceptionLogger> mExceptionLoggers;
    private boolean mIsDevSupportEnabled;
    private boolean mIsReceiverRegistered;
    private boolean mIsShakeDetectorStarted;
    private final String mJSAppBundleName;
    private final File mJSBundleTempFile;
    /* access modifiers changed from: private */
    public int mLastErrorCookie;
    private StackFrame[] mLastErrorStack;
    private String mLastErrorTitle;
    private ErrorType mLastErrorType;
    /* access modifiers changed from: private */
    public final ReactInstanceManagerDevHelper mReactInstanceManagerHelper;
    /* access modifiers changed from: private */
    public RedBoxDialog mRedBoxDialog;
    /* access modifiers changed from: private */
    public RedBoxHandler mRedBoxHandler;
    private final BroadcastReceiver mReloadAppBroadcastReceiver;
    private final ShakeDetector mShakeDetector;

    private enum ErrorType {
        JS,
        NATIVE
    }

    private interface ExceptionLogger {
        void log(Exception exc);
    }

    public void onPackagerConnected() {
    }

    public void onPackagerDisconnected() {
    }

    private static class JscProfileTask extends AsyncTask<String, Void, Void> {
        private static final MediaType JSON = MediaType.parse(LiveAgentRequest.HEADER_ACCEPT_VALUE);
        private final String mSourceUrl;

        private JscProfileTask(String str) {
            this.mSourceUrl = str;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... strArr) {
            try {
                String uri = Uri.parse(this.mSourceUrl).buildUpon().path("/jsc-profile").query((String) null).build().toString();
                OkHttpClient okHttpClient = new OkHttpClient();
                for (String create : strArr) {
                    FirebasePerfOkHttpClient.execute(okHttpClient.newCall(new Request.Builder().url(uri).post(RequestBody.create(JSON, create)).build()));
                }
            } catch (IOException e2) {
                FLog.e(ReactConstants.TAG, "Failed not talk to server", (Throwable) e2);
            }
            return null;
        }
    }

    public DevSupportManagerImpl(Context context, ReactInstanceManagerDevHelper reactInstanceManagerDevHelper, String str, boolean z, int i) {
        this(context, reactInstanceManagerDevHelper, str, z, (RedBoxHandler) null, (DevBundleDownloadListener) null, i, (Map<String, RequestHandler>) null);
    }

    public DevSupportManagerImpl(Context context, ReactInstanceManagerDevHelper reactInstanceManagerDevHelper, String str, boolean z, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i, Map<String, RequestHandler> map) {
        this.mExceptionLoggers = new ArrayList();
        this.mCustomDevOptions = new LinkedHashMap<>();
        this.mDevLoadingViewVisible = false;
        this.mIsReceiverRegistered = false;
        this.mIsShakeDetectorStarted = false;
        this.mIsDevSupportEnabled = false;
        this.mLastErrorCookie = 0;
        this.mReactInstanceManagerHelper = reactInstanceManagerDevHelper;
        this.mApplicationContext = context;
        this.mJSAppBundleName = str;
        this.mDevSettings = new DevInternalSettings(context, this);
        this.mBundleStatus = new InspectorPackagerConnection.BundleStatus();
        this.mDevServerHelper = new DevServerHelper(this.mDevSettings, this.mApplicationContext.getPackageName(), new InspectorPackagerConnection.BundleStatusProvider() {
            public InspectorPackagerConnection.BundleStatus getBundleStatus() {
                return DevSupportManagerImpl.this.mBundleStatus;
            }
        });
        this.mBundleDownloadListener = devBundleDownloadListener;
        this.mShakeDetector = new ShakeDetector(new ShakeDetector.ShakeListener() {
            public void onShake() {
                DevSupportManagerImpl.this.showDevOptionsDialog();
            }
        }, i);
        this.mCustomPackagerCommandHandlers = map;
        this.mReloadAppBroadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (DevSupportManagerImpl.getReloadAppAction(context).equals(intent.getAction())) {
                    if (intent.getBooleanExtra(DevServerHelper.RELOAD_APP_EXTRA_JS_PROXY, false)) {
                        DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(true);
                        DevSupportManagerImpl.this.mDevServerHelper.launchJSDevtools();
                    } else {
                        DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(false);
                    }
                    DevSupportManagerImpl.this.handleReloadJS();
                }
            }
        };
        this.mJSBundleTempFile = new File(context.getFilesDir(), JS_BUNDLE_FILE_NAME);
        this.mDefaultNativeModuleCallExceptionHandler = new DefaultNativeModuleCallExceptionHandler();
        setDevSupportEnabled(z);
        this.mRedBoxHandler = redBoxHandler;
        this.mDevLoadingViewController = new DevLoadingViewController(context, reactInstanceManagerDevHelper);
        this.mExceptionLoggers.add(new JSExceptionLogger());
    }

    public void handleException(Exception exc) {
        if (this.mIsDevSupportEnabled) {
            for (ExceptionLogger log : this.mExceptionLoggers) {
                log.log(exc);
            }
            return;
        }
        this.mDefaultNativeModuleCallExceptionHandler.handleException(exc);
    }

    private class JSExceptionLogger implements ExceptionLogger {
        private JSExceptionLogger() {
        }

        public void log(Exception exc) {
            StringBuilder sb = new StringBuilder(exc.getMessage() == null ? "Exception in native call from JS" : exc.getMessage());
            for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
                sb.append("\n\n");
                sb.append(cause.getMessage());
            }
            if (exc instanceof JSException) {
                FLog.e(ReactConstants.TAG, "Exception in native call from JS", (Throwable) exc);
                String stack = ((JSException) exc).getStack();
                sb.append("\n\n");
                sb.append(stack);
                DevSupportManagerImpl.this.showNewError(sb.toString(), new StackFrame[0], -1, ErrorType.JS);
                return;
            }
            DevSupportManagerImpl.this.showNewJavaError(sb.toString(), exc);
        }
    }

    public void showNewJavaError(String str, Throwable th) {
        FLog.e(ReactConstants.TAG, "Exception in native call", th);
        showNewError(str, StackTraceHelper.convertJavaStackTrace(th), -1, ErrorType.NATIVE);
    }

    public void addCustomDevOption(String str, DevOptionHandler devOptionHandler) {
        this.mCustomDevOptions.put(str, devOptionHandler);
    }

    public void showNewJSError(String str, ReadableArray readableArray, int i) {
        showNewError(str, StackTraceHelper.convertJsStackTrace(readableArray), i, ErrorType.JS);
    }

    public void registerErrorCustomizer(ErrorCustomizer errorCustomizer) {
        if (this.mErrorCustomizers == null) {
            this.mErrorCustomizers = new ArrayList();
        }
        this.mErrorCustomizers.add(errorCustomizer);
    }

    /* access modifiers changed from: private */
    public Pair<String, StackFrame[]> processErrorCustomizers(Pair<String, StackFrame[]> pair) {
        List<ErrorCustomizer> list = this.mErrorCustomizers;
        if (list == null) {
            return pair;
        }
        for (ErrorCustomizer customizeErrorInfo : list) {
            Pair<String, StackFrame[]> customizeErrorInfo2 = customizeErrorInfo.customizeErrorInfo(pair);
            if (customizeErrorInfo2 != null) {
                pair = customizeErrorInfo2;
            }
        }
        return pair;
    }

    public void updateJSError(final String str, final ReadableArray readableArray, final int i) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (DevSupportManagerImpl.this.mRedBoxDialog != null && DevSupportManagerImpl.this.mRedBoxDialog.isShowing() && i == DevSupportManagerImpl.this.mLastErrorCookie) {
                    StackFrame[] convertJsStackTrace = StackTraceHelper.convertJsStackTrace(readableArray);
                    Pair access$800 = DevSupportManagerImpl.this.processErrorCustomizers(Pair.create(str, convertJsStackTrace));
                    DevSupportManagerImpl.this.mRedBoxDialog.setExceptionDetails((String) access$800.first, (StackFrame[]) access$800.second);
                    DevSupportManagerImpl.this.updateLastErrorInfo(str, convertJsStackTrace, i, ErrorType.JS);
                    if (DevSupportManagerImpl.this.mRedBoxHandler != null) {
                        DevSupportManagerImpl.this.mRedBoxHandler.handleRedbox(str, convertJsStackTrace, RedBoxHandler.ErrorType.JS);
                        DevSupportManagerImpl.this.mRedBoxDialog.resetReporting();
                    }
                    DevSupportManagerImpl.this.mRedBoxDialog.show();
                }
            }
        });
    }

    public void hideRedboxDialog() {
        RedBoxDialog redBoxDialog = this.mRedBoxDialog;
        if (redBoxDialog != null) {
            redBoxDialog.dismiss();
            this.mRedBoxDialog = null;
        }
    }

    private void hideDevOptionsDialog() {
        AlertDialog alertDialog = this.mDevOptionsDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.mDevOptionsDialog = null;
        }
    }

    /* access modifiers changed from: private */
    public void showNewError(String str, StackFrame[] stackFrameArr, int i, ErrorType errorType) {
        final String str2 = str;
        final StackFrame[] stackFrameArr2 = stackFrameArr;
        final int i2 = i;
        final ErrorType errorType2 = errorType;
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (DevSupportManagerImpl.this.mRedBoxDialog == null) {
                    Activity currentActivity = DevSupportManagerImpl.this.mReactInstanceManagerHelper.getCurrentActivity();
                    if (currentActivity == null || currentActivity.isFinishing()) {
                        FLog.e(ReactConstants.TAG, "Unable to launch redbox because react activity is not available, here is the error that redbox would've displayed: " + str2);
                        return;
                    }
                    DevSupportManagerImpl devSupportManagerImpl = DevSupportManagerImpl.this;
                    RedBoxDialog unused = devSupportManagerImpl.mRedBoxDialog = new RedBoxDialog(currentActivity, devSupportManagerImpl, devSupportManagerImpl.mRedBoxHandler);
                }
                if (!DevSupportManagerImpl.this.mRedBoxDialog.isShowing()) {
                    Pair access$800 = DevSupportManagerImpl.this.processErrorCustomizers(Pair.create(str2, stackFrameArr2));
                    DevSupportManagerImpl.this.mRedBoxDialog.setExceptionDetails((String) access$800.first, (StackFrame[]) access$800.second);
                    DevSupportManagerImpl.this.updateLastErrorInfo(str2, stackFrameArr2, i2, errorType2);
                    if (DevSupportManagerImpl.this.mRedBoxHandler != null && errorType2 == ErrorType.NATIVE) {
                        DevSupportManagerImpl.this.mRedBoxHandler.handleRedbox(str2, stackFrameArr2, RedBoxHandler.ErrorType.NATIVE);
                    }
                    DevSupportManagerImpl.this.mRedBoxDialog.resetReporting();
                    DevSupportManagerImpl.this.mRedBoxDialog.show();
                }
            }
        });
    }

    public void showDevOptionsDialog() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.mDevOptionsDialog == null && this.mIsDevSupportEnabled && !ActivityManager.isUserAMonkey()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_reloadjs), new DevOptionHandler() {
                public void onOptionSelected() {
                    if (!DevSupportManagerImpl.this.mDevSettings.isJSDevModeEnabled() && DevSupportManagerImpl.this.mDevSettings.isHotModuleReplacementEnabled()) {
                        Toast.makeText(DevSupportManagerImpl.this.mApplicationContext, "HMR cannot be enabled when Dev mode is off. Disabling HMR...", 1).show();
                        DevSupportManagerImpl.this.mDevSettings.setHotModuleReplacementEnabled(false);
                    }
                    DevSupportManagerImpl.this.handleReloadJS();
                }
            });
            if (this.mDevSettings.isNuclideJSDebugEnabled()) {
                linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_debugjs_nuclide) + EMOJI_HUNDRED_POINTS_SYMBOL, new DevOptionHandler() {
                    public void onOptionSelected() {
                        DevSupportManagerImpl.this.mDevServerHelper.attachDebugger(DevSupportManagerImpl.this.mApplicationContext, ReactConstants.TAG);
                    }
                });
            }
            if (this.mDevSettings.isRemoteJSDebugEnabled()) {
                str = this.mApplicationContext.getString(R.string.catalyst_debugjs_off);
            } else {
                str = this.mApplicationContext.getString(R.string.catalyst_debugjs);
            }
            if (this.mDevSettings.isNuclideJSDebugEnabled()) {
                str = str + EMOJI_FACE_WITH_NO_GOOD_GESTURE;
            }
            linkedHashMap.put(str, new DevOptionHandler() {
                public void onOptionSelected() {
                    DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(!DevSupportManagerImpl.this.mDevSettings.isRemoteJSDebugEnabled());
                    DevSupportManagerImpl.this.handleReloadJS();
                }
            });
            if (this.mDevSettings.isReloadOnJSChangeEnabled()) {
                str2 = this.mApplicationContext.getString(R.string.catalyst_live_reload_off);
            } else {
                str2 = this.mApplicationContext.getString(R.string.catalyst_live_reload);
            }
            linkedHashMap.put(str2, new DevOptionHandler() {
                public void onOptionSelected() {
                    DevSupportManagerImpl.this.mDevSettings.setReloadOnJSChangeEnabled(!DevSupportManagerImpl.this.mDevSettings.isReloadOnJSChangeEnabled());
                }
            });
            if (this.mDevSettings.isHotModuleReplacementEnabled()) {
                str3 = this.mApplicationContext.getString(R.string.catalyst_hot_module_replacement_off);
            } else {
                str3 = this.mApplicationContext.getString(R.string.catalyst_hot_module_replacement);
            }
            linkedHashMap.put(str3, new DevOptionHandler() {
                public void onOptionSelected() {
                    if (!DevSupportManagerImpl.this.mDevSettings.isHotModuleReplacementEnabled() && !DevSupportManagerImpl.this.mDevSettings.isJSDevModeEnabled()) {
                        Toast.makeText(DevSupportManagerImpl.this.mApplicationContext, "You're trying to enable HMR while Dev mode is off. Turning both HMR and the Dev mode on...", 1).show();
                        DevSupportManagerImpl.this.mDevSettings.setJSDevModeEnabled(true);
                    }
                    DevSupportManagerImpl.this.mDevSettings.setHotModuleReplacementEnabled(true ^ DevSupportManagerImpl.this.mDevSettings.isHotModuleReplacementEnabled());
                    DevSupportManagerImpl.this.handleReloadJS();
                }
            });
            linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_element_inspector), new DevOptionHandler() {
                public void onOptionSelected() {
                    DevSupportManagerImpl.this.mDevSettings.setElementInspectorEnabled(!DevSupportManagerImpl.this.mDevSettings.isElementInspectorEnabled());
                    DevSupportManagerImpl.this.mReactInstanceManagerHelper.toggleElementInspector();
                }
            });
            if (this.mDevSettings.isFpsDebugEnabled()) {
                str4 = this.mApplicationContext.getString(R.string.catalyst_perf_monitor_off);
            } else {
                str4 = this.mApplicationContext.getString(R.string.catalyst_perf_monitor);
            }
            linkedHashMap.put(str4, new DevOptionHandler() {
                public void onOptionSelected() {
                    if (!DevSupportManagerImpl.this.mDevSettings.isFpsDebugEnabled()) {
                        Activity currentActivity = DevSupportManagerImpl.this.mReactInstanceManagerHelper.getCurrentActivity();
                        if (currentActivity == null) {
                            FLog.e(ReactConstants.TAG, "Unable to get reference to react activity");
                        } else {
                            DebugOverlayController.requestPermission(currentActivity);
                        }
                    }
                    DevSupportManagerImpl.this.mDevSettings.setFpsDebugEnabled(!DevSupportManagerImpl.this.mDevSettings.isFpsDebugEnabled());
                }
            });
            linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_poke_sampling_profiler), new DevOptionHandler() {
                public void onOptionSelected() {
                    DevSupportManagerImpl.this.handlePokeSamplingProfiler();
                }
            });
            linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_settings), new DevOptionHandler() {
                public void onOptionSelected() {
                    Intent intent = new Intent(DevSupportManagerImpl.this.mApplicationContext, DevSettingsActivity.class);
                    intent.setFlags(SigType.TLS);
                    DevSupportManagerImpl.this.mApplicationContext.startActivity(intent);
                }
            });
            if (this.mCustomDevOptions.size() > 0) {
                linkedHashMap.putAll(this.mCustomDevOptions);
            }
            final DevOptionHandler[] devOptionHandlerArr = (DevOptionHandler[]) linkedHashMap.values().toArray(new DevOptionHandler[0]);
            Activity currentActivity = this.mReactInstanceManagerHelper.getCurrentActivity();
            if (currentActivity == null || currentActivity.isFinishing()) {
                FLog.e(ReactConstants.TAG, "Unable to launch dev options menu because react activity isn't available");
                return;
            }
            this.mDevOptionsDialog = new AlertDialog.Builder(currentActivity).setItems((CharSequence[]) linkedHashMap.keySet().toArray(new String[0]), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    devOptionHandlerArr[i].onOptionSelected();
                    AlertDialog unused = DevSupportManagerImpl.this.mDevOptionsDialog = null;
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    AlertDialog unused = DevSupportManagerImpl.this.mDevOptionsDialog = null;
                }
            }).create();
            this.mDevOptionsDialog.show();
        }
    }

    public void setDevSupportEnabled(boolean z) {
        this.mIsDevSupportEnabled = z;
        reloadSettings();
    }

    public boolean getDevSupportEnabled() {
        return this.mIsDevSupportEnabled;
    }

    public DeveloperSettings getDevSettings() {
        return this.mDevSettings;
    }

    public void onNewReactContextCreated(ReactContext reactContext) {
        resetCurrentContext(reactContext);
    }

    public void onReactInstanceDestroyed(ReactContext reactContext) {
        if (reactContext == this.mCurrentContext) {
            resetCurrentContext((ReactContext) null);
        }
    }

    public String getSourceMapUrl() {
        String str = this.mJSAppBundleName;
        if (str == null) {
            return "";
        }
        return this.mDevServerHelper.getSourceMapUrl((String) Assertions.assertNotNull(str));
    }

    public String getSourceUrl() {
        String str = this.mJSAppBundleName;
        if (str == null) {
            return "";
        }
        return this.mDevServerHelper.getSourceUrl((String) Assertions.assertNotNull(str));
    }

    public String getJSBundleURLForRemoteDebugging() {
        return this.mDevServerHelper.getJSBundleURLForRemoteDebugging((String) Assertions.assertNotNull(this.mJSAppBundleName));
    }

    public String getDownloadedJSBundleFile() {
        return this.mJSBundleTempFile.getAbsolutePath();
    }

    public boolean hasUpToDateJSBundleInCache() {
        if (this.mIsDevSupportEnabled && this.mJSBundleTempFile.exists()) {
            try {
                String packageName = this.mApplicationContext.getPackageName();
                if (this.mJSBundleTempFile.lastModified() > this.mApplicationContext.getPackageManager().getPackageInfo(packageName, 0).lastUpdateTime) {
                    File file = new File(String.format(Locale.US, EXOPACKAGE_LOCATION_FORMAT, new Object[]{packageName}));
                    if (!file.exists() || this.mJSBundleTempFile.lastModified() > file.lastModified()) {
                        return true;
                    }
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                FLog.e(ReactConstants.TAG, "DevSupport is unable to get current app info");
            }
        }
        return false;
    }

    public boolean hasBundleInAssets(String str) {
        try {
            String[] list = this.mApplicationContext.getAssets().list("");
            for (String equals : list) {
                if (equals.equals(str)) {
                    return true;
                }
            }
        } catch (IOException unused) {
            FLog.e(ReactConstants.TAG, "Error while loading assets list");
        }
        return false;
    }

    private void resetCurrentContext(ReactContext reactContext) {
        if (this.mCurrentContext != reactContext) {
            this.mCurrentContext = reactContext;
            DebugOverlayController debugOverlayController = this.mDebugOverlayController;
            if (debugOverlayController != null) {
                debugOverlayController.setFpsDebugViewVisible(false);
            }
            if (reactContext != null) {
                this.mDebugOverlayController = new DebugOverlayController(reactContext);
            }
            if (this.mDevSettings.isHotModuleReplacementEnabled() && this.mCurrentContext != null) {
                try {
                    URL url = new URL(getSourceUrl());
                    ((HMRClient) this.mCurrentContext.getJSModule(HMRClient.class)).enable("android", url.getPath().substring(1), url.getHost(), url.getPort());
                } catch (MalformedURLException e2) {
                    showNewJavaError(e2.getMessage(), e2);
                }
            }
            reloadSettings();
        }
    }

    public void reloadSettings() {
        if (UiThreadUtil.isOnUiThread()) {
            reload();
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSupportManagerImpl.this.reload();
                }
            });
        }
    }

    public void onInternalSettingsChanged() {
        reloadSettings();
    }

    public void handleReloadJS() {
        UiThreadUtil.assertOnUiThread();
        ReactMarker.logMarker(ReactMarkerConstants.RELOAD, this.mDevSettings.getPackagerConnectionSettings().getDebugServerHost());
        hideRedboxDialog();
        if (this.mDevSettings.isRemoteJSDebugEnabled()) {
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Proxy");
            this.mDevLoadingViewController.showForRemoteJSEnabled();
            this.mDevLoadingViewVisible = true;
            reloadJSInProxyMode();
            return;
        }
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Server");
        reloadJSFromServer(this.mDevServerHelper.getDevServerBundleURL((String) Assertions.assertNotNull(this.mJSAppBundleName)));
    }

    public void isPackagerRunning(PackagerStatusCallback packagerStatusCallback) {
        this.mDevServerHelper.isPackagerRunning(packagerStatusCallback);
    }

    public File downloadBundleResourceFromUrlSync(String str, File file) {
        return this.mDevServerHelper.downloadBundleResourceFromUrlSync(str, file);
    }

    public String getLastErrorTitle() {
        return this.mLastErrorTitle;
    }

    public StackFrame[] getLastErrorStack() {
        return this.mLastErrorStack;
    }

    public void onPackagerReloadCommand() {
        this.mDevServerHelper.disableDebugger();
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                DevSupportManagerImpl.this.handleReloadJS();
            }
        });
    }

    public void onPackagerDevMenuCommand() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                DevSupportManagerImpl.this.showDevOptionsDialog();
            }
        });
    }

    public void onCaptureHeapCommand(final Responder responder) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                DevSupportManagerImpl.this.handleCaptureHeap(responder);
            }
        });
    }

    public Map<String, RequestHandler> customCommandHandlers() {
        return this.mCustomPackagerCommandHandlers;
    }

    /* access modifiers changed from: private */
    public void handleCaptureHeap(final Responder responder) {
        ReactContext reactContext = this.mCurrentContext;
        if (reactContext != null) {
            ((JSCHeapCapture) reactContext.getNativeModule(JSCHeapCapture.class)).captureHeap(this.mApplicationContext.getCacheDir().getPath(), new JSCHeapCapture.CaptureCallback() {
                public void onSuccess(File file) {
                    responder.respond(file.toString());
                }

                public void onFailure(JSCHeapCapture.CaptureException captureException) {
                    responder.error(captureException.toString());
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void handlePokeSamplingProfiler() {
        try {
            Iterator<String> it = JSCSamplingProfiler.poke(60000).iterator();
            while (it.hasNext()) {
                String next = it.next();
                Toast.makeText(this.mCurrentContext, next == null ? "Started JSC Sampling Profiler" : "Stopped JSC Sampling Profiler", 1).show();
                new JscProfileTask(getSourceUrl()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{next});
            }
        } catch (JSCSamplingProfiler.ProfilerException e2) {
            showNewJavaError(e2.getMessage(), e2);
        }
    }

    /* access modifiers changed from: private */
    public void updateLastErrorInfo(String str, StackFrame[] stackFrameArr, int i, ErrorType errorType) {
        this.mLastErrorTitle = str;
        this.mLastErrorStack = stackFrameArr;
        this.mLastErrorCookie = i;
        this.mLastErrorType = errorType;
    }

    private void reloadJSInProxyMode() {
        this.mDevServerHelper.launchJSDevtools();
        this.mReactInstanceManagerHelper.onReloadWithJSDebugger(new JavaJSExecutor.Factory() {
            public JavaJSExecutor create() throws Exception {
                WebsocketJavaScriptExecutor websocketJavaScriptExecutor = new WebsocketJavaScriptExecutor();
                SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
                websocketJavaScriptExecutor.connect(DevSupportManagerImpl.this.mDevServerHelper.getWebsocketProxyURL(), DevSupportManagerImpl.this.getExecutorConnectCallback(simpleSettableFuture));
                try {
                    simpleSettableFuture.get(90, TimeUnit.SECONDS);
                    return websocketJavaScriptExecutor;
                } catch (ExecutionException e2) {
                    throw ((Exception) e2.getCause());
                } catch (InterruptedException | TimeoutException e3) {
                    throw new RuntimeException(e3);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public WebsocketJavaScriptExecutor.JSExecutorConnectCallback getExecutorConnectCallback(final SimpleSettableFuture<Boolean> simpleSettableFuture) {
        return new WebsocketJavaScriptExecutor.JSExecutorConnectCallback() {
            public void onSuccess() {
                simpleSettableFuture.set(true);
                DevSupportManagerImpl.this.mDevLoadingViewController.hide();
                boolean unused = DevSupportManagerImpl.this.mDevLoadingViewVisible = false;
            }

            public void onFailure(Throwable th) {
                DevSupportManagerImpl.this.mDevLoadingViewController.hide();
                boolean unused = DevSupportManagerImpl.this.mDevLoadingViewVisible = false;
                FLog.e(ReactConstants.TAG, "Unable to connect to remote debugger", th);
                simpleSettableFuture.setException(new IOException(DevSupportManagerImpl.this.mApplicationContext.getString(R.string.catalyst_remotedbg_error), th));
            }
        };
    }

    public void reloadJSFromServer(String str) {
        ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_START);
        this.mDevLoadingViewController.showForUrl(str);
        this.mDevLoadingViewVisible = true;
        final BundleDownloader.BundleInfo bundleInfo = new BundleDownloader.BundleInfo();
        this.mDevServerHelper.downloadBundleFromURL(new DevBundleDownloadListener() {
            public void onSuccess(final NativeDeltaClient nativeDeltaClient) {
                DevSupportManagerImpl.this.mDevLoadingViewController.hide();
                boolean unused = DevSupportManagerImpl.this.mDevLoadingViewVisible = false;
                synchronized (DevSupportManagerImpl.this) {
                    DevSupportManagerImpl.this.mBundleStatus.isLastDownloadSucess = true;
                    DevSupportManagerImpl.this.mBundleStatus.updateTimestamp = System.currentTimeMillis();
                }
                if (DevSupportManagerImpl.this.mBundleDownloadListener != null) {
                    DevSupportManagerImpl.this.mBundleDownloadListener.onSuccess(nativeDeltaClient);
                }
                UiThreadUtil.runOnUiThread(new Runnable() {
                    public void run() {
                        ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_END, bundleInfo.toJSONString());
                        DevSupportManagerImpl.this.mReactInstanceManagerHelper.onJSBundleLoadedFromServer(nativeDeltaClient);
                    }
                });
            }

            public void onProgress(String str, Integer num, Integer num2) {
                DevSupportManagerImpl.this.mDevLoadingViewController.updateProgress(str, num, num2);
                if (DevSupportManagerImpl.this.mBundleDownloadListener != null) {
                    DevSupportManagerImpl.this.mBundleDownloadListener.onProgress(str, num, num2);
                }
            }

            public void onFailure(final Exception exc) {
                DevSupportManagerImpl.this.mDevLoadingViewController.hide();
                boolean unused = DevSupportManagerImpl.this.mDevLoadingViewVisible = false;
                synchronized (DevSupportManagerImpl.this) {
                    DevSupportManagerImpl.this.mBundleStatus.isLastDownloadSucess = false;
                }
                if (DevSupportManagerImpl.this.mBundleDownloadListener != null) {
                    DevSupportManagerImpl.this.mBundleDownloadListener.onFailure(exc);
                }
                FLog.e(ReactConstants.TAG, "Unable to download JS bundle", (Throwable) exc);
                UiThreadUtil.runOnUiThread(new Runnable() {
                    public void run() {
                        Exception exc = exc;
                        if (exc instanceof DebugServerException) {
                            DevSupportManagerImpl.this.showNewJavaError(((DebugServerException) exc).getMessage(), exc);
                        } else {
                            DevSupportManagerImpl.this.showNewJavaError(DevSupportManagerImpl.this.mApplicationContext.getString(R.string.catalyst_jsload_error), exc);
                        }
                    }
                });
            }
        }, this.mJSBundleTempFile, str, bundleInfo);
    }

    public void startInspector() {
        if (this.mIsDevSupportEnabled) {
            this.mDevServerHelper.openInspectorConnection();
        }
    }

    public void stopInspector() {
        this.mDevServerHelper.closeInspectorConnection();
    }

    public void setHotModuleReplacementEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSupportManagerImpl.this.mDevSettings.setHotModuleReplacementEnabled(z);
                    DevSupportManagerImpl.this.handleReloadJS();
                }
            });
        }
    }

    public void setRemoteJSDebugEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(z);
                    DevSupportManagerImpl.this.handleReloadJS();
                }
            });
        }
    }

    public void setReloadOnJSChangeEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSupportManagerImpl.this.mDevSettings.setReloadOnJSChangeEnabled(z);
                    DevSupportManagerImpl.this.handleReloadJS();
                }
            });
        }
    }

    public void setFpsDebugEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSupportManagerImpl.this.mDevSettings.setFpsDebugEnabled(z);
                }
            });
        }
    }

    public void toggleElementInspector() {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSupportManagerImpl.this.mDevSettings.setElementInspectorEnabled(!DevSupportManagerImpl.this.mDevSettings.isElementInspectorEnabled());
                    DevSupportManagerImpl.this.mReactInstanceManagerHelper.toggleElementInspector();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void reload() {
        UiThreadUtil.assertOnUiThread();
        if (this.mIsDevSupportEnabled) {
            DebugOverlayController debugOverlayController = this.mDebugOverlayController;
            if (debugOverlayController != null) {
                debugOverlayController.setFpsDebugViewVisible(this.mDevSettings.isFpsDebugEnabled());
            }
            if (!this.mIsShakeDetectorStarted) {
                this.mShakeDetector.start((SensorManager) this.mApplicationContext.getSystemService("sensor"));
                this.mIsShakeDetectorStarted = true;
            }
            if (!this.mIsReceiverRegistered) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(getReloadAppAction(this.mApplicationContext));
                this.mApplicationContext.registerReceiver(this.mReloadAppBroadcastReceiver, intentFilter);
                this.mIsReceiverRegistered = true;
            }
            if (this.mDevLoadingViewVisible) {
                this.mDevLoadingViewController.showMessage("Reloading...");
            }
            this.mDevServerHelper.openPackagerConnection(getClass().getSimpleName(), this);
            if (this.mDevSettings.isReloadOnJSChangeEnabled()) {
                this.mDevServerHelper.startPollingOnChangeEndpoint(new DevServerHelper.OnServerContentChangeListener() {
                    public void onServerContentChanged() {
                        DevSupportManagerImpl.this.handleReloadJS();
                    }
                });
            } else {
                this.mDevServerHelper.stopPollingOnChangeEndpoint();
            }
        } else {
            DebugOverlayController debugOverlayController2 = this.mDebugOverlayController;
            if (debugOverlayController2 != null) {
                debugOverlayController2.setFpsDebugViewVisible(false);
            }
            if (this.mIsShakeDetectorStarted) {
                this.mShakeDetector.stop();
                this.mIsShakeDetectorStarted = false;
            }
            if (this.mIsReceiverRegistered) {
                this.mApplicationContext.unregisterReceiver(this.mReloadAppBroadcastReceiver);
                this.mIsReceiverRegistered = false;
            }
            hideRedboxDialog();
            hideDevOptionsDialog();
            this.mDevLoadingViewController.hide();
            this.mDevServerHelper.closePackagerConnection();
            this.mDevServerHelper.stopPollingOnChangeEndpoint();
        }
    }

    /* access modifiers changed from: private */
    public static String getReloadAppAction(Context context) {
        return context.getPackageName() + RELOAD_APP_ACTION_SUFFIX;
    }
}
