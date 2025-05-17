package app.buildrun.agrosafe.entity;

public class LoginResponse {
    

        private String uuid;
        private String username;

        // Construtor
        public LoginResponse(String uuid, String username) {
            this.uuid = uuid;
            this.username = username;
        }
    
        // Getter e Setter
        public String getUuid() {
            return uuid;
        }

        public String getUserName() {
            return username;
        }
    
        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    
    
}
