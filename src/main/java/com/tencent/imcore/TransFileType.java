package com.tencent.imcore;

public enum TransFileType {
    kPicFile((String) 1),
    kPicThumb,
    kTransFile,
    kTransPtt,
    kTransVideoSnapshot,
    kUGCFile;
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30658a;

        static /* synthetic */ int a() {
            int i = f30658a;
            f30658a = i + 1;
            return i;
        }
    }

    private TransFileType(int i) {
        this.swigValue = i;
        int unused = aa.f30658a = i + 1;
    }

    private TransFileType(TransFileType transFileType) {
        this.swigValue = transFileType.swigValue;
        int unused = aa.f30658a = this.swigValue + 1;
    }

    public static TransFileType swigToEnum(int i) {
        TransFileType[] transFileTypeArr = (TransFileType[]) TransFileType.class.getEnumConstants();
        if (i < transFileTypeArr.length && i >= 0 && transFileTypeArr[i].swigValue == i) {
            return transFileTypeArr[i];
        }
        for (TransFileType transFileType : transFileTypeArr) {
            if (transFileType.swigValue == i) {
                return transFileType;
            }
        }
        throw new IllegalArgumentException("No enum " + TransFileType.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
