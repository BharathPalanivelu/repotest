package com.tencent.cos.xml.model.object;

import com.appsflyer.share.Constants;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.Delete;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class DeleteMultiObjectRequest extends ObjectRequest {
    private Delete delete = new Delete();

    public String getMethod() {
        return "POST";
    }

    public String getPath() {
        return Constants.URL_PATH_DELIMITER;
    }

    public boolean isNeedMD5() {
        return true;
    }

    public DeleteMultiObjectRequest(String str, List<String> list) {
        super(str, (String) null);
        this.delete.deleteObjects = new ArrayList();
        setObjectList(list);
    }

    public Map<String, String> getQueryString() {
        this.queryParameters.put("delete", (Object) null);
        return this.queryParameters;
    }

    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildDelete(this.delete));
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException((Throwable) e2);
        } catch (IOException e3) {
            throw new CosXmlClientException((Throwable) e3);
        }
    }

    public void checkParameters() throws CosXmlClientException {
        if (this.bucket == null) {
            throw new CosXmlClientException("bucket must not be null");
        }
    }

    public void setQuiet(boolean z) {
        this.delete.quiet = z;
    }

    public void setObjectList(String str) {
        if (str != null) {
            if (str.startsWith(Constants.URL_PATH_DELIMITER)) {
                str = str.substring(1);
            }
            Delete.DeleteObject deleteObject = new Delete.DeleteObject();
            deleteObject.key = str;
            this.delete.deleteObjects.add(deleteObject);
        }
    }

    public void setObjectList(String str, String str2) {
        if (str != null) {
            if (str.startsWith(Constants.URL_PATH_DELIMITER)) {
                str = str.substring(1);
            }
            Delete.DeleteObject deleteObject = new Delete.DeleteObject();
            deleteObject.key = str;
            if (str2 != null) {
                deleteObject.versionId = str2;
            }
            this.delete.deleteObjects.add(deleteObject);
        }
    }

    public void setObjectList(List<String> list) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Delete.DeleteObject deleteObject = new Delete.DeleteObject();
                String str = list.get(i);
                if (str.startsWith(Constants.URL_PATH_DELIMITER)) {
                    deleteObject.key = str.substring(1);
                } else {
                    deleteObject.key = str;
                }
                this.delete.deleteObjects.add(deleteObject);
            }
        }
    }

    public void setObjectList(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                Delete.DeleteObject deleteObject = new Delete.DeleteObject();
                String str = (String) next.getKey();
                String str2 = (String) next.getValue();
                if (str.startsWith(Constants.URL_PATH_DELIMITER)) {
                    deleteObject.key = str.substring(1);
                } else {
                    deleteObject.key = str;
                }
                if (str2 != null) {
                    deleteObject.versionId = str2;
                }
                this.delete.deleteObjects.add(deleteObject);
            }
        }
    }

    public Delete getDelete() {
        return this.delete;
    }
}
