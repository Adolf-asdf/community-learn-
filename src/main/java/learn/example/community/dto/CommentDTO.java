package learn.example.community.dto;

import learn.example.community.model.User;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private Integer commentCount;
    private User user;
}
