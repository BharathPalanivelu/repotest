package com.modiface.mfemakeupkit;

import com.modiface.mfemakeupkit.MFEMakeupEngine;
import com.modiface.mfemakeupkit.video.MFEVideoRecordingError;
import com.modiface.mfemakeupkit.video.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine.RecordVideoOutputCompletionHandler f15319a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MFEMakeupEngine f15320b;

    j(MFEMakeupEngine mFEMakeupEngine, MFEMakeupEngine.RecordVideoOutputCompletionHandler recordVideoOutputCompletionHandler) {
        this.f15320b = mFEMakeupEngine;
        this.f15319a = recordVideoOutputCompletionHandler;
    }

    public void run() {
        if (this.f15320b.mVideoRecorder != null) {
            this.f15320b.mVideoRecorder.f();
            File file = this.f15320b.mVideoRecorder.m;
            m mVar = this.f15320b.mVideoRecorder.n;
            boolean z = mVar.f15456c;
            long j = mVar.f15454a;
            long j2 = mVar.f15455b;
            List<MFEVideoRecordingError> a2 = this.f15320b.mVideoRecorder.a();
            com.modiface.mfemakeupkit.video.j unused = this.f15320b.mVideoRecorder = null;
            MFEMakeupEngine.RecordVideoOutputCompletionHandler recordVideoOutputCompletionHandler = this.f15319a;
            if (recordVideoOutputCompletionHandler != null) {
                recordVideoOutputCompletionHandler.onVideoRecorded(file, z, j, j2, a2);
                return;
            }
            return;
        }
        MFEMakeupEngine.RecordVideoOutputCompletionHandler recordVideoOutputCompletionHandler2 = this.f15319a;
        if (recordVideoOutputCompletionHandler2 != null) {
            recordVideoOutputCompletionHandler2.onVideoRecorded((File) null, false, 0, 0, new ArrayList());
        }
    }
}
