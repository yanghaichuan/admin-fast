package com.ruoyi.project.budget.info.service;

import java.util.List;
import com.ruoyi.project.budget.info.domain.ProjectBudgetInfo;

/**
 * 项目管理Service接口
 *
 * @author yueqiangu
 * @date 2021-01-10
 */
public interface IProjectBudgetInfoService
{
    /**
     * 查询项目管理
     *
     * @param id 项目管理ID
     * @return 项目管理
     */
    public ProjectBudgetInfo selectProjectBudgetInfoById(Long id);

    /**
     * 查询项目管理列表
     *
     * @param projectBudgetInfo 项目管理
     * @return 项目管理集合
     */
    public List<ProjectBudgetInfo> selectProjectBudgetInfoList(ProjectBudgetInfo projectBudgetInfo);

    /**
     * 新增项目管理
     *
     * @param projectBudgetInfo 项目管理
     * @return 结果
     */
    public int insertProjectBudgetInfo(ProjectBudgetInfo projectBudgetInfo);

    /**
     * 修改项目管理
     *
     * @param projectBudgetInfo 项目管理
     * @return 结果
     */
    public int updateProjectBudgetInfo(ProjectBudgetInfo projectBudgetInfo);

    /**
     * 项目提交
     * @param projectBudgetInfo
     * @return
     */
    public int submit(ProjectBudgetInfo projectBudgetInfo);
    /**
     * 批量删除项目管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectBudgetInfoByIds(String ids);

    /**
     * 删除项目管理信息
     *
     * @param id 项目管理ID
     * @return 结果
     */
    public int deleteProjectBudgetInfoById(Long id);
}
