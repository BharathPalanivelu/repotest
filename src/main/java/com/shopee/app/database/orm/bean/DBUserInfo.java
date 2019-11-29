package com.shopee.app.database.orm.bean;

import com.garena.android.appkit.tools.b;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shopee.id.R;

@DatabaseTable(tableName = "sp_user_info")
public class DBUserInfo {
    @DatabaseField(columnName = "appVersion")
    private int appVersion;
    @DatabaseField(columnName = "bankAccVerified")
    private int bankAccVerified;
    @DatabaseField(columnName = "cTime")
    private int cTime;
    @DatabaseField(columnName = "cacheTime")
    private int cacheTime;
    @DatabaseField(columnName = "country")
    private String country;
    @DatabaseField(columnName = "deviceId", dataType = DataType.BYTE_ARRAY)
    private byte[] deviceId;
    @DatabaseField(columnName = "email")
    private String email;
    @DatabaseField(columnName = "emailVerified")
    private boolean emailVerified;
    @DatabaseField(columnName = "extInfo", dataType = DataType.BYTE_ARRAY)
    private byte[] extInfo;
    @DatabaseField(columnName = "fbId")
    private String fbId;
    @DatabaseField(columnName = "followingCount")
    private int followingCount;
    @DatabaseField(columnName = "inited")
    private int inited;
    @DatabaseField(columnName = "isSeller")
    private boolean isSeller;
    @DatabaseField(columnName = "language")
    private String language;
    @DatabaseField(columnName = "lastLogin")
    private int lastLogin;
    @DatabaseField(columnName = "lastLogout")
    private int lastLogout;
    @DatabaseField(columnName = "likedCount")
    private int likedCount;
    @DatabaseField(columnName = "mTime")
    private int mTime;
    @DatabaseField(columnName = "machineCode")
    private String machineCode;
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "password")
    private String password;
    @DatabaseField(columnName = "phone")
    private String phone;
    @DatabaseField(columnName = "phonePublic")
    private boolean phonePublic;
    @DatabaseField(columnName = "phoneVerified")
    private boolean phoneVerified;
    @DatabaseField(columnName = "pnOption")
    private long pnOption;
    @DatabaseField(columnName = "portrait")
    private String portrait;
    @DatabaseField(columnName = "remark")
    private String remark;
    @DatabaseField(columnName = "shopId")
    private int shopId;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "user_id", id = true)
    private int userId;
    @DatabaseField(columnName = "userName")
    private String userName;

    public static DBUserInfo a(int i) {
        DBUserInfo dBUserInfo = new DBUserInfo();
        dBUserInfo.f(b.e(R.string.sp_label_deleted_user));
        dBUserInfo.c(i);
        dBUserInfo.a(b.e(R.string.sp_label_deleted_user));
        dBUserInfo.e(0);
        return dBUserInfo;
    }

    public static DBUserInfo b(int i) {
        DBUserInfo dBUserInfo = new DBUserInfo();
        dBUserInfo.f(b.e(R.string.sp_user_name_placeholder));
        dBUserInfo.c(i);
        dBUserInfo.a(b.e(R.string.sp_user_name_placeholder));
        dBUserInfo.e(1);
        return dBUserInfo;
    }

    public void c(int i) {
        this.userId = i;
    }

    public void a(String str) {
        this.name = str;
    }

    public String a() {
        return this.name;
    }

    public void b(String str) {
        this.phone = str;
    }

    public String b() {
        return this.phone;
    }

    public String c() {
        return this.email;
    }

    public void c(String str) {
        this.email = str;
    }

    public int d() {
        return this.userId;
    }

    public int e() {
        return this.shopId;
    }

    public void d(int i) {
        this.shopId = i;
    }

    public String f() {
        return this.fbId;
    }

    public void d(String str) {
        this.fbId = str;
    }

    public int g() {
        return this.status;
    }

    public void e(int i) {
        this.status = i;
    }

    public int h() {
        return this.bankAccVerified;
    }

    public void f(int i) {
        this.bankAccVerified = i;
    }

    public void e(String str) {
        this.remark = str;
    }

    public String i() {
        return this.userName;
    }

    public void f(String str) {
        this.userName = str;
    }

    public String j() {
        return this.portrait;
    }

    public void g(String str) {
        this.portrait = str;
    }

    public void h(String str) {
        this.machineCode = str;
    }

    public void a(byte[] bArr) {
        this.deviceId = bArr;
    }

    public long k() {
        return this.pnOption;
    }

    public void a(long j) {
        this.pnOption = j;
    }

    public void i(String str) {
        this.language = str;
    }

    public void g(int i) {
        this.appVersion = i;
    }

    public String l() {
        return this.country;
    }

    public void j(String str) {
        this.country = str;
    }

    public void h(int i) {
        this.cTime = i;
    }

    public void i(int i) {
        this.mTime = i;
    }

    public int m() {
        return this.followingCount;
    }

    public void j(int i) {
        this.followingCount = i;
    }

    public boolean n() {
        return this.phoneVerified;
    }

    public void a(boolean z) {
        this.phoneVerified = z;
    }

    public boolean o() {
        return this.emailVerified;
    }

    public void b(boolean z) {
        this.emailVerified = z;
    }

    public int p() {
        return this.lastLogin;
    }

    public void k(int i) {
        this.lastLogin = i;
    }

    public void c(boolean z) {
        this.isSeller = z;
    }

    public boolean q() {
        return this.isSeller;
    }

    public void d(boolean z) {
        this.phonePublic = z;
    }

    public boolean r() {
        return this.phonePublic;
    }

    public int s() {
        return this.cacheTime;
    }

    public void l(int i) {
        this.cacheTime = i;
    }

    public byte[] t() {
        return this.extInfo;
    }

    public void b(byte[] bArr) {
        this.extInfo = bArr;
    }

    public void m(int i) {
        this.likedCount = i;
    }

    public int u() {
        return this.likedCount;
    }

    public int v() {
        return this.inited;
    }

    public void n(int i) {
        this.inited = i;
    }

    public final int w() {
        return this.lastLogout;
    }

    public void o(int i) {
        this.lastLogout = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DBUserInfo) || this.userId != ((DBUserInfo) obj).d()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.userId;
    }
}
