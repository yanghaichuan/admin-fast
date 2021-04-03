package com.yueqiangu.project.budget.appraisal.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yueqiangu.framework.aspectj.lang.annotation.Excel;
import com.yueqiangu.framework.web.domain.BaseEntity;

/**
 * 绩效自评对象 project_self_appraisal
 *
 * @author yueqiangu
 * @date 2021-04-02
 */
public class ProjectSelfAppraisal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long projectId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 预算单位ID */
    @Excel(name = "预算单位ID")
    private Long deptId;

    /** 预算单位 */
    @Excel(name = "预算单位")
    private String deptName;

    /** 执行科室 */
    @Excel(name = "执行科室")
    private String childDept;

    /** 当年预算 */
    @Excel(name = "当年预算")
    private String budgetYear;

    /** 前年预算 */
    @Excel(name = "前年预算")
    private String budgetBefore;

    /** 自评结果 */
    @Excel(name = "自评结果")
    private String selfResult;

    /** 自评时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "自评时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date selfTime;

    /** 是否经常项目 */
    @Excel(name = "是否经常项目")
    private String isOften;

    /** 绩效等级 */
    @Excel(name = "绩效等级")
    private String grade;

    /** 主要绩效 */
    @Excel(name = "主要绩效")
    private String achievement;

    /** 主要问题 */
    @Excel(name = "主要问题")
    private String problem;

    /** 改进措施 */
    @Excel(name = "改进措施")
    private String improvement;

    /** 改进措施 */
    @Excel(name = "改进措施")
    private String budgetImplement;


    /** 预算执行率 */
    @Excel(name = "预算执行率")
    private String implementRate;

    /** 年度目标 */
    @Excel(name = "年度目标")
    private String yearTarget;

    /**
     * 目标信息
     */
    private String targetStr;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }

    public Long getProjectId()
    {
        return projectId;
    }
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getDeptName()
    {
        return deptName;
    }
    public void setChildDept(String childDept)
    {
        this.childDept = childDept;
    }

    public String getChildDept()
    {
        return childDept;
    }
    public void setBudgetYear(String budgetYear)
    {
        this.budgetYear = budgetYear;
    }

    public String getBudgetYear()
    {
        return budgetYear;
    }
    public void setBudgetBefore(String budgetBefore)
    {
        this.budgetBefore = budgetBefore;
    }

    public String getBudgetBefore()
    {
        return budgetBefore;
    }
    public void setSelfResult(String selfResult)
    {
        this.selfResult = selfResult;
    }

    public String getSelfResult()
    {
        return selfResult;
    }
    public void setSelfTime(Date selfTime)
    {
        this.selfTime = selfTime;
    }

    public Date getSelfTime()
    {
        return selfTime;
    }
    public void setIsOften(String isOften)
    {
        this.isOften = isOften;
    }

    public String getIsOften()
    {
        return isOften;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGrade()
    {
        return grade;
    }
    public void setAchievement(String achievement)
    {
        this.achievement = achievement;
    }

    public String getBudgetImplement() {
        return budgetImplement;
    }

    public void setBudgetImplement(String budgetImplement) {
        this.budgetImplement = budgetImplement;
    }

    public String getImplementRate() {
        return implementRate;
    }

    public void setImplementRate(String implementRate) {
        this.implementRate = implementRate;
    }

    public String getAchievement()
    {
        return achievement;
    }
    public void setProblem(String problem)
    {
        this.problem = problem;
    }

    public String getProblem()
    {
        return problem;
    }
    public void setImprovement(String improvement)
    {
        this.improvement = improvement;
    }

    public String getImprovement()
    {
        return improvement;
    }
    public void setYearTarget(String yearTarget)
    {
        this.yearTarget = yearTarget;
    }

    public String getYearTarget()
    {
        return yearTarget;
    }

    public String getTargetStr() {
        return targetStr;
    }

    public void setTargetStr(String targetStr) {
        this.targetStr = targetStr;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("projectName", getProjectName())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("childDept", getChildDept())
            .append("budgetYear", getBudgetYear())
            .append("budgetBefore", getBudgetBefore())
            .append("selfResult", getSelfResult())
            .append("selfTime", getSelfTime())
            .append("isOften", getIsOften())
            .append("grade", getGrade())
            .append("achievement", getAchievement())
            .append("problem", getProblem())
            .append("improvement", getImprovement())
            .append("yearTarget", getYearTarget())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
