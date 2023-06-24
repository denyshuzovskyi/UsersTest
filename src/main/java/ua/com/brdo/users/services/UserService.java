package ua.com.brdo.users.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.brdo.users.dtos.CommentDTO;
import ua.com.brdo.users.entities.User;
import ua.com.brdo.users.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void transformAndSaveComments(CommentDTO[] comments){
        User[] users = new User[comments.length];
        for (int i = 0; i < comments.length; i++) {
            CommentDTO currentComment = comments[i];
            User currentUser = new User();
            currentUser.setId(currentComment.getId());
            currentUser.setBody(currentComment.getBody());
            currentUser.setUsername(currentComment.getUser().getUsername());
            currentUser.setPostId(currentComment.getPostId());
            currentUser.setUpdatedAt(LocalDateTime.now());
            users[i] = currentUser;
        }
        userRepository.saveAll(Arrays.asList(users));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
