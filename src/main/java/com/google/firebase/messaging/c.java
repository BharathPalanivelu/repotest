package com.google.firebase.messaging;

import java.util.Locale;

public final class c extends Exception {
    private final int errorCode;

    c(String str) {
        super(str);
        int i = 0;
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.US);
            char c2 = 65535;
            switch (lowerCase.hashCode()) {
                case -1743242157:
                    if (lowerCase.equals("service_not_available")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1290953729:
                    if (lowerCase.equals("toomanymessages")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -920906446:
                    if (lowerCase.equals("invalid_parameters")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -617027085:
                    if (lowerCase.equals("messagetoobig")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -95047692:
                    if (lowerCase.equals("missing_to")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                i = 1;
            } else if (c2 == 2) {
                i = 2;
            } else if (c2 == 3) {
                i = 3;
            } else if (c2 == 4) {
                i = 4;
            }
        }
        this.errorCode = i;
    }
}
