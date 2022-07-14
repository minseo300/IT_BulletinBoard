//package toyProject.IT_BulletinBoard.config.auth;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Component
//public class GoogleOauth implements SocialOauth {
//    private final String GOOGLE_SNS_BASE_URL = "https://accounts.google.com/o/oauth2/v2/auth";
//    private final String GOOGLE_SNS_CLIENT_ID = "652442945302-06tpkhg3bphvvqc71vql8e3sj6ul48gi.apps.googleusercontent.com";
//    private final String GOOGLE_SNS_CALLBACK_URL = "http://localhost:8080/auth/google/callback";
//    private final String GOOGLE_SNS_CLIENT_SECRET = "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";
//    private final String GOOGLE_SNS_TOKEN_BASE_URL = "https://oauth2.googleapis.com/token";
////    @Value("${sns.google.url}")
////    private String GOOGLE_SNS_BASE_URL;
////    @Value("${sns.google.client.id}")
////    private String GOOGLE_SNS_CLIENT_ID;
////    @Value("${sns.google.callback.url}")
////    private String GOOGLE_SNS_CALLBACK_URL;
////    @Value("${sns.google.client.secret}")
////    private String GOOGLE_SNS_CLIENT_SECRET;
//
//    @Override
//    public String getOauthRedirectURL() {
//        Map<String, Object> params = new HashMap<>();
//        params.put("scope", "profile");
//        params.put("response_type", "code");
//        params.put("client_id", GOOGLE_SNS_CLIENT_ID);
//        params.put("redirect_uri", GOOGLE_SNS_CALLBACK_URL);
//
//        String parameterString = params.entrySet().stream()
//                .map(x -> x.getKey() + "=" + x.getValue())
//                .collect(Collectors.joining("&"));
//
//        return GOOGLE_SNS_BASE_URL + "?" + parameterString;
//    }
//
//    @Override
//    public String requestAccessToken(String code) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("code", code);
//        params.put("client_id", GOOGLE_SNS_CLIENT_ID);
//        params.put("client_secret", GOOGLE_SNS_CLIENT_SECRET);
//        params.put("redirect_uri", GOOGLE_SNS_CALLBACK_URL);
//        params.put("grant_type", "authorization_code");
//
//        ResponseEntity<String> responseEntity =
//                restTemplate.postForEntity(GOOGLE_SNS_TOKEN_BASE_URL, params, String.class);
//
//        if (responseEntity.getStatusCode() == HttpStatus.OK) {
//            return responseEntity.getBody();
//        }
//        return "구글 로그인 요청 처리 실패";
//    }
//}
