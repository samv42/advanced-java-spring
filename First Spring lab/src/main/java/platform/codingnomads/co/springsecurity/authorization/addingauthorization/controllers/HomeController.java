package platform.codingnomads.co.springsecurity.authorization.addingauthorization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.models.UserMeta;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.services.CustomUserService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CustomUserService customUserService;

    @GetMapping("/")
    public String homePage() {
        return "authorization/home";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "authorization/admin";
    }

    @GetMapping("/superu")
    public String superUPage() {
        return "authorization/superu";
    }

    @GetMapping("/cart")
    public String cartPage() {return "authorization/cart";}

    @GetMapping("/permissions")
    public String permissionsPage() {return "authorization/permissions";}

    @GetMapping("/manage-users")
    public String manageUsersPage(Model model) {
        List<UserMeta> userMetaList = customUserService.getAllUserMetas();
        model.addAttribute("userMetaList", userMetaList);
        return "authorization/user-manager";}

    @GetMapping("/edit-user/{id}")
    public String editMeta(Model model, @PathVariable long id) {
        UserMeta userMeta = customUserService.getMetaById(id);
        model.addAttribute(userMeta);
        return "authorization/edit-user";
    }

    @PostMapping("/save-user")
    public String saveUserMeta(@ModelAttribute("userMeta") UserMeta userMeta) {
        customUserService.updateUserMeta(userMeta);
        return "redirect:/";
    }

}