package com.mani.chess_game.service.strategy;

import com.mani.chess_game.model.CoinDirection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PawnCoinStrategyTest {

    @InjectMocks
    private PawnCoinStrategy pawnCoinStrategy;

    @Test
    void coinCapability() {
        Map<CoinDirection, Integer> expectedMap = new HashMap<>();
        expectedMap.put(CoinDirection.FORWARD, 1);

        Map<CoinDirection, Integer> actualMap = pawnCoinStrategy.coinCapability();

        assertEquals(expectedMap, actualMap);
    }
}