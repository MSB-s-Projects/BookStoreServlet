package com.msb.bookstoreservlet.helloworldcontroller;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    private final Map<String, String> message = new HashMap<>();
    private final transient Gson gson = new Gson();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        getServletContext().log("Get Request Received");

        message.put("message", "Hello, World!");
        String json = gson.toJson(message);

        response.setContentType("application/json");
        try {
            response.getWriter().print(json);
        } catch (Exception e) {
            log(e.getMessage());
        }
    }

}
