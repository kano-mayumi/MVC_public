package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet6")
public class TestServlet6 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static {
        // クラスがロードされた際に1回だけ実行される
        System.out.println("TestServlet6 static クラスがロードされた際に1回だけ実行");
    }

    @Override
    public void init() {
        // 初回リクエスト時にインスタンス化された際に1回だけ実行される
        // 一般的にサーブレットを何らかの初期化をする必要がある場合に、ここで処理を行う。
        System.out.println("TestServlet6 init() 初回リクエスト時にインスタンス化された際に1回だけ実行");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("TestServlet6 doGet() 通常の処理を実行");

        // リクエスト時にGETである場合、serviceメソッドから自動的に呼び出される。
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>サーブレットのライフサイクル</title></head><body>");
        out.println("TestServlet6 doGet() 通常の処理を実行");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("TestServlet6 doPost() 通常の処理を実行");

        // リクエスト時にPOSTである場合、serviceメソッドから自動的に呼び出される。
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>サーブレットのライフサイクル</title></head><body>");
        out.println("TestServlet6 doPost() 通常の処理を実行");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        // サーブレットコンテナ終了直前に1回だけ実行される
        System.out.println("TestServlet6 destroy() サーブレットコンテナ終了直前に1回だけ実行");
    }
}
