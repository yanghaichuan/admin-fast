package com.yueqiangu.project.budget.appraisal.service;

import java.util.List;
import com.yueqiangu.project.budget.appraisal.domain.ProjectSelfAppraisal;

/**
 * 绩效自评Service接口
 * 
 * @author yueqiangu
 * @date 2021-04-02
 */
public interface IProjectSelfAppraisalService 
{
    /**
     * 查询绩效自评
     * 
     * @param id 绩效自评ID
     * @return 绩效自评
     */
    public ProjectSelfAppraisal selectProjectSelfAppraisalById(Long id);

    /**
     * 查询绩效自评列表
     * 
     * @param projectSelfAppraisal 绩效自评
     * @return 绩效自评集合
     */
    public List<ProjectSelfAppraisal> selectProjectSelfAppraisalList(ProjectSelfAppraisal projectSelfAppraisal);

    /**
     * 新增绩效自评
     * 
     * @param projectSelfAppraisal 绩效自评
     * @return 结果
     */
    public int insertProjectSelfAppraisal(ProjectSelfAppraisal projectSelfAppraisal);

    /**
     * 修改绩效自评
     * 
     * @param projectSelfAppraisal 绩效自评
     * @return 结果
     */
    public int updateProjectSelfAppraisal(ProjectSelfAppraisal projectSelfAppraisal);

    /**
     * 批量删除绩效自评
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectSelfAppraisalByIds(String ids);

    /**
     * 删除绩效自评信息
     * 
     * @param id 绩效自评ID
     * @return 结果
     */
    public int deleteProjectSelfAppraisalById(Long id);
}
