package com.mani.chess_game.service;

import com.mani.chess_game.service.strategy.ICoinStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChessBoardService {

//    private int[][] chessBoard = new int[8][8];

    private ICoinStrategy coinStrategy;


    public void setCoinStrategy(ICoinStrategy coinStrategy) {
        this.coinStrategy = coinStrategy;
    }

    public List<String> nextPossibleMoves(String position) {
        return coinStrategy.nextPossibleMoves(position);
    }

}
