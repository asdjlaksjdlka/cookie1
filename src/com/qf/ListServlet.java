package com.qf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置字符集和文档格式
        response.setContentType("text/html;charset=utf-8");
        //获取ProductDaoImpl对象
        ProductDaoImpl dao = new ProductDaoImpl();
        List<Product> list = dao.findAll();

        PrintWriter writer = response.getWriter();
        String html = "";
        html += "<html>";
        html += "<head>";
        html += "<title>显示商品列表</title>";
        html += "</head>";
        html += "<body>";
        html += "<table border '1' align='center' width='600px'>";
        html += "<tr>";
        html += "<th>编号</th><th>商品名称</th><th>商品型号</th><th>商品价格</th>";
        html += "</tr>";
        if (list != null) {
            for (Product p : list) {
                html += "<tr>";
                html += "<td>" + p.getId() + "</td><td><a href='" + request.getContextPath() + "/DetailServlet?id=" + p.getId() + "'>" + p.getProName() + "</a></td><td>" + p.getProType() + "</td><td>" + p.getPrice() + "</td>";
                html += "</tr>";
            }
        }
        html += "</table>";
        writer.write(html);
        Cookie[] cookies = request.getCookies();
        String sid = null;
        for (Cookie c : cookies) {
            if ("product".equals(c.getName())) {// 存在product的cookie
                sid = c.getValue();
            }
        }
        System.out.println(sid + "cookie中的id");
        if (sid!=null){//sid中已经有值
            String s = sid.substring(0, sid.length() - 1);
            String[] split = s.split("-");
            System.out.println(split.toString());
        }


    }
}