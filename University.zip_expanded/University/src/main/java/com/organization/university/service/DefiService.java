package com.organization.university.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.organization.university.custom.exception.CustomException;
import com.organization.university.model.AccountInfoPayload;
import com.organization.university.model.AccountInformationReponse;
import com.organization.university.model.TokenResponse;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class DefiService {

	@Value("${grant_type_dev}")
	private String grant_type_dev;
	@Value("${client_id_dev}")
	private String client_id;
	@Value("${client_secret_dev}")
	private String client_secret;
	@Value("${token_service_dev}")
	private String token_service_dev;
	@Value("${getaccount_service_dev}")
	private String getaccount_service_dev;

	public String getTokenData() {
		TokenResponse tResponse = null;
		try {
			String payload = "{" + "\"client_id\":\"" + client_id + "\"," + "\"client_secret\":\"" + client_secret
					+ "\"," + "\"grant_type\":\"" + grant_type_dev + "\"" + "}";
			StringEntity entity = new StringEntity(payload, "UTF8");
			HttpPost post = new HttpPost(token_service_dev);
			post.setHeader("Content-type", "application/json");
			post.setEntity(entity);
			CloseableHttpClient client = HttpClients.createDefault();
			CloseableHttpResponse response = null;
			log.info("Before calling the token service ");
			response = client.execute(post);
			log.info("Successfully getting token response ");
			HttpEntity entityResponse = response.getEntity();
			String respStr = EntityUtils.toString(entityResponse);
			tResponse = new ObjectMapper().readValue(respStr, TokenResponse.class);

		} catch (Exception ex) {
			log.error(" CustomException  in getTokenData ::: " + ex.getMessage());
			throw new CustomException(
					"Failing while gettoken service calling.  Excpetion is : " + ex.getMessage() + ", HttCode: "  + HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return tResponse.toString();

	}

	public AccountInformationReponse getAccountDetails(AccountInfoPayload payload, String authorization) {

			log.info("entering into getAccountDetails method ");
			String jsonStr = null;
			//Creating Object of ObjectMapper define in Jakson Api
			ObjectMapper Obj = new ObjectMapper();
			AccountInformationReponse accResponse = null;
		try {
			//get AccountInfoPayload object as a json string
			jsonStr = Obj.writeValueAsString(payload);
			StringEntity entity = new StringEntity(jsonStr, "UTF8");
			HttpPost post = new HttpPost(getaccount_service_dev);
			post.setHeader("Content-type", "application/json");
			post.setHeader("Authorization", authorization);
			post.setEntity(entity);
			CloseableHttpClient client = HttpClients.createDefault();
			CloseableHttpResponse response = null;
			log.info("before calling...service getAccountDetails...");
			response = client.execute(post);
			log.info("after response of getAccountDetails:::");
			HttpEntity entityResponse = response.getEntity();
			String respStr = EntityUtils.toString(entityResponse);
			accResponse = new ObjectMapper().readValue(respStr, AccountInformationReponse.class);
		} catch (Exception ex) {
			log.error("exception in execute ::: " + ex.getMessage());
			throw new CustomException(
					"Failing while gettoken service calling.  Excpetion is : " + ex.getMessage() + ", HttCode: "  + HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
			log.info("returning the response of account details:::");

		return accResponse;

	}

	/*
	 * 
	 * 
	 * 
	 * org.springframework.http.HttpEntity org.springframework.http.ResponseEntity
	 * 
	 * 
	 * public String getTokenDataRest() throws IOException {
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setContentType(MediaType.APPLICATION_JSON); MultiValueMap<String,
	 * Object> form = new LinkedMultiValueMap<>(); form.add("client_id", client_id);
	 * form.add("client_secret", client_secret); form.add("grant_type",
	 * grant_type_dev); final ResponseEntity<TokenResponse> responseEntity =
	 * this.restTemplate.exchange(token_service_dev, HttpMethod.POST, new
	 * HttpEntity<>(form, headers), TokenResponse.class); TokenResponse response =
	 * responseEntity.getBody(); System.out.println("response ::: "+response);
	 * return response.getAccess_token();
	 * 
	 * }
	 * 
	 */

}