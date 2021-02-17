package com.anisimovdenis.listener;

import com.anisimovdenis.persist.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductRepository productRepository = new ProductRepository();
        productRepository.saveOrUpdate(new Product(null, "Product 1", "Description of product 1", new BigDecimal(100), 1L));
        productRepository.saveOrUpdate(new Product(null, "Product 2", "Description of product 2", new BigDecimal(200), 1L));
        productRepository.saveOrUpdate(new Product(null, "Product 3", "Description of product 3", new BigDecimal(300), 2L));
        sce.getServletContext().setAttribute("productRepository", productRepository);

        UserRepository userRepository = new UserRepository();
        userRepository.saveOrUpdate(new User(null, "Bob", "Johnson", "bob@mail.com", "1990/12/05", "89994443322"));
        userRepository.saveOrUpdate(new User(null, "Den", "Dickens", "den@mail.com", "1980/10/13", "89994333120"));
        userRepository.saveOrUpdate(new User(null, "Carl", "Willis", "carl@mail.com", "1964/03/21", "899955777311"));
        sce.getServletContext().setAttribute("userRepository", userRepository);

        CategoryRepository categoryRepository = new CategoryRepository();
        categoryRepository.saveOrUpdate(new Category(null, "Category 1"));
        categoryRepository.saveOrUpdate(new Category(null, "Category 2"));
        sce.getServletContext().setAttribute("categoryRepository", categoryRepository);
    }
}
