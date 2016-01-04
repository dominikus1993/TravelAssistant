/**
 * Created by domin_000 on 14.11.2015.
 */

import controllers.RideController;
import controllers.UserController;
import entities.DataGenerator;
import repositories.IPersonRepository;
import repositories.IRidesRepository;
import utils.MyStaticDataBase;
import utils.SetUpRoutes;
import utils.SimpleDependencyResolver;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {

        MyStaticDataBase dataBase = new MyStaticDataBase(DataGenerator.persons, DataGenerator.rides);
        IPersonRepository personRepository = SimpleDependencyResolver.GetIPersonRepository();
        IRidesRepository ridesRepository = SimpleDependencyResolver.getIRidesRepository();
        UserController userController = new UserController(personRepository);
        RideController rideController = new RideController(ridesRepository);

        SetUpRoutes routes = new SetUpRoutes(userController, rideController);

        staticFileLocation("public");

        init();

        routes.setUp();



    }
}
