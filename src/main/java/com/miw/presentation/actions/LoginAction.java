package com.miw.presentation.actions;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.miw.model.LoginInfo;
import com.miw.presentation.user.UserManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Results({ @Result(name = "success", location = "counter.action", type = "redirectAction"),
		@Result(name = "login-error", location = "/index.jsp"),
		@Result(name = "captcha-error", location = "/index.jsp"),

		// For validation
		@Result(name = "input", location = "/index.jsp")

})

@Validations(
	requiredStrings = {
				@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "loginInfo.login", key="loginErr"),
				@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "loginInfo.password", key="loginPasswordErr") })

public class LoginAction extends ActionSupport implements RequestAware, SessionAware {

	Logger logger = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = -3854762737466390371L;
	private LoginInfo login = null;
	private Map<String, Object> session = null;
	private Map<String, Object> request;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public LoginInfo getLoginInfo() {
		return login;
	}

	public void setLoginInfo(LoginInfo login) {
		this.login = login;
	}

	@Override
	public void validate() {
		logger.debug("Invoking validate!");
		super.validate();
	}

	@Override
	public String execute() throws Exception {

		if (!login.getCaptcha().equals("23344343")) {
			request.put("mymessage", getText("loginCaptchaErr"));

			return "captcha-error";
		}
		
		UserManagerServiceHelper helper = new UserManagerServiceHelper();
		
		if (helper.userExists(login.getLogin(), login.getPassword())) {
			logger.debug("Loggin in!: " + login);
			session.put("loginInfo", login);
			return SUCCESS;
		} 
		else {
			logger.debug("Credentials are wrong: " + login);
			request.put("mymessage", getText("loginWrongCredentials"));
			return "login-error";
		}
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}
