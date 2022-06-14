package cn.cpoet.mt.model.base;

import cn.cpoet.mt.api.constant.SystemConst;
import cn.cpoet.mt.db.domain.BaseDbModel;
import io.ebean.annotation.SoftDelete;
import io.ebean.annotation.WhenCreated;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 记录型实体不涉及修改
 *
 * @author CPoet
 */
@Data
@MappedSuperclass
public abstract class BaseRecordModel extends BaseDbModel {
    /**
     * pk
     */
    @Id
    @GeneratedValue(generator = SystemConst.EBEAN_ID_GRT_NAME)
    private Long id;

    /**
     * 逻辑删除
     */
    @SoftDelete
    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    /**
     * 创建时间
     */
    @WhenCreated
    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;
}
