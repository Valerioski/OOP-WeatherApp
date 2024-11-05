package org.app.model;

public interface AbstractPair<X, Y> {

    X getX();

    Y getY();

    int hashCode();

    boolean equals(Object obj);

    String toString();

}
