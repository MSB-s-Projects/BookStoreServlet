package com.msb.bookstoreservlet;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    private final Map<String, String> message = new HashMap<>();

    @Override
    public void init() {
        getServletContext().log("Servlet Initialized");
        message.put("message", "Hello World!");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        getServletContext().log("Get Request Received");
        response.setContentType("application/json");
        Gson gson = new Gson();
        String json = gson.toJson(message);
        try {
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        } catch (Exception e) {
            log(e.getMessage());
        }
    }

}
