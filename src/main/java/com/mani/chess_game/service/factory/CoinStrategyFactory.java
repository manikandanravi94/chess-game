package com.mani.chess_game.service.factory;

import com.mani.chess_game.model.Coin;
import com.mani.chess_game.service.strategy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoinStrategyFactory {

    private final KingCoinStrategy kingCoinStrategy;

    private final PawnCoinStrategy pawnCoinStrategy;

    private final QueenCoinStrategy queenCoinStrategy;

    private final RookCoinStrategy rookCoinStrategy;

    @Autowired
    public CoinStrategyFactory(KingCoinStrategy kingCoinStrategy, PawnCoinStrategy pawnCoinStrategy, QueenCoinStrategy queenCoinStrategy, RookCoinStrategy rookCoinStrategy) {
        this.kingCoinStrategy = kingCoinStrategy;
        this.pawnCoinStrategy = pawnCoinStrategy;
        this.queenCoinStrategy = queenCoinStrategy;
        this.rookCoinStrategy = rookCoinStrategy;
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
            case ROOK -> {
                return rookCoinStrategy;
            }
            default -> throw new IllegalArgumentException("invalid input");
        }
    }
}
