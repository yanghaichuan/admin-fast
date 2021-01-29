package com.yueqiangu.project.budget.target.controller;

import java.util.List;


import com.alibaba.fastjson.JSON;
import com.yueqiangu.common.enums.SysDelFlag;
import com.yueqiangu.common.utils.TreeBeanUtils;
import com.yueqiangu.project.budget.mould.domain.ProjectKpiMould;
import com.yueqiangu.project.budget.mould.service.IProjectKpiMouldService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.yueqiangu.framework.aspectj.lang.annotation.Log;
import com.yueqiangu.framework.aspectj.lang.enums.BusinessType;
import com.yueqiangu.project.budget.target.domain.ProjectKpiTarget;
import com.yueqiangu.project.budget.target.service.IProjectKpiTargetService;
import com.yueqiangu.framework.web.controller.BaseController;
import com.yueqiangu.framework.web.domain.AjaxResult;
import com.yueqiangu.common.utils.poi.ExcelUtil;
import com.yueqiangu.framework.web.page.TableDataInfo;

/**
 * 项目绩效模板Controller
 *
 * @author yueqiangu
 * @date 2021-01-25
 */
@Controller
@RequestMapping("/budget/target")
public class ProjectKpiTargetController extends BaseController
{
    private String prefix = "budget/target";

    @Autowired
    private IProjectKpiTargetService projectKpiTargetService;

    @Autowired
    private IProjectKpiMouldService projectKpiMouldService;

    @RequiresPermissions("budget:target:view")
    @GetMapping()
    public String target(@RequestParam(value = "projectId",defaultValue = "")  Long projectId,
                         @RequestParam(value = "projectName",defaultValue = "") String projectName, ModelMap mmap)
    {
        mmap.put("projectId",projectId);
        mmap.put("projectName",projectName);
        return prefix + "/target";
    }

    /**
     * 查询项目绩效模板列表
     */
    @RequiresPermissions("budget:target:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectKpiTarget projectKpiTarget)
    {
        startPage();
        List<ProjectKpiTarget> list = projectKpiTargetService.selectProjectKpiTargetList(projectKpiTarget);
        return getDataTable(list);
    }

    /**
     * 导出项目绩效模板列表
     */
    @RequiresPermissions("budget:target:export")
    @Log(title = "项目绩效模板", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectKpiTarget projectKpiTarget)
    {
        List<ProjectKpiTarget> list = projectKpiTargetService.selectProjectKpiTargetList(projectKpiTarget);
        ExcelUtil<ProjectKpiTarget> util = new ExcelUtil<ProjectKpiTarget>(ProjectKpiTarget.class);
        return util.exportExcel(list, "target");
    }

    /**
     * 新增项目绩效模板
     */
    @GetMapping("/add")
    public String add(@RequestParam(value = "projectId",defaultValue = "")  Long projectId,
                      @RequestParam(value = "projectName",defaultValue = "") String projectName,ModelMap mmap)
    {
        ProjectKpiMould projectKpiMould = new ProjectKpiMould();
        projectKpiMould.setDelFlag(SysDelFlag.NORMAL.getCode());
        List<ProjectKpiMould> projectKpiMouldList = projectKpiMouldService.selectProjectKpiMouldList(projectKpiMould);
        try {
            List<ProjectKpiMould> tree = TreeBeanUtils.getTree(projectKpiMouldList, "id");
            mmap.put("data", JSON.toJSON(tree));
            mmap.put("projectId",projectId);
            mmap.put("projectName",projectName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prefix + "/add";
    }

    /**
     * 新增保存项目绩效模板
     */
    @RequiresPermissions("budget:target:add")
    @Log(title = "项目绩效模板", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProjectKpiTarget projectKpiTarget)
    {
        return toAjax(projectKpiTargetService.insertProjectKpiTarget(projectKpiTarget));
    }

    /**
     * 修改项目绩效模板
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProjectKpiTarget projectKpiTarget = projectKpiTargetService.selectProjectKpiTargetById(id);
        mmap.put("projectKpiTarget", projectKpiTarget);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目绩效模板
     */
    @RequiresPermissions("budget:target:edit")
    @Log(title = "项目绩效模板", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProjectKpiTarget projectKpiTarget)
    {
        return toAjax(projectKpiTargetService.updateProjectKpiTarget(projectKpiTarget));
    }

    /**
     * 删除项目绩效模板
     */
    @RequiresPermissions("budget:target:remove")
    @Log(title = "项目绩效模板", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(projectKpiTargetService.deleteProjectKpiTargetByIds(ids));
    }
}
