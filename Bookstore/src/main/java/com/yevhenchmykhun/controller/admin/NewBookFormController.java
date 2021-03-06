package com.yevhenchmykhun.controller.admin;

import com.yevhenchmykhun.dao.DaoFactory;
import com.yevhenchmykhun.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/newbookform")
public class NewBookFormController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        List<Category> categories = (List<Category>) getServletContext().getAttribute("categories");
        if (categories == null) {
            categories = new DaoFactory().getCategoryDao().findAll();
        }

        request.setAttribute("categories", categories);

        String url = "/admin/view/addbook.jsp";
        request.getRequestDispatcher(url).forward(request, response);

    }
}
