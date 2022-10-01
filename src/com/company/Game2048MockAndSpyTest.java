package com.company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class Game2048MockAndSpyTest {

    @Mock
    Board<Key, Integer> board = new SquareBoard<>(4);

    @Spy
    GameHelper helper = new GameHelper();

    @InjectMocks
    private Game2048 game = new Game2048();

    @Test
    public void testCanMove() {
        List<Key> keys = new ArrayList<>();
        keys.add(new Key(1,1));

        Mockito.when(board.availableSpace()).thenReturn(keys);
        assertTrue(game.canMove());
    }

    @Test
    public void testMakeMove() {
        List<Integer> listAfterMerge = asList(1, 2, 3, null);
        Mockito.when(helper.moveAndMergeEqual(anyList())).thenReturn(listAfterMerge);
        game.makeMove(anyList());
        assertArrayEquals(asList(1, 2, 3, null).toArray(), helper.moveAndMergeEqual(asList(1, 2, null, 3)).toArray());
    }

    @Test
    public void testCheckListInMethodInit() {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i < 16; i++)
        {
            list.add(null);
        }
        Mockito.doNothing().when(board).fillBoard(anyList());
        game.init();
        verify(board, times(1)).fillBoard(list);
    }
}
