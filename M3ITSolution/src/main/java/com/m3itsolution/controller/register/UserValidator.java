package com.m3itsolution.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.m3itsolution.model.User;
import com.m3itsolution.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		boolean result = false;
		result = User.class.equals(aClass);
		System.out.println(result);
		return result;
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 6 || user.getUsername().length() > 15) {
			errors.rejectValue("username", "Size.regForm.username");
		}
		
		if (userService.getUserByName(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.regForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "NotEmpty");
		if (user.getPwd().length() < 8 || user.getPwd().length() > 15) {
			errors.rejectValue("pwd", "Size.regForm.pwd");
		}

		if (!user.getConfirmPwd().equals(user.getPwd())) {
			errors.rejectValue("confirmPwd", "Diff.regForm.confirmPwd");
		}
	}
}