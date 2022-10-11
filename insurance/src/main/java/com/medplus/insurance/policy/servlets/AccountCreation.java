package com.medplus.insurance.policy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medplus.insurance.policy.beans.Business_Segment;
import com.medplus.insurance.policy.beans.User_Role;
import com.medplus.insurance.policy.service.AccountsService;
import com.medplus.insurance.policy.service.AccountsServiceImpl;
import com.medplus.insurance.policy.service.Business_segmentService;
import com.medplus.insurance.policy.service.Business_segmentServiceImpl;
import com.medplus.insurance.policy.service.User_RoleService;
import com.medplus.insurance.policy.service.User_RoleServiceImpl;

/**
 * Servlet implementation class AccountCreation
 */
@WebServlet("/AccountCreation")
public class AccountCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	Business_segmentService business_segmentService = new Business_segmentServiceImpl();
	User_RoleService user_RoleService = new User_RoleServiceImpl();
	AccountsService accountsService = new AccountsServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("role") == null) {
			response.sendRedirect("Login");
		} else {
			List<Business_Segment> business_Segments = business_segmentService.getAllBusSeg();
			List<User_Role> agents = user_RoleService.getAllAgents();
			List<User_Role> insureds = user_RoleService.getAllInsureds();
			request.setAttribute("business_segments", business_Segments);
			request.setAttribute("agents", agents);
			request.setAttribute("insureds", insureds);
			request.getRequestDispatcher("AccountCreation.jsp").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String insured_name = request.getParameter("insured_name");
		String insured_street = request.getParameter("insured_street");
		String insured_city = request.getParameter("insured_city");
		String insured_state = request.getParameter("insured_state");
		int insured_zip = Integer.parseInt(request.getParameter("insured_zip"));
		String business_segment = request.getParameter("business_segment");
		String insuredId = request.getParameter("insured");
		String agentId = request.getParameter("agent");

		if (insured_zip < 10000 || insured_zip > 99999) {
			out.print("<p class = 'warning'>Please Enter a valid 5 digit zip code</p>");
			doGet(request, response);
		} else if (user_RoleService.checkIfAccountCreated(insuredId).equals("created")) {
			out.print("<p class = 'warning'>An Account for this user is already created</p>");
			doGet(request, response);
		} else {
			String output = accountsService.createAccount(insured_name, insured_street, insured_city, insured_state,
					insured_zip, business_segment, insuredId, agentId);
			if (output.equals("Account Created")) {
				out.print("<p class = 'success'> " + output + " </p>");
				HttpSession session = request.getSession();
				if (session.getAttribute("role").equals("insured")) {
					session.setAttribute("account", "created");
					response.sendRedirect("Homepage");
				}
			}

			else
				out.print("<p class = 'alert'>" + output + "</p>");
				doGet(request, response);
		}

	}

}
