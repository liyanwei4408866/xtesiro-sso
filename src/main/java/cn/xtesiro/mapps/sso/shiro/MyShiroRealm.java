package cn.xtesiro.mapps.sso.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.xtesiro.mapps.sso.service.UserService;
import cn.xtesiro.mapps.sso.vo.UserInfo;

public class MyShiroRealm extends AuthorizingRealm
{
	@Resource
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
//		for (SysRole role : userInfo.getRoleList()) {
//			authorizationInfo.addRole(role.getRole());
//			for (SysPermission p : role.getPermissions()) {
//				authorizationInfo.addStringPermission(p.getPermission());
//			}
//		}
		return authorizationInfo;
	}

	/* 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。 */
    @Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
		// 获取用户的输入的账号.
        String username = (String) token.getPrincipal();
//        System.out.println(token.getCredentials());
		// 通过username从数据库中查找 User对象，如果找到，没找到.
		// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//		Example example = new Example(CommUserMapper.class);
//		example.createCriteria().andEqualTo("username", username);
		UserInfo userInfo = userService.getUserInfoByUserName(username);
//        System.out.println("----->>userInfo="+userInfo);
		if (userInfo == null) {
            return null;
        }
		if ("1".equals(userInfo.getIsDelete())) { // 账户冻结
			throw new LockedAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, // 用户名
				userInfo.getPassword(), // 密码
				getName() // realm name
        );
        return authenticationInfo;
    }

    public static void main(String[] args)
    {
        // 所需加密的参数 即 密码
        String source = "123456";
        // [盐] 一般为用户名 或 随机数
        String salt = "admin8d78869f470951332959580424d4bf4f";
        // 加密次数
		int hashIterations = 2;

        // 调用 org.apache.shiro.crypto.hash.Md5Hash.Md5Hash(Object source, Object salt, int hashIterations)构造方法实现MD5盐值加密
		Md5Hash mh = new Md5Hash(source);
        // 打印最终结果
        System.out.println(mh.toString());
		// e10adc3949ba59abbe56e057f20f883e

        /*
         * 调用org.apache.shiro.crypto.hash.SimpleHash.SimpleHash(String algorithmName, Object source, Object salt, int
         * hashIterations) 构造方法实现盐值加密 String algorithmName 为加密算法 支持md5 base64 等
         */
		SimpleHash sh = new SimpleHash("md5", source, null, hashIterations);
        // 打印最终结果
        System.out.println(sh.toString());
		if ("e10adc3949ba59abbe56e057f20f883e".equals(sh.toString()))
        {
            System.out.println("same");
        }
        else
        {
            System.out.println("no same");
        }
    }
}