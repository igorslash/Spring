package SpringR.RestIpi.rest.configuration.ExeptionHanding;

public class EmployeeIncorrectData {
    private String info;

    public EmployeeIncorrectData(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
