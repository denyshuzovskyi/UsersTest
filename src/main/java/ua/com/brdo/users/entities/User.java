package ua.com.brdo.users.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.com.brdo.users.converters.LocalDateTimeStringConverter;
import ua.com.brdo.users.utils.DateTimeStringConverters;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    private Integer id;
    private String body;
    @Column(name = "postid")
    private Integer postId;
    private String username;
    @Column(name = "updatedat")
    @Convert(converter = LocalDateTimeStringConverter.class)
    private LocalDateTime updatedAt;

    public String getUpdatedAtFormatted() {
        return DateTimeStringConverters.localDateTimeToString(updatedAt);
    }
}
