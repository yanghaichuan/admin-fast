package com.yueqiangu.project.budget.apply.service.impl;

import java.util.List;

import com.yueqiangu.common.utils.DateUtils;
import com.yueqiangu.common.utils.security.ShiroUtils;
import com.yueqiangu.common.utils.text.Convert;
import com.yueqiangu.project.budget.info.domain.ProjectBudgetInfo;
import com.yueqiangu.project.budget.info.service.IProjectBudgetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yueqiangu.project.budget.apply.mapper.ProjectMoneyApplyMapper;
import com.yueqiangu.project.budget.apply.domain.ProjectMoneyApply;
import com.yueqiangu.project.budget.apply.service.IProjectMoneyApplyService;

/**
 * 资金申报Service业务层处理
 *
 * @author yueqiangu
 * @date 2021-02-08
 */
@Service
public class ProjectMoneyApplyServiceImpl implements IProjectMoneyApplyService
{
    @Autowired
    private ProjectMoneyApplyMapper projectMoneyApplyMapper;

    @Autowired
    private IProjectBudgetInfoService projectBudgetInfoService;

    /**
     * 查询资金申报
     *
     * @param id 资金申报ID
     * @return 资金申报
     */
    @Override
    public ProjectMoneyApply selectProjectMoneyApplyById(Long id)
    {
        return projectMoneyApplyMapper.selectProjectMoneyApplyById(id);
    }

    /**
     * 查询资金申报列表
     *
     * @param projectMoneyApply 资金申报
     * @return 资金申报
     */
    @Override
    public List<ProjectMoneyApply> selectProjectMoneyApplyList(ProjectMoneyApply projectMoneyApply)
    {
        return projectMoneyApplyMapper.selectProjectMoneyApplyList(projectMoneyApply);
    }

    /**
     * 新增资金申报
     *
     * @param projectMoneyApply 资金申报
     * @return 结果
     */
    @Override
    public int insertProjectMoneyApply(ProjectMoneyApply projectMoneyApply)
    {
        projectMoneyApply.setCreateTime(DateUtils.getNowDate());
        projectMoneyApply.setCreateBy(ShiroUtils.getLoginName());
        if(projectMoneyApply.getProjectId()!=null){
            ProjectBudgetInfo projectBudgetInfo = projectBudgetInfoService.selectProjectBudgetInfoById(projectMoneyApply.getProjectId());
            if(projectBudgetInfo!=null){
                projectMoneyApply.setProjectName(projectBudgetInfo.getProjectName());
            }
            projectMoneyApply.setStatus("1");
        }
        return projectMoneyApplyMapper.insertProjectMoneyApply(projectMoneyApply);
    }

    /**
     * 修改资金申报
     *
     * @param projectMoneyApply 资金申报
     * @return 结果
     */
    @Override
    public int updateProjectMoneyApply(ProjectMoneyApply projectMoneyApply)
    {
        return projectMoneyApplyMapper.updateProjectMoneyApply(projectMoneyApply);
    }

    /**
     * 删除资金申报对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProjectMoneyApplyByIds(String ids)
    {
        return projectMoneyApplyMapper.deleteProjectMoneyApplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资金申报信息
     *
     * @param id 资金申报ID
     * @return 结果
     */
    @Override
    public int deleteProjectMoneyApplyById(Long id)
    {
        return projectMoneyApplyMapper.deleteProjectMoneyApplyById(id);
    }
}
