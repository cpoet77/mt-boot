package cn.cpoet.mt.model.base;

import cn.cpoet.mt.api.constant.SystemConst;
import io.ebean.Model;
import io.ebean.annotation.SoftDelete;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import io.ebean.annotation.WhoModified;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 实体基类
 *
 * @author CPoet
 */
@Data
@MappedSuperclass
public abstract class BaseModel extends Model {
    /**
     * 实体id
     */
    @Id
    @GeneratedValue(generator = SystemConst.EBEAN_ID_GRT_NAME)
    private Long id;

    /**
     * 版本
     */
    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    /**
     * 最后操作的用户id
     */
    @WhoModified
    @Column(name = "last_mod_staff", nullable = false)
    private Long lastModStaff;

    /**
     * 软删除
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

    /**
     * 更新时间
     */
    @WhenModified
    @Column(name = "updated_time", nullable = false)
    private LocalDateTime updatedTime;
}
