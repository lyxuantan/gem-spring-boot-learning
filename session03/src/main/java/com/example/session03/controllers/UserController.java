package com.example.session03.controllers;


import com.example.session03.dao.UserDAO;
import com.example.session03.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/")
    public String addOrEdit(ModelMap model)
    {
        User u = new User();
        //u.setUsername("tan");
        model.addAttribute("USER",u);
        model.addAttribute("ACTION","saveOrUpdate");
        return "register-user";
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(ModelMap model , @ModelAttribute("USER") User user){
        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
        System.out.println(userDAO.getAll().size());
        return "register-user";

    }

    @RequestMapping("list")
    public String list(ModelMap model)
    {
        UserDAO userDao = new UserDAO();
        model.addAttribute("USERS",userDao.getAll());
        userDao.getAll();

        return "view-user";
    }

    @RequestMapping("/edit/{username}")
    public String edit(ModelMap model, @PathVariable(name = "username") String username)
    {
        UserDAO userDAO = new UserDAO();
        User u = userDAO.findByUsername(username);
        model.addAttribute("USER",u);
        model.addAttribute("ACTION","/saveOrUpdate");
        return "register-user";
    }

    @RequestMapping("/delete/{username}")
    public String delete(ModelMap model, @PathVariable(name = "username") String username)
    {
        UserDAO userDAO = new UserDAO();
        userDAO.delete(username);

        return "view-user";
    }
}
