package learn.example.community.service;

import learn.example.community.enums.CommentTypeEnum;
import learn.example.community.exception.CustomizeErrorCode;
import learn.example.community.exception.CustomizeException;
import learn.example.community.mapper.CommentMapper;
import learn.example.community.mapper.QuestionExtMapper;
import learn.example.community.mapper.QuestionMapper;
import learn.example.community.model.Comment;
import learn.example.community.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FIND);
        }
        System.out.printf(comment.getType()+"");
        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            //回复评论
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }
        System.out.printf(comment.getType()+"");
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FIND);
            }
            commentMapper.insert(comment);
        } else {
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FIND);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);
        }
    }
}
