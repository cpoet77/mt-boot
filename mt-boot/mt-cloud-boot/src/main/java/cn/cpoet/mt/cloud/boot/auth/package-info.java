/**
 * 微服务认证支持
 * <div>
 * 微服务认证支持有两个维度：
 * <ol>
 *     <li>网关维度：解析JWT并加载用户信息和权限信息并写入请求头中。</li>
 *     <li>微服务维度：解析网关设置的用户信息和权限信息。</li>
 * </ol>
 * </div>
 *
 * @author CPoet
 */
package cn.cpoet.mt.cloud.boot.auth;