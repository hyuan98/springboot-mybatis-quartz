package yuanian.service;

import yuanian.pojo.Usercode;

public interface UsercodeService {
    void insterUsercode(Usercode usercode);

    Usercode findUsercodeByid(Integer ucid);

}
