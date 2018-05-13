package by.itacademy.servlet;

import by.itacademy.entity.User;
import by.itacademy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userlist")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> users = UserService.getInstance().findAll();
        req.setAttribute("user", users);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/userlist.jsp")
                .forward(req, resp);
    }
}
