package core;

import java.util.Date;
import java.util.List;

public abstract class Client {

    List<Date> datas;

    public Client() {
    }

    public List<Date> getDatas() {
        return datas;
    }

    public void setDatas(List<Date> datas) {
        this.datas = datas;
    }

}
