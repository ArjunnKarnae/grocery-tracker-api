package com.grocerytracker.dto;

public class AuthResponseDTO {

    public AuthResponseDTO() {
    }

    public AuthResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AuthResponseDTO{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
