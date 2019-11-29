package com.tencent.cos.xml.model.tag;

import java.util.List;

public class Delete {
    public List<DeleteObject> deleteObjects;
    public boolean quiet;

    public static class DeleteObject {
        public String key;
        public String versionId;
    }
}
