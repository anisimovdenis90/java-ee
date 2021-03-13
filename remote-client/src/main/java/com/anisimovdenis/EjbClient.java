package com.anisimovdenis;

import com.anisimovdenis.service.ProductServiceRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;

public class EjbClient {

    public static void main(String[] args) throws NamingException, IOException {
        Context context = createInitialContext();

        String jndiServiceName = "ejb:/first-jsf-app/ProductServiceImpl!com.anisimovdenis.service.ProductServiceRemote";
        ProductServiceRemote productService = (ProductServiceRemote) context.lookup(jndiServiceName);

        productService.findAll().
                forEach(p -> System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getPrice()));
    }

    public static Context createInitialContext() throws IOException, NamingException {
        final Properties env = new Properties();
        env.load(EjbClient.class.getResourceAsStream("/wildfly-jndi.properties"));
        return new InitialContext(env);
    }
}
