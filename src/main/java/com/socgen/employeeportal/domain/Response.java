package com.socgen.employeeportal.domain;

public class Response {
    private String message;
    private boolean isStatus;

    public Response() {
    }

    public Response(String message, boolean isStatus) {
        this.message = message;
        this.isStatus = isStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }
}
