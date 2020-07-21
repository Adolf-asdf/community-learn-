package learn.example.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FIND(2001,"该问题不存在，或已删除"),
    TARGET_PARAM_NOT_FIND(2002,"未选中任何问题或者评论进行回复"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试"),
    SYS_ERROR(2004,"服务器冒烟了，请稍后重试"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FIND(2006,"回复的评论不存在，或已删除" ),
    COMMENT_IS_EMPTY(2007,"输入内容不能为空"),
    ;


    private Integer code;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
