package com.yueqiangu.project.budget.mould.controller;

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
import com.yueqiangu.framework.aspectj.lang.annotation.Log;
import com.yueqiangu.framework.aspectj.lang.enums.BusinessType;
import com.yueqiangu.project.budget.mould.domain.ProjectKpiMould;
import com.yueqiangu.project.budget.mould.service.IProjectKpiMouldService;
import com.yueqiangu.framework.web.controller.BaseController;
import com.yueqiangu.framework.web.domain.AjaxResult;
import com.yueqiangu.common.utils.poi.ExcelUtil;
import com.yueqiangu.common.utils.StringUtils;
import com.yueqiangu.framework.web.domain.Ztree;

/**
 * 项目绩效目标Controller
 *
 * @author yueqiangu
 * @date 2021-01-24
 */
@Controller
@RequestMapping("/kpi/mould")
public class ProjectKpiMouldController extends BaseController
{
    private String prefix = "kpi/mould";

    @Autowired
    private IProjectKpiMouldService projectKpiMouldService;

    @RequiresPermissions("kpi:mould:view")
    @GetMapping()
    public String mould()
    {
        return prefix + "/mould";
    }

    /**
     * 查询项目绩效目标树列表
     */
    @RequiresPermissions("kpi:mould:list")
    @PostMapping("/list")
    @ResponseBody
    public List<ProjectKpiMould> list(ProjectKpiMould projectKpiMould)
    {
        List<ProjectKpiMould> list = projectKpiMouldService.selectProjectKpiMouldList(projectKpiMould);
        return list;
    }

    /**
     * 导出项目绩效目标列表
     */
    @RequiresPermissions("kpi:mould:export")
    @Log(title = "项目绩效目标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectKpiMould projectKpiMould)
    {
        List<ProjectKpiMould> list = projectKpiMouldService.selectProjectKpiMouldList(projectKpiMould);
        ExcelUtil<ProjectKpiMould> util = new ExcelUtil<ProjectKpiMould>(ProjectKpiMould.class);
        return util.exportExcel(list, "mould");
    }

    /**
     * 新增项目绩效目标
     */
    @GetMapping(value = { "/add/{id}", "/add/" })
    public String add(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("projectKpiMould", projectKpiMouldService.selectProjectKpiMouldById(id));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存项目绩效目标
     */
    @RequiresPermissions("kpi:mould:add")
    @Log(title = "项目绩效目标", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProjectKpiMould projectKpiMould)
    {
        return toAjax(projectKpiMouldService.insertProjectKpiMould(projectKpiMould));
    }

    /**
     * 修改项目绩效目标
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProjectKpiMould projectKpiMould = projectKpiMouldService.selectProjectKpiMouldById(id);
        mmap.put("projectKpiMould", projectKpiMould);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目绩效目标
     */
    @RequiresPermissions("kpi:mould:edit")
    @Log(title = "项目绩效目标", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProjectKpiMould projectKpiMould)
    {
        return toAjax(projectKpiMouldService.updateProjectKpiMould(projectKpiMould));
    }

    /**
     * 删除
     */
    @RequiresPermissions("kpi:mould:remove")
    @Log(title = "项目绩效目标", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id)
    {
        return toAjax(projectKpiMouldService.deleteProjectKpiMouldById(id));
    }

    /**
     * 选择项目绩效目标树
     */
    @GetMapping(value = { "/selectMouldTree/{id}", "/selectMouldTree/" })
    public String selectMouldTree(@PathVariable(value = "id", required = false) Long id, ModelMap mmap)
    {
        if (StringUtils.isNotNull(id))
        {
            mmap.put("projectKpiMould", projectKpiMouldService.selectProjectKpiMouldById(id));
        }
        return prefix + "/tree";
    }

    /**
     * 加载项目绩效目标树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = projectKpiMouldService.selectProjectKpiMouldTree();
        return ztrees;
    }
}
