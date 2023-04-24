
public Class UserDao(){
    private final DynamoDbMapper dynamoDbMapper;


    // TODO : Why is this not formatting correctly?
    @Inject
    public UserDao(DynamoDBMapper,dynamoDbMapper){
        AmazonDynamoDB dynamoDbClient = DynamoDbClientProvider.getDynamoDBClient();
        this.dynamoDbMapper = dynamoDbMapper;


        }


    public User getUser(String userId){

    }

    public void saveUser(User user){

    }






}









