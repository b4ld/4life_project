package org.academiadecodigo.invictus.controller;

import org.academiadecodigo.invictus.converter.DtoToUser;
import org.academiadecodigo.invictus.converter.UserToDto;
import org.academiadecodigo.invictus.dto.UserDto;
import org.academiadecodigo.invictus.persistence.model.User;
import org.academiadecodigo.invictus.services.UserService;
import org.academiadecodigo.invictus.services.WishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;
    private DtoToUser dtoToUser;
    private UserToDto usertoDto;
    private WishesService wishesService;


    @Autowired
    public void setDtoToUser(DtoToUser dtoToUser) {
        this.dtoToUser = dtoToUser;
    }

    @Autowired
    public void setUserToDto(UserToDto usertoDto) {
        this.usertoDto = usertoDto;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUsertoDto(UserToDto usertoDto) {
        this.usertoDto = usertoDto;
    }

    @Autowired
    public void setWishesService(WishesService wishesService) {
        this.wishesService = wishesService;
    }

    @GetMapping(path = "")
    public String home() {

        return "index";
    }

    @GetMapping(path = "/user/{id}")
    public String showUser(@PathVariable Integer id, Model model) {

        User user = userService.get(id);
        model.addAttribute("user", usertoDto.convert(user));
        return "user";
    }


    @GetMapping(path = "/user/{id}/edit")
    public String editUser(@PathVariable Integer id, Model model) {

        model.addAttribute("user", usertoDto.convert(userService.get(id)));
        model.addAttribute("wishes", wishesService.wishesList());
        return "form";
    }

    @GetMapping(path = "/user/form")
    public String add(Model model) {

        model.addAttribute("user", new UserDto());
        return "form";
    }

    @PostMapping(path = "/user/form")
    public String submitForm(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return  "form";
        }
        return "redirect:/user/list/";
    }

    @GetMapping(path = "/user/login")
    public String login(Model model) {

        model.addAttribute("user", new UserDto());
        return "login";
    }

    @PostMapping(path = "/user/login")
    public String submitLogin(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {

        /*if(bindingResult.hasErrors()){
            return "login";
        }*/

        return "redirect:/user/list";
    }


    @GetMapping(path = "/user/list")
    public String userList(Model model) {
        model.addAttribute("user", usertoDto.convertToList(userService.userList()));

        return "userList";
    }


   // @PostMapping(path = "/user/list")
   // public void




}
