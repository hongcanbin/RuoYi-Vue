package com.gox.system.service;

import java.util.List;

import com.gox.common.core.domain.AjaxResult;
import com.gox.common.utils.file.Chunk;
import com.gox.system.domain.Metadata;

import javax.servlet.http.HttpServletResponse;

/**
 * 文书类基本元数据Service接口
 * 
 * @author gox
 * @date 2020-12-28
 */
public interface IMetadataService 
{
    /**
     * 查询文书类基本元数据
     * 
     * @param id 文书类基本元数据ID
     * @return 文书类基本元数据
     */
    public Metadata selectMetadataById(Long id);

    /**
     * 查询文书类基本元数据列表
     * 
     * @param metadata 文书类基本元数据
     * @return 文书类基本元数据集合
     */
    public List<Metadata> selectMetadataList(Metadata metadata);

    /**
     * 新增文书类基本元数据
     * 
     * @param metadata 文书类基本元数据
     * @return 结果
     */
    public int insertMetadata(Metadata metadata);

    /**
     * 修改文书类基本元数据
     * 
     * @param metadata 文书类基本元数据
     * @return 结果
     */
    public int updateMetadata(Metadata metadata);

    /**
     * 批量删除文书类基本元数据
     * 
     * @param ids 需要删除的文书类基本元数据ID
     * @return 结果
     */
    public int deleteMetadataByIds(Long[] ids);

    /**
     * 删除文书类基本元数据信息
     * 
     * @param id 文书类基本元数据ID
     * @return 结果
     */
    public int deleteMetadataById(Long id);
    /**
     * 生成档号
     */
    String generateArchivalCode(String[] fields,Object [] values);

    /**
     * 根据id导出 excel
     * @param ids 文书类基本元数据ID
     * @return 结果
     */
    AjaxResult exportExcelByIds(Long []ids);
    /**
     * 根据id导出 excel 电子原文
     * @param ids 文书类基本元数据ID
     * @return 结果
     */
    AjaxResult exportExcelAndEleByIds(Long []ids);

    /**
     * 上传处理
     * @return result
     */
    String uploadHandle(Chunk chunk, HttpServletResponse response);
}
