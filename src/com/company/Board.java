package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board<Key,V> {
    int weigh;
    int height;
    Map<Key, V> board = new HashMap<>();

    public Board(int _weigh, int _height)
    {
        weigh = _weigh;
        height = _height;
    }

    abstract void fillBoard(List<V> list);
    abstract List<Key> availableSpace();
    abstract void addItem(Key key, V value);
    abstract Key getKey(int i, int j);
    abstract V getValue(Key key);
    abstract List<Key> getColumn(int j);
    abstract List<Key> getRow(int i);
    abstract boolean hasValue(V value);
    abstract List<V> getValues(List<Key> keys);
}
