package com.ruoyi.project.budget.detail.controller;

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
import com.ruoyi.project.budget.detail.domain.ProjectBudgetDetail;
import com.ruoyi.project.budget.detail.service.IProjectBudgetDetailService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 项目明细Controller
 * 
 * @author yueqiangu
 * @date 2021-01-10
 */
@Controller
@RequestMapping("/budget/detail")
public class ProjectBudgetDetailController extends BaseController
{
    private String prefix = "budget/detail";

    @Autowired
    private IProjectBudgetDetailService projectBudgetDetailService;

    @RequiresPermissions("budget:detail:view")
    @GetMapping()
    public String detail()
    {
        return prefix + "/detail";
    }

    /**
     * 查询项目明细列表
     */
    @RequiresPermissions("budget:detail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectBudgetDetail projectBudgetDetail)
    {
        startPage();
        List<ProjectBudgetDetail> list = projectBudgetDetailService.selectProjectBudgetDetailList(projectBudgetDetail);
        return getDataTable(list);
    }

    /**
     * 导出项目明细列表
     */
    @RequiresPermissions("budget:detail:export")
    @Log(title = "项目明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectBudgetDetail projectBudgetDetail)
    {
        List<ProjectBudgetDetail> list = projectBudgetDetailService.selectProjectBudgetDetailList(projectBudgetDetail);
        ExcelUtil<ProjectBudgetDetail> util = new ExcelUtil<ProjectBudgetDetail>(ProjectBudgetDetail.class);
        return util.exportExcel(list, "detail");
    }

    /**
     * 新增项目明细
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目明细
     */
    @RequiresPermissions("budget:detail:add")
    @Log(title = "项目明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProjectBudgetDetail projectBudgetDetail)
    {
        return toAjax(projectBudgetDetailService.insertProjectBudgetDetail(projectBudgetDetail));
    }

    /**
     * 修改项目明细
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProjectBudgetDetail projectBudgetDetail = projectBudgetDetailService.selectProjectBudgetDetailById(id);
        mmap.put("projectBudgetDetail", projectBudgetDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目明细
     */
    @RequiresPermissions("budget:detail:edit")
    @Log(title = "项目明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProjectBudgetDetail projectBudgetDetail)
    {
        return toAjax(projectBudgetDetailService.updateProjectBudgetDetail(projectBudgetDetail));
    }

    /**
     * 删除项目明细
     */
    @RequiresPermissions("budget:detail:remove")
    @Log(title = "项目明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(projectBudgetDetailService.deleteProjectBudgetDetailByIds(ids));
    }
}
