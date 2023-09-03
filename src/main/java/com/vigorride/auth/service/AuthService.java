package com.vigorride.auth.service;

import com.vigorride.auth.data.AuthPayload;

public interface AuthService {

	public String login(final AuthPayload authPayload);

}
