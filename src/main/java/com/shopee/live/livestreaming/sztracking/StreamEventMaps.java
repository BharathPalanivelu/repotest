package com.shopee.live.livestreaming.sztracking;

import android.util.SparseArray;
import com.tencent.rtmp.TXLiveConstants;

public class StreamEventMaps {
    static final String PLAY_CUSTOM_BLACK_SCREEN_FOR_FIRST_TIME_CONNECT = "PLAY_CUSTOM_BLACK_SCREEN_FOR_FIRST_TIME_CONNECT";
    static final String PLAY_CUSTOM_BLACK_SCREEN_FOR_RECONNECT = "PLAY_CUSTOM_BLACK_SCREEN_FOR_RECONNECT";
    static final String PLAY_CUSTOM_LOW_FPS = "PLAY_CUSTOM_LOW_FPS";
    static final String PLAY_CUSTOM_WEAK_NETWORK = "PLAY_CUSTOM_WEAK_NETWORK";
    private static final String PLAY_ERR_FILE_NOT_FOUND = "PLAY_ERR_FILE_NOT_FOUND";
    private static final String PLAY_ERR_GET_PLAYINFO_FAIL = "PLAY_ERR_GET_PLAYINFO_FAIL";
    private static final String PLAY_ERR_GET_RTMP_ACC_URL_FAIL = "PLAY_ERR_GET_RTMP_ACC_URL_FAIL";
    private static final String PLAY_ERR_HEVC_DECODE_FAIL = "PLAY_ERR_HEVC_DECODE_FAIL";
    private static final String PLAY_ERR_HLS_KEY = "PLAY_ERR_HLS_KEY";
    private static final String PLAY_ERR_NET_DISCONNECT = "PLAY_ERR_NET_DISCONNECT";
    private static final String PLAY_ERR_STREAM_SWITCH_FAIL = "PLAY_ERR_STREAM_SWITCH_FAIL";
    private static final String PLAY_EVT_CHANGE_RESOLUTION = "PLAY_EVT_CHANGE_RESOLUTION";
    private static final String PLAY_EVT_CHANGE_ROTATION = "PLAY_EVT_CHANGE_ROTATION";
    private static final String PLAY_EVT_CONNECT_SUCC = "PLAY_EVT_CONNECT_SUCC";
    private static final String PLAY_EVT_GET_MESSAGE = "PLAY_EVT_GET_MESSAGE";
    private static final String PLAY_EVT_GET_PLAYINFO_SUCC = "PLAY_EVT_GET_PLAYINFO_SUCC";
    private static final String PLAY_EVT_PLAY_BEGIN = "PLAY_EVT_PLAY_BEGIN";
    private static final String PLAY_EVT_PLAY_END = "PLAY_EVT_PLAY_END";
    private static final String PLAY_EVT_PLAY_LOADING = "PLAY_EVT_PLAY_LOADING";
    private static final String PLAY_EVT_PLAY_PROGRESS = "PLAY_EVT_PLAY_PROGRESS";
    private static final String PLAY_EVT_RCV_FIRST_I_FRAME = "PLAY_EVT_RCV_FIRST_I_FRAME";
    private static final String PLAY_EVT_RTMP_STREAM_BEGIN = "PLAY_EVT_RTMP_STREAM_BEGIN";
    private static final String PLAY_EVT_START_VIDEO_DECODER = "PLAY_EVT_START_VIDEO_DECODER";
    private static final String PLAY_EVT_STREAM_SWITCH_SUCC = "PLAY_EVT_STREAM_SWITCH_SUCC";
    private static final String PLAY_EVT_VOD_LOADING_END = "PLAY_EVT_VOD_LOADING_END";
    private static final String PLAY_EVT_VOD_PLAY_PREPARED = "PLAY_EVT_VOD_PLAY_PREPARED";
    private static final String PLAY_WARNING_AUDIO_DECODE_FAIL = "PLAY_WARNING_AUDIO_DECODE_FAIL";
    private static final String PLAY_WARNING_DNS_FAIL = "PLAY_WARNING_DNS_FAIL";
    private static final String PLAY_WARNING_FIRST_IDR_HW_DECODE_FAIL = "PLAY_WARNING_FIRST_IDR_HW_DECODE_FAIL";
    private static final String PLAY_WARNING_HW_ACCELERATION_FAIL = "PLAY_WARNING_HW_ACCELERATION_FAIL";
    private static final String PLAY_WARNING_READ_WRITE_FAIL = "PLAY_WARNING_READ_WRITE_FAIL";
    private static final String PLAY_WARNING_RECONNECT = "PLAY_WARNING_RECONNECT";
    private static final String PLAY_WARNING_RECV_DATA_LAG = "PLAY_WARNING_RECV_DATA_LAG";
    private static final String PLAY_WARNING_SEVER_CONN_FAIL = "PLAY_WARNING_SEVER_CONN_FAIL";
    private static final String PLAY_WARNING_SHAKE_FAIL = "PLAY_WARNING_SHAKE_FAIL";
    private static final String PLAY_WARNING_VIDEO_DECODE_FAIL = "PLAY_WARNING_VIDEO_DECODE_FAIL";
    private static final String PLAY_WARNING_VIDEO_DISCONTINUITY = "PLAY_WARNING_VIDEO_DISCONTINUITY";
    private static final String PLAY_WARNING_VIDEO_PLAY_LAG = "PLAY_WARNING_VIDEO_PLAY_LAG";
    private static final String PUSH_ERR_AUDIO_ENCODE_FAIL = "PUSH_ERR_AUDIO_ENCODE_FAIL";
    private static final String PUSH_ERR_INVALID_ADDRESS = "PUSH_ERR_INVALID_ADDRESS";
    private static final String PUSH_ERR_MIC_RECORD_FAIL = "PUSH_ERR_MIC_RECORD_FAIL";
    private static final String PUSH_ERR_NET_DISCONNECT = "PUSH_ERR_NET_DISCONNECT";
    private static final String PUSH_ERR_OPEN_CAMERA_FAIL = "PUSH_ERR_OPEN_CAMERA_FAIL";
    private static final String PUSH_ERR_OPEN_MIC_FAIL = "PUSH_ERR_OPEN_MIC_FAIL";
    private static final String PUSH_ERR_SCREEN_CAPTURE_DISTURBED = "PUSH_ERR_SCREEN_CAPTURE_DISTURBED";
    private static final String PUSH_ERR_SCREEN_CAPTURE_START_FAILED = "PUSH_ERR_SCREEN_CAPTURE_START_FAILED";
    private static final String PUSH_ERR_SCREEN_CAPTURE_SWITCH_DISPLAY_FAILED = "PUSH_ERR_SCREEN_CAPTURE_SWITCH_DISPLAY_FAILED";
    private static final String PUSH_ERR_SCREEN_CAPTURE_UNSURPORT = "PUSH_ERR_SCREEN_CAPTURE_UNSURPORT";
    private static final String PUSH_ERR_UNSUPPORTED_RESOLUTION = "PUSH_ERR_UNSUPPORTED_RESOLUTION";
    private static final String PUSH_ERR_UNSUPPORTED_SAMPLERATE = "PUSH_ERR_UNSUPPORTED_SAMPLERATE";
    private static final String PUSH_ERR_VIDEO_ENCODE_FAIL = "PUSH_ERR_VIDEO_ENCODE_FAIL";
    private static final String PUSH_EVT_CHANGE_BITRATE = "PUSH_EVT_CHANGE_BITRATE";
    private static final String PUSH_EVT_CHANGE_RESOLUTION = "PUSH_EVT_CHANGE_RESOLUTION";
    private static final String PUSH_EVT_CONNECT_SUCC = "PUSH_EVT_CONNECT_SUCC";
    private static final String PUSH_EVT_FIRST_FRAME_AVAILABLE = "PUSH_EVT_FIRST_FRAME_AVAILABLE";
    private static final String PUSH_EVT_OPEN_CAMERA_SUCC = "PUSH_EVT_OPEN_CAMERA_SUCC";
    private static final String PUSH_EVT_PUSH_BEGIN = "PUSH_EVT_PUSH_BEGIN";
    private static final String PUSH_EVT_ROOM_IN = "PUSH_EVT_ROOM_IN";
    private static final String PUSH_EVT_ROOM_NEED_REENTER = "PUSH_EVT_ROOM_NEED_REENTER";
    private static final String PUSH_EVT_ROOM_OUT = "PUSH_EVT_ROOM_OUT";
    private static final String PUSH_EVT_ROOM_USERLIST = "PUSH_EVT_ROOM_USERLIST";
    private static final String PUSH_EVT_SCREEN_CAPTURE_SUCC = "PUSH_EVT_SCREEN_CAPTURE_SUCC";
    private static final String PUSH_EVT_START_VIDEO_ENCODER = "PUSH_EVT_START_VIDEO_ENCODER";
    private static final String PUSH_WARNING_BEAUTYSURFACE_VIEW_INIT_FAIL = "PUSH_WARNING_BEAUTYSURFACE_VIEW_INIT_FAIL";
    private static final String PUSH_WARNING_DNS_FAIL = "PUSH_WARNING_DNS_FAIL";
    private static final String PUSH_WARNING_HW_ACCELERATION_FAIL = "PUSH_WARNING_HW_ACCELERATION_FAIL";
    private static final String PUSH_WARNING_NET_BUSY = "PUSH_WARNING_NET_BUSY";
    private static final String PUSH_WARNING_READ_WRITE_FAIL = "PUSH_WARNING_READ_WRITE_FAIL";
    private static final String PUSH_WARNING_RECONNECT = "PUSH_WARNING_RECONNECT";
    private static final String PUSH_WARNING_SERVER_DISCONNECT = "PUSH_WARNING_SERVER_DISCONNECT";
    private static final String PUSH_WARNING_SEVER_CONN_FAIL = "PUSH_WARNING_SEVER_CONN_FAIL";
    private static final String PUSH_WARNING_SHAKE_FAIL = "PUSH_WARNING_SHAKE_FAIL";
    private static final String PUSH_WARNING_VIDEO_ENCODE_BITRATE_OVERFLOW = "PUSH_WARNING_VIDEO_ENCODE_BITRATE_OVERFLOW";
    private static final String PUSH_WARNING_VIDEO_ENCODE_FAIL = "PUSH_WARNING_VIDEO_ENCODE_FAIL";
    private static final String PUSH_WARNING_VIDEO_ENCODE_SW_SWITCH_HW = "PUSH_WARNING_VIDEO_ENCODE_SW_SWITCH_HW";
    private static StreamEventMaps sInstance;
    private SparseArray<String> mMap = new SparseArray<>();
    private SparseArray<String> mPlayEventMap;

    public static StreamEventMaps getInstance() {
        if (sInstance == null) {
            synchronized (SZTrackingReporter.class) {
                if (sInstance == null) {
                    sInstance = new StreamEventMaps();
                }
            }
        }
        return sInstance;
    }

    private StreamEventMaps() {
        this.mMap.put(1001, PUSH_EVT_CONNECT_SUCC);
        this.mMap.put(1002, PUSH_EVT_PUSH_BEGIN);
        this.mMap.put(1003, PUSH_EVT_OPEN_CAMERA_SUCC);
        this.mMap.put(1004, PUSH_EVT_SCREEN_CAPTURE_SUCC);
        this.mMap.put(1005, PUSH_EVT_CHANGE_RESOLUTION);
        this.mMap.put(1006, PUSH_EVT_CHANGE_BITRATE);
        this.mMap.put(1007, PUSH_EVT_FIRST_FRAME_AVAILABLE);
        this.mMap.put(1008, PUSH_EVT_START_VIDEO_ENCODER);
        this.mMap.put(1018, PUSH_EVT_ROOM_IN);
        this.mMap.put(1019, PUSH_EVT_ROOM_OUT);
        this.mMap.put(1020, PUSH_EVT_ROOM_USERLIST);
        this.mMap.put(1021, PUSH_EVT_ROOM_NEED_REENTER);
        this.mMap.put(-1301, PUSH_ERR_OPEN_CAMERA_FAIL);
        this.mMap.put(-1302, PUSH_ERR_OPEN_MIC_FAIL);
        this.mMap.put(-1303, PUSH_ERR_VIDEO_ENCODE_FAIL);
        this.mMap.put(-1304, PUSH_ERR_AUDIO_ENCODE_FAIL);
        this.mMap.put(-1305, PUSH_ERR_UNSUPPORTED_RESOLUTION);
        this.mMap.put(-1306, PUSH_ERR_UNSUPPORTED_SAMPLERATE);
        this.mMap.put(-1307, PUSH_ERR_NET_DISCONNECT);
        this.mMap.put(-1308, PUSH_ERR_SCREEN_CAPTURE_START_FAILED);
        this.mMap.put(-1309, PUSH_ERR_SCREEN_CAPTURE_UNSURPORT);
        this.mMap.put(TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_DISTURBED, PUSH_ERR_SCREEN_CAPTURE_DISTURBED);
        this.mMap.put(TXLiveConstants.PUSH_ERR_MIC_RECORD_FAIL, PUSH_ERR_MIC_RECORD_FAIL);
        this.mMap.put(TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_SWITCH_DISPLAY_FAILED, PUSH_ERR_SCREEN_CAPTURE_SWITCH_DISPLAY_FAILED);
        this.mMap.put(-1313, PUSH_ERR_INVALID_ADDRESS);
        this.mMap.put(1101, PUSH_WARNING_NET_BUSY);
        this.mMap.put(1102, PUSH_WARNING_RECONNECT);
        this.mMap.put(1103, PUSH_WARNING_HW_ACCELERATION_FAIL);
        this.mMap.put(TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_FAIL, PUSH_WARNING_VIDEO_ENCODE_FAIL);
        this.mMap.put(TXLiveConstants.PUSH_WARNING_BEAUTYSURFACE_VIEW_INIT_FAIL, PUSH_WARNING_BEAUTYSURFACE_VIEW_INIT_FAIL);
        this.mMap.put(TXLiveConstants.PUSH_WARNING_VIDEO_ENCODE_BITRATE_OVERFLOW, PUSH_WARNING_VIDEO_ENCODE_BITRATE_OVERFLOW);
        this.mMap.put(1107, PUSH_WARNING_VIDEO_ENCODE_SW_SWITCH_HW);
        this.mMap.put(3001, PUSH_WARNING_DNS_FAIL);
        this.mMap.put(3002, PUSH_WARNING_SEVER_CONN_FAIL);
        this.mMap.put(3003, PUSH_WARNING_SHAKE_FAIL);
        this.mMap.put(3004, PUSH_WARNING_SERVER_DISCONNECT);
        this.mMap.put(3005, PUSH_WARNING_READ_WRITE_FAIL);
        this.mMap.put(2001, PLAY_EVT_CONNECT_SUCC);
        this.mMap.put(2002, PLAY_EVT_RTMP_STREAM_BEGIN);
        this.mMap.put(2003, PLAY_EVT_RCV_FIRST_I_FRAME);
        this.mMap.put(2004, PLAY_EVT_PLAY_BEGIN);
        this.mMap.put(2005, PLAY_EVT_PLAY_PROGRESS);
        this.mMap.put(2006, PLAY_EVT_PLAY_END);
        this.mMap.put(2007, PLAY_EVT_PLAY_LOADING);
        this.mMap.put(2008, PLAY_EVT_START_VIDEO_DECODER);
        this.mMap.put(2009, PLAY_EVT_CHANGE_RESOLUTION);
        this.mMap.put(2010, PLAY_EVT_GET_PLAYINFO_SUCC);
        this.mMap.put(2011, PLAY_EVT_CHANGE_ROTATION);
        this.mMap.put(2012, PLAY_EVT_GET_MESSAGE);
        this.mMap.put(2013, PLAY_EVT_VOD_PLAY_PREPARED);
        this.mMap.put(2014, PLAY_EVT_VOD_LOADING_END);
        this.mMap.put(2015, PLAY_EVT_STREAM_SWITCH_SUCC);
        this.mMap.put(-2301, PLAY_ERR_NET_DISCONNECT);
        this.mMap.put(-2302, PLAY_ERR_GET_RTMP_ACC_URL_FAIL);
        this.mMap.put(-2303, PLAY_ERR_FILE_NOT_FOUND);
        this.mMap.put(-2304, PLAY_ERR_HEVC_DECODE_FAIL);
        this.mMap.put(-2305, PLAY_ERR_HLS_KEY);
        this.mMap.put(-2306, PLAY_ERR_GET_PLAYINFO_FAIL);
        this.mMap.put(-2307, PLAY_ERR_STREAM_SWITCH_FAIL);
        this.mMap.put(2101, PLAY_WARNING_VIDEO_DECODE_FAIL);
        this.mMap.put(2102, PLAY_WARNING_AUDIO_DECODE_FAIL);
        this.mMap.put(2103, PLAY_WARNING_RECONNECT);
        this.mMap.put(TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG, PLAY_WARNING_RECV_DATA_LAG);
        this.mMap.put(2105, PLAY_WARNING_VIDEO_PLAY_LAG);
        this.mMap.put(2106, PLAY_WARNING_HW_ACCELERATION_FAIL);
        this.mMap.put(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY, PLAY_WARNING_VIDEO_DISCONTINUITY);
        this.mMap.put(2108, PLAY_WARNING_FIRST_IDR_HW_DECODE_FAIL);
        this.mMap.put(3001, PLAY_WARNING_DNS_FAIL);
        this.mMap.put(3002, PLAY_WARNING_SEVER_CONN_FAIL);
        this.mMap.put(3003, PLAY_WARNING_SHAKE_FAIL);
        this.mMap.put(3005, PLAY_WARNING_READ_WRITE_FAIL);
        this.mPlayEventMap = new SparseArray<>();
        this.mPlayEventMap.put(-2301, PLAY_ERR_NET_DISCONNECT);
        this.mPlayEventMap.put(-2302, PLAY_ERR_GET_RTMP_ACC_URL_FAIL);
        this.mPlayEventMap.put(-2303, PLAY_ERR_FILE_NOT_FOUND);
        this.mPlayEventMap.put(-2304, PLAY_ERR_HEVC_DECODE_FAIL);
        this.mPlayEventMap.put(-2305, PLAY_ERR_HLS_KEY);
        this.mPlayEventMap.put(-2306, PLAY_ERR_GET_PLAYINFO_FAIL);
        this.mPlayEventMap.put(2101, PLAY_WARNING_VIDEO_DECODE_FAIL);
        this.mPlayEventMap.put(2102, PLAY_WARNING_AUDIO_DECODE_FAIL);
        this.mPlayEventMap.put(2103, PLAY_WARNING_RECONNECT);
        this.mPlayEventMap.put(TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG, PLAY_WARNING_RECV_DATA_LAG);
        this.mPlayEventMap.put(2105, PLAY_WARNING_VIDEO_PLAY_LAG);
        this.mPlayEventMap.put(2106, PLAY_WARNING_HW_ACCELERATION_FAIL);
        this.mPlayEventMap.put(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY, PLAY_WARNING_VIDEO_DISCONTINUITY);
        this.mPlayEventMap.put(2108, PLAY_WARNING_FIRST_IDR_HW_DECODE_FAIL);
        this.mPlayEventMap.put(3001, PLAY_WARNING_DNS_FAIL);
        this.mPlayEventMap.put(3002, PLAY_WARNING_SEVER_CONN_FAIL);
        this.mPlayEventMap.put(3003, PLAY_WARNING_SHAKE_FAIL);
        this.mPlayEventMap.put(3005, PLAY_WARNING_READ_WRITE_FAIL);
    }

    public String getEventName(int i) {
        return this.mMap.get(i);
    }

    public String getPlayExceptionEventName(int i) {
        return this.mPlayEventMap.get(i);
    }
}
