package com.tencent.imcore;

public class Context {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Context() {
        this(internalJNI.new_Context(), true);
    }

    protected Context(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(Context context) {
        if (context == null) {
            return 0;
        }
        return context.swigCPtr;
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                internalJNI.delete_Context(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public byte[] getA2() {
        return internalJNI.Context_a2_get(this.swigCPtr, this);
    }

    public long getBid() {
        return internalJNI.Context_bid_get(this.swigCPtr, this);
    }

    public String getCache_msg_count() {
        return internalJNI.Context_cache_msg_count_get(this.swigCPtr, this);
    }

    public String getData_dir() {
        return internalJNI.Context_data_dir_get(this.swigCPtr, this);
    }

    public IEnv getEnv() {
        long Context_env_get = internalJNI.Context_env_get(this.swigCPtr, this);
        if (Context_env_get == 0) {
            return null;
        }
        return new IEnv(Context_env_get, false);
    }

    public String getFile_cache_path() {
        return internalJNI.Context_file_cache_path_get(this.swigCPtr, this);
    }

    public SWIGTYPE_p_void getFm_guard() {
        long Context_fm_guard_get = internalJNI.Context_fm_guard_get(this.swigCPtr, this);
        if (Context_fm_guard_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(Context_fm_guard_get, false);
    }

    public SWIGTYPE_p_void getGrp_guard() {
        long Context_grp_guard_get = internalJNI.Context_grp_guard_get(this.swigCPtr, this);
        if (Context_grp_guard_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(Context_grp_guard_get, false);
    }

    public String getHttp_sso_url() {
        return internalJNI.Context_http_sso_url_get(this.swigCPtr, this);
    }

    public String getIp() {
        return internalJNI.Context_ip_get(this.swigCPtr, this);
    }

    public ILogMsgCallback getLog_cb() {
        long Context_log_cb_get = internalJNI.Context_log_cb_get(this.swigCPtr, this);
        if (Context_log_cb_get == 0) {
            return null;
        }
        return new ILogMsgCallback(Context_log_cb_get, false);
    }

    public String getLog_cb_lvl() {
        return internalJNI.Context_log_cb_lvl_get(this.swigCPtr, this);
    }

    public String getLog_file_name() {
        return internalJNI.Context_log_file_name_get(this.swigCPtr, this);
    }

    public String getLog_lvl() {
        return internalJNI.Context_log_lvl_get(this.swigCPtr, this);
    }

    public String getLog_path() {
        return internalJNI.Context_log_path_get(this.swigCPtr, this);
    }

    public String getMajor_ver() {
        return internalJNI.Context_major_ver_get(this.swigCPtr, this);
    }

    public SWIGTYPE_p_void getMm_guard() {
        long Context_mm_guard_get = internalJNI.Context_mm_guard_get(this.swigCPtr, this);
        if (Context_mm_guard_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_void(Context_mm_guard_get, false);
    }

    public long getMsg_dup_time() {
        return internalJNI.Context_msg_dup_time_get(this.swigCPtr, this);
    }

    public String getPic_cache_path() {
        return internalJNI.Context_pic_cache_path_get(this.swigCPtr, this);
    }

    public long getPlatform() {
        return internalJNI.Context_platform_get(this.swigCPtr, this);
    }

    public boolean getPrint_log() {
        return internalJNI.Context_print_log_get(this.swigCPtr, this);
    }

    public String getRevision_ver() {
        return internalJNI.Context_revision_ver_get(this.swigCPtr, this);
    }

    public long getSvr_time_diff() {
        return internalJNI.Context_svr_time_diff_get(this.swigCPtr, this);
    }

    public void setA2(byte[] bArr) {
        internalJNI.Context_a2_set(this.swigCPtr, this, bArr);
    }

    public void setBid(long j) {
        internalJNI.Context_bid_set(this.swigCPtr, this, j);
    }

    public void setCache_msg_count(String str) {
        internalJNI.Context_cache_msg_count_set(this.swigCPtr, this, str);
    }

    public void setData_dir(String str) {
        internalJNI.Context_data_dir_set(this.swigCPtr, this, str);
    }

    public void setEnv(IEnv iEnv) {
        internalJNI.Context_env_set(this.swigCPtr, this, IEnv.getCPtr(iEnv), iEnv);
    }

    public void setFile_cache_path(String str) {
        internalJNI.Context_file_cache_path_set(this.swigCPtr, this, str);
    }

    public void setFm_guard(SWIGTYPE_p_void sWIGTYPE_p_void) {
        internalJNI.Context_fm_guard_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public void setGrp_guard(SWIGTYPE_p_void sWIGTYPE_p_void) {
        internalJNI.Context_grp_guard_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public void setHttp_sso_url(String str) {
        internalJNI.Context_http_sso_url_set(this.swigCPtr, this, str);
    }

    public void setIp(String str) {
        internalJNI.Context_ip_set(this.swigCPtr, this, str);
    }

    public void setLog_cb(ILogMsgCallback iLogMsgCallback) {
        internalJNI.Context_log_cb_set(this.swigCPtr, this, ILogMsgCallback.getCPtr(iLogMsgCallback), iLogMsgCallback);
    }

    public void setLog_cb_lvl(String str) {
        internalJNI.Context_log_cb_lvl_set(this.swigCPtr, this, str);
    }

    public void setLog_file_name(String str) {
        internalJNI.Context_log_file_name_set(this.swigCPtr, this, str);
    }

    public void setLog_lvl(String str) {
        internalJNI.Context_log_lvl_set(this.swigCPtr, this, str);
    }

    public void setLog_path(String str) {
        internalJNI.Context_log_path_set(this.swigCPtr, this, str);
    }

    public void setMajor_ver(String str) {
        internalJNI.Context_major_ver_set(this.swigCPtr, this, str);
    }

    public void setMm_guard(SWIGTYPE_p_void sWIGTYPE_p_void) {
        internalJNI.Context_mm_guard_set(this.swigCPtr, this, SWIGTYPE_p_void.getCPtr(sWIGTYPE_p_void));
    }

    public void setMsg_dup_time(long j) {
        internalJNI.Context_msg_dup_time_set(this.swigCPtr, this, j);
    }

    public void setPic_cache_path(String str) {
        internalJNI.Context_pic_cache_path_set(this.swigCPtr, this, str);
    }

    public void setPlatform(long j) {
        internalJNI.Context_platform_set(this.swigCPtr, this, j);
    }

    public void setPrint_log(boolean z) {
        internalJNI.Context_print_log_set(this.swigCPtr, this, z);
    }

    public void setRevision_ver(String str) {
        internalJNI.Context_revision_ver_set(this.swigCPtr, this, str);
    }

    public void setSvr_time_diff(long j) {
        internalJNI.Context_svr_time_diff_set(this.swigCPtr, this, j);
    }
}
