package com.ruoyi.project.budget.target.controller;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.enums.SysDelFlag;
import com.ruoyi.common.utils.TreeBeanUtils;
import com.ruoyi.common.utils.TreeUtils;
import com.ruoyi.framework.web.domain.CxSelect;
import com.ruoyi.framework.web.domain.Ztree;
import com.ruoyi.project.budget.mould.domain.ProjectKpiMould;
import com.ruoyi.project.budget.mould.service.IProjectKpiMouldService;
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
import com.ruoyi.project.budget.target.domain.ProjectKpiTarget;
import com.ruoyi.project.budget.target.service.IProjectKpiTargetService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

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
    public String target()
    {
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
    public String add(ModelMap mmap)
    {
        ProjectKpiMould projectKpiMould = new ProjectKpiMould();
        projectKpiMould.setDelFlag(SysDelFlag.NORMAL.getCode());
        List<ProjectKpiMould> projectKpiMouldList = projectKpiMouldService.selectProjectKpiMouldList(projectKpiMould);
        try {
            List<ProjectKpiMould> tree = TreeBeanUtils.getTree(projectKpiMouldList, "id");
            mmap.put("data", JSON.toJSON(tree));
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
