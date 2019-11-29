package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.fabric.jsi.Binding;
import com.facebook.react.fabric.jsi.EventBeatManager;
import com.facebook.react.fabric.jsi.EventEmitterWrapper;
import com.facebook.react.fabric.jsi.FabricSoLoader;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.mountitems.BatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.CreateMountItem;
import com.facebook.react.fabric.mounting.mountitems.DeleteMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.InsertMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.PreAllocateViewMountItem;
import com.facebook.react.fabric.mounting.mountitems.RemoveMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateEventEmitterMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLayoutMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLocalDataMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdatePropsMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateStateMountItem;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.ReactRootViewTagGenerator;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.slider.ReactSliderManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.systrace.Systrace;
import com.path.android.jobqueue.JobManager;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"MissingNativeLoadLibrary"})
public class FabricUIManager implements LifecycleEventListener, UIManager {
    public static final boolean DEBUG = PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.FABRIC_UI_MANAGER);
    private static final int FRAME_TIME_MS = 16;
    private static final int MAX_TIME_IN_FRAME_FOR_NON_BATCHED_OPERATIONS_MS = 8;
    private static final int PRE_MOUNT_ITEMS_INITIAL_SIZE_ARRAY = 250;
    public static final String TAG = "FabricUIManager";
    private static final Map<String, String> sComponentNames = new HashMap();
    private long mBatchedExecutionTime = 0;
    private Binding mBinding;
    private long mCommitStartTime = 0;
    /* access modifiers changed from: private */
    @ThreadConfined("UI")
    public final DispatchUIFrameCallback mDispatchUIFrameCallback;
    private long mDispatchViewUpdatesTime = 0;
    private final EventBeatManager mEventBeatManager;
    private final EventDispatcher mEventDispatcher;
    private long mFinishTransactionCPPTime = 0;
    private long mFinishTransactionTime = 0;
    /* access modifiers changed from: private */
    @ThreadConfined("UI")
    public boolean mIsMountingEnabled = true;
    private long mLayoutTime = 0;
    private List<MountItem> mMountItems = new ArrayList();
    private final Object mMountItemsLock = new Object();
    private final MountingManager mMountingManager;
    private ArrayDeque<MountItem> mPreMountItems = new ArrayDeque<>(PRE_MOUNT_ITEMS_INITIAL_SIZE_ARRAY);
    private final Object mPreMountItemsLock = new Object();
    private final ReactApplicationContext mReactApplicationContext;
    private final ConcurrentHashMap<Integer, ThemedReactContext> mReactContextForRootTag = new ConcurrentHashMap<>();
    private long mRunStartTime = 0;

    public void clearJSResponder() {
    }

    public void onHostDestroy() {
    }

    public void profileNextBatch() {
    }

    public void setJSResponder(int i, boolean z) {
    }

    static {
        FabricSoLoader.staticInit();
        sComponentNames.put("View", "RCTView");
        sComponentNames.put("Image", ReactImageManager.REACT_CLASS);
        sComponentNames.put("ScrollView", ReactScrollViewManager.REACT_CLASS);
        sComponentNames.put("Slider", ReactSliderManager.REACT_CLASS);
        sComponentNames.put("ModalHostView", ReactModalHostManager.REACT_CLASS);
        sComponentNames.put("Paragraph", ReactTextViewManager.REACT_CLASS);
        sComponentNames.put("Text", "RCText");
        sComponentNames.put("RawText", ReactRawTextManager.REACT_CLASS);
        sComponentNames.put("ActivityIndicatorView", ReactProgressBarViewManager.REACT_CLASS);
        sComponentNames.put("ShimmeringView", "RKShimmeringView");
        sComponentNames.put("TemplateView", "RCTTemplateView");
        sComponentNames.put("AxialGradientView", "RCTAxialGradientView");
    }

    public FabricUIManager(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, EventBeatManager eventBeatManager) {
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        this.mMountingManager = new MountingManager(viewManagerRegistry);
        this.mEventDispatcher = eventDispatcher;
        this.mEventBeatManager = eventBeatManager;
        this.mReactApplicationContext.addLifecycleEventListener(this);
    }

    public <T extends View> int addRootView(T t, WritableMap writableMap, String str) {
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        ThemedReactContext themedReactContext = new ThemedReactContext(this.mReactApplicationContext, t.getContext());
        this.mMountingManager.addRootView(nextRootViewTag, t);
        this.mReactContextForRootTag.put(Integer.valueOf(nextRootViewTag), themedReactContext);
        this.mBinding.startSurface(nextRootViewTag, (NativeMap) writableMap);
        if (str != null) {
            this.mBinding.renderTemplateToSurface(nextRootViewTag, str);
        }
        return nextRootViewTag;
    }

    @DoNotStrip
    public void onRequestEventBeat() {
        this.mEventDispatcher.dispatchAllEvents();
    }

    public void removeRootView(int i) {
        this.mMountingManager.removeRootView(i);
        this.mReactContextForRootTag.remove(Integer.valueOf(i));
    }

    public void initialize() {
        this.mEventDispatcher.registerEventEmitter(2, new FabricEventEmitter(this));
        this.mEventDispatcher.addBatchEventDispatchedListener(this.mEventBeatManager);
    }

    public void onCatalystInstanceDestroy() {
        this.mEventDispatcher.removeBatchEventDispatchedListener(this.mEventBeatManager);
        this.mEventDispatcher.unregisterEventEmitter(2);
        this.mBinding.unregister();
        ViewManagerPropertyUpdater.clear();
    }

    @DoNotStrip
    private void preallocateView(int i, int i2, String str, ReadableMap readableMap, boolean z) {
        ThemedReactContext themedReactContext = this.mReactContextForRootTag.get(Integer.valueOf(i));
        String component = getComponent(str);
        synchronized (this.mPreMountItemsLock) {
            this.mPreMountItems.add(new PreAllocateViewMountItem(themedReactContext, i, i2, component, readableMap, z));
        }
    }

    private String getComponent(String str) {
        String str2 = sComponentNames.get(str);
        return str2 != null ? str2 : str;
    }

    @DoNotStrip
    private MountItem createMountItem(String str, int i, int i2, boolean z) {
        String component = getComponent(str);
        ThemedReactContext themedReactContext = this.mReactContextForRootTag.get(Integer.valueOf(i));
        if (themedReactContext != null) {
            return new CreateMountItem(themedReactContext, i, i2, component, z);
        }
        throw new IllegalArgumentException("Unable to find ReactContext for root: " + i);
    }

    @DoNotStrip
    private MountItem removeMountItem(int i, int i2, int i3) {
        return new RemoveMountItem(i, i2, i3);
    }

    @DoNotStrip
    private MountItem insertMountItem(int i, int i2, int i3) {
        return new InsertMountItem(i, i2, i3);
    }

    @DoNotStrip
    private MountItem deleteMountItem(int i) {
        return new DeleteMountItem(i);
    }

    @DoNotStrip
    private MountItem updateLayoutMountItem(int i, int i2, int i3, int i4, int i5) {
        return new UpdateLayoutMountItem(i, i2, i3, i4, i5);
    }

    @DoNotStrip
    private MountItem updatePropsMountItem(int i, ReadableMap readableMap) {
        return new UpdatePropsMountItem(i, readableMap);
    }

    @DoNotStrip
    private MountItem updateLocalDataMountItem(int i, ReadableMap readableMap) {
        return new UpdateLocalDataMountItem(i, readableMap);
    }

    @DoNotStrip
    private MountItem updateStateMountItem(int i, Object obj) {
        return new UpdateStateMountItem(i, (StateWrapper) obj);
    }

    @DoNotStrip
    private MountItem updateEventEmitterMountItem(int i, Object obj) {
        return new UpdateEventEmitterMountItem(i, (EventEmitterWrapper) obj);
    }

    @DoNotStrip
    private MountItem createBatchMountItem(MountItem[] mountItemArr, int i) {
        return new BatchMountItem(mountItemArr, i);
    }

    @DoNotStrip
    private long measure(String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, float f3, float f4, float f5) {
        return this.mMountingManager.measure(this.mReactApplicationContext, str, readableMap, readableMap2, readableMap3, LayoutMetricsConversions.getYogaSize(f2, f3), LayoutMetricsConversions.getYogaMeasureMode(f2, f3), LayoutMetricsConversions.getYogaSize(f4, f5), LayoutMetricsConversions.getYogaMeasureMode(f4, f5));
    }

    public void synchronouslyUpdateViewOnUIThread(int i, ReadableMap readableMap) {
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            scheduleMountItems(updatePropsMountItem(i, readableMap), uptimeMillis, 0, uptimeMillis, uptimeMillis);
        } catch (Exception unused) {
        }
    }

    @DoNotStrip
    private void scheduleMountItems(MountItem mountItem, long j, long j2, long j3, long j4) {
        this.mCommitStartTime = j;
        this.mLayoutTime = j2;
        this.mFinishTransactionCPPTime = j4 - j3;
        this.mFinishTransactionTime = SystemClock.uptimeMillis() - j3;
        this.mDispatchViewUpdatesTime = SystemClock.uptimeMillis();
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(mountItem);
        }
        if (UiThreadUtil.isOnUiThread()) {
            dispatchMountItems();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r7.mPreMountItems.isEmpty() != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r0 = r7.mPreMountItems;
        r7.mPreMountItems = new java.util.ArrayDeque<>(PRE_MOUNT_ITEMS_INITIAL_SIZE_ARRAY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r0 == null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        com.facebook.systrace.Systrace.beginSection(0, "FabricUIManager::mountViews preMountItems to execute: " + r0.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0055, code lost:
        if (r0.isEmpty() != false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        r0.pollFirst().execute(r7.mMountingManager);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        com.facebook.systrace.Systrace.endSection(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        com.facebook.systrace.Systrace.beginSection(0, "FabricUIManager::mountViews mountItems to execute: " + r1.size());
        r4 = android.os.SystemClock.uptimeMillis();
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        if (r0.hasNext() == false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008c, code lost:
        r0.next().execute(r7.mMountingManager);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0098, code lost:
        r7.mBatchedExecutionTime = android.os.SystemClock.uptimeMillis() - r4;
        com.facebook.systrace.Systrace.endSection(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a2, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        r0 = null;
        r2 = r7.mPreMountItemsLock;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchMountItems() {
        /*
            r7 = this;
            long r0 = android.os.SystemClock.uptimeMillis()
            r7.mRunStartTime = r0
            java.lang.Object r0 = r7.mMountItemsLock
            monitor-enter(r0)
            java.util.List<com.facebook.react.fabric.mounting.mountitems.MountItem> r1 = r7.mMountItems     // Catch:{ all -> 0x00a6 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            return
        L_0x0013:
            java.util.List<com.facebook.react.fabric.mounting.mountitems.MountItem> r1 = r7.mMountItems     // Catch:{ all -> 0x00a6 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00a6 }
            r2.<init>()     // Catch:{ all -> 0x00a6 }
            r7.mMountItems = r2     // Catch:{ all -> 0x00a6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            r0 = 0
            java.lang.Object r2 = r7.mPreMountItemsLock
            monitor-enter(r2)
            java.util.ArrayDeque<com.facebook.react.fabric.mounting.mountitems.MountItem> r3 = r7.mPreMountItems     // Catch:{ all -> 0x00a3 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00a3 }
            if (r3 != 0) goto L_0x0034
            java.util.ArrayDeque<com.facebook.react.fabric.mounting.mountitems.MountItem> r0 = r7.mPreMountItems     // Catch:{ all -> 0x00a3 }
            java.util.ArrayDeque r3 = new java.util.ArrayDeque     // Catch:{ all -> 0x00a3 }
            r4 = 250(0xfa, float:3.5E-43)
            r3.<init>(r4)     // Catch:{ all -> 0x00a3 }
            r7.mPreMountItems = r3     // Catch:{ all -> 0x00a3 }
        L_0x0034:
            monitor-exit(r2)     // Catch:{ all -> 0x00a3 }
            r2 = 0
            if (r0 == 0) goto L_0x0066
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "FabricUIManager::mountViews preMountItems to execute: "
            r4.append(r5)
            int r5 = r0.size()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.facebook.systrace.Systrace.beginSection(r2, r4)
        L_0x0051:
            boolean r4 = r0.isEmpty()
            if (r4 != 0) goto L_0x0063
            java.lang.Object r4 = r0.pollFirst()
            com.facebook.react.fabric.mounting.mountitems.MountItem r4 = (com.facebook.react.fabric.mounting.mountitems.MountItem) r4
            com.facebook.react.fabric.mounting.MountingManager r5 = r7.mMountingManager
            r4.execute(r5)
            goto L_0x0051
        L_0x0063:
            com.facebook.systrace.Systrace.endSection(r2)
        L_0x0066:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "FabricUIManager::mountViews mountItems to execute: "
            r0.append(r4)
            int r4 = r1.size()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.facebook.systrace.Systrace.beginSection(r2, r0)
            long r4 = android.os.SystemClock.uptimeMillis()
            java.util.Iterator r0 = r1.iterator()
        L_0x0086:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0098
            java.lang.Object r1 = r0.next()
            com.facebook.react.fabric.mounting.mountitems.MountItem r1 = (com.facebook.react.fabric.mounting.mountitems.MountItem) r1
            com.facebook.react.fabric.mounting.MountingManager r6 = r7.mMountingManager
            r1.execute(r6)
            goto L_0x0086
        L_0x0098:
            long r0 = android.os.SystemClock.uptimeMillis()
            long r0 = r0 - r4
            r7.mBatchedExecutionTime = r0
            com.facebook.systrace.Systrace.endSection(r2)
            return
        L_0x00a3:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00a3 }
            throw r0
        L_0x00a6:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a6 }
            goto L_0x00aa
        L_0x00a9:
            throw r1
        L_0x00aa:
            goto L_0x00a9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.fabric.FabricUIManager.dispatchMountItems():void");
    }

    /* access modifiers changed from: private */
    public void dispatchPreMountItems(long j) {
        MountItem pollFirst;
        Systrace.beginSection(0, "FabricUIManager::premountViews");
        while (true) {
            if (16 - ((System.nanoTime() - j) / JobManager.NS_PER_MS) < 8) {
                break;
            }
            synchronized (this.mPreMountItemsLock) {
                if (!this.mPreMountItems.isEmpty()) {
                    pollFirst = this.mPreMountItems.pollFirst();
                }
            }
            pollFirst.execute(this.mMountingManager);
        }
        Systrace.endSection(0);
    }

    public void setBinding(Binding binding) {
        this.mBinding = binding;
    }

    public void updateRootLayoutSpecs(int i, int i2, int i3) {
        this.mBinding.setConstraints(i, LayoutMetricsConversions.getMinSize(i2), LayoutMetricsConversions.getMaxSize(i2), LayoutMetricsConversions.getMinSize(i3), LayoutMetricsConversions.getMaxSize(i3));
    }

    public void receiveEvent(int i, String str, WritableMap writableMap) {
        EventEmitterWrapper eventEmitter = this.mMountingManager.getEventEmitter(i);
        if (eventEmitter == null) {
            String str2 = TAG;
            FLog.d(str2, "Unable to invoke event: " + str + " for reactTag: " + i);
            return;
        }
        eventEmitter.invoke(str, writableMap);
    }

    public void onHostResume() {
        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    public void onHostPause() {
        ReactChoreographer.getInstance().removeFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    public void dispatchCommand(int i, int i2, ReadableArray readableArray) {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new DispatchCommandMountItem(i, i2, readableArray));
        }
    }

    public Map<String, Long> getPerformanceCounters() {
        HashMap hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.mCommitStartTime));
        hashMap.put("LayoutTime", Long.valueOf(this.mLayoutTime));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mDispatchViewUpdatesTime));
        hashMap.put("RunStartTime", Long.valueOf(this.mRunStartTime));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.mBatchedExecutionTime));
        hashMap.put("FinishFabricTransactionTime", Long.valueOf(this.mFinishTransactionTime));
        hashMap.put("FinishFabricTransactionCPPTime", Long.valueOf(this.mFinishTransactionCPPTime));
        return hashMap;
    }

    private class DispatchUIFrameCallback extends GuardedFrameCallback {
        private DispatchUIFrameCallback(ReactContext reactContext) {
            super(reactContext);
        }

        public void doFrameGuarded(long j) {
            if (!FabricUIManager.this.mIsMountingEnabled) {
                FLog.w(ReactConstants.TAG, "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            try {
                FabricUIManager.this.dispatchPreMountItems(j);
                FabricUIManager.this.dispatchMountItems();
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
            } catch (Exception e2) {
                FLog.i(ReactConstants.TAG, "Exception thrown when executing UIFrameGuarded", (Throwable) e2);
                boolean unused = FabricUIManager.this.mIsMountingEnabled = false;
                throw e2;
            } catch (Throwable th) {
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
                throw th;
            }
        }
    }
}
