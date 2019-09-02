package yuanian.mapper;

import org.apache.ibatis.annotations.Mapper;
import yuanian.pojo.Usercode;

@Mapper
public interface UsercodeMapper {
    void insterUsercode(Usercode usercode);

    Usercode findUsercodeByid(Integer ucid);
}
