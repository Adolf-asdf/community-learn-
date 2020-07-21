package learn.example.community.mapper;

import learn.example.community.model.Comment;
import learn.example.community.model.Question;

public interface CommentExtMapper {
   /* int incView(Question record);*/
    int incCommentCount(Comment comment);
}