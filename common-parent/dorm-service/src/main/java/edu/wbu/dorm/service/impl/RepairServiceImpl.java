package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.PageBean;
import edu.wbu.dorm.model.Repair;
import edu.wbu.dorm.model.RepairExt;
import edu.wbu.dorm.model.User;
import edu.wbu.dorm.service.RepairService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RepairServiceImpl extends BaseServiceImpl<Repair> implements RepairService {
    @Override
    public List<Repair> findByDormId(int dorm_id) {
        return repairMapper.findByDormId(dorm_id);
    }

    @Override
    public int insertNewRepair(String uid, String content) {
        //首先找到该用户的dorm_id
        User u = userMapper.findById(uid);
        int i = 0;
        if (u!=null){
            int dorm_id = u.getDorm_id();
            if (dorm_id!=0){
                //找到该用户且不住在校外
                Repair r = new Repair(dorm_id,content);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(new Date());
                r.setCreateTime(date);
                i = repairMapper.insert(r);
            }
        }
        return i;
    }

    @Override
    public List<Repair> findRepairs(String uid) {
        User u = userMapper.findById(uid);
        if (u!=null){
            int dorm_id = u.getDorm_id();
            if (dorm_id!=0){
                //找到该用户且不住在校外
                return repairMapper.findByDormId(dorm_id);
            }
        }
        return null;
    }

    @Override
    public PageBean<RepairExt> findByPage(int currentPage) {
        PageBean<RepairExt> page = new PageBean<RepairExt>();
        page.setCurrentPage(currentPage);//当前页
        int totalCount = repairMapper.countAll();//总记录数
        page.setTotalCount(totalCount);
        int pageSize = 15;
        page.setPageSize(pageSize);//每页显示条数
        int totalPage = totalCount % 15 == 0 ? totalCount / 15 : totalCount / 15 + 1 ;//总页数
        page.setTotalPage(totalPage);
        int selectedRow = (currentPage-1)*pageSize;
        List<RepairExt> byPage = repairMapper.findByPage(selectedRow);//所需记录集合
        page.setInfo(byPage);
        return page;
    }

    @Override
    public Repair findById(String id) {
        return null;
    }

    @Override
    public Repair findById(int id) {
        return null;
    }
}
