package com.shopee.app.database;

import android.database.sqlite.SQLiteDatabase;
import com.garena.android.appkit.a.d;
import com.shopee.app.database.orm.bean.DBActionContent;
import com.shopee.app.database.orm.bean.DBAttributeCache;
import com.shopee.app.database.orm.bean.DBBIReport;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.DBChatToOffer;
import com.shopee.app.database.orm.bean.DBItemAttribute;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.DBModel;
import com.shopee.app.database.orm.bean.DBModelAttrIdMap;
import com.shopee.app.database.orm.bean.DBUserBrief;
import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.database.orm.bean.chatP2P.DBOffer;
import java.util.ArrayList;
import java.util.List;

public class c extends com.garena.android.appkit.a.c {
    private d A = new d(1, 24) {
        public String a() {
            return DBActionContent.n();
        }
    };
    private d B = new d(1, 25) {
        public String a() {
            return DBChatMessage.A();
        }
    };
    private d C = new d(1, 26) {
        public String a() {
            return DBItemDetail.u();
        }
    };
    private d D = new d(1, 27) {
        public String a() {
            return "ALTER TABLE sp_action_content ADD groupId INTEGER; ALTER TABLE sp_action_content ADD groupedCount INTEGER;CREATE TABLE IF NOT EXISTS `sp_action_group` (`id` BIGINT, `content` VARCHAR, PRIMARY KEY (`id`));";
        }
    };
    private d E = new d(1, 27) {
        public String a() {
            return "DELETE FROM sp_action_content;";
        }
    };
    private d F = new d(1, 28) {
        public String a() {
            return "ALTER TABLE sp_return_item ADD ext VARCHAR;";
        }
    };
    private d G = new d(1, 29) {
        public String a() {
            return "ALTER TABLE sp_action_content ADD avatarImage VARCHAR;";
        }
    };
    private d H = new d(1, 30) {
        public String a() {
            return "ALTER TABLE DBShopInfo ADD max_image_count INTEGER;";
        }
    };
    private d I = new d(1, 31) {
        public String a() {
            return DBActionContent.r();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private d f17342a = new d(1, 2) {
        public String a() {
            return "ALTER TABLE dbshopinfo ADD score INTEGER;ALTER TABLE dbshopinfo ADD followed SMALLINT;";
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private d f17343b = new d(1, 3) {
        public String a() {
            return "ALTER TABLE sp_item_detail ADD extended_info BLOB;";
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private d f17344c = new d(1, 4) {
        public String a() {
            return "CREATE TABLE IF NOT EXISTS `sp_contact_list` (`CONTACT_NAME` VARCHAR , `PORTRAIT` VARCHAR , `USERNAME` VARCHAR , `CONTACT_TYPE` INTEGER , `FOLLOWED` SMALLINT , `SHOP_ID` INTEGER , `USER_ID` INTEGER , PRIMARY KEY (`USER_ID`) );";
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private d f17345d = new d(1, 5) {
        public String a() {
            return "ALTER TABLE sp_activity_item ADD accType INTEGER;ALTER TABLE sp_activity_item ADD contactName VARCHAR;";
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private d f17346e = new d(1, 6) {
        public String a() {
            return "ALTER TABLE sp_item_snapshot ADD extended_info BLOB;ALTER TABLE sp_activity_item ADD activityInfo BLOB;ALTER TABLE dbshopinfo ADD ext_info BLOB;ALTER TABLE sp_action_content ADD actionRequiredUrl VARCHAR;";
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private d f17347f = new d(1, 7) {
        public String a() {
            return "ALTER TABLE sp_checkout_item ADD logisticsStatus INTEGER;ALTER TABLE dborderdetail ADD pickupTime INTEGER;ALTER TABLE dborderdetail ADD orderInfo BLOB;ALTER TABLE dborderdetail ADD listType INTEGER;ALTER TABLE dborderdetail ADD shippingConfirmTime INTEGER;";
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private d f17348g = new d(1, 8) {
        public String a() {
            return "ALTER TABLE sp_user_info ADD inited INTEGER;";
        }
    };
    private d h = new d(1, 9) {
        public String a() {
            return "ALTER TABLE sp_category ADD parent_id INTEGER;ALTER TABLE sp_category ADD is_default_subcategory INTEGER;";
        }
    };
    private d i = new d(1, 10) {
        public String a() {
            return "CREATE TABLE `sp_model` (`currency` VARCHAR , `name` VARCHAR , `model_id` BIGINT , `item_id` BIGINT , `price` BIGINT , `status` INTEGER DEFAULT 1 , `stock` INTEGER , PRIMARY KEY (`model_id`) );";
        }
    };
    private d j = new d(1, 10) {
        public String a() {
            return "alter table sp_user_info ADD lastLogout INTEGER";
        }
    };
    private d k = new d(1, 10) {
        public String a() {
            return DBChatMessage.v() + DBChatToOffer.i();
        }
    };
    private d l = new d(1, 10) {
        public String a() {
            return "create index sp_model_itemid on sp_model (item_id)";
        }
    };
    private d m = new d(1, 10) {
        public String a() {
            return DBModel.a() + DBModel.b() + DBModel.c() + DBModel.d() + DBModel.e();
        }
    };
    private d n = new d(1, 11) {
        public String a() {
            return "CREATE TABLE `sp_model_snapshot` (`currency` VARCHAR , `extinfo` BLOB , `name` VARCHAR , `stock` INTEGER , `item_id` BIGINT , `price` BIGINT , `priceBeforeDiscount` BIGINT , `promotionid` BIGINT , `rebatePrice` BIGINT , `model_id` BIGINT , `status` INTEGER DEFAULT 1 , `sold` INTEGER , PRIMARY KEY (`model_id`) );";
        }
    };
    private d o = new d(1, 12) {
        public String a() {
            return "ALTER TABLE dbtransaction ADD extinfo BLOB;";
        }
    };
    private d p = new d(1, 13) {
        public String a() {
            return "Delete  from  sp_chat_message;Delete  from  sp_item_comment;Delete  from  sp_chat_to_offer;" + DBChat.r() + DBOffer.o() + DBChatMessage.w() + DBChatMessage.x() + DBBIReport.c() + DBChatMessage.y();
        }
    };
    private d q = new d(1, 13) {
        public String a() {
            return DBBlockUser.c();
        }
    };
    private d r = new d(1, 14) {
        public String a() {
            return "ALTER TABLE sp_activity_item add feedId BIGINT;";
        }
    };
    private d s = new d(1, 15) {
        public String a() {
            return "ALTER TABLE sp_item_comment add rating_star2 INTEGER;Delete  from  sp_item_comment;";
        }
    };
    private d t = new d(1, 16) {
        public String a() {
            return "ALTER TABLE sp_action_content ADD actionCate INTEGER;ALTER TABLE sp_action_content ADD actionAppPath VARCHAR;";
        }
    };
    private d u = new d(1, 17) {
        public String a() {
            return "CREATE TABLE IF NOT EXISTS `sp_activity_item2` (`contactName` VARCHAR , `comment` VARCHAR , `activityInfo` BLOB , `activityId` INTEGER , `itemId` BIGINT , `feedId` BIGINT , `createTime` INTEGER , `accType` INTEGER , `fromUserId` INTEGER , `commentId` BIGINT , `shopId` INTEGER , `type` INTEGER , `updateType` INTEGER , PRIMARY KEY (`activityId`) );CREATE TABLE IF NOT EXISTS `sp_item_comment2` (`mentioned` BLOB , `extra_info` BLOB, `comment` VARCHAR , `orderId` BIGINT , `id` INTEGER PRIMARY KEY AUTOINCREMENT , `itemId` BIGINT , `modelId` BIGINT , `cTime` INTEGER, `mTime` INTEGER , `editable` INTEGER, `cmtId` BIGINT , `rating` INTEGER , `rating_star2` INTEGER , `shopId` INTEGER , `status` INTEGER , `userId` INTEGER );";
        }
    };
    private d v = new d(1, 18) {
        public String a() {
            return DBChatMessage.z();
        }
    };
    private d w = new d(1, 19) {
        public String a() {
            return "Delete  from  sp_BIReport;" + DBBIReport.d() + DBBIReport.e();
        }
    };
    private d x = new d(1, 20) {
        public String a() {
            return DBChat.p() + DBChat.q();
        }
    };
    private d y = new d(1, 21) {
        public String a() {
            return DBUserBrief.m() + DBUserBrief.o() + DBUserBrief.n();
        }
    };
    private d z = new d(1, 23) {
        public String a() {
            return DBItemAttribute.m() + DBAttributeCache.c() + DBAttributeCache.e() + DBAttributeCache.d() + DBModelAttrIdMap.b();
        }
    };

    public c(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        super(sQLiteDatabase, i2, i3);
    }

    /* access modifiers changed from: protected */
    public List<d> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f17342a);
        arrayList.add(this.f17343b);
        arrayList.add(this.f17344c);
        arrayList.add(this.f17345d);
        arrayList.add(this.f17346e);
        arrayList.add(this.f17347f);
        arrayList.add(this.f17348g);
        arrayList.add(this.h);
        arrayList.add(this.i);
        arrayList.add(this.j);
        arrayList.add(this.k);
        arrayList.add(this.l);
        arrayList.add(this.m);
        arrayList.add(this.n);
        arrayList.add(this.o);
        arrayList.add(this.p);
        arrayList.add(this.q);
        arrayList.add(this.r);
        arrayList.add(this.s);
        arrayList.add(this.t);
        arrayList.add(this.u);
        arrayList.add(this.w);
        arrayList.add(this.v);
        arrayList.add(this.x);
        arrayList.add(this.y);
        arrayList.add(this.z);
        arrayList.add(this.A);
        arrayList.add(this.B);
        arrayList.add(this.C);
        arrayList.add(this.E);
        arrayList.add(this.D);
        arrayList.add(this.F);
        arrayList.add(this.G);
        arrayList.add(this.H);
        arrayList.add(this.I);
        return arrayList;
    }
}
