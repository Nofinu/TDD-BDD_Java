package StepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Model.Product;
import org.example.Repositoriy.ProductRepository;
import org.example.Repositoriy.UserRepository;
import org.example.Service.ProductService;
import org.example.Service.UserService;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ProductSearchSteps {
    private Product productSearch;
    private ProductRepository productRepository;
    private ProductService productService;
    private List<Product> productsFind;


    @Given("User want to search a product")
    public void userWantToSearchAProduct() {
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @When("A user send the name or a part of the name of the product he search")
    public void aUserSendTheNameOrAPartOfTheNameOfTheProductHeSearch() {
        productSearch = new Product("ch",0,"");
    }

    @And("the app search for all the related product by name")
    public void theAppSearchForAllTheRelatedProductByName() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Cheese",2.49f,"Food"));
        products.add(new Product("Chair",59.99f,"Housing"));
        Mockito.when(productRepository.findByName(productSearch.getName())).thenReturn(products);
        productsFind =  productService.findByName(productSearch.getName());
    }

    @Then("the app return the products find")
    public void theAppReturnTheProductsFind() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Cheese",2.49f,"Food"));
        products.add(new Product("Chair",59.99f,"Housing"));
        Assert.assertArrayEquals(productsFind.toArray(),products.toArray());
    }


    @When("A user send the price of the product he search")
    public void aUserSendThePriceOfTheProductHeSearch() {
        productSearch = new Product("",60,"");
    }

    @And("the app search for all the related product by price")
    public void theAppSearchForAllTheRelatedProductByPrice() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Cheese",2.49f,"Food"));
        products.add(new Product("Chair",59.99f,"Housing"));
        Mockito.when(productRepository.findByPrice(productSearch.getPrice())).thenReturn(products);
        productsFind =  productService.findByPrice(productSearch.getPrice());
    }
}
