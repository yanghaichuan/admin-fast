package com.yueqiangu.project.budget.mould.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.yueqiangu.framework.web.domain.Ztree;
import com.yueqiangu.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yueqiangu.project.budget.mould.mapper.ProjectKpiMouldMapper;
import com.yueqiangu.project.budget.mould.domain.ProjectKpiMould;
import com.yueqiangu.project.budget.mould.service.IProjectKpiMouldService;
import com.yueqiangu.common.utils.text.Convert;

/**
 * 项目绩效目标Service业务层处理
 *
 * @author yueqiangu
 * @date 2021-01-24
 */
@Service
public class ProjectKpiMouldServiceImpl implements IProjectKpiMouldService
{
    @Autowired
    private ProjectKpiMouldMapper projectKpiMouldMapper;

    /**
     * 查询项目绩效目标
     *
     * @param id 项目绩效目标ID
     * @return 项目绩效目标
     */
    @Override
    public ProjectKpiMould selectProjectKpiMouldById(Long id)
    {
        return projectKpiMouldMapper.selectProjectKpiMouldById(id);
    }

    /**
     * 查询项目绩效目标列表
     *
     * @param projectKpiMould 项目绩效目标
     * @return 项目绩效目标
     */
    @Override
    public List<ProjectKpiMould> selectProjectKpiMouldList(ProjectKpiMould projectKpiMould)
    {
        return projectKpiMouldMapper.selectProjectKpiMouldList(projectKpiMould);
    }

    /**
     * 新增项目绩效目标
     *
     * @param projectKpiMould 项目绩效目标
     * @return 结果
     */
    @Override
    public int insertProjectKpiMould(ProjectKpiMould projectKpiMould)
    {
        projectKpiMould.setCreateTime(DateUtils.getNowDate());
        return projectKpiMouldMapper.insertProjectKpiMould(projectKpiMould);
    }

    /**
     * 修改项目绩效目标
     *
     * @param projectKpiMould 项目绩效目标
     * @return 结果
     */
    @Override
    public int updateProjectKpiMould(ProjectKpiMould projectKpiMould)
    {
        projectKpiMould.setUpdateTime(DateUtils.getNowDate());
        return projectKpiMouldMapper.updateProjectKpiMould(projectKpiMould);
    }

    /**
     * 删除项目绩效目标对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProjectKpiMouldByIds(String ids)
    {
        return projectKpiMouldMapper.deleteProjectKpiMouldByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目绩效目标信息
     *
     * @param id 项目绩效目标ID
     * @return 结果
     */
    @Override
    public int deleteProjectKpiMouldById(Long id)
    {
        return projectKpiMouldMapper.deleteProjectKpiMouldById(id);
    }

    /**
     * 查询项目绩效目标树列表
     *
     * @return 所有项目绩效目标信息
     */
    @Override
    public List<Ztree> selectProjectKpiMouldTree()
    {
        List<ProjectKpiMould> projectKpiMouldList = projectKpiMouldMapper.selectProjectKpiMouldList(new ProjectKpiMould());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (ProjectKpiMould projectKpiMould : projectKpiMouldList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(projectKpiMould.getId());
            ztree.setpId(projectKpiMould.getParentId());
            ztree.setName(projectKpiMould.getKpiName());
            ztree.setTitle(projectKpiMould.getKpiName());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    @Override
    public List<ProjectKpiMould> selectMouldList(ProjectKpiMould projectKpiMould) {
        return projectKpiMouldMapper.selectMouldList(projectKpiMould);
    }
}
