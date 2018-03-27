package com.focustraining.virtualstore.domain.repository.myTemplate;

public class MyT {

    protected final int id;

    public MyT(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Integer) {
            return id == (int) obj;
        }
        return super.equals(obj);
    }
}
