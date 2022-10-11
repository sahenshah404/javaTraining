package com.medplus.insurance.policy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medplus.insurance.policy.beans.Accounts;
import com.medplus.insurance.policy.beans.Policy_Details;
import com.medplus.insurance.policy.beans.Policy_Questions;
import com.medplus.insurance.policy.service.AccountsService;
import com.medplus.insurance.policy.service.AccountsServiceImpl;
import com.medplus.insurance.policy.service.PolicyService;
import com.medplus.insurance.policy.service.PolicyServiceImpl;
import com.medplus.insurance.policy.service.Policy_DetailsService;
import com.medplus.insurance.policy.service.Policy_DetailsServiceImpl;
import com.medplus.insurance.policy.service.Policy_questionsService;
import com.medplus.insurance.policy.service.Policy_questionsServiceImpl;

/**
 * Servlet implementation class PolicyCreation
 */
@WebServlet("/PolicyCreation")
public class PolicyCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	AccountsService accountsService = new AccountsServiceImpl();
	Policy_questionsService policy_questionsService = new Policy_questionsServiceImpl();
	PolicyService policyService = new PolicyServiceImpl();
	Policy_DetailsService policy_DetailsService = new Policy_DetailsServiceImpl();
	
	List<Policy_Questions>  policy_Questions = new ArrayList<Policy_Questions>();
		List<Accounts> insureds = new ArrayList<Accounts>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(request.getParameter("user_name")==null) {
			HttpSession session = request.getSession();
			if(session.getAttribute("role").equals("admin")) {
				insureds = accountsService.getInsuredForAdmin();
			}
			else if(session.getAttribute("role").equals("agent")) {
				insureds = accountsService.getInsuredForAgent(session.getAttribute("username").toString());
			}
				request.setAttribute("insureds", insureds);
//				request.getRequestDispatcher("PolicyCreation.jsp").forward(request, response);
//		}
		if(request.getParameter("user_name")!=null) {
			String username = request.getParameter("user_name");
			String busSegId = accountsService.getBusSegByUsername(username);
			policy_Questions = policy_questionsService.getPolicyQues(busSegId);
			request.setAttribute("questions", policy_Questions);
//			request.getRequestDispatcher("PolicyCreation.jsp").include(request, response);
		}
		
				request.getRequestDispatcher("PolicyCreation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("user_name");
		Accounts account = accountsService.findAccountByUsername(username);
		policy_Questions = policy_questionsService.getPolicyQues(account.getBusiness_segment());
		int premium = 0;
		for (Policy_Questions question : policy_Questions) {
			premium = premium + Integer.parseInt( request.getParameter(question.getPol_ques_id()));
		}
		premium = premium * 10;
		int polNum = policyService.createPolicy(account.getAccount_number(),premium);
		if(polNum == 0) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<p class='alert'> Policy not created </p>");
			request.getRequestDispatcher("PolicyCreation.jsp").include(request, response);
		}
		else {
			int result =0;
			for (Policy_Questions question : policy_Questions) {
				Policy_Details policy_Detail = new Policy_Details();
				policy_Detail.setPolicy_number(polNum);
				policy_Detail.setQuestion_id(question.getPol_ques_id());
				int weightage = Integer.parseInt( request.getParameter(question.getPol_ques_id()));
				String answer = question.getAnsStringByWeightage(weightage);
				policy_Detail.setAnswer(answer);
				 if(policy_DetailsService.createPolicyDetail(policy_Detail)>0)
					 ++result;
			}
			if(result ==  policy_Questions.size()) {
				response.sendRedirect("Homepage");
			}
			else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<p class='alert'> Policy details not created </p>"+ result);
				request.getRequestDispatcher("PolicyCreation.jsp").include(request, response);
			}
			
		}
			
		
	}

}
