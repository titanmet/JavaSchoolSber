package com.ratnikov.controllers;

import com.ratnikov.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dao")
public class UserController {

    private final UserDao dao;

    @Autowired
    public UserController(UserDao dao) {
        this.dao = dao;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("users", dao.getUsers());
        return "user/all";
    }

    @GetMapping("/get")
    @ResponseBody
    public String getUser(@RequestParam("id") String id) {
        return dao.findUserByCode(Integer.parseInt(id)).getName();
    }

//    @GetMapping("/del/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") String id) {
//        dao.delete(Integer.parseInt(id));
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        dao.delete(Integer.parseInt(id));
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @GetMapping("/new")
    public String newUser() {
        return "user/new";
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "login", required = false) String login) {
        System.out.println("name = " + name + " , " + "login = " + login);
        dao.add(name, login);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam(value = "id") int id,
                                    @RequestParam(value = "name", required = false) String name,
                                    @RequestParam(value = "login", required = false) String login) {
        return dao.update(id, name, login) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
