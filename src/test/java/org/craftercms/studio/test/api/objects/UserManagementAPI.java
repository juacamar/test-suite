package org.craftercms.studio.test.api.objects;

import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

public class UserManagementAPI extends BaseAPI {

	private String newusername = "jane.doe";
	private String newpassword = "SuperSecretPassword123#";
	private String first_name = "Jane";
	private String last_name = "Doe";
	private String email = "jane@example.com";
	private String token = null;

	public UserManagementAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}

	public void testCreateUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("password", newpassword);
		json.put("first_name", first_name);
		json.put("last_name", last_name);
		json.put("email", email);

		api.post("/studio/api/1/services/api/1/user/create.json").json(json).execute().status(201)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?user=" + newusername))
				.json("$.message", is("OK")).debug();
		
	}

	public void testCreateUserUserExist() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("password", newpassword);
		json.put("first_name", first_name);
		json.put("last_name", last_name);
		json.put("email", email);

		api.post("/studio/api/1/services/api/1/user/create.json").json(json).execute().status(409)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?user=" + newusername))
				.json("$.message", is("User already exists")).debug();

	}

	public void testCreateUserInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("usernamenonvalid", newusername);
		json.put("passwordnonvalid", newpassword);
		json.put("first_namenonvalid", first_name);
		json.put("last_namenonvalid", last_name);
		json.put("emailnonvalid", email);

		api.post("/studio/api/1/services/api/1/user/create.json").json(json).execute().status(400)
				.json("$.message", is("Invalid parameter(s): [username, password, firstname, lastname, email]"))
				.debug();

	}

	public void testDeleteUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		api.post("/studio/api/1/services/api/1/user/delete.json").json(json).execute().status(204);
	}

	public void testDeleteUserInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("usernamenonvalid", newusername);
		api.post("/studio/api/1/services/api/1/user/delete.json").json(json).execute().status(400).json("$.message",
				is("Invalid parameter: username"));

	}

	public void testDeleteUserUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername + "nonvalid");

		api.post("/studio/api/1/services/api/1/user/delete.json").json(json).execute().status(404).json("$.message",
				is("User not found"));
	}

	public void testGetUser() {
		api.get("/studio/api/1/services/api/1/user/get.json").urlParam("username", newusername).execute().status(200)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?username=" + newusername));
	}

	public void testGetUserInvalidParameters() {
		api.get("/studio/api/1/services/api/1/user/get.json").urlParam("usernamenonvalid", newusername).execute()
				.status(400)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?username=" + newusername))
				.json("$.message", is("Invalid parameter: username"));
	}

	public void testGetUserUserNotFound() {
		api.get("/studio/api/1/services/api/1/user/get.json").urlParam("username", newusername + "nonvalid").execute()
				.status(404);
	}

	public void testGetUsers() {
		api.get("/studio/api/1/services/api/1/user/get-all.json").urlParam("start", "0").urlParam("number", "25")
				.execute().status(200).header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get-all.json?start=0&number=25"));
	}

	public void testGetUsersPerSite(String siteId) {
		api.get("/studio/api/1/services/api/1/user/get-per-site.json").urlParam("site_id", siteId).execute().status(200)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get-per-site.json?site_id=" + siteId
								+ "&start=0&number=25"));

	}

	public void testUpdateUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("password", newpassword);
		json.put("first_name", first_name);
		json.put("last_name", last_name);
		json.put("email", email);
		json.put("externally_managed", "false");
		api.post("/studio/api/1/services/api/1/user/update.json").json(json).execute().status(200)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?username=" + newusername))
				.json("$.message", is("OK")).debug();
	}
	
	public void testUpdateUserToExternallyManaged() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("password", newpassword);
		json.put("first_name", first_name);
		json.put("last_name", last_name);
		json.put("email", email);
		json.put("externally_managed", "true");
		api.post("/studio/api/1/services/api/1/user/update.json").json(json).execute().status(200)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?username=" + newusername))
				.json("$.message", is("OK")).debug();
	}
	
	public void testUpdateUserUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername + "nonvalid");
		json.put("password", newpassword);
		json.put("first_name", first_name);
		json.put("last_name", last_name);
		json.put("email", email);
		json.put("externally_managed", "false");

		api.post("/studio/api/1/services/api/1/user/update.json").json(json).execute().status(404)
				.json("$.message", is("User not found")).debug();

	}

	public void testEnableUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);

		api.post("/studio/api/1/services/api/1/user/enable.json").json(json).execute().status(200)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?username=" + newusername))
				.json("$.message", is("OK")).debug();
	}

	public void testEnableUserInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("usernamenonvalid", newusername);

		api.post("/studio/api/1/services/api/1/user/enable.json").json(json).execute().status(400)
				.json("$.message", is("Invalid parameter: username")).debug();

	}

	public void testEnableUserUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername + "nonvalid");

		api.post("/studio/api/1/services/api/1/user/enable.json").json(json).execute().status(404)
				.json("$.message", is("User not found")).debug();

	}

	public void testDisableUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);

		api.post("/studio/api/1/services/api/1/user/disable.json").json(json).execute().status(200)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?username=" + newusername))
				.json("$.message", is("OK"));

	}

	public void testDisableUserInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("usernamenonvalid", newusername);

		api.post("/studio/api/1/services/api/1/user/disable.json").json(json).execute().status(400).json("$.message",
				is("Invalid parameter: username"));

	}

	public void testDisableUserUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername + "nonvalid");

		api.post("/studio/api/1/services/api/1/user/disable.json").json(json).execute().status(404).json("$.message",
				is("User not found"));

	}

	public void testGetUserStatus() {

		api.get("/studio/api/1/services/api/1/user/status.json").urlParam("username", newusername).execute().status(200)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?username=" + newusername));

	}

	public void testGetUserStatusInvalidParameter() {
		Map<String, Object> json = new HashMap<>();
		json.put("usernamenonvalid", newusername);

		api.get("/studio/api/1/services/api/1/user/status.json").json(json).execute().status(400).json("$.message",
				is("Invalid parameter: username"));

	}

	public void testGetUserStatusUserNotFound() {

		api.get("/studio/api/1/services/api/1/user/status.json").urlParam("username", newusername + "nonvalid")
				.execute().status(404);

	}

	public void testForgotPassword() {
		api.get("/studio/api/1/services/api/1/user/forgot-password.json").urlParam("username", newusername).execute()
				.status(200)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?username=" + newusername))
				.json("$.message", is("OK"));
	}

	public void testForgotPasswordUserNotFound() {
		api.get("/studio/api/1/services/api/1/user/forgot-password.json").urlParam("username", newusername+"nonvalid").execute()
				.status(404).json("$.message", is("User not found"));

	}

	public void testForgotPasswordInternalServerError() {
		api.get("/studio/api/1/services/api/1/user/forgot-password.json").urlParam("username", newusername).execute().status(500)
				.debug();
	}

	public void testSetPassword() {
		Map<String, Object> json = new HashMap<>();
		json.put("token", token);
		json.put("new", "new");
		api.post("/studio/api/1/services/api/1/user/set-password.json").json(json).execute().status(200)
				.json("$.message", is("OK")).debug();
	}

	public void testSetPasswordInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("tokennonvalid", token);
		json.put("new", "new");
		api.post("/studio/api/1/services/api/1/user/set-password.json").json(json).execute().status(400)
		.json("$.message",is("Invalid parameter(s): [token]"));
	}

	public void testSetPasswordUnauthorized() {
		Map<String, Object> json = new HashMap<>();
		json.put("token", token);
		json.put("new", "new");
		api.post("/studio/api/1/services/api/1/user/set-password.json").json(json).execute().status(401);
	}

	public void testValidateToken() {
		api.get("/studio/api/1/services/api/1/user/validate-token.json").urlParam("token", token).execute().status(200)
				.json("$.message", is("OK")).debug();
	}

	public void testValidateTokenInvalidParameters() {
		api.get("/studio/api/1/services/api/1/user/validate-token.json").urlParam("tokennonvalid", token).execute().status(400)
				.json("$.message", is("Invalid parameter: token")).debug();
	}

	public void testValidateTokenUnauthorized() {
		api.get("/studio/api/1/services/api/1/user/validate-token.json").urlParam("token", token).execute().status(401)
				.json("$.message", is("Unauthorized")).debug();
	}

	public void testValidateTokenExternallyManagedUser() {
		api.get("/studio/api/1/services/api/1/user/validate-token.json").urlParam("token", token).execute().status(403)
				.json("$.message", is("Externally managed user")).debug();
	}

	public void testValidateTokenInternalServerError() {
		api.get("/studio/api/1/services/api/1/user/validate-token.json").urlParam("token", token).execute().status(500)
				.json("$.message", is("Internal server error")).debug();
	}

	public void testChangePassword() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("current", newpassword);
		json.put("new", newusername + "#");

		api.post("/studio/api/1/services/api/1/user/change-password.json").json(json).execute().status(200)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?username=" + newusername))
				.json("$.message", is("OK")).debug();

	}

	public void testChangePasswordInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("currentnon-valid", newpassword);
		json.put("new", newpassword + "#");

		api.post("/studio/api/1/services/api/1/user/change-password.json").json(json).execute().status(400)
				.json("$.message", is("Invalid parameter(s): [current]")).debug();

	}

	public void testChangePasswordUnauthorized() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("current", newpassword);
		json.put("new", newpassword + "#");

		api.post("/studio/api/1/services/api/1/user/change-password.json").json(json).execute().status(401);
				//.json("$.message", is("Unauthorized")).debug();

	}

	public void testChangePasswordUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("current", newpassword);
		json.put("new", newpassword + "#");

		api.post("/studio/api/1/services/api/1/user/change-password.json").json(json).execute().status(404)
				.json("$.message", is("User not found")).debug();
	}

	public void testResetPassword() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("new", newpassword + "#");

		api.post("/studio/api/1/services/api/1/user/reset-password.json").json(json).execute().status(200)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?username=" + newusername))
				.json("$.message", is("OK")).debug();

	}

	public void testResetPasswordUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername + "nonvalid");
		json.put("new", newpassword + "##");

		api.post("/studio/api/1/services/api/1/user/reset-password.json").json(json).execute().status(404)
				.json("$.message", is("User not found")).debug();
	}

	public String getNewusername() {
		return newusername;
	}

	public void setNewusername(String newusername) {
		this.newusername = newusername;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
