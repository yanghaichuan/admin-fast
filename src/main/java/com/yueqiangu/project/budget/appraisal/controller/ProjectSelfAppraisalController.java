package com.yueqiangu.project.budget.appraisal.controller;

import java.util.List;

import com.yueqiangu.project.budget.info.domain.ProjectBudgetInfo;
import com.yueqiangu.project.budget.info.service.IProjectBudgetInfoService;
import com.yueqiangu.project.budget.target.domain.ProjectKpiTarget;
import com.yueqiangu.project.budget.target.service.IProjectKpiTargetService;
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
import com.yueqiangu.project.budget.appraisal.domain.ProjectSelfAppraisal;
import com.yueqiangu.project.budget.appraisal.service.IProjectSelfAppraisalService;
import com.yueqiangu.framework.web.controller.BaseController;
import com.yueqiangu.framework.web.domain.AjaxResult;
import com.yueqiangu.common.utils.poi.ExcelUtil;
import com.yueqiangu.framework.web.page.TableDataInfo;

/**
 * 绩效自评Controller
 *
 * @author yueqiangu
 * @date 2021-04-02
 */
@Controller
@RequestMapping("/budget/appraisal")
public class ProjectSelfAppraisalController extends BaseController
{
    private String prefix = "budget/appraisal";

    @Autowired
    private IProjectSelfAppraisalService projectSelfAppraisalService;

    @Autowired
    private IProjectBudgetInfoService projectBudgetInfoService;


    @Autowired
    private IProjectKpiTargetService projectKpiTargetService;

    @RequiresPermissions("budget:appraisal:view")
    @GetMapping()
    public String appraisal()
    {
        return prefix + "/appraisal";
    }

    @RequiresPermissions("budget:appraisal:viewpj")
    @GetMapping("/pj")
    public String appraisalpj()
    {
        return prefix + "/appraisalpj";
    }

    /**
     * 查询绩效自评列表
     */
    @RequiresPermissions("budget:appraisal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectSelfAppraisal projectSelfAppraisal)
    {
        startPage();
        List<ProjectSelfAppraisal> list = projectSelfAppraisalService.selectProjectSelfAppraisalList(projectSelfAppraisal);
        return getDataTable(list);
    }

    /**
     * 导出绩效自评列表
     */
    @RequiresPermissions("budget:appraisal:export")
    @Log(title = "绩效自评", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectSelfAppraisal projectSelfAppraisal)
    {
        List<ProjectSelfAppraisal> list = projectSelfAppraisalService.selectProjectSelfAppraisalList(projectSelfAppraisal);
        ExcelUtil<ProjectSelfAppraisal> util = new ExcelUtil<ProjectSelfAppraisal>(ProjectSelfAppraisal.class);
        return util.exportExcel(list, "appraisal");
    }

    /**
     * 新增绩效自评
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        ProjectBudgetInfo projectBudgetInfo = new ProjectBudgetInfo();
        projectBudgetInfo.setDelFlag("0");
        projectBudgetInfo.setStatus("6");
        projectBudgetInfo.setSelf("0");
        List<ProjectBudgetInfo> projects =  projectBudgetInfoService.selectProjectBudgetInfoList(projectBudgetInfo);
        for(ProjectBudgetInfo projectBudgetInfo1:projects){
            ProjectKpiTarget projectKpiTarget = new ProjectKpiTarget();
            projectKpiTarget.setProjectId(projectBudgetInfo1.getId());
            List<ProjectKpiTarget> projectKpiTargetList = projectKpiTargetService.selectProjectKpiTargetList(projectKpiTarget);
            projectBudgetInfo1.setProjectKpiTargetList(projectKpiTargetList);
        }
        mmap.put("projects",projects);
        return prefix + "/add";
    }

    /**
     * 新增保存绩效自评
     */
    @RequiresPermissions("budget:appraisal:add")
    @Log(title = "绩效自评", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProjectSelfAppraisal projectSelfAppraisal)
    {
        return toAjax(projectSelfAppraisalService.insertProjectSelfAppraisal(projectSelfAppraisal));
    }

    /**
     * 修改绩效自评
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        ProjectSelfAppraisal projectSelfAppraisal = projectSelfAppraisalService.selectProjectSelfAppraisalById(id);
        mmap.put("projectSelfAppraisal", projectSelfAppraisal);
        ProjectBudgetInfo projectBudgetInfo = new ProjectBudgetInfo();
        projectBudgetInfo.setDelFlag("0");
        projectBudgetInfo.setStatus("6");
        List<ProjectBudgetInfo> projects = projectBudgetInfoService.selectProjectBudgetInfoList(projectBudgetInfo);
        for (ProjectBudgetInfo projectBudgetInfo1 : projects) {
            ProjectKpiTarget projectKpiTarget = new ProjectKpiTarget();
            projectKpiTarget.setProjectId(projectBudgetInfo1.getId());
            List<ProjectKpiTarget> projectKpiTargetList = projectKpiTargetService.selectProjectKpiTargetList(projectKpiTarget);
            projectBudgetInfo1.setProjectKpiTargetList(projectKpiTargetList);
        }
        mmap.put("projects", projects);
        return prefix + "/edit";
    }

    /**
     * 修改绩效自评
     */
    @GetMapping("/evaluate/{id}")
    public String evaluate(@PathVariable("id") Long id, ModelMap mmap) {
        ProjectSelfAppraisal projectSelfAppraisal = projectSelfAppraisalService.selectProjectSelfAppraisalById(id);
        mmap.put("projectSelfAppraisal", projectSelfAppraisal);
        ProjectBudgetInfo projectBudgetInfo = new ProjectBudgetInfo();
        projectBudgetInfo.setDelFlag("0");
        projectBudgetInfo.setStatus("6");
        List<ProjectBudgetInfo> projects = projectBudgetInfoService.selectProjectBudgetInfoList(projectBudgetInfo);
        for (ProjectBudgetInfo projectBudgetInfo1 : projects) {
            ProjectKpiTarget projectKpiTarget = new ProjectKpiTarget();
            projectKpiTarget.setProjectId(projectBudgetInfo1.getId());
            List<ProjectKpiTarget> projectKpiTargetList = projectKpiTargetService.selectProjectKpiTargetList(projectKpiTarget);
            projectBudgetInfo1.setProjectKpiTargetList(projectKpiTargetList);
        }
        mmap.put("projects", projects);
        return prefix + "/evaluate";
    }

    /**
     * 修改保存绩效自评
     */
    @RequiresPermissions("budget:appraisal:edit")
    @Log(title = "绩效自评", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProjectSelfAppraisal projectSelfAppraisal)
    {
        return toAjax(projectSelfAppraisalService.updateProjectSelfAppraisal(projectSelfAppraisal));
    }

    /**
     * 修改保存绩效自评
     */
    @RequiresPermissions("budget:appraisal:evaluate")
    @Log(title = "绩效评价", businessType = BusinessType.UPDATE)
    @PostMapping("/evaluate")
    @ResponseBody
    public AjaxResult evaluate(ProjectSelfAppraisal projectSelfAppraisal)
    {
        return toAjax(projectSelfAppraisalService.updateProjectSelfAppraisal(projectSelfAppraisal));
    }

    /**
     * 删除绩效自评
     */
    @RequiresPermissions("budget:appraisal:remove")
    @Log(title = "绩效自评", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(projectSelfAppraisalService.deleteProjectSelfAppraisalByIds(ids));
    }
}
