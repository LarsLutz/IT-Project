package sampleSolution.abstractClasses;

/**
 * Copyright 2015, FHNW, Prof. Dr. Brad Richards. All rights reserved. This code
 * is licensed under the terms of the BSD 3-clause license (see the file
 * license.txt).
 * 
 * @author Brad Richards
 */
public abstract class Controller<M, V> {
    protected M model;
    protected V view;
    
    protected Controller(M model, V view) {
        this.model = model;
        this.view = view;
    }
}
