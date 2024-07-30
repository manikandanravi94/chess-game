package com.mani.chess_game.service.strategy;

import com.mani.chess_game.model.CoinDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.mani.chess_game.constant.AppConstant.xCharMap;

public interface ICoinStrategy {

    int MAX_CHESS_BOX_LIMIT = 8;

    int MIN_CHESS_BOX_LIMIT = 1;

    Map<CoinDirection, Integer> coinCapability();

    default List<String> nextPossibleMoves(String position) {
        int xaxisCurrentPosition = Character.getNumericValue(position.charAt(0)) - 9;
        int yaxisCurrentPosition = Character.getNumericValue(position.charAt(1));
        List<String> coinMoves = new ArrayList<>();
        if (yaxisCurrentPosition < MIN_CHESS_BOX_LIMIT || yaxisCurrentPosition > MAX_CHESS_BOX_LIMIT || xaxisCurrentPosition < MIN_CHESS_BOX_LIMIT || xaxisCurrentPosition > MAX_CHESS_BOX_LIMIT) {
            return coinMoves;
        }
        coinCapability().forEach((direction, maxMove) -> {
            int counter = 0;
            switch (direction) {
                case FORWARD -> {
                    for (int i = yaxisCurrentPosition; i < MAX_CHESS_BOX_LIMIT; i++) {
                        counter = counter + 1;
                        String move = xCharMap.get(xaxisCurrentPosition) + (i + 1);
                        coinMoves.add(move);
                        if (counter == maxMove) {
                            break;
                        }
                    }
                }
                case BACKWARD -> {
                    for (int i = yaxisCurrentPosition; i > MIN_CHESS_BOX_LIMIT; i--) {
                        counter = counter + 1;
                        String move = xCharMap.get(xaxisCurrentPosition) + (i - 1);
                        coinMoves.add(move);
                        if (counter == maxMove) {
                            break;
                        }
                    }
                }
                case RIGHT -> {
                    for (int i = xaxisCurrentPosition + 1; i <= MAX_CHESS_BOX_LIMIT; i++) {
                        counter = counter + 1;
                        String move = xCharMap.get(i) + yaxisCurrentPosition;
                        coinMoves.add(move);
                        if (counter == maxMove) {
                            break;
                        }
                    }
                }
                case LEFT -> {
                    for (int i = xaxisCurrentPosition - 1; i >= MIN_CHESS_BOX_LIMIT; i--) {
                        counter = counter + 1;
                        String move = xCharMap.get(i) + yaxisCurrentPosition;
                        coinMoves.add(move);
                        if (counter == maxMove) {
                            break;
                        }
                    }
                }
                case BACKWARDRIGHTDIAGONAL -> {
                    for (int i = xaxisCurrentPosition + 1; i <= MAX_CHESS_BOX_LIMIT; i++) {
                        counter = counter + 1;
                        int derivedYAxis = (yaxisCurrentPosition - counter);
                        if (derivedYAxis <= 0 || derivedYAxis > 8) {
                            break;
                        }
                        String move = xCharMap.get(i) + derivedYAxis;
                        coinMoves.add(move);
                        if (counter >= (yaxisCurrentPosition) || counter >= maxMove) {
                            break;
                        }

                    }
                }
                case BACKWARDLEFTDIAGONAL -> {
                    for (int i = xaxisCurrentPosition - 1; i >= MIN_CHESS_BOX_LIMIT; i--) {
                        counter = counter + 1;
                        int derivedYAxis = (yaxisCurrentPosition - counter);
                        if (derivedYAxis <= 0 || derivedYAxis > 8) {
                            break;
                        }
                        String move = xCharMap.get(i) + derivedYAxis;
                        coinMoves.add(move);
                        if (counter >= (yaxisCurrentPosition) || counter >= maxMove) {
                            break;
                        }

                    }
                }
                case FORWARDRIGHTDIAGONAL -> {
                    for (int i = xaxisCurrentPosition + 1; i <= MAX_CHESS_BOX_LIMIT; i++) {
                        counter = counter + 1;
                        int derivedYAxis = (yaxisCurrentPosition + counter);
                        if (derivedYAxis <= 0 || derivedYAxis > 8) {
                            break;
                        }
                        String move = xCharMap.get(i) + derivedYAxis;
                        coinMoves.add(move);
                        if (counter > (maxMove - yaxisCurrentPosition) + 1 || counter >= maxMove) {
                            break;
                        }

                    }
                }
                case FORWARDLEFTDIAGONAL -> {
                    for (int i = xaxisCurrentPosition - 1; i >= MIN_CHESS_BOX_LIMIT; i--) {
                        counter = counter + 1;
                        int derivedYAxis = (yaxisCurrentPosition + counter);
                        if (derivedYAxis <= 0 || derivedYAxis > 8) {
                            break;
                        }
                        String move = xCharMap.get(i) + derivedYAxis;
                        coinMoves.add(move);
                        if (counter > (maxMove - yaxisCurrentPosition) + 1 || counter >= maxMove) {
                            break;
                        }
                    }
                }
            }
        });
        return coinMoves;
    }
}
