package com.mani.chess_game.service.strategy;

import com.mani.chess_game.model.CoinDirection;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class KingCoinStrategy implements ICoinStrategy {

    private static final Map<CoinDirection, Integer> KING_COIN_CAPABILITY = new LinkedHashMap<>();

    static {
        KING_COIN_CAPABILITY.put(CoinDirection.FORWARD, 1);
        KING_COIN_CAPABILITY.put(CoinDirection.BACKWARD, 1);
        KING_COIN_CAPABILITY.put(CoinDirection.LEFT, 1);
        KING_COIN_CAPABILITY.put(CoinDirection.RIGHT, 1);
        KING_COIN_CAPABILITY.put(CoinDirection.FORWARDRIGHTDIAGONAL, 1);
        KING_COIN_CAPABILITY.put(CoinDirection.FORWARDLEFTDIAGONAL, 1);
        KING_COIN_CAPABILITY.put(CoinDirection.BACKWARDRIGHTDIAGONAL, 1);
        KING_COIN_CAPABILITY.put(CoinDirection.BACKWARDLEFTDIAGONAL, 1);
    }

    @Override
    public Map<CoinDirection, Integer> coinCapability() {
        return KING_COIN_CAPABILITY;
    }
}
