package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.Dorm;
import edu.wbu.dorm.model.DormBuilding;
import edu.wbu.dorm.service.DormService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DormServiceImpl extends BaseServiceImpl<Dorm> implements DormService {

    @Override
    public List<Dorm> findAllDorms(int db_id) {
        return dormMapper.findAllDorms(db_id);
    }

    @Override
    public Boolean isAdd(int db_id, int dorm_number) {
        Dorm dorm = dormMapper.findByDbidAndDnumber(new Dorm(db_id, dorm_number));
        if (dorm==null)
            return false;//没有该宿舍
        if (dorm.getOccupy()<dorm.getCapacity())
            return true;//找到该宿舍且没有住满人
        else
            return false;//找到该宿舍但已满人
    }

    @Override
    public Boolean isOutside(String uid) {
        int dorm_id = userMapper.findById(uid).getDorm_id();
        if (dorm_id==0){
            return true;//代表住在校外
        }
        return false;//代表住在校内
    }

    @Override
    public int addDorm(int db_Id, int dorm_number, int capacity) {
        int i = 0;
        if (capacity<=0)
            //可住人数至少为1
            return i;
        //先检验该宿舍楼是否存在
        DormBuilding byId = dormBuildingMapper.findById(db_Id);
        if (byId!=null){
        int type = byId.getType();
        String gender =null;
        if (type==1||type==3)
            gender = "男";
        if (type==2||type==4)
            gender = "女";
            //再检验该编号在此宿舍楼中是否存在
            Dorm d = dormMapper.findByDbidAndDnumber(new Dorm(db_Id, dorm_number));
            if (d==null){
                //此时可以安全添加
                Dorm dorm = new Dorm(db_Id,dorm_number);
                dorm.setCapacity(capacity);
                dorm.setDorm_gender(gender);
                i = dormMapper.insertDorm(dorm);
            }
        }
        return i;
    }


    @Override
    public Dorm findById(String id) {
        return null;
    }

    @Override
    public Dorm findById(int id) {
        return dormMapper.findById(id);
    }
}
