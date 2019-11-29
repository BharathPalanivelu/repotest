package com.shopee.app.network.http.data.datapoint;

import com.shopee.app.network.http.data.BaseResponse;

public class GetReportCursorResponse extends BaseResponse {
    private ReportCursorData data;

    public ReportCursorData getData() {
        return this.data;
    }
}
