package com.mani.chess_game.service.strategy;

import com.mani.chess_game.model.CoinDirection;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PawnCoinStrategy implements ICoinStrategy {

    private static final Map<CoinDirection, Integer> PAWN_COIN_CAPABILITY = new HashMap<>();

    static {
        PAWN_COIN_CAPABILITY.put(CoinDirection.FORWARD, 1);
    }

    @Override
    public Map<CoinDirection, Integer> coinCapability() {
        return PAWN_COIN_CAPABILITY;
    }
}
