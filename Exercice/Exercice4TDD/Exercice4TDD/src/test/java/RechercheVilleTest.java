import jdk.jshell.spi.ExecutionControl;
import org.example.NotFoundException;
import org.example.RechercheVille;
import org.
        junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RechercheVilleTest {

    private RechercheVille rechercheVille;

    private List<String> villes = Arrays.asList(new String[] {"Paris","Budapest","Skopje","Valence","Vancouver","Amsterdam","Sydney","Londres"});

    @Before
    public void setUp (){
        rechercheVille = new RechercheVille(villes);
    }

    @Test
    public void rechercheWhenLess_2_Char_Raise_NotFoundException(){
        //Arrange
        String myChar = "v";

        //Assert
        Assert.assertThrows(NotFoundException.class,()->{
            rechercheVille.recherche(myChar);
        });
    }

    @Test
    public void rechercheWhenGt_2_Char_ThenReturn_CitiesStartedWithChar () throws ExecutionControl.NotImplementedException {
        //Arrange
        String mySearch = "Va";
        String[] expected = new String[] {"Valence","Vancouver"};

        //Act
        List<String> result = rechercheVille.recherche(mySearch);

        //Assert
        Assert.assertArrayEquals(expected,result.toArray());
    }

    @Test
    public void rechercheWhenGt_2_Char_NoCaseSensitive () throws ExecutionControl.NotImplementedException {
        //Arrange
        String mySearch = "vA";
        String[] expected = new String[] {"Valence","Vancouver"};

        //Act
        List<String> result = rechercheVille.recherche(mySearch);

        //Assert
        Assert.assertArrayEquals(expected,result.toArray());
    }

    @Test
    public void rechercheWhenGt_2_Char_ThenReturnCitiesContainChar () throws ExecutionControl.NotImplementedException {
        //Arrance
        String mySearch = "ape";
        String[] expected = new String[]{"Budapest"};

        //Act
        List<String> result = rechercheVille.recherche(mySearch);

        //Assert
        Assert.assertArrayEquals(expected,result.toArray());
    }

    @Test
    public void rechercheWhenChar_Asterisk_ThenReturnAllCities () throws ExecutionControl.NotImplementedException {
        //Arrange
        String mySearch = "*";

        //Act
        List<String> result = rechercheVille.recherche(mySearch);

        Assert.assertArrayEquals(villes.toArray(),result.toArray());
    }

}
