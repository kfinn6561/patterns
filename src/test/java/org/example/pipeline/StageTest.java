package org.example.pipeline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StageTest {
     @Mock private Stage stage1;
     @Mock private Stage stage2;
     @Mock private Stage stage3;


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
            assert result.equals(dataAfterStage3);
        }

}