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
    void kingCoinCapabilitySizeTest() {
        int expectedKingCoinCapability = 8;

        Map<CoinDirection, Integer> actualKingCoinCapabilityMap = kingCoinStrategy.coinCapability();

        assertEquals(expectedKingCoinCapability, actualKingCoinCapabilityMap.size());
    }

    //TODO below test can be extended for all other directions in all coins
    @Test
    void kingCoinCapabilityMaxMoveTest() {
        int expectedKingCoinForwardMoveCapability = 1;

        Map<CoinDirection, Integer> actualKingCoinCapabilityMap = kingCoinStrategy.coinCapability();

        assertEquals(expectedKingCoinForwardMoveCapability, actualKingCoinCapabilityMap.get(CoinDirection.FORWARD));
    }
}