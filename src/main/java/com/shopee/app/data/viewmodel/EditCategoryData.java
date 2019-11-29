package com.shopee.app.data.viewmodel;

import java.util.List;

public class EditCategoryData {
    public String page;
    public List<EditCategory> selectedPath;

    public static class EditCategory {
        public int catId;
        public String displayName;
    }
}
