package com.modiface.mfemakeupkit.video;

import java.util.Arrays;
import java.util.EnumSet;

public final class MFEVideoRecordingError extends Throwable {
    public final EnumSet<Consequence> consequences;

    public enum Consequence {
        SkippedVideoFrame,
        SkippedAudioFrame,
        NoAudio,
        RecordingFailed
    }

    MFEVideoRecordingError(Throwable th, Consequence... consequenceArr) {
        super(getConsequenceString(consequenceArr), th);
        if (consequenceArr.length <= 0) {
            this.consequences = EnumSet.noneOf(Consequence.class);
        } else {
            this.consequences = EnumSet.copyOf(Arrays.asList(consequenceArr));
        }
    }

    private static String getConsequenceString(Consequence... consequenceArr) {
        if (consequenceArr.length <= 0) {
            return "\n\tThis error has no consequence.";
        }
        StringBuilder sb = new StringBuilder("\n\tThis error has the following consequence(s):");
        for (Consequence consequence : consequenceArr) {
            if (consequence == null) {
                sb.append("\n\t\t(null)");
            } else {
                int i = o.f15459a[consequence.ordinal()];
                if (i == 1) {
                    sb.append("\n\t\trecording failed");
                } else if (i == 2) {
                    sb.append("\n\t\tno audio recorded");
                } else if (i == 3) {
                    sb.append("\n\t\ta video frame is skipped");
                } else if (i != 4) {
                    sb.append("\n\t\t(unknown consequence)");
                } else {
                    sb.append("\n\t\tan audio frame is skipped");
                }
            }
        }
        return sb.toString();
    }
}
