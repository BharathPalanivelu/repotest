package com.path.android.jobqueue.persistentQueue.sqlite;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class QueryCache {
    private static final String KEY_EMPTY_WITHOUT_NETWORK = "wo_n";
    private static final String KEY_EMPTY_WITH_NETWORK = "w_n";
    private final Map<String, String> cache = new HashMap();
    private final StringBuilder reusedBuilder = new StringBuilder();

    public synchronized String get(boolean z, Collection<String> collection) {
        return this.cache.get(cacheKey(z, collection));
    }

    public synchronized void set(String str, boolean z, Collection<String> collection) {
        this.cache.put(cacheKey(z, collection), str);
    }

    private String cacheKey(boolean z, Collection<String> collection) {
        if (collection == null || collection.size() == 0) {
            return z ? KEY_EMPTY_WITH_NETWORK : KEY_EMPTY_WITHOUT_NETWORK;
        }
        this.reusedBuilder.setLength(0);
        this.reusedBuilder.append(z ? "X" : "Y");
        for (String append : collection) {
            StringBuilder sb = this.reusedBuilder;
            sb.append("-");
            sb.append(append);
        }
        return this.reusedBuilder.toString();
    }

    public synchronized void clear() {
        this.cache.clear();
    }
}
