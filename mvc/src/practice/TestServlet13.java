package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet13")
public class TestServlet13 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 送信されてきたCookieを取得する。
        Cookie[] cookies = request.getCookies();

        // HTMLを返却する（Cookieの内容を表示）。
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Cookieの取得</title></head><body>");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println(cookie.getName() + "=" + cookie.getValue() + "<br>");
            }
        }
        out.println("</body></html>");
    }
}
