package com.ebuy.shared.helper.exception.response;

public class ResourceNotFoundExceptionResponse {
    private String id;

    public ResourceNotFoundExceptionResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
