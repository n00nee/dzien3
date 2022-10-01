package com.example.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet("/post2")
public class Form2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userText = req.getParameter("userText");
        String agreement = req.getParameter("agreement"); // true

        ArrayList<String> swearing = new ArrayList<>();
        swearing.add("cholera");
        swearing.add("dupa");

        if (Objects.nonNull(agreement)) {
            resp.getWriter().println(userText);
        } else {
            for (String swear : swearing) {
                userText = userText.replaceAll(
                        swear, swear.replaceAll("[a-zA-Z]", "*"));
            }
            resp.getWriter().append(userText);
        }
    }
}
