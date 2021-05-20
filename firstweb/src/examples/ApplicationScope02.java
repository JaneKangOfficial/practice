package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ApplicationScope02")
public class ApplicationScope02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApplicationScope02() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// Application Scope 생성 
		ServletContext application = getServletContext();
		
		try {
			// Application Scope에 저장된 값을 가져온다 
			int value = (int)application.getAttribute("value");
			value++;
			// 값을 저장한다 
			application.setAttribute("value", value);
			
			out.println("<h1>value : " + value + "</h1>");
		
		} catch(NullPointerException e) {
			// ApplicationScope02.java 가 먼저 실행되었을 경우 
			out.print("value의 값이 설정되지 않았습니다.");
		}
	}

}
