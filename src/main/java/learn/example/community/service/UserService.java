package learn.example.community.service;

import learn.example.community.mapper.UserMapper;
import learn.example.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        User dbUser=userMapper.findByAccountId(user.getAccountId());
        if(dbUser==null){
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }else{
            user.setGmtModified(System.currentTimeMillis());
            user.setToken(user.getToken());
            user.setName(user.getName());
            user.setAvatarUrl(user.getAvatarUrl());
            userMapper.update(dbUser);
        }
    }
}
