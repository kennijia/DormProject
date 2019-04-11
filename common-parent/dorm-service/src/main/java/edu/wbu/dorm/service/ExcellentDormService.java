package edu.wbu.dorm.service;

import edu.wbu.dorm.model.ExcellentDorm;
import edu.wbu.dorm.service.base.BaseService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcellentDormService extends BaseService<ExcellentDorm> {

    List<ExcellentDorm> findAll();

    int ed(int edId, int ed_dormId, List<MultipartFile> ed_imgs, MultipartFile ed_introduce, String savePath);
}
