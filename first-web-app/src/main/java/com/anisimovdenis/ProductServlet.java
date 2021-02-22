package com.anisimovdenis;

import com.anisimovdenis.persist.CategoryRepository;
import com.anisimovdenis.persist.Product;
import com.anisimovdenis.persist.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
        categoryRepository = (CategoryRepository) getServletContext().getAttribute("categoryRepository");
        if (productRepository == null || categoryRepository == null) {
            throw new ServletException("Repository not initialized");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = parseId(req.getParameter("id"), resp);
        Long categoryId = parseId(req.getParameter("categoryId"), resp);
        BigDecimal price = parsePrice(req.getParameter("price"), resp);
        if (price == null) {
            return;
        }
        final Product product = new Product(id, req.getParameter("name"), req.getParameter("description"), price, categoryId);
        productRepository.saveOrUpdate(product);
        resp.sendRedirect(getServletContext().getContextPath() + "/product");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(req.getPathInfo());
        if (req.getPathInfo() == null || req.getPathInfo().equals("/")) {
            req.setAttribute("products", productRepository.findAll());
            req.setAttribute("categories", categoryRepository.findAll());
            getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").forward(req, resp);
        } else if (req.getPathInfo().equals("/edit")) {
            Long id = parseId(req.getParameter("id"), resp);
            if (id == null) {
                return;
            }
            final Product product = productRepository.findById(id);
            if (product == null) {
                resp.setStatus(404);
                return;
            }
            req.setAttribute("product", product);
            req.setAttribute("categories", categoryRepository.findAll());
            getServletContext().getRequestDispatcher("/WEB-INF/product_form.jsp").forward(req, resp);
        } else if (req.getPathInfo().equals("/create")) {
            req.setAttribute("categories", categoryRepository.findAll());
            req.setAttribute("product", new Product());
            getServletContext().getRequestDispatcher("/WEB-INF/product_form.jsp").forward(req, resp);
        } else if (req.getPathInfo().equals("/delete")) {
            Long id = parseId(req.getParameter("id"), resp);
            if (id == null) {
                return;
            }
            productRepository.deleteById(id);
            resp.sendRedirect(getServletContext().getContextPath() + "/product");
        }
    }

    private Long parseId(String stringId, HttpServletResponse response) {
        Long id = null;
        try {
            if (stringId != null && !stringId.isBlank()) {
                id = Long.parseLong(stringId);
            }
        } catch (NumberFormatException e) {
            response.setStatus(400);
        }
        return id;
    }

    private BigDecimal parsePrice(String stringPrice, HttpServletResponse response) {
        BigDecimal price = null;
        try {
            price = new BigDecimal(stringPrice);
        } catch (NumberFormatException e) {
            response.setStatus(400);
        }
        return price;
    }
}
