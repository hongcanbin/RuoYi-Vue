package com.stdiet.custom.service;

import java.util.List;

import com.stdiet.common.core.domain.AjaxResult;
import com.stdiet.custom.domain.SysLiveSchedul;
import com.stdiet.custom.domain.SysLiveSchedulFanRecord;

/**
 * 直播排班Service接口
 *
 * @author xzj
 * @date 2021-05-12
 */
public interface ISysLiveSchedulService
{
    /**
     * 查询直播排班
     *
     * @param id 直播排班ID
     * @return 直播排班
     */
    public SysLiveSchedul selectSysLiveSchedulById(Long id);

    /**
     * 查询直播排班列表
     *
     * @param sysLiveSchedul 直播排班
     * @return 直播排班集合
     */
    public List<SysLiveSchedul> selectSysLiveSchedulList(SysLiveSchedul sysLiveSchedul);

    /**
     * 新增直播排班
     *
     * @param sysLiveSchedul 直播排班
     * @return 结果
     */
    public int insertSysLiveSchedul(SysLiveSchedul sysLiveSchedul);

    /**
     * 修改直播排班
     *
     * @param sysLiveSchedul 直播排班
     * @return 结果
     */
    public int updateSysLiveSchedul(SysLiveSchedul sysLiveSchedul);

    /**
     * 批量删除直播排班
     *
     * @param ids 需要删除的直播排班ID
     * @return 结果
     */
    public int deleteSysLiveSchedulByIds(Long[] ids);

    /**
     * 删除直播排班信息
     *
     * @param id 直播排班ID
     * @return 结果
     */
    public int deleteSysLiveSchedulById(Long id);

    /**
     * 根据直播时间查询是否重叠
     */
    public SysLiveSchedul getLiveSchedulByLiveTime(SysLiveSchedul sysLiveSchedul);

    /**
     * 更新部分字段
     * @param sysLiveSchedul
     * @return
     */
    public int updateSysLiveSchedulById(SysLiveSchedul sysLiveSchedul);

    /**
     * 根据ID查询上一条记录
     * @param sysLiveSchedul
     * @return
     */
    public SysLiveSchedul getLastLiveSchedulById(SysLiveSchedul sysLiveSchedul);

    /**
     * 复制上一次直播间计划，并将上次的直播计划状态全部改为未开播
     * @return
     */
    public AjaxResult copyLastTimeLiveSchedul();

    /**
     * 根据时间确定最近的直播记录
     * @return
     */
    public SysLiveSchedul getLiveSchedulByTime(SysLiveSchedul sysLiveSchedul);


    /**
     * 给对应直播添加进粉记录
     * @return
     */
    int addLiveSchedulFanRecord(SysLiveSchedulFanRecord sysLiveSchedulFanRecord);

    /**
     * 给对应直播更新进粉记录
     * @param sysLiveSchedulFanRecord
     * @return
     */
    int updateLiveSchedulFanRecord(SysLiveSchedulFanRecord sysLiveSchedulFanRecord);

    /**
     * 给对应直播删除进粉记录
     * @param id
     * @return
     */
    int delLiveSchedulFanRecord(Long id);

    /**
     * 查询导粉总量
     * @param sysLiveSchedul
     * @return
     */
    int getTotalImportFanNumByLiveSchedul(SysLiveSchedul sysLiveSchedul);

    /**
     * 查询总进粉量
     * @param sysLiveSchedul
     * @return
     */
    int getTotalAddFanNumByLiveSchedul(SysLiveSchedul sysLiveSchedul);

    /**
     * 查询总直播时长
     * @param sysLiveSchedul
     * @return
     */
    int getLiveTotalTimeByLiveSchedul(SysLiveSchedul sysLiveSchedul);
}