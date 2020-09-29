package controller;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import services.UserServices;

@RestController
@RequestMapping("/user")
@Api(description = "user's API operations")
public class UserController {
    @Autowired
    UserServices userServices;

    @ApiOperation("view the list of users")
    @GetMapping(value = "/getAll")
    public Iterable<User> getAllUsers() {
        Iterable<User> list = this.userServices.listAllUsers();
        return this.userServices.listAllUsers();
    }


}
