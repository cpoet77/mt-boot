package cn.cpoet.mt.single;

import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * 数据库DDL生成和执行
 *
 * @author CPoet
 * @see io.ebeaninternal.dbmigration.DdlGenerator
 * @see DbMigration
 * @see io.ebean.ddlrunner.DdlRunner
 */
@SpringBootTest
public class DBMigrationTest {
    /**
     * 生成DDL-SQL
     *
     * @throws IOException IO异常
     */
    @Test
    public void ddlGrtSql() throws IOException {
        DbMigration dbMigration = DbMigration.create();
        dbMigration.addPlatform(Platform.MYSQL);
        dbMigration.addPlatform(Platform.ORACLE);
        dbMigration.setVersion("1.0.0");
        dbMigration.generateMigration();
    }
}
