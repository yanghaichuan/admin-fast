package com.yueqiangu.project.budget.apply.controller;

import java.util.List;

import com.yueqiangu.common.utils.poi.ExcelUtil;
import com.yueqiangu.framework.aspectj.lang.annotation.Log;
import com.yueqiangu.framework.aspectj.lang.enums.BusinessType;
import com.yueqiangu.framework.web.controller.BaseController;
import com.yueqiangu.framework.web.domain.AjaxResult;
import com.yueqiangu.framework.web.page.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yueqiangu.project.budget.apply.domain.ProjectMoneyApply;
import com.yueqiangu.project.budget.apply.service.IProjectMoneyApplyService;


/**
 * 资金申报Controller
 *
 * @author yueqiangu
 * @date 2021-02-08
 */
@Controller
@RequestMapping("/money/apply")
public class ProjectMoneyApplyController extends BaseController
{
    private String prefix = "budget/apply";

    @Autowired
    private IProjectMoneyApplyService projectMoneyApplyService;

    @RequiresPermissions("money:apply:view")
    @GetMapping()
    public String apply()
    {
        return prefix + "/apply";
    }

    /**
     * 查询资金申报列表
     */
    @RequiresPermissions("money:apply:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectMoneyApply projectMoneyApply)
    {
        startPage();
        List<ProjectMoneyApply> list = projectMoneyApplyService.selectProjectMoneyApplyList(projectMoneyApply);
        return getDataTable(list);
    }

    /**
     * 导出资金申报列表
     */
    @RequiresPermissions("money:apply:export")
    @Log(title = "资金申报", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectMoneyApply projectMoneyApply)
    {
        List<ProjectMoneyApply> list = projectMoneyApplyService.selectProjectMoneyApplyList(projectMoneyApply);
        ExcelUtil<ProjectMoneyApply> util = new ExcelUtil<ProjectMoneyApply>(ProjectMoneyApply.class);
        return util.exportExcel(list, "apply");
    }

    /**
     * 新增资金申报
     */
    @GetMapping("/add/{projectId}")
    public String add(@PathVariable("projectId") Long projectId, ModelMap mmap)
    {
        mmap.put("projectId",projectId);
        return prefix + "/add";
    }

    /**
     * 新增保存资金申报
     */
    @RequiresPermissions("money:apply:add")
    @Log(title = "资金申报", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProjectMoneyApply projectMoneyApply)
    {
        return toAjax(projectMoneyApplyService.insertProjectMoneyApply(projectMoneyApply));
    }

    /**
     * 修改资金申报
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProjectMoneyApply projectMoneyApply = projectMoneyApplyService.selectProjectMoneyApplyById(id);
        mmap.put("projectMoneyApply", projectMoneyApply);
        return prefix + "/edit";
    }

    /**
     * 修改保存资金申报
     */
    @RequiresPermissions("money:apply:edit")
    @Log(title = "资金申报", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProjectMoneyApply projectMoneyApply)
    {
        return toAjax(projectMoneyApplyService.updateProjectMoneyApply(projectMoneyApply));
    }

    /**
     * 删除资金申报
     */
    @RequiresPermissions("money:apply:remove")
    @Log(title = "资金申报", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(projectMoneyApplyService.deleteProjectMoneyApplyByIds(ids));
    }
}
