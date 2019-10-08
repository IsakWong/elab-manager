package elab.network;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;
import java.util.Properties;

public class NetworkSession {

    public static void main(String[] args) {

        String URL = "ldap://192.168.1.40:389/";
        String FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
        String adminName = "ELAB\\yx";
        String adminPwd = "awd153";
        LdapContext ctx = null;
        Hashtable env = null;
        Control[] connCtls = null;

        try {
            env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY,FACTORY);
            env.put(Context.PROVIDER_URL, URL);//LDAP server
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, adminName);
            env.put(Context.SECURITY_CREDENTIALS, adminPwd);

            ctx = new InitialLdapContext(env, connCtls);
            // 域节点
            String searchBase = "OU=ELAB,DC=elab,DC=dlut,DC=edu,DC=cn";
            // LDAP搜索过滤器类
            String searchFilter = "objectClass=User";
            // 搜索控制器
            SearchControls searchCtls = new SearchControls(); // Create the
            // search
            // controls
            // 创建搜索控制器
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE); // Specify
            // the
            // search
            // scope
            // 设置搜索范围
            // searchCtls.setSearchScope(SearchControls.OBJECT_SCOPE); //
            // Specify the search scope 设置搜索范围
//   String returnedAtts[] = { "memberOf", "distinguishedName",
//     "Pwd-Last-Set", "User-Password", "cn" };// 定制返回属性
            String returnedAtts[] = { "company" };// 定制返回属性

            // String returnedAtts[] = { "url", "whenChanged", "employeeID",
            // "name", "userPrincipalName", "physicalDeliveryOfficeName",
            // "departmentNumber", "telephoneNumber", "homePhone",
            // "mobile", "department", "sAMAccountName", "whenChanged",
            // "mail" }; // 定制返回属性
            searchCtls.setReturningAttributes(returnedAtts); // 设置返回属性集
            // 根据设置的域节点、过滤器类和搜索控制器搜索LDAP得到结果
            NamingEnumeration answer = ctx.search(searchBase, searchFilter,
                    searchCtls);// Search for objects using the filter
            // 初始化搜索结果数为0
            int totalResults = 0;// Specify the attributes to return
            int rows = 0;
            while (answer.hasMoreElements()) {// 遍历结果集
                SearchResult sr = (SearchResult) answer.next();// 得到符合搜索条件的DN
                System.out.println(++rows
                        + "************************************************");

                String dn = sr.getName();
                System.out.println(dn);
                String match = dn.split("CN=")[1].split(",")[0];//返回格式一般是CN=ptyh,OU=专卖
                System.out.println(match);
               /* if(userName.equals(match)){
                    Attributes Attrs = sr.getAttributes();// 得到符合条件的属性集
                    if (Attrs != null) {
                        try {
                            for (NamingEnumeration ne = Attrs.getAll(); ne.hasMore();) {
                                Attribute Attr = (Attribute) ne.next();// 得到下一个属性
                                System.out.println(" AttributeID=属性名："+ Attr.getID().toString());
                                // 读取属性值
                                for (NamingEnumeration e = Attr.getAll(); e.hasMore(); totalResults++) {
                                    company =  e.next().toString();
                                    System.out.println("    AttributeValues=属性值：" + company);
                                }
                                System.out.println("    ---------------");

                            }
                        } catch (NamingException e) {
                            System.err.println("Throw Exception : " + e);
                        }
                    }//if
                }*/
            }//while
            System.out.println("************************************************");
            System.out.println("Number: " + totalResults);
            ctx.close();
//此处若不指定用户名和密码,则自动转换为匿名登录

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
