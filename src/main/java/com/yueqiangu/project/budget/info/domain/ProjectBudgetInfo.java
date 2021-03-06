package com.yueqiangu.project.budget.info.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yueqiangu.project.budget.detail.domain.ProjectBudgetDetail;
import com.yueqiangu.project.budget.target.domain.ProjectKpiTarget;
import com.yueqiangu.project.system.attachment.domain.ProjectAttachment;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yueqiangu.framework.aspectj.lang.annotation.Excel;
import com.yueqiangu.framework.web.domain.BaseEntity;

/**
 * 项目管理对象 project_budget_info
 *
 * @author yueqiangu
 * @date 2021-01-10
 */
public class ProjectBudgetInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 项目编码 */
    @Excel(name = "项目编码")
    private String projectCode;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目类别 */
    @Excel(name = "项目类别")
    private Long projectCategroy;

    /** 项目类型 */
    @Excel(name = "项目类型")
    private Long projectType;

    /** 项目说明 */
    @Excel(name = "项目说明")
    private String projectContent;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finshTime;

    /** 是否参与绩效考核 */
    @Excel(name = "是否参与绩效考核")
    private String isKpi;

    /** 是否专业评审 */
    @Excel(name = "是否专业评审")
    private String isReview;

    /** 是否纳入本年预算 */
    @Excel(name = "是否纳入本年预算")
    private String isBudget;

    /** 总预算 */
    @Excel(name = "总预算")
    private String generalBudget;

    /** 状态通过 */
    @Excel(name = "状态通过")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 项目明细信息 */
    private List<ProjectBudgetDetail> projectBudgetDetailList;
    /**
     * 三级明细
     */
    private List<ProjectBudgetDetail> projectBudgetDetailThreeList;
    /**
     * 附件列表
     */
    private List<ProjectAttachment> attachmentList;

    private String attachmentStr;

    /**
     * 绩效目标
     */
    private List<ProjectKpiTarget> projectKpiTargetList;
    /**
     * 绩效目标数量
      */
    private Integer targetNum;
    /**
     * 审核信息
      */
    private ProjectApprovalLog  projectApprovalLog;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setProjectCode(String projectCode)
    {
        this.projectCode = projectCode;
    }

    public String getProjectCode()
    {
        return projectCode;
    }
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
    }
    public void setProjectCategroy(Long projectCategroy)
    {
        this.projectCategroy = projectCategroy;
    }

    public Long getProjectCategroy()
    {
        return projectCategroy;
    }
    public void setProjectType(Long projectType)
    {
        this.projectType = projectType;
    }

    public Long getProjectType()
    {
        return projectType;
    }
    public void setProjectContent(String projectContent)
    {
        this.projectContent = projectContent;
    }

    public String getProjectContent()
    {
        return projectContent;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setFinshTime(Date finshTime)
    {
        this.finshTime = finshTime;
    }

    public Date getFinshTime()
    {
        return finshTime;
    }
    public void setIsKpi(String isKpi)
    {
        this.isKpi = isKpi;
    }

    public String getIsKpi()
    {
        return isKpi;
    }
    public void setIsReview(String isReview)
    {
        this.isReview = isReview;
    }

    public String getIsReview()
    {
        return isReview;
    }
    public void setIsBudget(String isBudget)
    {
        this.isBudget = isBudget;
    }

    public String getIsBudget()
    {
        return isBudget;
    }
    public void setGeneralBudget(String generalBudget)
    {
        this.generalBudget = generalBudget;
    }

    public String getGeneralBudget()
    {
        return generalBudget;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }


    public List<ProjectBudgetDetail> getProjectBudgetDetailList()
    {
        return projectBudgetDetailList;
    }

    public void setProjectBudgetDetailList(List<ProjectBudgetDetail> projectBudgetDetailList)
    {
        this.projectBudgetDetailList = projectBudgetDetailList;
    }

    public List<ProjectBudgetDetail> getProjectBudgetDetailThreeList() {
        return projectBudgetDetailThreeList;
    }

    public void setProjectBudgetDetailThreeList(List<ProjectBudgetDetail> projectBudgetDetailThreeList) {
        this.projectBudgetDetailThreeList = projectBudgetDetailThreeList;
    }

    public List<ProjectAttachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<ProjectAttachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public String getAttachmentStr() {
        return attachmentStr;
    }

    public void setAttachmentStr(String attachmentStr) {
        this.attachmentStr = attachmentStr;
    }

    public List<ProjectKpiTarget> getProjectKpiTargetList() {
        return projectKpiTargetList;
    }

    public void setProjectKpiTargetList(List<ProjectKpiTarget> projectKpiTargetList) {
        this.projectKpiTargetList = projectKpiTargetList;
    }

    public Integer getTargetNum() {
        return targetNum;
    }

    public void setTargetNum(Integer targetNum) {
        this.targetNum = targetNum;
    }

    public ProjectApprovalLog getProjectApprovalLog() {
        return projectApprovalLog;
    }

    public void setProjectApprovalLog(ProjectApprovalLog projectApprovalLog) {
        this.projectApprovalLog = projectApprovalLog;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectCode", getProjectCode())
            .append("projectName", getProjectName())
            .append("projectCategroy", getProjectCategroy())
            .append("projectType", getProjectType())
            .append("projectContent", getProjectContent())
            .append("startTime", getStartTime())
            .append("finshTime", getFinshTime())
            .append("isKpi", getIsKpi())
            .append("isReview", getIsReview())
            .append("isBudget", getIsBudget())
            .append("generalBudget", getGeneralBudget())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("projectBudgetDetailList", getProjectBudgetDetailList())
            .toString();
    }
}
