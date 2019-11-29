package com.shopee.app.ui.sharing.base.helper;

import androidx.annotation.Keep;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

@Keep
public final class ProcessedData {
    private final String filePath;
    private final String fileUrl;

    public static /* synthetic */ ProcessedData copy$default(ProcessedData processedData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = processedData.filePath;
        }
        if ((i & 2) != 0) {
            str2 = processedData.fileUrl;
        }
        return processedData.copy(str, str2);
    }

    public final String component1() {
        return this.filePath;
    }

    public final String component2() {
        return this.fileUrl;
    }

    public final ProcessedData copy(String str, String str2) {
        j.b(str, "filePath");
        j.b(str2, "fileUrl");
        return new ProcessedData(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessedData)) {
            return false;
        }
        ProcessedData processedData = (ProcessedData) obj;
        return j.a((Object) this.filePath, (Object) processedData.filePath) && j.a((Object) this.fileUrl, (Object) processedData.fileUrl);
    }

    public int hashCode() {
        String str = this.filePath;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.fileUrl;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ProcessedData(filePath=" + this.filePath + ", fileUrl=" + this.fileUrl + SQLBuilder.PARENTHESES_RIGHT;
    }

    public ProcessedData(String str, String str2) {
        j.b(str, "filePath");
        j.b(str2, "fileUrl");
        this.filePath = str;
        this.fileUrl = str2;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final String getFileUrl() {
        return this.fileUrl;
    }
}
