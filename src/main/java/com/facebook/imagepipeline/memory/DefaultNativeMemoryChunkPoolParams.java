package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.util.ByteConstants;
import com.facebook.internal.NativeProtocol;
import com.tencent.imsdk.TIMGroupManager;
import tencent.tls.platform.SigType;

public class DefaultNativeMemoryChunkPoolParams {
    private static final int LARGE_BUCKET_LENGTH = 2;
    private static final int SMALL_BUCKET_LENGTH = 5;

    public static PoolParams get() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(1024, 5);
        sparseIntArray.put(2048, 5);
        sparseIntArray.put(4096, 5);
        sparseIntArray.put(8192, 5);
        sparseIntArray.put(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE, 5);
        sparseIntArray.put(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_LAST_MSG, 5);
        sparseIntArray.put(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 5);
        sparseIntArray.put(131072, 5);
        sparseIntArray.put(SigType.D2, 2);
        sparseIntArray.put(524288, 2);
        sparseIntArray.put(ByteConstants.MB, 2);
        return new PoolParams(getMaxSizeSoftCap(), getMaxSizeHardCap(), sparseIntArray);
    }

    private static int getMaxSizeSoftCap() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return 3145728;
        }
        return min < 33554432 ? 6291456 : 12582912;
    }

    private static int getMaxSizeHardCap() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return min / 2;
        }
        return (min / 4) * 3;
    }
}
