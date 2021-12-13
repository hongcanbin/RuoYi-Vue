package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.LinkRepo;

/**
 * 链接仓库Mapper接口
 *
 * @author ysj
 * @date 2021-12-07
 */
public interface LinkRepoMapper
{
    /**
     * 查询链接仓库
     *
     * @param id 链接仓库主键
     * @return 链接仓库
     */
    public LinkRepo selectLinkRepoById(Long id);

    /**
     * 查询链接仓库列表
     *
     * @param linkRepo 链接仓库
     * @return 链接仓库集合
     */
    public List<LinkRepo> selectLinkRepoList(LinkRepo linkRepo);

    /**
     * 新增链接仓库
     *
     * @param linkRepo 链接仓库
     * @return 结果
     */
    public int insertLinkRepo(LinkRepo linkRepo);

    /**
     * 修改链接仓库
     *
     * @param linkRepo 链接仓库
     * @return 结果
     */
    public int updateLinkRepo(LinkRepo linkRepo);

    /**
     * 删除链接仓库
     *
     * @param id 链接仓库主键
     * @return 结果
     */
    public int deleteLinkRepoById(Long id);

    /**
     * 批量删除链接仓库
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLinkRepoByIds(Long[] ids);

    List<LinkRepo> selectLinkRepoListOfUser(Long userId);
}
