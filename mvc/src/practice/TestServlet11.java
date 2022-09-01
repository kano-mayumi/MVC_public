package practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet11")
public class TestServlet11 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // リクエスト・スコープのHttpServletRequestからリクエスト転送用インスタンスを取得する。
        RequestDispatcher rd = request.getRequestDispatcher("/TestServlet1");

        // リクエストを転送（フォワード）する。
        rd.forward(request, response);
    }
}
