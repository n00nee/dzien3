package com.example.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post1")
public class Form1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        resp.addHeader("Accept-Encoding", "UTF-8");
        resp.getWriter().append("Witaj, " + firstName + " " + lastName);
    }

    //    W projekcie stwórz servlet Form1 , dostępny pod adresem /post1 oraz stronę HTML form1.html,
//    w której zawarty jest formularz przesyłający imię i nazwisko. Po uruchomieniu na serwerze
//    i uzupełnieniu formularza w przeglądarce wyświetli się napis: Witaj, <podane imię>
//    <podane nazwisko>.


}
