package com.zto.common;

/**
 * Created by xujun on 2018-11-26.
 */
public class LinkedList {
    private Integer value;
    public LinkedList next;

    public LinkedList(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }
}
