package org.academiadecodigo.invictus.controller;

import org.academiadecodigo.invictus.converter.DtoToUser;
import org.academiadecodigo.invictus.converter.UserToDto;
import org.academiadecodigo.invictus.dto.UserDto;
import org.academiadecodigo.invictus.model.User;
import org.academiadecodigo.invictus.services.UserService;
import org.academiadecodigo.invictus.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private UserServiceImpl userService;
    private DtoToUser dtoToUser;
    private UserToDto usertoDto;


    @Autowired
    public void setDtoToUser(DtoToUser dtoToUser) {
        this.dtoToUser = dtoToUser;
    }

   @Autowired
    public void setUserToDto(UserToDto usertoDto) {
        this.usertoDto = usertoDto;
    }

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(path ="")
    public String home(){

        return "index";
    }

    @GetMapping(path ="/{id}")
    public String showUser(@PathVariable Integer id, Model model){

        User user = userService.get(id);

        model.addAttribute("user", usertoDto.convert(user));

        return "user";

    }


    @GetMapping(path = "/{id}/edit")
    public String editUser(@PathVariable Integer id, Model model){

        model.addAttribute("user",usertoDto.convert(userService.get(id)));

        return "form";

    }

    @GetMapping(path = "/user/form")
    public String form (Model model){
        model.addAttribute("user",new UserDto());

        return "form";
    }


    @PostMapping(path = "/form")
    public String submit(@ModelAttribute("user") UserDto userDto){

        return"redirect:/user";

    }

    @GetMapping(path ="/user/list")
    public String userList(Model model){
        model.addAttribute("user", usertoDto.convertToList(userService.userList())) ;

        return "userList";
    }





}
