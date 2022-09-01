package practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet5")
public class TestServlet5 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 会社のホームページへ一時的リダイレクトさせる。
        response.sendRedirect("http://www.opst.co.jp/");

        // リダイレクトには2種類（恒久的:301と一時的:302,307）あります。
        // 使い分けたい時はsetStatusメソッド・setHeaderメソッドを使いましょう。
        //response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY); // 301:恒久的
        //response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY); // 302:一時的
        //response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT); // 307:一時的
        //response.setHeader("Location", "http://www.opst.co.jp/");
    }
}
