package com.cos.project.action.user;

import com.cos.project.action.Action;

public class UserFactory {

	public static Action route(String cmd) {
		// TODO Auto-generated method stub
		System.out.println("2.UserFactory)");
		if (cmd.equals("login")) {
			return new UserLoginAction();
		}else if (cmd.equals("logout")) {
			return new UserLogoutAction();
		}else if (cmd.equals("update")) {
			return new UserUpdateAction();
		}else if (cmd.equals("register")) {
			return new UserResgisterAction();
		}else if (cmd.equals("registerProc")) {
			return new UserResgisterProcAction();
		}else if (cmd.equals("loginProc")) {
			return new UserLoginProcAction();
		}else if (cmd.equals("profile")) {
			return new UserProfileAction();
		}else if(cmd.equals("profileProc")) {
			return new UserProfileProcAction();  
		}else if(cmd.equals("usernameCheck")) {
			return new UsernameCheckAction();  
		}else if (cmd.equals("contactList")) {
			return new UserContactListAction();
			
		}
		
		return null;
	}

}
