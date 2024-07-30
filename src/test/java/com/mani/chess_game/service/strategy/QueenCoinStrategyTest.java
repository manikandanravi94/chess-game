package com.mani.chess_game.service.strategy;

import com.mani.chess_game.model.CoinDirection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class QueenCoinStrategyTest {

    @InjectMocks
    private QueenCoinStrategy queenCoinStrategy;

    @Test
    void queenCoinCapabilityTest() {
        Map<CoinDirection, Integer> actualQueenCapabilityMap = queenCoinStrategy.coinCapability();

        assertEquals(8, actualQueenCapabilityMap.size());
    }

    @Test
    void validQueenPositionTest() {
        List<String> expectedQueenPossiblePostions = Arrays.asList("D6", "D7", "D8", "D4", "D3", "D2", "D1", "C5", "B5", "A5", "E5", "F5", "G5", "H5", "E6", "F7", "G8", "C6", "B7", "A8", "E4", "F3", "G2", "H1", "C4", "B3", "A2");

        List<String> actualQueenPossiblePositions = queenCoinStrategy.nextPossibleMoves("D5");

        assertEquals(expectedQueenPossiblePostions, actualQueenPossiblePositions);
    }

    @Test
    void invalidPositionTest(){
        List<String> actualQueenPossiblePositions = queenCoinStrategy.nextPossibleMoves("I9");

        assertTrue(actualQueenPossiblePositions.isEmpty());
    }
}