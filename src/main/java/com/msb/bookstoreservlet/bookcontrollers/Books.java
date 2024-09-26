package com.msb.bookstoreservlet.bookcontrollers;

import com.google.gson.Gson;
import com.msb.bookstoreservlet.Book;
import com.msb.bookstoreservlet.BookService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class Books extends HttpServlet {
    private final transient Gson gson = new Gson();
    private final transient BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {

            resp.setContentType("application/json");
            resp.getWriter().print(gson.toJson(bookService.getBooks()));
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            getServletContext().log("Error while fetching books", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {

            StringBuilder sb = new StringBuilder();
            req.getReader().lines().forEach(sb::append);
            bookService.addBook(gson.fromJson(sb.toString(), Book.class));
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.setContentType("application/json");
            resp.getWriter().print(gson.toJson(bookService.getBooks()));
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            getServletContext().log("Error while adding book", e);
        }
    }
}
