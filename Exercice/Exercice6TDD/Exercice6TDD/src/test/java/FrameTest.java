import jdk.jshell.spi.ExecutionControl;
import org.example.Frame;
import org.example.IGenerateur;
import org.example.Roll;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FrameTest {

        private Frame frame;


        private IGenerateur generator = Mockito.mock(IGenerateur.class);

        @Test
        public void Roll_SimpleFrame_FirstRoll_CheckScore()
        {

            frame = new Frame(generator, false);
            Mockito.when(generator.randomPin(10)).thenReturn(4);
            frame.makeRoll();
            Assertions.assertEquals(4, frame.getScore());
        }

        @Test
        public void Roll_SimpleFrame_SecondRoll_CheckScore()
        {

            frame = new Frame(generator, false);
            Mockito.when(generator.randomPin(6)).thenReturn(4);
            List<Roll> rolls = new ArrayList<>(Arrays.asList(new Roll[]{new Roll(4)}));
            frame.setRolls(rolls);
            frame.makeRoll();
            Assertions.assertEquals(8, frame.getScore());
        }

        @Test
        public void Roll_SimpleFrame_SecondRoll_FirstRollStrick_ReturnFalse()
        {
            frame = new Frame(generator, false);
            List<Roll> rolls = new ArrayList<>(Arrays.asList(new Roll[]{new Roll(10)}));
            frame.setRolls(rolls);
            boolean res = frame.makeRoll();
            Assertions.assertFalse(res);
        }

        @Test
        public void Roll_SimpleFrame_MoreRolls_ReturnFalse()
        {
            frame = new Frame(generator, false);
            List<Roll> rolls = new ArrayList<>(Arrays.asList(new Roll[]{new Roll(4), new Roll(5)}));
            frame.setRolls(rolls);
            boolean res = frame.makeRoll();
            Assertions.assertFalse(res);
        }


        @Test
        public void Roll_LastFrame_MoreRolls_ReturnFalse()
        {

            frame = new Frame(generator, true);
            List<Roll> rolls = new ArrayList<>(Arrays.asList(new Roll[]{new Roll(4), new Roll(5)}));
            frame.setRolls(rolls);
            boolean res = frame.makeRoll();
            Assertions.assertFalse(res);
        }

        @Test
        public void Roll_LastFrame_SecondRoll_FirstRollStrick_ReturnTrue()
        {
            frame = new Frame(generator, true);
            Mockito.when(generator.randomPin(10)).thenReturn(4);
            List<Roll> rolls = new ArrayList<>(Arrays.asList(new Roll[]{new Roll(10)}));
            frame.setRolls(rolls);
            boolean res = frame.makeRoll();
            Assertions.assertTrue(res);
        }

        @Test
        public void Roll_LastFrame_SecondRoll_FirstRollStrick_CheckScore()
        {
            frame = new Frame(generator, true);
            Mockito.when(generator.randomPin(10)).thenReturn(4);
            List<Roll> rolls = new ArrayList<>(Arrays.asList(new Roll[]{new Roll(10)}));
            frame.setRolls(rolls);
            boolean res = frame.makeRoll();
            Assertions.assertEquals(14, frame.getScore());
        }

        @Test
        public void Roll_LastFrame_ThirdRoll_FirstRollStrick_ReturnTrue()
        {
            frame = new Frame(generator, true);
            Mockito.when(generator.randomPin(4)).thenReturn(4);
            List<Roll> rolls = new ArrayList<>(Arrays.asList(new Roll[]{new Roll(10),new Roll(6)}));
            frame.setRolls(rolls);
            boolean res = frame.makeRoll();
            Assertions.assertTrue(res);
        }
        @Test
        public void Roll_LastFrame_ThirdRoll_FirstRollStrick_CheckScore()
        {
            frame = new Frame(generator, true);
            Mockito.when(generator.randomPin(4)).thenReturn(4);
            List<Roll> rolls = new ArrayList<>(Arrays.asList(new Roll[]{new Roll(10),new Roll(6)}));
            frame.setRolls(rolls);
            boolean res = frame.makeRoll();
            Assertions.assertEquals(20, frame.getScore());
        }


        @Test
        public void Roll_LastFrame_ThirdRoll_Spare_ReturnTrue()
        {
            frame = new Frame(generator, true);
            Mockito.when(generator.randomPin(10)).thenReturn(4);
            List<Roll> rolls = new ArrayList<>(Arrays.asList(new Roll[]{new Roll(4),new Roll(6)}));
            frame.setRolls(rolls);
            boolean res = frame.makeRoll();
            Assertions.assertTrue(res);
        }

        @Test
        public void Roll_LastFrame_ThirdRoll_Spare_CheckScore()
        {
            frame = new Frame(generator, true);
            Mockito.when(generator.randomPin(10)).thenReturn(4);
            List<Roll> rolls = new ArrayList<>(Arrays.asList(new Roll[]{new Roll(4),new Roll(6)}));
            frame.setRolls(rolls);
            boolean res = frame.makeRoll();
            Assertions.assertEquals(14, frame.getScore());
        }

        @Test
        public void Roll_LastFrame_FourthRoll_ReturnFalse()
        {
            frame = new Frame(generator, true);
            List<Roll> rolls = new ArrayList<>(Arrays.asList(new Roll[]{new Roll(4),new Roll(6),new Roll(4)}));
            frame.setRolls(rolls);
            boolean res = frame.makeRoll();
            Assertions.assertFalse(res);
        }
}

