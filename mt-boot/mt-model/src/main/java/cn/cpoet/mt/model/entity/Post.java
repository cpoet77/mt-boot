package cn.cpoet.mt.model.entity;

import cn.cpoet.mt.model.entity.base.BaseTenantable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 职务
 *
 * @author CPoet
 */
@Data
@Entity
@Table(name = "mt_post")
public class Post extends BaseTenantable {
    /**
     * 名称
     */
    @Column(name = "post", nullable = false)
    private String name;

    /**
     * 排序
     */
    @Column(name = "sorted", nullable = false)
    private Integer sorted;
}
