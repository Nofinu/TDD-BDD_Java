import org.example.DiceScore;
import org.example.Ide;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DiceScoreTest {

    private DiceScore diceScore;

    private final Ide de = Mockito.mock(Ide.class);

    @Test
    public void when2DiceAreSame_DeValue5_ThenScore_20 (){
        //Arrange
        diceScore = new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(5);

        //Act
        int result = diceScore.getScore();

        //Assert
        Assert.assertEquals(20,result);
    }

    @Test
    public void when2DiceAreSame_DeValue6_ThenScore_30(){
        //Arrange
        diceScore = new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(6);

        //Act
        int result = diceScore.getScore();

        //Assert
        Assert.assertEquals(30,result);
    }

    @Test
    public void whenDice1Value_5_Dice2Value_6_ThenScore_6 (){
        //Arrange
        diceScore = new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(5,6);

        //Act
        int result = diceScore.getScore();

        //Assert
        Assert.assertEquals(6,result);
    }

    @Test
    public void whenDice1Value_5_Dice2Value_4_ThenScore_5 (){
        //Arrange
        diceScore = new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(5,4);

        //Act
        int result = diceScore.getScore();

        //Assert
        Assert.assertEquals(5,result);
    }
}
