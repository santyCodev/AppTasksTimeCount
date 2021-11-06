package com.santicodev.contarhoras.data.entity.enums;

public enum TopicType {

    THEORY, PROJECT;

    public String toString() {
        switch (this) {
            case THEORY:
                return "Theory";
            case PROJECT:
                return "Project";
        }
        return "";
    }

}
