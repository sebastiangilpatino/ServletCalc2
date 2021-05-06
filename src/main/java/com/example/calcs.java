package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calcs", value = "/calcs")
public class calcs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double num1Sum = null, num2Sum = null, num1Multi = null, num2Multi = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sum1Str = request.getParameter("sum1");
        String sum2Str = request.getParameter("sum2");
        String multi1Str = request.getParameter("multi1");
        String multi2Str = request.getParameter("multi2");
        String multiply = "";
        String sum = "";

        if (sum1Str.length() > 0 && sum2Str.length() > 0) {
            try {
                num1Sum = Double.parseDouble(sum1Str);
                num2Sum = Double.parseDouble(sum2Str);
            } catch (NumberFormatException e) {
                num1Sum = null;
                num2Sum = null;
            }
        }

        if (multi1Str.length() > 0 && multi2Str.length() > 0) {
            try {
                num1Multi = Double.parseDouble(multi1Str);
                num2Multi = Double.parseDouble(multi2Str);
            } catch (NumberFormatException e) {
                num1Multi = null;
                num2Multi = null;
            }
        }

        out.println("<html><body>");
        out.println("<form action='calcs' method='GET'>");
        if (num1Sum != null && num2Sum != null) {
            sum = String.valueOf(num1Sum + num2Sum);
            out.println("<div>");
            out.println("<input type='text' name='sum1' value=" + sum1Str + ">");
            out.println("+");
            out.println("<input type='text' name='sum2' value=" + sum2Str + ">");
            out.println("=");
            out.println("<input type='text' name='sum' value=" + sum + ">");
            out.println("<div/>");
        }else{
            out.println("<div>");
            out.println("<input type='text' name='sum1' >");
            out.println("+");
            out.println("<input type='text' name='sum2' >");
            out.println("=");
            out.println("<input type='text' name='sum' >");
            out.println("<div/>");
        }

        if (num1Multi != null && num2Multi != null) {
            multiply = String.valueOf(num1Multi * num2Multi);
            out.println("<div>");
            out.println("<input type='text' name='multi1' value=" + multi1Str + ">");
            out.println("*");
            out.println("<input type='text' name='multi2' value=" + multi2Str + ">");
            out.println("=");
            out.println("<input type='text' name='sum' value=" + multiply + ">");
            out.println("<div/>");
        }else{
            out.println("<div>");
            out.println("<input type='text' name='multi1' >");
            out.println("*");
            out.println("<input type='text' name='multi2' >");
            out.println("=");
            out.println("<input type='text' name='sum' >");
            out.println("<div/>");
        }

        out.println("<input type='submit'></form>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
