package ua.com.brdo.users.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.brdo.users.dtos.CommentDTO;
import ua.com.brdo.users.entities.User;
import ua.com.brdo.users.mappers.CommentDTOUserMapper;
import ua.com.brdo.users.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final CommentDTOUserMapper commentDTOUserMapper;

    public void transformCommentDTOsAndSaveUsers(CommentDTO[] comments){
        userRepository.saveAll(commentDTOUserMapper.commentDTOToUser(comments));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
