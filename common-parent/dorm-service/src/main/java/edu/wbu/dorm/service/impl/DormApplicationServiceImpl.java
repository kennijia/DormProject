package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.*;
import edu.wbu.dorm.service.DormApplicationService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.krb5.internal.PAData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DormApplicationServiceImpl extends BaseServiceImpl<DormApplication> implements DormApplicationService {
    /**
     * 用户查询自己的旧申请记录
     * @param pid
     * @return
     */
    @Override
    public List<DormApplication> findOld(String pid) {
        return daMapper.findOldById(pid);
    }

    /**
     * 用户查询自己的新申请记录
     * @param pid
     * @return
     */
    @Override
    public List<DormApplication> findNew(String pid) {
        return daMapper.findNewById(pid);
    }

    /**
     * 提交换宿舍的申请
     * @param uid
     * @param to_db_id
     * @param to_dorm_number
     * @param reason
     * @return
     */
    @Override
    public int insertNewApplication(String uid,int to_db_id,int to_dorm_number,String reason) {
        int i =0;
        //判断用户是否满足入住条件或者目标宿舍是否满足入住条件
        User u = userMapper.findById(uid);
        if (u!=null){
            int dorm_id = u.getDorm_id();
            if (dorm_id!=0){
                //找到该用户并且住在校内
                Dorm d = dormMapper.findByDbidAndDid(new Dorm(to_db_id, to_dorm_number));//查找目标宿舍的信息
                if (d!=null){
                    DormBuilding dormBuilding = dormBuildingMapper.findById(d.getDb_id());//查找目标宿舍的宿舍楼信息
                    if (d.getOccupy()<d.getCapacity()&&u.getGender().equals(d.getDorm_gender())){
                        //要想申请成功，必须满足：
                        //1.申请人申请的是同性别的宿舍
                        //2.目标宿舍未满人
                        //3.申请人的身份要与目标宿舍的类型一致
                        int dormBuildingType = dormBuilding.getType();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String date = sdf.format(new Date());
                        if (u.getRole()==0&&dormBuildingType<3){
                            //申请人的身份是学生且目标宿舍是学生宿舍
                            i = daMapper.insertApplication(new DormApplication(uid,reason,to_db_id,to_dorm_number,date));
                        }
                        if (u.getRole()==1&&dormBuildingType==3){
                            //申请人身份是教职工且目标宿舍是教职工宿舍
                            i = daMapper.insertApplication(new DormApplication(uid,reason,to_db_id,to_dorm_number,date));
                        }
                    }
                }
            }
        }
        return i;
    }

    @Override
    public int delete(int id) {
        return daMapper.deleteApplication(id);
    }

    @Override
    public int update(DormApplication dorm) {
        return daMapper.updateApplication(dorm);
    }

    @Override
    public DormApplication findOne(int id) {
        return daMapper.findOne(id);
    }

    /**
     * 根据页码查询出对应的申请
     * @return
     */
    @Override
    public PageBean<DormApplicationExt> findByPage(int currentPage) {
        PageBean<DormApplicationExt> page = new PageBean<DormApplicationExt>();
        page.setCurrentPage(currentPage);//当前页
        int totalCount = daMapper.countAll();//总记录数
        page.setTotalCount(totalCount);
        int pageSize = 15;
        page.setPageSize(pageSize);//每页显示条数
        int totalPage = totalCount % 15 == 0 ? totalCount / 15 : totalCount / 15 + 1 ;//总页数
        page.setTotalPage(totalPage);
        int selectedRow = (currentPage-1)*pageSize;
        List<DormApplicationExt> byPage = daMapper.findByPage(selectedRow);//所需记录集合
        page.setInfo(byPage);
        return page;
    }

    @Override
    public int updateStatus(int id, int status) {
        return daMapper.updateStatus(new DormApplication(id,status));
    }

    @Override
    public DormApplication findById(String id) {
        return null;
    }

    @Override
    public DormApplication findById(int id) {
        return daMapper.findById(id);
    }


}
