package controllers;

import entities.Person;
import entities.RegisterUser;
import entities.Result;
import repositories.IAuthenticationRepository;
import repositories.IPersonRepository;
import spark.Request;
import spark.Response;
import com.google.gson.Gson;
import utils.UserUtils;
import utils.XmlDataManager;

import javax.jws.soap.SOAPBinding;

/**
 * Created by domin_000 on 02.01.2016.
 */
public class UserController extends BaseController {
    private final IPersonRepository repository;
    private final Gson gson;

    public UserController(IPersonRepository repository, IAuthenticationRepository authenticationRepository) {
        super(authenticationRepository);
        this.repository = repository;
        this.gson = new Gson();
    }

    public String login(Request request, Response response) {
        Result<Person> person = repository.Login(request.params(":login"), request.params(":password"));
        if (person.isSuccess()) {
            response.cookie("login", person.getValue().getEmail());
            return gson.toJson(getAuthenticationRepository().create(person.getValue()));
        }
        return gson.toJson(new Result<>(false, true, Result.CreateMessagesList("Invalid password or username")));
    }

    public String register(Request request, Response response) {
        try{
            RegisterUser user = gson.fromJson(request.body(), RegisterUser.class);
            Result<Person> personResult = repository.Register(user.getUsername(), user.getPassword(), user.getConfirmPassword());
            return gson.toJson(personResult);
        }catch(Exception ex){
            return gson.toJson(new Result<>(false, true , Result.CreateMessagesList("Invlid data format")));
        }
    }

}
