package com.shopee.app.react.protocol;

public class ImagePickerData {
    private boolean allowCrop;
    private boolean allowEdit;
    private boolean allowPreview;
    private CropData cropRatio;
    private ImageOption imageOption;
    private int maxCount = 1;
    private boolean selectFromInstagram;

    public int getMaxCount() {
        return this.maxCount;
    }

    public CropData getCropData() {
        return this.cropRatio;
    }

    public boolean isAllowEdit() {
        return this.allowEdit;
    }

    public boolean isAllowCrop() {
        return this.allowCrop;
    }

    public ImageOption getImageOption() {
        return this.imageOption;
    }

    public boolean isAllowPreview() {
        return this.allowPreview;
    }

    public boolean isSelectFromInstagram() {
        return this.selectFromInstagram;
    }

    public static class CropData {
        private int height = 1;
        private int width = 1;

        public int getWidthRatio() {
            return this.width;
        }

        public int getHeightRatio() {
            return this.height;
        }
    }

    public static class ImageOption {
        private int height = 800;
        private int quality = 80;
        private int tnHeight;
        private int tnWidth;
        private int width = 800;

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public int getQuality() {
            return this.quality;
        }

        public int getThumbWidth() {
            return this.tnWidth;
        }

        public int getThumbHeight() {
            return this.tnHeight;
        }
    }
}
