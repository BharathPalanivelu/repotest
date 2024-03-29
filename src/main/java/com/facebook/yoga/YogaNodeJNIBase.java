package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import java.util.ArrayList;
import java.util.List;

@DoNotStrip
public abstract class YogaNodeJNIBase extends YogaNode implements Cloneable {
    private YogaBaselineFunction mBaselineFunction;
    private List<YogaNodeJNIBase> mChildren;
    private Object mData;
    private YogaMeasureFunction mMeasureFunction;
    private long mNativePointer;
    private YogaNodeJNIBase mOwner;

    public abstract boolean getDoesLegacyStretchFlagAffectsLayout();

    public YogaNodeJNIBase() {
        this.mNativePointer = YogaNative.jni_YGNodeNew(YogaConfig.useBatchingForLayoutOutputs);
        if (this.mNativePointer == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    public YogaNodeJNIBase(YogaConfig yogaConfig) {
        this.mNativePointer = YogaNative.jni_YGNodeNewWithConfig(yogaConfig.mNativePointer, YogaConfig.useBatchingForLayoutOutputs);
        if (this.mNativePointer == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            freeNatives();
        } finally {
            super.finalize();
        }
    }

    public void freeNatives() {
        long j = this.mNativePointer;
        if (j > 0) {
            this.mNativePointer = 0;
            YogaNative.jni_YGNodeFree(j);
        }
    }

    public void reset() {
        this.mMeasureFunction = null;
        this.mBaselineFunction = null;
        this.mData = null;
        YogaNative.jni_YGNodeReset(this.mNativePointer);
    }

    public int getChildCount() {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public YogaNodeJNIBase getChildAt(int i) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            return list.get(i);
        }
        throw new IllegalStateException("YogaNode does not have children");
    }

    public void addChildAt(YogaNode yogaNode, int i) {
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
        if (yogaNodeJNIBase.mOwner == null) {
            if (this.mChildren == null) {
                this.mChildren = new ArrayList(4);
            }
            this.mChildren.add(i, yogaNodeJNIBase);
            yogaNodeJNIBase.mOwner = this;
            YogaNative.jni_YGNodeInsertChild(this.mNativePointer, yogaNodeJNIBase.mNativePointer, i);
            return;
        }
        throw new IllegalStateException("Child already has a parent, it must be removed first.");
    }

    public void setIsReferenceBaseline(boolean z) {
        YogaNative.jni_YGNodeSetIsReferenceBaseline(this.mNativePointer, z);
    }

    public boolean isReferenceBaseline() {
        return YogaNative.jni_YGNodeIsReferenceBaseline(this.mNativePointer);
    }

    public YogaNodeJNIBase cloneWithoutChildren() {
        try {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) super.clone();
            long jni_YGNodeClone = YogaNative.jni_YGNodeClone(this.mNativePointer);
            yogaNodeJNIBase.mOwner = null;
            yogaNodeJNIBase.mNativePointer = jni_YGNodeClone;
            yogaNodeJNIBase.clearChildren();
            return yogaNodeJNIBase;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void clearChildren() {
        this.mChildren = null;
        YogaNative.jni_YGNodeClearChildren(this.mNativePointer);
    }

    public YogaNodeJNIBase removeChildAt(int i) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            YogaNodeJNIBase remove = list.remove(i);
            remove.mOwner = null;
            YogaNative.jni_YGNodeRemoveChild(this.mNativePointer, remove.mNativePointer);
            return remove;
        }
        throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
    }

    public YogaNodeJNIBase getOwner() {
        return this.mOwner;
    }

    @Deprecated
    public YogaNodeJNIBase getParent() {
        return getOwner();
    }

    public int indexOf(YogaNode yogaNode) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list == null) {
            return -1;
        }
        return list.indexOf(yogaNode);
    }

    public void calculateLayout(float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i)).mChildren;
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i2 = 0; i2 < yogaNodeJNIBaseArr.length; i2++) {
            jArr[i2] = yogaNodeJNIBaseArr[i2].mNativePointer;
        }
        YogaNative.jni_YGNodeCalculateLayout(this.mNativePointer, f2, f3, jArr, yogaNodeJNIBaseArr);
    }

    public void dirty() {
        YogaNative.jni_YGNodeMarkDirty(this.mNativePointer);
    }

    public void dirtyAllDescendants() {
        YogaNative.jni_YGNodeMarkDirtyAndPropogateToDescendants(this.mNativePointer);
    }

    public boolean isDirty() {
        return YogaNative.jni_YGNodeIsDirty(this.mNativePointer);
    }

    public void copyStyle(YogaNode yogaNode) {
        YogaNative.jni_YGNodeCopyStyle(this.mNativePointer, ((YogaNodeJNIBase) yogaNode).mNativePointer);
    }

    public YogaDirection getStyleDirection() {
        return YogaDirection.fromInt(YogaNative.jni_YGNodeStyleGetDirection(this.mNativePointer));
    }

    public void setDirection(YogaDirection yogaDirection) {
        YogaNative.jni_YGNodeStyleSetDirection(this.mNativePointer, yogaDirection.intValue());
    }

    public YogaFlexDirection getFlexDirection() {
        return YogaFlexDirection.fromInt(YogaNative.jni_YGNodeStyleGetFlexDirection(this.mNativePointer));
    }

    public void setFlexDirection(YogaFlexDirection yogaFlexDirection) {
        YogaNative.jni_YGNodeStyleSetFlexDirection(this.mNativePointer, yogaFlexDirection.intValue());
    }

    public YogaJustify getJustifyContent() {
        return YogaJustify.fromInt(YogaNative.jni_YGNodeStyleGetJustifyContent(this.mNativePointer));
    }

    public void setJustifyContent(YogaJustify yogaJustify) {
        YogaNative.jni_YGNodeStyleSetJustifyContent(this.mNativePointer, yogaJustify.intValue());
    }

    public YogaAlign getAlignItems() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignItems(this.mNativePointer));
    }

    public void setAlignItems(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignItems(this.mNativePointer, yogaAlign.intValue());
    }

    public YogaAlign getAlignSelf() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignSelf(this.mNativePointer));
    }

    public void setAlignSelf(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignSelf(this.mNativePointer, yogaAlign.intValue());
    }

    public YogaAlign getAlignContent() {
        return YogaAlign.fromInt(YogaNative.jni_YGNodeStyleGetAlignContent(this.mNativePointer));
    }

    public void setAlignContent(YogaAlign yogaAlign) {
        YogaNative.jni_YGNodeStyleSetAlignContent(this.mNativePointer, yogaAlign.intValue());
    }

    public YogaPositionType getPositionType() {
        return YogaPositionType.fromInt(YogaNative.jni_YGNodeStyleGetPositionType(this.mNativePointer));
    }

    public void setPositionType(YogaPositionType yogaPositionType) {
        YogaNative.jni_YGNodeStyleSetPositionType(this.mNativePointer, yogaPositionType.intValue());
    }

    public YogaWrap getWrap() {
        return YogaWrap.fromInt(YogaNative.jni_YGNodeStyleGetFlexWrap(this.mNativePointer));
    }

    public void setWrap(YogaWrap yogaWrap) {
        YogaNative.jni_YGNodeStyleSetFlexWrap(this.mNativePointer, yogaWrap.intValue());
    }

    public YogaOverflow getOverflow() {
        return YogaOverflow.fromInt(YogaNative.jni_YGNodeStyleGetOverflow(this.mNativePointer));
    }

    public void setOverflow(YogaOverflow yogaOverflow) {
        YogaNative.jni_YGNodeStyleSetOverflow(this.mNativePointer, yogaOverflow.intValue());
    }

    public YogaDisplay getDisplay() {
        return YogaDisplay.fromInt(YogaNative.jni_YGNodeStyleGetDisplay(this.mNativePointer));
    }

    public void setDisplay(YogaDisplay yogaDisplay) {
        YogaNative.jni_YGNodeStyleSetDisplay(this.mNativePointer, yogaDisplay.intValue());
    }

    public float getFlex() {
        return YogaNative.jni_YGNodeStyleGetFlex(this.mNativePointer);
    }

    public void setFlex(float f2) {
        YogaNative.jni_YGNodeStyleSetFlex(this.mNativePointer, f2);
    }

    public float getFlexGrow() {
        return YogaNative.jni_YGNodeStyleGetFlexGrow(this.mNativePointer);
    }

    public void setFlexGrow(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexGrow(this.mNativePointer, f2);
    }

    public float getFlexShrink() {
        return YogaNative.jni_YGNodeStyleGetFlexShrink(this.mNativePointer);
    }

    public void setFlexShrink(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexShrink(this.mNativePointer, f2);
    }

    public YogaValue getFlexBasis() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetFlexBasis(this.mNativePointer));
    }

    public void setFlexBasis(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexBasis(this.mNativePointer, f2);
    }

    public void setFlexBasisPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetFlexBasisPercent(this.mNativePointer, f2);
    }

    public void setFlexBasisAuto() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAuto(this.mNativePointer);
    }

    public YogaValue getMargin(YogaEdge yogaEdge) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMargin(this.mNativePointer, yogaEdge.intValue()));
    }

    public void setMargin(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetMargin(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public void setMarginPercent(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetMarginPercent(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public void setMarginAuto(YogaEdge yogaEdge) {
        YogaNative.jni_YGNodeStyleSetMarginAuto(this.mNativePointer, yogaEdge.intValue());
    }

    public YogaValue getPadding(YogaEdge yogaEdge) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetPadding(this.mNativePointer, yogaEdge.intValue()));
    }

    public void setPadding(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPadding(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public void setPaddingPercent(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPaddingPercent(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public float getBorder(YogaEdge yogaEdge) {
        return YogaNative.jni_YGNodeStyleGetBorder(this.mNativePointer, yogaEdge.intValue());
    }

    public void setBorder(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetBorder(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public YogaValue getPosition(YogaEdge yogaEdge) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetPosition(this.mNativePointer, yogaEdge.intValue()));
    }

    public void setPosition(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPosition(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public void setPositionPercent(YogaEdge yogaEdge, float f2) {
        YogaNative.jni_YGNodeStyleSetPositionPercent(this.mNativePointer, yogaEdge.intValue(), f2);
    }

    public YogaValue getWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetWidth(this.mNativePointer));
    }

    public void setWidth(float f2) {
        YogaNative.jni_YGNodeStyleSetWidth(this.mNativePointer, f2);
    }

    public void setWidthPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetWidthPercent(this.mNativePointer, f2);
    }

    public void setWidthAuto() {
        YogaNative.jni_YGNodeStyleSetWidthAuto(this.mNativePointer);
    }

    public YogaValue getHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetHeight(this.mNativePointer));
    }

    public void setHeight(float f2) {
        YogaNative.jni_YGNodeStyleSetHeight(this.mNativePointer, f2);
    }

    public void setHeightPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetHeightPercent(this.mNativePointer, f2);
    }

    public void setHeightAuto() {
        YogaNative.jni_YGNodeStyleSetHeightAuto(this.mNativePointer);
    }

    public YogaValue getMinWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMinWidth(this.mNativePointer));
    }

    public void setMinWidth(float f2) {
        YogaNative.jni_YGNodeStyleSetMinWidth(this.mNativePointer, f2);
    }

    public void setMinWidthPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetMinWidthPercent(this.mNativePointer, f2);
    }

    public YogaValue getMinHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMinHeight(this.mNativePointer));
    }

    public void setMinHeight(float f2) {
        YogaNative.jni_YGNodeStyleSetMinHeight(this.mNativePointer, f2);
    }

    public void setMinHeightPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetMinHeightPercent(this.mNativePointer, f2);
    }

    public YogaValue getMaxWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxWidth(this.mNativePointer));
    }

    public void setMaxWidth(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxWidth(this.mNativePointer, f2);
    }

    public void setMaxWidthPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxWidthPercent(this.mNativePointer, f2);
    }

    public YogaValue getMaxHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxHeight(this.mNativePointer));
    }

    public void setMaxHeight(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxHeight(this.mNativePointer, f2);
    }

    public void setMaxHeightPercent(float f2) {
        YogaNative.jni_YGNodeStyleSetMaxHeightPercent(this.mNativePointer, f2);
    }

    public float getAspectRatio() {
        return YogaNative.jni_YGNodeStyleGetAspectRatio(this.mNativePointer);
    }

    public void setAspectRatio(float f2) {
        YogaNative.jni_YGNodeStyleSetAspectRatio(this.mNativePointer, f2);
    }

    public void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction) {
        this.mMeasureFunction = yogaMeasureFunction;
        YogaNative.jni_YGNodeSetHasMeasureFunc(this.mNativePointer, yogaMeasureFunction != null);
    }

    @DoNotStrip
    public final long measure(float f2, int i, float f3, int i2) {
        if (isMeasureDefined()) {
            return this.mMeasureFunction.measure(this, f2, YogaMeasureMode.fromInt(i), f3, YogaMeasureMode.fromInt(i2));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    public void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction) {
        this.mBaselineFunction = yogaBaselineFunction;
        YogaNative.jni_YGNodeSetHasBaselineFunc(this.mNativePointer, yogaBaselineFunction != null);
    }

    @DoNotStrip
    public final float baseline(float f2, float f3) {
        return this.mBaselineFunction.baseline(this, f2, f3);
    }

    public boolean isMeasureDefined() {
        return this.mMeasureFunction != null;
    }

    public boolean isBaselineDefined() {
        return this.mBaselineFunction != null;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public Object getData() {
        return this.mData;
    }

    public void print() {
        YogaNative.jni_YGNodePrint(this.mNativePointer);
    }

    public void setStyleInputs(float[] fArr, int i) {
        YogaNative.jni_YGNodeSetStyleInputs(this.mNativePointer, fArr, i);
    }

    @DoNotStrip
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            list.remove(i);
            this.mChildren.add(i, yogaNodeJNIBase);
            yogaNodeJNIBase.mOwner = this;
            return yogaNodeJNIBase.mNativePointer;
        }
        throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
    }

    private static YogaValue valueFromLong(long j) {
        return new YogaValue(Float.intBitsToFloat((int) j), (int) (j >> 32));
    }
}
