package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.salesforce.android.chat.core.model.PreChatField;

public final class zzin extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        String str;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 1);
        Preconditions.checkArgument(!(zzoaArr[0] instanceof zzol));
        Preconditions.checkArgument(true ^ zzoo.zzm(zzoaArr[0]));
        zzog zzog = zzoaArr[0];
        if (zzog == zzog.zzaum) {
            str = "undefined";
        } else if (zzog instanceof zzod) {
            str = "boolean";
        } else if (zzog instanceof zzoe) {
            str = "number";
        } else if (zzog instanceof zzom) {
            str = PreChatField.STRING;
        } else {
            str = zzog instanceof zzof ? "function" : "object";
        }
        return new zzom(str);
    }
}
