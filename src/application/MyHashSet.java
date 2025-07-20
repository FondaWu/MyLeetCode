package application;

import java.util.LinkedList;

public class MyHashSet {
    private static final int BASE = 769;
    private LinkedList[] data;

    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < data.length; i++){
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int i = key %  BASE;
        if (!data[i].contains(key)){
            data[i].add(key);
        }

    }

    public void remove(int key) {
        int i = key %  BASE;
        data[i].removeFirstOccurrence(key);
    }

    public boolean contains(int key) {
        int i = key %  BASE;
        return data[i].contains(key);
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }
}
