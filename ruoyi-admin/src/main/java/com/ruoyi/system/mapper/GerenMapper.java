package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Geren;
import java.util.List;	

/**
 * 个人 数据层
 * 
 * @author ruoyi
 * @date 2019-03-13
 */
public interface GerenMapper 
{
	/**
     * 查询个人信息
     * 
     * @param id 个人ID
     * @return 个人信息
     */
	public Geren selectGerenById(Integer id);
	
	/**
     * 查询个人列表
     * 
     * @param geren 个人信息
     * @return 个人集合
     */
	public List<Geren> selectGerenList(Geren geren);
	
	/**
     * 新增个人
     * 
     * @param geren 个人信息
     * @return 结果
     */
	public int insertGeren(Geren geren);
	
	/**
     * 修改个人
     * 
     * @param geren 个人信息
     * @return 结果
     */
	public int updateGeren(Geren geren);
	
	/**
     * 删除个人
     * 
     * @param id 个人ID
     * @return 结果
     */
	public int deleteGerenById(Integer id);
	
	/**
     * 批量删除个人
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteGerenByIds(String[] ids);
	
}