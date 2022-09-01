package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet2")
public class TestServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        // HTTPリクエストの1行目を取得する。
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String query = request.getQueryString();
        String protocol = request.getProtocol();

        // WEBブラウザで指定されたURLを取得する。
        // パラメータ（クエリー）は取得出来ません。
        String url = request.getRequestURL().toString();

        // HTTPリクエストのUser-Agentを取得する。
        // 引数にヘッダ名を指定することで文字列で取得出来る。
        String ua = request.getHeader("User-Agent");

        // WEBアプリの情報を取得する。
        String contextpath = request.getContextPath(); // コンテキストパス
        String servletpath = request.getServletPath(); // サーブレットパス

        // HTMLを返却する。
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>HTTPリクエストヘッダを取得</title></head><body>");
        out.println("[リクエストライン] HTTPメソッド: " + method + "<br>");
        out.println("[リクエストライン] URI: " + uri + "<br>");
        out.println("[リクエストライン] GETのパラメータ（クエリー） :" + query + "<br>");
        out.println("[リクエストライン] プロトコル: " + protocol + "<br><br>");
        out.println("URL: " + url + "<br><br>");
        out.println("[その他HTTPヘッダ] User-Agent: " + ua + "<br><br>");
        out.println("[WEBアプリ] コンテキストパス: " + contextpath + "<br>");
        out.println("[WEBアプリ] サーブレットパス: " + servletpath + "<br>");
        out.println("</body></html>");
    }
}
