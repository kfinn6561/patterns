package org.example.pipeline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

class StageTest {
     private Stage stage1;
     private Stage stage2;
     private Stage stage3;

     @BeforeEach
        void setUp() {
         stage1 = mock(Stage.class,withSettings().defaultAnswer(Answers.CALLS_REAL_METHODS));
            stage2 = mock(Stage.class,withSettings().defaultAnswer(Answers.CALLS_REAL_METHODS));
            stage3 = mock(Stage.class,withSettings().defaultAnswer(Answers.CALLS_REAL_METHODS));
        }

     @Test
        void testCreateChain() {
          // given
          Data inputData = new Data("Initial data");
          Data dataAfterStage1=new Data("Stage 1 processed");
            Data dataAfterStage2=new Data("Stage 2 processed");
            Data dataAfterStage3=new Data("Stage 3 processed");

            when(stage1.handle(inputData)).thenReturn(dataAfterStage1);
            when(stage2.handle(dataAfterStage1)).thenReturn(dataAfterStage2);
            when(stage3.handle(dataAfterStage2)).thenReturn(dataAfterStage3);

            Stage chain = Stage.CreateChain(stage1, stage2,stage3);

            // when
            Data result = chain.process(inputData);

            // then
            assertEquals(dataAfterStage3, result);
        }

}