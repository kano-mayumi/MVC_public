package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/TestServlet8" }, initParams = { @WebInitParam(name = "address", value = "Tokyo") })
public class TestServlet8 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 初期化パラメータ名
    private static final String PARAM_NAME = "address";

    // 初期化パラメータ
    private String param = null;

    @Override
    public void init() {
        // 初回リクエスト時にインスタンス化された際に1回だけ実行される
        // 一般的にサーブレットを何らかの初期化をする必要がある場合に、ここで処理を行う。

        // このサーブレットの初期化パラメータを取得する。
        ServletConfig config = getServletConfig();
        this.param = config.getInitParameter(PARAM_NAME);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // HTMLを返却する。
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>初期化パラメータの利用（ServletConfig）</title></head><body>");
        out.println("ServletConfig " + PARAM_NAME + "=" + this.param);
        out.println("</body></html>");
    }
}
