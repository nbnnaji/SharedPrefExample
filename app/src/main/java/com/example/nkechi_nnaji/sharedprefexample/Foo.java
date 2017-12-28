package com.example.nkechi_nnaji.sharedprefexample;

/**
 * Created by nkechi_nnaji on 12/28/17.
 */

public class Foo<T> {

    //Generate getter & setters for the generic object T
    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    private T object;
}
