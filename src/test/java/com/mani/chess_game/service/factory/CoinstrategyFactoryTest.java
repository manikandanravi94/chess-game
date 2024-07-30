package com.mani.chess_game.service.factory;

import com.mani.chess_game.model.Coin;
import com.mani.chess_game.service.strategy.ICoinStrategy;
import com.mani.chess_game.service.strategy.KingCoinStrategy;
import com.mani.chess_game.service.strategy.PawnCoinStrategy;
import com.mani.chess_game.service.strategy.QueenCoinStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CoinstrategyFactoryTest {

    @Mock
    private KingCoinStrategy expectedKingCoinStrategy;

    @Mock
    private QueenCoinStrategy expectedQueenCoinStrategy;

    @Mock
    private PawnCoinStrategy expectedPawnCoinStrategy;

    @InjectMocks
    private CoinstrategyFactory coinstrategyFactory;

    @Test
    void getKingStrategyTest() {
        ICoinStrategy actualkingCoinStrategy = coinstrategyFactory.getStrategy(Coin.KING);

        assertEquals(expectedKingCoinStrategy, actualkingCoinStrategy);
    }


    @Test
    void getQueenStrategyTest() {
        ICoinStrategy actualQueenCoinStrategy = coinstrategyFactory.getStrategy(Coin.QUEEN);

        assertEquals(expectedQueenCoinStrategy, actualQueenCoinStrategy);
    }

    @Test
    void getPawnStrategyTest() {
        ICoinStrategy actualPawnCoinStrategy = coinstrategyFactory.getStrategy(Coin.PAWN);

        assertEquals(expectedPawnCoinStrategy, actualPawnCoinStrategy);
    }
}