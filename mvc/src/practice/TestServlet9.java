package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet9")
public class TestServlet9 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // アプリケーション・スコープ： ServletContext <- GenericServletのgetServletContext()で取得
        // セッション・スコープ： HttpSession <- HttpServletRequestのgetSession()で取得
        // リクエスト・スコープ： HttpServletRequest <- doGet, doPostの引数

        //        ServletContext scopeObj = getServletContext();
        //        HttpSession scopeObj = request.getSession();
        HttpServletRequest scopeObj = request;

        // リクエスト・スコープのインスタンスに属性を設定する。
        scopeObj.setAttribute("name", "Taro Yamada");

        // 同じ属性名で設定すると上書きとなる。
        scopeObj.setAttribute("name", "Ichiro Suzuki");

        // リクエスト・スコープのインスタンスから属性を取得する。
        String name1 = (String) scopeObj.getAttribute("name");

        // 取得してもインスタンスから削除される訳ではない。
        String name2 = (String) scopeObj.getAttribute("name");

        // リクエスト・スコープのインスタンスから属性を削除する。
        scopeObj.removeAttribute("name");

        // 削除した後は属性は取得できない（nullとなる）。
        String name3 = (String) scopeObj.getAttribute("name");

        // HTMLを返却する。
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>サーブレットのスコープ・情報共有</title></head><body>");
        out.println("name1=" + name1 + "<br>");
        out.println("name2=" + name2 + "<br>");
        out.println("name3=" + name3 + "<br>");
        out.println("</body></html>");
    }
}
