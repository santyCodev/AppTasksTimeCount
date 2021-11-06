package com.santicodev.contarhoras.data.entity.enums;

public enum Category {
    MUSIC, DRAWING, ENGLISH, WEB_DEV, DEV_OTHER;

    public String toString() {
        switch (this) {
            case MUSIC:
                return "Music";
            case ENGLISH:
                return "English";
            case DRAWING:
                return "Drawing";
            case WEB_DEV:
                return "Web Development";
            case DEV_OTHER:
                return "Other Type Development";
        }
        return "";
    }
}
