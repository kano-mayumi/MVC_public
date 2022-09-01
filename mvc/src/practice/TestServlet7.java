package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet7")
public class TestServlet7 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 初期化パラメータ名
    private static final String PARAM_NAME = "company";

    // 初期化パラメータ
    private String param = null;

    @Override
    public void init() {
        // 初回リクエスト時にインスタンス化された際に1回だけ実行される
        // 一般的にサーブレットを何らかの初期化をする必要がある場合に、ここで処理を行う。

        // 全サーブレットの初期化パラメータを取得する。
        ServletContext context = getServletContext();
        this.param = context.getInitParameter(PARAM_NAME);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // HTMLを返却する。
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>初期化パラメータの利用（ServletContext）</title></head><body>");
        out.println("ServletContext " + PARAM_NAME + "=" + this.param);
        out.println("</body></html>");
    }
}
