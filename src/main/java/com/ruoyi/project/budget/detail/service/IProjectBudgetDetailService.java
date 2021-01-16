package com.ruoyi.project.budget.detail.service;

import java.util.List;
import com.ruoyi.project.budget.detail.domain.ProjectBudgetDetail;

/**
 * 项目明细Service接口
 * 
 * @author yueqiangu
 * @date 2021-01-10
 */
public interface IProjectBudgetDetailService 
{
    /**
     * 查询项目明细
     * 
     * @param id 项目明细ID
     * @return 项目明细
     */
    public ProjectBudgetDetail selectProjectBudgetDetailById(Long id);

    /**
     * 查询项目明细列表
     * 
     * @param projectBudgetDetail 项目明细
     * @return 项目明细集合
     */
    public List<ProjectBudgetDetail> selectProjectBudgetDetailList(ProjectBudgetDetail projectBudgetDetail);

    /**
     * 新增项目明细
     * 
     * @param projectBudgetDetail 项目明细
     * @return 结果
     */
    public int insertProjectBudgetDetail(ProjectBudgetDetail projectBudgetDetail);

    /**
     * 修改项目明细
     * 
     * @param projectBudgetDetail 项目明细
     * @return 结果
     */
    public int updateProjectBudgetDetail(ProjectBudgetDetail projectBudgetDetail);

    /**
     * 批量删除项目明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectBudgetDetailByIds(String ids);

    /**
     * 删除项目明细信息
     * 
     * @param id 项目明细ID
     * @return 结果
     */
    public int deleteProjectBudgetDetailById(Long id);
}
