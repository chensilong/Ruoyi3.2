package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.annotation.Excel;
import java.util.Date;

/**
 * 个人表 geren
 * 
 * @author ruoyi
 * @date 2019-03-13
 */
public class Geren extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
@Excel(name = "ID", prompt = "ID")
	private Integer id;
	/** 姓名 */
@Excel(name = "姓名", prompt = "姓名")
	private String name;
	/** 年纪 */
@Excel(name = "年纪", prompt = "年纪")
	private Integer age;
	/** 身份证 */
@Excel(name = "身份证", prompt = "身份证")
	private String sfz;
	/** 是否 */
@Excel(name = "是否", prompt = "是否")
	private Integer isno;
	/** 更新时间 */
@Excel(name = "更新时间", prompt = "更新时间")
	private Date uptime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setAge(Integer age) 
	{
		this.age = age;
	}

	public Integer getAge() 
	{
		return age;
	}
	public void setSfz(String sfz) 
	{
		this.sfz = sfz;
	}

	public String getSfz() 
	{
		return sfz;
	}
	public void setIsno(Integer isno) 
	{
		this.isno = isno;
	}

	public Integer getIsno() 
	{
		return isno;
	}
	public void setUptime(Date uptime) 
	{
		this.uptime = uptime;
	}

	public Date getUptime() 
	{
		return uptime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("age", getAge())
            .append("sfz", getSfz())
            .append("isno", getIsno())
            .append("uptime", getUptime())
            .toString();
    }
}
