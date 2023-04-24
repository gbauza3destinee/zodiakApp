
public Class UserDao(){
    private final DynamoDbMapper dynamoDbMapper;


    @Inject
    public UserDao(DynamoDBMapper,dynamoDbMapper){
        this.dynamoDbMapper=dynamoDbMapper;

        }


    public User getUser(String userId){

    }

    public void saveUser(User user){

    }






}









