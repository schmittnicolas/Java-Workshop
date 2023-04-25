package fr.epita.assistants.myset;

import java.util.ArrayList;
import java.util.Collections;

public class IntegerSet {
    private ArrayList<Integer> base_;
    private int size;

    public IntegerSet() {
        base_ = new ArrayList<>();
        size = 0;
    }

    public Boolean has(Integer i) {
        return (base_.contains(i));
    }

    public void insert(Integer i) {
        if (!has(i)) {
            base_.add(i);
            size += 1;
            Collections.sort(base_);
        }
    }

    public void remove(Integer i) {
        base_.remove(Integer.valueOf(i));
        size = base_.size();
    }

    public Boolean isEmpty() {
        this.size = base_.size();
        return size == 0;
    }

    public Integer min() {
        return Collections.min(base_);
    }

    public Integer max() {
        return Collections.max((base_));
    }

    public int size() {
        return base_.size();
    }

    public static IntegerSet intersection(IntegerSet a, IntegerSet b) {
        IntegerSet set = new IntegerSet();

        for (Integer element : a.base_) {
            if (b.has(element)) {
                set.insert(element);
            }
        }

        return set;
    }

    public static IntegerSet union(IntegerSet a, IntegerSet b) {
        IntegerSet set = new IntegerSet();
        for (Integer element : a.base_) {
            set.insert(element);
        }
        for (Integer element : b.base_) {
            set.insert(element);
        }

        return set;
    }
}
