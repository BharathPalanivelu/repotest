package com.garena.videolib.uploader;

public class ServerResponse {
    private String message;
    private int status;

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return "Status Code=" + this.status + " | Message=" + this.message;
    }
}
