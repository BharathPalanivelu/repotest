package com.shopee.app.web.protocol;

import java.util.List;

public class FullImageMessage {
    private int currentIndex;
    private List<String> imageUrls;
    private List<Media> medias;

    public List<String> getImageUrls() {
        return this.imageUrls;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public List<Media> getMediaList() {
        return this.medias;
    }

    public static class Media {
        private int curTime;
        private String imageUrl;
        private String mediaUrl;
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

        public int getCurTime() {
            return this.curTime;
        }

        public boolean isVideo() {
            return this.type == 1;
        }
    }
}
