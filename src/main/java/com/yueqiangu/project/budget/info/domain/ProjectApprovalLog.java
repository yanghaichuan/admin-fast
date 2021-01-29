package com.yueqiangu.project.budget.info.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yueqiangu.framework.aspectj.lang.annotation.Excel;
import com.yueqiangu.framework.web.domain.BaseEntity;

/**
 * 审批日志对象 project_approval_log
 *
 * @author yueqiangu
 * @date 2021-01-28
 */
public class ProjectApprovalLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 项目ID */
    @Excel(name = "项目ID")
    private String porjectId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 审批 */
    @Excel(name = "审批")
    private String opinion;

    /** 审批金额 */
    @Excel(name = "审批金额")
    private BigDecimal amount;

    /** 审批人 */
    @Excel(name = "审批人")
    private Long userId;

    /** 审批人 */
    @Excel(name = "审批人")
    private String userName;

    /** 是否通过1通过2未通过 */
    @Excel(name = "是否通过1通过2未通过")
    private String isPass;

    /** 完成1是0否 */
    @Excel(name = "完成1是0否")
    private String isFinishNode;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPorjectId(String porjectId)
    {
        this.porjectId = porjectId;
    }

    public String getPorjectId()
    {
        return porjectId;
    }
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
    }
    public void setOpinion(String opinion)
    {
        this.opinion = opinion;
    }

    public String getOpinion()
    {
        return opinion;
    }
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setIsPass(String isPass)
    {
        this.isPass = isPass;
    }

    public String getIsPass()
    {
        return isPass;
    }
    public void setIsFinishNode(String isFinishNode)
    {
        this.isFinishNode = isFinishNode;
    }

    public String getIsFinishNode()
    {
        return isFinishNode;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("porjectId", getPorjectId())
            .append("projectName", getProjectName())
            .append("opinion", getOpinion())
            .append("amount", getAmount())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("isPass", getIsPass())
            .append("isFinishNode", getIsFinishNode())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
