package cn.cpoet.mt.model.entity.constant;

import io.ebean.annotation.Platform;
import io.ebean.config.dbplatform.DbType;

import javax.persistence.Column;

/**
 * 数据字段类型定义
 *
 * @author CPoet
 */
public interface DbTypeConst {
    /**
     * oracle-clob
     *
     * @see DbType#CLOB
     */
    String CLOB = "CLOB";

    /**
     * mysql-text
     * <p>
     * 注意：这里是为兼容DDL的生成统一类型，CLOB会对应MYSQL下的LongText。
     * 如果确定数据库平台类型，可以人为干预字段类型。见{@link Column#columnDefinition()}
     * </p>
     * <p>
     * 代码层面的兼容处理可以使用{@link io.ebean.config.PlatformConfig#addCustomMapping(DbType, String, Platform)}，该方法存在
     * 局限性。
     * </p>
     */
    String TEXT = CLOB;
}
