package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SquareBoardTest {

    SquareBoard sq = new SquareBoard(4);

    @Test
    void fillBoardShouldThrowException() {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<15; i++){
            list.add(i);
        }
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            sq.fillBoard(list);
        });
        assertEquals(exception.getMessage(), "Ошибка инициализации board");
    }

    @Test
    void shouldReturnSize16() {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<16; i++){
            list.add(i);
        }
        sq.fillBoard(list);
        assertEquals(16, sq.board.size());
    }

    @Test
    void availableSpaceShouldReturnSize0() {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<16; i++){
            list.add(i);
        }
        sq.fillBoard(list);
        assertEquals(0, sq.availableSpace().size());
    }

    @Test
    void addItemShouldReturnSize0AndValue42() {
        List<Integer> list = new ArrayList<>();
        list.add(null);
        for (int i=0; i<15; i++){
            list.add(i);
        }

        sq.fillBoard(list);
        int expectedSize = sq.availableSpace().size() - 1;
        Key key = (Key) sq.availableSpace().get(0);
        sq.addItem(key, 42);
        int actualSize = sq.availableSpace().size();

        Assertions.assertAll(
                () -> assertEquals(expectedSize, actualSize),
                () -> assertEquals(sq.getValue(key), 42)
        );
    }

    @Test
    void getValueShouldReturnValue42() {
        List<Integer> list = new ArrayList<>();
        list.add(null);
        for (int i=0; i<15; i++){
            list.add(i);
        }

        sq.fillBoard(list);
        Key key = (Key) sq.availableSpace().get(0);
        sq.addItem(key, 42);

        assertEquals(42, sq.getValue(key));
    }

    @Test
    void hasValueShouldReturnTrueOnValue42() {
        List<Integer> list = new ArrayList<>();
        list.add(42);
        for (int i=0; i<15; i++){
            list.add(i);
        }
        sq.fillBoard(list);
        assertTrue(sq.hasValue(42));
    }

//    @Test
//    void getValuesShouldReturnTrueOnMatchArrays() {
//        List<Integer> list = new ArrayList<>();
//        list.add(null);
//        for (int i=0; i<15; i++){
//            list.add(i);
//        }
//
//        sq.fillBoard(list);
//
//        List<Key> keys = new ArrayList<>();
//
//        for (Object k : sq.board.keySet()){
//            if (sq.getValue((Key) k) == null) keys.add((Key) k);
//            else {
//                if ((int) sq.getValue((Key) k) == 1) keys.add((Key) k);
//                if ((int) sq.getValue((Key) k) == 2) keys.add((Key) k);
//                if ((int) sq.getValue((Key) k) == 3) keys.add((Key) k);
//            }
//        }
//
//        assertArrayEquals(asList(2,3,1).toArray(), sq.getValues(keys).toArray());
//    }
}
