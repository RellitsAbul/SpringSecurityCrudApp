package crudapp.controllers;

import crudapp.models.User;
import crudapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    final
    UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String printUser(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.get(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.get(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/users";

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }


}
