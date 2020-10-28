package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MavenSer
 */
public class MavenSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MavenSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con = null;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
//			System.out.println(con+"success");
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int empno = Integer.parseInt(request.getParameter("empno"));
		String empname = request.getParameter("empname");
		double empsal = Double.parseDouble(request.getParameter("empsal"));
		String hiredate = request.getParameter("hiredate");
		try{

			PreparedStatement pst = con.prepareStatement("insert into jdbc1 values(?,?,?,?)");
			pst.setInt(1, empno);
			pst.setString(2,empname);
			pst.setDouble(3,empsal);
			pst.setDate(4,Date.valueOf(hiredate));
			 int res = pst.executeUpdate();
			 if(res>0){
				 pw.println("Inserted successfully");
			 }
			 else {
				 pw.println(" try again ");
			 }
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
