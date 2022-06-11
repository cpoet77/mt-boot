package cn.cpoet.mt.entity.base;

import io.ebean.annotation.SoftDelete;
import io.ebean.annotation.WhenCreated;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * 记录型实体不涉及修改
 *
 * @author CPoet
 */
@Data
@FieldNameConstants
public abstract class BaseRecordModel {
    /**
     * pk
     */
    @Id
    private Long id;

    /**
     * 逻辑删除
     */
    @SoftDelete
    private Long deleted;

    /**
     * 创建时间
     */
    @WhenCreated
    private LocalDateTime createdTime;
}
