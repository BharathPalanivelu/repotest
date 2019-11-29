package iyegoroff.RNTextGradient;

import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.react.views.text.ReactRawTextShadowNode;
import com.facebook.react.views.text.ReactTextInlineImageShadowNode;
import com.facebook.react.views.text.ReactTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class RNShadowTextGradient extends ReactTextShadowNode {
    private static final String sSpannableField = "mPreparedSpannableText";
    protected int[] mColors;
    private WeakReference<ReactApplicationContext> mContext;
    protected float[] mLocations;
    protected boolean mUseViewFrame;

    /* access modifiers changed from: protected */
    public abstract RNSetGradientSpanOperation createSpan(SpannableStringBuilder spannableStringBuilder, int i, int i2, float f2, float f3, Layout layout);

    private static class TextChangeListener extends OneOffListener implements TextWatcher {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        TextChangeListener(Runnable runnable) {
            super(runnable);
        }

        public void afterTextChanged(Editable editable) {
            trigger();
        }
    }

    private static class LayoutChangeListener extends OneOffListener implements View.OnLayoutChangeListener {
        LayoutChangeListener(Runnable runnable) {
            super(runnable);
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            trigger();
        }
    }

    public RNShadowTextGradient(ReactApplicationContext reactApplicationContext) {
        this.mContext = new WeakReference<>(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    public View resolveView(int i) {
        UiThreadUtil.assertOnUiThread();
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.mContext.get();
        if (reactApplicationContext != null) {
            NativeViewHierarchyManager nativeViewHierarchyManager = (NativeViewHierarchyManager) ReflectUtils.getFieldValue(ReflectUtils.getFieldValue(((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).getUIImplementation(), "mOperationsQueue", (Class) null), "mNativeViewHierarchyManager", (Class) null);
            if (nativeViewHierarchyManager != null) {
                return nativeViewHierarchyManager.resolveView(i);
            }
        }
        return null;
    }

    @ReactProp(name = "locations")
    public void setLocations(ReadableArray readableArray) {
        if (readableArray != null) {
            float[] fArr = new float[readableArray.size()];
            for (int i = 0; i < fArr.length; i++) {
                fArr[i] = (float) readableArray.getDouble(i);
            }
            this.mLocations = fArr;
        } else {
            this.mLocations = null;
        }
        markUpdated();
    }

    @ReactProp(name = "colors")
    public void setColors(ReadableArray readableArray) {
        if (readableArray != null) {
            int[] iArr = new int[readableArray.size()];
            for (int i = 0; i < iArr.length; i++) {
                iArr[i] = readableArray.getInt(i);
            }
            this.mColors = iArr;
        } else {
            this.mColors = null;
        }
        markUpdated();
    }

    @ReactProp(name = "useViewFrame")
    public void setUseViewFrame(boolean z) {
        this.mUseViewFrame = z;
        markUpdated();
    }

    public boolean dispatchUpdates(float f2, float f3, UIViewOperationQueue uIViewOperationQueue, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        boolean dispatchUpdates = super.dispatchUpdates(f2, f3, uIViewOperationQueue, nativeViewHierarchyOptimizer);
        if (dispatchUpdates) {
            markUpdated();
        }
        return dispatchUpdates;
    }

    /* access modifiers changed from: private */
    public Spannable updatedSpannable(Layout layout) {
        return spannableWithGradient(getSpannable(), this, getLayoutWidth(), getLayoutHeight(), layout);
    }

    private Spannable getSpannable() {
        return (Spannable) ReflectUtils.getFieldValue(this, sSpannableField, ReactTextShadowNode.class);
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        uIViewOperationQueue.enqueueUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                final RNTextGradient rNTextGradient = (RNTextGradient) this.resolveView(RNShadowTextGradient.this.getReactTag());
                if (rNTextGradient != null) {
                    Layout layout = rNTextGradient.getLayout();
                    if (layout != null) {
                        rNTextGradient.setText(new ReactTextUpdate(this.updatedSpannable(layout), -1, this.mContainsImages, this.getPadding(4), this.getPadding(1), this.getPadding(5), this.getPadding(3), ((Integer) ReflectUtils.invokeMethod(this, "getTextAlign", ReactTextShadowNode.class)).intValue(), this.mTextBreakStrategy, this.mJustificationMode));
                    }
                    AnonymousClass1 r0 = new Runnable() {
                        public void run() {
                            AnonymousClass1 r0 = new Runnable() {
                                public void run() {
                                    rNTextGradient.setText(new ReactTextUpdate(this.updatedSpannable(rNTextGradient.getLayout()), -1, this.mContainsImages, this.getPadding(4), this.getPadding(1), this.getPadding(5), this.getPadding(3), ((Integer) ReflectUtils.invokeMethod(this, "getTextAlign", ReactTextShadowNode.class)).intValue(), this.mTextBreakStrategy, this.mJustificationMode));
                                }
                            };
                            if (rNTextGradient.getLayout() != null) {
                                r0.run();
                            } else {
                                UiThreadUtil.runOnUiThread(r0);
                            }
                        }
                    };
                    final LayoutChangeListener layoutChangeListener = new LayoutChangeListener(r0);
                    rNTextGradient.addOnLayoutChangeListener(layoutChangeListener);
                    layoutChangeListener.addRemoval(new Runnable() {
                        public void run() {
                            rNTextGradient.removeOnLayoutChangeListener(layoutChangeListener);
                        }
                    });
                    final TextChangeListener textChangeListener = new TextChangeListener(r0);
                    rNTextGradient.addTextChangedListener(textChangeListener);
                    textChangeListener.addRemoval(new Runnable() {
                        public void run() {
                            rNTextGradient.removeTextChangedListener(textChangeListener);
                        }
                    });
                }
            }
        });
        super.onCollectExtraUpdates(uIViewOperationQueue);
    }

    private static Spannable spannableWithGradient(Spannable spannable, RNShadowTextGradient rNShadowTextGradient, float f2, float f3, Layout layout) {
        ArrayList arrayList = new ArrayList();
        buildSpannedGradientFromTextCSSNode(rNShadowTextGradient, new SpannableStringBuilder(), arrayList, f2, f3, layout);
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((RNSetGradientSpanOperation) arrayList.get(size)).execute((SpannableStringBuilder) spannable);
        }
        return spannable;
    }

    private static void buildSpannedGradientFromTextCSSNode(ReactBaseTextShadowNode reactBaseTextShadowNode, SpannableStringBuilder spannableStringBuilder, List<RNSetGradientSpanOperation> list, float f2, float f3, Layout layout) {
        int length = spannableStringBuilder.length();
        for (int i = 0; i < reactBaseTextShadowNode.getChildCount(); i++) {
            ReactShadowNodeImpl childAt = reactBaseTextShadowNode.getChildAt(i);
            if (childAt instanceof ReactRawTextShadowNode) {
                spannableStringBuilder.append(((ReactRawTextShadowNode) childAt).getText());
            } else if (childAt instanceof ReactBaseTextShadowNode) {
                buildSpannedGradientFromTextCSSNode((ReactBaseTextShadowNode) childAt, spannableStringBuilder, list, f2, f3, layout);
            } else if (childAt instanceof ReactTextInlineImageShadowNode) {
                spannableStringBuilder.append((String) ReflectUtils.getFieldValue(reactBaseTextShadowNode, "INLINE_IMAGE_PLACEHOLDER", ReactTextShadowNode.class));
            }
            childAt.markUpdateSeen();
        }
        int length2 = spannableStringBuilder.length();
        if (length2 >= length && (reactBaseTextShadowNode instanceof RNShadowTextGradient)) {
            list.add(((RNShadowTextGradient) reactBaseTextShadowNode).createSpan(spannableStringBuilder, length, length2, f2, f3, layout));
        }
    }
}
