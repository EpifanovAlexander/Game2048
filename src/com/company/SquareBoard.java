package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SquareBoard<V> extends Board<Key,V>{

    public SquareBoard(int size)
    {
        super(size, size);
    }

    void fillBoard(List<V> list)
    {
        board.clear();
        if (list.size() != weigh*height)
        {
            throw new RuntimeException("Ошибка инициализации board");
        }
        for (int i=0; i < weigh; i++)
        {
            for (int j=0; j<height; j++)
            {
                board.put(new Key(i,j), list.get(i*height+j));
            }
        }
    }

    List<Key> availableSpace()
    {
        List<Key> keyList = new ArrayList<>();
        for (Map.Entry<Key, V> entry : board.entrySet())
        {
            if (entry.getValue() == null)
            {
                keyList.add(entry.getKey());
            }
        }
        return keyList;
    }

    void addItem(Key key, V value)
    {
        board.put(key, value);
    }

    Key getKey(int i, int j)
    {
        return board
                .keySet()
                .stream()
                .filter(key -> key.getI() == i && key.getJ() == j)
                .findFirst()
                .orElseGet(() -> null);
    }

    V getValue(Key key)
    {
        return board.get(key);
    }

    List<Key> getColumn(int j)
    {
        List<Key> keyList = new ArrayList<>();
        for (int i=0; i < height; i++)
        {
            keyList.add(getKey(i,j));
        }
        return keyList;
    }

    List<Key> getRow(int i)
    {
        List<Key> keyList = new ArrayList<>();
        for (int j=0; j < weigh; j++)
        {
            keyList.add(getKey(i,j));
        }
        return keyList;
    }

    boolean hasValue(V value)
    {
        return board.containsValue(value);
    }

    List<V> getValues(List<Key> keys)
    {
        List<V> values = new ArrayList<>();
        for (int i=0; i<keys.size(); i++)
        {
            if (keys.get(i) != null)
            {
                values.add(getValue(keys.get(i)));
            }
        }
        return values;
    }
}
