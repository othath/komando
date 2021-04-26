package mainApp.client;

public class userCls {

    private int id;
    private String first;
    private String last;
    private String email;

    public userCls(){}
    public userCls(int id, String first, String last, String email){
        this.id = id;
        this.first = first;
        this.last = last;
        this.email = email;
    }
    public void setClient(userCls u){
        this.id = u.getId();
        this.first = u.getFirst();
        this.last = u.getLast();
        this.email = u.getEmail();
    }
    int getId(){return id;};
    String getFirst(){return first;};
    String getLast(){return last;};
    String getEmail(){return email;};

}
