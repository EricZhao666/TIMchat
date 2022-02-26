package timchat.beta.component;

import org.springframework.beans.factory.annotation.Autowired;
import timchat.beta.Mapper.UserMapper;


public class IdUtils {
    @Autowired
    UserMapper userMapper;

    public int idGetter(){
        boolean isin=true;
        int id=1;
        int uid=1;
        while (isin){
            if (userMapper.findId(id)==null){
                 uid=id;
                break;
            }
            id++;

        }
        return uid;
    }

}
