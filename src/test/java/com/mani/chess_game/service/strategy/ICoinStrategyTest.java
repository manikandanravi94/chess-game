package com.mani.chess_game.service.strategy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class ICoinStrategyTest {

    ICoinStrategy coinStrategy = () -> QueenCoinStrategy.QUEEN_COIN_CAPABILITY;

    @Test
    void invalidPositionTest() {
        assertThrowsExactly(IllegalArgumentException.class, () -> coinStrategy.nextPossibleMoves("I9"));
    }

    @Test
    void validQueenPositionTest() {
        List<String> expectedQueenPossiblePostions = Arrays.asList("D6", "D7", "D8", "D4", "D3", "D2", "D1", "C5", "B5", "A5", "E5", "F5", "G5", "H5", "E6", "F7", "G8", "C6", "B7", "A8", "E4", "F3", "G2", "H1", "C4", "B3", "A2");

        List<String> actualQueenPossiblePositions = coinStrategy.nextPossibleMoves("D5");

        assertEquals(expectedQueenPossiblePostions, actualQueenPossiblePositions);
    }
}