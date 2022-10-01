package com.company;

import java.util.*;

public class Game2048 implements Game {


    GameHelper helper = new GameHelper();
    Random random = new Random();

    public static int GAME_SIZE = 4;
    Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);

    public Game2048(Board _board) { }
    public Game2048() { }

    public void init()
    {
        List<Integer> list = new ArrayList<>(GAME_SIZE*GAME_SIZE);

        for (int i=0; i < GAME_SIZE*GAME_SIZE; i++)
        {
            list.add(null);
        }

        board.fillBoard(list);
        //addItem();
        //addItem();
    }

    public boolean canMove()
    {
        List<Key> keyListSpaces = board.availableSpace();
        return (keyListSpaces.size() != 0);
    }

    public void move(Direction direction) throws GameOverException
    {
        boolean wasMove = false;

        switch (direction)
        {
            case UP:
                for (int i=0; i<GAME_SIZE; i++)
                {
                    if (makeMove(board.getColumn(i))) wasMove = true;
                }
                break;
            case RIGHT:
                for (int i=0; i<GAME_SIZE; i++)
                {
                    List<Key> keyList = board.getRow(i);
                    Collections.reverse(keyList);

                    if (makeMove(keyList)) wasMove = true;
                }
                break;
            case DOWN:
                for (int i=0; i<GAME_SIZE; i++)
                {
                    List<Key> keyList = board.getColumn(i);
                    Collections.reverse(keyList);

                    if (makeMove(keyList)) wasMove = true;
                }
                break;
            case LEFT:
                for (int i=0; i<GAME_SIZE; i++)
                {
                    if (makeMove(board.getRow(i))) wasMove = true;
                }
                break;
        }

        if (wasMove)
        {
            if (board.availableSpace().size() == 0)
            {
                throw new GameOverException("На поле нет свободных мест");
            }
            else
            {
                addItem();
            }
        }
    }

    public boolean makeMove(List<Key> pastKeysInBoard)
    {
        List<Integer> pastValuesInBoard = board.getValues(pastKeysInBoard);
        List<Integer> listAfterMerge = helper.moveAndMergeEqual(pastValuesInBoard);

        if (listAfterMerge.equals(pastValuesInBoard))
        {
            return false;
        }
        else
        {
            int index = 0;
            for (Key key : pastKeysInBoard)
            {
                board.addItem(key, listAfterMerge.get(index));
                index++;
            }
            return true;
        }
    }



    public void addItem()
    {
        if (board.availableSpace().size() == 0)
        {
            try {
                throw new GameOverException("На поле нет свободных мест");
            } catch (GameOverException e) {
                e.printStackTrace();
            }
        }

        List<Key> keyListSpaces = board.availableSpace();
        board.addItem(keyListSpaces.get(random.nextInt(keyListSpaces.size())), 2*(1+random.nextInt(1)));
    }

    public Board getGameBoard()
    {
        return board;
    }

    public boolean hasWin()
    {
        return (board.hasValue(2048));
    }
}
