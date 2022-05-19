package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Getzichanxifen;

/**
 * 资产细分Service接口
 * 
 * @author gongyu
 * @date 2022-05-19
 */
public interface IGetzichanxifenService 
{
    /**
     * 查询资产细分
     * 
     * @param name 资产细分主键
     * @return 资产细分
     */
    public Getzichanxifen selectGetzichanxifenByName(String name);

    /**
     * 查询资产细分列表
     * 
     * @param getzichanxifen 资产细分
     * @return 资产细分集合
     */
    public List<Getzichanxifen> selectGetzichanxifenList(Getzichanxifen getzichanxifen);

    /**
     * 新增资产细分
     * 
     * @param getzichanxifen 资产细分
     * @return 结果
     */
    public int insertGetzichanxifen(Getzichanxifen getzichanxifen);

    /**
     * 修改资产细分
     * 
     * @param getzichanxifen 资产细分
     * @return 结果
     */
    public int updateGetzichanxifen(Getzichanxifen getzichanxifen);

    /**
     * 批量删除资产细分
     * 
     * @param names 需要删除的资产细分主键集合
     * @return 结果
     */
    public int deleteGetzichanxifenByNames(String[] names);

    /**
     * 删除资产细分信息
     * 
     * @param name 资产细分主键
     * @return 结果
     */
    public int deleteGetzichanxifenByName(String name);
}
