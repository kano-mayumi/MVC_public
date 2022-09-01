package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TestServlet14")
public class TestServlet14 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // HttpSessionインスタンスを取得する。
        // セッションIDが関連づいているもの or 関連づいていなければ新規作成
        HttpSession session = request.getSession(true);

        // セッションから属性を取得する。
        Integer value = (Integer) session.getAttribute("counter");
        if (value == null) {
            // まだ属性が設定されていなければ新規に登録する。
            value = Integer.valueOf(0);
            session.setAttribute("counter", value);
        }

        // セッションから取得した属性に対して何らかの操作をして設定する。
        int counter = value.intValue();
        counter++;
        session.setAttribute("counter", Integer.valueOf(counter));

        // HTMLを返却する。
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>セッション管理</title></head><body>");
        out.println("counter=" + counter + "<br><br>");

        out.println("<a href=\"/mvc/TestServlet14\">再読み込み（属性値をカウントアップ）</a><br>");
        out.println("<a href=\"/mvc/TestServlet16\">ログアウト（セッションIDが関連づいているHttpSessionインスタンスを破棄）</a><br>");
        out.println("<a href=\"/mvc/TestServlet17\">有効期間変更（初期値の1800秒から20秒へ）</a><br>");

        out.println("</body></html>");
    }
}
