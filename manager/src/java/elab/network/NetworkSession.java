package elab.network;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;
import java.util.Properties;

public class NetworkSession {

    public static void main(String[] args) {

        String URL = "ldap://10.8.128.204:389/";
        String BASEDN = "";
        String FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
        LdapContext ctx = null;
        Hashtable env = null;
        Control[] connCtls = null;

        try {
            env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY,FACTORY);
            env.put(Context.PROVIDER_URL, URL+BASEDN);//LDAP server
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            ctx = new InitialLdapContext(env, connCtls);
            System.out.println("yes");
//此处若不指定用户名和密码,则自动转换为匿名登录

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
