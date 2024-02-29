package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.VehicleSource;

/**
 * 车源管理Service接口
 * 
 * @author ruoyi
 * @date 2024-02-29
 */
public interface IVehicleSourceService 
{
    /**
     * 查询车源管理
     * 
     * @param id 车源管理主键
     * @return 车源管理
     */
    public VehicleSource selectVehicleSourceById(Long id);

    /**
     * 查询车源管理列表
     * 
     * @param vehicleSource 车源管理
     * @return 车源管理集合
     */
    public List<VehicleSource> selectVehicleSourceList(VehicleSource vehicleSource);

    /**
     * 新增车源管理
     * 
     * @param vehicleSource 车源管理
     * @return 结果
     */
    public int insertVehicleSource(VehicleSource vehicleSource);

    /**
     * 修改车源管理
     * 
     * @param vehicleSource 车源管理
     * @return 结果
     */
    public int updateVehicleSource(VehicleSource vehicleSource);

    /**
     * 批量删除车源管理
     * 
     * @param ids 需要删除的车源管理主键集合
     * @return 结果
     */
    public int deleteVehicleSourceByIds(Long[] ids);

    /**
     * 删除车源管理信息
     * 
     * @param id 车源管理主键
     * @return 结果
     */
    public int deleteVehicleSourceById(Long id);
}
