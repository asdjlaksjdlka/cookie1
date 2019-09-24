package com.qf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String html = "";
        String sid = request.getQueryString();
        sid = sid.substring(3);//截取id=2 得到2
        //System.out.println(sid+"浏览的id");
        ProductDaoImpl dao = new ProductDaoImpl();
        List<Product> list = dao.findAll();
        Product product = null;
        //找id相同的产品
        for (Product p : list) {
            if (sid.equals(p.getId())) {
                product = p;
                break;
            }
        }
        html += "<html>";
        html += "<head>";
        html += "<title>显示商品详细</title>";
        html += "</head>";
        html += "<body>";
        html += "<table border='1' align='center' width='300px'>";
        if (product != null) {
            html += "<tr><th>编号:</th><td>" + product.getId() + "</td></tr>";
            html += "<tr><th>商品名称:</th><td>" + product.getProName() + "</td></tr>";
            html += "<tr><th>商品型号:</th><td>" + product.getProType() + "</td></tr>";
            html += "<tr><th>商品价格:</th><td>" + product.getPrice() + "</td></tr>";
        }
        html += "</table>";
        html += "<center><a href='" + request.getContextPath() + "/ListServlet'>[返回列表]</a></center>";
        html += "</body>";
        html += "</html>";
        writer.write(html);
        Cookie cookie = new Cookie("product", result(request, sid));
        response.addCookie(cookie);

    }


    public String result(HttpServletRequest req,String id){

        if()

        return id ;
    }
}

