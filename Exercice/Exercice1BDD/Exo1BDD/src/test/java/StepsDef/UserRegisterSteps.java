package StepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Exception.AlreadyExisteException;
import org.example.Repositoriy.UserRepository;
import org.example.Service.UserService;
import org.example.Model.User;
import org.junit.Assert;
import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.List;

public class UserRegisterSteps {


    private UserRepository userRepository;
    private UserService userService ;

    private String message;

    private User user;

    @Given("A new user want to create a account")
    public void aNewUserWantToCreateAAccount() {
        user = new User();
    }

    @When("A user send is {string} {string} and {string}")
    public void aUserSendIsAnd(String email, String username, String password) {
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
    }

    @And("the new user is add to the app")
    public void theNewUserIsAddToTheApp() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
        Mockito.when(userRepository.findByName(user.getUsername())).thenReturn(new ArrayList<>());
        Mockito.when(userRepository.add(user)).thenReturn(user);
        message = userService.register(user);
    }

    @Then("there is a message who validate Register")
    public void thereIsAMessageWhoValidateRegister() {
        Assert.assertEquals(message,message = "user Register! \n"+user);
    }

    @Then("the new user is add to the app but user Already exist")
    public void theNewUserIsAddToTheAppButUserAlreadyExist() {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("email@email.com","Toto","Pa$$word"));
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
        Mockito.when(userRepository.findByName(user.getUsername())).thenReturn(usersList);
        Assert.assertThrows(AlreadyExisteException.class,()->{userService.register(user);});
    }
}
