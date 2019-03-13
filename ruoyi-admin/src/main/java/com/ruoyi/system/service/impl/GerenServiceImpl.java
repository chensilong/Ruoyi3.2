package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GerenMapper;
import com.ruoyi.system.domain.Geren;
import com.ruoyi.system.service.IGerenService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;

/**
 * 个人 服务层实现
 * 
 * @author ruoyi
 * @date 2019-03-13
 */
@Service
public class GerenServiceImpl implements IGerenService 
{
	@Autowired
	private GerenMapper gerenMapper;

	/**
     * 查询个人信息
     * 
     * @param id 个人ID
     * @return 个人信息
     */
    @Override
	public Geren selectGerenById(Integer id)
	{
	    return gerenMapper.selectGerenById(id);
	}
	
	/**
     * 查询个人列表
     * 
     * @param geren 个人信息
     * @return 个人集合
     */
	@Override
	public List<Geren> selectGerenList(Geren geren)
	{
	    return gerenMapper.selectGerenList(geren);
	}
	
    /**
     * 新增个人
     * 
     * @param geren 个人信息
     * @return 结果
     */
	@Override
	public int insertGeren(Geren geren)
	{
	    return gerenMapper.insertGeren(geren);
	}
	
	/**
     * 修改个人
     * 
     * @param geren 个人信息
     * @return 结果
     */
	@Override
	public int updateGeren(Geren geren)
	{
	    return gerenMapper.updateGeren(geren);
	}

	/**
     * 删除个人对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteGerenByIds(String ids)
	{
		return gerenMapper.deleteGerenByIds(Convert.toStrArray(ids));
	}

    /**
     * 导入个人对象
     * @param gerenList
     * @return
     */

    @Override
    public String importGeren(List<Geren> gerenList) {
    if (StringUtils.isNull(gerenList) || gerenList.size() == 0) {
        throw new BusinessException("导入用户数据不能为空！");
    }
    int successNum = 0;
    StringBuilder successMsg = new StringBuilder();
    for (Geren geren : gerenList) {
        this.insertGeren(geren);
        successNum++;
    }
    successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
    return successMsg.toString();
}
	
}
