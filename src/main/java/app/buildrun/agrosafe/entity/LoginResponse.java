package app.buildrun.agrosafe.entity;

public class LoginResponse {
    

        private String uuid;
    
        // Construtor
        public LoginResponse(String uuid) {
            this.uuid = uuid;
        }
    
        // Getter e Setter
        public String getUuid() {
            return uuid;
        }
    
        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    
    
}
