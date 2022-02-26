package timchat.beta.Mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import timchat.beta.entiy.User;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<User> findAll();
    User findByName(String name);
    String findPswByName(String UserName);
    User findId(int id);
    void save(User user);
}
