package com.facebook.react.animated;

import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

class NativeAnimatedNodesManager implements EventDispatcherListener {
    private final SparseArray<AnimationDriver> mActiveAnimations = new SparseArray<>();
    private int mAnimatedGraphBFSColor = 0;
    private final SparseArray<AnimatedNode> mAnimatedNodes = new SparseArray<>();
    private final UIManagerModule.CustomEventNamesResolver mCustomEventNamesResolver;
    private final Map<String, List<EventAnimationDriver>> mEventDrivers = new HashMap();
    private final List<AnimatedNode> mRunUpdateNodeList = new LinkedList();
    private final UIManagerModule mUIManagerModule;
    private final SparseArray<AnimatedNode> mUpdatedNodes = new SparseArray<>();

    public NativeAnimatedNodesManager(UIManagerModule uIManagerModule) {
        this.mUIManagerModule = uIManagerModule;
        uIManagerModule.getEventDispatcher().addListener(this);
        this.mCustomEventNamesResolver = uIManagerModule.getDirectEventNamesResolver();
    }

    /* access modifiers changed from: package-private */
    public AnimatedNode getNodeById(int i) {
        return this.mAnimatedNodes.get(i);
    }

    public boolean hasActiveAnimations() {
        return this.mActiveAnimations.size() > 0 || this.mUpdatedNodes.size() > 0;
    }

    public void createAnimatedNode(int i, ReadableMap readableMap) {
        AnimatedNode animatedNode;
        if (this.mAnimatedNodes.get(i) == null) {
            String string = readableMap.getString("type");
            if (AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.equals(string)) {
                animatedNode = new StyleAnimatedNode(readableMap, this);
            } else if (AppMeasurementSdk.ConditionalUserProperty.VALUE.equals(string)) {
                animatedNode = new ValueAnimatedNode(readableMap);
            } else if ("props".equals(string)) {
                animatedNode = new PropsAnimatedNode(readableMap, this, this.mUIManagerModule);
            } else if ("interpolation".equals(string)) {
                animatedNode = new InterpolationAnimatedNode(readableMap);
            } else if ("addition".equals(string)) {
                animatedNode = new AdditionAnimatedNode(readableMap, this);
            } else if ("subtraction".equals(string)) {
                animatedNode = new SubtractionAnimatedNode(readableMap, this);
            } else if ("division".equals(string)) {
                animatedNode = new DivisionAnimatedNode(readableMap, this);
            } else if ("multiplication".equals(string)) {
                animatedNode = new MultiplicationAnimatedNode(readableMap, this);
            } else if ("modulus".equals(string)) {
                animatedNode = new ModulusAnimatedNode(readableMap, this);
            } else if ("diffclamp".equals(string)) {
                animatedNode = new DiffClampAnimatedNode(readableMap, this);
            } else if ("transform".equals(string)) {
                animatedNode = new TransformAnimatedNode(readableMap, this);
            } else if ("tracking".equals(string)) {
                animatedNode = new TrackingAnimatedNode(readableMap, this);
            } else {
                throw new JSApplicationIllegalArgumentException("Unsupported node type: " + string);
            }
            animatedNode.mTag = i;
            this.mAnimatedNodes.put(i, animatedNode);
            this.mUpdatedNodes.put(i, animatedNode);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " already exists");
    }

    public void dropAnimatedNode(int i) {
        this.mAnimatedNodes.remove(i);
        this.mUpdatedNodes.remove(i);
    }

    public void startListeningToAnimatedNodeValue(int i, AnimatedNodeValueListener animatedNodeValueListener) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode instanceof ValueAnimatedNode) {
            ((ValueAnimatedNode) animatedNode).setValueListener(animatedNodeValueListener);
        }
    }

    public void stopListeningToAnimatedNodeValue(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode instanceof ValueAnimatedNode) {
            ((ValueAnimatedNode) animatedNode).setValueListener((AnimatedNodeValueListener) null);
        }
    }

    public void setAnimatedNodeValue(int i, double d2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode instanceof ValueAnimatedNode) {
            stopAnimationsForNode(animatedNode);
            ((ValueAnimatedNode) animatedNode).mValue = d2;
            this.mUpdatedNodes.put(i, animatedNode);
        }
    }

    public void setAnimatedNodeOffset(int i, double d2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode instanceof ValueAnimatedNode) {
            ((ValueAnimatedNode) animatedNode).mOffset = d2;
            this.mUpdatedNodes.put(i, animatedNode);
        }
    }

    public void flattenAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode instanceof ValueAnimatedNode) {
            ((ValueAnimatedNode) animatedNode).flattenOffset();
        }
    }

    public void extractAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode instanceof ValueAnimatedNode) {
            ((ValueAnimatedNode) animatedNode).extractOffset();
        }
    }

    public void startAnimatingNode(int i, int i2, ReadableMap readableMap, Callback callback) {
        AnimationDriver animationDriver;
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode != null) {
            if (animatedNode instanceof ValueAnimatedNode) {
                AnimationDriver animationDriver2 = this.mActiveAnimations.get(i);
                if (animationDriver2 != null) {
                    animationDriver2.resetConfig(readableMap);
                    return;
                }
                String string = readableMap.getString("type");
                if ("frames".equals(string)) {
                    animationDriver = new FrameBasedAnimationDriver(readableMap);
                } else if ("spring".equals(string)) {
                    animationDriver = new SpringAnimation(readableMap);
                } else if ("decay".equals(string)) {
                    animationDriver = new DecayAnimation(readableMap);
                } else {
                    throw new JSApplicationIllegalArgumentException("Unsupported animation type: " + string);
                }
                animationDriver.mId = i;
                animationDriver.mEndCallback = callback;
                animationDriver.mAnimatedValue = (ValueAnimatedNode) animatedNode;
                this.mActiveAnimations.put(i, animationDriver);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node should be of type " + ValueAnimatedNode.class.getName());
        }
    }

    private void stopAnimationsForNode(AnimatedNode animatedNode) {
        int i = 0;
        while (i < this.mActiveAnimations.size()) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i);
            if (animatedNode.equals(valueAt.mAnimatedValue)) {
                if (valueAt.mEndCallback != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.mEndCallback.invoke(createMap);
                }
                this.mActiveAnimations.removeAt(i);
                i--;
            }
            i++;
        }
    }

    public void stopAnimation(int i) {
        for (int i2 = 0; i2 < this.mActiveAnimations.size(); i2++) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i2);
            if (valueAt.mId == i) {
                if (valueAt.mEndCallback != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.mEndCallback.invoke(createMap);
                }
                this.mActiveAnimations.removeAt(i2);
                return;
            }
        }
    }

    public void connectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            AnimatedNode animatedNode2 = this.mAnimatedNodes.get(i2);
            if (animatedNode2 != null) {
                animatedNode.addChild(animatedNode2);
                this.mUpdatedNodes.put(i2, animatedNode2);
            }
        }
    }

    public void disconnectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            AnimatedNode animatedNode2 = this.mAnimatedNodes.get(i2);
            if (animatedNode2 != null) {
                animatedNode.removeChild(animatedNode2);
                this.mUpdatedNodes.put(i2, animatedNode2);
            }
        }
    }

    public void connectAnimatedNodeToView(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            if (animatedNode instanceof PropsAnimatedNode) {
                ((PropsAnimatedNode) animatedNode).connectToView(i2);
                this.mUpdatedNodes.put(i, animatedNode);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
        }
    }

    public void disconnectAnimatedNodeFromView(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            if (animatedNode instanceof PropsAnimatedNode) {
                ((PropsAnimatedNode) animatedNode).disconnectFromView(i2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
        }
    }

    public void restoreDefaultValues(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            if (animatedNode instanceof PropsAnimatedNode) {
                ((PropsAnimatedNode) animatedNode).restoreDefaultValues();
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
        }
    }

    public void addAnimatedEventToView(int i, String str, ReadableMap readableMap) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(readableMap.getInt("animatedValueTag"));
        if (animatedNode != null) {
            if (animatedNode instanceof ValueAnimatedNode) {
                ReadableArray array = readableMap.getArray("nativeEventPath");
                ArrayList arrayList = new ArrayList(array.size());
                for (int i2 = 0; i2 < array.size(); i2++) {
                    arrayList.add(array.getString(i2));
                }
                EventAnimationDriver eventAnimationDriver = new EventAnimationDriver(arrayList, (ValueAnimatedNode) animatedNode);
                String str2 = i + str;
                if (this.mEventDrivers.containsKey(str2)) {
                    this.mEventDrivers.get(str2).add(eventAnimationDriver);
                    return;
                }
                ArrayList arrayList2 = new ArrayList(1);
                arrayList2.add(eventAnimationDriver);
                this.mEventDrivers.put(str2, arrayList2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node connected to event should beof type " + ValueAnimatedNode.class.getName());
        }
    }

    public void removeAnimatedEventFromView(int i, String str, int i2) {
        String str2 = i + str;
        if (this.mEventDrivers.containsKey(str2)) {
            List list = this.mEventDrivers.get(str2);
            if (list.size() == 1) {
                this.mEventDrivers.remove(i + str);
                return;
            }
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (((EventAnimationDriver) listIterator.next()).mValueNode.mTag == i2) {
                    listIterator.remove();
                    return;
                }
            }
        }
    }

    public void onEventDispatch(final Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    NativeAnimatedNodesManager.this.handleEvent(event);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void handleEvent(Event event) {
        if (!this.mEventDrivers.isEmpty()) {
            String resolveCustomEventName = this.mCustomEventNamesResolver.resolveCustomEventName(event.getEventName());
            Map<String, List<EventAnimationDriver>> map = this.mEventDrivers;
            List<EventAnimationDriver> list = map.get(event.getViewTag() + resolveCustomEventName);
            if (list != null) {
                for (EventAnimationDriver eventAnimationDriver : list) {
                    stopAnimationsForNode(eventAnimationDriver.mValueNode);
                    event.dispatch(eventAnimationDriver);
                    this.mRunUpdateNodeList.add(eventAnimationDriver.mValueNode);
                }
                updateNodes(this.mRunUpdateNodeList);
                this.mRunUpdateNodeList.clear();
            }
        }
    }

    public void runUpdates(long j) {
        UiThreadUtil.assertOnUiThread();
        for (int i = 0; i < this.mUpdatedNodes.size(); i++) {
            this.mRunUpdateNodeList.add(this.mUpdatedNodes.valueAt(i));
        }
        this.mUpdatedNodes.clear();
        boolean z = false;
        for (int i2 = 0; i2 < this.mActiveAnimations.size(); i2++) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i2);
            valueAt.runAnimationStep(j);
            this.mRunUpdateNodeList.add(valueAt.mAnimatedValue);
            if (valueAt.mHasFinished) {
                z = true;
            }
        }
        updateNodes(this.mRunUpdateNodeList);
        this.mRunUpdateNodeList.clear();
        if (z) {
            for (int size = this.mActiveAnimations.size() - 1; size >= 0; size--) {
                AnimationDriver valueAt2 = this.mActiveAnimations.valueAt(size);
                if (valueAt2.mHasFinished) {
                    if (valueAt2.mEndCallback != null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putBoolean("finished", true);
                        valueAt2.mEndCallback.invoke(createMap);
                    }
                    this.mActiveAnimations.removeAt(size);
                }
            }
        }
    }

    private void updateNodes(List<AnimatedNode> list) {
        this.mAnimatedGraphBFSColor++;
        int i = this.mAnimatedGraphBFSColor;
        if (i == 0) {
            this.mAnimatedGraphBFSColor = i + 1;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i2 = 0;
        for (AnimatedNode next : list) {
            int i3 = next.mBFSColor;
            int i4 = this.mAnimatedGraphBFSColor;
            if (i3 != i4) {
                next.mBFSColor = i4;
                i2++;
                arrayDeque.add(next);
            }
        }
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode = (AnimatedNode) arrayDeque.poll();
            if (animatedNode.mChildren != null) {
                int i5 = i2;
                for (int i6 = 0; i6 < animatedNode.mChildren.size(); i6++) {
                    AnimatedNode animatedNode2 = animatedNode.mChildren.get(i6);
                    animatedNode2.mActiveIncomingNodes++;
                    int i7 = animatedNode2.mBFSColor;
                    int i8 = this.mAnimatedGraphBFSColor;
                    if (i7 != i8) {
                        animatedNode2.mBFSColor = i8;
                        i5++;
                        arrayDeque.add(animatedNode2);
                    }
                }
                i2 = i5;
            }
        }
        this.mAnimatedGraphBFSColor++;
        int i9 = this.mAnimatedGraphBFSColor;
        if (i9 == 0) {
            this.mAnimatedGraphBFSColor = i9 + 1;
        }
        int i10 = 0;
        for (AnimatedNode next2 : list) {
            if (next2.mActiveIncomingNodes == 0) {
                int i11 = next2.mBFSColor;
                int i12 = this.mAnimatedGraphBFSColor;
                if (i11 != i12) {
                    next2.mBFSColor = i12;
                    i10++;
                    arrayDeque.add(next2);
                }
            }
        }
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode3 = (AnimatedNode) arrayDeque.poll();
            animatedNode3.update();
            if (animatedNode3 instanceof PropsAnimatedNode) {
                try {
                    ((PropsAnimatedNode) animatedNode3).updateView();
                } catch (IllegalViewOperationException e2) {
                    FLog.e(ReactConstants.TAG, "Native animation workaround, frame lost as result of race condition", (Throwable) e2);
                }
            }
            if (animatedNode3 instanceof ValueAnimatedNode) {
                ((ValueAnimatedNode) animatedNode3).onValueUpdate();
            }
            if (animatedNode3.mChildren != null) {
                int i13 = i10;
                for (int i14 = 0; i14 < animatedNode3.mChildren.size(); i14++) {
                    AnimatedNode animatedNode4 = animatedNode3.mChildren.get(i14);
                    animatedNode4.mActiveIncomingNodes--;
                    if (animatedNode4.mBFSColor != this.mAnimatedGraphBFSColor && animatedNode4.mActiveIncomingNodes == 0) {
                        animatedNode4.mBFSColor = this.mAnimatedGraphBFSColor;
                        i13++;
                        arrayDeque.add(animatedNode4);
                    }
                }
                i10 = i13;
            }
        }
        if (i2 != i10) {
            throw new IllegalStateException("Looks like animated nodes graph has cycles, there are " + i2 + " but toposort visited only " + i10);
        }
    }
}
