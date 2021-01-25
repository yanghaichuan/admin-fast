package com.ruoyi.project.budget.target.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.budget.target.mapper.ProjectKpiTargetMapper;
import com.ruoyi.project.budget.target.domain.ProjectKpiTarget;
import com.ruoyi.project.budget.target.service.IProjectKpiTargetService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 项目绩效模板Service业务层处理
 * 
 * @author yueqiangu
 * @date 2021-01-25
 */
@Service
public class ProjectKpiTargetServiceImpl implements IProjectKpiTargetService 
{
    @Autowired
    private ProjectKpiTargetMapper projectKpiTargetMapper;

    /**
     * 查询项目绩效模板
     * 
     * @param id 项目绩效模板ID
     * @return 项目绩效模板
     */
    @Override
    public ProjectKpiTarget selectProjectKpiTargetById(Long id)
    {
        return projectKpiTargetMapper.selectProjectKpiTargetById(id);
    }

    /**
     * 查询项目绩效模板列表
     * 
     * @param projectKpiTarget 项目绩效模板
     * @return 项目绩效模板
     */
    @Override
    public List<ProjectKpiTarget> selectProjectKpiTargetList(ProjectKpiTarget projectKpiTarget)
    {
        return projectKpiTargetMapper.selectProjectKpiTargetList(projectKpiTarget);
    }

    /**
     * 新增项目绩效模板
     * 
     * @param projectKpiTarget 项目绩效模板
     * @return 结果
     */
    @Override
    public int insertProjectKpiTarget(ProjectKpiTarget projectKpiTarget)
    {
        projectKpiTarget.setCreateTime(DateUtils.getNowDate());
        return projectKpiTargetMapper.insertProjectKpiTarget(projectKpiTarget);
    }

    /**
     * 修改项目绩效模板
     * 
     * @param projectKpiTarget 项目绩效模板
     * @return 结果
     */
    @Override
    public int updateProjectKpiTarget(ProjectKpiTarget projectKpiTarget)
    {
        projectKpiTarget.setUpdateTime(DateUtils.getNowDate());
        return projectKpiTargetMapper.updateProjectKpiTarget(projectKpiTarget);
    }

    /**
     * 删除项目绩效模板对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProjectKpiTargetByIds(String ids)
    {
        return projectKpiTargetMapper.deleteProjectKpiTargetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目绩效模板信息
     * 
     * @param id 项目绩效模板ID
     * @return 结果
     */
    @Override
    public int deleteProjectKpiTargetById(Long id)
    {
        return projectKpiTargetMapper.deleteProjectKpiTargetById(id);
    }
}
