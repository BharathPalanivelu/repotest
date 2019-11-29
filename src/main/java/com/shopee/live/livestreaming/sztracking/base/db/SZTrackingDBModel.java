package com.shopee.live.livestreaming.sztracking.base.db;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

@Table("live_event")
public class SZTrackingDBModel {
    @Column("body")
    public String body;
    @Column("event_id")
    public int eventId;
    @Column("header")
    @NotNull
    public String header;
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    public int id;
    @Column("scene_id")
    public int sceneId;
    @Column("timestamp")
    public long timestamp;
}
