package com.ruoyi.project.budget.info.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.budget.info.mapper.ProjectApprovalLogMapper;
import com.ruoyi.project.budget.info.domain.ProjectApprovalLog;
import com.ruoyi.project.budget.info.service.IProjectApprovalLogService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 审批日志Service业务层处理
 *
 * @author yueqiangu
 * @date 2021-01-28
 */
@Service
public class ProjectApprovalLogServiceImpl implements IProjectApprovalLogService
{
    @Autowired
    private ProjectApprovalLogMapper projectApprovalLogMapper;

    /**
     * 查询审批日志
     *
     * @param id 审批日志ID
     * @return 审批日志
     */
    @Override
    public ProjectApprovalLog selectProjectApprovalLogById(Long id)
    {
        return projectApprovalLogMapper.selectProjectApprovalLogById(id);
    }

    /**
     * 查询审批日志列表
     *
     * @param projectApprovalLog 审批日志
     * @return 审批日志
     */
    @Override
    public List<ProjectApprovalLog> selectProjectApprovalLogList(ProjectApprovalLog projectApprovalLog)
    {
        return projectApprovalLogMapper.selectProjectApprovalLogList(projectApprovalLog);
    }

    /**
     * 新增审批日志
     *
     * @param projectApprovalLog 审批日志
     * @return 结果
     */
    @Override
    public int insertProjectApprovalLog(ProjectApprovalLog projectApprovalLog)
    {
        projectApprovalLog.setCreateBy(ShiroUtils.getLoginName());
        projectApprovalLog.setCreateTime(DateUtils.getNowDate());
        return projectApprovalLogMapper.insertProjectApprovalLog(projectApprovalLog);
    }

    /**
     * 修改审批日志
     *
     * @param projectApprovalLog 审批日志
     * @return 结果
     */
    @Override
    public int updateProjectApprovalLog(ProjectApprovalLog projectApprovalLog)
    {
        projectApprovalLog.setUpdateTime(DateUtils.getNowDate());
        return projectApprovalLogMapper.updateProjectApprovalLog(projectApprovalLog);
    }

    /**
     * 删除审批日志对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProjectApprovalLogByIds(String ids)
    {
        return projectApprovalLogMapper.deleteProjectApprovalLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除审批日志信息
     *
     * @param id 审批日志ID
     * @return 结果
     */
    @Override
    public int deleteProjectApprovalLogById(Long id)
    {
        return projectApprovalLogMapper.deleteProjectApprovalLogById(id);
    }
}
