package cn.cpoet.mt.single;

import cn.cpoet.mt.api.constant.SystemConst;
import cn.cpoet.mt.db.tenant.TenantDb;
import cn.cpoet.mt.db.tenant.TenantDbContext;
import cn.cpoet.mt.model.domain.StaffRole;
import cn.cpoet.mt.model.domain.query.QStaffRole;
import io.ebean.Database;
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

    @Test
    public void tenantTest() {
        TenantDbContext instance = TenantDbContext.getInstance();
//        Database master = instance.getMaster(SystemConst.SYS_TENANT_ID);
//        Database salve = instance.getSalve(SystemConst.SYS_TENANT_ID);

        StaffRole staffRole = new StaffRole();
        staffRole.setStaffId(-1L);
        staffRole.setRoleId(-1L);
        staffRole.setDeleted(Boolean.FALSE);
//        master.save(staffRole);
        staffRole.save();

        System.out.println(staffRole);

//        StaffRole one = new QStaffRole(salve)
//            .id.eq(staffRole.getId())
//            .findOne();

        System.out.println(TenantDb
            .agent(QStaffRole::new)
            .id.eq(staffRole.getId())
            .findOne());

        System.out.println(TenantDb
            .agent(QStaffRole.class)
            .id.eq(staffRole.getId())
            .findOne());

    }
}
