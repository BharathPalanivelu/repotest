package com.shopee.feeds.feedlibrary.data.entity;

import com.shopee.feeds.feedlibrary.editor.sticker.a.d;
import com.shopee.feeds.feedlibrary.editor.tag.a;
import com.shopee.feeds.feedlibrary.editor.text.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class BaseEditEntity implements Serializable {
    private String caution;
    private HashMap<String, String> cleanEditImagePathMap;
    private HashMap<String, Integer[]> cleanEditImageSizeMap;
    private ArrayList<String> currentPathList;
    private HashMap<String, String> editImagePathMap;
    private String feedId;
    private String feedWaterMarkIconPath;
    private boolean hasAlbum = false;
    private boolean hasIns = false;
    private boolean hasParamCheck = false;
    private ArrayList<String> hashTags;
    private HashMap<String, String> mainColorMap;
    private MediaCompressParam mediaCompressParam;
    private ArrayList<Integer> mentions;
    private ArrayList<String> postCurrentPathList;
    public long postEndTime;
    private String postId;
    public long postStartTime = 0;
    private int postState = 0;
    private int postType = 1;
    private HashMap<String, String> saveAlbumPathMap;
    public ArrayList<String> saveList;
    private int source;
    private LinkedHashMap<String, ArrayList<d>> stickerInfoMap;
    private LinkedHashMap<String, ArrayList<a>> tagInfoMap;
    private LinkedHashMap<String, ArrayList<b>> textInfoMap;

    public void setFeedWaterMarkIconPath(String str) {
        this.feedWaterMarkIconPath = str;
    }

    public String getFeedWaterMarkIconPath() {
        return this.feedWaterMarkIconPath;
    }

    public MediaCompressParam getMediaCompressParam() {
        return this.mediaCompressParam;
    }

    public void setMediaCompressParam(MediaCompressParam mediaCompressParam2) {
        this.mediaCompressParam = mediaCompressParam2;
    }

    public void setSaveList(ArrayList<String> arrayList) {
        this.saveList = arrayList;
    }

    public ArrayList<String> getSaveList() {
        return this.saveList;
    }

    public boolean isHasParamCheck() {
        return this.hasParamCheck;
    }

    public void setHasParamCheck(boolean z) {
        this.hasParamCheck = z;
    }

    public void setPostCurrentPathList(ArrayList<String> arrayList) {
        this.postCurrentPathList = arrayList;
    }

    public ArrayList<String> getPostCurrentPathList() {
        return this.postCurrentPathList;
    }

    public void setPostType(int i) {
        this.postType = i;
    }

    public int getPostType() {
        return this.postType;
    }

    public void setHasIns(boolean z) {
        this.hasIns = z;
    }

    public boolean isHasIns() {
        return this.hasIns;
    }

    public void setHasAlbum(boolean z) {
        this.hasAlbum = z;
    }

    public boolean isHasAlbum() {
        return this.hasAlbum;
    }

    public void setCaution(String str) {
        this.caution = str;
    }

    public String getCaution() {
        String str = this.caution;
        return str == null ? "" : str;
    }

    public void setMentions(ArrayList<Integer> arrayList) {
        this.mentions = arrayList;
    }

    public ArrayList<Integer> getMentions() {
        return this.mentions;
    }

    public void setHashTags(ArrayList<String> arrayList) {
        this.hashTags = arrayList;
    }

    public ArrayList<String> getHashTags() {
        return this.hashTags;
    }

    public void setPostState(int i) {
        this.postState = i;
    }

    public int getPostState() {
        return this.postState;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public String getPostId() {
        String str = this.postId;
        return str == null ? "" : str;
    }

    public void setFeedId(String str) {
        this.feedId = str;
    }

    public String getFeedId() {
        String str = this.feedId;
        return str == null ? "" : str;
    }

    public void setPostStartTime(long j) {
        this.postStartTime = j;
    }

    public long getPostStartTime() {
        return this.postStartTime;
    }

    public void setPostEndTime(long j) {
        this.postEndTime = j;
    }

    public long getPostEndTime() {
        return this.postEndTime;
    }

    public ArrayList<String> getCurrentPathList() {
        ArrayList<String> arrayList = this.currentPathList;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public HashMap<String, String> getMainColorMap() {
        return this.mainColorMap;
    }

    public void setMainColorMap(HashMap<String, String> hashMap) {
        this.mainColorMap = hashMap;
    }

    public void setCurrentPathList(ArrayList<String> arrayList) {
        this.currentPathList = arrayList;
    }

    public HashMap<String, String> getSaveAlbumPathMap() {
        return this.saveAlbumPathMap;
    }

    public void setSaveAlbumPathMap(HashMap<String, String> hashMap) {
        this.saveAlbumPathMap = hashMap;
    }

    public HashMap<String, String> getEditImagePathMap() {
        return this.editImagePathMap;
    }

    public void setEditImagePathMap(HashMap<String, String> hashMap) {
        this.editImagePathMap = hashMap;
    }

    public HashMap<String, String> getCleanEditImagePathMap() {
        return this.cleanEditImagePathMap;
    }

    public void setCleanEditImagePathMap(HashMap<String, String> hashMap) {
        this.cleanEditImagePathMap = hashMap;
    }

    public HashMap<String, Integer[]> getCleanEditImageSizeMap() {
        return this.cleanEditImageSizeMap;
    }

    public void setCleanEditImageSizeMap(HashMap<String, Integer[]> hashMap) {
        this.cleanEditImageSizeMap = hashMap;
    }

    public LinkedHashMap<String, ArrayList<a>> getTagInfoMap() {
        return this.tagInfoMap;
    }

    public void setTagInfoMap(LinkedHashMap<String, ArrayList<a>> linkedHashMap) {
        this.tagInfoMap = linkedHashMap;
    }

    public LinkedHashMap<String, ArrayList<b>> getTextInfoMap() {
        return this.textInfoMap;
    }

    public void setTextInfoMap(LinkedHashMap<String, ArrayList<b>> linkedHashMap) {
        this.textInfoMap = linkedHashMap;
    }

    public LinkedHashMap<String, ArrayList<d>> getStickerInfoMap() {
        return this.stickerInfoMap;
    }

    public void setStickerInfoMap(LinkedHashMap<String, ArrayList<d>> linkedHashMap) {
        this.stickerInfoMap = linkedHashMap;
    }

    public int getSource() {
        return this.source;
    }

    public void setSource(int i) {
        this.source = i;
    }
}
