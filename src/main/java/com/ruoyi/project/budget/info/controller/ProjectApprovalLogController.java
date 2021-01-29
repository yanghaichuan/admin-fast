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
import com.ruoyi.project.budget.info.domain.ProjectApprovalLog;
import com.ruoyi.project.budget.info.service.IProjectApprovalLogService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 审批日志Controller
 *
 * @author yueqiangu
 * @date 2021-01-28
 */
@Controller
@RequestMapping("/info/log")
public class ProjectApprovalLogController extends BaseController
{
    private String prefix = "info/log";

    @Autowired
    private IProjectApprovalLogService projectApprovalLogService;

    @RequiresPermissions("info:log:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/log";
    }

    /**
     * 查询审批日志列表
     */
    @RequiresPermissions("info:log:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectApprovalLog projectApprovalLog)
    {
        startPage();
        List<ProjectApprovalLog> list = projectApprovalLogService.selectProjectApprovalLogList(projectApprovalLog);
        return getDataTable(list);
    }

    /**
     * 导出审批日志列表
     */
    @RequiresPermissions("info:log:export")
    @Log(title = "审批日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectApprovalLog projectApprovalLog)
    {
        List<ProjectApprovalLog> list = projectApprovalLogService.selectProjectApprovalLogList(projectApprovalLog);
        ExcelUtil<ProjectApprovalLog> util = new ExcelUtil<ProjectApprovalLog>(ProjectApprovalLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 新增审批日志
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存审批日志
     */
    @RequiresPermissions("info:log:add")
    @Log(title = "审批日志", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProjectApprovalLog projectApprovalLog)
    {
        return toAjax(projectApprovalLogService.insertProjectApprovalLog(projectApprovalLog));
    }

    /**
     * 修改审批日志
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProjectApprovalLog projectApprovalLog = projectApprovalLogService.selectProjectApprovalLogById(id);
        mmap.put("projectApprovalLog", projectApprovalLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存审批日志
     */
    @RequiresPermissions("info:log:edit")
    @Log(title = "审批日志", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProjectApprovalLog projectApprovalLog)
    {
        return toAjax(projectApprovalLogService.updateProjectApprovalLog(projectApprovalLog));
    }

    /**
     * 删除审批日志
     */
    @RequiresPermissions("info:log:remove")
    @Log(title = "审批日志", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(projectApprovalLogService.deleteProjectApprovalLogByIds(ids));
    }
}
