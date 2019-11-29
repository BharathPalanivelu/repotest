package com.google.android.gms.internal.measurement;

import com.salesforce.android.service.common.utilities.threading.Timer;
import com.tencent.ijk.media.player.IjkMediaMeta;

public final class zzjp implements zzjq {
    private static final zzcm<Long> zzapx;
    private static final zzcm<Long> zzapy;
    private static final zzcm<String> zzapz;
    private static final zzcm<String> zzaqa;
    private static final zzcm<String> zzaqb;
    private static final zzcm<Long> zzaqc;
    private static final zzcm<Long> zzaqd;
    private static final zzcm<Long> zzaqe;
    private static final zzcm<Long> zzaqf;
    private static final zzcm<Long> zzaqg;
    private static final zzcm<Long> zzaqh;
    private static final zzcm<Long> zzaqi;
    private static final zzcm<Long> zzaqj;
    private static final zzcm<Long> zzaqk;
    private static final zzcm<Long> zzaql;
    private static final zzcm<Long> zzaqm;
    private static final zzcm<Long> zzaqn;
    private static final zzcm<String> zzaqo;
    private static final zzcm<Long> zzaqp;
    private static final zzcm<Long> zzaqq;
    private static final zzcm<Long> zzaqr;
    private static final zzcm<Long> zzaqs;
    private static final zzcm<Long> zzaqt;
    private static final zzcm<Long> zzaqu;
    private static final zzcm<Long> zzaqv;
    private static final zzcm<Long> zzaqw;
    private static final zzcm<Long> zzaqx;
    private static final zzcm<Long> zzaqy;
    private static final zzcm<Long> zzaqz;
    private static final zzcm<Long> zzara;
    private static final zzcm<Long> zzarb;
    private static final zzcm<Long> zzarc;
    private static final zzcm<Long> zzard;
    private static final zzcm<Long> zzare;
    private static final zzcm<String> zzarf;
    private static final zzcm<Long> zzarg;

    public final long zzxn() {
        return zzapx.get().longValue();
    }

    public final long zzxo() {
        return zzapy.get().longValue();
    }

    public final String zzxp() {
        return zzapz.get();
    }

    public final String zzxq() {
        return zzaqa.get();
    }

    public final String zzxr() {
        return zzaqb.get();
    }

    public final long zzxs() {
        return zzaqc.get().longValue();
    }

    public final long zzxt() {
        return zzaqd.get().longValue();
    }

    public final long zzxu() {
        return zzaqe.get().longValue();
    }

    public final long zzxv() {
        return zzaqf.get().longValue();
    }

    public final long zzxw() {
        return zzaqg.get().longValue();
    }

    public final long zzxx() {
        return zzaqh.get().longValue();
    }

    public final long zzxy() {
        return zzaqi.get().longValue();
    }

    public final long zzxz() {
        return zzaqj.get().longValue();
    }

    public final long zzya() {
        return zzaqk.get().longValue();
    }

    public final long zzyb() {
        return zzaql.get().longValue();
    }

    public final long zzyc() {
        return zzaqm.get().longValue();
    }

    public final long zzyd() {
        return zzaqn.get().longValue();
    }

    public final String zzye() {
        return zzaqo.get();
    }

    public final long zzyf() {
        return zzaqp.get().longValue();
    }

    public final long zzyg() {
        return zzaqq.get().longValue();
    }

    public final long zzyh() {
        return zzaqr.get().longValue();
    }

    public final long zzyi() {
        return zzaqs.get().longValue();
    }

    public final long zzyj() {
        return zzaqt.get().longValue();
    }

    public final long zzyk() {
        return zzaqu.get().longValue();
    }

    public final long zzyl() {
        return zzaqv.get().longValue();
    }

    public final long zzym() {
        return zzaqw.get().longValue();
    }

    public final long zzyn() {
        return zzaqx.get().longValue();
    }

    public final long zzyo() {
        return zzaqy.get().longValue();
    }

    public final long zzyp() {
        return zzaqz.get().longValue();
    }

    public final long zzyq() {
        return zzara.get().longValue();
    }

    public final long zzyr() {
        return zzarb.get().longValue();
    }

    public final long zzys() {
        return zzarc.get().longValue();
    }

    public final long zzyt() {
        return zzard.get().longValue();
    }

    public final long zzyu() {
        return zzare.get().longValue();
    }

    public final String zzyv() {
        return zzarf.get();
    }

    public final long zzyw() {
        return zzarg.get().longValue();
    }

    static {
        zzct zzct = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        zzapx = zzct.zze("measurement.ad_id_cache_time", 10000);
        zzapy = zzct.zze("measurement.config.cache_time", 3600000);
        zzapz = zzct.zzt("measurement.log_tag", "FA");
        zzaqa = zzct.zzt("measurement.config.url_authority", "app-measurement.com");
        zzaqb = zzct.zzt("measurement.config.url_scheme", "https");
        zzaqc = zzct.zze("measurement.upload.debug_upload_interval", 1000);
        zzaqd = zzct.zze("measurement.lifetimevalue.max_currency_tracked", 4);
        zzaqe = zzct.zze("measurement.store.max_stored_events_per_app", 100000);
        zzaqf = zzct.zze("measurement.experiment.max_ids", 50);
        zzaqg = zzct.zze("measurement.audience.filter_result_max_count", 200);
        zzaqh = zzct.zze("measurement.alarm_manager.minimum_interval", 60000);
        zzaqi = zzct.zze("measurement.upload.minimum_delay", 500);
        zzaqj = zzct.zze("measurement.monitoring.sample_period_millis", 86400000);
        zzaqk = zzct.zze("measurement.upload.realtime_upload_interval", 10000);
        zzaql = zzct.zze("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        zzaqm = zzct.zze("measurement.config.cache_time.service", 86400000);
        zzaqn = zzct.zze("measurement.service_client.idle_disconnect_millis", 5000);
        zzaqo = zzct.zzt("measurement.log_tag.service", "FA-SVC");
        zzaqp = zzct.zze("measurement.upload.stale_data_deletion_interval", 86400000);
        zzaqq = zzct.zze("measurement.upload.backoff_period", 43200000);
        zzaqr = zzct.zze("measurement.upload.initial_upload_delay_time", Timer.DEFAULT_TIMER_DELAY_MS);
        zzaqs = zzct.zze("measurement.upload.interval", 3600000);
        zzaqt = zzct.zze("measurement.upload.max_bundle_size", IjkMediaMeta.AV_CH_TOP_BACK_CENTER);
        zzaqu = zzct.zze("measurement.upload.max_bundles", 100);
        zzaqv = zzct.zze("measurement.upload.max_conversions_per_day", 500);
        zzaqw = zzct.zze("measurement.upload.max_error_events_per_day", 1000);
        zzaqx = zzct.zze("measurement.upload.max_events_per_bundle", 1000);
        zzaqy = zzct.zze("measurement.upload.max_events_per_day", 100000);
        zzaqz = zzct.zze("measurement.upload.max_public_events_per_day", 50000);
        zzara = zzct.zze("measurement.upload.max_queue_time", 2419200000L);
        zzarb = zzct.zze("measurement.upload.max_realtime_events_per_day", 10);
        zzarc = zzct.zze("measurement.upload.max_batch_size", IjkMediaMeta.AV_CH_TOP_BACK_CENTER);
        zzard = zzct.zze("measurement.upload.retry_count", 6);
        zzare = zzct.zze("measurement.upload.retry_time", 1800000);
        zzarf = zzct.zzt("measurement.upload.url", "https://app-measurement.com/a");
        zzarg = zzct.zze("measurement.upload.window_interval", 3600000);
    }
}
