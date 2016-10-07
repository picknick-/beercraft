package eu.mszulc.controller;

import eu.mszulc.model.User;
import eu.mszulc.model.UserDao;
import org.hibernate.annotations.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
 public class UserController {

        @RequestMapping("/create")
        @ResponseBody
        public String create(@RequestParam("name") String name, @RequestParam("email") String email) {
            String userId = "";
            try {
                User user = new User(email, name);
                userDao.save(user);
                userId = String.valueOf(user.getId());
            }
            catch (Exception ex) {
                return "Error creating the user: " + ex.toString();
            }
            return "User succesfully created with id = " + userId;
        }

        /**
         * GET /delete  --> Delete the user having the passed id.
         */
        @RequestMapping("/delete")
        @ResponseBody
        public String delete(long id) {
            try {
                User user = new User(id);
                userDao.delete(user);
            }
            catch (Exception ex) {
                return "Error deleting the user:" + ex.toString();
            }
            return "User succesfully deleted!";
        }

        /**
         * GET /get-by-email  --> Return the id for the user having the passed
         * email.
         */
        @RequestMapping("/get-by-email")
        @ResponseBody
        public String getByEmail(String email) {
            String userId = "";
            try {
                List<User> user = userDao.findByEmail(email);
                userId = String.valueOf(user.get(0).getId());
            }
            catch (Exception ex) {
                return "User not found";
            }
            return "The user id is: " + userId;
        }

        /**
         * GET /update  --> Update the email and the name for the user in the
         * database having the passed id.
         */
        @RequestMapping("/update")
        @ResponseBody
        public String updateUser(long id, String email, String name) {
            try {
                User user = userDao.findOne(id);
                user.setEmail(email);
                user.setName(name);
                userDao.save(user);
            }
            catch (Exception ex) {
                return "Error updating the user: " + ex.toString();
            }
            return "User succesfully updated!";
        }

    @RequestMapping("/getall")
    @ResponseBody
        public String getAllUsers() {
        String x="";
        try {
            for (User customer : userDao.findAll()) {
                x+=customer.toString();
            }

        } catch (Exception ex){
            return "Error getting the users: ex.toString()";
        }
        return x;
    }

        @Autowired
        private UserDao userDao;

    }
