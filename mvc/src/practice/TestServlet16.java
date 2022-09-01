package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestServlet16")
public class TestServlet16 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // HttpSessionインスタンスを取得する。
        // セッションIDが関連づいているもの or 関連づいていなければnull
        HttpSession session = request.getSession(false);

        // HttpSessionインスタンスを無効化する。
        if (session != null) {
            session.invalidate();
        }

        // HTMLを返却する。
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>セッション管理</title></head><body>");

        out.println("<a href=\"/mvc/TestServlet14\">初期表示</a><br>");

        out.println("</body></html>");
    }
}
