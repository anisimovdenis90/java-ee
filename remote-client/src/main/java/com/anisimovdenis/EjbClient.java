package com.anisimovdenis;

import com.anisimovdenis.service.CategoryServiceRemote;
import com.anisimovdenis.service.ProductServiceRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;

public class EjbClient {

    public static void main(String[] args) throws NamingException, IOException {
        Context context = createInitialContext();

        String jndiProductServiceName = "ejb:/first-jsf-app/ProductServiceImpl!com.anisimovdenis.service.ProductServiceRemote";
        String jndiCategoryServiceName = "ejb:/first-jsf-app/CategoryServiceImpl!com.anisimovdenis.service.CategoryServiceRemote";
        String jndiUserServiceName = "ejb:/first-jsf-app/UserServiceImpl!com.anisimovdenis.service.UserServiceRemote";

        ProductServiceRemote productService = (ProductServiceRemote) context.lookup(jndiProductServiceName);
        CategoryServiceRemote categoryService = (CategoryServiceRemote) context.lookup(jndiCategoryServiceName);

        productService.findAll().
                forEach(p -> System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getPrice()));
        categoryService.findAll().
                forEach(c -> System.out.println(c.getId() + "\t" + c.getName() + "\t" + c.getProductList()));
    }

    public static Context createInitialContext() throws IOException, NamingException {
        final Properties env = new Properties();
        env.load(EjbClient.class.getResourceAsStream("/wildfly-jndi.properties"));
        return new InitialContext(env);
    }
}
