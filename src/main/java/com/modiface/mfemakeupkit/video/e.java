package com.modiface.mfemakeupkit.video;

import android.graphics.Rect;
import com.modiface.mfemakeupkit.aa;
import com.modiface.mfemakeupkit.utils.n;
import com.modiface.mfemakeupkit.video.MFEVideoRecordingError;
import java.util.ArrayList;
import java.util.Iterator;

class e extends aa {
    final /* synthetic */ j k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    e(j jVar, boolean z) {
        super(z);
        this.k = jVar;
    }

    /* access modifiers changed from: protected */
    public float[] a(int i, int i2, int i3, int i4) {
        Rect a2 = n.a(i, i2, i3, i4);
        if (a2.isEmpty()) {
            return super.a(i, i2, i3, i4);
        }
        return n.a(a2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, ArrayList<Throwable> arrayList) {
        if (arrayList != null) {
            Iterator<Throwable> it = arrayList.iterator();
            while (it.hasNext()) {
                Throwable next = it.next();
                if (next != null) {
                    if (z) {
                        this.k.p.add(new MFEVideoRecordingError(next, new MFEVideoRecordingError.Consequence[0]));
                    } else {
                        this.k.p.add(new MFEVideoRecordingError(next, MFEVideoRecordingError.Consequence.RecordingFailed));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Throwable th) {
        if (th != null) {
            this.k.p.add(new MFEVideoRecordingError(th, MFEVideoRecordingError.Consequence.SkippedVideoFrame));
        }
    }
}
