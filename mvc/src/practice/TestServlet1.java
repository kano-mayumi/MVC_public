package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet1")
//@WebServlet(urlPatterns = { "/TestServlet1", "/TestServletX" })
//@WebServlet(name = "FirstServlet", urlPatterns = { "/TestServlet1" })
public class TestServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>最初のサーブレット</title></head><body>");
        out.println("Hello World.");

        //        out.flush();  // 明示的にFLUSHする。⇒Webブラウザに出力する。
        //        try {
        //            Thread.sleep(5000L); // 5秒待つ
        //        } catch (InterruptedException ie) {
        //            // do nothing.
        //        }
        //        out.println("Hello World.");

        //        out.println("<br>outオブジェクトの実態クラス：" + out.getClass().getName());

        //        out.println("<br>サーブレットの名前：" + getServletName());
        //        out.println("<br>ＵＲＬパターン：" + request.getServletPath());

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
