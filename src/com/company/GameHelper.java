package com.company;

import java.util.ArrayList;
import java.util.List;

public class GameHelper {
    List<Integer> moveAndMergeEqual(List<Integer> list){

        List<Integer> listWithNoSpaces = new ArrayList<>();
        List<Integer> finalList = new ArrayList<>();

        for (int i=0; i<list.size(); i++)
        {
            if (list.get(i) != null)
            {
                listWithNoSpaces.add(list.get(i));
            }
        }

        if (!list.isEmpty() && (listWithNoSpaces.size() == 0))
        {
            return list;
        }

        int i = 0;
        while (i < listWithNoSpaces.size())
        {
            Integer element = listWithNoSpaces.get(i);

            if ((i < (listWithNoSpaces.size() - 1) && (element.equals(listWithNoSpaces.get(i+1)))))
            {
                finalList.add(2*element);
                i += 2;
            }
            else
            {
                finalList.add(element);
                i++;
            }
        }

        if (finalList.size() != list.size())
        {
            int difference = list.size() - finalList.size();
            for (int j=0; j<difference; j++)
            {
                finalList.add(null);
            }
        }
        return finalList;
    }
}
