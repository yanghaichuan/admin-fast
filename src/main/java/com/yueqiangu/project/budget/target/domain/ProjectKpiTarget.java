package com.yueqiangu.project.budget.target.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yueqiangu.framework.aspectj.lang.annotation.Excel;
import com.yueqiangu.framework.web.domain.BaseEntity;

/**
 * 项目绩效模板对象 project_kpi_target
 *
 * @author yueqiangu
 * @date 2021-01-25
 */
public class ProjectKpiTarget extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 项目ID */
    private Long projectId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 一级指标ID */
    @Excel(name = "一级指标ID")
    private Long oneLevel;

    /** 一级指标 */
    @Excel(name = "一级指标")
    private String oneLevelName;

    /** 二级指标ID */
    @Excel(name = "二级指标ID")
    private Long twoLevel;

    /** 二级指标 */
    @Excel(name = "二级指标")
    private String twoLevelName;

    /** 三级指标ID */
    @Excel(name = "三级指标ID")
    private Long threeLevel;

    /** 三级指标 */
    @Excel(name = "三级指标")
    private String threeLevelName;

    /** 指标内容 */
    @Excel(name = "指标内容")
    private String target;

    /** 完成率 */
    @Excel(name = "完成率")
    private String targetRate;

    /** 自评得分 */
    @Excel(name = "自评得分")
    private String selfScore;

    /** 得分 */
    @Excel(name = "得分")
    private String score;

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
    public void setOneLevel(Long oneLevel)
    {
        this.oneLevel = oneLevel;
    }

    public Long getOneLevel()
    {
        return oneLevel;
    }
    public void setOneLevelName(String oneLevelName)
    {
        this.oneLevelName = oneLevelName;
    }

    public String getOneLevelName()
    {
        return oneLevelName;
    }
    public void setTwoLevel(Long twoLevel)
    {
        this.twoLevel = twoLevel;
    }

    public Long getTwoLevel()
    {
        return twoLevel;
    }
    public void setTwoLevelName(String twoLevelName)
    {
        this.twoLevelName = twoLevelName;
    }

    public String getTwoLevelName()
    {
        return twoLevelName;
    }
    public void setThreeLevel(Long threeLevel)
    {
        this.threeLevel = threeLevel;
    }

    public Long getThreeLevel()
    {
        return threeLevel;
    }
    public void setThreeLevelName(String threeLevelName)
    {
        this.threeLevelName = threeLevelName;
    }

    public String getThreeLevelName()
    {
        return threeLevelName;
    }
    public void setTarget(String target)
    {
        this.target = target;
    }

    public String getTarget()
    {
        return target;
    }
    public void setTargetRate(String targetRate)
    {
        this.targetRate = targetRate;
    }

    public String getSelfScore() {
        return selfScore;
    }

    public void setSelfScore(String selfScore) {
        this.selfScore = selfScore;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTargetRate()
    {
        return targetRate;
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
            .append("oneLevel", getOneLevel())
            .append("oneLevelName", getOneLevelName())
            .append("twoLevel", getTwoLevel())
            .append("twoLevelName", getTwoLevelName())
            .append("threeLevel", getThreeLevel())
            .append("threeLevelName", getThreeLevelName())
            .append("target", getTarget())
            .append("targetRate", getTargetRate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
