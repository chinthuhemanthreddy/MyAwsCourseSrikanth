package com.organization.university.helper;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.organization.university.custom.exception.CustomException;
import com.organization.university.model.AccountDetailsByKeyResponse;
import com.organization.university.model.GetAccountDetailsByKeyRequest;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class RestHelper {

	public AccountDetailsByKeyResponse restForGetAccountDetailsbyKey(GetAccountDetailsByKeyRequest request,
			String service_url, String authorization){

		AccountDetailsByKeyResponse accResponse = null;
		try {
		String jsonStr = null;
		// Creating Object of ObjectMapper define in Jakson Api
		ObjectMapper Obj = new ObjectMapper();

		// get AccountInfoPayload object as a json string
		jsonStr = Obj.writeValueAsString(request);

		log.info("jsonStr hshhs :::: " + jsonStr);
		StringEntity entity = new StringEntity(jsonStr, "UTF8");
		log.info("getaccountdetailsbykey_service_dev ::: " + service_url);
		HttpPost post = new HttpPost(service_url);
		post.setHeader("Content-type", "application/json");
		post.setHeader("Authorization", authorization);
		post.setEntity(entity);

		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		log.info("before calling...service...");
		response = client.execute(post);
		System.out.println("response :::" + response);
		HttpEntity entityResponse = response.getEntity();
		String respStr = EntityUtils.toString(entityResponse);
		log.info("before formatting the response... " + respStr);

		accResponse = new ObjectMapper().readValue(respStr,
				AccountDetailsByKeyResponse.class);
		}catch (Exception ex) {
			log.error("exception in execute RestHelper.restForGetAccountDetailsbyKey ::: " + ex.getMessage());
			throw new CustomException(
					"Failing while getAccountDetailsByKey service calling.  Excpetion is : " + ex.getMessage() + ", HttCode: "  + HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return accResponse;
	}
}
