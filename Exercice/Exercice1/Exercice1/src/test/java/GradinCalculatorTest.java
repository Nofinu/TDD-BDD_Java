import org.example.GradingCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GradinCalculatorTest {
    private GradingCalculator gradingCalculator;

//    @Test
//    public void whenGrade_95_AndPresence_90_Then_A (){
//        //Arrange
//        gradingCalculator = new GradingCalculator(95,90);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assert.assertEquals(gradGet,'A');
//    }
//
//    @Test
//    public void whenGrade_85_AndPresence_90_Then_B(){
//        //Arrange
//        gradingCalculator = new GradingCalculator(85,90);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assert.assertEquals(gradGet,'B');
//    }
//
//    @Test
//    public void whenGrade_65_AndPresence_90_Then_C(){
//        //Arrange
//        gradingCalculator = new GradingCalculator(65,90);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assert.assertEquals(gradGet,'C');
//    }
//
//    @Test
//    public void whenGrade_95_AndPresence_65_Then_B(){
//        //Arrange
//        gradingCalculator = new GradingCalculator(95,65);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assert.assertEquals(gradGet,'B');
//    }
//
//    @Test
//    public void whenGrade_95_AndPresence_55_Then_F(){
//        //Arrange
//        gradingCalculator = new GradingCalculator(95,55);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assert.assertEquals(gradGet,'F');
//    }
//
//    @Test
//    public void whenGrade_65_AndPresence_55_Then_F(){
//        //Arrange
//        gradingCalculator = new GradingCalculator(65,55);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assert.assertEquals(gradGet,'F');
//    }
//
//    @Test
//    public void whenGrade_50_AndPresence_90_Then_F(){
//        //Arrange
//        gradingCalculator = new GradingCalculator(50,90);
//
//        //Act
//        char gradGet = gradingCalculator.getGrade();
//
//        //Assert
//        Assert.assertEquals(gradGet,'F');
//    }

    @ParameterizedTest
//    @CsvSource({
//            "95,90,A",
//            "85,90,B",
//            "65,90,C",
//            "95,65,B",
//            "95,55,F",
//            "65,55,F",
//            "50,90,F",
//
//    })
    @MethodSource("provideParameters")
    public void whenGrade_andPresence_Then_awaitedGrade(int score, int attendancePercentage, char awaitedGrade){
        //Arrange
        gradingCalculator = new GradingCalculator(score,attendancePercentage);

        //Act
        char gradeGet = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(awaitedGrade,gradeGet);
    }

    private static Stream<Arguments> provideParameters(){
        return Stream.of(
                Arguments.of(95,90,'A'),
                Arguments.of(85,90,'B'),
                Arguments.of(65,90,'C'),
                Arguments.of(95,65,'B'),
                Arguments.of(95,55,'F')
        );
    }

}
