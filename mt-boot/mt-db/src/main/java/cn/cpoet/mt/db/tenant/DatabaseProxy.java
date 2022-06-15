package cn.cpoet.mt.db.tenant;

import io.ebean.Database;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * {@link Database}代理，便于后期拓展
 *
 * @author CPoet
 */
@RequiredArgsConstructor
public class DatabaseProxy implements MethodInterceptor {

    private final Database thisDb;

    /**
     * 创建代理
     *
     * @param database 目标
     * @return 代理
     */
    public static Database proxy(Database database) {
        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(new Class[]{Database.class});
        enhancer.setCallback(new DatabaseProxy(database));
        return (Database) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invoke(thisDb, objects);
    }
}
