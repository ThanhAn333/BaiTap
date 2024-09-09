package vn.iostar.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/hello", "/hi"})
public class HelloWorld extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "hello";
        String y = "2024";

        String namey = name + " " + y;
        resp.setContentType("text/html"); // Đã chỉnh sửa để chính xác
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><h1>" + namey + "</h1></body></html>"); // Đã bổ sung cấu trúc HTML cơ bản
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Xử lý POST nếu cần
    }
}
