package practice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet10")
public class TestServlet10 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // アプリケーション・スコープのServletContextからリクエスト転送用インスタンスを取得する。
        ServletContext context = getServletContext();
        RequestDispatcher rd = null;
        //rd = context.getRequestDispatcher("/TestServlet1");
        rd = context.getNamedDispatcher("FirstServlet");

        // リクエストを転送（フォワード）する。
        rd.forward(request, response);
    }
}
