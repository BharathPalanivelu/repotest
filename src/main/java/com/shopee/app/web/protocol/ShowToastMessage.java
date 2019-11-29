package com.shopee.app.web.protocol;

public class ShowToastMessage {
    private Toast toast;

    public String getToast() {
        return this.toast.getMessage();
    }

    private class Toast {
        String iconType;
        String message;

        private Toast() {
        }

        public String getMessage() {
            return this.message;
        }
    }
}
