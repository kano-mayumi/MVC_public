package practice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet4")
public class TestServlet4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // HTTPレスポンスの応答ステータスを設定する。
        response.sendError(HttpServletResponse.SC_NOT_FOUND); //NOT FOUND(ページが存在しない)
        //        response.sendError(HttpServletResponse.SC_FORBIDDEN);   //FORBIDDEN(ページへのアクセス拒否)
        //        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);   //INTERNAL SERVER ERROR(内部エラー)
        // 以下のようにsetStatusメソッドを利用することもできます。
        //      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
}
