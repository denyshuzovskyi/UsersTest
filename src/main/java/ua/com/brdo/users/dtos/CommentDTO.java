package ua.com.brdo.users.dtos;

import lombok.Data;

@Data
public class CommentDTO {
    private int id;
    private String body;
    private int postId;
    private UserDTO user;
}
