package config;

public class AuthConfig {

        private String authorization;
        private String key;

    public AuthConfig() {
        String authorization;
        String key;
    }

    public String getAuthorization(){
            return authorization;
        }

        public void setAuthorization(){
            this.authorization = authorization;
        }


    public String getKey(){
        return key;
    }

    public void setKey(){
        this.key = key;
    }

        public void AuthConfig(String authorization, String key){
            this.authorization = authorization;
            this.key = key;
        }

}