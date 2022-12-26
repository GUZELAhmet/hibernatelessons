package AdvJavaPractice.Generics.Interfaces;

public interface Repostry<T> {
    void add(T t);

    void get(T t);

    void update(T t);

    void delete(T t);
}
