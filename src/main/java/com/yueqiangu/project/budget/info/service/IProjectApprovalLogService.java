package com.yueqiangu.project.budget.info.service;

import java.util.List;
import com.yueqiangu.project.budget.info.domain.ProjectApprovalLog;

/**
 * 审批日志Service接口
 *
 * @author yueqiangu
 * @date 2021-01-28
 */
public interface IProjectApprovalLogService
{
    /**
     * 查询审批日志
     *
     * @param id 审批日志ID
     * @return 审批日志
     */
    public ProjectApprovalLog selectProjectApprovalLogById(Long id);

    /**
     * 查询审批日志列表
     *
     * @param projectApprovalLog 审批日志
     * @return 审批日志集合
     */
    public List<ProjectApprovalLog> selectProjectApprovalLogList(ProjectApprovalLog projectApprovalLog);

    /**
     * 新增审批日志
     *
     * @param projectApprovalLog 审批日志
     * @return 结果
     */
    public int insertProjectApprovalLog(ProjectApprovalLog projectApprovalLog);

    /**
     * 修改审批日志
     *
     * @param projectApprovalLog 审批日志
     * @return 结果
     */
    public int updateProjectApprovalLog(ProjectApprovalLog projectApprovalLog);

    /**
     * 批量删除审批日志
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectApprovalLogByIds(String ids);

    /**
     * 删除审批日志信息
     *
     * @param id 审批日志ID
     * @return 结果
     */
    public int deleteProjectApprovalLogById(Long id);
}
