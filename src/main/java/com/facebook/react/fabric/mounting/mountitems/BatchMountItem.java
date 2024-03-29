package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.systrace.Systrace;

@DoNotStrip
public class BatchMountItem implements MountItem {
    private final MountItem[] mMountItems;
    private final int mSize;

    public BatchMountItem(MountItem[] mountItemArr, int i) {
        if (mountItemArr == null) {
            throw new NullPointerException();
        } else if (i < 0 || i > mountItemArr.length) {
            throw new IllegalArgumentException("Invalid size received by parameter size: " + i + " items.size = " + mountItemArr.length);
        } else {
            this.mMountItems = mountItemArr;
            this.mSize = i;
        }
    }

    public void execute(MountingManager mountingManager) {
        Systrace.beginSection(0, "FabricUIManager::mountViews - " + this.mSize + " items");
        for (int i = 0; i < this.mSize; i++) {
            MountItem mountItem = this.mMountItems[i];
            if (FabricUIManager.DEBUG) {
                String str = FabricUIManager.TAG;
                FLog.d(str, "Executing mountItem: " + mountItem);
            }
            mountItem.execute(mountingManager);
        }
        Systrace.endSection(0);
    }

    public String toString() {
        return "BatchMountItem - size " + this.mMountItems.length;
    }
}
