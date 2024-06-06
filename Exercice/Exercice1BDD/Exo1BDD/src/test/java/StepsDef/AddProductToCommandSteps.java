package StepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Model.Command;
import org.example.Model.Product;
import org.example.Repositoriy.CommandRepository;
import org.example.Repositoriy.ProductRepository;
import org.example.Service.CommandService;
import org.example.Service.ProductService;
import org.junit.Assert;
import org.mockito.Mockito;

import java.util.List;

public class AddProductToCommandSteps {

    private int commandId;
    private CommandRepository commandRepository;
    private CommandService commandService;

    private Command command;

    private  Product product;


    @Given("User want add Product to a Command")
    public void userWantAddProductToACommand() {
        commandRepository = Mockito.mock(CommandRepository.class);
        commandService = new CommandService(commandRepository);
        command = new Command(124578);
        product = new Product("Cheese",12.5f,"Food");
    }

    @When("A user add product to a command")
    public void aUserAddProductToACommand() {
        Mockito.when(commandRepository.findById(124578)).thenReturn(command);
        command = commandService.addProductToCommand(product,124578);
    }

    @And("the app save the command")
    public void theAppSaveTheCommand() {
        Mockito.when((commandRepository.update(command))).thenReturn(command);
        commandService.updateCommand(command);
    }

    @Then("the app return command")
    public void theAppReturnCommand() {
        Command command1 = new Command(124578);
        command1.addProductQuantity(product,1);
        Assert.assertEquals(command1,command);
    }

    @Given("User want add Product to a Command where the product is already in the command")
    public void userWantAddProductToACommandWhereTheProductIsAlreadyInTheCommand() {
        commandRepository = Mockito.mock(CommandRepository.class);
        commandService = new CommandService(commandRepository);
        command = new Command(124578);
        product = new Product("Cheese",12.5f,"Food");
        command.addProductQuantity(product,1);
    }

    @Then("the app return command with {int} product")
    public void theAppReturnCommandWithProduct(int arg0) {

        Command command1 = new Command(124578);
        command1.addProductQuantity(product,arg0);
        Assert.assertEquals(command1,command);
    }
}
