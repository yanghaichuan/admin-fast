package com.yueqiangu.project.budget.mould.service;

import java.util.List;
import com.yueqiangu.project.budget.mould.domain.ProjectKpiMould;
import com.yueqiangu.framework.web.domain.Ztree;

/**
 * 项目绩效目标Service接口
 *
 * @author yueqiangu
 * @date 2021-01-24
 */
public interface IProjectKpiMouldService
{
    /**
     * 查询项目绩效目标
     *
     * @param id 项目绩效目标ID
     * @return 项目绩效目标
     */
    public ProjectKpiMould selectProjectKpiMouldById(Long id);

    /**
     * 查询项目绩效目标列表
     *
     * @param projectKpiMould 项目绩效目标
     * @return 项目绩效目标集合
     */
    public List<ProjectKpiMould> selectProjectKpiMouldList(ProjectKpiMould projectKpiMould);

    /**
     * 新增项目绩效目标
     *
     * @param projectKpiMould 项目绩效目标
     * @return 结果
     */
    public int insertProjectKpiMould(ProjectKpiMould projectKpiMould);

    /**
     * 修改项目绩效目标
     *
     * @param projectKpiMould 项目绩效目标
     * @return 结果
     */
    public int updateProjectKpiMould(ProjectKpiMould projectKpiMould);

    /**
     * 批量删除项目绩效目标
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectKpiMouldByIds(String ids);

    /**
     * 删除项目绩效目标信息
     *
     * @param id 项目绩效目标ID
     * @return 结果
     */
    public int deleteProjectKpiMouldById(Long id);

    /**
     * 查询项目绩效目标树列表
     *
     * @return 所有项目绩效目标信息
     */
    public List<Ztree> selectProjectKpiMouldTree();
}
