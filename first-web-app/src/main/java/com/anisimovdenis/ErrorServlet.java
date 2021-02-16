package com.anisimovdenis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/error_servlet")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int status = resp.getStatus();
        String message = "";
        if (status == 404) {
            message = "Указан неверный адрес";
        } else if (status == 403) {
            message = "Нет прав доступа";
        }
        resp.getWriter().println("<h1>Статус: " + status + " - " + message + "</h1>");
    }
}
