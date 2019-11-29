package com.modiface.mfemakeupkit;

import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.video.MFEVideoRecordingError;
import com.modiface.mfemakeupkit.video.j;
import com.modiface.mfemakeupkit.video.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine.RecordVideoOutputCompletionHandler f15317a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15318b;

    i(MFEMakeupEngine mFEMakeupEngine, MFEMakeupEngine.RecordVideoOutputCompletionHandler recordVideoOutputCompletionHandler) {
        this.f15318b = mFEMakeupEngine;
        this.f15317a = recordVideoOutputCompletionHandler;
    }

    public void run() {
        if (this.f15318b.mVideoRecorder != null) {
            this.f15318b.mVideoRecorder.f();
            this.f15318b.mVideoRecorder.c().d();
            File file = this.f15318b.mVideoRecorder.m;
            m mVar = this.f15318b.mVideoRecorder.n;
            boolean z = mVar.f15456c;
            long j = mVar.f15454a;
            long j2 = mVar.f15455b;
            List<MFEVideoRecordingError> a2 = this.f15318b.mVideoRecorder.a();
            j unused = this.f15318b.mVideoRecorder = null;
            MFEMakeupEngine.RecordVideoOutputCompletionHandler recordVideoOutputCompletionHandler = this.f15317a;
            if (recordVideoOutputCompletionHandler != null) {
                recordVideoOutputCompletionHandler.onVideoRecorded(file, z, j, j2, a2);
                return;
            }
            return;
        }
        MFEMakeupEngine.RecordVideoOutputCompletionHandler recordVideoOutputCompletionHandler2 = this.f15317a;
        if (recordVideoOutputCompletionHandler2 != null) {
            recordVideoOutputCompletionHandler2.onVideoRecorded((File) null, false, 0, 0, new ArrayList());
        }
    }
}
