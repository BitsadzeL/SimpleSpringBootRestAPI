package ge.ibsu.demo.dto;
public class AddCity {


        private String cityName;
        private String address;



        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public AddCity() {
        }

        public AddCity(String cityName, String address) {
            this.cityName = cityName;
            this.address = address;
        }




}
