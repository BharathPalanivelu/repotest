package com.shopee.app.network.http.data.datapoint;

public class ReportCursorData {
    int content_type;
    CursorData cursor_data;

    public int getContentType() {
        return this.content_type;
    }

    public CursorData getCursorData() {
        return this.cursor_data;
    }
}
