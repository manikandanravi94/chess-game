package com.mani.chess_game.service;

import com.mani.chess_game.model.Coin;
import com.mani.chess_game.service.factory.CoinstrategyFactory;
import com.mani.chess_game.service.strategy.ICoinStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ChessGameIntializer implements ApplicationRunner {


    private final CoinstrategyFactory coinstrategyFactory;

    private final ChessBoardService chessBoardService;

    @Autowired
    public ChessGameIntializer(CoinstrategyFactory coinstrategyFactory, ChessBoardService chessBoardService) {
        this.coinstrategyFactory = coinstrategyFactory;
        this.chessBoardService = chessBoardService;
    }


    @Override
    public void run(ApplicationArguments args) {

        Scanner inputScanner = new Scanner(System.in);
        boolean hasNextInput = true;
        do {
            System.out.println("Please enter keys from the following");
            for (Coin coin : Coin.values()) {
                System.out.println(coin);
            }
            try {
                Coin coinInput = Coin.valueOf(inputScanner.next());
                ICoinStrategy coinStrategy = coinstrategyFactory.getStrategy(coinInput);
                if (coinStrategy == null) {
                    continue;
                }
                System.out.println(coinInput);
                System.out.println("Please enter position for the coin");
                String position = inputScanner.next();
                chessBoardService.setCoinStrategy(coinStrategy);
                List<String> possibleMoves = chessBoardService.nextPossibleMoves(position);
                System.out.println(possibleMoves);
            } catch (Exception e) {
                System.out.println("Unknow coin type provided please provide valid type mentioned in the list");
                continue;
            }

            System.out.println("press 'Y' to continue or other keys to exit");
            if (!"y".equalsIgnoreCase(inputScanner.next())) {
                hasNextInput = false;
            }
        } while (hasNextInput);
    }
}
