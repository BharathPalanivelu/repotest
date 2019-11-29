package com.tencent.imsdk;

import android.text.TextUtils;
import com.tencent.imcore.CustomElem;
import com.tencent.imcore.Elem;
import com.tencent.imcore.FaceElem;
import com.tencent.imcore.FileElem;
import com.tencent.imcore.FriendChangeInfoVec;
import com.tencent.imcore.ImageElem;
import com.tencent.imcore.LocationElem;
import com.tencent.imcore.MsgElemType;
import com.tencent.imcore.SoundElem;
import com.tencent.imcore.StrVec;
import com.tencent.imcore.TextElem;
import com.tencent.imcore.UGCElem;
import com.tencent.imcore.VideoElem;
import com.tencent.imsdk.log.QLog;
import java.io.UnsupportedEncodingException;

public abstract class TIMElem {
    private static final String tag = "imsdk.TIMElem";
    protected String identifier = "";
    protected TIMElemType type = TIMElemType.Invalid;

    static TIMImageElem buildImageElem(Elem elem) {
        TIMImageElem tIMImageElem = new TIMImageElem();
        try {
            String str = new String(elem.getSelf_identifier(), "utf-8");
            String str2 = new String(elem.getResource(), "utf-8");
            ImageElem image = elem.getImage();
            tIMImageElem = buildImageElem(image, str);
            tIMImageElem.setIdentifier(str);
            tIMImageElem.setPath(str2);
            tIMImageElem.setTaskId(image.getTaskid());
            tIMImageElem.setImageFormat(image.getFormat());
            tIMImageElem.setLevel(image.getLevel());
            return tIMImageElem;
        } catch (Throwable th) {
            QLog.e(tag, 1, IMFunc.getExceptionInfo(th));
            return tIMImageElem;
        }
    }

    static TIMImageElem buildImageElem(ImageElem imageElem, String str) {
        TIMImageElem tIMImageElem = new TIMImageElem();
        if (imageElem.getOrig_url() != null && imageElem.getOrig_url().length() > 0) {
            TIMImage tIMImage = new TIMImage();
            tIMImage.setType(TIMImageType.Original);
            tIMImage.setUuid(imageElem.getFileid());
            tIMImage.setHeight((long) imageElem.getPic_height());
            tIMImage.setWidth((long) imageElem.getPic_width());
            tIMImage.setSize((long) imageElem.getPic_size());
            tIMImage.setUrl(imageElem.getOrig_url());
            tIMImage.setIdentifier(str);
            tIMImageElem.getImageList().add(tIMImage);
        }
        if (imageElem.getThumb_url() != null && imageElem.getThumb_url().length() > 0) {
            TIMImage tIMImage2 = new TIMImage();
            tIMImage2.setType(TIMImageType.Thumb);
            tIMImage2.setUuid(imageElem.getFileid());
            tIMImage2.setHeight((long) imageElem.getPic_thumb_height());
            tIMImage2.setWidth((long) imageElem.getPic_thumb_width());
            tIMImage2.setSize((long) imageElem.getPic_thumb_size());
            tIMImage2.setUrl(imageElem.getThumb_url());
            tIMImage2.setIdentifier(str);
            tIMImageElem.getImageList().add(tIMImage2);
        }
        if (imageElem.getLarge_url() != null && imageElem.getLarge_url().length() > 0) {
            TIMImage tIMImage3 = new TIMImage();
            tIMImage3.setType(TIMImageType.Large);
            tIMImage3.setUuid(imageElem.getFileid());
            tIMImage3.setHeight((long) imageElem.getPic_large_height());
            tIMImage3.setWidth((long) imageElem.getPic_large_width());
            tIMImage3.setSize((long) imageElem.getPic_large_size());
            tIMImage3.setUrl(imageElem.getLarge_url());
            tIMImage3.setIdentifier(str);
            tIMImageElem.getImageList().add(tIMImage3);
        }
        return tIMImageElem;
    }

    static TIMVideoElem buildVideoElem(Elem elem) {
        TIMVideoElem tIMVideoElem = new TIMVideoElem();
        try {
            String str = new String(elem.getSelf_identifier(), "utf-8");
            tIMVideoElem.setIdentifier(str);
            VideoElem video = elem.getVideo();
            if (video != null) {
                tIMVideoElem.setTaskId(video.getTaskid());
                TIMVideo tIMVideo = new TIMVideo();
                tIMVideo.setDuaration(video.getVideo_duration());
                tIMVideo.setSize(video.getVideo_size());
                if (!(video.getVideo_type() == null || video.getVideoId() == null)) {
                    tIMVideo.setType(new String(video.getVideo_type(), "utf-8"));
                    tIMVideo.setUuid(new String(video.getVideoId(), "utf-8"));
                }
                tIMVideo.setIdentifier(str);
                tIMVideo.setBusinessId((long) video.getBusiness_id());
                tIMVideo.setDownloadFlag(video.getVideo_download_flag());
                StrVec video_urls = video.getVideo_urls();
                for (int i = 0; ((long) i) < video_urls.size(); i++) {
                    tIMVideo.addUrl(video_urls.get(i));
                }
                tIMVideoElem.setVideo(tIMVideo);
                TIMSnapshot tIMSnapshot = new TIMSnapshot();
                tIMSnapshot.setSize(video.getImage_size());
                tIMSnapshot.setHeight(video.getImage_height());
                tIMSnapshot.setWidth(video.getImage_width());
                if (!(video.getImageId() == null || video.getImage_type() == null)) {
                    tIMSnapshot.setUuid(new String(video.getImageId(), "utf-8"));
                    tIMSnapshot.setType(new String(video.getImage_type(), "utf-8"));
                }
                tIMSnapshot.setIdentifier(str);
                tIMSnapshot.setBusinessId((long) video.getBusiness_id());
                tIMSnapshot.setDownloadFlag(video.getImage_download_flag());
                StrVec image_urls = video.getImage_urls();
                for (int i2 = 0; ((long) i2) < image_urls.size(); i2++) {
                    tIMVideo.addUrl(image_urls.get(i2));
                }
                tIMVideoElem.setSnapshot(tIMSnapshot);
                if (!(video.getImage_path() == null || video.getVideo_path() == null)) {
                    tIMVideoElem.setSnapshotPath(new String(video.getImage_path(), "utf-8"));
                    tIMVideoElem.setVideoPath(new String(video.getVideo_path(), "utf-8"));
                }
            }
        } catch (Throwable th) {
            QLog.e(tag, 1, IMFunc.getExceptionInfo(th));
        }
        return tIMVideoElem;
    }

    protected static TIMElem convertFrom(Elem elem) {
        String str;
        String str2;
        String str3;
        String str4;
        cv cvVar = new cv();
        try {
            MsgElemType type2 = elem.getType();
            if (type2 == MsgElemType.kInvalid) {
                return cvVar;
            }
            if (type2 == MsgElemType.kText) {
                TIMTextElem tIMTextElem = new TIMTextElem();
                tIMTextElem.setIdentifier(new String(elem.getSelf_identifier(), "utf-8"));
                str4 = new String(elem.getText().getContent(), "utf-8");
                tIMTextElem.setText(str4);
                return tIMTextElem;
            } else if (type2 == MsgElemType.kPicNew) {
                return buildImageElem(elem);
            } else {
                int i = 0;
                if (type2 == MsgElemType.kPttNew) {
                    TIMSoundElem tIMSoundElem = new TIMSoundElem();
                    tIMSoundElem.setUuid(elem.getSound().getFileid());
                    tIMSoundElem.setDataSize((long) elem.getSound().getFile_size());
                    tIMSoundElem.setDuration((long) elem.getSound().getFile_time());
                    tIMSoundElem.setTaskId(elem.getSound().getTaskid());
                    tIMSoundElem.setBusinessId((long) elem.getSound().getBusiness_id());
                    tIMSoundElem.setDownloadFlag(elem.getSound().getDownload_flag());
                    StrVec urls = elem.getSound().getUrls();
                    while (((long) i) < urls.size()) {
                        tIMSoundElem.addUrl(urls.get(i));
                        i++;
                    }
                    try {
                        tIMSoundElem.setIdentifier(new String(elem.getSelf_identifier(), "utf-8"));
                        tIMSoundElem.setPath(new String(elem.getSound().getFile_path(), "utf-8"));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                    return tIMSoundElem;
                } else if (type2 == MsgElemType.kFile) {
                    TIMFileElem tIMFileElem = new TIMFileElem();
                    tIMFileElem.setUuid(elem.getFile().getFileid());
                    tIMFileElem.setFileSize(elem.getFile().getFile_size());
                    tIMFileElem.setTaskId(elem.getFile().getTaskid());
                    tIMFileElem.setBusinessId((long) elem.getFile().getBusiness_id());
                    tIMFileElem.setDownloadFlag(elem.getFile().getDownload_flag());
                    StrVec urls2 = elem.getFile().getUrls();
                    while (((long) i) < urls2.size()) {
                        tIMFileElem.addUrl(urls2.get(i));
                        i++;
                    }
                    try {
                        tIMFileElem.setIdentifier(new String(elem.getSelf_identifier(), "utf-8"));
                        tIMFileElem.setFileName(new String(elem.getFile().getFile_name(), "utf-8"));
                        tIMFileElem.setPath(new String(elem.getFile().getFile_path(), "utf-8"));
                    } catch (UnsupportedEncodingException e3) {
                        e3.printStackTrace();
                    }
                    return tIMFileElem;
                } else if (type2 == MsgElemType.kLocation) {
                    TIMLocationElem tIMLocationElem = new TIMLocationElem();
                    tIMLocationElem.setLongitude(elem.getLocation().getLongitude());
                    tIMLocationElem.setLatitude(elem.getLocation().getLatitude());
                    try {
                        tIMLocationElem.setIdentifier(new String(elem.getSelf_identifier(), "utf-8"));
                        str3 = new String(elem.getLocation().getDesc(), "utf-8");
                    } catch (UnsupportedEncodingException e4) {
                        e4.printStackTrace();
                        str3 = "";
                    }
                    tIMLocationElem.setDesc(str3);
                    return tIMLocationElem;
                } else if (type2 == MsgElemType.kCustom) {
                    TIMCustomElem tIMCustomElem = new TIMCustomElem();
                    byte[] ext = elem.getCustom().getExt();
                    if (ext != null && ext.length > 0) {
                        tIMCustomElem.setExt(ext);
                    }
                    tIMCustomElem.setData(elem.getCustom().getData());
                    tIMCustomElem.setSound(elem.getCustom().getSound());
                    tIMCustomElem.setExt(elem.getCustom().getExt());
                    try {
                        tIMCustomElem.setIdentifier(new String(elem.getSelf_identifier(), "utf-8"));
                        str2 = new String(elem.getCustom().getDesc(), "utf-8");
                    } catch (UnsupportedEncodingException e5) {
                        e5.printStackTrace();
                        str2 = "";
                    }
                    tIMCustomElem.setDesc(str2);
                    return tIMCustomElem;
                } else if (type2 == MsgElemType.kFace) {
                    TIMFaceElem tIMFaceElem = new TIMFaceElem();
                    try {
                        tIMFaceElem.setIdentifier(new String(elem.getSelf_identifier(), "utf-8"));
                    } catch (UnsupportedEncodingException e6) {
                        e6.printStackTrace();
                    }
                    tIMFaceElem.setData(elem.getFace().getBuf());
                    tIMFaceElem.setIndex(elem.getFace().getIndex());
                    return tIMFaceElem;
                } else if (type2 == MsgElemType.kGroupTips) {
                    TIMGroupTipsElem tIMGroupTipsElem = new TIMGroupTipsElem(elem.getGroup_tips());
                    try {
                        tIMGroupTipsElem.setIdentifier(new String(elem.getSelf_identifier(), "utf-8"));
                    } catch (UnsupportedEncodingException e7) {
                        e7.printStackTrace();
                    }
                    return tIMGroupTipsElem;
                } else if (type2 == MsgElemType.kGroupReport) {
                    TIMGroupSystemElem tIMGroupSystemElem = new TIMGroupSystemElem(elem.getGroup_report());
                    try {
                        tIMGroupSystemElem.setIdentifier(new String(elem.getSelf_identifier(), "utf-8"));
                    } catch (UnsupportedEncodingException e8) {
                        e8.printStackTrace();
                    }
                    return tIMGroupSystemElem;
                } else if (type2 == MsgElemType.kFriendChange) {
                    TIMSNSSystemElem tIMSNSSystemElem = new TIMSNSSystemElem();
                    tIMSNSSystemElem.setSubType(elem.getFriend_change().getType());
                    FriendChangeInfoVec users = elem.getFriend_change().getUsers();
                    while (((long) i) < users.size()) {
                        TIMSNSChangeInfo tIMSNSChangeInfo = new TIMSNSChangeInfo(users.get(i));
                        tIMSNSSystemElem.setPendencyReportTimestamp(elem.getFriend_change().getDdwPendencyReportTimestamp());
                        tIMSNSSystemElem.setDecideReportTimestamp(elem.getFriend_change().getDdwDecideReportTimestamp());
                        tIMSNSSystemElem.setRecommendReportTimestamp(elem.getFriend_change().getDdwRecommendReportTimestamp());
                        tIMSNSSystemElem.getChangeInfoList().add(tIMSNSChangeInfo);
                        i++;
                    }
                    try {
                        tIMSNSSystemElem.setIdentifier(new String(elem.getSelf_identifier(), "utf-8"));
                    } catch (UnsupportedEncodingException e9) {
                        e9.printStackTrace();
                    }
                    return tIMSNSSystemElem;
                } else if (type2 == MsgElemType.kProfileChange) {
                    TIMProfileSystemElem tIMProfileSystemElem = new TIMProfileSystemElem();
                    tIMProfileSystemElem.setSubType(elem.getProfile_change().getType());
                    tIMProfileSystemElem.setFromUser(elem.getProfile_change().getFrom());
                    try {
                        tIMProfileSystemElem.setIdentifier(new String(elem.getSelf_identifier(), "utf-8"));
                        str = new String(elem.getProfile_change().getNick(), "utf-8");
                    } catch (UnsupportedEncodingException e10) {
                        e10.printStackTrace();
                        str = "";
                    }
                    tIMProfileSystemElem.setNickName(str);
                    return tIMProfileSystemElem;
                } else if (type2 == MsgElemType.kVideo) {
                    return buildVideoElem(elem);
                } else {
                    if (type2 == MsgElemType.kUGC) {
                        try {
                            return (TIMElem) Class.forName("com.tencent.imsdk.ext.ugc.IMUGCExtBridge").getMethod("ugcElemConvertFromInternal", new Class[]{UGCElem.class}).invoke((Object) null, new Object[]{elem.getUgc()});
                        } catch (Throwable th) {
                            QLog.e(tag, 1, "ugc ext is needed." + QLog.getStackTraceString(th));
                        }
                    }
                    return cvVar;
                }
            }
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
            str4 = "";
        } catch (Throwable th2) {
            QLog.e(tag, 1, IMFunc.getExceptionInfo(th2));
            return cvVar;
        }
    }

    /* access modifiers changed from: protected */
    public Elem convertTo() {
        if (getType() == TIMElemType.Invalid) {
            return null;
        }
        Elem elem = new Elem();
        if (getType() == TIMElemType.Text) {
            elem.setType(MsgElemType.kText);
            TextElem textElem = new TextElem();
            try {
                textElem.setContent(((TIMTextElem) this).getText().getBytes("utf-8"));
                elem.setText(textElem);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else if (getType() == TIMElemType.Image) {
            elem.setType(MsgElemType.kPicNew);
            ImageElem imageElem = new ImageElem();
            TIMImageElem tIMImageElem = (TIMImageElem) this;
            if (tIMImageElem.getPath() == null) {
                return null;
            }
            imageElem.setLevel(tIMImageElem.getLevel());
            imageElem.setFormat(tIMImageElem.getImageFormat());
            try {
                elem.setResource(tIMImageElem.getPath().getBytes("utf-8"));
                elem.setImage(imageElem);
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        } else if (getType() == TIMElemType.Sound) {
            elem.setType(MsgElemType.kPttNew);
            SoundElem soundElem = new SoundElem();
            TIMSoundElem tIMSoundElem = (TIMSoundElem) this;
            if (TextUtils.isEmpty(tIMSoundElem.getPath())) {
                return null;
            }
            soundElem.setFile_time((int) tIMSoundElem.getDuration());
            soundElem.setFile_size((int) tIMSoundElem.getDataSize());
            if (!TextUtils.isEmpty(tIMSoundElem.getPath())) {
                try {
                    soundElem.setFile_path(tIMSoundElem.getPath().getBytes("utf-8"));
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                }
            }
            elem.setSound(soundElem);
        } else if (getType() == TIMElemType.File) {
            elem.setType(MsgElemType.kFile);
            FileElem fileElem = new FileElem();
            TIMFileElem tIMFileElem = (TIMFileElem) this;
            if (TextUtils.isEmpty(tIMFileElem.getPath())) {
                return null;
            }
            try {
                if (!TextUtils.isEmpty(tIMFileElem.getPath())) {
                    fileElem.setFile_path(tIMFileElem.getPath().getBytes("utf-8"));
                }
                if (!TextUtils.isEmpty(tIMFileElem.getFileName())) {
                    fileElem.setFile_name(tIMFileElem.getFileName().getBytes("utf-8"));
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            fileElem.setFile_size(tIMFileElem.getFileSize());
            elem.setFile(fileElem);
        } else if (getType() == TIMElemType.Custom) {
            elem.setType(MsgElemType.kCustom);
            CustomElem customElem = new CustomElem();
            TIMCustomElem tIMCustomElem = (TIMCustomElem) this;
            customElem.setData(tIMCustomElem.getData());
            customElem.setExt(tIMCustomElem.getExt());
            customElem.setSound(tIMCustomElem.getSound());
            try {
                customElem.setDesc(tIMCustomElem.getDesc().getBytes("utf-8"));
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            elem.setCustom(customElem);
        } else if (getType() == TIMElemType.Location) {
            elem.setType(MsgElemType.kLocation);
            LocationElem locationElem = new LocationElem();
            TIMLocationElem tIMLocationElem = (TIMLocationElem) this;
            try {
                locationElem.setDesc(tIMLocationElem.getDesc().getBytes("utf-8"));
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            locationElem.setLatitude(tIMLocationElem.getLatitude());
            locationElem.setLongitude(tIMLocationElem.getLongitude());
            elem.setLocation(locationElem);
        } else if (getType() == TIMElemType.Face) {
            elem.setType(MsgElemType.kFace);
            FaceElem faceElem = new FaceElem();
            TIMFaceElem tIMFaceElem = (TIMFaceElem) this;
            faceElem.setIndex(tIMFaceElem.getIndex());
            if (tIMFaceElem.getData() != null) {
                faceElem.setBuf(tIMFaceElem.getData());
            }
            elem.setFace(faceElem);
        } else if (getType() == TIMElemType.Video) {
            elem.setType(MsgElemType.kVideo);
            VideoElem videoElem = new VideoElem();
            TIMVideoElem tIMVideoElem = (TIMVideoElem) this;
            if (tIMVideoElem.getSnapshotPath() == null || tIMVideoElem.getSnapshotPath().length() == 0 || tIMVideoElem.getSnapshotInfo() == null || tIMVideoElem.getSnapshotInfo().getType() == null || tIMVideoElem.getVideoPath() == null || tIMVideoElem.getVideoPath().length() == 0 || tIMVideoElem.getVideoInfo() == null || tIMVideoElem.getVideoInfo().getType() == null) {
                return null;
            }
            try {
                videoElem.setVideo_path(tIMVideoElem.getVideoPath().getBytes("utf-8"));
                videoElem.setImage_path(tIMVideoElem.getSnapshotPath().getBytes("utf-8"));
                videoElem.setImage_type(tIMVideoElem.getSnapshotInfo().getType().getBytes("utf-8"));
                videoElem.setVideo_type(tIMVideoElem.getVideoInfo().getType().getBytes("utf-8"));
            } catch (UnsupportedEncodingException e8) {
                e8.printStackTrace();
            }
            videoElem.setImage_height(tIMVideoElem.getSnapshotInfo().getHeight());
            videoElem.setImage_width(tIMVideoElem.getSnapshotInfo().getWidth());
            videoElem.setVideo_duration(tIMVideoElem.getVideoInfo().getDuaration());
            elem.setVideo(videoElem);
        } else {
            if (getType() == TIMElemType.UGC) {
                try {
                    return (Elem) Class.forName("com.tencent.imsdk.ext.ugc.IMUGCExtBridge").getMethod("ugcElemConvertToInternal", new Class[]{TIMElem.class}).invoke((Object) null, new Object[]{this});
                } catch (Throwable unused) {
                    QLog.e(tag, 1, "ugc ext is needed");
                }
            }
            return null;
        }
        return elem;
    }

    public TIMElemType getType() {
        return this.type;
    }

    /* access modifiers changed from: protected */
    public void setIdentifier(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.identifier = str;
        }
    }
}
