package com.shopee.app.web.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class SaveMediaToDeviceAlbumMessage {
    private final int type;
    private final String url;

    public static /* synthetic */ SaveMediaToDeviceAlbumMessage copy$default(SaveMediaToDeviceAlbumMessage saveMediaToDeviceAlbumMessage, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = saveMediaToDeviceAlbumMessage.url;
        }
        if ((i2 & 2) != 0) {
            i = saveMediaToDeviceAlbumMessage.type;
        }
        return saveMediaToDeviceAlbumMessage.copy(str, i);
    }

    public final String component1() {
        return this.url;
    }

    public final int component2() {
        return this.type;
    }

    public final SaveMediaToDeviceAlbumMessage copy(String str, int i) {
        j.b(str, "url");
        return new SaveMediaToDeviceAlbumMessage(str, i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof SaveMediaToDeviceAlbumMessage) {
                SaveMediaToDeviceAlbumMessage saveMediaToDeviceAlbumMessage = (SaveMediaToDeviceAlbumMessage) obj;
                if (j.a((Object) this.url, (Object) saveMediaToDeviceAlbumMessage.url)) {
                    if (this.type == saveMediaToDeviceAlbumMessage.type) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.url;
        return ((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.type).hashCode();
    }

    public String toString() {
        return "SaveMediaToDeviceAlbumMessage(url=" + this.url + ", type=" + this.type + SQLBuilder.PARENTHESES_RIGHT;
    }

    public SaveMediaToDeviceAlbumMessage(String str, int i) {
        j.b(str, "url");
        this.url = str;
        this.type = i;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getType() {
        return this.type;
    }
}
