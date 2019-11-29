package com.shopee.d.a.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.HashSet;

public class b {

    /* renamed from: a  reason: collision with root package name */
    static boolean f27136a = false;

    /* renamed from: b  reason: collision with root package name */
    static boolean f27137b = false;

    /* renamed from: c  reason: collision with root package name */
    static boolean f27138c = false;

    /* renamed from: d  reason: collision with root package name */
    private static long f27139d = 2147483648L;

    public static boolean a(Context context) {
        if (f27136a) {
            return true;
        }
        return b(context);
    }

    public static boolean b(Context context) {
        if (context != null) {
            long a2 = a.a(context);
            if (a2 != -1 && a2 <= f27139d) {
                return true;
            }
        }
        if (!f27137b) {
            HashSet hashSet = new HashSet();
            for (String str : "HM 2A,vivo X5L,R8107,2014501,HUAWEI P7-L07,vivo Y33,F103,Coolpad 8675,HUAWEI P7-L09,Coolpad 8675-A,HM NOTE 1TD,G621-TL00,vivo X3t,Coolpad Y75,C8817D,M463C,Coolpad 8297,Coolpad 8675-FHD,Coolpad 8297-T01,2013022,C730Lw,HM NOTE 1W,VOTO GT7,vivo Y13iL,SM-G7106,2013022,vivo Y22L,lephone T2,M623C,Coolpad 8675-HD,HM 1SC,M355,HUAWEI P7-L00,GT-I9300,HONOR H30-L01,M351,JXD,KOPO L8,H30-T00,vivo Y13,Hisense M20-T,HUAWEI C8817E,GN5001,HM 1SW,R827T,GN151,LA-S1,Hol-T00,V188S,C03,vivo Y17T,DOOV M1t,HLJ-GM-Q1,Coolpad 8720L,Lenovo A788t,YEPEN,lephone T708,F8909,HONOR H30-L01M,G620S-UL00,XM-T,UOOGOU,4G+,K-Touch H2,LA2-S,KONKA D557,HUAWEI C8816,C630Lw,HUAWEI P6-C00,DOOV L5M,Lenovo S850t,F303,Coolpad 8730L,gucci,LA-S5,vivo Y17W,Coolpad 8675-W00,HUAWEI P6-T00,K-Touch H2,KONKA D557,V183,BF_A500,Lenovo S60-t,A51kc,Coolpad 5263S,HONOR H30-L02,vivo Y22iL,SM-G7108,2013023,Coolpad 8729,R1,vivo X1St,GM,KOPO L7,WP-S,XBS,R819T,M040,Best_sonny_LT416,Lenovo A3860,Coolpad Y80D,X1 7.0,Coolpad 5263S,T1,S6,Lovme-T15,Coolpad SK1-01,Z1988,P6,P8".split(",")) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            f27138c = hashSet.contains(Build.MODEL);
            f27137b = true;
        }
        return f27138c;
    }
}
