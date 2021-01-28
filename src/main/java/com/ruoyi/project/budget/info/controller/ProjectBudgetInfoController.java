package com.ruoyi.project.budget.info.controller;

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
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.budget.info.domain.ProjectBudgetInfo;
import com.ruoyi.project.budget.info.service.IProjectBudgetInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 项目管理Controller
 *
 * @author yueqiangu
 * @date 2021-01-10
 */
@Controller
@RequestMapping("/budget/info")
public class ProjectBudgetInfoController extends BaseController
{
    private String prefix = "budget/info";

    @Autowired
    private IProjectBudgetInfoService projectBudgetInfoService;


    @RequiresPermissions("budget:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询项目管理列表
     */
    @RequiresPermissions("budget:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectBudgetInfo projectBudgetInfo)
    {
        startPage();
        List<ProjectBudgetInfo> list = projectBudgetInfoService.selectProjectBudgetInfoList(projectBudgetInfo);
        return getDataTable(list);
    }

    /**
     * 导出项目管理列表
     */
    @RequiresPermissions("budget:info:export")
    @Log(title = "项目管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectBudgetInfo projectBudgetInfo)
    {
        List<ProjectBudgetInfo> list = projectBudgetInfoService.selectProjectBudgetInfoList(projectBudgetInfo);
        ExcelUtil<ProjectBudgetInfo> util = new ExcelUtil<ProjectBudgetInfo>(ProjectBudgetInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增项目管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目管理
     */
    @RequiresPermissions("budget:info:add")
    @Log(title = "项目管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProjectBudgetInfo projectBudgetInfo)
    {
        return toAjax(projectBudgetInfoService.insertProjectBudgetInfo(projectBudgetInfo));
    }

    /**
     * 修改项目管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProjectBudgetInfo projectBudgetInfo = projectBudgetInfoService.selectProjectBudgetInfoById(id);
        mmap.put("projectBudgetInfo", projectBudgetInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目管理
     */
    @RequiresPermissions("budget:info:edit")
    @Log(title = "项目管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProjectBudgetInfo projectBudgetInfo)
    {
        return toAjax(projectBudgetInfoService.updateProjectBudgetInfo(projectBudgetInfo));
    }

    /**
     * 删除项目管理
     */
    @RequiresPermissions("budget:info:remove")
    @Log(title = "项目管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(projectBudgetInfoService.deleteProjectBudgetInfoByIds(ids));
    }

    /**
     * 修改项目管理
     */
    @GetMapping("/approval/{id}")
    public String approval(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProjectBudgetInfo projectBudgetInfo = projectBudgetInfoService.selectProjectBudgetInfoById(id);
        mmap.put("projectBudgetInfo", projectBudgetInfo);
        return prefix + "/approval";
    }

    /**
     * 项目提交
     *
     *
     */
    @RequiresPermissions("budget:info:edit")
    @Log(title = "项目管理", businessType = BusinessType.UPDATE)
    @PostMapping("/submit")
    @ResponseBody
    public AjaxResult submit(ProjectBudgetInfo projectBudgetInfo)
    {
        return toAjax(projectBudgetInfoService.submit(projectBudgetInfo));
    }
}
