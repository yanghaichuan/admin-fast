package com.yueqiangu.project.budget.info.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.yueqiangu.common.utils.DateUtils;
import com.yueqiangu.project.budget.apply.domain.ProjectMoneyApply;
import com.yueqiangu.project.budget.apply.service.IProjectMoneyApplyService;
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
import com.yueqiangu.project.budget.info.domain.ProjectBudgetInfo;
import com.yueqiangu.project.budget.info.service.IProjectBudgetInfoService;
import com.yueqiangu.framework.web.controller.BaseController;
import com.yueqiangu.framework.web.domain.AjaxResult;
import com.yueqiangu.common.utils.poi.ExcelUtil;
import com.yueqiangu.framework.web.page.TableDataInfo;

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


    @Autowired
    private IProjectMoneyApplyService projectMoneyApplyService;


    @RequiresPermissions("budget:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    @RequiresPermissions("budget:info:view")
    @GetMapping("/examList")
    public String examList()
    {
        return prefix + "/examList";
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
     * 项目预览
     */
    @GetMapping("/preview/{id}")
    public String preview(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProjectBudgetInfo projectBudgetInfo = projectBudgetInfoService.selectProjectBudgetInfoById(id);
        mmap.put("projectBudgetInfo", projectBudgetInfo);
        return prefix + "/preview";
    }

    /**
     * 项目预览
     */
    @GetMapping("/chart/{id}")
    public String chart(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProjectBudgetInfo projectBudgetInfo = projectBudgetInfoService.selectProjectBudgetInfoById(id);
        mmap.put("projectBudgetInfo", projectBudgetInfo);
        ProjectMoneyApply projectMoneyApply = new ProjectMoneyApply();
        projectMoneyApply.setProjectId(id);
        List<ProjectMoneyApply> projectMoneyApplyList =  projectMoneyApplyService.selectProjectMoneyApplyList(projectMoneyApply);
        List<Double> cashList = new ArrayList<>();
        List<String> dateList = new ArrayList<>();
        for(ProjectMoneyApply projectMoneyApply1 :projectMoneyApplyList){
            double d1 = 0;
            try {
                d1 = new DecimalFormat().parse(projectMoneyApply1.getMoney()).doubleValue();
                cashList.add(d1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dateList.add(DateUtils.parseDateToStr("yyyy-MM-dd",projectMoneyApply1.getCreateTime()));
        }
        mmap.put("cashList",cashList);
        mmap.put("dateList",dateList);
        return prefix + "/chart";
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
    @RequiresPermissions("budget:info:submit")
    @Log(title = "项目管理", businessType = BusinessType.UPDATE)
    @PostMapping("/submit")
    @ResponseBody
    public AjaxResult submit(ProjectBudgetInfo projectBudgetInfo)
    {
        return toAjax(projectBudgetInfoService.submit(projectBudgetInfo));
    }


    /**
     * 审核
     */
    @GetMapping("/examine/{id}")
    public String examine(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProjectBudgetInfo projectBudgetInfo = projectBudgetInfoService.selectProjectBudgetInfoById(id);
        mmap.put("projectBudgetInfo", projectBudgetInfo);
        return prefix + "/examine";
    }
}
