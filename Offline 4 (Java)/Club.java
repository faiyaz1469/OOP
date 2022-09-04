public class Club {
    private int id;
    private int number;
    private String name;

    public Club() {
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setPoint(int number){
        this.number = number;
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getPoint(){ return number;}
}
