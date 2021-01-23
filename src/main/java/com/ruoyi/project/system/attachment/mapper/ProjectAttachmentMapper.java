package com.ruoyi.project.system.attachment.mapper;

import java.util.List;
import com.ruoyi.project.system.attachment.domain.ProjectAttachment;
import org.apache.ibatis.annotations.Param;

/**
 * 文件管理Mapper接口
 *
 * @author yueqiangu
 * @date 2021-01-23
 */
public interface ProjectAttachmentMapper
{
    /**
     * 查询文件管理
     *
     * @param id 文件管理ID
     * @return 文件管理
     */
    public ProjectAttachment selectProjectAttachmentById(Long id);

    /**
     * 查询文件管理列表
     *
     * @param projectAttachment 文件管理
     * @return 文件管理集合
     */
    public List<ProjectAttachment> selectProjectAttachmentList(ProjectAttachment projectAttachment);

    /**
     * 新增文件管理
     *
     * @param projectAttachment 文件管理
     * @return 结果
     */
    public int insertProjectAttachment(ProjectAttachment projectAttachment);

    /**
     * 修改文件管理
     *
     * @param projectAttachment 文件管理
     * @return 结果
     */
    public int updateProjectAttachment(ProjectAttachment projectAttachment);

    /**
     * 删除文件管理
     *
     * @param id 文件管理ID
     * @return 结果
     */
    public int deleteProjectAttachmentById(Long id);

    /**
     * 批量删除文件管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectAttachmentByIds(String[] ids);

    /**
     * 删除
     * @param projectId
     * @return
     */
    public int deleteByProjectId(@Param("projectId") Long projectId);
}
