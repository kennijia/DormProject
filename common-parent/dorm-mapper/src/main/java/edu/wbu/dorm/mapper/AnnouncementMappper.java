package edu.wbu.dorm.mapper;

import edu.wbu.dorm.mapper.base.BaseMapper;
import edu.wbu.dorm.model.Announcement;

import java.util.List;

public interface AnnouncementMappper extends BaseMapper<Announcement> {
    /**
     * 查询最新的6条公告
     * @return
     */
    List<Announcement> findTopSixByTime();

    /**
     * 删除该条公告
     * @param anouId
     * @return
     */
    int delete(int anouId);

    /**
     * 修改该条公告
     * @param anou
     * @return
     */
    int update(Announcement anou);
}
