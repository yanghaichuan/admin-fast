package com.yueqiangu.project.system.attachment.controller;

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
import com.yueqiangu.project.system.attachment.domain.ProjectAttachment;
import com.yueqiangu.project.system.attachment.service.IProjectAttachmentService;
import com.yueqiangu.framework.web.controller.BaseController;
import com.yueqiangu.framework.web.domain.AjaxResult;
import com.yueqiangu.common.utils.poi.ExcelUtil;
import com.yueqiangu.framework.web.page.TableDataInfo;

/**
 * 文件管理Controller
 *
 * @author yueqiangu
 * @date 2021-01-23
 */
@Controller
@RequestMapping("/project/attachment")
public class ProjectAttachmentController extends BaseController
{
    private String prefix = "project/attachment";

    @Autowired
    private IProjectAttachmentService projectAttachmentService;

    @RequiresPermissions("project:attachment:view")
    @GetMapping()
    public String attachment()
    {
        return prefix + "/attachment";
    }

    /**
     * 查询文件管理列表
     */
    @RequiresPermissions("project:attachment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProjectAttachment projectAttachment)
    {
        startPage();
        List<ProjectAttachment> list = projectAttachmentService.selectProjectAttachmentList(projectAttachment);
        return getDataTable(list);
    }

    /**
     * 导出文件管理列表
     */
    @RequiresPermissions("project:attachment:export")
    @Log(title = "文件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProjectAttachment projectAttachment)
    {
        List<ProjectAttachment> list = projectAttachmentService.selectProjectAttachmentList(projectAttachment);
        ExcelUtil<ProjectAttachment> util = new ExcelUtil<ProjectAttachment>(ProjectAttachment.class);
        return util.exportExcel(list, "attachment");
    }

    /**
     * 新增文件管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文件管理
     */
    @RequiresPermissions("project:attachment:add")
    @Log(title = "文件管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ProjectAttachment projectAttachment)
    {
        return toAjax(projectAttachmentService.insertProjectAttachment(projectAttachment));
    }

    /**
     * 修改文件管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ProjectAttachment projectAttachment = projectAttachmentService.selectProjectAttachmentById(id);
        mmap.put("projectAttachment", projectAttachment);
        return prefix + "/edit";
    }

    /**
     * 修改保存文件管理
     */
    @RequiresPermissions("project:attachment:edit")
    @Log(title = "文件管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProjectAttachment projectAttachment)
    {
        return toAjax(projectAttachmentService.updateProjectAttachment(projectAttachment));
    }

    /**
     * 删除文件管理
     */
    @RequiresPermissions("project:attachment:remove")
    @Log(title = "文件管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(projectAttachmentService.deleteProjectAttachmentByIds(ids));
    }
}
