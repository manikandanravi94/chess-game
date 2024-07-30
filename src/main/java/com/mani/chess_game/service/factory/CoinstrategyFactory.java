package com.mani.chess_game.service.factory;

import com.mani.chess_game.model.Coin;
import com.mani.chess_game.service.strategy.ICoinStrategy;
import com.mani.chess_game.service.strategy.KingCoinStrategy;
import com.mani.chess_game.service.strategy.PawnCoinStrategy;
import com.mani.chess_game.service.strategy.QueenCoinStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoinstrategyFactory {

    private final KingCoinStrategy kingCoinStrategy;

    private final PawnCoinStrategy pawnCoinStrategy;

    private final QueenCoinStrategy queenCoinStrategy;

    @Autowired
    public CoinstrategyFactory(KingCoinStrategy kingCoinStrategy, PawnCoinStrategy pawnCoinStrategy, QueenCoinStrategy queenCoinStrategy) {
        this.kingCoinStrategy = kingCoinStrategy;
        this.pawnCoinStrategy = pawnCoinStrategy;
        this.queenCoinStrategy = queenCoinStrategy;
    }

    public ICoinStrategy getStrategy(Coin coin) {
        switch (coin) {
            case KING -> {
                return kingCoinStrategy;
            }
            case PAWN -> {
                return pawnCoinStrategy;
            }
            case QUEEN -> {
                return queenCoinStrategy;
            }
            default -> {
                return null;
            }
        }
    }
}
