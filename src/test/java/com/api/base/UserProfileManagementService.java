package com.api.base;

import com.api.models.request.ProfileRequest;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService {

	private static final String BASE_PATH = "/api/users";

	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH + "/profile");

	}

	public Response updateProfile(String token, ProfileRequest payload) {
		setAuthToken(token);
		return putRequest(payload, BASE_PATH + "/profile");

	}
}
