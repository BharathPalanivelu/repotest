package com.shopee.app.web.protocol;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class FileDownloadMessage {
    private final String description;
    private final String fileName;
    private final String title;
    private final String url;

    public static /* synthetic */ FileDownloadMessage copy$default(FileDownloadMessage fileDownloadMessage, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileDownloadMessage.url;
        }
        if ((i & 2) != 0) {
            str2 = fileDownloadMessage.title;
        }
        if ((i & 4) != 0) {
            str3 = fileDownloadMessage.description;
        }
        if ((i & 8) != 0) {
            str4 = fileDownloadMessage.fileName;
        }
        return fileDownloadMessage.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.fileName;
    }

    public final FileDownloadMessage copy(String str, String str2, String str3, String str4) {
        return new FileDownloadMessage(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileDownloadMessage)) {
            return false;
        }
        FileDownloadMessage fileDownloadMessage = (FileDownloadMessage) obj;
        return j.a((Object) this.url, (Object) fileDownloadMessage.url) && j.a((Object) this.title, (Object) fileDownloadMessage.title) && j.a((Object) this.description, (Object) fileDownloadMessage.description) && j.a((Object) this.fileName, (Object) fileDownloadMessage.fileName);
    }

    public int hashCode() {
        String str = this.url;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.fileName;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "FileDownloadMessage(url=" + this.url + ", title=" + this.title + ", description=" + this.description + ", fileName=" + this.fileName + SQLBuilder.PARENTHESES_RIGHT;
    }

    public FileDownloadMessage(String str, String str2, String str3, String str4) {
        this.url = str;
        this.title = str2;
        this.description = str3;
        this.fileName = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileDownloadMessage(String str, String str2, String str3, String str4, int i, g gVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }
}
