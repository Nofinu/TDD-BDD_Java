import org.example.Fib;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class FibTest {

    private Fib fib;

    @Before
    public void setup (){
        fib = new Fib();
    }

    @Test
    public void whenGetFibSeries_Range1_ThenResultIsNotEmpty (){

        //Act
        List<Integer> result = fib.getFibSeries(1);

        //Assert
//        Assert.assertNotEquals(0,result.size());
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void whenGetFibSeries_IfRange1_ThenResultContain_0(){
        //Act
        List<Integer> result = fib.getFibSeries(1);

        //Assert
        Assert.assertTrue(result.contains(0));
    }

    @Test
    public void whengetFibSeries_IfRange6_ThenResultContain_3(){
        //Act
        List<Integer> result = fib.getFibSeries(6);

        //Assert
        Assert.assertTrue(result.contains(3));
    }

    @Test
    public void whenGetFibSeries_IfRange6_ThenResultContain_6_Elements (){
        //Act
        List<Integer> result = fib.getFibSeries(6);

        //Assert
        Assert.assertEquals(6,result.size());
    }

    @Test
    public void whenGetFibSeries_IfRange6_ThenResultDoesNotContain_4 (){
        //Act
        List<Integer> result = fib.getFibSeries(6);

        //Assert
        Assert.assertFalse(result.contains(4));
    }

    @Test
    public void whenGetFibSeries_IfRange6_ThenResultContain_0_1_1_2_3_5 (){
        //Arrange
        List<Integer> expected = Arrays.asList(new Integer[]{0,1,2,3,5});

        //Act
        List<Integer> result = fib.getFibSeries(6);

        //Assert
        Assert.assertTrue(result.containsAll(expected));
    }

    @Test
    public void whenGetFibSeries_IfRange6_ThenResultIsSortedAscending (){
        //Act
        List<Integer> result = fib.getFibSeries(6);
        List<Integer> expected = new ArrayList<>(result);
        Collections.sort(expected);

        //Assert
        Assert.assertArrayEquals(expected.toArray(),result.toArray());
    }
}
