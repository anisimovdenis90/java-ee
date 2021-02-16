package com.anisimovdenis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(urlPatterns = "/nav_menu")
public class MenuServlet extends HttpServlet {

    private final String string = "<head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n" +
            "          integrity=\"sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1\" crossorigin=\"anonymous\">\n" +
            "\n" +
            "    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js\"\n" +
            "            integrity=\"sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU\" crossorigin=\"anonymous\"></script>\n" +
            "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js\"\n" +
            "            integrity=\"sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj\" crossorigin=\"anonymous\"></script>\n" +
            "</head>\n";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(string);

        resp.getWriter().println("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">");
        resp.getWriter().println("<div class=\"container-fluid\">");
        resp.getWriter().println("<div class=\"collapse navbar-collapse\" id=\"navbarNav\">");
        resp.getWriter().println("<ul class=\"navbar-nav\">");
        resp.getWriter().println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"" + req.getContextPath() + "/main\">Главная</a></li>");
        resp.getWriter().println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"" + req.getContextPath() + "/catalog\">Каталог</a></li>");
        resp.getWriter().println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"" + req.getContextPath() + "/cart\">Корзина</a></li>");
        resp.getWriter().println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"" + req.getContextPath() + "/product\">Продукт</a></li>");
        resp.getWriter().println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"" + req.getContextPath() + "/order\">Заказы</a></li>");
        resp.getWriter().println("</div>");
        resp.getWriter().println("</div>");
        resp.getWriter().println("</nav>");
    }
}
