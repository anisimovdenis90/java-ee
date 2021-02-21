package com.anisimovdenis;

import com.anisimovdenis.persist.User;
import com.anisimovdenis.persist.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        userRepository = (UserRepository) getServletContext().getAttribute("userRepository");
        if (userRepository == null) {
            throw new ServletException("UserRepository not initialized");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = parseId(req.getParameter("id"), resp);
        final User user = new User(
                id,
                req.getParameter("firstname"),
                req.getParameter("lastname"),
                req.getParameter("email"),
                req.getParameter("birthday"),
                req.getParameter("phone")
        );
        userRepository.saveOrUpdate(user);
        resp.sendRedirect(getServletContext().getContextPath() + "/user");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getPathInfo() == null || req.getPathInfo().equals("/")) {
            req.setAttribute("users", userRepository.findAll());
            getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(req, resp);
        } else if (req.getPathInfo().equals("/edit")) {
            Long id = parseId(req.getParameter("id"), resp);
            if (id == null) {
                return;
            }
            final User user = userRepository.findById(id);
            if (user == null) {
                resp.setStatus(404);
                return;
            }
            req.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/WEB-INF/user_form.jsp").forward(req, resp);
        } else if (req.getPathInfo().equals("/create")) {
            getServletContext().getRequestDispatcher("/WEB-INF/user_form.jsp").forward(req, resp);
        } else if (req.getPathInfo().equals("/delete")) {
            Long id = parseId(req.getParameter("id"), resp);
            if (id == null) {
                return;
            }
            userRepository.deleteById(id);
            resp.sendRedirect(getServletContext().getContextPath() + "/user");
        }
    }

    private Long parseId(String stringId, HttpServletResponse response) {
        Long id = null;
        try {
            id = Long.parseLong(stringId);
        } catch (NumberFormatException e) {
            response.setStatus(400);
        }
        return id;
    }
}
