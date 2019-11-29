package com.tencent.imcore;

public enum ProfileFlag {
    kProfileFlagNone((String) 0),
    kProfileFlagNick((String) 1),
    kProfileFlagAllowType((String) 2),
    kProfileFlagFaceUrl((String) 4),
    kProfileFlagRemark((String) 8),
    kProfileFlagGroup((String) 16),
    kProfileFlagSelfSignature((String) 32),
    kProfileFlagGender((String) 64),
    kProfileFlagBirthday((String) 128),
    kProfileFlagLocation((String) 256),
    kProfileFlagLanguage((String) 512),
    kProfileFlagLevel((String) 1024),
    kProfileFlagRole((String) 2048);
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30655a;

        static /* synthetic */ int a() {
            int i = f30655a;
            f30655a = i + 1;
            return i;
        }
    }

    private ProfileFlag(int i) {
        this.swigValue = i;
        int unused = aa.f30655a = i + 1;
    }

    private ProfileFlag(ProfileFlag profileFlag) {
        this.swigValue = profileFlag.swigValue;
        int unused = aa.f30655a = this.swigValue + 1;
    }

    public static ProfileFlag swigToEnum(int i) {
        ProfileFlag[] profileFlagArr = (ProfileFlag[]) ProfileFlag.class.getEnumConstants();
        if (i < profileFlagArr.length && i >= 0 && profileFlagArr[i].swigValue == i) {
            return profileFlagArr[i];
        }
        for (ProfileFlag profileFlag : profileFlagArr) {
            if (profileFlag.swigValue == i) {
                return profileFlag;
            }
        }
        throw new IllegalArgumentException("No enum " + ProfileFlag.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
