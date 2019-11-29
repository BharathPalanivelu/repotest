package com.shopee.app.react.protocol;

import com.google.a.o;
import java.util.List;

public class MediaBrowserData {
    private int currentIndex;
    private boolean isMuted;
    private List<Media> mediaList;

    public List<Media> getMediaList() {
        return this.mediaList;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public boolean isMuted() {
        return this.isMuted;
    }

    public static class Media {
        private int curTime;
        private String imageUrl;
        private String mediaUrl;
        private o trackingData;
        private int type;

        public String getImageUrl() {
            return this.imageUrl;
        }

        public String getMediaUrl() {
            return this.mediaUrl;
        }

        public int getType() {
            return this.type;
        }

        public int getCurrentTime() {
            return this.curTime;
        }

        public boolean isVideo() {
            return this.type == 1;
        }

        public o getTrackingData() {
            return this.trackingData;
        }
    }
}
