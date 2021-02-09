package com.yueqiangu.project.budget.apply.service;

import java.util.List;
import com.yueqiangu.project.budget.apply.domain.ProjectMoneyApply;

/**
 * 资金申报Service接口
 * 
 * @author yueqiangu
 * @date 2021-02-08
 */
public interface IProjectMoneyApplyService 
{
    /**
     * 查询资金申报
     * 
     * @param id 资金申报ID
     * @return 资金申报
     */
    public ProjectMoneyApply selectProjectMoneyApplyById(Long id);

    /**
     * 查询资金申报列表
     * 
     * @param projectMoneyApply 资金申报
     * @return 资金申报集合
     */
    public List<ProjectMoneyApply> selectProjectMoneyApplyList(ProjectMoneyApply projectMoneyApply);

    /**
     * 新增资金申报
     * 
     * @param projectMoneyApply 资金申报
     * @return 结果
     */
    public int insertProjectMoneyApply(ProjectMoneyApply projectMoneyApply);

    /**
     * 修改资金申报
     * 
     * @param projectMoneyApply 资金申报
     * @return 结果
     */
    public int updateProjectMoneyApply(ProjectMoneyApply projectMoneyApply);

    /**
     * 批量删除资金申报
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProjectMoneyApplyByIds(String ids);

    /**
     * 删除资金申报信息
     * 
     * @param id 资金申报ID
     * @return 结果
     */
    public int deleteProjectMoneyApplyById(Long id);
}
