package com.yueqiangu.project.budget.appraisal.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yueqiangu.common.utils.DateUtils;
import com.yueqiangu.common.utils.StringUtils;
import com.yueqiangu.project.budget.target.domain.ProjectKpiTarget;
import com.yueqiangu.project.budget.target.service.IProjectKpiTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yueqiangu.project.budget.appraisal.mapper.ProjectSelfAppraisalMapper;
import com.yueqiangu.project.budget.appraisal.domain.ProjectSelfAppraisal;
import com.yueqiangu.project.budget.appraisal.service.IProjectSelfAppraisalService;
import com.yueqiangu.common.utils.text.Convert;

/**
 * 绩效自评Service业务层处理
 *
 * @author yueqiangu
 * @date 2021-04-02
 */
@Service
public class ProjectSelfAppraisalServiceImpl implements IProjectSelfAppraisalService
{
    @Autowired
    private ProjectSelfAppraisalMapper projectSelfAppraisalMapper;
    @Autowired
    private IProjectKpiTargetService projectKpiTargetService;

    /**
     * 查询绩效自评
     *
     * @param id 绩效自评ID
     * @return 绩效自评
     */
    @Override
    public ProjectSelfAppraisal selectProjectSelfAppraisalById(Long id)
    {
        return projectSelfAppraisalMapper.selectProjectSelfAppraisalById(id);
    }

    /**
     * 查询绩效自评列表
     *
     * @param projectSelfAppraisal 绩效自评
     * @return 绩效自评
     */
    @Override
    public List<ProjectSelfAppraisal> selectProjectSelfAppraisalList(ProjectSelfAppraisal projectSelfAppraisal)
    {
        return projectSelfAppraisalMapper.selectProjectSelfAppraisalList(projectSelfAppraisal);
    }

    /**
     * 新增绩效自评
     *
     * @param projectSelfAppraisal 绩效自评
     * @return 结果
     */
    @Override
    public int insertProjectSelfAppraisal(ProjectSelfAppraisal projectSelfAppraisal)
    {
        projectSelfAppraisal.setCreateTime(DateUtils.getNowDate());
        if(StringUtils.isNotEmpty(projectSelfAppraisal.getTargetStr())){
            List<ProjectKpiTarget> projectKpiTargetList = JSONArray.parseArray(projectSelfAppraisal.getTargetStr(),ProjectKpiTarget.class);
            for(ProjectKpiTarget target : projectKpiTargetList){
                projectKpiTargetService.updateProjectKpiTarget(target);
            }
        }
        return projectSelfAppraisalMapper.insertProjectSelfAppraisal(projectSelfAppraisal);
    }

    /**
     * 修改绩效自评
     *
     * @param projectSelfAppraisal 绩效自评
     * @return 结果
     */
    @Override
    public int updateProjectSelfAppraisal(ProjectSelfAppraisal projectSelfAppraisal)
    {
        projectSelfAppraisal.setUpdateTime(DateUtils.getNowDate());
        return projectSelfAppraisalMapper.updateProjectSelfAppraisal(projectSelfAppraisal);
    }

    /**
     * 删除绩效自评对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProjectSelfAppraisalByIds(String ids)
    {
        return projectSelfAppraisalMapper.deleteProjectSelfAppraisalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除绩效自评信息
     *
     * @param id 绩效自评ID
     * @return 结果
     */
    @Override
    public int deleteProjectSelfAppraisalById(Long id)
    {
        return projectSelfAppraisalMapper.deleteProjectSelfAppraisalById(id);
    }
}
