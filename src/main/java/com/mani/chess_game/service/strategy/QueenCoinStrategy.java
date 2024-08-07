package com.mani.chess_game.service.strategy;

import com.mani.chess_game.model.CoinDirection;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class QueenCoinStrategy implements ICoinStrategy {

    public static final Map<CoinDirection, Integer> QUEEN_COIN_CAPABILITY = new LinkedHashMap<>();

    static {
        QUEEN_COIN_CAPABILITY.put(CoinDirection.FORWARD, 7);
        QUEEN_COIN_CAPABILITY.put(CoinDirection.BACKWARD, 7);
        QUEEN_COIN_CAPABILITY.put(CoinDirection.LEFT, 7);
        QUEEN_COIN_CAPABILITY.put(CoinDirection.RIGHT, 7);
        QUEEN_COIN_CAPABILITY.put(CoinDirection.FORWARDRIGHTDIAGONAL, 7);
        QUEEN_COIN_CAPABILITY.put(CoinDirection.FORWARDLEFTDIAGONAL, 7);
        QUEEN_COIN_CAPABILITY.put(CoinDirection.BACKWARDRIGHTDIAGONAL, 7);
        QUEEN_COIN_CAPABILITY.put(CoinDirection.BACKWARDLEFTDIAGONAL, 7);
        ICoinStrategy.BLACK_COIN_MAP.put("E4","E4");
    }

    @Override
    public Map<CoinDirection, Integer> coinCapability() {
        return QUEEN_COIN_CAPABILITY;
    }
}
