package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.Dorm;
import edu.wbu.dorm.model.DormBuilding;
import edu.wbu.dorm.model.DormExt;
import edu.wbu.dorm.model.User;
import edu.wbu.dorm.service.UserService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    /**
     * 根据不同角色分配宿舍
     * @param role
     * @param gender
     * @param type
     * @return
     */
    private int privateDistributionOfDorm(int role,String gender,int type){
        Dorm d = new Dorm();
        User u = new User();
        u.setRole(role);
        u.setGender(gender);
        List<User> users = userMapper.findFemaleOrMale(u);
        List<DormBuilding> dormBuildings = dormBuildingMapper.findEmptyDorm(type);
        List<Dorm> dorms = null;
        if (dormBuildings.size()>0){
                dorms = dormBuildings.get(0).getDormList();
                for (int i = 1;i<dormBuildings.size();i++)
                    dorms.addAll(dormBuildings.get(i).getDormList());
        }
        int index = 0;
        if (users!=null&&dorms!=null&&users.size()>0&&dorms.size()>0){
            for (Dorm dorm:dorms){
                int dorm_id = dorm.getId();
                int occupy = dorm.getOccupy();//已住人数
                for (;occupy<dorm.getCapacity();occupy++){
                    if (index==users.size())
                        break;//索引到达用户列表末尾，循坏结束
                    //将该生信息的宿舍号修改为dorm_id
                    String uid = users.get(index).getId();
                    u.setId(uid);
                    u.setDorm_id(dorm_id);
                    userMapper.updateDormId(u);
                    index++;
                }
                //将该宿舍的已住人数修改为occupy
                d.setId(dorm_id);
                d.setOccupy(occupy);
                dormMapper.updateOccupy(d);
            }
        }
        if (users.size()-index>0){
            System.out.println("宿舍不够...");
            return users.size()-index;
        }
        return 0;
    }

    public Boolean login(String uid, String password) {
        User u = userMapper.findById(uid);
        if (u==null)
            //没有该用户
            return false;
        if (password.equals(u.getPassword()))
            //找到用户且密码正确
            return true;
        else
            //找到用户但密码错误
            return false;
    }

    @Override
    public Map<String, Integer> countPersonProportion() {
        Map<String,Integer> map = new HashMap<String,Integer>();
        User u = new User();
        u.setGender("男");
        u.setRole(0);
        u.setDorm_id(100);
        int countMale = userMapper.countPerson(u);
        u.setGender("女");
        int countFemale = userMapper.countPerson(u);
        System.out.println(countMale+"...."+countFemale);
        if (countMale==0&&countFemale==0){
            map.put("male",30);
            map.put("female",70);
            return map;
        }
        int maleProportion = (countMale*100)/(countFemale+countMale);
        int femaleProportion = 100 - maleProportion;
        map.put("male",maleProportion);
        map.put("female",femaleProportion);
        return map;
    }

    @Override
    public Boolean isAdmin(String uid) {
        User byId = userMapper.findById(uid);
        if (byId==null)
            return false;
        if (byId.getPermission()>0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean exists(String uid) {
        User byId = userMapper.findById(uid);
        if (byId==null)
            return false;
        return true;
    }

    @Override
    public Map<String ,Integer> distributionOfDorm() {
        Map<String,Integer> map = new HashMap<String ,Integer>();
        int maleStu = privateDistributionOfDorm(0, "男", 1);
        int femaleStu = privateDistributionOfDorm(0, "女", 2);
        int maleSta = privateDistributionOfDorm(1, "男", 3);
        int femaleSta = privateDistributionOfDorm(1, "女", 4);
        //在最后，将已住人的宿舍数量更新至宿舍楼表中
        List<DormExt> numberByDbId = dormMapper.findNumberByDbId();
        for (DormExt dormExt:numberByDbId){
            dormBuildingMapper.updateOccupy(dormExt);
        }
        map.put("maleStu",maleStu);
        map.put("femaleStu",femaleStu);
        map.put("maleSta",maleSta);
        map.put("femaleSta",femaleSta);
        return map;

    }

    @Override
    public String changeImg(String uid, String path, MultipartFile headImg) {
        File f = new File(path);
        if (!f.exists()){
            f.mkdirs();
        }
        String suffix = headImg.getOriginalFilename().split("\\.")[1];
        String newFileName = UUID.randomUUID().toString()+"."+suffix;
        String totalPath = path+"/"+newFileName;
        try {
            FileCopyUtils.copy(headImg.getInputStream(),new FileOutputStream(new File(totalPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imgUri = "/image/headpic/"+newFileName;
        User u = new User();
        u.setId(uid);
        u.setHeadpic(imgUri);
        int i = userMapper.updateImg(u);
        if (i>0)
            return imgUri;
        return null;
    }

    @Override
    public Map<String, Integer> count() {
        Map<String,Integer> map = new HashMap<String,Integer>();
        User u = new User("男",0);
        u.setDorm_id(0);
        int maleStudentNumber = userMapper.countPerson(u);
        u.setRole(1);
        int maleStaffNumber = userMapper.countPerson(u);
        u.setGender("女");
        int femaleStaffNumber = userMapper.countPerson(u);
        u.setRole(0);
        int femaleStudentNumber = userMapper.countPerson(u);
        map.put("maleStudentNumber",maleStudentNumber);
        map.put("femaleStudentNumber",femaleStudentNumber);
        map.put("maleStaffNumber",maleStaffNumber);
        map.put("femaleStaffNumber",femaleStaffNumber);
        return map;
    }

    @Override
    public List<User> findNoDistributionPerson(int behavior) {
        User u = new User();
        String gender = "男";
        int role = 0;
        int dorm_id = 0;
        if (behavior==2){
            gender = "女";
        }
        if (behavior==3){
            gender = "男";
            role = 1;
        }
        if (behavior==4){
            gender = "女";
            role = 1;
        }
        u.setGender(gender);
        u.setRole(role);
        u.setDorm_id(dorm_id);
        return userMapper.findByRoleAndGenderAndDormId(u);
    }

    @Override
    public Boolean uploadExcel(MultipartFile file) {
        XSSFRow row;
        InputStream fis = null;
        XSSFWorkbook workbook = null;
        User u = new User();
        try {
            fis = file.getInputStream();
            workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator <Row> rowIterator = spreadsheet.iterator();
            rowIterator.next();//跳过第一行，第一行为标题行
            while (rowIterator.hasNext())
            {
                row = (XSSFRow) rowIterator.next();
                u.setId(row.getCell(0).getStringCellValue());
                u.setName(row.getCell(1).getStringCellValue());
                u.setGender(row.getCell(2).getStringCellValue());
                u.setAge((int)row.getCell(3).getNumericCellValue());
                Cell c = row.getCell(4);
                String dept;
                try {
                    dept = c.getStringCellValue();
                    u.setDept(dept);
                } catch (Exception e) {
                    u.setDept("");
                }
                u.setDorm_id((int)row.getCell(5).getNumericCellValue());
                u.setInstitute(row.getCell(6).getStringCellValue());
                u.setPassword(row.getCell(7).getStringCellValue());
                u.setRole((int)row.getCell(8).getNumericCellValue());
                u.setEmail(row.getCell(9).getStringCellValue());
                u.setHomeAddress(row.getCell(10).getStringCellValue());
                //SimpleDateFormat sdf = new SimpleDateFormat(row.getCell(11).getCellStyle().getDataFormatString());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(row.getCell(11).getDateCellValue());
                u.setEntrancetime(date);
                u.setPermission((int)row.getCell(14).getNumericCellValue());
                User u1 = userMapper.findById(u.getId());
                if (u1==null){
                    userMapper.insertUser(u);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 查找用户信息
     * @param id
     * @return
     */
    public User findById(String id) {
        User user = userMapper.findById(id);
        user.setPassword("");
        return user;

    }

    public User findById(int id) {
        return null;
    }


}
