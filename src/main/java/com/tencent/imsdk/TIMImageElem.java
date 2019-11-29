package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;
import java.util.ArrayList;

public class TIMImageElem extends TIMElem {
    public static final int TIM_IMAGE_FORMAT_BMP = 4;
    public static final int TIM_IMAGE_FORMAT_GIF = 2;
    public static final int TIM_IMAGE_FORMAT_JPG = 1;
    public static final int TIM_IMAGE_FORMAT_PNG = 3;
    public static final int TIM_IMAGE_FORMAT_UNKNOWN = 255;
    private int imageFormat = 255;
    private ArrayList<TIMImage> imageList = new ArrayList<>();
    private int level = 1;
    private String path = "";
    private int taskId = 0;

    public TIMImageElem() {
        this.type = TIMElemType.Image;
    }

    public boolean cancelUploading() {
        if (!IMCoreWrapper.get().isIMCoreUserInited() || this.taskId == 0) {
            return false;
        }
        QLog.e("MSF.C.TIMMessage", 1, "canceluploading: " + this.taskId);
        TIMManager.getInstanceById(this.identifier).getCoreUser().cancelTask((long) this.taskId);
        return true;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    public ArrayList<TIMImage> getImageList() {
        return this.imageList;
    }

    public int getLevel() {
        return this.level;
    }

    public String getPath() {
        return this.path;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public int getUploadingProgress() {
        if (!IMCoreWrapper.get().isIMCoreUserInited() || this.taskId == 0) {
            return 0;
        }
        return TIMManager.getInstanceById(this.identifier).getCoreUser().getImageUploadProgrss((long) this.taskId);
    }

    /* access modifiers changed from: package-private */
    public void setImageFormat(int i) {
        this.imageFormat = i;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setPath(String str) {
        this.path = str;
    }

    /* access modifiers changed from: package-private */
    public void setTaskId(int i) {
        this.taskId = i;
    }
}
