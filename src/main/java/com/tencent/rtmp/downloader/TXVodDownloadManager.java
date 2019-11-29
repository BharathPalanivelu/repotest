package com.tencent.rtmp.downloader;

import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import com.tencent.ijk.media.player.IjkDownloadCenter;
import com.tencent.ijk.media.player.IjkDownloadMedia;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.f;
import com.tencent.liteav.network.g;
import com.tencent.liteav.network.i;
import com.tencent.liteav.network.j;
import com.tencent.rtmp.TXPlayerAuthBuilder;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class TXVodDownloadManager {
    public static final int DOWNLOAD_AUTH_FAILED = -5001;
    public static final int DOWNLOAD_DISCONNECT = -5005;
    public static final int DOWNLOAD_FORMAT_ERROR = -5004;
    public static final int DOWNLOAD_HLS_KEY_ERROR = -5006;
    public static final int DOWNLOAD_NO_FILE = -5003;
    public static final int DOWNLOAD_PATH_ERROR = -5007;
    public static final int DOWNLOAD_SUCCESS = 0;
    private static final int IJKDM_EVT_FILE_OPEN_ERROR = 1008;
    private static final int IJKDM_EVT_HLS_KEY_ERROR = 1008;
    private static final int IJKDM_EVT_NET_DISCONNECT = 1001;
    private static final String TAG = "TXVodDownloadManager";
    private static TXVodDownloadManager instance;
    protected IjkDownloadCenter mDownloadCenter = IjkDownloadCenter.getInstance();
    IjkDownloadCenter.OnDownloadListener mDownloadCenterListener = new IjkDownloadCenter.OnDownloadListener() {
        public void downloadBegin(IjkDownloadCenter ijkDownloadCenter, IjkDownloadMedia ijkDownloadMedia) {
            TXVodDownloadMediaInfo convertMedia = TXVodDownloadManager.this.convertMedia(ijkDownloadMedia);
            if (convertMedia != null) {
                TXCLog.i(TXVodDownloadManager.TAG, "downloadBegin " + convertMedia.playPath);
                TXVodDownloadManager.this.mListener.onDownloadStart(convertMedia);
                if (new File(convertMedia.playPath).isFile()) {
                    TXCLog.d(TXVodDownloadManager.TAG, "file state ok");
                } else {
                    TXCLog.e(TXVodDownloadManager.TAG, "file not create!");
                }
            }
        }

        public void downloadEnd(IjkDownloadCenter ijkDownloadCenter, IjkDownloadMedia ijkDownloadMedia) {
            TXVodDownloadMediaInfo convertMedia = TXVodDownloadManager.this.convertMedia(ijkDownloadMedia);
            if (convertMedia != null) {
                TXCLog.i(TXVodDownloadManager.TAG, "downloadEnd " + convertMedia.playPath);
                TXVodDownloadManager.this.mMediaInfoArray.remove(convertMedia);
                TXVodDownloadManager.this.mListener.onDownloadStop(convertMedia);
            }
        }

        public void downloadFinish(IjkDownloadCenter ijkDownloadCenter, IjkDownloadMedia ijkDownloadMedia) {
            TXVodDownloadMediaInfo convertMedia = TXVodDownloadManager.this.convertMedia(ijkDownloadMedia);
            if (convertMedia != null) {
                TXCLog.i(TXVodDownloadManager.TAG, "downloadFinish " + convertMedia.playPath);
                TXVodDownloadManager.this.mMediaInfoArray.remove(convertMedia);
                if (new File(convertMedia.playPath).isFile()) {
                    TXVodDownloadManager.this.mListener.onDownloadFinish(convertMedia);
                } else {
                    TXVodDownloadManager.this.mListener.onDownloadError(convertMedia, TXVodDownloadManager.DOWNLOAD_NO_FILE, "文件已被删除");
                }
            }
        }

        public void downloadError(IjkDownloadCenter ijkDownloadCenter, IjkDownloadMedia ijkDownloadMedia, int i, String str) {
            TXVodDownloadMediaInfo convertMedia = TXVodDownloadManager.this.convertMedia(ijkDownloadMedia);
            if (convertMedia != null) {
                TXCLog.e(TXVodDownloadManager.TAG, "downloadError " + convertMedia.playPath + SQLBuilder.BLANK + str);
                TXVodDownloadManager.this.mMediaInfoArray.remove(convertMedia);
                if (convertMedia.isStop) {
                    TXVodDownloadManager.this.mListener.onDownloadStop(convertMedia);
                } else if (i == 1008) {
                    TXVodDownloadManager.this.mListener.onDownloadError(convertMedia, TXVodDownloadManager.DOWNLOAD_HLS_KEY_ERROR, str);
                } else {
                    TXVodDownloadManager.this.mListener.onDownloadError(convertMedia, TXVodDownloadManager.DOWNLOAD_DISCONNECT, str);
                }
            }
        }

        public void downloadProgress(IjkDownloadCenter ijkDownloadCenter, IjkDownloadMedia ijkDownloadMedia) {
            TXVodDownloadMediaInfo convertMedia = TXVodDownloadManager.this.convertMedia(ijkDownloadMedia);
            if (convertMedia != null) {
                TXVodDownloadManager.this.mListener.onDownloadProgress(convertMedia);
            }
        }

        public int hlsKeyVerify(IjkDownloadCenter ijkDownloadCenter, IjkDownloadMedia ijkDownloadMedia, String str, byte[] bArr) {
            TXVodDownloadMediaInfo convertMedia = TXVodDownloadManager.this.convertMedia(ijkDownloadMedia);
            if (convertMedia != null) {
                return TXVodDownloadManager.this.mListener.hlsKeyVerify(convertMedia, str, bArr);
            }
            return 0;
        }
    };
    protected String mDownloadPath;
    protected Map<String, String> mHeaders;
    protected ITXVodDownloadListener mListener;
    protected ArrayList<TXVodDownloadMediaInfo> mMediaInfoArray;

    private TXVodDownloadManager() {
        this.mDownloadCenter.setListener(this.mDownloadCenterListener);
        this.mMediaInfoArray = new ArrayList<>();
    }

    public static TXVodDownloadManager getInstance() {
        if (instance == null) {
            instance = new TXVodDownloadManager();
        }
        return instance;
    }

    public void setDownloadPath(String str) {
        if (str != null) {
            new File(str).mkdirs();
            this.mDownloadPath = str;
        }
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
        this.mDownloadCenter.setHeaders(map);
    }

    public void setListener(ITXVodDownloadListener iTXVodDownloadListener) {
        this.mListener = iTXVodDownloadListener;
    }

    public TXVodDownloadMediaInfo startDownloadUrl(String str) {
        TXVodDownloadMediaInfo tXVodDownloadMediaInfo = new TXVodDownloadMediaInfo();
        tXVodDownloadMediaInfo.url = str;
        this.mMediaInfoArray.add(tXVodDownloadMediaInfo);
        downloadMedia(tXVodDownloadMediaInfo);
        return tXVodDownloadMediaInfo;
    }

    public TXVodDownloadMediaInfo startDownload(final TXVodDownloadDataSource tXVodDownloadDataSource) {
        final TXVodDownloadMediaInfo tXVodDownloadMediaInfo = new TXVodDownloadMediaInfo();
        tXVodDownloadMediaInfo.dataSource = tXVodDownloadDataSource;
        if (tXVodDownloadDataSource.authBuilder == null) {
            return null;
        }
        TXPlayerAuthBuilder tXPlayerAuthBuilder = tXVodDownloadDataSource.authBuilder;
        f fVar = new f();
        fVar.a(tXPlayerAuthBuilder.isHttps());
        fVar.a((g) new g() {
            public void onNetSuccess(f fVar) {
                if (tXVodDownloadMediaInfo.isStop) {
                    TXVodDownloadManager.this.mMediaInfoArray.remove(tXVodDownloadMediaInfo);
                    if (TXVodDownloadManager.this.mListener != null) {
                        TXVodDownloadManager.this.mListener.onDownloadStop(tXVodDownloadMediaInfo);
                    }
                    TXCLog.w(TXVodDownloadManager.TAG, "已取消下载任务");
                    return;
                }
                i a2 = fVar.a();
                j jVar = null;
                if (tXVodDownloadDataSource.quality != 1000) {
                    jVar = TXVodDownloadManager.this.getClassificationSource(a2, tXVodDownloadDataSource.quality);
                } else if (tXVodDownloadDataSource.templateName != null) {
                    jVar = TXVodDownloadManager.this.getTemplateSource(a2, tXVodDownloadDataSource.templateName);
                }
                if (jVar == null) {
                    TXVodDownloadManager.this.mMediaInfoArray.remove(tXVodDownloadMediaInfo);
                    if (TXVodDownloadManager.this.mListener != null) {
                        TXVodDownloadManager.this.mListener.onDownloadError(tXVodDownloadMediaInfo, TXVodDownloadManager.DOWNLOAD_NO_FILE, "无此清晰度");
                        return;
                    }
                    return;
                }
                tXVodDownloadMediaInfo.url = jVar.b();
                tXVodDownloadMediaInfo.size = jVar.d();
                tXVodDownloadMediaInfo.duration = jVar.c();
                TXVodDownloadManager.this.downloadMedia(tXVodDownloadMediaInfo);
            }

            public void onNetFailed(f fVar, String str, int i) {
                TXVodDownloadManager.this.mMediaInfoArray.remove(tXVodDownloadMediaInfo);
                if (TXVodDownloadManager.this.mListener != null) {
                    TXVodDownloadManager.this.mListener.onDownloadError(tXVodDownloadMediaInfo, TXVodDownloadManager.DOWNLOAD_AUTH_FAILED, str);
                }
            }
        });
        if (fVar.a(tXPlayerAuthBuilder.getAppId(), tXPlayerAuthBuilder.getFileId(), tXPlayerAuthBuilder.getTimeout(), tXPlayerAuthBuilder.getUs(), tXPlayerAuthBuilder.getExper(), tXPlayerAuthBuilder.getSign()) == 0) {
            tXVodDownloadMediaInfo.netApi = fVar;
            this.mMediaInfoArray.add(tXVodDownloadMediaInfo);
            return tXVodDownloadMediaInfo;
        }
        TXCLog.e(TAG, "unable to getPlayInfo");
        return null;
    }

    public void stopDownload(TXVodDownloadMediaInfo tXVodDownloadMediaInfo) {
        if (tXVodDownloadMediaInfo != null) {
            tXVodDownloadMediaInfo.isStop = true;
            if (tXVodDownloadMediaInfo.tid < 0) {
                TXCLog.w(TAG, "stop download not start task");
                return;
            }
            this.mDownloadCenter.stop(tXVodDownloadMediaInfo.tid);
            TXCLog.d(TAG, "stop download " + tXVodDownloadMediaInfo.url);
        }
    }

    public boolean deleteDownloadFile(String str) {
        TXCLog.d(TAG, "delete file " + str);
        Iterator<TXVodDownloadMediaInfo> it = this.mMediaInfoArray.iterator();
        while (it.hasNext()) {
            TXVodDownloadMediaInfo next = it.next();
            if (next.playPath != null && next.playPath.equals(str)) {
                TXCLog.e(TAG, "file is downloading, can not be delete");
                return false;
            }
        }
        new File(str).delete();
        TXCLog.e(TAG, "delete success");
        return true;
    }

    /* access modifiers changed from: protected */
    public void downloadMedia(TXVodDownloadMediaInfo tXVodDownloadMediaInfo) {
        String str = tXVodDownloadMediaInfo.url;
        if (str != null) {
            if (Uri.parse(str).getPath().endsWith(".m3u8")) {
                tXVodDownloadMediaInfo.playPath = makePlayPath(str);
                if (tXVodDownloadMediaInfo.playPath == null) {
                    ITXVodDownloadListener iTXVodDownloadListener = this.mListener;
                    if (iTXVodDownloadListener != null) {
                        iTXVodDownloadListener.onDownloadError(tXVodDownloadMediaInfo, DOWNLOAD_PATH_ERROR, "本地路径创建失败");
                        return;
                    }
                    return;
                }
                if (!(tXVodDownloadMediaInfo.dataSource == null || tXVodDownloadMediaInfo.dataSource.token == null)) {
                    String[] split = str.split(Constants.URL_PATH_DELIMITER);
                    if (split.length > 0) {
                        int lastIndexOf = str.lastIndexOf(split[split.length - 1]);
                        str = str.substring(0, lastIndexOf) + "voddrm.token." + tXVodDownloadMediaInfo.dataSource.token + "." + str.substring(lastIndexOf);
                    }
                }
                TXCLog.d(TAG, "download hls " + str + " to " + tXVodDownloadMediaInfo.playPath);
                tXVodDownloadMediaInfo.tid = this.mDownloadCenter.downloadHls(str, tXVodDownloadMediaInfo.playPath);
                if (tXVodDownloadMediaInfo.tid < 0) {
                    TXCLog.e(TAG, "start download failed");
                    ITXVodDownloadListener iTXVodDownloadListener2 = this.mListener;
                    if (iTXVodDownloadListener2 != null) {
                        iTXVodDownloadListener2.onDownloadError(tXVodDownloadMediaInfo, DOWNLOAD_FORMAT_ERROR, "Internal error");
                        return;
                    }
                    return;
                }
                return;
            }
            TXCLog.e(TAG, "format error: " + str);
            ITXVodDownloadListener iTXVodDownloadListener3 = this.mListener;
            if (iTXVodDownloadListener3 != null) {
                iTXVodDownloadListener3.onDownloadError(tXVodDownloadMediaInfo, DOWNLOAD_FORMAT_ERROR, "No support format");
            }
        }
    }

    /* access modifiers changed from: protected */
    public String makePlayPath(String str) {
        String str2 = this.mDownloadPath + "/txdownload";
        File file = new File(str2);
        if ((!file.exists() || !file.isDirectory()) && !file.mkdir()) {
            TXCLog.e(TAG, "创建下载路径失败 " + str2);
            return null;
        } else if (Uri.parse(str).getPath().endsWith(".m3u8")) {
            return str2 + Constants.URL_PATH_DELIMITER + md5(str) + ".m3u8.sqlite";
        } else {
            TXCLog.e(TAG, "不支持格式");
            return null;
        }
    }

    protected static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b2 : MessageDigest.getInstance(Hash.ALGORITHM_MD5).digest(str.getBytes())) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public j getClassificationSource(i iVar, int i) {
        if (i == 0) {
            return iVar.d();
        }
        return iVar.a(TXVodDownloadDataSource.qualityToId(i), "hls");
    }

    /* access modifiers changed from: package-private */
    public j getTemplateSource(i iVar, String str) {
        return iVar.b(str, "hls");
    }

    /* access modifiers changed from: package-private */
    public TXVodDownloadMediaInfo convertMedia(IjkDownloadMedia ijkDownloadMedia) {
        Iterator<TXVodDownloadMediaInfo> it = this.mMediaInfoArray.iterator();
        while (it.hasNext()) {
            TXVodDownloadMediaInfo next = it.next();
            if (next.tid == ijkDownloadMedia.tid) {
                next.downloadSize = ijkDownloadMedia.downloadSize;
                if (next.size == 0) {
                    next.size = ijkDownloadMedia.size;
                }
                return next;
            }
        }
        return null;
    }
}
