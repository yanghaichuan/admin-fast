package com.ruoyi.project.budget.info.mapper;

import java.util.List;

import com.ruoyi.project.budget.detail.domain.ProjectBudgetDetail;
import com.ruoyi.project.budget.info.domain.ProjectBudgetInfo;

/**
 * 项目管理Mapper接口
 *
 * @author yueqiangu
 * @date 2021-01-10
 */
public interface ProjectBudgetInfoMapper
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
     * 删除项目管理
     *
     * @param id 项目管理ID
     * @return 结果
     */
    public int deleteProjectBudgetInfoById(Long id);

    /**
     * 批量删除项目管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectBudgetInfoByIds(String[] ids);

    /**
     * 批量删除项目明细
     *
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectBudgetDetailByProjectCodes(String[] ids);

    /**
     * 批量新增项目明细
     *
     * @param projectBudgetDetailList 项目明细列表
     * @return 结果
     */
    public int batchProjectBudgetDetail(List<ProjectBudgetDetail> projectBudgetDetailList);


    /**
     * 通过项目管理ID删除项目明细信息
     *
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteProjectBudgetDetailByProjectCode(String id);
}
