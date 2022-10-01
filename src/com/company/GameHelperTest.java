package com.company;

import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

public class GameHelperTest {

    private final static GameHelper helper = new GameHelper();

    @Test
    void testSpaceAndValueChangePlaces() {
        assertArrayEquals(asList(1, 2, 3, null).toArray(), helper.moveAndMergeEqual(asList(1, 2, null, 3)).toArray());
    }

    @Test
    void textMerge2And2Result4() {
        assertArrayEquals(asList(4, null, null, null).toArray(), helper.moveAndMergeEqual(asList(null, null, 2, 2)).toArray());
    }

    @Test
    void testMergeAndSwipeTogether2And2ChangeInto4SpaceAppears() {
        assertArrayEquals(asList(4, 2, 3, null).toArray(), helper.moveAndMergeEqual(asList(2, 2, 2, 3)).toArray());
    }
}
