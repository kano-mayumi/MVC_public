package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet3")
public class TestServlet3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // （サーバが受信した）リクエストの文字列のエンコーディング
        request.setCharacterEncoding("UTF-8"); // エンコーディングをUTF-8に指定（フォームのHTMLと同じエンコード）
        //        request.setCharacterEncoding("Shift_JIS"); // エンコーディングをShift_JISに指定（間違ってみる）

        // （サーバが送信する）レスポンスのコンテントタイプ、エンコーディング
        response.setContentType("text/html; charset=UTF-8");
        //        response.setCharacterEncoding("Shift_JIS"); // 上記のcharsetの指定を上書きする。
        //        response.setContentType("text/plain; charset=Shift_JIS"); // 普通のテキスト（≠HTML）にして送ってみる。
        // 以下のようにsetHeaderメソッドを利用することもできますが
        // 専用メソッドがある場合はそちらを利用しましょう。
        //        response.setHeader("Content-Type","text/html; charset=UTF-8");

        // パラメータ（クエリー）の値を取得する。
        String id = request.getParameter("id");
        String firstname = request.getParameter("firstname");

        // リモートIPアドレスを取得する。
        String remoteaddr = request.getRemoteAddr();

        // HTMLを返却する。
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>パラメータ部分を取得</title></head><body>");
        out.println("id: " + id + "<br>");
        out.println("firstname: " + firstname + "<br><br>");
        out.println("リモートIPアドレス: " + remoteaddr + "<br>");
        out.println("</body></html>");

        // 動作確認用コンソール出力
        System.out.println("TestServlet3 doGet() ID:" + id);
        System.out.println("TestServlet3 doGet() FIRST_NAME:" + firstname);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
