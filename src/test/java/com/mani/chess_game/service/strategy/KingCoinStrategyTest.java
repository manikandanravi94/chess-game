package com.mani.chess_game.service.strategy;

import com.mani.chess_game.model.CoinDirection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class KingCoinStrategyTest {

    @InjectMocks
    private KingCoinStrategy kingCoinStrategy;

    @Test
    void kingCoinCapabilityTest() {
        int expectedKingCoinCapability = 8;

        Map<CoinDirection, Integer> actualKingCoinCapabilityMap = kingCoinStrategy.coinCapability();

        assertEquals(expectedKingCoinCapability, actualKingCoinCapabilityMap.size());
    }
}