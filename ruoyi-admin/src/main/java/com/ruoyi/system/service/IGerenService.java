package com.ruoyi.system.service;

import com.ruoyi.system.domain.Geren;
import java.util.List;

/**
 * 个人 服务层
 * 
 * @author ruoyi
 * @date 2019-03-13
 */
public interface IGerenService 
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
     * 删除个人信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteGerenByIds(String ids);

    /**
     * 导入个人数据
     * @param gerenList
     * @return
     */
    public String importGeren(List<Geren> gerenList);
	
}
