package cn.cpoet.mt.entity.base;

import cn.cpoet.mt.api.constant.SystemConst;
import io.ebean.Model;
import io.ebean.annotation.SoftDelete;
import io.ebean.annotation.WhenCreated;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

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
@FieldNameConstants
@MappedSuperclass
public abstract class BaseRecordModel extends Model {
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
