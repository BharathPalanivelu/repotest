package com.shopee.live.livestreaming.data.cache;

import android.content.SharedPreferences;
import com.shopee.live.livestreaming.data.entity.LiveStreamingData;
import com.shopee.sdk.e.a;

public class LiveStreamingCache extends a<LiveStreamingData> {
    public LiveStreamingCache(SharedPreferences sharedPreferences, int i) {
        super(sharedPreferences, i, LiveStreamingData.class);
    }
}
