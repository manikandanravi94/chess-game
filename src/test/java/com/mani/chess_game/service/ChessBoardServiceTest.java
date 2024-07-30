package com.mani.chess_game.service;

import com.mani.chess_game.service.strategy.ICoinStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ChessBoardServiceTest {


    @Mock
    private ICoinStrategy coinStrategy;

    @InjectMocks
    private ChessBoardService chessBoardService;

    @BeforeEach
    void setUp() {

    }


    @Test
    void nextPossibleMoves() {
        chessBoardService.setCoinStrategy(coinStrategy);
        Mockito.when(coinStrategy.nextPossibleMoves(Mockito.anyString())).thenReturn(new ArrayList<>());
        List<String> expectedOutput = chessBoardService.nextPossibleMoves("A6");
        System.out.println(expectedOutput);
        assertTrue(expectedOutput.isEmpty());
    }
}