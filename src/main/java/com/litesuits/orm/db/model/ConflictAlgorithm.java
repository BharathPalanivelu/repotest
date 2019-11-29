package com.litesuits.orm.db.model;

import com.litesuits.orm.db.assit.SQLBuilder;

public enum ConflictAlgorithm {
    None(SQLBuilder.BLANK),
    Rollback(" OR ROLLBACK "),
    Abort(" OR ABORT "),
    Fail(" OR FAIL "),
    Ignore(" OR IGNORE "),
    Replace(" OR REPLACE ");
    
    private String algorithm;

    private ConflictAlgorithm(String str) {
        this.algorithm = str;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }
}
