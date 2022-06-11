package cn.cpoet.mt.entity.base;

import io.ebean.annotation.*;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Id;
import javax.persistence.Version;
import java.time.LocalDateTime;

/**
 * 实体基类
 *
 * @author CPoet
 */
@Data
@FieldNameConstants
public abstract class BaseModel {
    /**
     * 实体id
     */
    @Id
    private Long id;

    /**
     * 版本
     */
    @Version
    private Integer version;

    /**
     * 最后操作的用户id
     */
    @WhoModified
    private Long lastModStaff;

    /**
     * 软删除
     */
    @SoftDelete
    private Boolean deleted;

    /**
     * 创建时间
     */
    @WhenCreated
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    @WhenModified
    private LocalDateTime updatedTime;
}
