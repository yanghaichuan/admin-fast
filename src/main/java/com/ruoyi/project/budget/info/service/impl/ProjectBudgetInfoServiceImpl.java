package com.ruoyi.project.budget.info.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.ruoyi.common.enums.ProjectBudgetDetailEnum;
import com.ruoyi.common.enums.ProjectStatusEnum;
import com.ruoyi.common.enums.SysDelFlag;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.budget.detail.domain.ProjectBudgetDetail;
import com.ruoyi.project.budget.detail.service.IProjectBudgetDetailService;
import com.ruoyi.project.budget.target.domain.ProjectKpiTarget;
import com.ruoyi.project.budget.target.service.IProjectKpiTargetService;
import com.ruoyi.project.system.attachment.domain.ProjectAttachment;
import com.ruoyi.project.system.attachment.service.IProjectAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private IProjectBudgetDetailService projectBudgetDetailService;

    @Autowired
    private IProjectAttachmentService projectAttachmentService;

    @Autowired
    private IProjectKpiTargetService projectKpiTargetService;

    /**
     * 查询项目管理
     *
     * @param id 项目管理ID
     * @return 项目管理
     */
    @Override
    public ProjectBudgetInfo selectProjectBudgetInfoById(Long id)
    {
        ProjectBudgetInfo projectBudgetInfo = projectBudgetInfoMapper.selectProjectBudgetInfoById(id);
        //查询详情
        ProjectBudgetDetail projectBudgetDetail = new ProjectBudgetDetail();
        projectBudgetDetail.setProjectCode(projectBudgetInfo.getProjectCode());
        List<ProjectBudgetDetail> projectBudgetDetailList =  projectBudgetDetailService.selectProjectBudgetDetailList(projectBudgetDetail);

        //分组
        Map<String, List<ProjectBudgetDetail>> groupByType= projectBudgetDetailList.stream().collect(Collectors.groupingBy(ProjectBudgetDetail::getType));
        //遍历分组
        for (Map.Entry<String, List<ProjectBudgetDetail>> p: groupByType.entrySet()) {
            String key = p.getKey();
            List<ProjectBudgetDetail> projectBudgetDetailList1 = p.getValue();
            if(ProjectBudgetDetailEnum.DETAIL_TYPE_TWO.getValue().equals(key)){
                projectBudgetInfo.setProjectBudgetDetailList(projectBudgetDetailList1);
            }else if(ProjectBudgetDetailEnum.DETAIL_TYPE_THREE.getValue().equals(key)){
                projectBudgetInfo.setProjectBudgetDetailThreeList(projectBudgetDetailList1);
            }
        }

        //查询附件
        ProjectAttachment projectAttachment = new ProjectAttachment();
        projectAttachment.setProjectId(id);
        projectAttachment.setDelFlag(SysDelFlag.NORMAL.getCode());
        List<ProjectAttachment>  projectAttachmentList =  projectAttachmentService.selectProjectAttachmentList(projectAttachment);
        projectBudgetInfo.setAttachmentList(projectAttachmentList);

        ProjectKpiTarget projectKpiTarget = new ProjectKpiTarget();
        projectKpiTarget.setProjectId(id);
        List<ProjectKpiTarget>  projectKpiTargetList = projectKpiTargetService.selectProjectKpiTargetList(projectKpiTarget);
        projectBudgetInfo.setProjectKpiTargetList(projectKpiTargetList);
        return projectBudgetInfo;
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
        List<ProjectBudgetInfo>  projectBudgetInfoList = projectBudgetInfoMapper.selectProjectBudgetInfoList(projectBudgetInfo);
        for(ProjectBudgetInfo projectBudgetInfo1:projectBudgetInfoList){
            ProjectBudgetDetail projectBudgetDetail = new ProjectBudgetDetail();
            projectBudgetDetail.setProjectCode(projectBudgetInfo1.getProjectCode());
            List<ProjectBudgetDetail> projectBudgetDetailList =  projectBudgetDetailService.selectProjectBudgetDetailList(projectBudgetDetail);

            //分组
            Map<String, List<ProjectBudgetDetail>> groupByType= projectBudgetDetailList.stream().collect(Collectors.groupingBy(ProjectBudgetDetail::getType));
            //遍历分组
            for (Map.Entry<String, List<ProjectBudgetDetail>> p: groupByType.entrySet()) {
                String key = p.getKey();
                List<ProjectBudgetDetail> projectBudgetDetailList1 = p.getValue();
                if(ProjectBudgetDetailEnum.DETAIL_TYPE_TWO.getValue().equals(key)){
                    projectBudgetInfo1.setProjectBudgetDetailList(projectBudgetDetailList1);
                }else if(ProjectBudgetDetailEnum.DETAIL_TYPE_THREE.getValue().equals(key)){
                    projectBudgetInfo1.setProjectBudgetDetailThreeList(projectBudgetDetailList1);
                }
            }
            ProjectKpiTarget projectKpiTarget = new ProjectKpiTarget();
            projectKpiTarget.setProjectId(projectBudgetInfo1.getId());
            List<ProjectKpiTarget> projectKpiTargetList = projectKpiTargetService.selectProjectKpiTargetList(projectKpiTarget);
            projectBudgetInfo1.setTargetNum(projectKpiTargetList.size());
        }
        return projectBudgetInfoList;
    }

    /**
     * 新增项目管理
     *
     * @param projectBudgetInfo 项目管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertProjectBudgetInfo(ProjectBudgetInfo projectBudgetInfo)
    {
        projectBudgetInfo.setStatus(ProjectStatusEnum.INFO.getCode());
        projectBudgetInfo.setCreateTime(DateUtils.getNowDate());
        int rows = projectBudgetInfoMapper.insertProjectBudgetInfo(projectBudgetInfo);
        ;
        if(StringUtils.isNotEmpty(projectBudgetInfo.getProjectBudgetDetailList())){
            projectBudgetInfo.getProjectBudgetDetailList().forEach(data->{
                data.setType(ProjectBudgetDetailEnum.DETAIL_TYPE_TWO.getValue());
            });
        }
        if(StringUtils.isNotEmpty(projectBudgetInfo.getProjectBudgetDetailThreeList())){
            projectBudgetInfo.getProjectBudgetDetailThreeList().forEach(data->{
                data.setType(ProjectBudgetDetailEnum.DETAIL_TYPE_THREE.getValue());
            });
            projectBudgetInfo.getProjectBudgetDetailList().addAll(projectBudgetInfo.getProjectBudgetDetailThreeList());
        }
        insertProjectBudgetDetail(projectBudgetInfo);
        if(StringUtils.isNotEmpty(projectBudgetInfo.getAttachmentStr())){
            List<ProjectAttachment> projectAttachmentList = JSON.parseObject(projectBudgetInfo.getAttachmentStr(),new TypeReference<List<ProjectAttachment>>(){});
            if(StringUtils.isNotEmpty(projectAttachmentList)){
                projectAttachmentList.forEach(data->{
                    data.setProjectId(projectBudgetInfo.getId());
                    data.setId(null);
                    projectAttachmentService.insertProjectAttachment(data);
                });
            }
        }
        return rows;
    }

    /**
     * 修改项目管理
     *
     * @param projectBudgetInfo 项目管理
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateProjectBudgetInfo(ProjectBudgetInfo projectBudgetInfo)
    {
        projectBudgetInfo.setUpdateTime(DateUtils.getNowDate());
        if(StringUtils.isNotEmpty(projectBudgetInfo.getProjectBudgetDetailList())){
            projectBudgetInfo.getProjectBudgetDetailList().forEach(data->{
                data.setType(ProjectBudgetDetailEnum.DETAIL_TYPE_TWO.getValue());
            });
        }
        if(StringUtils.isNotEmpty(projectBudgetInfo.getProjectBudgetDetailThreeList())){
            projectBudgetInfo.getProjectBudgetDetailThreeList().forEach(data->{
                data.setType(ProjectBudgetDetailEnum.DETAIL_TYPE_THREE.getValue());
            });
            projectBudgetInfo.getProjectBudgetDetailList().addAll(projectBudgetInfo.getProjectBudgetDetailThreeList());
        }
        projectBudgetInfoMapper.deleteProjectBudgetDetailByProjectCode(projectBudgetInfo.getProjectCode());
        insertProjectBudgetDetail(projectBudgetInfo);
        //删除附件
        projectAttachmentService.deleteByProjectId(projectBudgetInfo.getId());
        //保存附件
        if(StringUtils.isNotEmpty(projectBudgetInfo.getAttachmentStr())){
            List<ProjectAttachment> projectAttachmentList = JSON.parseObject(projectBudgetInfo.getAttachmentStr(),new TypeReference<List<ProjectAttachment>>(){});
            if(StringUtils.isNotEmpty(projectAttachmentList)){
                projectAttachmentList.forEach(data->{
                    data.setProjectId(projectBudgetInfo.getId());
                    data.setId(null);
                    projectAttachmentService.insertProjectAttachment(data);
                });
            }
        }
        return projectBudgetInfoMapper.updateProjectBudgetInfo(projectBudgetInfo);
    }

    /**
     * 删除项目管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
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
        ProjectBudgetInfo projectBudgetInfo= projectBudgetInfoMapper.selectProjectBudgetInfoById(id);
        projectBudgetInfoMapper.deleteProjectBudgetDetailByProjectCode(projectBudgetInfo.getProjectCode());
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
