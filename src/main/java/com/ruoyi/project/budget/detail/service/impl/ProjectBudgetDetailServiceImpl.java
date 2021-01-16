package com.ruoyi.project.budget.detail.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.budget.detail.mapper.ProjectBudgetDetailMapper;
import com.ruoyi.project.budget.detail.domain.ProjectBudgetDetail;
import com.ruoyi.project.budget.detail.service.IProjectBudgetDetailService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 项目明细Service业务层处理
 * 
 * @author yueqiangu
 * @date 2021-01-10
 */
@Service
public class ProjectBudgetDetailServiceImpl implements IProjectBudgetDetailService 
{
    @Autowired
    private ProjectBudgetDetailMapper projectBudgetDetailMapper;

    /**
     * 查询项目明细
     * 
     * @param id 项目明细ID
     * @return 项目明细
     */
    @Override
    public ProjectBudgetDetail selectProjectBudgetDetailById(Long id)
    {
        return projectBudgetDetailMapper.selectProjectBudgetDetailById(id);
    }

    /**
     * 查询项目明细列表
     * 
     * @param projectBudgetDetail 项目明细
     * @return 项目明细
     */
    @Override
    public List<ProjectBudgetDetail> selectProjectBudgetDetailList(ProjectBudgetDetail projectBudgetDetail)
    {
        return projectBudgetDetailMapper.selectProjectBudgetDetailList(projectBudgetDetail);
    }

    /**
     * 新增项目明细
     * 
     * @param projectBudgetDetail 项目明细
     * @return 结果
     */
    @Override
    public int insertProjectBudgetDetail(ProjectBudgetDetail projectBudgetDetail)
    {
        projectBudgetDetail.setCreateTime(DateUtils.getNowDate());
        return projectBudgetDetailMapper.insertProjectBudgetDetail(projectBudgetDetail);
    }

    /**
     * 修改项目明细
     * 
     * @param projectBudgetDetail 项目明细
     * @return 结果
     */
    @Override
    public int updateProjectBudgetDetail(ProjectBudgetDetail projectBudgetDetail)
    {
        projectBudgetDetail.setUpdateTime(DateUtils.getNowDate());
        return projectBudgetDetailMapper.updateProjectBudgetDetail(projectBudgetDetail);
    }

    /**
     * 删除项目明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProjectBudgetDetailByIds(String ids)
    {
        return projectBudgetDetailMapper.deleteProjectBudgetDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目明细信息
     * 
     * @param id 项目明细ID
     * @return 结果
     */
    @Override
    public int deleteProjectBudgetDetailById(Long id)
    {
        return projectBudgetDetailMapper.deleteProjectBudgetDetailById(id);
    }
}
