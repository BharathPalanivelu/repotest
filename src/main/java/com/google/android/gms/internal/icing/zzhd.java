package com.google.android.gms.internal.icing;

public final class zzhd implements zzha {
    private static final zzbo<Boolean> zzqw;
    private static final zzbo<Boolean> zzqx;
    private static final zzbo<Boolean> zzqy;
    private static final zzbo<Boolean> zzqz;
    private static final zzbo<Boolean> zzra;
    private static final zzbo<Boolean> zzrb;
    private static final zzbo<Boolean> zzrc;
    private static final zzbo<Boolean> zzrd;
    private static final zzbo<Boolean> zzre;
    private static final zzbo<Boolean> zzrf;
    private static final zzbo<Boolean> zzrg;
    private static final zzbo<Boolean> zzrh;
    private static final zzbo<Boolean> zzri;
    private static final zzbo<Boolean> zzrj;
    private static final zzbo<Boolean> zzrk;
    private static final zzbo<Boolean> zzrl;
    private static final zzbo<Boolean> zzrm;
    private static final zzbo<Boolean> zzrn;
    private static final zzbo<Boolean> zzro;
    private static final zzbo<Boolean> zzrp;

    public final boolean zzec() {
        return zzrc.get().booleanValue();
    }

    static {
        zzbp zzbp = new zzbp(zzbl.zzl("com.google.android.gms.icing"));
        zzqw = zzbp.zza("block_action_upload_if_data_sharing_disabled", false);
        zzqx = zzbp.zza("disable_remove_fanout_for_messaging", true);
        zzqy = zzbp.zza("disable_update_fanout_for_messaging", true);
        zzqz = zzbp.zza("enable_accurate_errors_for_validate_corpus_keys", false);
        zzra = zzbp.zza("enable_actionsv2_using_unified_indexing", false);
        zzrb = zzbp.zza("enable_additional_type_for_email", false);
        zzrc = zzbp.zza("enable_client_grant_slice_permission", true);
        zzrd = zzbp.zza("gms_icing_corpus_schema_store_as_ground_truth", false);
        zzre = zzbp.zza("enable_custom_action_url_generation", false);
        zzrf = zzbp.zza("enable_failure_response_for_apitask_exceptions", false);
        zzrg = zzbp.zza("enable_message_section_for_clock_types", false);
        zzrh = zzbp.zza("enable_on_device_sharing_control_ui", false);
        zzri = zzbp.zza("enable_on_device_sharing_control_ui_text_top", false);
        zzrj = zzbp.zza("enable_safe_app_indexing_package_removal", false);
        zzrk = zzbp.zza("enable_safe_index_cleanup", true);
        zzrl = zzbp.zza("enable_slice_authority_validation", false);
        zzrm = zzbp.zza("enable_st_nary_logical_operator", false);
        zzrn = zzbp.zza("redirect_user_actions_from_persistent_to_main", false);
        zzro = zzbp.zza("type_access_whitelist_enforce_platform_permissions", false);
        zzrp = zzbp.zza("unified_indexing_request_queue", false);
    }
}
