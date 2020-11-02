package prep2;

public class SocialCard extends Card{
    public String type;
    public boolean status;

    public SocialCard(int num, String type){
        super(num);
        this.type = type;
    }

    @Override
    public int getNum() {
        return super.getNum();
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
