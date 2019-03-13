package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Geren;
import com.ruoyi.system.service.IGerenService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
/**
 * 个人 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-13
 */
@Controller
@RequestMapping("/system/geren")
public class GerenController extends BaseController
{
    private String prefix = "system/geren";
	
	@Autowired
	private IGerenService gerenService;
	
	@RequiresPermissions("system:geren:view")
	@GetMapping()
	public String geren()
	{
	    return prefix + "/geren";
	}
	
	/**
	 * 查询个人列表
	 */
	@RequiresPermissions("system:geren:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Geren geren)
	{
		startPage();
        List<Geren> list = gerenService.selectGerenList(geren);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出个人列表
	 */
	@RequiresPermissions("system:geren:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Geren geren)
    {
    	List<Geren> list = gerenService.selectGerenList(geren);
        ExcelUtil<Geren> util = new ExcelUtil<Geren>(Geren.class);
        return util.exportExcel(list, "geren");
    }
    /**
     * 导入个人列表
     */
    @RequiresPermissions("system:geren:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<Geren> util = new ExcelUtil<Geren>(Geren.class);
        List<Geren> userList = util.importExcel(file.getInputStream());
        String message = gerenService.importGeren(userList);
        return AjaxResult.success(message);
    }
    /**
     * 个人表格模板下载
     * @return
     */
    @RequiresPermissions("system:geren:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<Geren> util = new ExcelUtil<Geren>(Geren.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增个人
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存个人
	 */
	@RequiresPermissions("system:geren:add")
	@Log(title = "个人", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Geren geren)
	{		
		return toAjax(gerenService.insertGeren(geren));
	}

	/**
	 * 修改个人
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Geren geren = gerenService.selectGerenById(id);
		mmap.put("geren", geren);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存个人
	 */
	@RequiresPermissions("system:geren:edit")
	@Log(title = "个人", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Geren geren)
	{		
		return toAjax(gerenService.updateGeren(geren));
	}
	
	/**
	 * 删除个人
	 */
	@RequiresPermissions("system:geren:remove")
	@Log(title = "个人", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(gerenService.deleteGerenByIds(ids));
	}
	
}
