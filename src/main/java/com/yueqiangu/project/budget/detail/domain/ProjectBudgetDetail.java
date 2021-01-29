package com.yueqiangu.project.budget.detail.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yueqiangu.framework.aspectj.lang.annotation.Excel;
import com.yueqiangu.framework.web.domain.BaseEntity;

/**
 * 项目明细对象 project_budget_detail
 *
 * @author yueqiangu
 * @date 2021-01-10
 */
public class ProjectBudgetDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 项目编码 */
    @Excel(name = "项目编码")
    private String projectCode;

    /** 项目构成 */
    @Excel(name = "项目构成")
    private String constitute;

    /** 科目 */
    @Excel(name = "科目")
    private String subject;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 明细内容 */
    @Excel(name = "明细内容")
    private String detail;

    /** 资金来源 */
    @Excel(name = "资金来源")
    private String source;

    /** 规格类型 */
    @Excel(name = "规格类型")
    private Long specification;

    /** 金额类别 */
    @Excel(name = "金额类别")
    private Long funds;

    /** 经济科目 */
    @Excel(name = "经济科目")
    private Long ecmSubjects;

    /** 政府经济科目 */
    @Excel(name = "政府经济科目")
    private String govEconomy;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

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
    public void setConstitute(String constitute)
    {
        this.constitute = constitute;
    }

    public String getConstitute()
    {
        return constitute;
    }
    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getSubject()
    {
        return subject;
    }
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getDetail()
    {
        return detail;
    }
    public void setSource(String source)
    {
        this.source = source;
    }

    public String getSource()
    {
        return source;
    }
    public void setSpecification(Long specification)
    {
        this.specification = specification;
    }

    public Long getSpecification()
    {
        return specification;
    }
    public void setFunds(Long funds)
    {
        this.funds = funds;
    }

    public Long getFunds()
    {
        return funds;
    }
    public void setEcmSubjects(Long ecmSubjects)
    {
        this.ecmSubjects = ecmSubjects;
    }

    public Long getEcmSubjects()
    {
        return ecmSubjects;
    }
    public void setGovEconomy(String govEconomy)
    {
        this.govEconomy = govEconomy;
    }

    public String getGovEconomy()
    {
        return govEconomy;
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
            .append("projectCode", getProjectCode())
            .append("constitute", getConstitute())
            .append("subject", getSubject())
            .append("amount", getAmount())
            .append("type", getType())
            .append("detail", getDetail())
            .append("source", getSource())
            .append("specification", getSpecification())
            .append("funds", getFunds())
            .append("ecmSubjects", getEcmSubjects())
            .append("govEconomy", getGovEconomy())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
