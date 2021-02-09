package com.yueqiangu.project.budget.apply.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yueqiangu.framework.aspectj.lang.annotation.Excel;
import com.yueqiangu.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 资金申报对象 project_money_apply
 *
 * @author yueqiangu
 * @date 2021-02-08
 */
public class ProjectMoneyApply extends BaseEntity
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

    /** 金额 */
    @Excel(name = "金额")
    private String money;

    /** 资金用途 */
    @Excel(name = "资金用途")
    private String note;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 审核人 */
    @Excel(name = "审核人")
    private String reviewer;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reviewerTime;

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
    public void setMoney(String money)
    {
        this.money = money;
    }

    public String getMoney()
    {
        return money;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setReviewer(String reviewer)
    {
        this.reviewer = reviewer;
    }

    public String getReviewer()
    {
        return reviewer;
    }
    public void setReviewerTime(Date reviewerTime)
    {
        this.reviewerTime = reviewerTime;
    }

    public Date getReviewerTime()
    {
        return reviewerTime;
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
            .append("money", getMoney())
            .append("note", getNote())
            .append("status", getStatus())
            .append("reviewer", getReviewer())
            .append("reviewerTime", getReviewerTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
