package com.dgtfactory.dgtfactoryassignment.shared.exceptions;

public class ObjectWithIdNotFoundException extends RuntimeException {

    public ObjectWithIdNotFoundException(Long id, String entity) {
        super("Could not find \'" + entity + "\' with id: " + id);
    }
}
