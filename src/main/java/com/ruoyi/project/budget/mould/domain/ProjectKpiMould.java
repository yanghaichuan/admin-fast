package com.ruoyi.project.budget.mould.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.TreeEntity;

import java.util.List;

/**
 * 项目绩效目标对象 project_kpi_mould
 *
 * @author yueqiangu
 * @date 2021-01-24
 */
public class ProjectKpiMould extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 绩效名称 */
    @Excel(name = "绩效名称")
    private String kpiName;

    /** 绩效内容 */
    @Excel(name = "绩效内容")
    private String kpiContent;

    /** 绩效级别 */
    @Excel(name = "绩效级别")
    private String kpiLevel;

    /** 绩效目标 */
    @Excel(name = "绩效目标")
    private String kpiTarget;

    /** 目标金额 */
    @Excel(name = "目标金额")
    private String targetAmount;

    /** 目标完成率 */
    @Excel(name = "目标完成率")
    private String targetRate;

    /** 路由 */
    private String route;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    private List<ProjectKpiMould> children;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setKpiName(String kpiName)
    {
        this.kpiName = kpiName;
    }

    public String getKpiName()
    {
        return kpiName;
    }
    public void setKpiContent(String kpiContent)
    {
        this.kpiContent = kpiContent;
    }

    public String getKpiContent()
    {
        return kpiContent;
    }
    public void setKpiLevel(String kpiLevel)
    {
        this.kpiLevel = kpiLevel;
    }

    public String getKpiLevel()
    {
        return kpiLevel;
    }
    public void setKpiTarget(String kpiTarget)
    {
        this.kpiTarget = kpiTarget;
    }

    public String getKpiTarget()
    {
        return kpiTarget;
    }
    public void setTargetAmount(String targetAmount)
    {
        this.targetAmount = targetAmount;
    }

    public String getTargetAmount()
    {
        return targetAmount;
    }
    public void setTargetRate(String targetRate)
    {
        this.targetRate = targetRate;
    }

    public String getTargetRate()
    {
        return targetRate;
    }
    public void setRoute(String route)
    {
        this.route = route;
    }

    public String getRoute()
    {
        return route;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public List<ProjectKpiMould> getChildren() {
        return children;
    }

    public void setChildren(List<ProjectKpiMould> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("kpiName", getKpiName())
            .append("kpiContent", getKpiContent())
            .append("kpiLevel", getKpiLevel())
            .append("kpiTarget", getKpiTarget())
            .append("targetAmount", getTargetAmount())
            .append("targetRate", getTargetRate())
            .append("parentId", getParentId())
            .append("route", getRoute())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
