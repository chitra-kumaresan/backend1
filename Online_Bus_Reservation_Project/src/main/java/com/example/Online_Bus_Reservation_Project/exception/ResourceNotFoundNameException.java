package com.example.Online_Bus_Reservation_Project.exception;

public class ResourceNotFoundNameException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private String name;

    public ResourceNotFoundNameException(String resourceName, String fieldName, String name) {
        super(String.format("%s not found with %s:'%s'", resourceName, fieldName, name));
        this.fieldName = fieldName;
        this.resourceName = resourceName;
        this.name = name;
    }
}
