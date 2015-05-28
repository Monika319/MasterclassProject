/**
 * Created by monika03 on 28.05.15.
 */
public class Result {

    private int id;
    private int idUser;
    private int idDataset;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdDataset() {
        return idDataset;
    }

    public void setIdDataset(int idDataset) {
        this.idDataset = idDataset;
    }

    public Result() {
    }

    public Result(int id, int idUser, int idDataset) {
        this.id = id;
        this.idUser = idUser;
        this.idDataset = idDataset;

    }


}
