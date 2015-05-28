/**
 * Created by monika03 on 28.05.15.
 */
public class Dataset {
    private int id;
    private String collision;
    private String gaussParameters;
    private String polynomialParameters;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public Dataset() {
    }

    public Dataset(int id, String collision, String gaussParameters, String polynomialParameters) {
        this.id = id;
        this.collision = collision;
        this.gaussParameters = gaussParameters;
        this.polynomialParameters = polynomialParameters;

    }

    @Override
    public String toString() {
        return "[" + id + "] - " + collision + " - " + gaussParameters + " - " + polynomialParameters;
    }
}
