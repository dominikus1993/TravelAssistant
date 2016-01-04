package utils;

import controllers.RideController;
import controllers.UserController;
import entities.Person;
import repositories.IPersonRepository;
import spark.Request;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by domin_000 on 03.01.2016.
 */
public class SetUpRoutes {
    private final UserController userController;
    private final RideController rideController;

    public SetUpRoutes(UserController userController, RideController rideController) {
        this.userController = userController;
        this.rideController = rideController;
    }

    public void setUp(){
        //User
        get("/user/login/:login/password/:password", (userController::Login));

        post("user/register", userController::Register);


        //Rides
        get("/rides/all", rideController::get);
        post("/rides/create", rideController::create);

    }



}
