package ua.com.brdo.users.dtos;

import lombok.Data;

@Data
public class CommentsDTO {
    private CommentDTO[] comments;

    private int total;

    private int skip;

    private int limit;
}
