package com.shopee.app.web.protocol;

import android.graphics.Color;
import com.garena.android.appkit.tools.b;
import com.shopee.id.R;

public class ShowPinPopupMessage {
    private Popup popUp;

    public Popup getPopUp() {
        return this.popUp;
    }

    public static class Popup {
        private ButtonMessage button;
        private String cancelText;
        private String message;
        private int numberOfDigits;
        private String okText;
        private String title;

        public String getTitle() {
            return this.title;
        }

        public String getMessage() {
            return this.message;
        }

        public String getOkText() {
            return this.okText;
        }

        public String getCancelText() {
            return this.cancelText;
        }

        public ButtonMessage getButton() {
            return this.button;
        }

        public int getNumberOfDigits() {
            return this.numberOfDigits;
        }
    }

    public static class ButtonMessage {
        private String color;
        private String eventID;
        private float fontSize;
        private String title;

        public String getTitle() {
            return this.title;
        }

        public int getColor() {
            try {
                return Color.parseColor(this.color);
            } catch (Exception unused) {
                return b.a(R.color.link_text_material_light);
            }
        }

        public float getFontSize() {
            return this.fontSize;
        }

        public String getEventID() {
            return this.eventID;
        }
    }
}
