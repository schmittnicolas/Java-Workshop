package fr.epita.assistants.myset;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GenericSet<T extends Comparable<T>> {
    private ArrayList<T> base_;
    private int size;

    public GenericSet() {
        base_ = new ArrayList<>();
        size = 0;
    }

    public Boolean has(T t) {
        return (base_.contains(t));
    }

    public void insert(T t) {
        if (!has(t)) {
            base_.add(t);
            size += 1;
            Collections.sort(base_);
        }
    }

    public void remove(T t) {
        base_.remove(t);
        size = base_.size();
    }

    public Boolean isEmpty() {
        this.size = base_.size();
        return size == 0;
    }

    public T min() {
        return Collections.min(base_);
    }

    public T max() {
        return Collections.max((base_));
    }

    public int size() {
        this.size = base_.size();
        return size;
    }

    public static <T extends Comparable<T>> GenericSet<T> intersection(GenericSet<T> a, GenericSet<T> b) {
        GenericSet<T> set = new GenericSet<T>();

        for (T element : a.base_) {
            if (b.has(element)) {
                set.insert(element);
            }
        }

        return set;
    }

    public static <T extends Comparable<T>> GenericSet<T> union(GenericSet<T> a, GenericSet<T> b) {
        GenericSet<T> set = new GenericSet<T>();
        for (T element : a.base_) {
            set.insert(element);
        }
        for (T element : b.base_) {
            set.insert(element);
        }

        return set;
    }
}
