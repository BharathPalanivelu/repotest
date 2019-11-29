package com.shopee.app.data.viewmodel;

import android.text.TextUtils;
import com.garena.android.appkit.tools.a.a;
import com.garena.android.appkit.tools.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.data.store.ak;
import com.shopee.app.g.d;
import com.shopee.id.R;

public class UserData {
    private boolean autoTranslationEnabled = false;
    private boolean isHolidayModeOn = false;
    private boolean isPhonePublic;
    private boolean isUserActive = true;
    private int lastLogin;
    private int lastLogout;
    private String phoneNumber;
    private String portrait;
    private int shopId;
    private int userId;
    private String userName;
    private int userStatus;

    public boolean isUserDeletedOrBanned() {
        int i = this.userStatus;
        return i == 0 || i == 2;
    }

    public boolean isUserBanned() {
        return this.userStatus == 2;
    }

    public void setUserStatus(int i) {
        this.userStatus = i;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public boolean isValid() {
        return (this.portrait == null || this.userName == null) ? false : true;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public boolean isPhonePublic() {
        return this.isPhonePublic;
    }

    public void setPhonePublic(boolean z) {
        this.isPhonePublic = z;
    }

    public void setLastLogin(int i) {
        this.lastLogin = i;
    }

    public int getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogout(int i) {
        this.lastLogout = i;
    }

    public int getLastLogout() {
        return this.lastLogout;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public int getShopId() {
        return this.shopId;
    }

    public static String lastSeenTimeWithCeiling2(int i, int i2, int i3) {
        if (i2 > 0) {
            i = i2;
        }
        if (a.a() - i <= i3 * 60 * 60 * 24) {
            return d.a(((long) (a.a() - i)) * 1000, 2);
        }
        return b.a(R.string.sp_n_day_ago, Integer.valueOf(i3));
    }

    public static String lastSeenTimeWithCeiling(int i, int i2, int i3) {
        String str;
        int i4 = i2 > 0 ? i2 : i;
        if (a.a() - i4 > i3 * 60 * 60 * 24) {
            str = b.a(R.string.sp_n_day_ago, Integer.valueOf(i3));
        } else {
            str = d.a(((long) (a.a() - i4)) * 1000, 2);
        }
        if ((i2 > 0 && i >= i2) || TextUtils.isEmpty(str)) {
            return b.e(R.string.sp_label_online);
        }
        return b.e(R.string.sp_label_active) + SQLBuilder.BLANK + str;
    }

    public boolean isUserActive() {
        return this.isUserActive;
    }

    public void setIsUserActive(boolean z) {
        this.isUserActive = z;
    }

    public boolean isMe() {
        return this.userId == ((Integer) ak.a().d().b(-1)).intValue();
    }

    public boolean isHolidayModeOn() {
        return this.isHolidayModeOn;
    }

    public void setHolidayModeOn(boolean z) {
        this.isHolidayModeOn = z;
    }

    public boolean isAutoTranslationEnabled() {
        return this.autoTranslationEnabled;
    }

    public void setAutoTranslationEnabled(boolean z) {
        this.autoTranslationEnabled = z;
    }
}
