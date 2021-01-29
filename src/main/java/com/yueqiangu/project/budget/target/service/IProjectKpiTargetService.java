package com.yueqiangu.project.budget.target.service;

import java.util.List;
import com.yueqiangu.project.budget.target.domain.ProjectKpiTarget;

/**
 * 项目绩效模板Service接口
 *
 * @author yueqiangu
 * @date 2021-01-25
 */
public interface IProjectKpiTargetService
{
    /**
     * 查询项目绩效模板
     *
     * @param id 项目绩效模板ID
     * @return 项目绩效模板
     */
    public ProjectKpiTarget selectProjectKpiTargetById(Long id);

    /**
     * 查询项目绩效模板列表
     *
     * @param projectKpiTarget 项目绩效模板
     * @return 项目绩效模板集合
     */
    public List<ProjectKpiTarget> selectProjectKpiTargetList(ProjectKpiTarget projectKpiTarget);

    /**
     * 新增项目绩效模板
     *
     * @param projectKpiTarget 项目绩效模板
     * @return 结果
     */
    public int insertProjectKpiTarget(ProjectKpiTarget projectKpiTarget);

    /**
     * 修改项目绩效模板
     *
     * @param projectKpiTarget 项目绩效模板
     * @return 结果
     */
    public int updateProjectKpiTarget(ProjectKpiTarget projectKpiTarget);

    /**
     * 批量删除项目绩效模板
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectKpiTargetByIds(String ids);

    /**
     * 删除项目绩效模板信息
     *
     * @param id 项目绩效模板ID
     * @return 结果
     */
    public int deleteProjectKpiTargetById(Long id);
}
