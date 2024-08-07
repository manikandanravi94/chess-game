package com.mani.chess_game.service.strategy;

import com.mani.chess_game.model.CoinDirection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mani.chess_game.constant.AppConstant.xCharMap;

public interface ICoinStrategy {

    int MAX_CHESS_BOX_LIMIT = 8;

    int MIN_CHESS_BOX_LIMIT = 1;

    Map<String, String> whiteCoinMap = new HashMap<>();

    static Map<String, String> BLACK_COIN_MAP = new HashMap<>();

    Map<CoinDirection, Integer> coinCapability();


    //A5

    default List<String> nextPossibleMoves(String position) {
        int xaxisCurrentPosition = Character.getNumericValue(position.charAt(0)) - 9;
        int yaxisCurrentPosition = Character.getNumericValue(position.charAt(1));
        List<String> coinMoves = new ArrayList<>();
        if (yaxisCurrentPosition < MIN_CHESS_BOX_LIMIT || yaxisCurrentPosition > MAX_CHESS_BOX_LIMIT || xaxisCurrentPosition < MIN_CHESS_BOX_LIMIT || xaxisCurrentPosition > MAX_CHESS_BOX_LIMIT) {
            throw new IllegalArgumentException("Not a valid position");
        }
        coinCapability().forEach((direction, maxMove) -> {
            int counter = 0;
            switch (direction) {
                case FORWARD -> {
                    for (int i = yaxisCurrentPosition; i < MAX_CHESS_BOX_LIMIT; i++) {
                        counter = counter + 1;
                        String move = xCharMap.get(xaxisCurrentPosition) + (i + 1);
                        if (checkOppositeCoinPresence(coinMoves, move)) break;
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
                        if (checkOppositeCoinPresence(coinMoves, move)) break;
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
                        if (checkOppositeCoinPresence(coinMoves, move)) break;
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
                        if (checkOppositeCoinPresence(coinMoves, move)) break;
                        coinMoves.add(move);
                        if (counter == maxMove) {
                            break;
                        }
                    }
                }
                case BACKWARDRIGHTDIAGONAL ->
                        backwardRightPossibleMoves(xaxisCurrentPosition, yaxisCurrentPosition, coinMoves, maxMove, counter);
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

    private static void backwardRightPossibleMoves(int xaxisCurrentPosition, int yaxisCurrentPosition, List<String> coinMoves, Integer maxMove, int counter) {
        for (int i = xaxisCurrentPosition + 1; i <= MAX_CHESS_BOX_LIMIT; i++) {
            counter = counter + 1;
            int derivedYAxis = (yaxisCurrentPosition - counter);
            if (derivedYAxis <= 0 || derivedYAxis > 8) {
                break;
            }
            String move = xCharMap.get(i) + derivedYAxis;
            if (checkOppositeCoinPresence(coinMoves, move)) break;
            coinMoves.add(move);
            if (counter >= yaxisCurrentPosition || counter >= maxMove) {
                break;
            }

        }
    }

    private static boolean checkOppositeCoinPresence(List<String> coinMoves, String move) {
        if(BLACK_COIN_MAP.containsKey(move)){
            coinMoves.add(move);
            return true;
        }
        return false;
    }
}
