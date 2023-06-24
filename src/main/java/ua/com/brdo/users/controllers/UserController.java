package ua.com.brdo.users.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.brdo.users.clients.DummyJSONClient;
import ua.com.brdo.users.dtos.CommentsDTO;
import ua.com.brdo.users.entities.User;
import ua.com.brdo.users.services.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController implements InitializingBean {
    private final DummyJSONClient dummyJSONClient;
    private final UserService userService;

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        CommentsDTO allComments = dummyJSONClient.getAllComments();
        userService.transformCommentDTOsAndSaveUsers(allComments.getComments());
    }
}
