package com.shopee.app.web.protocol;

public class ShowPopUpMessage {
    public static final int BUTTON_CANCEL = 1;
    public static final int BUTTON_DISMISS = 2;
    public static final int BUTTON_OK = 0;
    private PopUp popUp;

    public static class PopUp {
        private String cancelText;
        private String message;
        private String okText;
        private String title;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public String getOkText() {
            return this.okText;
        }

        public void setOkText(String str) {
            this.okText = str;
        }

        public String getCancelText() {
            return this.cancelText;
        }

        public void setCancelText(String str) {
            this.cancelText = str;
        }
    }

    public void setPopUp(PopUp popUp2) {
        this.popUp = popUp2;
    }

    public PopUp getPopUp() {
        return this.popUp;
    }

    public String getTitle() {
        PopUp popUp2 = this.popUp;
        return popUp2 == null ? "" : popUp2.getTitle();
    }

    public String getMessage() {
        PopUp popUp2 = this.popUp;
        return popUp2 == null ? "" : popUp2.getMessage();
    }

    public String getOkText() {
        PopUp popUp2 = this.popUp;
        return popUp2 == null ? "" : popUp2.getOkText();
    }

    public String getCancelText() {
        PopUp popUp2 = this.popUp;
        return popUp2 == null ? "" : popUp2.getCancelText();
    }
}
