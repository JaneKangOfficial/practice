package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ApplicationScope01")
public class ApplicationScope01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApplicationScope01() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		// 응답 통로 
		PrintWriter out = response.getWriter();
		
		// Application Scope 생성 
		ServletContext application = getServletContext();
		int value = 1;
		// 값 저장 
		application.setAttribute("value", value);
		
		out.println("<h1>value : " + value + "</h1>");
		
	}

}
