package com.ruoyi.project.budget.info.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.budget.info.domain.ProjectBudgetDetail;
import com.ruoyi.project.budget.info.mapper.ProjectBudgetInfoMapper;
import com.ruoyi.project.budget.info.domain.ProjectBudgetInfo;
import com.ruoyi.project.budget.info.service.IProjectBudgetInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 项目管理Service业务层处理
 *
 * @author yueqiangu
 * @date 2021-01-10
 */
@Service
public class ProjectBudgetInfoServiceImpl implements IProjectBudgetInfoService
{
    @Autowired
    private ProjectBudgetInfoMapper projectBudgetInfoMapper;

    /**
     * 查询项目管理
     *
     * @param id 项目管理ID
     * @return 项目管理
     */
    @Override
    public ProjectBudgetInfo selectProjectBudgetInfoById(Long id)
    {
        return projectBudgetInfoMapper.selectProjectBudgetInfoById(id);
    }

    /**
     * 查询项目管理列表
     *
     * @param projectBudgetInfo 项目管理
     * @return 项目管理
     */
    @Override
    public List<ProjectBudgetInfo> selectProjectBudgetInfoList(ProjectBudgetInfo projectBudgetInfo)
    {
        return projectBudgetInfoMapper.selectProjectBudgetInfoList(projectBudgetInfo);
    }

    /**
     * 新增项目管理
     *
     * @param projectBudgetInfo 项目管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertProjectBudgetInfo(ProjectBudgetInfo projectBudgetInfo)
    {
        projectBudgetInfo.setCreateTime(DateUtils.getNowDate());
        int rows = projectBudgetInfoMapper.insertProjectBudgetInfo(projectBudgetInfo);
        insertProjectBudgetDetail(projectBudgetInfo);
        return rows;
    }

    /**
     * 修改项目管理
     *
     * @param projectBudgetInfo 项目管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateProjectBudgetInfo(ProjectBudgetInfo projectBudgetInfo)
    {
        projectBudgetInfo.setUpdateTime(DateUtils.getNowDate());
        projectBudgetInfoMapper.deleteProjectBudgetDetailByProjectCode(projectBudgetInfo.getId());
        insertProjectBudgetDetail(projectBudgetInfo);
        return projectBudgetInfoMapper.updateProjectBudgetInfo(projectBudgetInfo);
    }

    /**
     * 删除项目管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteProjectBudgetInfoByIds(String ids)
    {
        projectBudgetInfoMapper.deleteProjectBudgetDetailByProjectCodes(Convert.toStrArray(ids));
        return projectBudgetInfoMapper.deleteProjectBudgetInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目管理信息
     *
     * @param id 项目管理ID
     * @return 结果
     */
    @Override
    public int deleteProjectBudgetInfoById(Long id)
    {
        projectBudgetInfoMapper.deleteProjectBudgetDetailByProjectCode(id);
        return projectBudgetInfoMapper.deleteProjectBudgetInfoById(id);
    }

    /**
     * 新增项目明细信息
     *
     * @param projectBudgetInfo 项目管理对象
     */
    public void insertProjectBudgetDetail(ProjectBudgetInfo projectBudgetInfo)
    {
        List<ProjectBudgetDetail> projectBudgetDetailList = projectBudgetInfo.getProjectBudgetDetailList();
        String projectCode = projectBudgetInfo.getProjectCode();
        if (StringUtils.isNotNull(projectBudgetDetailList))
        {
            List<ProjectBudgetDetail> list = new ArrayList<ProjectBudgetDetail>();
            for (ProjectBudgetDetail projectBudgetDetail : projectBudgetDetailList)
            {
                projectBudgetDetail.setProjectCode(projectCode);
                list.add(projectBudgetDetail);
            }
            if (list.size() > 0)
            {
                projectBudgetInfoMapper.batchProjectBudgetDetail(list);
            }
        }
    }
}
