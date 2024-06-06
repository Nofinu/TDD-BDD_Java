import jdk.jshell.spi.ExecutionControl;
import org.example.Product;
import org.example.Shop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShopTest {

    private Shop shop;

    @Before
    public void setUp(){
        shop = new Shop();
    }

    @Test
    public void updateTest_Desc_SellIn_10_ThenSellIn_9 () throws ExecutionControl.NotImplementedException {
        //Arrange
        Product product = new Product("p","product",10,10);

        //Act
        shop.update(product);

        //Assert
        Assert.assertEquals(9,product.getSellIn());
    }

    @Test
    public void updateTest_Desc_Quality_10_ThenQuality_9 () throws ExecutionControl.NotImplementedException {
        //Arrange
        Product product = new Product("p","product",10,10);

        //Act
        shop.update(product);

        //Assert
        Assert.assertEquals(9,product.getQuality());
    }

    @Test
    public void updateTest_Desc_Quality_10_WithSellIn_0_ThenQuality_8 () throws ExecutionControl.NotImplementedException {
        //Arrange
        Product product = new Product("p","product",0,10);

        //Act
        shop.update(product);

        //Assert
        Assert.assertEquals(8,product.getQuality());
    }

    @Test
    public void updateTest_Desc_Quality_0_ThenQuality_0() throws ExecutionControl.NotImplementedException {
        //Arrange
        Product product = new Product("p","product",10,0);

        //Act
        shop.update(product);

        //Assert
        Assert.assertEquals(0,product.getQuality());
    }

    @Test
    public void updateTest_QualityAsc_WhenBrie() throws ExecutionControl.NotImplementedException {
        //Arrange
        Product product = new Product("l","Brie",10,10);

        //Act
        shop.update(product);

        //Assert
        Assert.assertEquals(11,product.getQuality());
    }

    @Test
    public void updateTest_Quality_50_WithBrie_ThenQualityStay_50() throws ExecutionControl.NotImplementedException {
        //Arrange
        Product product = new Product("l","Brie",10,50);

        //Act
        shop.update(product);

        //Assert
        Assert.assertEquals(50,product.getQuality());
    }

    @Test
    public void updateTest_Desc_QualityWithProduitLaitier_10_ThenQuality_8 () throws ExecutionControl.NotImplementedException {
        //Arrange
        Product product = new Product("l","product",10,10);

        //Act
        shop.update(product);

        //Assert
        Assert.assertEquals(8,product.getQuality());
    }

    @Test
    public void updateTest_Desc_QualityWithProduitLaitierAndSellIn_0__10_ThenQuality_6 () throws ExecutionControl.NotImplementedException {
        //Arrange
        Product product = new Product("l","product",0,10);

        //Act
        shop.update(product);

        //Assert
        Assert.assertEquals(6,product.getQuality());
    }

}
