package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet12")
public class TestServlet12 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 保持する属性（名前・値）を指定してCookieを作成する。
        Cookie cookie1 = new Cookie("country", "Japan");
        Cookie cookie2 = new Cookie("city", "Tokyo");

        // 有効期限（秒数）を設定する。
        // 正数：指定した秒数まで有効
        // 負数：WEBブラウザ終了時まで有効
        cookie1.setMaxAge(3600);
        cookie2.setMaxAge(-1);

        // 他の設定値
        //cookie2.setDomain("www.opst.co.jp"); // ドメイン
        //cookie2.setPath("/mvc"); // パス
        //cookie2.setSecure(false); // セキュア

        // レスポンスにCookieを設定する。
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        // HTMLを返却する。
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Cookieの作成</title></head><body>");
        out.println("countryとcityというCookieを作成しました。<br>");
        out.println("<a href=\"/mvc/TestServlet13\">Cookieの取得</a><br>");
        out.println("</body></html>");
    }
}
