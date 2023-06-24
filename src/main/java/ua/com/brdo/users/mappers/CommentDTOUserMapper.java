package ua.com.brdo.users.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ua.com.brdo.users.dtos.CommentDTO;
import ua.com.brdo.users.entities.User;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentDTOUserMapper {

    @Mapping(target = "username", expression = "java(ua.com.brdo.users.utils.StringUtils.trimAndCapitalizeString(commentDTO.getUser().getUsername()))")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    User commentDTOToUser(CommentDTO commentDTO);

    List<User> commentDTOToUser(CommentDTO[] commentDTOs);
}
