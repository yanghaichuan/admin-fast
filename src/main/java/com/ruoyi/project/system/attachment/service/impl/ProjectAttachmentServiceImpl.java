package com.ruoyi.project.system.attachment.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.attachment.mapper.ProjectAttachmentMapper;
import com.ruoyi.project.system.attachment.domain.ProjectAttachment;
import com.ruoyi.project.system.attachment.service.IProjectAttachmentService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 文件管理Service业务层处理
 *
 * @author yueqiangu
 * @date 2021-01-23
 */
@Service
public class ProjectAttachmentServiceImpl implements IProjectAttachmentService
{
    @Autowired
    private ProjectAttachmentMapper projectAttachmentMapper;

    /**
     * 查询文件管理
     *
     * @param id 文件管理ID
     * @return 文件管理
     */
    @Override
    public ProjectAttachment selectProjectAttachmentById(Long id)
    {
        return projectAttachmentMapper.selectProjectAttachmentById(id);
    }

    /**
     * 查询文件管理列表
     *
     * @param projectAttachment 文件管理
     * @return 文件管理
     */
    @Override
    public List<ProjectAttachment> selectProjectAttachmentList(ProjectAttachment projectAttachment)
    {
        return projectAttachmentMapper.selectProjectAttachmentList(projectAttachment);
    }

    /**
     * 新增文件管理
     *
     * @param projectAttachment 文件管理
     * @return 结果
     */
    @Override
    public int insertProjectAttachment(ProjectAttachment projectAttachment)
    {
        projectAttachment.setCreateTime(DateUtils.getNowDate());
        return projectAttachmentMapper.insertProjectAttachment(projectAttachment);
    }

    /**
     * 修改文件管理
     *
     * @param projectAttachment 文件管理
     * @return 结果
     */
    @Override
    public int updateProjectAttachment(ProjectAttachment projectAttachment)
    {
        projectAttachment.setUpdateTime(DateUtils.getNowDate());
        return projectAttachmentMapper.updateProjectAttachment(projectAttachment);
    }

    /**
     * 删除文件管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProjectAttachmentByIds(String ids)
    {
        return projectAttachmentMapper.deleteProjectAttachmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文件管理信息
     *
     * @param id 文件管理ID
     * @return 结果
     */
    @Override
    public int deleteProjectAttachmentById(Long id)
    {
        return projectAttachmentMapper.deleteProjectAttachmentById(id);
    }

    @Override
    public int deleteByProjectId(Long projectId) {
        return projectAttachmentMapper.deleteByProjectId(projectId);
    }
}
