package com.shopee.app.database.orm.bean.chatP2P;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.shopee.app.d.b.b;
import com.shopee.protocol.action.BlockedUser;

@DatabaseTable(tableName = "sp_BlockUser")
public class DBBlockUser {
    @DatabaseField(columnName = "blocked")
    private boolean blocked;
    @DatabaseField(columnName = "sequence")
    private int sequence;
    @DatabaseField(columnName = "userid", id = true)
    private int userid;

    public static String c() {
        return "CREATE TABLE `sp_BlockUser` (`blocked` INTEGER , `sequence` INTEGER , `userid` INTEGER , PRIMARY KEY (`userid`) );";
    }

    public final int a() {
        return this.userid;
    }

    public void a(int i) {
        this.userid = i;
    }

    public final boolean b() {
        return this.blocked;
    }

    public void a(boolean z) {
        this.blocked = z;
    }

    public static void a(BlockedUser blockedUser, DBBlockUser dBBlockUser) {
        dBBlockUser.a(b.a(blockedUser.userid));
        dBBlockUser.a(b.a(blockedUser.blocked));
    }

    public void b(int i) {
        this.sequence = i;
    }
}
