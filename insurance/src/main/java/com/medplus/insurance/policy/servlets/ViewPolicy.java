package com.medplus.insurance.policy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medplus.insurance.policy.beans.Policy;
import com.medplus.insurance.policy.service.PolicyService;
import com.medplus.insurance.policy.service.PolicyServiceImpl;

/**
 * Servlet implementation class ViewPolicy
 */
@WebServlet("/ViewPolicy")
public class ViewPolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PolicyService policyService = new PolicyServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String role = session.getAttribute("role").toString();
		String username = session.getAttribute("username").toString();
		
		List<Policy> policies = policyService.getPolicies(username,role);
		request.setAttribute("policies", policies);
		request.getRequestDispatcher("ViewPolicy.jsp").forward(request, response);
		
	}


}
