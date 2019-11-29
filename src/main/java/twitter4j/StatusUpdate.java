package twitter4j;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class StatusUpdate implements Serializable {
    private static final long serialVersionUID = 7422094739799350035L;
    private boolean displayCoordinates = true;
    private long inReplyToStatusId = -1;
    private GeoLocation location = null;
    private transient InputStream mediaBody;
    private File mediaFile;
    private long[] mediaIds;
    private String mediaName;
    private String placeId = null;
    private boolean possiblySensitive;
    private final String status;

    public StatusUpdate(String str) {
        this.status = str;
    }

    public String getStatus() {
        return this.status;
    }

    public long getInReplyToStatusId() {
        return this.inReplyToStatusId;
    }

    public void setInReplyToStatusId(long j) {
        this.inReplyToStatusId = j;
    }

    public StatusUpdate inReplyToStatusId(long j) {
        setInReplyToStatusId(j);
        return this;
    }

    public GeoLocation getLocation() {
        return this.location;
    }

    public void setLocation(GeoLocation geoLocation) {
        this.location = geoLocation;
    }

    public StatusUpdate location(GeoLocation geoLocation) {
        setLocation(geoLocation);
        return this;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public void setPlaceId(String str) {
        this.placeId = str;
    }

    public StatusUpdate placeId(String str) {
        setPlaceId(str);
        return this;
    }

    public boolean isDisplayCoordinates() {
        return this.displayCoordinates;
    }

    public void setDisplayCoordinates(boolean z) {
        this.displayCoordinates = z;
    }

    public StatusUpdate displayCoordinates(boolean z) {
        setDisplayCoordinates(z);
        return this;
    }

    public void setMedia(File file) {
        this.mediaFile = file;
    }

    public StatusUpdate media(File file) {
        setMedia(file);
        return this;
    }

    public void setMedia(String str, InputStream inputStream) {
        this.mediaName = str;
        this.mediaBody = inputStream;
    }

    public void setMediaIds(long... jArr) {
        this.mediaIds = jArr;
    }

    /* access modifiers changed from: package-private */
    public boolean isForUpdateWithMedia() {
        return (this.mediaFile == null && this.mediaName == null) ? false : true;
    }

    public StatusUpdate media(String str, InputStream inputStream) {
        setMedia(str, inputStream);
        return this;
    }

    public void setPossiblySensitive(boolean z) {
        this.possiblySensitive = z;
    }

    public StatusUpdate possiblySensitive(boolean z) {
        setPossiblySensitive(z);
        return this;
    }

    public boolean isPossiblySensitive() {
        return this.possiblySensitive;
    }

    /* access modifiers changed from: package-private */
    public HttpParameter[] asHttpParameterArray() {
        ArrayList arrayList = new ArrayList();
        appendParameter("status", this.status, (List<HttpParameter>) arrayList);
        long j = this.inReplyToStatusId;
        if (-1 != j) {
            appendParameter("in_reply_to_status_id", j, (List<HttpParameter>) arrayList);
        }
        GeoLocation geoLocation = this.location;
        if (geoLocation != null) {
            appendParameter("lat", geoLocation.getLatitude(), (List<HttpParameter>) arrayList);
            appendParameter("long", this.location.getLongitude(), (List<HttpParameter>) arrayList);
        }
        appendParameter("place_id", this.placeId, (List<HttpParameter>) arrayList);
        if (!this.displayCoordinates) {
            appendParameter("display_coordinates", "false", (List<HttpParameter>) arrayList);
        }
        File file = this.mediaFile;
        if (file != null) {
            arrayList.add(new HttpParameter("media[]", file));
            arrayList.add(new HttpParameter("possibly_sensitive", this.possiblySensitive));
        } else {
            String str = this.mediaName;
            if (str != null) {
                InputStream inputStream = this.mediaBody;
                if (inputStream != null) {
                    arrayList.add(new HttpParameter("media[]", str, inputStream));
                    arrayList.add(new HttpParameter("possibly_sensitive", this.possiblySensitive));
                }
            }
            long[] jArr = this.mediaIds;
            if (jArr != null && jArr.length >= 1) {
                arrayList.add(new HttpParameter("media_ids", StringUtil.join(jArr)));
            }
        }
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    private void appendParameter(String str, String str2, List<HttpParameter> list) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    private void appendParameter(String str, double d2, List<HttpParameter> list) {
        list.add(new HttpParameter(str, String.valueOf(d2)));
    }

    private void appendParameter(String str, long j, List<HttpParameter> list) {
        list.add(new HttpParameter(str, String.valueOf(j)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StatusUpdate statusUpdate = (StatusUpdate) obj;
        if (this.displayCoordinates != statusUpdate.displayCoordinates || this.inReplyToStatusId != statusUpdate.inReplyToStatusId || this.possiblySensitive != statusUpdate.possiblySensitive) {
            return false;
        }
        GeoLocation geoLocation = this.location;
        if (geoLocation == null ? statusUpdate.location != null : !geoLocation.equals(statusUpdate.location)) {
            return false;
        }
        InputStream inputStream = this.mediaBody;
        if (inputStream == null ? statusUpdate.mediaBody != null : !inputStream.equals(statusUpdate.mediaBody)) {
            return false;
        }
        File file = this.mediaFile;
        if (file == null ? statusUpdate.mediaFile != null : !file.equals(statusUpdate.mediaFile)) {
            return false;
        }
        String str = this.mediaName;
        if (str == null ? statusUpdate.mediaName != null : !str.equals(statusUpdate.mediaName)) {
            return false;
        }
        long[] jArr = this.mediaIds;
        if (jArr == null ? statusUpdate.mediaIds != null : !Arrays.equals(jArr, statusUpdate.mediaIds)) {
            return false;
        }
        String str2 = this.placeId;
        if (str2 == null ? statusUpdate.placeId != null : !str2.equals(statusUpdate.placeId)) {
            return false;
        }
        String str3 = this.status;
        return str3 == null ? statusUpdate.status == null : str3.equals(statusUpdate.status);
    }

    public int hashCode() {
        String str = this.status;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.inReplyToStatusId;
        int i2 = ((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        GeoLocation geoLocation = this.location;
        int hashCode2 = (i2 + (geoLocation != null ? geoLocation.hashCode() : 0)) * 31;
        String str2 = this.placeId;
        int hashCode3 = (((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.displayCoordinates ? 1 : 0)) * 31) + (this.possiblySensitive ? 1 : 0)) * 31;
        String str3 = this.mediaName;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        InputStream inputStream = this.mediaBody;
        int hashCode5 = (hashCode4 + (inputStream != null ? inputStream.hashCode() : 0)) * 31;
        File file = this.mediaFile;
        int hashCode6 = (hashCode5 + (file != null ? file.hashCode() : 0)) * 31;
        long[] jArr = this.mediaIds;
        if (jArr != null) {
            i = StringUtil.join(jArr).hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "StatusUpdate{status='" + this.status + '\'' + ", inReplyToStatusId=" + this.inReplyToStatusId + ", location=" + this.location + ", placeId='" + this.placeId + '\'' + ", displayCoordinates=" + this.displayCoordinates + ", possiblySensitive=" + this.possiblySensitive + ", mediaName='" + this.mediaName + '\'' + ", mediaBody=" + this.mediaBody + ", mediaFile=" + this.mediaFile + ", mediaIds=" + this.mediaIds + '}';
    }
}
