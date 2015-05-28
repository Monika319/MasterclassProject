/**
 * Created by monika03 on 28.05.15.
 */
public class User {

    //private int id;
    private String nameSurname;
    private String collision;
    private String gaussParameters;
    private String polynomialParameters;
    private String total;
    private String background;
    private String signal;
    private String mean;
    private String sigma;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    public String getSigma() {
        return sigma;
    }

    public void setSigma(String sigma) {
        this.sigma = sigma;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getMean() {
        return mean;
    }


    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getCollisions() {
        return collision;
    }

    public void setCollision(String collision) {
        this.collision = collision;
    }

    public String getGaussParameters() {
        return gaussParameters;
    }

    public void setGaussParameters(String gaussParameters) {
        this.gaussParameters = gaussParameters;
    }

    public String getPolynomialParameters() {
        return polynomialParameters;
    }

    public void setPolynomialParameters(String polynomialParameters) {
        this.polynomialParameters = polynomialParameters;
    }

    public User() {
    }

    public User(String nameSurname, String collision, String total, String background, String signal, String mean, String sigma) {
        this.nameSurname = nameSurname;
        this.collision = collision;
        this.total = total;
        this.background = background;
        this.signal = signal;
        this.mean = mean;
        this.sigma = sigma;
    }

    @Override
    public String toString() {
        // return "[" + id + "] - " + name + " - " + surname;
        return nameSurname + " - " + collision + " - " + total + " - " + background + " - " + signal + " - " + mean + " - " + sigma;
    }

}
