package com.example.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session2")
public class Session2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<html>" +
                "<body>" +
                "<form action=\"/session2\" method=\"get\">" +
                "<input name=\"ocena\" type=\"text\" />" +
                "<button type=\"submit\">Send</button>" +
                "</form>" +
                "</body>" +
                "</html>");
        resp.getWriter().println("------------------------------------");

        HttpSession session = req.getSession();

        if (session.isNew()) {
            session.setAttribute("oceny", new ArrayList<Integer>());
        } else {
            List<Integer> oceny = (ArrayList<Integer>) session.getAttribute("oceny");
            Integer ocena = Integer.parseInt(req.getParameter("ocena"));
            oceny.add(ocena);
            session.setAttribute("oceny", oceny);
            Integer sumaOcen = 0;

            for (Integer o : oceny) {
                sumaOcen += o;
                resp.getWriter().println("<br/>Ocena: " + o);
            }
            resp.getWriter().println("<br/>Srednia: " + (double)sumaOcen / oceny.size());
        }
    }
}
