import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.Order;
import org.junit.Assert;

import java.util.List;

public class CocktailSteps {

    private Order order;
//// first scenario
//    @Given("Romeo who wants to buy a drink")
//    public void romeo_who_wants_to_buy_a_drink (){
//        order = new Order();
//        order.declareOwner("Romeo");
//    }
//
//    @When("an order is declared for Juliette")
//    public void an_Order_Is_Declared_For_Juliette() {
//        order.declareTarget("Juliette");
//    }
//
//    @Then("there is no cocktail in the order")
//    public void there_Is_No_Cocktail_In_The_Order() {
//        List<String> cocktails =  order.getCocktails();
//        Assert.assertEquals(0, cocktails.size());
//    }


    @Given("(.*) who wants to buy a drink")
    public void romeo_who_wants_to_buy_a_drink (String owner){
        order = new Order();
        order.declareOwner(owner);
    }

    @When("an order is declared for (.*)")
    public void an_Order_Is_Declared_For_Juliette(String target) {
        order.declareTarget(target);
    }

    @Then("there is (\\d+) cocktails in the order")
    public void there_Is_No_Cocktail_In_The_Order(int nbCocktail) {
        List<String> cocktails =  order.getCocktails();
        Assert.assertEquals(nbCocktail, cocktails.size());
    }

// third scenario

    @And("a message saying {string} is added")
    public void aMessageSayingIsAdded(String something) {
        order.withMessage(something);
    }

    @Then("the ticket must say {string}")
    public void theTicketMustSay(String somethingElse) {
        Assert.assertEquals(somethingElse, order.getTicketMessage());
    }



}
