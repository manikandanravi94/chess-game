package com.mani.chess_game.service.strategy;

import com.mani.chess_game.model.CoinDirection;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RookCoinStrategy implements ICoinStrategy{

    public static Map<CoinDirection,Integer> ROOK_COIN_CAPABILITY = new LinkedHashMap<>();

    static {
        ROOK_COIN_CAPABILITY.put(CoinDirection.FORWARD,7);
        ROOK_COIN_CAPABILITY.put(CoinDirection.BACKWARD,7);
        ROOK_COIN_CAPABILITY.put(CoinDirection.LEFT,7);
        ROOK_COIN_CAPABILITY.put(CoinDirection.RIGHT,7);
    }

    @Override
    public Map<CoinDirection, Integer> coinCapability() {
        return ROOK_COIN_CAPABILITY;
    }
}
