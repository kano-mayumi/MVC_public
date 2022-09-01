package practice;

import java.io.IOException;
//変更した。
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//かえた
@WebServlet("/TestServlet17")
public class TestServlet17 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // HttpSessionインスタンスを取得する。
        // セッションIDが関連づいているもの or 関連づいていなければ新規作成
        HttpSession session = request.getSession(true);

        // HttpSessionインスタンスの有効期間（秒）を設定する。
        // ここでは20秒。
        session.setMaxInactiveInterval(20);

        // HTMLを返却する。
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>セッション管理</title></head><body>");

        out.println("20秒以内に再読込しないと自動的に無効化される。<br>");
        out.println("<a href=\"/mvc/TestServlet14\">再読み込み（属性値をカウントアップ）</a><br>");

        out.println("</body></html>");
    }
}
