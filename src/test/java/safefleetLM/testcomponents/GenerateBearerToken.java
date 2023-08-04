package safefleetLM.testcomponents;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;


public class GenerateBearerToken extends BaseTest {

	public GenerateBearerToken() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Map<String, String> configDetailsApi() throws OAuthSystemException, OAuthProblemException {

		Map<String, String> config = new TreeMap<String, String>();

		String tokenURL=null;
    String clientSecret=null;
		String clientID="licensemgr-api-client";
    String clientSecret_DEV_TEST="74083f0d-34e9-93a0-bdfc-3ca19374a4a1";
    String clientSecret_STG="7de12fd6-4195-7b04-3f94-4449f1225dea";
		if(prop.get("Environment").equals("TEST")) {
			tokenURL = "https://test-id.safefleetcloud.com/connect/token";
      clientSecret = clientSecret_DEV_TEST;
		}
		else if(prop.get("Environment").equals("DEV")) {
			tokenURL = "https://dev-id.safefleetcloud.com/connect/token";
      clientSecret = clientSecret_DEV_TEST;
		}
    else if(prop.get("Environment").equals("STG")) {
      tokenURL = "https://stg-id.safefleetcloud.com/connect/token";
      clientSecret = clientSecret_STG;
    }

		String encodedValue = getBasse64Encodeed(clientID, clientSecret);
		config.put("tokenURL", tokenURL);
		config.put("encodedValue", encodedValue);

		return config;
	}

	public static String licenseManagerApi() throws OAuthSystemException, OAuthProblemException {
		Map<String, String> config = configDetailsApi();

        OAuthClient client = new OAuthClient(new URLConnectionClient());
        OAuthClientRequest request = OAuthClientRequest.tokenLocation(config.get("tokenURL")).setGrantType(GrantType.CLIENT_CREDENTIALS).setScope("licenseManagerApi")
        																	.buildBodyMessage();
        request.addHeader("Authorization", "Basic "+config.get("encodedValue"));
        OAuthJSONAccessTokenResponse oAuthResponse = client.accessToken(request,OAuth.HttpMethod.POST,OAuthJSONAccessTokenResponse.class);
        String finaltoken = "Bearer "+oAuthResponse.getAccessToken();
        return finaltoken;

	}

	public static String getBasse64Encodeed(String id,String pwd) {
		return Base64.getEncoder().encodeToString((id+":"+pwd).getBytes(StandardCharsets.UTF_8));
	}

	public static String tenantManagerApi() throws OAuthSystemException, OAuthProblemException {
		Map<String, String> config = configDetailsApi();

        OAuthClient client = new OAuthClient(new URLConnectionClient());
        OAuthClientRequest request = OAuthClientRequest.tokenLocation(config.get("tokenURL")).setGrantType(GrantType.CLIENT_CREDENTIALS).setScope("tenant-manager-api-read-tenants tenant-manager-api-read-applications")
        																	.buildBodyMessage();
        request.addHeader("Authorization", "Basic "+config.get("encodedValue"));
        OAuthJSONAccessTokenResponse oAuthResponse = client.accessToken(request,OAuth.HttpMethod.POST,OAuthJSONAccessTokenResponse.class);
        String finaltoken = "Bearer "+oAuthResponse.getAccessToken();
        return finaltoken;

	}

	public static String singleSignOnApi() throws OAuthSystemException, OAuthProblemException {
		Map<String, String> config = configDetailsApi();

        OAuthClient client = new OAuthClient(new URLConnectionClient());
        OAuthClientRequest request = OAuthClientRequest.tokenLocation(config.get("tokenURL")).setGrantType(GrantType.CLIENT_CREDENTIALS).setScope("singlesignonapi-read-users")
        																	.buildBodyMessage();
        request.addHeader("Authorization", "Basic "+config.get("encodedValue"));
        OAuthJSONAccessTokenResponse oAuthResponse = client.accessToken(request,OAuth.HttpMethod.POST,OAuthJSONAccessTokenResponse.class);
        String finaltoken = "Bearer "+oAuthResponse.getAccessToken();
        return finaltoken;

	}

}
