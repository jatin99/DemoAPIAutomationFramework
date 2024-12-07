package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test
	public void UpdateProfileTest() {

		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday1234", "uday1234"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());

		
		System.out.println("------------------------------------------------------------");
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "uday1234");;
		
		System.out.println("------------------------------------------------------------");
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("Disha")
				.lastName("Bhat")
				.email("disha1234@gmail.com")
				.mobileNumber("7777777771")
				.build();
		
		
		response=	userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());	
	}
}
