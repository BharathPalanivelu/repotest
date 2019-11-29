package com.shopee.app.data.viewmodel;

import java.util.List;

public class VariationData {
    public final boolean isEditMode;
    public final long maxPrice;
    public final int maxStock;
    public final long minPrice;
    public final int minStock;
    public final List<ModelDetail> models;
    public final List<Variation> variations;

    public VariationData(List<Variation> list, List<ModelDetail> list2, long j, long j2, int i, int i2, boolean z) {
        this.variations = list;
        this.models = list2;
        this.maxPrice = j;
        this.minPrice = j2;
        this.maxStock = i;
        this.minStock = i2;
        this.isEditMode = z;
    }
}
