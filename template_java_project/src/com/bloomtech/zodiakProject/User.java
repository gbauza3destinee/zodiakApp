@DynamoDBTable (tableName = "Users")
public class User{
    private String userId;
    private String userName;
    private String birthDate;
    private String pronouns;


    @DynamoDBHashKey(attributeName = "shoeId")
    public String getUserId(){
        return userName();

    }

    public void setUserId(){
        this.userId = userId;

    }


    @DynamoDBAttribute(attributeName = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @DynamoDBAttribute(attributeName = "birthDate")
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    @DynamoDBAttribute(attributeName = "pronoun")
    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }




}




